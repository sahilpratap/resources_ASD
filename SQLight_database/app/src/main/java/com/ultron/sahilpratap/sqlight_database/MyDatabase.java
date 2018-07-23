package com.ultron.sahilpratap.sqlight_database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper{

    public static final int DATA_VERSION = 1;
    public static final String DATABASE_NAME = "mydb";
    public static final String TABLE_NAME = "crimnal_record";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CASES = "cases";
    public static final String DISC = "disc";

    public MyDatabase(Context context) {

        super(context, DATABASE_NAME, null, DATA_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+TABLE_NAME+"("+ID+" NUMBER PRIMARY KEY,"+NAME+" TEXT,"+CASES+" TEXT,"+DISC+" TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public void insertRecord(CriminalRecord record){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID,record.getId());
        values.put(NAME,record.getName());
        values.put(CASES,record.getCases());
        values.put(DISC,record.getDisc());

        database.insert(TABLE_NAME,null,values);


    }

    public CriminalRecord getSingleRecord(int id){

        CriminalRecord record=null;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID, NAME, CASES, DISC}, ID, new String[]{"=?"}, String.valueOf(new String[]{String.valueOf(id)}), null, null, null);
        if(cursor.moveToNext()){

            record= new CriminalRecord(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        }

        return record;
    }

    public List<CriminalRecord> getAllRecord(){

        SQLiteDatabase db = getReadableDatabase();
        List<CriminalRecord> list = new ArrayList<CriminalRecord>();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToNext()){

            do{

                CriminalRecord record = new CriminalRecord();
                record.setId(cursor.getInt(0));
                record.setName(cursor.getString(1));
                record.setCases(cursor.getString(2));
                record.setDisc(cursor.getString(3));

                list.add(record);

            }while (cursor.moveToNext());

        }

        return list;
    }

    public void updateRecord(CriminalRecord record){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,record.getName());
        values.put(CASES,record.getCases());
        values.put(DISC,record.getDisc());

        db.update(TABLE_NAME,values,ID+"=?",new String[]{String.valueOf(record.getId())});

    }

    public void deleteRecord(int id){

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
        db.close();

    }

}
