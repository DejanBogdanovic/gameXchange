<%@ include file="header.jspf"%>
<script type="text/javascript">
function checkPassword()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('userPassword');
    var pass2 = document.getElementById('userpasswordrepeat');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(pass1.value == pass2.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
        document.getElementById("btn btn-lg btn-primary btn-block").disabled = false;
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
        document.getElementById("btn btn-lg btn-primary btn-block").disabled = true;
	}
}  
</script>

<div class="container">

	<form action="register" method="post" class="form-signin">
		<h2 class="form-signin-heading">Login informations</h2>
		<div class="form-group">
        	<label for="useremail">Email address</label>
        	<input type="email" class="form-control" id="userEmail" name="userEmail" required>
        </div>
                           
        <div class="row">
        	<div class="col-md-6">
        		<div class="form-group">
        			<label for="userpassword">Password</label>
        			<input type="password" class="form-control" id="userPassword" name="userPassword" required>
        		</div> 
        	</div>
        	<div class="col-md-6">
       			<div class="form-group">
        			<label for="userpasswordrepeat">Repeat password</label>
        			<input type="password" class="form-control" id="userpasswordrepeat" name="userpasswordrepeat" onkeyup="checkPassword();" required>
					<span id="confirmMessage" class="inputPasswordRepeat"></span>
        		</div>
        	</div>
        </div>
		
		<h2 class="form-signin-heading">Personal informations</h2>

		<div class="form-group">
			<label for="name">Name</label>
			<input type="text" name="name" class="form-control" required>
			<label for="lastname">Lastname</label>
			<input type="text" name="lastname" class="form-control" required>
			<label for="userName">Username</label>
			<input type="text" name="userName" class="form-control" required>
			<label for="dateOfBirth">Date of birth</label>
			<input type="date" name="dateOfBirth" class="form-control" required>
			<div class="row">
				<div class="col-md-8">
					<div class="form-group">
						<label for="domicile">Domicile</label>
						<input type="text" name="domicile" class="form-control" required>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="postcode">Postcode</label>
						<input type="number" name="postcode" class="form-control" required>
					</div>
				</div>
			</div>
			<label for="country">Country</label>
			<input type="text" name="country" class="form-control" required>
		</div>

		<button id ="btn btn-lg btn-primary btn-block" class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
	</form>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript -->
<%@ include file="footer.jspf"%>