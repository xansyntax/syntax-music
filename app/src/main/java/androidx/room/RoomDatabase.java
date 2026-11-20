package androidx.room;

import android.os.Looper;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.db.MusicDatabaseKt;
import com.metrolist.music.utils.SyncUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    public boolean allowMainThreadQueries;
    public FileMetadata connectionManager;
    public ContextScope coroutineScope;
    public Executor internalQueryExecutor;
    public InvalidationTracker internalTracker;
    public TransactionExecutor internalTransactionExecutor;
    public CoroutineContext transactionContext;
    public final Dispatcher closeBarrier = new Dispatcher(new RoomDatabase$closeBarrier$1(0, this, RoomDatabase.class, "onClosed", "onClosed()V", 0, 0));
    public final ThreadLocal suspendingTransactionContext = new ThreadLocal();
    public final LinkedHashMap typeConverters = new LinkedHashMap();
    public boolean useTempTrackingTable = true;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Callback {
        public void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            frameworkSQLiteDatabase.getClass();
        }

        public void onDestructiveMigration(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            frameworkSQLiteDatabase.getClass();
        }

        public void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            frameworkSQLiteDatabase.getClass();
            MusicDatabaseKt.applyPragmaSettings(frameworkSQLiteDatabase);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class JournalMode {
        public static final /* synthetic */ JournalMode[] $VALUES;
        public static final JournalMode WRITE_AHEAD_LOGGING;

        /* JADX INFO: Fake field, exist only in values array */
        JournalMode EF0;

        static {
            JournalMode journalMode = new JournalMode("AUTOMATIC", 0);
            JournalMode journalMode2 = new JournalMode("TRUNCATE", 1);
            JournalMode journalMode3 = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            WRITE_AHEAD_LOGGING = journalMode3;
            $VALUES = new JournalMode[]{journalMode, journalMode2, journalMode3};
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }
    }

    public final void assertNotMainThread() {
        if (this.allowMainThreadQueries) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void beginTransaction() {
        assertNotMainThread();
        assertNotMainThread();
        FrameworkSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        if (!writableDatabase.inTransaction()) {
            UtilsKt.runBlockingUninterruptible(new SyncUtils.AnonymousClass2(getInvalidationTracker(), null, (byte) 16));
        }
        if (writableDatabase.delegate.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    public List createAutoMigrations(LinkedHashMap linkedHashMap) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(Okio__OkioKt.getJavaClass((KClass) entry.getKey()), entry.getValue());
        }
        return EmptyList.INSTANCE;
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public RoomOpenDelegate createOpenDelegate() {
        throw new NotImplementedError(0);
    }

    public final InvalidationTracker getInvalidationTracker() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalTracker");
        throw null;
    }

    public final SupportSQLiteOpenHelper getOpenHelper() {
        FileMetadata fileMetadata = this.connectionManager;
        if (fileMetadata == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            throw null;
        }
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = (SupportSQLiteOpenHelper) fileMetadata.lastAccessedAtMillis;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
        return null;
    }

    public Set getRequiredAutoMigrationSpecClasses() {
        return CollectionsKt.toSet(new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(EmptySet.INSTANCE, 10)));
    }

    public LinkedHashMap getRequiredTypeConverterClasses() {
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(EmptySet.INSTANCE, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        return new LinkedHashMap(iMapCapacity);
    }

    public final boolean inCompatibilityMode() {
        FileMetadata fileMetadata = this.connectionManager;
        if (fileMetadata != null) {
            return ((SupportSQLiteOpenHelper) fileMetadata.lastAccessedAtMillis) != null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
        throw null;
    }

    public final boolean inTransaction() {
        return isOpenInternal$room_runtime() && getOpenHelper().getWritableDatabase().inTransaction();
    }

    public final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        InvalidationTracker invalidationTracker = getInvalidationTracker();
        invalidationTracker.implementation.refreshInvalidationAsync$room_runtime(invalidationTracker.onRefreshScheduled, invalidationTracker.onRefreshCompleted);
    }

    public final boolean isOpenInternal$room_runtime() {
        FileMetadata fileMetadata = this.connectionManager;
        if (fileMetadata == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            throw null;
        }
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) fileMetadata.extras;
        if (frameworkSQLiteDatabase != null) {
            return frameworkSQLiteDatabase.isOpen();
        }
        return false;
    }

    public final Object useConnection(boolean z, Function2 function2, ContinuationImpl continuationImpl) {
        IntMath.throwIfClosed(this);
        FileMetadata fileMetadata = this.connectionManager;
        if (fileMetadata != null) {
            return ((ConnectionPool) fileMetadata.lastModifiedAtMillis).useConnection(z, function2, continuationImpl);
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
        throw null;
    }
}
