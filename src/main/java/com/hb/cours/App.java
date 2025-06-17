package com.hb.cours;

import com.hb.cours.model.Skill;
import com.hb.cours.repository.SkillRepositoryImpl;
import com.hb.cours.repository.interfaces.SkillRepository;

import java.sql.*;

/**
 * Hello world!
 * DB connection
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SkillRepository sr = new SkillRepositoryImpl();

        for (Skill skill : sr.findAll()) {
            System.out.println(skill.getLabel());
        }
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
