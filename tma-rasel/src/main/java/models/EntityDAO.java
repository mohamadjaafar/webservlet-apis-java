package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import exception.CustomEnums.ExceptionType;
import exception.CustomException;

public class EntityDAO {
	private Connection conn = null;
	private static final String GET_ENTITY_BY_ID_SQL = "SELECT * FROM ENTITY WHERE ID = ?";

	public EntityDAO() {
		new DBUtil();
	}

	private ResultSet getResultSet(String query) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// Get connection
		conn = DBUtil.getConnection();

		// Prepare statement
		stmt = conn.prepareStatement(query);

		// Execute query
		rs = stmt.executeQuery();

		return rs;

	}
	
	public List<Entity> getAllEntities() throws SQLException {
		List<Entity> entities = new ArrayList<>();
		String query = "SELECT * FROM ENTITY";
		try {
			ResultSet rs = getResultSet(query);

			// Process result set
			while (rs.next()) {
				Entity entity = new Entity();
				entity.setId(rs.getInt("ID"));
				entity.setCabinet(rs.getBoolean("IS_CABINET"));
				entity.setExternalSend(rs.getBoolean("EXTERNAL_SEND"));
				entity.setExternalReceive(rs.getBoolean("EXTERNAL_RECIEVE"));
				entity.setImportantParent(rs.getInt("IMPORTANT_PARENT"));
				entity.setParentId(rs.getInt("PARENT_ID"));
				entity.setLineage(rs.getString("LINEAGE"));
				entity.setActive(rs.getBoolean("ACTIVE"));
				entity.setDescription(rs.getString("DESCRIPTION"));
				entity.setUserDefinedId(rs.getString("USER_DEFINED_ID"));
				entity.setCabinetId(rs.getInt("CABINET_ID"));
				entity.setName(rs.getString("Name"));
				entity.setActionTrace(rs.getBoolean("ACTION_TRACE"));
				entity.setReplaceByChild(rs.getInt("REPLACE_BY_CHILD"));
				entity.setBarCodeSymbol(rs.getString("BAR_CODE_SYMBOL"));
				// Add entity to list
				entities.add(entity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// Close resources
			DBUtil.closeConnection(conn);
		}
		return entities;
	}
	
	public Entity getEntityById(int i) throws Exception {
		Entity entity = null;
		boolean rsEmpty = true;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(GET_ENTITY_BY_ID_SQL);
			statement.setLong(1, i);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				rsEmpty = false;
				entity = new Entity();
				entity.setName(rs.getString("name"));
				entity.setId(rs.getInt("ID"));
			}
			
			if(rsEmpty == true) {
				throw new CustomException(ExceptionType.ITEM_NOT_FOUND_EXCEPTION);
			}
		}
		catch (CustomException e) {
			throw new CustomException(ExceptionType.OTHER_EXCEPTION,e);
		}
		return entity;
	}
}
