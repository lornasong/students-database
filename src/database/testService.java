package database;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService
@Produces({ "text/html" })
@Path("/hi")
public class testService {

	@GET
	@WebMethod
	@Path("/hi")
	public String root() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html><body>\n");
		sb.append("<h1> Working </h1>\n");
		return sb.toString();
	}
}