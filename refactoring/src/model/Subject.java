package model;

public interface Subject {
    
        void notify(String category, String message);
        void addObserver(String category, Observer o);
	/*void notifyApostadores();
        void notifyBookies(String notification);
        void addObserverApostador(Observer obs);
        void addObserverBookie(Observer obs);*/

}