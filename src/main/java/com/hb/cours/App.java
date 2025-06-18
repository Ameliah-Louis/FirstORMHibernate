package com.hb.cours;

import com.hb.cours.model.Skill;
import com.hb.cours.model.Student;
import com.hb.cours.repository.PromoRepositoryImpl;
import com.hb.cours.repository.SkillRepositoryImpl;
import com.hb.cours.repository.StudentRepositoryImpl;
import com.hb.cours.repository.interfaces.SkillRepository;
import com.hb.cours.repository.interfaces.StudentRepository;

import java.sql.*;
import java.util.List;

/**
 * Hello world!
 * DB connection
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //Exercice 1
//        SkillRepository sr = new SkillRepositoryImpl();
//
//        for (Skill skill : sr.findAll()) {
//            System.out.println(skill.getLabel());
////        }
//        SkillRepository repo = new SkillRepositoryImpl();
//        repo.delete(1);

        //Exercice 2
//        StudentRepository repo = new StudentRepositoryImpl();
//
//        List<Student> result = repo.findAll();
//
//        for (Student student : result) {
//            System.out.println(student.getName() + " "+student.getFirstName()+" "+student.getPromo().getName());
//        }

        PromoRepositoryImpl studentRepo = new PromoRepositoryImpl();
        List<Student> students = studentRepo.findAll();

        for (Student student : students) {
            System.out.println("👤 " + student.getFirstName() + " " + student.getName());
            System.out.println("   Promo : " + student.getPromo().getName());
            System.out.println("   Début : " + student.getPromo().getStartDate() +
                    " | Fin : " + student.getPromo().getEndDate());
            System.out.println("   Compétences :");
            for (Skill skill : student.getSkills()) {
                System.out.println("     - " + skill.getLabel());
            }
            System.out.println("--------------------------------------------------");
        }


//  Logique exportée dans Database.java
//        try {
//            Connection connection= DriverManager.getConnection("jdbc:mysql://root:1234@localhost:3306/hb_cda_jdbc");
//            System.out.println( "DB connection Ok!" );
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Skills");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getString("label"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
    }
}
