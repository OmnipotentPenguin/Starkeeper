"use strict";

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

$(document).ready(function() {
    $('.js-example-basic-multiple').select2({
    width: '100%',
    tags: true
    });
});