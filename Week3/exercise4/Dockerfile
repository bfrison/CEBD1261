FROM httpd
COPY . /src
RUN ["apt-get", "update"]
RUN bash -c "echo Y | apt-get install python3"
