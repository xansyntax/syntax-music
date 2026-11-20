package androidx.media3.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceHolder;
import androidx.collection.ArrayMap;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.ListenerSet$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.session.MediaControllerImplLegacy;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaControllerCompat$Callback$CallbackStub;
import androidx.media3.session.legacy.MediaControllerCompat$Callback$MediaControllerCallback;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import androidx.media3.session.legacy.MediaControllerCompat$PlaybackInfo;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.MediaSessionCompat$QueueItem;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.materialkolor.quantize.QuantizerWu;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    public final BitmapLoader bitmapLoader;
    public MediaBrowserCompat browserCompat;
    public boolean connected;
    public final Bundle connectionHints;
    public final Context context;
    public CallbackWrapper controllerCompat;
    public final ControllerCompatCallback controllerCompatCallback;
    public boolean hasInitializedLegacyPlaylist;
    public boolean hasPendingExtrasChange;
    public final MediaController instance;
    public final ListenerSet listeners;
    public boolean released;
    public final SessionToken token;
    public LegacyPlayerInfo legacyPlayerInfo = new LegacyPlayerInfo();
    public LegacyPlayerInfo pendingLegacyPlayerInfo = new LegacyPlayerInfo();
    public QuantizerWu controllerInfo = new QuantizerWu((byte) 5);
    public final byte platformSessionCallbackAggregationTimeoutMs = 100;
    public long currentPositionMs = -9223372036854775807L;
    public long lastSetPlayWhenReadyCalledTimeMs = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ControllerCompatCallback implements IBinder.DeathRecipient {
        public final MediaControllerCompat$Callback$MediaControllerCallback callbackFwk = new android.media.session.MediaController.Callback(this) { // from class: androidx.media3.session.legacy.MediaControllerCompat$Callback$MediaControllerCallback
            public final WeakReference callback;

            {
                this.callback = new WeakReference(this);
            }

            @Override // android.media.session.MediaController.Callback
            public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback == null || playbackInfo == null) {
                    return;
                }
                int playbackType = playbackInfo.getPlaybackType();
                String volumeControlId = Build.VERSION.SDK_INT >= 30 ? playbackInfo.getVolumeControlId() : null;
                boolean z = true;
                if (playbackType == 1 && volumeControlId != null) {
                    z = false;
                }
                UtilsKt.checkArgument(z);
                MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo = new MediaControllerCompat$PlaybackInfo(playbackType, AudioAttributes.fromPlatformAudioAttributes(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume(), volumeControlId);
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(mediaControllerCompat$PlaybackInfo, legacyPlayerInfo.playbackStateCompat, legacyPlayerInfo.mediaMetadataCompat, legacyPlayerInfo.queue, legacyPlayerInfo.queueTitle, legacyPlayerInfo.repeatMode, legacyPlayerInfo.shuffleMode, legacyPlayerInfo.sessionExtras);
                controllerCompatCallback.startWaitingForPendingChanges();
            }

            @Override // android.media.session.MediaController.Callback
            public final void onExtrasChanged(Bundle bundle) {
                Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback != null) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    if (bundleConvertToNullIfInvalid == null) {
                        bundleConvertToNullIfInvalid = new Bundle();
                    }
                    Bundle bundle2 = bundleConvertToNullIfInvalid;
                    MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                    mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(legacyPlayerInfo.playbackInfoCompat, legacyPlayerInfo.playbackStateCompat, legacyPlayerInfo.mediaMetadataCompat, legacyPlayerInfo.queue, legacyPlayerInfo.queueTitle, legacyPlayerInfo.repeatMode, legacyPlayerInfo.shuffleMode, bundle2);
                    mediaControllerImplLegacy.hasPendingExtrasChange = true;
                    controllerCompatCallback.startWaitingForPendingChanges();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onMetadataChanged(MediaMetadata mediaMetadata) {
                MediaMetadataCompat mediaMetadataCompatCreateFromParcel;
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback != null) {
                    ArrayMap arrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
                    if (mediaMetadata != null) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaMetadata.writeToParcel(parcelObtain, 0);
                        parcelObtain.setDataPosition(0);
                        mediaMetadataCompatCreateFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        mediaMetadataCompatCreateFromParcel.metadataFwk = mediaMetadata;
                    } else {
                        mediaMetadataCompatCreateFromParcel = null;
                    }
                    MediaMetadataCompat mediaMetadataCompat = mediaMetadataCompatCreateFromParcel;
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                    mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(legacyPlayerInfo.playbackInfoCompat, legacyPlayerInfo.playbackStateCompat, mediaMetadataCompat, legacyPlayerInfo.queue, legacyPlayerInfo.queueTitle, legacyPlayerInfo.repeatMode, legacyPlayerInfo.shuffleMode, legacyPlayerInfo.sessionExtras);
                    controllerCompatCallback.startWaitingForPendingChanges();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onPlaybackStateChanged(PlaybackState playbackState) {
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback == null || controllerCompatCallback.iControllerCallback != null) {
                    return;
                }
                controllerCompatCallback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(playbackState));
            }

            @Override // android.media.session.MediaController.Callback
            public final void onQueueChanged(List list) {
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback != null) {
                    ArrayList arrayListFromQueueItemList = MediaSessionCompat$QueueItem.fromQueueItemList(list);
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                    mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(legacyPlayerInfo.playbackInfoCompat, legacyPlayerInfo.playbackStateCompat, legacyPlayerInfo.mediaMetadataCompat, MediaControllerImplLegacy.convertToNonNullQueueItemList(arrayListFromQueueItemList), legacyPlayerInfo.queueTitle, legacyPlayerInfo.repeatMode, legacyPlayerInfo.shuffleMode, legacyPlayerInfo.sessionExtras);
                    controllerCompatCallback.startWaitingForPendingChanges();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onQueueTitleChanged(CharSequence charSequence) {
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback != null) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                    mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(legacyPlayerInfo.playbackInfoCompat, legacyPlayerInfo.playbackStateCompat, legacyPlayerInfo.mediaMetadataCompat, legacyPlayerInfo.queue, charSequence, legacyPlayerInfo.repeatMode, legacyPlayerInfo.shuffleMode, legacyPlayerInfo.sessionExtras);
                    controllerCompatCallback.startWaitingForPendingChanges();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onSessionDestroyed() {
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback != null) {
                    MediaControllerImplLegacy.this.instance.release();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public final void onSessionEvent(String str, Bundle bundle) {
                Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.callback.get();
                if (controllerCompatCallback != null) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    if (str == null) {
                        return;
                    }
                    if (bundleConvertToNullIfInvalid == null) {
                        bundleConvertToNullIfInvalid = Bundle.EMPTY;
                    }
                    androidx.media3.session.MediaController mediaController = mediaControllerImplLegacy.instance;
                    mediaController.getClass();
                    UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                    mediaController.listener.onCustomCommand(new SessionCommand(str, bundleConvertToNullIfInvalid));
                }
            }
        };
        public DefaultDrmSession.RequestHandler handler;
        public MediaControllerCompat$Callback$CallbackStub iControllerCallback;
        public final Handler pendingChangesHandler;

        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.media3.session.legacy.MediaControllerCompat$Callback$MediaControllerCallback] */
        public ControllerCompatCallback(Looper looper) {
            this.pendingChangesHandler = new Handler(looper, new ListenerSet$$ExternalSyntheticLambda0((byte) 4, this));
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            postToHandler(8, null);
        }

        public final void onCaptioningEnabledChanged(boolean z) {
            MediaController mediaController = MediaControllerImplLegacy.this.instance;
            mediaController.getClass();
            UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
            MediaController.Listener listener = mediaController.listener;
            new Bundle().putBoolean("androidx.media3.session.ARGUMENT_CAPTIONING_ENABLED", z);
            listener.onCustomCommand(new SessionCommand("androidx.media3.session.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED", Bundle.EMPTY));
        }

        public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = new LegacyPlayerInfo(legacyPlayerInfo.playbackInfoCompat, MediaControllerImplLegacy.convertToSafePlaybackStateCompat(playbackStateCompat), legacyPlayerInfo.mediaMetadataCompat, legacyPlayerInfo.queue, legacyPlayerInfo.queueTitle, legacyPlayerInfo.repeatMode, legacyPlayerInfo.shuffleMode, legacyPlayerInfo.sessionExtras);
            startWaitingForPendingChanges();
        }

        public final void postToHandler(int i, Object obj) {
            DefaultDrmSession.RequestHandler requestHandler = this.handler;
            if (requestHandler != null) {
                requestHandler.obtainMessage(i, obj).sendToTarget();
            }
        }

        public final void setHandler(Handler handler) {
            if (handler != null) {
                DefaultDrmSession.RequestHandler requestHandler = new DefaultDrmSession.RequestHandler(this, handler.getLooper());
                this.handler = requestHandler;
                requestHandler.isReleased = true;
            } else {
                DefaultDrmSession.RequestHandler requestHandler2 = this.handler;
                if (requestHandler2 != null) {
                    requestHandler2.isReleased = false;
                    requestHandler2.removeCallbacksAndMessages(null);
                    this.handler = null;
                }
            }
        }

        public final void startWaitingForPendingChanges() {
            Handler handler = this.pendingChangesHandler;
            if (handler.hasMessages(1)) {
                return;
            }
            handler.sendEmptyMessageDelayed(1, MediaControllerImplLegacy.this.platformSessionCallbackAggregationTimeoutMs);
        }
    }

    public MediaControllerImplLegacy(Context context, MediaController mediaController, SessionToken sessionToken, Bundle bundle, Looper looper, BitmapLoader bitmapLoader) {
        this.listeners = new ListenerSet(looper, new MediaControllerImplLegacy$$ExternalSyntheticLambda2(this));
        this.context = context;
        this.instance = mediaController;
        this.controllerCompatCallback = new ControllerCompatCallback(looper);
        this.token = sessionToken;
        this.connectionHints = bundle;
        this.bitmapLoader = bitmapLoader;
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        RegularImmutableList regularImmutableList = RegularImmutableList.EMPTY;
    }

    public static boolean canInitializeLegacyPlaylist(QuantizerWu quantizerWu) {
        PlayerInfo playerInfo = (PlayerInfo) quantizerWu.weights;
        if (playerInfo.playbackState == 1 || playerInfo.timeline.isEmpty()) {
            return false;
        }
        return ((Player.Commands) quantizerWu.momentsG).contains(2) || ((PlayerInfo) quantizerWu.weights).playWhenReady;
    }

    public static List convertToNonNullQueueItemList(ArrayList arrayList) {
        if (arrayList == null) {
            return Collections.EMPTY_LIST;
        }
        Splitter splitter = MediaUtils.defaultBrowserRoot;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (obj != null) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static PlaybackStateCompat convertToSafePlaybackStateCompat(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return null;
        }
        if (playbackStateCompat.speed > CropImageView.DEFAULT_ASPECT_RATIO) {
            return playbackStateCompat;
        }
        Log.w("MCImplLegacy", "Adjusting playback speed to 1.0f because negative playback speed isn't supported.");
        ArrayList arrayList = new ArrayList();
        long j = playbackStateCompat.bufferedPosition;
        long j2 = playbackStateCompat.actions;
        int i = playbackStateCompat.errorCode;
        CharSequence charSequence = playbackStateCompat.errorMessage;
        List list = playbackStateCompat.customActions;
        if (list != null) {
            arrayList.addAll(list);
        }
        return new PlaybackStateCompat(playbackStateCompat.state, playbackStateCompat.position, j, 1.0f, j2, i, charSequence, playbackStateCompat.updateTime, arrayList, playbackStateCompat.activeItemId, playbackStateCompat.extras);
    }

    public static Player.PositionInfo createPositionInfo(int i, MediaItem mediaItem, long j, boolean z) {
        return new Player.PositionInfo(null, i, mediaItem, null, i, j, j, z ? 0 : -1, z ? 0 : -1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void addListener(Player.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void addMediaItems(int i, List list) {
        UtilsKt.checkArgument(i >= 0);
        if (list.isEmpty()) {
            return;
        }
        QueueTimeline queueTimeline = (QueueTimeline) ((PlayerInfo) this.controllerInfo.weights).timeline;
        if (queueTimeline.isEmpty()) {
            setMediaItems(list, 0, -9223372036854775807L);
            return;
        }
        int iMin = Math.min(i, getCurrentTimeline().getWindowCount());
        QueueTimeline queueTimelineCopyWithNewMediaItems = queueTimeline.copyWithNewMediaItems(iMin, list);
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        int size = list.size();
        if (currentMediaItemIndex >= iMin) {
            currentMediaItemIndex += size;
        }
        PlayerInfo playerInfoCopyWithTimelineAndMediaItemIndex = ((PlayerInfo) this.controllerInfo.weights).copyWithTimelineAndMediaItemIndex(queueTimelineCopyWithNewMediaItems, currentMediaItemIndex);
        QuantizerWu quantizerWu = this.controllerInfo;
        updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithTimelineAndMediaItemIndex, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        if (this.hasInitializedLegacyPlaylist) {
            addQueueItems(iMin, list);
        }
    }

    public final void addQueueItems(int i, List list) {
        ArrayList arrayList = new ArrayList();
        MediaControllerImplLegacy$$ExternalSyntheticLambda3 mediaControllerImplLegacy$$ExternalSyntheticLambda3 = new MediaControllerImplLegacy$$ExternalSyntheticLambda3(this, new AtomicInteger(0), list, arrayList, i, (byte) 0);
        for (int i2 = 0; i2 < list.size(); i2++) {
            byte[] bArr = ((MediaItem) list.get(i2)).mediaMetadata.artworkData;
            if (bArr == null) {
                arrayList.add(null);
                mediaControllerImplLegacy$$ExternalSyntheticLambda3.run();
            } else {
                ListenableFuture listenableFutureDecodeBitmap = this.bitmapLoader.decodeBitmap(bArr);
                arrayList.add(listenableFutureDecodeBitmap);
                Handler handler = this.instance.applicationHandler;
                Objects.requireNonNull(handler);
                listenableFutureDecodeBitmap.addListener(mediaControllerImplLegacy$$ExternalSyntheticLambda3, new DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(handler, (byte) 0));
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void connect() {
        SessionToken sessionToken = this.token;
        int type = sessionToken.impl.getType();
        MediaController mediaController = this.instance;
        if (type != 0) {
            mediaController.runOnApplicationLooper(new MediaControllerImplLegacy$$ExternalSyntheticLambda1(this, (byte) 1));
            return;
        }
        Object binder = sessionToken.impl.getBinder();
        binder.getClass();
        mediaController.runOnApplicationLooper(new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, binder, (byte) 4));
        mediaController.applicationHandler.postDelayed(new MediaControllerImplLegacy$$ExternalSyntheticLambda1(this, (byte) 0), 500L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void decreaseDeviceVolume(int i) {
        int deviceVolume = getDeviceVolume() - 1;
        if (deviceVolume >= getDeviceInfo().minVolume) {
            PlayerInfo playerInfoCopyWithDeviceVolume = ((PlayerInfo) this.controllerInfo.weights).copyWithDeviceVolume(deviceVolume, isDeviceMuted());
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithDeviceVolume, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.adjustVolume(-1, i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final AudioAttributes getAudioAttributes() {
        return ((PlayerInfo) this.controllerInfo.weights).audioAttributes;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Player.Commands getAvailableCommands() {
        return (Player.Commands) this.controllerInfo.momentsG;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final SessionCommands getAvailableSessionCommands() {
        return (SessionCommands) this.controllerInfo.momentsR;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getBufferedPercentage() {
        return ((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.bufferedPercentage;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getBufferedPosition() {
        return ((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.bufferedPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Bundle getConnectionHints() {
        return this.connectionHints;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getContentBufferedPosition() {
        return getBufferedPosition();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getContentDuration() {
        return getDuration();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getContentPosition() {
        return getCurrentPosition();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentAdGroupIndex() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentAdIndexInAdGroup() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final CueGroup getCurrentCues() {
        Log.w("MCImplLegacy", "Session doesn't support getting Cue");
        return CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getCurrentLiveOffset() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentMediaItemIndex() {
        return ((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.positionInfo.mediaItemIndex;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentPeriodIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getCurrentPosition() {
        long updatedCurrentPositionMs = MediaUtils.getUpdatedCurrentPositionMs((PlayerInfo) this.controllerInfo.weights, this.currentPositionMs, this.lastSetPlayWhenReadyCalledTimeMs, this.instance.timeDiffMs);
        this.currentPositionMs = updatedCurrentPositionMs;
        return updatedCurrentPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Timeline getCurrentTimeline() {
        return ((PlayerInfo) this.controllerInfo.weights).timeline;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Tracks getCurrentTracks() {
        return Tracks.EMPTY;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final DeviceInfo getDeviceInfo() {
        return ((PlayerInfo) this.controllerInfo.weights).deviceInfo;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getDeviceVolume() {
        PlayerInfo playerInfo = (PlayerInfo) this.controllerInfo.weights;
        if (playerInfo.deviceInfo.playbackType == 1) {
            return playerInfo.deviceVolume;
        }
        CallbackWrapper callbackWrapper = this.controllerCompat;
        if (callbackWrapper == null) {
            return 0;
        }
        MediaControllerCompat$PlaybackInfo playbackInfo = ((MediaControllerCompat$MediaControllerImplApi23) callbackWrapper.mCallback).getPlaybackInfo();
        ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
        if (playbackInfo == null) {
            return 0;
        }
        return playbackInfo.currentVolume;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getDuration() {
        return ((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.durationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getMaxSeekToPreviousPosition() {
        return ((PlayerInfo) this.controllerInfo.weights).maxSeekToPreviousPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ImmutableList getMediaButtonPreferences() {
        return (ImmutableList) this.controllerInfo.momentsB;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final androidx.media3.common.MediaMetadata getMediaMetadata() {
        MediaItem currentMediaItem = ((PlayerInfo) this.controllerInfo.weights).getCurrentMediaItem();
        return currentMediaItem == null ? androidx.media3.common.MediaMetadata.EMPTY : currentMediaItem.mediaMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean getPlayWhenReady() {
        return ((PlayerInfo) this.controllerInfo.weights).playWhenReady;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackParameters getPlaybackParameters() {
        return ((PlayerInfo) this.controllerInfo.weights).playbackParameters;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getPlaybackState() {
        return ((PlayerInfo) this.controllerInfo.weights).playbackState;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getPlaybackSuppressionReason() {
        return 0;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackException getPlayerError() {
        return ((PlayerInfo) this.controllerInfo.weights).playerError;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final androidx.media3.common.MediaMetadata getPlaylistMetadata() {
        return ((PlayerInfo) this.controllerInfo.weights).playlistMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getRepeatMode() {
        return ((PlayerInfo) this.controllerInfo.weights).repeatMode;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getSeekBackIncrement() {
        return ((PlayerInfo) this.controllerInfo.weights).seekBackIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getSeekForwardIncrement() {
        return ((PlayerInfo) this.controllerInfo.weights).seekForwardIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean getShuffleModeEnabled() {
        return ((PlayerInfo) this.controllerInfo.weights).shuffleModeEnabled;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getTotalBufferedDuration() {
        return ((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.totalBufferedDurationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final TrackSelectionParameters getTrackSelectionParameters() {
        return TrackSelectionParameters.DEFAULT;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final VideoSize getVideoSize() {
        Log.w("MCImplLegacy", "Session doesn't support getting VideoSize");
        return VideoSize.UNKNOWN;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final float getVolume() {
        return 1.0f;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0251 A[PHI: r4 r9
      0x0251: PHI (r4v20 androidx.media3.session.QueueTimeline) = 
      (r4v14 androidx.media3.session.QueueTimeline)
      (r4v17 androidx.media3.session.QueueTimeline)
      (r4v25 androidx.media3.session.QueueTimeline)
     binds: [B:137:0x0269, B:152:0x02a2, B:130:0x0239] A[DONT_GENERATE, DONT_INLINE]
      0x0251: PHI (r9v10 int) = (r9v7 int), (r9v7 int), (r9v14 int) binds: [B:137:0x0269, B:152:0x02a2, B:130:0x0239] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:133:0x025b A[PHI: r4
      0x025b: PHI (r4v18 androidx.media3.session.QueueTimeline) = (r4v13 androidx.media3.session.QueueTimeline), (r4v21 androidx.media3.session.QueueTimeline) binds: [B:135:0x0261, B:132:0x0255] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:136:0x0263  */
    /* JADX WARN: Code duplicated, block: B:138:0x026b  */
    /* JADX WARN: Code duplicated, block: B:140:0x0271  */
    /* JADX WARN: Code duplicated, block: B:141:0x0273  */
    /* JADX WARN: Code duplicated, block: B:149:0x0297  */
    /* JADX WARN: Code duplicated, block: B:152:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:153:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:172:0x0328  */
    /* JADX WARN: Code duplicated, block: B:177:0x0338 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x033a  */
    /* JADX WARN: Code duplicated, block: B:184:0x034e  */
    /* JADX WARN: Code duplicated, block: B:188:0x035e  */
    /* JADX WARN: Code duplicated, block: B:191:0x036b  */
    /* JADX WARN: Code duplicated, block: B:193:0x0375  */
    /* JADX WARN: Code duplicated, block: B:198:0x0389  */
    /* JADX WARN: Code duplicated, block: B:202:0x0396  */
    /* JADX WARN: Code duplicated, block: B:205:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:208:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:211:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:214:0x03da  */
    /* JADX WARN: Code duplicated, block: B:217:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:220:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:223:0x0403  */
    /* JADX WARN: Code duplicated, block: B:225:0x040c  */
    /* JADX WARN: Code duplicated, block: B:227:0x040f  */
    /* JADX WARN: Code duplicated, block: B:230:0x0429  */
    /* JADX WARN: Code duplicated, block: B:233:0x0436  */
    /* JADX WARN: Code duplicated, block: B:235:0x043d  */
    /* JADX WARN: Code duplicated, block: B:237:0x0446  */
    /* JADX WARN: Code duplicated, block: B:240:0x0454  */
    /* JADX WARN: Code duplicated, block: B:243:0x0468  */
    /* JADX WARN: Code duplicated, block: B:245:0x0471 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:246:0x0473  */
    /* JADX WARN: Code duplicated, block: B:247:0x0476  */
    /* JADX WARN: Code duplicated, block: B:250:0x0492 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:253:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:256:0x04af A[LOOP:4: B:254:0x04ab->B:256:0x04af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:258:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:261:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:265:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:268:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:270:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:274:0x050c  */
    /* JADX WARN: Code duplicated, block: B:275:0x0519  */
    /* JADX WARN: Code duplicated, block: B:278:0x052e  */
    /* JADX WARN: Code duplicated, block: B:280:0x053c  */
    /* JADX WARN: Code duplicated, block: B:281:0x0548  */
    /* JADX WARN: Code duplicated, block: B:284:0x055a  */
    /* JADX WARN: Code duplicated, block: B:285:0x055d  */
    /* JADX WARN: Code duplicated, block: B:288:0x056d  */
    /* JADX WARN: Code duplicated, block: B:290:0x0576  */
    /* JADX WARN: Code duplicated, block: B:291:0x057d  */
    /* JADX WARN: Code duplicated, block: B:293:0x0580  */
    /* JADX WARN: Code duplicated, block: B:295:0x0590  */
    /* JADX WARN: Code duplicated, block: B:297:0x0598  */
    /* JADX WARN: Code duplicated, block: B:301:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:307:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:309:0x05de  */
    /* JADX WARN: Code duplicated, block: B:311:0x05eb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:323:0x0631  */
    /* JADX WARN: Code duplicated, block: B:324:0x0633  */
    /* JADX WARN: Code duplicated, block: B:328:0x0640  */
    /* JADX WARN: Code duplicated, block: B:329:0x0643  */
    /* JADX WARN: Code duplicated, block: B:331:0x064c  */
    /* JADX WARN: Code duplicated, block: B:332:0x0653  */
    /* JADX WARN: Code duplicated, block: B:334:0x065b  */
    /* JADX WARN: Code duplicated, block: B:335:0x065e  */
    /* JADX WARN: Code duplicated, block: B:338:0x0664  */
    /* JADX WARN: Code duplicated, block: B:340:0x0668  */
    /* JADX WARN: Code duplicated, block: B:341:0x066a A[PHI: r31
      0x066a: PHI (r31v13 androidx.media3.common.PlaybackException) = (r31v5 androidx.media3.common.PlaybackException), (r31v14 androidx.media3.common.PlaybackException) binds: [B:360:0x06af, B:340:0x0668] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:344:0x067b  */
    /* JADX WARN: Code duplicated, block: B:345:0x067d A[Catch: ConversionException -> 0x06b5, TryCatch #1 {ConversionException -> 0x06b5, blocks: (B:342:0x066c, B:348:0x0686, B:349:0x0689, B:345:0x067d), top: B:444:0x066c }] */
    /* JADX WARN: Code duplicated, block: B:349:0x0689 A[Catch: ConversionException -> 0x06b5, TRY_LEAVE, TryCatch #1 {ConversionException -> 0x06b5, blocks: (B:342:0x066c, B:348:0x0686, B:349:0x0689, B:345:0x067d), top: B:444:0x066c }] */
    /* JADX WARN: Code duplicated, block: B:353:0x069f  */
    /* JADX WARN: Code duplicated, block: B:354:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:355:0x06a5 A[PHI: r31
      0x06a5: PHI (r31v8 androidx.media3.common.PlaybackException) = (r31v7 androidx.media3.common.PlaybackException), (r31v9 androidx.media3.common.PlaybackException) binds: [B:357:0x06a9, B:354:0x06a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:356:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:358:0x06ab A[PHI: r31
      0x06ab: PHI (r31v6 androidx.media3.common.PlaybackException) = (r31v5 androidx.media3.common.PlaybackException), (r31v7 androidx.media3.common.PlaybackException) binds: [B:360:0x06af, B:357:0x06a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:359:0x06ad  */
    /* JADX WARN: Code duplicated, block: B:366:0x06e2  */
    /* JADX WARN: Code duplicated, block: B:367:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:371:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:373:0x06f3  */
    /* JADX WARN: Code duplicated, block: B:375:0x06fa  */
    /* JADX WARN: Code duplicated, block: B:376:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:379:0x0708 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:382:0x070d  */
    /* JADX WARN: Code duplicated, block: B:385:0x071a  */
    /* JADX WARN: Code duplicated, block: B:386:0x071d  */
    /* JADX WARN: Code duplicated, block: B:388:0x0723  */
    /* JADX WARN: Code duplicated, block: B:389:0x0726  */
    /* JADX WARN: Code duplicated, block: B:394:0x0740  */
    /* JADX WARN: Code duplicated, block: B:395:0x0744  */
    /* JADX WARN: Code duplicated, block: B:398:0x07d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:401:0x07de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:402:0x07e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:404:0x07e5  */
    /* JADX WARN: Code duplicated, block: B:406:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:409:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:412:0x0806  */
    /* JADX WARN: Code duplicated, block: B:415:0x0816 A[LOOP:3: B:410:0x07fe->B:415:0x0816, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:418:0x081e  */
    /* JADX WARN: Code duplicated, block: B:419:0x082a  */
    /* JADX WARN: Code duplicated, block: B:421:0x0834  */
    /* JADX WARN: Code duplicated, block: B:423:0x0844  */
    /* JADX WARN: Code duplicated, block: B:426:0x084b  */
    /* JADX WARN: Code duplicated, block: B:428:0x0856  */
    /* JADX WARN: Code duplicated, block: B:430:0x085e  */
    /* JADX WARN: Code duplicated, block: B:432:0x0864  */
    /* JADX WARN: Code duplicated, block: B:435:0x0887  */
    /* JADX WARN: Code duplicated, block: B:438:0x0897  */
    /* JADX WARN: Code duplicated, block: B:444:0x066c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:457:0x081b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:458:0x0814 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:461:0x04dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:462:? A[LOOP:5: B:259:0x04ca->B:462:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:465:0x04fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:468:0x05af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:472:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0100  */
    public final void handleNewLegacyParameters(boolean z, LegacyPlayerInfo legacyPlayerInfo) {
        boolean z2;
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo;
        boolean z3;
        String str;
        QueueTimeline queueTimeline;
        long j;
        long j2;
        int windowCount;
        androidx.media3.common.MediaMetadata mediaMetadataConvertToMediaMetadata;
        MediaItem mediaItem;
        MediaItem mediaItemConvertToMediaItem;
        ImmutableList immutableList;
        int size;
        QueueTimeline.QueuedMediaItem queuedMediaItem;
        boolean z4;
        androidx.media3.common.MediaMetadata mediaMetadata;
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo2;
        int i;
        long j3;
        long j4;
        QueueTimeline queueTimeline2;
        boolean z5;
        long j5;
        Bundle bundle;
        Bundle bundle2;
        Player.Commands commands;
        CharSequence charSequence;
        CharSequence charSequence2;
        androidx.media3.common.MediaMetadata mediaMetadata2;
        int iConvertToRepeatMode;
        boolean zConvertToShuffleModeEnabled;
        HashSet<SessionCommand> hashSet;
        RegularImmutableList regularImmutableList;
        int i2;
        SessionCommands sessionCommands;
        Object[] objArrCopyOf;
        Iterator it;
        int i3;
        int i4;
        boolean z6;
        SessionCommands sessionCommands2;
        ImmutableList mediaButtonPreferencesFromCustomLayout;
        Bundle bundle3;
        int i5;
        CommandButton.Builder builder;
        Bundle bundle4;
        String string;
        int iExpandedCapacity;
        Uri uri;
        String scheme;
        SessionCommands sessionCommands3;
        Bundle bundle5;
        PlaybackException playbackExceptionConvertToPlaybackException;
        int i6;
        Player.Commands commands2;
        SessionError sessionError;
        boolean z7;
        PlaybackParameters playbackParameters;
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo3;
        AudioAttributes audioAttributes;
        boolean z8;
        int i7;
        int i8;
        long jConvertToDurationMs;
        boolean z9;
        boolean z10;
        int i9;
        boolean z11;
        DeviceInfo deviceInfoBuild;
        int i10;
        boolean z12;
        QueueTimeline queueTimeline3;
        MediaItem mediaItem2;
        PlayerInfo playerInfo;
        LegacyPlayerInfo legacyPlayerInfo2;
        QuantizerWu quantizerWu;
        long j6;
        boolean zIsEmpty;
        MediaItem currentMediaItem;
        QueueTimeline.QueuedMediaItem queuedMediaItem2;
        int i11;
        ImmutableList immutableList2;
        boolean z13;
        boolean z14;
        Integer num;
        Integer num2;
        long jConvertToCurrentPositionMs;
        long jConvertToCurrentPositionMs2;
        Integer num3;
        int i12;
        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem;
        Bitmap bitmap;
        MediaMetadataCompat mediaMetadataCompat;
        Bitmap mostRelevantArtworkBitmap;
        if (this.released || !this.connected) {
            return;
        }
        LegacyPlayerInfo legacyPlayerInfo3 = this.legacyPlayerInfo;
        QuantizerWu quantizerWu2 = this.controllerInfo;
        String packageName = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.getPackageName();
        long flags = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.getFlags();
        boolean z15 = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).sessionToken.getExtraBinder() != null;
        int ratingType = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.getRatingType();
        MediaController mediaController = this.instance;
        long j7 = mediaController.timeDiffMs;
        boolean z16 = this.hasPendingExtrasChange;
        MediaMetadataCompat mediaMetadataCompat2 = legacyPlayerInfo3.mediaMetadataCompat;
        PlaybackStateCompat playbackStateCompat = legacyPlayerInfo3.playbackStateCompat;
        List list = legacyPlayerInfo3.queue;
        if (mediaMetadataCompat2 == null || (mediaMetadataCompat = legacyPlayerInfo.mediaMetadataCompat) == null || mediaMetadataCompat2.compressedArtworkData == null || (mostRelevantArtworkBitmap = mediaMetadataCompat.getMostRelevantArtworkBitmap()) == null) {
            z2 = z15;
        } else {
            z2 = z15;
            Bitmap mostRelevantArtworkBitmap2 = mediaMetadataCompat2.getMostRelevantArtworkBitmap();
            if (mostRelevantArtworkBitmap2 != null && mostRelevantArtworkBitmap.sameAs(mostRelevantArtworkBitmap2)) {
                mediaMetadataCompat.compressedArtworkData = mediaMetadataCompat2.compressedArtworkData;
            }
        }
        List list2 = legacyPlayerInfo.queue;
        Bundle bundle6 = legacyPlayerInfo.sessionExtras;
        PlaybackStateCompat playbackStateCompat2 = legacyPlayerInfo.playbackStateCompat;
        MediaMetadataCompat mediaMetadataCompat3 = legacyPlayerInfo.mediaMetadataCompat;
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo4 = legacyPlayerInfo.playbackInfoCompat;
        if (list != list2) {
            HashMap map = new HashMap();
            int i13 = 0;
            while (i13 < list.size()) {
                MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem2 = (MediaSessionCompat$QueueItem) list.get(i13);
                MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo5 = mediaControllerCompat$PlaybackInfo4;
                if (mediaSessionCompat$QueueItem2.description.icon != null) {
                    map.put(Long.valueOf(mediaSessionCompat$QueueItem2.id), mediaSessionCompat$QueueItem2);
                }
                i13++;
                mediaControllerCompat$PlaybackInfo4 = mediaControllerCompat$PlaybackInfo5;
            }
            mediaControllerCompat$PlaybackInfo = mediaControllerCompat$PlaybackInfo4;
            int i14 = 0;
            while (i14 < list2.size()) {
                MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem3 = (MediaSessionCompat$QueueItem) list2.get(i14);
                if (mediaSessionCompat$QueueItem3.description.icon == null || (mediaSessionCompat$QueueItem = (MediaSessionCompat$QueueItem) map.get(Long.valueOf(mediaSessionCompat$QueueItem3.id))) == null) {
                    i12 = i14;
                } else {
                    MediaDescriptionCompat mediaDescriptionCompat = mediaSessionCompat$QueueItem3.description;
                    MediaDescriptionCompat mediaDescriptionCompat2 = mediaSessionCompat$QueueItem.description;
                    mediaDescriptionCompat.getClass();
                    if (mediaDescriptionCompat2.compressedIcon == null || (bitmap = mediaDescriptionCompat.icon) == null) {
                        i12 = i14;
                    } else {
                        i12 = i14;
                        Bitmap bitmap2 = mediaDescriptionCompat2.icon;
                        if (bitmap2 != null && bitmap.sameAs(bitmap2)) {
                            mediaDescriptionCompat.compressedIcon = mediaDescriptionCompat2.compressedIcon;
                        }
                    }
                }
                i14 = i12 + 1;
            }
        } else {
            mediaControllerCompat$PlaybackInfo = mediaControllerCompat$PlaybackInfo4;
        }
        boolean z17 = list != list2;
        String str2 = "initialCapacity";
        if (z17) {
            QueueTimeline queueTimeline4 = QueueTimeline.DEFAULT;
            Maps.checkNonnegative(4, "initialCapacity");
            Object[] objArrCopyOf2 = new Object[4];
            int i15 = 0;
            int i16 = 0;
            while (i16 < list2.size()) {
                MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem4 = (MediaSessionCompat$QueueItem) list2.get(i16);
                ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
                boolean z18 = z17;
                String str3 = str2;
                QueueTimeline.QueuedMediaItem queuedMediaItem3 = new QueueTimeline.QueuedMediaItem(LegacyConversions.convertToMediaItem(mediaSessionCompat$QueueItem4.description), mediaSessionCompat$QueueItem4.id, -9223372036854775807L);
                int i17 = i15 + 1;
                int iExpandedCapacity2 = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf2.length, i17);
                if (iExpandedCapacity2 > objArrCopyOf2.length) {
                    objArrCopyOf2 = Arrays.copyOf(objArrCopyOf2, iExpandedCapacity2);
                }
                objArrCopyOf2[i15] = queuedMediaItem3;
                i16++;
                i15 = i17;
                z17 = z18;
                str2 = str3;
            }
            z3 = z17;
            str = str2;
            queueTimeline = new QueueTimeline(ImmutableList.asImmutableList(i15, objArrCopyOf2), null);
        } else {
            z3 = z17;
            str = "initialCapacity";
            QueueTimeline queueTimeline5 = (QueueTimeline) ((PlayerInfo) quantizerWu2.weights).timeline;
            queueTimeline = new QueueTimeline(queueTimeline5.queuedMediaItems, queueTimeline5.fakeQueuedMediaItem);
        }
        boolean z19 = legacyPlayerInfo3.mediaMetadataCompat != mediaMetadataCompat3 || z;
        long j8 = playbackStateCompat == null ? -1L : playbackStateCompat.activeItemId;
        if (playbackStateCompat2 == null) {
            j2 = -1;
            j = -1;
        } else {
            j = -1;
            j2 = playbackStateCompat2.activeItemId;
        }
        boolean z20 = j8 != j2 || z;
        long jConvertToDurationMs2 = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
        if (z19 || z20 || z3) {
            boolean z21 = z19;
            if (list2 == null || j2 == j) {
                windowCount = -1;
                break;
            }
            long j9 = j2;
            windowCount = 0;
            while (true) {
                if (windowCount >= list2.size()) {
                    windowCount = -1;
                    break;
                } else if (((MediaSessionCompat$QueueItem) list2.get(windowCount)).id == j9) {
                    break;
                } else {
                    windowCount++;
                }
            }
            boolean z22 = mediaMetadataCompat3 != null;
            if (z22 && z21) {
                mediaMetadataConvertToMediaMetadata = LegacyConversions.convertToMediaMetadata(mediaMetadataCompat3, ratingType);
            } else if (z22 || !z20) {
                mediaMetadataConvertToMediaMetadata = ((PlayerInfo) quantizerWu2.weights).mediaMetadata;
            } else {
                mediaMetadataConvertToMediaMetadata = windowCount == -1 ? androidx.media3.common.MediaMetadata.EMPTY : LegacyConversions.convertToMediaMetadata(((MediaSessionCompat$QueueItem) list2.get(windowCount)).description, ratingType);
            }
            ImmutableList immutableList3 = queueTimeline.queuedMediaItems;
            int i18 = -1;
            if (windowCount != -1) {
                if (windowCount != i18) {
                    queueTimeline = new QueueTimeline(immutableList3, null);
                    if (!z22) {
                        if (windowCount >= queueTimeline.getWindowCount()) {
                            mediaItem = null;
                        } else {
                            mediaItem = queueTimeline.getQueuedMediaItem(windowCount).mediaItem;
                        }
                        mediaItem.getClass();
                        mediaItemConvertToMediaItem = LegacyConversions.convertToMediaItem(mediaItem.mediaId, mediaMetadataCompat3, ratingType);
                        immutableList = queueTimeline.queuedMediaItems;
                        size = immutableList.size();
                        queuedMediaItem = queueTimeline.fakeQueuedMediaItem;
                        if (windowCount >= size || (windowCount == immutableList.size() && queuedMediaItem != null)) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        UtilsKt.checkArgument(z4);
                        if (windowCount == immutableList.size()) {
                            queueTimeline = new QueueTimeline(immutableList, new QueueTimeline.QueuedMediaItem(mediaItemConvertToMediaItem, -1L, jConvertToDurationMs2));
                        } else {
                            long j10 = ((QueueTimeline.QueuedMediaItem) immutableList.get(windowCount)).queueId;
                            ImmutableList.Builder builder2 = new ImmutableList.Builder(4);
                            builder2.addAll(immutableList.subList(0, windowCount));
                            builder2.add((Object) new QueueTimeline.QueuedMediaItem(mediaItemConvertToMediaItem, j10, jConvertToDurationMs2));
                            builder2.addAll(immutableList.subList(windowCount + 1, immutableList.size()));
                            queueTimeline = new QueueTimeline(builder2.build(), queuedMediaItem);
                        }
                    }
                } else {
                    windowCount = 0;
                }
            } else if (!z21) {
                i18 = -1;
                if (windowCount != i18) {
                    queueTimeline = new QueueTimeline(immutableList3, null);
                    if (!z22) {
                        if (windowCount >= queueTimeline.getWindowCount()) {
                            mediaItem = null;
                        } else {
                            mediaItem = queueTimeline.getQueuedMediaItem(windowCount).mediaItem;
                        }
                        mediaItem.getClass();
                        mediaItemConvertToMediaItem = LegacyConversions.convertToMediaItem(mediaItem.mediaId, mediaMetadataCompat3, ratingType);
                        immutableList = queueTimeline.queuedMediaItems;
                        size = immutableList.size();
                        queuedMediaItem = queueTimeline.fakeQueuedMediaItem;
                        if (windowCount >= size) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        UtilsKt.checkArgument(z4);
                        if (windowCount == immutableList.size()) {
                            queueTimeline = new QueueTimeline(immutableList, new QueueTimeline.QueuedMediaItem(mediaItemConvertToMediaItem, -1L, jConvertToDurationMs2));
                        } else {
                            long j11 = ((QueueTimeline.QueuedMediaItem) immutableList.get(windowCount)).queueId;
                            ImmutableList.Builder builder3 = new ImmutableList.Builder(4);
                            builder3.addAll(immutableList.subList(0, windowCount));
                            builder3.add((Object) new QueueTimeline.QueuedMediaItem(mediaItemConvertToMediaItem, j11, jConvertToDurationMs2));
                            builder3.addAll(immutableList.subList(windowCount + 1, immutableList.size()));
                            queueTimeline = new QueueTimeline(builder3.build(), queuedMediaItem);
                        }
                    }
                } else {
                    windowCount = 0;
                }
            } else if (z22) {
                Log.w("MCImplLegacy", "Adding a fake MediaItem at the end of the list because there's no QueueItem with the active queue id and current Timeline should have currently playing MediaItem.");
                CharSequence charSequence3 = mediaMetadataCompat3.bundle.getCharSequence("android.media.metadata.MEDIA_ID");
                queueTimeline = new QueueTimeline(immutableList3, new QueueTimeline.QueuedMediaItem(LegacyConversions.convertToMediaItem(charSequence3 != null ? charSequence3.toString() : null, mediaMetadataCompat3, ratingType), -1L, jConvertToDurationMs2));
                windowCount = queueTimeline.getWindowCount() - 1;
            } else {
                queueTimeline = new QueueTimeline(immutableList3, null);
                windowCount = 0;
            }
            mediaMetadata = mediaMetadataConvertToMediaMetadata;
        } else {
            PlayerInfo playerInfo2 = (PlayerInfo) quantizerWu2.weights;
            windowCount = playerInfo2.sessionPositionInfo.positionInfo.mediaItemIndex;
            mediaMetadata = playerInfo2.mediaMetadata;
        }
        if (mediaControllerCompat$PlaybackInfo != null) {
            mediaControllerCompat$PlaybackInfo2 = mediaControllerCompat$PlaybackInfo;
            i = mediaControllerCompat$PlaybackInfo2.volumeControl;
        } else {
            mediaControllerCompat$PlaybackInfo2 = mediaControllerCompat$PlaybackInfo;
            i = 0;
        }
        FlagSet.Builder builder4 = new FlagSet.Builder((byte) 0);
        if (playbackStateCompat2 == null) {
            j4 = 0;
            j3 = 0;
        } else {
            j3 = 0;
            j4 = playbackStateCompat2.actions;
        }
        if (playbackStateCompat2 != null) {
            queueTimeline2 = queueTimeline;
            switch (playbackStateCompat2.state) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                    z5 = true;
                    break;
            }
            if (LegacyConversions.hasAction(j4, 4L) || z5) {
                j5 = 4;
                if ((LegacyConversions.hasAction(j4, 2L) && z5) || LegacyConversions.hasAction(j4, 512L)) {
                }
                if (LegacyConversions.hasAction(j4, 1024L) || LegacyConversions.hasAction(j4, 2048L) || LegacyConversions.hasAction(j4, 8192L)) {
                    builder4.add(31);
                }
                if (!LegacyConversions.hasAction(j4, 16384L)) {
                    bundle = bundle6;
                    if (!LegacyConversions.hasAction(j4, 32768L) || LegacyConversions.hasAction(j4, 65536L) || LegacyConversions.hasAction(j4, 131072L)) {
                    }
                    if (LegacyConversions.hasAction(j4, 8L)) {
                        builder4.add(11);
                    }
                    if (LegacyConversions.hasAction(j4, 64L)) {
                        builder4.add(12);
                    }
                    bundle2 = bundle;
                    if (LegacyConversions.hasAction(j4, 256L)) {
                        builder4.addAll(5, 4);
                    }
                    if (LegacyConversions.hasAction(j4, 32L)) {
                        builder4.addAll(9, 8);
                    }
                    if (LegacyConversions.hasAction(j4, 16L)) {
                        builder4.addAll(7, 6);
                    }
                    if (LegacyConversions.hasAction(j4, 4194304L)) {
                        builder4.add(13);
                    }
                    if (LegacyConversions.hasAction(j4, 1L)) {
                        builder4.add(3);
                    }
                    if (i == 1) {
                        builder4.addAll(26, 34);
                    } else if (i == 2) {
                        builder4.addAll(26, 34, 25, 33);
                    }
                    builder4.addAll(23, 17, 18, 16, 21, 32);
                    if ((flags & j5) != j3) {
                        builder4.add(20);
                    }
                    if (LegacyConversions.hasAction(j4, 4096L)) {
                        builder4.add(10);
                    }
                    if (z2) {
                        if (LegacyConversions.hasAction(j4, 262144L)) {
                            builder4.add(15);
                        }
                        if (LegacyConversions.hasAction(j4, 2097152L)) {
                            builder4.add(14);
                        }
                    }
                    commands = new Player.Commands(builder4.build());
                    charSequence = legacyPlayerInfo3.queueTitle;
                    charSequence2 = legacyPlayerInfo.queueTitle;
                    if (charSequence == charSequence2) {
                        mediaMetadata2 = ((PlayerInfo) quantizerWu2.weights).playlistMetadata;
                    } else if (charSequence2 == null) {
                        mediaMetadata2 = androidx.media3.common.MediaMetadata.EMPTY;
                    } else {
                        androidx.media3.common.MediaMetadata.Builder builder5 = new androidx.media3.common.MediaMetadata.Builder();
                        builder5.title = charSequence2;
                        mediaMetadata2 = new androidx.media3.common.MediaMetadata(builder5);
                    }
                    androidx.media3.common.MediaMetadata mediaMetadata3 = mediaMetadata2;
                    iConvertToRepeatMode = LegacyConversions.convertToRepeatMode(legacyPlayerInfo.repeatMode);
                    zConvertToShuffleModeEnabled = LegacyConversions.convertToShuffleModeEnabled(legacyPlayerInfo.shuffleMode);
                    if (playbackStateCompat == playbackStateCompat2 || z16) {
                        hashSet = new HashSet();
                        regularImmutableList = SessionCommand.SESSION_COMMANDS;
                        for (i2 = 0; i2 < regularImmutableList.size; i2++) {
                            hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                        }
                        if (!z2) {
                            for (SessionCommand sessionCommand : hashSet) {
                                if (sessionCommand.commandCode == 40010) {
                                    hashSet.remove(sessionCommand);
                                }
                            }
                        }
                        if (playbackStateCompat2 != null) {
                            for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat2.customActions) {
                                String str4 = customAction.action;
                                bundle5 = customAction.extras;
                                if (bundle5 == null) {
                                    bundle5 = Bundle.EMPTY;
                                }
                                hashSet.add(new SessionCommand(str4, bundle5));
                            }
                        }
                        sessionCommands = new SessionCommands(hashSet);
                        if (playbackStateCompat2 == null) {
                            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                            i4 = iConvertToRepeatMode;
                            z6 = zConvertToShuffleModeEnabled;
                            sessionCommands2 = sessionCommands;
                            mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                        } else {
                            List list3 = playbackStateCompat2.customActions;
                            Maps.checkNonnegative(4, str);
                            objArrCopyOf = new Object[4];
                            it = list3.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                PlaybackStateCompat.CustomAction customAction2 = (PlaybackStateCompat.CustomAction) it.next();
                                String str5 = customAction2.action;
                                int i19 = iConvertToRepeatMode;
                                bundle3 = customAction2.extras;
                                if (bundle3 != null) {
                                    i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                                } else {
                                    i5 = 0;
                                }
                                SessionCommands sessionCommands4 = sessionCommands;
                                builder = new CommandButton.Builder(i5, customAction2.icon);
                                if (bundle3 == null) {
                                    bundle4 = Bundle.EMPTY;
                                } else {
                                    bundle4 = bundle3;
                                }
                                builder.setSessionCommand(new SessionCommand(str5, bundle4));
                                builder.displayName = customAction2.name;
                                builder.enabled = true;
                                if (bundle3 != null) {
                                    builder.extras = new Bundle(bundle3);
                                }
                                if (bundle3 != null) {
                                    string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                                } else {
                                    string = null;
                                }
                                if (string != null) {
                                    uri = Uri.parse(string);
                                    scheme = uri.getScheme();
                                    if (Objects.equals(scheme, "content") || Objects.equals(scheme, "android.resource")) {
                                        builder.setIconUri(uri);
                                    }
                                }
                                CommandButton commandButtonBuild = builder.build();
                                int i20 = i3 + 1;
                                iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i20);
                                if (iExpandedCapacity > objArrCopyOf.length) {
                                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                                }
                                objArrCopyOf[i3] = commandButtonBuild;
                                i3 = i20;
                                iConvertToRepeatMode = i19;
                                zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                                it = it;
                                sessionCommands = sessionCommands4;
                            }
                            i4 = iConvertToRepeatMode;
                            z6 = zConvertToShuffleModeEnabled;
                            sessionCommands2 = sessionCommands;
                            mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                        }
                        sessionCommands3 = sessionCommands2;
                    } else {
                        sessionCommands3 = (SessionCommands) quantizerWu2.momentsR;
                        mediaButtonPreferencesFromCustomLayout = (ImmutableList) quantizerWu2.momentsB;
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                    }
                    Context context = this.context;
                    playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat2, context);
                    if (playbackStateCompat2 == null) {
                        i6 = playbackStateCompat2.state;
                        int i21 = playbackStateCompat2.errorCode;
                        CharSequence charSequence4 = playbackStateCompat2.errorMessage;
                        Bundle bundle7 = playbackStateCompat2.extras;
                        commands2 = commands;
                        if (i6 == 7 && i21 != 0) {
                            int iConvertToSessionErrorCode = LegacyConversions.convertToSessionErrorCode(i21);
                            String string2 = charSequence4 != null ? charSequence4.toString() : LegacyConversions.getSessionErrorMessage(context, iConvertToSessionErrorCode);
                            if (bundle7 == null) {
                                bundle7 = Bundle.EMPTY;
                            }
                            sessionError = new SessionError(string2, iConvertToSessionErrorCode, bundle7);
                        }
                        long jConvertToCurrentPositionMs3 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                        long jConvertToBufferedPositionMs = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                        SessionCommands sessionCommands5 = sessionCommands3;
                        ImmutableList immutableList4 = mediaButtonPreferencesFromCustomLayout;
                        SessionError sessionError2 = sessionError;
                        int iCalculateBufferedPercentage = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                        long jConvertToBufferedPositionMs2 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                        if (mediaMetadataCompat3 == null && mediaMetadataCompat3.getLong("android.media.metadata.ADVERTISEMENT") != j3) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (playbackStateCompat2 == null) {
                            playbackParameters = PlaybackParameters.DEFAULT;
                        } else {
                            playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                        }
                        if (mediaControllerCompat$PlaybackInfo2 == 0) {
                            audioAttributes = AudioAttributes.DEFAULT;
                            mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                        } else {
                            mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                            audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                        }
                        if (playbackStateCompat2 == null) {
                            switch (playbackStateCompat2.state) {
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 9:
                                case 10:
                                case 11:
                                    z8 = true;
                                    break;
                                case 7:
                                case 8:
                                default:
                                    z8 = false;
                                    break;
                            }
                        } else {
                            z8 = false;
                        }
                        if (playbackStateCompat2 == null) {
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 1;
                        } else {
                            try {
                                i8 = playbackStateCompat2.state;
                                jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                                if (jConvertToDurationMs == -9223372036854775807L && LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) >= jConvertToDurationMs) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                switch (i8) {
                                    case 0:
                                    case 7:
                                    case 8:
                                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                        i7 = 1;
                                        break;
                                    case 1:
                                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                        if (z9) {
                                            i7 = 4;
                                        } else {
                                            i7 = 1;
                                        }
                                        break;
                                    case 2:
                                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                        if (z9) {
                                            i7 = 4;
                                        } else {
                                            i7 = 3;
                                        }
                                        break;
                                    case 3:
                                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                        i7 = 3;
                                        break;
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 9:
                                    case 10:
                                    case 11:
                                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                        i7 = 2;
                                        break;
                                    default:
                                        try {
                                            throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                                        } catch (LegacyConversions.ConversionException unused) {
                                            Log.e("MCImplLegacy", "Received invalid playback state " + playbackStateCompat2.state + " from package " + packageName + ". Keeping the previous state.");
                                            i7 = ((PlayerInfo) quantizerWu2.weights).playbackState;
                                            int i22 = i7;
                                            if (playbackStateCompat2 == null) {
                                                z10 = false;
                                            } else {
                                                z10 = true;
                                            }
                                            if (mediaControllerCompat$PlaybackInfo3 == null) {
                                                deviceInfoBuild = DeviceInfo.UNKNOWN;
                                            } else {
                                                if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                                                    i9 = 1;
                                                } else {
                                                    i9 = 0;
                                                }
                                                GapBuffer gapBuffer = new GapBuffer(i9);
                                                gapBuffer.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                                                String str6 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                                                if (i9 == 0) {
                                                    z11 = true;
                                                } else {
                                                    z11 = true;
                                                }
                                                UtilsKt.checkArgument(z11);
                                                gapBuffer.buffer = str6;
                                                deviceInfoBuild = gapBuffer.build();
                                            }
                                            DeviceInfo deviceInfo = deviceInfoBuild;
                                            if (mediaControllerCompat$PlaybackInfo3 == null) {
                                                i10 = 0;
                                            } else {
                                                i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                                            }
                                            if (mediaControllerCompat$PlaybackInfo3 == null) {
                                                z12 = false;
                                            } else {
                                                z12 = true;
                                            }
                                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu2.weights;
                                            long j12 = playerInfo3.seekBackIncrementMs;
                                            long j13 = playerInfo3.seekForwardIncrementMs;
                                            long j14 = playerInfo3.maxSeekToPreviousPositionMs;
                                            Bundle bundle8 = legacyPlayerInfo.sessionExtras;
                                            if (windowCount >= queueTimeline2.getWindowCount()) {
                                                queueTimeline3 = queueTimeline2;
                                                mediaItem2 = null;
                                            } else {
                                                queueTimeline3 = queueTimeline2;
                                                mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                                            }
                                            SessionPositionInfo sessionPositionInfo = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs3, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs, iCalculateBufferedPercentage, jConvertToBufferedPositionMs2, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs);
                                            Player.PositionInfo positionInfo = SessionPositionInfo.DEFAULT_POSITION_INFO;
                                            int i23 = i4;
                                            playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo, positionInfo, positionInfo, 0, playbackParameters, i23, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata3, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo, i10, z12, z8, 1, 0, i22, z10, false, mediaMetadata, j12, j13, j14, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                                            QuantizerWu quantizerWu3 = new QuantizerWu(playerInfo, sessionCommands5, commands2, immutableList4, bundle8, sessionError2);
                                            legacyPlayerInfo2 = this.legacyPlayerInfo;
                                            quantizerWu = this.controllerInfo;
                                            j6 = mediaController.timeDiffMs;
                                            zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                                            boolean zIsEmpty2 = queueTimeline3.isEmpty();
                                            if (!zIsEmpty) {
                                                if (zIsEmpty) {
                                                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                                                    currentMediaItem.getClass();
                                                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                                                    if (queuedMediaItem2 == null) {
                                                        i11 = 0;
                                                        while (true) {
                                                            immutableList2 = queueTimeline3.queuedMediaItems;
                                                            if (i11 >= immutableList2.size()) {
                                                                z13 = false;
                                                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                                z13 = true;
                                                            } else {
                                                                i11++;
                                                            }
                                                        }
                                                    } else {
                                                        i11 = 0;
                                                        while (true) {
                                                            immutableList2 = queueTimeline3.queuedMediaItems;
                                                            if (i11 >= immutableList2.size()) {
                                                                z13 = false;
                                                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                                z13 = true;
                                                            } else {
                                                                i11++;
                                                            }
                                                        }
                                                    }
                                                    if (z13) {
                                                        num2 = 4;
                                                        num = 3;
                                                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                                        if (jConvertToCurrentPositionMs2 == j3) {
                                                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                                num2 = 5;
                                                            } else {
                                                                num2 = null;
                                                            }
                                                            num3 = null;
                                                        } else {
                                                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                                num2 = 5;
                                                            } else {
                                                                num2 = null;
                                                            }
                                                            num3 = null;
                                                        }
                                                        num = num3;
                                                    } else {
                                                        z14 = true;
                                                        num = 1;
                                                        num2 = 0;
                                                    }
                                                    z14 = true;
                                                } else {
                                                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                                                    currentMediaItem.getClass();
                                                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                                                    if (queuedMediaItem2 == null) {
                                                        i11 = 0;
                                                        while (true) {
                                                            immutableList2 = queueTimeline3.queuedMediaItems;
                                                            if (i11 >= immutableList2.size()) {
                                                                z13 = false;
                                                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                                z13 = true;
                                                            } else {
                                                                i11++;
                                                            }
                                                        }
                                                    } else {
                                                        i11 = 0;
                                                        while (true) {
                                                            immutableList2 = queueTimeline3.queuedMediaItems;
                                                            if (i11 >= immutableList2.size()) {
                                                                z13 = false;
                                                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                                z13 = true;
                                                            } else {
                                                                i11++;
                                                            }
                                                        }
                                                    }
                                                    if (z13) {
                                                        num2 = 4;
                                                        num = 3;
                                                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                                        if (jConvertToCurrentPositionMs2 == j3) {
                                                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                                num2 = 5;
                                                            } else {
                                                                num2 = null;
                                                            }
                                                            num3 = null;
                                                        } else {
                                                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                                num2 = 5;
                                                            } else {
                                                                num2 = null;
                                                            }
                                                            num3 = null;
                                                        }
                                                        num = num3;
                                                    } else {
                                                        z14 = true;
                                                        num = 1;
                                                        num2 = 0;
                                                    }
                                                    z14 = true;
                                                }
                                            } else if (zIsEmpty) {
                                                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                                                currentMediaItem.getClass();
                                                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                                                if (queuedMediaItem2 == null) {
                                                    i11 = 0;
                                                    while (true) {
                                                        immutableList2 = queueTimeline3.queuedMediaItems;
                                                        if (i11 >= immutableList2.size()) {
                                                            z13 = false;
                                                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                            z13 = true;
                                                        } else {
                                                            i11++;
                                                        }
                                                    }
                                                } else {
                                                    i11 = 0;
                                                    while (true) {
                                                        immutableList2 = queueTimeline3.queuedMediaItems;
                                                        if (i11 >= immutableList2.size()) {
                                                            z13 = false;
                                                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                            z13 = true;
                                                        } else {
                                                            i11++;
                                                        }
                                                    }
                                                }
                                                if (z13) {
                                                    num2 = 4;
                                                    num = 3;
                                                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                                    if (jConvertToCurrentPositionMs2 == j3) {
                                                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                            num2 = 5;
                                                        } else {
                                                            num2 = null;
                                                        }
                                                        num3 = null;
                                                    } else {
                                                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                            num2 = 5;
                                                        } else {
                                                            num2 = null;
                                                        }
                                                        num3 = null;
                                                    }
                                                    num = num3;
                                                } else {
                                                    z14 = true;
                                                    num = 1;
                                                    num2 = 0;
                                                }
                                                z14 = true;
                                            } else {
                                                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                                                currentMediaItem.getClass();
                                                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                                                if (queuedMediaItem2 == null) {
                                                    i11 = 0;
                                                    while (true) {
                                                        immutableList2 = queueTimeline3.queuedMediaItems;
                                                        if (i11 >= immutableList2.size()) {
                                                            z13 = false;
                                                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                            z13 = true;
                                                        } else {
                                                            i11++;
                                                        }
                                                    }
                                                } else {
                                                    i11 = 0;
                                                    while (true) {
                                                        immutableList2 = queueTimeline3.queuedMediaItems;
                                                        if (i11 >= immutableList2.size()) {
                                                            z13 = false;
                                                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                                            z13 = true;
                                                        } else {
                                                            i11++;
                                                        }
                                                    }
                                                }
                                                if (z13) {
                                                    num2 = 4;
                                                    num = 3;
                                                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                                    if (jConvertToCurrentPositionMs2 == j3) {
                                                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                            num2 = 5;
                                                        } else {
                                                            num2 = null;
                                                        }
                                                        num3 = null;
                                                    } else {
                                                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                                            num2 = 5;
                                                        } else {
                                                            num2 = null;
                                                        }
                                                        num3 = null;
                                                    }
                                                    num = num3;
                                                } else {
                                                    z14 = true;
                                                    num = 1;
                                                    num2 = 0;
                                                }
                                                z14 = true;
                                            }
                                            Pair pairCreate = Pair.create(num2, num);
                                            updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu3, (Integer) pairCreate.first, (Integer) pairCreate.second);
                                            if (this.hasPendingExtrasChange) {
                                                this.hasPendingExtrasChange = false;
                                                if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                                                    z14 = false;
                                                }
                                                UtilsKt.checkState(z14);
                                                mediaController.listener.getClass();
                                            }
                                        }
                                }
                            } catch (LegacyConversions.ConversionException unused2) {
                            }
                        }
                        int i24 = i7;
                        if (playbackStateCompat2 == null && playbackStateCompat2.state == 3) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (mediaControllerCompat$PlaybackInfo3 == null) {
                            deviceInfoBuild = DeviceInfo.UNKNOWN;
                        } else {
                            if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                                i9 = 1;
                            } else {
                                i9 = 0;
                            }
                            GapBuffer gapBuffer2 = new GapBuffer(i9);
                            gapBuffer2.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                            String str7 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                            if (i9 == 0 || str7 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            UtilsKt.checkArgument(z11);
                            gapBuffer2.buffer = str7;
                            deviceInfoBuild = gapBuffer2.build();
                        }
                        DeviceInfo deviceInfo2 = deviceInfoBuild;
                        if (mediaControllerCompat$PlaybackInfo3 == null) {
                            i10 = 0;
                        } else {
                            i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                        }
                        if (mediaControllerCompat$PlaybackInfo3 == null && mediaControllerCompat$PlaybackInfo3.currentVolume == 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu2.weights;
                        long j15 = playerInfo4.seekBackIncrementMs;
                        long j16 = playerInfo4.seekForwardIncrementMs;
                        long j17 = playerInfo4.maxSeekToPreviousPositionMs;
                        Bundle bundle9 = legacyPlayerInfo.sessionExtras;
                        if (windowCount >= queueTimeline2.getWindowCount()) {
                            queueTimeline3 = queueTimeline2;
                            mediaItem2 = null;
                        } else {
                            queueTimeline3 = queueTimeline2;
                            mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                        }
                        SessionPositionInfo sessionPositionInfo2 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs3, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs, iCalculateBufferedPercentage, jConvertToBufferedPositionMs2, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs);
                        Player.PositionInfo positionInfo2 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                        int i25 = i4;
                        playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo2, positionInfo2, positionInfo2, 0, playbackParameters, i25, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata3, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo2, i10, z12, z8, 1, 0, i24, z10, false, mediaMetadata, j15, j16, j17, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                        QuantizerWu quantizerWu4 = new QuantizerWu(playerInfo, sessionCommands5, commands2, immutableList4, bundle9, sessionError2);
                        legacyPlayerInfo2 = this.legacyPlayerInfo;
                        quantizerWu = this.controllerInfo;
                        j6 = mediaController.timeDiffMs;
                        zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                        boolean zIsEmpty3 = queueTimeline3.isEmpty();
                        if (!zIsEmpty && zIsEmpty3) {
                            num = null;
                            num2 = null;
                        } else if (zIsEmpty || zIsEmpty3) {
                            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                            currentMediaItem.getClass();
                            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                            if (queuedMediaItem2 == null && currentMediaItem.equals(queuedMediaItem2.mediaItem)) {
                                z13 = true;
                            } else {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                            if (z13) {
                                if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                    if (jConvertToCurrentPositionMs2 == j3 || i25 != 1) {
                                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                            num2 = 5;
                                        } else {
                                            num2 = null;
                                        }
                                        num3 = null;
                                    } else {
                                        num2 = 0;
                                        num3 = null;
                                    }
                                    num = num3;
                                } else {
                                    z14 = true;
                                    num = 1;
                                    num2 = 0;
                                }
                                Pair pairCreate2 = Pair.create(num2, num);
                                updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu4, (Integer) pairCreate2.first, (Integer) pairCreate2.second);
                                if (this.hasPendingExtrasChange) {
                                    this.hasPendingExtrasChange = false;
                                    if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                                        z14 = false;
                                    }
                                    UtilsKt.checkState(z14);
                                    mediaController.listener.getClass();
                                }
                            }
                            num2 = 4;
                            num = 3;
                        } else {
                            num = 3;
                            num2 = 0;
                        }
                        z14 = true;
                        Pair pairCreate3 = Pair.create(num2, num);
                        updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu4, (Integer) pairCreate3.first, (Integer) pairCreate3.second);
                        if (this.hasPendingExtrasChange) {
                            this.hasPendingExtrasChange = false;
                            if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                                z14 = false;
                            }
                            UtilsKt.checkState(z14);
                            mediaController.listener.getClass();
                        }
                    }
                    commands2 = commands;
                    sessionError = null;
                    long jConvertToCurrentPositionMs4 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    long jConvertToBufferedPositionMs3 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    SessionCommands sessionCommands6 = sessionCommands3;
                    ImmutableList immutableList5 = mediaButtonPreferencesFromCustomLayout;
                    SessionError sessionError3 = sessionError;
                    int iCalculateBufferedPercentage2 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                    long jConvertToBufferedPositionMs4 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    if (mediaMetadataCompat3 == null) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (playbackStateCompat2 == null) {
                        playbackParameters = PlaybackParameters.DEFAULT;
                    } else {
                        playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                    }
                    if (mediaControllerCompat$PlaybackInfo2 == 0) {
                        audioAttributes = AudioAttributes.DEFAULT;
                        mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                    } else {
                        mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                        audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                    }
                    if (playbackStateCompat2 == null) {
                        switch (playbackStateCompat2.state) {
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 9:
                            case 10:
                            case 11:
                                z8 = true;
                                break;
                            case 7:
                            case 8:
                            default:
                                z8 = false;
                                break;
                        }
                    } else {
                        z8 = false;
                    }
                    if (playbackStateCompat2 == null) {
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 1;
                    } else {
                        i8 = playbackStateCompat2.state;
                        jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                        if (jConvertToDurationMs == -9223372036854775807L) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        switch (i8) {
                            case 0:
                            case 7:
                            case 8:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 1;
                                break;
                            case 1:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                if (z9) {
                                    i7 = 4;
                                } else {
                                    i7 = 1;
                                }
                                break;
                            case 2:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                if (z9) {
                                    i7 = 4;
                                } else {
                                    i7 = 3;
                                }
                                break;
                            case 3:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 3;
                                break;
                            case 4:
                            case 5:
                            case 6:
                            case 9:
                            case 10:
                            case 11:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 2;
                                break;
                            default:
                                throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                        }
                    }
                    int i26 = i7;
                    if (playbackStateCompat2 == null) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        deviceInfoBuild = DeviceInfo.UNKNOWN;
                    } else {
                        if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                            i9 = 1;
                        } else {
                            i9 = 0;
                        }
                        GapBuffer gapBuffer3 = new GapBuffer(i9);
                        gapBuffer3.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                        String str8 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                        if (i9 == 0) {
                            z11 = true;
                        } else {
                            z11 = true;
                        }
                        UtilsKt.checkArgument(z11);
                        gapBuffer3.buffer = str8;
                        deviceInfoBuild = gapBuffer3.build();
                    }
                    DeviceInfo deviceInfo3 = deviceInfoBuild;
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        i10 = 0;
                    } else {
                        i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                    }
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    PlayerInfo playerInfo5 = (PlayerInfo) quantizerWu2.weights;
                    long j18 = playerInfo5.seekBackIncrementMs;
                    long j19 = playerInfo5.seekForwardIncrementMs;
                    long j110 = playerInfo5.maxSeekToPreviousPositionMs;
                    Bundle bundle10 = legacyPlayerInfo.sessionExtras;
                    if (windowCount >= queueTimeline2.getWindowCount()) {
                        queueTimeline3 = queueTimeline2;
                        mediaItem2 = null;
                    } else {
                        queueTimeline3 = queueTimeline2;
                        mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                    }
                    SessionPositionInfo sessionPositionInfo3 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs4, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs3, iCalculateBufferedPercentage2, jConvertToBufferedPositionMs4, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs3);
                    Player.PositionInfo positionInfo3 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                    int i27 = i4;
                    playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo3, positionInfo3, positionInfo3, 0, playbackParameters, i27, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata3, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo3, i10, z12, z8, 1, 0, i26, z10, false, mediaMetadata, j18, j19, j110, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                    QuantizerWu quantizerWu5 = new QuantizerWu(playerInfo, sessionCommands6, commands2, immutableList5, bundle10, sessionError3);
                    legacyPlayerInfo2 = this.legacyPlayerInfo;
                    quantizerWu = this.controllerInfo;
                    j6 = mediaController.timeDiffMs;
                    zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                    boolean zIsEmpty4 = queueTimeline3.isEmpty();
                    if (!zIsEmpty) {
                        if (zIsEmpty) {
                            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                            currentMediaItem.getClass();
                            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                            if (queuedMediaItem2 == null) {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            } else {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                            if (z13) {
                                num2 = 4;
                                num = 3;
                            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                if (jConvertToCurrentPositionMs2 == j3) {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                } else {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                }
                                num = num3;
                            } else {
                                z14 = true;
                                num = 1;
                                num2 = 0;
                            }
                            z14 = true;
                        } else {
                            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                            currentMediaItem.getClass();
                            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                            if (queuedMediaItem2 == null) {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            } else {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                            if (z13) {
                                num2 = 4;
                                num = 3;
                            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                if (jConvertToCurrentPositionMs2 == j3) {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                } else {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                }
                                num = num3;
                            } else {
                                z14 = true;
                                num = 1;
                                num2 = 0;
                            }
                            z14 = true;
                        }
                    } else if (zIsEmpty) {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    } else {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    }
                    Pair pairCreate4 = Pair.create(num2, num);
                    updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu5, (Integer) pairCreate4.first, (Integer) pairCreate4.second);
                    if (this.hasPendingExtrasChange) {
                        this.hasPendingExtrasChange = false;
                        if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                            z14 = false;
                        }
                        UtilsKt.checkState(z14);
                        mediaController.listener.getClass();
                    }
                }
                bundle = bundle6;
                builder4.add(2);
                if (LegacyConversions.hasAction(j4, 8L)) {
                    builder4.add(11);
                }
                if (LegacyConversions.hasAction(j4, 64L)) {
                    builder4.add(12);
                }
                bundle2 = bundle;
                if (LegacyConversions.hasAction(j4, 256L)) {
                    builder4.addAll(5, 4);
                }
                if (LegacyConversions.hasAction(j4, 32L)) {
                    builder4.addAll(9, 8);
                }
                if (LegacyConversions.hasAction(j4, 16L)) {
                    builder4.addAll(7, 6);
                }
                if (LegacyConversions.hasAction(j4, 4194304L)) {
                    builder4.add(13);
                }
                if (LegacyConversions.hasAction(j4, 1L)) {
                    builder4.add(3);
                }
                if (i == 1) {
                    builder4.addAll(26, 34);
                } else if (i == 2) {
                    builder4.addAll(26, 34, 25, 33);
                }
                builder4.addAll(23, 17, 18, 16, 21, 32);
                if ((flags & j5) != j3) {
                    builder4.add(20);
                }
                if (LegacyConversions.hasAction(j4, 4096L)) {
                    builder4.add(10);
                }
                if (z2) {
                    if (LegacyConversions.hasAction(j4, 262144L)) {
                        builder4.add(15);
                    }
                    if (LegacyConversions.hasAction(j4, 2097152L)) {
                        builder4.add(14);
                    }
                }
                commands = new Player.Commands(builder4.build());
                charSequence = legacyPlayerInfo3.queueTitle;
                charSequence2 = legacyPlayerInfo.queueTitle;
                if (charSequence == charSequence2) {
                    mediaMetadata2 = ((PlayerInfo) quantizerWu2.weights).playlistMetadata;
                } else if (charSequence2 == null) {
                    mediaMetadata2 = androidx.media3.common.MediaMetadata.EMPTY;
                } else {
                    androidx.media3.common.MediaMetadata.Builder builder6 = new androidx.media3.common.MediaMetadata.Builder();
                    builder6.title = charSequence2;
                    mediaMetadata2 = new androidx.media3.common.MediaMetadata(builder6);
                }
                androidx.media3.common.MediaMetadata mediaMetadata4 = mediaMetadata2;
                iConvertToRepeatMode = LegacyConversions.convertToRepeatMode(legacyPlayerInfo.repeatMode);
                zConvertToShuffleModeEnabled = LegacyConversions.convertToShuffleModeEnabled(legacyPlayerInfo.shuffleMode);
                if (playbackStateCompat == playbackStateCompat2) {
                    hashSet = new HashSet();
                    regularImmutableList = SessionCommand.SESSION_COMMANDS;
                    while (i2 < regularImmutableList.size) {
                        hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                    }
                    if (!z2) {
                        while (r8.hasNext()) {
                            if (sessionCommand.commandCode == 40010) {
                                hashSet.remove(sessionCommand);
                            }
                        }
                    }
                    if (playbackStateCompat2 != null) {
                        while (r8.hasNext()) {
                            String str9 = customAction.action;
                            bundle5 = customAction.extras;
                            if (bundle5 == null) {
                                bundle5 = Bundle.EMPTY;
                            }
                            hashSet.add(new SessionCommand(str9, bundle5));
                        }
                    }
                    sessionCommands = new SessionCommands(hashSet);
                    if (playbackStateCompat2 == null) {
                        ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                    } else {
                        List list4 = playbackStateCompat2.customActions;
                        Maps.checkNonnegative(4, str);
                        objArrCopyOf = new Object[4];
                        it = list4.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            PlaybackStateCompat.CustomAction customAction3 = (PlaybackStateCompat.CustomAction) it.next();
                            String str10 = customAction3.action;
                            int i110 = iConvertToRepeatMode;
                            bundle3 = customAction3.extras;
                            if (bundle3 != null) {
                                i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                            } else {
                                i5 = 0;
                            }
                            SessionCommands sessionCommands7 = sessionCommands;
                            builder = new CommandButton.Builder(i5, customAction3.icon);
                            if (bundle3 == null) {
                                bundle4 = Bundle.EMPTY;
                            } else {
                                bundle4 = bundle3;
                            }
                            builder.setSessionCommand(new SessionCommand(str10, bundle4));
                            builder.displayName = customAction3.name;
                            builder.enabled = true;
                            if (bundle3 != null) {
                                builder.extras = new Bundle(bundle3);
                            }
                            if (bundle3 != null) {
                                string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                            } else {
                                string = null;
                            }
                            if (string != null) {
                                uri = Uri.parse(string);
                                scheme = uri.getScheme();
                                if (Objects.equals(scheme, "content")) {
                                    builder.setIconUri(uri);
                                } else {
                                    builder.setIconUri(uri);
                                }
                            }
                            CommandButton commandButtonBuild2 = builder.build();
                            int i28 = i3 + 1;
                            iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i28);
                            if (iExpandedCapacity > objArrCopyOf.length) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                            }
                            objArrCopyOf[i3] = commandButtonBuild2;
                            i3 = i28;
                            iConvertToRepeatMode = i110;
                            zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                            it = it;
                            sessionCommands = sessionCommands7;
                        }
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                    }
                    sessionCommands3 = sessionCommands2;
                } else {
                    hashSet = new HashSet();
                    regularImmutableList = SessionCommand.SESSION_COMMANDS;
                    while (i2 < regularImmutableList.size) {
                        hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                    }
                    if (!z2) {
                        while (r8.hasNext()) {
                            if (sessionCommand.commandCode == 40010) {
                                hashSet.remove(sessionCommand);
                            }
                        }
                    }
                    if (playbackStateCompat2 != null) {
                        while (r8.hasNext()) {
                            String str11 = customAction.action;
                            bundle5 = customAction.extras;
                            if (bundle5 == null) {
                                bundle5 = Bundle.EMPTY;
                            }
                            hashSet.add(new SessionCommand(str11, bundle5));
                        }
                    }
                    sessionCommands = new SessionCommands(hashSet);
                    if (playbackStateCompat2 == null) {
                        ImmutableList.Itr itr3 = ImmutableList.EMPTY_ITR;
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                    } else {
                        List list5 = playbackStateCompat2.customActions;
                        Maps.checkNonnegative(4, str);
                        objArrCopyOf = new Object[4];
                        it = list5.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            PlaybackStateCompat.CustomAction customAction4 = (PlaybackStateCompat.CustomAction) it.next();
                            String str12 = customAction4.action;
                            int i111 = iConvertToRepeatMode;
                            bundle3 = customAction4.extras;
                            if (bundle3 != null) {
                                i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                            } else {
                                i5 = 0;
                            }
                            SessionCommands sessionCommands8 = sessionCommands;
                            builder = new CommandButton.Builder(i5, customAction4.icon);
                            if (bundle3 == null) {
                                bundle4 = Bundle.EMPTY;
                            } else {
                                bundle4 = bundle3;
                            }
                            builder.setSessionCommand(new SessionCommand(str12, bundle4));
                            builder.displayName = customAction4.name;
                            builder.enabled = true;
                            if (bundle3 != null) {
                                builder.extras = new Bundle(bundle3);
                            }
                            if (bundle3 != null) {
                                string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                            } else {
                                string = null;
                            }
                            if (string != null) {
                                uri = Uri.parse(string);
                                scheme = uri.getScheme();
                                if (Objects.equals(scheme, "content")) {
                                    builder.setIconUri(uri);
                                } else {
                                    builder.setIconUri(uri);
                                }
                            }
                            CommandButton commandButtonBuild3 = builder.build();
                            int i29 = i3 + 1;
                            iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i29);
                            if (iExpandedCapacity > objArrCopyOf.length) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                            }
                            objArrCopyOf[i3] = commandButtonBuild3;
                            i3 = i29;
                            iConvertToRepeatMode = i111;
                            zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                            it = it;
                            sessionCommands = sessionCommands8;
                        }
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                    }
                    sessionCommands3 = sessionCommands2;
                }
                Context context2 = this.context;
                playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat2, context2);
                if (playbackStateCompat2 == null) {
                    i6 = playbackStateCompat2.state;
                    int i210 = playbackStateCompat2.errorCode;
                    CharSequence charSequence5 = playbackStateCompat2.errorMessage;
                    Bundle bundle11 = playbackStateCompat2.extras;
                    commands2 = commands;
                    if (i6 == 7) {
                    }
                    long jConvertToCurrentPositionMs5 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    long jConvertToBufferedPositionMs5 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    SessionCommands sessionCommands9 = sessionCommands3;
                    ImmutableList immutableList6 = mediaButtonPreferencesFromCustomLayout;
                    SessionError sessionError4 = sessionError;
                    int iCalculateBufferedPercentage3 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                    long jConvertToBufferedPositionMs6 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    if (mediaMetadataCompat3 == null) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (playbackStateCompat2 == null) {
                        playbackParameters = PlaybackParameters.DEFAULT;
                    } else {
                        playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                    }
                    if (mediaControllerCompat$PlaybackInfo2 == 0) {
                        audioAttributes = AudioAttributes.DEFAULT;
                        mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                    } else {
                        mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                        audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                    }
                    if (playbackStateCompat2 == null) {
                        switch (playbackStateCompat2.state) {
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 9:
                            case 10:
                            case 11:
                                z8 = true;
                                break;
                            case 7:
                            case 8:
                            default:
                                z8 = false;
                                break;
                        }
                    } else {
                        z8 = false;
                    }
                    if (playbackStateCompat2 == null) {
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 1;
                    } else {
                        i8 = playbackStateCompat2.state;
                        jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                        if (jConvertToDurationMs == -9223372036854775807L) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        switch (i8) {
                            case 0:
                            case 7:
                            case 8:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 1;
                                break;
                            case 1:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                if (z9) {
                                    i7 = 4;
                                } else {
                                    i7 = 1;
                                }
                                break;
                            case 2:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                if (z9) {
                                    i7 = 4;
                                } else {
                                    i7 = 3;
                                }
                                break;
                            case 3:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 3;
                                break;
                            case 4:
                            case 5:
                            case 6:
                            case 9:
                            case 10:
                            case 11:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 2;
                                break;
                            default:
                                throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                        }
                    }
                    int i211 = i7;
                    if (playbackStateCompat2 == null) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        deviceInfoBuild = DeviceInfo.UNKNOWN;
                    } else {
                        if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                            i9 = 1;
                        } else {
                            i9 = 0;
                        }
                        GapBuffer gapBuffer4 = new GapBuffer(i9);
                        gapBuffer4.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                        String str13 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                        if (i9 == 0) {
                            z11 = true;
                        } else {
                            z11 = true;
                        }
                        UtilsKt.checkArgument(z11);
                        gapBuffer4.buffer = str13;
                        deviceInfoBuild = gapBuffer4.build();
                    }
                    DeviceInfo deviceInfo4 = deviceInfoBuild;
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        i10 = 0;
                    } else {
                        i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                    }
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    PlayerInfo playerInfo6 = (PlayerInfo) quantizerWu2.weights;
                    long j111 = playerInfo6.seekBackIncrementMs;
                    long j112 = playerInfo6.seekForwardIncrementMs;
                    long j113 = playerInfo6.maxSeekToPreviousPositionMs;
                    Bundle bundle12 = legacyPlayerInfo.sessionExtras;
                    if (windowCount >= queueTimeline2.getWindowCount()) {
                        queueTimeline3 = queueTimeline2;
                        mediaItem2 = null;
                    } else {
                        queueTimeline3 = queueTimeline2;
                        mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                    }
                    SessionPositionInfo sessionPositionInfo4 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs5, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs5, iCalculateBufferedPercentage3, jConvertToBufferedPositionMs6, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs5);
                    Player.PositionInfo positionInfo4 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                    int i212 = i4;
                    playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo4, positionInfo4, positionInfo4, 0, playbackParameters, i212, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata4, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo4, i10, z12, z8, 1, 0, i211, z10, false, mediaMetadata, j111, j112, j113, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                    QuantizerWu quantizerWu6 = new QuantizerWu(playerInfo, sessionCommands9, commands2, immutableList6, bundle12, sessionError4);
                    legacyPlayerInfo2 = this.legacyPlayerInfo;
                    quantizerWu = this.controllerInfo;
                    j6 = mediaController.timeDiffMs;
                    zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                    boolean zIsEmpty5 = queueTimeline3.isEmpty();
                    if (!zIsEmpty) {
                        if (zIsEmpty) {
                            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                            currentMediaItem.getClass();
                            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                            if (queuedMediaItem2 == null) {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            } else {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                            if (z13) {
                                num2 = 4;
                                num = 3;
                            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                if (jConvertToCurrentPositionMs2 == j3) {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                } else {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                }
                                num = num3;
                            } else {
                                z14 = true;
                                num = 1;
                                num2 = 0;
                            }
                            z14 = true;
                        } else {
                            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                            currentMediaItem.getClass();
                            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                            if (queuedMediaItem2 == null) {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            } else {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                            if (z13) {
                                num2 = 4;
                                num = 3;
                            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                if (jConvertToCurrentPositionMs2 == j3) {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                } else {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                }
                                num = num3;
                            } else {
                                z14 = true;
                                num = 1;
                                num2 = 0;
                            }
                            z14 = true;
                        }
                    } else if (zIsEmpty) {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    } else {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    }
                    Pair pairCreate5 = Pair.create(num2, num);
                    updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu6, (Integer) pairCreate5.first, (Integer) pairCreate5.second);
                    if (this.hasPendingExtrasChange) {
                        this.hasPendingExtrasChange = false;
                        if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                            z14 = false;
                        }
                        UtilsKt.checkState(z14);
                        mediaController.listener.getClass();
                    }
                }
                commands2 = commands;
                sessionError = null;
                long jConvertToCurrentPositionMs6 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                long jConvertToBufferedPositionMs7 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                SessionCommands sessionCommands10 = sessionCommands3;
                ImmutableList immutableList7 = mediaButtonPreferencesFromCustomLayout;
                SessionError sessionError5 = sessionError;
                int iCalculateBufferedPercentage4 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                long jConvertToBufferedPositionMs8 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                if (mediaMetadataCompat3 == null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (playbackStateCompat2 == null) {
                    playbackParameters = PlaybackParameters.DEFAULT;
                } else {
                    playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                }
                if (mediaControllerCompat$PlaybackInfo2 == 0) {
                    audioAttributes = AudioAttributes.DEFAULT;
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                } else {
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                    audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                }
                if (playbackStateCompat2 == null) {
                    switch (playbackStateCompat2.state) {
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            z8 = true;
                            break;
                        case 7:
                        case 8:
                        default:
                            z8 = false;
                            break;
                    }
                } else {
                    z8 = false;
                }
                if (playbackStateCompat2 == null) {
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    i7 = 1;
                } else {
                    i8 = playbackStateCompat2.state;
                    jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                    if (jConvertToDurationMs == -9223372036854775807L) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    switch (i8) {
                        case 0:
                        case 7:
                        case 8:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 1;
                            break;
                        case 1:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 1;
                            }
                            break;
                        case 2:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 3;
                            }
                            break;
                        case 3:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 2;
                            break;
                        default:
                            throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                    }
                }
                int i213 = i7;
                if (playbackStateCompat2 == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    deviceInfoBuild = DeviceInfo.UNKNOWN;
                } else {
                    if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                        i9 = 1;
                    } else {
                        i9 = 0;
                    }
                    GapBuffer gapBuffer5 = new GapBuffer(i9);
                    gapBuffer5.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                    String str14 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                    if (i9 == 0) {
                        z11 = true;
                    } else {
                        z11 = true;
                    }
                    UtilsKt.checkArgument(z11);
                    gapBuffer5.buffer = str14;
                    deviceInfoBuild = gapBuffer5.build();
                }
                DeviceInfo deviceInfo5 = deviceInfoBuild;
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    i10 = 0;
                } else {
                    i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                PlayerInfo playerInfo7 = (PlayerInfo) quantizerWu2.weights;
                long j114 = playerInfo7.seekBackIncrementMs;
                long j115 = playerInfo7.seekForwardIncrementMs;
                long j116 = playerInfo7.maxSeekToPreviousPositionMs;
                Bundle bundle13 = legacyPlayerInfo.sessionExtras;
                if (windowCount >= queueTimeline2.getWindowCount()) {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = null;
                } else {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                }
                SessionPositionInfo sessionPositionInfo5 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs6, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs7, iCalculateBufferedPercentage4, jConvertToBufferedPositionMs8, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs7);
                Player.PositionInfo positionInfo5 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                int i214 = i4;
                playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo5, positionInfo5, positionInfo5, 0, playbackParameters, i214, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata4, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo5, i10, z12, z8, 1, 0, i213, z10, false, mediaMetadata, j114, j115, j116, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                QuantizerWu quantizerWu7 = new QuantizerWu(playerInfo, sessionCommands10, commands2, immutableList7, bundle13, sessionError5);
                legacyPlayerInfo2 = this.legacyPlayerInfo;
                quantizerWu = this.controllerInfo;
                j6 = mediaController.timeDiffMs;
                zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                boolean zIsEmpty6 = queueTimeline3.isEmpty();
                if (!zIsEmpty) {
                    if (zIsEmpty) {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    } else {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    }
                } else if (zIsEmpty) {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                } else {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                }
                Pair pairCreate6 = Pair.create(num2, num);
                updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu7, (Integer) pairCreate6.first, (Integer) pairCreate6.second);
                if (this.hasPendingExtrasChange) {
                    this.hasPendingExtrasChange = false;
                    if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                        z14 = false;
                    }
                    UtilsKt.checkState(z14);
                    mediaController.listener.getClass();
                }
            }
            j5 = 4;
            builder4.add(1);
            if (LegacyConversions.hasAction(j4, 1024L)) {
                builder4.add(31);
            } else {
                builder4.add(31);
            }
            if (!LegacyConversions.hasAction(j4, 16384L)) {
                bundle = bundle6;
                if (!LegacyConversions.hasAction(j4, 32768L)) {
                }
                if (LegacyConversions.hasAction(j4, 8L)) {
                    builder4.add(11);
                }
                if (LegacyConversions.hasAction(j4, 64L)) {
                    builder4.add(12);
                }
                bundle2 = bundle;
                if (LegacyConversions.hasAction(j4, 256L)) {
                    builder4.addAll(5, 4);
                }
                if (LegacyConversions.hasAction(j4, 32L)) {
                    builder4.addAll(9, 8);
                }
                if (LegacyConversions.hasAction(j4, 16L)) {
                    builder4.addAll(7, 6);
                }
                if (LegacyConversions.hasAction(j4, 4194304L)) {
                    builder4.add(13);
                }
                if (LegacyConversions.hasAction(j4, 1L)) {
                    builder4.add(3);
                }
                if (i == 1) {
                    builder4.addAll(26, 34);
                } else if (i == 2) {
                    builder4.addAll(26, 34, 25, 33);
                }
                builder4.addAll(23, 17, 18, 16, 21, 32);
                if ((flags & j5) != j3) {
                    builder4.add(20);
                }
                if (LegacyConversions.hasAction(j4, 4096L)) {
                    builder4.add(10);
                }
                if (z2) {
                    if (LegacyConversions.hasAction(j4, 262144L)) {
                        builder4.add(15);
                    }
                    if (LegacyConversions.hasAction(j4, 2097152L)) {
                        builder4.add(14);
                    }
                }
                commands = new Player.Commands(builder4.build());
                charSequence = legacyPlayerInfo3.queueTitle;
                charSequence2 = legacyPlayerInfo.queueTitle;
                if (charSequence == charSequence2) {
                    mediaMetadata2 = ((PlayerInfo) quantizerWu2.weights).playlistMetadata;
                } else if (charSequence2 == null) {
                    mediaMetadata2 = androidx.media3.common.MediaMetadata.EMPTY;
                } else {
                    androidx.media3.common.MediaMetadata.Builder builder7 = new androidx.media3.common.MediaMetadata.Builder();
                    builder7.title = charSequence2;
                    mediaMetadata2 = new androidx.media3.common.MediaMetadata(builder7);
                }
                androidx.media3.common.MediaMetadata mediaMetadata5 = mediaMetadata2;
                iConvertToRepeatMode = LegacyConversions.convertToRepeatMode(legacyPlayerInfo.repeatMode);
                zConvertToShuffleModeEnabled = LegacyConversions.convertToShuffleModeEnabled(legacyPlayerInfo.shuffleMode);
                if (playbackStateCompat == playbackStateCompat2) {
                    hashSet = new HashSet();
                    regularImmutableList = SessionCommand.SESSION_COMMANDS;
                    while (i2 < regularImmutableList.size) {
                        hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                    }
                    if (!z2) {
                        while (r8.hasNext()) {
                            if (sessionCommand.commandCode == 40010) {
                                hashSet.remove(sessionCommand);
                            }
                        }
                    }
                    if (playbackStateCompat2 != null) {
                        while (r8.hasNext()) {
                            String str15 = customAction.action;
                            bundle5 = customAction.extras;
                            if (bundle5 == null) {
                                bundle5 = Bundle.EMPTY;
                            }
                            hashSet.add(new SessionCommand(str15, bundle5));
                        }
                    }
                    sessionCommands = new SessionCommands(hashSet);
                    if (playbackStateCompat2 == null) {
                        ImmutableList.Itr itr4 = ImmutableList.EMPTY_ITR;
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                    } else {
                        List list6 = playbackStateCompat2.customActions;
                        Maps.checkNonnegative(4, str);
                        objArrCopyOf = new Object[4];
                        it = list6.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            PlaybackStateCompat.CustomAction customAction5 = (PlaybackStateCompat.CustomAction) it.next();
                            String str16 = customAction5.action;
                            int i112 = iConvertToRepeatMode;
                            bundle3 = customAction5.extras;
                            if (bundle3 != null) {
                                i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                            } else {
                                i5 = 0;
                            }
                            SessionCommands sessionCommands11 = sessionCommands;
                            builder = new CommandButton.Builder(i5, customAction5.icon);
                            if (bundle3 == null) {
                                bundle4 = Bundle.EMPTY;
                            } else {
                                bundle4 = bundle3;
                            }
                            builder.setSessionCommand(new SessionCommand(str16, bundle4));
                            builder.displayName = customAction5.name;
                            builder.enabled = true;
                            if (bundle3 != null) {
                                builder.extras = new Bundle(bundle3);
                            }
                            if (bundle3 != null) {
                                string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                            } else {
                                string = null;
                            }
                            if (string != null) {
                                uri = Uri.parse(string);
                                scheme = uri.getScheme();
                                if (Objects.equals(scheme, "content")) {
                                    builder.setIconUri(uri);
                                } else {
                                    builder.setIconUri(uri);
                                }
                            }
                            CommandButton commandButtonBuild4 = builder.build();
                            int i215 = i3 + 1;
                            iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i215);
                            if (iExpandedCapacity > objArrCopyOf.length) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                            }
                            objArrCopyOf[i3] = commandButtonBuild4;
                            i3 = i215;
                            iConvertToRepeatMode = i112;
                            zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                            it = it;
                            sessionCommands = sessionCommands11;
                        }
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                    }
                    sessionCommands3 = sessionCommands2;
                } else {
                    hashSet = new HashSet();
                    regularImmutableList = SessionCommand.SESSION_COMMANDS;
                    while (i2 < regularImmutableList.size) {
                        hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                    }
                    if (!z2) {
                        while (r8.hasNext()) {
                            if (sessionCommand.commandCode == 40010) {
                                hashSet.remove(sessionCommand);
                            }
                        }
                    }
                    if (playbackStateCompat2 != null) {
                        while (r8.hasNext()) {
                            String str17 = customAction.action;
                            bundle5 = customAction.extras;
                            if (bundle5 == null) {
                                bundle5 = Bundle.EMPTY;
                            }
                            hashSet.add(new SessionCommand(str17, bundle5));
                        }
                    }
                    sessionCommands = new SessionCommands(hashSet);
                    if (playbackStateCompat2 == null) {
                        ImmutableList.Itr itr5 = ImmutableList.EMPTY_ITR;
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                    } else {
                        List list7 = playbackStateCompat2.customActions;
                        Maps.checkNonnegative(4, str);
                        objArrCopyOf = new Object[4];
                        it = list7.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            PlaybackStateCompat.CustomAction customAction6 = (PlaybackStateCompat.CustomAction) it.next();
                            String str18 = customAction6.action;
                            int i113 = iConvertToRepeatMode;
                            bundle3 = customAction6.extras;
                            if (bundle3 != null) {
                                i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                            } else {
                                i5 = 0;
                            }
                            SessionCommands sessionCommands12 = sessionCommands;
                            builder = new CommandButton.Builder(i5, customAction6.icon);
                            if (bundle3 == null) {
                                bundle4 = Bundle.EMPTY;
                            } else {
                                bundle4 = bundle3;
                            }
                            builder.setSessionCommand(new SessionCommand(str18, bundle4));
                            builder.displayName = customAction6.name;
                            builder.enabled = true;
                            if (bundle3 != null) {
                                builder.extras = new Bundle(bundle3);
                            }
                            if (bundle3 != null) {
                                string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                            } else {
                                string = null;
                            }
                            if (string != null) {
                                uri = Uri.parse(string);
                                scheme = uri.getScheme();
                                if (Objects.equals(scheme, "content")) {
                                    builder.setIconUri(uri);
                                } else {
                                    builder.setIconUri(uri);
                                }
                            }
                            CommandButton commandButtonBuild5 = builder.build();
                            int i216 = i3 + 1;
                            iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i216);
                            if (iExpandedCapacity > objArrCopyOf.length) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                            }
                            objArrCopyOf[i3] = commandButtonBuild5;
                            i3 = i216;
                            iConvertToRepeatMode = i113;
                            zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                            it = it;
                            sessionCommands = sessionCommands12;
                        }
                        i4 = iConvertToRepeatMode;
                        z6 = zConvertToShuffleModeEnabled;
                        sessionCommands2 = sessionCommands;
                        mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                    }
                    sessionCommands3 = sessionCommands2;
                }
                Context context3 = this.context;
                playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat2, context3);
                if (playbackStateCompat2 == null) {
                    i6 = playbackStateCompat2.state;
                    int i217 = playbackStateCompat2.errorCode;
                    CharSequence charSequence6 = playbackStateCompat2.errorMessage;
                    Bundle bundle14 = playbackStateCompat2.extras;
                    commands2 = commands;
                    if (i6 == 7) {
                    }
                    long jConvertToCurrentPositionMs7 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    long jConvertToBufferedPositionMs9 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    SessionCommands sessionCommands13 = sessionCommands3;
                    ImmutableList immutableList8 = mediaButtonPreferencesFromCustomLayout;
                    SessionError sessionError6 = sessionError;
                    int iCalculateBufferedPercentage5 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                    long jConvertToBufferedPositionMs10 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                    if (mediaMetadataCompat3 == null) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (playbackStateCompat2 == null) {
                        playbackParameters = PlaybackParameters.DEFAULT;
                    } else {
                        playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                    }
                    if (mediaControllerCompat$PlaybackInfo2 == 0) {
                        audioAttributes = AudioAttributes.DEFAULT;
                        mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                    } else {
                        mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                        audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                    }
                    if (playbackStateCompat2 == null) {
                        switch (playbackStateCompat2.state) {
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 9:
                            case 10:
                            case 11:
                                z8 = true;
                                break;
                            case 7:
                            case 8:
                            default:
                                z8 = false;
                                break;
                        }
                    } else {
                        z8 = false;
                    }
                    if (playbackStateCompat2 == null) {
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 1;
                    } else {
                        i8 = playbackStateCompat2.state;
                        jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                        if (jConvertToDurationMs == -9223372036854775807L) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        switch (i8) {
                            case 0:
                            case 7:
                            case 8:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 1;
                                break;
                            case 1:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                if (z9) {
                                    i7 = 4;
                                } else {
                                    i7 = 1;
                                }
                                break;
                            case 2:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                if (z9) {
                                    i7 = 4;
                                } else {
                                    i7 = 3;
                                }
                                break;
                            case 3:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 3;
                                break;
                            case 4:
                            case 5:
                            case 6:
                            case 9:
                            case 10:
                            case 11:
                                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                                i7 = 2;
                                break;
                            default:
                                throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                        }
                    }
                    int i218 = i7;
                    if (playbackStateCompat2 == null) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        deviceInfoBuild = DeviceInfo.UNKNOWN;
                    } else {
                        if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                            i9 = 1;
                        } else {
                            i9 = 0;
                        }
                        GapBuffer gapBuffer6 = new GapBuffer(i9);
                        gapBuffer6.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                        String str19 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                        if (i9 == 0) {
                            z11 = true;
                        } else {
                            z11 = true;
                        }
                        UtilsKt.checkArgument(z11);
                        gapBuffer6.buffer = str19;
                        deviceInfoBuild = gapBuffer6.build();
                    }
                    DeviceInfo deviceInfo6 = deviceInfoBuild;
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        i10 = 0;
                    } else {
                        i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                    }
                    if (mediaControllerCompat$PlaybackInfo3 == null) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    PlayerInfo playerInfo8 = (PlayerInfo) quantizerWu2.weights;
                    long j117 = playerInfo8.seekBackIncrementMs;
                    long j118 = playerInfo8.seekForwardIncrementMs;
                    long j119 = playerInfo8.maxSeekToPreviousPositionMs;
                    Bundle bundle15 = legacyPlayerInfo.sessionExtras;
                    if (windowCount >= queueTimeline2.getWindowCount()) {
                        queueTimeline3 = queueTimeline2;
                        mediaItem2 = null;
                    } else {
                        queueTimeline3 = queueTimeline2;
                        mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                    }
                    SessionPositionInfo sessionPositionInfo6 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs7, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs9, iCalculateBufferedPercentage5, jConvertToBufferedPositionMs10, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs9);
                    Player.PositionInfo positionInfo6 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                    int i219 = i4;
                    playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo6, positionInfo6, positionInfo6, 0, playbackParameters, i219, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata5, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo6, i10, z12, z8, 1, 0, i218, z10, false, mediaMetadata, j117, j118, j119, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                    QuantizerWu quantizerWu8 = new QuantizerWu(playerInfo, sessionCommands13, commands2, immutableList8, bundle15, sessionError6);
                    legacyPlayerInfo2 = this.legacyPlayerInfo;
                    quantizerWu = this.controllerInfo;
                    j6 = mediaController.timeDiffMs;
                    zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                    boolean zIsEmpty7 = queueTimeline3.isEmpty();
                    if (!zIsEmpty) {
                        if (zIsEmpty) {
                            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                            currentMediaItem.getClass();
                            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                            if (queuedMediaItem2 == null) {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            } else {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                            if (z13) {
                                num2 = 4;
                                num = 3;
                            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                if (jConvertToCurrentPositionMs2 == j3) {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                } else {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                }
                                num = num3;
                            } else {
                                z14 = true;
                                num = 1;
                                num2 = 0;
                            }
                            z14 = true;
                        } else {
                            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                            currentMediaItem.getClass();
                            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                            if (queuedMediaItem2 == null) {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            } else {
                                i11 = 0;
                                while (true) {
                                    immutableList2 = queueTimeline3.queuedMediaItems;
                                    if (i11 >= immutableList2.size()) {
                                        z13 = false;
                                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                        z13 = true;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                            if (z13) {
                                num2 = 4;
                                num = 3;
                            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                                if (jConvertToCurrentPositionMs2 == j3) {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                } else {
                                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                        num2 = 5;
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = null;
                                }
                                num = num3;
                            } else {
                                z14 = true;
                                num = 1;
                                num2 = 0;
                            }
                            z14 = true;
                        }
                    } else if (zIsEmpty) {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    } else {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    }
                    Pair pairCreate7 = Pair.create(num2, num);
                    updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu8, (Integer) pairCreate7.first, (Integer) pairCreate7.second);
                    if (this.hasPendingExtrasChange) {
                        this.hasPendingExtrasChange = false;
                        if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                            z14 = false;
                        }
                        UtilsKt.checkState(z14);
                        mediaController.listener.getClass();
                    }
                }
                commands2 = commands;
                sessionError = null;
                long jConvertToCurrentPositionMs8 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                long jConvertToBufferedPositionMs11 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                SessionCommands sessionCommands14 = sessionCommands3;
                ImmutableList immutableList9 = mediaButtonPreferencesFromCustomLayout;
                SessionError sessionError7 = sessionError;
                int iCalculateBufferedPercentage6 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                long jConvertToBufferedPositionMs12 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                if (mediaMetadataCompat3 == null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (playbackStateCompat2 == null) {
                    playbackParameters = PlaybackParameters.DEFAULT;
                } else {
                    playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                }
                if (mediaControllerCompat$PlaybackInfo2 == 0) {
                    audioAttributes = AudioAttributes.DEFAULT;
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                } else {
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                    audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                }
                if (playbackStateCompat2 == null) {
                    switch (playbackStateCompat2.state) {
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            z8 = true;
                            break;
                        case 7:
                        case 8:
                        default:
                            z8 = false;
                            break;
                    }
                } else {
                    z8 = false;
                }
                if (playbackStateCompat2 == null) {
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    i7 = 1;
                } else {
                    i8 = playbackStateCompat2.state;
                    jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                    if (jConvertToDurationMs == -9223372036854775807L) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    switch (i8) {
                        case 0:
                        case 7:
                        case 8:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 1;
                            break;
                        case 1:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 1;
                            }
                            break;
                        case 2:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 3;
                            }
                            break;
                        case 3:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 2;
                            break;
                        default:
                            throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                    }
                }
                int i2110 = i7;
                if (playbackStateCompat2 == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    deviceInfoBuild = DeviceInfo.UNKNOWN;
                } else {
                    if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                        i9 = 1;
                    } else {
                        i9 = 0;
                    }
                    GapBuffer gapBuffer7 = new GapBuffer(i9);
                    gapBuffer7.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                    String str110 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                    if (i9 == 0) {
                        z11 = true;
                    } else {
                        z11 = true;
                    }
                    UtilsKt.checkArgument(z11);
                    gapBuffer7.buffer = str110;
                    deviceInfoBuild = gapBuffer7.build();
                }
                DeviceInfo deviceInfo7 = deviceInfoBuild;
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    i10 = 0;
                } else {
                    i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                PlayerInfo playerInfo9 = (PlayerInfo) quantizerWu2.weights;
                long j1110 = playerInfo9.seekBackIncrementMs;
                long j1111 = playerInfo9.seekForwardIncrementMs;
                long j1112 = playerInfo9.maxSeekToPreviousPositionMs;
                Bundle bundle16 = legacyPlayerInfo.sessionExtras;
                if (windowCount >= queueTimeline2.getWindowCount()) {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = null;
                } else {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                }
                SessionPositionInfo sessionPositionInfo7 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs8, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs11, iCalculateBufferedPercentage6, jConvertToBufferedPositionMs12, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs11);
                Player.PositionInfo positionInfo7 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                int i2111 = i4;
                playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo7, positionInfo7, positionInfo7, 0, playbackParameters, i2111, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata5, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo7, i10, z12, z8, 1, 0, i2110, z10, false, mediaMetadata, j1110, j1111, j1112, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                QuantizerWu quantizerWu9 = new QuantizerWu(playerInfo, sessionCommands14, commands2, immutableList9, bundle16, sessionError7);
                legacyPlayerInfo2 = this.legacyPlayerInfo;
                quantizerWu = this.controllerInfo;
                j6 = mediaController.timeDiffMs;
                zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                boolean zIsEmpty8 = queueTimeline3.isEmpty();
                if (!zIsEmpty) {
                    if (zIsEmpty) {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    } else {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    }
                } else if (zIsEmpty) {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                } else {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                }
                Pair pairCreate8 = Pair.create(num2, num);
                updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu9, (Integer) pairCreate8.first, (Integer) pairCreate8.second);
                if (this.hasPendingExtrasChange) {
                    this.hasPendingExtrasChange = false;
                    if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                        z14 = false;
                    }
                    UtilsKt.checkState(z14);
                    mediaController.listener.getClass();
                }
            }
            bundle = bundle6;
            builder4.add(2);
            if (LegacyConversions.hasAction(j4, 8L)) {
                builder4.add(11);
            }
            if (LegacyConversions.hasAction(j4, 64L)) {
                builder4.add(12);
            }
            bundle2 = bundle;
            if (LegacyConversions.hasAction(j4, 256L)) {
                builder4.addAll(5, 4);
            }
            if (LegacyConversions.hasAction(j4, 32L)) {
                builder4.addAll(9, 8);
            }
            if (LegacyConversions.hasAction(j4, 16L)) {
                builder4.addAll(7, 6);
            }
            if (LegacyConversions.hasAction(j4, 4194304L)) {
                builder4.add(13);
            }
            if (LegacyConversions.hasAction(j4, 1L)) {
                builder4.add(3);
            }
            if (i == 1) {
                builder4.addAll(26, 34);
            } else if (i == 2) {
                builder4.addAll(26, 34, 25, 33);
            }
            builder4.addAll(23, 17, 18, 16, 21, 32);
            if ((flags & j5) != j3) {
                builder4.add(20);
            }
            if (LegacyConversions.hasAction(j4, 4096L)) {
                builder4.add(10);
            }
            if (z2) {
                if (LegacyConversions.hasAction(j4, 262144L)) {
                    builder4.add(15);
                }
                if (LegacyConversions.hasAction(j4, 2097152L)) {
                    builder4.add(14);
                }
            }
            commands = new Player.Commands(builder4.build());
            charSequence = legacyPlayerInfo3.queueTitle;
            charSequence2 = legacyPlayerInfo.queueTitle;
            if (charSequence == charSequence2) {
                mediaMetadata2 = ((PlayerInfo) quantizerWu2.weights).playlistMetadata;
            } else if (charSequence2 == null) {
                mediaMetadata2 = androidx.media3.common.MediaMetadata.EMPTY;
            } else {
                androidx.media3.common.MediaMetadata.Builder builder8 = new androidx.media3.common.MediaMetadata.Builder();
                builder8.title = charSequence2;
                mediaMetadata2 = new androidx.media3.common.MediaMetadata(builder8);
            }
            androidx.media3.common.MediaMetadata mediaMetadata6 = mediaMetadata2;
            iConvertToRepeatMode = LegacyConversions.convertToRepeatMode(legacyPlayerInfo.repeatMode);
            zConvertToShuffleModeEnabled = LegacyConversions.convertToShuffleModeEnabled(legacyPlayerInfo.shuffleMode);
            if (playbackStateCompat == playbackStateCompat2) {
                hashSet = new HashSet();
                regularImmutableList = SessionCommand.SESSION_COMMANDS;
                while (i2 < regularImmutableList.size) {
                    hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                }
                if (!z2) {
                    while (r8.hasNext()) {
                        if (sessionCommand.commandCode == 40010) {
                            hashSet.remove(sessionCommand);
                        }
                    }
                }
                if (playbackStateCompat2 != null) {
                    while (r8.hasNext()) {
                        String str111 = customAction.action;
                        bundle5 = customAction.extras;
                        if (bundle5 == null) {
                            bundle5 = Bundle.EMPTY;
                        }
                        hashSet.add(new SessionCommand(str111, bundle5));
                    }
                }
                sessionCommands = new SessionCommands(hashSet);
                if (playbackStateCompat2 == null) {
                    ImmutableList.Itr itr6 = ImmutableList.EMPTY_ITR;
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                } else {
                    List list8 = playbackStateCompat2.customActions;
                    Maps.checkNonnegative(4, str);
                    objArrCopyOf = new Object[4];
                    it = list8.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        PlaybackStateCompat.CustomAction customAction7 = (PlaybackStateCompat.CustomAction) it.next();
                        String str112 = customAction7.action;
                        int i114 = iConvertToRepeatMode;
                        bundle3 = customAction7.extras;
                        if (bundle3 != null) {
                            i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                        } else {
                            i5 = 0;
                        }
                        SessionCommands sessionCommands15 = sessionCommands;
                        builder = new CommandButton.Builder(i5, customAction7.icon);
                        if (bundle3 == null) {
                            bundle4 = Bundle.EMPTY;
                        } else {
                            bundle4 = bundle3;
                        }
                        builder.setSessionCommand(new SessionCommand(str112, bundle4));
                        builder.displayName = customAction7.name;
                        builder.enabled = true;
                        if (bundle3 != null) {
                            builder.extras = new Bundle(bundle3);
                        }
                        if (bundle3 != null) {
                            string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                        } else {
                            string = null;
                        }
                        if (string != null) {
                            uri = Uri.parse(string);
                            scheme = uri.getScheme();
                            if (Objects.equals(scheme, "content")) {
                                builder.setIconUri(uri);
                            } else {
                                builder.setIconUri(uri);
                            }
                        }
                        CommandButton commandButtonBuild6 = builder.build();
                        int i2112 = i3 + 1;
                        iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i2112);
                        if (iExpandedCapacity > objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                        }
                        objArrCopyOf[i3] = commandButtonBuild6;
                        i3 = i2112;
                        iConvertToRepeatMode = i114;
                        zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                        it = it;
                        sessionCommands = sessionCommands15;
                    }
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                }
                sessionCommands3 = sessionCommands2;
            } else {
                hashSet = new HashSet();
                regularImmutableList = SessionCommand.SESSION_COMMANDS;
                while (i2 < regularImmutableList.size) {
                    hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                }
                if (!z2) {
                    while (r8.hasNext()) {
                        if (sessionCommand.commandCode == 40010) {
                            hashSet.remove(sessionCommand);
                        }
                    }
                }
                if (playbackStateCompat2 != null) {
                    while (r8.hasNext()) {
                        String str113 = customAction.action;
                        bundle5 = customAction.extras;
                        if (bundle5 == null) {
                            bundle5 = Bundle.EMPTY;
                        }
                        hashSet.add(new SessionCommand(str113, bundle5));
                    }
                }
                sessionCommands = new SessionCommands(hashSet);
                if (playbackStateCompat2 == null) {
                    ImmutableList.Itr itr7 = ImmutableList.EMPTY_ITR;
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                } else {
                    List list9 = playbackStateCompat2.customActions;
                    Maps.checkNonnegative(4, str);
                    objArrCopyOf = new Object[4];
                    it = list9.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        PlaybackStateCompat.CustomAction customAction8 = (PlaybackStateCompat.CustomAction) it.next();
                        String str114 = customAction8.action;
                        int i115 = iConvertToRepeatMode;
                        bundle3 = customAction8.extras;
                        if (bundle3 != null) {
                            i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                        } else {
                            i5 = 0;
                        }
                        SessionCommands sessionCommands16 = sessionCommands;
                        builder = new CommandButton.Builder(i5, customAction8.icon);
                        if (bundle3 == null) {
                            bundle4 = Bundle.EMPTY;
                        } else {
                            bundle4 = bundle3;
                        }
                        builder.setSessionCommand(new SessionCommand(str114, bundle4));
                        builder.displayName = customAction8.name;
                        builder.enabled = true;
                        if (bundle3 != null) {
                            builder.extras = new Bundle(bundle3);
                        }
                        if (bundle3 != null) {
                            string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                        } else {
                            string = null;
                        }
                        if (string != null) {
                            uri = Uri.parse(string);
                            scheme = uri.getScheme();
                            if (Objects.equals(scheme, "content")) {
                                builder.setIconUri(uri);
                            } else {
                                builder.setIconUri(uri);
                            }
                        }
                        CommandButton commandButtonBuild7 = builder.build();
                        int i2113 = i3 + 1;
                        iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i2113);
                        if (iExpandedCapacity > objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                        }
                        objArrCopyOf[i3] = commandButtonBuild7;
                        i3 = i2113;
                        iConvertToRepeatMode = i115;
                        zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                        it = it;
                        sessionCommands = sessionCommands16;
                    }
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                }
                sessionCommands3 = sessionCommands2;
            }
            Context context4 = this.context;
            playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat2, context4);
            if (playbackStateCompat2 == null) {
                i6 = playbackStateCompat2.state;
                int i2114 = playbackStateCompat2.errorCode;
                CharSequence charSequence7 = playbackStateCompat2.errorMessage;
                Bundle bundle17 = playbackStateCompat2.extras;
                commands2 = commands;
                if (i6 == 7) {
                }
                long jConvertToCurrentPositionMs9 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                long jConvertToBufferedPositionMs13 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                SessionCommands sessionCommands17 = sessionCommands3;
                ImmutableList immutableList10 = mediaButtonPreferencesFromCustomLayout;
                SessionError sessionError8 = sessionError;
                int iCalculateBufferedPercentage7 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                long jConvertToBufferedPositionMs14 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                if (mediaMetadataCompat3 == null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (playbackStateCompat2 == null) {
                    playbackParameters = PlaybackParameters.DEFAULT;
                } else {
                    playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                }
                if (mediaControllerCompat$PlaybackInfo2 == 0) {
                    audioAttributes = AudioAttributes.DEFAULT;
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                } else {
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                    audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                }
                if (playbackStateCompat2 == null) {
                    switch (playbackStateCompat2.state) {
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            z8 = true;
                            break;
                        case 7:
                        case 8:
                        default:
                            z8 = false;
                            break;
                    }
                } else {
                    z8 = false;
                }
                if (playbackStateCompat2 == null) {
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    i7 = 1;
                } else {
                    i8 = playbackStateCompat2.state;
                    jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                    if (jConvertToDurationMs == -9223372036854775807L) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    switch (i8) {
                        case 0:
                        case 7:
                        case 8:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 1;
                            break;
                        case 1:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 1;
                            }
                            break;
                        case 2:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 3;
                            }
                            break;
                        case 3:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 2;
                            break;
                        default:
                            throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                    }
                }
                int i2115 = i7;
                if (playbackStateCompat2 == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    deviceInfoBuild = DeviceInfo.UNKNOWN;
                } else {
                    if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                        i9 = 1;
                    } else {
                        i9 = 0;
                    }
                    GapBuffer gapBuffer8 = new GapBuffer(i9);
                    gapBuffer8.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                    String str115 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                    if (i9 == 0) {
                        z11 = true;
                    } else {
                        z11 = true;
                    }
                    UtilsKt.checkArgument(z11);
                    gapBuffer8.buffer = str115;
                    deviceInfoBuild = gapBuffer8.build();
                }
                DeviceInfo deviceInfo8 = deviceInfoBuild;
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    i10 = 0;
                } else {
                    i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                PlayerInfo playerInfo10 = (PlayerInfo) quantizerWu2.weights;
                long j1113 = playerInfo10.seekBackIncrementMs;
                long j1114 = playerInfo10.seekForwardIncrementMs;
                long j1115 = playerInfo10.maxSeekToPreviousPositionMs;
                Bundle bundle18 = legacyPlayerInfo.sessionExtras;
                if (windowCount >= queueTimeline2.getWindowCount()) {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = null;
                } else {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                }
                SessionPositionInfo sessionPositionInfo8 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs9, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs13, iCalculateBufferedPercentage7, jConvertToBufferedPositionMs14, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs13);
                Player.PositionInfo positionInfo8 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                int i2116 = i4;
                playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo8, positionInfo8, positionInfo8, 0, playbackParameters, i2116, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata6, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo8, i10, z12, z8, 1, 0, i2115, z10, false, mediaMetadata, j1113, j1114, j1115, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                QuantizerWu quantizerWu10 = new QuantizerWu(playerInfo, sessionCommands17, commands2, immutableList10, bundle18, sessionError8);
                legacyPlayerInfo2 = this.legacyPlayerInfo;
                quantizerWu = this.controllerInfo;
                j6 = mediaController.timeDiffMs;
                zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                boolean zIsEmpty9 = queueTimeline3.isEmpty();
                if (!zIsEmpty) {
                    if (zIsEmpty) {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    } else {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    }
                } else if (zIsEmpty) {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                } else {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                }
                Pair pairCreate9 = Pair.create(num2, num);
                updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu10, (Integer) pairCreate9.first, (Integer) pairCreate9.second);
                if (this.hasPendingExtrasChange) {
                    this.hasPendingExtrasChange = false;
                    if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                        z14 = false;
                    }
                    UtilsKt.checkState(z14);
                    mediaController.listener.getClass();
                }
            }
            commands2 = commands;
            sessionError = null;
            long jConvertToCurrentPositionMs10 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            long jConvertToBufferedPositionMs15 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            SessionCommands sessionCommands18 = sessionCommands3;
            ImmutableList immutableList11 = mediaButtonPreferencesFromCustomLayout;
            SessionError sessionError9 = sessionError;
            int iCalculateBufferedPercentage8 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
            long jConvertToBufferedPositionMs16 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            if (mediaMetadataCompat3 == null) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (playbackStateCompat2 == null) {
                playbackParameters = PlaybackParameters.DEFAULT;
            } else {
                playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
            }
            if (mediaControllerCompat$PlaybackInfo2 == 0) {
                audioAttributes = AudioAttributes.DEFAULT;
                mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
            } else {
                mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
            }
            if (playbackStateCompat2 == null) {
                switch (playbackStateCompat2.state) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        z8 = true;
                        break;
                    case 7:
                    case 8:
                    default:
                        z8 = false;
                        break;
                }
            } else {
                z8 = false;
            }
            if (playbackStateCompat2 == null) {
                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                i7 = 1;
            } else {
                i8 = playbackStateCompat2.state;
                jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                if (jConvertToDurationMs == -9223372036854775807L) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                switch (i8) {
                    case 0:
                    case 7:
                    case 8:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 1;
                        break;
                    case 1:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        if (z9) {
                            i7 = 4;
                        } else {
                            i7 = 1;
                        }
                        break;
                    case 2:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        if (z9) {
                            i7 = 4;
                        } else {
                            i7 = 3;
                        }
                        break;
                    case 3:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 3;
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 2;
                        break;
                    default:
                        throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                }
            }
            int i2117 = i7;
            if (playbackStateCompat2 == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                deviceInfoBuild = DeviceInfo.UNKNOWN;
            } else {
                if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                    i9 = 1;
                } else {
                    i9 = 0;
                }
                GapBuffer gapBuffer9 = new GapBuffer(i9);
                gapBuffer9.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                String str116 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                if (i9 == 0) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                UtilsKt.checkArgument(z11);
                gapBuffer9.buffer = str116;
                deviceInfoBuild = gapBuffer9.build();
            }
            DeviceInfo deviceInfo9 = deviceInfoBuild;
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                i10 = 0;
            } else {
                i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
            }
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            PlayerInfo playerInfo11 = (PlayerInfo) quantizerWu2.weights;
            long j1116 = playerInfo11.seekBackIncrementMs;
            long j1117 = playerInfo11.seekForwardIncrementMs;
            long j1118 = playerInfo11.maxSeekToPreviousPositionMs;
            Bundle bundle19 = legacyPlayerInfo.sessionExtras;
            if (windowCount >= queueTimeline2.getWindowCount()) {
                queueTimeline3 = queueTimeline2;
                mediaItem2 = null;
            } else {
                queueTimeline3 = queueTimeline2;
                mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
            }
            SessionPositionInfo sessionPositionInfo9 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs10, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs15, iCalculateBufferedPercentage8, jConvertToBufferedPositionMs16, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs15);
            Player.PositionInfo positionInfo9 = SessionPositionInfo.DEFAULT_POSITION_INFO;
            int i2118 = i4;
            playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo9, positionInfo9, positionInfo9, 0, playbackParameters, i2118, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata6, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo9, i10, z12, z8, 1, 0, i2117, z10, false, mediaMetadata, j1116, j1117, j1118, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
            QuantizerWu quantizerWu11 = new QuantizerWu(playerInfo, sessionCommands18, commands2, immutableList11, bundle19, sessionError9);
            legacyPlayerInfo2 = this.legacyPlayerInfo;
            quantizerWu = this.controllerInfo;
            j6 = mediaController.timeDiffMs;
            zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
            boolean zIsEmpty10 = queueTimeline3.isEmpty();
            if (!zIsEmpty) {
                if (zIsEmpty) {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                } else {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                }
            } else if (zIsEmpty) {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            } else {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            }
            Pair pairCreate10 = Pair.create(num2, num);
            updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu11, (Integer) pairCreate10.first, (Integer) pairCreate10.second);
            if (this.hasPendingExtrasChange) {
                this.hasPendingExtrasChange = false;
                if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                    z14 = false;
                }
                UtilsKt.checkState(z14);
                mediaController.listener.getClass();
            }
        }
        queueTimeline2 = queueTimeline;
        z5 = false;
        if (LegacyConversions.hasAction(j4, 4L)) {
            j5 = 4;
            if (LegacyConversions.hasAction(j4, 2L)) {
                builder4.add(1);
            } else {
                builder4.add(1);
            }
        } else {
            j5 = 4;
            if (LegacyConversions.hasAction(j4, 2L)) {
                builder4.add(1);
            } else {
                builder4.add(1);
            }
        }
        if (LegacyConversions.hasAction(j4, 1024L)) {
            builder4.add(31);
        } else {
            builder4.add(31);
        }
        if (!LegacyConversions.hasAction(j4, 16384L)) {
            bundle = bundle6;
            if (!LegacyConversions.hasAction(j4, 32768L)) {
            }
            if (LegacyConversions.hasAction(j4, 8L)) {
                builder4.add(11);
            }
            if (LegacyConversions.hasAction(j4, 64L)) {
                builder4.add(12);
            }
            bundle2 = bundle;
            if (LegacyConversions.hasAction(j4, 256L)) {
                builder4.addAll(5, 4);
            }
            if (LegacyConversions.hasAction(j4, 32L)) {
                builder4.addAll(9, 8);
            }
            if (LegacyConversions.hasAction(j4, 16L)) {
                builder4.addAll(7, 6);
            }
            if (LegacyConversions.hasAction(j4, 4194304L)) {
                builder4.add(13);
            }
            if (LegacyConversions.hasAction(j4, 1L)) {
                builder4.add(3);
            }
            if (i == 1) {
                builder4.addAll(26, 34);
            } else if (i == 2) {
                builder4.addAll(26, 34, 25, 33);
            }
            builder4.addAll(23, 17, 18, 16, 21, 32);
            if ((flags & j5) != j3) {
                builder4.add(20);
            }
            if (LegacyConversions.hasAction(j4, 4096L)) {
                builder4.add(10);
            }
            if (z2) {
                if (LegacyConversions.hasAction(j4, 262144L)) {
                    builder4.add(15);
                }
                if (LegacyConversions.hasAction(j4, 2097152L)) {
                    builder4.add(14);
                }
            }
            commands = new Player.Commands(builder4.build());
            charSequence = legacyPlayerInfo3.queueTitle;
            charSequence2 = legacyPlayerInfo.queueTitle;
            if (charSequence == charSequence2) {
                mediaMetadata2 = ((PlayerInfo) quantizerWu2.weights).playlistMetadata;
            } else if (charSequence2 == null) {
                mediaMetadata2 = androidx.media3.common.MediaMetadata.EMPTY;
            } else {
                androidx.media3.common.MediaMetadata.Builder builder9 = new androidx.media3.common.MediaMetadata.Builder();
                builder9.title = charSequence2;
                mediaMetadata2 = new androidx.media3.common.MediaMetadata(builder9);
            }
            androidx.media3.common.MediaMetadata mediaMetadata7 = mediaMetadata2;
            iConvertToRepeatMode = LegacyConversions.convertToRepeatMode(legacyPlayerInfo.repeatMode);
            zConvertToShuffleModeEnabled = LegacyConversions.convertToShuffleModeEnabled(legacyPlayerInfo.shuffleMode);
            if (playbackStateCompat == playbackStateCompat2) {
                hashSet = new HashSet();
                regularImmutableList = SessionCommand.SESSION_COMMANDS;
                while (i2 < regularImmutableList.size) {
                    hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                }
                if (!z2) {
                    while (r8.hasNext()) {
                        if (sessionCommand.commandCode == 40010) {
                            hashSet.remove(sessionCommand);
                        }
                    }
                }
                if (playbackStateCompat2 != null) {
                    while (r8.hasNext()) {
                        String str117 = customAction.action;
                        bundle5 = customAction.extras;
                        if (bundle5 == null) {
                            bundle5 = Bundle.EMPTY;
                        }
                        hashSet.add(new SessionCommand(str117, bundle5));
                    }
                }
                sessionCommands = new SessionCommands(hashSet);
                if (playbackStateCompat2 == null) {
                    ImmutableList.Itr itr8 = ImmutableList.EMPTY_ITR;
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                } else {
                    List list10 = playbackStateCompat2.customActions;
                    Maps.checkNonnegative(4, str);
                    objArrCopyOf = new Object[4];
                    it = list10.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        PlaybackStateCompat.CustomAction customAction9 = (PlaybackStateCompat.CustomAction) it.next();
                        String str118 = customAction9.action;
                        int i116 = iConvertToRepeatMode;
                        bundle3 = customAction9.extras;
                        if (bundle3 != null) {
                            i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                        } else {
                            i5 = 0;
                        }
                        SessionCommands sessionCommands19 = sessionCommands;
                        builder = new CommandButton.Builder(i5, customAction9.icon);
                        if (bundle3 == null) {
                            bundle4 = Bundle.EMPTY;
                        } else {
                            bundle4 = bundle3;
                        }
                        builder.setSessionCommand(new SessionCommand(str118, bundle4));
                        builder.displayName = customAction9.name;
                        builder.enabled = true;
                        if (bundle3 != null) {
                            builder.extras = new Bundle(bundle3);
                        }
                        if (bundle3 != null) {
                            string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                        } else {
                            string = null;
                        }
                        if (string != null) {
                            uri = Uri.parse(string);
                            scheme = uri.getScheme();
                            if (Objects.equals(scheme, "content")) {
                                builder.setIconUri(uri);
                            } else {
                                builder.setIconUri(uri);
                            }
                        }
                        CommandButton commandButtonBuild8 = builder.build();
                        int i2119 = i3 + 1;
                        iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i2119);
                        if (iExpandedCapacity > objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                        }
                        objArrCopyOf[i3] = commandButtonBuild8;
                        i3 = i2119;
                        iConvertToRepeatMode = i116;
                        zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                        it = it;
                        sessionCommands = sessionCommands19;
                    }
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                }
                sessionCommands3 = sessionCommands2;
            } else {
                hashSet = new HashSet();
                regularImmutableList = SessionCommand.SESSION_COMMANDS;
                while (i2 < regularImmutableList.size) {
                    hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
                }
                if (!z2) {
                    while (r8.hasNext()) {
                        if (sessionCommand.commandCode == 40010) {
                            hashSet.remove(sessionCommand);
                        }
                    }
                }
                if (playbackStateCompat2 != null) {
                    while (r8.hasNext()) {
                        String str119 = customAction.action;
                        bundle5 = customAction.extras;
                        if (bundle5 == null) {
                            bundle5 = Bundle.EMPTY;
                        }
                        hashSet.add(new SessionCommand(str119, bundle5));
                    }
                }
                sessionCommands = new SessionCommands(hashSet);
                if (playbackStateCompat2 == null) {
                    ImmutableList.Itr itr9 = ImmutableList.EMPTY_ITR;
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
                } else {
                    List list11 = playbackStateCompat2.customActions;
                    Maps.checkNonnegative(4, str);
                    objArrCopyOf = new Object[4];
                    it = list11.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        PlaybackStateCompat.CustomAction customAction10 = (PlaybackStateCompat.CustomAction) it.next();
                        String str1110 = customAction10.action;
                        int i117 = iConvertToRepeatMode;
                        bundle3 = customAction10.extras;
                        if (bundle3 != null) {
                            i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                        } else {
                            i5 = 0;
                        }
                        SessionCommands sessionCommands110 = sessionCommands;
                        builder = new CommandButton.Builder(i5, customAction10.icon);
                        if (bundle3 == null) {
                            bundle4 = Bundle.EMPTY;
                        } else {
                            bundle4 = bundle3;
                        }
                        builder.setSessionCommand(new SessionCommand(str1110, bundle4));
                        builder.displayName = customAction10.name;
                        builder.enabled = true;
                        if (bundle3 != null) {
                            builder.extras = new Bundle(bundle3);
                        }
                        if (bundle3 != null) {
                            string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                        } else {
                            string = null;
                        }
                        if (string != null) {
                            uri = Uri.parse(string);
                            scheme = uri.getScheme();
                            if (Objects.equals(scheme, "content")) {
                                builder.setIconUri(uri);
                            } else {
                                builder.setIconUri(uri);
                            }
                        }
                        CommandButton commandButtonBuild9 = builder.build();
                        int i21110 = i3 + 1;
                        iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i21110);
                        if (iExpandedCapacity > objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                        }
                        objArrCopyOf[i3] = commandButtonBuild9;
                        i3 = i21110;
                        iConvertToRepeatMode = i117;
                        zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                        it = it;
                        sessionCommands = sessionCommands110;
                    }
                    i4 = iConvertToRepeatMode;
                    z6 = zConvertToShuffleModeEnabled;
                    sessionCommands2 = sessionCommands;
                    mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
                }
                sessionCommands3 = sessionCommands2;
            }
            Context context5 = this.context;
            playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat2, context5);
            if (playbackStateCompat2 == null) {
                i6 = playbackStateCompat2.state;
                int i21111 = playbackStateCompat2.errorCode;
                CharSequence charSequence8 = playbackStateCompat2.errorMessage;
                Bundle bundle110 = playbackStateCompat2.extras;
                commands2 = commands;
                if (i6 == 7) {
                }
                long jConvertToCurrentPositionMs11 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                long jConvertToBufferedPositionMs17 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                SessionCommands sessionCommands111 = sessionCommands3;
                ImmutableList immutableList12 = mediaButtonPreferencesFromCustomLayout;
                SessionError sessionError10 = sessionError;
                int iCalculateBufferedPercentage9 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
                long jConvertToBufferedPositionMs18 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
                if (mediaMetadataCompat3 == null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (playbackStateCompat2 == null) {
                    playbackParameters = PlaybackParameters.DEFAULT;
                } else {
                    playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
                }
                if (mediaControllerCompat$PlaybackInfo2 == 0) {
                    audioAttributes = AudioAttributes.DEFAULT;
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                } else {
                    mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                    audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
                }
                if (playbackStateCompat2 == null) {
                    switch (playbackStateCompat2.state) {
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            z8 = true;
                            break;
                        case 7:
                        case 8:
                        default:
                            z8 = false;
                            break;
                    }
                } else {
                    z8 = false;
                }
                if (playbackStateCompat2 == null) {
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    i7 = 1;
                } else {
                    i8 = playbackStateCompat2.state;
                    jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                    if (jConvertToDurationMs == -9223372036854775807L) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    switch (i8) {
                        case 0:
                        case 7:
                        case 8:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 1;
                            break;
                        case 1:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 1;
                            }
                            break;
                        case 2:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            if (z9) {
                                i7 = 4;
                            } else {
                                i7 = 3;
                            }
                            break;
                        case 3:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 11:
                            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                            i7 = 2;
                            break;
                        default:
                            throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                    }
                }
                int i21112 = i7;
                if (playbackStateCompat2 == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    deviceInfoBuild = DeviceInfo.UNKNOWN;
                } else {
                    if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                        i9 = 1;
                    } else {
                        i9 = 0;
                    }
                    GapBuffer gapBuffer10 = new GapBuffer(i9);
                    gapBuffer10.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                    String str1111 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                    if (i9 == 0) {
                        z11 = true;
                    } else {
                        z11 = true;
                    }
                    UtilsKt.checkArgument(z11);
                    gapBuffer10.buffer = str1111;
                    deviceInfoBuild = gapBuffer10.build();
                }
                DeviceInfo deviceInfo10 = deviceInfoBuild;
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    i10 = 0;
                } else {
                    i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
                }
                if (mediaControllerCompat$PlaybackInfo3 == null) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                PlayerInfo playerInfo12 = (PlayerInfo) quantizerWu2.weights;
                long j1119 = playerInfo12.seekBackIncrementMs;
                long j11110 = playerInfo12.seekForwardIncrementMs;
                long j11111 = playerInfo12.maxSeekToPreviousPositionMs;
                Bundle bundle111 = legacyPlayerInfo.sessionExtras;
                if (windowCount >= queueTimeline2.getWindowCount()) {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = null;
                } else {
                    queueTimeline3 = queueTimeline2;
                    mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
                }
                SessionPositionInfo sessionPositionInfo10 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs11, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs17, iCalculateBufferedPercentage9, jConvertToBufferedPositionMs18, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs17);
                Player.PositionInfo positionInfo10 = SessionPositionInfo.DEFAULT_POSITION_INFO;
                int i21113 = i4;
                playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo10, positionInfo10, positionInfo10, 0, playbackParameters, i21113, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata7, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo10, i10, z12, z8, 1, 0, i21112, z10, false, mediaMetadata, j1119, j11110, j11111, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
                QuantizerWu quantizerWu12 = new QuantizerWu(playerInfo, sessionCommands111, commands2, immutableList12, bundle111, sessionError10);
                legacyPlayerInfo2 = this.legacyPlayerInfo;
                quantizerWu = this.controllerInfo;
                j6 = mediaController.timeDiffMs;
                zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
                boolean zIsEmpty11 = queueTimeline3.isEmpty();
                if (!zIsEmpty) {
                    if (zIsEmpty) {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    } else {
                        currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                        currentMediaItem.getClass();
                        queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                        if (queuedMediaItem2 == null) {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        } else {
                            i11 = 0;
                            while (true) {
                                immutableList2 = queueTimeline3.queuedMediaItems;
                                if (i11 >= immutableList2.size()) {
                                    z13 = false;
                                } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                    z13 = true;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (z13) {
                            num2 = 4;
                            num = 3;
                        } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                            jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                            jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                            if (jConvertToCurrentPositionMs2 == j3) {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            } else {
                                if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                    num2 = 5;
                                } else {
                                    num2 = null;
                                }
                                num3 = null;
                            }
                            num = num3;
                        } else {
                            z14 = true;
                            num = 1;
                            num2 = 0;
                        }
                        z14 = true;
                    }
                } else if (zIsEmpty) {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                } else {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                }
                Pair pairCreate11 = Pair.create(num2, num);
                updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu12, (Integer) pairCreate11.first, (Integer) pairCreate11.second);
                if (this.hasPendingExtrasChange) {
                    this.hasPendingExtrasChange = false;
                    if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                        z14 = false;
                    }
                    UtilsKt.checkState(z14);
                    mediaController.listener.getClass();
                }
            }
            commands2 = commands;
            sessionError = null;
            long jConvertToCurrentPositionMs12 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            long jConvertToBufferedPositionMs19 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            SessionCommands sessionCommands112 = sessionCommands3;
            ImmutableList immutableList13 = mediaButtonPreferencesFromCustomLayout;
            SessionError sessionError11 = sessionError;
            int iCalculateBufferedPercentage10 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
            long jConvertToBufferedPositionMs110 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            if (mediaMetadataCompat3 == null) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (playbackStateCompat2 == null) {
                playbackParameters = PlaybackParameters.DEFAULT;
            } else {
                playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
            }
            if (mediaControllerCompat$PlaybackInfo2 == 0) {
                audioAttributes = AudioAttributes.DEFAULT;
                mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
            } else {
                mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
            }
            if (playbackStateCompat2 == null) {
                switch (playbackStateCompat2.state) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        z8 = true;
                        break;
                    case 7:
                    case 8:
                    default:
                        z8 = false;
                        break;
                }
            } else {
                z8 = false;
            }
            if (playbackStateCompat2 == null) {
                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                i7 = 1;
            } else {
                i8 = playbackStateCompat2.state;
                jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                if (jConvertToDurationMs == -9223372036854775807L) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                switch (i8) {
                    case 0:
                    case 7:
                    case 8:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 1;
                        break;
                    case 1:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        if (z9) {
                            i7 = 4;
                        } else {
                            i7 = 1;
                        }
                        break;
                    case 2:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        if (z9) {
                            i7 = 4;
                        } else {
                            i7 = 3;
                        }
                        break;
                    case 3:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 3;
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 2;
                        break;
                    default:
                        throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                }
            }
            int i21114 = i7;
            if (playbackStateCompat2 == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                deviceInfoBuild = DeviceInfo.UNKNOWN;
            } else {
                if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                    i9 = 1;
                } else {
                    i9 = 0;
                }
                GapBuffer gapBuffer11 = new GapBuffer(i9);
                gapBuffer11.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                String str1112 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                if (i9 == 0) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                UtilsKt.checkArgument(z11);
                gapBuffer11.buffer = str1112;
                deviceInfoBuild = gapBuffer11.build();
            }
            DeviceInfo deviceInfo11 = deviceInfoBuild;
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                i10 = 0;
            } else {
                i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
            }
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            PlayerInfo playerInfo13 = (PlayerInfo) quantizerWu2.weights;
            long j11112 = playerInfo13.seekBackIncrementMs;
            long j11113 = playerInfo13.seekForwardIncrementMs;
            long j11114 = playerInfo13.maxSeekToPreviousPositionMs;
            Bundle bundle112 = legacyPlayerInfo.sessionExtras;
            if (windowCount >= queueTimeline2.getWindowCount()) {
                queueTimeline3 = queueTimeline2;
                mediaItem2 = null;
            } else {
                queueTimeline3 = queueTimeline2;
                mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
            }
            SessionPositionInfo sessionPositionInfo11 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs12, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs19, iCalculateBufferedPercentage10, jConvertToBufferedPositionMs110, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs19);
            Player.PositionInfo positionInfo11 = SessionPositionInfo.DEFAULT_POSITION_INFO;
            int i21115 = i4;
            playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo11, positionInfo11, positionInfo11, 0, playbackParameters, i21115, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata7, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo11, i10, z12, z8, 1, 0, i21114, z10, false, mediaMetadata, j11112, j11113, j11114, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
            QuantizerWu quantizerWu13 = new QuantizerWu(playerInfo, sessionCommands112, commands2, immutableList13, bundle112, sessionError11);
            legacyPlayerInfo2 = this.legacyPlayerInfo;
            quantizerWu = this.controllerInfo;
            j6 = mediaController.timeDiffMs;
            zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
            boolean zIsEmpty12 = queueTimeline3.isEmpty();
            if (!zIsEmpty) {
                if (zIsEmpty) {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                } else {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                }
            } else if (zIsEmpty) {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            } else {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            }
            Pair pairCreate12 = Pair.create(num2, num);
            updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu13, (Integer) pairCreate12.first, (Integer) pairCreate12.second);
            if (this.hasPendingExtrasChange) {
                this.hasPendingExtrasChange = false;
                if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                    z14 = false;
                }
                UtilsKt.checkState(z14);
                mediaController.listener.getClass();
            }
        }
        bundle = bundle6;
        builder4.add(2);
        if (LegacyConversions.hasAction(j4, 8L)) {
            builder4.add(11);
        }
        if (LegacyConversions.hasAction(j4, 64L)) {
            builder4.add(12);
        }
        bundle2 = bundle;
        if (LegacyConversions.hasAction(j4, 256L)) {
            builder4.addAll(5, 4);
        }
        if (LegacyConversions.hasAction(j4, 32L)) {
            builder4.addAll(9, 8);
        }
        if (LegacyConversions.hasAction(j4, 16L)) {
            builder4.addAll(7, 6);
        }
        if (LegacyConversions.hasAction(j4, 4194304L)) {
            builder4.add(13);
        }
        if (LegacyConversions.hasAction(j4, 1L)) {
            builder4.add(3);
        }
        if (i == 1) {
            builder4.addAll(26, 34);
        } else if (i == 2) {
            builder4.addAll(26, 34, 25, 33);
        }
        builder4.addAll(23, 17, 18, 16, 21, 32);
        if ((flags & j5) != j3) {
            builder4.add(20);
        }
        if (LegacyConversions.hasAction(j4, 4096L)) {
            builder4.add(10);
        }
        if (z2) {
            if (LegacyConversions.hasAction(j4, 262144L)) {
                builder4.add(15);
            }
            if (LegacyConversions.hasAction(j4, 2097152L)) {
                builder4.add(14);
            }
        }
        commands = new Player.Commands(builder4.build());
        charSequence = legacyPlayerInfo3.queueTitle;
        charSequence2 = legacyPlayerInfo.queueTitle;
        if (charSequence == charSequence2) {
            mediaMetadata2 = ((PlayerInfo) quantizerWu2.weights).playlistMetadata;
        } else if (charSequence2 == null) {
            mediaMetadata2 = androidx.media3.common.MediaMetadata.EMPTY;
        } else {
            androidx.media3.common.MediaMetadata.Builder builder10 = new androidx.media3.common.MediaMetadata.Builder();
            builder10.title = charSequence2;
            mediaMetadata2 = new androidx.media3.common.MediaMetadata(builder10);
        }
        androidx.media3.common.MediaMetadata mediaMetadata8 = mediaMetadata2;
        iConvertToRepeatMode = LegacyConversions.convertToRepeatMode(legacyPlayerInfo.repeatMode);
        zConvertToShuffleModeEnabled = LegacyConversions.convertToShuffleModeEnabled(legacyPlayerInfo.shuffleMode);
        if (playbackStateCompat == playbackStateCompat2) {
            hashSet = new HashSet();
            regularImmutableList = SessionCommand.SESSION_COMMANDS;
            while (i2 < regularImmutableList.size) {
                hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
            }
            if (!z2) {
                while (r8.hasNext()) {
                    if (sessionCommand.commandCode == 40010) {
                        hashSet.remove(sessionCommand);
                    }
                }
            }
            if (playbackStateCompat2 != null) {
                while (r8.hasNext()) {
                    String str1113 = customAction.action;
                    bundle5 = customAction.extras;
                    if (bundle5 == null) {
                        bundle5 = Bundle.EMPTY;
                    }
                    hashSet.add(new SessionCommand(str1113, bundle5));
                }
            }
            sessionCommands = new SessionCommands(hashSet);
            if (playbackStateCompat2 == null) {
                ImmutableList.Itr itr10 = ImmutableList.EMPTY_ITR;
                i4 = iConvertToRepeatMode;
                z6 = zConvertToShuffleModeEnabled;
                sessionCommands2 = sessionCommands;
                mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
            } else {
                List list12 = playbackStateCompat2.customActions;
                Maps.checkNonnegative(4, str);
                objArrCopyOf = new Object[4];
                it = list12.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    PlaybackStateCompat.CustomAction customAction11 = (PlaybackStateCompat.CustomAction) it.next();
                    String str1114 = customAction11.action;
                    int i118 = iConvertToRepeatMode;
                    bundle3 = customAction11.extras;
                    if (bundle3 != null) {
                        i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                    } else {
                        i5 = 0;
                    }
                    SessionCommands sessionCommands113 = sessionCommands;
                    builder = new CommandButton.Builder(i5, customAction11.icon);
                    if (bundle3 == null) {
                        bundle4 = Bundle.EMPTY;
                    } else {
                        bundle4 = bundle3;
                    }
                    builder.setSessionCommand(new SessionCommand(str1114, bundle4));
                    builder.displayName = customAction11.name;
                    builder.enabled = true;
                    if (bundle3 != null) {
                        builder.extras = new Bundle(bundle3);
                    }
                    if (bundle3 != null) {
                        string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                    } else {
                        string = null;
                    }
                    if (string != null) {
                        uri = Uri.parse(string);
                        scheme = uri.getScheme();
                        if (Objects.equals(scheme, "content")) {
                            builder.setIconUri(uri);
                        } else {
                            builder.setIconUri(uri);
                        }
                    }
                    CommandButton commandButtonBuild10 = builder.build();
                    int i21116 = i3 + 1;
                    iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i21116);
                    if (iExpandedCapacity > objArrCopyOf.length) {
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                    }
                    objArrCopyOf[i3] = commandButtonBuild10;
                    i3 = i21116;
                    iConvertToRepeatMode = i118;
                    zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                    it = it;
                    sessionCommands = sessionCommands113;
                }
                i4 = iConvertToRepeatMode;
                z6 = zConvertToShuffleModeEnabled;
                sessionCommands2 = sessionCommands;
                mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
            }
            sessionCommands3 = sessionCommands2;
        } else {
            hashSet = new HashSet();
            regularImmutableList = SessionCommand.SESSION_COMMANDS;
            while (i2 < regularImmutableList.size) {
                hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i2)).intValue()));
            }
            if (!z2) {
                while (r8.hasNext()) {
                    if (sessionCommand.commandCode == 40010) {
                        hashSet.remove(sessionCommand);
                    }
                }
            }
            if (playbackStateCompat2 != null) {
                while (r8.hasNext()) {
                    String str1115 = customAction.action;
                    bundle5 = customAction.extras;
                    if (bundle5 == null) {
                        bundle5 = Bundle.EMPTY;
                    }
                    hashSet.add(new SessionCommand(str1115, bundle5));
                }
            }
            sessionCommands = new SessionCommands(hashSet);
            if (playbackStateCompat2 == null) {
                ImmutableList.Itr itr11 = ImmutableList.EMPTY_ITR;
                i4 = iConvertToRepeatMode;
                z6 = zConvertToShuffleModeEnabled;
                sessionCommands2 = sessionCommands;
                mediaButtonPreferencesFromCustomLayout = RegularImmutableList.EMPTY;
            } else {
                List list13 = playbackStateCompat2.customActions;
                Maps.checkNonnegative(4, str);
                objArrCopyOf = new Object[4];
                it = list13.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    PlaybackStateCompat.CustomAction customAction12 = (PlaybackStateCompat.CustomAction) it.next();
                    String str1116 = customAction12.action;
                    int i119 = iConvertToRepeatMode;
                    bundle3 = customAction12.extras;
                    if (bundle3 != null) {
                        i5 = bundle3.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0);
                    } else {
                        i5 = 0;
                    }
                    SessionCommands sessionCommands114 = sessionCommands;
                    builder = new CommandButton.Builder(i5, customAction12.icon);
                    if (bundle3 == null) {
                        bundle4 = Bundle.EMPTY;
                    } else {
                        bundle4 = bundle3;
                    }
                    builder.setSessionCommand(new SessionCommand(str1116, bundle4));
                    builder.displayName = customAction12.name;
                    builder.enabled = true;
                    if (bundle3 != null) {
                        builder.extras = new Bundle(bundle3);
                    }
                    if (bundle3 != null) {
                        string = bundle3.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT");
                    } else {
                        string = null;
                    }
                    if (string != null) {
                        uri = Uri.parse(string);
                        scheme = uri.getScheme();
                        if (Objects.equals(scheme, "content")) {
                            builder.setIconUri(uri);
                        } else {
                            builder.setIconUri(uri);
                        }
                    }
                    CommandButton commandButtonBuild11 = builder.build();
                    int i21117 = i3 + 1;
                    iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i21117);
                    if (iExpandedCapacity > objArrCopyOf.length) {
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                    }
                    objArrCopyOf[i3] = commandButtonBuild11;
                    i3 = i21117;
                    iConvertToRepeatMode = i119;
                    zConvertToShuffleModeEnabled = zConvertToShuffleModeEnabled;
                    it = it;
                    sessionCommands = sessionCommands114;
                }
                i4 = iConvertToRepeatMode;
                z6 = zConvertToShuffleModeEnabled;
                sessionCommands2 = sessionCommands;
                mediaButtonPreferencesFromCustomLayout = CommandButton.getMediaButtonPreferencesFromCustomLayout(ImmutableList.asImmutableList(i3, objArrCopyOf), commands, bundle2);
            }
            sessionCommands3 = sessionCommands2;
        }
        Context context6 = this.context;
        playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat2, context6);
        if (playbackStateCompat2 == null) {
            i6 = playbackStateCompat2.state;
            int i21118 = playbackStateCompat2.errorCode;
            CharSequence charSequence9 = playbackStateCompat2.errorMessage;
            Bundle bundle113 = playbackStateCompat2.extras;
            commands2 = commands;
            if (i6 == 7) {
            }
            long jConvertToCurrentPositionMs13 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            long jConvertToBufferedPositionMs111 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            SessionCommands sessionCommands115 = sessionCommands3;
            ImmutableList immutableList14 = mediaButtonPreferencesFromCustomLayout;
            SessionError sessionError12 = sessionError;
            int iCalculateBufferedPercentage11 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
            long jConvertToBufferedPositionMs112 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
            if (mediaMetadataCompat3 == null) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (playbackStateCompat2 == null) {
                playbackParameters = PlaybackParameters.DEFAULT;
            } else {
                playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
            }
            if (mediaControllerCompat$PlaybackInfo2 == 0) {
                audioAttributes = AudioAttributes.DEFAULT;
                mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
            } else {
                mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
                audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
            }
            if (playbackStateCompat2 == null) {
                switch (playbackStateCompat2.state) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        z8 = true;
                        break;
                    case 7:
                    case 8:
                    default:
                        z8 = false;
                        break;
                }
            } else {
                z8 = false;
            }
            if (playbackStateCompat2 == null) {
                playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                i7 = 1;
            } else {
                i8 = playbackStateCompat2.state;
                jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
                if (jConvertToDurationMs == -9223372036854775807L) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                switch (i8) {
                    case 0:
                    case 7:
                    case 8:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 1;
                        break;
                    case 1:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        if (z9) {
                            i7 = 4;
                        } else {
                            i7 = 1;
                        }
                        break;
                    case 2:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        if (z9) {
                            i7 = 4;
                        } else {
                            i7 = 3;
                        }
                        break;
                    case 3:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 3;
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                        i7 = 2;
                        break;
                    default:
                        throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
                }
            }
            int i21119 = i7;
            if (playbackStateCompat2 == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                deviceInfoBuild = DeviceInfo.UNKNOWN;
            } else {
                if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                    i9 = 1;
                } else {
                    i9 = 0;
                }
                GapBuffer gapBuffer12 = new GapBuffer(i9);
                gapBuffer12.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
                String str1117 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
                if (i9 == 0) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                UtilsKt.checkArgument(z11);
                gapBuffer12.buffer = str1117;
                deviceInfoBuild = gapBuffer12.build();
            }
            DeviceInfo deviceInfo12 = deviceInfoBuild;
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                i10 = 0;
            } else {
                i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
            }
            if (mediaControllerCompat$PlaybackInfo3 == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            PlayerInfo playerInfo14 = (PlayerInfo) quantizerWu2.weights;
            long j11115 = playerInfo14.seekBackIncrementMs;
            long j11116 = playerInfo14.seekForwardIncrementMs;
            long j11117 = playerInfo14.maxSeekToPreviousPositionMs;
            Bundle bundle114 = legacyPlayerInfo.sessionExtras;
            if (windowCount >= queueTimeline2.getWindowCount()) {
                queueTimeline3 = queueTimeline2;
                mediaItem2 = null;
            } else {
                queueTimeline3 = queueTimeline2;
                mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
            }
            SessionPositionInfo sessionPositionInfo12 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs13, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs111, iCalculateBufferedPercentage11, jConvertToBufferedPositionMs112, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs111);
            Player.PositionInfo positionInfo12 = SessionPositionInfo.DEFAULT_POSITION_INFO;
            int i211110 = i4;
            playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo12, positionInfo12, positionInfo12, 0, playbackParameters, i211110, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata8, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo12, i10, z12, z8, 1, 0, i21119, z10, false, mediaMetadata, j11115, j11116, j11117, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
            QuantizerWu quantizerWu14 = new QuantizerWu(playerInfo, sessionCommands115, commands2, immutableList14, bundle114, sessionError12);
            legacyPlayerInfo2 = this.legacyPlayerInfo;
            quantizerWu = this.controllerInfo;
            j6 = mediaController.timeDiffMs;
            zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
            boolean zIsEmpty13 = queueTimeline3.isEmpty();
            if (!zIsEmpty) {
                if (zIsEmpty) {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                } else {
                    currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                    currentMediaItem.getClass();
                    queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                    if (queuedMediaItem2 == null) {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = 0;
                        while (true) {
                            immutableList2 = queueTimeline3.queuedMediaItems;
                            if (i11 >= immutableList2.size()) {
                                z13 = false;
                            } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                                z13 = true;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (z13) {
                        num2 = 4;
                        num = 3;
                    } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                        jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                        jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                        if (jConvertToCurrentPositionMs2 == j3) {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        } else {
                            if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                                num2 = 5;
                            } else {
                                num2 = null;
                            }
                            num3 = null;
                        }
                        num = num3;
                    } else {
                        z14 = true;
                        num = 1;
                        num2 = 0;
                    }
                    z14 = true;
                }
            } else if (zIsEmpty) {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            } else {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            }
            Pair pairCreate13 = Pair.create(num2, num);
            updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu14, (Integer) pairCreate13.first, (Integer) pairCreate13.second);
            if (this.hasPendingExtrasChange) {
                this.hasPendingExtrasChange = false;
                if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                    z14 = false;
                }
                UtilsKt.checkState(z14);
                mediaController.listener.getClass();
            }
        }
        commands2 = commands;
        sessionError = null;
        long jConvertToCurrentPositionMs14 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
        long jConvertToBufferedPositionMs113 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
        SessionCommands sessionCommands116 = sessionCommands3;
        ImmutableList immutableList15 = mediaButtonPreferencesFromCustomLayout;
        SessionError sessionError13 = sessionError;
        int iCalculateBufferedPercentage12 = MediaUtils.calculateBufferedPercentage(LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7), LegacyConversions.convertToDurationMs(mediaMetadataCompat3));
        long jConvertToBufferedPositionMs114 = LegacyConversions.convertToBufferedPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7) - LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j7);
        if (mediaMetadataCompat3 == null) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (playbackStateCompat2 == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        } else {
            playbackParameters = new PlaybackParameters(playbackStateCompat2.speed);
        }
        if (mediaControllerCompat$PlaybackInfo2 == 0) {
            audioAttributes = AudioAttributes.DEFAULT;
            mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
        } else {
            mediaControllerCompat$PlaybackInfo3 = mediaControllerCompat$PlaybackInfo2;
            audioAttributes = mediaControllerCompat$PlaybackInfo3.audioAttributes;
        }
        if (playbackStateCompat2 == null) {
            switch (playbackStateCompat2.state) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                    z8 = true;
                    break;
                case 7:
                case 8:
                default:
                    z8 = false;
                    break;
            }
        } else {
            z8 = false;
        }
        if (playbackStateCompat2 == null) {
            playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
            i7 = 1;
        } else {
            i8 = playbackStateCompat2.state;
            jConvertToDurationMs = LegacyConversions.convertToDurationMs(mediaMetadataCompat3);
            if (jConvertToDurationMs == -9223372036854775807L) {
                z9 = false;
            } else {
                z9 = true;
            }
            switch (i8) {
                case 0:
                case 7:
                case 8:
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    i7 = 1;
                    break;
                case 1:
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    if (z9) {
                        i7 = 4;
                    } else {
                        i7 = 1;
                    }
                    break;
                case 2:
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    if (z9) {
                        i7 = 4;
                    } else {
                        i7 = 3;
                    }
                    break;
                case 3:
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    i7 = 3;
                    break;
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                    playbackExceptionConvertToPlaybackException = playbackExceptionConvertToPlaybackException;
                    i7 = 2;
                    break;
                default:
                    throw new LegacyConversions.ConversionException("Invalid state of PlaybackStateCompat: " + i8);
            }
        }
        int i211111 = i7;
        if (playbackStateCompat2 == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (mediaControllerCompat$PlaybackInfo3 == null) {
            deviceInfoBuild = DeviceInfo.UNKNOWN;
        } else {
            if (mediaControllerCompat$PlaybackInfo3.playbackType == 2) {
                i9 = 1;
            } else {
                i9 = 0;
            }
            GapBuffer gapBuffer13 = new GapBuffer(i9);
            gapBuffer13.gapEnd = mediaControllerCompat$PlaybackInfo3.maxVolume;
            String str1118 = mediaControllerCompat$PlaybackInfo3.volumeControlId;
            if (i9 == 0) {
                z11 = true;
            } else {
                z11 = true;
            }
            UtilsKt.checkArgument(z11);
            gapBuffer13.buffer = str1118;
            deviceInfoBuild = gapBuffer13.build();
        }
        DeviceInfo deviceInfo13 = deviceInfoBuild;
        if (mediaControllerCompat$PlaybackInfo3 == null) {
            i10 = 0;
        } else {
            i10 = mediaControllerCompat$PlaybackInfo3.currentVolume;
        }
        if (mediaControllerCompat$PlaybackInfo3 == null) {
            z12 = false;
        } else {
            z12 = true;
        }
        PlayerInfo playerInfo15 = (PlayerInfo) quantizerWu2.weights;
        long j11118 = playerInfo15.seekBackIncrementMs;
        long j11119 = playerInfo15.seekForwardIncrementMs;
        long j111110 = playerInfo15.maxSeekToPreviousPositionMs;
        Bundle bundle115 = legacyPlayerInfo.sessionExtras;
        if (windowCount >= queueTimeline2.getWindowCount()) {
            queueTimeline3 = queueTimeline2;
            mediaItem2 = null;
        } else {
            queueTimeline3 = queueTimeline2;
            mediaItem2 = queueTimeline3.getQueuedMediaItem(windowCount).mediaItem;
        }
        SessionPositionInfo sessionPositionInfo13 = new SessionPositionInfo(createPositionInfo(windowCount, mediaItem2, jConvertToCurrentPositionMs14, z7), z7, SystemClock.elapsedRealtime(), jConvertToDurationMs2, jConvertToBufferedPositionMs113, iCalculateBufferedPercentage12, jConvertToBufferedPositionMs114, -9223372036854775807L, jConvertToDurationMs2, jConvertToBufferedPositionMs113);
        Player.PositionInfo positionInfo13 = SessionPositionInfo.DEFAULT_POSITION_INFO;
        int i211112 = i4;
        playerInfo = new PlayerInfo(playbackExceptionConvertToPlaybackException, 0, sessionPositionInfo13, positionInfo13, positionInfo13, 0, playbackParameters, i211112, z6, VideoSize.UNKNOWN, queueTimeline3, 0, mediaMetadata8, 1.0f, 1.0f, audioAttributes, 0, CueGroup.EMPTY_TIME_ZERO, deviceInfo13, i10, z12, z8, 1, 0, i211111, z10, false, mediaMetadata, j11118, j11119, j111110, Tracks.EMPTY, TrackSelectionParameters.DEFAULT);
        QuantizerWu quantizerWu15 = new QuantizerWu(playerInfo, sessionCommands116, commands2, immutableList15, bundle115, sessionError13);
        legacyPlayerInfo2 = this.legacyPlayerInfo;
        quantizerWu = this.controllerInfo;
        j6 = mediaController.timeDiffMs;
        zIsEmpty = ((PlayerInfo) quantizerWu.weights).timeline.isEmpty();
        boolean zIsEmpty14 = queueTimeline3.isEmpty();
        if (!zIsEmpty) {
            if (zIsEmpty) {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            } else {
                currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
                currentMediaItem.getClass();
                queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
                if (queuedMediaItem2 == null) {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = 0;
                    while (true) {
                        immutableList2 = queueTimeline3.queuedMediaItems;
                        if (i11 >= immutableList2.size()) {
                            z13 = false;
                        } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                            z13 = true;
                        } else {
                            i11++;
                        }
                    }
                }
                if (z13) {
                    num2 = 4;
                    num = 3;
                } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                    jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                    jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                    if (jConvertToCurrentPositionMs2 == j3) {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    } else {
                        if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                            num2 = 5;
                        } else {
                            num2 = null;
                        }
                        num3 = null;
                    }
                    num = num3;
                } else {
                    z14 = true;
                    num = 1;
                    num2 = 0;
                }
                z14 = true;
            }
        } else if (zIsEmpty) {
            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
            currentMediaItem.getClass();
            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
            if (queuedMediaItem2 == null) {
                i11 = 0;
                while (true) {
                    immutableList2 = queueTimeline3.queuedMediaItems;
                    if (i11 >= immutableList2.size()) {
                        z13 = false;
                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                        z13 = true;
                    } else {
                        i11++;
                    }
                }
            } else {
                i11 = 0;
                while (true) {
                    immutableList2 = queueTimeline3.queuedMediaItems;
                    if (i11 >= immutableList2.size()) {
                        z13 = false;
                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                        z13 = true;
                    } else {
                        i11++;
                    }
                }
            }
            if (z13) {
                num2 = 4;
                num = 3;
            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                if (jConvertToCurrentPositionMs2 == j3) {
                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                        num2 = 5;
                    } else {
                        num2 = null;
                    }
                    num3 = null;
                } else {
                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                        num2 = 5;
                    } else {
                        num2 = null;
                    }
                    num3 = null;
                }
                num = num3;
            } else {
                z14 = true;
                num = 1;
                num2 = 0;
            }
            z14 = true;
        } else {
            currentMediaItem = ((PlayerInfo) quantizerWu.weights).getCurrentMediaItem();
            currentMediaItem.getClass();
            queuedMediaItem2 = queueTimeline3.fakeQueuedMediaItem;
            if (queuedMediaItem2 == null) {
                i11 = 0;
                while (true) {
                    immutableList2 = queueTimeline3.queuedMediaItems;
                    if (i11 >= immutableList2.size()) {
                        z13 = false;
                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                        z13 = true;
                    } else {
                        i11++;
                    }
                }
            } else {
                i11 = 0;
                while (true) {
                    immutableList2 = queueTimeline3.queuedMediaItems;
                    if (i11 >= immutableList2.size()) {
                        z13 = false;
                    } else if (currentMediaItem.equals(((QueueTimeline.QueuedMediaItem) immutableList2.get(i11)).mediaItem)) {
                        z13 = true;
                    } else {
                        i11++;
                    }
                }
            }
            if (z13) {
                num2 = 4;
                num = 3;
            } else if (currentMediaItem.equals(playerInfo.getCurrentMediaItem())) {
                jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j6);
                jConvertToCurrentPositionMs2 = LegacyConversions.convertToCurrentPositionMs(playbackStateCompat2, mediaMetadataCompat3, j6);
                if (jConvertToCurrentPositionMs2 == j3) {
                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                        num2 = 5;
                    } else {
                        num2 = null;
                    }
                    num3 = null;
                } else {
                    if (Math.abs(jConvertToCurrentPositionMs - jConvertToCurrentPositionMs2) > 100) {
                        num2 = 5;
                    } else {
                        num2 = null;
                    }
                    num3 = null;
                }
                num = num3;
            } else {
                z14 = true;
                num = 1;
                num2 = 0;
            }
            z14 = true;
        }
        Pair pairCreate14 = Pair.create(num2, num);
        updateControllerInfo(z, legacyPlayerInfo, true, quantizerWu15, (Integer) pairCreate14.first, (Integer) pairCreate14.second);
        if (this.hasPendingExtrasChange) {
            this.hasPendingExtrasChange = false;
            if (Looper.myLooper() != mediaController.applicationHandler.getLooper()) {
                z14 = false;
            }
            UtilsKt.checkState(z14);
            mediaController.listener.getClass();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void increaseDeviceVolume(int i) {
        int deviceVolume = getDeviceVolume();
        int i2 = getDeviceInfo().maxVolume;
        if (i2 == 0 || deviceVolume + 1 <= i2) {
            PlayerInfo playerInfoCopyWithDeviceVolume = ((PlayerInfo) this.controllerInfo.weights).copyWithDeviceVolume(deviceVolume + 1, isDeviceMuted());
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithDeviceVolume, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.adjustVolume(1, i);
    }

    public final void initializeLegacyPlaylist() {
        this.hasInitializedLegacyPlaylist = true;
        Timeline.Window window = new Timeline.Window();
        PlayerInfo playerInfo = (PlayerInfo) this.controllerInfo.weights;
        QueueTimeline queueTimeline = (QueueTimeline) playerInfo.timeline;
        int i = playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        queueTimeline.getWindow(i, window, 0L);
        MediaItem mediaItem = window.mediaItem;
        if (queueTimeline.getQueueId(i) != -1) {
            boolean z = ((PlayerInfo) this.controllerInfo.weights).playWhenReady;
            CallbackWrapper callbackWrapper = this.controllerCompat;
            if (z) {
                ((android.media.session.MediaController.TransportControls) callbackWrapper.getTransportControls().impl).play();
            } else {
                ((android.media.session.MediaController.TransportControls) callbackWrapper.getTransportControls().impl).prepare();
            }
        } else {
            MediaItem.RequestMetadata requestMetadata = mediaItem.requestMetadata;
            String str = mediaItem.mediaId;
            if (requestMetadata.mediaUri != null) {
                boolean z2 = ((PlayerInfo) this.controllerInfo.weights).playWhenReady;
                CallbackWrapper callbackWrapper2 = this.controllerCompat;
                if (z2) {
                    MediaBrowserCompat transportControls = callbackWrapper2.getTransportControls();
                    Uri uri = requestMetadata.mediaUri;
                    Bundle bundle = requestMetadata.extras;
                    if (bundle == null) {
                        bundle = Bundle.EMPTY;
                    }
                    ((android.media.session.MediaController.TransportControls) transportControls.impl).playFromUri(uri, bundle);
                } else {
                    MediaBrowserCompat transportControls2 = callbackWrapper2.getTransportControls();
                    Uri uri2 = requestMetadata.mediaUri;
                    Bundle bundle2 = requestMetadata.extras;
                    if (bundle2 == null) {
                        bundle2 = Bundle.EMPTY;
                    }
                    ((android.media.session.MediaController.TransportControls) transportControls2.impl).prepareFromUri(uri2, bundle2);
                }
            } else {
                String str2 = requestMetadata.searchQuery;
                QuantizerWu quantizerWu = this.controllerInfo;
                if (str2 != null) {
                    boolean z3 = ((PlayerInfo) quantizerWu.weights).playWhenReady;
                    CallbackWrapper callbackWrapper3 = this.controllerCompat;
                    if (z3) {
                        MediaBrowserCompat transportControls3 = callbackWrapper3.getTransportControls();
                        String str3 = requestMetadata.searchQuery;
                        Bundle bundle3 = requestMetadata.extras;
                        if (bundle3 == null) {
                            bundle3 = Bundle.EMPTY;
                        }
                        ((android.media.session.MediaController.TransportControls) transportControls3.impl).playFromSearch(str3, bundle3);
                    } else {
                        MediaBrowserCompat transportControls4 = callbackWrapper3.getTransportControls();
                        String str4 = requestMetadata.searchQuery;
                        Bundle bundle4 = requestMetadata.extras;
                        if (bundle4 == null) {
                            bundle4 = Bundle.EMPTY;
                        }
                        ((android.media.session.MediaController.TransportControls) transportControls4.impl).prepareFromSearch(str4, bundle4);
                    }
                } else {
                    boolean z4 = ((PlayerInfo) quantizerWu.weights).playWhenReady;
                    CallbackWrapper callbackWrapper4 = this.controllerCompat;
                    if (z4) {
                        MediaBrowserCompat transportControls5 = callbackWrapper4.getTransportControls();
                        Bundle bundle5 = requestMetadata.extras;
                        if (bundle5 == null) {
                            bundle5 = Bundle.EMPTY;
                        }
                        ((android.media.session.MediaController.TransportControls) transportControls5.impl).playFromMediaId(str, bundle5);
                    } else {
                        MediaBrowserCompat transportControls6 = callbackWrapper4.getTransportControls();
                        Bundle bundle6 = requestMetadata.extras;
                        if (bundle6 == null) {
                            bundle6 = Bundle.EMPTY;
                        }
                        ((android.media.session.MediaController.TransportControls) transportControls6.impl).prepareFromMediaId(str, bundle6);
                    }
                }
            }
        }
        if (((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.positionInfo.positionMs != 0) {
            ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).seekTo(((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.positionInfo.positionMs);
        }
        if (((Player.Commands) this.controllerInfo.momentsG).contains(20)) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < queueTimeline.getWindowCount(); i2++) {
                if (i2 != i && queueTimeline.getQueueId(i2) == -1) {
                    queueTimeline.getWindow(i2, window, 0L);
                    arrayList.add(window.mediaItem);
                }
            }
            addQueueItems(0, arrayList);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isConnected() {
        return this.connected;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isDeviceMuted() {
        PlayerInfo playerInfo = (PlayerInfo) this.controllerInfo.weights;
        if (playerInfo.deviceInfo.playbackType == 1) {
            return playerInfo.deviceMuted;
        }
        CallbackWrapper callbackWrapper = this.controllerCompat;
        if (callbackWrapper == null) {
            return false;
        }
        MediaControllerCompat$PlaybackInfo playbackInfo = ((MediaControllerCompat$MediaControllerImplApi23) callbackWrapper.mCallback).getPlaybackInfo();
        ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
        return playbackInfo != null && playbackInfo.currentVolume == 0;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isLoading() {
        return false;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isPlaying() {
        return ((PlayerInfo) this.controllerInfo.weights).isPlaying;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isPlayingAd() {
        return ((PlayerInfo) this.controllerInfo.weights).sessionPositionInfo.isPlayingAd;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void moveMediaItem(int i, int i2) {
        moveMediaItems(i, i + 1, i2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void moveMediaItems(int i, int i2, int i3) {
        UtilsKt.checkArgument(i >= 0 && i <= i2 && i3 >= 0);
        QueueTimeline queueTimeline = (QueueTimeline) ((PlayerInfo) this.controllerInfo.weights).timeline;
        int windowCount = queueTimeline.getWindowCount();
        int iMin = Math.min(i2, windowCount);
        int i4 = iMin - i;
        int i5 = windowCount - i4;
        int i6 = i5 - 1;
        int iMin2 = Math.min(i3, i5);
        if (i >= windowCount || i == iMin || i == iMin2) {
            return;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        if (currentMediaItemIndex >= i) {
            currentMediaItemIndex = currentMediaItemIndex < iMin ? -1 : currentMediaItemIndex - i4;
        }
        if (currentMediaItemIndex == -1) {
            currentMediaItemIndex = Util.constrainValue(i, 0, i6);
            Log.w("MCImplLegacy", "Currently playing item will be removed and added back to mimic move. Assumes item at " + currentMediaItemIndex + " would be the new current item");
        }
        if (currentMediaItemIndex >= iMin2) {
            currentMediaItemIndex += i4;
        }
        ArrayList arrayList = new ArrayList(queueTimeline.queuedMediaItems);
        Util.moveItems(arrayList, i, iMin, iMin2);
        PlayerInfo playerInfoCopyWithTimelineAndMediaItemIndex = ((PlayerInfo) this.controllerInfo.weights).copyWithTimelineAndMediaItemIndex(new QueueTimeline(ImmutableList.copyOf((Collection) arrayList), queueTimeline.fakeQueuedMediaItem), currentMediaItemIndex);
        QuantizerWu quantizerWu = this.controllerInfo;
        updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithTimelineAndMediaItemIndex, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        if (this.hasInitializedLegacyPlaylist) {
            ArrayList arrayList2 = new ArrayList();
            for (int i7 = 0; i7 < i4; i7++) {
                arrayList2.add((MediaSessionCompat$QueueItem) this.legacyPlayerInfo.queue.get(i));
                this.controllerCompat.removeQueueItem(((MediaSessionCompat$QueueItem) this.legacyPlayerInfo.queue.get(i)).description);
            }
            for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                this.controllerCompat.addQueueItem(((MediaSessionCompat$QueueItem) arrayList2.get(i8)).description, i8 + iMin2);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void mute() {
        Log.w("MCImplLegacy", "Session doesn't support muting the player");
    }

    public final void onConnected() {
        MediaMetadataCompat mediaMetadataCompatCreateFromParcel;
        int shuffleMode;
        if (this.released || this.connected) {
            return;
        }
        this.connected = true;
        MediaControllerCompat$PlaybackInfo playbackInfo = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).getPlaybackInfo();
        PlaybackStateCompat playbackStateCompatConvertToSafePlaybackStateCompat = convertToSafePlaybackStateCompat(this.controllerCompat.getPlaybackState());
        MediaMetadata metadata = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.getMetadata();
        if (metadata != null) {
            ArrayMap arrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
            Parcel parcelObtain = Parcel.obtain();
            metadata.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            mediaMetadataCompatCreateFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            mediaMetadataCompatCreateFromParcel.metadataFwk = metadata;
        } else {
            mediaMetadataCompatCreateFromParcel = null;
        }
        List<MediaSession.QueueItem> queue = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.getQueue();
        List listConvertToNonNullQueueItemList = convertToNonNullQueueItemList(queue != null ? MediaSessionCompat$QueueItem.fromQueueItemList(queue) : null);
        CharSequence queueTitle = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.getQueueTitle();
        androidx.media3.session.legacy.IMediaSession extraBinder = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).sessionToken.getExtraBinder();
        int repeatMode = -1;
        if (extraBinder != null) {
            try {
                repeatMode = extraBinder.getRepeatMode();
            } catch (RemoteException | SecurityException e) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
            }
        }
        androidx.media3.session.legacy.IMediaSession extraBinder2 = ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).sessionToken.getExtraBinder();
        if (extraBinder2 != null) {
            try {
                shuffleMode = extraBinder2.getShuffleMode();
            } catch (RemoteException | SecurityException e2) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e2);
                shuffleMode = -1;
            }
        } else {
            shuffleMode = -1;
        }
        handleNewLegacyParameters(true, new LegacyPlayerInfo(playbackInfo, playbackStateCompatConvertToSafePlaybackStateCompat, mediaMetadataCompatCreateFromParcel, listConvertToNonNullQueueItemList, queueTitle, repeatMode, shuffleMode, Util.convertToNullIfInvalid(((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.getExtras())));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void prepare() {
        PlayerInfo playerInfo = (PlayerInfo) this.controllerInfo.weights;
        if (playerInfo.playbackState != 1) {
            return;
        }
        PlayerInfo playerInfoCopyWithPlaybackState = playerInfo.copyWithPlaybackState(playerInfo.timeline.isEmpty() ? 4 : 2, null);
        QuantizerWu quantizerWu = this.controllerInfo;
        updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithPlaybackState, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        if (canInitializeLegacyPlaylist(this.controllerInfo)) {
            initializeLegacyPlaylist();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void release() {
        Messenger messenger;
        if (this.released) {
            return;
        }
        this.released = true;
        MediaBrowserCompat mediaBrowserCompat = this.browserCompat;
        if (mediaBrowserCompat != null) {
            MediaBrowserCompat.MediaBrowserImplApi26 mediaBrowserImplApi26 = (MediaBrowserCompat.MediaBrowserImplApi26) mediaBrowserCompat.impl;
            CallbackWrapper callbackWrapper = mediaBrowserImplApi26.serviceBinderWrapper;
            if (callbackWrapper != null && (messenger = mediaBrowserImplApi26.callbacksMessenger) != null) {
                try {
                    callbackWrapper.sendRequest(7, null, messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            mediaBrowserImplApi26.browserFwk.disconnect();
            this.browserCompat = null;
        }
        CallbackWrapper callbackWrapper2 = this.controllerCompat;
        if (callbackWrapper2 != null) {
            Set set = (Set) callbackWrapper2.mExecutor;
            ControllerCompatCallback controllerCompatCallback = this.controllerCompatCallback;
            if (set.remove(controllerCompatCallback)) {
                try {
                    ((MediaControllerCompat$MediaControllerImplApi23) callbackWrapper2.mCallback).unregisterCallback(controllerCompatCallback);
                    controllerCompatCallback.setHandler(null);
                } catch (Throwable th) {
                    controllerCompatCallback.setHandler(null);
                    throw th;
                }
            } else {
                Log.w("MediaControllerCompat", "the callback has never been registered");
            }
            controllerCompatCallback.pendingChangesHandler.removeCallbacksAndMessages(null);
            this.controllerCompat = null;
        }
        this.connected = false;
        this.listeners.release();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void removeListener(Player.Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void removeMediaItems(int i, int i2) {
        UtilsKt.checkArgument(i >= 0 && i2 >= i);
        int windowCount = getCurrentTimeline().getWindowCount();
        int iMin = Math.min(i2, windowCount);
        if (i >= windowCount || i == iMin) {
            return;
        }
        QueueTimeline queueTimeline = (QueueTimeline) ((PlayerInfo) this.controllerInfo.weights).timeline;
        queueTimeline.getClass();
        ImmutableList.Builder builder = new ImmutableList.Builder(4);
        ImmutableList immutableList = queueTimeline.queuedMediaItems;
        builder.addAll(immutableList.subList(0, i));
        builder.addAll(immutableList.subList(iMin, immutableList.size()));
        QueueTimeline queueTimeline2 = new QueueTimeline(builder.build(), queueTimeline.fakeQueuedMediaItem);
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        int i3 = iMin - i;
        if (currentMediaItemIndex >= i) {
            currentMediaItemIndex = currentMediaItemIndex < iMin ? -1 : currentMediaItemIndex - i3;
        }
        if (currentMediaItemIndex == -1) {
            currentMediaItemIndex = Util.constrainValue(i, 0, queueTimeline2.getWindowCount() - 1);
            Log.w("MCImplLegacy", "Currently playing item is removed. Assumes item at " + currentMediaItemIndex + " is the new current item");
        }
        PlayerInfo playerInfoCopyWithTimelineAndMediaItemIndex = ((PlayerInfo) this.controllerInfo.weights).copyWithTimelineAndMediaItemIndex(queueTimeline2, currentMediaItemIndex);
        QuantizerWu quantizerWu = this.controllerInfo;
        updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithTimelineAndMediaItemIndex, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        if (this.hasInitializedLegacyPlaylist) {
            while (i < iMin && i < this.legacyPlayerInfo.queue.size()) {
                this.controllerCompat.removeQueueItem(((MediaSessionCompat$QueueItem) this.legacyPlayerInfo.queue.get(i)).description);
                i++;
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void replaceMediaItem(int i, MediaItem mediaItem) {
        replaceMediaItems(i, i + 1, ImmutableList.of((Object) mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void replaceMediaItems(int i, int i2, List list) {
        UtilsKt.checkArgument(i >= 0 && i <= i2);
        int windowCount = ((QueueTimeline) ((PlayerInfo) this.controllerInfo.weights).timeline).getWindowCount();
        if (i > windowCount) {
            return;
        }
        int iMin = Math.min(i2, windowCount);
        addMediaItems(iMin, list);
        removeMediaItems(i, iMin);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekBack() {
        ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).rewind();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekForward() {
        ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).fastForward();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekTo(long j) {
        seekToInternal$1(getCurrentMediaItemIndex(), j);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToDefaultPosition() {
        seekToInternal$1(getCurrentMediaItemIndex(), 0L);
    }

    public final void seekToInternal$1(int i, long j) {
        Integer num;
        Integer num2;
        int i2;
        long j2;
        long j3;
        long j4;
        int i3 = i;
        long j5 = j;
        UtilsKt.checkArgument(i3 >= 0);
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        Timeline timeline = ((PlayerInfo) this.controllerInfo.weights).timeline;
        if ((timeline.isEmpty() || i3 < timeline.getWindowCount()) && !isPlayingAd()) {
            if (i3 != currentMediaItemIndex) {
                long queueId = ((QueueTimeline) ((PlayerInfo) this.controllerInfo.weights).timeline).getQueueId(i3);
                if (queueId != -1) {
                    ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).skipToQueueItem(queueId);
                    num = 2;
                } else {
                    Format$$ExternalSyntheticOutline0.m(i3, "Cannot seek to new media item due to the missing queue Id at media item, mediaItemIndex=", "MCImplLegacy");
                    i3 = currentMediaItemIndex;
                    num = null;
                }
            } else {
                i3 = currentMediaItemIndex;
                num = null;
            }
            long currentPosition = getCurrentPosition();
            if (j5 == -9223372036854775807L) {
                j5 = currentPosition;
                num2 = null;
            } else {
                ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).seekTo(j5);
                num2 = 1;
            }
            if (num == null) {
                long bufferedPosition = getBufferedPosition();
                long duration = getDuration();
                long jMax = j5 < currentPosition ? j5 : Math.max(j5, bufferedPosition);
                j2 = jMax;
                i2 = duration == -9223372036854775807L ? 0 : (int) ((100 * jMax) / duration);
                j3 = jMax - j5;
                j4 = duration;
            } else {
                i2 = 0;
                j2 = 0;
                j3 = 0;
                j4 = -9223372036854775807L;
            }
            PlayerInfo playerInfoCopyWithSessionPositionInfo = ((PlayerInfo) this.controllerInfo.weights).copyWithSessionPositionInfo(new SessionPositionInfo(createPositionInfo(i3, !timeline.isEmpty() ? timeline.getWindow(i3, new Timeline.Window(), 0L).mediaItem : null, j5, false), false, SystemClock.elapsedRealtime(), j4, j2, i2, j3, -9223372036854775807L, j4, j2));
            if (playerInfoCopyWithSessionPositionInfo.playbackState != 1) {
                playerInfoCopyWithSessionPositionInfo = playerInfoCopyWithSessionPositionInfo.copyWithPlaybackState(2, null);
            }
            PlayerInfo playerInfo = playerInfoCopyWithSessionPositionInfo;
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfo, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), num2, num);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToNext() {
        ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).skipToNext();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToNextMediaItem() {
        ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).skipToNext();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToPrevious() {
        ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).skipToPrevious();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToPreviousMediaItem() {
        ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).skipToPrevious();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ListenableFuture sendCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        Bundle bundle2 = sessionCommand.customExtras;
        if (this.controllerCompat == null) {
            return new ImmediateFuture(new SessionResult(-100));
        }
        if (bundle.isEmpty()) {
            bundle = bundle2;
        } else if (!bundle2.isEmpty()) {
            Bundle bundle3 = new Bundle(bundle2);
            bundle3.putAll(bundle);
            bundle = bundle3;
        }
        this.controllerCompat.getTransportControls().sendCustomAction(sessionCommand.customAction, bundle);
        return new ImmediateFuture(new SessionResult(0));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        Log.w("MCImplLegacy", "Legacy session doesn't support setting audio attributes remotely");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceMuted(int i, boolean z) {
        if (z != isDeviceMuted()) {
            PlayerInfo playerInfoCopyWithDeviceVolume = ((PlayerInfo) this.controllerInfo.weights).copyWithDeviceVolume(getDeviceVolume(), z);
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithDeviceVolume, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.adjustVolume(z ? -100 : 100, i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceVolume(int i, int i2) {
        DeviceInfo deviceInfo = getDeviceInfo();
        int i3 = deviceInfo.minVolume;
        int i4 = deviceInfo.maxVolume;
        if (i3 <= i && (i4 == 0 || i <= i4)) {
            PlayerInfo playerInfoCopyWithDeviceVolume = ((PlayerInfo) this.controllerInfo.weights).copyWithDeviceVolume(i, isDeviceMuted());
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithDeviceVolume, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        ((MediaControllerCompat$MediaControllerImplApi23) this.controllerCompat.mCallback).controllerFwk.setVolumeTo(i, i2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItem(mediaItem, -9223372036854775807L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItem$1(MediaItem mediaItem) {
        setMediaItem(mediaItem);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItems(List list, int i, long j) {
        if (list.isEmpty()) {
            clearMediaItems();
            return;
        }
        PlayerInfo playerInfoCopyWithTimelineAndSessionPositionInfo = ((PlayerInfo) this.controllerInfo.weights).copyWithTimelineAndSessionPositionInfo(QueueTimeline.DEFAULT.copyWithNewMediaItems(0, list), new SessionPositionInfo(createPositionInfo(i, (MediaItem) list.get(i), j == -9223372036854775807L ? 0L : j, false), false, SystemClock.elapsedRealtime(), -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L), 0);
        QuantizerWu quantizerWu = this.controllerInfo;
        updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithTimelineAndSessionPositionInfo, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        if (canInitializeLegacyPlaylist(this.controllerInfo)) {
            initializeLegacyPlaylist();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlayWhenReady(boolean z) {
        PlayerInfo playerInfo = (PlayerInfo) this.controllerInfo.weights;
        if (playerInfo.playWhenReady == z) {
            return;
        }
        this.currentPositionMs = MediaUtils.getUpdatedCurrentPositionMs(playerInfo, this.currentPositionMs, this.lastSetPlayWhenReadyCalledTimeMs, this.instance.timeDiffMs);
        this.lastSetPlayWhenReadyCalledTimeMs = SystemClock.elapsedRealtime();
        PlayerInfo playerInfoCopyWithPlayWhenReady = ((PlayerInfo) this.controllerInfo.weights).copyWithPlayWhenReady(1, z, 0);
        QuantizerWu quantizerWu = this.controllerInfo;
        updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithPlayWhenReady, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        if (!this.hasInitializedLegacyPlaylist) {
            if (canInitializeLegacyPlaylist(this.controllerInfo)) {
                initializeLegacyPlaylist();
            }
        } else {
            CallbackWrapper callbackWrapper = this.controllerCompat;
            if (z) {
                ((android.media.session.MediaController.TransportControls) callbackWrapper.getTransportControls().impl).play();
            } else {
                ((android.media.session.MediaController.TransportControls) callbackWrapper.getTransportControls().impl).pause();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (!playbackParameters.equals(getPlaybackParameters())) {
            PlayerInfo playerInfoCopyWithPlaybackParameters = ((PlayerInfo) this.controllerInfo.weights).copyWithPlaybackParameters(playbackParameters);
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithPlaybackParameters, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        this.controllerCompat.getTransportControls().setPlaybackSpeed(playbackParameters.speed);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlaybackSpeed(float f) {
        if (f != getPlaybackParameters().speed) {
            PlayerInfo playerInfoCopyWithPlaybackParameters = ((PlayerInfo) this.controllerInfo.weights).copyWithPlaybackParameters(new PlaybackParameters(f));
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithPlaybackParameters, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        this.controllerCompat.getTransportControls().setPlaybackSpeed(f);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlaylistMetadata(androidx.media3.common.MediaMetadata mediaMetadata) {
        Log.w("MCImplLegacy", "Session doesn't support setting playlist metadata");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setRepeatMode(int i) {
        if (i != getRepeatMode()) {
            PlayerInfo playerInfoCopyWithRepeatMode = ((PlayerInfo) this.controllerInfo.weights).copyWithRepeatMode(i);
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithRepeatMode, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        MediaBrowserCompat transportControls = this.controllerCompat.getTransportControls();
        int iConvertToPlaybackStateCompatRepeatMode = LegacyConversions.convertToPlaybackStateCompatRepeatMode(i);
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", iConvertToPlaybackStateCompatRepeatMode);
        transportControls.sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setShuffleModeEnabled(boolean z) {
        if (z != getShuffleModeEnabled()) {
            PlayerInfo playerInfoCopyWithShuffleModeEnabled = ((PlayerInfo) this.controllerInfo.weights).copyWithShuffleModeEnabled(z);
            QuantizerWu quantizerWu = this.controllerInfo;
            updateStateMaskedControllerInfo(new QuantizerWu(playerInfoCopyWithShuffleModeEnabled, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        }
        MediaBrowserCompat transportControls = this.controllerCompat.getTransportControls();
        ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", z ? 1 : 0);
        transportControls.sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        Log.w("MCImplLegacy", "Session doesn't support setting SurfaceHolder");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setVolume(float f) {
        Log.w("MCImplLegacy", "Session doesn't support setting player volume");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void stop() {
        PlayerInfo playerInfo = (PlayerInfo) this.controllerInfo.weights;
        if (playerInfo.playbackState == 1) {
            return;
        }
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
        boolean z = sessionPositionInfo.isPlayingAd;
        long j = sessionPositionInfo.durationMs;
        long j2 = positionInfo.positionMs;
        PlayerInfo playerInfoCopyWithSessionPositionInfo = playerInfo.copyWithSessionPositionInfo(new SessionPositionInfo(positionInfo, z, SystemClock.elapsedRealtime(), j, j2, MediaUtils.calculateBufferedPercentage(j2, j), 0L, -9223372036854775807L, j, j2));
        PlayerInfo playerInfo2 = (PlayerInfo) this.controllerInfo.weights;
        if (playerInfo2.playbackState != 1) {
            playerInfoCopyWithSessionPositionInfo = playerInfoCopyWithSessionPositionInfo.copyWithPlaybackState(1, playerInfo2.playerError);
        }
        PlayerInfo playerInfo3 = playerInfoCopyWithSessionPositionInfo;
        QuantizerWu quantizerWu = this.controllerInfo;
        updateStateMaskedControllerInfo(new QuantizerWu(playerInfo3, (SessionCommands) quantizerWu.momentsR, (Player.Commands) quantizerWu.momentsG, (ImmutableList) quantizerWu.momentsB, (Bundle) quantizerWu.moments, (SessionError) null), null, null);
        this.hasInitializedLegacyPlaylist = false;
        ((android.media.session.MediaController.TransportControls) this.controllerCompat.getTransportControls().impl).stop();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void unmute() {
        Log.w("MCImplLegacy", "Session doesn't support unmuting the player");
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:48:0x00de  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateControllerInfo(boolean z, LegacyPlayerInfo legacyPlayerInfo, boolean z2, final QuantizerWu quantizerWu, Integer num, Integer num2) {
        PlaybackException playbackExceptionConvertToPlaybackException;
        boolean z3;
        final byte b;
        boolean z4;
        SessionCommands sessionCommands = (SessionCommands) quantizerWu.momentsR;
        ImmutableList immutableList = (ImmutableList) quantizerWu.momentsB;
        LegacyPlayerInfo legacyPlayerInfo2 = this.legacyPlayerInfo;
        QuantizerWu quantizerWu2 = this.controllerInfo;
        if (z2) {
            this.legacyPlayerInfo = legacyPlayerInfo;
            this.pendingLegacyPlayerInfo = legacyPlayerInfo;
            if (canInitializeLegacyPlaylist(quantizerWu)) {
                this.hasInitializedLegacyPlaylist = true;
            }
        }
        this.controllerInfo = quantizerWu;
        MediaController mediaController = this.instance;
        if (z) {
            mediaController.notifyAccepted();
            if (((ImmutableList) quantizerWu2.momentsB).equals(immutableList)) {
                return;
            }
            mediaController.applicationHandler.post(new MediaControllerImplLegacy$$ExternalSyntheticLambda1(this, quantizerWu));
            return;
        }
        PlayerInfo playerInfo = (PlayerInfo) quantizerWu2.weights;
        Timeline timeline = playerInfo.timeline;
        PlayerInfo playerInfo2 = (PlayerInfo) quantizerWu.weights;
        SessionError sessionError = (SessionError) quantizerWu.cubes;
        boolean zEquals = timeline.equals(playerInfo2.timeline);
        final byte b2 = 5;
        ListenerSet listenerSet = this.listeners;
        if (!zEquals) {
            listenerSet.queueEvent(0, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b3 = b2;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b3) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        CharSequence charSequence = legacyPlayerInfo2.queueTitle;
        CharSequence charSequence2 = legacyPlayerInfo.queueTitle;
        PlaybackStateCompat playbackStateCompat = legacyPlayerInfo.playbackStateCompat;
        if (!TextUtils.equals(charSequence, charSequence2)) {
            final byte b3 = 6;
            listenerSet.queueEvent(15, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b4 = b3;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b4) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        byte b4 = 2;
        if (num != null) {
            listenerSet.queueEvent(11, new MediaSessionStub$$ExternalSyntheticLambda81(quantizerWu2, quantizerWu, num, b4));
        }
        byte b5 = 13;
        if (num2 != null) {
            listenerSet.queueEvent(1, new TextLinkScope$$ExternalSyntheticLambda10(quantizerWu, num2, b5));
        }
        PlaybackStateCompat playbackStateCompat2 = legacyPlayerInfo2.playbackStateCompat;
        Splitter splitter = MediaUtils.defaultBrowserRoot;
        boolean z5 = playbackStateCompat2 != null && playbackStateCompat2.state == 7;
        boolean z6 = playbackStateCompat != null && playbackStateCompat.state == 7;
        final byte b6 = 3;
        final byte b7 = 10;
        if (z5 && z6) {
            String str = Util.DEVICE_DEBUG_INFO;
            if (playbackStateCompat2.errorCode != playbackStateCompat.errorCode || !TextUtils.equals(playbackStateCompat2.errorMessage, playbackStateCompat.errorMessage)) {
                playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat, this.context);
                listenerSet.queueEvent(10, new MediaControllerImplBase$$ExternalSyntheticLambda41(playbackExceptionConvertToPlaybackException, b6));
                if (playbackExceptionConvertToPlaybackException != null) {
                    listenerSet.queueEvent(10, new MediaControllerImplBase$$ExternalSyntheticLambda41(playbackExceptionConvertToPlaybackException, (byte) 4));
                }
            }
        } else if (z5 != z6) {
            playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(playbackStateCompat, this.context);
            listenerSet.queueEvent(10, new MediaControllerImplBase$$ExternalSyntheticLambda41(playbackExceptionConvertToPlaybackException, b6));
            if (playbackExceptionConvertToPlaybackException != null) {
                listenerSet.queueEvent(10, new MediaControllerImplBase$$ExternalSyntheticLambda41(playbackExceptionConvertToPlaybackException, (byte) 4));
            }
        }
        if (legacyPlayerInfo2.mediaMetadataCompat != legacyPlayerInfo.mediaMetadataCompat) {
            listenerSet.queueEvent(14, new MediaControllerImplLegacy$$ExternalSyntheticLambda2(this));
        }
        if (playerInfo.playbackState != playerInfo2.playbackState) {
            final byte b8 = 7;
            listenerSet.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b9 = b8;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b9) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        final byte b9 = 8;
        if (playerInfo.playWhenReady != playerInfo2.playWhenReady) {
            listenerSet.queueEvent(5, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b10 = b9;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b10) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (playerInfo.isPlaying != playerInfo2.isPlaying) {
            z3 = false;
            final boolean z7 = false ? 1 : 0;
            listenerSet.queueEvent(7, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b10 = z7;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b10) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        } else {
            z3 = false;
        }
        final byte b10 = 9;
        final byte b11 = 12;
        if (!playerInfo.playbackParameters.equals(playerInfo2.playbackParameters)) {
            listenerSet.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b12 = b10;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b12) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (playerInfo.repeatMode != playerInfo2.repeatMode) {
            listenerSet.queueEvent(8, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b12 = b7;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b12) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (playerInfo.shuffleModeEnabled != playerInfo2.shuffleModeEnabled) {
            final byte b12 = 11;
            listenerSet.queueEvent(9, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b13 = b12;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b13) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.audioAttributes.equals(playerInfo2.audioAttributes)) {
            listenerSet.queueEvent(20, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b13 = b11;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b13) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (playerInfo.audioSessionId != playerInfo2.audioSessionId) {
            b = 1;
            listenerSet.queueEvent(21, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b13 = b;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b13) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        } else {
            b = 1;
        }
        if (!playerInfo.deviceInfo.equals(playerInfo2.deviceInfo)) {
            final byte b13 = 2;
            listenerSet.queueEvent(29, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b14 = b13;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b14) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (playerInfo.deviceVolume != playerInfo2.deviceVolume || playerInfo.deviceMuted != playerInfo2.deviceMuted) {
            listenerSet.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b14 = b6;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b14) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (!((Player.Commands) quantizerWu2.momentsG).equals((Player.Commands) quantizerWu.momentsG)) {
            final byte b14 = 4;
            listenerSet.queueEvent(13, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b15 = b14;
                    QuantizerWu quantizerWu3 = quantizerWu;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b15) {
                        case 0:
                            listener.onIsPlayingChanged(((PlayerInfo) quantizerWu3.weights).isPlaying);
                            break;
                        case 1:
                            listener.onAudioSessionIdChanged(((PlayerInfo) quantizerWu3.weights).audioSessionId);
                            break;
                        case 2:
                            listener.onDeviceInfoChanged(((PlayerInfo) quantizerWu3.weights).deviceInfo);
                            break;
                        case 3:
                            PlayerInfo playerInfo3 = (PlayerInfo) quantizerWu3.weights;
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 4:
                            listener.onAvailableCommandsChanged((Player.Commands) quantizerWu3.momentsG);
                            break;
                        case 5:
                            PlayerInfo playerInfo4 = (PlayerInfo) quantizerWu3.weights;
                            listener.onTimelineChanged(playerInfo4.timeline, playerInfo4.timelineChangeReason);
                            break;
                        case 6:
                            listener.onPlaylistMetadataChanged(((PlayerInfo) quantizerWu3.weights).playlistMetadata);
                            break;
                        case 7:
                            listener.onPlaybackStateChanged(((PlayerInfo) quantizerWu3.weights).playbackState);
                            break;
                        case 8:
                            listener.onPlayWhenReadyChanged(4, ((PlayerInfo) quantizerWu3.weights).playWhenReady);
                            break;
                        case 9:
                            listener.onPlaybackParametersChanged(((PlayerInfo) quantizerWu3.weights).playbackParameters);
                            break;
                        case 10:
                            listener.onRepeatModeChanged(((PlayerInfo) quantizerWu3.weights).repeatMode);
                            break;
                        case 11:
                            listener.onShuffleModeEnabledChanged(((PlayerInfo) quantizerWu3.weights).shuffleModeEnabled);
                            break;
                        default:
                            listener.onAudioAttributesChanged(((PlayerInfo) quantizerWu3.weights).audioAttributes);
                            break;
                    }
                }
            });
        }
        if (!((SessionCommands) quantizerWu2.momentsR).equals(sessionCommands)) {
            mediaController.getClass();
            UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper() ? b : z3 ? 1 : 0);
            mediaController.listener.onAvailableSessionCommandsChanged();
        }
        if (!((ImmutableList) quantizerWu2.momentsB).equals(immutableList)) {
            mediaController.getClass();
            UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper() ? b : z3 ? 1 : 0);
            MediaController.Listener listener = mediaController.listener;
            listener.getClass();
            MediaController.Listener.onSetCustomLayout();
            listener.onMediaButtonPreferencesChanged();
        }
        if (sessionError != null) {
            mediaController.getClass();
            if (Looper.myLooper() == mediaController.applicationHandler.getLooper()) {
                z4 = z3;
                z4 = b;
            }
            z4 = z3;
            UtilsKt.checkState(z4);
            mediaController.listener.getClass();
        }
        listenerSet.flushEvents();
    }

    public final void updateStateMaskedControllerInfo(QuantizerWu quantizerWu, Integer num, Integer num2) {
        updateControllerInfo(false, this.legacyPlayerInfo, false, quantizerWu, num, num2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekTo(int i, long j) {
        seekToInternal$1(i, j);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(ImmutableList.of((Object) mediaItem), 0, j);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToDefaultPosition(int i) {
        seekToInternal$1(i, 0L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LegacyPlayerInfo {
        public final MediaMetadataCompat mediaMetadataCompat;
        public final MediaControllerCompat$PlaybackInfo playbackInfoCompat;
        public final PlaybackStateCompat playbackStateCompat;
        public final List queue;
        public final CharSequence queueTitle;
        public final int repeatMode;
        public final Bundle sessionExtras;
        public final int shuffleMode;

        public LegacyPlayerInfo(MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo, PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, List list, CharSequence charSequence, int i, int i2, Bundle bundle) {
            this.playbackInfoCompat = mediaControllerCompat$PlaybackInfo;
            this.playbackStateCompat = playbackStateCompat;
            this.mediaMetadataCompat = mediaMetadataCompat;
            list.getClass();
            this.queue = list;
            this.queueTitle = charSequence;
            this.repeatMode = i;
            this.shuffleMode = i2;
            this.sessionExtras = bundle == null ? Bundle.EMPTY : bundle;
        }

        public LegacyPlayerInfo() {
            this.playbackInfoCompat = null;
            this.playbackStateCompat = null;
            this.mediaMetadataCompat = null;
            this.queue = Collections.EMPTY_LIST;
            this.queueTitle = null;
            this.repeatMode = 0;
            this.shuffleMode = 0;
            this.sessionExtras = Bundle.EMPTY;
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceMuted(boolean z) {
        setDeviceMuted(1, z);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceVolume(int i) {
        setDeviceVolume(i, 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void decreaseDeviceVolume() {
        decreaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void increaseDeviceVolume() {
        increaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void addMediaItems(List list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItems(List list) {
        setMediaItems(list, 0, -9223372036854775807L);
    }
}
