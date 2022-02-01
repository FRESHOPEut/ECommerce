package eCommerceSignIn.dataAccess.concretes;

import java.util.ArrayList;

import eCommerceSignIn.dataAccess.abstracts.UserDao;
import eCommerceSignIn.entities.concretes.User;

public class UserHibernateDao implements UserDao {

	ArrayList<User> users = new ArrayList<User>();

	@Override
	public void add(User entity) {
		System.out.println("Sign in Successful");
		users.add(entity);
	}

	@Override
	public void update(User entity) {
		for (User user : users) {
			users.set(users.indexOf(user), entity);
		}
		System.out.println(entity.getFirstName() + " updated Successfully");
	}

	@Override
	public void delete(User entity) {
		System.out.println(entity.getFirstName() + " Deleted");
		users.remove(entity);
	}

	@Override
	public ArrayList<User> getAll() {
		return this.users;
	}

}
