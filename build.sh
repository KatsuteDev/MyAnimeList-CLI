#!/bin/bash

version=1.0.0
year=2023
name=mal
vendor=Katsute

mvn clean
mvn package

mkdir -p staging

cp target/mal.jar staging
cp LICENSE staging/LICENSE

if [ "$(expr substr $(uname -s) 1 10)" == "MINGW64_NT" ]; then
    echo "Building for windows x64"
    cp jq.exe staging
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    echo "Building for ubuntu"
    cp jq staging
elif [ "$(uname)" == "Darwin" ]; then
    echo "Building for OSX"
    cp jq staging
fi