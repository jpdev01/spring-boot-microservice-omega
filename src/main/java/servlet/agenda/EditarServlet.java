package servlet.agenda;

import onroad.dao.Contato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "agenda/edit", value = "/agenda-edit")
public class EditarServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Integer id = req.getParameter("id") != null ? Integer.valueOf(req.getParameter("id")) : null;

             // metodo singleton
             Agenda agenda = Agenda.getInstance();

             if (id != null){
                 Contato contato = agenda.carregar(id);
                 req.setAttribute("contato", contato);
             }

         req.getRequestDispatcher("agenda/edit.jsp").forward(req, resp);
    }
}
