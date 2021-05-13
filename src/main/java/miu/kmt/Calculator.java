package miu.kmt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author KidusMT
 * Date: 5/13/2021
 */
@WebServlet("/calc")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer op1 = Integer.parseInt(req.getParameter("op1"));
        String opr = req.getParameter("opr");
        Integer op2 = Integer.parseInt(req.getParameter("op2"));
        Integer result = null;
        if(opr.equals("+")){
            result = op1 + op2;
        }else if(opr.equals("*")){
            result = op1 * op2;
        }else if(opr.equals("/")){
            result = op1 / op2;
        }else if(opr.equals("-")){
            result = op1 - op2;
        }

        req.getSession().setAttribute("result", result);
        req.getSession().setAttribute("opr", opr);
        req.getSession().setAttribute("op1", op1);
        req.getSession().setAttribute("op2", op2);

        // PRG pattern
        resp.sendRedirect("calc");
    }
}
