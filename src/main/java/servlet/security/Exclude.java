package servlet.security;

import onroad.config.AppUtils;
import onroad.dao.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Exclude extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = req.getParameter("id") != null ? Integer.valueOf(req.getParameter("id")) : null;
        if (id != null)
        {
            new UserDAOImpl().remove(id);
        }
        resp.sendRedirect(AppUtils.getInstance().getAppUrl() + "/user/list");
    }
}
