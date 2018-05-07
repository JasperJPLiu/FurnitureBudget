package com.edu.zucc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by moshennlin on 2018/2/5.
 */

@Component
public class PortListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private int serverPort;
    private static String host;

    @Value("${server.port}")
    private String port;

    public static void hostSet() {
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            host = "error:" + e;
        }
    }


    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        this.serverPort = event.getEmbeddedServletContainer().getPort();
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}

