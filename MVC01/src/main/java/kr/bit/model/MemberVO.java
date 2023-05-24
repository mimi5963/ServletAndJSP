package kr.bit.model;
//회원(Object) ->
public class MemberVO {
	private int num; 
	private String id;
	private String pass;
	private String name; 
	private int age;
	private String email;
	private String phone;
	//int num포함된건 db용 
	public MemberVO(int num, String id, String pass, String name, int age, String email, String phone) {
		super();
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	public MemberVO(){}
	//ㅇ거 ㅈ동생성이라 super있고, num은 우리가 입력하는거아닌데 입력할 수 있게 만들어둔거 추후를 위해 0524
	public MemberVO(String id, String pass, String name, int age, String email, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + ", email="
				+ email + ", phone=" + phone + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
