package br.com.raphaelzana.central_fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Usuario;
import br.com.raphaelzana.central_fatec.dto.UsuarioNewDTO;
import br.com.raphaelzana.central_fatec.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario find(String email) {
		Usuario obj = repo.findByEmail(email);
		return obj;
	}
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario cli = new Usuario(null, objDto.getEmail(), pe.encode(objDto.getSenha()));
		return cli;
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}

}