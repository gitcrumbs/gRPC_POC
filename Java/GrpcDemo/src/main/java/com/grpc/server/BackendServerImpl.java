package com.grpc.server;
   import com.grpc.service.GreetServiceImpl;
   import com.grpc.service.UserServiceImpl;
   import io.grpc.Server;
   import io.grpc.ServerBuilder;

public class BackendServerImpl {

    public static void main(String[] args) throws Exception{
        final int PORT = 9091;

        // Create a new server to listen on port 9090
        Server server = ServerBuilder.forPort(PORT)
                .addService(new UserServiceImpl())
                .addService(new GreetServiceImpl())
                .build()
                .start();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("Shutting down Server ");
                server.shutdown();

            }
        });

        // Server threads are running in the background.
        System.out.println("Server started on Port "+PORT);
        // Don't exit the main thread. Wait until server is terminated.
        server.awaitTermination();
    }
}