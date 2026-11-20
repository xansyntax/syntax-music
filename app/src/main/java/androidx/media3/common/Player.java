package androidx.media3.common;

import android.os.Bundle;
import android.os.Looper;
import android.util.SparseBooleanArray;
import android.view.SurfaceHolder;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Player {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Commands {
        public static final Commands EMPTY;
        public static final String FIELD_COMMANDS;
        public final FlagSet flags;

        static {
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            UtilsKt.checkState(!false);
            EMPTY = new Commands(new FlagSet(sparseBooleanArray));
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_COMMANDS = Integer.toString(0, 36);
        }

        public Commands(FlagSet flagSet) {
            this.flags = flagSet;
        }

        public static Commands fromBundle(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(FIELD_COMMANDS);
            if (integerArrayList == null) {
                return EMPTY;
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            for (int i = 0; i < integerArrayList.size(); i++) {
                int iIntValue = integerArrayList.get(i).intValue();
                UtilsKt.checkState(!false);
                sparseBooleanArray.append(iIntValue, true);
            }
            UtilsKt.checkState(!false);
            return new Commands(new FlagSet(sparseBooleanArray));
        }

        public final boolean contains(int i) {
            return this.flags.flags.get(i);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Commands) {
                return this.flags.equals(((Commands) obj).flags);
            }
            return false;
        }

        public final int hashCode() {
            return this.flags.flags.hashCode();
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                FlagSet flagSet = this.flags;
                if (i >= flagSet.flags.size()) {
                    bundle.putIntegerArrayList(FIELD_COMMANDS, arrayList);
                    return bundle;
                }
                arrayList.add(Integer.valueOf(flagSet.get(i)));
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Events {
        public final FlagSet flags;

        public Events(FlagSet flagSet) {
            this.flags = flagSet;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Events) {
                return this.flags.equals(((Events) obj).flags);
            }
            return false;
        }

        public final int hashCode() {
            return this.flags.flags.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Listener {
        default void onCues(List list) {
        }

        default void onPositionDiscontinuity(int i, PositionInfo positionInfo, PositionInfo positionInfo2) {
        }

        default void onRenderedFirstFrame() {
        }

        default void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        }

        default void onAudioSessionIdChanged(int i) {
        }

        default void onAvailableCommandsChanged(Commands commands) {
        }

        default void onCues(CueGroup cueGroup) {
        }

        default void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        }

        default void onIsLoadingChanged(boolean z) {
        }

        default void onIsPlayingChanged(boolean z) {
        }

        default void onLoadingChanged(boolean z) {
        }

        default void onMaxSeekToPreviousPositionChanged(long j) {
        }

        default void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        }

        default void onMetadata(Metadata metadata) {
        }

        default void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        default void onPlaybackStateChanged(int i) {
        }

        default void onPlaybackSuppressionReasonChanged(int i) {
        }

        default void onPlayerError(PlaybackException playbackException) {
        }

        default void onPlayerErrorChanged(PlaybackException playbackException) {
        }

        default void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        }

        default void onPositionDiscontinuity(int i) {
        }

        default void onRepeatModeChanged(int i) {
        }

        default void onSeekBackIncrementChanged(long j) {
        }

        default void onSeekForwardIncrementChanged(long j) {
        }

        default void onShuffleModeEnabledChanged(boolean z) {
        }

        default void onSkipSilenceEnabledChanged(boolean z) {
        }

        default void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        }

        default void onTracksChanged(Tracks tracks) {
        }

        default void onVideoSizeChanged(VideoSize videoSize) {
        }

        default void onVolumeChanged(float f) {
        }

        default void onDeviceVolumeChanged(int i, boolean z) {
        }

        default void onEvents(Player player, Events events) {
        }

        default void onMediaItemTransition(int i, MediaItem mediaItem) {
        }

        default void onPlayWhenReadyChanged(int i, boolean z) {
        }

        default void onPlayerStateChanged(int i, boolean z) {
        }

        default void onSurfaceSizeChanged(int i, int i2) {
        }

        default void onTimelineChanged(Timeline timeline, int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PositionInfo {
        public static final String FIELD_AD_GROUP_INDEX;
        public static final String FIELD_AD_INDEX_IN_AD_GROUP;
        public static final String FIELD_CONTENT_POSITION_MS;
        public static final String FIELD_MEDIA_ITEM;
        public static final String FIELD_MEDIA_ITEM_INDEX;
        public static final String FIELD_PERIOD_INDEX;
        public static final String FIELD_POSITION_MS;
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final long contentPositionMs;
        public final MediaItem mediaItem;
        public final int mediaItemIndex;
        public final int periodIndex;
        public final Object periodUid;
        public final long positionMs;
        public final Object windowUid;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_MEDIA_ITEM_INDEX = Integer.toString(0, 36);
            FIELD_MEDIA_ITEM = Integer.toString(1, 36);
            FIELD_PERIOD_INDEX = Integer.toString(2, 36);
            FIELD_POSITION_MS = Integer.toString(3, 36);
            FIELD_CONTENT_POSITION_MS = Integer.toString(4, 36);
            FIELD_AD_GROUP_INDEX = Integer.toString(5, 36);
            FIELD_AD_INDEX_IN_AD_GROUP = Integer.toString(6, 36);
        }

        public PositionInfo(Object obj, int i, MediaItem mediaItem, Object obj2, int i2, long j, long j2, int i3, int i4) {
            UtilsKt.checkArgument(i >= 0);
            UtilsKt.checkArgument(i2 >= 0);
            this.windowUid = obj;
            this.mediaItemIndex = i;
            this.mediaItem = mediaItem;
            this.periodUid = obj2;
            this.periodIndex = i2;
            this.positionMs = j;
            this.contentPositionMs = j2;
            this.adGroupIndex = i3;
            this.adIndexInAdGroup = i4;
        }

        public static PositionInfo fromBundle(int i, Bundle bundle) {
            int iMax = Math.max(0, bundle.getInt(FIELD_MEDIA_ITEM_INDEX, 0));
            Bundle bundle2 = bundle.getBundle(FIELD_MEDIA_ITEM);
            return new PositionInfo(null, iMax, bundle2 == null ? null : MediaItem.fromBundle(i, bundle2), null, Math.max(0, bundle.getInt(FIELD_PERIOD_INDEX, 0)), bundle.getLong(FIELD_POSITION_MS, 0L), bundle.getLong(FIELD_CONTENT_POSITION_MS, 0L), bundle.getInt(FIELD_AD_GROUP_INDEX, -1), bundle.getInt(FIELD_AD_INDEX_IN_AD_GROUP, -1));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PositionInfo.class == obj.getClass()) {
                PositionInfo positionInfo = (PositionInfo) obj;
                if (equalsForBundling(positionInfo) && Objects.equals(this.windowUid, positionInfo.windowUid) && Objects.equals(this.periodUid, positionInfo.periodUid)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean equalsForBundling(PositionInfo positionInfo) {
            return this.mediaItemIndex == positionInfo.mediaItemIndex && this.periodIndex == positionInfo.periodIndex && this.positionMs == positionInfo.positionMs && this.contentPositionMs == positionInfo.contentPositionMs && this.adGroupIndex == positionInfo.adGroupIndex && this.adIndexInAdGroup == positionInfo.adIndexInAdGroup && Objects.equals(this.mediaItem, positionInfo.mediaItem);
        }

        public final PositionInfo filterByAvailableCommands(boolean z, boolean z2) {
            if (z && z2) {
                return this;
            }
            return new PositionInfo(this.windowUid, z2 ? this.mediaItemIndex : 0, z ? this.mediaItem : null, this.periodUid, z2 ? this.periodIndex : 0, z ? this.positionMs : 0L, z ? this.contentPositionMs : 0L, z ? this.adGroupIndex : -1, z ? this.adIndexInAdGroup : -1);
        }

        public final int hashCode() {
            return Objects.hash(this.windowUid, Integer.valueOf(this.mediaItemIndex), this.mediaItem, this.periodUid, Integer.valueOf(this.periodIndex), Long.valueOf(this.positionMs), Long.valueOf(this.contentPositionMs), Integer.valueOf(this.adGroupIndex), Integer.valueOf(this.adIndexInAdGroup));
        }

        public final Bundle toBundle(int i) {
            Bundle bundle = new Bundle();
            int i2 = this.mediaItemIndex;
            if (i < 3 || i2 != 0) {
                bundle.putInt(FIELD_MEDIA_ITEM_INDEX, i2);
            }
            MediaItem mediaItem = this.mediaItem;
            if (mediaItem != null) {
                bundle.putBundle(FIELD_MEDIA_ITEM, mediaItem.toBundle(i, false));
            }
            int i3 = this.periodIndex;
            if (i < 3 || i3 != 0) {
                bundle.putInt(FIELD_PERIOD_INDEX, i3);
            }
            long j = this.positionMs;
            if (i < 3 || j != 0) {
                bundle.putLong(FIELD_POSITION_MS, j);
            }
            long j2 = this.contentPositionMs;
            if (i < 3 || j2 != 0) {
                bundle.putLong(FIELD_CONTENT_POSITION_MS, j2);
            }
            int i4 = this.adGroupIndex;
            if (i4 != -1) {
                bundle.putInt(FIELD_AD_GROUP_INDEX, i4);
            }
            int i5 = this.adIndexInAdGroup;
            if (i5 != -1) {
                bundle.putInt(FIELD_AD_INDEX_IN_AD_GROUP, i5);
            }
            return bundle;
        }

        public final String toString() {
            String str = "mediaItem=" + this.mediaItemIndex + ", period=" + this.periodIndex + ", pos=" + this.positionMs;
            int i = this.adGroupIndex;
            if (i == -1) {
                return str;
            }
            return str + ", contentPos=" + this.contentPositionMs + ", adGroup=" + i + ", ad=" + this.adIndexInAdGroup;
        }
    }

    void addListener(Listener listener);

    void addMediaItems(int i, List list);

    void addMediaItems(List list);

    boolean canAdvertiseSession();

    void clearMediaItems();

    void decreaseDeviceVolume();

    void decreaseDeviceVolume(int i);

    Looper getApplicationLooper();

    AudioAttributes getAudioAttributes();

    Commands getAvailableCommands();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    CueGroup getCurrentCues();

    long getCurrentLiveOffset();

    MediaItem getCurrentMediaItem();

    int getCurrentMediaItemIndex();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    Timeline getCurrentTimeline();

    Tracks getCurrentTracks();

    DeviceInfo getDeviceInfo();

    int getDeviceVolume();

    long getDuration();

    long getMaxSeekToPreviousPosition();

    MediaItem getMediaItemAt(int i);

    int getMediaItemCount();

    MediaMetadata getMediaMetadata();

    boolean getPlayWhenReady();

    PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    PlaybackException getPlayerError();

    MediaMetadata getPlaylistMetadata();

    int getRepeatMode();

    long getSeekBackIncrement();

    long getSeekForwardIncrement();

    boolean getShuffleModeEnabled();

    long getTotalBufferedDuration();

    TrackSelectionParameters getTrackSelectionParameters();

    VideoSize getVideoSize();

    float getVolume();

    void increaseDeviceVolume();

    void increaseDeviceVolume(int i);

    boolean isCommandAvailable(int i);

    boolean isCurrentMediaItemDynamic();

    boolean isCurrentMediaItemLive();

    boolean isCurrentMediaItemSeekable();

    boolean isDeviceMuted();

    boolean isLoading();

    boolean isPlaying();

    boolean isPlayingAd();

    void moveMediaItem(int i, int i2);

    void moveMediaItems(int i, int i2, int i3);

    void mute();

    void pause();

    void play();

    void prepare();

    void removeListener(Listener listener);

    void removeMediaItem(int i);

    void removeMediaItems(int i, int i2);

    void replaceMediaItem(int i, MediaItem mediaItem);

    void replaceMediaItems(int i, int i2, List list);

    void seekBack();

    void seekForward();

    void seekTo(int i, long j);

    void seekTo(long j);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i);

    void seekToNext();

    void seekToNextMediaItem();

    void seekToPrevious();

    void seekToPreviousMediaItem();

    void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

    void setDeviceMuted(int i, boolean z);

    void setDeviceMuted(boolean z);

    void setDeviceVolume(int i);

    void setDeviceVolume(int i, int i2);

    void setMediaItem(MediaItem mediaItem);

    void setMediaItem(MediaItem mediaItem, long j);

    void setMediaItem$1(MediaItem mediaItem);

    void setMediaItems(List list);

    void setMediaItems(List list, int i, long j);

    void setPlayWhenReady(boolean z);

    void setPlaybackParameters(PlaybackParameters playbackParameters);

    void setPlaybackSpeed(float f);

    void setPlaylistMetadata(MediaMetadata mediaMetadata);

    void setRepeatMode(int i);

    void setShuffleModeEnabled(boolean z);

    void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters);

    void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

    void setVolume(float f);

    void stop();

    void unmute();
}
