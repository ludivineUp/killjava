package fr.library.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class CancelListener implements ActionListener{
	
	public JInternalFrame parent;
	
	public CancelListener(JInternalFrame parent){
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//parent.setVisible(false);
		parent.dispose();
		
	}

}
