package model;

public interface Subject {
    
        void notify(String category, String message);

        void addObserver(String category, Observer o);

}