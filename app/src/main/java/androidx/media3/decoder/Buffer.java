package androidx.media3.decoder;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Buffer {
    public final /* synthetic */ byte $r8$classId;
    public int flags;

    public /* synthetic */ Buffer(byte b, int i) {
        this.$r8$classId = b;
        this.flags = i;
    }

    public static void deleteDatabaseFile(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e) {
            Log.w("SupportSQLite", "delete failed: ", e);
        }
    }

    public static String getBoxTypeString(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public void addFlag(int i) {
        this.flags = i | this.flags;
    }

    public boolean getFlag(int i) {
        return (this.flags & i) == i;
    }

    public abstract void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

    public abstract void onDowngrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i, int i2);

    public abstract void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

    public abstract void onUpgrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i, int i2);

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                return getBoxTypeString(this.flags);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ Buffer() {
        this.$r8$classId = (byte) 0;
    }
}
