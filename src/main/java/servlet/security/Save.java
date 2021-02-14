package servlet.security;

import onroad.config.AppUtils;
import onroad.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="saveUser", value="/user/save")
public class Save extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id") != null ? Integer.valueOf(req.getParameter("id")) : null;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String permissao = req.getParameter("permissao");

        User user = new User(login, password, permissao);
        Users users = Users.getInstance();
        users.save(user);

        resp.sendRedirect(AppUtils.getInstance().getAppUrl() + "user/list");

    }
}
