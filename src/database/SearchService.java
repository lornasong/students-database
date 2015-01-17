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

	@Path("")
	@GET
	@WebMethod
	public String search(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> Search </h1>\n");

		sb.append("</body></html>\n");
		return sb.toString();
	}
}