<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 07/09/2018
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Supervisor</title>
    <%@include file="../resources.jsp"%>
</head>
<body>
<div class="navbar navbar-fixed-left" style="background-color: #009688;">
    <a href="#" data-toggle="modal" data-target="#supervisorModal" class="btn btn-info" role ="button"style="width:150px;margin-left: 80%;margin-top:40px;">Add New Supervisor</a>

    <h2 style="text-align: center; color: white">DWIT Projects</h2>
    <%--<div class="form-group">--%>
    <%--<button type="submit" class="btn btn-info form-control" style="width: 90px;margin-left: 90%"> Login</button>--%>
    <%--</div>--%>

</div>


<div class="container" style="margin-top: 12%">


    <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Supervisor Name</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${supervisorList}" var="supervisor">

                <tr>
                    <td>${supervisor.name}</td>
                    <td>
                        <a href="/supervisor?action=delete&id=${supervisor.id}"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></a>
                        <a href="/supervisor?action=edit&id=${supervisor.id}"><button class="btn btn-success"><span class="glyphicon glyphicon-edit"></span></button></a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

</div>

<div id="supervisorModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add New Supervisor</h4>
            </div>
            <div class="modal-body">

                <form action="/supervisor" method="post">
                    <input type="hidden" value="add" name="action">
                    <div class="form-group">
                        <label for="sname">Supervisor Name:</label>
                        <input type="text" class="form-control" id="sname" name="sname">
                    </div>

                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<%@include file="../footer.jsp"%>
</body>
</html>
