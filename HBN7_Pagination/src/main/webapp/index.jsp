<%@page import="com.Dao.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.Pagination"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



      <%
            
           
            String getStart=request.getParameter("start");
      
            int start=0;
            
            
      
            if(getStart!=null){
            	 start=Integer.parseInt(getStart);
            }
      
            
      
            Pagination pg=new Pagination();
            List<Employee>list=pg.read(start);
            
           
            
            for(Employee e:list){
      
      %>
            
                 <h1><%=e %></h1>
            
      <%
             start++;
            }
      %>
      
      
      <form action="index.jsp" method="post">
           <input type="hidden" name="start" value="<%= start%>">
           <button>next</button>
      </form>
      
      <form action="index.jsp" method="post">
           <input type="hidden" name="start" value="<%=start-8%>">
           <button>prev</button>
      </form>

</body>
</html>