<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
    var max_time = 4;
    var cinterval;
     
    function countdown_timer(){
    	// decrease timer
    	max_time--;
    	//document.getElementById('seconds').innerHTML = max_time;
    	if(max_time == 0){
	    	clearInterval(cinterval);
	    	var URL = location.href;
			var targetURL = URL.substring(0, URL.lastIndexOf("/") + 1);
			// open login page.
			window.location = targetURL + "ejectCardDone";
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<title>Eject Card</title>
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
						<!-- <p id="advise">Please select a transaction</p> -->
					</div>
				</div>
				<div id=content>
					<div id=functionCenter>
						
						<label class="labelCenter" id="welcome">Please receive your card! </label>
					</div>
					<div id=functionRight>
						<!-- <label class="labelRight"></label> --> 
						<!-- <label class="labelRight">OK</label> 
						<label class="labelRight">Cancel</label> -->
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
								<button type="button" class="btn btn-primary" value="0" onclick="keyType(this)">0</button>
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