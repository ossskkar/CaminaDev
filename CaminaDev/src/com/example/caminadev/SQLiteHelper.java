package com.example.caminadev;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	public static final String TABLE_PATH_H="path_h";
	public static final String PATH_H_COLUMN_ID="_id";
	public static final String PATH_H_COLUMN_SUBJECT="_subject";
	public static final String PATH_H_COLUMN_DEVICE="_device";
	public static final String PATH_H_COLUMN_DESCRIPTION="_description";
	public static final String PATH_H_COLUMN_DATE="_date";
	public static final String PATH_H_COLUMN_FILE_NAME="file_name";
	
	public static final String TABLE_PATH_D="path_d";
	public static final String PATH_D_COLUMN_ID="_id";
	public static final String PATH_D_COLUMN_PATH_H="path_h";
	
	public static final String PATH_D_COLUMN_DIRECTION_X="direction_x";
	public static final String PATH_D_COLUMN_DIRECTION_Y="direction_y";
	public static final String PATH_D_COLUMN_DIRECTION_Z="direction_z";
	
	public static final String PATH_D_COLUMN_ACCELERATION_X="acceleration_x";
	public static final String PATH_D_COLUMN_ACCELERATION_Y="acceleration_y";
	public static final String PATH_D_COLUMN_ACCELERATION_Z="acceleration_z";
	
	public static final String PATH_D_COLUMN_GYRO_X="gyro_x";
	public static final String PATH_D_COLUMN_GYRO_Y="gyro_y";
	public static final String PATH_D_COLUMN_GYRO_Z="gyro_z";
	
	private static final String DATABASE_NAME="camina.db";
	private static final int DATABASE_VERSION=1;
		
	private static final String DATABASE_CREATE_H=
			"create table "+TABLE_PATH_H+"("
			+PATH_H_COLUMN_ID+" integer primary key autoincrement, "
			+PATH_H_COLUMN_SUBJECT+" text not null, "
			+PATH_H_COLUMN_DEVICE+" text not null, "
			+PATH_H_COLUMN_DESCRIPTION+" text not null, "
			+PATH_H_COLUMN_DATE+" text not null, "
			+PATH_H_COLUMN_FILE_NAME+" text not null); ";
	private static final String DATABASE_CREATE_D=
			"create table "+TABLE_PATH_D+"("
			+PATH_D_COLUMN_ID +" integer primary key autoincrement, "
			+PATH_D_COLUMN_PATH_H+" integer not null, "
			+PATH_D_COLUMN_DIRECTION_X+" float not null, "
			+PATH_D_COLUMN_DIRECTION_Y+" float not null, "
			+PATH_D_COLUMN_DIRECTION_Z+" float not null, "
			+PATH_D_COLUMN_ACCELERATION_X+" float not null, "
			+PATH_D_COLUMN_ACCELERATION_Y+" float not null, "
			+PATH_D_COLUMN_ACCELERATION_Z+" float not null, "
			+PATH_D_COLUMN_GYRO_X+" float not null, "
			+PATH_D_COLUMN_GYRO_Y+" float not null, "
			+PATH_D_COLUMN_GYRO_Z+" float not null); ";
	
	public SQLiteHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_H);
		database.execSQL(DATABASE_CREATE_D);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(SQLiteHelper.class.getName(),
				"Upgrading database from version "+oldVersion+" to "
				+newVersion+", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_PATH_H);
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_PATH_D);
		onCreate(db);
	}
}
