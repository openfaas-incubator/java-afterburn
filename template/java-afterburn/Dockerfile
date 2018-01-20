FROM openjdk:8u121-jdk-alpine
RUN apk add --no-cache curl \
    && curl -sL https://github.com/openfaas-incubator/of-watchdog/releases/download/0.1.0/of-watchdog \
    > /usr/bin/fwatchdog && chmod +x /usr/bin/fwatchdog \
    && apk del curl

WORKDIR /root/

COPY Handler.java .
RUN javac Handler.java

ENV fprocess="java Handler"

HEALTHCHECK --interval=1s CMD [ -e /tmp/.lock ] || exit 1

CMD ["fwatchdog"]

