package br.com.raphaelzana.central_fatec.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raphaelzana.central_fatec.services.DisciplinaService;

@RestController
@RequestMapping(value="/disciplinas")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService service;
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> findList(
			@RequestParam(value="curso", defaultValue="0") Integer id) {
		List<Disciplina> list = service.findList(id);
		return ResponseEntity.ok().body(list);
	}*/

}
