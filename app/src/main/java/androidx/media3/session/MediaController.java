package androidx.media3.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.yalantis.ucrop.view.CropImageView;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaController implements Player {
    public final Handler applicationHandler;
    public final MediaControllerHolder connectionCallback;
    public boolean connectionNotified;
    public final MediaControllerImpl impl;
    public final Listener listener;
    public boolean released;
    public final long timeDiffMs;
    public final Timeline.Window window;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface MediaControllerImpl {
        void addListener(Player.Listener listener);

        void addMediaItems(int i, List list);

        void addMediaItems(List list);

        void clearMediaItems();

        void connect();

        void decreaseDeviceVolume();

        void decreaseDeviceVolume(int i);

        AudioAttributes getAudioAttributes();

        Player.Commands getAvailableCommands();

        SessionCommands getAvailableSessionCommands();

        int getBufferedPercentage();

        long getBufferedPosition();

        Bundle getConnectionHints();

        long getContentBufferedPosition();

        long getContentDuration();

        long getContentPosition();

        int getCurrentAdGroupIndex();

        int getCurrentAdIndexInAdGroup();

        CueGroup getCurrentCues();

        long getCurrentLiveOffset();

        int getCurrentMediaItemIndex();

        int getCurrentPeriodIndex();

        long getCurrentPosition();

        Timeline getCurrentTimeline();

        Tracks getCurrentTracks();

        DeviceInfo getDeviceInfo();

        int getDeviceVolume();

        long getDuration();

        long getMaxSeekToPreviousPosition();

        ImmutableList getMediaButtonPreferences();

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

        boolean isConnected();

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

        void release();

        void removeListener(Player.Listener listener);

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

        ListenableFuture sendCustomCommand(SessionCommand sessionCommand, Bundle bundle);

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

    public MediaController(Context context, SessionToken sessionToken, Bundle bundle, Listener listener, Looper looper, MediaControllerHolder mediaControllerHolder, CallbackWrapper callbackWrapper) {
        MediaController mediaController;
        MediaControllerImpl mediaControllerImplBase;
        UtilsKt.checkNotNull(sessionToken, "token must not be null");
        Log.i("MediaController", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.1] [" + Util.DEVICE_DEBUG_INFO + "]");
        this.window = new Timeline.Window();
        this.timeDiffMs = -9223372036854775807L;
        this.listener = listener;
        this.applicationHandler = new Handler(looper);
        this.connectionCallback = mediaControllerHolder;
        if (sessionToken.impl.isLegacySession()) {
            callbackWrapper.getClass();
            mediaControllerImplBase = new MediaControllerImplLegacy(context, this, sessionToken, bundle, looper, callbackWrapper);
            mediaController = this;
        } else {
            mediaController = this;
            mediaControllerImplBase = new MediaControllerImplBase(context, mediaController, sessionToken, bundle, looper);
        }
        mediaController.impl = mediaControllerImplBase;
        mediaControllerImplBase.connect();
    }

    public static void releaseFuture(MediaControllerHolder mediaControllerHolder) {
        if (mediaControllerHolder.cancel(false)) {
            return;
        }
        try {
            ((MediaController) UuidKt.getDone(mediaControllerHolder)).release();
        } catch (CancellationException | ExecutionException e) {
            Log.w("MediaController", "MediaController future failed (so we couldn't release it)", e);
        }
    }

    @Override // androidx.media3.common.Player
    public final void addListener(Player.Listener listener) {
        this.impl.addListener(listener);
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(List list) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.addMediaItems(list);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean canAdvertiseSession() {
        return false;
    }

    @Override // androidx.media3.common.Player
    public final void clearMediaItems() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.clearMediaItems();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring clearMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.decreaseDeviceVolume();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final Looper getApplicationLooper() {
        return this.applicationHandler.getLooper();
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes getAudioAttributes() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return !mediaControllerImpl.isConnected() ? AudioAttributes.DEFAULT : mediaControllerImpl.getAudioAttributes();
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands getAvailableCommands() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return !mediaControllerImpl.isConnected() ? Player.Commands.EMPTY : mediaControllerImpl.getAvailableCommands();
    }

    @Override // androidx.media3.common.Player
    public final int getBufferedPercentage() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getBufferedPercentage();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getBufferedPosition() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getBufferedPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getContentBufferedPosition() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getContentBufferedPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getContentDuration() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getContentDuration();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final long getContentPosition() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getContentPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdGroupIndex() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getCurrentAdGroupIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getCurrentAdIndexInAdGroup();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup getCurrentCues() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.getCurrentCues() : CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentLiveOffset() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getCurrentLiveOffset();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentMediaItemIndex() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getCurrentMediaItemIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentPeriodIndex() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getCurrentPeriodIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentPosition() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getCurrentPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final Timeline getCurrentTimeline() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.getCurrentTimeline() : Timeline.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final Tracks getCurrentTracks() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.getCurrentTracks() : Tracks.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo getDeviceInfo() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return !mediaControllerImpl.isConnected() ? DeviceInfo.UNKNOWN : mediaControllerImpl.getDeviceInfo();
    }

    @Override // androidx.media3.common.Player
    public final int getDeviceVolume() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getDeviceVolume();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getDuration();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final long getMaxSeekToPreviousPosition() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getMaxSeekToPreviousPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window, 0L).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getMediaMetadata() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.getMediaMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final boolean getPlayWhenReady() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.getPlayWhenReady();
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.getPlaybackParameters() : PlaybackParameters.DEFAULT;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackState() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getPlaybackState();
        }
        return 1;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackSuppressionReason() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getPlaybackSuppressionReason();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackException getPlayerError() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getPlayerError();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.getPlaylistMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final int getRepeatMode() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getRepeatMode();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekBackIncrement() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getSeekBackIncrement();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekForwardIncrement() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getSeekForwardIncrement();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final boolean getShuffleModeEnabled() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.getShuffleModeEnabled();
    }

    @Override // androidx.media3.common.Player
    public final long getTotalBufferedDuration() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getTotalBufferedDuration();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return !mediaControllerImpl.isConnected() ? TrackSelectionParameters.DEFAULT : mediaControllerImpl.getTrackSelectionParameters();
    }

    @Override // androidx.media3.common.Player
    public final VideoSize getVideoSize() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() ? mediaControllerImpl.getVideoSize() : VideoSize.UNKNOWN;
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.getVolume();
        }
        return 1.0f;
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.increaseDeviceVolume();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().contains(i);
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemDynamic() {
        verifyApplicationThread$2();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).isDynamic;
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemLive() {
        verifyApplicationThread$2();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).isLive();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemSeekable() {
        verifyApplicationThread$2();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).isSeekable;
    }

    @Override // androidx.media3.common.Player
    public final boolean isDeviceMuted() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            return mediaControllerImpl.isDeviceMuted();
        }
        return false;
    }

    @Override // androidx.media3.common.Player
    public final boolean isLoading() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.isLoading();
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlaying() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.isPlaying();
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlayingAd() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        return mediaControllerImpl.isConnected() && mediaControllerImpl.isPlayingAd();
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItem(int i, int i2) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.moveMediaItem(i, i2);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring moveMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.moveMediaItems(i, i2, i3);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring moveMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void mute() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.mute();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring mute().");
        }
    }

    public final void notifyAccepted() {
        UtilsKt.checkState(Looper.myLooper() == this.applicationHandler.getLooper());
        UtilsKt.checkState(!this.connectionNotified);
        this.connectionNotified = true;
        MediaControllerHolder mediaControllerHolder = this.connectionCallback;
        mediaControllerHolder.accepted = true;
        MediaController mediaController = mediaControllerHolder.controller;
        if (mediaController != null) {
            mediaControllerHolder.set(mediaController);
        }
    }

    @Override // androidx.media3.common.Player
    public final void pause() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.pause();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring pause().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void play() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.play();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring play().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void prepare() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.prepare();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring prepare().");
        }
    }

    public final void release() {
        String str;
        Handler handler = this.applicationHandler;
        verifyApplicationThread$2();
        if (this.released) {
            return;
        }
        StringBuilder sb = new StringBuilder("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [AndroidXMedia3/1.10.1] [");
        sb.append(Util.DEVICE_DEBUG_INFO);
        sb.append("] [");
        HashSet hashSet = MediaLibraryInfo.registeredModules;
        synchronized (MediaLibraryInfo.class) {
            str = MediaLibraryInfo.registeredModulesString;
        }
        sb.append(str);
        sb.append("]");
        Log.i("MediaController", sb.toString());
        this.released = true;
        handler.removeCallbacksAndMessages(null);
        try {
            this.impl.release();
        } catch (Exception e) {
            Log.d("Exception while releasing impl", e);
        }
        if (this.connectionNotified) {
            UtilsKt.checkState(Looper.myLooper() == handler.getLooper());
            this.listener.onDisconnected();
        } else {
            this.connectionNotified = true;
            MediaControllerHolder mediaControllerHolder = this.connectionCallback;
            mediaControllerHolder.getClass();
            mediaControllerHolder.setException(new SecurityException("Session rejected the connection request."));
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeListener(Player.Listener listener) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(listener, "listener must not be null");
        this.impl.removeListener(listener);
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItem(int i) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.removeMediaItem(i);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring removeMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItems(int i, int i2) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.removeMediaItems(i, i2);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring removeMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.replaceMediaItem(i, mediaItem);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring replaceMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItems(int i, int i2, List list) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.replaceMediaItems(i, i2, list);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring replaceMediaItems().");
        }
    }

    public final void runOnApplicationLooper(Runnable runnable) {
        Util.postOrRun(this.applicationHandler, runnable);
    }

    @Override // androidx.media3.common.Player
    public final void seekBack() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekBack();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekBack().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekForward() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekForward();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekForward().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(long j) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekTo(j);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekToDefaultPosition();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToNext() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekToNext();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToNext().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToNextMediaItem() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekToNextMediaItem();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToNextMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToPrevious() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekToPrevious();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToPrevious().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToPreviousMediaItem() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.seekToPreviousMediaItem();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToPreviousMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setAudioAttributes(audioAttributes, z);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setAudioAttributes().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(boolean z) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setDeviceMuted(z);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(int i) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setDeviceVolume(i);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(mediaItem, "mediaItems must not be null");
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setMediaItem(mediaItem);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem$1(MediaItem mediaItem) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(mediaItem, "mediaItems must not be null");
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setMediaItem$1(mediaItem);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List list) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(list, "mediaItems must not be null");
        for (int i = 0; i < list.size(); i++) {
            UtilsKt.checkArgument("items must not contain null, index=%s", i, list.get(i) != null);
        }
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setMediaItems(list);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlayWhenReady(boolean z) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setPlayWhenReady(z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(playbackParameters, "playbackParameters must not be null");
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setPlaybackParameters(playbackParameters);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setPlaybackParameters().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackSpeed(float f) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setPlaybackSpeed(f);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setPlaybackSpeed().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(mediaMetadata, "playlistMetadata must not be null");
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setPlaylistMetadata(mediaMetadata);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setPlaylistMetadata().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setRepeatMode(int i) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setRepeatMode(i);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setRepeatMode().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setShuffleModeEnabled(z);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setShuffleMode().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setTrackSelectionParameters().");
        }
        mediaControllerImpl.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setVideoSurfaceHolder(surfaceHolder);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setVideoSurfaceHolder().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVolume(float f) {
        verifyApplicationThread$2();
        UtilsKt.checkArgument("volume must be between 0 and 1", f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= 1.0f);
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.setVolume(f);
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring setVolume().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.stop();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring stop().");
        }
    }

    @Override // androidx.media3.common.Player
    public final void unmute() {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaControllerImpl.unmute();
        } else {
            Log.w("MediaController", "The controller is not connected. Ignoring unmute().");
        }
    }

    public final void verifyApplicationThread$2() {
        UtilsKt.checkState("MediaController method is called from a wrong thread. See javadoc of MediaController for details.", Looper.myLooper() == this.applicationHandler.getLooper());
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Listener {
        static ImmediateFuture onSetCustomLayout() {
            return new ImmediateFuture(new SessionResult(-6));
        }

        default ImmediateFuture onCustomCommand(SessionCommand sessionCommand) {
            return new ImmediateFuture(new SessionResult(-6));
        }

        default void onAvailableSessionCommandsChanged() {
        }

        default void onDisconnected() {
        }

        default void onMediaButtonPreferencesChanged() {
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(int i, List list) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        } else {
            mediaControllerImpl.addMediaItems(i, list);
        }
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume(int i) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        } else {
            mediaControllerImpl.decreaseDeviceVolume(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume(int i) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        } else {
            mediaControllerImpl.increaseDeviceVolume(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(int i, long j) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            mediaControllerImpl.seekTo(i, j);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition(int i) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            mediaControllerImpl.seekToDefaultPosition(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(int i, boolean z) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        } else {
            mediaControllerImpl.setDeviceMuted(i, z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(int i, int i2) {
        verifyApplicationThread$2();
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        } else {
            mediaControllerImpl.setDeviceVolume(i, i2);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem, long j) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(mediaItem, "mediaItems must not be null");
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        } else {
            mediaControllerImpl.setMediaItem(mediaItem, j);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List list, int i, long j) {
        verifyApplicationThread$2();
        UtilsKt.checkNotNull(list, "mediaItems must not be null");
        for (int i2 = 0; i2 < list.size(); i2++) {
            UtilsKt.checkArgument("items must not contain null, index=%s", i2, list.get(i2) != null);
        }
        MediaControllerImpl mediaControllerImpl = this.impl;
        if (!mediaControllerImpl.isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            mediaControllerImpl.setMediaItems(list, i, j);
        }
    }
}
