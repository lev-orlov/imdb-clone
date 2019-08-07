# IMDb clone

Features:
* Search based on parameters such as title, rating, genres, etc. and collaborations search (two 
persons in same title).
* Logged in users can add titles to watchlist and mark them as viewed.

### Demo
![](https://i.imgur.com/EDIEywV.gif)


### Prerequisites

* JDK 1.8
* PostgreSQL
* Gradle
* Yarn
* ~12 GB of storage space

### Setting up

Create database in your PostgreSQL.

Change the following code in application.properties to yours settings
```
spring.datasource.url=jdbc:postgresql://localhost:5432/cloneimdb
spring.datasource.username=postgres
spring.datasource.password=postgres
```
In project directory run
```
yarn install
gradle wrapper
./gradlew build
```

Run app(in IDE or ./runApp.sh), open (http://localhost:8080/) and login as admin@admin.ad 1234. 
On main page use Download CSV button to automatically download (into home dir /Downloads/tables) and unzip 4 files (title.basics.tsv.gz, title.principals.tsv.gz, title.ratings.tsv.gz, name.basics.tsv.gz) [from IMDb](https://www.imdb.com/interfaces/). 
After successful unzipping press Fill Tables button, it will copy contents of the files into the tables. 
When tables are filled you are gonna need to alter them and create some indexes using [this SQL commands](https://gist.github.com/lev-orlov/43198cf4596fd8b12edf6397ae074405).
















