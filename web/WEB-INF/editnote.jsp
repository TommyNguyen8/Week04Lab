<%-- 
    Document   : editnote.jsp
    Created on : Sep 28, 2020, 2:38:07 PM
    Author     : 791662
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <b>Title:</b>
            <input type="text" name="title" value="${note.title}"><br>
            <b>Content:</b>
            <textarea rows="6" cols="20" name="content" >${note.content}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
