FROM openjdk:8
ADD /Emp-Web/target/Emp-Web.jar /employee/Emp-Web.jar
ADD /Emp-Web/target/Emp-Web-javadoc.jar /employee/Emp-Web-javadoc.jar
ADD /Emp-Web/target/Emp-Web-sources.jar /employee/Emp-Web-sources.jar
ADD /Emp-Service/target/Emp-Service-javadoc.jar /employee/Emp-Service-javadoc.jar
ADD /Emp-Service/target/Emp-Service-sources.jar /employee/Emp-Service-sources.jar
RUN chmod +x /employee

ADD emp-main.sh /emp-main.sh
RUN chmod +x /emp-main.sh

EXPOSE 8484 

## THE LIFE SAVER
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait


CMD /wait && /emp-main.sh
