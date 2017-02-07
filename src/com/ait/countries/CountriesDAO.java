package com.ait.countries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class CountriesDAO {

	    public List<Countries> findAll() {
	        List<Countries> list = new ArrayList<Countries>();
	        Connection c = null;
	    	String sql = "SELECT * FROM countries_data ORDER BY country";
	        try {
	            c = ConnectionHelper.getConnection();
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                list.add(processRow(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	    }
	    
	    
	    public Countries findById(int id) 
	    {
	    	String sql = "SELECT * FROM countries_data WHERE id = ?";
	        Countries countries = null;
	        Connection c = null;
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                countries = processRow(rs);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return countries;
	    }
	    
	    public Countries create(Countries countries) {
	        Connection c = null;
	        PreparedStatement ps = null;
	        try {
	            c = ConnectionHelper.getConnection();
	            ps = (PreparedStatement) c.prepareStatement("INSERT INTO countries_data (country, phone_prefix, flag, population, capital_city, geo_location, commentary) VALUES (?, ?, ?, ?, ?, ?, ?)",
	                new String[] { "ID" });
	            ps.setString(1, countries.getCountry());
	            ps.setString(2, countries.getPhone_prefix());
	            ps.setString(3, countries.getFlag());
	            ps.setString(4, countries.getPopulation());
	            ps.setString(5, countries.getCapital_city());
	            ps.setString(6, countries.getGeo_location());
	            ps.setString(7, countries.getCommentary());
	            ps.executeUpdate();
	            ResultSet rs = ps.getGeneratedKeys();
	            rs.next();
	            // Update the id in the returned object. This is important as this value must be returned to the client.
	            int id = rs.getInt(1);
	            countries.setId(id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return countries;
	    }
	    
	    public Countries update(Countries countries) {
	        Connection c = null;
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = (PreparedStatement) c.prepareStatement("UPDATE countries_data SET country=?, phone_prefix=?, flag=?, population=?, capital_city=?, geo_location=?, commentary=? WHERE id=?");
	            ps.setString(1, countries.getCountry());
	            ps.setString(2, countries.getPhone_prefix());
	            ps.setString(3, countries.getFlag());
	            ps.setString(4, countries.getPopulation());
	            ps.setString(5, countries.getCapital_city());
	            ps.setString(6, countries.getGeo_location());
	            ps.setString(7, countries.getCommentary());
	            ps.setInt(8, countries.getId());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return countries;
	    }
	    
	    public boolean remove(int id)
	    {
	        Connection c = null;
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = (PreparedStatement) c.prepareStatement("DELETE FROM countries_data WHERE id=?");
	            ps.setInt(1, id);
	            int count = ps.executeUpdate();
	            return count == 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	    }
	    
	    public List<Countries> findByCountry(String country) {
	        List<Countries> list = new ArrayList<Countries>();
	        Connection c = null;
	    	String sql = "SELECT * FROM countries_data as e " +
				"WHERE UPPER(country) LIKE ? " +	
				"ORDER BY country";
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	            ps.setString(1, "%" + country.toUpperCase() + "%");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(processRow(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	    }
	    
	    public List<Countries> findByPrefix(String phone_prefix) {
	        List<Countries> list = new ArrayList<Countries>();
	        Connection c = null;
	    	String sql = "SELECT * FROM countries_data as e " +
				"WHERE UPPER(phone_prefix) LIKE ? " +	
				"ORDER BY country";
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	            ps.setString(1, "%" + phone_prefix.toUpperCase() + "%");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(processRow(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	    }
	    
	    protected Countries processRow(ResultSet rs) throws SQLException {
	    	Countries countries = new Countries();
	        countries.setId(rs.getInt("id"));
	        countries.setCountry(rs.getString("country"));
	        countries.setPhone_prefix(rs.getString("phone_prefix"));
	        countries.setFlag(rs.getString("flag"));
	        countries.setPopulation(rs.getString("population"));
	        countries.setCapital_city(rs.getString("capital_city"));
	        countries.setGeo_location(rs.getString("geo_location"));
	        countries.setCommentary(rs.getString("commentary"));
	        return countries;
	    }
	    
	}
