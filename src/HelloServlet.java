import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@WebServlet("/HelloServlet")


public class HelloServlet extends HttpServlet {


    private String globalVar = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<p>I`m from GET!</p>");
        writer.close();
        System.out.println("GET globalVar is: " + globalVar);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String id = request.getParameter("id");
		printGlobalVarTest(id, "POST");
        try {
            writer.println(id);
        } finally {
            writer.close();
        }
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        //PrintWriter writer = response.getWriter();
		printGlobalVarTest(request.getParameter("id"), "PUT");
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		printGlobalVarTest("deleted", "DELETE");

    }

    private void printGlobalVarTest(String newId, String method){
		globalVar = newId;
		System.out.println(method + " current globalVar: " + globalVar);
	}

}