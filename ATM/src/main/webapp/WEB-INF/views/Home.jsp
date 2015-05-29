<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
    href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Home</title>
<script type="text/javascript">
    $(document).ready(function() {

    	$('#welcome').show();
    	$('#check').hide();

        $('#card1').click(function() {
            $('#cardid').val('123456');
            return false;
        });

        $('#card2').click(function() {
            $('#cardid').val('1235');
            return false;
        });

        $('#insert').click(function(){
        	$('#welcome').hide();
        	$('#messages').hide();
        	$('#check').show();

        	setTimeout(function () {
                    $('#vaidateform').submit();
            }, 5000);
        	return false;
        });


    });
</script>
</head>
<body>

    <div id="main">
        <div id="center" class="panel panel-default">
            <div id="left">
                <div id="leftContent">
                    <button type="button" class="functionButton">
                        <img src="${pageContext.request.contextPath}/resources/imgs/arrow.png">
                    </button>
                    <button type="button" class="functionButton">
                        <img src="${pageContext.request.contextPath}/resources/imgs/arrow.png">
                    </button>
                    <button type="button" class="functionButton">
                        <img src="${pageContext.request.contextPath}/resources/imgs/arrow.png">
                    </button>

                </div>
            </div>
            <!-- Begin Screen -->
            <div id="screen">
                <div id=title>
                    <div id=logo>
                        <img src="${pageContext.request.contextPath}/resources/imgs/logo.jpg">
                    </div>
                    <div id=message>
                        <p>TP Bank ATM</p>
                        <!-- <p id="advise">Please select a transaction</p> -->
                    </div>
                </div>
                <div id=content>
                    <div id=functionCenter>
                    <div id = "welcome">
                        <b>WELCOME TO TP BANK</b>
                     </div>
                     <div id = "check">
                        <label id="welcome">Validateting your ATM card...</label>
                     </div>
                     <div id="messages">
                        <h2>${message }</h2>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Screen -->
            <div id="right">
                <div id="rightContent">

                    <button type="button" class="functionButton">
                        <img src="${pageContext.request.contextPath}/resources/imgs/arrow2.png">
                    </button>
                    <button type="button" class="functionButton">
                        <img src="${pageContext.request.contextPath}/resources/imgs/arrow2.png">
                    </button>
                    <button type="button" class="functionButton">
                        <img src="${pageContext.request.contextPath}/resources/imgs/arrow2.png">
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
                            <td class="keyFuntion" colspan="2">
                            <button style="width: 80px;" type="button" class="btn btn-success">Enter</button></td>
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
                            <button id="card1" type="button" class="btn btn-primary">
                                <img alt="" src="${pageContext.request.contextPath}/resources/imgs/card.png">Card 1
                            </button>
                            <button id="card2" type="button" class="btn btn-primary">
                                <img alt="" src="${pageContext.request.contextPath}/resources/imgs/card.png">Card 2
                            </button>
                            <button type="button" class="btn btn-success">
                                <img src="${pageContext.request.contextPath}/resources/imgs/pick.png">Pick
                            </button>

                        </div>
                    </div>
                    <div id="cardInsert">
                        <form action="${pageContext.request.contextPath}/card/insertprocess" method="post" id ="vaidateform">
                            <input type="hidden" name="cardid" id="cardid">
                            <div id="insertPanel" class="panel panel-default">
                                <label><img alt="" src="${pageContext.request.contextPath}/resources/imgs/cardIn.png"></label>
                                <button id="insert" type="submit" class="btn btn-warning">
                                    <img alt="" src="${pageContext.request.contextPath}/resources/imgs/insert.png"> Insert card
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