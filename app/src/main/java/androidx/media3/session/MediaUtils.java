package androidx.media3.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaUtils {
    public static final Splitter defaultBrowserRoot = new Splitter("androidx.media3.session.MediaLibraryService", (Bundle) null);

    public static boolean areSessionPositionInfosInSamePeriodOrAd(SessionPositionInfo sessionPositionInfo, SessionPositionInfo sessionPositionInfo2) {
        Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
        int i = positionInfo.mediaItemIndex;
        Player.PositionInfo positionInfo2 = sessionPositionInfo2.positionInfo;
        return i == positionInfo2.mediaItemIndex && positionInfo.periodIndex == positionInfo2.periodIndex && positionInfo.adGroupIndex == positionInfo2.adGroupIndex && positionInfo.adIndexInAdGroup == positionInfo2.adIndexInAdGroup;
    }

    public static int calculateBufferedPercentage(long j, long j2) {
        if (j == -9223372036854775807L || j2 == -9223372036854775807L) {
            return 0;
        }
        if (j2 == 0) {
            return 100;
        }
        return Util.constrainValue(Util.percentInt(j, j2), 0, 100);
    }

    public static long getUpdatedCurrentPositionMs(PlayerInfo playerInfo, long j, long j2, long j3) {
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        boolean z = sessionPositionInfo.equals(SessionPositionInfo.DEFAULT) || j2 < sessionPositionInfo.eventTimeMs;
        if (playerInfo.isPlaying) {
            if (z || j == -9223372036854775807L) {
                if (j3 == -9223372036854775807L) {
                    j3 = SystemClock.elapsedRealtime() - sessionPositionInfo.eventTimeMs;
                }
                long j4 = sessionPositionInfo.positionInfo.positionMs + ((long) (j3 * playerInfo.playbackParameters.speed));
                long j5 = sessionPositionInfo.durationMs;
                return j5 != -9223372036854775807L ? Math.min(j4, j5) : j4;
            }
        } else if (z || j == -9223372036854775807L) {
            return sessionPositionInfo.positionInfo.positionMs;
        }
        return j;
    }

    public static Player.Commands intersect(Player.Commands commands, Player.Commands commands2) {
        if (commands != null) {
            FlagSet flagSet = commands.flags;
            if (commands2 != null) {
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
                for (int i = 0; i < flagSet.flags.size(); i++) {
                    if (commands2.contains(flagSet.get(i))) {
                        int i2 = flagSet.get(i);
                        UtilsKt.checkState(!false);
                        sparseBooleanArray.append(i2, true);
                    }
                }
                UtilsKt.checkState(!false);
                return new Player.Commands(new FlagSet(sparseBooleanArray));
            }
        }
        return Player.Commands.EMPTY;
    }

    public static PlayerInfo mergePlayerInfo(PlayerInfo playerInfo, PlayerInfo playerInfo2, PlayerInfo.BundlingExclusions bundlingExclusions, Player.Commands commands, boolean z, SessionToken sessionToken) {
        PlayerInfo playerInfoCopyWithCurrentTracks;
        Tracks tracks;
        boolean z2;
        if (bundlingExclusions.isTimelineExcluded && commands.contains(17)) {
            Timeline timeline = playerInfo.timeline;
            DatabaseDao_Impl.AnonymousClass17.checkState("Invalid PlayerInfo update, old index: " + playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex + " (count=" + timeline.getWindowCount() + "), new index = " + playerInfo2.sessionPositionInfo.positionInfo.mediaItemIndex + ", sent from " + sessionToken.impl.getPackageName() + ", interface version=" + sessionToken.impl.getInterfaceVersion(), timeline.isEmpty() || playerInfo2.sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
            playerInfoCopyWithCurrentTracks = playerInfo2.copyWithTimeline(timeline);
        } else {
            playerInfoCopyWithCurrentTracks = playerInfo2;
        }
        if (bundlingExclusions.areCurrentTracksExcluded && commands.contains(30)) {
            playerInfoCopyWithCurrentTracks = playerInfoCopyWithCurrentTracks.copyWithCurrentTracks(playerInfo.currentTracks);
        }
        if (!z || playerInfo2.volume != CropImageView.DEFAULT_ASPECT_RATIO) {
            return playerInfoCopyWithCurrentTracks;
        }
        float f = playerInfo.unmuteVolume;
        PlaybackException playbackException = playerInfoCopyWithCurrentTracks.playerError;
        int i = playerInfoCopyWithCurrentTracks.mediaItemTransitionReason;
        SessionPositionInfo sessionPositionInfo = playerInfoCopyWithCurrentTracks.sessionPositionInfo;
        Player.PositionInfo positionInfo = playerInfoCopyWithCurrentTracks.oldPositionInfo;
        Player.PositionInfo positionInfo2 = playerInfoCopyWithCurrentTracks.newPositionInfo;
        int i2 = playerInfoCopyWithCurrentTracks.discontinuityReason;
        PlaybackParameters playbackParameters = playerInfoCopyWithCurrentTracks.playbackParameters;
        int i3 = playerInfoCopyWithCurrentTracks.repeatMode;
        boolean z3 = playerInfoCopyWithCurrentTracks.shuffleModeEnabled;
        Timeline timeline2 = playerInfoCopyWithCurrentTracks.timeline;
        int i4 = playerInfoCopyWithCurrentTracks.timelineChangeReason;
        VideoSize videoSize = playerInfoCopyWithCurrentTracks.videoSize;
        MediaMetadata mediaMetadata = playerInfoCopyWithCurrentTracks.playlistMetadata;
        float f2 = playerInfoCopyWithCurrentTracks.volume;
        int i5 = playerInfoCopyWithCurrentTracks.audioSessionId;
        AudioAttributes audioAttributes = playerInfoCopyWithCurrentTracks.audioAttributes;
        CueGroup cueGroup = playerInfoCopyWithCurrentTracks.cueGroup;
        DeviceInfo deviceInfo = playerInfoCopyWithCurrentTracks.deviceInfo;
        int i6 = playerInfoCopyWithCurrentTracks.deviceVolume;
        boolean z4 = playerInfoCopyWithCurrentTracks.deviceMuted;
        boolean z5 = playerInfoCopyWithCurrentTracks.playWhenReady;
        int i7 = playerInfoCopyWithCurrentTracks.playWhenReadyChangeReason;
        boolean z6 = playerInfoCopyWithCurrentTracks.isPlaying;
        boolean z7 = playerInfoCopyWithCurrentTracks.isLoading;
        int i8 = playerInfoCopyWithCurrentTracks.playbackSuppressionReason;
        int i9 = playerInfoCopyWithCurrentTracks.playbackState;
        MediaMetadata mediaMetadata2 = playerInfoCopyWithCurrentTracks.mediaMetadata;
        long j = playerInfoCopyWithCurrentTracks.seekBackIncrementMs;
        long j2 = playerInfoCopyWithCurrentTracks.seekForwardIncrementMs;
        long j3 = playerInfoCopyWithCurrentTracks.maxSeekToPreviousPositionMs;
        Tracks tracks2 = playerInfoCopyWithCurrentTracks.currentTracks;
        TrackSelectionParameters trackSelectionParameters = playerInfoCopyWithCurrentTracks.trackSelectionParameters;
        if (!timeline2.isEmpty()) {
            tracks = tracks2;
            if (sessionPositionInfo.positionInfo.mediaItemIndex >= timeline2.getWindowCount()) {
                z2 = false;
            }
            UtilsKt.checkState(z2);
            return new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z3, videoSize, timeline2, i4, mediaMetadata, f2, f, audioAttributes, i5, cueGroup, deviceInfo, i6, z4, z5, i7, i8, i9, z6, z7, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
        }
        tracks = tracks2;
        z2 = true;
        UtilsKt.checkState(z2);
        return new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z3, videoSize, timeline2, i4, mediaMetadata, f2, f, audioAttributes, i5, cueGroup, deviceInfo, i6, z4, z5, i7, i8, i9, z6, z7, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
    }

    public static void setMediaItemsWithStartIndexAndPosition(Player player, MediaSession$MediaItemsWithStartPosition mediaSession$MediaItemsWithStartPosition) {
        int i = mediaSession$MediaItemsWithStartPosition.startIndex;
        long j = mediaSession$MediaItemsWithStartPosition.startPositionMs;
        ImmutableList immutableList = mediaSession$MediaItemsWithStartPosition.mediaItems;
        if (i == -1) {
            if (player.isCommandAvailable(20)) {
                player.setMediaItems(immutableList);
                return;
            } else {
                if (immutableList.isEmpty()) {
                    return;
                }
                player.setMediaItem$1((MediaItem) immutableList.get(0));
                return;
            }
        }
        if (player.isCommandAvailable(20)) {
            player.setMediaItems(immutableList, mediaSession$MediaItemsWithStartPosition.startIndex, j);
        } else {
            if (immutableList.isEmpty()) {
                return;
            }
            player.setMediaItem((MediaItem) immutableList.get(0), j);
        }
    }

    public static ArrayList truncateListBySize(List list) {
        ArrayList arrayList = new ArrayList();
        Parcel parcelObtain = Parcel.obtain();
        for (int i = 0; i < list.size(); i++) {
            try {
                Parcelable parcelable = (Parcelable) list.get(i);
                parcelObtain.writeParcelable(parcelable, 0);
                if (parcelObtain.dataSize() >= 262144) {
                    break;
                }
                arrayList.add(parcelable);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        parcelObtain.recycle();
        return arrayList;
    }
}
