package servlet.security;

import onroad.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name="listUsers", value="/user/list")
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users usersInstance = Users.getInstance();
        Set<User> users = usersInstance.getUsers();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/security/list.jsp").forward(req, resp);

    }
}
