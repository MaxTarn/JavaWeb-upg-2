<div class="div">
<form action="index.jsp" method="get" class="form">
<button type="submit">Go to Index</button>
</form>


<form action="<%=request.getContextPath()%>/Controller" method="get" class="form">
<button type="submit">Go to Controller</button>
</form>


<form action="userDisplay.jsp" method="get" class="form">
<button type="submit">Go to UserDisplay</button>
</form>


<form action="<%=request.getContextPath()%>/LogOut" method="post" class="form">
<button type="submit">Log out</button>
</form>
</div>
