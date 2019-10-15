<%-- 
    Document   : Student
    Created on : 12 Oct, 2019, 4:34:20 PM
    Author     : Lenovo
--%>


<%@page import="a.b.Data"%>
<%

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
        for (int i = 1; i <=mark.length; i++) {
            String sql = "insert into Mark values('" + num[i] + "','" + subject + "','" + mark[i] + "')";
            System.out.println(sql);
            ob.executeSql(sql);
        }
        ob.disconnect();
        out.print("Marks Save in database");

    } catch (Exception e) {
        out.print(e);
    }
%>

