package com.API.Login.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.API.Login.Entity.Address;
import com.API.Login.Entity.ApiResponse;
import com.API.Login.Entity.MobileNo;
import com.API.Login.Entity.MyRunner;
import com.API.Login.Entity.UserLogin;
import com.API.Login.service.userService;


@RestController
public class UserController {

	@Autowired
	userService service;
	
	@Autowired
	MyRunner myRunner;
	
	@PostMapping("/login")
    ResponseEntity<ApiResponse> loginUser(@RequestBody UserLogin userlogin){
		ApiResponse login = service.getLogin(userlogin);
		
		return ResponseEntity.status(HttpStatus.OK).body(login);	
	}
	
	@PostMapping("/register")
	ResponseEntity<UserLogin> createUser(@RequestBody UserLogin register){
		UserLogin saveUserDetails = service.saveUserDetails(register);
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setMessage("You are registered successfully!!");
		return ResponseEntity.status(HttpStatus.OK).body(saveUserDetails);
	}
	
	@GetMapping("/getById/{userId}")
	ResponseEntity<Optional<UserLogin>> getByuserId(@PathVariable("userId") int id){
		Optional<UserLogin> userByUsrId = service.getUserByUsrId(id);
		return ResponseEntity.status(HttpStatus.OK).body(userByUsrId);
	}
	
	@GetMapping("/getuserName/{userId}")
	ResponseEntity<String>getByIduserName(@PathVariable("userId") int id){
		String userByUsrId = service.getUsername(id);
		return ResponseEntity.status(HttpStatus.OK).body(userByUsrId);
	}
	
	@GetMapping("/getUserByMobileId/{mobileId}")
	ResponseEntity<Object> getUserByMobileId(@PathVariable("mobileId") int id){
		Object userByMobileId =service.getUserByMobileId(id);
		return ResponseEntity.status(HttpStatus.OK).body(userByMobileId);
	}
	
	@PostMapping("/logge")  //*->Between consider middle value as well as both a and b also.
    ResponseEntity<List<Object[]>> getdetailbetween(@RequestBody UserLogin userlogin){
		List<Object[]> login = service.getdetailbetween(userlogin);
		
		return ResponseEntity.status(HttpStatus.OK).body(login);	
	}
	@PostMapping("/logg")
    ResponseEntity<List<UserLogin>> getdetailgreaterthanOrEquals(@RequestBody UserLogin userlogin){
		List<UserLogin> login = service.getdetailgreaterthan(userlogin);
		
		return ResponseEntity.status(HttpStatus.OK).body(login);	
	}
	@GetMapping("/log")
    ResponseEntity<List<Object[]>> findByAgeOrderByLastnameDesc(){
		List<Object[]> login = service.findByAgeOrderByLastnameDesc();
		
		return ResponseEntity.status(HttpStatus.OK).body(login);	
	}
	@PostMapping("/oneTomany")
	ResponseEntity<UserLogin> createMultipleAddress(@RequestBody UserLogin userLogin ){
		UserLogin userByUsrId = service.createMultipleAddress(userLogin);
		return ResponseEntity.status(HttpStatus.OK).body(userByUsrId);
	}
	@GetMapping("/getuser/{addressId}")
	ResponseEntity<Address> getUserByAddressId(@PathVariable("addressId") int id){
		Address userByUsrId = service.getUserByAddressId(id);
		return ResponseEntity.status(HttpStatus.OK).body(userByUsrId);
	}
//	@GetMapping("/getPreLoadedData")
//	ResponseEntity<ArrayList> getLoadedData(){
//		ArrayList list = myRunner.getList();
//		return ResponseEntity.status(HttpStatus.OK).body(list);
//	}
}
	
	
	
	
	
	
