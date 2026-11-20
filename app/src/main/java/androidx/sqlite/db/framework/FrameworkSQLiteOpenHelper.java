package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.media3.decoder.Buffer;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.SynchronizedLazyImpl;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final Buffer callback;
    public final Context context;
    public final SynchronizedLazyImpl lazyDelegate;
    public final String name;
    public boolean writeAheadLoggingEnabled;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OpenHelper extends SQLiteOpenHelper {
        public static final /* synthetic */ int $r8$clinit = 0;
        public final Buffer callback;
        public final Context context;
        public final ConnectionPool dbRef;
        public final ProcessLock lock;
        public boolean migrated;
        public boolean opened;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class CallbackException extends RuntimeException {
            public final CallbackName callbackName;
            public final Throwable cause;

            public CallbackException(CallbackName callbackName, Throwable th) {
                super(th);
                this.callbackName = callbackName;
                this.cause = th;
            }

            @Override // java.lang.Throwable
            public final Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class CallbackName {
            public static final /* synthetic */ CallbackName[] $VALUES;
            public static final CallbackName ON_CONFIGURE;
            public static final CallbackName ON_CREATE;
            public static final CallbackName ON_DOWNGRADE;
            public static final CallbackName ON_OPEN;
            public static final CallbackName ON_UPGRADE;

            static {
                CallbackName callbackName = new CallbackName("ON_CONFIGURE", 0);
                ON_CONFIGURE = callbackName;
                CallbackName callbackName2 = new CallbackName("ON_CREATE", 1);
                ON_CREATE = callbackName2;
                CallbackName callbackName3 = new CallbackName("ON_UPGRADE", 2);
                ON_UPGRADE = callbackName3;
                CallbackName callbackName4 = new CallbackName("ON_DOWNGRADE", 3);
                ON_DOWNGRADE = callbackName4;
                CallbackName callbackName5 = new CallbackName("ON_OPEN", 4);
                ON_OPEN = callbackName5;
                $VALUES = new CallbackName[]{callbackName, callbackName2, callbackName3, callbackName4, callbackName5};
            }

            public static CallbackName valueOf(String str) {
                return (CallbackName) Enum.valueOf(CallbackName.class, str);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final ConnectionPool connectionPool, final Buffer buffer) {
            String string;
            super(context, str, null, buffer.flags, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    int i = FrameworkSQLiteOpenHelper.OpenHelper.$r8$clinit;
                    sQLiteDatabase.getClass();
                    ConnectionPool connectionPool2 = connectionPool;
                    FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) connectionPool2.delegate;
                    if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.delegate.equals(sQLiteDatabase)) {
                        frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                        connectionPool2.delegate = frameworkSQLiteDatabase;
                    }
                    SQLiteDatabase sQLiteDatabase2 = frameworkSQLiteDatabase.delegate;
                    buffer.getClass();
                    Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + frameworkSQLiteDatabase + ".path");
                    if (!sQLiteDatabase2.isOpen()) {
                        String path = sQLiteDatabase2.getPath();
                        if (path != null) {
                            Buffer.deleteDatabaseFile(path);
                            return;
                        }
                        return;
                    }
                    List<Pair<String, String>> attachedDbs = null;
                    try {
                        try {
                            attachedDbs = sQLiteDatabase2.getAttachedDbs();
                        } finally {
                            if (attachedDbs != null) {
                                Iterator<T> it = attachedDbs.iterator();
                                while (it.hasNext()) {
                                    Object obj = ((Pair) it.next()).second;
                                    obj.getClass();
                                    Buffer.deleteDatabaseFile((String) obj);
                                }
                            } else {
                                String path2 = sQLiteDatabase2.getPath();
                                if (path2 != null) {
                                    Buffer.deleteDatabaseFile(path2);
                                }
                            }
                        }
                    } catch (SQLiteException unused) {
                    }
                    try {
                        frameworkSQLiteDatabase.close();
                    } catch (IOException unused2) {
                    }
                    if (attachedDbs != null) {
                        return;
                    }
                }
            });
            context.getClass();
            buffer.getClass();
            this.context = context;
            this.dbRef = connectionPool;
            this.callback = buffer;
            if (str == null) {
                string = UUID.randomUUID().toString();
                string.getClass();
            } else {
                string = str;
            }
            this.lock = new ProcessLock(string, context.getCacheDir(), false);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final void close() {
            ProcessLock processLock = this.lock;
            try {
                processLock.lock(processLock.processLock);
                super.close();
                this.dbRef.delegate = null;
                this.opened = false;
            } finally {
                processLock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getSupportDatabase(boolean z) {
            ProcessLock processLock = this.lock;
            try {
                processLock.lock((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase sQLiteDatabaseInnerGetDatabase = innerGetDatabase(z);
                if (!this.migrated) {
                    return getWrappedDb(sQLiteDatabaseInnerGetDatabase);
                }
                close();
                return getSupportDatabase(z);
            } finally {
                processLock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            ConnectionPool connectionPool = this.dbRef;
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) connectionPool.delegate;
            if (frameworkSQLiteDatabase != null && frameworkSQLiteDatabase.delegate.equals(sQLiteDatabase)) {
                return frameworkSQLiteDatabase;
            }
            FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = new FrameworkSQLiteDatabase(sQLiteDatabase);
            connectionPool.delegate = frameworkSQLiteDatabase2;
            return frameworkSQLiteDatabase2;
        }

        public final SQLiteDatabase innerGetDatabase(boolean z) throws Throwable {
            SQLiteDatabase readableDatabase;
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z2 = this.opened;
            if (databaseName != null && !z2 && (parentFile = this.context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                if (z) {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.getClass();
                    return writableDatabase;
                }
                SQLiteDatabase readableDatabase2 = getReadableDatabase();
                readableDatabase2.getClass();
                return readableDatabase2;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    if (z) {
                        readableDatabase = getWritableDatabase();
                        readableDatabase.getClass();
                    } else {
                        readableDatabase = getReadableDatabase();
                        readableDatabase.getClass();
                    }
                    return readableDatabase;
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = (CallbackException) th;
                        int iOrdinal = callbackException.callbackName.ordinal();
                        th = callbackException.cause;
                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                            throw th;
                        }
                        if (iOrdinal != 4) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        if (!(th instanceof SQLiteException)) {
                            throw th;
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            boolean z = this.migrated;
            Buffer buffer = this.callback;
            if (!z && buffer.flags != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                getWrappedDb(sQLiteDatabase);
                buffer.getClass();
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.getClass();
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.getClass();
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, Buffer buffer, String str) {
        context.getClass();
        buffer.getClass();
        this.context = context;
        this.name = str;
        this.callback = buffer;
        this.lazyDelegate = new SynchronizedLazyImpl(new RoomDatabase$$ExternalSyntheticLambda0((byte) 28, this));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SynchronizedLazyImpl synchronizedLazyImpl = this.lazyDelegate;
        if (synchronizedLazyImpl.isInitialized()) {
            ((OpenHelper) synchronizedLazyImpl.getValue()).close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final FrameworkSQLiteDatabase getWritableDatabase() {
        return ((OpenHelper) this.lazyDelegate.getValue()).getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        SynchronizedLazyImpl synchronizedLazyImpl = this.lazyDelegate;
        if (synchronizedLazyImpl.isInitialized()) {
            ((OpenHelper) synchronizedLazyImpl.getValue()).setWriteAheadLoggingEnabled(z);
        }
        this.writeAheadLoggingEnabled = z;
    }
}
