#!/bin/bash

git reset HEAD --hard
git clean -fd
git pull
cd ..
mvn clean install -DskipTests
cd visibleTarget
mv ../target/Reasoning-0.0.1-SNAPSHOT.jar Reasoning-0.0.1-SNAPSHOT.jar
java -jar Reasoning-0.0.1-SNAPSHOT.jar