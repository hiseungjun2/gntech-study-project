package com.gntech.dto;

public class orderDTO {

	private int id; // �Խñ� ��ȣ
	private String order_num; // �ֹ���ȣ
//	private String image; // �̹��� ���� �̸�
	private String pro_name; // ��ǰ��
	private String pro_content; // ��ǰ����
	private int price; // ��ǰ ����
	private String checkYN; // ���俩��
	private String status; // �������
	private String memo; // �޸�
	private String order_name; // �Ǹ����̸�
	private String order_phone; // �Ǹ��� �޴���
	private String order_address; // �Ǹ��� �ּ�
	private String order_date; // �ۼ���
	private int return_price; // ȸ�簡 ������ �ݾ�

	public orderDTO(int id, String order_num, String image, String pro_name, String pro_content, int price,
			String checkYN, String status, String memo, String order_name, String order_phone, String order_address,
			String order_date, int return_price) {
		super();
		this.id = id;
		this.order_num = order_num;
//		this.image = image;
		this.pro_name = pro_name;
		this.pro_content = pro_content;
		this.price = price;
		this.checkYN = checkYN;
		this.status = status;
		this.memo = memo;
		this.order_name = order_name;
		this.order_phone = order_phone;
		this.order_address = order_address;
		this.order_date = order_date;
		this.return_price = return_price;
	}

	public orderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}

//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_content() {
		return pro_content;
	}

	public void setPro_content(String pro_content) {
		this.pro_content = pro_content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCheckYN() {
		return checkYN;
	}

	public void setCheckYN(String checkYN) {
		this.checkYN = checkYN;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getOrder_phone() {
		return order_phone;
	}

	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getReturn_price() {
		return return_price;
	}

	public void setReturn_price(int return_price) {
		this.return_price = return_price;
	}

}
