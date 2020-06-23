## springboot2.0集成websocket,实现后台向前端推送消息

#### 什么是websocket
````
    WebSocket协议是基于TCP的一种新的网络协议。
    它实现了浏览器与服务器全双工(full-duplex)通信——允许服务器主动发送信息给客户端。
````

#### WebSocketServer
````
    1.因为WebSocket是类似客户端服务端的形式(采用ws协议),那么这里的WebSocketServer其实
    就相当于一个ws协议的Controller
    2.直接 @ServerEndPoint("/imserver/{userId}"),@Component启用即可,然后在里面实现
    @OnOpen开启连接,@OnClose关闭连接,@OnMessage接收消息等方法
    3.新建一个ConcurrentHashMap webSocketMap 用于接收当前userId的WebSocket,方便IM之间,
    对userId进行推送消息.单机版实现到这里就可以
    4.集群版 (多个ws节点) 还需要借助mysql或者redis进行处理,改造对应的sendMessage方法即可
````