package androidx.media3.session;

import android.os.Looper;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.ForwardingPlayer$ForwardingListener;
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
import androidx.media3.session.PlayerWrapper;
import coil3.util.UtilsKt;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerWrapper implements Player {
    public final IdentityHashMap listeners = new IdentityHashMap();
    public final Player player;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CurrentMediaItemOnlyTimeline extends Timeline {
        public static final Object UID = new Object();
        public final long durationUs;
        public final boolean isDynamic;
        public final boolean isSeekable;
        public final MediaItem.LiveConfiguration liveConfiguration;
        public final MediaItem mediaItem;

        public CurrentMediaItemOnlyTimeline(PlayerWrapper playerWrapper) {
            this.mediaItem = playerWrapper.getCurrentMediaItem();
            this.isSeekable = playerWrapper.isCurrentMediaItemSeekable();
            this.isDynamic = playerWrapper.isCurrentMediaItemDynamic();
            this.liveConfiguration = playerWrapper.isCurrentMediaItemLive() ? MediaItem.LiveConfiguration.UNSET : null;
            this.durationUs = Util.msToUs(playerWrapper.getContentDuration());
        }

        @Override // androidx.media3.common.Timeline
        public final int getIndexOfPeriod(Object obj) {
            return UID != obj ? -1 : 0;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            period.getClass();
            AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
            Object obj = UID;
            period.set(obj, obj, 0, this.durationUs, 0L, adPlaybackState, false);
            period.isPlaceholder = false;
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public final int getPeriodCount() {
            return 1;
        }

        @Override // androidx.media3.common.Timeline
        public final Object getUidOfPeriod(int i) {
            return UID;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(UID, this.mediaItem, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.isSeekable, this.isDynamic, this.liveConfiguration, 0L, this.durationUs, 0, 0, 0L);
            window.isPlaceholder = false;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public final int getWindowCount() {
            return 1;
        }
    }

    public PlayerWrapper(Player player) {
        this.player = player;
    }

    @Override // androidx.media3.common.Player
    public final void addListener(final Player.Listener listener) {
        verifyApplicationThread$1();
        synchronized (this.listeners) {
            try {
                Player.Listener listener2 = (ForwardingPlayer$ForwardingListener) this.listeners.get(listener);
                if (listener2 == null) {
                    listener2 = new Player.Listener(this, listener) { // from class: androidx.media3.common.ForwardingPlayer$ForwardingListener
                        public final PlayerWrapper forwardingPlayer;
                        public final Player.Listener listener;

                        {
                            this.forwardingPlayer = this;
                            this.listener = listener;
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                            this.listener.onAudioAttributesChanged(audioAttributes);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onAudioSessionIdChanged(int i) {
                            this.listener.onAudioSessionIdChanged(i);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onAvailableCommandsChanged(Player.Commands commands) {
                            this.listener.onAvailableCommandsChanged(commands);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onCues(List list) {
                            this.listener.onCues(list);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                            this.listener.onDeviceInfoChanged(deviceInfo);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onDeviceVolumeChanged(int i, boolean z) {
                            this.listener.onDeviceVolumeChanged(i, z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onEvents(Player player, Player.Events events) {
                            this.listener.onEvents(this.forwardingPlayer, events);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onIsLoadingChanged(boolean z) {
                            this.listener.onIsLoadingChanged(z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onIsPlayingChanged(boolean z) {
                            this.listener.onIsPlayingChanged(z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onLoadingChanged(boolean z) {
                            this.listener.onIsLoadingChanged(z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onMaxSeekToPreviousPositionChanged(long j) {
                            this.listener.onMaxSeekToPreviousPositionChanged(j);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onMediaItemTransition(int i, MediaItem mediaItem) {
                            this.listener.onMediaItemTransition(i, mediaItem);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                            this.listener.onMediaMetadataChanged(mediaMetadata);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onMetadata(Metadata metadata) {
                            this.listener.onMetadata(metadata);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlayWhenReadyChanged(int i, boolean z) {
                            this.listener.onPlayWhenReadyChanged(i, z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                            this.listener.onPlaybackParametersChanged(playbackParameters);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlaybackStateChanged(int i) {
                            this.listener.onPlaybackStateChanged(i);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlaybackSuppressionReasonChanged(int i) {
                            this.listener.onPlaybackSuppressionReasonChanged(i);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlayerError(PlaybackException playbackException) {
                            this.listener.onPlayerError(playbackException);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlayerErrorChanged(PlaybackException playbackException) {
                            this.listener.onPlayerErrorChanged(playbackException);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlayerStateChanged(int i, boolean z) {
                            this.listener.onPlayerStateChanged(i, z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                            this.listener.onPlaylistMetadataChanged(mediaMetadata);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPositionDiscontinuity(int i) {
                            this.listener.onPositionDiscontinuity(i);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onRenderedFirstFrame() {
                            this.listener.onRenderedFirstFrame();
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onRepeatModeChanged(int i) {
                            this.listener.onRepeatModeChanged(i);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onSeekBackIncrementChanged(long j) {
                            this.listener.onSeekBackIncrementChanged(j);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onSeekForwardIncrementChanged(long j) {
                            this.listener.onSeekForwardIncrementChanged(j);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onShuffleModeEnabledChanged(boolean z) {
                            this.listener.onShuffleModeEnabledChanged(z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onSkipSilenceEnabledChanged(boolean z) {
                            this.listener.onSkipSilenceEnabledChanged(z);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onSurfaceSizeChanged(int i, int i2) {
                            this.listener.onSurfaceSizeChanged(i, i2);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onTimelineChanged(Timeline timeline, int i) {
                            this.listener.onTimelineChanged(timeline, i);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                            this.listener.onTrackSelectionParametersChanged(trackSelectionParameters);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onTracksChanged(Tracks tracks) {
                            this.listener.onTracksChanged(tracks);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onVideoSizeChanged(VideoSize videoSize) {
                            this.listener.onVideoSizeChanged(videoSize);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onVolumeChanged(float f) {
                            this.listener.onVolumeChanged(f);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onCues(CueGroup cueGroup) {
                            this.listener.onCues(cueGroup);
                        }

                        @Override // androidx.media3.common.Player.Listener
                        public final void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
                            this.listener.onPositionDiscontinuity(i, positionInfo, positionInfo2);
                        }
                    };
                }
                this.player.addListener(listener2);
                this.listeners.put(listener, listener2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(List list) {
        verifyApplicationThread$1();
        this.player.addMediaItems(list);
    }

    @Override // androidx.media3.common.Player
    public final boolean canAdvertiseSession() {
        return this.player.canAdvertiseSession();
    }

    @Override // androidx.media3.common.Player
    public final void clearMediaItems() {
        verifyApplicationThread$1();
        this.player.clearMediaItems();
    }

    public final Player.PositionInfo createPositionInfo() {
        boolean zIsCommandAvailable = isCommandAvailable(16);
        boolean zIsCommandAvailable2 = isCommandAvailable(17);
        int currentMediaItemIndex = zIsCommandAvailable2 ? getCurrentMediaItemIndex() : 0;
        UtilsKt.checkState(currentMediaItemIndex >= 0);
        int currentPeriodIndex = zIsCommandAvailable2 ? getCurrentPeriodIndex() : 0;
        UtilsKt.checkState(currentPeriodIndex >= 0);
        if (zIsCommandAvailable2) {
            Timeline currentTimeline = getCurrentTimeline();
            if (!currentTimeline.isEmpty()) {
                UtilsKt.checkState(currentMediaItemIndex < currentTimeline.getWindowCount());
                Timeline.Window window = currentTimeline.getWindow(currentMediaItemIndex, new Timeline.Window(), 0L);
                UtilsKt.checkState(currentPeriodIndex == Util.constrainValue(currentPeriodIndex, window.firstPeriodIndex, window.lastPeriodIndex));
            }
        }
        long contentPosition = 0;
        MediaItem currentMediaItem = zIsCommandAvailable ? getCurrentMediaItem() : null;
        long currentPosition = zIsCommandAvailable ? getCurrentPosition() : 0L;
        if (zIsCommandAvailable) {
            contentPosition = getContentPosition();
        }
        return new Player.PositionInfo(null, currentMediaItemIndex, currentMediaItem, null, currentPeriodIndex, currentPosition, contentPosition, zIsCommandAvailable ? getCurrentAdGroupIndex() : -1, zIsCommandAvailable ? getCurrentAdIndexInAdGroup() : -1);
    }

    public final SessionPositionInfo createSessionPositionInfo() {
        boolean zIsCommandAvailable = isCommandAvailable(16);
        return new SessionPositionInfo(createPositionInfo(), zIsCommandAvailable && isPlayingAd(), SystemClock.elapsedRealtime(), zIsCommandAvailable ? getDuration() : -9223372036854775807L, zIsCommandAvailable ? getBufferedPosition() : 0L, zIsCommandAvailable ? getBufferedPercentage() : 0, zIsCommandAvailable ? getTotalBufferedDuration() : 0L, zIsCommandAvailable ? getCurrentLiveOffset() : -9223372036854775807L, zIsCommandAvailable ? getContentDuration() : -9223372036854775807L, zIsCommandAvailable ? getContentBufferedPosition() : 0L);
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume() {
        verifyApplicationThread$1();
        this.player.decreaseDeviceVolume();
    }

    @Override // androidx.media3.common.Player
    public final Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes getAudioAttributes() {
        verifyApplicationThread$1();
        return this.player.getAudioAttributes();
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands getAvailableCommands() {
        verifyApplicationThread$1();
        return this.player.getAvailableCommands();
    }

    @Override // androidx.media3.common.Player
    public final int getBufferedPercentage() {
        verifyApplicationThread$1();
        return this.player.getBufferedPercentage();
    }

    @Override // androidx.media3.common.Player
    public final long getBufferedPosition() {
        verifyApplicationThread$1();
        return this.player.getBufferedPosition();
    }

    @Override // androidx.media3.common.Player
    public final long getContentBufferedPosition() {
        verifyApplicationThread$1();
        return this.player.getContentBufferedPosition();
    }

    @Override // androidx.media3.common.Player
    public final long getContentDuration() {
        verifyApplicationThread$1();
        return this.player.getContentDuration();
    }

    @Override // androidx.media3.common.Player
    public final long getContentPosition() {
        verifyApplicationThread$1();
        return this.player.getContentPosition();
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdGroupIndex() {
        verifyApplicationThread$1();
        return this.player.getCurrentAdGroupIndex();
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread$1();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override // androidx.media3.common.Player
    public final CueGroup getCurrentCues() {
        verifyApplicationThread$1();
        return this.player.getCurrentCues();
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentLiveOffset() {
        verifyApplicationThread$1();
        return this.player.getCurrentLiveOffset();
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getCurrentMediaItem() {
        verifyApplicationThread$1();
        return this.player.getCurrentMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentMediaItemIndex() {
        verifyApplicationThread$1();
        return this.player.getCurrentMediaItemIndex();
    }

    public final MediaItem getCurrentMediaItemWithCommandCheck() {
        if (isCommandAvailable(16)) {
            return getCurrentMediaItem();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentPeriodIndex() {
        verifyApplicationThread$1();
        return this.player.getCurrentPeriodIndex();
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentPosition() {
        verifyApplicationThread$1();
        return this.player.getCurrentPosition();
    }

    @Override // androidx.media3.common.Player
    public final Timeline getCurrentTimeline() {
        verifyApplicationThread$1();
        return this.player.getCurrentTimeline();
    }

    public final Timeline getCurrentTimelineWithCommandCheck() {
        if (isCommandAvailable(17)) {
            return getCurrentTimeline();
        }
        return getCurrentMediaItemWithCommandCheck() != null ? new CurrentMediaItemOnlyTimeline(this) : Timeline.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final Tracks getCurrentTracks() {
        verifyApplicationThread$1();
        return this.player.getCurrentTracks();
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo getDeviceInfo() {
        verifyApplicationThread$1();
        return this.player.getDeviceInfo();
    }

    @Override // androidx.media3.common.Player
    public final int getDeviceVolume() {
        verifyApplicationThread$1();
        return this.player.getDeviceVolume();
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        verifyApplicationThread$1();
        return this.player.getDuration();
    }

    @Override // androidx.media3.common.Player
    public final long getMaxSeekToPreviousPosition() {
        verifyApplicationThread$1();
        return this.player.getMaxSeekToPreviousPosition();
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getMediaItemAt(int i) {
        verifyApplicationThread$1();
        return this.player.getMediaItemAt(i);
    }

    @Override // androidx.media3.common.Player
    public final int getMediaItemCount() {
        verifyApplicationThread$1();
        return this.player.getMediaItemCount();
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getMediaMetadata() {
        verifyApplicationThread$1();
        return this.player.getMediaMetadata();
    }

    public final MediaMetadata getMediaMetadataWithCommandCheck() {
        return isCommandAvailable(18) ? getMediaMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final boolean getPlayWhenReady() {
        verifyApplicationThread$1();
        return this.player.getPlayWhenReady();
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread$1();
        return this.player.getPlaybackParameters();
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackState() {
        verifyApplicationThread$1();
        return this.player.getPlaybackState();
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackSuppressionReason() {
        verifyApplicationThread$1();
        return this.player.getPlaybackSuppressionReason();
    }

    @Override // androidx.media3.common.Player
    public final PlaybackException getPlayerError() {
        verifyApplicationThread$1();
        return this.player.getPlayerError();
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread$1();
        return this.player.getPlaylistMetadata();
    }

    @Override // androidx.media3.common.Player
    public final int getRepeatMode() {
        verifyApplicationThread$1();
        return this.player.getRepeatMode();
    }

    @Override // androidx.media3.common.Player
    public final long getSeekBackIncrement() {
        verifyApplicationThread$1();
        return this.player.getSeekBackIncrement();
    }

    @Override // androidx.media3.common.Player
    public final long getSeekForwardIncrement() {
        verifyApplicationThread$1();
        return this.player.getSeekForwardIncrement();
    }

    @Override // androidx.media3.common.Player
    public final boolean getShuffleModeEnabled() {
        verifyApplicationThread$1();
        return this.player.getShuffleModeEnabled();
    }

    @Override // androidx.media3.common.Player
    public final long getTotalBufferedDuration() {
        verifyApplicationThread$1();
        return this.player.getTotalBufferedDuration();
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread$1();
        return this.player.getTrackSelectionParameters();
    }

    @Override // androidx.media3.common.Player
    public final VideoSize getVideoSize() {
        verifyApplicationThread$1();
        return this.player.getVideoSize();
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        verifyApplicationThread$1();
        return this.player.getVolume();
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume() {
        verifyApplicationThread$1();
        this.player.increaseDeviceVolume();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCommandAvailable(int i) {
        verifyApplicationThread$1();
        return this.player.isCommandAvailable(i);
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemDynamic() {
        verifyApplicationThread$1();
        return this.player.isCurrentMediaItemDynamic();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemLive() {
        verifyApplicationThread$1();
        return this.player.isCurrentMediaItemLive();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemSeekable() {
        verifyApplicationThread$1();
        return this.player.isCurrentMediaItemSeekable();
    }

    @Override // androidx.media3.common.Player
    public final boolean isDeviceMuted() {
        verifyApplicationThread$1();
        return this.player.isDeviceMuted();
    }

    public final boolean isDeviceMutedWithCommandCheck() {
        return isCommandAvailable(23) && isDeviceMuted();
    }

    @Override // androidx.media3.common.Player
    public final boolean isLoading() {
        verifyApplicationThread$1();
        return this.player.isLoading();
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlaying() {
        verifyApplicationThread$1();
        return this.player.isPlaying();
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlayingAd() {
        verifyApplicationThread$1();
        return this.player.isPlayingAd();
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItem(int i, int i2) {
        verifyApplicationThread$1();
        this.player.moveMediaItem(i, i2);
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread$1();
        this.player.moveMediaItems(i, i2, i3);
    }

    @Override // androidx.media3.common.Player
    public final void mute() {
        verifyApplicationThread$1();
        this.player.mute();
    }

    @Override // androidx.media3.common.Player
    public final void pause() {
        verifyApplicationThread$1();
        this.player.pause();
    }

    @Override // androidx.media3.common.Player
    public final void play() {
        verifyApplicationThread$1();
        this.player.play();
    }

    @Override // androidx.media3.common.Player
    public final void prepare() {
        verifyApplicationThread$1();
        this.player.prepare();
    }

    @Override // androidx.media3.common.Player
    public final void removeListener(Player.Listener listener) {
        verifyApplicationThread$1();
        synchronized (this.listeners) {
            Player.Listener listener2 = (Player.Listener) this.listeners.remove(listener);
            Player player = this.player;
            if (listener2 != null) {
                listener = listener2;
            }
            player.removeListener(listener);
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItem(int i) {
        verifyApplicationThread$1();
        this.player.removeMediaItem(i);
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItems(int i, int i2) {
        verifyApplicationThread$1();
        this.player.removeMediaItems(i, i2);
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread$1();
        this.player.replaceMediaItem(i, mediaItem);
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItems(int i, int i2, List list) {
        verifyApplicationThread$1();
        this.player.replaceMediaItems(i, i2, list);
    }

    @Override // androidx.media3.common.Player
    public final void seekBack() {
        verifyApplicationThread$1();
        this.player.seekBack();
    }

    @Override // androidx.media3.common.Player
    public final void seekForward() {
        verifyApplicationThread$1();
        this.player.seekForward();
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(long j) {
        verifyApplicationThread$1();
        this.player.seekTo(j);
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition(int i) {
        verifyApplicationThread$1();
        this.player.seekToDefaultPosition(i);
    }

    @Override // androidx.media3.common.Player
    public final void seekToNext() {
        verifyApplicationThread$1();
        this.player.seekToNext();
    }

    @Override // androidx.media3.common.Player
    public final void seekToNextMediaItem() {
        verifyApplicationThread$1();
        this.player.seekToNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final void seekToPrevious() {
        verifyApplicationThread$1();
        this.player.seekToPrevious();
    }

    @Override // androidx.media3.common.Player
    public final void seekToPreviousMediaItem() {
        verifyApplicationThread$1();
        this.player.seekToPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        this.player.setAudioAttributes(audioAttributes, z);
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(boolean z) {
        verifyApplicationThread$1();
        this.player.setDeviceMuted(z);
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(int i) {
        verifyApplicationThread$1();
        this.player.setDeviceVolume(i);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread$1();
        this.player.setMediaItem(mediaItem);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem$1(MediaItem mediaItem) {
        verifyApplicationThread$1();
        this.player.setMediaItem$1(mediaItem);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List list) {
        verifyApplicationThread$1();
        this.player.setMediaItems(list);
    }

    @Override // androidx.media3.common.Player
    public final void setPlayWhenReady(boolean z) {
        verifyApplicationThread$1();
        this.player.setPlayWhenReady(z);
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread$1();
        this.player.setPlaybackParameters(playbackParameters);
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackSpeed(float f) {
        verifyApplicationThread$1();
        this.player.setPlaybackSpeed(f);
    }

    @Override // androidx.media3.common.Player
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThread$1();
        this.player.setPlaylistMetadata(mediaMetadata);
    }

    @Override // androidx.media3.common.Player
    public final void setRepeatMode(int i) {
        verifyApplicationThread$1();
        this.player.setRepeatMode(i);
    }

    @Override // androidx.media3.common.Player
    public final void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread$1();
        this.player.setShuffleModeEnabled(z);
    }

    @Override // androidx.media3.common.Player
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread$1();
        this.player.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread$1();
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // androidx.media3.common.Player
    public final void setVolume(float f) {
        verifyApplicationThread$1();
        this.player.setVolume(f);
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        verifyApplicationThread$1();
        this.player.stop();
    }

    @Override // androidx.media3.common.Player
    public final void unmute() {
        verifyApplicationThread$1();
        this.player.unmute();
    }

    public final void verifyApplicationThread$1() {
        UtilsKt.checkState(Looper.myLooper() == this.player.getApplicationLooper());
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(int i, List list) {
        verifyApplicationThread$1();
        this.player.addMediaItems(i, list);
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume(int i) {
        verifyApplicationThread$1();
        this.player.decreaseDeviceVolume(i);
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume(int i) {
        verifyApplicationThread$1();
        this.player.increaseDeviceVolume(i);
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(int i, long j) {
        verifyApplicationThread$1();
        this.player.seekTo(i, j);
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition() {
        verifyApplicationThread$1();
        this.player.seekToDefaultPosition();
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(int i, boolean z) {
        verifyApplicationThread$1();
        this.player.setDeviceMuted(i, z);
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(int i, int i2) {
        verifyApplicationThread$1();
        this.player.setDeviceVolume(i, i2);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem, long j) {
        verifyApplicationThread$1();
        this.player.setMediaItem(mediaItem, j);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List list, int i, long j) {
        verifyApplicationThread$1();
        this.player.setMediaItems(list, i, j);
    }
}
