package com.claim.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.entity.User;
import com.claim.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private static final String loginSql="select U.* from users U where U.email=:email and U.password =:password";
	private static final String emailCheckSql = "select U.* from users U where U.email=:email";
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	@Transactional
//	public User login(String email, String password){
//	
//		return (User) entityManager.createNativeQuery(loginSql, User.class)
//				.setParameter("email", email)
//				.setParameter("password", password)
//				.getSingleResult();
//	}
	
	@Transactional
	public User login(String email, String password){
		try{
		return this.userRepository.login(email, password);
		}
		catch (NoResultException nre){
			return null;
		}
	}
	
	@Transactional
	public void save(User newPerson){
		userRepository.save(newPerson);
	}

}