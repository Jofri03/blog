"use strict";

$(function(){
  console.log('hi2');

  $("#submit").click(function() {
	  $(this).addClass("loading");
    $.post("EditBlogServlet", { 
    	"blogid": $("#blogid").val(),
    	"title": $("#title").val(),
    	"content": $("#content").val() }
    )				    	
	.done(function(json) {
    	location.href = "success?blogid=" + $("#blogid").val();
    })
    .fail(function() {
    	alert("Edit blog failed!")
    })
    .always(function() {
    		$(this).removeClass("loading");
    })
  });
});
