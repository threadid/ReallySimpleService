package com.reallysimpleservice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servAjax
 */
//@WebServlet(name = "ServAjax", urlPatterns = { "/write/*", "/read/*" })
public class SimplyServed extends HttpServlet {
	private ServletContext servContext;
	private ServletConfig config;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SimplyServed() {
        super();
    }

	public void init()	throws ServletException
	{
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter responseOut = response.getWriter();
		 
		System.out.println("SimplyServed");
	
		this.servContext = this.getServletContext();
	
		 System.out.println("<Begin>");
		 System.out.println("**************************************************************************");
		 
		 System.out.println("request.getParameter(\"whom\") = "+request.getParameter("whom")+"<br>");		 
	
		 System.out.println("servContext.getInitParameter(\"jdbcURL\") = "+servContext.getInitParameter("jdbcURL")+"<br>");
		 System.out.println("servContext.getInitParameter(\"dataService\") = "+servContext.getInitParameter("dataService")+"<br>");
		 System.out.println("request.getAttributeNames().hasMoreElements() = "+request.getAttributeNames().hasMoreElements()+"<br>");
		 if(request.getAttributeNames().hasMoreElements()) {
			 System.out.println("request.getAttributeNames().nextElement() = "+request.getAttributeNames().nextElement()+"<br>");
		 }
		 System.out.println("request.getHeaderNames().hasMoreElements() = "+request.getHeaderNames().hasMoreElements()+"<br>");
		 Enumeration<String> hnames = request.getHeaderNames();
		 String hname = "";
		 while(hnames.hasMoreElements()) {
			 	hname = (String) hnames.nextElement();
			 	System.out.println("request.getHeaderNames().nextElement() = "+hname+"<br>");
			 	System.out.println("request.getHeader("+hname+") = "+request.getHeader(hname)+"<br>");
		 }	 
		 
	
/*			 
		 Cookie [] cookies = request.getCookies();
		 System.out.println("cookies.length = "+cookies.length+"<br>");
		 System.out.println("cookies[0].getName() = "+cookies[0].getName() +"<br>");
		 System.out.println("cookies[0].getValue() = "+cookies[0].getValue() +"<br>");
		 System.out.println("cookies[0].getPath() = "+cookies[0].getPath() +"<br>");
		 System.out.println("cookies[0].getVersion() = "+cookies[0].getVersion() +"<br>");
		 System.out.println("cookies[0].getMaxAge() = "+cookies[0].getMaxAge() +"<br>");
		 System.out.println("cookies[0].getDomain() = "+cookies[0].getDomain() +"<br>");
		 System.out.println("cookies[0].getComment() = "+cookies[0].getComment()+"<br>");
*/		
		 System.out.println("request.getAuthType() = "+request.getAuthType()+"<br>");
		 System.out.println("request.getCharacterEncoding() = "+request.getCharacterEncoding()+"<br>");
		 System.out.println("request.getContentLength() = "+request.getContentLength()+"<br>");
		 System.out.println("request.getContentType() = "+request.getContentType()+"<br>");
		 System.out.println("request.getContextPath() = "+request.getContextPath()+"<br>");
		 System.out.println("request.getRequestedSessionId() = "+request.getRequestedSessionId()+"<br>");
		 System.out.println("request.getRequestURI() = "+request.getRequestURI()+"<br>");
		 System.out.println("request.getLocalAddr() = "+request.getLocalAddr()+"<br>");
		 System.out.println("request.getLocalName() = "+request.getLocalName()+"<br>");
		 System.out.println("request.getLocalPort() = "+request.getLocalPort()+"<br>");
		 System.out.println("request.getMethod() = "+request.getMethod()+"<br>");
		 try {
			System.out.println("request.getPart() = "+request.getPart("mime-type")+"<br>");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		 System.out.println("request.getPathTranslated() = "+request.getPathTranslated()+"<br>");
		 System.out.println("request.getPathInfo() = "+request.getPathInfo() +"<br>");
		 System.out.println("request.getProtocol() = "+request.getProtocol()+"<br>");
		 System.out.println("request.getQueryString() = "+request.getQueryString()+"<br>");
		 System.out.println("request.getRequestedSessionId() = "+request.getRequestedSessionId()+"<br>");
		 System.out.println("request.getServletPath() = "+request.getServletPath()+"<br>");
		 System.out.println("request.isRequestedSessionIdFromCookie() = "+request.isRequestedSessionIdFromCookie()+"<br>");
		 System.out.println("request.isRequestedSessionIdFromURL() = "+request.isRequestedSessionIdFromURL()+"<br>");
		 System.out.println("request.isRequestedSessionIdValid() = "+request.isRequestedSessionIdValid()+"<br>");
		 System.out.println("request.isSecure() = "+request.isSecure()+"<br>");
		 System.out.println("request.getSession() = "+request.getSession()+"<br>");
		 System.out.println("request.getUserPrincipal() = "+request.getUserPrincipal()+"<br>");
		 System.out.println("request.isAsyncStarted() = "+request.isAsyncStarted()+"<br>");
		 System.out.println("request.isAsyncSupported() = "+request.isAsyncSupported()+"<br>");
		 System.out.println("**************************************************************************");
		 System.out.println("</End>");
	
	
		String resourceServlet = "";
		String resourcePath = "";
		String whom="";
		
		resourceServlet = request.getServletPath();
	 	resourcePath = request.getPathInfo();
	 	whom=request.getParameter("whom");
	 	
		responseOut.print("Hello "+whom);

	}
}

