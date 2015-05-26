<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#main {
	width: 70%;;
	margin-left: auto;
	margin-right: auto;
	background-color: #8ff7cf;
	height: 600px;;
}

#center {
	width: 100%;
	height: 70%;
	float: left;
	clear: none;
	background-color: #98f9f9;
}

#below {
	width: 100%;
	height: 30%;
	float: left;
	clear: none;
}

#below #keyBoard {
	height: 100%;
	width: 30%;
	background-color: white;
	margin-left: auto;
	margin-right: auto;
	clear: right;
}
#below #cardBoard {
	height: 100%;
	width: 30%;
	background-color: white;

}
#below #keyBoard #keyTable{
	height: 100%;
	width: 90%;
	margin:auto;
}
#left {
	width: 20%;
	height: 100%;
	float: left;
	clear: right;
	background-color: #49bbf4;
	position: relative;
}

#left #leftContent {
	position: absolute;
	bottom: 0px;
	width: 100%;
	height: 78%;
}

#right {
	width: 20%;
	height: 100%;
	float: left;
	clear: none;
	background-color: #49bbf4;
	position: relative;
}

#right #rightContent {
	position: absolute;
	bottom: 0px;
	width: 100%;
	height: 78%;
}

.functionButton {
	background-color: #5CB85C;
	width: 70%;
	height: 30px;
	margin-top: 40px;
	margin-bottom: 40px;
	margin-left: 15%;
	margin-right: 15%;
	float: left;
	clear: none;
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border-radius: 20px;
}

#screen {
	width: 60%;
	height: 100%;
	float: left;
	clear: right;
	background-color: white;
	border-color: black;
	border-style: solid;
}

#screen #title {
	width: 100%;
}

#screen #title #logo {
	float: left;
	clear: right;
}

#screen #title #message {
	float: left;
	clear: none;
}

#screen #title #message p {
	text-align: center;
	font-style: italic;
	font-size: 30px;
	font-weight: 5px;
	font-style: italic;
}

#screen #title #message #advise {
	font-size: 20px;
	font-weight: 5px;
	color: red;
}

#screen #content {
	width: 100%;
	height: 78%;
	float: left;
}

#screen #content #functionLeft {
	width: 35%;
	height: 100%;
	float: left;
	clear: none;
}

#screen #content #functionRight {
	width: 35%;
	height: 100%;
	float: right;
	clear: none;
}

#screen #content #functionLeft  .labelLeft {
	border-radius: 78% 0% 0% 78%/100% 0% 0% 100%;
	background-color: #2a78f7;
	width: 120px;
	height: 30px;
	margin: 40px;
	float: left;
	clear: none;
	font-size: 18px;
	text-align: center;
}

#screen #content #functionRight .labelRight {
	border-radius: 0% 78% 78% 0%/0% 100% 100% 0%;
	background-color: #2a78f7;
	width: 120px;
	height: 30px;
	margin: 40px;
	float: right;
	clear: none;
	font-size: 18px;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="main">
		<div id="center">
			<div id="left">
				<div id="leftContent">
					<button type="button" class="functionButton">Button 1</button>
					<button type="button" class="functionButton">Button 2</button>
					<button type="button" class="functionButton">Button 3</button>

				</div>
			</div>
			<div id="screen">
				<div id=title>
					<div id=logo>
						<img src="resources/logo.jpg">
					</div>
					<div id=message>
						<p>TP Bank ATM</p>
<!-- 						<p id="advise">Please select a transaction</p> -->
					</div>
				</div>
				<div id=content>
<!-- 					<div id=functionLeft> -->
<!-- 						<label class="labelLeft">Manh</label> <label class="labelLeft">Manh</label> -->
<!-- 						<label class="labelLeft">Manh</label> -->
<!-- 					</div> -->
<!-- 					<div id=functionRight> -->
<!-- 						<label class="labelRight">Manh</label> <label class="labelRight">Manh</label> -->
<!-- 						<label class="labelRight">Manh</label> -->
<!-- 					</div> -->
						<center><h1>Enter your PIN</h1>
						<form action="loginprocess" method="post">
							<table>
								<tr>
									<td>Account ID </td>
									<td><input type="text" name="account"></td>
								</tr>
								<tr>
									<td>PIN </td>
									<td><input type="text" name="pin"></td>
								</tr>
							</table>
							<br>
							Then press enter button       <input type="submit" value="OK">
						</form>
						<p>${message }</p>
						</center>

				</div>
			</div>
			<div id="right">
				<div id="rightContent">
					<button type="button" class="functionButton">Button 4</button>
					<button type="button" class="functionButton">Button 5</button>
					<button type="button" class="functionButton">Button 6</button>
				</div>
			</div>
		</div>
		<div id="below">
			<div id=keyBoard class="panel panel-default">
				<table id="keyTable">
					<tr>
						<td> <button type="button" class="btn btn-primary">1</button></td>
						<td> <button type="button" class="btn btn-primary">2</button></td>
						<td> <button type="button" class="btn btn-primary">3</button></td>
						<td class="keyFuntion" colspan="2"><button style="width: 80px;" type="button" class="btn btn-success">Enter</button></td>
					</tr>
					<tr>
						<td> <button type="button" class="btn btn-primary">4</button></td>
						<td> <button type="button" class="btn btn-primary">5</button></td>
						<td> <button type="button" class="btn btn-primary">6</button></td>
						<td class="keyFuntion" colspan="2"><button style="width: 80px;" type="button" class="btn btn-warning">Clear</button></td>
					</tr>
					<tr>
						<td> <button type="button" class="btn btn-primary">7</button></td>
						<td> <button type="button" class="btn btn-primary">8</button></td>
						<td> <button type="button" class="btn btn-primary">9</button></td>
						<td class="keyFuntion" colspan="2"><button style="width:80px;" type="button" class="btn btn-danger">Cancel</button></td>
					</tr>
					<tr>
						<td> <button type="button" class="btn btn-primary"> </button></td>
						<td> <button type="button" class="btn btn-primary">0</button></td>
						<td> <button type="button" class="btn btn-primary"></button></td>
						<td class="keyFuntion" colspan="2"><button style="width: 80px;" type="button" class="btn btn-primary"></button></td>
					</tr>
				</table>
			</div>
			<div id="cardBoard" class="panel panel-default">
			<div id="cardPick">
			</div>
			<div id="cardInsert">
			
			</div>
			</div>
		</div>
	</div>
</body>
</html>