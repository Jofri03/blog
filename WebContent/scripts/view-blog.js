$(function () {
	//Goto the editing page
	$("#edit_btn").click(function () {
		var blogId = $("#blog_id").val();
		location.href = 'edit?blogid=' + blogId;
	});

	// Delete blog
	$("#delete_btn").click(function () {
		$(this).addClass("loading");
		var blogId = $("#blog_id").val();
		$.get("delete", {"blogId": blogId})
		.done(function() {
			location.href = 'list';
		})
		.fail(function() {
			alert("delete blog failed!");
		})
		.always(function() {
			$(this).removeClass("loading");
		 });
	});
});
