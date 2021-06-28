package com.nachiket.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nachiket.model.Skills;
import com.nachiket.service.SkillsService;

import lombok.extern.java.Log;


@RestController
@RequestMapping("/skills")
@Log
public class SkillsController {


	@Autowired
	private SkillsService skillsService;
	
	@PostMapping("/addSkills")
	public ResponseEntity<String> registerSkills(@RequestBody Skills skills)
	{
		//log.info("SkillsController-->registerSkills");			
		skillsService.addSkill(skills);		
		//return new ResponseEntity(Skills, new HttpHeaders().set, HttpStatus.CREATED);
		
		return
				ResponseEntity.status(HttpStatus.CREATED).
			
				body("Skills is created with id:"+skills.getSkillId());
	}
	
	@PostMapping("/addSkillsList")
	public void addSkillsList(@RequestBody List<Skills> skillsList)
	{
		//log.info("SkillsController-->registerSkills");			
		skillsService.addSkillsList(skillsList);		
		//return new ResponseEntity(Skills, new HttpHeaders().set, HttpStatus.CREATED);
		
		
	}
	@GetMapping("/findSkillsByID/{SkillsID}")
	public ResponseEntity<Skills> findSkillsByID(@PathVariable int SkillsID)
	{
		log.info("SkillsController-->findSkillsByID");			
		Skills obj=skillsService.findskills(SkillsID);
		if(obj!=null)
		{
			log.info("found Skills with id "+SkillsID);			
		return new ResponseEntity( obj, new HttpHeaders(), HttpStatus.FOUND);
		}
		else
		{
			String msg="No Skills with given id found";
			log.info("Not found Skills with id "+SkillsID);	
			return new ResponseEntity(msg, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
			
	}
	@PutMapping("/updateSkills")
	public ResponseEntity updateSkills(@RequestBody Skills skills)
	{
		log.info("SkillsController-->updateSkills");			
		skillsService.updateskills(skills);
		//return new ResponseEntity(Skills, new HttpHeaders().set, HttpStatus.CREATED);
		
		return
				ResponseEntity.status(HttpStatus.OK).
			
				body("Skills is updated with id:"+skills.getSkillId());
	}
	
	@DeleteMapping("/deleteSkillsByID/{SkillsID}")
	public ResponseEntity deleteSkillsByID(@PathVariable int skillsID)
	{
			log.info("SkillsController-->deleteSkillsByID");			
			String msg=skillsService.deleteskills(skillsID);
		
		   	return new ResponseEntity(msg, new HttpHeaders(), HttpStatus.OK);
		
			
	}
	@GetMapping("/findAllSkills")
	public ResponseEntity<Skills> findAllSkills()
	{
		//log.info("SkillsController-->findAllSkills");		
		System.out.println("findall called");
		List<Skills> SkillsList=skillsService.findAllskills();
		if(SkillsList.size()==0)
		{
			
		return new ResponseEntity( "No Skills Added till now", new HttpHeaders(), HttpStatus.FOUND);
		}
		else
		{
		
		
			return new ResponseEntity(SkillsList, new HttpHeaders(), HttpStatus.OK);
		}
			
	}
	@GetMapping("/findAllSkillsByID")
	public List<Skills> findAllSkillsByID(@PathVariable List<Integer> skillID)
	{
		log.info("SkillsController-->findAllSkillsByID");		
		//System.out.println("findall called");
		List<Skills> SkillsList=skillsService.findAllskillsByList(skillID);
		return SkillsList;
			
	}
	
}
