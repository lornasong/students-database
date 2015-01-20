package database;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService
@Produces({ "text/html" })
@Path("/home")
public class ExportService {

	private final StudentDatabaseWeb db;
	
	public ExportService(StudentDatabaseWeb db){
		this.db = db;
	}
	
	@Path("/export")
	@GET
	@WebMethod
	public String exportData() {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append(db.saveDataAsCsv());
		sb.append("</body></html>\n");
		
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>");

		return sb.toString();
	}
}