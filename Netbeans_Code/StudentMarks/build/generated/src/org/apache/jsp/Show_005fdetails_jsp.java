package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import a.b.Data;

public final class Show_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

  
    try {
        String s="";
//        String a=request.getParameter("id");
//        String name=request.getParameter("Name");
//        String mobile_no=request.getParameter("Mob_no");
//        String email=request.getParameter("Email");
//        String dob=request.getParameter("DOB");
//        String city=request.getParameter("City");
//        String a="1";
//        String b="abcde";
//        String name="Ashutosh Pipriye";
//        String mobile_no="1234567890";
//        String email="ashu@gmail.com";
//        String dob="12/10/2019";
//        String city="Abad";
        Data ob =new Data();
        String sql="select * from Student_detailss";
//        out.print(sql);
        ResultSet rs = ob.getData(sql);
//        if(rs.next()){
            while(rs.next())
                {
                    s =",\nRoll No. : "+rs.getString("Roll_no")+",\nName : "+rs.getString("Name")+",\nMobile No. : "+rs.getString("Mob_no")+" ,\nE-mail : "+rs.getString("Email")+" ,\nDOB : "+rs.getString("DOB")+" ,\nCity : "+rs.getString("City");
               
                    out.print(s);
                }
//        a++;
//        }
        
//        System.out.println(s);
        
    } catch (Exception e) {
        out.print(e);
    }

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
