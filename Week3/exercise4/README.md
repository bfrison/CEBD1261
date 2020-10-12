## Instructions:
1. Execute ```docker build -t <image_name> .``` to build a docker image form the `Dockerfile`
1. Execute ```docker run -dit -p 8080:80 <image_name> python3 /src/hello.py <your name>``` to start running the container
1. In your browser, visit `localhost:8080/web.html` and you will be greeted by name
