package com.softdev.system.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;

/**
 * @author liuzehong
 * @date 2022/2/22
 */
@ClientEndpoint
public class WebSocketClient {

    private static Logger logger = LoggerFactory.getLogger(WebSocketClient.class);
    private Session session;
    @OnOpen
    public void open(Session session){
        logger.info("Client WebSocket is opening...");
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message){
        logger.info("Server send message: " + message);
    }

    @OnClose
    public void onClose(){
        logger.info("Websocket closed");
    }

    /**
     * 发送客户端消息到服务端
     * @param message 消息内容
     */
    public void send(String message){
        this.session.getAsyncRemote().sendText(message);
    }
}
