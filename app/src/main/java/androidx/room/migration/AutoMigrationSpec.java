package androidx.room.migration;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.driver.SupportSQLiteConnection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface AutoMigrationSpec {
    default void onPostMigrate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        if (sQLiteConnection instanceof SupportSQLiteConnection) {
            onPostMigrate(((SupportSQLiteConnection) sQLiteConnection).db);
        }
    }

    default void onPostMigrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.getClass();
    }
}
