package ServletContextTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContextDemo5 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //resp.getWriter().print("getWriter:ServletContextDemo5");//getWriter()不能和getOutputStream()同时使用
        resp.setDateHeader("expires", System.currentTimeMillis() + 1000*60*24);//将数据的缓存时间设置为1天
        resp.getOutputStream().write("getOutputStream:ServletContextDemo5 expires".getBytes());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
    }
}
