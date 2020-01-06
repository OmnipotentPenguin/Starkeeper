// '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .
$(window).on("load resize ", function () {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({ 'padding-right': scrollWidth });
}).resize();

function loadHomePage(){
  console.log("Homepage loaded")
}

function loadArticlePage(){
  console.log("Article page loaded")
}

function loadNewArticlePage(){
  console.log("new article loaded")
}

function toggleFavCreate(){

  let star = document.getElementById("favToggle");

  if (star.className === "glyphicon glyphicon-star-empty"){
    star.className = "glyphicon glyphicon-star";
  } else {
    star.className = "glyphicon glyphicon-star-empty";
  }

}

function toggleFavourite(){

}

function editArticle(){

}

function deleteArticle(){

}

/* CREATE TAG FUNCTIONALITY */

// ADD JQUERY
(function () {
  var tagList = [];
  
  // cacheing the DOM elements
  var $tagList = $("#tagList");
  var $newTag = $("#newTag");

  // initial render
  tagList_render();
  
  // always put logic sections and render sections in seperate functions/class
  // trust me it will help a lot on big projects!
  function tagList_render () {
    $tagList.empty();
    tagList.map (function (_tag) {
      var temp = '<li>'+ _tag +'<span class="rmTag">&times;</span></li>';
      $tagList.append(temp);
    });
  };
  
  // key events
  // Add new tag on "ENTER" press
  $newTag.on('keyup', function (e) {
    // enter keycode 13
    if (e.keyCode == 13) {
      var newTag = $("#newTag").val();
      if( newTag.replace(/\s/g, '') !== '' ){
        tagList.push(newTag);
        $newTag.val('');
        tagList_render();
      }
    }
  });
  
  // button events
  // Remove Tag
  $tagList.on("click", "li>span.rmTag", function(){
    var index = $(this).parent().index();
    tagList.splice(index, 1);
    tagList_render();
  });
})();
