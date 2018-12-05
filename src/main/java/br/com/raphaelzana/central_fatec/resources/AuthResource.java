package br.com.raphaelzana.central_fatec.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.raphaelzana.central_fatec.security.JWTUtil;
import br.com.raphaelzana.central_fatec.security.UserSS;
import br.com.raphaelzana.central_fatec.services.UserService;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value="/refresh_token", method=RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
	UserSS user = UserService.authenticated();
	String token = jwtUtil.generateToken(user.getUsername());
	response.addHeader("Authorization", "Bearer " + token);
	response.addHeader("access-control-expose-headers", "Authorization");
	return ResponseEntity.noContent().build();
	}

}
