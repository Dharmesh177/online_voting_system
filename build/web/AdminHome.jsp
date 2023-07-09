<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            body {
			background-color: #f1f1f1;
			font-family: Arial, sans-serif;
		}
		h1 {
			text-align: center;
			margin-top: 50px;
		}
		.container {
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: center;
			margin-top: 50px;
		}
		.btn {
			background-color: #4CAF50;
			color: white;
			padding: 14px 20px;
			border: none;
			cursor: pointer;
			border-radius: 5px;
			margin: 10px;
			font-size: 20px;
		}
		.btn:hover {
			background-color: #3e8e41;
		}
        </style>
    </head>
    <body>
        <h2 align="center">
            Welcome, ${name}
        </h2>
        <div class="container">
            <a href="AddNominee.html"><button class="btn">Add Nominee</button></a>
            <a href="NomineeListAdmin"><button class="btn">View Nominee</button></a>
            <a href="VotesListAdmin"><button class="btn">View Votes</button></a>
	</div>
    </body>
</html>
