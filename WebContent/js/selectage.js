$(function() {
	for (var i = 1; i < 120; i++) {
		$("#user_age").append("<option>"+i+"</option>");
	}
	$(".show_info").show();
	$(".update_info").hide();
	
	$(".edit_info").click(function(){
		$(".show_info").toggle();
		$(".update_info").toggle();
		$(".edit_div").hide();
	});
});

