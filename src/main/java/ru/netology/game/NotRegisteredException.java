package ru.netology.game;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String name) {
        super("Player with name: "+ name + "not registered");
    }

}
