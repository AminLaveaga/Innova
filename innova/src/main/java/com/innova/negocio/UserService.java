package com.innova.negocio;

import com.innova.entidad.User;

public interface UserService {
	User save(User user);

	User findByEmail(String email);

}
