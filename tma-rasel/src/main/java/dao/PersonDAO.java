package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBUtil;
import models.Person;

public class PersonDAO {
	private Connection conn = null;
	private final String GET_PERSON_BY_ID = "SELECT * FROM PERSON WHERE ID = ?";
	
	public PersonDAO() {
		new DBUtil();
	}
	
	public Person getPersonById(int personId) throws Exception {
		String sql = GET_PERSON_BY_ID;
		Person person = new Person();
		try{
        	conn = DBUtil.getConnection();
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,personId);
            ResultSet rs  = preparedStatement.executeQuery();
                if (rs.next()) {
                	person.setId(personId);
                	person.setName(rs.getString("name"));
                	person.setName(rs.getString("fullName"));
                }
            
        }
        catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		return person;

	}

}
