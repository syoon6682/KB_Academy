package we.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import we.pet.exception.DuplicateIdException;
import we.pet.exception.RecordNotFoundException;
import we.pet.vo.Cart;
import we.pet.vo.Customer;
import we.pet.vo.Pet;
import we.pet.vo.PetFood;

public interface CustDAO {
	// JDBC Connect function
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException;
	
	
	// Customer CRUD function
	void addCustomer(Customer cust)throws SQLException,DuplicateIdException;
	Customer getCustomer(int id)throws SQLException,RecordNotFoundException;
	ArrayList<Customer> getAllCustomers() throws SQLException;
	void deleteCustomer(int id) throws SQLException,RecordNotFoundException;
	void updateCustomer(Customer cust) throws SQLException,RecordNotFoundException;
	
	// Pet CRUD function 
	void addPet(Pet pet)throws SQLException,DuplicateIdException;
	Pet getPet(int id) throws RecordNotFoundException, SQLException;
	ArrayList<Pet> getAllPets() throws SQLException;
	void deletePet(int id)throws SQLException,RecordNotFoundException;
	void updatePet(Pet pet)throws SQLException,RecordNotFoundException;
	
	// Pet Food CRUD function
	void addPetFood(PetFood petFood)throws SQLException,DuplicateIdException;
	PetFood getPetFood(int id) throws RecordNotFoundException,SQLException;
	ArrayList<PetFood> getAllPetFoods() throws SQLException;
	void deletePetFood(int id)throws SQLException,RecordNotFoundException;
	void updatePetFood(PetFood petfood)throws SQLException,RecordNotFoundException;
	
	// Order CRUD function
	void addCart(Cart cart)throws SQLException,DuplicateIdException;
	Cart getCart(int id) throws RecordNotFoundException, SQLException;
	ArrayList<Cart> getAllCarts() throws SQLException;
	void deleteCart(int id)throws SQLException,RecordNotFoundException;
	void updateCart(Cart cart)throws SQLException,RecordNotFoundException;
	
	
}