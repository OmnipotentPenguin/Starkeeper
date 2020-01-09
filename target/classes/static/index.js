"use strict";

// '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .
$(window).on("load resize ", function () {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({ 'padding-right': scrollWidth });
}).resize();

function toggleFavCreate() {

  let star = document.getElementById("favToggle");

  if (star.className === "glyphicon glyphicon-star-empty") {
    star.className = "glyphicon glyphicon-star";
  } else {
    star.className = "glyphicon glyphicon-star-empty";
  }
}

function articleFavourite(articleID){

  console.log("favourite toggled")

  axios.patch("/toggleFavourite/" + articleID)
    .then((response) => {
    }).catch((error) => {
      console.error(error);
    });    
}

function articleEdit(articleID){

}

function articleDelete(articleID){

}

var tagData = [];

function submitArticle() {

  let star = document.getElementById("favToggle");
  let isFav = false;

  if (star.className === "glyphicon glyphicon-star-empty") {
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
      console.log(response.data);
      document.location.href = "create_article.html";
    }).catch((error) => {
      console.error(error);
    });
}

function checkTags(articleID) {

  let chosenTags = document.querySelectorAll(".select2-selection__choice");

  for (let i = 0; i < chosenTags.length; ++i) {
    let tag = chosenTags[i].title;
    axios.patch(("/addTag/" + articleID), {
      name: tag
    })
      .then((response) => {

      }).catch((error) => {
        console.error(error);
      });
  }
}

function insertNewRow(table, article) {

  let row = table.insertRow(0);

  let cell1 = row.insertCell(0);
  let cell2 = row.insertCell(1);
  let cell3 = row.insertCell(2);
  let cell4 = row.insertCell(3);
  let cell5 = row.insertCell(4);
  let cell6 = row.insertCell(5);
  let cell7 = row.insertCell(6);

  cell1.innerHTML = article.id;
  cell2.innerHTML = article.name;
  cell3.innerHTML = article.description;
  cell4.innerHTML = article.source;
  cell5.innerHTML = article.rating;
  cell6.innerHTML = article.url;

  let favref = document.createElement("a");
  favref.onclick = function() {articleFavourite(article.id);};
  favref.className = "favourite-item";
  favref.title = "Favourite";

  let favicon = document.createElement("i");
  favicon.className = "glyphicon glyphicon-star";
  favref.appendChild(favicon);

  let editref = document.createElement("a");
  editref.onclick = null //articleEdit(article.id);
  editref.className = "edit-item";
  editref.title = "Edit";

  let editicon = document.createElement("i");
  editicon.className = "glyphicon glyphicon-pencil";
  editref.appendChild(editicon);

  let delref = document.createElement("a");
  delref.onclick = null //articleDelete(article.id);
  delref.className = "delete-item";
  delref.title = "Delete";

  let delicon = document.createElement("i");
  delicon.className = "glyphicon glyphicon-trash";
  delref.appendChild(delicon);

  cell7.appendChild(favref);
  cell7.appendChild(editref);
  cell7.appendChild(delref);

}

function articlePage() {

  let table = document.getElementById("myTable tbody");

  axios.get("/getArticle")
    .then((response) => {
      console.log(response.data);

      let allArticles = response.data;

      for (let article of allArticles) {

        insertNewRow(table, article);

      }

    }).catch((error) => {
      console.error(error);
    });
}

function indexPage() {

  let table = document.getElementById("myFavouritesTable tbody");

  axios.get("/getArticle")
    .then((response) => {
      console.log(response.data);

      let allArticles = response.data;

      for (let article of allArticles) {

        if (article.favourite) {
          insertNewRow(table, article);
        }
      }
    }).catch((error) => {
      console.error(error);
    });

  let table2 = document.getElementById("myLatestTable tbody");

  axios.get("/getArticle")
    .then((response) => {
      console.log(response.data);

      let allArticles = response.data;

      for (let i = 0; i < allArticles.length; i++) {

        if (allArticles.length > 6) {
          let j = allArticles.length - (6 - i);
          insertNewRow(table2, allArticles[j]);
        } else {
          insertNewRow(table2, allArticles[i])
        }

        if (i > 6) {
          break;
        }
      }

    }).catch((error) => {
      console.error(error);
    });

}

function createArticlePage() {

  let newTagData = [];

  axios.get("/getTag")
    .then((response) => {

      let allTags = response.data;

      for (let tag of allTags) {

        let newTag =
        {
          "id": parseInt(tag.id),
          "text": tag.name
        };

        newTagData.push(newTag);
      }

      tagData = newTagData;

      $('.js-example-basic-multiple').select2({
        width: '100%',
        tags: true,
        data: tagData,
        placeholder: "  Input a tag then press Enter",
        allowClear: true
      });

    }).catch((error) => {
      console.error(error);
    });

}

