package org.noip.olyol95.charactersheet.entities;

import java.io.Serializable;

public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String title,misc,check;
	private boolean trained;

	public Skill(String title) {
		
		this.title = title;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public boolean isTrained() {
		return trained;
	}

	public void setTrained(boolean trained) {
		this.trained = trained;
	}
	
	
	
}
