package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Order;
import internetshop.model.User;
import internetshop.service.OrderService;
import internetshop.service.UserService;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrdersController extends HttpServlet {
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = userService.get(0L);
        List<Order> orders = user.getOrders();
        req.setAttribute("user", user);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(req, resp);
    }
}
