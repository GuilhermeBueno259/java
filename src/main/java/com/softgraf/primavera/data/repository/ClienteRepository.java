package com.softgraf.primavera.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softgraf.primavera.data.entity.Cliente;
import com.softgraf.primavera.data.projection.ClienteProjection;

// Recurso do módulo Spring Data
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	// metodos personalzados com base no find
	// cria um méetodo para buscar cliente por nome
	List<Cliente> findByNome(String nome);

	// acha quaalquer nome que contenha o nome
	List<Cliente> findByNomeContaining(String nome);

	List<Cliente> findByEmailContaining(String email);

	// busca com ordenação
	List<Cliente> findByNomeOrderByNomeAsc(String nome);
	List<Cliente> findByNomeContaining(String nome, Sort sort);
	
	// busca com classe aninhada (@Embedded)
	List<Cliente> findByEndereco_Cidade(String cidade);

	List<Cliente> findByEndereco_Estado(String estado);
	
	List<Cliente> findByEndereco_BairroContaining(String bairro);

	List<Cliente> findByEndereco_CepContaining(String cep);
	
	// busca com paginação (busca paginada)
	Page<Cliente> findAll(Pageable pageable);
	
	// Queries
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Pageable pageable);
	
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Sort sort);
	
	// Consultas SQL nativa
	@Query(value = "SELECT c.id, c.nome, c.email FROM Cliente c", nativeQuery = true)
	List<ClienteProjection> findClienteProjecao();
	
}
