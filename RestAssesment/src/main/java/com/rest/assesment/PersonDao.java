package com.rest.assesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.rest.assesment.Person;

public class PersonDao {	
	
	List<Person> persons;
	
	public PersonDao() {
		persons = new ArrayList();
		Person p1 = new Person(101,"Abc",20);
		Person p2 = new Person(102,"Def",21);
		Person p3 = new Person(103,"Ghi",23);
		Person p4 = new Person(104,"Jkl",29);
		persons.addAll(Arrays.asList(p1,p2,p3,p4));
	}
	
	public List<Person> getAllPerson(){
		return persons;
	}
	
	public Person getPersonById(int id){
		return persons.stream().filter(x->x.getId()==id).collect(Collectors.toList()).get(0);
	}
	
	public List<Person> addPerson(Person p) {
		persons.add(p);
		return persons;
	}
	
	public List<Person> deletePerson(int id){
		persons.removeIf(x-> x.getId() == id);	
		return persons;
	}
	
	public List<Person> updatePerson(int id, String name){
		persons.stream().filter(x->x.getId()==id).collect(Collectors.toList()).get(0).setName(name);
		return persons;
	}
}	
