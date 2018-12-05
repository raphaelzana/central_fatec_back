package br.com.raphaelzana.central_fatec.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.raphaelzana.central_fatec.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
