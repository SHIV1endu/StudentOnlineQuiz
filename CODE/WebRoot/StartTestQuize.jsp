<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.aoc.dto.QuestionBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'StartTestQuize.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<script type="text/javascript">
	
	function preventBack()
	{
	window.history.forward();
	}
	setTimeout("preventBack()",0);
	
	window.onload=function()
	{
	null
	};
	</script>






  <script type="text/javascript" src="jquery.min.js"></script></head>
  <script type="text/javascript">
  
     window.onload=function(){
  
		  startCountDown(3000);
        var auto = setTimeout(function(){ autoRefresh(); },300);

        function submitform(){
         
          document.forms["myForm"].submit();
        }

        function autoRefresh(){
           clearTimeout(auto);
           auto = setTimeout(function(){ submitform(); autoRefresh(); }, 30000);
        }
    }
    
</script>
  
	<script type="text/javascript">
	var countdownTimer;
var endTime;
var counter = 0;  // ** see reply item 3. **

function startCountDown( csecs)   // hundredths of a second
{   endTime = Date.now() + 10*csecs; // endTime in millisecs
    decrement();
    countdownTimer = setInterval(decrement, 10);
    counter = 0; // testing
     
}

function decrement()
{   var now, time, mins, secs, csecs, timeStr;

    ++ counter; // testing

    now = Date.now();
    if( now >= endTime)
    {   
    	time = 0;
        timeStr = "Times up! ";
        clearInterval( countdownTimer);
    
        
   
    }
    else
    {   time = Math.floor( (endTime - now)/10); // unit = 1/100 sec
        csecs = time%100;
        time = (time-csecs)/100; // unit = 1 sec
        secs = time % 60;
        mins = (time-secs)/60;   // unit = 60 secs
        timeStr =  
          ( (mins < 10)  ? "0" + mins : mins) + ":" +
          ( (secs < 10)  ? "0" + secs : secs) + ":" +
          ( (csecs < 10) ? "0" + csecs : csecs);
    }
    document.getElementById("output").innerHTML=timeStr;
}

</script>
  <body>
    <div style="width: 1000px; height: auto; margin-top: -15px;"></div>
			<jsp:include page="Header.jsp"></jsp:include>
			<div style="margin-top: -3px;"><jsp:include page="UserMenu.jsp"></jsp:include>
			</div>
			<center>
				<div style="height: auto; width: 650px; background-color: white;">
		   	       <div style="height: 20px;width: 650px;background-color:	#FF4500;"></div>
		   	       All Questions for &nbsp;&nbsp;&nbsp;Test
		   	       <form action="./AnsSubmitByStudent" name="myForm" id="myForm" >
		   	       
						<table style="width: 550px;" border="0">
							<tr>
								<td colspan="2">
									<label
										style="color: #0000aa; font-style: italic; font-size: 20px;">
										<%		
										  String testname=(String)session.getAttribute("tpaper");
										  System.out.println("testname--->"+testname);
										  String name=(String)session.getAttribute("name");
										  System.out.println("name--->"+name);
										  String sid=(String)session.getAttribute("sid");	
										    System.out.println("sid--->"+sid);
										  String email=(String)session.getAttribute("emailid");
										     System.out.println("email--->"+email);
										  String phone=(String)session.getAttribute("phone");
										     System.out.println("phone--->"+phone);
										  String subjectid=(String)session.getAttribute("sid");	
										   System.out.println("subject--->"+subjectid);
										  String userid=(String)session.getAttribute("uid");
										   System.out.println("userid--->"+userid);	
											HashMap hm=(HashMap)session.getAttribute("hmv");
											
											System.out.print(hm.size());
										%>
									</label>
								</td>
							</tr>
							<tr>
							<td>
							<input type="hidden" name="userid" value="<%=userid%>"/>
							<input type="hidden" name="tname" value="<%=testname%>"/>
							<input type="hidden" name="email" value="<%=email%>"/>
							<input type="hidden" name="phone" value="<%=phone%>"/>
							<input type="hidden" name="uname" value="<%=name%>"/>
							<input type="hidden" name="sid" value="<%=subjectid%>"/>
							</td>
							</tr>
							<tr>
							
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
								</td>
							</tr>	
							<%
						    QuestionBean dto=new QuestionBean();
						
						int i=(Integer)session.getAttribute("que");
						
						session.setAttribute("i",i);
							dto=(QuestionBean)hm.get(i);
							%>
							
							<tr >
							<td>
							<!--<table style="width: 400px;color: gray;">-->
							<tr><td>
							
		<center><font color='red'>				
<div id="output">

</div></font></center>
<br/>
							
							<%=i %><input type="hidden" name="qid" value="<%=dto.getQuestionid()%>">&nbsp;&nbsp;&nbsp;<font style="color: red;"><%=dto.getQuestion() %></font>
					       
							</td></tr>
							</td>
							<td>
							<table style="width: 400px;color: gray;">
							
							<tr><td style="width: 100px;color: green;">Option 1:</td><td> &nbsp; </td> <td><%=dto.getOp1() %></td></tr>
							<tr><td style="color: green;">Option 2:</td><td> &nbsp; </td> <td><%=dto.getOp2()%></td></tr>
							<tr><td style="color: green;">Option 3:</td><td> &nbsp; </td> <td><%=dto.getOp3() %></td></tr>
							<tr><td style="color: green;">Option 4:</td><td> &nbsp; </td> <td><%=dto.getOp4() %></td></tr>
							
							<tr><td style="color: #C71585;">True Answer:</td><td> &nbsp; </td> <td><input type="hidden"name="tue" value=" <%=dto.getTruans()%>"/></td></tr>
							<tr>
							<td>
							<input type="radio" name="op" value="1" />Op1</td>
							<td><input type="radio" name="op" value="2" />Op2</td>
							<td><input type="radio" name="op" value="3" />Op3</td>
							<td><input type="radio" name="op" value="4" />Op4</td>
							</tr>
							
							</table>	
							</td>
							</tr>
								<tr style="background-color: silver;">
								<td colspan="2">
									&nbsp;
							
									&nbsp;
								</td>
							</tr>
							
						 
		   	 
		   	      <tr>
		   	      
		   	      <td></td><td><input type="submit" value="SubmitAns"/></td>
		   	      </tr>
		   	       </table>
		   	       </form>
		   	       </div>
		   	       </center>
		   	       
  </body>
</html>