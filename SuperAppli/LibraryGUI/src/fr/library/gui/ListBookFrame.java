package fr.library.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import fr.library.controller.IController;
import fr.library.gui.model.BookTableModel;

public class ListBookFrame extends MyJInternalFrame {

	public ListBookFrame(IController controller) {
		super(controller);
		setVisible(true);
		setBounds(100, 100, 400, 200);
		setMinimumSize(new Dimension(200, 200));
		setTitle("List of books");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		TableModel tableModel = new BookTableModel();
		JTable table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
	}

}
