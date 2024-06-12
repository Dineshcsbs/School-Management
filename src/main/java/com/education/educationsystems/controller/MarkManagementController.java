package com.education.educationsystems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.MarkManagement;
import com.education.educationsystems.service.MarkManagementService;

@RestController
@RequestMapping("/api/mark")
public class MarkManagementController {

	@Autowired
	private MarkManagementService markManagementService;
	
	@PutMapping("/")
	public Map<String,String> studentMarkUpdated(){
		 return markManagementService.studentMarkUpdated();
	}
	
	@GetMapping("/single-record")
	public MarkManagement retriveSingleRecord(@RequestParam Long studentId,@RequestParam Long courseId) {
		return markManagementService.retriveSingleRecord(studentId, courseId);
	}
	
//	@GetMapping("/mark-update")
//	public void studentMarkUpdated(Long studentId,Long courseId) {
//		markManagementService.studentMarkUpdated(studentId,courseId);
//	}
	
//	@GetMapping("/all-record-update")
//	public void updateAllRecord() {
//		markManagementService.updateAllRecord();
//	}
}
