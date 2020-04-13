# Spring Boot 学习笔记

[toc]

## Web

### Servlet Containers

1. [Tomcat](https://tomcat.apache.org/)
2. [Jetty](https://www.eclipse.org/jetty/documentation/current/introduction.html#what-is-jetty)
3. [Undertow](http://undertow.io/)

加载web起步依赖，默认是使用的Tomcat，一般情况下也无需更换使用其他servlet容器。

```xml
<!-- tomcat -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- ubdertow -->
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-web</artifactId>  
    <exclusions>  
        <exclusion>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-starter-tomcat</artifactId>  
        </exclusion>  
    </exclusions>  
</dependency>
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-undertow</artifactId>  
</dependency>
```

> Jetty使用同ubdertow，去除tomcat后添加spring-boot-starter-jetty依赖即可

### start

启动一个SpringBoot项目

```java
// @ComponentScan
// @Configuration
// @EnableAutoConfiguration
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
```

> @SpringBootApplication 相当于 @EnableAutoConfiguration 、@ComponentScan 、@Configuration 三个注解。
> 需要注意的是在未使用@SpringBootApplication注解时需要在测试的@SpringBootTest注解声明启动类

SpringBoot应用启动后启动特定的功能代码，CommandLineRunner 或 ApplicationRunner

```java
@Component
public class MyBean implements CommandLineRunner {
    public void run(String... args) {
        // code
    }
}
```

> CommandLineRunner 接口使用简单字符串获得对应程序参数  
> ApplicationRunner 则通过 ApplicationArguments 获得

配置文件的载入规则: 后载入覆盖先载入

```yml
# 指定应用http服务绑定端口
server:
  port: 26801
```

可以通过命令启动时指定参数配置覆盖

```sh
java -jar target/web-0.0.1-SNAPSHOT.jar --server.port=26800
```

> 配置可以使用环境变量

profile的使用，惯例命名application-{profile}.properties或application-{profile}.yml

```yml
# 指定使用dev配置
spring:
  profiles:
    active: dev
```

> 未设置profiles激活时，使用application-default.properties

配置在代码中的使用

```yml
# 添加配置
name:
  first: 悟空
  last: 孙
```

使用 @Value 和 @ConfigurationProperties 获取，yml文件不能通过@PropertySource获取这里忽略它。

```java
// 使用@Value获取
@Value("${name.first}")
private String firstName;

@Value("${name.last}")
private String lastName;

// 使用@ConfigurationProperties获取
@ConfigurationProperties(prefix = "name")
public class Name {
    private String first;
    private String last;
}
```

> @Value 需要在SpringBean中使用， @ConfigurationProperties 需有 @EnableConfigurationProperties 配合使用

日志

## TODO

### work

@RestController => @Controller + @ResponseBody
@GetMapping => @RequestMapping(method = RequestMethod.GET)
@PostMapping => @RequestMapping(method = RequestMethod.POST)

> 多请求方式支持@RequestMapping配置，简写注解有多个时第一个生效

### package

使用 maven pligin 打包为可执行的jar

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

备注：

```text
spring cloud
    eureka    ---
    Hystrix   ---  
    feign     ---
    config    ---    bootstrap
    bus   ---    rabbitmq / kafka
    gateway   ---
```
