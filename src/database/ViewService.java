package database;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService
@Produces({ "text/html" })
@Path("/home")
public class ViewService {

	private final StudentDatabaseWeb db;
	
	public ViewService(StudentDatabaseWeb db){
		this.db = db;
	}
	
	public String viewPageHeader(String type){
		
		StringBuilder sb = new StringBuilder();

		sb.append("<html>\n");
		sb.append("<font face = 'verdana'><h1>").append(type).append("</h1></font>\n");
		sb.append("<hr width = '95%' size = '5' color = '#270A33' align = 'left'/>\n");
		sb.append("<blockquote><style type='text/css'> form {display: inline;}</style>\n");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home' style = 'float: right'></form>\n");
		sb.append("<form action='http://localhost:8080/home/view_lastname'><input type='submit' value='View By Last Name'style = 'float: right'></form>\n");
		sb.append("<form action='http://localhost:8080/home/view_id'><input type='submit' value='View By ID' style = 'float: right'></form>\n");
		sb.append("<form action='http://localhost:8080/home/view_age'><input type='submit' value='View By Age'style = 'float: right'></form>\n");
		sb.append("<br/>").append("</blockquote>");

		sb.append("</html>");
		
		return sb.toString();

	}
	
	@Path("/view_id")
	@GET
	@WebMethod
	public String viewByID() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(viewPageHeader("VIEW BY ID"));

		sb.append("<html>");
		sb.append("<body><font face = 'verdana'>\n");		
		sb.append(db.getStudentListById()).append("\n");
		sb.append("</font></body></html>\n");
		
		return sb.toString();
	}
	
	@Path("/view_lastname")
	@GET
	@WebMethod
	public String viewByLastName() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>\n");
		sb.append("<font face = 'verdana'><h1>").append("VIEW BY LAST NAME").append("</h1></font>\n");
		sb.append("<blockquote><style type='text/css'> form {display: inline;}</style>\n");
		sb.append("<form action='http://localhost:8080/home/view_lastname'><input type='submit' value='View By Last Name'style = 'float: right'></form>\n");
		sb.append("<form action='http://localhost:8080/home/view_id'><input type='submit' value='View By ID' style = 'float: right'></form>\n");
		sb.append("<form action='http://localhost:8080/home/view_age'><input type='submit' value='View By Age'style = 'float: right'></form>\n");
		sb.append("<br/>").append("</blockquote>");
		sb.append("<hr width = '95%' size = '5' color = '#270A33' align = 'left'>\n");
		
		sb.append("<body><font face = 'verdana'>\n");		
		sb.append(db.getStudentListByLastName()).append("\n");
		sb.append("<br/>");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>\n");
		sb.append("</font></body></html>\n");
		
		return sb.toString();
	}
	
	@Path("/view_age")
	@GET
	@WebMethod
	public String viewByAge() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>\n");
		sb.append("<font face = 'verdana'><h1>").append("VIEW BY AGE").append("</h1></font>\n");
		sb.append("<blockquote><style type='text/css'> form {display: inline;}</style>\n");
		sb.append("<form action='http://localhost:8080/home/view_lastname'><input type='submit' value='View By Last Name'style = 'float: right'></form>\n");
		sb.append("<form action='http://localhost:8080/home/view_id'><input type='submit' value='View By ID' style = 'float: right'></form>\n");
		sb.append("<form action='http://localhost:8080/home/view_age'><input type='submit' value='View By Age'style = 'float: right'></form>\n");
		sb.append("<br/>").append("</blockquote>");
		sb.append("<hr width = '95%' size = '5' color = '#270A33' align = 'left'>\n");
		
		sb.append("<body><font face = 'verdana'>\n");		
		sb.append(db.getStudentListByAge()).append("\n");
		sb.append("<br/>");
		sb.append("<form action='http://localhost:8080/home'><input type='submit' value='Return Home'></form>\n");
		sb.append("</font></body></html>\n");
		
		return sb.toString();
	}
}