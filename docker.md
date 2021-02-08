# Docker Cheatsheet
Run - start a container
```sh
$ docker run nginx //nginx is image name
$ docker run ubuntu sleep 5
```

Ps - list containers
```sh
$ docker ps //show running ps
$ docker ps -a //show all ps
```
 STOP - stop a container
```sh
$ docker stop $container_name
```
Rm - Remove a container
```sh
$ docker rm $container_name
```
Images - List images
```sh
$ docker images
```
Rmi - Remove images
```sh
$ docker rmi nginx
```
Pull - download an image
```sh
$ docker pull ubuntu
```
Exec - execute a command
```sh
$ docker exec $process_name cat /etc/hosts
```
Run - attach and detach
```sh
$ docker run kodekloud/simple-webapp //attach
$ docker run -d  run kodekloud/simple-webapp  //detach(backgroud mode), this will give out and ID
```
```sh
$ docker attach $id  //reattaching container
```
Run - tag (specific version)
```sh
$ docker run redis:4.0 //4.0 is the tag
```
Run - STDIN
```sh
$ docker run -i kodekloud/simple-prompt-docker //has input but no prompt
$ docker run -it kodekloud/simple-prompt-docker //has input and prompt
```
Run - PORT mapping
```sh
$ docker run -p 80:5000 kodecloud/simple-webapp
```
Run - Volume Mapping
```sh
$ docker run -v $destination_dir:/var/lib/mysql mysql
```
Inspect Container
```sh
$ docker inspect $container_name
```
Container Logs
```sh
$ docker logs $container_name
```
ENV Variables in Docker
```sh
$ docker run -e APP_COLOR=blue simple-webapp-color
```


CREATE MY OWN IMAGE

Create a Dockerfile
```dockerfile
//Dockerfile
FROM Ubuntu

RUN apt-get update
RUN apt-get install python

RUN pip install flask
RUN pip install flask-mysql

COPY . /opt/source-code

ENTRYPOINT FLASK_APP=/opt/source-code/app.py flask run
```


Build
```sh
$ docker build Dockerfile -t muhdlaziem/custom-app
```
Push
```sh
$ docker push muhdlaziem/custom-app
```

History
```sh
$ docker history muhdlaziem/custom-app
```










