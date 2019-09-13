<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div  style=" height: 40px; color: #ebecee; ">
  <div style="float: left; font-size: 30px; uppercase; color: rgba(253, 253, 253, 0.9);	font-weight: 700;">
    <a href="index.jsp">Home</a>
  </div>
 
  <div style="float: right; ">
 
     <!-- User store in session with attribute: loginedUser -->
     Hello <b>${loginedUser.userName}</b>
   <br/>
     Search <input name="search">
 
  </div>
 
</div>