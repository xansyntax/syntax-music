package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteStatement delegate;

    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.delegate = sQLiteStatement;
    }
}
