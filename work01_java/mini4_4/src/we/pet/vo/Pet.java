package we.pet.vo;

public class Pet {

	private int id;
	private String name;
	private int age;
	private boolean sex;
	private boolean walktime;
	private boolean kidney;
	
	public Pet(int id, String name, int age, boolean sex, boolean walktime, boolean kidney) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.walktime = walktime;
		this.kidney = kidney;
	}
	
	public Pet() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public boolean isWalktime() {
		return walktime;
	}
	public void setWalktime(boolean walktime) {
		this.walktime = walktime;
	}
	public boolean isKidney() {
		return kidney;
	}
	public void setKidney(boolean kidney) {
		this.kidney = kidney;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", walktime=" + walktime
				+ ", kidney=" + kidney + "]";
	}
	
	
	
	
}
