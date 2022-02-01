package eCommerceSignIn.business.abstracts;

import java.util.ArrayList;

import eCommerceSignIn.business.concretes.BusinessException;
import eCommerceSignIn.entities.concretes.User;

public interface UserService {

	void add(User user) throws BusinessException;
	void update(User user) throws BusinessException;
	void delete(User user);
	ArrayList <User> getAll();
	
}
