package org.geektimes;


import org.geektimes.context.ClassicComponentContext;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class WebServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {
        ClassicComponentContext context = ClassicComponentContext.getInstance();
        context.init(servletContext);
    }
}
