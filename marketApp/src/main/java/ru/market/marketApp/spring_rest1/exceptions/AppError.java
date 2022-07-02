package ru.market.marketApp.spring_rest1.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AppError {


    private int statusCode;
    private Date date;
    private String message;



    public AppError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.date = new Date();
    }
}
