package com.bain.grpc.client;

import com.bain.grpc.User;
import com.bain.grpc.User.LoginRequest;
import com.bain.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        // need to create stubs to call an API.
        // that need to generate from proto files.

        userGrpc.userBlockingStub userStubs =  userGrpc.newBlockingStub(channel);
        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("DummyA").setPassword("Dummy").build();
        User.APIResponse response = userStubs.login(loginRequest);
        System.out.println(response.getResponseMessage());
    }
}
