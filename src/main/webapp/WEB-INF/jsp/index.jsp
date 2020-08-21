<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>

<form method="post" enctype="multipart/form-data" action="/upload">
    Files To Upload: <input type="file" name="file"> <br />
    Name: <input type="text" name="name"><br/><br/>
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
<br/>
<%--<a href="<c:url value='/download/int'/>">${listValue}</a>--%>
<br/>
<table>
    <tr>
        <th>File list</th>
    </tr>
    <c:forEach var="listValue" items="${files}">
        <tr>
            <td><a href="<c:url value='/download/${listValue}'/>">${listValue}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
