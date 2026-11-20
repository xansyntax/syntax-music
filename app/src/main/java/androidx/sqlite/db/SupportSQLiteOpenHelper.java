package androidx.sqlite.db;

import androidx.navigation.NavDeepLinkRequest;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes.dex */
    public interface Factory {
        SupportSQLiteOpenHelper create(NavDeepLinkRequest navDeepLinkRequest);
    }

    String getDatabaseName();

    FrameworkSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);
}
