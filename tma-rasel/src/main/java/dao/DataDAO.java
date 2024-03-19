package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import models.Confidentiality;
import models.Entity;
import models.ExternalPraty;
import models.Priority;
import models.SourceType;
import models.Status;

public class DataDAO {
	private Connection conn = null;

	public DataDAO() {
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

	public List<Status> getAllStatuses() throws SQLException {
		List<Status> statuses = new ArrayList<Status>();
		String query = "SELECT * FROM STATUS";
		try {
			ResultSet rs = getResultSet(query);

			while (rs.next()) {
				Status status = new Status();
				status.setId(rs.getInt("ID"));
				status.setStatusDescription(rs.getString("DESCRIPTION"));
				status.setTransCategory(rs.getInt("TRANS_CATEGORY"));

				statuses.add(status);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}finally {
			// Close resources
			DBUtil.closeConnection(conn);
		}
		return statuses;

	}

	public List<Priority> getAllPriorityes() throws SQLException {
		List<Priority> Priorities = new ArrayList<Priority>();
		String query = "SELECT * FROM Priority";
		try {
			ResultSet rs = getResultSet(query);

			while (rs.next()) {
				Priority Priority = new Priority();
				Priority.setId(rs.getInt("ID"));
				Priority.setPriorityDescription(rs.getString("DESCRIPTION"));
				Priority.setTransCategory(rs.getInt("TRANS_CATEGORY"));

				Priorities.add(Priority);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			// Close resources
			DBUtil.closeConnection(conn);
		}
		return Priorities;
	}

	public List<Confidentiality> getAllConfidentialities() throws SQLException {
		List<Confidentiality> confidentialities = new ArrayList<Confidentiality>();
		String query = "SELECT * FROM Confidentiality";
		try {
			ResultSet rs = getResultSet(query);

			while (rs.next()) {
				Confidentiality Confidentiality = new Confidentiality();
				Confidentiality.setId(rs.getInt("ID"));
				Confidentiality.setConfidentialityDescription(rs.getString("DESCRIPTION"));
				Confidentiality.setTransCategory(rs.getInt("TRANS_CATEGORY"));

				confidentialities.add(Confidentiality);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			// Close resources
			DBUtil.closeConnection(conn);
		}
		return confidentialities;
	}

	public List<SourceType> getAllSourceTypes() throws SQLException {
		List<SourceType> sourceTypes = new ArrayList<SourceType>();
		String query = "SELECT * FROM SOURCE_TYPE";
		try {
			ResultSet rs = getResultSet(query);

			while (rs.next()) {
				SourceType SourceType = new SourceType();
				SourceType.setId(rs.getInt("ID"));
				SourceType.setSourceTypeDescription(rs.getString("DESCRIPTION"));
				SourceType.setTransCategory(rs.getInt("TRANS_CATEGORY"));

				sourceTypes.add(SourceType);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			// Close resources
			DBUtil.closeConnection(conn);
		}
		return sourceTypes;
	}

	public List<ExternalPraty> getAllPraties() throws SQLException {
		List<ExternalPraty> praties = new ArrayList<ExternalPraty>();
		String query = "SELECT * FROM EXTERNAL_PRATY";
		try {
			ResultSet rs = getResultSet(query);

			while (rs.next()) {
				ExternalPraty praty = new ExternalPraty();
				praty.setExternalPratyId(rs.getInt("ID"));
				praty.setExternalPratyName(rs.getString("name"));

				praties.add(praty);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			// Close resources
			DBUtil.closeConnection(conn);
		}
		return praties;

	}
	
	public List<Entity> getAllEntities() throws SQLException{
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
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			// Close resources
			DBUtil.closeConnection(conn);
		}
		return entities;
	}
	}
