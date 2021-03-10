import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HelloWorld extends HttpServlet {
    private String message;         //doGetDemo1使用
    private ServletConfig config;   //doGetDemo3使用

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!20210309wcj";
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGetDemo3(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    //测试
    private void doGetDemo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //设置响应内容类型
        resp.setContentType("text/html");
        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    //设置Location响应头，实现请求重定向
    private void doGetDemo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(302);
        resp.setHeader("Location", "/firstWeb_war_exploded/f.html");
    }

    //通过ServletConfig获取Servlet的初始化参数
    private void doGetDemo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramVal = this.config.getInitParameter("name");
        resp.getWriter().print(paramVal);

        resp.getWriter().print("<hr/>");
        Enumeration<String> e = config.getInitParameterNames();
        while(e.hasMoreElements())
        {
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            resp.getWriter().print(name + "=" + value + "</br>");
        }
    }
}