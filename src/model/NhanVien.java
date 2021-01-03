package model;

public class NhanVien extends ThanhVien{
	private String viTri;
	private String moTa;
	
	
	public NhanVien() {
		super();
	}


	public NhanVien(String viTri, String moTa) {
		super();
		this.viTri = viTri;
		this.moTa = moTa;
	}


	public String getViTri() {
		return viTri;
	}


	public void setViTri(String viTri) {
		this.viTri = viTri;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}
