package org.noip.olyol95.charactersheet.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.noip.olyol95.charactersheet.Main;
import org.noip.olyol95.charactersheet.entities.Attribute;
import org.noip.olyol95.charactersheet.entities.Sheet;
import org.noip.olyol95.charactersheet.entities.Skill;

public class Window extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	
	private TextField gender,tempHP,strLevel,strMod,strCheck,conLevel,conMod,conCheck,dexLevel,dexMod,dexCheck,intLevel,intMod,intCheck,wisLevel,wisMod,wisCheck,chaLevel,chaMod,chaCheck,athMisc,athCheck,endMisc,endCheck,acrMisc,acrCheck,steMisc,steCheck,theMisc,theCheck,arcMisc,arcCheck,hisMisc,hisCheck,relMisc,relCheck,dunMisc,dunCheck,heaMisc,heaCheck,insMisc,insCheck,natMisc,natCheck,perMisc,perCheck,bluMisc,bluCheck,dipMisc,dipCheck,intiMisc,intiCheck,streMisc,streCheck,wealth,initiative,speed,ac,fortitude,reflex,will,attkBonus1,attkBonus2,weaponName1,weaponName2,weaponDam1,weaponDam2,maxHP,bloodied,surgeValue,maxSurges,hp,surgesUsed,name,role,level,race,alignment,xp,xpForNextLevel,languages1,languages2;
	private Sheet currentSheet;
	private CheckBox athSkilled,endSkilled,acrSkilled,steSkilled,thiSkilled,arcSkilled,hisSkilled,relSkilled,dunSkilled,heaSkilled,insSkilled,natSkilled,perSkilled,bluSkilled,dipSkilled,intiSkilled,streSkilled;
	private TextList feats,equiptment,notes;
	private JPanel panel,panel2;
	private JScrollPane scrollPane;
	private ImageIcon background,icon;
	private JLabel backgroundImage;
	private JMenuBar menubar;
	private boolean isLocked;
	private File lastFile;
	private JFileChooser filechooser;
	
	public Window() {
		
		filechooser = new JFileChooser();
		FileFilter saveType = new FileNameExtensionFilter("4ESAVE (.4E)", "4E");
		filechooser.setFileFilter(saveType);
		
		isLocked = false;
		
		menubar = new JMenuBar();
		    
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		  
		JMenuItem save = new JMenuItem("Save");
		save.setActionCommand("save");
		save.addActionListener(this);
		  
		JMenuItem saveas = new JMenuItem("Save As...");
		saveas.setActionCommand("saveas");
		saveas.addActionListener(this);
		
		JMenuItem open = new JMenuItem("Open");
		open.setActionCommand("open");
		open.addActionListener(this);
		
		JMenuItem newsheet = new JMenuItem("New");
		newsheet.setActionCommand("new");
		newsheet.addActionListener(this);
		
		JMenuItem lock = new JMenuItem("Lock/Unlock");
		lock.setActionCommand("lock");
		lock.addActionListener(this);
		    
		file.add(save);
		file.add(saveas);
		file.add(open);
		file.add(newsheet);
		
		edit.add(lock);

		menubar.add(file);
		menubar.add(edit);
		this.setJMenuBar(menubar);
		
		try {
			
			background = new ImageIcon(ImageIO.read(Main.class.getResource("/resources/img/background.png")));
			icon  = new ImageIcon(ImageIO.read(Main.class.getResource("/resources/img/icon.png")));
			
		} catch (Exception e) {
			
			try {
				
				background = new ImageIcon(ImageIO.read(new File("C:/Users/Oliver/Pictures/4Ebg.png")));
				icon = new ImageIcon(ImageIO.read(new File("C:/Users/Oliver/Pictures/dndicon.png")));
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
		}
		
		this.setIconImage(icon.getImage());
		
		panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(783,1047));
		panel2.add(panel,new GridBagConstraints());
		scrollPane = new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		HandScrollListener scrollListener = new HandScrollListener(panel);
		scrollPane.getViewport().addMouseMotionListener(scrollListener);
		scrollPane.getViewport().addMouseListener(scrollListener);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		this.setSize(820,700);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("4E Character Sheet - Untitled");
		this.setLocationRelativeTo(null);
		
		currentSheet = new Sheet();
		
		backgroundImage = new JLabel(background);
		
		gender = new TextField();
		tempHP = new TextField();
		strLevel = new TextField();
		strMod = new TextField();
		strCheck = new TextField();
		conLevel = new TextField();
		conMod = new TextField();
		conCheck = new TextField();
		dexLevel = new TextField();
		dexMod = new TextField();
		dexCheck = new TextField();
		intLevel = new TextField();
		intMod = new TextField();
		intCheck = new TextField();
		wisLevel = new TextField();
		wisMod = new TextField();
		wisCheck = new TextField();
		chaLevel = new TextField();
		chaMod = new TextField();
		chaCheck = new TextField();
		athMisc = new TextField();
		athCheck = new TextField();
		endMisc = new TextField();
		endCheck = new TextField();
		acrMisc = new TextField();
		acrCheck = new TextField();
		steMisc = new TextField();
		steCheck = new TextField();
		theMisc = new TextField();
		theCheck = new TextField();
		arcMisc = new TextField();
		arcCheck = new TextField();
		hisMisc = new TextField();
		hisCheck = new TextField();
		relMisc = new TextField();
		relCheck = new TextField();
		dunMisc = new TextField();
		dunCheck = new TextField();
		heaMisc = new TextField();
		heaCheck = new TextField();
		insMisc = new TextField();
		insCheck = new TextField();
		natMisc = new TextField();
		natCheck = new TextField();
		perMisc = new TextField();
		perCheck = new TextField();
		bluMisc = new TextField();
		bluCheck = new TextField();
		dipMisc = new TextField();
		dipCheck = new TextField();
		intiMisc = new TextField();
		intiCheck = new TextField();
		streMisc = new TextField();
		streCheck = new TextField();
		wealth = new TextField();
		initiative = new TextField();
		speed = new TextField();
		ac = new TextField();
		fortitude = new TextField();
		reflex = new TextField();
		will = new TextField();
		attkBonus1 = new TextField();
		attkBonus2 = new TextField();
		weaponName1 = new TextField();
		weaponName2 = new TextField();
		weaponDam1 = new TextField();
		weaponDam2 = new TextField();
		maxHP = new TextField();
		bloodied = new TextField();
		surgeValue = new TextField();
		maxSurges = new TextField();
		hp = new TextField();
		surgesUsed = new TextField();
		name = new TextField();
		role = new TextField();
		level = new TextField();
		race = new TextField();
		alignment  = new TextField();
		xp = new TextField();
		xpForNextLevel = new TextField();
		languages1 = new TextField();
		languages2 = new TextField();
		
		athSkilled = new CheckBox();
		endSkilled = new CheckBox();
		acrSkilled = new CheckBox();
		steSkilled = new CheckBox();
		thiSkilled = new CheckBox();
		arcSkilled = new CheckBox();
		hisSkilled = new CheckBox();
		relSkilled = new CheckBox();
		dunSkilled = new CheckBox();
		heaSkilled = new CheckBox();
		insSkilled = new CheckBox();
		natSkilled = new CheckBox();
		perSkilled = new CheckBox();
		bluSkilled = new CheckBox();
		dipSkilled = new CheckBox();
		intiSkilled = new CheckBox();
		streSkilled = new CheckBox();
		
		feats = new TextList();
		equiptment = new TextList();
		notes = new TextList();
		
		backgroundImage.setBounds(0,0,783,1047);
		
		feats.setBounds(7,711,250,233);
		equiptment.setBounds(270,730,250,173);
		notes.setBounds(533,200,250,685);
		
		athSkilled.setBounds(98,126,14,14);
		endSkilled.setBounds(98,189,14,14);
		acrSkilled.setBounds(98,253,14,14);
		steSkilled.setBounds(98,273,14,14);
		thiSkilled.setBounds(98,292,14,14);
		arcSkilled.setBounds(98,356,14,14);
		hisSkilled.setBounds(98,376,14,14);
		relSkilled.setBounds(98,395,14,14);
		dunSkilled.setBounds(98,459,14,14);
		heaSkilled.setBounds(98,478,14,14);
		insSkilled.setBounds(98,498,14,14);
		natSkilled.setBounds(98,517,14,14);
		perSkilled.setBounds(98,537,14,14);
		bluSkilled.setBounds(98,601,14,14);
		dipSkilled.setBounds(98,620,14,14);
		intiSkilled.setBounds(98,639,14,14);
		streSkilled.setBounds(98,659,14,14);
		
		gender.setBounds(720,78,57,16);
		tempHP.setBounds(295,675,49,19);
		strLevel.setBounds(7,81,34,32);
		strMod.setBounds(152,88,50,17);
		strCheck.setBounds(206,88,50,17);
		conLevel.setBounds(7,145,34,32);
		conMod.setBounds(152,152,50,17);
		conCheck.setBounds(206,152,50,17);
		dexLevel.setBounds(7,208,34,32);
		dexMod.setBounds(152,216,50,17);
		dexCheck.setBounds(206,216,50,17);
		intLevel.setBounds(7,311,34,32);
		intMod.setBounds(152,319,50,17);
		intCheck.setBounds(206,319,50,17);
		wisLevel.setBounds(7,414,34,32);
		wisMod.setBounds(152,422,50,17);
		wisCheck.setBounds(206,422,50,17);
		chaLevel.setBounds(7,555,34,32);
		chaMod.setBounds(152,563,50,17);
		chaCheck.setBounds(206,563,50,17);
		athMisc.setBounds(152,123,50,17);
		athCheck.setBounds(206,123,50,17);
		endMisc.setBounds(152,187,50,17);
		endCheck.setBounds(206,187,50,17);
		acrMisc.setBounds(152,251,50,17);
		acrCheck.setBounds(206,251,50,17);
		steMisc.setBounds(152,270,50,17);
		steCheck.setBounds(206,270,50,17);
		theMisc.setBounds(152,290,50,17);
		theCheck.setBounds(206,290,50,17);
		arcMisc.setBounds(152,353,50,17);
		arcCheck.setBounds(206,353,50,17);
		hisMisc.setBounds(152,373,50,17);
		hisCheck.setBounds(206,373,50,17);
		relMisc.setBounds(152,392,50,17);
		relCheck.setBounds(206,392,50,17);
		dunMisc.setBounds(152,456,50,17);
		dunCheck.setBounds(206,456,50,17);
		heaMisc.setBounds(152,476,50,17);
		heaCheck.setBounds(206,476,50,17);
		insMisc.setBounds(152,495,50,17);
		insCheck.setBounds(206,495,50,17);
		natMisc.setBounds(152,514,50,17);
		natCheck.setBounds(206,514,50,17);
		perMisc.setBounds(152,534,50,17);
		perCheck.setBounds(206,534,50,17);
		bluMisc.setBounds(152,598,50,17);
		bluCheck.setBounds(206,598,50,17);
		dipMisc.setBounds(152,617,50,17);
		dipCheck.setBounds(206,617,50,17);
		intiMisc.setBounds(152,637,50,17);
		intiCheck.setBounds(206,637,50,17);
		streMisc.setBounds(152,657,50,17);
		streCheck.setBounds(206,657,50,17);
		wealth.setBounds(7,980,250,53);
		initiative.setBounds(269,80,34,32);
		speed.setBounds(402,80,34,32);
		ac.setBounds(273,162,34,32);
		fortitude.setBounds(273,206,34,32);
		reflex.setBounds(273,251,34,32);
		will.setBounds(273,295,34,32);
		attkBonus1.setBounds(269,355,34,32);
		attkBonus2.setBounds(269,390,34,32);
		weaponName1.setBounds(383,364,83,17);
		weaponName2.setBounds(383,399,83,17);
		weaponDam1.setBounds(470,364,49,17);
		weaponDam2.setBounds(470,399,49,17);
		maxHP.setBounds(269,454,34,32);
		bloodied.setBounds(469,462,50,17);
		surgeValue.setBounds(469,516,50,17);
		maxSurges.setBounds(469,536,50,17);
		hp.setBounds(269,621,250,38);
		surgesUsed.setBounds(464,675,47,19);
		name.setBounds(473,5,305,40);
		role.setBounds(563,59,107,16);
		level.setBounds(707,59,70,16);
		race.setBounds(563,78,107,16);
		alignment.setBounds(594,98,185,16);
		xp.setBounds(532,978,250,33);
		xpForNextLevel.setBounds(708,1011,65,16);
		languages1.setBounds(593,116,183,17);
		languages2.setBounds(532,136,245,17);
		
		panel.setLayout(null);
		panel.add(feats);
		panel.add(equiptment);
		panel.add(notes);
		panel.add(name);
		panel.add(gender);
		panel.add(tempHP);
		panel.add(strLevel);
		panel.add(strMod);
		panel.add(strCheck);
		panel.add(conLevel);
		panel.add(conMod);
		panel.add(conCheck);
		panel.add(dexLevel);
		panel.add(dexMod);
		panel.add(dexCheck);
		panel.add(intLevel);
		panel.add(intMod);
		panel.add(intCheck);
		panel.add(wisLevel);
		panel.add(wisMod);
		panel.add(wisCheck);
		panel.add(chaLevel);
		panel.add(chaMod);
		panel.add(chaCheck);
		panel.add(athMisc);
		panel.add(athCheck);
		panel.add(endMisc);
		panel.add(endCheck);
		panel.add(acrMisc);
		panel.add(acrCheck);
		panel.add(steMisc);
		panel.add(steCheck);
		panel.add(theMisc);
		panel.add(theCheck);
		panel.add(arcMisc);
		panel.add(arcCheck);
		panel.add(hisMisc);
		panel.add(hisCheck);
		panel.add(relMisc);
		panel.add(relCheck);
		panel.add(dunMisc);
		panel.add(dunCheck);
		panel.add(heaMisc);
		panel.add(heaCheck);
		panel.add(insMisc);
		panel.add(insCheck);
		panel.add(natMisc);
		panel.add(natCheck);
		panel.add(perMisc);
		panel.add(perCheck);
		panel.add(bluMisc);
		panel.add(bluCheck);
		panel.add(dipMisc);
		panel.add(dipCheck);
		panel.add(intiMisc);
		panel.add(intiCheck);
		panel.add(streMisc);
		panel.add(streCheck);
		panel.add(wealth);
		panel.add(initiative);
		panel.add(speed);
		panel.add(ac);
		panel.add(fortitude);
		panel.add(reflex);
		panel.add(will);
		panel.add(attkBonus1);
		panel.add(attkBonus2);
		panel.add(weaponName1);
		panel.add(weaponName2);
		panel.add(weaponDam1);
		panel.add(weaponDam2);
		panel.add(maxHP);
		panel.add(bloodied);
		panel.add(surgeValue);
		panel.add(maxSurges);
		panel.add(hp);
		panel.add(surgesUsed);
		panel.add(name);
		panel.add(role);
		panel.add(level);
		panel.add(race);
		panel.add(alignment);
		panel.add(xp);
		panel.add(xpForNextLevel);
		panel.add(athSkilled);
		panel.add(endSkilled);
		panel.add(acrSkilled);
		panel.add(steSkilled);
		panel.add(thiSkilled);
		panel.add(arcSkilled);
		panel.add(hisSkilled);
		panel.add(relSkilled);
		panel.add(dunSkilled);
		panel.add(heaSkilled);
		panel.add(insSkilled);
		panel.add(natSkilled);
		panel.add(perSkilled);
		panel.add(bluSkilled);
		panel.add(dipSkilled);
		panel.add(intiSkilled);
		panel.add(streSkilled);
		panel.add(languages1);
		panel.add(languages2);
		panel.add(backgroundImage);
		
		this.add(scrollPane);
		this.setVisible(true);
		this.addWindowListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("save")) {
			
			if (lastFile == null) {
				
				JOptionPane.showMessageDialog(this, "No file selected, please use Save As.");
				
			} else {
				
				if (!lastFile.exists()) {
					
					lastFile.mkdirs();
					
					try {
						
						lastFile.createNewFile();
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
						
					}
					
				}
				
			    
				try {
					
					assignValues();
					ObjectOutput output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(lastFile)));
					output.writeObject(currentSheet);
					output.close();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
				
			}
			
		} else if (e.getActionCommand().equals("saveas")) {

			int returnVal = filechooser.showSaveDialog(this);
			
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	        	
	            lastFile = new File(filechooser.getSelectedFile().getAbsolutePath()+".4E");
	            
	            try {
					
	            	assignValues();
					ObjectOutput output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(lastFile)));
					output.writeObject(currentSheet);
					output.close();
					
					this.setTitle("4E Character Sheet - "+lastFile.getAbsolutePath());
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
	            
	        }
			
		} else if (e.getActionCommand().equals("open")) {
			
			int returnVal = filechooser.showOpenDialog(this);
			
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	        	
	        	lastFile = filechooser.getSelectedFile();
	        	
	        	try {
	        		
					ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(lastFile)));
					currentSheet = (Sheet) input.readObject();
					input.close();
					
					this.setTitle("4E Character Sheet - "+lastFile.getAbsolutePath());
					
					loadValues();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
					
				} 
	        	
	        }
			
		} else if (e.getActionCommand().equals("lock")) {
			
			if (isLocked) {
				
				for (Component c: panel.getComponents()) {
				
					try {
						
						TextField c1 = (TextField) c;
						c1.setEditable(true);
						
					} catch (Exception e1) {
						
						try {
							
							TextList c1 = (TextList) c;
							c1.unlock();
							
						} catch (Exception e2) {
							
							try {
								
								CheckBox c1 = (CheckBox) c;
								c1.setEnabled(true);
								
							} catch (Exception e3) {
								
								
							}
							
						}
						
					}
					
				}
				
				if (this.getTitle().endsWith("[READ ONLY]")) {
					
					this.setTitle(this.getTitle().substring(0, this.getTitle().length()-12));
					
				}
				
				isLocked = false;
				
			} else {
				
				for (Component c: panel.getComponents()) {
					
					try {
						
						TextField c1 = (TextField) c;
						c1.setEditable(false);
						
					} catch (Exception e1) {
						
						try {
							
							TextList c1 = (TextList) c;
							c1.lock();
							
						} catch (Exception e2) {
							
							try {
								
								CheckBox c1 = (CheckBox) c;
								c1.setEnabled(false);
								
							} catch (Exception e3) {
								
								
							}
							
						}
						
					}
					
				}
				
				this.setTitle(this.getTitle()+" [READ ONLY]");
				
				isLocked = true;
				
			}
			
		} else if (e.getActionCommand().equals("new")) {
			
			int returnVal = JOptionPane.showConfirmDialog(this, "Are you sure you wish to create a new sheet? \nDoing so will clear the current sheet.","Please Confirm.",JOptionPane.YES_NO_OPTION);
			
			if (returnVal == JOptionPane.YES_OPTION) {
			
				lastFile = null;
				currentSheet = new Sheet();
				loadValues();
				
				this.setTitle("4E Character Sheet - Untitled");
				
			}
			
		}
		
	}
	
	private void assignValues() {
		
		currentSheet.setGender(gender.getText());
		currentSheet.setTempHP(tempHP.getText());
		
		for (Attribute a: currentSheet.getAttributeList()) {
			
			switch(a.getTitle()) {
			
			case("Strength"):
				
				a.setLevel(strLevel.getText());
				a.setModifier(strMod.getText());
				a.setCheck(strCheck.getText());
				break;
				
			case("Constitution"):
				
				a.setLevel(conLevel.getText());
				a.setModifier(conMod.getText());
				a.setCheck(conCheck.getText());
				break;
				
			case("Dexterity"):
				
				a.setLevel(dexLevel.getText());
				a.setModifier(dexMod.getText());
				a.setCheck(dexCheck.getText());
				break;
				
			case("Intelligence"):
				
				a.setLevel(intLevel.getText());
				a.setModifier(intMod.getText());
				a.setCheck(intCheck.getText());
				break;
				
			case("Wisdom"):
				
				a.setLevel(wisLevel.getText());
				a.setModifier(wisMod.getText());
				a.setCheck(wisCheck.getText());
				break;
				
			case("Charisma"):
				
				a.setLevel(chaLevel.getText());
				a.setModifier(chaMod.getText());
				a.setCheck(chaCheck.getText());
				break;
			
			}
			
		}
		
		for (Skill s: currentSheet.getSkillList()) {
			
			switch(s.getTitle()) {
			
			case("Athletics"):
				
				s.setMisc(athMisc.getText());
				s.setCheck(athCheck.getText());
				s.setTrained(athSkilled.isSelected());
				break;
				
			case("Endurance"):
				
				s.setMisc(endMisc.getText());
				s.setCheck(endCheck.getText());
				s.setTrained(endSkilled.isSelected());
				break;
				
			case("Acrobatics"):
				
				s.setMisc(acrMisc.getText());
				s.setCheck(acrCheck.getText());
				s.setTrained(acrSkilled.isSelected());
				break;
				
			case("Stealth"):
				
				s.setMisc(steMisc.getText());
				s.setCheck(steCheck.getText());
				s.setTrained(steSkilled.isSelected());
				break;
				
			case("Thievery"):
				
				s.setMisc(theMisc.getText());
				s.setCheck(theCheck.getText());
				s.setTrained(thiSkilled.isSelected());
				break;
			
			case("Arcana"):
				
				s.setMisc(arcMisc.getText());
				s.setCheck(arcCheck.getText());
				s.setTrained(arcSkilled.isSelected());
				break;
				
			case("History"):
				
				s.setMisc(hisMisc.getText());
				s.setCheck(hisCheck.getText());
				s.setTrained(hisSkilled.isSelected());
				break;
				
			case("Religion"):
				
				s.setMisc(relMisc.getText());
				s.setCheck(relCheck.getText());
				s.setTrained(relSkilled.isSelected());
				break;
				
			case("Dungeoneering"):
				
				s.setMisc(dunMisc.getText());
				s.setCheck(dunCheck.getText());
				s.setTrained(dunSkilled.isSelected());
				break;
				
			case("Heal"):
				
				s.setMisc(heaMisc.getText());
				s.setCheck(heaCheck.getText());
				s.setTrained(heaSkilled.isSelected());
				break;
				
			case("Insight"):
				
				s.setMisc(insMisc.getText());
				s.setCheck(insCheck.getText());
				s.setTrained(insSkilled.isSelected());
				break;
				
			case("Nature"):
				
				s.setMisc(natMisc.getText());
				s.setCheck(natCheck.getText());
				s.setTrained(natSkilled.isSelected());
				break;
				
			case("Perception"):
				
				s.setMisc(perMisc.getText());
				s.setCheck(perCheck.getText());
				s.setTrained(perSkilled.isSelected());
				break;
				
			case("Bluff"):
				
				s.setMisc(bluMisc.getText());
				s.setCheck(bluCheck.getText());
				s.setTrained(bluSkilled.isSelected());
				break;
				
			case("Diplomacy"):
				
				s.setMisc(dipMisc.getText());
				s.setCheck(dipCheck.getText());
				s.setTrained(dipSkilled.isSelected());
				break;
				
			case("Intimidate"):
				
				s.setMisc(intiMisc.getText());
				s.setCheck(intiCheck.getText());
				s.setTrained(intiSkilled.isSelected());
				break;
				
			case("Streetwise"):
				
				s.setMisc(streMisc.getText());
				s.setCheck(streCheck.getText());
				s.setTrained(streSkilled.isSelected());
				break;
			
			}
			
		}
		
		currentSheet.setWealth(wealth.getText());
		currentSheet.setInitiative(initiative.getText());
		currentSheet.setSpeed(speed.getText());
		currentSheet.setArmorClass(ac.getText());
		currentSheet.setFortitude(fortitude.getText());
		currentSheet.setReflex(reflex.getText());
		currentSheet.setWill(will.getText());
		currentSheet.setWeapon1AttackBonus(attkBonus1.getText());
		currentSheet.setWeapon2AttackBonus(attkBonus2.getText());
		currentSheet.setWeapon1(weaponName1.getText());
		currentSheet.setWeapon2(weaponName2.getText());
		currentSheet.setWeapon1Damage(weaponDam1.getText());
		currentSheet.setWeapon2Damage(weaponDam2.getText());
		currentSheet.setMaxHP(maxHP.getText());
		currentSheet.setBloodied(bloodied.getText());
		currentSheet.setSurgeValue(surgeValue.getText());
		currentSheet.setSurgeLimit(maxSurges.getText());
		currentSheet.setHealth(hp.getText());
		currentSheet.setSurgesUsed(surgesUsed.getText());
		currentSheet.setName(name.getText());
		currentSheet.setRole(role.getText());
		currentSheet.setLevel(level.getText());
		currentSheet.setRace(race.getText());
		currentSheet.setAlignment(alignment.getText());
		currentSheet.setExperience(xp.getText());
		currentSheet.setExperienceForNextLevel(xpForNextLevel.getText());
		currentSheet.setLanguages1(languages1.getText());
		currentSheet.setLanguages2(languages2.getText());
		currentSheet.setFeats(feats.getText());
		currentSheet.setEquiptment(equiptment.getText());
		currentSheet.setNotes(notes.getText());
		
	}
	
	private void loadValues() {
		
		gender.setText(currentSheet.getGender());
		tempHP.setText(currentSheet.getTempHP());
		
		for (Attribute a: currentSheet.getAttributeList()) {
			
			switch(a.getTitle()) {
			
			case("Strength"):
				
				strLevel.setText(a.getLevel());
				strMod.setText(a.getModifier());
				strCheck.setText(a.getCheck());
				break;
				
			case("Constitution"):
				
				conLevel.setText(a.getLevel());
				conMod.setText(a.getModifier());
				conCheck.setText(a.getCheck());
				break;
				
			case("Dexterity"):
				
				dexLevel.setText(a.getLevel());
				dexMod.setText(a.getModifier());
				dexCheck.setText(a.getCheck());
				break;
				
			case("Intelligence"):
				
				intLevel.setText(a.getLevel());
				intMod.setText(a.getModifier());
				intCheck.setText(a.getCheck());
				break;
				
			case("Wisdom"):
				
				wisLevel.setText(a.getLevel());
				wisMod.setText(a.getModifier());
				wisCheck.setText(a.getCheck());
				break;
				
			case("Charisma"):
				
				chaLevel.setText(a.getLevel());
				chaMod.setText(a.getModifier());
				chaCheck.setText(a.getCheck());
				break;
			
			}
			
		}
		
		for (Skill s: currentSheet.getSkillList()) {
			
			switch(s.getTitle()) {
			
			case("Athletics"):
				
				athMisc.setText(s.getMisc());
				athCheck.setText(s.getCheck());
				athSkilled.setSelected(s.isTrained());
				break;
				
			case("Endurance"):
				
				endMisc.setText(s.getMisc());
				endCheck.setText(s.getCheck());
				endSkilled.setSelected(s.isTrained());
				break;
				
			case("Acrobatics"):
				
				acrMisc.setText(s.getMisc());
				acrCheck.setText(s.getCheck());
				acrSkilled.setSelected(s.isTrained());
				break;
				
			case("Stealth"):
				
				steMisc.setText(s.getMisc());
				steCheck.setText(s.getCheck());
				steSkilled.setSelected(s.isTrained());
				break;
				
			case("Thievery"):
				
				theMisc.setText(s.getMisc());
				theCheck.setText(s.getCheck());
				thiSkilled.setSelected(s.isTrained());
				break;
			
			case("Arcana"):
				
				arcMisc.setText(s.getMisc());
				arcCheck.setText(s.getCheck());
				arcSkilled.setSelected(s.isTrained());
				break;
				
			case("History"):
				
				hisMisc.setText(s.getMisc());
				hisCheck.setText(s.getCheck());
				hisSkilled.setSelected(s.isTrained());
				break;
				
			case("Religion"):
				
				relMisc.setText(s.getMisc());
				relCheck.setText(s.getCheck());
				relSkilled.setSelected(s.isTrained());
				break;
				
			case("Dungeoneering"):
				
				dunMisc.setText(s.getMisc());
				dunCheck.setText(s.getCheck());
				dunSkilled.setSelected(s.isTrained());
				break;
				
			case("Heal"):
				
				heaMisc.setText(s.getMisc());
				heaCheck.setText(s.getCheck());
				heaSkilled.setSelected(s.isTrained());
				break;
				
			case("Insight"):
				
				insMisc.setText(s.getMisc());
				insCheck.setText(s.getCheck());
				insSkilled.setSelected(s.isTrained());
				break;
				
			case("Nature"):
				
				natMisc.setText(s.getMisc());
				natCheck.setText(s.getCheck());
				natSkilled.setSelected(s.isTrained());
				break;
				
			case("Perception"):
				
				perMisc.setText(s.getMisc());
				perCheck.setText(s.getCheck());
				perSkilled.setSelected(s.isTrained());
				break;
				
			case("Bluff"):
				
				bluMisc.setText(s.getMisc());
				bluCheck.setText(s.getCheck());
				bluSkilled.setSelected(s.isTrained());
				break;
				
			case("Diplomacy"):
				
				dipMisc.setText(s.getMisc());
				dipCheck.setText(s.getCheck());
				dipSkilled.setSelected(s.isTrained());
				break;
				
			case("Intimidate"):
				
				intiMisc.setText(s.getMisc());
				intiCheck.setText(s.getCheck());
				intiSkilled.setSelected(s.isTrained());
				break;
				
			case("Streetwise"):
				
				streMisc.setText(s.getMisc());
				streCheck.setText(s.getCheck());
				streSkilled.setSelected(s.isTrained());
				break;
			
			}
			
		}
		
		wealth.setText(currentSheet.getWealth());
		initiative.setText(currentSheet.getInitiative());
		speed.setText(currentSheet.getSpeed());
		ac.setText(currentSheet.getArmorClass());
		fortitude.setText(currentSheet.getFortitude());
		reflex.setText(currentSheet.getReflex());
		will.setText(currentSheet.getWill());
		attkBonus1.setText(currentSheet.getWeapon1AttackBonus());
		attkBonus2.setText(currentSheet.getWeapon2AttackBonus());
		weaponName1.setText(currentSheet.getWeapon1());
		weaponName2.setText(currentSheet.getWeapon2());
		weaponDam1.setText(currentSheet.getWeapon1Damage());
		weaponDam2.setText(currentSheet.getWeapon2Damage());
		maxHP.setText(currentSheet.getMaxHP());
		bloodied.setText(currentSheet.getBloodied());
		surgeValue.setText(currentSheet.getSurgeValue());
		maxSurges.setText(currentSheet.getSurgeLimit());
		hp.setText(currentSheet.getHealth());
		surgesUsed.setText(currentSheet.getSurgesUsed());
		name.setText(currentSheet.getName());
		role.setText(currentSheet.getRole());
		level.setText(currentSheet.getLevel());
		race.setText(currentSheet.getRace());
		alignment.setText(currentSheet.getAlignment());
		xp.setText(currentSheet.getExperience());
		xpForNextLevel.setText(currentSheet.getExperienceForNextLevel());
		languages1.setText(currentSheet.getLanguages1());
		languages2.setText(currentSheet.getLanguages2());
		feats.setText(currentSheet.getFeats());
		equiptment.setText(currentSheet.getEquiptment());
		notes.setText(currentSheet.getNotes());
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
		if (JOptionPane.showConfirmDialog(this, "Are you sure you wish to quit?\nAny unsaved progress will be lost.", "Please confirm.", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			
			System.exit(0);
		
		} else {
			
			this.setVisible(true);
			
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
