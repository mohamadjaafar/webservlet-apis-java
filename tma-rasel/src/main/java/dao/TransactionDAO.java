package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import db.DBUtil;
import exception.CustomException;
import exception.CustomEnums.ExceptionType;
import models.AssignTrack;
import models.Assignment;
import models.Confidentiality;
import models.Entity;
import models.ExternalPraty;
import models.Priority;
import models.SourceType;
import models.Status;
import models.Transaction;

public class TransactionDAO {
	private Connection conn = null;

	public TransactionDAO() {
		new DBUtil();
	}

	public List<Transaction> getTransactions(Integer entityId, Integer confidentialityId, Integer priorityId,
			Integer statusId, Integer transCategory, Long transDate, Integer transSourceId, Integer assignToEntityId,
			Integer externalPartyId) throws SQLException {

		List<Transaction> transactions = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM TRANSACTIONS WHERE 1 = 1");
		List<Object> params = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			if (entityId != null) {
				sql.append(" AND ENTITY_ID = ?");
				params.add(entityId);
			}

			if (confidentialityId != null) {
				sql.append(" AND CONFIDENTIALITY_ID = ?");
				params.add(confidentialityId);
			}

			if (priorityId != null) {
				sql.append(" AND PRIORITY_ID = ?");
				params.add(priorityId);
			}

			if (statusId != null) {
				sql.append(" AND STATUS_ID = ?");
				params.add(statusId);
			}

			if (transCategory != null) {
				sql.append(" AND TRANS_VW_TRANS_CATEGORY = ?");
				params.add(transCategory);
			}

			if (transDate != null) {
				sql.append(" AND TRANS_VW_TRANS_DATE = ?");
				params.add(transDate);
			}

			if (transSourceId != null) {
				sql.append(" AND TRANS_VW_TRANS_SOURCE_ID = ?");
				params.add(transSourceId);
			}

			if (assignToEntityId != null) {
				sql.append(" AND ASSIGNTO_ENTITY_ID = ?");
				params.add(assignToEntityId);
			}

			if (externalPartyId != null) {
				sql.append(" AND EXTERNAL_PARTY_ID = ?");
				params.add(externalPartyId);
			}
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			// Set parameter values
			int index = 1;
			for (Object param : params) {
				statement.setObject(index++, param);
			}

			try (ResultSet rs = statement.executeQuery()) {
				transactions = getTransactionsFromResultSet(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.closeConnection(conn);
		}

		return transactions;
	}

	private List<Transaction> getTransactionsFromResultSet(ResultSet rs) throws SQLException {
		List<Transaction> transactions = new ArrayList<>();

		while (rs.next()) {
			Transaction transaction = mapToTransaction(rs);
			transactions.add(transaction);
		}

		return transactions;
	}

	public Transaction getTransactionById(String transId) throws SQLException, CustomException {
		Transaction transaction = null;
		boolean resultSetEmpty = true;
		if (null != transId) {
			String query = "SELECT at.*, t.*, a.*,"
					+ " s.id AS s_id, s.Description AS s_description,"
					+ " p.id AS p_id, p.Description AS p_description,"
					+ " e.id AS e_id, e.Description AS e_description, e.name as e_name,"
					+ " c.id AS c_id, c.Description AS c_description,"
					+ " st.id AS st_id, st.Description AS st_description,"
					+ " ep.id AS ep_id, ep.name as ep_name"
					+ " FROM Transactions t"
					+ " LEFT JOIN AssignTrack at ON t.assign_track_id = at.id"
					+ " LEFT JOIN Assignment a ON at.id = a.assign_track_id"
					+ " LEFT JOIN ENTITY e ON e.id = t.entity_id"
					+ " LEFT JOIN STATUS s ON s.id = t.status_id"
					+ " LEFT JOIN PRIORITY p ON p.id = t.priority_id"
					+ " LEFT JOIN Confidentiality c ON c.id = t.confidentiality_id"
					+ " LEFT JOIN Source_Type st ON st.id = t.source_type_id"
					+ " LEFT JOIN EXTERNAL_PRATY ep ON ep.id = t.external_party_id"
					+ " WHERE t.TRANS_VW_TRANS_ID = ?;";
			
			try {
				conn = DBUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setLong(1, Long.parseLong(transId));
				ResultSet rs = statement.executeQuery();
			
				while (rs.next()) {
					resultSetEmpty = false;
					transaction = mapToTransaction(rs);
				}
				if(resultSetEmpty) {
		    		throw new CustomException(ExceptionType.ITEM_NOT_FOUND_EXCEPTION);
				}
			} catch (CustomException e) {
	    		throw e;

			} finally {
				// Close resources
				DBUtil.closeConnection(conn);
			}
		}
		return transaction;
	}

	public void updateTransaction(Long transId, int assignTrackId) throws Exception {
		String sql = "UPDATE TRANSACTIONS SET ASSIGN_TRACK_ID = ? WHERE TRANS_VW_TRANS_ID = ?";
		try {
			conn = DBUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, assignTrackId);
			preparedStatement.setLong(2, transId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			DBUtil.closeConnection(conn);
		}

	}

	private Transaction mapToTransaction(ResultSet rs) throws SQLException {
		Transaction transaction = null;
	    AssignTrack assignTrack = null;
	    do {
	    	if(transaction == null) {
	    		transaction = new Transaction();
	    		transaction.setTransVwTransId(rs.getLong("TRANS_VW_TRANS_ID"));
				transaction.setTransVwTransNo(rs.getInt("TRANS_VW_TRANS_NO"));
				// Set other fields similarly
//		           transaction.setTransVwTransDate(rs.getTimestamp("TRANS_VW_TRANS_DATE").toLocalDateTime());
				transaction.setTransVwPersonDesc(rs.getString("TRANS_VW_PERSON_DESC"));
				transaction.setTransVwConfidentialConfidDesc(rs.getString("TRANS_VW_CONFIDENTIALCONFIDDES"));
				transaction.setTransVwPriorityDesc(rs.getString("TRANS_VW_PRIORITYDESC"));
				transaction.setTransVwStatusDesc(rs.getString("TRANS_VW_STATUSDESC"));
				transaction.setTransVwSubject(rs.getString("TRANS_VW_SUBJECT"));
				transaction.setTransVwSourceDesc(rs.getString("TRANS_VW_SOURCE_DESC"));
				transaction.setTransVwInOutDest(rs.getString("TRANS_VW_INOUT_DEST"));
				transaction.setFullTransNo(rs.getString("FULL_TRANS_NO"));
				transaction.setFlaged(rs.getBoolean("IS_FLAGED"));
				transaction.setCanView(rs.getBoolean("CAN_VIEW"));
				transaction.setAssignToEntityId(rs.getInt("ASSIGNTO_ENTITY_ID"));
				transaction.setCreatedByEntityId(rs.getInt("CREATED_BY_ENTITY_ID"));
				transaction.setCreatedByPersonId(rs.getInt("CREATED_BY_PERSON_ID"));
//		           transaction.setRemindDate(rs.getTimestamp("REMIND_DATE").toLocalDateTime());
				transaction.setDescription(rs.getString("DESCRIPTION"));
				transaction.setProcessId(rs.getInt("PROCESS_ID"));
				transaction.setTransVwTransSourceId(rs.getInt("TRANS_VW_TRANS_SOURCE_ID"));
				transaction.setTransVwTransDateHj(rs.getLong("TRANS_VW_TRANS_DATE_HJ"));
				transaction.setTransVwConcernedEntityId(rs.getInt("TRANS_VW_CONCERNED_ENTITY_ID"));
				transaction.setTransVwEntityDesc(rs.getString("TRANS_VW_ENTITY_DESC"));
				transaction.setTransVwConfidId(rs.getInt("TRANS_VW_CONFID_ID"));
				transaction.setPriorityNo(rs.getInt("PRIORITY_NO"));
				transaction.setTransVwLinkTypeDesc(rs.getString("TRANS_VW_LINKTYPEDESC"));
				transaction.setTransVwAbbrAr(rs.getString("TRANS_VW_ABBR_AR"));
				transaction.setTransVwTransCategory(rs.getInt("TRANS_VW_TRANS_CATEGORY"));
				transaction.setTransVwRemarksAr(rs.getString("TRANS_VW_REMARKS_AR"));
				transaction.setTransVwCityName(rs.getString("TRANS_VW_CITYNAME"));
				transaction.setInquiryStatus(rs.getString("INQUIRY_STATUS"));
				transaction.setTabId(rs.getString("TAB_ID"));
				transaction.setExtTransNo(rs.getString("EXT_TRANS_NO"));
				transaction.setSubjectType(rs.getString("SUBJECT_TYPE"));
				transaction.setDateDifference(rs.getString("Date_difference"));
				transaction.setTypeId(rs.getInt("TYPE_ID"));
				transaction.setGroupId(rs.getString("GROUPID"));
				transaction.setArchived(rs.getInt("ARCHIVED"));
				transaction.setCreatingCabinetUserDefined(rs.getString("CREATING_CABINET_USERDEFINED"));
				transaction.setIncludedItemsNumber(rs.getInt("INCLUDEDITEMS_NUMBER"));
				transaction.setAssignToEntityName(rs.getString("ASSIGNTO_ENTITYNAME"));
				transaction.setIsOwner(rs.getInt("IS_OWNER"));
				transaction.setOldSysTransNo(rs.getString("OLD_SYS_TRANS_NO"));
				transaction.setNeedEncrypt(rs.getInt("NEED_ENCRYPT"));
				transaction.setInternalOutbound(rs.getBoolean("IS_INTERNAL_OUTBOUND"));
				transaction.setParticular(rs.getBoolean("IS_PARTICULAR"));
				transaction.setCreatedByEntityId(rs.getInt("CreatedByEntityId"));
				transaction.setRemindDateHj(rs.getLong("REMIND_DATE_HJ"));
	    	}
	    	if(0 != rs.getInt("s_id") && null != rs.getString("s_description")) {
	    		Status status = new Status();
	    		status.setId(rs.getInt("s_id"));
	    		status.setStatusDescription(rs.getString("s_description"));
	    		transaction.setStatus(status);
	    	}
	    	if(0 != rs.getInt("p_id") && null != rs.getString("p_description")) {
	    		Priority priority = new Priority();
	    		priority.setId(rs.getInt("p_id"));
	    		priority.setPriorityDescription(rs.getString("p_description"));;
	    		transaction.setPriority(priority);
	    	}
	    	if(0 != rs.getInt("c_id") && null != rs.getString("c_description")) {
	    		Confidentiality confidentiality = new Confidentiality();
	    		confidentiality.setId(rs.getInt("c_id"));
	    		confidentiality.setConfidentialityDescription(rs.getString("p_description"));
	    		transaction.setConfidentiality(confidentiality);
	    	}
	    	if(0 != rs.getInt("st_id") && null != rs.getString("st_description")) {
	    		SourceType sourceType = new SourceType();
	    		sourceType.setId(rs.getInt("st_id"));
	    		sourceType.setSourceTypeDescription(rs.getString("p_description"));
	    		transaction.setSourceType(sourceType);
	    	}
	    	if(0 != rs.getInt("e_id") && null != rs.getString("e_description")) {
	    		Entity entity = new Entity();
	    		entity.setId(rs.getInt("e_id"));
	    		entity.setDescription(rs.getString("e_description"));
	    		entity.setName(rs.getString("e_name"));
	    		transaction.setEntity(entity);
	    	}
	    	if(0 != rs.getInt("ep_id") && null != rs.getString("ep_name")) {
	    		ExternalPraty praty = new ExternalPraty();
	    		praty.setExternalPratyId(rs.getInt("ep_id"));
	    		praty.setExternalPratyName(rs.getString("ep_name"));
	    		transaction.setExternalParty(praty);
	    	}
	    	
	    	
	    	
	    	if(assignTrack == null && null != rs.getString("PHYSICAL_ENTITY")) {
	            assignTrack = new AssignTrack();
	            assignTrack.setId(rs.getInt("ID"));
	            assignTrack.setPhysicalEntity(rs.getString("PHYSICAL_ENTITY"));
	            assignTrack.setElcEntity(rs.getString("ELC_ENTITY"));
	            assignTrack.setPhysicalDate(rs.getDate("PHYSICAL_DATE").toLocalDate());
	            assignTrack.setElcDate(rs.getDate("ELC_DATE").toLocalDate());
	    	}
		    if(null != rs.getString("FROM_PERSON")) {
		    Assignment assignment = new Assignment();
	        assignment.setId(rs.getInt("ID"));
	        assignment.setFromPerson(rs.getString("FROM_PERSON"));
	        assignment.setFromEntity(rs.getString("FROM_ENTITY"));
	        assignment.setToPerson(rs.getString("TO_PERSON"));
	        assignment.setToEntity(rs.getString("TO_ENTITY"));
	        assignment.setDate(rs.getDate("DATE").toLocalDate());
	        assignment.setProcessName(rs.getString("PROCESS_NAME"));
	        
	        // Add assignment to the assignTrack object
	        assignTrack.addAssignment(assignment);
		    }
		    
	    }
	    while(rs.next());
	    transaction.setAssignTrack(assignTrack);
	    
		return transaction;
	}

}
