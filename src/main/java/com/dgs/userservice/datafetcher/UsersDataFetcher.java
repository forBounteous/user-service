package com.dgs.userservice.datafetcher;


import com.dgs.userservice.model.User;
import com.dgs.userservice.repository.UserRepository;
import com.mongodb.client.MongoClient;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import java.util.List;

@DgsComponent
@Slf4j
public class UsersDataFetcher {

    private static final Logger logger = LoggerFactory.getLogger(UsersDataFetcher.class);

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Autowired
    private UserRepository userRepository;

    @DgsQuery
    public List<User> users() {
        logger.debug("Inside users *****");
        return userRepository.findAll();
    }

}