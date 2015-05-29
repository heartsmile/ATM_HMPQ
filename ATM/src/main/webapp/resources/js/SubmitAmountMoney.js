/**
 * 
 */
function sendAmount() {
	var amount = $("#numOfOtherMoney").val();
	if (amount != "") {
		$.ajax({
			type : "POST",
			url : "submitAmountMoney",
			data : "amountMoney=" + amount + "&abc=" + "abc",
			dataType : "json",
			success : function(data) {
				// Check if response is success.
				if (data.result == "success") {
					window.location.href = 'askReceipt';
				}
				if (data.result == "error") {
					window.location.href = 'errorPage';
				}
			}
		});
	}
	
}

function sendAmountRecommended(value) {
	var amount = value;

	$.ajax({
		type : "POST",
		url : "submitAmountMoney",
		data : "amountMoney=" + amount + "&abc=" + "abc",
		dataType : "json",
		success : function(data) {
			// Check if response is success.
			if (data.result == "success") {
				window.location.href = 'askReceipt';
			}
			if (data.result == "error") {
				window.location.href = 'errorPage';
			}
		}
	});
}