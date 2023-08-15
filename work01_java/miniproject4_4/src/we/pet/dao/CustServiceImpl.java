package we.pet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import we.pet.exception.DuplicateIdException;
import we.pet.exception.InvalidTransactionException;
import we.pet.exception.RecordNotFoundException;
import we.pet.vo.Cart;
import we.pet.vo.Customer;
import we.pet.vo.*;

import we.pet.vo.PetFood;

public class CustServiceImpl implements CustService{
	
	CustDAOImpl dao = new CustDAOImpl();
	
	@Override
    public PetFood recommPetFoodByBudget(Pet pet, int budget) throws SQLException {  //다시 짜야함: 신장병 있는 고양이는 단백질 낮게
        PetFood pf = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=  null;
       
        
        try {
            conn = dao.getConnect();
            
            String query ="";
            
            if(pet.getSpecies() == 0) { // 고양이
                if (pet.isKidney()) {// 신장병 있음
                    query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(protein, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE protein = 0 AND " // 단백질 X
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }else {
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(protein, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE protein = 1 AND " // 단백질 X
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }
            } else {// 강아지
                if (pet.isWalktime()) {// 많이 걸음
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(walktime, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE walktime = 1 AND " // 단백질 X
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                    
                }else { // 많이 안 걸음
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(walktime, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE walktime = 0 AND " // 단백질 X
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }
            }
            
           
            ps = conn.prepareStatement(query);
            ps.setInt(1, budget);
            rs = ps.executeQuery();
            /* int id, String name, int price, int stock, boolean species, 
             * int texture, double satisfaction, boolean protein, boolean calories
             */
            rs.next();
            pf = new PetFood(
                    
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("price"),
                    rs.getInt("stock"),
                    rs.getBoolean("species"),
                    rs.getInt("texture"),
                    rs.getDouble("satisfaction"),
                    rs.getBoolean("protein"),
                    rs.getBoolean("calories")
                    );
            
            
            return pf;  
            
        } finally {
            dao.closeAll(rs, ps, conn);
        } 
    }

	@Override
	public PetFood recommPetFoodByTexture(Pet pet, int texture) throws SQLException {
		PetFood pf = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=  null;
       
        
        try {
            conn = dao.getConnect();
            
            String query ="";
            
            if(pet.getSpecies() == 0) { // 고양이
                if (pet.isKidney()) {// 신장병 있음
                    query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(protein, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE protein = 0 AND " // 단백질 X
                            + "texture = ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }else {
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(protein, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE protein = 1 AND " // 단백질 X
                            + "texture = ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }
            } else {// 강아지
                if (pet.isWalktime()) {// 많이 걸음
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(walktime, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE walktime = 1 AND " // 단백질 X
                            + "texture = ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                    
                }else { // 많이 안 걸음
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(walktime, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE walktime = 0 AND " // 단백질 X
                            + "texture = ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }
            }
            
           
            ps = conn.prepareStatement(query);
            ps.setInt(1, texture);
            rs = ps.executeQuery();
            /* int id, String name, int price, int stock, boolean species, 
             * int texture, double satisfaction, boolean protein, boolean calories
             */
            rs.next();
            pf = new PetFood(
                    
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("price"),
                    rs.getInt("stock"),
                    rs.getBoolean("species"),
                    rs.getInt("texture"),
                    rs.getDouble("satisfaction"),
                    rs.getBoolean("protein"),
                    rs.getBoolean("calories")
                    );
            
            
            return pf;  
            
        } finally {
            dao.closeAll(rs, ps, conn);
        } 
	}

	@Override
	public PetFood recommPetFood(Pet pet, int budget, int texture) throws SQLException {
		PetFood pf = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=  null;
       
        
        try {
            conn = dao.getConnect();
            
            String query ="";
            
            if(pet.getSpecies() == 0) { // 고양이
                if (pet.isKidney()) {// 신장병 있음
                    query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(protein, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE protein = 0 AND " // 단백질 X
                            + "texture = ? AND"
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }else {
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(protein, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE protein = 1 AND " // 단백질 X
                            + "texture = ? AND "
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }
            } else {// 강아지
                if (pet.isWalktime()) {// 많이 걸음
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(walktime, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE walktime = 1 AND " // 단백질 X
                            + "texture = ? AND "
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                    
                }else { // 많이 안 걸음
                	query = "SELECT id, name, species, price, stock, texture, satisfaction, calories, "
                            + "DECODE(walktime, '1', '고단백', '0', '저단백') protein"
                    		+ "FROM ( "
                            + "SELECT * "
                            + "FROM pet_food "
                            + "WHERE walktime = 0 AND " // 단백질 X
                            + "texture = ? AND "
                            + "price < ? "
                            + "ORDER BY satisfaction) "
                            + "WHERE ROWNUM = 1";
                }
            }
            
           
            ps = conn.prepareStatement(query);
            ps.setInt(1, texture);
            ps.setInt(2, budget);
            rs = ps.executeQuery();
            /* int id, String name, int price, int stock, boolean species, 
             * int texture, double satisfaction, boolean protein, boolean calories
             */
            rs.next();
            pf = new PetFood(
                    
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("price"),
                    rs.getInt("stock"),
                    rs.getBoolean("species"),
                    rs.getInt("texture"),
                    rs.getDouble("satisfaction"),
                    rs.getBoolean("protein"),
                    rs.getBoolean("calories")
                    );
            
            
            return pf;  
            
        } finally {
            dao.closeAll(rs, ps, conn);
        } 
	}

	@Override
	public void buyPetFood(int budget, PetFood petfood, int quantity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public void buyPetFood(Customer cust, PetFood petfood, int quantity) throws SQLException, InvalidTransactionException, RecordNotFoundException, DuplicateIdException, ParseException {
		double cbudget = cust.getBudget();
		int cost = petfood.getPrice() * quantity;
		
		if (cbudget > cost) {
			throw new InvalidTransactionException();
		}
	
		cust.setBudget(cust.getBudget() - cbudget);
		petfood.setStock(petfood.getStock() - quantity);
		
		Cart cart = new Cart(quantity, Date.valueOf("2023-08-06"), cust.getId(), petfood.getId());
		
		dao.addCart(cart);
		dao.updateCustomer(cust);
		dao.updatePetFood(petfood);
	}

	
	public PetFood getBestRanking(int texture) throws SQLException {
		PetFood pf = null;
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=  null;
		String query = "select texture, max(satisfaction) best from pet_food group by texture order by texture";
		
		try {
        	conn = dao.getConnect();
        	ps = conn.prepareStatement(query);
        	
        	rs = ps.executeQuery();
        	while(rs.next()) {
        		
        		if (rs.getInt("texture") == texture) {
        			double best = rs.getDouble("best");
        			conn = dao.getConnect();
        			query = "SELECT * FROM pet_food WHERE texture = ? AND satisfaction = ?";                	ps = conn.prepareStatement(query);
                	
                	rs = ps.executeQuery();
        			
        			
		        	pf = new PetFood(
            				rs.getInt("id"),
                			rs.getString("name"),
                			rs.getInt("price"),
                			rs.getInt("stock"),
                			rs.getBoolean("species"),
                			rs.getInt("texture"),s
                			rs.getDouble("satisfaction"),
                			rs.getBoolean("protein"),
                			rs.getBoolean("calories"));
		        	
		        	return pf;
        		}
        		
        		
        	}
        	
        	
		}finally {
			dao.closeAll(rs, ps, conn);
		}
		
		
		return pf;
	}

	@Override
	public Cart getRecentCart(Customer cust) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Cart> getBestPetFoodMonth() throws SQLException {
		ArrayList<Cart> cartlist = new ArrayList<Cart>();
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=  null;
        
		try {
			conn = dao.getConnect();
			String query   = ""; // 작성해야함
        	ps = conn.prepareStatement(query);
        	rs = ps.executeQuery();
        	
        	while(rs.next()) { // Result 값이 없다 이렇게 나와서 while 적어 줌
        		// 에러명: ResultSet.next가 호출되지 않았음
        		cartlist.add(new Cart(
            			
            			rs.getInt("id"),
            			rs.getInt("quantity"),
            			rs.getDate("cart_date;"),
            			
            			rs.getInt("cid"),
            			rs.getInt("pfid")
            			));
        	}
        	
			return cartlist;
			
		}finally {
			dao.closeAll(rs, ps, conn);
		}
		
		
	}


	

}
