package fr.library.gui.panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class AuhtorPanel extends JPanel {
	private JTextField lastname;
	private JTextField firstname;
	private JTextField pseudo;

	/**
	 * Create the panel.
	 */
	public AuhtorPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, -39, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nom");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lastname = new JTextField();
		GridBagConstraints gbc_lastname = new GridBagConstraints();
		
		gbc_lastname.insets = new Insets(0, 0, 5, 5);
		gbc_lastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastname.gridx = 2;
		gbc_lastname.gridy = 0;
		add(lastname, gbc_lastname);
		lastname.setColumns(90);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		firstname = new JTextField();
		GridBagConstraints gbc_firstname = new GridBagConstraints();
		gbc_firstname.insets = new Insets(0, 0, 5, 5);
		gbc_firstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstname.gridx = 2;
		gbc_firstname.gridy = 1;
		add(firstname, gbc_firstname);
		firstname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pseudonyme");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		pseudo = new JTextField();
		GridBagConstraints gbc_pseudo = new GridBagConstraints();
		gbc_pseudo.insets = new Insets(0, 0, 0, 5);
		gbc_pseudo.fill = GridBagConstraints.HORIZONTAL;
		gbc_pseudo.gridx = 2;
		gbc_pseudo.gridy = 2;
		add(pseudo, gbc_pseudo);
		pseudo.setColumns(10);

	}

	public JTextField getLastname() {
		return lastname;
	}

	public JTextField getFirstname() {
		return firstname;
	}

	public JTextField getPseudo() {
		return pseudo;
	}

}
