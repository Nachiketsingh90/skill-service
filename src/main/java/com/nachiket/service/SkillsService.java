package com.nachiket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nachiket.dto.SkillsDTO;
import com.nachiket.model.Skills;

import lombok.extern.java.Log;

@Log
@Service
public class SkillsService {

	@Autowired
	private SkillsDTO skillsDTO;
	
	public Skills addSkill(Skills skills)
	{
		log.info("Ging to register skills in skillsService->>addSkill");
		if (skills!=null)
		{
			skillsDTO.save(skills);
		}
		
		log.info("skills is registered now");
		return skills;
	}
	public void addSkillsList(List<Skills> skillsList)
	{
		log.info("Ging to register skills in skillsService->>addSkillsList");
		if (skillsList!=null)
		{
			skillsDTO.saveAll(skillsList);
		}
		
		log.info("skills is registered now");
	//	return skills;
	}
	
	public Skills updateskills(Skills skills)
	{
		log.info("Ging to update skills in skillsService->>updateskills");
		skillsDTO.save(skills);
		log.info("skills is updated now");
		return skills;
	}
	public String  deleteskills(int id)
	{
		log.info("Ging to delete skills in skillsService->>deleteskills");
		String msg;
		if(skillsDTO.findById(id).isPresent())
		{
			skillsDTO.deleteById(id);
			msg="skills deleted with ID: "+id;
			log.info("skills is deleted now");
		}
		else
			msg="skills not found with ID: "+id;
		
		return msg;
		
	}
	public Skills findskills(int id)
	{
		log.info("Ging to find skills in skillsService->>findskills");
		Optional<Skills> skillsOp=skillsDTO.findById(id);
		if(skillsOp.isPresent())
			return skillsOp.get();
		else
			
		return null;
		
	}

	public List<Skills> findAllskills() {
		// TODO Auto-generated method stub
		return skillsDTO.findAll();
	}
	public List<Skills> findAllskillsByList(List<Integer> intList) {
		// TODO Auto-generated method stub
		return skillsDTO.findAllById(intList);
	}
}
