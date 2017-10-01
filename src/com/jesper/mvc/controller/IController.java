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
	 * @param id
	 * @param value
	 */
	public void update(int id, T value);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T delete(int id);
	
	/**
	 * 
	 * @param value
	 */
	public void view(int id);
	
}
