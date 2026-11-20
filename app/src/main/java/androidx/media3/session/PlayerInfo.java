package androidx.media3.session;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Timeline$$ExternalSyntheticLambda0;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerInfo {
    public static final PlayerInfo DEFAULT;
    public static final String FIELD_AUDIO_ATTRIBUTES;
    public static final String FIELD_AUDIO_SESSION_ID;
    public static final String FIELD_CUE_GROUP;
    public static final String FIELD_CURRENT_TRACKS;
    public static final String FIELD_DEVICE_INFO;
    public static final String FIELD_DEVICE_MUTED;
    public static final String FIELD_DEVICE_VOLUME;
    public static final String FIELD_DISCONTINUITY_REASON;
    public static final String FIELD_IN_PROCESS_BINDER;
    public static final String FIELD_IS_LOADING;
    public static final String FIELD_IS_PLAYING;
    public static final String FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    public static final String FIELD_MEDIA_ITEM_TRANSITION_REASON;
    public static final String FIELD_MEDIA_METADATA;
    public static final String FIELD_NEW_POSITION_INFO;
    public static final String FIELD_OLD_POSITION_INFO;
    public static final String FIELD_PLAYBACK_ERROR;
    public static final String FIELD_PLAYBACK_PARAMETERS;
    public static final String FIELD_PLAYBACK_STATE;
    public static final String FIELD_PLAYBACK_SUPPRESSION_REASON;
    public static final String FIELD_PLAYLIST_METADATA;
    public static final String FIELD_PLAY_WHEN_READY;
    public static final String FIELD_PLAY_WHEN_READY_CHANGE_REASON;
    public static final String FIELD_REPEAT_MODE;
    public static final String FIELD_SEEK_BACK_INCREMENT_MS;
    public static final String FIELD_SEEK_FORWARD_INCREMENT_MS;
    public static final String FIELD_SESSION_POSITION_INFO;
    public static final String FIELD_SHUFFLE_MODE_ENABLED;
    public static final String FIELD_TIMELINE;
    public static final String FIELD_TIMELINE_CHANGE_REASON;
    public static final String FIELD_TRACK_SELECTION_PARAMETERS;
    public static final String FIELD_UNMUTE_VOLUME;
    public static final String FIELD_VIDEO_SIZE;
    public static final String FIELD_VOLUME;
    public final AudioAttributes audioAttributes;
    public final int audioSessionId;
    public final CueGroup cueGroup;
    public final Tracks currentTracks;
    public final DeviceInfo deviceInfo;
    public final boolean deviceMuted;
    public final int deviceVolume;
    public final int discontinuityReason;
    public final boolean isLoading;
    public final boolean isPlaying;
    public final long maxSeekToPreviousPositionMs;
    public final int mediaItemTransitionReason;
    public final MediaMetadata mediaMetadata;
    public final Player.PositionInfo newPositionInfo;
    public final Player.PositionInfo oldPositionInfo;
    public final boolean playWhenReady;
    public final int playWhenReadyChangeReason;
    public final PlaybackParameters playbackParameters;
    public final int playbackState;
    public final int playbackSuppressionReason;
    public final PlaybackException playerError;
    public final MediaMetadata playlistMetadata;
    public final int repeatMode;
    public final long seekBackIncrementMs;
    public final long seekForwardIncrementMs;
    public final SessionPositionInfo sessionPositionInfo;
    public final boolean shuffleModeEnabled;
    public final Timeline timeline;
    public final int timelineChangeReason;
    public final TrackSelectionParameters trackSelectionParameters;
    public final float unmuteVolume;
    public final VideoSize videoSize;
    public final float volume;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class BundlingExclusions {
        public static final String FIELD_ARE_CURRENT_TRACKS_EXCLUDED;
        public static final String FIELD_IS_TIMELINE_EXCLUDED;
        public static final BundlingExclusions NONE = new BundlingExclusions(false, false);
        public final boolean areCurrentTracksExcluded;
        public final boolean isTimelineExcluded;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_IS_TIMELINE_EXCLUDED = Integer.toString(0, 36);
            FIELD_ARE_CURRENT_TRACKS_EXCLUDED = Integer.toString(1, 36);
        }

        public BundlingExclusions(boolean z, boolean z2) {
            this.isTimelineExcluded = z;
            this.areCurrentTracksExcluded = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BundlingExclusions)) {
                return false;
            }
            BundlingExclusions bundlingExclusions = (BundlingExclusions) obj;
            return this.isTimelineExcluded == bundlingExclusions.isTimelineExcluded && this.areCurrentTracksExcluded == bundlingExclusions.areCurrentTracksExcluded;
        }

        public final int hashCode() {
            return Objects.hash(Boolean.valueOf(this.isTimelineExcluded), Boolean.valueOf(this.areCurrentTracksExcluded));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InProcessBinder extends Binder {
        public InProcessBinder() {
        }
    }

    static {
        SessionPositionInfo sessionPositionInfo = SessionPositionInfo.DEFAULT;
        Player.PositionInfo positionInfo = SessionPositionInfo.DEFAULT_POSITION_INFO;
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        VideoSize videoSize = VideoSize.UNKNOWN;
        Timeline.AnonymousClass1 anonymousClass1 = Timeline.EMPTY;
        MediaMetadata mediaMetadata = MediaMetadata.EMPTY;
        DEFAULT = new PlayerInfo(null, 0, sessionPositionInfo, positionInfo, positionInfo, 0, playbackParameters, 0, false, videoSize, anonymousClass1, 0, mediaMetadata, 1.0f, 1.0f, AudioAttributes.DEFAULT, 0, CueGroup.EMPTY_TIME_ZERO, DeviceInfo.UNKNOWN, 0, false, false, 1, 0, 1, false, false, mediaMetadata, 5000L, 15000L, 3000L, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_PLAYBACK_PARAMETERS = Integer.toString(1, 36);
        FIELD_REPEAT_MODE = Integer.toString(2, 36);
        FIELD_SHUFFLE_MODE_ENABLED = Integer.toString(3, 36);
        FIELD_TIMELINE = Integer.toString(4, 36);
        FIELD_VIDEO_SIZE = Integer.toString(5, 36);
        FIELD_PLAYLIST_METADATA = Integer.toString(6, 36);
        FIELD_VOLUME = Integer.toString(7, 36);
        FIELD_UNMUTE_VOLUME = Integer.toString(33, 36);
        FIELD_AUDIO_ATTRIBUTES = Integer.toString(8, 36);
        FIELD_DEVICE_INFO = Integer.toString(9, 36);
        FIELD_DEVICE_VOLUME = Integer.toString(10, 36);
        FIELD_DEVICE_MUTED = Integer.toString(11, 36);
        FIELD_PLAY_WHEN_READY = Integer.toString(12, 36);
        FIELD_PLAY_WHEN_READY_CHANGE_REASON = Integer.toString(13, 36);
        FIELD_PLAYBACK_SUPPRESSION_REASON = Integer.toString(14, 36);
        FIELD_PLAYBACK_STATE = Integer.toString(15, 36);
        FIELD_IS_PLAYING = Integer.toString(16, 36);
        FIELD_IS_LOADING = Integer.toString(17, 36);
        FIELD_PLAYBACK_ERROR = Integer.toString(18, 36);
        FIELD_SESSION_POSITION_INFO = Integer.toString(19, 36);
        FIELD_MEDIA_ITEM_TRANSITION_REASON = Integer.toString(20, 36);
        FIELD_OLD_POSITION_INFO = Integer.toString(21, 36);
        FIELD_NEW_POSITION_INFO = Integer.toString(22, 36);
        FIELD_DISCONTINUITY_REASON = Integer.toString(23, 36);
        FIELD_CUE_GROUP = Integer.toString(24, 36);
        FIELD_MEDIA_METADATA = Integer.toString(25, 36);
        FIELD_SEEK_BACK_INCREMENT_MS = Integer.toString(26, 36);
        FIELD_SEEK_FORWARD_INCREMENT_MS = Integer.toString(27, 36);
        FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS = Integer.toString(28, 36);
        FIELD_TRACK_SELECTION_PARAMETERS = Integer.toString(29, 36);
        FIELD_CURRENT_TRACKS = Integer.toString(30, 36);
        FIELD_TIMELINE_CHANGE_REASON = Integer.toString(31, 36);
        FIELD_IN_PROCESS_BINDER = Integer.toString(32, 36);
        FIELD_AUDIO_SESSION_ID = Integer.toString(34, 36);
    }

    public PlayerInfo(PlaybackException playbackException, int i, SessionPositionInfo sessionPositionInfo, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2, PlaybackParameters playbackParameters, int i3, boolean z, VideoSize videoSize, Timeline timeline, int i4, MediaMetadata mediaMetadata, float f, float f2, AudioAttributes audioAttributes, int i5, CueGroup cueGroup, DeviceInfo deviceInfo, int i6, boolean z2, boolean z3, int i7, int i8, int i9, boolean z4, boolean z5, MediaMetadata mediaMetadata2, long j, long j2, long j3, Tracks tracks, TrackSelectionParameters trackSelectionParameters) {
        this.playerError = playbackException;
        this.mediaItemTransitionReason = i;
        this.sessionPositionInfo = sessionPositionInfo;
        this.oldPositionInfo = positionInfo;
        this.newPositionInfo = positionInfo2;
        this.discontinuityReason = i2;
        this.playbackParameters = playbackParameters;
        this.repeatMode = i3;
        this.shuffleModeEnabled = z;
        this.videoSize = videoSize;
        this.timeline = timeline;
        this.timelineChangeReason = i4;
        this.playlistMetadata = mediaMetadata;
        this.volume = f;
        this.unmuteVolume = f2;
        this.audioSessionId = i5;
        this.audioAttributes = audioAttributes;
        this.cueGroup = cueGroup;
        this.deviceInfo = deviceInfo;
        this.deviceVolume = i6;
        this.deviceMuted = z2;
        this.playWhenReady = z3;
        this.playWhenReadyChangeReason = i7;
        this.playbackSuppressionReason = i8;
        this.playbackState = i9;
        this.isPlaying = z4;
        this.isLoading = z5;
        this.mediaMetadata = mediaMetadata2;
        this.seekBackIncrementMs = j;
        this.seekForwardIncrementMs = j2;
        this.maxSeekToPreviousPositionMs = j3;
        this.currentTracks = tracks;
        this.trackSelectionParameters = trackSelectionParameters;
    }

    public static PlayerInfo fromBundle(int i, Bundle bundle) {
        PlaybackException playbackException;
        RegularImmutableList regularImmutableListFromBundleList;
        RegularImmutableList regularImmutableListFromBundleList2;
        Timeline remotableTimeline;
        RegularImmutableList regularImmutableListBuild;
        CueGroup cueGroup;
        DeviceInfo deviceInfoBuild;
        RegularImmutableList regularImmutableListFromBundleList3;
        Tracks tracks;
        IBinder binder = bundle.getBinder(FIELD_IN_PROCESS_BINDER);
        if (binder instanceof InProcessBinder) {
            return PlayerInfo.this;
        }
        Bundle bundle2 = bundle.getBundle(FIELD_PLAYBACK_ERROR);
        Throwable remoteException = null;
        byte b = 1;
        if (bundle2 == null) {
            playbackException = null;
        } else {
            String string = bundle2.getString(PlaybackException.FIELD_STRING_MESSAGE);
            String string2 = bundle2.getString(PlaybackException.FIELD_STRING_CAUSE_CLASS_NAME);
            String string3 = bundle2.getString(PlaybackException.FIELD_STRING_CAUSE_MESSAGE);
            if (!TextUtils.isEmpty(string2)) {
                try {
                    Class<?> cls = Class.forName(string2, true, PlaybackException.class.getClassLoader());
                    remoteException = Throwable.class.isAssignableFrom(cls) ? (Throwable) cls.getConstructor(String.class).newInstance(string3) : null;
                    if (remoteException == null) {
                        remoteException = new RemoteException(string3);
                    }
                } catch (Throwable unused) {
                    remoteException = new RemoteException(string3);
                }
            }
            Throwable th = remoteException;
            int i2 = bundle2.getInt(PlaybackException.FIELD_INT_ERROR_CODE, CIOKt.DEFAULT_HTTP_POOL_SIZE);
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle2.getBundle(PlaybackException.FIELD_BUNDLE_EXTRAS));
            if (bundleConvertToNullIfInvalid == null) {
                bundleConvertToNullIfInvalid = Bundle.EMPTY;
            }
            playbackException = new PlaybackException(string, th, i2, bundleConvertToNullIfInvalid, bundle2.getLong(PlaybackException.FIELD_LONG_TIMESTAMP_MS, SystemClock.elapsedRealtime()));
        }
        byte b2 = 0;
        int i3 = bundle.getInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, 0);
        Bundle bundle3 = bundle.getBundle(FIELD_SESSION_POSITION_INFO);
        SessionPositionInfo sessionPositionInfoFromBundle = bundle3 == null ? SessionPositionInfo.DEFAULT : SessionPositionInfo.fromBundle(i, bundle3);
        Bundle bundle4 = bundle.getBundle(FIELD_OLD_POSITION_INFO);
        Player.PositionInfo positionInfoFromBundle = bundle4 == null ? SessionPositionInfo.DEFAULT_POSITION_INFO : Player.PositionInfo.fromBundle(i, bundle4);
        Bundle bundle5 = bundle.getBundle(FIELD_NEW_POSITION_INFO);
        Player.PositionInfo positionInfoFromBundle2 = bundle5 == null ? SessionPositionInfo.DEFAULT_POSITION_INFO : Player.PositionInfo.fromBundle(i, bundle5);
        int i4 = bundle.getInt(FIELD_DISCONTINUITY_REASON, 0);
        Bundle bundle6 = bundle.getBundle(FIELD_PLAYBACK_PARAMETERS);
        PlaybackParameters playbackParameters = bundle6 == null ? PlaybackParameters.DEFAULT : new PlaybackParameters(bundle6.getFloat(PlaybackParameters.FIELD_SPEED, 1.0f), bundle6.getFloat(PlaybackParameters.FIELD_PITCH, 1.0f));
        int i5 = bundle.getInt(FIELD_REPEAT_MODE, 0);
        boolean z = bundle.getBoolean(FIELD_SHUFFLE_MODE_ENABLED, false);
        Bundle bundle7 = bundle.getBundle(FIELD_TIMELINE);
        if (bundle7 == null) {
            remotableTimeline = Timeline.EMPTY;
        } else {
            Timeline$$ExternalSyntheticLambda0 timeline$$ExternalSyntheticLambda0 = new Timeline$$ExternalSyntheticLambda0(b2, i);
            IBinder binder2 = bundle7.getBinder(Timeline.FIELD_WINDOWS);
            if (binder2 == null) {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                regularImmutableListFromBundleList = RegularImmutableList.EMPTY;
            } else {
                regularImmutableListFromBundleList = GlUtil.fromBundleList(timeline$$ExternalSyntheticLambda0, BundleListRetriever.getList(binder2));
            }
            Timeline$$ExternalSyntheticLambda0 timeline$$ExternalSyntheticLambda1 = new Timeline$$ExternalSyntheticLambda0(b, i);
            IBinder binder3 = bundle7.getBinder(Timeline.FIELD_PERIODS);
            if (binder3 == null) {
                ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                regularImmutableListFromBundleList2 = RegularImmutableList.EMPTY;
            } else {
                regularImmutableListFromBundleList2 = GlUtil.fromBundleList(timeline$$ExternalSyntheticLambda1, BundleListRetriever.getList(binder3));
            }
            int[] intArray = bundle7.getIntArray(Timeline.FIELD_SHUFFLED_WINDOW_INDICES);
            if (intArray == null) {
                int i6 = regularImmutableListFromBundleList.size;
                int[] iArr = new int[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    iArr[i7] = i7;
                }
                intArray = iArr;
            }
            remotableTimeline = new Timeline.RemotableTimeline(regularImmutableListFromBundleList, regularImmutableListFromBundleList2, intArray);
        }
        int i8 = bundle.getInt(FIELD_TIMELINE_CHANGE_REASON, 0);
        Bundle bundle8 = bundle.getBundle(FIELD_VIDEO_SIZE);
        VideoSize videoSize = bundle8 == null ? VideoSize.UNKNOWN : new VideoSize(bundle8.getFloat(VideoSize.FIELD_PIXEL_WIDTH_HEIGHT_RATIO, 1.0f), bundle8.getInt(VideoSize.FIELD_WIDTH, 0), bundle8.getInt(VideoSize.FIELD_HEIGHT, 0));
        Bundle bundle9 = bundle.getBundle(FIELD_PLAYLIST_METADATA);
        MediaMetadata mediaMetadataFromBundle = bundle9 == null ? MediaMetadata.EMPTY : MediaMetadata.fromBundle(i, bundle9);
        float f = bundle.getFloat(FIELD_VOLUME, 1.0f);
        float f2 = bundle.getFloat(FIELD_UNMUTE_VOLUME, 1.0f);
        int i9 = bundle.getInt(FIELD_AUDIO_SESSION_ID, 0);
        Bundle bundle10 = bundle.getBundle(FIELD_AUDIO_ATTRIBUTES);
        AudioAttributes audioAttributesFromBundle = bundle10 == null ? AudioAttributes.DEFAULT : AudioAttributes.fromBundle(bundle10);
        Bundle bundle11 = bundle.getBundle(FIELD_CUE_GROUP);
        if (bundle11 == null) {
            cueGroup = CueGroup.EMPTY_TIME_ZERO;
            mediaMetadataFromBundle = mediaMetadataFromBundle;
            f = f;
            videoSize = videoSize;
        } else {
            ArrayList parcelableArrayList = bundle11.getParcelableArrayList(CueGroup.FIELD_CUES);
            if (parcelableArrayList == null) {
                ImmutableList.Itr itr3 = ImmutableList.EMPTY_ITR;
                regularImmutableListBuild = RegularImmutableList.EMPTY;
            } else {
                ImmutableList.Builder builder = ImmutableList.builder();
                for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
                    Bundle bundle12 = (Bundle) parcelableArrayList.get(i10);
                    bundle12.getClass();
                    builder.add((Object) Cue.fromBundle(bundle12));
                }
                regularImmutableListBuild = builder.build();
            }
            cueGroup = new CueGroup(regularImmutableListBuild, bundle11.getLong(CueGroup.FIELD_PRESENTATION_TIME_US));
        }
        Bundle bundle13 = bundle.getBundle(FIELD_DEVICE_INFO);
        if (bundle13 == null) {
            deviceInfoBuild = DeviceInfo.UNKNOWN;
        } else {
            int i11 = bundle13.getInt(DeviceInfo.FIELD_PLAYBACK_TYPE, 0);
            int i12 = bundle13.getInt(DeviceInfo.FIELD_MIN_VOLUME, 0);
            int i13 = bundle13.getInt(DeviceInfo.FIELD_MAX_VOLUME, 0);
            String string4 = bundle13.getString(DeviceInfo.FIELD_ROUTING_CONTROLLER_ID);
            GapBuffer gapBuffer = new GapBuffer(i11);
            gapBuffer.gapStart = i12;
            gapBuffer.gapEnd = i13;
            UtilsKt.checkArgument(i11 != 0 || string4 == null);
            gapBuffer.buffer = string4;
            deviceInfoBuild = gapBuffer.build();
        }
        int i14 = bundle.getInt(FIELD_DEVICE_VOLUME, 0);
        boolean z2 = bundle.getBoolean(FIELD_DEVICE_MUTED, false);
        boolean z3 = bundle.getBoolean(FIELD_PLAY_WHEN_READY, false);
        int i15 = bundle.getInt(FIELD_PLAY_WHEN_READY_CHANGE_REASON, 1);
        int i16 = bundle.getInt(FIELD_PLAYBACK_SUPPRESSION_REASON, 0);
        int i17 = bundle.getInt(FIELD_PLAYBACK_STATE, 1);
        boolean z4 = bundle.getBoolean(FIELD_IS_PLAYING, false);
        boolean z5 = bundle.getBoolean(FIELD_IS_LOADING, false);
        Bundle bundle14 = bundle.getBundle(FIELD_MEDIA_METADATA);
        MediaMetadata mediaMetadataFromBundle2 = bundle14 == null ? MediaMetadata.EMPTY : MediaMetadata.fromBundle(i, bundle14);
        DeviceInfo deviceInfo = deviceInfoBuild;
        long j = bundle.getLong(FIELD_SEEK_BACK_INCREMENT_MS, i < 4 ? 0L : 5000L);
        long j2 = bundle.getLong(FIELD_SEEK_FORWARD_INCREMENT_MS, i < 4 ? 0L : 15000L);
        long j3 = bundle.getLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, i < 4 ? 0L : 3000L);
        Bundle bundle15 = bundle.getBundle(FIELD_CURRENT_TRACKS);
        if (bundle15 == null) {
            tracks = Tracks.EMPTY;
        } else {
            ArrayList parcelableArrayList2 = bundle15.getParcelableArrayList(Tracks.FIELD_TRACK_GROUPS);
            if (parcelableArrayList2 == null) {
                ImmutableList.Itr itr4 = ImmutableList.EMPTY_ITR;
                regularImmutableListFromBundleList3 = RegularImmutableList.EMPTY;
            } else {
                regularImmutableListFromBundleList3 = GlUtil.fromBundleList(new Format$$ExternalSyntheticLambda1((byte) 6), parcelableArrayList2);
            }
            tracks = new Tracks(regularImmutableListFromBundleList3);
        }
        Bundle bundle16 = bundle.getBundle(FIELD_TRACK_SELECTION_PARAMETERS);
        return new PlayerInfo(playbackException, i3, sessionPositionInfoFromBundle, positionInfoFromBundle, positionInfoFromBundle2, i4, playbackParameters, i5, z, videoSize, remotableTimeline, i8, mediaMetadataFromBundle, f, f2, audioAttributesFromBundle, i9, cueGroup, deviceInfo, i14, z2, z3, i15, i16, i17, z4, z5, mediaMetadataFromBundle2, j, j2, j3, tracks, bundle16 == null ? TrackSelectionParameters.DEFAULT : TrackSelectionParameters.fromBundle(bundle16));
    }

    public final PlayerInfo copyWithAudioAttributes(AudioAttributes audioAttributes) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithCurrentTracks(Tracks tracks) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, tracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithDeviceVolume(int i, boolean z) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, i, z, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithPlayWhenReady(int i, boolean z, int i2) {
        int i3 = this.playbackState;
        boolean z2 = i3 == 3 && z && i2 == 0;
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, z, i, i2, i3, z2, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithPlaybackParameters(PlaybackParameters playbackParameters) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithPlaybackState(int i, PlaybackException playbackException) {
        boolean z = this.playWhenReady;
        int i2 = this.playbackSuppressionReason;
        boolean z2 = i == 3 && z && i2 == 0;
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(playbackException, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, z, this.playWhenReadyChangeReason, i2, i, z2, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithPlaylistMetadata(MediaMetadata mediaMetadata) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, mediaMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithPositionInfos(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, positionInfo, positionInfo2, i, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithRepeatMode(int i) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, i, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithSessionPositionInfo(SessionPositionInfo sessionPositionInfo) {
        Timeline timeline = this.timeline;
        UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithShuffleModeEnabled(boolean z) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, z, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithTimeline(Timeline timeline) {
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithTimelineAndMediaItemIndex(QueueTimeline queueTimeline, int i) {
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
        SessionPositionInfo sessionPositionInfo2 = new SessionPositionInfo(new Player.PositionInfo(positionInfo.windowUid, i, positionInfo.mediaItem, positionInfo.periodUid, positionInfo.periodIndex, positionInfo.positionMs, positionInfo.contentPositionMs, positionInfo.adGroupIndex, positionInfo.adIndexInAdGroup), sessionPositionInfo.isPlayingAd, sessionPositionInfo.eventTimeMs, sessionPositionInfo.durationMs, sessionPositionInfo.bufferedPositionMs, sessionPositionInfo.bufferedPercentage, sessionPositionInfo.totalBufferedDurationMs, sessionPositionInfo.currentLiveOffsetMs, sessionPositionInfo.contentDurationMs, sessionPositionInfo.contentBufferedPositionMs);
        UtilsKt.checkState(queueTimeline.isEmpty() || sessionPositionInfo2.positionInfo.mediaItemIndex < queueTimeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo2, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, queueTimeline, 0, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithTimelineAndSessionPositionInfo(Timeline timeline, SessionPositionInfo sessionPositionInfo, int i) {
        UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, i, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo copyWithTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.unmuteVolume, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, trackSelectionParameters);
    }

    public final PlayerInfo copyWithVolume(float f) {
        float f2 = f != CropImageView.DEFAULT_ASPECT_RATIO ? f : this.volume;
        Timeline timeline = this.timeline;
        boolean zIsEmpty = timeline.isEmpty();
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        UtilsKt.checkState(zIsEmpty || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, this.playlistMetadata, f, f2, this.audioAttributes, this.audioSessionId, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
    }

    public final PlayerInfo filterByAvailableCommands(Player.Commands commands, boolean z, boolean z2) {
        float f;
        float f2;
        int i;
        boolean z3;
        int i2;
        boolean zContains = commands.contains(16);
        boolean zContains2 = commands.contains(17);
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        SessionPositionInfo sessionPositionInfoFilterByAvailableCommands = sessionPositionInfo.filterByAvailableCommands(zContains, zContains2);
        Player.PositionInfo positionInfoFilterByAvailableCommands = this.oldPositionInfo.filterByAvailableCommands(zContains, zContains2);
        Player.PositionInfo positionInfoFilterByAvailableCommands2 = this.newPositionInfo.filterByAvailableCommands(zContains, zContains2);
        boolean z4 = true;
        Timeline remotableTimeline = this.timeline;
        if (!zContains2 && zContains && !remotableTimeline.isEmpty()) {
            int i3 = sessionPositionInfo.positionInfo.mediaItemIndex;
            if (remotableTimeline.getWindowCount() != 1) {
                Timeline.Window window = remotableTimeline.getWindow(i3, new Timeline.Window(), 0L);
                ImmutableList.Builder builder = ImmutableList.builder();
                int i4 = window.firstPeriodIndex;
                while (true) {
                    i2 = window.lastPeriodIndex;
                    if (i4 > i2) {
                        break;
                    }
                    Timeline.Period period = remotableTimeline.getPeriod(i4, new Timeline.Period(), true);
                    period.windowIndex = 0;
                    builder.add((Object) period);
                    i4++;
                }
                window.lastPeriodIndex = i2 - window.firstPeriodIndex;
                window.firstPeriodIndex = 0;
                remotableTimeline = new Timeline.RemotableTimeline(ImmutableList.of((Object) window), builder.build(), new int[]{0});
            }
        } else if (z || !zContains2) {
            remotableTimeline = Timeline.EMPTY;
        }
        Timeline timeline = remotableTimeline;
        MediaMetadata mediaMetadata = !commands.contains(18) ? MediaMetadata.EMPTY : this.playlistMetadata;
        if (commands.contains(22)) {
            f = this.volume;
            f2 = this.unmuteVolume;
        } else {
            f = 1.0f;
            f2 = 1.0f;
        }
        AudioAttributes audioAttributes = !commands.contains(21) ? AudioAttributes.DEFAULT : this.audioAttributes;
        CueGroup cueGroup = !commands.contains(28) ? CueGroup.EMPTY_TIME_ZERO : this.cueGroup;
        if (commands.contains(23)) {
            i = this.deviceVolume;
            z3 = this.deviceMuted;
        } else {
            i = 0;
            z3 = false;
        }
        MediaMetadata mediaMetadata2 = !commands.contains(18) ? MediaMetadata.EMPTY : this.mediaMetadata;
        Tracks tracks = (z2 || !commands.contains(30)) ? Tracks.EMPTY : this.currentTracks;
        if (!timeline.isEmpty() && sessionPositionInfoFilterByAvailableCommands.positionInfo.mediaItemIndex >= timeline.getWindowCount()) {
            z4 = false;
        }
        UtilsKt.checkState(z4);
        return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, sessionPositionInfoFilterByAvailableCommands, positionInfoFilterByAvailableCommands, positionInfoFilterByAvailableCommands2, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, timeline, this.timelineChangeReason, mediaMetadata, f, f2, audioAttributes, this.audioSessionId, cueGroup, this.deviceInfo, i, z3, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, mediaMetadata2, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, tracks, this.trackSelectionParameters);
    }

    public final MediaItem getCurrentMediaItem() {
        Timeline timeline = this.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        return timeline.getWindow(this.sessionPositionInfo.positionInfo.mediaItemIndex, new Timeline.Window(), 0L).mediaItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v28 */
    public final Bundle toBundleForRemoteProcess(int i) {
        Bundle bundle;
        long j;
        int i2;
        Bundle bundle2;
        ArrayList arrayList;
        Timeline timeline;
        Timeline.Period period;
        int i3;
        Bundle bundle3;
        int i4 = i;
        Bundle bundle4 = new Bundle();
        PlaybackException playbackException = this.playerError;
        if (playbackException != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt(PlaybackException.FIELD_INT_ERROR_CODE, playbackException.errorCode);
            bundle5.putLong(PlaybackException.FIELD_LONG_TIMESTAMP_MS, playbackException.timestampMs);
            bundle5.putString(PlaybackException.FIELD_STRING_MESSAGE, playbackException.getMessage());
            bundle5.putBundle(PlaybackException.FIELD_BUNDLE_EXTRAS, playbackException.extras);
            Throwable cause = playbackException.getCause();
            if (cause != null) {
                bundle5.putString(PlaybackException.FIELD_STRING_CAUSE_CLASS_NAME, cause.getClass().getName());
                bundle5.putString(PlaybackException.FIELD_STRING_CAUSE_MESSAGE, cause.getMessage());
            }
            bundle4.putBundle(FIELD_PLAYBACK_ERROR, bundle5);
        }
        int i5 = this.mediaItemTransitionReason;
        if (i5 != 0) {
            bundle4.putInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, i5);
        }
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        if (i4 < 3 || !sessionPositionInfo.equals(SessionPositionInfo.DEFAULT)) {
            bundle4.putBundle(FIELD_SESSION_POSITION_INFO, sessionPositionInfo.toBundle(i4));
        }
        Player.PositionInfo positionInfo = this.oldPositionInfo;
        if (i4 < 3 || !SessionPositionInfo.DEFAULT_POSITION_INFO.equalsForBundling(positionInfo)) {
            bundle4.putBundle(FIELD_OLD_POSITION_INFO, positionInfo.toBundle(i4));
        }
        Player.PositionInfo positionInfo2 = this.newPositionInfo;
        if (i4 < 3 || !SessionPositionInfo.DEFAULT_POSITION_INFO.equalsForBundling(positionInfo2)) {
            bundle4.putBundle(FIELD_NEW_POSITION_INFO, positionInfo2.toBundle(i4));
        }
        int i6 = this.discontinuityReason;
        if (i6 != 0) {
            bundle4.putInt(FIELD_DISCONTINUITY_REASON, i6);
        }
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        PlaybackParameters playbackParameters2 = this.playbackParameters;
        if (!playbackParameters2.equals(playbackParameters)) {
            Bundle bundle6 = new Bundle();
            bundle6.putFloat(PlaybackParameters.FIELD_SPEED, playbackParameters2.speed);
            bundle6.putFloat(PlaybackParameters.FIELD_PITCH, playbackParameters2.pitch);
            bundle4.putBundle(FIELD_PLAYBACK_PARAMETERS, bundle6);
        }
        int i7 = this.repeatMode;
        if (i7 != 0) {
            bundle4.putInt(FIELD_REPEAT_MODE, i7);
        }
        boolean z = this.shuffleModeEnabled;
        if (z) {
            bundle4.putBoolean(FIELD_SHUFFLE_MODE_ENABLED, z);
        }
        Timeline.AnonymousClass1 anonymousClass1 = Timeline.EMPTY;
        Timeline timeline2 = this.timeline;
        boolean z2 = false;
        long j2 = 0;
        if (timeline2.equals(anonymousClass1)) {
            bundle = bundle4;
            j = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            int windowCount = timeline2.getWindowCount();
            Timeline.Window window = new Timeline.Window();
            int i8 = 0;
            while (i8 < windowCount) {
                Timeline.Window window2 = timeline2.getWindow(i8, window, j2);
                window2.getClass();
                Bundle bundle7 = new Bundle();
                long j3 = j2;
                if (!MediaItem.EMPTY.equals(window2.mediaItem)) {
                    bundle7.putBundle(Timeline.Window.FIELD_MEDIA_ITEM, window2.mediaItem.toBundle(i4, false));
                }
                long j4 = window2.presentationStartTimeMs;
                if (j4 != -9223372036854775807L) {
                    bundle7.putLong(Timeline.Window.FIELD_PRESENTATION_START_TIME_MS, j4);
                }
                long j5 = window2.windowStartTimeMs;
                if (j5 != r12) {
                    bundle7.putLong(Timeline.Window.FIELD_WINDOW_START_TIME_MS, j5);
                }
                long j6 = window2.elapsedRealtimeEpochOffsetMs;
                if (j6 != r12) {
                    bundle7.putLong(Timeline.Window.FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS, j6);
                }
                boolean z3 = window2.isSeekable;
                if (z3) {
                    bundle7.putBoolean(Timeline.Window.FIELD_IS_SEEKABLE, z3);
                }
                boolean z4 = window2.isDynamic;
                if (z4) {
                    bundle7.putBoolean(Timeline.Window.FIELD_IS_DYNAMIC, z4);
                }
                MediaItem.LiveConfiguration liveConfiguration = window2.liveConfiguration;
                if (liveConfiguration != null) {
                    bundle7.putBundle(Timeline.Window.FIELD_LIVE_CONFIGURATION, liveConfiguration.toBundle());
                }
                boolean z5 = window2.isPlaceholder;
                if (z5) {
                    bundle7.putBoolean(Timeline.Window.FIELD_IS_PLACEHOLDER, z5);
                }
                long j7 = window2.defaultPositionUs;
                if (j7 != j3) {
                    bundle7.putLong(Timeline.Window.FIELD_DEFAULT_POSITION_US, j7);
                }
                long j8 = window2.durationUs;
                if (j8 != -9223372036854775807) {
                    bundle7.putLong(Timeline.Window.FIELD_DURATION_US, j8);
                }
                int i9 = window2.firstPeriodIndex;
                if (i9 != 0) {
                    bundle7.putInt(Timeline.Window.FIELD_FIRST_PERIOD_INDEX, i9);
                }
                int i10 = window2.lastPeriodIndex;
                if (i10 != 0) {
                    bundle7.putInt(Timeline.Window.FIELD_LAST_PERIOD_INDEX, i10);
                }
                long j9 = window2.positionInFirstPeriodUs;
                if (j9 != j3) {
                    bundle7.putLong(Timeline.Window.FIELD_POSITION_IN_FIRST_PERIOD_US, j9);
                }
                arrayList2.add(bundle7);
                i8++;
                j2 = j3;
            }
            j = j2;
            ArrayList arrayList3 = new ArrayList();
            int periodCount = timeline2.getPeriodCount();
            Timeline.Period period2 = new Timeline.Period();
            int i11 = 0;
            while (i11 < periodCount) {
                Timeline.Period period3 = timeline2.getPeriod(i11, period2, z2);
                period3.getClass();
                Bundle bundle8 = new Bundle();
                int i12 = period3.windowIndex;
                if (i12 != 0) {
                    bundle8.putInt(Timeline.Period.FIELD_WINDOW_INDEX, i12);
                }
                long j10 = period3.durationUs;
                if (j10 != -9223372036854775807L) {
                    bundle8.putLong(Timeline.Period.FIELD_DURATION_US, j10);
                }
                long j11 = period3.positionInWindowUs;
                if (j11 != j) {
                    bundle8.putLong(Timeline.Period.FIELD_POSITION_IN_WINDOW_US, j11);
                }
                boolean z6 = period3.isPlaceholder;
                if (z6) {
                    bundle8.putBoolean(Timeline.Period.FIELD_PLACEHOLDER, z6);
                }
                if (period3.adPlaybackState.equals(AdPlaybackState.NONE)) {
                    bundle2 = bundle4;
                    arrayList = arrayList2;
                    timeline = timeline2;
                    period = period2;
                    i3 = i11;
                } else {
                    String str = Timeline.Period.FIELD_AD_PLAYBACK_STATE;
                    AdPlaybackState adPlaybackState = period3.adPlaybackState;
                    Bundle bundle9 = new Bundle();
                    ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
                    AdPlaybackState.AdGroup[] adGroupArr = adPlaybackState.adGroups;
                    int length = adGroupArr.length;
                    ?? r6 = z2;
                    while (r6 < length) {
                        ?? r23 = r6;
                        AdPlaybackState.AdGroup adGroup = adGroupArr[r23 == true ? 1 : 0];
                        adGroup.getClass();
                        int i13 = length;
                        Bundle bundle10 = new Bundle();
                        Timeline.Period period4 = period2;
                        Bundle bundle11 = bundle4;
                        ArrayList arrayList5 = arrayList2;
                        bundle10.putLong(AdPlaybackState.AdGroup.FIELD_TIME_US, adGroup.timeUs);
                        bundle10.putInt(AdPlaybackState.AdGroup.FIELD_COUNT, adGroup.count);
                        bundle10.putInt(AdPlaybackState.AdGroup.FIELD_ORIGINAL_COUNT, adGroup.originalCount);
                        bundle10.putParcelableArrayList(AdPlaybackState.AdGroup.FIELD_URIS, new ArrayList<>(Arrays.asList(adGroup.uris)));
                        String str2 = AdPlaybackState.AdGroup.FIELD_MEDIA_ITEMS;
                        ArrayList<? extends Parcelable> arrayList6 = new ArrayList<>();
                        MediaItem[] mediaItemArr = adGroup.mediaItems;
                        int i14 = i11;
                        int length2 = mediaItemArr.length;
                        ?? r10 = z2;
                        while (true) {
                            Bundle bundle12 = null;
                            if (r10 >= length2) {
                                break;
                            }
                            ?? r31 = r10;
                            MediaItem mediaItem = mediaItemArr[r31 == true ? 1 : 0];
                            if (mediaItem != null) {
                                bundle12 = mediaItem.toBundle(i4, true);
                            }
                            arrayList6.add(bundle12);
                            length2 = length2;
                            r10 = (r31 == true ? 1 : 0) + 1;
                        }
                        bundle10.putParcelableArrayList(str2, arrayList6);
                        bundle10.putIntArray(AdPlaybackState.AdGroup.FIELD_STATES, adGroup.states);
                        bundle10.putLongArray(AdPlaybackState.AdGroup.FIELD_DURATIONS_US, adGroup.durationsUs);
                        bundle10.putLong(AdPlaybackState.AdGroup.FIELD_CONTENT_RESUME_OFFSET_US, adGroup.contentResumeOffsetUs);
                        bundle10.putBoolean(AdPlaybackState.AdGroup.FIELD_IS_SERVER_SIDE_INSERTED, adGroup.isServerSideInserted);
                        bundle10.putStringArrayList(AdPlaybackState.AdGroup.FIELD_IDS, new ArrayList<>(Arrays.asList(adGroup.ids)));
                        String str3 = AdPlaybackState.AdGroup.FIELD_SKIP_INFOS;
                        ArrayList<? extends Parcelable> arrayList7 = new ArrayList<>();
                        AdPlaybackState.SkipInfo[] skipInfoArr = adGroup.skipInfos;
                        int length3 = skipInfoArr.length;
                        ?? r11 = z2;
                        while (r11 < length3) {
                            ?? r32 = r11;
                            AdPlaybackState.SkipInfo skipInfo = skipInfoArr[r32 == true ? 1 : 0];
                            if (skipInfo == null) {
                                bundle3 = null;
                            } else {
                                bundle3 = new Bundle();
                                bundle3.putLong(AdPlaybackState.SkipInfo.FIELD_SKIP_OFFSET_US, skipInfo.skipOffsetUs);
                                bundle3.putLong(AdPlaybackState.SkipInfo.FIELD_SKIP_DURATION_US, skipInfo.skipDurationUs);
                                bundle3.putString(AdPlaybackState.SkipInfo.FIELD_LABEL_ID, skipInfo.labelId);
                            }
                            arrayList7.add(bundle3);
                            length3 = length3;
                            timeline2 = timeline2;
                            str = str;
                            r11 = (r32 == true ? 1 : 0) + 1;
                        }
                        bundle10.putParcelableArrayList(str3, arrayList7);
                        bundle10.putBoolean(AdPlaybackState.AdGroup.FIELD_IS_PLACEHOLDER, adGroup.isPlaceholder);
                        arrayList4.add(bundle10);
                        i4 = i;
                        length = i13;
                        period2 = period4;
                        bundle4 = bundle11;
                        arrayList2 = arrayList5;
                        i11 = i14;
                        r6 = (r23 == true ? 1 : 0) + 1;
                    }
                    bundle2 = bundle4;
                    arrayList = arrayList2;
                    timeline = timeline2;
                    String str4 = str;
                    period = period2;
                    i3 = i11;
                    if (!arrayList4.isEmpty()) {
                        bundle9.putParcelableArrayList(AdPlaybackState.FIELD_AD_GROUPS, arrayList4);
                    }
                    long j12 = adPlaybackState.adResumePositionUs;
                    if (j12 != j) {
                        bundle9.putLong(AdPlaybackState.FIELD_AD_RESUME_POSITION_US, j12);
                    }
                    long j13 = adPlaybackState.contentDurationUs;
                    if (j13 != -9223372036854775807L) {
                        bundle9.putLong(AdPlaybackState.FIELD_CONTENT_DURATION_US, j13);
                    }
                    int i15 = adPlaybackState.removedAdGroupCount;
                    if (i15 != 0) {
                        bundle9.putInt(AdPlaybackState.FIELD_REMOVED_AD_GROUP_COUNT, i15);
                    }
                    bundle8.putBundle(str4, bundle9);
                }
                arrayList3.add(bundle8);
                i11 = i3 + 1;
                i4 = i;
                z2 = z2;
                periodCount = periodCount;
                period2 = period;
                bundle4 = bundle2;
                arrayList2 = arrayList;
                timeline2 = timeline;
            }
            Bundle bundle13 = bundle4;
            ArrayList arrayList8 = arrayList2;
            Timeline timeline3 = timeline2;
            boolean z7 = z2;
            int[] iArr = new int[windowCount];
            boolean z8 = true;
            if (windowCount > 0) {
                iArr[z7 ? 1 : 0] = timeline3.getFirstWindowIndex(true);
            }
            int i16 = 1;
            while (i16 < windowCount) {
                iArr[i16] = timeline3.getNextWindowIndex(iArr[i16 - 1], z8, z7 ? 1 : 0);
                i16++;
                z8 = true;
                z7 = false;
            }
            Bundle bundle14 = new Bundle();
            bundle14.putBinder(Timeline.FIELD_WINDOWS, new BundleListRetriever(arrayList8));
            bundle14.putBinder(Timeline.FIELD_PERIODS, new BundleListRetriever(arrayList3));
            bundle14.putIntArray(Timeline.FIELD_SHUFFLED_WINDOW_INDICES, iArr);
            bundle = bundle13;
            bundle.putBundle(FIELD_TIMELINE, bundle14);
        }
        int i17 = this.timelineChangeReason;
        if (i17 != 0) {
            bundle.putInt(FIELD_TIMELINE_CHANGE_REASON, i17);
        }
        VideoSize videoSize = VideoSize.UNKNOWN;
        VideoSize videoSize2 = this.videoSize;
        if (!videoSize2.equals(videoSize)) {
            Bundle bundle15 = new Bundle();
            int i18 = videoSize2.width;
            if (i18 != 0) {
                bundle15.putInt(VideoSize.FIELD_WIDTH, i18);
            }
            int i19 = videoSize2.height;
            if (i19 != 0) {
                bundle15.putInt(VideoSize.FIELD_HEIGHT, i19);
            }
            float f = videoSize2.pixelWidthHeightRatio;
            if (f != 1.0f) {
                bundle15.putFloat(VideoSize.FIELD_PIXEL_WIDTH_HEIGHT_RATIO, f);
            }
            bundle.putBundle(FIELD_VIDEO_SIZE, bundle15);
        }
        MediaMetadata mediaMetadata = MediaMetadata.EMPTY;
        MediaMetadata mediaMetadata2 = this.playlistMetadata;
        if (mediaMetadata2.equals(mediaMetadata)) {
            i2 = i;
        } else {
            i2 = i;
            bundle.putBundle(FIELD_PLAYLIST_METADATA, mediaMetadata2.toBundle(i2));
        }
        float f2 = this.volume;
        if (f2 != 1.0f) {
            bundle.putFloat(FIELD_VOLUME, f2);
        }
        float f3 = this.unmuteVolume;
        if (f3 != 1.0f) {
            bundle.putFloat(FIELD_UNMUTE_VOLUME, f3);
        }
        int i20 = this.audioSessionId;
        if (i20 != 0) {
            bundle.putInt(FIELD_AUDIO_SESSION_ID, i20);
        }
        AudioAttributes audioAttributes = AudioAttributes.DEFAULT;
        AudioAttributes audioAttributes2 = this.audioAttributes;
        if (!audioAttributes2.equals(audioAttributes)) {
            bundle.putBundle(FIELD_AUDIO_ATTRIBUTES, audioAttributes2.toBundle());
        }
        CueGroup cueGroup = CueGroup.EMPTY_TIME_ZERO;
        CueGroup cueGroup2 = this.cueGroup;
        if (!cueGroup2.equals(cueGroup)) {
            Bundle bundle16 = new Bundle();
            String str5 = CueGroup.FIELD_CUES;
            RegularImmutableList regularImmutableList = cueGroup2.cues;
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i21 = 0; i21 < regularImmutableList.size; i21++) {
                if (((Cue) regularImmutableList.get(i21)).bitmap == null) {
                    builder.add(regularImmutableList.get(i21));
                }
            }
            RegularImmutableList regularImmutableListBuild = builder.build();
            ArrayList<? extends Parcelable> arrayList9 = new ArrayList<>(regularImmutableListBuild.size);
            ImmutableList.Itr itrListIterator = regularImmutableListBuild.listIterator(0);
            while (itrListIterator.hasNext()) {
                Cue cue = (Cue) itrListIterator.next();
                Bundle bundleWithoutBitmap = cue.toBundleWithoutBitmap();
                Bitmap bitmap = cue.bitmap;
                if (bitmap != null) {
                    bundleWithoutBitmap.putParcelable(Cue.FIELD_BITMAP_PARCELABLE, bitmap);
                }
                arrayList9.add(bundleWithoutBitmap);
            }
            bundle16.putParcelableArrayList(str5, arrayList9);
            bundle16.putLong(CueGroup.FIELD_PRESENTATION_TIME_US, cueGroup2.presentationTimeUs);
            bundle.putBundle(FIELD_CUE_GROUP, bundle16);
        }
        DeviceInfo deviceInfo = DeviceInfo.UNKNOWN;
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (!deviceInfo2.equals(deviceInfo)) {
            Bundle bundle17 = new Bundle();
            int i22 = deviceInfo2.playbackType;
            if (i22 != 0) {
                bundle17.putInt(DeviceInfo.FIELD_PLAYBACK_TYPE, i22);
            }
            int i23 = deviceInfo2.minVolume;
            if (i23 != 0) {
                bundle17.putInt(DeviceInfo.FIELD_MIN_VOLUME, i23);
            }
            int i24 = deviceInfo2.maxVolume;
            if (i24 != 0) {
                bundle17.putInt(DeviceInfo.FIELD_MAX_VOLUME, i24);
            }
            String str6 = deviceInfo2.routingControllerId;
            if (str6 != null) {
                bundle17.putString(DeviceInfo.FIELD_ROUTING_CONTROLLER_ID, str6);
            }
            bundle.putBundle(FIELD_DEVICE_INFO, bundle17);
        }
        int i25 = this.deviceVolume;
        if (i25 != 0) {
            bundle.putInt(FIELD_DEVICE_VOLUME, i25);
        }
        boolean z9 = this.deviceMuted;
        if (z9) {
            bundle.putBoolean(FIELD_DEVICE_MUTED, z9);
        }
        boolean z10 = this.playWhenReady;
        if (z10) {
            bundle.putBoolean(FIELD_PLAY_WHEN_READY, z10);
        }
        int i26 = this.playWhenReadyChangeReason;
        if (i26 != 1) {
            bundle.putInt(FIELD_PLAY_WHEN_READY_CHANGE_REASON, i26);
        }
        int i27 = this.playbackSuppressionReason;
        if (i27 != 0) {
            bundle.putInt(FIELD_PLAYBACK_SUPPRESSION_REASON, i27);
        }
        int i28 = this.playbackState;
        if (i28 != 1) {
            bundle.putInt(FIELD_PLAYBACK_STATE, i28);
        }
        boolean z11 = this.isPlaying;
        if (z11) {
            bundle.putBoolean(FIELD_IS_PLAYING, z11);
        }
        boolean z12 = this.isLoading;
        if (z12) {
            bundle.putBoolean(FIELD_IS_LOADING, z12);
        }
        MediaMetadata mediaMetadata3 = MediaMetadata.EMPTY;
        MediaMetadata mediaMetadata4 = this.mediaMetadata;
        if (!mediaMetadata4.equals(mediaMetadata3)) {
            bundle.putBundle(FIELD_MEDIA_METADATA, mediaMetadata4.toBundle(i2));
        }
        long j14 = i2 < 6 ? j : 5000L;
        long j15 = this.seekBackIncrementMs;
        if (j15 != j14) {
            bundle.putLong(FIELD_SEEK_BACK_INCREMENT_MS, j15);
        }
        long j16 = i2 < 6 ? j : 15000L;
        long j17 = this.seekForwardIncrementMs;
        if (j17 != j16) {
            bundle.putLong(FIELD_SEEK_FORWARD_INCREMENT_MS, j17);
        }
        long j18 = i2 < 6 ? j : 3000L;
        long j19 = this.maxSeekToPreviousPositionMs;
        if (j19 != j18) {
            bundle.putLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, j19);
        }
        Tracks tracks = Tracks.EMPTY;
        Tracks tracks2 = this.currentTracks;
        if (!tracks2.equals(tracks)) {
            Bundle bundle18 = new Bundle();
            bundle18.putParcelableArrayList(Tracks.FIELD_TRACK_GROUPS, GlUtil.toBundleArrayList(tracks2.groups, new Format$$ExternalSyntheticLambda1((byte) 5)));
            bundle.putBundle(FIELD_CURRENT_TRACKS, bundle18);
        }
        TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.DEFAULT;
        TrackSelectionParameters trackSelectionParameters2 = this.trackSelectionParameters;
        if (!trackSelectionParameters2.equals(trackSelectionParameters)) {
            bundle.putBundle(FIELD_TRACK_SELECTION_PARAMETERS, trackSelectionParameters2.toBundle());
        }
        return bundle;
    }
}
