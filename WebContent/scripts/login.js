"use strict";

$(function(){
  console.log('login page');

  $("#Login").click(function() {
    var username = $("#username").val();
    var password = $("#password").val();
    console.log("Loginservlet");
    $.post("LoginVerifiedServlet", {"username": username, "password": password}).
    done(function(json) {
    	alert("You successfully logged in ");
    	//to-do: jump to the bloglist related to this user
    //	location.href = "edit-blog-success?blogid=" + json['newBlogId'];
    })
    .fail(function() {
    	alert("Your login failed");
    });
  });
});
