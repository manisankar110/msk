package com.msk.automobiles.service.pojos;

public class Customer_Details_Pojo {

	private String customer_id;
	private String first_name;
	private String mobile;
	private String model;
	private String registration_no;
	private String gst_no;
	private String current_service_date;

	public Customer_Details_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer_Details_Pojo(String customer_id, String first_name, String mobile, String model,
			String registration_no, String gst_no, String current_service_date) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.mobile = mobile;
		this.model = model;
		this.registration_no = registration_no;
		this.gst_no = gst_no;
		this.current_service_date = current_service_date;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}

	public String getGst_no() {
		return gst_no;
	}

	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	public String getCurrent_service_date() {
		return current_service_date;
	}

	public void setCurrent_service_date(String current_service_date) {
		this.current_service_date = current_service_date;
	}

	@Override
	public String toString() {
		return "Customer_Details_Pojo [customer_id=" + customer_id + ", first_name=" + first_name + ", mobile=" + mobile
				+ ", model=" + model + ", registration_no=" + registration_no + ", gst_no=" + gst_no
				+ ", current_service_date=" + current_service_date + "]";
	}

}
