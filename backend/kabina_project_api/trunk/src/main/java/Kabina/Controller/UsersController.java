package Kabina.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Kabina.Model.Users;
import Kabina.Service.impl.UserServiceImpl;
import Kabina.Validator.UsersValidator;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kabina")
public class UsersController {

	@Autowired
	private UserServiceImpl usersService;

	@Autowired
	private UsersValidator usersValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(usersValidator);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Users> getUsers() {
		return (List<Users>) usersService.findAll();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public ResponseEntity<Users> update(@RequestBody Users user) {
		user = usersService.updateUser(user);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<Users> add(@RequestBody Users user) {
		
		int check = usersService.checkUserExist(user.getUserName());
		if (check != 1) {
			user = usersService.addUser(user);
			if (user != null) {
				
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/users/del/{Id}", method = RequestMethod.GET)
	public void deleteUser(@PathVariable Integer Id) {
		usersService.deleteUser(Id);
	}
}
