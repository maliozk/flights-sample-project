package com.flight.sample.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}

	@Component
	public class H2 {

		private org.h2.tools.Server webServer;

		private org.h2.tools.Server tcpServer;

		@EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
		public void start() throws java.sql.SQLException {
			this.webServer = org.h2.tools.Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
			this.tcpServer = org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
		}

		@EventListener(org.springframework.context.event.ContextClosedEvent.class)
		public void stop() {
			this.tcpServer.stop();
			this.webServer.stop();
		}

	}

}
