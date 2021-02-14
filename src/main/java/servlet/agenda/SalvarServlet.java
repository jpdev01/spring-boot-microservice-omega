package servlet.agenda;

import onroad.dao.Contato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "agenda/salvar", value = "/agenda-save")
public class SalvarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id") != null ? Integer.valueOf(req.getParameter("id")) : null;
        String name = req.getParameter("name");
        String phone = req.getParameter("telephone");

        Contato c = new Contato(id, name, phone);

        Agenda agenda = Agenda.getInstance();
        agenda.salvar(c);

        resp.sendRedirect("agenda-list");
    }
}
