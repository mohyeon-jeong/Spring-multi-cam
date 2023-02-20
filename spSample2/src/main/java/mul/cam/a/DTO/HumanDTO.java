package mul.cam.a.DTO;

import java.io.Serializable;

public class HumanDTO implements Serializable {

	private String name;
	private int age;
	
	public HumanDTO() {
	}

	public HumanDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "HumanDTO [name=" + name + ", age=" + age + "]";
	}

}
