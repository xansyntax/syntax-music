package androidx.sqlite;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SQLiteStatement extends AutoCloseable {
    void bindBlob(byte[] bArr, int i);

    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindText(int i, String str);

    void clearBindings();

    default boolean getBoolean() {
        return getLong(0) != 0;
    }

    int getColumnCount();

    String getColumnName(int i);

    double getDouble(int i);

    long getLong(int i);

    String getText(int i);

    boolean isNull(int i);

    void reset();

    boolean step();
}
