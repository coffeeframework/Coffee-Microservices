#!/bin/bash

git reset HEAD --hard
git clean -fd
git pull
mvn clean install -DskipTests
mv target/HLVLParser-0.0.1-SNAPSHOT.jar HLVLParser-0.0.1-SNAPSHOT.jar
java -jar HLVLParser-0.0.1-SNAPSHOT.jar