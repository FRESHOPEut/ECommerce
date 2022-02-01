package eCommerceSignIn.core.dataAccess;

import java.util.ArrayList;

import eCommerceSignIn.core.entities.Entity;

public interface CrudRepository <T extends Entity>{
	void add(T entity);
	void update(T entity);
	void delete(T entity);
	ArrayList <T> getAll();
}
