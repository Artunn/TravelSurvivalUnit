package com.example.asusnb.travelsurvivalunit;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.asusnb.travelsurvivalunit.User;

public class UserDatabaseHelper extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DB_FILE_NAME = "user";

    public UserDatabaseHelper(Context context) {
        super(context, DB_FILE_NAME, null, DATABASE_VERSION);
    }

    //Create database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE user_info ( " +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " username VARCHAR2(30), " +
                " password VARCHAR2(20)," +
                " homeCountry VARCHAR2(20)," +
                " name VARCHAR2 (30)," +
                " surname VARCHAR(30)," +
                " avatarId INTEGER," +
                " count INTEGER," +
                " motherLanguage VARCHAR(30)," +
                " targetLanguage VARCHAR(30)," +
                " destination VARCHAR(30))";
        db.execSQL(sql);
    }

    //Update database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == oldVersion + 1) {
            // db.execSQL("ALTER TABLE student_info ADD COLUMN country VARCHAR(30)");
        }
    }

    //Insert data into table
    public void insertData(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("INSERT INTO user_info (username, password, homeCountry, name, surname, avatarId, count, motherLanguage, targetLanguage, destination) "
                + "VALUES (?,?,?,?)");
        stmt.bindString(1, user.getUsername());
        stmt.bindString(2, user.getPassword());
        stmt.bindString(3, user.getHomeCountry());
        stmt.bindString(4, user.getName());
        stmt.bindString(5, user.getSurname());
        stmt.bindLong(6, user.getAvatar());
        stmt.bindLong(7, user.getCount());
        stmt.bindString(8, user.getMotherLanguage());
        stmt.bindString(9, user.getTargetLanguage());
        stmt.bindString(10, user.getDestination());
        stmt.execute();
        stmt.close();
        db.close();
    }

    //Update data into table
    public void updateData(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("UPDATE student_info SET username=?, password=?, homeCountry=?, name=?, surname=?, avatarId=?, count=?, motherLanguage=?, targetLanguage=?, destination=?" +
                "WHERE id = ?");
        stmt.bindString(1, user.getUsername());
        stmt.bindString(2, user.getPassword());
        stmt.bindString(3, user.getHomeCountry());
        stmt.bindString(4, user.getName());
        stmt.bindString(5, user.getSurname());
        stmt.bindLong(6, user.getAvatar());
        stmt.bindLong(7, user.getCount());
        stmt.bindString(8, user.getMotherLanguage());
        stmt.bindString(9, user.getTargetLanguage());
        stmt.bindString(10, user.getDestination());

        stmt.execute();
        stmt.close();
        db.close();
    }

    //Select all data from the table
    public List getUsers() {
        List users = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT id, username, password, homeCountry, name, surname, avatarId, count, motherLanguage, targetLanguage, destination from user_info ORDER BY id ASC";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            User usr = new User();
            usr.setId(cursor.getInt(0));
            usr.setUsername(cursor.getString(1));
            usr.setPassword(cursor.getString(2));
            usr.setHomeCountry(cursor.getString(3));
            usr.setName(cursor.getString(4));
            usr.setSurname(cursor.getString(5));
            usr.setAvatar(cursor.getInt(6));
            usr.setCount(cursor.getInt(7));
            usr.setMotherLanguage(cursor.getString(8));
            usr.setTargetLanguage(cursor.getString(9));
            usr.setDestination(cursor.getString(10));
            users.add(usr);
        }
        db.close();
        return users;
    }

    //Delete data from the table for the given id
    public void deleteData(int usrId) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("DELETE FROM user_info WHERE id = ?");
        stmt.bindLong(1, usrId);
        stmt.execute();
        stmt.close();
        db.close();
    }

    //Select data for the given id
    public User getUserById(int userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT id, username, password, homeCountry, name, surname, avatarId, count, motherLanguage, targetLanguage, destination FROM user_info WHERE id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(userId)});
        cursor.moveToFirst();
        User usr = new User();
        usr.setId(cursor.getInt(0));
        usr.setUsername(cursor.getString(1));
        usr.setPassword(cursor.getString(2));
        usr.setHomeCountry(cursor.getString(3));
        usr.setName(cursor.getString(4));
        usr.setSurname(cursor.getString(5));
        usr.setAvatar(cursor.getInt(6));
        usr.setCount(cursor.getInt(7));
        usr.setMotherLanguage(cursor.getString(8));
        usr.setTargetLanguage(cursor.getString(9));
        usr.setDestination(cursor.getString(10));
        db.close();
        return usr;
    }
}
