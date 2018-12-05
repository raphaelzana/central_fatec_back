package br.com.raphaelzana.central_fatec.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.raphaelzana.central_fatec.domain.Disciplina_Sala;
import br.com.raphaelzana.central_fatec.dtos.DisciplinaSalaDTO;
import br.com.raphaelzana.central_fatec.services.Disciplina_SalaService;

@RestController
@RequestMapping(value="/disciplina_sala")
public class Disciplina_SalaResource {
	
	@Autowired
	private Disciplina_SalaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<DisciplinaSalaDTO> find(
			@RequestParam(value="curso", defaultValue="0") Integer curso,
			@RequestParam(value="disciplina", defaultValue="0") Integer disciplina) {
		Disciplina_Sala ds = service.find(curso,disciplina);
		DisciplinaSalaDTO retorno = new DisciplinaSalaDTO(ds.getDiaSemana(), ds.getSala().getBloco(), ds.getSala().getNome(), ds.getAula());
		return ResponseEntity.ok().body(retorno);
	}
	
	@RequestMapping(value="/busca",method=RequestMethod.GET)
	public ResponseEntity<List<Disciplina_Sala>> busca(
			@RequestParam(value="curso", defaultValue="0") Integer curso,
			@RequestParam(value="semestre", defaultValue="0") Integer semestre) {
		List<Disciplina_Sala> ds = service.busca(curso,semestre);
		return ResponseEntity.ok().body(ds);
	}

}
