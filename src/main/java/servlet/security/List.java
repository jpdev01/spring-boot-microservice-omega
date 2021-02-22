package servlet.security;

import onroad.backend.entity.User;
import onroad.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name="listUsers", value="/user/list")
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<User> users = new HashSet<>();
        users = new UserService().loadAll();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/security/user/list.jsp").forward(req, resp);

    }
}
