"use strict";

$(function(){
    $("#submit").click(function() {
	    $(this).addClass("loading");
        var title = $("#title").val();
        var content = $("#content").val();
        console.log("NewServlet");
        $.post("NewServlet", {"title": title, "content": content}).
        done(function(json) {
    	    location.href = "success?blogid=" + json['newBlogId'];
    })
    .fail(function() {
    		alert("Add nwe blog failed!")
    })
    .always(function() {
    		$(this).removeClass("loading");
    });
  });
});
