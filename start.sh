#!/bin/bash

ENVIRONMENT=""

build_application()
{
  gradle clean
  gradle build
}

deployment_dev()
{
  build_application
  gradle bootRun --args='--spring.profiles.active=dev'
}

deployment_hml()
{
  build_application
  gradle bootBuildImage
  docker-compose pull
  docker-compose up -d
  docker-compose ps
}

environment_request()
{
  echo "In which environment do you want to run? "
  echo "DEV | HML "
  read ENVIRONMENT
}

while [ "$ENVIRONMENT" == "" ]
do
  environment_request
  if [ "$ENVIRONMENT" == "DEV" ]; then
    deployment_dev
  elif [ "$ENVIRONMENT" == "HML" ]; then
    deployment_hml
  else
    echo "Invalid environment. Try again!"
    ENVIRONMENT=""
  fi
done

echo "Running in the $ENVIRONMENT environment"
