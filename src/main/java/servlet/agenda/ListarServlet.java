package servlet.agenda;

import onroad.dao.Contato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "agenda", value = "/agenda-list")
public class ListarServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Agenda agenda = Agenda.getInstance();

        Set<Contato> contatos = agenda.getContatos();
        req.setAttribute("contatos", contatos);

        req.getRequestDispatcher("/agenda/list.jsp").forward(req, resp);
    }
}
