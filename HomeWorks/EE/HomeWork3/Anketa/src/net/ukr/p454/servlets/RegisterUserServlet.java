package net.ukr.p454.servlets;

import net.ukr.p454.entity.RegisterUser;
import net.ukr.p454.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dalvik on 22.10.2016.
 */
@WebServlet(urlPatterns = "/registrationCompleted")
public class RegisterUserServlet extends HttpServlet{
    static final String TEMPLATE = "<html>" +
            "<head><title>Register</title></head>" +
            "<body><h1>%s</h1></body></html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(name, lastname, email, password);
        String s;
        if (RegisterUser.addUser(user)){
            s = "Welcome  "  + user.getName() + "! Registration completed <br> " ;
            s = s + "<a href=\"login.html\" col>Login</a>";
        } else {
            s = "Sorry, your email exists in our base....";
        }
        resp.getWriter().println(String.format(TEMPLATE,s));
    }
}
