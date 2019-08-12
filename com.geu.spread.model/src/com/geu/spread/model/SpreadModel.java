/**
 * 
 */
package com.geu.spread.model;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * @author geu
 *
 */
public class SpreadModel implements ISpreadModel {
	
	String name;
	Rectangle region;
	Color color;
	String imagePath;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Rectangle getRegion() {
		return this.region;
	}

	@Override
	public void setRegion(Rectangle rectangle) {
		this.region = rectangle;
	}
	
	@Override
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String getImage() {
		return this.imagePath;
	}
	
	public void setImage(String image) {
		this.imagePath = image;
	}

}
