package com.metrolist.music.db;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.room.InvalidationTracker;
import androidx.room.ObservedTableStates;
import androidx.room.RoomOpenDelegate;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.room.util.TableInfo;
import androidx.room.util.ViewInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.common.math.IntMath;
import com.metrolist.music.db.daos.SpeedDialDao_Impl;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/InternalDatabase_Impl;", "Lcom/metrolist/music/db/InternalDatabase;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class InternalDatabase_Impl extends InternalDatabase {
    public final SynchronizedLazyImpl _databaseDao;
    public final SynchronizedLazyImpl _speedDialDao;

    public InternalDatabase_Impl() {
        final byte b = 0;
        this._databaseDao = new SynchronizedLazyImpl(new Function0(this) { // from class: com.metrolist.music.db.InternalDatabase_Impl$$ExternalSyntheticLambda0
            public final /* synthetic */ InternalDatabase_Impl f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                InternalDatabase_Impl internalDatabase_Impl = this.f$0;
                switch (b2) {
                    case 0:
                        return new DatabaseDao_Impl(internalDatabase_Impl);
                    default:
                        return new SpeedDialDao_Impl(internalDatabase_Impl);
                }
            }
        });
        final byte b2 = 1;
        this._speedDialDao = new SynchronizedLazyImpl(new Function0(this) { // from class: com.metrolist.music.db.InternalDatabase_Impl$$ExternalSyntheticLambda0
            public final /* synthetic */ InternalDatabase_Impl f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                InternalDatabase_Impl internalDatabase_Impl = this.f$0;
                switch (b3) {
                    case 0:
                        return new DatabaseDao_Impl(internalDatabase_Impl);
                    default:
                        return new SpeedDialDao_Impl(internalDatabase_Impl);
                }
            }
        });
    }

    @Override // androidx.room.RoomDatabase
    public final List createAutoMigrations(LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        int i = 3;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(2, i, (byte) 9));
        int i2 = 4;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i, i2, (byte) 17));
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i2, 5, (byte) 18));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 0));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 14));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 15));
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(8, 9, (byte) 19));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 16));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 1));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 2));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 3));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 4));
        int i3 = 15;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(14, i3, (byte) 1));
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i3, 16, (byte) 2));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 5));
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(17, 18, (byte) 3));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 6));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 7));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 8));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 9));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 10));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 11));
        int i4 = 25;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(24, i4, (byte) 4));
        int i5 = 26;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i4, i5, (byte) 5));
        int i6 = 27;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i5, i6, (byte) 6));
        int i7 = 28;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i6, i7, (byte) 7));
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i7, 29, (byte) 8));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 12));
        int i8 = 31;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(30, i8, (byte) 10));
        int i9 = 32;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i8, i9, (byte) 11));
        int i10 = 33;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i9, i10, (byte) 12));
        int i11 = 34;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i10, i11, (byte) 13));
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i11, 35, (byte) 14));
        arrayList.add(new InternalDatabase_AutoMigration_5_6_Impl((byte) 13));
        int i12 = 37;
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(36, i12, (byte) 15));
        arrayList.add(new MusicDatabaseKt$MIGRATION_1_2$1(i12, 38, (byte) 16));
        return arrayList;
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("song_artist_map");
        linkedHashMap2.put("sorted_song_artist_map", linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add("song_album_map");
        linkedHashMap2.put("sorted_song_album_map", linkedHashSet2);
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        linkedHashSet3.add("playlist_song_map");
        linkedHashMap2.put("playlist_song_map_preview", linkedHashSet3);
        return new InvalidationTracker(this, linkedHashMap, linkedHashMap2, "song", "artist", "album", "playlist", "song_artist_map", "song_album_map", "album_artist_map", "playlist_song_map", "search_history", "format", "lyrics", "event", "related_song_map", "set_video_id", "playCount", "recognition_history", "speed_dial_item", "podcast");
    }

    @Override // androidx.room.RoomDatabase
    public final RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.metrolist.music.db.InternalDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(38, "bcf76ed36a3cb785f239e5cfbd28440e", "2b16d40726612dcc5e203dca5ad16b2f");
            }

            @Override // androidx.room.RoomOpenDelegate
            public final void createAllTables(SQLiteConnection sQLiteConnection) {
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "CREATE TABLE IF NOT EXISTS `song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `explicit` INTEGER NOT NULL DEFAULT 0, `year` INTEGER, `date` INTEGER, `dateModified` INTEGER, `liked` INTEGER NOT NULL, `likedDate` INTEGER, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, `dateDownload` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, `libraryAddToken` TEXT, `libraryRemoveToken` TEXT, `lyricsOffset` INTEGER NOT NULL DEFAULT 0, `romanizeLyrics` INTEGER NOT NULL DEFAULT true, `isDownloaded` INTEGER NOT NULL DEFAULT 0, `isUploaded` INTEGER NOT NULL DEFAULT false, `isVideo` INTEGER NOT NULL DEFAULT false, `isEpisode` INTEGER NOT NULL DEFAULT false, `playbackPosition` INTEGER DEFAULT NULL, `uploadEntityId` TEXT DEFAULT NULL, `isCached` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`id`))", sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `artist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `thumbnailUrl` TEXT, `channelId` TEXT, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, `isPodcastChannel` INTEGER NOT NULL DEFAULT false, `cachedPageJson` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `album` (`id` TEXT NOT NULL, `playlistId` TEXT, `title` TEXT NOT NULL, `year` INTEGER, `thumbnailUrl` TEXT, `themeColor` INTEGER, `songCount` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `explicit` INTEGER NOT NULL DEFAULT 0, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `likedDate` INTEGER, `inLibrary` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, `isUploaded` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `playlist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `browseId` TEXT, `createdAt` INTEGER, `lastUpdateTime` INTEGER, `isEditable` INTEGER NOT NULL DEFAULT true, `bookmarkedAt` INTEGER, `remoteSongCount` INTEGER, `playEndpointParams` TEXT, `thumbnailUrl` TEXT, `shuffleEndpointParams` TEXT, `radioEndpointParams` TEXT, `isLocal` INTEGER NOT NULL DEFAULT false, `isAutoSync` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `song_artist_map` (`songId` TEXT NOT NULL, `artistId` TEXT NOT NULL, `position` INTEGER NOT NULL, PRIMARY KEY(`songId`, `artistId`), FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`artistId`) REFERENCES `artist`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_artist_map_songId` ON `song_artist_map` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_artist_map_artistId` ON `song_artist_map` (`artistId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `song_album_map` (`songId` TEXT NOT NULL, `albumId` TEXT NOT NULL, `index` INTEGER NOT NULL, PRIMARY KEY(`songId`, `albumId`), FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`albumId`) REFERENCES `album`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_album_map_songId` ON `song_album_map` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_album_map_albumId` ON `song_album_map` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `album_artist_map` (`albumId` TEXT NOT NULL, `artistId` TEXT NOT NULL, `order` INTEGER NOT NULL, PRIMARY KEY(`albumId`, `artistId`), FOREIGN KEY(`albumId`) REFERENCES `album`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`artistId`) REFERENCES `artist`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_album_artist_map_albumId` ON `album_artist_map` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_album_artist_map_artistId` ON `album_artist_map` (`artistId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `playlist_song_map` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playlistId` TEXT NOT NULL, `songId` TEXT NOT NULL, `position` INTEGER NOT NULL, `setVideoId` TEXT, FOREIGN KEY(`playlistId`) REFERENCES `playlist`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_playlist_song_map_playlistId` ON `playlist_song_map` (`playlistId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_playlist_song_map_songId` ON `playlist_song_map` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `search_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `query` TEXT NOT NULL)");
                SQLite.execSQL(sQLiteConnection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_search_history_query` ON `search_history` (`query`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `format` (`id` TEXT NOT NULL, `itag` INTEGER NOT NULL, `mimeType` TEXT NOT NULL, `codecs` TEXT NOT NULL, `bitrate` INTEGER NOT NULL, `sampleRate` INTEGER, `contentLength` INTEGER NOT NULL, `loudnessDb` REAL, `perceptualLoudnessDb` REAL, `playbackUrl` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `lyrics` (`id` TEXT NOT NULL, `lyrics` TEXT NOT NULL, `provider` TEXT NOT NULL DEFAULT 'Unknown', `translatedLyrics` TEXT NOT NULL DEFAULT '', `translationLanguage` TEXT NOT NULL DEFAULT '', `translationMode` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `event` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `songId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `playTime` INTEGER NOT NULL, FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_event_songId` ON `event` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `related_song_map` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `songId` TEXT NOT NULL, `relatedSongId` TEXT NOT NULL, FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`relatedSongId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_related_song_map_songId` ON `related_song_map` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_related_song_map_relatedSongId` ON `related_song_map` (`relatedSongId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `set_video_id` (`videoId` TEXT NOT NULL, `setVideoId` TEXT, PRIMARY KEY(`videoId`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `playCount` (`song` TEXT NOT NULL, `year` INTEGER NOT NULL, `month` INTEGER NOT NULL, `count` INTEGER NOT NULL, PRIMARY KEY(`song`, `year`, `month`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `recognition_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `trackId` TEXT NOT NULL, `title` TEXT NOT NULL, `artist` TEXT NOT NULL, `album` TEXT, `coverArtUrl` TEXT, `coverArtHqUrl` TEXT, `genre` TEXT, `releaseDate` TEXT, `label` TEXT, `shazamUrl` TEXT, `appleMusicUrl` TEXT, `spotifyUrl` TEXT, `isrc` TEXT, `youtubeVideoId` TEXT, `recognizedAt` INTEGER NOT NULL, `liked` INTEGER NOT NULL)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_recognition_history_trackId` ON `recognition_history` (`trackId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `speed_dial_item` (`id` TEXT NOT NULL, `secondaryId` TEXT, `title` TEXT NOT NULL, `subtitle` TEXT, `subtitleIds` TEXT, `thumbnailUrl` TEXT, `type` TEXT NOT NULL, `explicit` INTEGER NOT NULL, `createDate` INTEGER NOT NULL, `albumId` TEXT, `albumName` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `podcast` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `author` TEXT, `thumbnailUrl` TEXT, `channelId` TEXT, `bookmarkedAt` INTEGER, `lastUpdateTime` INTEGER NOT NULL, `libraryAddToken` TEXT, `libraryRemoveToken` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(sQLiteConnection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bcf76ed36a3cb785f239e5cfbd28440e')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public final void dropAllTables(SQLiteConnection sQLiteConnection) {
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP TABLE IF EXISTS `song`", sQLiteConnection, "DROP TABLE IF EXISTS `artist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `album`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `playlist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `song_artist_map`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `song_album_map`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `album_artist_map`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `playlist_song_map`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `search_history`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `format`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `lyrics`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `event`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `related_song_map`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `set_video_id`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `playCount`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `recognition_history`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `speed_dial_item`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `podcast`");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS `sorted_song_artist_map`");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS `sorted_song_album_map`");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS `playlist_song_map_preview`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public final void onCreate(SQLiteConnection sQLiteConnection) {
                sQLiteConnection.getClass();
            }

            @Override // androidx.room.RoomOpenDelegate
            public final void onOpen(SQLiteConnection sQLiteConnection) {
                sQLiteConnection.getClass();
                SQLite.execSQL(sQLiteConnection, "PRAGMA foreign_keys = ON");
                InvalidationTracker invalidationTracker = this.this$0.getInvalidationTracker();
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = invalidationTracker.implementation;
                triggerBasedInvalidationTracker.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA query_only");
                try {
                    sQLiteStatementPrepare.step();
                    boolean z = sQLiteStatementPrepare.getBoolean();
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                    if (!z) {
                        SQLite.execSQL(sQLiteConnection, "PRAGMA temp_store = MEMORY");
                        SQLite.execSQL(sQLiteConnection, "PRAGMA recursive_triggers = 1");
                        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS room_table_modification_log");
                        if (triggerBasedInvalidationTracker.useTempTable) {
                            SQLite.execSQL(sQLiteConnection, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                        } else {
                            SQLite.execSQL(sQLiteConnection, StringsKt__StringsJVMKt.replace("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", "", false));
                        }
                        ObservedTableStates observedTableStates = triggerBasedInvalidationTracker.observedTableStates;
                        ReentrantLock reentrantLock = observedTableStates.lock;
                        reentrantLock.lock();
                        try {
                            observedTableStates.needsSync = true;
                            reentrantLock.unlock();
                        } catch (Throwable th) {
                            reentrantLock.unlock();
                            throw th;
                        }
                    }
                    synchronized (invalidationTracker.trackerLock) {
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th2);
                        throw th3;
                    }
                }
            }

            @Override // androidx.room.RoomOpenDelegate
            public final void onPostMigrate(SQLiteConnection sQLiteConnection) {
                sQLiteConnection.getClass();
            }

            @Override // androidx.room.RoomOpenDelegate
            public final void onPreMigrate(SQLiteConnection sQLiteConnection) {
                sQLiteConnection.getClass();
                ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT name FROM sqlite_master WHERE type = 'trigger'");
                while (sQLiteStatementPrepare.step()) {
                    try {
                        listBuilderCreateListBuilder.add(sQLiteStatementPrepare.getText(0));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                            throw th2;
                        }
                    }
                }
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                ListIterator listIterator = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder).listIterator(0);
                while (true) {
                    ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                    if (!itr.hasNext()) {
                        return;
                    }
                    String str = (String) itr.next();
                    if (StringsKt__StringsJVMKt.startsWith(str, "room_fts_content_sync_", false)) {
                        SQLite.execSQL(sQLiteConnection, "DROP TRIGGER IF EXISTS ".concat(str));
                    }
                }
            }

            @Override // androidx.room.RoomOpenDelegate
            public final FlagSet.Builder onValidateSchema(SQLiteConnection sQLiteConnection) {
                sQLiteConnection.getClass();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap.put(LinkHeader.Parameters.Title, new TableInfo.Column(0, 1, LinkHeader.Parameters.Title, "TEXT", null, true));
                linkedHashMap.put("duration", new TableInfo.Column(0, 1, "duration", "INTEGER", null, true));
                linkedHashMap.put("thumbnailUrl", new TableInfo.Column(0, 1, "thumbnailUrl", "TEXT", null, false));
                linkedHashMap.put("albumId", new TableInfo.Column(0, 1, "albumId", "TEXT", null, false));
                linkedHashMap.put("albumName", new TableInfo.Column(0, 1, "albumName", "TEXT", null, false));
                linkedHashMap.put("explicit", new TableInfo.Column(0, 1, "explicit", "INTEGER", "0", true));
                linkedHashMap.put("year", new TableInfo.Column(0, 1, "year", "INTEGER", null, false));
                linkedHashMap.put("date", new TableInfo.Column(0, 1, "date", "INTEGER", null, false));
                linkedHashMap.put("dateModified", new TableInfo.Column(0, 1, "dateModified", "INTEGER", null, false));
                linkedHashMap.put("liked", new TableInfo.Column(0, 1, "liked", "INTEGER", null, true));
                linkedHashMap.put("likedDate", new TableInfo.Column(0, 1, "likedDate", "INTEGER", null, false));
                linkedHashMap.put("totalPlayTime", new TableInfo.Column(0, 1, "totalPlayTime", "INTEGER", null, true));
                linkedHashMap.put("inLibrary", new TableInfo.Column(0, 1, "inLibrary", "INTEGER", null, false));
                linkedHashMap.put("dateDownload", new TableInfo.Column(0, 1, "dateDownload", "INTEGER", null, false));
                linkedHashMap.put("isLocal", new TableInfo.Column(0, 1, "isLocal", "INTEGER", "false", true));
                linkedHashMap.put("libraryAddToken", new TableInfo.Column(0, 1, "libraryAddToken", "TEXT", null, false));
                linkedHashMap.put("libraryRemoveToken", new TableInfo.Column(0, 1, "libraryRemoveToken", "TEXT", null, false));
                linkedHashMap.put("lyricsOffset", new TableInfo.Column(0, 1, "lyricsOffset", "INTEGER", "0", true));
                linkedHashMap.put("romanizeLyrics", new TableInfo.Column(0, 1, "romanizeLyrics", "INTEGER", "true", true));
                linkedHashMap.put("isDownloaded", new TableInfo.Column(0, 1, "isDownloaded", "INTEGER", "0", true));
                linkedHashMap.put("isUploaded", new TableInfo.Column(0, 1, "isUploaded", "INTEGER", "false", true));
                linkedHashMap.put("isVideo", new TableInfo.Column(0, 1, "isVideo", "INTEGER", "false", true));
                linkedHashMap.put("isEpisode", new TableInfo.Column(0, 1, "isEpisode", "INTEGER", "false", true));
                linkedHashMap.put("playbackPosition", new TableInfo.Column(0, 1, "playbackPosition", "INTEGER", "NULL", false));
                linkedHashMap.put("uploadEntityId", new TableInfo.Column(0, 1, "uploadEntityId", "TEXT", "NULL", false));
                linkedHashMap.put("isCached", new TableInfo.Column(0, 1, "isCached", "INTEGER", "0", true));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_song_albumId", false, CollectionsKt__IterablesKt.listOf("albumId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo = new TableInfo("song", linkedHashMap, linkedHashSet, linkedHashSet2);
                TableInfo tableInfo2 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "song");
                if (!tableInfo.equals(tableInfo2)) {
                    return new FlagSet.Builder("song(com.metrolist.music.db.entities.SongEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2, false);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap2.put(ContentDisposition.Parameters.Name, new TableInfo.Column(0, 1, ContentDisposition.Parameters.Name, "TEXT", null, true));
                linkedHashMap2.put("thumbnailUrl", new TableInfo.Column(0, 1, "thumbnailUrl", "TEXT", null, false));
                linkedHashMap2.put("channelId", new TableInfo.Column(0, 1, "channelId", "TEXT", null, false));
                linkedHashMap2.put("lastUpdateTime", new TableInfo.Column(0, 1, "lastUpdateTime", "INTEGER", null, true));
                linkedHashMap2.put("bookmarkedAt", new TableInfo.Column(0, 1, "bookmarkedAt", "INTEGER", null, false));
                linkedHashMap2.put("isLocal", new TableInfo.Column(0, 1, "isLocal", "INTEGER", "false", true));
                linkedHashMap2.put("isPodcastChannel", new TableInfo.Column(0, 1, "isPodcastChannel", "INTEGER", "false", true));
                linkedHashMap2.put("cachedPageJson", new TableInfo.Column(0, 1, "cachedPageJson", "TEXT", null, false));
                TableInfo tableInfo3 = new TableInfo("artist", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo4 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "artist");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new FlagSet.Builder("artist(com.metrolist.music.db.entities.ArtistEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4, false);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap3.put("playlistId", new TableInfo.Column(0, 1, "playlistId", "TEXT", null, false));
                linkedHashMap3.put(LinkHeader.Parameters.Title, new TableInfo.Column(0, 1, LinkHeader.Parameters.Title, "TEXT", null, true));
                linkedHashMap3.put("year", new TableInfo.Column(0, 1, "year", "INTEGER", null, false));
                linkedHashMap3.put("thumbnailUrl", new TableInfo.Column(0, 1, "thumbnailUrl", "TEXT", null, false));
                linkedHashMap3.put("themeColor", new TableInfo.Column(0, 1, "themeColor", "INTEGER", null, false));
                linkedHashMap3.put("songCount", new TableInfo.Column(0, 1, "songCount", "INTEGER", null, true));
                linkedHashMap3.put("duration", new TableInfo.Column(0, 1, "duration", "INTEGER", null, true));
                linkedHashMap3.put("explicit", new TableInfo.Column(0, 1, "explicit", "INTEGER", "0", true));
                linkedHashMap3.put("lastUpdateTime", new TableInfo.Column(0, 1, "lastUpdateTime", "INTEGER", null, true));
                linkedHashMap3.put("bookmarkedAt", new TableInfo.Column(0, 1, "bookmarkedAt", "INTEGER", null, false));
                linkedHashMap3.put("likedDate", new TableInfo.Column(0, 1, "likedDate", "INTEGER", null, false));
                linkedHashMap3.put("inLibrary", new TableInfo.Column(0, 1, "inLibrary", "INTEGER", null, false));
                linkedHashMap3.put("isLocal", new TableInfo.Column(0, 1, "isLocal", "INTEGER", "false", true));
                linkedHashMap3.put("isUploaded", new TableInfo.Column(0, 1, "isUploaded", "INTEGER", "false", true));
                TableInfo tableInfo5 = new TableInfo("album", linkedHashMap3, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo6 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "album");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new FlagSet.Builder("album(com.metrolist.music.db.entities.AlbumEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6, false);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap4.put(ContentDisposition.Parameters.Name, new TableInfo.Column(0, 1, ContentDisposition.Parameters.Name, "TEXT", null, true));
                linkedHashMap4.put("browseId", new TableInfo.Column(0, 1, "browseId", "TEXT", null, false));
                linkedHashMap4.put("createdAt", new TableInfo.Column(0, 1, "createdAt", "INTEGER", null, false));
                linkedHashMap4.put("lastUpdateTime", new TableInfo.Column(0, 1, "lastUpdateTime", "INTEGER", null, false));
                linkedHashMap4.put("isEditable", new TableInfo.Column(0, 1, "isEditable", "INTEGER", "true", true));
                linkedHashMap4.put("bookmarkedAt", new TableInfo.Column(0, 1, "bookmarkedAt", "INTEGER", null, false));
                linkedHashMap4.put("remoteSongCount", new TableInfo.Column(0, 1, "remoteSongCount", "INTEGER", null, false));
                linkedHashMap4.put("playEndpointParams", new TableInfo.Column(0, 1, "playEndpointParams", "TEXT", null, false));
                linkedHashMap4.put("thumbnailUrl", new TableInfo.Column(0, 1, "thumbnailUrl", "TEXT", null, false));
                linkedHashMap4.put("shuffleEndpointParams", new TableInfo.Column(0, 1, "shuffleEndpointParams", "TEXT", null, false));
                linkedHashMap4.put("radioEndpointParams", new TableInfo.Column(0, 1, "radioEndpointParams", "TEXT", null, false));
                linkedHashMap4.put("isLocal", new TableInfo.Column(0, 1, "isLocal", "INTEGER", "false", true));
                linkedHashMap4.put("isAutoSync", new TableInfo.Column(0, 1, "isAutoSync", "INTEGER", "false", true));
                TableInfo tableInfo7 = new TableInfo("playlist", linkedHashMap4, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo8 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "playlist");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new FlagSet.Builder("playlist(com.metrolist.music.db.entities.PlaylistEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8, false);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("songId", new TableInfo.Column(1, 1, "songId", "TEXT", null, true));
                linkedHashMap5.put("artistId", new TableInfo.Column(2, 1, "artistId", "TEXT", null, true));
                linkedHashMap5.put("position", new TableInfo.Column(0, 1, "position", "INTEGER", null, true));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                linkedHashSet3.add(new TableInfo.ForeignKey("song", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("id")));
                linkedHashSet3.add(new TableInfo.ForeignKey("artist", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("artistId"), CollectionsKt__IterablesKt.listOf("id")));
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_song_artist_map_songId", false, CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("ASC")));
                linkedHashSet4.add(new TableInfo.Index("index_song_artist_map_artistId", false, CollectionsKt__IterablesKt.listOf("artistId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo9 = new TableInfo("song_artist_map", linkedHashMap5, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfo10 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "song_artist_map");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new FlagSet.Builder("song_artist_map(com.metrolist.music.db.entities.SongArtistMap).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10, false);
                }
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                linkedHashMap6.put("songId", new TableInfo.Column(1, 1, "songId", "TEXT", null, true));
                linkedHashMap6.put("albumId", new TableInfo.Column(2, 1, "albumId", "TEXT", null, true));
                linkedHashMap6.put("index", new TableInfo.Column(0, 1, "index", "INTEGER", null, true));
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                linkedHashSet5.add(new TableInfo.ForeignKey("song", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("id")));
                linkedHashSet5.add(new TableInfo.ForeignKey("album", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("albumId"), CollectionsKt__IterablesKt.listOf("id")));
                LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                linkedHashSet6.add(new TableInfo.Index("index_song_album_map_songId", false, CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("ASC")));
                linkedHashSet6.add(new TableInfo.Index("index_song_album_map_albumId", false, CollectionsKt__IterablesKt.listOf("albumId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo11 = new TableInfo("song_album_map", linkedHashMap6, linkedHashSet5, linkedHashSet6);
                TableInfo tableInfo12 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "song_album_map");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new FlagSet.Builder("song_album_map(com.metrolist.music.db.entities.SongAlbumMap).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12, false);
                }
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                linkedHashMap7.put("albumId", new TableInfo.Column(1, 1, "albumId", "TEXT", null, true));
                linkedHashMap7.put("artistId", new TableInfo.Column(2, 1, "artistId", "TEXT", null, true));
                linkedHashMap7.put("order", new TableInfo.Column(0, 1, "order", "INTEGER", null, true));
                LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                linkedHashSet7.add(new TableInfo.ForeignKey("album", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("albumId"), CollectionsKt__IterablesKt.listOf("id")));
                linkedHashSet7.add(new TableInfo.ForeignKey("artist", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("artistId"), CollectionsKt__IterablesKt.listOf("id")));
                LinkedHashSet linkedHashSet8 = new LinkedHashSet();
                linkedHashSet8.add(new TableInfo.Index("index_album_artist_map_albumId", false, CollectionsKt__IterablesKt.listOf("albumId"), CollectionsKt__IterablesKt.listOf("ASC")));
                linkedHashSet8.add(new TableInfo.Index("index_album_artist_map_artistId", false, CollectionsKt__IterablesKt.listOf("artistId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo13 = new TableInfo("album_artist_map", linkedHashMap7, linkedHashSet7, linkedHashSet8);
                TableInfo tableInfo14 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "album_artist_map");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new FlagSet.Builder("album_artist_map(com.metrolist.music.db.entities.AlbumArtistMap).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14, false);
                }
                LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                linkedHashMap8.put("id", new TableInfo.Column(1, 1, "id", "INTEGER", null, true));
                linkedHashMap8.put("playlistId", new TableInfo.Column(0, 1, "playlistId", "TEXT", null, true));
                linkedHashMap8.put("songId", new TableInfo.Column(0, 1, "songId", "TEXT", null, true));
                linkedHashMap8.put("position", new TableInfo.Column(0, 1, "position", "INTEGER", null, true));
                linkedHashMap8.put("setVideoId", new TableInfo.Column(0, 1, "setVideoId", "TEXT", null, false));
                LinkedHashSet linkedHashSet9 = new LinkedHashSet();
                linkedHashSet9.add(new TableInfo.ForeignKey("playlist", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("playlistId"), CollectionsKt__IterablesKt.listOf("id")));
                linkedHashSet9.add(new TableInfo.ForeignKey("song", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("id")));
                LinkedHashSet linkedHashSet10 = new LinkedHashSet();
                linkedHashSet10.add(new TableInfo.Index("index_playlist_song_map_playlistId", false, CollectionsKt__IterablesKt.listOf("playlistId"), CollectionsKt__IterablesKt.listOf("ASC")));
                linkedHashSet10.add(new TableInfo.Index("index_playlist_song_map_songId", false, CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo15 = new TableInfo("playlist_song_map", linkedHashMap8, linkedHashSet9, linkedHashSet10);
                TableInfo tableInfo16 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "playlist_song_map");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new FlagSet.Builder("playlist_song_map(com.metrolist.music.db.entities.PlaylistSongMap).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16, false);
                }
                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                linkedHashMap9.put("id", new TableInfo.Column(1, 1, "id", "INTEGER", null, true));
                linkedHashMap9.put("query", new TableInfo.Column(0, 1, "query", "TEXT", null, true));
                LinkedHashSet linkedHashSet11 = new LinkedHashSet();
                LinkedHashSet linkedHashSet12 = new LinkedHashSet();
                linkedHashSet12.add(new TableInfo.Index("index_search_history_query", true, CollectionsKt__IterablesKt.listOf("query"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo17 = new TableInfo("search_history", linkedHashMap9, linkedHashSet11, linkedHashSet12);
                TableInfo tableInfo18 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "search_history");
                if (!tableInfo17.equals(tableInfo18)) {
                    return new FlagSet.Builder("search_history(com.metrolist.music.db.entities.SearchHistory).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18, false);
                }
                LinkedHashMap linkedHashMap10 = new LinkedHashMap();
                linkedHashMap10.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap10.put("itag", new TableInfo.Column(0, 1, "itag", "INTEGER", null, true));
                linkedHashMap10.put("mimeType", new TableInfo.Column(0, 1, "mimeType", "TEXT", null, true));
                linkedHashMap10.put("codecs", new TableInfo.Column(0, 1, "codecs", "TEXT", null, true));
                linkedHashMap10.put("bitrate", new TableInfo.Column(0, 1, "bitrate", "INTEGER", null, true));
                linkedHashMap10.put("sampleRate", new TableInfo.Column(0, 1, "sampleRate", "INTEGER", null, false));
                linkedHashMap10.put("contentLength", new TableInfo.Column(0, 1, "contentLength", "INTEGER", null, true));
                linkedHashMap10.put("loudnessDb", new TableInfo.Column(0, 1, "loudnessDb", "REAL", null, false));
                linkedHashMap10.put("perceptualLoudnessDb", new TableInfo.Column(0, 1, "perceptualLoudnessDb", "REAL", null, false));
                linkedHashMap10.put("playbackUrl", new TableInfo.Column(0, 1, "playbackUrl", "TEXT", null, false));
                TableInfo tableInfo19 = new TableInfo("format", linkedHashMap10, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo20 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "format");
                if (!tableInfo19.equals(tableInfo20)) {
                    return new FlagSet.Builder("format(com.metrolist.music.db.entities.FormatEntity).\n Expected:\n" + tableInfo19 + "\n Found:\n" + tableInfo20, false);
                }
                LinkedHashMap linkedHashMap11 = new LinkedHashMap();
                linkedHashMap11.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap11.put("lyrics", new TableInfo.Column(0, 1, "lyrics", "TEXT", null, true));
                linkedHashMap11.put("provider", new TableInfo.Column(0, 1, "provider", "TEXT", "'Unknown'", true));
                linkedHashMap11.put("translatedLyrics", new TableInfo.Column(0, 1, "translatedLyrics", "TEXT", "''", true));
                linkedHashMap11.put("translationLanguage", new TableInfo.Column(0, 1, "translationLanguage", "TEXT", "''", true));
                linkedHashMap11.put("translationMode", new TableInfo.Column(0, 1, "translationMode", "TEXT", "''", true));
                TableInfo tableInfo21 = new TableInfo("lyrics", linkedHashMap11, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo22 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "lyrics");
                if (!tableInfo21.equals(tableInfo22)) {
                    return new FlagSet.Builder("lyrics(com.metrolist.music.db.entities.LyricsEntity).\n Expected:\n" + tableInfo21 + "\n Found:\n" + tableInfo22, false);
                }
                LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                linkedHashMap12.put("id", new TableInfo.Column(1, 1, "id", "INTEGER", null, true));
                linkedHashMap12.put("songId", new TableInfo.Column(0, 1, "songId", "TEXT", null, true));
                linkedHashMap12.put("timestamp", new TableInfo.Column(0, 1, "timestamp", "INTEGER", null, true));
                linkedHashMap12.put("playTime", new TableInfo.Column(0, 1, "playTime", "INTEGER", null, true));
                LinkedHashSet linkedHashSet13 = new LinkedHashSet();
                linkedHashSet13.add(new TableInfo.ForeignKey("song", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("id")));
                LinkedHashSet linkedHashSet14 = new LinkedHashSet();
                linkedHashSet14.add(new TableInfo.Index("index_event_songId", false, CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo23 = new TableInfo("event", linkedHashMap12, linkedHashSet13, linkedHashSet14);
                TableInfo tableInfo24 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "event");
                if (!tableInfo23.equals(tableInfo24)) {
                    return new FlagSet.Builder("event(com.metrolist.music.db.entities.Event).\n Expected:\n" + tableInfo23 + "\n Found:\n" + tableInfo24, false);
                }
                LinkedHashMap linkedHashMap13 = new LinkedHashMap();
                linkedHashMap13.put("id", new TableInfo.Column(1, 1, "id", "INTEGER", null, true));
                linkedHashMap13.put("songId", new TableInfo.Column(0, 1, "songId", "TEXT", null, true));
                linkedHashMap13.put("relatedSongId", new TableInfo.Column(0, 1, "relatedSongId", "TEXT", null, true));
                LinkedHashSet linkedHashSet15 = new LinkedHashSet();
                linkedHashSet15.add(new TableInfo.ForeignKey("song", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("id")));
                linkedHashSet15.add(new TableInfo.ForeignKey("song", "CASCADE", "NO ACTION", CollectionsKt__IterablesKt.listOf("relatedSongId"), CollectionsKt__IterablesKt.listOf("id")));
                LinkedHashSet linkedHashSet16 = new LinkedHashSet();
                linkedHashSet16.add(new TableInfo.Index("index_related_song_map_songId", false, CollectionsKt__IterablesKt.listOf("songId"), CollectionsKt__IterablesKt.listOf("ASC")));
                linkedHashSet16.add(new TableInfo.Index("index_related_song_map_relatedSongId", false, CollectionsKt__IterablesKt.listOf("relatedSongId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo25 = new TableInfo("related_song_map", linkedHashMap13, linkedHashSet15, linkedHashSet16);
                TableInfo tableInfo26 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "related_song_map");
                if (!tableInfo25.equals(tableInfo26)) {
                    return new FlagSet.Builder("related_song_map(com.metrolist.music.db.entities.RelatedSongMap).\n Expected:\n" + tableInfo25 + "\n Found:\n" + tableInfo26, false);
                }
                LinkedHashMap linkedHashMap14 = new LinkedHashMap();
                linkedHashMap14.put("videoId", new TableInfo.Column(1, 1, "videoId", "TEXT", null, true));
                linkedHashMap14.put("setVideoId", new TableInfo.Column(0, 1, "setVideoId", "TEXT", null, false));
                TableInfo tableInfo27 = new TableInfo("set_video_id", linkedHashMap14, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo28 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "set_video_id");
                if (!tableInfo27.equals(tableInfo28)) {
                    return new FlagSet.Builder("set_video_id(com.metrolist.music.db.entities.SetVideoIdEntity).\n Expected:\n" + tableInfo27 + "\n Found:\n" + tableInfo28, false);
                }
                LinkedHashMap linkedHashMap15 = new LinkedHashMap();
                linkedHashMap15.put("song", new TableInfo.Column(1, 1, "song", "TEXT", null, true));
                linkedHashMap15.put("year", new TableInfo.Column(2, 1, "year", "INTEGER", null, true));
                linkedHashMap15.put("month", new TableInfo.Column(3, 1, "month", "INTEGER", null, true));
                linkedHashMap15.put("count", new TableInfo.Column(0, 1, "count", "INTEGER", null, true));
                TableInfo tableInfo29 = new TableInfo("playCount", linkedHashMap15, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo30 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "playCount");
                if (!tableInfo29.equals(tableInfo30)) {
                    return new FlagSet.Builder("playCount(com.metrolist.music.db.entities.PlayCountEntity).\n Expected:\n" + tableInfo29 + "\n Found:\n" + tableInfo30, false);
                }
                LinkedHashMap linkedHashMap16 = new LinkedHashMap();
                linkedHashMap16.put("id", new TableInfo.Column(1, 1, "id", "INTEGER", null, true));
                linkedHashMap16.put("trackId", new TableInfo.Column(0, 1, "trackId", "TEXT", null, true));
                linkedHashMap16.put(LinkHeader.Parameters.Title, new TableInfo.Column(0, 1, LinkHeader.Parameters.Title, "TEXT", null, true));
                linkedHashMap16.put("artist", new TableInfo.Column(0, 1, "artist", "TEXT", null, true));
                linkedHashMap16.put("album", new TableInfo.Column(0, 1, "album", "TEXT", null, false));
                linkedHashMap16.put("coverArtUrl", new TableInfo.Column(0, 1, "coverArtUrl", "TEXT", null, false));
                linkedHashMap16.put("coverArtHqUrl", new TableInfo.Column(0, 1, "coverArtHqUrl", "TEXT", null, false));
                linkedHashMap16.put("genre", new TableInfo.Column(0, 1, "genre", "TEXT", null, false));
                linkedHashMap16.put("releaseDate", new TableInfo.Column(0, 1, "releaseDate", "TEXT", null, false));
                linkedHashMap16.put("label", new TableInfo.Column(0, 1, "label", "TEXT", null, false));
                linkedHashMap16.put("shazamUrl", new TableInfo.Column(0, 1, "shazamUrl", "TEXT", null, false));
                linkedHashMap16.put("appleMusicUrl", new TableInfo.Column(0, 1, "appleMusicUrl", "TEXT", null, false));
                linkedHashMap16.put("spotifyUrl", new TableInfo.Column(0, 1, "spotifyUrl", "TEXT", null, false));
                linkedHashMap16.put("isrc", new TableInfo.Column(0, 1, "isrc", "TEXT", null, false));
                linkedHashMap16.put("youtubeVideoId", new TableInfo.Column(0, 1, "youtubeVideoId", "TEXT", null, false));
                linkedHashMap16.put("recognizedAt", new TableInfo.Column(0, 1, "recognizedAt", "INTEGER", null, true));
                linkedHashMap16.put("liked", new TableInfo.Column(0, 1, "liked", "INTEGER", null, true));
                LinkedHashSet linkedHashSet17 = new LinkedHashSet();
                LinkedHashSet linkedHashSet18 = new LinkedHashSet();
                linkedHashSet18.add(new TableInfo.Index("index_recognition_history_trackId", false, CollectionsKt__IterablesKt.listOf("trackId"), CollectionsKt__IterablesKt.listOf("ASC")));
                TableInfo tableInfo31 = new TableInfo("recognition_history", linkedHashMap16, linkedHashSet17, linkedHashSet18);
                TableInfo tableInfo32 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "recognition_history");
                if (!tableInfo31.equals(tableInfo32)) {
                    return new FlagSet.Builder("recognition_history(com.metrolist.music.db.entities.RecognitionHistory).\n Expected:\n" + tableInfo31 + "\n Found:\n" + tableInfo32, false);
                }
                LinkedHashMap linkedHashMap17 = new LinkedHashMap();
                linkedHashMap17.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap17.put("secondaryId", new TableInfo.Column(0, 1, "secondaryId", "TEXT", null, false));
                linkedHashMap17.put(LinkHeader.Parameters.Title, new TableInfo.Column(0, 1, LinkHeader.Parameters.Title, "TEXT", null, true));
                linkedHashMap17.put("subtitle", new TableInfo.Column(0, 1, "subtitle", "TEXT", null, false));
                linkedHashMap17.put("subtitleIds", new TableInfo.Column(0, 1, "subtitleIds", "TEXT", null, false));
                linkedHashMap17.put("thumbnailUrl", new TableInfo.Column(0, 1, "thumbnailUrl", "TEXT", null, false));
                linkedHashMap17.put(LinkHeader.Parameters.Type, new TableInfo.Column(0, 1, LinkHeader.Parameters.Type, "TEXT", null, true));
                linkedHashMap17.put("explicit", new TableInfo.Column(0, 1, "explicit", "INTEGER", null, true));
                linkedHashMap17.put("createDate", new TableInfo.Column(0, 1, "createDate", "INTEGER", null, true));
                linkedHashMap17.put("albumId", new TableInfo.Column(0, 1, "albumId", "TEXT", null, false));
                linkedHashMap17.put("albumName", new TableInfo.Column(0, 1, "albumName", "TEXT", null, false));
                TableInfo tableInfo33 = new TableInfo("speed_dial_item", linkedHashMap17, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo34 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "speed_dial_item");
                if (!tableInfo33.equals(tableInfo34)) {
                    return new FlagSet.Builder("speed_dial_item(com.metrolist.music.db.entities.SpeedDialItem).\n Expected:\n" + tableInfo33 + "\n Found:\n" + tableInfo34, false);
                }
                LinkedHashMap linkedHashMap18 = new LinkedHashMap();
                linkedHashMap18.put("id", new TableInfo.Column(1, 1, "id", "TEXT", null, true));
                linkedHashMap18.put(LinkHeader.Parameters.Title, new TableInfo.Column(0, 1, LinkHeader.Parameters.Title, "TEXT", null, true));
                linkedHashMap18.put("author", new TableInfo.Column(0, 1, "author", "TEXT", null, false));
                linkedHashMap18.put("thumbnailUrl", new TableInfo.Column(0, 1, "thumbnailUrl", "TEXT", null, false));
                linkedHashMap18.put("channelId", new TableInfo.Column(0, 1, "channelId", "TEXT", null, false));
                linkedHashMap18.put("bookmarkedAt", new TableInfo.Column(0, 1, "bookmarkedAt", "INTEGER", null, false));
                linkedHashMap18.put("lastUpdateTime", new TableInfo.Column(0, 1, "lastUpdateTime", "INTEGER", null, true));
                linkedHashMap18.put("libraryAddToken", new TableInfo.Column(0, 1, "libraryAddToken", "TEXT", null, false));
                linkedHashMap18.put("libraryRemoveToken", new TableInfo.Column(0, 1, "libraryRemoveToken", "TEXT", null, false));
                TableInfo tableInfo35 = new TableInfo("podcast", linkedHashMap18, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfo36 = DatabaseDao_Impl.AnonymousClass17.read(sQLiteConnection, "podcast");
                if (!tableInfo35.equals(tableInfo36)) {
                    return new FlagSet.Builder("podcast(com.metrolist.music.db.entities.PodcastEntity).\n Expected:\n" + tableInfo35 + "\n Found:\n" + tableInfo36, false);
                }
                ViewInfo viewInfo = new ViewInfo("sorted_song_artist_map", "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                ViewInfo viewInfo2 = IntMath.read(sQLiteConnection, "sorted_song_artist_map");
                if (!viewInfo.equals(viewInfo2)) {
                    return new FlagSet.Builder("sorted_song_artist_map(com.metrolist.music.db.entities.SortedSongArtistMap).\n Expected:\n" + viewInfo + "\n Found:\n" + viewInfo2, false);
                }
                ViewInfo viewInfo3 = new ViewInfo("sorted_song_album_map", "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                ViewInfo viewInfo4 = IntMath.read(sQLiteConnection, "sorted_song_album_map");
                if (!viewInfo3.equals(viewInfo4)) {
                    return new FlagSet.Builder("sorted_song_album_map(com.metrolist.music.db.entities.SortedSongAlbumMap).\n Expected:\n" + viewInfo3 + "\n Found:\n" + viewInfo4, false);
                }
                ViewInfo viewInfo5 = new ViewInfo("playlist_song_map_preview", "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ViewInfo viewInfo6 = IntMath.read(sQLiteConnection, "playlist_song_map_preview");
                if (viewInfo5.equals(viewInfo6)) {
                    return new FlagSet.Builder((String) null, true);
                }
                return new FlagSet.Builder("playlist_song_map_preview(com.metrolist.music.db.entities.PlaylistSongMapPreview).\n Expected:\n" + viewInfo5 + "\n Found:\n" + viewInfo6, false);
            }
        };
    }

    @Override // com.metrolist.music.db.InternalDatabase
    public final DatabaseDao getDao() {
        return (DatabaseDao) this._databaseDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final LinkedHashMap getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DatabaseDao.class);
        EmptyList emptyList = EmptyList.INSTANCE;
        linkedHashMap.put(orCreateKotlinClass, emptyList);
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(SpeedDialDao_Impl.class), emptyList);
        return linkedHashMap;
    }

    @Override // com.metrolist.music.db.InternalDatabase
    public final SpeedDialDao_Impl getSpeedDialDao() {
        return (SpeedDialDao_Impl) this._speedDialDao.getValue();
    }
}
