
# File: `dockers/jenkins/Dockerfile` (相关片段)
FROM jenkins/jenkins:lts
USER root

RUN apt-get update && apt-get install -y maven git && rm -rf /var/lib/apt/lists/*

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt --verbose

USER jenkins
