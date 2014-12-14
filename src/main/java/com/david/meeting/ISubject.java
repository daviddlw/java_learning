package com.david.meeting;

public interface ISubject
{
	public void registerObserver(ICustomObserver observer);
	
	public void removeObserver(String name);
	
	public void notifyObservers();
}
