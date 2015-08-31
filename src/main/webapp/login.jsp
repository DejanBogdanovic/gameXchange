<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="header.jspf"%>

<div class="container">
	
	<%
	if(request.getAttribute("errorLogin") != null) {
	%>
	<div class="alert alert-danger">
	<p>
		<%= request.getAttribute("errorLogin") %>
	</p>
	</div>
	<% 	
	} 
	%>
	<form action="login" method="post" class="form-signin">
		<h2 class="form-signin-heading">Please sign in</h2>
		<label for="inputEmail" class="sr-only">Email address</label> 
		<input type="email" name="userEmail" id="inputEmail" class="form-control" placeholder="Email address" required autofocus> 
		<label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" name="userPassword" id="inputPassword" class="form-control" placeholder="Password" required>
		<div class="checkbox">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	in</button>
	</form>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript -->
<%@ include file="footer.jspf"%>