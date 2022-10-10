package com.grpc.service;

import io.grpc.stub.StreamObserver;
import proto.greet.GreetRequest;
import proto.greet.GreetResponse;
import proto.greet.GreetServiceGrpc;
import proto.greet.Greeting;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("You are in the greet method or the greet service");

        // we get the greeting object from the request (as defined in the proto file)
        Greeting greeting = request.getGreeting();
        String result = "Hello " + greeting.getFirstName() + greeting.getLastName();

        // build our response where the type should be GreetResponse
        GreetResponse response = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);// send the response
        responseObserver.onCompleted();// complete the execution
    }
}