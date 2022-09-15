#!/bin/bash

MAVEN=./mvnw
MAVEN_WIN=mvnw.cmd

all:
	$(MAVEN) clean compile package assembly:single

linux: all
	java -jar target/quebra-barreira-1.0-SNAPSHOT-jar-with-dependencies.jar

winComp:
	$(MAVEN_WIN) clean compile package assembly:single

windows: winComp
	java -jar target/quebra-barreira-1.0-SNAPSHOT-jar-with-dependencies.jar
	
clean:
	$(MAVEN) clean