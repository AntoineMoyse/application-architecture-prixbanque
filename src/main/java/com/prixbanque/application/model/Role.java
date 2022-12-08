package com.prixbanque.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author antoine
 *
 */
@Document("role")
public class Role {

	@Id
    private String id;

    private String role;

    /**
     * @return l'id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return le role
     */
    public String getRole() {
        return this.role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
