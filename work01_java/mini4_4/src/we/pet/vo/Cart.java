package we.pet.vo;

import java.sql.Date;

public class Cart {

	private int id;
	private int quantity;
	private Date cartDate;
	private int cid;
	private int pfid;
	
	

	public Cart(int id, int quantity, Date cartDate, int cid, int pid) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.cartDate = cartDate;
		this.cid = cid;
		this.pfid = pid;
	}
	
	public Cart() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pfid;
	}

	public void setPid(int pid) {
		this.pfid = pid;
	}
	
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", cartDate=" + cartDate + ", cid=" + cid + ", pfid=" + pfid
				+ "]";
	}
	
	}
	
