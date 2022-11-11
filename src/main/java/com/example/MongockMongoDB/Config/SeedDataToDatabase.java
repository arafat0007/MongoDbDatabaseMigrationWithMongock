package com.example.MongockMongoDB.Config;

import com.example.MongockMongoDB.Model.User;
import com.example.MongockMongoDB.Repository.UserRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

@ChangeUnit(id="SeedDataToDatabase", order="001", author = "Arafat")
public class SeedDataToDatabase {
    //aim is to add data to database

    //executing using repository

//    @Execution()
//    public void seedData(UserRepository userRepository){
//        List<User> userList = new ArrayList<>();
//        userList.add(createUser("arafat","arafat@gmail.com"));
//        userList.add(createUser("yasin","yasin@gmail.com"));
//        userList.add(createUser("afrina","afrina@gmail.com"));
//
//        userRepository.insert(userList);
//    }


    //executing using MongoTemplate
    @Execution()
    public void seedData(MongoTemplate mongoTemplate){
        List<User> userList = new ArrayList<>();
        userList.add(createUser("arafat1","arafat@gmail.com"));
        userList.add(createUser("yasin1","yasin@gmail.com"));
        userList.add(createUser("afrina1","afrina@gmail.com"));

        mongoTemplate.insertAll(userList);
    }

    @RollbackExecution
    public void rollback() {
        // Our change is backward-compatible; we don't need to implement a rollback mechanism.
    }
    private User createUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}
