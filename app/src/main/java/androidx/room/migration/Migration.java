package androidx.room.migration;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.driver.SupportSQLiteConnection;
import kotlin.NotImplementedError;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Migration {
    public final byte endVersion;
    public final byte startVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public Migration(int i, int i2) {
        this.startVersion = i;
        this.endVersion = i2;
    }

    public void migrate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        if (!(sQLiteConnection instanceof SupportSQLiteConnection)) {
            throw new NotImplementedError("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
        }
        migrate(((SupportSQLiteConnection) sQLiteConnection).db);
    }

    public void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.getClass();
        throw new NotImplementedError("Migration functionality with a SupportSQLiteDatabase (without a provided SQLiteDriver) requires overriding the migrate(SupportSQLiteDatabase) function.");
    }
}
