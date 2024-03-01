<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 5/19/18
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <%@include file="../resources.jsp" %>
    <style>

        tr {
            height: 50px;
        }
        th{
            background-color:#E6E6FA;
        }

        projectTable{
        @media (min-width: 992px)
                float: unset;
        }

    </style>
    <%
        Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/microproject?user=root&password=");

        Statement statement = connection.createStatement() ;
    %>
</head>
<body>
<div clss="container">
    <div class="navbar navbar-fixed-left" style="background-color: #009688;">

        <h2 style="text-align: center; color: white">DWIT Projects</h2>


        <form action="/jsp/index.jsp">
            <c:if test="${sessionScope.username != null}">
                <div id="emptydiv" style="height: 5%;">

                </div>
            </c:if>
            <c:if test="${sessionScope.username == null}">
                <div class="form-group">
                    <button type="submit" class="btn btn-info form-control" style="width: 90px;margin-left: 90%"> Login</button>
                </div>

            </c:if>


            <c:if test="${sessionScope.username != null}">
                <a href="#" data-toggle="modal" data-target="#projectModal" class="btn btn-info" role ="button"style="align:right">Add New Project</a>
            </c:if>
            <c:if test="${sessionScope.username == null}">
                <div id="emptydiv" style="height: 5%;">

                </div>
            </c:if>
        </form>


    </div>


        <div class="table-responsive">
            <div class="row" style="width: auto">
                <div class="col-md-12">
                    <table class="table" id="projectTable" cellpadding="0" cellspacing="0" border="0">
                        <thead>
                        <tr>
                            <th>Roll Number</th>
                            <th>Student Name</th>
                            <th>Project Year</th>
                            <th>Semester</th>
                            <th>Project Category</th>
                            <%--<th>Filename</th>--%>
                            <th>Project Title</th>
                            <th>Tags</th>
                            <th>Project Supervisor</th>
                            <th>Project Domain</th>
                            <th>Project Abstract</th>
                            <th>Download</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${projects}" var="project">

                            <tr>
                                <td>${project.roll}</td>
                                <td>${project.name}</td>
                                <td>${project.year}</td>
                                <td>${project.semester}</td>
                                <td>${project.category}</td>
                                <%--<td>${project.filename}</td>--%>
                                <td>${project.title}</td>
                                <td>${project.tags}</td>
                                <td>${project.supervisor}</td>
                                <td>${project.domain}</td>

                                <td>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#abstractModal"
                                            data-abstract=${project.id}>View Abstract
                                    </button>
                                </td>
                                    <%--<td><a href="#" data-toggle="modal" data-target="#abstractModal" id="viewAbstract" data-abstract-id=${project.id}>View Abatract</a></td>--%>
                                <td><a href="/downloadfile?id=${project.getId()}">Download</a></td>
                                    <%--<td>
                                        <a href="/user?action=delete&id=${user.id}"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></a>
                                        <a href="/user?action=edit&id=${user.id}"><button class="btn btn-success"><span class="glyphicon glyphicon-edit"></span></button></a>
                                    </td>--%>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <%--<tfoot>--%>

                        <%--<tr>--%>
                        <%--<th>Name</th>--%>
                        <%--<th>Title</th>--%>
                        <%--<th>Category</th>--%>
                        <%--<th>Advisers</th>--%>
                        <%--<th>File Name</th>--%>
                        <%--<th>Tags</th>--%>
                        <%--<th>Abstract</th>--%>
                        <%--<th>Download</th>--%>
                        <%--</tr>--%>

                        <%--</tfoot>--%>
                    </table>

                </div>
            </div>
        </div>
</div>
<!-- Modal -->
<div id="projectModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body">

                <form action="/addProject" method="post" enctype="multipart/form-data">
                    <input type="hidden" value="add" name="action">
                    <div class="form-group">
                        <label for="proll">Roll:</label>
                        <input type="text" class="form-control" id="proll" name="proll" placeholder="Enter Roll num...">
                    </div>

                    <div class="form-group">
                        <label for="pname">Name:</label>
                        <input type="text" class="form-control" id="pname" name="pname" placeholder="Enter Name...">
                    </div>

                    <div class="form-group">
                        <label for="pyear">Year:</label>
                        <input type="text" class="form-control" id="pyear" name="pyear" placeholder="Enter Year...">
                    </div>

                    <div class="form-group">
                        <label for="psemester">Semester:</label>
                        <input type="text" class="form-control" id="psemester" name="psemester" placeholder="Enter Semester...">
                    </div>


                    <div class="form-group">
                        <%

                                resultset =statement.executeQuery("select * from category") ;
                        %>
                        <label for="pcategory">Category:</label>
                        <select name="pcategory" class="form-control" id="pcategory">
                            <%  while(resultset.next()){ %>
                            <option><%= resultset.getString(2)%></option>
                            <% } %>
                        </select>
                    </div>

                    <%--<div class="form-group">--%>
                        <%--<label for="pfilename">FileName:</label>--%>
                        <%--<input type="text" class="form-control" id="pfilename" name="pfilename" ,--%>
                               <%--placeholder="Uploade File name">--%>
                    <%--</div>--%>

                    <div class="form-group">
                        <label for="ptitle">Title:</label>
                        <input type="text" class="form-control" id="ptitle" name="ptitle"
                               placeholder="Enter the title...">
                    </div>


                    <div class="form-group">
                        <label for="ptags">Tags:</label>
                        <input type="text" class="form-control" id="ptags" name="ptags"
                               placeholder="Comma separated tags">
                    </div>

                    <div class="form-group">
                        <%
                            try{

                                resultset =statement.executeQuery("select * from supervisor") ;
                        %>
                        <label for="psupervisor">Supervisor:</label>
                             <select name="psupervisor"  class="form-control" id="psupervisor">
                                 <%  while(resultset.next()){ %>
                                 <option><%= resultset.getString(2)%></option>
                                 <% } %>
                             </select>

                         <%
                                 //**Should I input the codes here?**
                             }
                             catch(Exception e)
                             {
                                 out.println("wrong entry"+e);
                             }
                         %>
                         <%--<label for="psupervisor">Supervisor:</label>--%>
                        <%--<input type="text" class="form-control" id="psupervisor" name="psupervisor"--%>
                               <%--placeholder="Name of Supervisor">--%>
                    </div>


                    <div class="form-group">
                        <%

                            resultset =statement.executeQuery("select * from domain") ;
                        %>
                        <label for="pdomain">Project Domain:</label>
                        <select name="pdomain" class="form-control" id="pdomain">
                            <%  while(resultset.next()){ %>
                            <option><%= resultset.getString(2)%></option>
                            <% } %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="pabstraction">Abstraction </label>
                        <textarea rows="4" cols="50"
                                  class="form-control" id="pabstraction" name="pabstraction"
                                  placeholder="Enter the project Abstraction here ..."></textarea>
                    </div>

                    <div class="form-group">
                        <input type="file" required="required" name="image" id="image" placeholder="File">
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

<div id="abstractModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Abstract</h4>
            </div>
            <div class="modal-body">
                <p></p>

                <%--                        <form>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">Message:</label>
                                                <textarea class="form-control" id="message-text"></textarea>
                                            </div>
                                        </form>--%>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<%@include file="../footer.jsp" %>
</body>

<script>
    $(document).ready(function () {
        // alert("hello world")

        $('#projectTable').DataTable();

        $('#abstractModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Button that triggered the modal
            var id = button.data('abstract') // Extract info from data-* attributes
            // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).


            function testAjax(id) {
                var result = "";
                $.ajax({
                    url: "/api/projects?id=" + id,
                    async: false,
                    success: function (data) {
                        result = data;
                    }
                });
                return result;
            }

            var result = testAjax(id)

            var modal = $(this)
            console.log(result)
            modal.find('.modal-title').text('New message to ')
            modal.find('.modal-body p').text(result.abstraction)


        })

    });

</script>
</html>
