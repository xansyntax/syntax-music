package com.metrolist.music.db;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.time.LocalDateTime;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity {
    public final LocalDateTime createDate;
    public final int duration;
    public final String id;
    public final boolean liked;
    public final LocalDateTime modifyDate;
    public final String title;

    public MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity(String str, String str2, int i, boolean z, LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        this.id = str;
        this.title = str2;
        this.duration = i;
        this.liked = z;
        this.createDate = localDateTime;
        this.modifyDate = localDateTime2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity)) {
            return false;
        }
        MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity = (MusicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity) obj;
        return this.id.equals(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.id) && this.title.equals(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.title) && this.duration == musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.duration && this.liked == musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.liked && this.createDate.equals(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.createDate) && this.modifyDate.equals(musicDatabaseKt$MIGRATION_1_2$1$migrate$OldSongEntity.modifyDate);
    }

    public final int hashCode() {
        return this.modifyDate.hashCode() + ((this.createDate.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(0, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.duration, Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 923521), this.liked, 31), 31, 0L), 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("OldSongEntity(id=", this.id, ", title=", this.title, ", duration=");
        sbM.append(this.duration);
        sbM.append(", thumbnailUrl=null, albumId=null, albumName=null, liked=");
        sbM.append(this.liked);
        sbM.append(", totalPlayTime=0, downloadState=0, createDate=");
        sbM.append(this.createDate);
        sbM.append(", modifyDate=");
        sbM.append(this.modifyDate);
        sbM.append(")");
        return sbM.toString();
    }
}
