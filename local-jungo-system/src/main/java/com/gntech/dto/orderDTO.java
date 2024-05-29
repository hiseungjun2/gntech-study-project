package com.gntech.dto;

public class orderDTO {

	private int id; // 게시글 번호
	private String order_num; // 주문번호
//	private String image; // 이미지 파일 이름
	private String pro_name; // 상품명
	private String pro_content; // 상품내용
	private int price; // 상품 가격
	private String checkYN; // 검토여부
	private String status; // 진행상태
	private String memo; // 메모
	private String order_name; // 판매자이름
	private String order_phone; // 판매자 휴대폰
	private String order_address; // 판매자 주소
	private String order_date; // 작성일
	private int return_price; // 회사가 제안한 금액

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
