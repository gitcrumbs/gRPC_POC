package com.grpc.server;

import com.grpc.service.GreetServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServerImpl {

    public static void main(String[] args) throws Exception{
        final int PORT = 9090;

        // Create a new server to listen on port 9090
        Server server = ServerBuilder.forPort(PORT)
                .addService(new GreetServiceImpl())
                .build();

        // Start the server
        server.start();

        // Server threads are running in the background.
        System.out.println("Server started...");
        // Don't exit the main thread. Wait until server is terminated.
        server.awaitTermination();
    }
}