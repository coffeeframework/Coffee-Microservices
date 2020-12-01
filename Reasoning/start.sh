#!/bin/bash

git reset HEAD --hard
git clean -fd
git pull
java -jar Reasoning-0.0.1-SNAPSHOT.jar