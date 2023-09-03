# STOMP를 이용한 웹 소켓 통신 채팅

## STOMP
> 직접 session을 처리하지 않고 어플리케이션에서 proxy를 처리 방식과 유사한 기능을 사용할 수 있다.

- header 작성 가능
  - destination으로 uri를 설정할 수 있다.
- 커멘드를 통해 통신을 구성할 수 있다.
  - SEND, SUBSCRIBE, MESSAGE

## STOMP 메세지 브로커 코드 작성 방식
- ```@EnableWebSocketMessageBroker```을 추가하여 해당 설정 클래스를 통해 웹 소켓 메세지 브로커를 활성화 한다.
- ```WebSocketMessageBrokerConfigurer``` 인터페이스를 상속하여 아래 메서드를 재구현한다.
  - ```configureMessageBroker```: PUB/SUB uri prefix를 설정한다.
  - ```registerStompEndpoints```: 웹 소켓 서버와 연결할 uri 및 CORS를 설정한다.
    - [선택사항] 모든 브라우저에서 접근 가능하도록 ```.withSockJS()```

## MessageMapping
- 웹 소켓 통신을 위한 Endpoint 설정에 ```@MessageMapping```으로 설정할 수 있다.
```java
/**
 * 채팅 웹 소켓 어댑터
 */
@RestController
@RequiredArgsConstructor
class ChatRoomSocketAdapter {
  ...
  
  /**
   * 채팅 메세지 전달
   * @param request
   */
  @MessageMapping("/chat/message")
  void chat(@Valid ChatRequest request) {
    sendMessageUseCase.sendMessage(request);
  }
  ...
}
```

## 주요 클래스 구현
- [웹 소켓 메세지 브로커 구현](src/main/java/io/gaegul/websocketstompchatting/config/WebSocketBrokerConfiguration.java)
- [웹 소켓 메세지 전달 포트 구현](src/main/java/io/gaegul/websocketstompchatting/adapter/out/broker/ChatMessageBrokerAdapter.java)
- [웹 소켓 화면 처리](src/main/resources/templates/chat/room.html)

## 참고
- [웹 소켓에 대해 알아보자! - 실전 편](https://tecoble.techcourse.co.kr/post/2021-09-05-web-socket-practice/)
- [Spring WebSocket 소개](https://supawer0728.github.io/2018/03/30/spring-websocket/)