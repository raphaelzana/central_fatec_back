package br.com.raphaelzana.central_fatec.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.raphaelzana.central_fatec.domain.Objeto;
import br.com.raphaelzana.central_fatec.domain.enums.TipoObjeto;
import br.com.raphaelzana.central_fatec.services.ObjetoService;

@RestController
@RequestMapping(value="/objetos")
public class ObjetoResource {
	
	@Autowired
	private ObjetoService service;
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Objeto>> findAll() {
		List<Objeto> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Objeto>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="data")String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC")String direction) {
		Page<Objeto> list = service.findPage(page,linesPerPage,orderBy,direction);
		return ResponseEntity.ok().body(list);
		
	}
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(value="/tipos", method=RequestMethod.GET)
	public ResponseEntity<List<TipoObjeto>> findAllTipo() {
		List<TipoObjeto> list = TipoObjeto.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Objeto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Objeto obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@PreAuthorize("hasAnyRole('ALUNO','ADMIN')")
//	@RequestMapping(method=RequestMethod.POST)
//	public ResponseEntity<Void> insert(@Valid @RequestBody ObjetoFormularioDTO dto){
//		Objeto obj = new Objeto(dto);
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Objeto obj,@PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
