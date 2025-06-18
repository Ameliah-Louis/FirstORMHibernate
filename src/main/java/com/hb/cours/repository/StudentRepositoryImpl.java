package com.hb.cours.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.cours.model.Promo;
import com.hb.cours.model.Student;
import com.hb.cours.repository.interfaces.StudentRepository;
import com.hb.cours.utils.Database;

public class StudentRepositoryImpl implements StudentRepository {
    private final String findAllSQL = "SELECT * FROM student LEFT JOIN promo ON student.promo_id=promo.id";

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        try (Connection connection = Database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(findAllSQL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student instance = resultToInstance(rs);
                rs.getInt("student.promo_id");
                if (!rs.wasNull()) {

                    instance.setPromo(
                            new Promo(
                                    rs.getInt("promo.id"),
                                    rs.getString("promo.name"),
                                    rs.getDate("promo.startDate").toLocalDate(),
                                    rs.getInt("promo.duration")));
                }
                list.add(instance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Student resultToInstance(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("student.id"),
                rs.getString("student.name"),
                rs.getString("student.firstname"),
                rs.getDate("student.birthday").toLocalDate());
    }

    @Override
    public Student findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean persist(Student entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'persist'");
    }

    @Override
    public boolean update(Student entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
