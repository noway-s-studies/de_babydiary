FROM resin/raspberrypi3-node
MAINTAINER noway0032 <noway0032@gmail.com>
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update -y --assume-yes \
  && apt-get install -y --assume-yes apt-utils
WORKDIR /usr/src/app
COPY package.json .
RUN npm install
EXPOSE 4200
COPY . .
CMD ["npm", "start"]
