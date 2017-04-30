package alvi17.eidrecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by User on 4/21/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "saveinfo.db";
    private static final String TABLE_NAME = "visited_log";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME= "info";

    public DBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " +TABLE_NAME+
                        "(id integer primary key,position integer,info integer,rating integer)");
        Log.e("DBHelper","Table created");
    }


    public void insertInfo(Integer position,Integer info)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_NAME,info);
        contentValues.put("position",position);
        database.insert(TABLE_NAME,null,contentValues);
        Log.e("DataBaseHelper", "new info inserted: " + contentValues);
        database.close();
    }

    public int getSaveValue(int position)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select info from "+TABLE_NAME+" where position ="+position, null );
        Log.e("DBHelper","count: "+res.getCount() +" position: "+position);
        if(res.getCount()>0)
        {
            res.moveToFirst();
            return res.getInt(res.getColumnIndex("info"));
        }

        return 0;

    }


    public int getRatingValue(int position)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select rating from "+TABLE_NAME+" where position ="+position, null );
        Log.e("DBHelper","count: "+res.getCount() +" position: "+position);
        if(res.getCount()>0)
        {

            res.moveToFirst();
            return res.getInt(res.getColumnIndex("rating"));
        }

        return 0;

    }

    public void updateValue(int value,int position)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rating",value);
//
        db.update(TABLE_NAME,contentValues,"position="+position+"",null);
        Log.e("DBHelper","updated: "+position + "value: "+value );
    }

    public void insertRaing(int position,int rating)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("rating",rating);
        contentValues.put("position",position);
        database.insert(TABLE_NAME,null,contentValues);
        Log.e("DataBaseHelper", "new rating info inserted: " + contentValues);
        database.close();
    }

    public boolean deleteRows()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean isDelete= db.delete(TABLE_NAME,null, null) > 0;

        db.close();
        return  isDelete;
    }


    public ArrayList<String> getAllInfo()
    {
        ArrayList<String> array_list = new ArrayList<>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();
        while(!res.isAfterLast()){
            array_list.add(res.getString(res.getColumnIndex(COLUMN_NAME))
            );
            res.moveToNext();
        }
        Collections.reverse(array_list);
        res.close();
        Log.e("DBHelper","Info List: "+ array_list.toString());
        db.close();
        return array_list;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
    }


}
