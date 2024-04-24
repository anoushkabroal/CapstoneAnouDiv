package com.example.capstoneanoudiv;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.myTextView);

        DatabaseManager dbManager = new DatabaseManager(this);
        // JDBC URL for SQLite
        String url = "jdbc:sqlite:C:\\Users\\gaurav\\Desktop";

        try (Connection connection = DatabaseManager.getConnection(url)) {
            // SQL query (allow this to be changed by user)
            String sqlQuery = "SELECT FoodProduct FROM food_ingredients_allergens WHERE Allergens = ?";

            //PreparedStatement takes in a sqlQuery that can be changed
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            // Set parameter value so the ? would be IT
            preparedStatement.setString(1, "Dairy");

            //do query and save the result
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String food = resultSet.getString("FoodProduct");
                System.out.println("Food: " + food);
                text.setText(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}