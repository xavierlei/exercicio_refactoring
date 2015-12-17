package ObserverPattern;

import ObserverPattern.Observer;

public interface Subject {
        void notify(String channel, String message);
        void addObserver(String channel, Observer o);

}