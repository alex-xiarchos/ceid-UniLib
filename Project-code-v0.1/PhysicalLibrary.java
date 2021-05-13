public class PhysicalLibrary {
	private String libraryName;
  private String email;
	private String address;
	private String telephone;

	public String getAddress(){
		return address;
	}
  
  public PhysicalLibrary (String parAddress, String parEmail, String parTel) {
    address = parAddress;
    email = parEmail;
    telephone = parTel;
  }
                     
	public String getTelephone(){
		return telephone;
	}

}
