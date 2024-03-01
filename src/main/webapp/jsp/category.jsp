<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 27/08/2018
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<div class="navbar navbar-fixed-left" style="background-color: #009688;">
    <a href="#" data-toggle="modal" data-target="#categoryModal" class="btn btn-info" role ="button"style="width:150px;margin-left: 80%;margin-top:40px;">Add
        New Category</a>

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
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${categoryList}" var="category">

            <tr>
                <td>${category.name}</td>
                <td>
                    <a href="/category?action=delete&id=${category.id}"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></a>
                    <a href="/category?action=edit&id=${category.id}"><button class="btn btn-success"><span class="glyphicon glyphicon-edit"></span></button></a>
                </td>
            </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

</div>

            <div id="categoryModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Add New Project Category</h4>
                        </div>
                        <div class="modal-body">

                            <form action="/category" method="post">
                                <input type="hidden" value="add" name="action">
                                <div class="form-group">
                                    <label for="cname">Category Name:</label>
                                    <input type="text" class="form-control" id="cname" name="cname">
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

    <%@include file="footer.jsp"%>
</body>
</html>
