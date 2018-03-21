$(function() {
	 $("#loading").hide();
	$(document).ajaxStart(function() { 
		$("#loading").show();  
	})
	.ajaxStop( function() { 
	   $("#loading").hide(); 
   }); 
	
	
	$("#search").click(function (event) {
		$(this).addClass("loading");
		event.preventDefault();
		var keyword = $("#keyword").val();
		location.href = 'search?keyword=' + keyword;
	});
});