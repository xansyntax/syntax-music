package androidx.room;

import androidx.sqlite.SQLiteStatement;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BindOnlySQLiteStatement implements SQLiteStatement {
    public final SQLiteStatement $$delegate_0;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BindOnlySQLiteStatement(SQLiteStatement sQLiteStatement, byte b) {
        this.$r8$classId = b;
        this.$$delegate_0 = sQLiteStatement;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindBlob(byte[] bArr, int i) {
        byte b = this.$r8$classId;
        SQLiteStatement sQLiteStatement = this.$$delegate_0;
        switch (b) {
            case 0:
                sQLiteStatement.bindBlob(bArr, i);
                break;
            default:
                sQLiteStatement.bindBlob(bArr, i);
                break;
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindDouble(int i, double d) {
        byte b = this.$r8$classId;
        SQLiteStatement sQLiteStatement = this.$$delegate_0;
        switch (b) {
            case 0:
                sQLiteStatement.bindDouble(i, d);
                break;
            default:
                sQLiteStatement.bindDouble(i, d);
                break;
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindLong(int i, long j) {
        byte b = this.$r8$classId;
        SQLiteStatement sQLiteStatement = this.$$delegate_0;
        switch (b) {
            case 0:
                sQLiteStatement.bindLong(i, j);
                break;
            default:
                sQLiteStatement.bindLong(i, j);
                break;
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindNull(int i) {
        byte b = this.$r8$classId;
        SQLiteStatement sQLiteStatement = this.$$delegate_0;
        switch (b) {
            case 0:
                sQLiteStatement.bindNull(i);
                break;
            default:
                sQLiteStatement.bindNull(i);
                break;
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindText(int i, String str) {
        byte b = this.$r8$classId;
        SQLiteStatement sQLiteStatement = this.$$delegate_0;
        switch (b) {
            case 0:
                str.getClass();
                sQLiteStatement.bindText(i, str);
                break;
            default:
                str.getClass();
                sQLiteStatement.bindText(i, str);
                break;
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void clearBindings() {
        byte b = this.$r8$classId;
        SQLiteStatement sQLiteStatement = this.$$delegate_0;
        switch (b) {
            case 0:
                sQLiteStatement.clearBindings();
                break;
            default:
                sQLiteStatement.clearBindings();
                break;
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                SQLiteStatement sQLiteStatement = this.$$delegate_0;
                sQLiteStatement.reset();
                sQLiteStatement.clearBindings();
                return;
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final boolean getBoolean() {
        byte b = this.$r8$classId;
        SQLiteStatement sQLiteStatement = this.$$delegate_0;
        switch (b) {
            case 0:
                break;
        }
        return sQLiteStatement.getBoolean();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final int getColumnCount() {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                return this.$$delegate_0.getColumnCount();
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final String getColumnName(int i) {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                return this.$$delegate_0.getColumnName(i);
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final double getDouble(int i) {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                return this.$$delegate_0.getDouble(i);
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final long getLong(int i) {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                return this.$$delegate_0.getLong(i);
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final String getText(int i) {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                return this.$$delegate_0.getText(i);
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final boolean isNull(int i) {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                return this.$$delegate_0.isNull(i);
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void reset() {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                this.$$delegate_0.reset();
                return;
        }
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final boolean step() {
        switch (this.$r8$classId) {
            case 0:
                throw new IllegalStateException("Only bind*() calls are allowed on the RoomRawQuery received statement.");
            default:
                return this.$$delegate_0.step();
        }
    }
}
