FROM resin/raspberrypi3-node
MAINTAINER noway0032 <noway0032@gmail.com>
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update -y --assume-yes \
  && apt-get install -y --assume-yes apt-utils \
  && apt-get install oracle-java8-jdk
WORKDIR /usr/src/app
COPY package.json .
EXPOSE 4200
EXPOSE 8181
COPY . .
CMD ["/bin/bash", "-c"]
