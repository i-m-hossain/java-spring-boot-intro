## Production and deploy:

To create an executable JAR file, run the following command:

```
./mvnw clean package
```

1. **clean**: deletes the target folder
2. **package**: Invoke Maven's package phase, which will cause verify, compile, and test phases to be invoked in
   the correct order

To run the executable JAR with Java run the following command:

```
java -jar target/learning-spring-boot-0.0.1-SNAPSHOT.jar
```

## Containerization

In the previous section, we learned how to build an Uber JAR and run it on any machine that has a JDK, What if there is
no JDK?

This is where containers and specifically `Docker containers` can help us out.

We can create a production version of our spring boot application using Dockerfiles or by
using `Cloud Native Build packs` to create optimized docker compatible container images that we can run everywhere.

As long as we have a docker desktop running you can run the following command to create an OCI image:

```
./mvnw spring-boot:build-image
docker image ls -a
docker run -it -p8080:8080 learning-spring-boot:0.0.1-SNAPSHOT
```

## Notion Documentation

[Java spring boot note](https://bloom-raven-0df.notion.site/JAVA-Spring-Boot-e445b3ea1296470483211f5723974fa0)

## Links:

1. [Spring Boot Tutorial for Beginners - 2023 Crash Course using Spring Boot 3](https://www.youtube.com/watch?v=UgX5lgv4uVM&ab_channel=DanVega)
2. [Spring Boot: A Tutorial for Beginners](https://www.youtube.com/watch?v=zTAHY0SLQAg&t=2003s&ab_channel=in28minutes-CloudMadeEasy) 