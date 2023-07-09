<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        	<style>
		body {
			font-family: 'Open Sans', sans-serif;
			background-color: #f9f9f9;
		}
		h1 {
			font-weight: 300;
			text-align: center;
			margin-top: 50px;
			margin-bottom: 30px;
			color: #555;
		}
		table {
			background-color: #fff;
			border-collapse: collapse;
			width: 80%;
			margin: auto;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			border-radius: 5px;
			overflow: hidden;
			position: relative;
		}
		th, td {
			padding: 10px;
			text-align: left;
		}
		th {
			background-color: #4CAF50;
			color: #fff;
		}
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
		.btn {
			display: inline-block;
			padding: 8px 12px;
			font-size: 14px;
			font-weight: 700;
			text-transform: uppercase;
			color: #fff;
			background-color: #2196F3;
			border-radius: 5px;
			text-decoration: none;
			margin-right: 10px;
			margin-top: 10px;
			transition: background-color 0.3s ease;
		}
		.btn:hover {
			background-color: #0D47A1;
			cursor: pointer;
		}
	</style>
    </head>
    <body>
        <h1 align="center">
            Welcome, ${name}
        </h1>
        <h2 align="center">
            Vote Any One Here,
        </h2>
        <h3 align="center">
            Nominees
        </h3>
	<table>
		<thead>
                    <tr>
                        <th>Nominee ID</th>
                        <th>Nominne Name</th>
                        <th>Slogan</th>
                        <th></th>
                    </tr>
		</thead>
		<tbody>
                    <c:forEach var="nominees" items="${nominees}">
                        <tr>
                            <td>${nominees.getId()}</td>
                            <td>${nominees.getName()}</td>
                            <td>${nominees.getSlogan()}</td>
                            <td>
                                    <form action="AddVoteServlet">
                                        <input type="hidden" name="nominee_id" value="${nominees.getId()}">
                                        <input type="hidden" name="voter_id" value="${name}">
                                        <button type="submit" class="btn">Vote</button>
                                    </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
    </body>
</html>
