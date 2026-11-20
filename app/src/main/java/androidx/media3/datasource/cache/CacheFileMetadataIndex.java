package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.database.VersionTable;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.io.FileSystemException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheFileMetadataIndex {
    public static final String[] COLUMNS = {ContentDisposition.Parameters.Name, "length", "last_touch_timestamp"};
    public final Object databaseProvider;
    public Serializable tableName;

    public CacheFileMetadataIndex() {
        this.databaseProvider = new HashMap();
        this.tableName = new ArrayList();
    }

    public void checkAndSet(Object obj, String str) {
        HashMap map = (HashMap) this.databaseProvider;
        obj.getClass();
        map.put(str, obj);
        ((ArrayList) this.tableName).remove(str);
    }

    public HashMap getAll() throws FileSystemException {
        try {
            ((String) this.tableName).getClass();
            Cursor cursorQuery = ((StandaloneDatabaseProvider) this.databaseProvider).getReadableDatabase().query((String) this.tableName, COLUMNS, null, null, null, null, null);
            try {
                HashMap map = new HashMap(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    string.getClass();
                    map.put(string, new CacheFileMetadata(cursorQuery.getLong(1), cursorQuery.getLong(2)));
                }
                cursorQuery.close();
                return map;
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (SQLException e) {
            throw new FileSystemException(e);
        }
    }

    public void initialize(long j) throws FileSystemException {
        StandaloneDatabaseProvider standaloneDatabaseProvider = (StandaloneDatabaseProvider) this.databaseProvider;
        try {
            String hexString = Long.toHexString(j);
            this.tableName = "ExoPlayerCacheFileMetadata" + hexString;
            if (VersionTable.getVersion(standaloneDatabaseProvider.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = standaloneDatabaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.setVersion(writableDatabase, 2, hexString, 1);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) this.tableName));
                    writableDatabase.execSQL("CREATE TABLE " + ((String) this.tableName) + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e) {
            throw new FileSystemException(e);
        }
    }

    public void removeAll(Set set) throws FileSystemException {
        ((String) this.tableName).getClass();
        try {
            SQLiteDatabase writableDatabase = ((StandaloneDatabaseProvider) this.databaseProvider).getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete((String) this.tableName, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new FileSystemException(e);
        }
    }

    public void set(long j, long j2, String str) throws FileSystemException {
        ((String) this.tableName).getClass();
        try {
            SQLiteDatabase writableDatabase = ((StandaloneDatabaseProvider) this.databaseProvider).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ContentDisposition.Parameters.Name, str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow((String) this.tableName, null, contentValues);
        } catch (SQLException e) {
            throw new FileSystemException(e);
        }
    }

    public CacheFileMetadataIndex(StandaloneDatabaseProvider standaloneDatabaseProvider) {
        this.databaseProvider = standaloneDatabaseProvider;
    }
}
