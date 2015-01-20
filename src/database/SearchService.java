package database;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@WebService
@Produces({ "text/html" })
@Path("/home/search")
public class SearchService {

	private final StudentDatabaseWeb db;

	public SearchService(StudentDatabaseWeb db) {
		this.db = db;
	}

	@Path("")
	@GET
	@WebMethod
	public String search(@QueryParam("fullName") String fullName,
			@QueryParam("id") String id) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> Search </h1>\n");
		sb.append("</body></html>\n");

		sb.append("<p><form>\n");
		sb.append("Full Name: <input name='fullName' type='text'/>");
		sb.append("ID: <input name='id' type='text'/>");
		sb.append("<input type='submit' />\n");
		sb.append("</body></html>\n");
		sb.append("</form></p>\n");
		
		sb.append("<br/><br/> Results: <br/>");

		// Case that ID is empty. Query using full name
		if (id != null && !id.trim().isEmpty()) {
			
			try {
				int idInt = Integer.parseInt(id);
				sb.append(db.getStudentByParameters(fullName, idInt));
			} catch (NumberFormatException nfe) {
				sb.append("The ID is invalid");
			}
			
			
		} else {
			sb.append(db.getStudentByParameters(fullName, 0));
		}
		
		sb.append("<br />");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>");


		return sb.toString();
	}
}