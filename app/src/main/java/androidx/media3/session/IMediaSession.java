package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface IMediaSession extends IInterface {
    void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle);

    void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder);

    void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder);

    void clearMediaItems(IMediaController iMediaController, int i);

    void connect(IMediaController iMediaController, int i, Bundle bundle);

    void decreaseDeviceVolume(IMediaController iMediaController, int i);

    void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2);

    void flushCommandQueue(IMediaController iMediaController);

    void increaseDeviceVolume(IMediaController iMediaController, int i);

    void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2);

    void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3);

    void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4);

    void mute(IMediaController iMediaController, int i);

    void onControllerResult(IMediaController iMediaController, int i, Bundle bundle);

    void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2);

    void onCustomCommandWithProgressUpdate(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2, boolean z);

    void onSurfaceSizeChanged(IMediaController iMediaController, int i, int i2, int i3);

    void pause(IMediaController iMediaController, int i);

    void play(IMediaController iMediaController, int i);

    void prepare(IMediaController iMediaController, int i);

    void release(IMediaController iMediaController, int i);

    void removeMediaItem(IMediaController iMediaController, int i, int i2);

    void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3);

    void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle);

    void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder);

    void seekBack(IMediaController iMediaController, int i);

    void seekForward(IMediaController iMediaController, int i);

    void seekTo(IMediaController iMediaController, int i, long j);

    void seekToDefaultPosition(IMediaController iMediaController, int i);

    void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2);

    void seekToNext(IMediaController iMediaController, int i);

    void seekToNextMediaItem(IMediaController iMediaController, int i);

    void seekToPrevious(IMediaController iMediaController, int i);

    void seekToPreviousMediaItem(IMediaController iMediaController, int i);

    void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j);

    void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z);

    void setDeviceMuted(IMediaController iMediaController, int i, boolean z);

    void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2);

    void setDeviceVolume(IMediaController iMediaController, int i, int i2);

    void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3);

    void setMediaItem(IMediaController iMediaController, int i, Bundle bundle);

    void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z);

    void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j);

    void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z);

    void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j);

    void setPlayWhenReady(IMediaController iMediaController, int i, boolean z);

    void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle);

    void setPlaybackSpeed(IMediaController iMediaController, int i, float f);

    void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle);

    void setRepeatMode(IMediaController iMediaController, int i, int i2);

    void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z);

    void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle);

    void setVideoSurface(IMediaController iMediaController, int i, Surface surface);

    void setVideoSurfaceWithSize(IMediaController iMediaController, int i, Surface surface, int i2, int i3);

    void setVolume(IMediaController iMediaController, int i, float f);

    void stop(IMediaController iMediaController, int i);

    void unmute(IMediaController iMediaController, int i);
}
