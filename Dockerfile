FROM andreptb/oracle-java:8
ENV PROFILE dev
EXPOSE 8080
COPY build/libs/web-application-data-linking-1.0-SNAPSHOT.jar /usr/local/web-application/
WORKDIR /usr/local/web-application/
CMD java -XX:+UseParallelGC -XX:-UseGCOverheadLimit -Dspring.profiles.active=dev -jar web-application-data-linking-1.0-SNAPSHOT.jar
