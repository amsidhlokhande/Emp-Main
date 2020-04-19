<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMPLOYEE MANAGEMENT</title>
  <style type="text/css" >
          
         table.mytable 
         { 
         border-collapse: collapse; 
         border: 5px solid #839E99;   
         border-color:green;
         font: 15, "Times New Roman", Times, serif; 
         color: black; 
         
         }  
         .mytable td, th 
         { 
         padding: 1px 1px .25em 1px; 
         line-height: 1em; 
         border: 3px solid #839E99; 
         border-color: skyblue;
         unicode-bidi: bidi-override;
         background:white;
		 resize: both;
		 overflow: auto;
         text-align: left;
         }  
         .mytable th 
         { 
         color:Blue; font-weight: bold; 
         text-align: center; 
         padding-right: .5em; 
         vertical-align: top;
         white-space:nowrap;
         }  
         .mytable thead th 
         { 
         text-align: center; 
         padding-left:0.1cm;
         padding-right:0.1cm;
         unicode-bidi:bidi-override;
         overflow:scroll;
         
        }  
		
		.error
		{
		 color: red;
		}
		
         
        </style>
</head>

<body>
	
	<p>
	   <form:form action="action.do" method="post" commandName="employee">
			<table align="center" border="2" bgcolor="pink">

				<tr>
					<td>Employee ID :</td>
					<td><form:input path="empId" /></td>
					<!-- readonly="true" disabled="true"  -->
				</tr>

				<tr>
					<td>Employee Name :</td>
					<td><form:input path="empName" /></td>
				</tr>
				<tr>
					<td>Company Name :</td>
					<td><form:input path="companyName" /></td>
				</tr>
				<tr>
					<td>Joining Date:</td>
					<td><form:input path="joiningDate" /></td>
				</tr>
				<tr>
					<td>Mobile Number :</td>
					<td><form:input path="mobileNumber" /></td>
				</tr>
				<tr>
					<td>Email ID :</td>
					<td><form:input path="emailId" /></td>
				</tr>
				<tr>
					<td>Address :</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="myAction" value="add" /> <input type="submit"
						name="myAction" value="update" /> <input type="submit"
						name="myAction" value="delete" /> <input type="submit"
						name="myAction" value="search" /></td>
				</tr>
			</table>
		</form:form>
	</p>
	
	<p>
	   <center> <label class="error">${message}</label> </center>   
	<h3 align="center">List Of Students</h3>
	<c:if test="${!empty employeeList}">

		<table align="center" border="2" bgcolor="pink" class="mytable">
			<tr>
				<th>EMPLOYEE ID</th>
				<th>EMPLOYEE NAME</th>
				<th>JOINING DATE</th>
				<th>CONATCT NUMBER</th>
				<th>EMAILID</th>
				<th>ADDRESS</th>
			</tr>
			<c:forEach items="${employeeList}" var="employee">
				<tr>
					<td>${employee.empId}</td>
					<td>${employee.empName}</td>
					<td>${employee.joiningDate}</td>
					<td>${employee.mobileNumber}</td>
					<td>${employee.emailId}</td>
					<td>${employee.address}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</p>
</body>
</html>
