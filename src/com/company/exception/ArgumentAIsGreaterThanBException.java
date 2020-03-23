package com.company.exception;

public class ArgumentAIsGreaterThanBException extends RuntimeException {

    public ArgumentAIsGreaterThanBException() {
        super("Argument a should be grater than argument b");
    }
}
