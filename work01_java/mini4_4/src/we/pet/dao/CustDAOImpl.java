package we.pet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import we.pet.exception.RecordNotFoundException;
import we.pet.vo.*;

public class CustDAOImpl implements CustDAO {
	public CustDAOImpl() {
	};

	public CustDAOImpl(String serverIp) throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("driver loading");
	}

	// 공통로직
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

	// ssn 여부 확인
	private boolean isExist(int id, String table, Connection conn) throws SQLException {
        String query = "SELECT id FROM " + table + " WHERE id = ?";;
        PreparedStatement ps = conn.prepareStatement(query);
//        ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        System.out.println(1);
        return rs.next();
    }

	// getAll ~~
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

//        		cust = new Customer(
//        				rs.getInt("id"),
//        				rs.getString("name"),
//        				rs.getString("ssn"),
//            			rs.getString("address"),
//            			rs.getString("phone"),
//            			rs.getDouble("budget"),
//            			getAllPet(rs.getInt("id")));
//        		
//        		System.out.println(cust.toString());
//        		
//        		custlist.add(cust);

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

	public ArrayList<Cart> getAllOrders() throws SQLException {
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

	// getAllPortfolio 랑 같은 것 --> getAllCustomers에서 사용됨
	// cid에 해당하는 pet의 정보를 가져온다
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

	// get~

	public Customer getCustomer(int id) throws RecordNotFoundException, SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cust = null;

		try {
			conn = getConnect();
			if (isExist(id, "customer", conn)) {
				String query = "SELECT name, ssn, address, phone, budget FROM customer where id = ?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
			} else {
				throw new RecordNotFoundException();
			}
			cust = new Customer(id, rs.getString("name"), rs.getString("ssn"), rs.getString("address"),
					rs.getString("phone"), rs.getDouble("budget"), getAllPet(id));
			
			return cust;


		} finally {
			closeAll(rs, ps, conn);
		}
	}

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

	public Cart getOrder(int id) throws RecordNotFoundException, SQLException {
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

	public void updateOrder(Cart order) {
		// 무슨 id?
		// 왜 return 형이 pet?
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cart cart = null;

		try {
			conn = getConnect();

			String query = "UPDATE cart quantity = ? where id = ?";
			cart = getOrder(id);
			ps.setInt(1, quantity);
			ps.setInt(2, id);
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, quantity);
			rs = ps.executeUpdate();
			
			if (cart == null) {
				throw new RecordNotFoundException();
			} 

		} finally {
			closeAll(rs, ps, conn);
		}
	}

	
	public void updateCustomer(Customer cust) throws SQLException, RecordNotFoundException{
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
			
		}finally {
			closeAll(ps, conn);
		}
		
		
		
	}
}
