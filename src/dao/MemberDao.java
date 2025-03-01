package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.JoinRequest;
import dto.Member;

public class MemberDao {
	DataSource dataSource;

	public MemberDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 
	 * @param id 중복확인에 사용할 Id값
	 * @return 일치하는 회원정보가 존재할 경우 member값 리턴, 아닐 경우 null 리턴
	 */
	public Member SelectId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ?";
		Member member = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setName(rs.getString("name"));
				member.setUseyn(rs.getInt("useyn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return member;
	}

	/**
	 * 신규회원 생성 시 사용
	 * 
	 * @param member 회원가입 시 입력한 회원 정보
	 */
	public void join(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member (id, password, email, phone, name) values (?, ?, ?, ?, ?)";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void modify(JoinRequest joinReq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set password=?, phone=?, email=? where id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, joinReq.getPassword());
			pstmt.setString(2, joinReq.getPhone());
			pstmt.setString(3, joinReq.getEmail());
			pstmt.setString(4, joinReq.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public String findId(String name, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from member where name=? and email=? and useyn = 2";
		String id = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return id;
	}

	public String findPassword(String name, String email, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select password from member where name = ? and email = ? and id=? and useyn =2";
		String password = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				password = rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return password;
	}

	public void deleteUser(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set useyn=1 where id = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void updateUser(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set useyn=2 where id = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
	
//	admin memberlist 출력
	public ArrayList<Member> adminMemberList() {
		ArrayList<Member> adminMemberList = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setUseyn(rs.getInt("useyn"));
				adminMemberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return adminMemberList;
	}
}
