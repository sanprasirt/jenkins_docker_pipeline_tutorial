FROM jenkins:2.60.3

MAINTAINER Sanprasirt b

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh $(cat /usr/share/jenkins/ref/plugins.txt| tr '\n' ' ')

COPY groovy/* /usr/share/jenkins/ref/init.groovy.d/
