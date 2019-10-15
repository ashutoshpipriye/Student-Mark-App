<%-- 
    Document   : Student
    Created on : 12 Oct, 2019, 4:34:20 PM
    Author     : Lenovo
--%>


<%@page import="a.b.Data"%>
<%
    
    try {
//        String a=request.getParameter("id");
        String name=request.getParameter("Name");
        String mobile_no=request.getParameter("Mob_no");
        String email=request.getParameter("Email");
        String dob=request.getParameter("DOB");
        String city=request.getParameter("City");
        
//        String a="1";
//        String b="abcde";
//        String name="Ashutosh Pipriye";
//        String mobile_no="1234567890";
//        String email="ashu@gmail.com";
//        String dob="12/10/2019";
//        String city="Abad";
        Data ob=new Data();
        String sql="insert into Student_detailsss values('"+name+"','"+mobile_no+"','"+email+"','"+dob+"','"+city+"')";
        System.out.println(sql);
        ob.executeSql(sql);
        ob.disconnect();
        out.print("Record Savedn in jsp");
        
    } catch (Exception e) {
        out.print(e);
    }
%>

