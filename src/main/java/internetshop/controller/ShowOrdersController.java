package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.service.OrderService;
import internetshop.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrdersController extends HttpServlet {
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;
    private static final Long sesionId = 0L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("user", userService.get(sesionId));
        req.setAttribute("orders", userService.get(sesionId).getOrders());
        req.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(req, resp);
    }
}
