package Kabina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kabina.Model.BusinessUnit;

@Repository
public interface BusinessUnitRepository extends CrudRepository<BusinessUnit, Long>, JpaRepository<BusinessUnit, Long> {

}