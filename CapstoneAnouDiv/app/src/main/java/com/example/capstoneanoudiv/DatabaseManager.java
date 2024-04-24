package com.example.capstoneanoudiv;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context c)
    {
        context = c;
    }

    public static Connection getConnection(String url) throws SQLException
    {
        //driverManager manages JDBC connection needed
        return DriverManager.getConnection(url);
    }


    public DatabaseManager open() throws SQLDataException
    {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getReadableDatabase();
        return this;
    }
}
