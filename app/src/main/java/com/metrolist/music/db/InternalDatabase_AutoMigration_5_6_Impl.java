package com.metrolist.music.db;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InternalDatabase_AutoMigration_5_6_Impl extends Migration {
    public final /* synthetic */ byte $r8$classId;
    public final AutoMigrationSpec callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalDatabase_AutoMigration_5_6_Impl(byte b) {
        super(5, 6);
        this.$r8$classId = b;
        switch (b) {
            case 1:
                super(10, 11);
                this.callback = new Migration7To8();
                break;
            case 2:
                super(11, 12);
                this.callback = new Converters((byte) 1);
                break;
            case 3:
                super(12, 13);
                this.callback = new Converters((byte) 2);
                break;
            case 4:
                super(13, 14);
                this.callback = new Converters((byte) 3);
                break;
            case 5:
                super(16, 17);
                this.callback = new Converters((byte) 4);
                break;
            case 6:
                super(18, 19);
                this.callback = new Converters((byte) 5);
                break;
            case 7:
                super(19, 20);
                this.callback = new Converters((byte) 6);
                break;
            case 8:
                super(20, 21);
                this.callback = new Migration7To8();
                break;
            case 9:
                super(21, 22);
                this.callback = new Converters((byte) 7);
                break;
            case 10:
                super(22, 23);
                this.callback = new Converters((byte) 8);
                break;
            case 11:
                super(23, 24);
                this.callback = new Converters((byte) 9);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                super(29, 30);
                this.callback = new Converters((byte) 10);
                break;
            case 13:
                super(35, 36);
                this.callback = new Converters((byte) 11);
                break;
            case 14:
                super(6, 7);
                this.callback = new Converters((byte) 13);
                break;
            case 15:
                super(7, 8);
                this.callback = new Migration7To8();
                break;
            case 16:
                super(9, 10);
                this.callback = new Migration7To8();
                break;
            default:
                this.callback = new Converters((byte) 12);
                break;
        }
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SQLiteConnection sQLiteConnection) {
        byte b = this.$r8$classId;
        AutoMigrationSpec autoMigrationSpec = this.callback;
        switch (b) {
            case 0:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `browseId` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `liked` INTEGER NOT NULL, `totalPlayTime` INTEGER NOT NULL, `downloadState` INTEGER NOT NULL, `createDate` INTEGER NOT NULL, `modifyDate` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`downloadState`,`createDate`,`modifyDate`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`download_state`,`create_date`,`modify_date` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_playlist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `browseId` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_playlist` (`id`,`name`) SELECT `id`,`name` FROM `playlist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `playlist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_playlist` RENAME TO `playlist`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 1:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `artist` ADD COLUMN `bookmarkedAt` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `liked` INTEGER NOT NULL, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`inLibrary`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`inLibrary` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_artist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `thumbnailUrl` TEXT, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_artist` (`id`,`name`,`thumbnailUrl`,`lastUpdateTime`) SELECT `id`,`name`,`thumbnailUrl`,`lastUpdateTime` FROM `artist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `artist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_artist` RENAME TO `artist`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Migration7To8) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 2:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `themeColor` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `bookmarkedAt` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `liked` INTEGER NOT NULL, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`inLibrary`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`inLibrary` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_album` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `year` INTEGER, `thumbnailUrl` TEXT, `themeColor` INTEGER, `songCount` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_album` (`id`,`title`,`year`,`thumbnailUrl`,`songCount`,`duration`,`lastUpdateTime`) SELECT `id`,`title`,`year`,`thumbnailUrl`,`songCount`,`duration`,`lastUpdateTime` FROM `album`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `album`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_album` RENAME TO `album`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 3:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 4:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `createdAt` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `lastUpdateTime` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 5:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `likedDate` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `inLibrary` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `remoteSongCount` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `playEndpointParams` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `shuffleEndpointParams` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `radioEndpointParams` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `format` ADD COLUMN `playbackUrl` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `year` INTEGER, `date` INTEGER, `dateModified` INTEGER, `liked` INTEGER NOT NULL, `likedDate` INTEGER, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, `dateDownload` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_artist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `thumbnailUrl` TEXT, `channelId` TEXT, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_artist` (`id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`) SELECT `id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt` FROM `artist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `artist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_artist` RENAME TO `artist`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_playlist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `browseId` TEXT, `createdAt` INTEGER, `lastUpdateTime` INTEGER, `isEditable` INTEGER NOT NULL DEFAULT true, `bookmarkedAt` INTEGER, `remoteSongCount` INTEGER, `playEndpointParams` TEXT, `shuffleEndpointParams` TEXT, `radioEndpointParams` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_playlist` (`id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`) SELECT `id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt` FROM `playlist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `playlist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_playlist` RENAME TO `playlist`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 6:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `artistName` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `explicit` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 7:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `explicit` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 8:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `isLocal` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `artist` ADD COLUMN `isLocal` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `isLocal` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `isLocal` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `explicit` INTEGER NOT NULL DEFAULT 0, `year` INTEGER, `date` INTEGER, `dateModified` INTEGER, `liked` INTEGER NOT NULL, `likedDate` INTEGER, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, `dateDownload` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Migration7To8) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 9:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `playlist` ADD COLUMN `thumbnailUrl` TEXT DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 10:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `explicit` INTEGER NOT NULL DEFAULT 0, `year` INTEGER, `date` INTEGER, `dateModified` INTEGER, `liked` INTEGER NOT NULL, `likedDate` INTEGER, `totalPlayTime` INTEGER NOT NULL, `inLibrary` INTEGER, `dateDownload` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, `libraryAddToken` TEXT, `libraryRemoveToken` TEXT, `romanizeLyrics` INTEGER NOT NULL DEFAULT true, `isDownloaded` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_song_albumId` ON `song` (`albumId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_artist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `thumbnailUrl` TEXT, `channelId` TEXT, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_artist` (`id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`,`isLocal`) SELECT `id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`,`isLocal` FROM `artist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `artist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_artist` RENAME TO `artist`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_album` (`id` TEXT NOT NULL, `playlistId` TEXT, `title` TEXT NOT NULL, `year` INTEGER, `thumbnailUrl` TEXT, `themeColor` INTEGER, `songCount` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `explicit` INTEGER NOT NULL DEFAULT 0, `lastUpdateTime` INTEGER NOT NULL, `bookmarkedAt` INTEGER, `likedDate` INTEGER, `inLibrary` INTEGER, `isLocal` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_album` (`id`,`playlistId`,`title`,`year`,`thumbnailUrl`,`themeColor`,`songCount`,`duration`,`explicit`,`lastUpdateTime`,`bookmarkedAt`,`likedDate`,`inLibrary`,`isLocal`) SELECT `id`,`playlistId`,`title`,`year`,`thumbnailUrl`,`themeColor`,`songCount`,`duration`,`explicit`,`lastUpdateTime`,`bookmarkedAt`,`likedDate`,`inLibrary`,`isLocal` FROM `album`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `album`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_album` RENAME TO `album`");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_playlist` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `browseId` TEXT, `createdAt` INTEGER, `lastUpdateTime` INTEGER, `isEditable` INTEGER NOT NULL DEFAULT true, `bookmarkedAt` INTEGER, `remoteSongCount` INTEGER, `playEndpointParams` TEXT, `thumbnailUrl` TEXT, `shuffleEndpointParams` TEXT, `radioEndpointParams` TEXT, `isLocal` INTEGER NOT NULL DEFAULT false, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_playlist` (`id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`,`remoteSongCount`,`playEndpointParams`,`thumbnailUrl`,`shuffleEndpointParams`,`radioEndpointParams`,`isLocal`) SELECT `id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`,`remoteSongCount`,`playEndpointParams`,`thumbnailUrl`,`shuffleEndpointParams`,`radioEndpointParams`,`isLocal` FROM `playlist`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `playlist`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_playlist` RENAME TO `playlist`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 11:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `isUploaded` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `album` ADD COLUMN `isUploaded` INTEGER NOT NULL DEFAULT false");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `lyrics` ADD COLUMN `provider` TEXT NOT NULL DEFAULT 'Unknown'");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 13:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `isCached` INTEGER NOT NULL DEFAULT 0");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 14:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `song` ADD COLUMN `inLibrary` INTEGER DEFAULT NULL");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Converters) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            case 15:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `event` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `songId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `playTime` INTEGER NOT NULL, FOREIGN KEY(`songId`) REFERENCES `song`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_event_songId` ON `event` (`songId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `_new_song` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `duration` INTEGER NOT NULL, `thumbnailUrl` TEXT, `albumId` TEXT, `albumName` TEXT, `liked` INTEGER NOT NULL, `totalPlayTime` INTEGER NOT NULL, `downloadState` INTEGER NOT NULL, `inLibrary` INTEGER, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "INSERT INTO `_new_song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`downloadState`,`inLibrary`) SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`liked`,`totalPlayTime`,`downloadState`,`inLibrary` FROM `song`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `song`");
                SQLite.execSQL(sQLiteConnection, "ALTER TABLE `_new_song` RENAME TO `song`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Migration7To8) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
            default:
                Format$$ExternalSyntheticOutline0.m(sQLiteConnection, sQLiteConnection, "DROP VIEW sorted_song_artist_map", sQLiteConnection, "DROP VIEW sorted_song_album_map");
                SQLite.execSQL(sQLiteConnection, "DROP VIEW playlist_song_map_preview");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE `download`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_artist_map` AS SELECT * FROM song_artist_map ORDER BY position");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `sorted_song_album_map` AS SELECT * FROM song_album_map ORDER BY `index`");
                SQLite.execSQL(sQLiteConnection, "CREATE VIEW `playlist_song_map_preview` AS SELECT * FROM playlist_song_map WHERE position <= 3 ORDER BY position");
                ((Migration7To8) autoMigrationSpec).onPostMigrate(sQLiteConnection);
                break;
        }
    }
}
