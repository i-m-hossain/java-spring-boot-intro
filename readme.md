# Production and deploy:

To create an executable JAR file, run the following command:

```
./mvnw clean package
```

1. clean: deletes the target folder
2. package: Invoke Maven's package phase, which will cause the verify, compile, and test test phases to be invoked in
   the correct order

To run the executable JAR with Java run the following command:

```
java -jar target/learning-spring-boot-0.0.1-SNAPSHOT.jar
```

## Notion Documentation

    https://bloom-raven-0df.notion.site/JAVA-Spring-Boot-e445b3ea1296470483211f5723974fa0