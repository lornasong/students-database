package database;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@WebService
@Produces({ "text/html" })
@Path("/home/modify")
public class ModifyService {

	private final StudentDatabaseWeb db;

	public ModifyService(StudentDatabaseWeb db) {
		this.db = db;
	}

	@Path("")
	@GET
	@WebMethod
	public String modify() {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> How would you like to modify your database? </h1>\n");

		sb.append("<UL>");
		sb.append("<form action='http://localhost:8080/home/modify/add'><input type='submit' value='Add a Student'></form>");
		sb.append("<form action='http://localhost:8080/home/modify/edit'><input type='submit' value='Edit a Student'></form>");
		sb.append("<form action='http://localhost:8080/home/modify/remove'><input type='submit' value='Remove a Student'></form>");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>");

		sb.append("</body></html>\n");
		return sb.toString();
	}

	@Path("/add")
	@GET
	@WebMethod
	public String modifyAddStudent(@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName, @QueryParam("age") int age) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> ADD </h1>\n");

		sb.append("<p><form>\n");
		sb.append("First Name: <input name='firstName' required type='text'/>");
		sb.append("Last Name: <input name='lastName' required type='text'/>");
		sb.append("Age: <input name='age' required type='text'/>");
		sb.append("<input type='submit' />\n");
		sb.append("</body></html>\n");
		sb.append("</form></p>\n");
		
		sb.append("<br/><br/> <br/>");

		if (firstName != null && !firstName.trim().isEmpty()) {
			sb.append("Success! You have added the following student: ");
			sb.append(db.addStudent(firstName, lastName, age));
		}
		else{
			sb.append("Failed to add student");
		}
		sb.append("</html></body>\n");
		sb.append("<br />");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>");
		
		return sb.toString();
	}

	@Path("/edit")
	@GET
	@WebMethod
	public String modifyEditStudent(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> EDIT </h1>\n");

		sb.append("</body></html>\n");
		sb.append("<br />");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>");

		return sb.toString();
	}

	@Path("/remove")
	@GET
	@WebMethod
	public String modifyRemoveStudent(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> REMOVE </h1>\n");

		sb.append("</body></html>\n");
		sb.append("<br />");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>");

		return sb.toString();
	}

}