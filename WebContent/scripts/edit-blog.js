"use strict";

$(function(){
  console.log('hi2');

  $("#submit").click(function() {
    $.post("EditBlogServlet", { 
    	"blogid": $("#blogid").val(),
    	"title": $("#title").val(),
    	"content": $("#content").val() }
    )				    	
	.done(function(json) {
    	alert("Edit blog success!");
    	location.href = "edit-blog-success?blogid=" + $("#blogid").val();
    })
    .fail(function() {
    	alert("Edit blog failed!")
    });
  });
});