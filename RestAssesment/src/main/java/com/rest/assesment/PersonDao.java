package com.rest.assesment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.rest.assesment.Person;

public class PersonDao {	
	
	List<Person> persons;
	/*
	 * public PersonDao() { persons = new ArrayList(); Person p1 = new
	 * Person(101,"Abc",20); Person p2 = new Person(102,"Def",21); Person p3 = new
	 * Person(103,"Ghi",23); Person p4 = new Person(104,"Jkl",29);
	 * persons.addAll(Arrays.asList(p1,p2,p3,p4)); }
	 */
	
	public List<Person> getAllPerson(){
		
		List<Person> list = new ArrayList<Person>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from person";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public Person getPersonById(int id){
		Person p = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from person where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Person> addPerson(Person p) {
		List<Person> persons = new ArrayList<Person>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into person(id,name,age) values(?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getId());
			pst.setString(2, p.getName());
			pst.setInt(3, p.getAge());
			pst.executeUpdate();
			persons.add(p);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return persons;
	}
	
	public void deletePerson(int id){
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "delete from person where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updatePerson(Person p){
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update person set name=?,age=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setInt(2, p.getAge());
			pst.setInt(3, p.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}	
