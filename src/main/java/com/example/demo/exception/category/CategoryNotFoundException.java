package com.example.demo.exception.category;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super();
    }
    public CategoryNotFoundException(String message) {
        super(message);
    }
    public CategoryNotFoundException(Throwable cause) {
        super(cause);
    }
    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
