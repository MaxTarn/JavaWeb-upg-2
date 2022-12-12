<jsp:include page="top.jsp"></jsp:include>

<body>
<jsp:include page="form.jsp"></jsp:include>
<%! String usrNumber; %>
<%! String usrName;%>
<%! String messege;%>



<div class="userDisplay-main-div">
<div class="userDisplay-top-div">
<%
if(session.getAttribute("usrName") != null && session.getAttribute("messege") != null){	
	usrName = session.getAttribute("usrName").toString();
	messege = session.getAttribute("messege").toString();
	out.print("<h1>Welcome " + usrName + "</h1>");
	out.print("<h3>Log In comment: " + messege + "</h3>");
	out.print("");
}else{
	response.sendRedirect(request.getContextPath()+ "/index.jsp?err=noUser");
}

out.print("<h3>Messege bound to the user logged in: </h3>");
if(session.getAttribute("usrMessege") != null){
	String usrMessege = session.getAttribute("usrMessege").toString();
	out.print("<h5>" + usrMessege + "</h5>");
	System.out.print(usrMessege);
}

%>





<% String text = "Your temporary text will be here:"; 
out.print("<h3>"+ text +  "</h3>");

if(request.getParameter("text") != null){
	String sentText = request.getParameter("text");
	out.print("<h5>" + sentText + "</h5>");
}

%>


</div>

<div class="userDisplay-div">
<form action="userDisplay.jsp?" method="get" class="userDisplay-form">

<label for="text">Temporary text:</label>
<input type="text" placeholder="type here" name="text">

<button type="submit">Send</button>

</form>
</div>

<div class="userDisplay-div">
<form action="<%=request.getContextPath()%>/Controller" method="post" class="userDisplay-form">

<label for="usrMessege">Add text to user:</label>
<input type="text" name="usrMessege" required>

<button type="submit">Add</button>
</form>
</div>


</div>
<jsp:include page="footer.jsp"></jsp:include>





</body>
</html>