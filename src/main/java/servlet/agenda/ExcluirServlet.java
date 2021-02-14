package servlet.agenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agenda-exluir")
public class ExcluirServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null){
            Integer id = Integer.valueOf(req.getParameter("id"));

            Agenda agenda = Agenda.getInstance();
            agenda.excluir(id);
        }
        resp.sendRedirect("agenda-list");

    }
}
