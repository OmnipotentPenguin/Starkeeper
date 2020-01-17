# StarKeeper Project

Project One for QA, completed on the 17th Jan 2020

## Index
[The Brief](#brief)
   
[The Development](#architecture)
   * [Initial Plan](#init)
   * [Delivered Solution](#outcome)
	
[Testing](#testing)
     
[Deployment](#depl)
   * [Technologies Used](#tech)

[Improvements for the Future](#improve)

[Author](#auth)

<a name="brief"></a>
## The Brief

The brief was to create an OOP-based application with utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training. The application must manipulate two tables with full CRUD functionality.

### The Solution

The solution was an Article Storage tool, dubbed StarKeeper, that allows a user to store sets of data pertaining to a web link in a table, with each data set tied to a series of tags that would summarize the contained information.

This required two tables (an article table and a tag table) tied together by a many-to-many relationship, where each article can have multiple tags, and each tag can be assigned to multiple articles.

<a name="architecture"></a>
## The Development
<a name="init"></a>
### Initial Plan
#### Entity Relationship Diagram - Initial
![Initial ERD](/Documentation/Starkeeper_ERD.png)

The initial ERD consisted of 3 tables: 
* Articles
* Tags 
* Users

An additional joining table was tied between the article and tag tables, which was then itself tied to the users table. It was later decided that this level of complexity was unnecessary for a first iteration, and so the users table along with its joining table were dropped from the project.

#### Wireframes
![HomePage Wireframe](/Documentation/Homepage.png)
![NewArticle Wireframe](/Documentation/Newarticle.png)

Wireframes, built off of the ERD's and taking into account acceptance criteria, were developed to better visualise the interactions a user may have with the product.

#### API Development
![API Development Diagram](/Documentation/API_Development_Diagram.png)

A simple API Development Diagram developed to visualise the back-end functions of the application.

<a name="outcome"></a>
### Delivered solution
#### Entity Relationship Diagram - Final
![Final ERD](/Documentation/Starkeeper_ERD_Simple.png)

In addition to the removal of the user table, the final ERD had many of the article values stripped away. This was done to simplify interactions with the user and minimize superfluous entries to each article. Instead, greater focus could be placed on the tag inputs to provide additional information.

### Final Appearance
![HomePage Wireframe](/Documentation/HomepageFinal.png)
![NewArticle Wireframe](/Documentation/NewarticleFinal.png)

<a name="testing"></a>
## Testing

JUnit, Mockito and Selenium were used for automated testing, with test coverage for the backend at 90.1%. SonarQube was used for static reporting and refactoring.

[Link to Final Surefire Report](/Documentation/surefire-report.pdf)

<a name="depl"></a>
## Deployment

The build, test and deployment process was automated using Jenkins, with a webhook to GitHub which was triggered with every push event

This application can be deployed both locally and externally through a virtual machine.

![Deployment Pipeline](/Documentation/ci-pipeline.png)
<a name="tech"></a>
### Technologies Used

* H2 Database Engine - Database
* Java/Eclipse - Back-End
* Visual Studio Code - Front-End
* Maven - Dependency Management
* [Git](https://github.com/OmnipotentPenguin/Starkeeper) - VCS
* [Trello](https://trello.com/b/4hNrMAWC/star-keeper-development) - Project Tracking
* Jenkins - CI Server
* Tomcat - Deployment
* Surefire - Test Reporting
* SonarQube - Static Testing
* AWS - Live Environment

<a name="improve"></a>
## Improvements for the Future

Current functionality for StarKeeper becomes quite limited when the number of articles increase beyond the size of the webpage. In future iterations, I'd like to begin the development for the search and filtering functionality that was considered at the start of the project, potentially searching through name and description or including an additional tag drop-down list that filters results based on the selected tags.

Beyond that, I would like to revisit the idea of multiple user accounts, each with a personal list of tags and articles, which interaction between user accounts over the homepage (such as trending articles) or a shared rating system for each article.

<a name="auth"></a>
## Author

Adam Martin

