package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
	
	@Autowired
	private AvaliacaoFisicaServiceImpl service;
	
	@PostMapping
	public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
	
	@GetMapping("/avaliacoes/get")
	public List<AvaliacaoFisica> getAll(@RequestParam(value = "id", required = false) Long id,
										@RequestParam(value = "nome", required = false) String nome,
										@RequestParam(value = "cpf", required = false) String cpf,
										@RequestParam(value = "dataDaAvaliacao", required = false) String dataDaAvaliacao){
		return service.getAll(id, nome, cpf, dataDaAvaliacao);
	}
	
	@GetMapping
	public AvaliacaoFisica get(Long id) {
		return service.get(id);
	}
	
	@PutMapping
	public AvaliacaoFisica updateAvaliacaoFisica (@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm form) {
		return service.update(id, form);
	}
	
	@DeleteMapping
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
