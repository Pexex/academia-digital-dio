package me.dio.academia.digital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	@Query("FROM Aluno a WHERE a.nome = :nome or a.cpf = :cpf or a.bairro = :bairro or a.dataDeNascimento = :dataDeNascimento")
	List<Aluno> findByParam (@Param("nome") String nome, 
							 @Param("cpf") String cpf,
							 @Param("bairro") String bairro,
							 @Param("dataDeNascimento") LocalDate dataDeNascimento);
}
