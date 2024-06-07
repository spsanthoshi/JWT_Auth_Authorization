package com.neuron.admin_server.dto;


public record ApiErrorResponse(
    int errorCode,
    String description) {

}
