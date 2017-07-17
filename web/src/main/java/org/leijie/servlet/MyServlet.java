package org.leijie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/7/14 0014
 * Time: 16:10
 */
@WebServlet(urlPatterns="/myservlet", description="Servlet的说明")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -8685285401859800066L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //content type must be set to text/event-stream
        response.setContentType("text/event-stream");
        //encoding must be set to UTF-8
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        Random random = new Random();
        System.out.println("-------------------------------------");
        writer.write("data: 测试"+ random.nextInt(55)+"\n\n");
        writer.close();

    }
}
