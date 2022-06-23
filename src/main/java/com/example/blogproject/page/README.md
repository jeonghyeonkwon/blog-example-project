# 페이지 네이션 관련 정리

### <span style="color:gray">초기 데이터 관련 수정 사항은... </span>

[초기 데이터 수정은 여기로!](https://github.com/jeonghyeonkwon/blog-example-project/blob/main/src/main/java/com/example/blogproject/InitDb.java)

```java

public void pageInit(){
            PageUserRequestDto dto = PageUserRequestDto
            .builder()
            .userName("유저")
            .address("주소")
            .intro("소개")
            .build();
            for(int i=1;i<67;i++){
                PageUser user = new PageUser(
                    UUID.randomUUID().toString(),
                    dto.getUserName()+i,
                    dto.getAddress()+i,
                    dto.getIntro()+i);
                em.persist(user);
            }
        }

```

## JPA Pagenation 프레임

[코드 보기](https://github.com/jeonghyeonkwon/blog-example-project/blob/main/src/main/java/com/example/blogproject/page/dto/PagenationFrame.java)

### JPA DTO로 조회 (네이티브 쿼리 X)

[코드 보기](https://github.com/jeonghyeonkwon/blog-example-project/blob/main/src/main/java/com/example/blogproject/page/repository/PageUserRepository.java)

### JSP템플릿

[코드 보기](https://github.com/jeonghyeonkwon/blog-example-project/blob/main/src/main/webapp/WEB-INF/views/pagenation.jsp)
