package we.pet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import we.pet.exception.DuplicateIdException;
import we.pet.exception.RecordNotFoundException;
import we.pet.vo.*;

public class CustDAOImpl implements CustDAO {
	public CustDAOImpl() {
	};

	public CustDAOImpl(String serverIp) throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("driver loading");
	}

	/////////// 공통으로 들어가는 로직 //////////////////
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("connected");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			ps.close();
		System.out.println("all closed");

	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);

	}

	// Buisness Logic

//customer

// Id 중복 확인
	private boolean isExist(int id, String table, Connection conn) throws SQLException {
		String query = "SELECT id FROM " + table + " WHERE id = ?";
		;
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		System.out.println(1);
		return rs.next();
	}

	// add
	@Override
	public void addCustomer(Customer cust) throws SQLException, DuplicateIdException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if (!isExist(cust.getId(), "customer", conn)) {
				String query = "INSERT INTO customer(id, name, ssn, address, phone, budget) VALUES(cust_seq.nextVal,?,?,?,?,?)";
				ps = conn.prepareStatement(query);

				ps.setString(1, cust.getName());
				ps.setString(2, cust.getSsn());
				ps.setString(3, cust.getAddress());
				ps.setString(4, cust.getPhone());
				ps.setDouble(5, cust.getBudget());
				System.out.println(ps.executeUpdate() + "님이 등록되었습니다.");

			} else {
				throw new DuplicateIdException();
			}
		} finally {
			closeAll(ps, conn);
		}

	}

	// getCustomer
	public Customer getCustomer(int id) throws RecordNotFoundException, SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cust = null;

		try {
			conn = getConnect();
			String query = "SELECT name, ssn, address, phone, budget FROM customer where id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			// 여기도 while 쓴 건 계속 rs 안나온다고 뜨는데 이거 쓰면 잡히긴 함 ㅠ
			while (rs.next()) {

				cust = new Customer(id, rs.getString("name"), rs.getString("ssn"), rs.getString("address"),
						rs.getString("phone"), rs.getDouble("budget"), getAllPet(id));

				// System.out.println(cust.toString());
			}

			if (cust == null) {
				throw new RecordNotFoundException();
			} else {
				System.out.println(cust.toString());
				return cust;
			}

		} finally {
			closeAll(rs, ps, conn);
		}
	}

	// getAllCustomer
	public ArrayList<Customer> getAllCustomers() throws SQLException {

		ArrayList<Customer> custlist = new ArrayList<Customer>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cust = null;// new Customer();

		try {
			conn = getConnect();
			String query = "SELECT * FROM customer";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

//	        		cust = new Customer(
//	        				rs.getInt("id"),
//	        				rs.getString("name"),
//	        				rs.getString("ssn"),
//	            			rs.getString("address"),
//	            			rs.getString("phone"),
//	            			rs.getDouble("budget"),
//	            			getAllPet(rs.getInt("id")));
//	        		
//	        		System.out.println(cust.toString());
//	        		
//	        		custlist.add(cust);

				custlist.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("ssn"),
						rs.getString("address"), rs.getString("phone"), rs.getDouble("budget"),
						getAllPet(rs.getInt("id")))

				);

			}

			System.out.println(custlist.toString());
			return custlist;

		} finally {
			closeAll(rs, ps, conn);
		}
	}

	// delete
	@Override
	public void deleteCustomer(int id) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub

	}

	// update
	public void updateCustomer(Customer cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "UPDATE customer SET name =? , address =?, phone=?, budget=? WHERE id=? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getPhone());
			ps.setDouble(4, cust.getBudget());
			ps.setInt(5, cust.getId());

			System.out.println(ps.executeUpdate() + "님이 업데이트 되었습니다.");

		} finally {
			closeAll(ps, conn);
		}

	}

//pet	

	// add
	@Override
	public void addPet(Pet pet) throws SQLException, DuplicateIdException {
		// TODO Auto-generated method stub

	}

	// getPet
	@Override
	public Pet getPet(int id) throws RecordNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pet pet = null;

		try {
			conn = getConnect();
			String query = "SELECT id, name, age, sex, walktime, kidney FROM pet WHERE id = ?";
			// String query = "SELECT name, ssn, address, phone, budget FROM customer where
			// id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("name"));
				pet = new Pet(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getBoolean("sex"),
						rs.getBoolean("walktime"), rs.getBoolean("kidney"));

				// System.out.println(pet.toString());
			}

			if (pet == null) {
				throw new RecordNotFoundException();
			} else {
				System.out.println(pet.toString());
				return pet;
			}

		} finally {
			closeAll(rs, ps, conn);
		}

	}

	// getAllPet(모든 펫의 전체정보)
	public ArrayList<Pet> getAllPets() throws SQLException {
		ArrayList<Pet> petList = new ArrayList<Pet>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnect();
			String query = "SELECT id, name, age, sex, walktime, kidney " + "FROM pet";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("id") + '\t' + rs.getString("name"));
				petList.add(new Pet(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getBoolean("sex"),
						rs.getBoolean("walktime"), rs.getBoolean("kidney")

				)

				);
			}

			return petList;

		} finally {
			closeAll(rs, ps, conn);
		}

	}

	// getAllPet(cid에 해당하는 pet의 전체정보)
	// getAllPortfolio 랑 같은 것 --> getAllCustomers에서 사용됨
	private ArrayList<Pet> getAllPet(int cid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Pet> list = new ArrayList<Pet>();
		try {
			conn = getConnect();
			String query = "SELECT id, name, age, sex, walktime, kidney FROM pet WHERE cid = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
			rs = ps.executeQuery();

			while (rs.next()) {
				// int id, String name, int age, boolean sex, boolean walktime, boolean kidney
				list.add(new Pet(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getBoolean("sex"),
						rs.getBoolean("walktime"), rs.getBoolean("kidney")));
			}

		} finally {
			closeAll(rs, ps, conn);
		}

		return list;
	}

	// delete
	@Override
	public void deletePet(int id) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub

	}

	// update
	@Override
	public void updatePet(Pet pet) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub

	}

//petfood	

	// add
	@Override
	public void addPetFood(PetFood petFood) throws SQLException, DuplicateIdException {
		// TODO Auto-generated method stub

	}

	// getPetFoods
	public PetFood getPetFood(int id) throws RecordNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PetFood pf = null;

		try {
			conn = getConnect();

			String query = "SELECT " + "name,price, stock, species, texture, satisfaction, protein, calories "
					+ "FROM pet_food " + "WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("name"));
				pf = new PetFood(id, rs.getString("name"), rs.getInt("price"), rs.getInt("stock"),
						rs.getBoolean("species"), rs.getInt("texture"), rs.getDouble("satisfaction"),
						rs.getBoolean("protein"), rs.getBoolean("calories"));

				// System.out.println(pf.toString());
			}

			if (pf == null) {
				throw new RecordNotFoundException();
			} else {
				System.out.println(pf);
				return pf;
			}

		} finally {
			closeAll(rs, ps, conn);
		}

	}

	// getAllPetFoods
	public ArrayList<PetFood> getAllPetFoods() throws SQLException {
		ArrayList<PetFood> PetFoodList = new ArrayList<PetFood>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnect();
			String query = "SELECT * FROM pet_food";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println();
				System.out.println(rs.getString("id") + '\t' + rs.getString("name"));

				PetFoodList.add(new PetFood(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
						rs.getInt("stock"), rs.getBoolean("species"), rs.getInt("texture"),
						rs.getDouble("satisfaction"), rs.getBoolean("protein"), rs.getBoolean("calories")));
			}

			return PetFoodList;

		} finally {
			closeAll(rs, ps, conn);
		}
	}

	// delete
	@Override
	public void deletePetFood(int id) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub

	}

	// update
	@Override
	public void updatePetFood(PetFood petfood) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub

	}

//cart	
	// add
	@Override
	public void addCart(Cart cart) throws SQLException, DuplicateIdException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			

			String query = "INSERT INTO cart(id, quantity, cartDate, cid, pfid) VALUES(cart_seq.nextVal,?,?,?,?)"
					+ "WHERE id=?";

			ps = conn.prepareStatement(query);
			System.out.println(1);
			ps.setInt(1, cart.getQuantity());
			ps.setDate(2, cart.getCartDate());
			ps.setDouble(3, cart.getCid());
			ps.setInt(4, cart.getPid());
			int result = ps.executeUpdate();
			System.out.println(result + " 개 상품 업데이트 성공!");
			
		} finally {
			closeAll(ps, conn);
		}

	}

	// getAllCart
	@Override
	public ArrayList<Cart> getAllCarts() throws SQLException {
		ArrayList<Cart> orderList = new ArrayList<Cart>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnect();
			String query = "SELECT * FROM cart";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("id") + '\t' + rs.getString("cid"));
				orderList.add(new Cart(rs.getInt("id"), rs.getInt("quantity"), rs.getDate("cart_date"),
						rs.getInt("cid"), rs.getInt("pfid")));

			}

			return orderList;

		} finally {
			closeAll(rs, ps, conn);
		}
	}

	// getCart
	public Cart getCart(int id) throws RecordNotFoundException, SQLException {
		// 무슨 id?
		// 왜 return 형이 pet?
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cart cart = null;

		try {
			conn = getConnect();

			String query = "SELECT cid, pfid, quantity, cart_date FROM cart where id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("name"));
				cart = new Cart(id, rs.getInt("quantity"), rs.getDate("cart_date"), rs.getInt("cid"),
						rs.getInt("pfid"));

				// System.out.println(cart.toString());
			}
			if (cart == null) {
				throw new RecordNotFoundException();
			} else {
				System.out.println(cart);
				return cart;
			}

			// return cart;

		} finally {
			closeAll(rs, ps, conn);
		}

	}

	// delete
	@Override
	public void deleteCart(int id) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub

	}

	// update

	public void updateCart(Cart cart) throws SQLException, RecordNotFoundException {
		// 무슨 id?
		// 왜 return 형이 pet?
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();

			String query = "UPDATE cart quantity = ? where id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cart.getId());
			ps.setInt(2, cart.getQuantity());

			if (cart == null) {
				throw new RecordNotFoundException();
			}

		} finally {
			closeAll(ps, conn);
		}
	}

}