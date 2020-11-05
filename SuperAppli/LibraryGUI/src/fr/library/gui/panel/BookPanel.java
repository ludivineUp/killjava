package fr.library.gui.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import fr.library.dao.DaoFactory;

public class BookPanel extends JPanel {

	private JTextArea title;
	private JComboBox editor;
	private JComboBox author;
	private JFormattedTextField parution;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public BookPanel() throws SQLException {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 0, 0, 11, 0};
		gridBagLayout.rowHeights = new int[]{29, 0, 29, 29, 10, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitre = new JLabel("Titre");
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 1;
		gbc_lblTitre.gridy = 0;
		add(lblTitre, gbc_lblTitre);
		
		title = new JTextArea();
		title.setRows(2);
		title.setTabSize(4);
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridheight = 2;
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_title.gridx = 2;
		gbc_title.gridy = 0;
		add(title, gbc_title);
		
		JLabel lblEditeur = new JLabel("Editeur");
		GridBagConstraints gbc_lblEditeur = new GridBagConstraints();
		gbc_lblEditeur.anchor = GridBagConstraints.WEST;
		gbc_lblEditeur.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditeur.gridx = 1;
		gbc_lblEditeur.gridy = 2;
		add(lblEditeur, gbc_lblEditeur);
		
		 editor = new JComboBox(DaoFactory.getEditorDao().findAll().toArray());
		GridBagConstraints gbc_editor = new GridBagConstraints();
		gbc_editor.insets = new Insets(0, 0, 5, 5);
		gbc_editor.fill = GridBagConstraints.HORIZONTAL;
		gbc_editor.gridx = 2;
		gbc_editor.gridy = 2;
		add(editor, gbc_editor);
		
		JLabel lblAuteur = new JLabel("Auteur");
		GridBagConstraints gbc_lblAuteur = new GridBagConstraints();
		gbc_lblAuteur.anchor = GridBagConstraints.WEST;
		gbc_lblAuteur.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuteur.gridx = 1;
		gbc_lblAuteur.gridy = 3;
		add(lblAuteur, gbc_lblAuteur);
		
		 author = new JComboBox(DaoFactory.getAuthorDao().findAll().toArray());
		GridBagConstraints gbc_author = new GridBagConstraints();
		gbc_author.insets = new Insets(0, 0, 5, 5);
		gbc_author.fill = GridBagConstraints.HORIZONTAL;
		gbc_author.gridx = 2;
		gbc_author.gridy = 3;
		add(author, gbc_author);
		
		JLabel lblDatraDeParution = new JLabel("Date de parution");
		GridBagConstraints gbc_lblDatraDeParution = new GridBagConstraints();
		gbc_lblDatraDeParution.fill = GridBagConstraints.VERTICAL;
		gbc_lblDatraDeParution.anchor = GridBagConstraints.EAST;
		gbc_lblDatraDeParution.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatraDeParution.gridx = 1;
		gbc_lblDatraDeParution.gridy = 4;
		add(lblDatraDeParution, gbc_lblDatraDeParution);
		
		parution = new JFormattedTextField(DateFormat.getDateInstance());
		Date d = new Date();
		parution.setText(d.toString());
		GridBagConstraints gbc_parution = new GridBagConstraints();
		gbc_parution.insets = new Insets(0, 0, 5, 5);
		gbc_parution.fill = GridBagConstraints.BOTH;
		gbc_parution.gridx = 2;
		gbc_parution.gridy = 4;
		add(parution, gbc_parution);

	}
	public JTextArea getTitle() {
		return title;
	}
	public JComboBox getEditor() {
		return editor;
	}
	public JComboBox getAuthor() {
		return author;
	}
	public JFormattedTextField getParution() {
		return parution;
	}

}
