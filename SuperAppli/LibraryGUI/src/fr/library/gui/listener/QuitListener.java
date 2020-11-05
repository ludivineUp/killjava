package fr.library.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuitListener implements ActionListener {
	
	private JFrame parent;
	
	public QuitListener(JFrame parent) {
		super();
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		final JDialog sure = new JDialog(parent);

		sure.setModal(true);
		sure.setTitle("Are you sure?");
		JPanel panel = new JPanel();
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);				
			}
		});
		panel.add(ok);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sure.dispose();	
			}
		});
		panel.add(cancel);
		sure.getContentPane().add(panel);
		sure.setBounds(200, 200, 200, 75);
		sure.setVisible(true);
	}
}
