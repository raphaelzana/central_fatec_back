package br.com.raphaelzana.central_fatec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
	
}
