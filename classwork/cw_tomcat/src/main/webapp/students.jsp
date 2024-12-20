<%--
  Created by IntelliJ IDEA.
  User: neste
  Date: 17.12.2024
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cerlace.dto.StudentDTO" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Students</h2>
<%= request.getAttribute("students")%>
<table>

    <% List<StudentDTO> studentDTOs = (List<StudentDTO>) request.getAttribute("students");
        for (StudentDTO studentDTO : studentDTOs) {
    %>
    <tr>
        <td><%= studentDTO.getName() %>
        </td>
        <td><%= studentDTO.getAge() %>
        </td>
        <td><%= studentDTO.getMark() %>
        </td>
        <td>
            <form name="test" method="post" action="info">
                <input name="id" type="hidden" value="<%= studentDTO.getId()%>">
                <input name="action" type="hidden" value="delete">
                <button>delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
