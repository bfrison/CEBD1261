FROM node
RUN ["mkdir", "/home/server"]
COPY . /home/server
WORKDIR /home/server
RUN ["npm", "install"]
CMD ["npm", "start"]
