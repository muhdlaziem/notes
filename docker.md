# Docker Cheatsheet

Run - start a container

```bash
$ docker run nginx //nginx is image name
$ docker run ubuntu sleep 5
```

Ps - list containers

```bash
$ docker ps //show running ps
$ docker ps -a //show all ps
```

STOP - stop a container

```bash
$ docker stop $container_name
```

Rm - Remove a container

```bash
$ docker rm $container_name
```

Images - List images

```bash
$ docker images
```

Rmi - Remove images

```bash
$ docker rmi nginx
```

Pull - download an image

```bash
$ docker pull ubuntu
```

Exec - execute a command

```bash
$ docker exec $process_name cat /etc/hosts
```

Run - attach and detach

```bash
$ docker run kodekloud/simple-webapp //attach
$ docker run -d  run kodekloud/simple-webapp  //detach(backgroud mode), this will give out and ID
```

```bash
$ docker attach $id  //reattaching container
```

Run - tag \(specific version\)

```bash
$ docker run redis:4.0 //4.0 is the tag
```

Run - STDIN

```bash
$ docker run -i kodekloud/simple-prompt-docker //has input but no prompt
$ docker run -it kodekloud/simple-prompt-docker //has input and prompt
```

Run - PORT mapping

```bash
$ docker run -p 80:5000 kodecloud/simple-webapp
```

Run - Volume Mapping

```bash
$ docker run -v $destination_dir:/var/lib/mysql mysql
```

Inspect Container

```bash
$ docker inspect $container_name
```

Container Logs

```bash
$ docker logs $container_name
```

ENV Variables in Docker

```bash
$ docker run -e APP_COLOR=blue simple-webapp-color
```

CREATE MY OWN IMAGE

Create a Dockerfile

```text
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

```bash
$ docker build Dockerfile -t muhdlaziem/custom-app
```

Push

```bash
$ docker push muhdlaziem/custom-app
```

History

```bash
$ docker history muhdlaziem/custom-app
```

