## Attendance Monitoring System

### Description:
A maven project which uses 
* Servlets
* JSP and JSTL
* MYSQL Connector

to connect to mysql database and perform 
CRUD operations.

### Endpoints
List Records : [ http://localhost:8080/attendaceMonitor/ ](http://localhost:8080/attendaceMonitor/)

Add Record: 
[http://localhost:8080/attendaceMonitor/new](http://localhost:8080/attendaceMonitor/new)

Edit Record:
[http://localhost:8080/attendaceMonitor/edit?rno=16BCS001](http://localhost:8080/attendaceMonitor/edit?rno=16BCS001)

### Dependancies:
* MySQL
* JDK
* Maven

### Compilation and Deployment :


```bash
mvn clean 
```
```bash
mvn install
```
```bash
mvn clean install tomcat7:run
```

### Mysql Configuration

```sql
create database Attendance;
use Attendance;
create table attendance(rno varchar(8) primary key,subname varchar(22) NOT NULL,name varchar(50) NOT NULL,pdays int(3) NOT NULL,adays int(3) NOT NULL,totdays int(3) NOT NULL);
insert into attendance values("16BCS001","XML AND WEBSERVICES","Surya",70,30,100);
insert into attendance values("16BCS002","XML AND WEBSERVICES","Shankar",80,20,100);
```
