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

#Descargamos minizinc 2.2.3
RUN wget https://github.com/MiniZinc/MiniZincIDE/releases/download/2.3.0/MiniZincIDE-2.3.0-bundle-linux-x86_64.tgz
#Descromprimimos el archivo .tgz
RUN tar xf MiniZincIDE-2.3.0-bundle-linux-x86_64.tgz
WORKDIR /home/MiniZincIDE-2.3.0-bundle-linux/bin

ENV PATH="/home/MiniZincIDE-2.3.0-bundle-linux/bin:${PATH}"
ENV LD_LIBRARY_PATH="/home/MiniZincIDE-2.3.0-bundle-linux/lib:$LD_LIBRARY_PATH"
ENV QT_PLUGIN_PATH="/home/MiniZincIDE-2.3.0-bundle-linux/plugins:$QT_PLUGIN_PATH"
RUN echo $PATH 
RUN echo $LD_LIBRARY_PATH 
RUN echo $QT_PLUGIN_PATH 
RUN minizinc --solvers
#PATH=$PATH:/Users/Angela/Coffee/apache-maven-3.6.0/bin
#Descargamos Picat
WORKDIR /home
RUN sudo apt update 
RUN  yes | sudo apt install nano
RUN wget http://picat-lang.org/download/picat30_1_linux64.tar.gz
RUN tar xf picat30_1_linux64.tar.gz
WORKDIR /home/Picat/lib
RUN chmod +x *

#Descargamos las librerias de picat
WORKDIR /home/MiniZincIDE-2.3.0-bundle-linux/share/minizinc
RUN mkdir globals
RUN wget http://picat-lang.org/flatzinc/picat_globals.tar.gz
RUN tar -C globals -xf picat_globals.tar.gz
RUN mv globals picat_sat

#Descargando el .msc que necesita minizinc para funcionar
WORKDIR /home/MiniZincIDE-2.3.0-bundle-linux/share/minizinc/solvers
RUN wget https://github.com/coffeeframework/Coffee-Microservices/raw/master/Reasoning/archivos%20de%20solvers/msc/picat_sat_cmd_line.msc
RUN ls -la
#Descargando el .sh que necesita picat para funcionar
WORKDIR /home/Picat
RUN wget https://raw.githubusercontent.com/coffeeframework/Coffee-Microservices/master/Reasoning/archivos%20de%20solvers/sh%20files/picat.sh
RUN chmod +x picat.sh
RUN ls 
#Clonamos el repositorio de JminiZinc
WORKDIR /home
#RUN git clone https://github.com/siemens/JMiniZinc
RUN ls 
ENV PATH="/home/Picat:${PATH}"
RUN echo $PATH 
RUN git clone https://github.com/coffeeframework/Coffee-Microservices
RUN minizinc --solvers
WORKDIR /home/Coffee-Microservices/Reasoning
RUN ls
EXPOSE 9091
RUN chmod +x start.sh
ENTRYPOINT ["bash","start.sh"]
