# Blog_example

블로그 설명용 예제 입니다.

### <span style="color:gray">application.yml 추가</span>

위치는 src/main/resource 안에 내용을 추가해 주세요

```YAML
server:
  port: #포트번호
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: #mysql 유저
    password: #mysql 비밀번호
    url: jdbc:mysql://127.0.0.1:3306/{데이터베이스 명}?serverTimezone=Asia/Seoul
  jpa:
    hibernate:
      ddl-auto: create
    open-in-view: true
    properties:
      hibernate:
        format_sql: true
        default_batch_fetch_size: 100
        use_sql_comments: true
```

### <span style="color:gray">기본 데이터 관련</span>

[initDB](https://github.com/jeonghyeonkwon/blog-example-project/blob/main/src/main/java/com/example/blogproject/InitDb.java)

## 1. 스프링 페이지 네이션 관련 (RestApi or JSP 템플릿 엔진)

[페이지 네이션 관련 내용](https://github.com/jeonghyeonkwon/blog-example-project/tree/main/src/main/java/com/example/blogproject/page)

[JSP 코드](https://github.com/jeonghyeonkwon/blog-example-project/blob/main/src/main/webapp/WEB-INF/views/pagenation.jsp)

## 2. Jquery를 이용한 동적 페이지 관련

### http://loocalhost:포트번호/dynamic-jquery-form (페이지 경로)

[JSP 코드](https://github.com/jeonghyeonkwon/blog-example-project/blob/main/src/main/webapp/WEB-INF/views/pagenation.jsp)

[JS 코드](https://github.com/jeonghyeonkwon/blog-example-project/tree/main/src/main/resources/static/js)