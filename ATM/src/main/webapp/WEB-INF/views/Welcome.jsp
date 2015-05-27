<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function keyType(id) {
		var el = document.getElementById("pass");
		var num = id.value;
		var oldValue = el.value;
		el.value = oldValue + num + "";
	}
	function clearText() {
		var el = document.getElementById("pass");
		var oldValue = el.value + "";
		el.value = oldValue.substring(0, oldValue.length - 1);
	}
</script>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">

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
		<div id="center" class="panel panel-default">
			<div id="left">
				<div id="leftContent">
					<button type="button" class="functionButton" onclick="window.location.href='withdraw'">
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
						<p id="advise">Please select a transaction</p>
					</div>
				</div>
				<div id=content>
					<div id=functionLeft>
						<label class="labelLeft">Withdraw</label> 
						<label class="labelLeft">Check Balance</label> 
						<label class="labelLeft">Transfer</label>
					</div>
					<div id=functionRight>
						<label class="labelRight">View History</label> 
						<label class="labelRight">Change PIN</label> 
						<label class="labelRight">Exit</label>
					</div>
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
								<button type="button" class="btn btn-primary" value="0">0</button>
							</td>
							<td>
								<button type="button" class="btn btn-primary">&nbsp</button>
							</td>
							<td class="keyFuntion" colspan="2"></td>
						</tr>
					</table>
				</div>
				<div id="cardBoard">
					<div id="cardPick">
						<div id="pickPanel" class="panel panel-default">
							<button type="button" class="btn btn-primary">
								<img alt="" src="resources/imgs/card.png">Card 1
							</button>
							<button type="button" class="btn btn-primary">
								<img alt="" src="resources/imgs/card.png">Card 2
							</button>
							<button type="button" class="btn btn-success">
								<img src="resources/imgs/pick.png">Pick
							</button>

						</div>
					</div>
					<div id="cardInsert">
						<div id="insertPanel" class="panel panel-default">
							<label><img alt="" src="resources/imgs/cardIn.png"></label>
							<button type="button" class="btn btn-warning">
								<img alt="" src="resources/imgs/insert.png"> Insert card
							</button>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>