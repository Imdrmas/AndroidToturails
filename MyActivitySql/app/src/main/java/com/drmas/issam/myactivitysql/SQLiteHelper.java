package com.drmas.issam.myactivitysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by drmas on 06/03/2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="UserDataBase";


       //// vars SignUp and SignIn
    public static final String TABLE_NAME="UserTable";
    public static final String Table_Column_ID="id";
    public static final String Table_Column_1_Name="name";
    public static final String Table_Column_2_Email="email";
    public static final String Table_Column_3_Password="password";

    //// Vars Projects
    public static final String TABLE_PROJECT = "project";
    public static final String COLUMN_PROJECTNO = "projectno";
    public static final String COLUMN_PROJECTNAME = "projectname";
    public static final String COLUMN_LOCATION_PROJECT = "location";
    public static final String COLUMN_DEPTNO_PROJECT = "deptno";

    //// Vars Department
    public static final String TABLE_DEPARTMENT = "department";
    public static final String COLUMN_DEPTNO = "deptno";
    public static final String COLUMN_DEPTNAME = "deptname";
    public static final String COLUMN_LOCATION_DEPT = "location";

    //// Vars Employy
    public static final String TABLE_EMPLOYYE = "employye";
    public static final String COLUMN_EMPNO = "empno";
    public static final String COLUMN_EMPNAME = "empname";
    public static final String COLUMN_EMPAddress = "adress";
    public static final String COLUMN_EMPSALARY = "salary";
    public static final String COLUMN_EMPHIRINGDATE = "hiringdate";
    public static final String COLUMN_EMPBIRTHDATE = "birthdate";
    public static final String COLUMN_DEPTNO_EMP = "deptno";

    //// Vars employee phone
    public static final String TABLE_EMPLOYY_PHONE = "employye_phone";
    public static final String COLUMN_EMPNO_PHONE = "empno_phone";
    public static final String COLUMN_PHONE = "phone";

    //// Vars workon
    public static final String TABLE_WORKON = "workon";
    public static final String COLUMN_EMPNO_WORKON = "empno_workon";
    public static final String COLUMN_PROJECTNO_WORKON = "projectno";


    // Table Create Project
    private static final String CREATE_TABLE_PROJECT = "CREATE TABLE "
            + TABLE_PROJECT + "(" + COLUMN_PROJECTNO + " INTEGER PRIMARY KEY, "
            + COLUMN_PROJECTNAME + "TEXT, "
            + COLUMN_LOCATION_PROJECT + "TEXT, "
            + COLUMN_DEPTNO_PROJECT + "INTEGER ) ";

    /// Table Create Department
    private static final String CREATE_TABLE_DEPARTMENT = "CREATE TABLE "
            + TABLE_DEPARTMENT + "(" + COLUMN_DEPTNO + "INTEGER PRIMARY KEY, "
            + COLUMN_DEPTNAME + "TEXT, "
            + COLUMN_LOCATION_DEPT + "TEXT )";

    /// Table Create Employee
    private static final String CREATE_TABLE_EMPLOYYE = "CREATE TABLE "
            + TABLE_EMPLOYYE + "(" + COLUMN_EMPNO + "INTEGER PRIMARY KEY, "
            + COLUMN_EMPNAME + "TEXT, "
            + COLUMN_EMPAddress + "TEXT, "
            + COLUMN_EMPSALARY + "DOUBLE, "
            + COLUMN_EMPHIRINGDATE + "DATE, "
            + COLUMN_EMPBIRTHDATE + "DATE, "
            + COLUMN_DEPTNO_EMP + "INTEGER )";

    /// Table Create Employye Phone
    private static final String CREATE_TABLE_EMPLOYE_PHONE = "CREATE TABLE "
            + TABLE_EMPLOYY_PHONE + "(" + COLUMN_EMPNO_PHONE + "INTEGER PRIMARY KEY, "
            + COLUMN_PHONE + "TEXT )";

    /// Table Create Workon
    private static final String CREATE_TABLE_WORKON = "CREATE TABLE "
          + TABLE_WORKON + "(" + COLUMN_EMPNO_WORKON + "INTEGER PRIMARY, "
            + COLUMN_PROJECTNO_WORKON + "INTEGER )";



    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_Name+" VARCHAR, "+Table_Column_2_Email+" VARCHAR, "+Table_Column_3_Password+" VARCHAR)";
        database.execSQL(CREATE_TABLE);
        database.execSQL( CREATE_TABLE_PROJECT );
        database.execSQL( CREATE_TABLE_DEPARTMENT );
        database.execSQL( CREATE_TABLE_EMPLOYYE );
        database.execSQL( CREATE_TABLE_EMPLOYE_PHONE );
        database.execSQL( CREATE_TABLE_WORKON );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_PROJECT );
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_DEPARTMENT );
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_EMPLOYY_PHONE );
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_WORKON );
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_EMPLOYYE );

        onCreate(db);

    }



}
