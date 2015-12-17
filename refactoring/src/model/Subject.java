package model;

public interface Subject {
        void notify(String channel, String message);
        void addObserver(String channel, Observer o);

}