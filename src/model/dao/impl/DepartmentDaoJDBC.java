package model.dao.impl;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import db.DB;
import db.DbException;
import model.entities.Department;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements model.dao.DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department "
                    + "ORDER BY Id");

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();

            while (rs.next()) {
                list.add(instantiateDepartment(rs));
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setName(rs.getString("Name"));
        dep.setId(rs.getInt("Id"));
        return dep;
    }
}
