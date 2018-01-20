FROM openjdk:8u121-jdk-alpine
RUN apk add --no-cache curl \
    && curl -sL https://github.com/openfaas/faas/releases/download/0.6.15/fwatchdog > /usr/bin/fwatchdog \
    && chmod +x /usr/bin/fwatchdog \
    && apk del curl

WORKDIR /root/

COPY function	function
COPY Main.java Main.java
RUN javac Main.java

ENV fprocess="java Main"

HEALTHCHECK --interval=1s CMD [ -e /tmp/.lock ] || exit 1

CMD ["fwatchdog"]

