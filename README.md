# Drugstores-BSS

#### 介绍
药店进销存系统

用于药店人员对药品的进销存操作

本项目采用前后端分离的开发模式,后端主要由servlet实现

适合初学Javaweb的朋友参考

#### 环境说明
- idea 2020

- jdk 12.0

- mySql 8.x

- tomcat 9.x

#### 使用说明
1. mysql数据库执行database目录下drugstore.sql脚本文件

2. idea引入项目资源,

3. 配置tomcat服务器,井将tomcat服务器的服务器地址改为"http://localhost:8080/"

4. tomcat服务器 Applicat context 修改为 "/"

5. 将web\web-inf\lib文件下除fastjson-2.x全部add as library

6. 配置 src/resource/jdbc.properties 文件,将数据库密码与用户名修改成为自己的

7. 如果出现too many connection 报错,可以将上一条文件的初始连接数与最大连接数减少,或者将自己mysql文件的my.ini文件,将最大连接数修改,并重启mysql服务

8. 启动tomcat服务器


