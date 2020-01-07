"use strict";

// '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .
$(window).on("load resize ", function () {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({ 'padding-right': scrollWidth });
}).resize();

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



function submitArticle() {


      checkTags();

      let star = document.getElementById("favToggle");
      let isFav = false;

      if (star.className === "glyphicon glyphicon-star-empty"){
        isFav = false;
      } else {
        isFav = true;
      }

    axios.post("/createArticle", {
      name: document.getElementById("na_name").value,
      description: document.getElementById("na_description").value,
      source: document.getElementById("na_source").value,
      rating: document.getElementById("na_rating").value,
      url: document.getElementById("na_url").value,
      favourite: isFav,
      tagList: currentTags
    })
        .then((response) => {            
            console.log(response.data);
        }).catch((error) => {
            console.error(error);
        });
}

let currentTags = [];

function checkTags(){

  let chosenTags = document.querySelectorAll(".select2-selection__choice");

  for (let i = 0; i < chosenTags.length; ++i) {
    let tag = chosenTags[i].title;
    axios.post("/createTag", {
      name: tag
    })
    .then((response) => {
            currentTags.push(response);
            console.log(response.data);
        }).catch((error) => {
            console.error(error);
        });
  }
  console.log(currentTags);
}