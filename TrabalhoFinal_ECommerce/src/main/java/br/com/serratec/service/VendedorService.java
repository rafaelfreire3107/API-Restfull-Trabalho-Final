package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Vendedor;
import br.com.serratec.repository.VendedorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VendedorService {

	@Autowired
    private VendedorRepository vendedorRepository;
	
	 public List<Vendedor> listar() {
	        return vendedorRepository.findAll();
	    }

	 public Vendedor listarPorId(Long id) {
	        return vendedorRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado"));
	    }

    public Vendedor inserirVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
    
    public Vendedor alterar(Long id, Vendedor vendedor) {
        Vendedor vendedores = vendedorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado"));
        
        vendedores.setNomeLoja(vendedor.getNomeLoja());
        vendedores.setEmail(vendedor.getEmail());
        vendedores.setCidade(vendedor.getCidade());
        vendedores.setAvaliacao(vendedor.getAvaliacao());

        vendedorRepository.save(vendedores);

        return vendedores;
    }

	
	public void deletar(Long id) {
	        Vendedor vendedor = vendedorRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado"));
	        vendedorRepository.delete(vendedor);
	    }
}
