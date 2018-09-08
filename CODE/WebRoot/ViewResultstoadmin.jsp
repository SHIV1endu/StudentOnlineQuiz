<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap" %>
<%@page import="com.dts.aoc.dao.AcceptTestNameDAO"%>
<%@page import="com.dts.aoc.dto.QuestionBean"%>

<!DOCTYPE HTML>



  <head>
  
  <style type="text/css">
  td
  {
  color: orange;
  }
  table
  {
  background-color: white;
  }
  </style>   
  </head>
  <%
  
  
  
  
   %>
  <body>
   <div style="width: 1000px; height: auto; margin-top: -15px;"></div>
	<jsp:include page="Header.jsp"></jsp:include>
			<%
			//String type=session.getAttribute("utype");
			String type=(String)session.getAttribute("utype");
			System.out.println(type);
			
			if(type.equals("ADMIN"))
			
			{
			 %>
			<jsp:include page="AdminMenu.jsp"></jsp:include>
			<%
			
			}
			else if(type.equals("FACULTY"))
			{
			 %>
			<jsp:include page="FacultyMenu.jsp"></jsp:include>
			<%
			} %>
			</div>
			
			
			
			
			
			
		
			<center>
			<table>
			<form action="ViewResultstoadmin.jsp">
			<tr><td>Select From_Date</td><td><input type="date" name="from" required/></td></tr>
			<tr><td>Select To_Date</td><td><input type="date" name="to" required/></td></tr>
			<tr><td></td><td><input type="submit" value="Get Results"/></td></tr>
			</form>
			</table>
			
			
			
			
			
			<%
			if(request.getParameter("from")!=null && request.getParameter("to")!=null)
			{
			String from=request.getParameter("from");
			String to=request.getParameter("to");
			
			
 HashMap hmpro=new AcceptTestNameDAO().getResult(from,to);
	         
         if(!hmpro.isEmpty())
         {
			
	%>		
			
			
			<table width="750" align="center" border="1" background="white">
  <tr bgcolor="lightgray">
   
   
   
         <td align="center" colspan="9">
          <font color="red" size="3">Student results</font>
         </td>
        </tr>
        <tr>
         
         <th>
          <font color=red size="4">userid</font>
         </th>
         <th>
          <font color="red" size="4"> name</font>
         </th>
          <th>
          <font color="red" size="4"> email</font>
         </th>
         
          <th>
          <font color="red" size="4">mobile number</font>
         </th>
          <th>
          <font color="red" size="4">testname</font>
         </th> 
         <th>
          <font color="red" size="4">subject id</font>
         </td>  
         <td>
          <font color="red" size="4">marks obtained</font>
         </th>  
         <th>
          <font color="red" size="4">total marks</font>
         </th>
         <th>
          <font color="red" size="4">Status</font>
         </th>               
        </tr>
        
    
        
       
        
 <% 
 
         
       for(int i=1;i<=hmpro.size();i++){
        
       System.out.println( "in hashmap");
        
        QuestionBean q=(QuestionBean)hmpro.get(i);
        
        
        System.out.println(q.getSno());
       System.out.println(q.getUserid());
       
        %>
     <tr>
        
              <td><%=q.getUserid() %></td>
              <td><%=q.getName() %></td>
              
              <td><%=q.getEmail()%></td>
              <td><%=q.getPhone() %></td>
              <td><%=q.getTestname() %></td>
              <td><%=q.getSubjectid()%></td>
              <td><%=q.getMyans() %></td>
              <td><%=q.getTotmarks() %></td>
              <%
              if(q.getMyans()<10)
              {
               %>
              <td>Failed</td>
              <%
              }
              else
              {
               %>
               <td>Pass</td>
              <%
              }
  
     }
     } 
     
     }%>
                      
          </tr>
           
        

  
       </table>
     
     
      <td width="980" height="50" align="center" valign="bottom" colspan="2">
      
      </td>
     </tr>
    </table>
    
  </body>
</html>




</body>
</html>