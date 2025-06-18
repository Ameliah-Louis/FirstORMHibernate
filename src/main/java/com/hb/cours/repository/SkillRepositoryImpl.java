package com.hb.cours.repository;

import com.hb.cours.model.Skill;
import com.hb.cours.repository.interfaces.SkillRepository;
import com.hb.cours.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {
    private final String findAllSQL = "SELECT * FROM skill";
    private final String persistSQL = "INSERT INTO skill (label) VALUES (?)";
    private final String findByIdSQL = "SELECT * FROM skill WHERE id=?";
    private final String updateSQL = "UPDATE skill SET label=? WHERE id=?";
    private final String deleteSQL = "DELETE FROM skill WHERE id=?";


    @Override
    public List<Skill> findAll() {
        //Créer une liste sous forme de tableau
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = Database.getConnection();) {
            // Bonus: Créer un classe Database avec une methode getConnection static qui va return spécifiquement cette ligne
            // Connection connection= DriverManager.getConnection("jdbc:mysql://root:1234@localhost:3306/hb_cda_jdbc");
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

        } catch (SQLException e) {
            throw new UnsupportedOperationException("Unimplemented method 'findAll()'");
        }
        return skills;
    }


    @Override
    public Skill findById(Integer id) {

        try (Connection connection = Database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(findByIdSQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Skill instance = resultToInstance(rs);

                return instance;
            }
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Unimplemented method 'findById()'");
        }
        return null;
    }

    @Override
    public boolean persist(Skill entity) {
        try (Connection connection = Database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    persistSQL,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getLabel());

            statement.executeUpdate();
            // Pour récupérer l'id auto incrémenté, on utilise ce petit bout de code
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            entity.setId(keys.getInt(1));
            return true;
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Unimplemented method 'persist'");
        }
    }

    @Override
    public boolean update(Skill entity) {
        try (Connection connection = Database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    updateSQL);
            statement.setString(1, entity.getLabel());
            statement.setInt(2, entity.getId());


            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Unimplemented method 'update'");
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = Database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    deleteSQL);
            statement.setInt(1, id);


            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
        }
    }

    private Skill resultToInstance(ResultSet rs) throws SQLException {
        return new Skill(
                rs.getInt("skill.id"),
                rs.getString("skill.label"));
    }
}
