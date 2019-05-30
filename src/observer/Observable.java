package observer;

public interface Observable
{
	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notify(Object o);
}
