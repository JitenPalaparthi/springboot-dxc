- Pull mysql image

```
docker pull mysql
```

- Run MYSQL docker instance 

```
docker run -d --name=mysql1 -p 33306:3306 -e MYSQL_ROOT_PASSWORD=admin123 -e MYSQL_DATABASE=demodb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin123 mysql
```

- Stop container

```
docker stop mysql1
```

- Start container

```
docker start mysql1
```