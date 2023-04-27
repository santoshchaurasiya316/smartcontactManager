package com.API.Login.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.API.Login.Entity.UserLogin;

@Repository
@EnableJpaRepositories
public interface userRepository extends JpaRepository<UserLogin, Integer> {
	
	
	public static final String HASK_KEY="User";
	
	UserLogin getUserByEmailAndPassword(String email, String password);

	
	UserLogin getUserByUserIdAndEmail(int userId,String email);

	UserLogin getUserByUserIdOrEmail(int userId, String email);

	List<UserLogin> getUserByUserIdLessThan(int userId);

	List<UserLogin> getUserByUserIdGreaterThan(int userId);

	List<UserLogin> getUserByUserIdGreaterThanEqual(int userId);

	//FROM Employee WHERE joinedDate BETWEEN :startDate AND :endDate
	@Query("select email from UserLogin u where u.userId Between :i AND :userId")
	List<Object[]> findByUserIdBetween(int i, int userId);
    	
	@Transactional(timeout = 3,readOnly = true)
	@Query("select u from UserLogin u order by u.password asc")
	List<Object[]> getUserOrderByUserId();

    
}
