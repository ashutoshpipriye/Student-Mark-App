<%@page import="java.sql.*"%>
<%@page import="a.b.Data"%>
<%
  
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
        String sql="select * from Student_detailsss";
//        out.print(sql);
        ResultSet rs = ob.getData(sql);
//        if(rs.next()){
            while(rs.next())
                {
                    s ="Roll No. : "+rs.getString("Roll_no")+",\nName : "+rs.getString("Name")+",\nMobile No. : "+rs.getString("Mob_no")+" ,\nE-mail : "+rs.getString("Email")+" ,\nDOB : "+rs.getString("DOB")+" ,\nCity : "+rs.getString("City")+",\n";
               
                    out.print(s);
                }
//        a++;
//        }
        
//        System.out.println(s);
        
    } catch (Exception e) {
        out.print(e);
    }
%>