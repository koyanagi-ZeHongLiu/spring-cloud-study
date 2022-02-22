package com.softdev.system.demo;

import com.softdev.system.demo.config.WebSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

/**
 * @author Moshow
 */
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			WebSocketClient client = new WebSocketClient();
			container.connectToServer(client, new URI("ws://localhost:9999/demo/imserver/1"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
