package org.noip.olyol95.charactersheet.entities;

import java.io.Serializable;

public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String title,level,modifier,check;;
	
	public Attribute(String title) {
		
		this.title = title;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
	
	

}
