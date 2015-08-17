<%@ include file="header.jspf"%>

<div class="container">

	<form class="form-sell" action="sell" method="post" enctype="multipart/form-data">
  		<div class="form-group">
    		<label for="title">Titel</label>
    		<input type="text" class="form-control" id="title" 
				name="title" maxlength="40" required="required">
  		</div>
  		<div class="form-group">
    		<label for="description">Description</label>
    		<textarea id="description" class="form-control" name="description" 
             		 rows="10" cols="100" maxlength="1000">
            </textarea>
  		</div>
  		<div class="form-group">
    		<label for="price">Price</label>
    		<input type="number" class="form-control" id="price" name="price" required="required">
  		</div>
 		<div class="form-group">
    		<label for="foto">Picture</label>
    		<input type="file" class="form-control" id="foto" name="foto">
  		</div>
  		<button type="submit" class="btn btn-default">Tauschen</button>
	</form>

</div> <!-- /container -->

<!-- Bootstrap core JavaScript -->
<%@ include file="footer.jspf"%>