package net.ukr.p454.entity;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
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
            saveUsers();
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

    public static User getUserbyEmail(String email){
        User user = null;

        for (User u : users) {
            if(u.getEmail().equalsIgnoreCase(email)){
                user = u;
                break;
            }
        }
        return user;
    }

    public static List<User> getUsers() {
        return users;
    }

    private static void saveUsers(){
        try {

            Users users = new Users();
            users.setList(RegisterUser.getUsers());

            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File("users.txt"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void setUsers(List<User> users) {
        RegisterUser.users = users;
    }
}
