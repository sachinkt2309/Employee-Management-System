package Example.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Example.Documents.Employee;
import Example.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee addEmployee(Employee employee) {	

		return employeeRepository.save(employee);
	}

	public List<Employee> getEmployes() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> deleteById(Integer id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		employeeRepository.deleteById(id);
		return employee;
	}
}
