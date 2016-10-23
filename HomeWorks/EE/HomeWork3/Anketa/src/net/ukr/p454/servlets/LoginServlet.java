package net.ukr.p454.servlets;


import net.ukr.p454.entity.RegisterUser;
import net.ukr.p454.entity.User;
import net.ukr.p454.entity.Users;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.bind.*;


/**
 * Created by Dalvik on 21.10.2016.
 */

@WebServlet(urlPatterns = "/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    static final String TEMPLATE = "<html>" +
            "<head><title>Prog.kiev.ua</title></head>" +
            "<body><h1>%s</h1></body></html>";

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        String msg;
        User user = null;


        if ( (user = RegisterUser.checkUser(login,pass)) != null){

            HttpSession session = req.getSession();
            session.setAttribute("name", user.getName());

            resp.sendRedirect("/questionnaire.html");
        }
        else {
            resp.sendRedirect("/BadLogin.html");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        File file = new File("users.txt");
        if (file.exists()){
            try {
                JAXBContext context = JAXBContext.newInstance(Users.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Users users = (Users) unmarshaller.unmarshal(file);
                RegisterUser.setUsers(users.getList());
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}
