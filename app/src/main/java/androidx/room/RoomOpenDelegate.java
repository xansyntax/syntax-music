package androidx.room;

import androidx.media3.common.FlagSet;
import androidx.sqlite.SQLiteConnection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RoomOpenDelegate {
    public final String identityHash;
    public final String legacyIdentityHash;
    public final int version;

    public RoomOpenDelegate(int i, String str, String str2) {
        this.version = i;
        this.identityHash = str;
        this.legacyIdentityHash = str2;
    }

    public void createAllTables(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        throw new IllegalStateException("NOP delegate should never be called");
    }

    public void dropAllTables(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        throw new IllegalStateException("NOP delegate should never be called");
    }

    public void onCreate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        throw new IllegalStateException("NOP delegate should never be called");
    }

    public void onOpen(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        throw new IllegalStateException("NOP delegate should never be called");
    }

    public void onPostMigrate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        throw new IllegalStateException("NOP delegate should never be called");
    }

    public void onPreMigrate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        throw new IllegalStateException("NOP delegate should never be called");
    }

    public FlagSet.Builder onValidateSchema(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        throw new IllegalStateException("NOP delegate should never be called");
    }
}
