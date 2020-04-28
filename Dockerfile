FROM openjdk:8
ADD /Emp-Web/target/Emp-Web.jar /employee/Emp-Web.jar
ADD /Emp-Web/target/Emp-Web-javadoc.jar /employee/Emp-Web-javadoc.jar
ADD /Emp-Web/target/Emp-Web-sources.jar /employee/Emp-Web-sources.jar
ADD /Emp-Service/target/Emp-Service-javadoc.jar /employee/Emp-Service-javadoc.jar
ADD /Emp-Service/target/Emp-Service-sources.jar /employee/Emp-Service-sources.jar
EXPOSE 8484
CMD ["java", "-jar", "/employee/Emp-Web.jar"]
