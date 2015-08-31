<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="ch.bbcag.gamexchange.lowlevel.model.User"%>
<%@ include file="header.jspf"%>

<div class="container">

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron">
		<h1>Edit your profile</h1>
		<%
			User user = (User) session.getAttribute("user");
		%>
		<div id="picture">
			<img src="default.jpg" alt="Profile Picture">
		</div>
			
		<form action="editProfile" method="post">
			<h2 class="form-signin-heading">Login informations</h2>
			<div class="form-group">
        		<label for="useremail">Email address</label>
        		<input type="email" class="form-control" id="userEmail" name="userEmail" value="<%=user.getUserEmail()%>" required>
        	</div>
		
			<h2 class="form-signin-heading">Personal informations</h2>

			<div class="form-group">
				<label for="name">Name</label>
				<input type="text" name="name" class="form-control" value="<%=user.getName()%>" required>
				<label for="lastname">Lastname</label>
				<input type="text" name="lastname" class="form-control" value="<%=user.getLastname()%>" required>
				<label for="userName">Username</label>
				<input type="text" name="userName" class="form-control" value="<%=user.getUserName()%>" required>
				<div class="row">
					<div class="col-md-8">
						<div class="form-group">
							<label for="domicile">Domicile</label>
							<input type="text" name="domicile" class="form-control" value="<%=user.getDomicile()%>" required>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="postcode">Postcode</label>
							<input type="number" name="postcode" class="form-control" value="<%=user.getPostcode()%>" required>
						</div>
					</div>
				</div>
				<label for="country">Country</label>
				<input type="text" name="country" class="form-control" value="<%=user.getCountry()%>" required>
			</div>
		
			<button class="btn btn-primary btn-right" type="submit">Save changes</button>		
		</form>
	</div>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript -->
<%@ include file="footer.jspf"%>