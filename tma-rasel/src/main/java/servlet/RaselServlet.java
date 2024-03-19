package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dto.AssignResponseDTO;
import exception.CustomException;
import models.Transaction;
import service.DataService;

/**
 * Servlet implementation class RaselServlet
 */
@WebServlet("/API/Data/*")
public class RaselServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataService dataService;
	
	public void init() {
		dataService = new DataService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RaselServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        String action = request.getPathInfo();
        log("path info is ".concat(action).concat("calling suitable function"));

        try {
            switch (action) {
                case "/GetOrgHierarchy":
                    getOrgHierarchy(response);
                    break;
                case "/GetActiveStautses":
                    getActiveStautses(response);
                    break;
                case "/GetActivePriorities":
                    getActivePriorities(response);
                    break;
                case "/GetActiveConfidentlalities":
                    getActiveConfidentlalities(response);
                    break;
                case "/GetActiveSourceTypes":
                    getActiveSourceTypes(response);
                    break;
                case "/GetTransaction":
                    getTransaction(request, response);
                    break;
                default:
                    getExternalPratis(response);
                    break;
            }
        } catch (IOException e) {
            // Handle IOException
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("An error occurred while processing the request: " + e.getMessage());
            log("IOException occurred: " + e.getMessage());
        } catch (SQLException e) {
            // Handle SQLException
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("An error occurred while accessing the database: " + e.getMessage());
            log("SQLException occurred: " + e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("An unexpected error occurred: " + e.getMessage());
            log("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Optionally print the full stack trace
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        String action = request.getPathInfo();
        log("path info is ".concat(action).concat("calling suitable function"));
        try {
			switch (action) {
			case "/GetAllTransactions":
				getAllTransaction(request,response);
				break;
			case "/AssignTransaction":
				assignTransaction(request,response);
				break;
			default:
				break;
			}
        }catch (Exception e) {
        	e.printStackTrace();
       }
	}
	
	
    private void createResponse(Object data,HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDate.class, new LocalDateSerializerDeserializer())
        .create();
        String jsonData = gson.toJson(data);
        // Write JSON data to response
        log("this is my test log for me");
        response.setContentType("application/json");
        response.getWriter().write(jsonData);
    }
    private void getAllTransaction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		try {
			List<Transaction> transactions = dataService.getTransactions(request);
			createResponse(transactions, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void assignTransaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	
		try {
			
			AssignResponseDTO assignResponseDTO = dataService.assignTransaction(request);
			createResponse(assignResponseDTO, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    private void getOrgHierarchy(HttpServletResponse response)throws IOException, SQLException{
    	createResponse(dataService.getOrgHierarchy(),response);
    }
    private void getActiveStautses(HttpServletResponse response) throws IOException, SQLException{
    	createResponse(dataService.getActiveStatuses(), response);
    }
    private void getActivePriorities(HttpServletResponse response) throws IOException, SQLException{
    	createResponse(dataService.getActivePriorities(), response);
    }
    private void getActiveConfidentlalities(HttpServletResponse response) throws IOException, SQLException{
    	createResponse(dataService.getActiveConfidentialities(), response);
    }
    private void getActiveSourceTypes(HttpServletResponse response) throws IOException, SQLException{
    	createResponse(dataService.getActiveSourceTypes(), response);
    }
    private void getExternalPratis(HttpServletResponse response) throws IOException, SQLException{
    	createResponse(dataService.getExternalPraty(), response);
    }
    private void getTransaction(HttpServletRequest request,HttpServletResponse response) throws IOException, CustomException, SQLException {
    	createResponse(dataService.getTransactionById(request.getParameter("transId")), response);
    }

}
