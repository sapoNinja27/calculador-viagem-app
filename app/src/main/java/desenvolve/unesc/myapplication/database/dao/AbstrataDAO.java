package desenvolve.unesc.myapplication.database.dao;

import android.database.sqlite.SQLiteDatabase;

import desenvolve.unesc.myapplication.database.DBOpenHelper;

public abstract class AbstrataDAO {

    protected SQLiteDatabase db;
    protected DBOpenHelper helper;

    protected final void Open() {
        db = helper.getWritableDatabase();
    }

    protected final void Close() {
        helper.close();
    }

}
