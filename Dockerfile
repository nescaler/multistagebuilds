FROM gradle:jdk8

MAINTAINER "Nedsayde Escalera"

EXPOSE 8080

COPY . /docker-repo-code

WORKDIR /docker-repo-code

CMD ["gradle", "bootRun", "--stacktrace"]