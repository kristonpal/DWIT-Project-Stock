<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <%@include file="resources.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>

<div class="container" style="margin-top: 12%">
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>

    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
        <fieldset>
            <legend style="text-align: center">Login </legend>
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="username">username</label>
                    <input type="text" class="form-control" name="username" id="username">
                </div>

                <div class="form-group">
                    <label for="password">password</label>
                    <input type="password" class="form-control" name="password" id="password">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary form-control">Submit</button>
                </div>

                <div>
                    hello hello
                    ${message}
                </div>



            </form>
<%--            <form action="/projects" method="post">
                <div class="form-group">
                    <button type="button" class="btn btn-info form-control"><a href="/projects" > Use As a Guest</a></button>
                </div>
            </form>--%>
        </fieldset>
    </div>
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>

<%@include file="footer.jsp" %>
</body>
</html>
