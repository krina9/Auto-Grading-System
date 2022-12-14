package com.example.AutoGrad.Model;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
public class EmailConfirmation {

    private String confirmationToken;
    private java.sql.Date date;
    private User user;

    public EmailConfirmation() {
    }

    public EmailConfirmation(User user) {
        this.user = user;
        date = new Date(System.currentTimeMillis());
        confirmationToken = UUID.randomUUID().toString();
    }

}
