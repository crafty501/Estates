
package de.dis2011.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import de.dis2016.model.Apartment;
import de.dis2016.model.Estate;
import de.dis2016.model.House;

public class DB2 extends DB2ConnectionManager {

	public DB2() {
		super();

	}

	/**
	 * Diese Methode sendet eine SQL Anfrage an die Datenbank und wirft ggf.
	 * eine SQLException
	 * 
	 * @param S
	 * 
	 * @param result
	 *            , falls die SQL-Anfrage ein Result hat muss hier true
	 *            angegeben werden
	 * @return
	 * @throws SQLException
	 */
	private ResultSet SendQuery(String S, boolean result) throws SQLException {

		try {

			Statement stm = this.con.createStatement();

			if (result) {
				if (stm.execute(S)) {
					return stm.getResultSet();
				} else {
					return null;
				}
			} else {
				stm.execute(S);
				return null;
			}

		} catch (SQLException e) {
			throw e;

		}
	}

	public void Save_new_Makler(Makler m) {

		String Adresse = m.getAddress();
		String Name = m.getName();
		String Login = m.getLogin();
		String Passwort = m.getPassword();

		String Anfrage = "INSERT INTO Estate_Agent " + "(Name,Addres,Login,Passwort) " + "VALUES" + "('" + Name + "','"
				+ Adresse + "','" + Login + "','" + Passwort + "')";
		try {
			this.SendQuery(Anfrage, false);
			System.out.println(Anfrage);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Die Anfrage konnte nicht verarbeitet werden!" + e.getMessage());
		}
	}

	public ArrayList<Makler> Gib_alle_Markler() {

		String Anfrage = "SELECT NAME,ADDRES,LOGIN,PASSWORT FROM Estate_Agent";

		try {
			ResultSet s = this.SendQuery(Anfrage, true);
			System.out.println(Anfrage);
			ArrayList liste = new ArrayList<Makler>();

			System.out.println("ResultSet row count = " + s.getRow());

			if (s.getRow() != 0) {
				while (s.next()) {

					String Name = s.getString("NAME");
					String Adresse = s.getString("ADDRES");
					String Login = s.getString("LOGIN");
					String Passwort = s.getString("PASSWORT");
					System.out.println(Name + " " + Adresse + " " + Login + " " + Passwort);

					Makler m = new Makler();
					m.setAddress(Adresse);
					m.setName(Name);
					m.setLogin(Login);
					m.setPassword(Passwort);

					liste.add(m);
				}
			}

			return liste;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * CREATE Estate_Agent( Name varchar(255), Addres text, Login varchar(255)
	 * NOT NULL UNIQUE, Passwort varchar(255) NOT NULL, PRIMARY KEY(Login) );
	 * 
	 * @param Login
	 * @return Makler
	 */
	public Makler Gib_Makler(String Login) {

		String Anfrage = "SELECT * FROM Estate_Agent WHERE Login='" + Login + "';";
		// System.out.println(Anfrage);
		try {
			ResultSet result = this.SendQuery(Anfrage, true);
			int size = 0;
			if (result == null) {
				return null;
			} else {
				size = result.getFetchSize();
			}
			System.out.println("size=" + size);
			String Name = result.getString(0); // Name varchar(255)
			String Addres = result.getString(1);
			String Login_id = result.getString(2);
			String Pass = result.getString(3);

			Makler m = new Makler();
			m.setName(Name);
			m.setAddress(Addres);
			m.setLogin(Login_id);
			m.setPassword(Pass);

			return m;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<House> getHouses(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Estate> getEstates(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEstate(Estate estate) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean addApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		return true;
	}

	public int createContract() {
		return new Random(20000).nextInt();
	}

	private static final String ADD_HOUSE = "INSERT INTO House (ESTATE_ID,Floors,Price,Garden,person_id,purchase_contract) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public void addHouse(House house) {

		try {
			int id = addEstate(house);

			PreparedStatement addHouse = con.prepareStatement(ADD_ESTATE);

			addHouse.setInt(1, id);
			addHouse.setInt(2, house.getFloors());
			addHouse.setInt(3, house.getPrice());
			addHouse.setInt(4, house.isGarden() ? 1 : 0);
			addHouse.setInt(3, house.getPersonid());
			addHouse.setInt(3, house.getContractnr());
			
			addHouse.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String ADD_APARTMENT = "INSERT Apartment Estate (ID,City,Postal_Code,Street,Street_Number,Square_Area,Login,person_id,Contract_No) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String ADD_ESTATE = "INSERT INTO Estate (City,Postal_Code,Street,Street_Number,Square_Area,Login,person_id,Contract_No) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private int addEstate(Estate estate) throws SQLException {

		estate.setContractnr(createContract());
		PreparedStatement addEstate = con.prepareStatement(ADD_ESTATE);

		addEstate.setString(1,estate.getCity());
		addEstate.setString(2,estate.getPostalCode());
		addEstate.setString(3,estate.getStreet());
		addEstate.setString(4,estate.getStreetNr());
		addEstate.setInt(5,estate.getSuareArea());
		addEstate.setString(6,estate.getLogin());
		addEstate.setInt(6,estate.getPersonid());
		addEstate.setInt(6,estate.getContractnr());
		
		addEstate.executeUpdate();
		
		ResultSet rs = addEstate.getGeneratedKeys();
		if(rs.next()) {
			  return rs.getInt(1);
		}
		return -1;
	}

	public void updateEstate(Estate estate) {
		// TODO Auto-generated method stub

	}

}
