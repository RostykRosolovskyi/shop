package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Item;
import internetshop.model.User;
import internetshop.service.ItemService;
import internetshop.service.UserService;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopController extends HttpServlet {
    @Inject
    private static ItemService itemService;
    @Inject
    private static UserService userService;
    private static final Long sesionId = 0L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (userService.getAll().size() == 0) {
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        }
        User user = userService.get(sesionId);
        List<Item> items = itemService.getAll();
        req.setAttribute("user", user);
        req.setAttribute("items", items);
        req.getRequestDispatcher("WEB-INF/views/shop.jsp").forward(req, resp);
    }
}
