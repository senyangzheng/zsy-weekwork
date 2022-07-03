package com.example.server;

import com.rpc.core.netty.server.RpcNettyServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) throws Exception {

        final int port = 8080;
        final RpcNettyServer rpcNettyServer = new RpcNettyServer(port);

        try {
            rpcNettyServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rpcNettyServer.destroy();
        }
    }

}
