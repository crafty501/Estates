package de.dis2011;

import de.dis2016.ui.main_ui;

/**
 * Hauptklasse
 */
public class Main {
	/**
	 * Startet die Anwendung
	 */
	public static void main(String[] args) {

		// showMainMenu();
		main_ui main_ui = new main_ui();
		main_ui.setSize(230, 200);
		main_ui.setVisible(true);
	}

}
