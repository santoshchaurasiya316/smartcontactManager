package com.API.Login.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.API.Login.Entity.Address;
import com.API.Login.Entity.ApiResponse;
import com.API.Login.Entity.MobileNo;
import com.API.Login.Entity.UserLogin;
import com.API.Login.controller.OurCustomizedException;
import com.API.Login.repository.addressRepo;
import com.API.Login.repository.mobileRepository;
import com.API.Login.repository.userRepository;

@Service
public class userService {

	@Autowired
	userRepository repository;
	
	@Autowired
	mobileRepository mobileRepository;
	
	@Autowired
	addressRepo addressRepo;
	
	public ApiResponse getLogin(UserLogin userlogin) {

		UserLogin user = repository.getUserByEmailAndPassword(userlogin.getEmail(), userlogin.getPassword());
		ApiResponse apiResponse = new ApiResponse();

		if (user == null) {
			apiResponse.setMessage("Not found!!!");
		} else {
			apiResponse.setMessage("Logged in successfully!!");
		}
		return apiResponse;
	}

	@Transactional(rollbackFor = NullPointerException.class)
	public UserLogin saveUserDetails(UserLogin register) {
		
		ApiResponse apiResponse = new ApiResponse();
		
        MobileNo mobileNo = register.getMobileNo(); 
         if(mobileNo==null) { 
        		UserLogin save = this.repository.save(register);
        	throw new NullPointerException("Please fill Mobile detail!!!"); //@transactional will not insert any value 
        	                                                                //if exception thrown and rollbacked
        }
        else {
		UserLogin save = this.repository.save(register);
		apiResponse.setMessage("user registered successfully !!!");
		return save;
        }
	}

	@Cacheable(cacheNames = "UserLogin",key = "#id") //to update and delete we use @CacheEvict
	public Optional<UserLogin> getUserByUsrId(int id) {

		Optional<UserLogin> findById = repository.findById(id);
//		UserLogin mobileNumber = findById.get();
		return findById;
	}

	public Object getUserByMobileId(int id){
		
		UserLogin findById=null;
		try {

			findById = mobileRepository.findById(id).get().getLogin();
			Optional.ofNullable(findById); // using nullable to avoid NLP exception
              
			
//			.orElseThrow(
//		            ()
//		                -> new NoSuchElementException(
//		                    "NO CUSTOMER PRESENT WITH ID = " + id));
			
			
		} catch (Exception e) {
			
//			String msg="NO DATA PRESENT WITH Given ID";
//			ApiResponse error=new ApiResponse(msg);

			System.err.println("NO DATA PRESENT WITH Given ID = " + id);

//			return "NO DATA PRESENT WITH Given ID";

//			throw new NoSuchElementException("NO DATA PRESENT WITH Given ID = " + id);
		}
		return findById;
}

	public UserLogin getdetail(UserLogin userlogin) {

		UserLogin findByuserIdAndemail = repository.getUserByUserIdOrEmail(userlogin.getUserId(), userlogin.getEmail());
		return findByuserIdAndemail;
	}

	public List<Object[]> getdetailbetween(UserLogin userlogin) {

		int a = 6;
		List<Object[]> findByuserIdBetween = repository.findByUserIdBetween(a, userlogin.getUserId());
//	  findByuserIdBetween.forEach(i->System.out.println(i.getMobileNo().getMobileNumber()));
		return findByuserIdBetween;
	}

	public List<UserLogin> getdetailgreaterthan(UserLogin userlogin) {

		List<UserLogin> findByuserIdBetween = repository.getUserByUserIdGreaterThanEqual(userlogin.getUserId());
		findByuserIdBetween.forEach(i -> System.out.println(i.getMobileNo().getMobileNumber()));
		return findByuserIdBetween;
	}

	public List<Object[]> findByAgeOrderByLastnameDesc() {
		List<Object[]> findByuserIdBetween = repository.getUserOrderByUserId();
		findByuserIdBetween.forEach(i -> System.out.println(i));
		return findByuserIdBetween;
	}

	public UserLogin createMultipleAddress(UserLogin userLogin) {

		UserLogin login = repository.save(userLogin);
		return login;
	}

	public Address getUserByAddressId(int id) {

		Address findById = addressRepo.findById(id).orElseThrow(
	            ()
                -> new NoSuchElementException(
                    "NO CUSTOMER PRESENT --->>>WITH ID = " + id));
		return findById;
	}

	public String getUsername(int id) {
		String name=null;
//		name=repository.findById(id);
		try {
			if(name.contains("Santosh")) {
				System.out.println("Hi>>>>>>>>>>>>>>>>>>");
			}
		} catch (Exception e) {
			throw new OurCustomizedException("No such element found!!");
		}
		
		//we can also handle exception by ispresent method of Optional clss
		
//		if(name.ispresent()) {
//			System.out.println(name.get());
//		}
//		else {
//			String s="Default";
//			optional.orElse();
//		}
		return name;
	}
	
	
}
