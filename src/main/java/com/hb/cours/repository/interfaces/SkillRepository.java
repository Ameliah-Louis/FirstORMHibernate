package com.hb.cours.repository.interfaces;

import com.hb.cours.model.Skill;

// Check pk extends et pas implements pour respecter les principes SOLID
public interface SkillRepository extends GenericRepository<Skill,Integer>{

}
