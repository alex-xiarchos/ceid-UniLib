public class university_department{
	private String university_name;
	private String address;
	private String telephone_number;

	public String get_university_name(){
		return university_name;
	}
	public String get_address(){
		return address;
	}
	public void set_address(String address){
		this.address = address;
	}
	public String get_telephone_number(){
		return telephone_number;
	}
	public void set_telephone_number(String telephone_number){
		this.telephone_number= telephone_number;
	}
	public String toString() {
		return "university_department [university_name=" + university_name + ", address=" + address + ", telephone_number="
				+ telepone_number "]";
	}

}