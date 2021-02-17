package servlet.security;

import onroad.config.AppUtils;
import onroad.dao.impl.UserDAOImpl;
import onroad.custom.Permission;
import onroad.entity.User;

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
        Integer permissao = req.getParameter("permissao") != null ? Integer.valueOf(req.getParameter("permissao")) : 0;

        User user = new User(login, password, Permission.ADM);
        UserDAOImpl dao = new UserDAOImpl();
        dao.save(user);

        resp.sendRedirect(AppUtils.getInstance().getAppUrl() + "/user/list");

    }
}
