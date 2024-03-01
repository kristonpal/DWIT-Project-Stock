
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <%@include file="resources.jsp"%>
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="container" style="margin-top: 12%">

        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
            <%@include file="sidebar.jsp"%>
        </div>

        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <form action="/user" method="post">
                <input type="hidden" value="update" name="action">
                <input type="hidden" value="${user.id}" name="id">
                <div class="form-group">
                    <label for="fname">First Name:</label>
                    <input type="text" class="form-control" id="fname" name="fname" value="${user.firstName}">
                </div>

                <div class="form-group">
                    <label for="lname">Last Name:</label>
                    <input type="text" class="form-control" id="lname" name="lname" value="${user.lastName}">
                </div>

                <div class="form-group">
                    <label for="username">User Name:</label>
                    <input type="text" class="form-control" id="username" name="username" value="${user.username}">
                </div>

                <div class="form-group">
                    <label for="role">Role:</label>
                    <select class="form-control" id="role" name="role">
                        <option value="admin">admin</option>
                        <option value="staff">staff</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>

    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
