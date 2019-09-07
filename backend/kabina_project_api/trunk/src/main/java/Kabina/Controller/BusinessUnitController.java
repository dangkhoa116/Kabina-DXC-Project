package Kabina.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Kabina.Model.BusinessUnit;
import Kabina.Service.impl.BusinessUnitServiceImpl;

@RestController
@RequestMapping(value = "/kabina")
public class BusinessUnitController {

	@Autowired
	private BusinessUnitServiceImpl businessUnitService;


	@RequestMapping(value = "/bu", method = RequestMethod.GET)
	public List<BusinessUnit> getAllBusinessUnit() {
		return (List<BusinessUnit>) businessUnitService.findAll();
	}
}
