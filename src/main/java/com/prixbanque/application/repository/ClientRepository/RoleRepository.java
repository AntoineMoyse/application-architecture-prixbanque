package com.prixbanque.application.repository.ClientRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prixbanque.application.model.Role;

/**
 * @author antoine
 *
 */
public interface RoleRepository extends MongoRepository<Role, String>{

	/**
	 * @param role
	 * @return le role associé au string
	 */
	Role findByRole(String role);
}
