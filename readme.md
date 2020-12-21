
# Contact List
A simple contact list web application with following features:

  
1. Listing people
2. Searching by name
3. Paging

See the live application hosted on my personal server: http://baran.webdeniz.com/

API/back-end side that the client communicates with is hosted on heroku: https://contactlistwebapp.herokuapp.com/contactList


## Usage and Installation

1. `$ git clone: https://github.com/baranozoglu/contactList.git && cd contactList`
2. Run the server/back-end: `$ mvn spring-boot:run`
3. Switch to the client part `$ cd client`
4. Run the client side: `$ npm run build`
5. Application is up and running at https://localhost:8088


## Technical Details

### API

**GET /people?name="Homer"&page=1&size=10** -- Retrieve people by given name and pagination parameters.

Query Parameters:

	name (Optional): Retrieve people with given name, Default value = all people

	page (Optional): Retrieve results of given page value. Default value = 1

	size (Optional): Set each page size. Default value = 10


**GET /upload?csvName=people'** -- Populates the database initially with the data in the given file.

Query Parameters:

	csvName (Required): CSV file name, without the extension.


### Implementation Details

Contact list data is provided through a `.csv` file. Application starts by populating the database with data in the file. File is looked up in the `resources` directory of the application. 

Back-end is a Spring Boot application consists of People model, /GetDataController for people entity operations, PeopleRepository for JPA layer and GetDataService implementation for the business logic. UploadDataController is for csv file operations along with it's service implementation. Pageable DTO is preferred for making the app easily extensible in the future with additional endpoints.

Client side application is written with Vue.js. Table component used for listing people. Axios library is used for making aysnchronous requests from the client side.

On the persistance layer, relational database H2 is used by embedding it into application. 

### Stack

* Back-end: Spring Boot
* Front-end: Vue.js
* Database: H2 DB
* Build System: Maven
* **Testing Library:** 