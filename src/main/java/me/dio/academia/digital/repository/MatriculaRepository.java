package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	
	/*@Query(value = "SELECT from tb_matriculas m " +
	  	"INNER JOIN id_alunos a ON m.aluno_id = a.id "+
		"WHERE a.bairro = :bairro", nativeQuery = true)*/
	
	@Query("FROM Matricula m WHERE m.aluno.nome = :nome or m.aluno.bairro = :bairro or m.aluno.cpf = :cpf ")
	List<Matricula> findByParam (@Param("nome") String nome,
								 @Param("bairro") String bairro,
								 @Param("cpf") String cpf);
	
	//List<Matricula> findByAlunoBairro(String bairro); 
}
