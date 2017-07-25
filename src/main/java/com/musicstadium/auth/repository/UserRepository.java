package com.musicstadium.auth.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.musicstadium.auth.model.User;
import com.musicstadium.repository.EntityRepository;

@Named("userRepository")
@ApplicationScoped
public class UserRepository extends EntityRepository<User>{

	public List<User> getDbUser() {
		Query query = getDb().createQuery("FROM User");
		List<User> dbElements = (List<User>) query.getResultList();
		return dbElements;
	}
	
	public List<User> duplicate (User user){
		String s = user.getUsername();
		Query query = getDb().createQuery("SELECT c FROM User AS c WHERE c.username = :username ");
		query.setParameter("username",s);
		List<User> dbElements = (List<User>) query.getResultList();
		return dbElements;
	}

	
	@Override
	@Transactional
	public void removeFromDb(User user){
		User activeUser = getDb().find(User.class, user.getId());
		getDb().remove(activeUser);
	}

}