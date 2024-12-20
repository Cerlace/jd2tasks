<html>
<body>
<h2>Hello World!</h2>
<%= request.getAttribute("newFio")%>
<%= session.getAttribute("fioage")%>

<a href="info?fio=Vasya&age=25">Info Servlet</a>

<form name="test" method="post" action="info">
    <input name="id" type="hidden" value="">
    Fill fio: <input name="fio" type="text"> <br/>
    Fill age: <input name="age" type="text"> <br/>
    Fill mark: <input name="mark" type="text"> <br/>
    <input name="browser" type="radio" value="IE"> Ie <br/>
    <button>Send</button>
</form>

</body>
</html>
