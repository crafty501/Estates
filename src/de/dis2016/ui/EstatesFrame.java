package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import de.dis2016.model.Apartment;
import de.dis2016.model.Estate;
import de.dis2016.model.EstateTableModel;
import de.dis2016.model.House;
import de.dis2016.presenter.EstatesPresenter;

public class EstatesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EstatesPresenter presenter;
	
	String[] columnNames = {"id",
            "name",
            "street"};
	

	//final DefaultTableModel housesModel = new DefaultTableModel( columnNames, 0 );
	//final DefaultTableModel apartmentsModel = new DefaultTableModel( columnNames, 0 );

	private JTable estates = new JTable();

	//private JTable houses = new JTable(housesModel);
	//private JTable apartments = new JTable(apartmentsModel);
	
	
	private JButton loginButton;
	private JButton createButton;
	private JButton deleteButton;
	private JButton modifyButton;
	
	
	private JTextField id;
	private JTextField street;
	private JTextField streetNo;
	private JTextField squareArea;
	private JTextField postalCode;
	
	
	

	public EstatesFrame() {
		super();
		
		this.setLayout(new BorderLayout());
		this.setSize(800, 600);
		this.setMinimumSize(new Dimension(800, 600));
		this.setResizable(true);
		this.setTitle("Estates");
		// Get the size of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// Move the window
		this.setLocation(x, y);
		
		
		loginButton = new JButton("login");
		createButton = new JButton("create");
		deleteButton = new JButton("delete");
		modifyButton = new JButton("modify");
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(createButton);
		pnlButtons.add(deleteButton);
		pnlButtons.add(modifyButton);
		pnlButtons.add(loginButton);
		//pnlButtons.setSize(300,500);
		//pnlButtons.setPreferredSize(new Dimension(300, 500));
		
		this.add(pnlButtons,BorderLayout.NORTH);
		
		
		//JPanel center = new JPanel();
		//center.setLayout(new GridLayout(0, 2));
		//center.add(new JScrollPane(houses));
		//houses.setFillsViewportHeight(true);
		//center.add(new JScrollPane(apartments));
		//apartments.setFillsViewportHeight(true);
		
		//this.add(center, BorderLayout.CENTER);
		
		this.add(new JScrollPane(estates), BorderLayout.CENTER);

		
		createButton.setEnabled(false);
		deleteButton.setEnabled(false);
		modifyButton.setEnabled(false);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showLogin();
			}
		});
	}
	
	
	public void showLogin() {
		new LoginFrame(presenter);
		
		createButton.setEnabled(false);
		deleteButton.setEnabled(false);
		modifyButton.setEnabled(false);
	}
	
    
	
	
	public void setEstates(List<Estate> list) {
		createButton.setEnabled(true);
		deleteButton.setEnabled(true);
		modifyButton.setEnabled(true);
		
		list = new ArrayList<>();
		House house1 = new House("1", "testcity", "55733", "teststrasse", "43a", "24", "3", "5000", true);
		House house2 = new House("2", "testcity2", "55733", "teststrasse", "43a", "24", "3", "5000", true);
		House house3 = new House("3", "testcity3", "55733", "teststrasse", "43a", "24", "3", "5000", true);
		Apartment app1 = new Apartment("4", "asdfsd", "code", "street", "54", "3", 4, 10, 4, true, true);
		
		
		list.add(house1);
		list.add(house2);
		list.add(house3);
		list.add(app1);
		
		estates.setModel(new EstateTableModel(list));
	}
	
	
	public void setPresenter(EstatesPresenter pres) {
        presenter = pres;
    }


}
