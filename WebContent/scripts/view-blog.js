$(function () {
	console.log("hi");
	$("#edit_btn").click(function () {
		var blogId = $("#blog_id").val();
		$.get("edit", {"blogId": blogId})
		.done(function() { })
		.fail(function() { })
		.always(function() { });
	});
	$("#delete_btn").click(function () { 
		var blogId = $("#blog_id").val();
		$.get("delete", {"blogId": blogId})
		.done(function() {
			alert("delete blog success!");
		})
		.fail(function() {
			alert("delete blog failed!");
		})
		.always(function() { });
	});
});