package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.NhanVien;
import model.ThanhVien;

public class NhanVienDAO extends DAO{
	 public NhanVienDAO(){
	        super();
	    }
	    
	    public NhanVien getNhanVien(ThanhVien tv){
	        String sql = "select * from tblNhanVien where id = ?";
	        NhanVien nv = null;
	        try{
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, tv.getId());
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                nv = new NhanVien();
	                nv.setId(rs.getInt("id"));
	                nv.setViTri(rs.getString("viTri"));
	                nv.setMoTa(rs.getString("moTa"));
	                nv.setDiaChi(tv.getDiaChi());
	                nv.setEmail(tv.getEmail());
	                nv.setGioiTinh(tv.getGioiTinh());
	                nv.setMatKhau(tv.getMatKhau());
	                nv.setNgaySinh(tv.getNgaySinh());
	                nv.setSdt(tv.getSdt());
	                nv.setTen(tv.getTen());
	                nv.setCmt(tv.getCmt());
	                nv.setTenDangNhap(tv.getTenDangNhap());
	                nv.setVaiTro(tv.getVaiTro());
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        System.out.println("MMMMMMMMMMMMMMMMMMMMM"+nv);
	        return nv;
	    }
}
