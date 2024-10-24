package br.com.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
		
	Optional<Cliente> findByEmail(String email);
}
