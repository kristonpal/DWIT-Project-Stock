
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <%@include file="resources.jsp"%>
</head>
<body>

<div class="navbar navbar-fixed-left" style="background-color: #009688;">

    <h2 style="text-align: center; color: white">DWIT Projects</h2>

</div>


    <div class="container" style="margin-top: 12%">




        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
            <%@include file="sidebar.jsp"%>
        </div>

        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${userList}" var="user">

                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.username}</td>
                    <td>${user.role}</td>
                    <td>
                        <a href="/user?action=delete&id=${user.id}"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></a>
                        <a href="/user?action=edit&id=${user.id}"><button class="btn btn-success"><span class="glyphicon glyphicon-edit"></span></button></a>
                    </td>
                </tr>
                </c:forEach>
                <tbody>

                </tbody>
            </table>
        </div>

    </div>

    <!-- Modal -->
    <div id="userModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">New User</h4>
                </div>
                <div class="modal-body">

                    <form action="/user" method="post">
                        <input type="hidden" value="add" name="action">
                        <div class="form-group">
                            <label for="fname">First Name:</label>
                            <input type="text" class="form-control" id="fname" name="fname">
                        </div>

                        <div class="form-group">
                            <label for="lname">Last Name:</label>
                            <input type="text" class="form-control" id="lname" name="lname">
                        </div>

                        <div class="form-group">
                            <label for="username">User Name:</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>

                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="password">
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
        </div>
    </div>

  <%@include file="footer.jsp"%>
</body>
</html>
