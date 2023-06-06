.DEFAULT_GOAL := build-run

c:
	./gradlew clean

b:
	./gradlew clean build

id:
	./gradlew installDist

install:
	./gradlew clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions


build-run: b run

.PHONY: build