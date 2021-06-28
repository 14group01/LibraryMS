package cn.edu.guet.mvc;

/**
 * @Author liyingfeng
 * @Date 2021/6/27 10:57
 * @Version 1.0
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.URISyntaxException;
import java.util.Map;

@WebListener()
//�����ļ�����
/*�ü�������������������tomcat��ʱ���Զ�ִ��Configuration��config����
* */
public class ContextConfigListener implements ServletContextListener{
    // Public constructor is required by servlet spec
    public ContextConfigListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
//        �Զ�����
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        try {
            Map<String,ControllerMapping> controllerMapping=new Configuration().config();
            /*
            ����˸���ҳ��jsp�������ݣ������ݷ���ĳ��������request��session��application
             */
            sce.getServletContext().setAttribute("cn.guet.web.controller",controllerMapping);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }

}
