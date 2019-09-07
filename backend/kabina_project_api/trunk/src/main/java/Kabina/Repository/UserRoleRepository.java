package Kabina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Kabina.Model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>, JpaRepository<UserRole, Long>{

}
