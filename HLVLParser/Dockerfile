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
RUN  yes | sudo apt install default-jdk
RUN   java -version
#instalamos wget 
RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*
#Clonamos el repositorio
WORKDIR /home
RUN git clone https://github.com/coffeeframework/Coffee-Microservices
WORKDIR /home/Coffee-Microservices/HLVLParser
#RUN ls
#RUN java -jar /home/Coffee-Microservices/HLVLParser/dependencies/HLVLParserV1.2.jar /home/Coffee-Microservices/HLVLParser/hlvl/modelX.hlvl
EXPOSE 7071
RUN chmod +x start.sh
ENTRYPOINT ["bash","start.sh"]





