package net.ukr.p454.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalvik on 22.10.2016.
 */
public class RegisterUser {

    private static volatile List<User> users = new ArrayList<>();

    public synchronized static Boolean addUser(User user){

        boolean check = true;
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                check = false;
                break;
            }
        }
        if(check){
            users.add(user);
        }

        return check;
    }

    public static User checkUser(String email, String password){
        User user = null;

        for (User u : users) {
            if(u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)){
                user = u;
                break;
            }
        }
        return user;
    }
}
