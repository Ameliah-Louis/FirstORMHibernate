package com.hb.cours.repository;

import com.hb.cours.model.Skill;
import com.hb.cours.repository.interfaces.SkillRepository;
import com.hb.cours.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {


    @Override
    public List<Skill> findAll() {
        //Créer une liste sous forme de tableau
        List<Skill> skills = new ArrayList<>();
        try {
            // Bonus: Créer un classe Database avec une methode getConnection static qui va return spécifiquement cette ligne
            // Connection connection= DriverManager.getConnection("jdbc:mysql://root:1234@localhost:3306/hb_cda_jdbc");
            Connection connection = Database.getConnection();
            System.out.println( "DB connection Ok!" );
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Skills");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                //Dans la boucle, au lieu de faire des system.out.print nul, faire des instances
                //de Skill qu'on met dans la list et on la return à la fin de la méthode
                Skill skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setLabel(rs.getString("label"));
                skills.add(skill);

//                System.out.println(rs.getString("label"));
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Unimplemented method 'findAll()'");
        }
        return skills;
    }


    @Override
    public Skill findById(Integer id) {
        return null;
    }
    @Override
    public boolean persist(Skill entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'persist'");
    }

    @Override
    public boolean update(Skill entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
