package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import coil3.network.NetworkHeaders;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationForAllTables;
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List autoMigrationSpecs;
    public final List callbacks;
    public final Context context;
    public final RoomDatabase.JournalMode journalMode;
    public final NetworkHeaders.Builder migrationContainer;
    public final Set migrationNotRequiredFrom;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SQLiteDriver sqliteDriver;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List typeConverters;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, NetworkHeaders.Builder builder, List list, boolean z, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z2, boolean z3, Set set, String str2, File file, Callable callable, List list2, List list3, boolean z4, SQLiteDriver sQLiteDriver, CoroutineContext coroutineContext) {
        context.getClass();
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = builder;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
        this.migrationNotRequiredFrom = set;
        this.typeConverters = list2;
        this.autoMigrationSpecs = list3;
        this.allowDestructiveMigrationForAllTables = z4;
        this.sqliteDriver = sQLiteDriver;
    }
}
