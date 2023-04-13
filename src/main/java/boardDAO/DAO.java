package boardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import boardDTO.DTO;

public class DAO {
	private static DAO instance = null;
	
	public synchronized static DAO getInstance() {
		if(instance == null) {
			instance = new DAO();
		}
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context iCtx = new InitialContext();
		DataSource ds =  (DataSource) iCtx.lookup("java:/comp/env/jdbc/ora");
		return  ds.getConnection();
	}
	
	public int insert(DTO dto) throws Exception {
		String sql = "INSERT INTO board values(board_seq.nextval,?,?,?,DEFAULT,SYSDATE)";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContents());
			
			return pstat.executeUpdate();
		}
	}

	public List<DTO> boardView() throws Exception {
		String sql = "SELECT * FROM BOARD";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<DTO> list = new ArrayList<DTO>();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				int view_count = rs.getInt("view_count");
				Timestamp write_date = rs.getTimestamp("write_date");
				
				DTO dto = new DTO(seq, writer, title, contents, view_count, write_date);
				list.add(dto);
			}
			return list;
		}
	}

	public DTO titleView(int seq) throws Exception {
		String sql = "SELECT * FROM BOARD WHERE seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, seq);
			try(ResultSet rs = pstat.executeQuery();){
				rs.next();
				int id = rs.getInt("seq");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				Timestamp write_date = rs.getTimestamp("write_date");
				int view_count = rs.getInt("view_count");
				
				DTO dto = new DTO(0,writer,title,contents,view_count,write_date);
				return dto;
			}
		}
	}

	public int update(int seq, String title, String contents) throws Exception {
		String sql = "UPDATE BOARD SET title=?, CONTENTS = ? WHERE SEQ = ? ";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, title);
			pstat.setString(2, contents);
			pstat.setInt(3, seq);
			return pstat.executeUpdate();
		}
		
	}
	
}








