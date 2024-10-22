package br.com.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.serratec.DTO.EnderecoResponseDTO;
import br.com.serratec.entity.Endereco;
import br.com.serratec.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public EnderecoResponseDTO buscar(String cep) {
		var endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));
		if(endereco.isPresent()) {
			return new EnderecoResponseDTO(endereco.get());
		}else {
			 RestTemplate rs = new RestTemplate();
		        String uri = "https://viacep.com.br/ws/" + cep + "/json/";
		        Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(uri, Endereco.class));
		        if(enderecoViaCep.get().getCep().isEmpty()) {
		        	String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
		        	enderecoViaCep.get().setCep(cepSemTraco);
		        	return inserir(enderecoViaCep.get());
		        }else {
		        	throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		        }
		}	
	}
	
	private EnderecoResponseDTO inserir(Endereco endereco) {
		endereco = enderecoRepository.save(endereco);
		return new EnderecoResponseDTO(endereco);
	}
	
}
