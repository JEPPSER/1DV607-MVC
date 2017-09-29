package com.jesper.mvc.controller;

/**
 * 
 * @author Oskar
 *
 * @param <T>
 */
public interface IController<T> {
	
	/**
	 * 
	 * @param value
	 */
	public void create(T value);
	
	/**
	 * 
	 * @param value
	 */
	public void update(T value);
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public T delete(T value);
	
	/**
	 * 
	 * @param value
	 */
	public void view(T value);
	
}
