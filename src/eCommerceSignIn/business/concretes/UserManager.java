package eCommerceSignIn.business.concretes;

import java.util.ArrayList;

import eCommerceSignIn.business.abstracts.UserService;
import eCommerceSignIn.dataAccess.abstracts.UserDao;
import eCommerceSignIn.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;

	public UserManager() {
		super();
	}

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) throws BusinessException {
		if (checkPasswordLenght(user) && checkEmailIsStandard(user) && checkNameAndSurname(user)
				&& checkOverlapEmail(user) && checkOverlapID(user)) {
			this.userDao.add(user);
		}
	}

	@Override
	public void update(User user) throws BusinessException {
		if (checkPasswordLenght(user) && checkEmailIsStandard(user) && checkNameAndSurname(user)) {
			this.userDao.update(user);
		}
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
	}

	@Override
	public ArrayList<User> getAll() {
		return this.userDao.getAll();
	}

	private boolean checkPasswordLenght(User user) throws BusinessException {
		if (user.getPassword().length() < 6) {
			throw new BusinessException("Password cannot be less than 6 characters");
		}
		return true;
	}

	private boolean checkEmailIsStandard(User user) throws BusinessException {
		if (!user.getEmail().contains("@")) {
			throw new BusinessException("E-mail must be contain @");
		}
		return true;
	}

	private boolean checkNameAndSurname(User user) throws BusinessException {
		if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			throw new BusinessException("Name or Surname cannot be less than 2 characters");
		}
		return true;
	}

	private boolean checkOverlapEmail(User user) throws BusinessException {
		for (int i = 0; i < getAll().size(); i++) {
			if (user.getEmail() == getAll().get(i).getEmail()) {
				throw new BusinessException("E-mail is in usage");
			}
		}
		return true;
	}

	private boolean checkOverlapID(User user) throws BusinessException {
		for (int i = 0; i < getAll().size(); i++) {
			if (user.getId() == getAll().get(i).getId()) {
				throw new BusinessException("User ID's cannot be duplicate");
			}
		}
		return true;
	}
}
