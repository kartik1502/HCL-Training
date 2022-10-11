package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("numberOne"));
		int num2 = Integer.parseInt(req.getParameter("numberTwo"));
		PrintWriter pw = resp.getWriter();
		String op = req.getParameter("operator");
		char operator = op.charAt(0);
		switch(operator){
			case '+':pw.println("The addition of "+num1+" and "+num2+" is: "+(num1+num2));
				break;
			case '-':pw.println("The subtraction of "+num1+" and "+num2+" is: "+(num1-num2));
				break;
			case '*':pw.println("The multiplication of "+num1+" and "+num2+" is: "+(num1*num2));
				break;
			case '/':pw.println("The division of "+num1+" and "+num2+" is: "+(num1/num2));
				break;
			case '%':pw.println("The modulus of "+num1+" and "+num2+" is: "+(num1%num2));
				break;
			default:pw.println("Invalid operator");
		}
		pw.close();
	}
	
}
