package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import com.google.common.base.Joiner;
import com.metrolist.music.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda20;
import java.io.Closeable;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements Closeable {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Lazy beginTransactionMethod$delegate;
    public static final Lazy getThreadSessionMethod$delegate;
    public final SQLiteDatabase delegate;

    static {
        UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((byte) 16);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        getThreadSessionMethod$delegate = ResultKt.lazy(lazyThreadSafetyMode, utilsKt$$ExternalSyntheticLambda0);
        beginTransactionMethod$delegate = ResultKt.lazy(lazyThreadSafetyMode, new UtilsKt$$ExternalSyntheticLambda0((byte) 17));
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.delegate = sQLiteDatabase;
    }

    public final void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public final void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    public final void endTransaction() {
        this.delegate.endTransaction();
    }

    public final void execSQL(String str) {
        this.delegate.execSQL(str);
    }

    public final String getPath() {
        return this.delegate.getPath();
    }

    public final boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public final long insert(String str, int i, ContentValues contentValues) {
        return this.delegate.insertWithOnConflict(str, null, contentValues, i);
    }

    public final boolean isOpen() {
        return this.delegate.isOpen();
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        final HistoryScreenKt$$ExternalSyntheticLambda20 historyScreenKt$$ExternalSyntheticLambda20 = new HistoryScreenKt$$ExternalSyntheticLambda20((byte) 4, supportSQLiteQuery);
        Cursor cursorRawQueryWithFactory = this.delegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$$ExternalSyntheticLambda1
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return (Cursor) historyScreenKt$$ExternalSyntheticLambda20.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
        cursorRawQueryWithFactory.getClass();
        return cursorRawQueryWithFactory;
    }

    public final void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public final Cursor query(String str) {
        return query(new Joiner(str, (byte) 4));
    }
}
