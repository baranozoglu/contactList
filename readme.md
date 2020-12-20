# Contact List

A simple contact list web application with following features:

1. Listing people
2. Searching by name
3. Paging

See the live application hosted on heroku: https://contactlistwebapp.herokuapp.com

## Usage

By cloning this repo:

1. `$ git clone: https://github.com/baranozoglu/contactList.git`

2. `$ npm install`

3. `$ npm run build`


## Technical Details

Contact list data is provided through a `.csv` file. Application starts by populating the database with data in the file.

* Back-end: Spring Boot
* Front-end: Vue.js
* Database: H2 DB
* Build System: Maven