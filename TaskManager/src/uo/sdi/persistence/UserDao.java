package uo.sdi.persistence;

import java.util.List;

import uo.sdi.dto.User;
import uo.sdi.persistence.util.GenericDao;

public interface UserDao extends GenericDao<User, Long>{

	User findByLogin(String login);
	User findByLoginAndPassword(String login, String password);
	
	List<User> findAll();
	
}
