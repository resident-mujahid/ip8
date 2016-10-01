## Project Name
Wildlife Tracker

## Features
This app will help rangers log sightings for animals that may or may not be endangered.

##Technologies
Java, JUnit, Gradle, Spark, PSQL

## Usage
To use the code, you can clone the repository at: [https://github.com/mehequanna/java-project4](https://github.com/mehequanna/java-project4).
* $ git clone https://github.com/mehequanna/java-project4
* $ cd java-project4
* $ gradle run
* Go to localhost:4567 in your browser

##Database Instructions (postgres/psql)
* CREATE DATABASE wildlife_tracker; (Run in psql)
* CREATE TABLE sightings (id serial PRIMARY KEY, ranger_name varchar, location varchar, animal_id int, timestamp timestamp);
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar, endangered varchar, health varchar, age varchar);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
* \c wildlife_tracker
* Finally check for tables by running: \dt


## Author
Stephen Emery

##License
This work can be used under the MIT License.
Copyright (c) 2016 Stephen Emery
