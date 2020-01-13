"use strict";

const url = "/StarKeeper"

// '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .
$(window).on("load resize ", function () {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({ 'padding-right': scrollWidth });
}).resize();

function toggleFavCreate(elID) {

  let star = null;
  if (elID == 'ca'){
    star = document.getElementById("ca-favToggle");
  } else if (elID == 'na'){
    star = document.getElementById("na-favToggle");
  } else {
    star = document.getElementById("ia-favToggle");
  }

  if (star.className === "glyphicon glyphicon-star-empty") {
    star.className = "glyphicon glyphicon-star";
  } else {
    star.className = "glyphicon glyphicon-star-empty";
  }
}

function articleFavourite(articleID){

  axios.patch(url+"/toggleFavourite/" + articleID)
    .then(() => {
      window.location.reload();
    }).catch((error) => {
      console.error(error);
    });    
}

var currentlyEditedArticle;
function articleEdit(article){ 

  $(".page-content").hide();
  $(".edit-form").show();  

  if(article != null){

    let pageID;

    if (document.location.href.includes("index.html")){
      pageID = "ia";
    } else if (document.location.href.includes("articles.html")){
      pageID = "na";
    } else {
      pageID;
    }
    
    currentlyEditedArticle = article;

    document.getElementById(pageID+"_name").value = article.name;
    document.getElementById(pageID+"_description").innerHTML = article.description;
    document.getElementById(pageID+"_source").value = article.source;
    document.getElementById(pageID+"_rating").value = article.rating;
    document.getElementById(pageID+"_url").value = article.url;
  
    if (article.favourite){

      let star = document.getElementById(pageID+"-favToggle");

      if (star.className === "glyphicon glyphicon-star-empty") {
        star.className = "glyphicon glyphicon-star";
      } else {
        star.className = "glyphicon glyphicon-star-empty";
      }
    }

    let newTagData = [];
    let activeTagData = [];

    axios.get(url+"/getTags")
      .then((response) => {
  
        let allTags = response.data;

        for (let articleTag of article.tagList){

          let activeTag = {
            id: articleTag.id,
            text: articleTag.name
          };

          activeTagData.push(activeTag);
        
          var newOption = new Option(activeTag.text, activeTag.id, true, true);
          $('.js-example-basic-multiple').append(newOption).trigger('change');
        }
  
        for (let tag of allTags) { 
          
          if (!(activeTagData.includes(tag.id))){
            let newTag = {
              id: tag.id,
              text: tag.name
            };
            newTagData.push(newTag);
          }
        }
  
        $('.js-example-basic-multiple').select2({
          width: '100%',
          tags: true,
          data: newTagData,
          placeholder: "  Input a tag then press Enter",
          allowClear: true
        });


  
      }).catch((error) => {
        console.error(error);
      });
  }  
}

function submitArticle() {

  let star = document.getElementById("ca-favToggle");
  let isFav = false;

  if (star.className === "glyphicon glyphicon-star-empty") {
    isFav = false;
  } else {
    isFav = true;
  }

  axios.post(url+"/createArticle", {
    name: document.getElementById("ca_name").value,
    description: document.getElementById("ca_description").value,
    source: document.getElementById("ca_source").value,
    rating: document.getElementById("ca_rating").value,
    url: document.getElementById("ca_url").value,
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

function submitArticleEdit(editID){

  let star = document.getElementById(editID+"-favToggle");
  let isFav = false;  

  if (star.className === "glyphicon glyphicon-star-empty") {
    isFav = false;
  } else {
    isFav = true;
  }

  axios.put(url+"/updateArticle?id="+currentlyEditedArticle.id, {
    name: document.getElementById(editID+"_name").value,
    description: document.getElementById(editID+"_description").value,
    source: document.getElementById(editID+"_source").value,
    rating: document.getElementById(editID+"_rating").value,
    url: document.getElementById(editID+"_url").value,
    favourite: isFav
  })
    .then((response) => {
      checkTags(response.data.id);
      console.log(response.data);
      window.location.reload();
    }).catch((error) => {
      console.error(error);
    });
}

function articleDelete(articleID){

  axios.delete(url+"/deleteArticle/" + articleID)
    .then((response) => {
      window.location.reload();
    }).catch((error) => {
      console.error(error);
    });

}

function checkTags(articleID) {

  let chosenTags = document.querySelectorAll(".select2-selection__choice");

  for (let i = 0; i < chosenTags.length; ++i) {
    let tag = chosenTags[i].title;
    axios.patch((url+"/addTag/" + articleID), {
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

  let linkurlref = document.createElement("a");
  linkurlref.href = "https://"+article.url;
  linkurlref.className = "link-item";
  linkurlref.title = "https://"+article.url;

  let linkurlicon = document.createElement("i");
  linkurlicon.className = "glyphicon glyphicon-globe";
  linkurlref.appendChild(linkurlicon);

  cell6.appendChild(linkurlref);

  let favref = document.createElement("a");
  favref.onclick = function() {articleFavourite(article.id);};
  favref.className = "favourite-item";
  favref.title = "Favourite";

  let favicon = document.createElement("i");
  favicon.className = "glyphicon glyphicon-star";
  favref.appendChild(favicon);

  let editref = document.createElement("a");
  editref.onclick = function() {articleEdit(article);};
  editref.className = "edit-item";
  editref.title = "Edit";

  let editicon = document.createElement("i");
  editicon.className = "glyphicon glyphicon-pencil";
  editref.appendChild(editicon);

  let delref = document.createElement("a");
  delref.onclick = function() {articleDelete(article.id);};
  delref.className = "delete-item";
  delref.title = "Delete";

  let delicon = document.createElement("i");
  delicon.className = "glyphicon glyphicon-trash";
  delref.appendChild(delicon);

  cell7.appendChild(favref);
  cell7.appendChild(editref);
  cell7.appendChild(delref);

  row.setAttribute("data-toggle", "tooltip");
  row.setAttribute("data-placement", "bottom");
  for (let tag of article.tagList){
    row.title += (" - "+tag.name+" - ");
  }
  $(row).tooltip();

}

function indexPage() {

  $(".page-content").show();
  $(".edit-form").hide();

  let table = document.getElementById("myFavouritesTable tbody");

  axios.get(url+"/getArticles")
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

  axios.get(url+"/getArticles")
    .then((response) => {
      console.log(response.data);

      let allArticles = response.data;

      for (let i = 0; i < allArticles.length; i++) {

        if (allArticles.length > 5) {
          let j = allArticles.length - (5 - i);
          insertNewRow(table2, allArticles[j]);
        } else {
          insertNewRow(table2, allArticles[i])
        }

        if (i > 5) {
          break;
        }
      }

    }).catch((error) => {
      console.error(error);
    });

}

function articlePage() {

  $(".page-content").show();
  $(".edit-form").hide();

  let table = document.getElementById("myTable tbody");

  axios.get(url+"/getArticles")
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

function createArticlePage() {

  let newTagData = [];

  axios.get(url+"/getTags")
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

      $('.js-example-basic-multiple').select2({
        width: '100%',
        tags: true,
        data: newTagData,
        placeholder: "  Input a tag then press Enter",
        allowClear: true
      });

    }).catch((error) => {
      console.error(error);
    });

}



