package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Categoria;
import br.com.serratec.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	 public List<Categoria> listar() {
	        return categoriaRepository.findAll();
	    }

	public Categoria inserir(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	 public Categoria atualizar(Long id, Categoria categoria) {
	        if (categoriaRepository.existsById(id)) {
	            categoria.setId(id);
	            return categoriaRepository.save(categoria);
	        } else {
	            return null;
	        }
	    }

}
