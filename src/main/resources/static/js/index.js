$(document).ready(function() {
	btnStartOnClick();
});

function btnStartOnClick() {
	$('#btnStart').click(function() {
		var dimension = $('#dimensionNumber').val();
		
		if (dimension === '') {
			alert('Please input the dimension number that you wish');
			return false;
		} else if (parseInt(dimension) < 2) {
			alert('Minimum size of dimension is 2 row and 2 column!');
			return false;
		}
		
		$('#frm').submit();
	});
}