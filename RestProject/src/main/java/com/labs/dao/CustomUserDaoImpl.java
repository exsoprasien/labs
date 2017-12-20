package com.labs.dao;

import com.labs.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.inject.Inject;
import java.util.Optional;

public class CustomUserDaoImpl implements CustomUserDao{

    private final MongoTemplate mongoTemplate;

    @Inject
    public CustomUserDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<User> findByFirstname(String firstname) {

        Query query = new Query();

        Criteria criteria = new Criteria();
        criteria.where("name").is(firstname);

        query.addCriteria(criteria);

        return Optional.of(mongoTemplate.findOne(query,User.class));

    }
}
