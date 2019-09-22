package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetBuckectController extends HttpServlet {
    @Inject
    private static UserService userService;
    @Inject
    private static BucketService bucketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = userService.get(0L);
        Bucket bucket = bucketService.get(user.getBucket().getId());
        req.setAttribute("user", user);
        req.setAttribute("bucket", bucket);
        List<Item> items = bucket.getItems();
        double sum = items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        req.getRequestDispatcher("WEB-INF/views/bucket.jsp").forward(req, resp);
    }
}
