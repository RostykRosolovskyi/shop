package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Bucket;
import internetshop.model.Order;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.OrderService;
import internetshop.service.UserService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompleteOrderController extends HttpServlet {
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;
    @Inject
    private static BucketService bucketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long bucketId = Long.parseLong(req.getParameter("bucket_id"));
        Bucket bucket = bucketService.get(bucketId);
        if (bucket.getItems().size() != 0) {
            User user = userService.get(0L);
            Order order = new Order(bucket.getItems(), user);
            orderService.add(order);
            user.getOrders().add(order);
            bucketService.clear(bucket);
        }
        resp.sendRedirect(req.getContextPath() + "/shop");
    }
}
