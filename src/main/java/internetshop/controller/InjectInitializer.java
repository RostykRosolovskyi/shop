package internetshop.controller;

import internetshop.lib.Injector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class InjectInitializer implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(InjectInitializer.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Injector.injectDependencies();
        } catch (IllegalAccessException e) {
            logger.error("We catch exception in contextInitialized method class Inject"
                    + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
