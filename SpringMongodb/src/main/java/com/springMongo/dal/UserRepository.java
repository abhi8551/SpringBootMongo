package com.springMongo.dal;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springMongo.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByUserId(String userId);
}
