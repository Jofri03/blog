"use strict";

$(function(){
  console.log('hi2');

  $("#submit").click(function() {
    var title = $("#title").val();
    var content = $("#content").val();
    console.log("new blog servlet");
    $.post("NewServlet", {"title": title, "content": content}).
    done(function(json) {
    	console.log(json);
    })
    .fail(function() {

    });
  });
});
