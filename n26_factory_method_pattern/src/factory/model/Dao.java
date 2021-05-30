package factory.model;

import java.sql.SQLException;

public class Dao {

	private static Dao dao = new Dao();

	private Dao(){
		System.out.println("Dao Constructor..");
	}
	
	public static Dao getInstance(){
		return dao;
	}
	
	/////////// business logic ///////////
	
	public NoteBook findNoteBookByModel(String model)throws SQLException {
		System.out.println("find noteBook :: " + model);
		NoteBook nb = new NoteBook("sense1007",1300000);
		return nb;
	}
}
