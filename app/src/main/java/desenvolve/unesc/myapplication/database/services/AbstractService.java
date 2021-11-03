package desenvolve.unesc.myapplication.database.services;

import android.database.sqlite.SQLiteDatabase;

import desenvolve.unesc.myapplication.database.DBOpenHelper;

public abstract class AbstractService {

    protected SQLiteDatabase db;
    protected DBOpenHelper helper;

    protected final void Open() {
        db = helper.getWritableDatabase();
    }

    protected final void Close() {
        helper.close();
    }

}
