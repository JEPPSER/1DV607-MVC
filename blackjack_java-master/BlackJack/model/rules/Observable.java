package BlackJack.model.rules;

import java.util.ArrayList;

public abstract class Observable {
	
  private ArrayList<IObserver> observers = new ArrayList<IObserver>();
	
	public void addObserver(IObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObserver() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}
}
