package com.metrolist.music.db;

import android.database.Cursor;
import android.database.SQLException;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Joiner;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.SongArtistMap;
import com.metrolist.music.extensions.StringExtKt;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicDatabaseKt$MIGRATION_1_2$1 extends Migration {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MusicDatabaseKt$MIGRATION_1_2$1(int i, int i2, byte b) {
        super(i, i2);
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x003a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v1, types: [java.lang.Object, java.time.LocalDateTime] */
    /* JADX WARN: Type inference failed for: r26v1, types: [java.lang.Object, java.time.LocalDateTime] */
    @Override // androidx.room.migration.Migration
    public void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException {
        int i = 1;
        switch (this.$r8$classId) {
            case 0:
                Integer num = 0;
                frameworkSQLiteDatabase.getClass();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ArrayList arrayList = new ArrayList();
                Regex regex = StringExtKt.combiningDiacriticalMarksRegex;
                Cursor cursorQuery = frameworkSQLiteDatabase.query(new Joiner("SELECT * FROM artist", (byte) 4));
                while (cursorQuery.moveToNext()) {
                    try {
                        int i2 = cursorQuery.getInt(0);
                        String strGenerateLocalId = CollectionsKt__IterablesKt.generateLocalId("LA");
                        linkedHashMap.put(Integer.valueOf(i2), strGenerateLocalId);
                        String string = cursorQuery.getString(1);
                        string.getClass();
                        arrayList.add(new ArtistEntity(strGenerateLocalId, string, null, null, null, false, null, 508));
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
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                ArrayList arrayList2 = new ArrayList();
                Cursor cursorQuery2 = frameworkSQLiteDatabase.query(new Joiner("SELECT * FROM playlist", (byte) 4));
                while (cursorQuery2.moveToNext()) {
                    try {
                        int i3 = cursorQuery2.getInt(0);
                        String strGenerateLocalId2 = CollectionsKt__IterablesKt.generateLocalId("LP");
                        linkedHashMap2.put(Integer.valueOf(i3), strGenerateLocalId2);
                        String string2 = cursorQuery2.getString(1);
                        string2.getClass();
                        arrayList2.add(new PlaylistEntity(strGenerateLocalId2, string2, null, null, false, null, null, null, null, null, null, 16380));
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CharsKt.closeFinally(cursorQuery2, th3);
                            throw th4;
                        }
                    }
                }
                cursorQuery2.close();
                ArrayList arrayList3 = new ArrayList();
                Cursor cursorQuery3 = frameworkSQLiteDatabase.query(new Joiner("SELECT * FROM playlist_song", (byte) 4));
                while (cursorQuery3.moveToNext()) {
                    try {
                        Object obj = linkedHashMap2.get(Integer.valueOf(cursorQuery3.getInt(1)));
                        obj.getClass();
                        String string3 = cursorQuery3.getString(2);
                        string3.getClass();
                        arrayList3.add(new PlaylistSongMap((String) obj, string3, cursorQuery3.getInt(3), (String) null, 17));
                    } catch (Throwable th5) {
                        try {
                            throw th5;
                        } catch (Throwable th6) {
                            CharsKt.closeFinally(cursorQuery3, th5);
                            throw th6;
                        }
                    }
                }
                cursorQuery3.close();
                if (arrayList3.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList3, new DatabaseDao$songs$lambda$1$2$$inlined$sortedBy$1((byte) 3));
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                int size = arrayList3.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = arrayList3.get(i4);
                    i4++;
                    PlaylistSongMap playlistSongMap = (PlaylistSongMap) obj2;
                    String str = playlistSongMap.playlistId;
                    if (!linkedHashMap3.containsKey(str)) {
                        linkedHashMap3.put(str, num);
                    }
                    Object obj3 = linkedHashMap3.get(str);
                    obj3.getClass();
                    int i5 = i;
                    PlaylistSongMap playlistSongMapCopy$default = PlaylistSongMap.copy$default(playlistSongMap, ((Number) obj3).intValue(), null, 23);
                    Object obj4 = linkedHashMap3.get(str);
                    obj4.getClass();
                    linkedHashMap3.put(str, Integer.valueOf(((Number) obj4).intValue() + 1));
                    arrayList4.add(playlistSongMapCopy$default);
                    i = i5;
                }
                int i6 = i;
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                Cursor cursorQuery4 = frameworkSQLiteDatabase.query(new Joiner("SELECT * FROM song", (byte) 4));
                while (cursorQuery4.moveToNext()) {
                    try {
                        String string4 = cursorQuery4.getString(0);
                        string4.getClass();
                        int i7 = i6;
                        String string5 = cursorQuery4.getString(i7);
                        string5.getClass();
                        int i8 = cursorQuery4.getInt(3);
                        boolean z = cursorQuery4.getInt(4) == i7 ? i7 : 0;
                        Instant instantOfEpochMilli = Instant.ofEpochMilli(new Date(cursorQuery4.getLong(8)).getTime());
                        ZoneOffset zoneOffset = ZoneOffset.UTC;
                        ?? localDateTime = instantOfEpochMilli.atZone(zoneOffset).toLocalDateTime();
                        localDateTime.getClass();
                        ?? localDateTime2 = Instant.ofEpochMilli(new Date(cursorQuery4.getLong(9)).getTime()).atZone(zoneOffset).toLocalDateTime();
                        localDateTime2.getClass();
                        arrayList5.add(new MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity(string4, string5, i8, z, localDateTime, localDateTime2));
                        Object obj5 = linkedHashMap.get(Integer.valueOf(cursorQuery4.getInt(2)));
                        obj5.getClass();
                        arrayList6.add(new SongArtistMap(string4, (String) obj5, 0));
                        i6 = i7;
                    } catch (Throwable th7) {
                        try {
                            throw th7;
                        } catch (Throwable th8) {
                            CharsKt.closeFinally(cursorQuery4, th7);
                            throw th8;
                        }
                    }
                }
                cursorQuery4.close();
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS song");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS artist");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS playlist");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS playlist_song");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `liked` INTEGER NOT NULL, `totalPlayTime` INTEGER NOT NULL, `isTrash` INTEGER NOT NULL, `download_state` INTEGER NOT NULL, `create_date` INTEGER NOT NULL, `modify_date` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `artist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `thumbnailUrl` TEXT, `bannerUrl` TEXT, `description` TEXT, `createDate` INTEGER NOT NULL, `lastUpdateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `album` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `year` INTEGER, `thumbnailUrl` TEXT, `songCount` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `createDate` INTEGER NOT NULL, `lastUpdateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `playlist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `author` TEXT, `authorId` TEXT, `year` INTEGER, `thumbnailUrl` TEXT, `createDate` INTEGER NOT NULL, `lastUpdateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `song_artist_map` (`songId` TEXT NOT NULL, `artistId` TEXT NOT NULL, `position` INTEGER NOT NULL, PRIMARY KEY(`songId`, `artistId`), FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`artistId`) REFERENCES `artist`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_song_artist_map_songId` ON `song_artist_map` (`songId`)");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_song_artist_map_artistId` ON `song_artist_map` (`artistId`)");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `song_album_map` (`songId` TEXT NOT NULL, `albumId` TEXT NOT NULL, `index` INTEGER, PRIMARY KEY(`songId`, `albumId`), FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`albumId`) REFERENCES `album`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_song_album_map_songId` ON `song_album_map` (`songId`)");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_song_album_map_albumId` ON `song_album_map` (`albumId`)");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `album_artist_map` (`albumId` TEXT NOT NULL, `artistId` TEXT NOT NULL, `order` INTEGER NOT NULL, PRIMARY KEY(`albumId`, `artistId`), FOREIGN KEY(`albumId`) REFERENCES `album`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`artistId`) REFERENCES `artist`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_album_artist_map_albumId` ON `album_artist_map` (`albumId`)");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_album_artist_map_artistId` ON `album_artist_map` (`artistId`)");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `playlist_song_map` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playlistId` TEXT NOT NULL, `songId` TEXT NOT NULL, `position` INTEGER NOT NULL, FOREIGN KEY(`playlistId`) REFERENCES `playlist`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_playlist_song_map_playlistId` ON `playlist_song_map` (`playlistId`)");
                frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_playlist_song_map_songId` ON `playlist_song_map` (`songId`)");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `download` (`id` INTEGER NOT NULL, `songId` TEXT NOT NULL, PRIMARY KEY(`id`))");
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `search_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `query` TEXT NOT NULL)");
                frameworkSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_search_history_query` ON `search_history` (`query`)");
                frameworkSQLiteDatabase.execSQL("CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                frameworkSQLiteDatabase.execSQL("CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                int i9 = 0;
                for (int size2 = arrayList.size(); i9 < size2; size2 = size2) {
                    Object obj6 = arrayList.get(i9);
                    i9++;
                    ArtistEntity artistEntity = (ArtistEntity) obj6;
                    String str2 = artistEntity.id;
                    LocalDateTime localDateTime3 = artistEntity.lastUpdateTime;
                    frameworkSQLiteDatabase.insert("artist", 2, SQLite.contentValuesOf(new Pair("id", str2), new Pair(ContentDisposition.Parameters.Name, artistEntity.name), new Pair("createDate", Converters.dateToTimestamp(localDateTime3)), new Pair("lastUpdateTime", Converters.dateToTimestamp(localDateTime3))));
                }
                int size3 = arrayList5.size();
                int i10 = 0;
                while (i10 < size3) {
                    MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity = (MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity) arrayList5.get(i10);
                    frameworkSQLiteDatabase.insert("song", 2, SQLite.contentValuesOf(new Pair("id", musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.id), new Pair(LinkHeader.Parameters.Title, musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.title), new Pair("duration", Integer.valueOf(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.duration)), new Pair("liked", Boolean.valueOf(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.liked)), new Pair("totalPlayTime", 0L), new Pair("isTrash", Boolean.FALSE), new Pair("download_state", num), new Pair("create_date", Converters.dateToTimestamp(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.createDate)), new Pair("modify_date", Converters.dateToTimestamp(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.modifyDate))));
                    size3 = size3;
                    arrayList5 = arrayList5;
                    i10++;
                    num = num;
                }
                int size4 = arrayList6.size();
                int i11 = 0;
                while (i11 < size4) {
                    Object obj7 = arrayList6.get(i11);
                    i11++;
                    SongArtistMap songArtistMap = (SongArtistMap) obj7;
                    frameworkSQLiteDatabase.insert("song_artist_map", 2, SQLite.contentValuesOf(new Pair("songId", songArtistMap.songId), new Pair("artistId", songArtistMap.artistId), new Pair("position", Integer.valueOf(songArtistMap.position))));
                }
                int size5 = arrayList2.size();
                int i12 = 0;
                while (i12 < size5) {
                    Object obj8 = arrayList2.get(i12);
                    i12++;
                    PlaylistEntity playlistEntity = (PlaylistEntity) obj8;
                    frameworkSQLiteDatabase.insert("playlist", 2, SQLite.contentValuesOf(new Pair("id", playlistEntity.id), new Pair(ContentDisposition.Parameters.Name, playlistEntity.name), new Pair("createDate", Converters.dateToTimestamp(LocalDateTime.now())), new Pair("lastUpdateTime", Converters.dateToTimestamp(LocalDateTime.now()))));
                }
                int size6 = arrayList3.size();
                int i13 = 0;
                while (i13 < size6) {
                    Object obj9 = arrayList3.get(i13);
                    i13++;
                    PlaylistSongMap playlistSongMap2 = (PlaylistSongMap) obj9;
                    frameworkSQLiteDatabase.insert("playlist_song_map", 2, SQLite.contentValuesOf(new Pair("playlistId", playlistSongMap2.playlistId), new Pair("songId", playlistSongMap2.songId), new Pair("position", Integer.valueOf(playlistSongMap2.position))));
                }
                return;
            case 20:
                frameworkSQLiteDatabase.getClass();
                MusicDatabaseKt.addVersion24ColumnsIfMissing(frameworkSQLiteDatabase);
                return;
            case 21:
                frameworkSQLiteDatabase.getClass();
                MusicDatabaseKt.addVersion24ColumnsIfMissing(frameworkSQLiteDatabase);
                return;
            case 22:
                frameworkSQLiteDatabase.getClass();
                Cursor cursorQuery5 = frameworkSQLiteDatabase.query("PRAGMA table_info(format)");
                try {
                    int columnIndex = cursorQuery5.getColumnIndex(ContentDisposition.Parameters.Name);
                    do {
                        if (cursorQuery5.moveToNext()) {
                            break;
                        } else {
                            i = 0;
                        }
                        cursorQuery5.close();
                        if (i == 0) {
                            frameworkSQLiteDatabase.execSQL("ALTER TABLE format ADD COLUMN perceptualLoudnessDb REAL DEFAULT NULL");
                            return;
                        }
                        return;
                    } while (!Intrinsics.areEqual(cursorQuery5.getString(columnIndex), "perceptualLoudnessDb"));
                    cursorQuery5.close();
                    if (i == 0) {
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE format ADD COLUMN perceptualLoudnessDb REAL DEFAULT NULL");
                        return;
                    }
                    return;
                } catch (Throwable th9) {
                    try {
                        throw th9;
                    } catch (Throwable th10) {
                        CharsKt.closeFinally(cursorQuery5, th9);
                        throw th10;
                    }
                }
            default:
                super.migrate(frameworkSQLiteDatabase);
                return;
        }
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SQLiteConnection sQLiteConnection) {
        switch (this.$r8$classId) {
            case 1:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `year` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `date` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `dateModified` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `likedDate` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `dateDownload` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 2:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `isLocal` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `localPath` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `artist` ADD COLUMN `channelId` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `playlistId` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `isEditable` INTEGER NOT NULL DEFAULT true");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `isLocal` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `bookmarkedAt` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist_song_map` ADD COLUMN `setVideoId` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `set_video_id` (`videoId` TEXT NOT NULL, `setVideoId` TEXT, PRIMARY KEY(`videoId`))");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 3:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `playCount` (`song` TEXT NOT NULL, `year` INTEGER NOT NULL, `month` INTEGER NOT NULL, `count` INTEGER NOT NULL, PRIMARY KEY(`song`, `year`, `month`))");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 4:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `format` ADD COLUMN `perceptualLoudnessDb` REAL DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 5:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `explicit` INTEGER NOT NULL DEFAULT 0, `year` INTEGER, `date` INTEGER, `dateModified` INTEGER, `liked` INTEGER NOT NULL, `likedDate` INTEGER, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, `dateDownload` INTEGER, `isLocal` INTEGER NOT NULL, `libraryAddToken` TEXT, `libraryRemoveToken` TEXT, `romanizeLyrics` INTEGER NOT NULL DEFAULT true, `isDownloaded` INTEGER NOT NULL DEFAULT 0, `isUploaded` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`,`libraryAddToken`,`libraryRemoveToken`,`romanizeLyrics`,`isDownloaded`,`isUploaded`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`,`libraryAddToken`,`libraryRemoveToken`,`romanizeLyrics`,`isDownloaded`,`isUploaded` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_artist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `thumbnailUrl` TEXT, `channelId` TEXT, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `isLocal` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_artist` (`id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`,`isLocal`) SELECT `id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`,`isLocal` FROM `artist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `artist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_artist` RENAME TO `artist`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_album` (`id` TEXT NOT NULL, `playlistId` TEXT, `title` TEXT NOT NULL, `year` INTEGER, `thumbnailUrl` TEXT, `themeColor` INTEGER, `songCount` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `explicit` INTEGER NOT NULL DEFAULT 0, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `likedDate` INTEGER, `inLibrary` INTEGER, `isLocal` INTEGER NOT NULL, `isUploaded` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_album` (`id`,`playlistId`,`title`,`year`,`thumbnailUrl`,`themeColor`,`songCount`,`duration`,`explicit`,`lastUpdateTime`,`bookmarkedAt`,`likedDate`,`inLibrary`,`isLocal`,`isUploaded`) SELECT `id`,`playlistId`,`title`,`year`,`thumbnailUrl`,`themeColor`,`songCount`,`duration`,`explicit`,`lastUpdateTime`,`bookmarkedAt`,`likedDate`,`inLibrary`,`isLocal`,`isUploaded` FROM `album`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `album`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_album` RENAME TO `album`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_playlist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `browseId` TEXT, `createdAt` INTEGER, `lastUpdateTime` INTEGER, `isEditable` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `remoteSongCount` INTEGER, `playEndpointParams` TEXT, `thumbnailUrl` TEXT, `shuffleEndpointParams` TEXT, `radioEndpointParams` TEXT, `isLocal` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_playlist` (`id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`,`remoteSongCount`,`playEndpointParams`,`thumbnailUrl`,`shuffleEndpointParams`,`radioEndpointParams`,`isLocal`) SELECT `id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`,`remoteSongCount`,`playEndpointParams`,`thumbnailUrl`,`shuffleEndpointParams`,`radioEndpointParams`,`isLocal` FROM `playlist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `playlist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_playlist` RENAME TO `playlist`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 6:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `lyricsOffset` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `isVideo` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 7:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `explicit` INTEGER NOT NULL DEFAULT 0, `year` INTEGER, `date` INTEGER, `dateModified` INTEGER, `liked` INTEGER NOT NULL, `likedDate` INTEGER, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, `dateDownload` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, `libraryAddToken` TEXT, `libraryRemoveToken` TEXT, `lyricsOffset` INTEGER NOT NULL DEFAULT 0, `romanizeLyrics` INTEGER NOT NULL DEFAULT true, `isDownloaded` INTEGER NOT NULL DEFAULT 0, `isUploaded` INTEGER NOT NULL DEFAULT false, `isVideo` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`,`libraryAddToken`,`libraryRemoveToken`,`lyricsOffset`,`romanizeLyrics`,`isDownloaded`,`isUploaded`,`isVideo`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`,`libraryAddToken`,`libraryRemoveToken`,`lyricsOffset`,`romanizeLyrics`,`isDownloaded`,`isUploaded`,`isVideo` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_artist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `thumbnailUrl` TEXT, `channelId` TEXT, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_artist` (`id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`,`isLocal`) SELECT `id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`,`isLocal` FROM `artist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `artist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_artist` RENAME TO `artist`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_album` (`id` TEXT NOT NULL, `playlistId` TEXT, `title` TEXT NOT NULL, `year` INTEGER, `thumbnailUrl` TEXT, `themeColor` INTEGER, `songCount` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `explicit` INTEGER NOT NULL DEFAULT 0, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `likedDate` INTEGER, `inLibrary` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, `isUploaded` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_album` (`id`,`playlistId`,`title`,`year`,`thumbnailUrl`,`themeColor`,`songCount`,`duration`,`explicit`,`lastUpdateTime`,`bookmarkedAt`,`likedDate`,`inLibrary`,`isLocal`,`isUploaded`) SELECT `id`,`playlistId`,`title`,`year`,`thumbnailUrl`,`themeColor`,`songCount`,`duration`,`explicit`,`lastUpdateTime`,`bookmarkedAt`,`likedDate`,`inLibrary`,`isLocal`,`isUploaded` FROM `album`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `album`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_album` RENAME TO `album`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_playlist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `browseId` TEXT, `createdAt` INTEGER, `lastUpdateTime` INTEGER, `isEditable` INTEGER NOT NULL DEFAULT true, `bookmarkedAt` INTEGER, `remoteSongCount` INTEGER, `playEndpointParams` TEXT, `thumbnailUrl` TEXT, `shuffleEndpointParams` TEXT, `radioEndpointParams` TEXT, `isLocal` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_playlist` (`id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`,`remoteSongCount`,`playEndpointParams`,`thumbnailUrl`,`shuffleEndpointParams`,`radioEndpointParams`,`isLocal`) SELECT `id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`,`remoteSongCount`,`playEndpointParams`,`thumbnailUrl`,`shuffleEndpointParams`,`radioEndpointParams`,`isLocal` FROM `playlist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `playlist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_playlist` RENAME TO `playlist`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 8:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `isAutoSync` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 9:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `format` (`id` TEXT NOT NULL, `itag` INTEGER NOT NULL, `mimeType` TEXT NOT NULL, `codecs` TEXT NOT NULL, `bitrate` INTEGER NOT NULL, `sampleRate` INTEGER, `contentLength` INTEGER NOT NULL, `loudnessDb` REAL, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 10:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `recognition_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `trackId` TEXT NOT NULL, `title` TEXT NOT NULL, `artist` TEXT NOT NULL, `album` TEXT, `coverArtUrl` TEXT, `coverArtHqUrl` TEXT, `genre` TEXT, `releaseDate` TEXT, `label` TEXT, `shazamUrl` TEXT, `appleMusicUrl` TEXT, `spotifyUrl` TEXT, `isrc` TEXT, `youtubeVideoId` TEXT, `recognizedAt` INTEGER NOT NULL, `liked` INTEGER NOT NULL)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_recognition_history_trackId` ON `recognition_history` (`trackId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 11:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `lyrics` ADD COLUMN `translatedLyrics` TEXT NOT NULL DEFAULT ''");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `lyrics` ADD COLUMN `translationLanguage` TEXT NOT NULL DEFAULT ''");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `lyrics` ADD COLUMN `translationMode` TEXT NOT NULL DEFAULT ''");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `speed_dial_item` (`id` TEXT NOT NULL, `secondaryId` TEXT, `title` TEXT NOT NULL, `subtitle` TEXT, `thumbnailUrl` TEXT, `type` TEXT NOT NULL, `explicit` INTEGER NOT NULL, `createDate` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 13:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `isEpisode` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `podcast` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `author` TEXT, `thumbnailUrl` TEXT, `channelId` TEXT, `bookmarkedAt` INTEGER, `lastUpdateTime` INTEGER NOT NULL, `libraryAddToken` TEXT, `libraryRemoveToken` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 14:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `playbackPosition` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `uploadEntityId` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `artist` ADD COLUMN `isPodcastChannel` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 15:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `speed_dial_item` ADD COLUMN `subtitleIds` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `speed_dial_item` ADD COLUMN `albumId` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `speed_dial_item` ADD COLUMN `albumName` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 16:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `artist` ADD COLUMN `cachedPageJson` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 17:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `lyrics` (`id` TEXT NOT NULL, `lyrics` TEXT NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            case 18:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song_album_map` (`songId` TEXT NOT NULL, `albumId` TEXT NOT NULL, `index` INTEGER NOT NULL, PRIMARY KEY(`songId`, `albumId`), FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`albumId`) REFERENCES `album`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song_album_map` (`songId`,`albumId`,`index`) SELECT `songId`,`albumId`,`index` FROM `song_album_map`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song_album_map`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song_album_map` RENAME TO `song_album_map`");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_album_map_songId` ON `song_album_map` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_album_map_albumId` ON `song_album_map` (`albumId`)");
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA foreign_key_check(`song_album_map`)");
                try {
                    if (!sQLiteStatementPrepare.step()) {
                        StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                        SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                        SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                        SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                        return;
                    }
                    throw new SQLException(SQLite.processForeignKeyCheckFailure$DBUtil__DBUtilKt(sQLiteStatementPrepare));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                        throw th2;
                    }
                }
            case 19:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `related_song_map` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `songId` TEXT NOT NULL, `relatedSongId` TEXT NOT NULL, FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`relatedSongId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_related_song_map_songId` ON `related_song_map` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_related_song_map_relatedSongId` ON `related_song_map` (`relatedSongId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                return;
            default:
                super.migrate(sQLiteConnection);
                return;
        }
    }
}
