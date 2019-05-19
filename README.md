# mfp-spring-adapter

## Introduction 
1. This a sample project for IBM MobileFirst Platform + Spring + Hibernate/JPA + MySQL

## Prequisite 
1. Installed Java JDK 1.8.x
2. Installed MySQL 8.x.x and create a local database connection.
3. Installed Apache Maven 3.6.x
4. Installed any preferred IDE. Recommended to use Eclipse 2019-03.
5. Installed Apache Lombok 1.x.x in IDE.
6. Git clone and setup `https://github.com/yousoff92/spring-hibernate`
7. Installed IBM MobileFirst Platform `http://mobilefirstplatform.ibmcloud.com/downloads/`

## Getting Started 

Setup `spring-hibernate`
1. `cd` to `spring-hibernate` and execute `mvn clean install` to generate jar file.
2. Generate the jar file again if we do any changes in the project.

Setup IBM MobileFirst Platform
1. `cd` to `../mfp-server/usr/servers/mfp`
2. Open IBM MFP server.xml and add the following lines : 

```
    <!-- Yousoff: Added configuration for JDBC -->
    <!-- Ref : https://www.ibm.com/support/knowledgecenter/SSD28V_9.0.0/com.ibm.websphere.wlp.core.doc/ae/twlp_dep_configuring_ds.html -->
    <!-- Must specify Datasource -->
    <dataSource id="DefaultDataSource" jndiName="jdbc/mysql" type="javax.sql.DataSource">
        <jdbcDriver libraryRef="MySQLLib" javax.sql.DataSource="com.mysql.cj.jdbc.MysqlDataSource"/>
        <properties url="jdbc:mysql://localhost:3306/mydb?useSSL=false&amp;allowPublicKeyRetrieval=true" user="root" password="password"/>
    </dataSource>

    <library id="MySQLLib">
        <file name="/home/yousoff/Documents/library/mysql-connector-java-8.0.11.jar"/>
    </library>
```
3. Modify the JDBC URL and point the MySQL Connector jar file to the correct path.
4. In terminal, execute the `run.sh` to start local MFP server at `http://localhost:9080/mfpconsole`

Setup `mfp-spring-adapter`
1. `cd` to `mfp-spring-adapter` project and build adapter by executing `mvn clean install` 
2. Deploy to local MFP by executing `mvn adapter:deploy`


## Troubleshoot

1. Make sure MySQL Connector version match your local MySQL DB version. Let say your DB is 5.x.x, then change then server.xml to 5.x.x.
