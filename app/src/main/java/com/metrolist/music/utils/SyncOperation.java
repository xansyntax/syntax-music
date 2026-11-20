package com.metrolist.music.utils;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.db.entities.SongEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SyncOperation {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ArtistsSubscriptions extends SyncOperation {
        public static final ArtistsSubscriptions INSTANCE = new ArtistsSubscriptions();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof ArtistsSubscriptions);
        }

        public final int hashCode() {
            return 1051005334;
        }

        public final String toString() {
            return "ArtistsSubscriptions";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AutoSyncPlaylists extends SyncOperation {
        public static final AutoSyncPlaylists INSTANCE = new AutoSyncPlaylists();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof AutoSyncPlaylists);
        }

        public final int hashCode() {
            return 793721163;
        }

        public final String toString() {
            return "AutoSyncPlaylists";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClearPodcastData extends SyncOperation {
        public static final ClearPodcastData INSTANCE = new ClearPodcastData();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof ClearPodcastData);
        }

        public final int hashCode() {
            return 1339991949;
        }

        public final String toString() {
            return "ClearPodcastData";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EpisodesForLater extends SyncOperation {
        public static final EpisodesForLater INSTANCE = new EpisodesForLater();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof EpisodesForLater);
        }

        public final int hashCode() {
            return -1824203641;
        }

        public final String toString() {
            return "EpisodesForLater";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FullSync extends SyncOperation {
        public static final FullSync INSTANCE = new FullSync();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof FullSync);
        }

        public final int hashCode() {
            return -419770090;
        }

        public final String toString() {
            return "FullSync";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LibrarySongs extends SyncOperation {
        public static final LibrarySongs INSTANCE = new LibrarySongs();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof LibrarySongs);
        }

        public final int hashCode() {
            return -861221041;
        }

        public final String toString() {
            return "LibrarySongs";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LikeSong extends SyncOperation {
        public final SongEntity song;

        public LikeSong(SongEntity songEntity) {
            this.song = songEntity;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LikeSong) && this.song.equals(((LikeSong) obj).song);
        }

        public final int hashCode() {
            return this.song.hashCode();
        }

        public final String toString() {
            return "LikeSong(song=" + this.song + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LikedAlbums extends SyncOperation {
        public static final LikedAlbums INSTANCE = new LikedAlbums();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof LikedAlbums);
        }

        public final int hashCode() {
            return 535787301;
        }

        public final String toString() {
            return "LikedAlbums";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LikedSongs extends SyncOperation {
        public static final LikedSongs INSTANCE = new LikedSongs();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof LikedSongs);
        }

        public final int hashCode() {
            return 449649309;
        }

        public final String toString() {
            return "LikedSongs";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PodcastSubscriptions extends SyncOperation {
        public static final PodcastSubscriptions INSTANCE = new PodcastSubscriptions();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof PodcastSubscriptions);
        }

        public final int hashCode() {
            return -423040098;
        }

        public final String toString() {
            return "PodcastSubscriptions";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SaveEpisode extends SyncOperation {
        public final String episodeId;
        public final boolean save;
        public final String setVideoId;

        public SaveEpisode(String str, String str2, boolean z) {
            str.getClass();
            this.episodeId = str;
            this.save = z;
            this.setVideoId = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SaveEpisode)) {
                return false;
            }
            SaveEpisode saveEpisode = (SaveEpisode) obj;
            return Intrinsics.areEqual(this.episodeId, saveEpisode.episodeId) && this.save == saveEpisode.save && Intrinsics.areEqual(this.setVideoId, saveEpisode.setVideoId);
        }

        public final int hashCode() {
            int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.episodeId.hashCode() * 31, this.save, 31);
            String str = this.setVideoId;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("SaveEpisode(episodeId=");
            sb.append(this.episodeId);
            sb.append(", save=");
            sb.append(this.save);
            sb.append(", setVideoId=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.setVideoId, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SavePodcast extends SyncOperation {
        public final String podcastId;
        public final boolean save;

        public SavePodcast(String str, boolean z) {
            str.getClass();
            this.podcastId = str;
            this.save = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SavePodcast)) {
                return false;
            }
            SavePodcast savePodcast = (SavePodcast) obj;
            return Intrinsics.areEqual(this.podcastId, savePodcast.podcastId) && this.save == savePodcast.save;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.save) + (this.podcastId.hashCode() * 31);
        }

        public final String toString() {
            return "SavePodcast(podcastId=" + this.podcastId + ", save=" + this.save + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SavedPlaylists extends SyncOperation {
        public static final SavedPlaylists INSTANCE = new SavedPlaylists();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof SavedPlaylists);
        }

        public final int hashCode() {
            return -346871706;
        }

        public final String toString() {
            return "SavedPlaylists";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SubscribeChannel extends SyncOperation {
        public final String channelId;
        public final boolean subscribe;

        public SubscribeChannel(String str, boolean z) {
            str.getClass();
            this.channelId = str;
            this.subscribe = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubscribeChannel)) {
                return false;
            }
            SubscribeChannel subscribeChannel = (SubscribeChannel) obj;
            return Intrinsics.areEqual(this.channelId, subscribeChannel.channelId) && this.subscribe == subscribeChannel.subscribe;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.subscribe) + (this.channelId.hashCode() * 31);
        }

        public final String toString() {
            return "SubscribeChannel(channelId=" + this.channelId + ", subscribe=" + this.subscribe + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UploadedAlbums extends SyncOperation {
        public static final UploadedAlbums INSTANCE = new UploadedAlbums();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof UploadedAlbums);
        }

        public final int hashCode() {
            return 1294919856;
        }

        public final String toString() {
            return "UploadedAlbums";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UploadedSongs extends SyncOperation {
        public static final UploadedSongs INSTANCE = new UploadedSongs();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof UploadedSongs);
        }

        public final int hashCode() {
            return -1604072526;
        }

        public final String toString() {
            return "UploadedSongs";
        }
    }
}
