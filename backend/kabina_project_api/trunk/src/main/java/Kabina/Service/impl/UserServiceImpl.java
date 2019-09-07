package Kabina.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kabina.Model.Users;
import Kabina.Repository.UsersRepository;
import Kabina.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository usersRepository;

	public Iterable<Users> findAll() {
		return usersRepository.findAll();
	}

	public void deleteUser(Integer Id) {
		usersRepository.deleteById(Id);
	}

	public Users addUser(Users usr) {
		// TODO Auto-generated method stub
		usersRepository.save(usr);
		return usr;
	}

	public int checkUserExist(String userName) {
		Users user = usersRepository.findByUserName(userName);
		if (user != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Users updateUser(Users usr) {
		// TODO Auto-generated method stub
		System.out.println(usr.getUserName() + " from url");
		System.out.println(usr.getPhone() + " from url");
		Users user = usersRepository.findByUserId(usr.getUserId());
		if (user != null) {
			System.out.println(user.getUserName() + " from database");
			System.out.println(user.getPhone() + " from database");
			user.setEmail(usr.getEmail());
			user.setPhone(usr.getPhone());
			user.setPassword(usr.getPassword());
			user.setUserShortName(usr.getUserShortName());
			user.setUserName(usr.getUserName());

			System.out.println("SAVE TO DATABASE");
			usersRepository.saveAndFlush(user);
		}
		return user;
	}
}
