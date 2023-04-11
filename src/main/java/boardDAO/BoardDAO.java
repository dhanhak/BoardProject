package boardDAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import boardDTO.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance = null;

	public synchronized static BoardDAO getInstance() {		//synchronized 쓰레드로부터 안전하다.
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	private Connection getConntection() throws Exception {
		Context iCtx = new InitialContext();	
		DataSource ds = (DataSource)iCtx.lookup("java:/comp/env/jdbc/ora");

		return ds.getConnection();
	}

	public int insert(BoardDTO dto) throws Exception {
		String sql = "INSERT INTO MEMBERS VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getEmail());
			pstat.setString(6, dto.getZipcode());
			pstat.setString(7, dto.getAddress1());
			pstat.setString(8, dto.getAddress2());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public int delete(String id) throws Exception {
		String sql = "DELETE FROM MEMBERS WHERE ID = ?";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			con.commit();
			return pstat.executeUpdate();
		}
	}

	public int Update(String pw, String name, String phone) throws Exception {
		String sql = "UPDATE MEMBERS SET PW = ?, NAME = ?, PHONE = ?";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, pw);
			pstat.setString(2, name);
			pstat.setString(3, phone);
			con.commit();
			return pstat.executeUpdate();
		}
	}

	public boolean isIdExist(String id) throws Exception {
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, id);
			try(ResultSet rs = pstat.executeQuery()){
				return rs.next();
			}
		}
	}

	public boolean isMember(String id, String pw) throws Exception {
		String sql = "SELECT * FROM MEMBERS WHERE ID = ? and PW = ?";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try(ResultSet rs = pstat.executeQuery()){
				return rs.next();
			}
		}
	}
	
	public BoardDTO selectId(String id) throws Exception{
		String sql = "SELECT * FROM MEMBERS WHERE id =?";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			try(ResultSet rs = pstat.executeQuery()){
				if (rs.next()) {
					String userid = rs.getString("id");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String zipcode = rs.getString("zipcode");
					String address1 = rs.getString("address1");
					String address2 = rs.getString("address2");
					Timestamp birthday = rs.getTimestamp("join_date");
					
					return new BoardDTO(userid, pw, name, phone, email, zipcode, address1, address2, birthday);
					
				}
				return null;
			}
		}
	}
	
	public static String getSHA512(String input){

		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update(input.getBytes("utf8"));
		    toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	    }


}
