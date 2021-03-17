package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.management.UserManager;
import org.geektimes.web.mvc.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.management.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

/**
 * 测试用途
 */
@Deprecated
public class TestingListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ComponentContext context = ComponentContext.getInstance();
        DBConnectionManager dbConnectionManager = context.getComponent("bean/DBConnectionManager");
        dbConnectionManager.getConnection();
//        testPropertyFromServletContext(sce.getServletContext());
//        testPropertyFromJNDI(context);
//        testUser(dbConnectionManager.getEntityManager());

        try {
            registerJmxBean();
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("所有的 JNDI 组件名称：[");
        context.getComponentNames().forEach(logger::info);
        logger.info("]");
    }

    private void testPropertyFromServletContext(ServletContext servletContext) {
        String propertyName = "application.name";
        logger.info("ServletContext Property[" + propertyName + "] : "
                + servletContext.getInitParameter(propertyName));
    }

    private void testPropertyFromJNDI(ComponentContext context) {
        String propertyName = "maxValue";
        logger.info("JNDI Property[" + propertyName + "] : "
                + context.lookupComponent(propertyName));
    }

    private void testUser(EntityManager entityManager) {
        User user = new User();
        user.setName("小马哥");
        user.setPassword("******");
        user.setEmail("mercyblitz@gmail.com");
        user.setPhoneNumber("abcdefg");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        System.out.println(entityManager.find(User.class, user.getId()));
    }

    private void registerJmxBean() throws Exception {
        // 获取平台 MBean Server
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        // 为 UserMXBean 定义 ObjectName
        ObjectName objectName = new ObjectName("org.geektimes.projects.user.management:type=User");
        // 创建 UserMBean 实例
        mBeanServer.registerMBean(mockUserManager(), objectName);
    }

    public UserManager mockUserManager() {
        User user = new User();
        user.setName("小马哥");
        user.setPassword("******");
        user.setEmail("mercyblitz@gmail.com");
        user.setPhoneNumber("abcdefg");
        return new UserManager(user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
