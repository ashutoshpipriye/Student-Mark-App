package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import a.b.Data;

public final class Marks_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


    try {
//        String a=request.getParameter("id");
        String number = request.getParameter("Roll_no");
        String subject = request.getParameter("Subject");
        String marks = request.getParameter("Marks");
        System.out.println(number);
        System.out.println(subject);
        System.out.println(marks);
        String[] num;
        num = number.split(",");
        System.out.println("num");
        String[] mark;
        mark = marks.split(",");

//        String a="1";
//        String b="abcde";
//        String number="1";
//        String subject="DBMS";
//        String marks="12";
//        String dob="12/10/2019";
//        String city="Abad";
        Data ob = new Data();
        System.out.println("\nGot marks     " + mark.length);
        for (int i = 0; i <= mark.length; i++) {
            String sql = "insert into Mark values('" + num[i] + "','" + subject + "','" + mark[i] + "')";
            System.out.println(sql);
            ob.executeSql(sql);
        }
        ob.disconnect();
        out.print("Marks Save in database");

    } catch (Exception e) {
        out.print(e);
    }

      out.write('\n');
      out.write('\n');
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
