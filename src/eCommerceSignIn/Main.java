package eCommerceSignIn;

import eCommerceSignIn.business.concretes.BusinessException;
import eCommerceSignIn.business.concretes.UserManager;
import eCommerceSignIn.dataAccess.concretes.UserHibernateDao;
import eCommerceSignIn.entities.concretes.User;

public class Main {

	public static void main(String[] args) throws BusinessException {

		User user1 = new User(1, "Zümra", "Girgin", "zmrgrgn@gmail.com", "123456");
		User user2 = new User(2, "Umut", "Taze", "umtz@hotmail.com", "1234566");
		User user3 = new User(3, "A", "B", "ozgurcglk@gmail.com", "123456");
		User user4 = new User(4, "Zümra", "Girgin", "zmrgrgn@gmail.com", "654321");

		UserManager userManager = new UserManager(new UserHibernateDao());

		try {
			userManager.add(user1);
			userManager.add(user2);
			userManager.update(user4);
			userManager.delete(user2);
			userManager.add(user3);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Bilinmeyen bir hata oluştu");
		}

	}

}
