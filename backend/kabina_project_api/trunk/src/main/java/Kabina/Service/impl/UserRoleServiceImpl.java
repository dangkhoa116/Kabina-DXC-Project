package Kabina.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kabina.Model.UserRole;
import Kabina.Repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl {
	@Autowired
	private UserRoleRepository userRoleRepository;

	public  Iterable<UserRole> findAll() {
		return userRoleRepository.findAll();
	}
}
