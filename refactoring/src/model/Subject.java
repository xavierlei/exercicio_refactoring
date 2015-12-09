package model;

public interface Subject {

	void notifyApostadores();
        void notifyBookies(String notification);
        void addObserverApostador(Observer obs);
        void addObserverBookie(Observer obs);

}