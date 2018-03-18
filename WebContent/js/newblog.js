$(function(){
  console.log('hi');

  $("#submit").click(function() {
    var title = $("#title").val();
    var content = $("#content").val();
    $.post("NewBlog", {"title": title, "content": content}).
    done(function() {

    })
    .fail(function() {

    });
  });
});
