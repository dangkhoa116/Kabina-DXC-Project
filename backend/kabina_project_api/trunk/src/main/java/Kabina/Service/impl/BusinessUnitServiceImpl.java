package Kabina.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kabina.Model.BusinessUnit;
import Kabina.Repository.BusinessUnitRepository;

@Service
public class BusinessUnitServiceImpl {
	@Autowired
	private BusinessUnitRepository businessUnitRepository;

	public  Iterable<BusinessUnit> findAll() {
		return businessUnitRepository.findAll();
	}
}
