package com.example.capstoneanoudiv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    static final String DATABASE_NAME = "AllergyDB.db";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_TABLE = "food_ingredients_and_allergens";
    //static final String DATABASE_NAME = "AllergyDB.db";
    //static final String DATABASE_NAME = "AllergyDB.db";
    //static final String DATABASE_NAME = "AllergyDB.db";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
