package me.dio.academia.digital.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());	
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		return avaliacaoFisicaRepository.getById(id);
	}
	
	@Override
	public List<AvaliacaoFisica> getAll(Long id, String nome, String cpf, String dataDaAvaliacao) {
		if (id != null && nome == null && cpf == null && dataDaAvaliacao == null) {
			return  avaliacaoFisicaRepository.findByParam(id, null, null, null);
		}
		if (id == null && nome != null && cpf == null && dataDaAvaliacao == null) {
			return  avaliacaoFisicaRepository.findByParam(null, nome, null, null);
		}
		if (id == null && nome == null && cpf != null && dataDaAvaliacao == null) {
			return  avaliacaoFisicaRepository.findByParam(null, null, cpf, null);
		}
		if (id == null && nome == null && cpf == null && dataDaAvaliacao != null) {
			LocalDateTime ldt = LocalDateTime.parse(dataDaAvaliacao, JavaTimeUtils.LOCAL_DATE_TIME_FORMATTER);
			return  avaliacaoFisicaRepository.findByParam(null, null, null, ldt);
		}		
		return avaliacaoFisicaRepository.findAll();		
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
		if (formUpdate.getAltura() != null) {
			avaliacaoFisica.setAltura(formUpdate.getAltura());
		}
		if (formUpdate.getPeso() != null) {
			avaliacaoFisica.setPeso(formUpdate.getPeso());
		}
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}

}
