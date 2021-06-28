package com.nachiket.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Skills {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int skillId;
	private String skillName;
	private String skillLevel;
	private int exp_in_skill;
}
