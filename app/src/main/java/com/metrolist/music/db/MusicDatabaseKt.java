package com.metrolist.music.db;

import android.content.Context;
import android.database.Cursor;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import dagger.hilt.EntryPoints;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MusicDatabaseKt {
    public static final MusicDatabaseKt$MIGRATION_1_2$1 MIGRATION_1_2 = new MusicDatabaseKt$MIGRATION_1_2$1(1, 2, 0);
    public static final MusicDatabaseKt$MIGRATION_1_2$1 MIGRATION_21_24;
    public static final MusicDatabaseKt$MIGRATION_1_2$1 MIGRATION_22_24;
    public static final MusicDatabaseKt$MIGRATION_1_2$1 MIGRATION_24_25;

    static {
        byte b = 21;
        int i = 24;
        MIGRATION_21_24 = new MusicDatabaseKt$MIGRATION_1_2$1(b, i, (byte) 20);
        MIGRATION_22_24 = new MusicDatabaseKt$MIGRATION_1_2$1(22, i, b);
        MIGRATION_24_25 = new MusicDatabaseKt$MIGRATION_1_2$1(i, 25, (byte) 22);
    }

    public static final void addColumnIfMissing(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, String str2, String str3) throws IOException {
        boolean z;
        Cursor cursorQuery = frameworkSQLiteDatabase.query("PRAGMA table_info('" + str + "')");
        try {
            int columnIndex = cursorQuery.getColumnIndex(ContentDisposition.Parameters.Name);
            while (true) {
                if (!cursorQuery.moveToNext()) {
                    z = false;
                    break;
                } else if (columnIndex >= 0 && Intrinsics.areEqual(cursorQuery.getString(columnIndex), str2)) {
                    z = true;
                    break;
                }
            }
            cursorQuery.close();
            if (z) {
                return;
            }
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ALTER TABLE `", str, "` ADD COLUMN `", str2, "` ");
            sbM.append(str3);
            frameworkSQLiteDatabase.execSQL(sbM.toString());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    public static final void addVersion24ColumnsIfMissing(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException {
        addColumnIfMissing(frameworkSQLiteDatabase, "song", "libraryAddToken", "TEXT");
        addColumnIfMissing(frameworkSQLiteDatabase, "song", "libraryRemoveToken", "TEXT");
        addColumnIfMissing(frameworkSQLiteDatabase, "song", "romanizeLyrics", "INTEGER NOT NULL DEFAULT true");
        addColumnIfMissing(frameworkSQLiteDatabase, "song", "isDownloaded", "INTEGER NOT NULL DEFAULT 0");
        addColumnIfMissing(frameworkSQLiteDatabase, "song", "isUploaded", "INTEGER NOT NULL DEFAULT false");
        addColumnIfMissing(frameworkSQLiteDatabase, "album", "isUploaded", "INTEGER NOT NULL DEFAULT false");
        addColumnIfMissing(frameworkSQLiteDatabase, "playlist", "thumbnailUrl", "TEXT");
    }

    public static final void applyPragmaSettings(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        try {
            frameworkSQLiteDatabase.query("PRAGMA busy_timeout = 60000").close();
            frameworkSQLiteDatabase.query("PRAGMA cache_size = -16000").close();
            frameworkSQLiteDatabase.query("PRAGMA wal_autocheckpoint = 1000").close();
            frameworkSQLiteDatabase.query("PRAGMA synchronous = NORMAL").close();
        } catch (Exception unused) {
            Timber.Forest.tag("MusicDatabase");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public static final void backupDatabase(Context context, String str) {
        File databasePath = context.getDatabasePath(str);
        if (databasePath.exists()) {
            String str2 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US).format(new Date());
            File file = new File(context.getFilesDir(), "database_backups");
            file.mkdirs();
            File file2 = new File(file, IntIntPair$$ExternalSyntheticOutline0.m(str, "_backup_", str2));
            boolean zBackupDatabase$copyFile = backupDatabase$copyFile(databasePath, new File(file2 + ".db"));
            if (zBackupDatabase$copyFile) {
                File file3 = new File(databasePath.getAbsolutePath() + "-wal");
                if (!file3.exists()) {
                    file3 = null;
                }
                if (file3 != null) {
                    backupDatabase$copyFile(file3, new File(file2 + ".db-wal"));
                }
                File file4 = new File(databasePath.getAbsolutePath() + "-shm");
                File file5 = file4.exists() ? file4 : null;
                if (file5 != null) {
                    backupDatabase$copyFile(file5, new File(file2 + ".db-shm"));
                }
                Timber.Forest.tag("DatabaseBackup");
                file2.toString();
                ConnectionPool.i(new Object[0]);
            }
            if (zBackupDatabase$copyFile) {
                new File(file2 + ".db");
            }
        }
    }

    public static final boolean backupDatabase$copyFile(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    EntryPoints.copyTo(fileInputStream, fileOutputStream);
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CharsKt.closeFinally(fileInputStream, th3);
                    throw th4;
                }
            }
        } catch (Exception unused) {
            Timber.Forest.tag("DatabaseBackup");
            file.getName();
            ConnectionPool.e$1(new Object[0]);
            return false;
        }
    }
}
