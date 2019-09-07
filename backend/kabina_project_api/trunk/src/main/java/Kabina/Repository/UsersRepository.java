package Kabina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Kabina.Model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>, JpaRepository<Users, Integer> {
	//@Query( value = "DELETE FROM Users WHERE user_id=%Id%", nativeQuery = true)
	Users findByUserName(String userName);
	Users findByUserId(int userId);
}
