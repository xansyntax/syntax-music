package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.delegate = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(byte[] bArr, int i) {
        this.delegate.bindBlob(i, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i, double d) {
        this.delegate.bindDouble(i, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j) {
        this.delegate.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        this.delegate.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int i, String str) {
        str.getClass();
        this.delegate.bindString(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }
}
