<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	
<title>Login</title>
<script type="text/javascript">
	$(document).ready(function() {

		$('#insertpin').show();
    	$('#valid').hide();
    	
    	var attemp = $('#attempt').val();
    	if(attemp == 3){
    		setTimeout(function () {
    			var contextPath='<%=request.getContextPath()%>';
				window.location.href = contextPath + "/home";
        }, 2000);
    	}
    		
		$('button').click(function() {
			var id = $(this).attr('id');
			var pinCode = $('#pin').val();
			if (id == 'clear') {
				clear(pinCode);
			} else if(id == 'cancel'){
				var contextPath='<%=request.getContextPath()%>';
				window.location.href = contextPath + "/home";
			} else {
				$('#pin').val(pinCode + id);
			}

			$('#pinhd').val($('#pin').val());
			return false;
		});

		$('#enter').click(function() {
			$('#insertpin').hide();
			$('#valid').show();

			setTimeout(function() {
				$('#pinvalidate').submit();
			}, 2000);
			return false;
		});

		function clear(pinCode) {
			var text = pinCode.substring(0, pinCode.length - 1);
			$('#pin').val(text);
		}

	});
</script>
</head>
<body>
	<div id="main">
		<div id="center" class="panel panel-default">
			<div id="left">
				<div id="leftContent">
					<button type="button" class="functionButton">
						<img
							src="${pageContext.request.contextPath}/resources/imgs/arrow.png">
					</button>
					<button type="button" class="functionButton">
						<img
							src="${pageContext.request.contextPath}/resources/imgs/arrow.png">
					</button>
					<button type="button" class="functionButton">
						<img
							src="${pageContext.request.contextPath}/resources/imgs/arrow.png">
					</button>

				</div>
			</div>
			<!-- Begin Screen -->
			<div id="screen">
				<div id=title>
					<div id=logo>
						<img
							src="${pageContext.request.contextPath}/resources/imgs/logo.jpg">
					</div>
					<div id=message>
						<p>TP Bank ATM</p>
						<!-- <p id="advise">Please select a transaction</p> -->
					</div>
				</div>
				<div id=content>
				
					<div id="insertpin">
					<div id = "welcome">
                        <center><b>WELCOME TO TP BANK</b></center>
                     </div>
						<center>
							<input type="hidden" id="attempt" value="${attempt }">
							<c:if test="${empty attempt or attempt < 3}">
								<h1>Enter your PIN</h1>
								<table>
									<tr>
										<td>PIN</td>
										<td><input type="password" name="pin" id="pin"
											readonly="true"></td>
									</tr>
								</table>
							</c:if>
							<center>
								<h4>${message }</h4>
							</center>
						</center>
					</div><br><br><br><br>
					<div id="valid">
						<center>
							<h4>Validating your pin....</h4>
						</center>
					</div>

				</div>
			</div>
			<div id="right">
				<div id="rightContent">

					<button type="button" class="functionButton">
						<img
							src="${pageContext.request.contextPath}/resources/imgs/arrow2.png">
					</button>
					<button type="button" class="functionButton">
						<img
							src="${pageContext.request.contextPath}/resources/imgs/arrow2.png">
					</button>
					<button type="button" class="functionButton">
						<img
							src="${pageContext.request.contextPath}/resources/imgs/arrow2.png">
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
								<button type="button" id="1" class="btn btn-primary" value="1">1</button>
							</td>
							<td>
								<button type="button" id="2" class="btn btn-primary" value="2">2</button>
							</td>
							<td>
								<button type="button" id="3" class="btn btn-primary" value="3">3</button>
							</td>
							<td class="keyFuntion" colspan="2">
								<form action="loginprocess" method="post" id="pinvalidate">
									<input type="hidden" name="cardid" value="${card.cardNo }">
									<input type="hidden" name="pin" value="${card.cardNo }"
										id="pinhd"> <input type="submit" style="width: 80px;"
										class="btn btn-success" value="Enter" id="enter">
								</form>
							</td>
						</tr>
						<tr>
							<td>
								<button type="button" id="4" class="btn btn-primary" value="4">4</button>
							</td>
							<td>
								<button type="button" id="5" class="btn btn-primary" value="5">5</button>
							</td>
							<td>
								<button type="button" id="6" class="btn btn-primary" value="6">6</button>
							</td>
							<td class="keyFuntion" colspan="2">
								<button class="btn btn-warning" style="width: 80px;" id="clear"
									type="button" value="clearB">Clear</button>
							</td>
						</tr>
						<tr>
							<td>
								<button type="button" id="7" class="btn btn-primary" value="7">7</button>
							</td>
							<td>
								<button type="button" id="8" class="btn btn-primary" value="8">8</button>
							</td>
							<td>
								<button type="button" id="9" class="btn btn-primary" value="9">9</button>
							</td>
							<td class="keyFuntion" colspan="2">
								<button style="width: 80px;" type="button" id="cancel"
									class="btn btn-danger">Cancel</button>
							</td>
						<tr>
							<td>
								<button type="button" class="btn btn-primary">&nbsp</button>
							</td>
							<td>
								<button type="button" id="0" class="btn btn-primary" value="0">0</button>
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
							<button id="card1" type="button" class="btn btn-primary">
								<img alt=""
									src="${pageContext.request.contextPath}/resources/imgs/card.png">Card
								1
							</button>
							<button id="card2" type="button" class="btn btn-primary">
								<img alt=""
									src="${pageContext.request.contextPath}/resources/imgs/card.png">Card
								2
							</button>
							<button type="button" class="btn btn-success">
								<img
									src="${pageContext.request.contextPath}/resources/imgs/pick.png">Pick
							</button>

						</div>
					</div>
					<div id="cardInsert">
						<form
							action="${pageContext.request.contextPath}/card/insertprocess"
							method="post">
							<input type="hidden" name="cardid" id="cardid">
							<div id="insertPanel" class="panel panel-default">
								<label><img alt=""
									src="${pageContext.request.contextPath}/resources/imgs/cardIn.png"></label>
								<button id="insert" type="submit" class="btn btn-warning">
									<img alt=""
										src="${pageContext.request.contextPath}/resources/imgs/insert.png">
									Insert card
								</button>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>