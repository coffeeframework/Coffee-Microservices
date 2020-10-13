FROM ubuntu
MAINTAINER Joan David Colina <joancolina819@gmail.com>

WORKDIR /home
ENV TZ=America/Bogota
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#Instalmos sudo
RUN apt-get update && apt-get install -y sudo
#Instalamos git
RUN yes | sudo apt-get install git
#Instalamos maven
RUN sudo apt update
RUN yes | sudo apt install maven
RUN mvn -version
#Instalamos java
RUN sudo apt update 
RUN yes | sudo apt install -y openjdk-8-jdk
RUN   java -version
#instalamos wget 
RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*
#Clonamos el repositorio
RUN git clone https://github.com/coffeeframework/Coffee-Microservices
WORKDIR /home/Coffee-Microservices/ModelParser
EXPOSE 9090
RUN chmod +x /start.sh
ENTRYPOINT ["java","-jar", "ParserCoffeServer-0.0.1-SNAPSHOT.jar"]


