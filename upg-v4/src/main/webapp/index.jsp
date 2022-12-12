	<jsp:include page="top.jsp"></jsp:include>

<body>
<!-- Navigation form -->
<jsp:include page="form.jsp"></jsp:include>
<!-- Navigation form END-->


<!-- if error, prints out error message -->
<% 
if(request.getParameter("err") != null){
	if(request.getParameter("err").equals("logIn")){
		out.print("<h2 class=\"center\">Please enter your credentials!</h2>");
		
	}else if(request.getParameter("err").equals("invalid")){
		out.print("<h2 class=\"center\">Invalid username or password</h2>");
		
	}else if(request.getParameter("err").equals("noUser")){
		out.print("<h2 class=\"center\">Can not display user site when no user is logged in</h2>");
	}else if(request.getParameter("err").equals("logOut")){
		out.print("<h2 class=\"center\">You have been logged out</h2>");
	}else if(request.getParameter("err").equals("noLogOut")){
		out.print("<h2 class=\"center\">You can not log out if you have not logged in...</h2>");
	}
	
}

%>
<!-- if error,  prints out error message END-->

<div class="div">

<!-- Log in form -->
<form action="<%=request.getContextPath()%>/Controller" method="post" class="form">

<label for="usrName">Username:</label>
<input type="text" required placeholder="username here" name="usrName">



<label for="password">Password:</label>
<input type="password" required  placeholder="password here" name="password">



<button type="submit">Log In</button>


</form>
</div>

<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>