package com.grpc.service;

import com.user.stubs.greet.GreetRequest;
import com.user.stubs.greet.GreetResponse;
import com.user.stubs.greet.GreetServiceGrpc;
import com.user.stubs.greet.Greeting;
import io.grpc.stub.StreamObserver;


public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("You are in the greet service");

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