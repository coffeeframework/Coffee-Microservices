#!/bin/bash

git clean -fd
git pull
mvn clean install -DskipTests
mv target/ParserCoffeServer-0.0.1-SNAPSHOT.jar ParserCoffeServer-0.0.1-SNAPSHOT.jar
java -jar ParserCoffeServer-0.0.1-SNAPSHOT.jar