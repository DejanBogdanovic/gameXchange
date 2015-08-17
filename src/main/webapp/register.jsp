<%@ include file="header.jspf"%>
<script type="text/javascript">
function checkPassword()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('inputPassword');
    var pass2 = document.getElementById('inputPasswordRepeat');
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
		<h2 class="form-signin-heading">Please register</h2>
		<input type="text" name="name" id="inputName" class="form-control" placeholder="Name" required autofocus>
		<input type="text" name="surname" id="inputSurname" class="form-control" placeholder="Surname" required>
		<input type="text" name="userName" id="userName" class="form-control" placeholder="Username" required>
		<input type="email" name="userEmail" id="inputEmail" class="form-control" placeholder="Email address" required>
		<input type="password" name="userPassword" id="inputPassword" class="form-control" placeholder="Password" required>
		<input type="password" name="userpasswordrepeat" id="inputPasswordRepeat" onkeyup="checkPassword(); return false;" class="form-control" placeholder="Password repeat" required>
		<span id="confirmMessage" class="inputPasswordRepeat"></span>
		<button id ="btn btn-lg btn-primary btn-block" class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
	</form>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript -->
<%@ include file="footer.jspf"%>