## [최주호] 스프링 강의 과제2

### x-www-form-urlencoded와 json 파싱

1. 브라우저를 활용하여 /login 주소로 Get요청을 한다.
```http request
GET http://localhost:20000/login
```
2. GET요청시에 QueryString을 전달한다.
```http request
?username=값&password=값
GET http://localhost:20000/login?username=값&password=값
```
3. 서블릿에 `@WebServlet("/login")` 이라고 등록해둔다.
4. request.getParameter로 쿼리 스트링 값을 변수에 받는다.
```text
변수명은 queryString의 key값과 동일하게 해서 받는다.
```
5. response.getWriter로 응답한다.
    - 응답형태 application/json
    - 응답예시
```json
{
  "code": 1,
  "msg": "loginSuccess"
}
```
```java
class ResponseMsg {
    private int code;
    private String msg;
    
    // getter, setter, constructor
}
```
위와 같은 클래스를 생성하고, 생성자를 통해 값을 주입한다.<br/>
해당 객체를 GSON을 이용하여 JSON으로 변경한다.<br/>
응답한다.
