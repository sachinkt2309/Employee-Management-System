package Example.Controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import Example.Documents.Employee;
import Example.Services.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getEmployee")
	public String getEmployee() throws JsonProcessingException {
		List<Employee> employee=employeeService.getEmployes();
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper(module);
		final String xml1 = xmlMapper.writeValueAsString(employee);
		return xml1;

	}
	@PostMapping("/addEmployee")
	public Employee AddEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);	 
	}
	@DeleteMapping("/deleteEmp/{id}")
	public Optional<Employee> deleteEmployee(@PathVariable Integer id){
		return employeeService.deleteById(id);
	}
}
