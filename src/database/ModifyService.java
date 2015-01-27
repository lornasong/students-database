package database;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Includes all web services with url "/home/modify" base.
 * Which includes the modify default page, add, edit, and remove pages.
 * 
 * Allows users to perform these three actions on their database
 * @author lornasong
 *
 */
@WebService
@Produces({ "text/html" })
@Path("/home/modify")
public class ModifyService {

	private final StudentDatabaseWeb db;

	public ModifyService(StudentDatabaseWeb db) {
		this.db = db;
	}

	/**
	 * This is the header and buttons that will show up on all modification type pages.
	 * That is, on the Add, Edit, and Remove pages.
	 * Header will have button options to go to each page as well as "return home"
	 */
	public String modifyPageHeader(){
		
		StringBuilder sb = new StringBuilder();

		//Header Title
		sb.append("<html>\n");
		sb.append("<center><font face = 'verdana'><h1>").append("MODIFICATIONS").append("</h1></font></center>\n");
		sb.append("<hr width = '95%' size = '5' color = '#270A33'>");

		//Buttons: Add, Edit, Remove, Home
		sb.append("<body><blockquote>");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home' style = 'float: right'></form>");
		sb.append("<form action='http://localhost:8080/home/modify/remove'><input type='submit' value='Remove a Student' style = 'float: right'></form>");		
		sb.append("<form action='http://localhost:8080/home/modify/edit'><input type='submit' value='Edit a Student' style = 'float: right'></form>");		
		sb.append("<form action='http://localhost:8080/home/modify/add'><input type='submit' value='Add a Student' style = 'float: right'></form>");
		sb.append("</blockquote></body></html>\n");
		return sb.toString();
	}

	/**
	 * Modify 'home' page which only has header of options. Body is blank
	 */
	@Path("")
	@GET
	@WebMethod
	public String modify() {
		return modifyPageHeader();
	}

	/**
	 * Add student page. Has the modify header. Allows user to add students to database.
	 * User must include First name, Last name, and Age information.
	 */
	@Path("/add")
	@GET
	@WebMethod
	public String modifyAddStudent(@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName, @QueryParam("age") int age) {

		
		String tab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

		StringBuilder sb = new StringBuilder();
		
		//Page header
		sb.append(modifyPageHeader());
		
		//Input parameters
		sb.append("<html>\n");
		sb.append("<p><body><font face = 'verdana'><blockquote><form>\n");
		sb.append("<br/>").append("ADD").append("<br/>");
		sb.append("First Name: <input name='firstName' required type='text'/>\n");
		sb.append(tab).append("Last Name: <input name='lastName' required type='text'/>\n");
		sb.append(tab).append("Age: <input name='age' required type='text'/>\n");
		sb.append("<input type='submit' />\n");
		
		//Return: confirmation that student is added or fail
		sb.append("<br/><br/><br/>\n");

		if (firstName != null && !firstName.trim().isEmpty()) {
			sb.append(db.addStudent(firstName, lastName, age));
		}
		else{
			sb.append("Failed to add student");
		}
		
		//Close
		sb.append("</form></blockform></font></html></body></p>\n");
		
		return sb.toString();
	}

	/**
	 * Incomplete
	 */
	@Path("/edit")
	@GET
	@WebMethod
	public String modifyEditStudent() {

		StringBuilder sb = new StringBuilder();
		
		sb.append(modifyPageHeader());
		
		sb.append("<html><body>\n");
		
		sb.append("<font face = 'verdana'><h1>");
		sb.append("EDIT");
		sb.append("</h1></font>\n");

		sb.append("</body></html>\n");

		return sb.toString();
	}

	/**
	 * Incomplete
	 */
	@Path("/remove")
	@GET
	@WebMethod
	public String modifyRemoveStudent() {

		StringBuilder sb = new StringBuilder();


		sb.append(modifyPageHeader());

		sb.append("<html><body>\n");
		sb.append("<font face = 'verdana'><h1>");
		sb.append("REMOVE");
		sb.append("</h1></font>\n");

		sb.append("</body></html>\n");

		return sb.toString();
	}

}