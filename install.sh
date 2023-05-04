#!/bin/bash

version=1.6

if [ "$(expr substr $(uname -s) 1 10)" == "MINGW64_NT" ]; then
    echo "Installing jq $version for windows x64"
    curl -L -k -o jq.exe "https://github.com/stedolan/jq/releases/download/jq-$version/jq-win64.exe"
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    echo "Installing jq $version for ubuntu"
    curl -L -k -o jq "https://github.com/stedolan/jq/releases/download/jq-$version/jq-linux64"
elif [ "$(uname)" == "Darwin" ]; then
    echo "Installing jq $version for OSX"
    curl -L -k -o jq "https://github.com/stedolan/jq/releases/download/jq-$version/jq-osx-amd64"
fi