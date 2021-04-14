$(document).ready(function() {
	btnQuickEvent();	
	btnRematchEvent();
	markSquareEvent();
});

/**
	Quick Game Event
**/
function btnQuickEvent() {
	$('#btnQuick').click(function() {
		var confirm = window.confirm("Are you sure going to quick the game?");
		
		if (!confirm) {
			return false;
		}
		
		location.href = '/';
	});
}

/**
	Rematch the game
**/
function btnRematchEvent() {
	$('#btnRematch').click(function() {
		var confirm = window.confirm("Are you sure going to rematch the game?");
		
		if (!confirm) {
			return false;
		}
		
		location.href = "/Rematch";
	});
}

/**
	Mark the selected square
**/
function markSquareEvent() {
	$('.square').click(function() {
		
		var gameStatus = $('#txtGameStatus');
		var allowRequestAPI = $('#txtAllowRequestAPI');
		
		if (gameStatus.val() === 'PROGRESS' && allowRequestAPI.val() === 'YN_Y') {
			allowRequestAPI.val('YN_N');
		
			var x = $(this).data('el_square').split('_')[0];
			var y = $(this).data('el_square').split('_')[1];
			
			var squareElement = $(this);
			var playerType = $('#txtPlayerTurn');
			
			$.ajax({
				type: "GET",
				url: "/TicTacToe/MarkSquare",
				data: {x, y},
				success: function(data) {
					var gameObj = data;
					console.log(gameObj);
					var playerTurn = gameObj.playerTurn;
					var gameStatus = gameObj.statusType;
					
					squareElement.find('span').text(playerType.val());
					
					setTimeout(function() {
						if (gameStatus === 'PROGRESS') {
							playerType.val(gameObj.playerTurn);
							allowRequestAPI.val('YN_Y');
							alert("Now Player " + playerTurn + " to go!");
						} else if (gameStatus === 'WIN') {
							allowRequestAPI.val('YN_N');
							alert("Player " + playerTurn + " has win the game!");
						} else if (gameStatus === 'DRAW') {
							allowRequestAPI.val('YN_N');
							alert("This game is draw");
						}	
					}, 500);
				},
				error: function(data) {
					alert('This field has been selected, cannot select this field!');
				} 
			});
		}
	});
}