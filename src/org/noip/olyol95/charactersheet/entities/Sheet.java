package org.noip.olyol95.charactersheet.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Sheet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String[] attributeNames = {"Strength","Constitution","Dexterity","Intelligence","Wisdom","Charisma"};
	private final String[] skillNames = {"Athletics","Endurance","Acrobatics","Stealth","Thievery","Arcana","History","Religion","Dungeoneering","Heal","Insight","Nature","Perception","Bluff","Diplomacy","Intimidate","Streetwise"};
	private String name,role,race,gender,alignment,weapon1,weapon2,notes,feats,equiptment,languages1,languages2,wealth,level,initiative,speed,armorClass,fortitude,reflex,will,weapon1AttackBonus,weapon2AttackBonus,weapon1Damage,weapon2Damage,maxHP,tempHP,bloodied,surgeValue,surgeLimit,health,surgesUsed,experience,experienceForNextLevel;
	private ArrayList<Skill> skillList;
	private ArrayList<Attribute> attributeList;
	
	public Sheet() {
		
		attributeList = new ArrayList<Attribute>();
		skillList = new ArrayList<Skill>();
		
		for (int i = 0; i<attributeNames.length; i++) {
			
			attributeList.add(new Attribute(attributeNames[i]));
			
		}
		
		for (int i = 0; i<skillNames.length; i++) {
			
			skillList.add(new Skill(skillNames[i]));
			
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getWeapon1() {
		return weapon1;
	}

	public void setWeapon1(String weapon1) {
		this.weapon1 = weapon1;
	}

	public String getWeapon2() {
		return weapon2;
	}

	public void setWeapon2(String weapon2) {
		this.weapon2 = weapon2;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getFeats() {
		return feats;
	}

	public void setFeats(String feats) {
		this.feats = feats;
	}

	public String getEquiptment() {
		return equiptment;
	}

	public void setEquiptment(String equiptment) {
		this.equiptment = equiptment;
	}

	public String getLanguages1() {
		return languages1;
	}

	public void setLanguages1(String languages1) {
		this.languages1 = languages1;
	}

	public String getLanguages2() {
		return languages2;
	}

	public void setLanguages2(String languages2) {
		this.languages2 = languages2;
	}

	public String getWealth() {
		return wealth;
	}

	public void setWealth(String wealth) {
		this.wealth = wealth;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getInitiative() {
		return initiative;
	}

	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(String armorClass) {
		this.armorClass = armorClass;
	}

	public String getFortitude() {
		return fortitude;
	}

	public void setFortitude(String fortitude) {
		this.fortitude = fortitude;
	}

	public String getReflex() {
		return reflex;
	}

	public void setReflex(String reflex) {
		this.reflex = reflex;
	}

	public String getWill() {
		return will;
	}

	public void setWill(String will) {
		this.will = will;
	}

	public String getWeapon1AttackBonus() {
		return weapon1AttackBonus;
	}

	public void setWeapon1AttackBonus(String weapon1AttackBonus) {
		this.weapon1AttackBonus = weapon1AttackBonus;
	}

	public String getWeapon2AttackBonus() {
		return weapon2AttackBonus;
	}

	public void setWeapon2AttackBonus(String weapon2AttackBonus) {
		this.weapon2AttackBonus = weapon2AttackBonus;
	}

	public String getWeapon1Damage() {
		return weapon1Damage;
	}

	public void setWeapon1Damage(String weapon1Damage) {
		this.weapon1Damage = weapon1Damage;
	}

	public String getWeapon2Damage() {
		return weapon2Damage;
	}

	public void setWeapon2Damage(String weapon2Damage) {
		this.weapon2Damage = weapon2Damage;
	}

	public String getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(String maxHP) {
		this.maxHP = maxHP;
	}

	public String getTempHP() {
		return tempHP;
	}

	public void setTempHP(String tempHP) {
		this.tempHP = tempHP;
	}

	public String getBloodied() {
		return bloodied;
	}

	public void setBloodied(String bloodied) {
		this.bloodied = bloodied;
	}

	public String getSurgeValue() {
		return surgeValue;
	}

	public void setSurgeValue(String surgeValue) {
		this.surgeValue = surgeValue;
	}

	public String getSurgeLimit() {
		return surgeLimit;
	}

	public void setSurgeLimit(String surgeLimit) {
		this.surgeLimit = surgeLimit;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getSurgesUsed() {
		return surgesUsed;
	}

	public void setSurgesUsed(String surgesUsed) {
		this.surgesUsed = surgesUsed;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getExperienceForNextLevel() {
		return experienceForNextLevel;
	}

	public void setExperienceForNextLevel(String experienceForNextLevel) {
		this.experienceForNextLevel = experienceForNextLevel;
	}

	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(ArrayList<Skill> skillList) {
		this.skillList = skillList;
	}

	public ArrayList<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(ArrayList<Attribute> attributeList) {
		this.attributeList = attributeList;
	}

	public String[] getAttributeNames() {
		return attributeNames;
	}

	public String[] getSkillNames() {
		return skillNames;
	}
	
}
