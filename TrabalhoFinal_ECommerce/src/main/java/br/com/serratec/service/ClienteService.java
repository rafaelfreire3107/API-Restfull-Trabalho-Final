package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.serratec.DTO.ClienteRequestDTO;
import br.com.serratec.DTO.ClienteResponseDTO;
import br.com.serratec.config.MailConfig;
import br.com.serratec.entity.Cliente;
import br.com.serratec.entity.Endereco;
import br.com.serratec.exception.EmailException;
import br.com.serratec.repository.ClienteRepository;
import br.com.serratec.repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private MailConfig mailConfig;
	
	@Autowired
	private SmsService smsService;

	public List<ClienteResponseDTO> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteResponseDTO> dtos = new ArrayList<>();
		for (Cliente cliente : clientes) {
			dtos.add(new ClienteResponseDTO(cliente));
		}
		return dtos;
	}

	@Transactional
	public ClienteResponseDTO inserir(ClienteRequestDTO dto) {
		Optional<Cliente> c = clienteRepository.findByEmail(dto.getEmail());
		if (c.isPresent()) {
			throw new EmailException("Email existente!");
		}

		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setCpf(dto.getCpf());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());

		Endereco endereco = enderecoRepository.findByCep(dto.getCep());
		if (endereco != null) {
			cliente.setEndereco(endereco);
		} else {
			RestTemplate rs = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + dto.getCep() + "/json/";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(uri, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				endereco = new Endereco();
				endereco.setCep(enderecoViaCep.get().getCep());
				endereco.setBairro(enderecoViaCep.get().getBairro());
				endereco.setLocalidade(enderecoViaCep.get().getLocalidade());
				endereco.setLogradouro(enderecoViaCep.get().getLogradouro());
				endereco.setUf(enderecoViaCep.get().getUf());
				enderecoRepository.save(endereco);
				cliente.setEndereco(endereco);
			} else {
				throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
			}

		}
		cliente = clienteRepository.save(cliente);
		mailConfig.sendEmail(cliente.getEmail(), "Confirmação de cadastro", cliente.toString());
		smsService.sendSms(cliente.getTelefone(),"Cadastro realizado com sucesso!"
				+"\nNome: " + cliente.getNome()
				+ "\nE-mail: " + cliente.getEmail()
				+ "\nCEP: " + endereco.getCep());
		
		return new ClienteResponseDTO(cliente);
	}

	@Transactional
	public ClienteResponseDTO alterar(Long id, ClienteRequestDTO dto) {
	    Cliente cliente = clienteRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

	    Optional<Cliente> existingCliente = clienteRepository.findByEmail(dto.getEmail());
	    if (existingCliente.isPresent() && !existingCliente.get().getId().equals(cliente.getId())) {
	        throw new EmailException("Email existente!");
	    }
	    cliente.setNome(dto.getNome());
	    cliente.setCpf(dto.getCpf());
	    cliente.setEmail(dto.getEmail());
	    cliente.setTelefone(dto.getTelefone());

	    Endereco endereco = enderecoAtualizado(dto.getCep());
	    cliente.setEndereco(endereco);

	    cliente = clienteRepository.save(cliente);
	    mailConfig.sendEmail(cliente.getEmail(), "Atualização de cadastro", cliente.toString());
	    smsService.sendSms(cliente.getTelefone(),"Cadastro atualizado com sucesso!"
				+"\nNome: " + cliente.getNome()
				+ "\nE-mail: " + cliente.getEmail()
				+ "\nCEP: " + endereco.getCep());
	    return new ClienteResponseDTO(cliente);
	}

	private Endereco enderecoAtualizado(String cep) {
	    Endereco endereco = enderecoRepository.findByCep(cep);
	    if (endereco != null) {
	        return endereco;
	    }

	    RestTemplate rs = new RestTemplate();
	    String uri = "https://viacep.com.br/ws/" + cep + "/json/";
	    Endereco enderecoViaCep = rs.getForObject(uri, Endereco.class);
	    
	    if (enderecoViaCep == null || enderecoViaCep.getCep() == null) {
	        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
	    }
	    
	    String cepSemTraco = enderecoViaCep.getCep().replaceAll("-", "");
	    enderecoViaCep.setCep(cepSemTraco);

	    enderecoRepository.save(enderecoViaCep); 

	    return enderecoViaCep; 
	}


}
