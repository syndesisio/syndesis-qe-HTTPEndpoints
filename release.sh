#!/usr/bin/env bash

if [ "$#" -eq 0 ]; then
	echo "No tag specified, using default syndesisqe/httpendpoints"
	TAG="syndesisqe/httpendpoints"
else
	TAG="$1"
fi

echo "Building project"
mvn clean install

echo "Building docker image"

docker build . -t $TAG

docker push $TAG
