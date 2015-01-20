package database;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@WebService
@Produces({ "text/html" })
@Path("/home")
public class HomeService {
	
	private final StudentDatabaseWeb db;
	
	public HomeService(StudentDatabaseWeb db){
		this.db = db;
	}

	@GET
	@WebMethod
	public String home(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> Welcome to ");
		sb.append(db.getSchoolName());
		sb.append("!</h1>\n");

		sb.append("Please Choose an Action For Your Database:");
		sb.append("<br />");
		sb.append("<UL>");
		sb.append("<form action='http://localhost:8080/home/modify'><input type='submit' value='Modify'></form>");
		sb.append("<form action='http://localhost:8080/home/search'><input type='submit' value='Search'></form>");
		sb.append("<form action='http://localhost:8080/home/view_default'><input type='submit' value='View'></form>");
		sb.append("<form action='http://localhost:8080/home/export'><input type='submit' value='Export'></form>");

		sb.append("</body></html>\n");
		return sb.toString();
	}
}