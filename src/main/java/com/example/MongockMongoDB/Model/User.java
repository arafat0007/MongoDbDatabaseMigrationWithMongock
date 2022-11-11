package com.example.MongockMongoDB.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("user")
public class User {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("email")
    private String email;

    @Indexed(unique = true)
    private String NID;
}
