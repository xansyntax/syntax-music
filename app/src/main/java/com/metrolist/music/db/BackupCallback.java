package com.metrolist.music.db;

import android.content.Context;
import androidx.media3.decoder.Buffer;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackupCallback extends Buffer {
    public final Context context;
    public final String dbName;
    public final Buffer delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupCallback(Context context, Buffer buffer, String str) {
        super((byte) 2, buffer.flags);
        buffer.getClass();
        this.context = context;
        this.delegate = buffer;
        this.dbName = str;
    }

    @Override // androidx.media3.decoder.Buffer
    public final void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        MusicDatabaseKt.applyPragmaSettings(frameworkSQLiteDatabase);
        this.delegate.onCreate(frameworkSQLiteDatabase);
    }

    @Override // androidx.media3.decoder.Buffer
    public final void onDowngrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i, int i2) {
        Timber.Forest.tag("DatabaseBackup");
        ConnectionPool.i(new Object[0]);
        MusicDatabaseKt.backupDatabase(this.context, this.dbName);
        this.delegate.onDowngrade(frameworkSQLiteDatabase, i, i2);
    }

    @Override // androidx.media3.decoder.Buffer
    public final void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        MusicDatabaseKt.applyPragmaSettings(frameworkSQLiteDatabase);
        this.delegate.onOpen(frameworkSQLiteDatabase);
    }

    @Override // androidx.media3.decoder.Buffer
    public final void onUpgrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i, int i2) {
        Timber.Forest.tag("DatabaseBackup");
        ConnectionPool.i(new Object[0]);
        MusicDatabaseKt.backupDatabase(this.context, this.dbName);
        this.delegate.onUpgrade(frameworkSQLiteDatabase, i, i2);
    }
}
