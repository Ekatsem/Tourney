package ru.netology.domain;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String name){
        super("Player is not registered");
    }


}
