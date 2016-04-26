package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.dis2016.presenter.ContractsPresenter;
import de.dis2016.presenter.EstatesPresenter;

public class ContractsFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private ContractsPresenter presenter;
	
	private JButton newPersonButton;
	private JButton ContractButton;
	
	private JButton okButton;
	private JButton exitButton;
	
//	private JTable contracts = new JTable();
	
	private JPanel contractPanel = new ContractsPanel();
	
	
	public ContractsFrame(){
	super();
	
	this.setLayout(new BorderLayout());
	this.setSize(800, 600);
	this.setMinimumSize(new Dimension(800, 600));
	this.setResizable(true);
	this.setTitle("Persons and contracts");
	// Get the size of the screen
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	// Determine the new location of the window
			int w = this.getSize().width;
			int h = this.getSize().height;
			int x = (dim.width - w) / 2;
			int y = (dim.height - h) / 2;

			// Move the window
			this.setLocation(x, y);
			
		newPersonButton = new JButton("New person");
		ContractButton = new JButton("Contracts");
		okButton = new JButton("OK");
		exitButton = new JButton("Exit");
		
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(newPersonButton);
		pnlButtons.add(ContractButton);
		
		JPanel pnl2Buttons = new JPanel();
		pnl2Buttons.setLayout(new FlowLayout());
		pnl2Buttons.add(okButton);
		pnl2Buttons.add(exitButton);
		
		this.add(pnlButtons, BorderLayout.NORTH);
		this.add(pnl2Buttons, BorderLayout.SOUTH);
		
		//this.add(new JScrollPane(contracts), BorderLayout.CENTER);
		this.add(contractPanel, BorderLayout.CENTER);

		newPersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contractPanel.setVisible(false);
			}
		});
		ContractButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contractPanel.setVisible(true);
			}
		});
	
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
		
	}
	public void setPresenter(ContractsPresenter pres) {
		presenter = pres;
	}
}