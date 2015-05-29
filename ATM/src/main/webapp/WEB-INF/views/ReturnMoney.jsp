<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="func" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	var max_time = 6;
	var cinterval;

	function countdown_timer() {
		// decrease timer
		max_time--;
		//document.getElementById('seconds').innerHTML = max_time;
		if (max_time == 0) {
			clearInterval(cinterval);
			var URL = location.href;
			var targetURL = URL.substring(0, URL.lastIndexOf("/") + 1);
			// open login page.
			window.location = targetURL + "returnMoneyDone";
		}
	}
	// 1,000 means 1 second.
	cinterval = setInterval('countdown_timer()', 1000);
</script>

<style type="text/css">
#screen #content #functionRight {
	width: 40%;
	height: 100%;
	float: right;
	clear: none;
	margin-top: -25px;
}
</style>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Withdraw Money</title>
</head>
<body>
	<div id="main">
		<div id="center" class="panel panel-default">
			<div id="left">
				<div id="leftContent">
					<button type="button" class="functionButton">
						<img src="resources/imgs/arrow.png">
					</button>
					<button type="button" class="functionButton">
						<img src="resources/imgs/arrow.png">
					</button>
					<button type="button" class="functionButton">
						<img src="resources/imgs/arrow.png">
					</button>
				</div>
			</div>
			<!-- Begin Screen -->
			<div id="screen">
				<div id=title>
					<div id=logo>
						<img src="resources/imgs/logo.jpg">
					</div>
					<div id=message>
						<p>TP Bank ATM</p>
					</div>
				</div>
				<div id=content>
					<div id=functionCenter>
						<label class="labelCenter" id="welcome">Please get your
							money!</label>
						<table class="table">
							<tr>
								<th> Money value</th>
								<th> Quantity</th>
							</tr>
							<c:if test="${not empty listMoney }">
									<c:forEach var="money" items="${listMoney }">
										<tr>
											<td>${money.value }</td>
											<td>${money.quantity }</td>
										</tr>
									</c:forEach>
							</c:if>
						</table>
					</div>
					<div id=functionRight></div>
				</div>
			</div>
			<!-- End Screen -->
			<div id="right">
				<div id="rightContent">
					<button type="button" class="functionButton">
						<img src="resources/imgs/arrow2.png">
					</button>
					<button type="button" class="functionButton">
						<img src="resources/imgs/arrow2.png">
					</button>
					<button type="button" class="functionButton">
						<img src="resources/imgs/arrow2.png">
					</button>
				</div>
			</div>
		</div>
		<div id="below" class="panel panel-default">
			<div id="board">
				<div id=keyBoard class="panel panel-default">
					<table id="keyTable">
						<tr>
							<td>
								<button type="button" class="btn btn-primary" value="1"
									onclick="keyType(this)">1</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary" value="2"
									onclick="keyType(this)">2</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary" value="3"
									onclick="keyType(this)">3</button>
							</td>
							<td class="keyFuntion" colspan="2"><button
									style="width: 80px;" type="button" class="btn btn-success">Enter</button></td>
						</tr>
						<tr>
							<td>
								<button type="button" class="btn btn-primary" value="4"
									onclick="keyType(this)">4</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary" value="5"
									onclick="keyType(this)">5</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary" value="6"
									onclick="keyType(this)">6</button>
							</td>
							<td class="keyFuntion" colspan="2">
								<button class="btn btn-warning" style="width: 80px;"
									type="button" value="clearB" onclick="clearText()">Clear</button>
							</td>
						</tr>
						<tr>
							<td>
								<button type="button" class="btn btn-primary" value="7"
									onclick="keyType(this)">7</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary" value="8"
									onclick="keyType(this)">8</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary" value="9"
									onclick="keyType(this)">9</button>
							</td>
							<td class="keyFuntion" colspan="2"><button
									style="width: 80px;" type="button" class="btn btn-danger">Cancel</button></td>
						</tr>
						<tr>
							<td>
								<button type="button" class="btn btn-primary">&nbsp</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary" value="0"
									onclick="keyType(this)">0</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary">&nbsp</button>
							</td>
							<td class="keyFuntion" colspan="2"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>