# server-jetty

本分支集成`jetty server`，不使用`spring-boot`自带的tomcat作为服务器。


使用`jetty`需要在pom中去除默认依赖

```xml

<!-- spring boot web集成 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <!-- 这里使用jetty服务器 -->
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!-- 同时加入jetty服务器 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>

```

同时在`application.yml`文件中也要对undertow进行配置：

```yml
server:
  port: 8080
  session-timeout: 1200
  jetty:
    accesslog:
      # 打开Undertow访问日志
      enabled: true
      # 访问日志所在目录
      dir: logs
    # 创建工作线程的I/O线程，默认为2或者CPU个数（有点像nginx的I/O线程）
    io-threads:
    # 工作线程个数，默认为I/O线程个数的8倍
    worker-threads:
    # HTTP POST内容最大长度，默认不限制
    max-http-post-size:
```






