package we.pet.test;


import we.pet.dao.CustDAO;
import we.pet.dao.CustDAOImpl;

public class Test {

	public static void main(String[] args) throws Exception {
		//CustDAO dao = new CustDAO("127.0.0.1");
		CustDAOImpl dao = new CustDAOImpl("127.0.0.1");
		//dao.getAllCustomers();
		//dao.getAllPets();
		//dao.getAllPetFoods();
		//dao.getAllOrders();
		
	
		dao.getCustomer(1);
		//dao.getOrder(1);
		//dao.getPet(2341);
		//dao.getPetFood(1234);
		
		

	}

}
