package com.goodrain.springbootdemo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.goodrain.springbootdemo.dao.DBInfoDao;
import com.goodrain.springbootdemo.util.DBConnPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBInfoService {
    @Autowired
    public DBInfoDao dbInfoDao;

    public Boolean isClosed() throws SQLException {
        System.out.println("isClosed Start");
        DBConnPool dcp = DBConnPool.getInstance();
        if (dcp == null) {
            return true;
        }
        System.out.println("isClosed getInstance success");
        Connection conn = dcp.getConnection();
        System.out.println("isClosed getConnection success");
        return conn.isClosed();
    }

    public List<String> listTables() throws SQLException {
        return dbInfoDao.listTables(System.getenv("MYSQL_DATABASE"));
    }
}
