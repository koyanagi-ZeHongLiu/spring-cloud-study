package com.softdev.system.demo.config;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author liuzehong
 * @date 2022/2/22
 */
public class WebSocketDemo {
    public static void main(String[] args) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            WebSocketClient client = new WebSocketClient();
            container.connectToServer(client, new URI("ws://localhost:9999/demo/imserver/1"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
