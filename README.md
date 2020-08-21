# Issue

Aesh version: 2.6

This CLI is configured to have 1 required argument and 1 optional flag (--flag)
aesh CLI does not fail on missing argument if a boolean flag is specified.

Expected successful run:
```
java -jar <app> test helloworld --verbose
# or
java -jar <app> test helloworld
```

where 'test' is the command, and 'helloworld' the argument

For e.g if I run:
```
java -jar <app> test --verbose
```
I expect the CLI to fail with missing argument error. Instead, it happily moves
ahead with further processing, setting the argument field to null.


This reproducer simulates:
```
java -jar <app> test --verbose
```

The successful result would be that an exception is thrown that there is a
missing argument. Right now it happily passes.


# Build
```
mvn clean install
```

# Run
```
java -jar target/aesh-reproducer-1.0-SNAPSHOT-jar-with-dependencies.jar
```
