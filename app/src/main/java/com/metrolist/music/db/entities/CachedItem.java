package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00022\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem;", "", "Companion", "Song", "Album", "Playlist", "Artist", "Podcast", "Episode", "Lcom/metrolist/music/db/entities/CachedItem$Album;", "Lcom/metrolist/music/db/entities/CachedItem$Artist;", "Lcom/metrolist/music/db/entities/CachedItem$Episode;", "Lcom/metrolist/music/db/entities/CachedItem$Playlist;", "Lcom/metrolist/music/db/entities/CachedItem$Podcast;", "Lcom/metrolist/music/db/entities/CachedItem$Song;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public abstract class CachedItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy $cachedSerializer$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new CachedItem$$ExternalSyntheticLambda0((byte) 0));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedItem;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return (KSerializer) CachedItem.$cachedSerializer$delegate.getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Artist;", "Lcom/metrolist/music/db/entities/CachedItem;", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Artist extends CachedItem {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String channelId;
        public final String id;
        public final String thumbnail;
        public final String title;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Artist$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedItem$Artist;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return CachedItem$Artist$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Artist(int i, String str, String str2, String str3, String str4) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(CachedItem$Artist$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            if ((i & 8) == 0) {
                this.channelId = null;
            } else {
                this.channelId = str4;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Artist)) {
                return false;
            }
            Artist artist = (Artist) obj;
            return Intrinsics.areEqual(this.id, artist.id) && Intrinsics.areEqual(this.title, artist.title) && Intrinsics.areEqual(this.thumbnail, artist.thumbnail) && Intrinsics.areEqual(this.channelId, artist.channelId);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.thumbnail);
            String str = this.channelId;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Artist(id=", this.id, ", title=", this.title, ", thumbnail="), this.thumbnail, ", channelId=", this.channelId, ")");
        }

        public Artist(String str, String str2, String str3, String str4) {
            str.getClass();
            str2.getClass();
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            this.channelId = str4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Playlist;", "Lcom/metrolist/music/db/entities/CachedItem;", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Playlist extends CachedItem {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final CachedArtist author;
        public final String authorAvatarUrl;
        public final String id;
        public final String songCountText;
        public final String thumbnail;
        public final String title;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Playlist$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedItem$Playlist;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return CachedItem$Playlist$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Playlist(int i, String str, String str2, String str3, CachedArtist cachedArtist, String str4, String str5) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(CachedItem$Playlist$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            if ((i & 8) == 0) {
                this.author = null;
            } else {
                this.author = cachedArtist;
            }
            if ((i & 16) == 0) {
                this.songCountText = null;
            } else {
                this.songCountText = str4;
            }
            if ((i & 32) == 0) {
                this.authorAvatarUrl = null;
            } else {
                this.authorAvatarUrl = str5;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Playlist)) {
                return false;
            }
            Playlist playlist = (Playlist) obj;
            return Intrinsics.areEqual(this.id, playlist.id) && Intrinsics.areEqual(this.title, playlist.title) && Intrinsics.areEqual(this.thumbnail, playlist.thumbnail) && Intrinsics.areEqual(this.author, playlist.author) && Intrinsics.areEqual(this.songCountText, playlist.songCountText) && Intrinsics.areEqual(this.authorAvatarUrl, playlist.authorAvatarUrl);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.thumbnail);
            CachedArtist cachedArtist = this.author;
            int iHashCode = (iM + (cachedArtist == null ? 0 : cachedArtist.hashCode())) * 31;
            String str = this.songCountText;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.authorAvatarUrl;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Playlist(id=", this.id, ", title=", this.title, ", thumbnail=");
            sbM.append(this.thumbnail);
            sbM.append(", author=");
            sbM.append(this.author);
            sbM.append(", songCountText=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.songCountText, ", authorAvatarUrl=", this.authorAvatarUrl, ")");
        }

        public Playlist(String str, String str2, String str3, CachedArtist cachedArtist, String str4, String str5) {
            str.getClass();
            str2.getClass();
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            this.author = cachedArtist;
            this.songCountText = str4;
            this.authorAvatarUrl = str5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Podcast;", "Lcom/metrolist/music/db/entities/CachedItem;", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Podcast extends CachedItem {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final CachedArtist author;
        public final String channelId;
        public final String episodeCountText;
        public final String id;
        public final String thumbnail;
        public final String title;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Podcast$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedItem$Podcast;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return CachedItem$Podcast$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Podcast(int i, String str, String str2, String str3, CachedArtist cachedArtist, String str4, String str5) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(CachedItem$Podcast$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            if ((i & 8) == 0) {
                this.author = null;
            } else {
                this.author = cachedArtist;
            }
            if ((i & 16) == 0) {
                this.episodeCountText = null;
            } else {
                this.episodeCountText = str4;
            }
            if ((i & 32) == 0) {
                this.channelId = null;
            } else {
                this.channelId = str5;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Podcast)) {
                return false;
            }
            Podcast podcast = (Podcast) obj;
            return Intrinsics.areEqual(this.id, podcast.id) && Intrinsics.areEqual(this.title, podcast.title) && Intrinsics.areEqual(this.thumbnail, podcast.thumbnail) && Intrinsics.areEqual(this.author, podcast.author) && Intrinsics.areEqual(this.episodeCountText, podcast.episodeCountText) && Intrinsics.areEqual(this.channelId, podcast.channelId);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.thumbnail);
            CachedArtist cachedArtist = this.author;
            int iHashCode = (iM + (cachedArtist == null ? 0 : cachedArtist.hashCode())) * 31;
            String str = this.episodeCountText;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.channelId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Podcast(id=", this.id, ", title=", this.title, ", thumbnail=");
            sbM.append(this.thumbnail);
            sbM.append(", author=");
            sbM.append(this.author);
            sbM.append(", episodeCountText=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.episodeCountText, ", channelId=", this.channelId, ")");
        }

        public Podcast(String str, String str2, String str3, CachedArtist cachedArtist, String str4, String str5) {
            str.getClass();
            str2.getClass();
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            this.author = cachedArtist;
            this.episodeCountText = str4;
            this.channelId = str5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Episode;", "Lcom/metrolist/music/db/entities/CachedItem;", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Episode extends CachedItem {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final CachedAlbum album;
        public final CachedArtist author;
        public final Integer duration;
        public final boolean explicit;
        public final String id;
        public final String thumbnail;
        public final String title;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Episode$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedItem$Episode;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return CachedItem$Episode$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Episode(int i, String str, String str2, String str3, boolean z, CachedArtist cachedArtist, CachedAlbum cachedAlbum, Integer num) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(CachedItem$Episode$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            if ((i & 8) == 0) {
                this.explicit = false;
            } else {
                this.explicit = z;
            }
            if ((i & 16) == 0) {
                this.author = null;
            } else {
                this.author = cachedArtist;
            }
            if ((i & 32) == 0) {
                this.album = null;
            } else {
                this.album = cachedAlbum;
            }
            if ((i & 64) == 0) {
                this.duration = null;
            } else {
                this.duration = num;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Episode)) {
                return false;
            }
            Episode episode = (Episode) obj;
            return Intrinsics.areEqual(this.id, episode.id) && Intrinsics.areEqual(this.title, episode.title) && Intrinsics.areEqual(this.thumbnail, episode.thumbnail) && this.explicit == episode.explicit && Intrinsics.areEqual(this.author, episode.author) && Intrinsics.areEqual(this.album, episode.album) && Intrinsics.areEqual(this.duration, episode.duration);
        }

        public final int hashCode() {
            int iM = IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.thumbnail), this.explicit, 31);
            CachedArtist cachedArtist = this.author;
            int iHashCode = (iM + (cachedArtist == null ? 0 : cachedArtist.hashCode())) * 31;
            CachedAlbum cachedAlbum = this.album;
            int iHashCode2 = (iHashCode + (cachedAlbum == null ? 0 : cachedAlbum.hashCode())) * 31;
            Integer num = this.duration;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Episode(id=", this.id, ", title=", this.title, ", thumbnail=");
            sbM.append(this.thumbnail);
            sbM.append(", explicit=");
            sbM.append(this.explicit);
            sbM.append(", author=");
            sbM.append(this.author);
            sbM.append(", album=");
            sbM.append(this.album);
            sbM.append(", duration=");
            sbM.append(this.duration);
            sbM.append(")");
            return sbM.toString();
        }

        public Episode(String str, String str2, String str3, boolean z, CachedArtist cachedArtist, CachedAlbum cachedAlbum, Integer num) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            this.explicit = z;
            this.author = cachedArtist;
            this.album = cachedAlbum;
            this.duration = num;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Album;", "Lcom/metrolist/music/db/entities/CachedItem;", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Album extends CachedItem {
        public final List artists;
        public final String browseId;
        public final boolean explicit;
        public final String id;
        public final String playlistId;
        public final String thumbnail;
        public final String title;
        public final Integer year;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new CachedItem$$ExternalSyntheticLambda0((byte) 3)), null, null, null};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Album$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedItem$Album;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return CachedItem$Album$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Album(int i, String str, String str2, String str3, boolean z, List list, Integer num, String str4, String str5) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(CachedItem$Album$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            if ((i & 8) == 0) {
                this.explicit = false;
            } else {
                this.explicit = z;
            }
            if ((i & 16) == 0) {
                this.artists = EmptyList.INSTANCE;
            } else {
                this.artists = list;
            }
            if ((i & 32) == 0) {
                this.year = null;
            } else {
                this.year = num;
            }
            if ((i & 64) == 0) {
                this.browseId = null;
            } else {
                this.browseId = str4;
            }
            if ((i & 128) == 0) {
                this.playlistId = null;
            } else {
                this.playlistId = str5;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Album)) {
                return false;
            }
            Album album = (Album) obj;
            return Intrinsics.areEqual(this.id, album.id) && Intrinsics.areEqual(this.title, album.title) && Intrinsics.areEqual(this.thumbnail, album.thumbnail) && this.explicit == album.explicit && Intrinsics.areEqual(this.artists, album.artists) && Intrinsics.areEqual(this.year, album.year) && Intrinsics.areEqual(this.browseId, album.browseId) && Intrinsics.areEqual(this.playlistId, album.playlistId);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.thumbnail), this.explicit, 31), 31, this.artists);
            Integer num = this.year;
            int iHashCode = (iM + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.browseId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.playlistId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Album(id=", this.id, ", title=", this.title, ", thumbnail=");
            sbM.append(this.thumbnail);
            sbM.append(", explicit=");
            sbM.append(this.explicit);
            sbM.append(", artists=");
            sbM.append(this.artists);
            sbM.append(", year=");
            sbM.append(this.year);
            sbM.append(", browseId=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.browseId, ", playlistId=", this.playlistId, ")");
        }

        public Album(Integer num, String str, String str2, String str3, String str4, String str5, List list, boolean z) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            this.explicit = z;
            this.artists = list;
            this.year = num;
            this.browseId = str4;
            this.playlistId = str5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Song;", "Lcom/metrolist/music/db/entities/CachedItem;", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Song extends CachedItem {
        public final CachedAlbum album;
        public final List artists;
        public final Integer duration;
        public final boolean explicit;
        public final String id;
        public final String thumbnail;
        public final String title;
        public final String videoId;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new CachedItem$$ExternalSyntheticLambda0((byte) 4)), null, null, null};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedItem$Song$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedItem$Song;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return CachedItem$Song$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Song(int i, String str, String str2, String str3, boolean z, List list, CachedAlbum cachedAlbum, Integer num, String str4) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(CachedItem$Song$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            if ((i & 8) == 0) {
                this.explicit = false;
            } else {
                this.explicit = z;
            }
            if ((i & 16) == 0) {
                this.artists = EmptyList.INSTANCE;
            } else {
                this.artists = list;
            }
            if ((i & 32) == 0) {
                this.album = null;
            } else {
                this.album = cachedAlbum;
            }
            if ((i & 64) == 0) {
                this.duration = null;
            } else {
                this.duration = num;
            }
            if ((i & 128) == 0) {
                this.videoId = null;
            } else {
                this.videoId = str4;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Song)) {
                return false;
            }
            Song song = (Song) obj;
            return Intrinsics.areEqual(this.id, song.id) && Intrinsics.areEqual(this.title, song.title) && Intrinsics.areEqual(this.thumbnail, song.thumbnail) && this.explicit == song.explicit && Intrinsics.areEqual(this.artists, song.artists) && Intrinsics.areEqual(this.album, song.album) && Intrinsics.areEqual(this.duration, song.duration) && Intrinsics.areEqual(this.videoId, song.videoId);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.thumbnail), this.explicit, 31), 31, this.artists);
            CachedAlbum cachedAlbum = this.album;
            int iHashCode = (iM + (cachedAlbum == null ? 0 : cachedAlbum.hashCode())) * 31;
            Integer num = this.duration;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.videoId;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Song(id=", this.id, ", title=", this.title, ", thumbnail=");
            sbM.append(this.thumbnail);
            sbM.append(", explicit=");
            sbM.append(this.explicit);
            sbM.append(", artists=");
            sbM.append(this.artists);
            sbM.append(", album=");
            sbM.append(this.album);
            sbM.append(", duration=");
            sbM.append(this.duration);
            sbM.append(", videoId=");
            sbM.append(this.videoId);
            sbM.append(")");
            return sbM.toString();
        }

        public Song(String str, String str2, String str3, boolean z, ArrayList arrayList, CachedAlbum cachedAlbum, Integer num, String str4) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            this.id = str;
            this.title = str2;
            this.thumbnail = str3;
            this.explicit = z;
            this.artists = arrayList;
            this.album = cachedAlbum;
            this.duration = num;
            this.videoId = str4;
        }
    }
}
