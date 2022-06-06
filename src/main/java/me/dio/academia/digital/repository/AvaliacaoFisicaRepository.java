package me.dio.academia.digital.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import me.dio.academia.digital.entity.AvaliacaoFisica;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long>{
	
	@Query("FROM AvaliacaoFisica af WHERE af.aluno.id = :id or af.aluno.nome = :nome or af.aluno.cpf = :cpf or af.dataDaAvaliacao = :dataDaAvaliacao")
	List<AvaliacaoFisica> findByParam (@Param("id") Long id,
									   @Param("nome") String nome,
									   @Param("cpf") String cpf,
							           @Param("dataDaAvaliacao") LocalDateTime dataDaAvaliacao);

}
