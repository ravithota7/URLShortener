FROM adoptopenjdk/openjdk11:ubi
ENV APP_HOME = /usr/app
WORKDIR $APP_HOME
COPY target/URLShortner-0.0.1-SNAPSHOT.jar urlshortenerapp.jar
EXPOSE 8080
CMD ["java","-jar","urlshortenerapp.jar"]