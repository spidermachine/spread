package com.geu.spread.model;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public interface ISpreadModel {
	
	/**
	 * 
	 * @return
	 */
	String getName();
	/**
	 * 
	 * @param name
	 */
	void setName(String name);
	/**
	 * 
	 * @return
	 */
	Rectangle getRegion();
	/**
	 * 
	 * @param rectangle
	 */
	void setRegion(Rectangle rectangle);
	/**
	 * 
	 * @return
	 */
	Color getColor();
	void setColor(Color color);
	/**
	 * 
	 * @return
	 */
	String getImage();
	/**
	 * 
	 * @param image
	 */
	void setImage(String image);
}
