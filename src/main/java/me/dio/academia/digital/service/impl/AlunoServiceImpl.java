package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService{
	
	@Autowired
	private AlunoRepository repository;
	

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno(null, form.getNome(), form.getCpf(), form.getBairro(), form.getDataDeNascimento(), null);
		return repository.save(aluno);
	}

	@Override
	public Optional<Aluno> get(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Aluno> getAll(String nome, String cpf, String bairro, String dataDeNascimento) {
		if (nome != null && cpf == null && bairro == null && dataDeNascimento == null) {
			return repository.findByParam(nome, null, null, null);
		}
		if (nome == null && cpf != null && bairro == null && dataDeNascimento == null) {
			return repository.findByParam(null, cpf, null, null);
		}
		if (nome == null && cpf == null && bairro != null && dataDeNascimento == null) {
			return repository.findByParam(null, null, bairro, null);
		}
		if (nome == null && cpf == null && bairro == null && dataDeNascimento != null) {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByParam(null, null, null, localDate);
		}
		return repository.findAll();		
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Aluno aluno = repository.findById(id).get();
		if (formUpdate.getNome() != null) {
			aluno.setNome(formUpdate.getNome()); 			
		}
		if (formUpdate.getBairro() != null) {
			aluno.setBairro(formUpdate.getBairro());			
		}
		if (formUpdate.getDataDeNascimento() != null) {
			aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());			
		}
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
		Aluno aluno = repository.findById(id).get();
		return aluno.getAvaliacoes();
	}



	

}
