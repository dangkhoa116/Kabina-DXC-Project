package Kabina.Service;

import Kabina.Model.Users;

public interface UserService {
	Iterable<Users> findAll();
	public Users addUser(Users usr);
	public Users updateUser(Users usr);
	public void deleteUser (Integer Id);
	int checkUserExist(String userName);
}
