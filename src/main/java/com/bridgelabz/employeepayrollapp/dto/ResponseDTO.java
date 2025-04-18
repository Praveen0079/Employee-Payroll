//ResponseDTO
package com.bridgelabz.employeepayrollapp.dto;
import lombok.Data;

public @Data class ResponseDTO {
    private String message;
    private Object data;

    //used lombok @Data so need of creating getter and setters
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
/*

GeneratedValue Methods

DTO/DAO

 */