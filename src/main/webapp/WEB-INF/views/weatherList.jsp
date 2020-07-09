<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employees List</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
        form {
            display: inline-block;
         }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-body">
            <form action="search">
                  <input type='text' name='searchName' id='searchName' placeholder="Search..."/>
                  <input class="btn btn-success" type='submit' value='Search'/>
            </form>
            <form action="list">
                  <input class="btn btn-primary" type='submit' value='Refresh'/>
             </form>


                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>City</th>
                        <th>Temperature</th>
                        <th>Weather</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${weatherList}" var="weather">
                        <tr>
                        	<th><c:out value="${weather.city}"/></th>
                        	<th><c:out value="${weather.temperature}"/></th>
                        	<th><c:out value="${weather.weather}"/></th>
                        	<th><a href="delete?id=<c:out value='${weather.id}'/>">Delete</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>