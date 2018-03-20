$(function () {
	
	$("#signin").click(function(event) {
		event.preventDefault();
		
		$.post("login", {"email": $("#email").val(), "password": $("#password").val(), "remember": $("#remember").is(':checked') })
		.done(function (data) {
//			debugger;
			if (data.result) {
				alert("Login success!");
				 location.href = 'list';


			} else {
				alert("username or password is incorrect!");
			}

		})
		.fail(function(json) {
			alert('fail');
			alert(JSON.stringify(json));
		});
	}); // click
});