package com.example.MongockMongoDB.Config;

import com.example.MongockMongoDB.Model.User;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.UUID;

@ChangeUnit(id="ModifyDataofDatabaseDueToModelFieldAddiction", order="002", author = "Arafat")
public class ModifyData {
    //aim is modify data of user table due to structure change (new field NID is added, so we will create NID for previous datas)

    //executing using MongoTemplate
    @Execution()
    public void seedData(MongoTemplate mongoTemplate){
        mongoTemplate.findAll(User.class).forEach(document -> {
            document.setNID(UUID.randomUUID().toString());
            mongoTemplate.save(document);
        });
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
