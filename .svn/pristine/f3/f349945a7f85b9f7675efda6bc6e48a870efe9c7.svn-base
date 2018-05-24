package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCTemplate {

	public List query(String sql,RowMapper rm,Object... params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setObject(i+1, params[i]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = rm.maprow(rs);
				list.add(obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void saveOrUpdate(String sql, Object... params){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setObject(i+1, params[i]);
			}
			ps.executeUpdate();
			System.out.println("保存成功,sql:"+sql);
			System.out.println("带参数后的sql:"+ps);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			JDBCUtil.closeAll(conn, ps, null);
		}
				
		
		
	}
	
}
