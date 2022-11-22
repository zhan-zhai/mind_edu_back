# SpringBoot Restful API后端

数据库采用 Neo4j 图数据库

## 本地运行

```
mvn package spring-boot:run
```

## 项目生成 jar 包

- 进入项目根目录下，target目录下生成jar包

```
mvn clean package
```

- jar 包上传到服务器上，执行命令，正常运行：

```
java -jar mindmap-backend-0.0.1-SNAPSHOT.jar
```
 
 ## 考虑用 Docker 容器化运行
 
```
docker build -t docker-spring-boot .
docker run -idt --name demo -p 8899:8899 docker-spring-boot:latest
```
