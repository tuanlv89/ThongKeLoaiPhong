package model;

public class NhanVien extends ThanhVien{
	private String moTa;
	
	
	public NhanVien() {
		super();
	}


	public NhanVien(String moTa) {
		super();
		this.moTa = moTa;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}
