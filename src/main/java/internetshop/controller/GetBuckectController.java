package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Bucket;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.UserService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetBuckectController extends HttpServlet {
    @Inject
    private static UserService userService;
    @Inject
    private static BucketService bucketService;
    private static final Long sesionId = 0L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = userService.get(sesionId);
        Bucket bucket = bucketService.get(user.getBucket().getId());
        req.setAttribute("user", user);
        req.setAttribute("bucket", bucket);
        req.getRequestDispatcher("WEB-INF/views/bucket.jsp").forward(req, resp);
    }
}
