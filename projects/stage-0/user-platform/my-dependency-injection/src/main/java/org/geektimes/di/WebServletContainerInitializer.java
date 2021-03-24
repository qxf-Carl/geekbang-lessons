package org.geektimes.di;

import org.geektimes.di.context.ComponentContext;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class WebServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {
        ComponentContext context = ComponentContext.getInstance();
        context.init(servletContext);
    }
}
