$(function () {
	
	$("#signin").click(function(event) {
		event.preventDefault();
		$(this).addClass("loading");
		$.post("login", {"email": $("#email").val(), "password": $("#password").val(), "remember": $("#remember").is(':checked') })
		.done(function (data) {
//			debugger;
			if (data.result) {
				 location.href = 'list';

			} else {
				alert("username or password is incorrect!");
			}

		})
		.fail(function(json) {
			alert('fail');
			alert(JSON.stringify(json));
		})
		.always(function() {
			$(this).removeClass("loading");
		})
	}); // click
});