package com.pratice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratice.entity.Student;
import java.util.Date;


public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	
	
	
	public List<Student> findByAdmissionDate(Date admissionDate);
	
	
//	Basic / Equality
//	1. Find a student by their name.
	public List<Student> findByName(String name);
	
	
//	2. Find a student by their email.
	public Student findByEmail(String email);
	
	
//	3. Find all students from the Computer department.
	public List<Student> findByDept(String dept) ;
	
	
//	4. Find students who have a course fee of ₹50,000.
	public List<Student> findByCourseFeeEquals(Double fee);
	
	
//	5. Find students whose name equals "Rahul".
	
	public List<Student> findByNameEquals(String name);
	
	
//	6. Find students whose department is not "Computer".
	public List<Student> findByDeptNotEquals(String dept);
	
	
//	And / Or
//	7. Find students from the Computer department and whose fee is ₹50,000.
	 public List<Student> findByDeptEqualsAndCourseFeeEquals(String dept ,Double fee) ;
	
	
//	8. Find students whose name is "Rahul" and department is "Computer".
	
	public List<Student> findByNameEqualsAndDeptEquals(String name ,String dept);

	//	9. Find students whose name is "Rahul" or email is "rahul@gmail.com".
	
	public List<Student> findByNameEqualsOrEmailEquals(String name , String email) ;
	
	
//	10. Find students from the Computer department or IT department.
	public List<Student> findByDeptOrDept(String dept , String dept1);
		
	
//	11. Find students whose name is "Rahul" and email is "rahul@gmail.com" and department is "Computer"
   public List<Student> findByNameAndEmailAndDeptEquals(String name , String email,String dept);
	
//	Comparison
//	12. Find students whose course fee is less than ₹50,000.
     public List<Student> findByCourseFeeLessThan(Double fee);
//	13. Find students whose course fee is less than or equal to ₹50,000.
     public List<Student> findByCourseFeeLessThanEqual(Double fee);
     
//	14. Find students whose course fee is greater than ₹50,000.
     public List<Student> findByCourseFeeGreaterThan(Double fee);
//	15. Find students whose course fee is greater than or equal to ₹50,000.
     public List<Student> findByCourseFeeGreaterThanEqual(Double fee);
       
//	16. Find students whose course fee is between ₹40,000 and ₹80,000.
     public List<Student> findByCourseFeeBetween(Double minFee,Double maxFee);
     
     
//	Date
//	17. Find students admitted before 1 January 2026.
     public List<Student>  findByAdmissionDateLessThan(Date date);
     public List<Student> findByAdmissionDateBefore();
//	18. Find students admitted after 1 January 2026.
     public List<Student> findByAdmissionDateGreaterThan(Date date);
     public List<Student> findByAdmissionDateAfter(Date date);
//	19. Find students admitted between 1 January 2026 and 30 June 2026.
     public  List<Student> findByAdmissionDateBetween(Date minDate, Date maxDate);
//	20. Find Computer students admitted after 1 January 2026.
     public  List<Student> findByDeptAndAdmissionDateGreaterThan(String dept, Date date);
//	21. Find students from the Computer department who were admitted before 1 January 2026.
     public  List<Student> findByDeptAndAdmissionDateLessThan(String dept, Date date);
     
     
     
//	Null
//	22. Find students whose email is NULL.
    public List<Student> findByEmailIsNull() ;
		
//	23. Find students whose email is NOT NULL.
    public List<Student> findByEmailNotNull();
//	24. Find students whose department is NULL.
    public List<Student> findByDeptIsNull();
     
//	25. Find students whose department is NOT NULL.
    public List<Student> findByDeptNotNull();     
     
//	String Searching
//	26. Find students whose name starts with "Rah".-->"Rah%"
    public List<Student> findByNameLike(String name);
    public List<Student> findByNameStartingWith(String name);
    
    
//	27. Find students whose name ends with "ul".--->"ul%"
//    public List<Student> findByNameLike(String name);
    public List<Student> findByNameEndingWith(String name);
    
//	28. Find students whose name contains "ahu".===>"%ahu%"
//    public List<Student> findByNameLike(String name);
    public List<Student>findByNameContaining(String name);
//	29. Find students whose name matches a given LIKE pattern.
//    public List<Student> findByNameLike(String name);
    
//	30. Find students whose name does not match a given LIKE pattern.
    public List<Student> findByNameNotLike(String name);
//	31. Find students whose name contains "rahul" without considering uppercase/lowercase.
     
     List< Student> findByNameConatainingIgnoreCase(String name);
     
//	Collection
//	32. Find students whose department is one of: Computer, IT, Mechanical.
     public List<Student> findByDeptIn(List<String> names);
//	33. Find students whose department is NOT Computer, IT, or Mechanical.
     public List<Student> findByDeptNotIn(List<String> names);
     
     
//	Sorting
//	34. Find all students and sort them by name in ascending order.
//	35. Find all students and sort them by name in descending order.
//	36. Find all students and sort them by course fee in ascending order.
//	37. Find all students and sort them by course fee in descending order.
//	38. Find Computer students and sort them by course fee in descending order.
//	39. Find students with fee greater than ₹50,000 and sort them by name.
//	40. Find students and sort them first by department ascending and then by course fee descending.
     
     
//	First / Top
//	41. Find the student with the lowest course fee.
//	42. Find the student with the highest course fee.
//	43. Find the first student admitted.
//	44. Find the most recently admitted student.
//	45. Find the top 3 students with the highest course fees.
//	46. Find the top 5 students from the Computer department based on course fee.
     
     
//	Distinct
//	47. Find all unique departments.
//	48. Find all unique student names.
     
     
//	Count
//	49. Count all students from the Computer department.
//	50. Count students whose course fee is greater than ₹50,000.
//	51. Count students admitted after 1 January 2026.
//	52. Count students whose email is not NULL.
     
     
//	Exists
//	53. Check whether a student exists with a given email.
//	54. Check whether any student exists in the Computer department.
//	55. Check whether any student has a course fee greater than ₹1,00,000.
     
     
//	Mixed / Interview-Level Requirements
//	56. Find Computer students whose fee is between ₹40,000–₹80,000 and sort by name.
//	57. Find Computer students whose name starts with "A" and fee is greater than ₹50,000.
//	58. Find students whose name contains "Rah" and who were admitted after 1 January 2026.
//	59. Find students from Computer or IT whose fee is less than ₹60,000.
//	60. Find students from Computer whose fee is between ₹40,000–₹80,000 and sort by admission date descending.
//	61. Find the top 5 Computer students with the highest course fee.
//	62. Find students whose email is not NULL and sort them by name ascending.
//	63. Find students whose name contains "Rah", fee is greater than ₹40,000, and sort by fee descending.
//	64. Find the top 3 students admitted most recently.
//	65. Find students from Computer whose fee is greater than ₹50,000 and who were admitted after 1 January 2026.
//	66. Find the top 5 students from Computer or IT with the highest course fee.
//	67. Find students whose fee is between ₹40,000–₹80,000, email is not NULL, and sort by admission date descending.
//	68. Find students whose name starts with "A" or "R" and sort them by name ascending.
//	69. Find students from Computer whose name contains "Rah", fee is between ₹40,000–₹80,000, and sort by name.
//	70. Find the top 5 students from Computer whose fee is greater than ₹50,000 and who were admitted after 1 January 2026.
	
}
