package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.TreeMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    public static final TreeMap queryPool = new TreeMap();
    public int argCount;
    public final int[] bindingTypes;
    public final byte[][] blobBindings;
    public final double[] doubleBindings;
    public final long[] longBindings;
    public volatile String query;
    public final String[] stringBindings;

    public RoomSQLiteQuery(int i) {
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2][];
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(byte[] bArr, int i) {
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i, double d) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int i, String str) {
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        int i = this.argCount;
        if (1 > i) {
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = this.bindingTypes[i2];
            if (i3 == 1) {
                supportSQLiteProgram.bindNull(i2);
            } else if (i3 == 2) {
                supportSQLiteProgram.bindLong(i2, this.longBindings[i2]);
            } else if (i3 == 3) {
                supportSQLiteProgram.bindDouble(i2, this.doubleBindings[i2]);
            } else if (i3 == 4) {
                String str = this.stringBindings[i2];
                if (str == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Required value was null.");
                    return;
                }
                supportSQLiteProgram.bindString(i2, str);
            } else if (i3 == 5) {
                byte[] bArr = this.blobBindings[i2];
                if (bArr == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Required value was null.");
                    return;
                }
                supportSQLiteProgram.bindBlob(bArr, i2);
            }
            if (i2 == i) {
                return;
            } else {
                i2++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
