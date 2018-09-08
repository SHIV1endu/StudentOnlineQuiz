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
			<div style="margin-top: -3px;"><jsp:include page="FacultyMenu.jsp"></jsp:include>
			</div>
			
			<table width="750" align="center" border="1" background="white">
  <tr bgcolor="lightgray">
   
   
   
         <td align="center" colspan="8">
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
        </tr>
        
    
        
       
        
 <% 
 
 
 
 
 
 
    
      HashMap  hmpro=(HashMap)session.getAttribute("hmpro");
         
         
	         
         
         
         
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
     } %>
                      
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