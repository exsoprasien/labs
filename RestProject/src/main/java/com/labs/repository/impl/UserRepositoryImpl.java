package com.labs.repository.impl;

import com.labs.repository.IUserRepository;
import com.labs.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Inject
    private final MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Inject
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<User> findByFirstname(String firstname) {

        Query query = new Query();
        query.addCriteria(Criteria.where("firstname").is(firstname));

        User user = mongoTemplate.findOne(query,User.class);
        return Optional.ofNullable(user);

    }
}
