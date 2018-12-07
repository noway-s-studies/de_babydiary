#!/bin/bash
echo -e "\n###\n###\t SH script started, system: \n###"
sudo df -h
sudo free -m

if [ "$1" != "" ]; then
        PROJECT_NAME="$1"
else
        PROJECT_NAME="pabydiary-frontend"
fi
echo -e "\n###\n###\t Name of project: $PROJECT_NAME \n###\n"

sudo mkdir -p /docker-temp
sudo mkdir -p /docker-temp/$PROJECT_NAME
echo -e "\n###\n###\t Libraries created \n###\n"

sudo docker rmi -f noway0032/$PROJECT_NAME:latest
sudo docker rmi -f $(docker images --all -q -f "since=resin/raspberrypi3-node")
echo -e "\n###\n###\t The earlier '$PROJECT_NAME' local image deleted \n###\n"

sudo docker build -f jenkins/Dockerfile -t noway0032/$PROJECT_NAME:latest .
echo -e "\n###\n###\t The new '$PROJECT_NAME' local image constructed \n###\n"

sudo docker rm -f $PROJECT_NAME
echo -e "\n###\n###\t The earlier '$PROJECT_NAME' repository deleted \n###\n"

sudo docker run -d --restart always --name $PROJECT_NAME -v /docker/$PROJECT_NAME:/usr/src/assets/temporary -p 80:4200 noway0032/$PROJECT_NAME:latest
echo -e "\n###\n###\t The new '$PROJECT_NAME' local repo started \n###\n"

sudo rm -rf *
echo -e "\n###\n###\t GIT folder deleted, system: \n###"
sudo df -h
sudo free -m
