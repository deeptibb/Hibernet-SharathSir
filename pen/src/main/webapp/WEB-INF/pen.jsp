<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pen Details</title>
</head>
<body>
	
	<form action="saveValuesFromPage.do">

		<div class="center">
			<h1>*****Welcome To PenDetails*****</h1>
			<p>
				<span style="color: brown; font-weight: bolder">*****Welcome
					To PenDetails*****</span>
			</p>

			<span>Pen Name:</span> <input type="text" name="penName" value="${PenName}"
				placeholder="Enter the pen name">
			<p style="color: purple">${errorName }</p>

			<span>Pen Color:</span> <input type="text" name="penColor" value="${PenColor}"  
				placeholder="Enter the pen color">
			<p style="color: purple">${errorColor}</p>


			<span>Pen Price:</span> <input type="text" name="penPrice" value="${PenPrice}"
				placeholder="Enter the pen price">
			<p style="color: purple">${errorPrice}</p>
			<input type="submit" value="click">
</div>
	</form>
	<h2>
		<center>Find Out The Pen</center>
	</h2>
	
	<form action="searchPenByName.do">
		<label><b>Pen Name</b></label>
		<p style="color: blue">${ErrorPenName}</p>
		<input type="text" name="name" placeholder="Enter Name"> <input
			type="submit" value="Search">
	</form> 
	<p>searchPenByName.do---------------------------------</p>
	<ol>
		<li>${PenName}</li>
		<li>${PenColor}</li>
		<li>${PenPrice}</li>
	</ol>
	<form action="deletePenByName.do">
		<label><b>Pen Name</b></label>
		<p style="color: blue">${ErrorPenName}</p>
		<input type="text" name="name" placeholder="Enter Name"> <input
			type="submit" value="Delete">
	</form>

	
	
	<form action="searchPenByName.do">
		<label><b>Pen Name</b></label>
		<p style="color: blue">${ErrorPenName}</p>
<pre>
		name: <input type="text" name="penName" value="${PenName}"> 
		
		color:	<input type="text" name="penColor" value="${PenColor}">
		
		price:	<input type="text" name="penPrice" value="${PenPrice}">
		
		<input type="text" name="name" placeholder="Enter Name"> <input
			type="submit" value="Update">
			</pre>
	</form>
	
	<a href="updatePenByName.do"><button >UPDATE</button></a>


<a href="getAllPenDetails.do"><button class="button">GetAllPens</button></a>

	

	<h1>Pen details by getallPenDetails</h1>
	<br>

	<table border="5" cellpading="5" cellpading="5">
		<tr>
			<!-- table heading -->
			<th>PENNAME</th>
			<th>PENCOLOR</th>
			<th>PENPRICE</th>
		</tr>
		<tr>
			<td>${PenName}</td>
			<td>${PenColor}</td>
			<td>${PenPrice}</td>

		</tr>

		<c:forEach items="${getAllPenDetails}" var="p">

			<tr>
				<td>${p.penName}</td>
				<td>${p.penColor}</td>
				<td>${p.penPrice}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>

