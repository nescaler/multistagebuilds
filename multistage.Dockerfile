FROM gradle:jdk8 AS build
MAINTAINER "Nedsayde Escalera"
COPY . /docker-repo-code
WORKDIR /docker-repo-code
CMD ["gradle", "build", "--stacktrace"]


FROM gradle:jdk8
MAINTAINER "Nedsayde Escalera"
EXPOSE 8080
COPY --from=build /docker-repo-code  /app
WORKDIR /app
CMD ["gradle", "bootRun", "--stacktrace"]

