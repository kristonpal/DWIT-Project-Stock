<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 07/09/2018
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Supervisor</title>
    <%@include file="../resources.jsp"%>
</head>
<body>
<%@include file="../header.jsp"%>

<div class="container" style="margin-top: 12%">

    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
        <%@include file="../sidebar.jsp"%>
    </div>

    <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
        <form action="/supervisor" method="post">
            <input type="hidden" value="update" name="action">
            <input type="hidden" value="${supervisor.id}" name="id">
            <div class="form-group">
                <label for="sname">Supervisor Name:</label>
                <input type="text" class="form-control" id="sname" name="sname" value="${supervisor.name}">
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

</div>

<%@include file="../footer.jsp"%>

</body>
</html>
