package ServletContextTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class ServletContextDemo6 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        resp.getWriter().println("java.util.logging.ConsoleHandler infos:");
        resp.getWriter().println("<hr/>");
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/config/logging.properties");
        Properties props = new Properties();
        props.load(in);

        String level = props.getProperty("java.util.logging.ConsoleHandler.level");
        String formatter = props.getProperty("java.util.logging.ConsoleHandler.formatter");
        String encoding = props.getProperty("java.util.logging.ConsoleHandler.encoding");
        resp.getWriter().print(MessageFormat.format("level={0};formatter={1};encoding={2}",
                level, formatter, encoding));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
    }
}
