package com.hb.cours.repository.interfaces;

import com.hb.cours.model.Skill;

import java.util.List;

// Check pk extends et pas implements pour respecter les principes SOLID
public interface SkillRepository extends GenericRepository<Skill,Integer>{
    List<Skill> findByStudent(int idStudent);
}
