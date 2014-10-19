package org.noip.olyol95.charactersheet.GUI;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextList extends JScrollPane {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	
	public TextList() {
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setMargin(new Insets(5,5,5,5));
		textArea.setWrapStyleWord(true);
		
		this.getViewport().add(textArea);
		this.getViewport().setView(textArea);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setFont(new Font("Eras Demi ITC", Font.PLAIN, 12));
		
	}
	
	public String getText() {
		
		return textArea.getText().replaceAll("\n", "¶");
		
	}
	
	public void setText(String text) {
		
		try {
			
			textArea.setText(text.replaceAll("¶","\n"));
			
		} catch (Exception e) {
			
			textArea.setText("");
			
		}
		
	}
	
	public void lock() {
		
		this.setEnabled(false);
		textArea.setEditable(false);
		
	}
	
	public void unlock() {
		
		this.setEnabled(true);
		textArea.setEditable(true);
		
	}

}
