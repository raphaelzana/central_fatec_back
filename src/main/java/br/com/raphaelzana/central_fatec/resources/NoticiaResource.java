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

import br.com.raphaelzana.central_fatec.domain.Noticia;
import br.com.raphaelzana.central_fatec.services.NoticiaService;

@RestController
@RequestMapping(value="/noticias")
public class NoticiaResource {
	
	@Autowired
	private NoticiaService service;
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Noticia obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Noticia>> findAll() {
		List<Noticia> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@PreAuthorize("hasAnyRole('ALUNO','ADMIN','PROFESSOR')")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Noticia>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="data")String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC")String direction) {
		Page<Noticia> list = service.findPage(page,linesPerPage,orderBy,direction);
		return ResponseEntity.ok().body(list);
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Noticia obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//	@PreAuthorize("hasAnyRole('ALUNO','ADMIN')")
//	@RequestMapping(method=RequestMethod.POST)
//	public ResponseEntity<Void> insert(@Valid @RequestBody NoticiaFormularioDTO dto){
//		Noticia obj = new Noticia(dto);
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Noticia obj,@PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
