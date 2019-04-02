<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
a { color: #FF0000;}
h2{
color:#008080;
}
p{
color:#008080;
}
body{
background-color:#008080;
}
.w3-container{
 position: fixed;
  height:700px;
}
.tab{
position: relative;
left: 600px;
top: 50px;
}
.tabcontent
{
position: relative;
left: 600px;
top: 50px;
}

.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
.button
{background-color: teal;
 border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>	
<body class="w3-teal" bgcolor="#008080">

<form  modelAttribute="doctor">

  <div class="w3-third">   
        <div class="w3-container" style="background-color:black">
          <h2>${doctor.fname} ${doctor.lname}</h2>
 
          <p><i class="fa fa-id-badge fa-fw w3-margin-right w3-large w3-text-teal"></i>${doctor.id}</p>         
 		  <p><i class="fa fa-flask fa-fw w3-margin-right w3-large w3-text-teal"></i>${doctor.service_id}</p>
          <p><i class="fa fa-clock-o w3-margin-right w3-large w3-text-teal"></i>${doctor.workhours}</p>
          <p><i class="fa fa-stethoscope fa-fw w3-margin-right w3-large w3-text-teal"></i>${doctor.speciality}</p>
          <p><i class="fa fa-graduation-cap fa-fw w3-margin-right w3-large w3-text-teal"></i>${doctor.degree}</p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i>${doctor.email}</p>
          <p><i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal"></i>${doctor.contactno}</p>
           
           <c:url var="sendID" value="/doctor/updateDoctor">
    	   
    	   <c:param name="doctorId" value="${doctor.id}"/>
           </c:url>
           <a href="${sendID}">
           Click
		   </a>
         
</div>

</div>
<div class="tab">

	<c:url var = "view" value="/doctor/viewDoctorRequests">
 	 <c:param name="id" value="${doctor.id}"></c:param>
  `	</c:url>
  
  	<c:url var = "view2" value="/doctor/viewAcceptedRequests">
 	 <c:param name="id" value="${doctor.id}"></c:param>
  `	</c:url>
  
  	<c:url var = "view3" value="/doctor/viewReports">
 	 <c:param name="id" value="${doctor.id}"></c:param>
  `	</c:url>
  
  <button class="tablinks" onclick="window.location.href='#'; return false;">Doctor</button>
  <button class="tablinks" onclick="window.location.href='/demo/service/listServices'; return false;">MedicalServices</button>
  <a href="${view}">Requests</a>
  <a href="${view2}">Appointments</a>
  <a href="${view3}">View Reports</a>
  
  

</div>




<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";




}
</script>
</form>
</body>
</html>
