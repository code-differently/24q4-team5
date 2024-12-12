FROM ubuntu:latest
LABEL authors="davidsmith"

ENTRYPOINT ["top", "-b"]