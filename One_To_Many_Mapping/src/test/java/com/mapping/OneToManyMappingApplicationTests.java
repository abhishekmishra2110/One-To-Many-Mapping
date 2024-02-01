package com.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mapping.entity.Address;
import com.mapping.entity.Student;
import com.mapping.repository.StudentRepository;

@SpringBootTest
class OneToManyMappingApplicationTests {
	@Autowired
	private StudentRepository studentRepository;
	

	@Test
	public void saveStudent() {
		Student student=new Student();
		student.setStudentId(1);
		student.setSudentName("Abhishek Mishra");
		student.setAbout("working as engineer");
		 
		Address address1=new Address();
		address1.setAddressId(1);
		address1.setCity("Banglore");
		address1.setStreet("1/1");
		address1.setCountry("India");
		address1.setStudent(student);
		
		Address address2=new Address();
		address2.setAddressId(2);
		address2.setCity("Delhi");
		address2.setStreet("2/2");
		address2.setCountry("India");
		address2.setStudent(student);
		
		Address address3=new Address();
		address3.setAddressId(3);
		address3.setCity("Uttrakhand");
		address3.setStreet("3/3");
		address3.setCountry("India");
		address3.setStudent(student);
		
		List<Address> addressList = new ArrayList<>();
		addressList.add(address3);
		addressList.add(address2);
		addressList.add(address1);
		
		student.setAddressList(addressList);
		
		
		studentRepository.save(student);
		
	}
	
	@Test
	public void readByStudentId(){
		
		Optional<Student> findById = studentRepository.findById(1);
		
		if(findById.isPresent()){
			Student student = findById.get();
			System.out.println(student.getStudentId());
			System.out.println(student.getSudentName());
			System.out.println(student.getAbout()); 
			List<Address> addressList = student.getAddressList();
			
			for (Address address : addressList) {
				System.out.println(address.getAddressId());
				System.out.println(address.getCity());
				System.out.println(address.getStreet());
				System.out.println(address.getCountry());
				
			}
			
		}
		else{
			System.out.println("Id Does not exist");
		}
		
		
	}
	
	

}
