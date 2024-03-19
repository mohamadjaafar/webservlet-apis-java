package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import db.DBUtil;
import dto.AssignRequestDTO;
import dto.AssignResponseDTO;
import models.Entity;
import models.EntityDAO;
import models.Person;

public class AssignmentDAO {
	private Connection conn = null;
	private EntityDAO entityDAO;
	private AssignTrackDAO assignTrackDAO;
	private PersonDAO personDAO;


	public AssignmentDAO() {
		new DBUtil();
		entityDAO = new EntityDAO();
		assignTrackDAO = new AssignTrackDAO();
		personDAO = new PersonDAO();
	}
	
	public AssignResponseDTO assignTransaction(AssignRequestDTO dto) throws Exception {
        String sql = "DECLARE @transVwTransId INT, " +
                "@fromPerson VARCHAR(255), " +
                "@fromEntity VARCHAR(255), " +
                "@toPerson VARCHAR(255), " +
                "@toEntity VARCHAR(255), " +
                "@date DATE, " +
                "@processName VARCHAR(255), " +
                "@physicalEntity VARCHAR(255), " +
                "@elcEntity VARCHAR(255), " +
                "@physicalDate DATE, " +
                "@elcDate DATE, " +
                "@assignTrackId INT; " +
                "SET @transVwTransId = ?; " +
                "SET @fromPerson = ?; " +
                "SET @fromEntity = ?; " +
                "SET @toPerson = ?; " +
                "SET @toEntity = ?; " +
                "SET @date = ?; " +
                "SET @processName = ?; " +
                "SET @physicalEntity = ?; " +
                "SET @elcEntity = ?; " +
                "SET @physicalDate = ?; " +
                "SET @elcDate = ?; " +
                "SELECT @assignTrackId = assign_track_id " +
                "FROM TRANSACTIONS " +
                "WHERE TRANS_VW_TRANS_ID = @transVwTransId; " +
                "IF @assignTrackId IS NOT NULL " +
                "BEGIN " +
                "INSERT INTO Assignment (FROM_PERSON, FROM_ENTITY, TO_PERSON, TO_ENTITY, DATE, PROCESS_NAME, ASSIGN_TRACK_ID) " +
                "VALUES (@fromPerson, @fromEntity, @toPerson, @toEntity, @date, @processName, @assignTrackId); " +
                "END " +
                "ELSE " +
                "BEGIN " +
                "INSERT INTO AssignTrack (PHYSICAL_ENTITY, ELC_ENTITY, PHYSICAL_DATE, ELC_DATE) " +
                "VALUES (@physicalEntity, @elcEntity, @physicalDate, @elcDate); " +
                "SET @assignTrackId = SCOPE_IDENTITY(); " +
                "INSERT INTO Assignment (FROM_PERSON, FROM_ENTITY, TO_PERSON, TO_ENTITY, DATE, PROCESS_NAME, ASSIGN_TRACK_ID) " +
                "VALUES (@fromPerson, @fromEntity, @toPerson, @toEntity, @date, @processName, @assignTrackId); " +
                "END;";
        Entity fromEntity = entityDAO.getEntityById(dto.getFromEntityId());
        Entity toEntity = entityDAO.getEntityById(dto.getToEntityId());
        Person fromPerson = personDAO.getPersonById(dto.getFromPersonId());
        Person toPerson = personDAO.getPersonById(dto.getToPersonId());
		try {
			conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set parameter values
            pstmt.setLong(1, dto.getTransId());
            pstmt.setString(2, fromPerson.getFullName());
            pstmt.setString(3, fromEntity.getName());
            pstmt.setString(4, toPerson.getFullName());
            pstmt.setString(5, toEntity.getName());
            pstmt.setDate(6, Date.valueOf(LocalDate.now()));
            pstmt.setString(7, String.valueOf(dto.getProcessId()));
            pstmt.setString(8, toEntity.getName());
            pstmt.setString(9, toEntity.getName());
            pstmt.setDate(10, Date.valueOf(LocalDate.now()));
            pstmt.setDate(11, Date.valueOf(LocalDate.now()));
            pstmt.executeUpdate();

		}
            catch (Exception e) {
			// TODO: handle exception
            	e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}	
		
		AssignResponseDTO assignResponseDTO = new AssignResponseDTO();
		assignResponseDTO.setUserEntity(fromEntity.getName());
		assignResponseDTO.setDefaultEntityId(toEntity.getId());
		assignResponseDTO.setDefaultEntityName(toEntity.getName());
		assignResponseDTO.setUserId(fromPerson.getId());
		assignResponseDTO.setUserName(fromPerson.getName());
		assignResponseDTO.setUserFullName(fromPerson.getFullName());
		assignResponseDTO.setDescription("done");
		assignResponseDTO.setCode(null);
		return assignResponseDTO;
	}
	
    public void saveAssignment(AssignRequestDTO assignment) throws Exception {
        String sql = "INSERT INTO Assignment (FROM_PERSON, FROM_ENTITY, TO_PERSON, TO_ENTITY, DATE, PROCESS_NAME) VALUES (?, ?, ?, ?, ?, ?)";
        Entity fromEntity = entityDAO.getEntityById(assignment.getFromEntityId());
        Entity toEntity = entityDAO.getEntityById(assignment.getToEntityId());
        
        try{
        	conn = DBUtil.getConnection();
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "Person 1");
            preparedStatement.setString(2, fromEntity.getName());
            preparedStatement.setString(3, "Person 2");
            preparedStatement.setString(4, toEntity.getName());
            preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(6, String.valueOf(assignment.getProcessId()));
            preparedStatement.executeUpdate();
            
            assignTrackDAO.saveAssignTrack(toEntity,assignment);
        }
        catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
}
