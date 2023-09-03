# 가장 간단한 방식의 웹소켓을 이용한 채팅

## 웹소켓 코드 작성 방식
- ```TextWebSocketHandler```을 상속 받아 웹 소켓을 이용한 동작을 구현한다.
  - 문자열 기반 웹 소켓 핸들러를 이용한다.
- mvc에서 처리하듯 웹 소켓에 접근하기 위한 엔드포인트가 필요한데 WebSocketConfigurer을 구현하여 설정할 수 있다.
  - ```@Configuration```을 사용하여 자바 설정 빈으로 등록한다.
  - 웹 소켓을 사용하여 처리할 수 있도록 ```@EnableWebSocket```을 추가한다.
  - 웹 소켓을 통해 접근할 수 있도록 endpoint mapping을 한다.
    - 클라이언트에서 웹 소켓에 접근하는 uri는 ```ws://localhost:8080/```를 사용한다.

## 주요 클래스 구현
- [웹 소켓 동작 핸들러](src/main/java/io/gaegulgaegul/websocketchatting/adapter/in/socket/ChatSocketAdapter.java)
- [웹 소켓 등록 설정](src/main/java/io/gaegulgaegul/websocketchatting/config/WebSocketConfiguration.java)

## 참고
- [WebSocket - WebSocket](https://velog.io/@yyong3519/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%9B%B9%EC%86%8C%EC%BC%93#1-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%B6%94%EA%B0%80)