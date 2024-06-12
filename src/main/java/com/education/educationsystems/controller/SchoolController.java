package com.education.educationsystems.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.education.educationsystems.entity.School;
import com.education.educationsystems.service.SchoolService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	public School createRecord(@RequestBody School school) {
		return schoolService.createRecord(school);
	}
	
	@GetMapping("/{id}")
	public List<Object> getStudentAndTeacherDetailsBySchoolName(@PathVariable Long id){
		return schoolService.getStudentAndTeacherDetailsBySchoolName(id);
	}
	
	@GetMapping("/course-count/{id}")
	public Map<String,Long> getSchoolsWithTotalCourseCounts(@PathVariable Long id){
		final Map<String,Long> totalCourseCountInSchool=new HashMap<>();
		totalCourseCountInSchool.put("Total Course Available In a School ",(schoolService.getSchoolsWithTotalCourseCounts(id)));
		return totalCourseCountInSchool;
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return schoolService.deleteByIdRecord(id);
	}
	@PutMapping("/update/{id}")
	public Map<String,Object> updateByRecord(@PathVariable Long id,@RequestBody School school){
		return schoolService.updateByRecord(id,school);
	}
	//api
	@GetMapping("/api/calling")
	public JsonNode apiCalling(){
	    String uri="https://reqres.in/api/users/2";
	    final RestTemplate rest=new RestTemplate();
	    final JsonNode response = rest.getForObject(uri, JsonNode.class);
//	    List<Object> result = new ArrayList<>();
//	    JsonNode i=response.get(0).getBody();
//	    ArrayNode arrayNode = (ArrayNode) response.getBody().get("data");
//	    
//        if (arrayNode != null) {
//            for (JsonNode node : arrayNode) {
//                result.add(node);
//            }
//        }
	    
        List<String> email=new LinkedList<>();
        response.findValuesAsText("email",email);
//        response.fi
	    return response;
	}
	
}
