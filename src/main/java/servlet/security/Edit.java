package servlet.security;

import onroad.backend.entity.User;
import onroad.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="editarUsuario", value="/user/edit")
public class Edit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = (req.getParameter("id") != null) ? Integer.valueOf(req.getParameter("id")) : null;

        if (id != null){
            User user = new UserService().load(id);
            req.setAttribute("user", user);
        }

        req.getRequestDispatcher("/security/user/edit.jsp").forward(req, resp);
    }
}
