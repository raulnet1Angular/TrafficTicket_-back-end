package com.trafficticket.springapp.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.trafficticket.springapp.entity.Student;
import com.trafficticket.springapp.service.StudentDAO;

@RestController
@RequestMapping("/")
public class StudentEnrollmentController {
	//private static final Logger logger = LoggerFactory.getLogger(StudentEnrollmentController.class);

	 @Autowired
	private StudentDAO studentDao;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/viewstudents")
	public List<Student> viewstudents() {
		try {
		//	String email = SecTools.getUser();
		//	logger.debug(email + " GET /materialModule/productTypeList");

			return studentDao.getAllStudents();
		} catch (Exception e) {
		//	ExceptionUtil.processException(SecTools.getUser(), e, null, null);
			return null;
		}
	}
		/**
		 * Create a Product Type
		 * 
		 * @param productType
		 *            information product type
		 * @author raul.oropeza
		 */
		@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
		public void addProductType(@RequestBody Student student) 
		{
		//	logger.debug("In: productType: " + productType.toString());
			
	//		String email = SecTools.getUser();
			//logger.debug(email + " POST /productModule/productType");
			
			Map<String, String> paramsIn = new HashMap<String, String>();
			paramsIn.put("student", student.toString());
			
			try {
			//	Transaction transaction = transactionService
		///				.beginTransaction(TransactionType.CREATE_PRODUCT_TYPE, paramsIn);
				studentDao.save(student);	
			//	studentDao.insertNewProductType(student,transaction.getTransactionalColumns());
				
			//	transactionService.endTransaction(transaction, null);
				
			} catch (Exception e) {
	//			ExceptionUtil.processException(email, e, null, productType);
			}
		//	logger.debug("Out: ");
			//return id;
		}
	
		
			

}
