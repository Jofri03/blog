$(function() {
	// You can then call the function with something like what i have below.
	$.each($('p'), function() {
		var maxLength = 500;
		if (this.innerText.length > maxLength) {
			this.innerText = this.innerText.substr(0, maxLength) + '...';
		}
	});
});