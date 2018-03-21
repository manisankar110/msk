package com.msk.automobiles.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import com.msk.automobiles.business.interfaces.Get_Business_Interface;
import com.msk.automobiles.business.interfaces.Insert_Business_Interface;
import com.msk.automobiles.business.interfaces.Update_Business_Interface;
import com.msk.automobiles.exception.CustomGenericException;
import com.msk.automobiles.service.pojos.Car_Brands_Pojo;
import com.msk.automobiles.service.pojos.Car_Models_Pojo;
import com.msk.automobiles.util.UtilityClass;

import net.minidev.json.JSONObject;

@Configuration
@PropertySource("classpath:/application_path.properties")
@Controller
@Path("/")
public class HomeController {

	@Autowired
	Get_Business_Interface get_Business_Interface;

	@Autowired
	Insert_Business_Interface insert_Business_Interface;

	@Autowired
	Update_Business_Interface update_Business_Interface;

	@Autowired
	UtilityClass util;

	@Autowired
	Environment env;

	@GET
	@Path("/")
	public Viewable index() {
		return new Viewable("/index");
	}
<<<<<<< HEAD

=======
	
>>>>>>> 03ecda00d576704d94f725bf4a174094466ea2b6
	@GET
	@Path("/login")
	public Viewable login() {
		return new Viewable("/login");
	}

	@GET
	@Path("/customer_details")
	public Viewable customer_details() {
		return new Viewable("/customer_details");
	}

	@POST
	@Path("/login")
	public Response login_cred(@FormParam("username") String username, @FormParam("password") String password,
			@Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		Viewable view = null;
		String status = null;

		try {
			String msk_Owner = get_Business_Interface.getMSKOwnerDetail(username, password);

			if (msk_Owner.equals("success")) {
				status = "success";

				mix.put("status", status);

				view = new Viewable("/customer_details.jsp", mix);
			} else {
				status = "failure";
				mix.put("status", status);

				view = new Viewable("/login.jsp", mix);
			}
		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

	@GET
	@Path("/car-brand")
	public Response car_brand() {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		Viewable view = null;
		try {
			List<Car_Brands_Pojo> brands = get_Business_Interface.getAllBrands();

			data.put("brands", brands);

			mix.put("data", data);

			view = new Viewable("/car_brands", mix);

		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

	@POST
	@Path("/{brand}/car-models")
	public Response car_models(@FormParam("brand_id") String brand_id, @Context HttpServletRequest request) {
		JSONObject mix = new JSONObject();
		JSONObject data = new JSONObject();

		Viewable view = null;
		try {
			List<Car_Models_Pojo> models = get_Business_Interface.getModels(brand_id);

			data.put("models", models);

			mix.put("data", data);

			view = new Viewable("/car_models", mix);

		} catch (Exception e) {
			throw new CustomGenericException("" + e.hashCode(), e.getMessage());
		}

		return Response.ok().entity(view).build();
	}

}