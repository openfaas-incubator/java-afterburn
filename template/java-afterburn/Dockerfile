FROM openjdk:8u121-jdk-alpine
RUN apk add --no-cache curl \
    && curl -sfSL https://github.com/openfaas-incubator/of-watchdog/releases/download/0.1.0/of-watchdog > /usr/bin/fwatchdog \
    && chmod +x /usr/bin/fwatchdog

WORKDIR /root/
COPY com	    com
COPY function	function
COPY Main.java	.

RUN javac Main.java

ENV fprocess="java Main"
ENV mode=afterburn
HEALTHCHECK --interval=1s CMD [ -e /tmp/.lock ] || exit 1

CMD ["fwatchdog"]

