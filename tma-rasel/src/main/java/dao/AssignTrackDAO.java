package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


import db.DBUtil;
import dto.AssignRequestDTO;
import models.Entity;

public class AssignTrackDAO {
	private TransactionDAO transactionDAO;
	private Connection conn = null;
	private final String INSERT_TO_ASSIGN_TRACK = "INSERT INTO AssignTrack (PHYSICAL_ENTITY, ELC_ENTITY, PHYSICAL_DATE, ELC_DATE) VALUES (?, ?, ?, ?)";
	
	public AssignTrackDAO() {
		new DBUtil();
		transactionDAO = new TransactionDAO();
	}
	
	public void saveAssignTrack(Entity entity,AssignRequestDTO dto) throws Exception {
		String sql = INSERT_TO_ASSIGN_TRACK;
		int assignTrackId = 0;
        try{
        	conn = DBUtil.getConnection();
        	PreparedStatement preparedStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
            ResultSet rs ;
            int rowsAffected = preparedStatement.executeUpdate(); // Execute the insert query
            if (rowsAffected > 0) {
                System.out.println("Insert successful!");
                rs = preparedStatement.getGeneratedKeys(); // Retrieve the auto-generated keys
                if (rs.next()) {
                	assignTrackId = rs.getInt(1); 
                }
            }
            transactionDAO.updateTransaction(dto.getTransId(), assignTrackId);
            
        }
        catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


}
