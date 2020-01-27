package data;

import models.User;

public class Users {
    public User userWithIncorrectEmail = new User().setLogin("tester125@gmail.com").setPassword("test1111").setName("Юрий");
    public User userWithIncorrectPassword = new User().setLogin("tester125@gmail.com").setPassword("test1111").setName("Юрий");

}
