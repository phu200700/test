<%-- 
    Document   : index
    Created on : Jan 28, 2019, 10:41:09 AM
    Author     : QuangPhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="home/apply.htm" method="post" enctype="multipart/form-data">
            ${message}
            <img src="images/${photo_name}">
            <input type="file" name="photo">
            <div class="form-group">
                <button>Nộp</button>
            </div>
        </form>
    </body>
</html>
