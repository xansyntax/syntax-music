package androidx.sqlite.driver;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SupportSQLiteStatement implements SQLiteStatement {
    public final FrameworkSQLiteDatabase db;
    public boolean isClosed;
    public final String sql;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RowSQLiteStatement extends SupportSQLiteStatement {
        public int[] bindingTypes;
        public byte[][] blobBindings;
        public Cursor cursor;
        public double[] doubleBindings;
        public long[] longBindings;
        public String[] stringBindings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RowSQLiteStatement(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str) {
            super(frameworkSQLiteDatabase, str);
            frameworkSQLiteDatabase.getClass();
            str.getClass();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        public static void throwIfInvalidColumn(Cursor cursor, int i) {
            if (i < 0 || i >= cursor.getColumnCount()) {
                SQLite.throwSQLiteException(25, "column index out of range");
                throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindBlob(byte[] bArr, int i) {
            throwIfClosed();
            ensureCapacity(4, i);
            this.bindingTypes[i] = 4;
            this.blobBindings[i] = bArr;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindDouble(int i, double d) {
            throwIfClosed();
            ensureCapacity(2, i);
            this.bindingTypes[i] = 2;
            this.doubleBindings[i] = d;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindLong(int i, long j) {
            throwIfClosed();
            ensureCapacity(1, i);
            this.bindingTypes[i] = 1;
            this.longBindings[i] = j;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindNull(int i) {
            throwIfClosed();
            ensureCapacity(5, i);
            this.bindingTypes[i] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindText(int i, String str) {
            str.getClass();
            throwIfClosed();
            ensureCapacity(3, i);
            this.bindingTypes[i] = 3;
            this.stringBindings[i] = str;
        }

        @Override // androidx.sqlite.driver.SupportSQLiteStatement, androidx.sqlite.SQLiteStatement
        public final void clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // java.lang.AutoCloseable
        public final void close() {
            if (!this.isClosed) {
                clearBindings();
                reset();
            }
            this.isClosed = true;
        }

        public final void ensureCapacity(int i, int i2) {
            int i3 = i2 + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i3) {
                this.bindingTypes = Arrays.copyOf(iArr, i3);
            }
            if (i == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i3) {
                    this.longBindings = Arrays.copyOf(jArr, i3);
                    return;
                }
                return;
            }
            if (i == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i3) {
                    this.doubleBindings = Arrays.copyOf(dArr, i3);
                    return;
                }
                return;
            }
            if (i == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i3) {
                    this.stringBindings = (String[]) Arrays.copyOf(strArr, i3);
                    return;
                }
                return;
            }
            if (i != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i3) {
                this.blobBindings = (byte[][]) Arrays.copyOf(bArr, i3);
            }
        }

        public final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = this.db.query(new ConnectionPool(this));
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final String getColumnName(int i) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
                return null;
            }
            throwIfInvalidColumn(cursor, i);
            String columnName = cursor.getColumnName(i);
            columnName.getClass();
            return columnName;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final double getDouble(int i) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i);
            return cursorThrowIfNoRow.getDouble(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final long getLong(int i) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i);
            return cursorThrowIfNoRow.getLong(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final String getText(int i) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i);
            String string = cursorThrowIfNoRow.getString(i);
            string.getClass();
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final boolean isNull(int i) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i);
            return cursorThrowIfNoRow.isNull(i);
        }

        @Override // androidx.sqlite.driver.SupportSQLiteStatement, androidx.sqlite.SQLiteStatement
        public final void reset() {
            throwIfClosed();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
            return false;
        }

        public final Cursor throwIfNoRow() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            SQLite.throwSQLiteException(21, "no row");
            throw null;
        }
    }

    public SupportSQLiteStatement(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str) {
        this.db = frameworkSQLiteDatabase;
        this.sql = str;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void clearBindings() {
        throwIfClosed();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        throwIfClosed();
    }

    public final void throwIfClosed() {
        if (this.isClosed) {
            SQLite.throwSQLiteException(21, "statement is closed");
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OtherSQLiteStatement extends SupportSQLiteStatement {
        public final /* synthetic */ byte $r8$classId = 0;
        public final Object delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OtherSQLiteStatement(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str) {
            super(frameworkSQLiteDatabase, str);
            frameworkSQLiteDatabase.getClass();
            str.getClass();
            str.getClass();
            android.database.sqlite.SQLiteStatement sQLiteStatementCompileStatement = frameworkSQLiteDatabase.delegate.compileStatement(str);
            sQLiteStatementCompileStatement.getClass();
            this.delegate = new FrameworkSQLiteStatement(sQLiteStatementCompileStatement);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindBlob(byte[] bArr, int i) {
            byte b = this.$r8$classId;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    throwIfClosed();
                    ((FrameworkSQLiteStatement) obj).bindBlob(bArr, i);
                    return;
                case 1:
                    ((RowSQLiteStatement) obj).bindBlob(bArr, i);
                    return;
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(25, "column index out of range");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindDouble(int i, double d) {
            byte b = this.$r8$classId;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    throwIfClosed();
                    ((FrameworkSQLiteStatement) obj).bindDouble(i, d);
                    return;
                case 1:
                    ((RowSQLiteStatement) obj).bindDouble(i, d);
                    return;
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(25, "column index out of range");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindLong(int i, long j) {
            byte b = this.$r8$classId;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    throwIfClosed();
                    ((FrameworkSQLiteStatement) obj).bindLong(i, j);
                    return;
                case 1:
                    ((RowSQLiteStatement) obj).bindLong(i, j);
                    return;
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(25, "column index out of range");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindNull(int i) {
            byte b = this.$r8$classId;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    throwIfClosed();
                    ((FrameworkSQLiteStatement) obj).bindNull(i);
                    return;
                case 1:
                    ((RowSQLiteStatement) obj).bindNull(i);
                    return;
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(25, "column index out of range");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindText(int i, String str) {
            byte b = this.$r8$classId;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    str.getClass();
                    throwIfClosed();
                    ((FrameworkSQLiteStatement) obj).bindString(i, str);
                    return;
                case 1:
                    str.getClass();
                    ((RowSQLiteStatement) obj).bindText(i, str);
                    return;
                default:
                    str.getClass();
                    throwIfClosed();
                    SQLite.throwSQLiteException(25, "column index out of range");
                    throw null;
            }
        }

        @Override // androidx.sqlite.driver.SupportSQLiteStatement, androidx.sqlite.SQLiteStatement
        public void clearBindings() {
            byte b = this.$r8$classId;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    throwIfClosed();
                    ((FrameworkSQLiteStatement) obj).clearBindings();
                    break;
                case 1:
                    ((RowSQLiteStatement) obj).clearBindings();
                    break;
                default:
                    super.clearBindings();
                    break;
            }
        }

        @Override // java.lang.AutoCloseable
        public final void close() throws IOException {
            byte b = this.$r8$classId;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    ((FrameworkSQLiteStatement) obj).close();
                    this.isClosed = true;
                    break;
                case 1:
                    ((RowSQLiteStatement) obj).close();
                    break;
                default:
                    this.isClosed = true;
                    break;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean getBoolean() {
            switch (this.$r8$classId) {
                case 1:
                    return ((RowSQLiteStatement) this.delegate).getBoolean();
                default:
                    return super.getBoolean();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final int getColumnCount() {
            switch (this.$r8$classId) {
                case 0:
                    throwIfClosed();
                    return 0;
                case 1:
                    return ((RowSQLiteStatement) this.delegate).getColumnCount();
                default:
                    throwIfClosed();
                    return 0;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final String getColumnName(int i) {
            switch (this.$r8$classId) {
                case 0:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
                case 1:
                    return ((RowSQLiteStatement) this.delegate).getColumnName(i);
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final double getDouble(int i) {
            switch (this.$r8$classId) {
                case 0:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
                case 1:
                    return ((RowSQLiteStatement) this.delegate).getDouble(i);
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final long getLong(int i) {
            switch (this.$r8$classId) {
                case 0:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
                case 1:
                    return ((RowSQLiteStatement) this.delegate).getLong(i);
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final String getText(int i) {
            switch (this.$r8$classId) {
                case 0:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
                case 1:
                    return ((RowSQLiteStatement) this.delegate).getText(i);
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final boolean isNull(int i) {
            switch (this.$r8$classId) {
                case 0:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
                case 1:
                    return ((RowSQLiteStatement) this.delegate).isNull(i);
                default:
                    throwIfClosed();
                    SQLite.throwSQLiteException(21, "no row");
                    throw null;
            }
        }

        @Override // androidx.sqlite.driver.SupportSQLiteStatement, androidx.sqlite.SQLiteStatement
        public void reset() {
            switch (this.$r8$classId) {
                case 1:
                    ((RowSQLiteStatement) this.delegate).reset();
                    break;
                default:
                    super.reset();
                    break;
            }
        }

        /* JADX WARN: Code duplicated, block: B:22:0x005f  */
        @Override // androidx.sqlite.SQLiteStatement
        public final boolean step() throws IllegalAccessException, InvocationTargetException {
            byte b = this.$r8$classId;
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.db;
            Object obj = this.delegate;
            switch (b) {
                case 0:
                    throwIfClosed();
                    ((FrameworkSQLiteStatement) obj).delegate.execute();
                    return false;
                case 1:
                    RowSQLiteStatement rowSQLiteStatement = (RowSQLiteStatement) obj;
                    boolean zStep = rowSQLiteStatement.step();
                    if (rowSQLiteStatement.getText(0).equalsIgnoreCase("wal")) {
                        frameworkSQLiteDatabase.delegate.enableWriteAheadLogging();
                    } else {
                        frameworkSQLiteDatabase.delegate.disableWriteAheadLogging();
                    }
                    return zStep;
                default:
                    int iOrdinal = ((SupportSQLiteStatement$Companion$TransactionOperation) obj).ordinal();
                    if (iOrdinal == 0) {
                        frameworkSQLiteDatabase.setTransactionSuccessful();
                        frameworkSQLiteDatabase.endTransaction();
                    } else if (iOrdinal == 1) {
                        frameworkSQLiteDatabase.endTransaction();
                    } else if (iOrdinal == 2) {
                        frameworkSQLiteDatabase.beginTransaction();
                    } else if (iOrdinal == 3) {
                        frameworkSQLiteDatabase.beginTransactionNonExclusive();
                    } else if (iOrdinal == 4) {
                        SQLiteDatabase sQLiteDatabase = frameworkSQLiteDatabase.delegate;
                        Lazy lazy = FrameworkSQLiteDatabase.beginTransactionMethod$delegate;
                        if (((Method) lazy.getValue()) != null) {
                            Lazy lazy2 = FrameworkSQLiteDatabase.getThreadSessionMethod$delegate;
                            if (((Method) lazy2.getValue()) != null) {
                                Method method = (Method) lazy.getValue();
                                method.getClass();
                                Method method2 = (Method) lazy2.getValue();
                                method2.getClass();
                                Object objInvoke = method2.invoke(sQLiteDatabase, null);
                                if (objInvoke != null) {
                                    method.invoke(objInvoke, 0, null, 0, null);
                                } else {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
                                }
                            } else {
                                frameworkSQLiteDatabase.beginTransaction();
                            }
                        } else {
                            frameworkSQLiteDatabase.beginTransaction();
                        }
                    } else {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                    }
                    return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OtherSQLiteStatement(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, SupportSQLiteStatement$Companion$TransactionOperation supportSQLiteStatement$Companion$TransactionOperation) {
            super(frameworkSQLiteDatabase, str);
            frameworkSQLiteDatabase.getClass();
            str.getClass();
            this.delegate = supportSQLiteStatement$Companion$TransactionOperation;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OtherSQLiteStatement(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, RowSQLiteStatement rowSQLiteStatement) {
            super(frameworkSQLiteDatabase, str);
            frameworkSQLiteDatabase.getClass();
            str.getClass();
            this.delegate = rowSQLiteStatement;
        }
    }
}
