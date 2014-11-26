package es.uv.isw.sparrow.dao.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import es.uv.isw.sparrow.bean.Chip;
import es.uv.isw.sparrow.bean.User;
import es.uv.isw.sparrow.dao.ChipDAO;
import es.uv.isw.sparrow.dao.MySQLChipDAO;
import es.uv.isw.sparrow.dao.MySQLUserDAO;
import es.uv.isw.sparrow.dao.UserDAO;
//MIRAMELO si funcionasdasdasdasdas
public class SparrowDaoTest {

	public static void main(String[] args) {
		// Creamos los DAOs
		//ChipDAO chipDao = new MySQLChipDAO();
		UserDAO userDao = new MySQLUserDAO();
		ChipDAO chipDao = new MySQLChipDAO();

		try {
			testUsers(userDao);
			testChips(chipDao, userDao);
			
			deleteChips(chipDao);
			//deleteUsers(userDao);
		}
		catch (SQLException e) {
			System.out.println("SparrowDaoTest: Error al acceder al almacén.");
			System.out.println("SparrowDaoTest: " + e.getMessage());
			System.exit(0);
		}
	}
	
	public static void testUsers(UserDAO userDao) throws SQLException {
		
		try{
		// Creamos varios objetos de la clase User...
		User u1 = new User("pepe", "abc", "pepe@mail", "Jose", "Piscinas", "V", "es");
		User u2 = new User("mariano", "abc", "mariano@moncloa", "Mariano", "Rajoy", "V", "es");
		User u3 = new User("george", "abc", "george@hollywood", "George", "Cluny", "V", "en");
		
		// Insertamos los usuarios en la base de datos
		userDao.insert(u1);
		userDao.insert(u2);
		userDao.insert(u3);
		System.out.println("Tres usuarios creados.");
		}catch(Exception ex){};
		// Buscamos el usuario por username
		User u4 = userDao.findByUsername("george");
		if (u4 != null) {
			System.out.println(" Buscando por username 'george': " + printUser(u4));
		}
		else {
			System.out.println(" Buscando por username 'george': usuario no encontrado.");
		}
		
		// Buscamos el usuario por id
		User u5 = userDao.findById(u4.getId());
		if (u5 != null) {
			System.out.println(" Buscando por UID '" + u4.getId() + "': " + printUser(u5));
		}
		else {
			System.out.println(" Buscando por UID '" + u4.getId() + "': usuario no encontrado.");
		}
		
		// La lista de usuarios
		ArrayList<User> users = userDao.getAllUsers();
		System.out.println("La lista de usuarios:");
		for (User u : users) {
			System.out.println("  " + printUser(u));
		}
	}
	//isodnhaiuwdhiawud
	public static void testChips(ChipDAO chipDao, UserDAO userDao) throws SQLException {
		// Recuperamos la lista de usuarios
		ArrayList<User> users = userDao.getAllUsers();
		
		// Obtenemos varios uids
		 int uid1 = users.get(0).getId();
		 int uid2 = users.get(1).getId();
		 int uid3 = users.get(2).getId();
		 
		 
		 // Creamos varios chips...
		 Chip c1 = new Chip("primerChip", "Este es el primer chip del sistema.", -1, uid1);
		 Chip c2 = new Chip("MOCKS", "Esto parece ser un mock... no me creo nada", -1, uid2);
		 Chip c3 = new Chip("aforismos", "Los niños, los borrachos y los 'leggins' dicen siempre la verdad", -1, uid1);
		 chipDao.insert(c1);
		 chipDao.insert(c2);
		 chipDao.insert(c3);

		 // Obtenemos todos los chips
		 ArrayList<Chip> chips = chipDao.getAllChips();
		 Chip c4 = chips.get(0);
		 Chip c5 = chips.get(1);
		 Chip c6 = chips.get(2);
		 
		 // Creamos dos chips asociado al primero...
		 Chip c7 = new Chip(c4.getTag(), "Esta es la continuación de un primer chip", c4.getId(), uid2);
		 Chip c8 = new Chip(c4.getTag(), "Contestando al primer chip que contesta al primer chip", c4.getId(), uid1);
		 chipDao.insert(c7);
		 chipDao.insert(c8);
		 
		 //  Creamos chips asociados al segundo y al tercero
		 Chip c9 = new Chip(c5.getTag(), "Haces bien. Este mensaje es falso, como #primerChip", c5.getId(), uid1);
		 Chip c10 = new Chip(c6.getTag(), "Eso ha sido un comentario de mal gusto!", c6.getId(), uid3);
		 chipDao.insert(c9);
		 chipDao.insert(c10);
		 
		 // Imprimimos todos los chips por tag...
		 ArrayList<String> tags = chipDao.getTags();
		 System.out.println("\n-----------------------------------------------");
		 for (String t : tags) {
			 System.out.println("Tag #" + t);
			 chips = chipDao.findByTag(t);
			 for (Chip c : chips) {
				 System.out.println(printChip(c));
				 System.out.println("-----------------------------------------------");
			 }
			 System.out.println("\n-----------------------------------------------");
		 }
	}

	public static void deleteChips(ChipDAO chipDao) throws SQLException {
		// Obtenemos la lista de chips por thread...
		ArrayList<String> tags = chipDao.getTags();
		System.out.println("\n-----------------------------------------------");
		for (String t : tags) {
			System.out.print("Tag  " + t);
			ArrayList<Chip> chips = chipDao.findByTag(t);
			Collections.reverse(chips);
			System.out.print(": Borrando los chips ");
			for (Chip c : chips) {
				System.out.print(c.getId() + ", ");
				chipDao.delete(c);
			}
			System.out.println(".");
		}
	}

	public static void deleteUsers(UserDAO userDao) throws SQLException {
		// Obtenemos todos los usuarios
		ArrayList<User> users = userDao.getAllUsers();
		// Borramos todos los usuarios
		System.out.print("Borrando los usuarios ");
		for (User u : users) {
			userDao.delete(u);
			System.out.print(u.getId() + ", ");
		}
		System.out.println(".");
	}

	private static String printUser(User u) {
		String sb = "";
	
		sb = " " + u.getId() + " (" + u.getUsername() + "): "
				+ u.getNombre() + " " + u.getApellidos();
		
		return sb;
	}

	private static String printChip(Chip c) {
		String ch = "";
	
		ch = " Id: " + c.getId() + " [ Tag: #" + c.getTag() + ", Thread: " + c.getThread() + ", User: @" + c.getUser() + "]\n" +
				" Text: " + c.getText();
		
		return ch;
	}
}
