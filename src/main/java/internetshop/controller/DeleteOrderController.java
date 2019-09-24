package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Order;
import internetshop.model.User;
import internetshop.service.OrderService;
import internetshop.service.UserService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrderController extends HttpServlet {
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;
    private static final Long sesionId = 0L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long orderId = Long.parseLong(req.getParameter("order_id"));
        Order order = orderService.get(orderId);
        User user = userService.get(sesionId);
        orderService.delete(orderId);
        user.getOrders().remove(order);
        resp.sendRedirect(req.getContextPath() + "/showAllOrders");
    }
}
