package com.metrolist.music.db;

import android.database.Cursor;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.SQLite;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoZonedDateTime;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Converters implements AutoMigrationSpec {
    public final /* synthetic */ byte $r8$classId;

    public static Long dateToTimestamp(LocalDateTime localDateTime) {
        ChronoZonedDateTime<LocalDate> chronoZonedDateTimeAtZone;
        Instant instant;
        if (localDateTime == null || (chronoZonedDateTimeAtZone = localDateTime.atZone((ZoneId) ZoneOffset.UTC)) == null || (instant = chronoZonedDateTimeAtZone.toInstant()) == null) {
            return null;
        }
        return Long.valueOf(instant.toEpochMilli());
    }

    public static LocalDateTime fromTimestamp(Long l) {
        if (l != null) {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(l.longValue()), ZoneOffset.UTC);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0162  */
    /* JADX WARN: Code duplicated, block: B:234:? A[RETURN, SYNTHETIC] */
    @Override // androidx.room.migration.AutoMigrationSpec
    public void onPostMigrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException {
        ChronoZonedDateTime<LocalDate> chronoZonedDateTimeAtZone;
        Instant instant;
        ChronoZonedDateTime<LocalDate> chronoZonedDateTimeAtZone2;
        Instant instant2;
        boolean z;
        Long lValueOf = null;
        boolean z2 = true;
        boolean z3 = false;
        switch (this.$r8$classId) {
            case 1:
                frameworkSQLiteDatabase.getClass();
                frameworkSQLiteDatabase.execSQL("UPDATE album SET bookmarkedAt = lastUpdateTime");
                Cursor cursorQuery = frameworkSQLiteDatabase.query("SELECT DISTINCT albumId, albumName FROM song");
                while (cursorQuery.moveToNext()) {
                    try {
                        frameworkSQLiteDatabase.insert("album", 4, SQLite.contentValuesOf(new Pair("id", cursorQuery.getString(0)), new Pair(LinkHeader.Parameters.Title, cursorQuery.getString(1)), new Pair("songCount", 0), new Pair("duration", 0), new Pair("lastUpdateTime", 0)));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CharsKt.closeFinally(cursorQuery, th);
                            throw th2;
                        }
                    }
                }
                cursorQuery.close();
                frameworkSQLiteDatabase.query("CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                return;
            case 2:
                frameworkSQLiteDatabase.getClass();
                return;
            case 3:
                frameworkSQLiteDatabase.getClass();
                LocalDateTime localDateTimeNow = LocalDateTime.now();
                frameworkSQLiteDatabase.execSQL("UPDATE playlist SET createdAt = '" + ((localDateTimeNow == null || (chronoZonedDateTimeAtZone2 = localDateTimeNow.atZone((ZoneId) ZoneOffset.UTC)) == null || (instant2 = chronoZonedDateTimeAtZone2.toInstant()) == null) ? null : Long.valueOf(instant2.toEpochMilli())) + "'");
                LocalDateTime localDateTimeNow2 = LocalDateTime.now();
                if (localDateTimeNow2 != null && (chronoZonedDateTimeAtZone = localDateTimeNow2.atZone((ZoneId) ZoneOffset.UTC)) != null && (instant = chronoZonedDateTimeAtZone.toInstant()) != null) {
                    lValueOf = Long.valueOf(instant.toEpochMilli());
                }
                frameworkSQLiteDatabase.execSQL("UPDATE playlist SET lastUpdateTime = '" + lValueOf + "'");
                return;
            case 4:
                frameworkSQLiteDatabase.getClass();
                frameworkSQLiteDatabase.execSQL("UPDATE playlist SET bookmarkedAt = lastUpdateTime");
                frameworkSQLiteDatabase.execSQL("UPDATE playlist SET isEditable = 1 WHERE browseId IS NOT NULL");
                return;
            case 5:
                frameworkSQLiteDatabase.getClass();
                frameworkSQLiteDatabase.execSQL("UPDATE song SET explicit = 0 WHERE explicit IS NULL");
                return;
            case 6:
                frameworkSQLiteDatabase.getClass();
                frameworkSQLiteDatabase.execSQL("UPDATE song SET explicit = 0 WHERE explicit IS NULL");
                return;
            case 7:
                frameworkSQLiteDatabase.getClass();
                try {
                    frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN libraryAddToken TEXT DEFAULT ''");
                } catch (Exception unused) {
                    Timber.Forest.tag("Migration21To22");
                    ConnectionPool.w$1(new Object[0]);
                }
                try {
                    frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN libraryRemoveToken TEXT DEFAULT ''");
                } catch (Exception unused2) {
                    Timber.Forest.tag("Migration21To22");
                    ConnectionPool.w$1(new Object[0]);
                }
                try {
                    frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN romanizeLyrics INTEGER NOT NULL DEFAULT 1");
                } catch (Exception unused3) {
                    Timber.Forest.tag("Migration21To22");
                    ConnectionPool.w$1(new Object[0]);
                }
                try {
                    frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN isDownloaded INTEGER NOT NULL DEFAULT 0");
                    return;
                } catch (Exception unused4) {
                    Timber.Forest.tag("Migration21To22");
                    ConnectionPool.w$1(new Object[0]);
                    return;
                }
            case 8:
                frameworkSQLiteDatabase.getClass();
                return;
            case 9:
                frameworkSQLiteDatabase.getClass();
                MusicDatabaseKt.addVersion24ColumnsIfMissing(frameworkSQLiteDatabase);
                return;
            case 10:
                frameworkSQLiteDatabase.getClass();
                Cursor cursorQuery2 = frameworkSQLiteDatabase.query("PRAGMA table_info('song')");
                try {
                    int columnIndex = cursorQuery2.getColumnIndex(ContentDisposition.Parameters.Name);
                    while (true) {
                        if (!cursorQuery2.moveToNext()) {
                            z = false;
                        } else if (Intrinsics.areEqual(columnIndex >= 0 ? cursorQuery2.getString(columnIndex) : null, "isVideo")) {
                            z = true;
                        }
                    }
                    cursorQuery2.close();
                    if (!z) {
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN isVideo INTEGER NOT NULL DEFAULT 0");
                    }
                    Cursor cursorQuery3 = frameworkSQLiteDatabase.query("PRAGMA table_info('lyrics')");
                    try {
                        int columnIndex2 = cursorQuery3.getColumnIndex(ContentDisposition.Parameters.Name);
                        do {
                            if (!cursorQuery3.moveToNext()) {
                                z2 = false;
                            }
                            cursorQuery3.close();
                            if (z2) {
                                return;
                            }
                            frameworkSQLiteDatabase.execSQL("ALTER TABLE lyrics ADD COLUMN provider TEXT NOT NULL DEFAULT 'Unknown'");
                            return;
                        } while (!Intrinsics.areEqual(columnIndex2 >= 0 ? cursorQuery3.getString(columnIndex2) : null, "provider"));
                        cursorQuery3.close();
                        if (z2) {
                            frameworkSQLiteDatabase.execSQL("ALTER TABLE lyrics ADD COLUMN provider TEXT NOT NULL DEFAULT 'Unknown'");
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CharsKt.closeFinally(cursorQuery3, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        CharsKt.closeFinally(cursorQuery2, th5);
                        throw th6;
                    }
                }
            case 11:
                frameworkSQLiteDatabase.getClass();
                Cursor cursorQuery4 = frameworkSQLiteDatabase.query("PRAGMA table_info('song')");
                try {
                    int columnIndex3 = cursorQuery4.getColumnIndex(ContentDisposition.Parameters.Name);
                    boolean z4 = false;
                    boolean z5 = false;
                    while (cursorQuery4.moveToNext()) {
                        String string = columnIndex3 >= 0 ? cursorQuery4.getString(columnIndex3) : null;
                        if (string != null) {
                            int iHashCode = string.hashCode();
                            if (iHashCode != -694013204) {
                                if (iHashCode != -412055452) {
                                    if (iHashCode == 1659462015 && string.equals("uploadEntityId")) {
                                        z4 = true;
                                    }
                                } else if (string.equals("playbackPosition")) {
                                    z3 = true;
                                }
                            } else if (string.equals("isCached")) {
                                z5 = true;
                            }
                        }
                        break;
                    }
                    cursorQuery4.close();
                    if (!z3) {
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN playbackPosition INTEGER DEFAULT NULL");
                    }
                    if (!z4) {
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN uploadEntityId TEXT DEFAULT NULL");
                    }
                    if (z5) {
                        return;
                    }
                    frameworkSQLiteDatabase.execSQL("ALTER TABLE song ADD COLUMN isCached INTEGER NOT NULL DEFAULT 0");
                    return;
                } catch (Throwable th7) {
                    try {
                        throw th7;
                    } catch (Throwable th8) {
                        CharsKt.closeFinally(cursorQuery4, th7);
                        throw th8;
                    }
                }
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                frameworkSQLiteDatabase.getClass();
                Cursor cursorQuery5 = frameworkSQLiteDatabase.query("SELECT id FROM playlist WHERE id NOT LIKE 'LP%'");
                while (cursorQuery5.moveToNext()) {
                    try {
                        frameworkSQLiteDatabase.execSQL("UPDATE playlist SET browseId = '" + cursorQuery5.getString(0) + "' WHERE id = '" + cursorQuery5.getString(0) + "'");
                    } catch (Throwable th9) {
                        try {
                            throw th9;
                        } catch (Throwable th10) {
                            CharsKt.closeFinally(cursorQuery5, th9);
                            throw th10;
                        }
                    }
                }
                cursorQuery5.close();
                return;
            default:
                frameworkSQLiteDatabase.getClass();
                Cursor cursorQuery6 = frameworkSQLiteDatabase.query("SELECT id, createDate FROM song");
                while (cursorQuery6.moveToNext()) {
                    try {
                        frameworkSQLiteDatabase.execSQL("UPDATE song SET inLibrary = " + cursorQuery6.getLong(1) + " WHERE id = '" + cursorQuery6.getString(0) + "'");
                    } catch (Throwable th11) {
                        try {
                            throw th11;
                        } catch (Throwable th12) {
                            CharsKt.closeFinally(cursorQuery6, th11);
                            throw th12;
                        }
                    }
                }
                cursorQuery6.close();
                return;
        }
    }
}
