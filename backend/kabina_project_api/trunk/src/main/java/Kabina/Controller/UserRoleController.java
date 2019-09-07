package Kabina.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Kabina.Model.UserRole;
import Kabina.Service.impl.UserRoleServiceImpl;

@RestController
@RequestMapping(value = "/kabina")
public class UserRoleController {

	@Autowired
	private UserRoleServiceImpl userRoleService;

	@RequestMapping(value = "/userRole", method = RequestMethod.GET)
	public List<UserRole> getAllUserRole() {
		return (List<UserRole>) userRoleService.findAll();
	}
}
