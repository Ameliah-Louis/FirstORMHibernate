package com.hb.cours.repository;

import com.hb.cours.model.Promo;
import com.hb.cours.model.Skill;
import com.hb.cours.model.Student;
import com.hb.cours.repository.interfaces.PromoRepository;
import com.hb.cours.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PromoRepositoryImpl  implements PromoRepository {
    private final String findAllSQL = "SELECT s.id AS student_id, s.firstname AS first_name, s.name AS last_name, "
            + "p.id AS promo_id, p.name AS promo_name, p.startDate, p.duration, "
            + "sk.id AS skill_id, sk.label AS skill_label "
            + "FROM student s "
            + "LEFT JOIN promo p ON s.promo_id = p.id "
            + "LEFT JOIN student_skills ss ON s.id = ss.student_id "
            + "LEFT JOIN skills sk ON ss.skill_id = sk.id";


    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();

        try (Connection connection = Database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(findAllSQL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student_id");

                Student stu = list.stream()
                        .filter(s -> s.getId().equals(studentId))
                        .findFirst()
                        .orElse(null);

                if (stu == null) {
                    Promo promo = new Promo();
                    promo.setId(rs.getInt("promo_id"));
                    promo.setName(rs.getString("promo_name"));
                    java.sql.Date d = rs.getDate("startDate");
                    if (d != null) promo.setStartDate(d.toLocalDate());
                    promo.setDuration(rs.getInt("duration"));

                    stu = new Student();
                    stu.setId(studentId);
                    stu.setFirstName(rs.getString("first_name"));
                    stu.setName(rs.getString("last_name"));
                    stu.setPromo(promo);
                    list.add(stu);
                }

                int skillId = rs.getInt("skill_id");
                if (!rs.wasNull()) {
                    Skill skill = new Skill();
                    skill.setId(skillId);
                    skill.setLabel(rs.getString("skill_label"));
                    stu.getSkills().add(skill);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    protected static Promo resultToInstance(ResultSet rs) throws SQLException {
        return new Promo(
                rs.getInt("promo.id"),
                rs.getString("promo.name"),
                rs.getObject("promo.start_date", LocalDate.class),
                rs.getInt("promo.duration"));
    }


    @Override
    public Object findById(Object id) {
        return null;
    }

    @Override
    public boolean persist(Object entity) {
        return false;
    }

    @Override
    public boolean update(Object entity) {
        return false;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }


}
