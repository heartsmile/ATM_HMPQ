<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
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
						<img src="${pageContext.request.contextPath}/resources/imgs/logo.jpg">
					</div>
					<div id=message>
						<p>TP Bank ATM</p>
						<!-- 						<p id="advise">Please select a transaction</p> -->
					</div>
				</div>
				<div id=content>
					<center>
						<h1>Insert your card</h1>
						<form action="insertprocess" method="post">
							<table>
								<tr>
									<td>Card number</td>
									<td><input type="text" name="cardid"></td>
								</tr>
							</table>
							<br> <input type="submit" value="Insert">
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
						<td>
							<button type="button" class="btn btn-primary">1</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary">2</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary">3</button>
						</td>
						<td class="keyFuntion" colspan="2"><button
								style="width: 80px;" type="button" class="btn btn-success">Enter</button></td>
					</tr>
					<tr>
						<td>
							<button type="button" class="btn btn-primary">4</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary">5</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary">6</button>
						</td>
						<td class="keyFuntion" colspan="2"><button
								style="width: 80px;" type="button" class="btn btn-warning">Clear</button></td>
					</tr>
					<tr>
						<td>
							<button type="button" class="btn btn-primary">7</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary">8</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary">9</button>
						</td>
						<td class="keyFuntion" colspan="2"><button
								style="width: 80px;" type="button" class="btn btn-danger">Cancel</button></td>
					</tr>
					<tr>
						<td>
							<button type="button" class="btn btn-primary"></button>
						</td>
						<td>
							<button type="button" class="btn btn-primary">0</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary"></button>
						</td>
						<td class="keyFuntion" colspan="2"><button
								style="width: 80px;" type="button" class="btn btn-primary"></button></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	</div>
</body>
</html>