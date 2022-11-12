
package com.flames.controller;
import com.flames.model.CommonResponse;
import com.flames.service.FlamesService;
import com.ibm.mfp.adapter.api.OAuthSecurity;

import java.util.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/flames")
public class FlamesStartResource {

	static Logger logger = Logger.getLogger(FlamesStartResource.class.getName());

	@POST
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON})
	@OAuthSecurity(enabled = false)
	@Path("getRelation")
	public Response getRelation(@QueryParam("params") String request) {
		logger.info("Entry FlamesStartResource.getRelation :: " +request);
		CommonResponse response = new CommonResponse();
		try {
			FlamesService flamesService = new FlamesService();
			response = flamesService.getRelationType(request);
		} catch (Exception ex) {
			logger.info("getRelation Exception " + ex.getMessage());
		}
		logger.info("Exit FlamesStartResource.getRelation ");
		return Response.ok(response.getResponseText()).build();
	}

}
