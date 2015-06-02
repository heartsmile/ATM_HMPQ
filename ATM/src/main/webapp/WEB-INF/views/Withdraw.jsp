<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<script src="<c:url value="/resources/js/SubmitAmountMoney.js" />"
	type="text/javascript"></script>	

<title>Withdraw Money</title>
</head>
<body>
	<div id="main">
		<div id="center" class="panel panel-default">
			<div id="left">
				<div id="leftContent">
						<button type="button" class="functionButton" 
							onclick="sendAmountRecommended(this.value)" value="500000">
							<img src="resources/imgs/arrow.png">
						</button>
						
						<button type="submit" class="functionButton"
							onclick="sendAmountRecommended(this.value)" value="2000000">
							<img src="resources/imgs/arrow.png">
						</button>
						
						<button type="submit" class="functionButton"
							onclick="sendAmountRecommended(this.value)" value="3000000">
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
						<label class="labelLeft">500.000</label>
						<label class="labelLeft">2.000.000</label> 
						<label class="labelLeft">3.000.000</label>
					</div>
					<div id=functionRight>
						<label class="labelRight">1.000.000</label> 
						<label class="labelRight">2.500.000</label> 
						<label class="labelRight">Enter other</label>
					</div>
				</div>
			</div> 
<!-- End Screen -->
			<div id="right">
				<div id="rightContent">
						<button type="submit" class="functionButton"
							onclick="sendAmountRecommended(this.value)" value="1000000">
							<img src="resources/imgs/arrow2.png">
						</button>
					
						<button type="submit" class="functionButton"
							onclick="sendAmountRecommended(this.value)" value="2500000">
							<img src="resources/imgs/arrow2.png">
						</button>
											
						<button type="button" class="functionButton" onclick="window.location.href='otherValue'">
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
									style="width: 80px;" type="button" class="btn btn-danger"
									onclick="window.location.href='welcome'">Cancel</button></td>
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
			</div>
		</div>
	</div>
</body>
</html>