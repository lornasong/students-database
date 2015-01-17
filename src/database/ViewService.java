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
public class ViewService {

	private final StudentDatabase db;
	
	public ViewService(StudentDatabase db){
		this.db = db;
	}
	
	@Path("/view_default")
	@GET
	@WebMethod
	public String viewByID(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> View By ID </h1>\n");
		sb.append(db.getStudentListString());

		sb.append("</body></html>\n");
		return sb.toString();
	}
	
	@Path("/view_surname")
	@GET
	@WebMethod
	public String viewByLastName(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> View By LastName </h1>\n");

		sb.append("</body></html>\n");
		return sb.toString();
	}
}