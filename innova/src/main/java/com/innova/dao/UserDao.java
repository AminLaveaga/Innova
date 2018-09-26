package com.innova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innova.entidad.Evento;
import com.innova.entidad.User;



@Repository
public interface UserDao extends JpaRepository<User,Long> {
	User save(User user);

	User findByEmail(String email);
}
