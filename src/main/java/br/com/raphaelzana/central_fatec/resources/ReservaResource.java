package br.com.raphaelzana.central_fatec.resources;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.raphaelzana.central_fatec.domain.Reserva;
import br.com.raphaelzana.central_fatec.domain.enums.PeriodoCurso;
import br.com.raphaelzana.central_fatec.services.ReservaService;

@RestController
@RequestMapping(value="/reservas")
public class ReservaResource {
	
	@Autowired
	private ReservaService service;
	
	
	/*@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Reserva> find(@PathVariable Integer id) {
		Reserva obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Reserva>> findAll() {
		List<Reserva> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}*/
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Reserva obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Reserva>> findList(
			@RequestParam(value="data", defaultValue="10-11-2000") String data, 
			@RequestParam(value="periodo", defaultValue="1") String periodo, 
			@RequestParam(value="aula", defaultValue="1")String aula) throws NumberFormatException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		List<Reserva> list = service.findList(sdf.parse(data), PeriodoCurso.toEnum(Integer.parseInt(periodo)), Integer.parseInt(aula));
		return ResponseEntity.ok().body(list);
		
	}
	
	/*@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Reserva obj,@PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}*/
}
