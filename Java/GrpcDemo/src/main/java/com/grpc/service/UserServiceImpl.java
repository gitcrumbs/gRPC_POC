package com.grpc.service;

import com.shopping.db.H2DatabaseConnection;
import com.shopping.db.User;
import com.shopping.db.UserDao;
import com.shopping.stubs.user.Gender;
import com.shopping.stubs.user.UserRequest;
import com.shopping.stubs.user.UserResponse;
import com.shopping.stubs.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    UserDao userDao = new UserDao();


    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {


        User user = userDao.getDetails(request.getUsername());

        UserResponse.Builder userresponsebuilder = UserResponse.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setName(user.getName())
                .setAge(user.getAge())
                .setGender(Gender.valueOf(user.getGender()));

        UserResponse userResponse = userresponsebuilder.build();
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();




    }




}
