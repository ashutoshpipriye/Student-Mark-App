<%@page import="java.sql.*"%>
<%@page import="a.b.Data"%>
<%
  
    try {
        String s="";
        Data ob =new Data();
        String sql="select Roll_no, Name from Student_detailsss";
//        out.print(sql);
        ResultSet rs = ob.getData(sql);
//        if(rs.next()){
            while(rs.next())
                {
                    s ="-"+rs.getString("Roll_no")+","+rs.getString("Name");
               
                    out.print(s);
                }
//        a++;
//        }
        
//        System.out.println(s);
        
    } catch (Exception e) {
        out.print(e);
    }
%>