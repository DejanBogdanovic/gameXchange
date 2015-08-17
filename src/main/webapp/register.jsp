<%@ include file="header.jspf"%>

<div class="container">

	<form action="register" method="post" class="form-signin">
		<h2 class="form-signin-heading">Please register</h2>
		<label for="inputName" class="sr-only">Name</label> 
		<input type="text" name="name" id="inputName" class="form-control" placeholder="Name" required autofocus> 
		<label for="inputSurname" class="sr-only">Surname</label> 
		<input type="text" name="surname" id="inputSurname" class="form-control" placeholder="Surname" required> 
		<label for="inputUsername" class="sr-only">Username</label> 
		<input type="text" name="userName" id="userName" class="form-control" placeholder="Username" required>
		<label for="inputEmail" class="sr-only">Email address</label> 
		<input type="email" name="userEmail" id="inputEmail" class="form-control" placeholder="Email address" required> 
		<label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" name="userPassword" id="inputPassword" class="form-control" placeholder="Password" required> 
		<label for="inputPasswordRepeat" class="sr-only">Password repeat</label> 
		<input type="password" name="userpasswordrepeat" id="inputPasswordRepeat" class="form-control" placeholder="Password repeat" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
	</form>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript -->
<%@ include file="footer.jspf"%>