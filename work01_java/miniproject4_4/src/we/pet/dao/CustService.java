package we.pet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import we.pet.vo.Cart;
import we.pet.vo.Customer;
import we.pet.vo.Pet;
import we.pet.vo.PetFood;

public interface CustService {
///// advanced service ////
	// recommend 
	PetFood recommPetFoodByBudget(Pet pet, int budget) throws SQLException;
	PetFood recommPetFoodByTexture(Pet pet, int texture) throws SQLException;
	PetFood recommPetFood(Pet pet, int budget, int texture) throws SQLException; 
	
	// buy food
	void buyPetFood(int budget, PetFood petfood, int quantity) throws SQLException;

	// Ranking
	ArrayList<PetFood> getRanking(int texture) throws SQLException;
	
  // log
	Cart getRecentCart(Customer cust) throws SQLException;
	ArrayList<Cart> getBestPetFoodMonth() throws SQLException;
}
