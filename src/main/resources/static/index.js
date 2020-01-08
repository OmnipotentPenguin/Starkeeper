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
    favourite: isFav
  })
  .then((response) => {
    checkTags(response.data.id);
    
  }).catch((error) => {
    console.error(error);
  });
}

function checkTags(articleID){

  let chosenTags = document.querySelectorAll(".select2-selection__choice");

  for (let i = 0; i < chosenTags.length; ++i) {
    let tag = chosenTags[i].title;
    axios.patch(("/update/"+articleID), {
      name: tag
    })
    .then((response) => {      
      console.log(response.data);
    }).catch((error) => {
      console.error(error);
    });
  }
  getArticles();
}

function getArticles(){
  axios.get("/getArticle")
        .then((response) => {
          console.log("refresh articles");
            showArticles(response.data);
        }).catch((error) => {
            console.error(error);
        });
}

function showArticles(articles) {

  let articleTable = document.getElementById("article-table");
  let template = document.getElementById("table-template");

    for (let article of articles) {


// Create an empty <tr> element and add it to the 1st position of the table:
let row = articleTable.insertRow(0);

// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
let cell0 = row.insertCell(0);
let cell1 = row.insertCell(1);
let cell2 = row.insertCell(2);
let cell3 = row.insertCell(3);
let cell4 = row.insertCell(4);
let cell5 = row.insertCell(5);

// Add some text to the new cells:
cell0.innerHTML = article.id;
cell1.innerHTML = article.name;
cell1.innerHTML = article.description;
cell1.innerHTML = article.area;
cell1.innerHTML = article.source;
cell1.innerHTML = "NEW CELL1";

        // const newID = document.createElement("td")
        // newID.className = "article-id"
        // newID.innerText = article.id;
        // newEntry.appendChild(newID);

        // const newName = document.createElement("td")
        // newName.className = "article-name"
        // newName.innerText = article.name;
        // newEntry.appendChild(newName);

        // const newDesc = document.createElement("td")
        // newDesc.className = "article-description"
        // newDesc.innerText = article.description;
        // newEntry.appendChild(newDesc);

        // const newArea = document.createElement("td")
        // newArea.className = "article-area"
        // newArea.innerText = article.area;
        // newEntry.appendChild(newArea);

        // const newSource = document.createElement("td")
        // newSource.className = "article-source"
        // newSource.innerText = article.source;
        // newEntry.appendChild(newSource);




        articleTable.appendChild(newEntry);
    }
}

$("#addTableRow").click( function () {      
  var row = $("<tr>");

  row.append($("<td>Text-1</td>"))
     .append($("<td>Text-2</td>"))
     .append($("<td>Text-3</td>"))
     .append($("<td>Text-4</td>"))
     .append($("<td>Text-5</td>"))
     .append($("<td>Text-6</td>"))
     .append($("<td>Text-7</td>"));
 
  $("#myTable tbody").append(row);
});