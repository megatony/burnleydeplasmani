FROM maven:3.5.0-jdk-8-alpine

WORKDIR /usr/src/app

# First copy only the pom file. This is the file with less change
COPY ./pom.xml .

# Download the package and make it cached in docker image
RUN mvn -B -f ./pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve

# Copy the actual code
COPY ./ .

# Then build the code
RUN mvn -B -f ./pom.xml -s /usr/share/maven/ref/settings-docker.xml package

# The rest is same as usual
EXPOSE 8888

CMD ["java", "-jar", "./target/burnleydeplasmani-0.0.1-SNAPSHOT.jar"]