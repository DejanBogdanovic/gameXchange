<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="ch.bbcag.gamexchange.lowlevel.model.User"%>
<%@ include file="header.jspf"%>

<div class="container">

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron">
		<%
			User user = (User) session.getAttribute("user");
		%>
		<div id="picture">
			<img src="default.jpg" alt="Profile Picture"><h2><%out.println(user.getLastname() + " "+ user.getName()); %></h2>
		</div>
			
		<table id="profile-details">
			<tr>
				<td>Username</td>
				<td><%=user.getUserName() %></td>
			</tr>
			<tr>
				<td>Current balance</td>
				<td><%=user.getBalance() %></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><%=user.getDateOfBirth() %></td>
			</tr>
			<tr>
				<td>Domicile</td>
				<td><%=user.getDomicile() %></td>
			</tr>
			<tr>
				<td>Postcode</td>
				<td><%=user.getPostcode() %></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><%=user.getCountry() %></td>
			</tr>
		</table>
	</div>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript -->
<%@ include file="footer.jspf"%>