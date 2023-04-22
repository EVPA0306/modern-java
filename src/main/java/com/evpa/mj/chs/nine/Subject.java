package com.evpa.mj.chs.nine;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
