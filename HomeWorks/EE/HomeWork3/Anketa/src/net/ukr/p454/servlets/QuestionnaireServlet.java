package net.ukr.p454.servlets;

import net.ukr.p454.entity.Answers;
import net.ukr.p454.entity.Question;
import net.ukr.p454.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Dalvik on 22.10.2016.
 */
@WebServlet(urlPatterns = "/stats")
public class QuestionnaireServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
        Question q1 = new Question("The capital of Ukraine is:", "Kiev");
        q1.addVariants("Kiev","Lvov","Kanev");
        Question q2 = new Question("The capital of Germany is:", "Berlin");
        q2.addVariants("Berlin","Dresden","Franfurkt-am-main");
        Question q3 = new Question("The capital of Poland is:", "Warsaw");
        q3.addVariants("Krakow","Warsaw","Wroclav");

        Questions.addQuestion(q1);
        Questions.addQuestion(q2);
        Questions.addQuestion(q3);

        Answers.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Question> list = Questions.getQuestions();
        Answers.addAnswer(list.get(0), req.getParameter("ukraine"));
        Answers.addAnswer(list.get(1), req.getParameter("germany"));
        Answers.addAnswer(list.get(2), req.getParameter("poland"));
        resp.sendRedirect("/stats.jsp");
    }
}
