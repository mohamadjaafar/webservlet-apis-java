package service;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.AssignmentDAO;
import dao.DataDAO;
import dao.TransactionDAO;
import dto.AssignRequestDTO;
import dto.AssignResponseDTO;
import exception.CustomEnums.ExceptionType;
import exception.CustomException;
import models.Confidentiality;
import models.Entity;
import models.ExternalPraty;
import models.Priority;
import models.SourceType;
import models.Status;
import models.Transaction;

public class DataService {
	private DataDAO dao;
	private ObjectMapper objectMapper;
	private TransactionDAO transactionDAO;
	private AssignmentDAO assignmentDAO;
	public DataService() {
		dao = new DataDAO();
		objectMapper = new ObjectMapper();
		transactionDAO = new TransactionDAO();
		assignmentDAO = new AssignmentDAO();
		}

	   public List<Entity> getOrgHierarchy() throws SQLException {
	        return dao.getAllEntities();
	    }

	    public List<Status> getActiveStatuses() throws SQLException {
	        return dao.getAllStatuses();
	    }

	    public List<Priority> getActivePriorities() throws SQLException {
	        return dao.getAllPriorityes();
	    }

	    public List<Confidentiality> getActiveConfidentialities() throws SQLException {
	        return dao.getAllConfidentialities();
	    }

	    public List<SourceType> getActiveSourceTypes() throws SQLException {
	        return dao.getAllSourceTypes();
	    }

	    public List<ExternalPraty> getExternalPraty() throws SQLException {
	        return dao.getAllPraties();
	    }
	    
	    public Transaction getTransactionById(String transId) throws CustomException, SQLException {
	    	if(null ==  transId || transId.isBlank() || transId.isEmpty()) {
	    		throw new CustomException(ExceptionType.MISSING_PARAMS_EXCEPTION);
	    	}
	    	return transactionDAO.getTransactionById(transId);
	    }
	    
	    public AssignResponseDTO assignTransaction(HttpServletRequest request) throws Exception {
	    	return assignmentDAO.assignTransaction(objectMapper.readValue(request.getReader(), AssignRequestDTO.class));
	    }
	    
	    
	    public List<Transaction> getTransactions(HttpServletRequest request) throws SQLException, StreamReadException, DatabindException, IOException {
	        // Extract parameters from the request
	    	@SuppressWarnings("unchecked")
			Map<String, Object> jsonMap = objectMapper.readValue(request.getReader(), Map.class);
	        Integer entityId = getIntegerParameter(jsonMap, "EntityId");
	        Integer confidId = getIntegerParameter(jsonMap, "ConfidId");
	        Integer priorityId = getIntegerParameter(jsonMap, "PriorityId");
	        Integer statusId = getIntegerParameter(jsonMap, "StautsId"); // Typo corrected from "StautsId" to "StatusId"
	        Integer transCategory = getIntegerParameter(jsonMap, "TransCategory");
	        Long dueDate = convertDateToTimestamp(jsonMap,"DueDate");
	        Integer transSource = getIntegerParameter(jsonMap, "TransSource");
	        Integer assigneeId = getIntegerParameter(jsonMap, "AssigneeId");
	        Integer externalPartyId = getIntegerParameter(jsonMap, "ExternalPartyId");

	        // Call the DAO method with the extracted parameters
	        return transactionDAO.getTransactions(entityId, confidId, priorityId, statusId, transCategory, dueDate, transSource, assigneeId, externalPartyId);
	    }

	    // Helper method to get an Integer parameter from the request
	    private Integer getIntegerParameter(Map<String, Object> jsonMap, String paramName) {
	    	if(jsonMap.containsKey(paramName)) {
	    		 return Integer.parseInt(String.valueOf(jsonMap.get(paramName)));
	    	}
	        return null;
	    }
	    
	    private Long convertDateToTimestamp(Map<String, Object> jsonMap, String paramName) {
	    	Long dateTimestamp = null;
	    	if(jsonMap.containsKey(paramName)) {
		        // Parse the date string
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        LocalDateTime dateTime = LocalDateTime.parse(String.valueOf(jsonMap.get(paramName)), formatter);
	            dateTimestamp = dateTime.atZone(java.time.ZoneOffset.UTC).toEpochSecond();

		        }
	        // Convert LocalDateTime to Unix timestamp
	        return dateTimestamp;
	    }
}
