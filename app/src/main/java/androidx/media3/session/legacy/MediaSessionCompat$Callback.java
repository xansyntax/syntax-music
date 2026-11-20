package androidx.media3.session.legacy;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AlertController;
import androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$1;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.material3.SliderState;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.VersionedParcelable;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.SupervisorCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaSessionCompat$Callback {
    public final Object callbackFwk;
    public Object callbackHandler;
    public final Object lock;
    public boolean mediaPlayPausePendingOnHandler;
    public Object sessionImpl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaSessionCallback extends MediaSession.Callback {
        public MediaSessionCallback() {
        }

        public static void setCurrentControllerInfo(MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            MediaSession mediaSession = mediaSessionCompat$MediaSessionImplApi23.sessionFwk;
            String str = null;
            try {
                str = (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
            } catch (Exception e) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e);
            }
            if (TextUtils.isEmpty(str)) {
                str = "android.media.session.MediaController";
            }
            mediaSessionCompat$MediaSessionImplApi23.setCurrentControllerInfo(new MediaSessionManager$RemoteUserInfo(str, -1, -1));
        }

        public final MediaSessionCompat$MediaSessionImplApi23 getSessionImplIfCallbackIsSet() {
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23;
            MediaSessionCompat$Callback mediaSessionCompat$Callback;
            synchronized (MediaSessionCompat$Callback.this.lock) {
                mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) ((WeakReference) MediaSessionCompat$Callback.this.sessionImpl).get();
            }
            if (mediaSessionCompat$MediaSessionImplApi23 == null) {
                return null;
            }
            MediaSessionCompat$Callback mediaSessionCompat$Callback2 = MediaSessionCompat$Callback.this;
            synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
                mediaSessionCompat$Callback = mediaSessionCompat$MediaSessionImplApi23.callback;
            }
            if (mediaSessionCompat$Callback2 == mediaSessionCompat$Callback) {
                return mediaSessionCompat$MediaSessionImplApi23;
            }
            return null;
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            VersionedParcelable versionedParcelable;
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            try {
                if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                    if (resultReceiver != null) {
                        Bundle bundle2 = new Bundle();
                        MediaSessionCompat$Token mediaSessionCompat$Token = sessionImplIfCallbackIsSet.token;
                        IMediaSession extraBinder = mediaSessionCompat$Token.getExtraBinder();
                        bundle2.putBinder("android.support.v4.media.session.EXTRA_BINDER", extraBinder == null ? null : extraBinder.asBinder());
                        synchronized (mediaSessionCompat$Token.lock) {
                            versionedParcelable = mediaSessionCompat$Token.session2Token;
                        }
                        if (versionedParcelable != null) {
                            Bundle bundle3 = new Bundle();
                            bundle3.putParcelable("a", new ParcelImpl(versionedParcelable));
                            bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle3);
                        }
                        resultReceiver.send(0, bundle2);
                    }
                } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        MediaSessionCompat$Callback.this.onAddQueueItem((MediaDescriptionCompat) DatabaseDao_Impl.AnonymousClass17.convert(bundleConvertToNullIfInvalid.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.CREATOR));
                    }
                } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        MediaSessionCompat$Callback.this.onAddQueueItem((MediaDescriptionCompat) DatabaseDao_Impl.AnonymousClass17.convert(bundleConvertToNullIfInvalid.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.CREATOR), bundleConvertToNullIfInvalid.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    }
                } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        MediaSessionCompat$Callback.this.onRemoveQueueItem((MediaDescriptionCompat) DatabaseDao_Impl.AnonymousClass17.convert(bundleConvertToNullIfInvalid.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.CREATOR));
                    }
                } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                    List list = sessionImplIfCallbackIsSet.queue;
                    if (list != null && bundleConvertToNullIfInvalid != null) {
                        int i = bundleConvertToNullIfInvalid.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = (i < 0 || i >= list.size()) ? null : (MediaSessionCompat$QueueItem) list.get(i);
                        if (mediaSessionCompat$QueueItem != null) {
                            MediaSessionCompat$Callback.this.onRemoveQueueItem(mediaSessionCompat$QueueItem.description);
                        }
                    }
                } else {
                    MediaSessionCompat$Callback.this.onCommand(str, bundleConvertToNullIfInvalid, resultReceiver);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
            }
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onCustomAction(String str, Bundle bundle) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            try {
                boolean zEquals = str.equals("android.support.v4.media.session.action.PLAY_FROM_URI");
                MediaSessionCompat$Callback mediaSessionCompat$Callback = MediaSessionCompat$Callback.this;
                if (zEquals) {
                    if (bundleConvertToNullIfInvalid != null) {
                        mediaSessionCompat$Callback.onPlayFromUri((Uri) bundleConvertToNullIfInvalid.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), Util.convertToNullIfInvalid(bundleConvertToNullIfInvalid.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                    }
                } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                    mediaSessionCompat$Callback.onPrepare();
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        mediaSessionCompat$Callback.onPrepareFromMediaId(bundleConvertToNullIfInvalid.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), Util.convertToNullIfInvalid(bundleConvertToNullIfInvalid.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                    }
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        mediaSessionCompat$Callback.onPrepareFromSearch(bundleConvertToNullIfInvalid.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), Util.convertToNullIfInvalid(bundleConvertToNullIfInvalid.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                    }
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        mediaSessionCompat$Callback.onPrepareFromUri((Uri) bundleConvertToNullIfInvalid.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), Util.convertToNullIfInvalid(bundleConvertToNullIfInvalid.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                    }
                } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        bundleConvertToNullIfInvalid.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                    }
                } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        mediaSessionCompat$Callback.onSetRepeatMode(bundleConvertToNullIfInvalid.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    }
                } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        mediaSessionCompat$Callback.onSetShuffleMode(bundleConvertToNullIfInvalid.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    }
                } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                    if (bundleConvertToNullIfInvalid != null) {
                        RatingCompat ratingCompat = (RatingCompat) DatabaseDao_Impl.AnonymousClass17.convert(bundleConvertToNullIfInvalid.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), RatingCompat.CREATOR);
                        Util.convertToNullIfInvalid(bundleConvertToNullIfInvalid.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                        mediaSessionCompat$Callback.onSetRating$1(ratingCompat);
                    }
                } else if (!str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                    mediaSessionCompat$Callback.onCustomAction(str, bundleConvertToNullIfInvalid);
                } else if (bundleConvertToNullIfInvalid != null) {
                    mediaSessionCompat$Callback.onSetPlaybackSpeed(bundleConvertToNullIfInvalid.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaSessionCompat", "Could not unparcel the data.");
            }
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onFastForward() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onFastForward();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final boolean onMediaButtonEvent(Intent intent) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return false;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            boolean zOnMediaButtonEvent = MediaSessionCompat$Callback.this.onMediaButtonEvent(intent);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
            return zOnMediaButtonEvent || super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPause() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPause();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPlay() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPlay();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPlayFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPlayFromMediaId(str, bundleConvertToNullIfInvalid);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPlayFromSearch(String str, Bundle bundle) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPlayFromSearch(str, bundleConvertToNullIfInvalid);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPlayFromUri(uri, bundleConvertToNullIfInvalid);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPrepare() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPrepare();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPrepareFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPrepareFromMediaId(str, bundleConvertToNullIfInvalid);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPrepareFromSearch(String str, Bundle bundle) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPrepareFromSearch(str, bundleConvertToNullIfInvalid);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onPrepareFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onPrepareFromUri(uri, bundleConvertToNullIfInvalid);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onRewind() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onRewind();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onSeekTo(long j) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onSeekTo(j);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onSetPlaybackSpeed(float f) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onSetPlaybackSpeed(f);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onSetRating(Rating rating) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onSetRating(RatingCompat.fromRating(rating));
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onSkipToNext() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onSkipToNext();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onSkipToPrevious() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onSkipToPrevious();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onSkipToQueueItem(long j) {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onSkipToQueueItem(j);
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public final void onStop() {
            MediaSessionCompat$MediaSessionImplApi23 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
            if (sessionImplIfCallbackIsSet == null) {
                return;
            }
            setCurrentControllerInfo(sessionImplIfCallbackIsSet);
            MediaSessionCompat$Callback.this.onStop();
            sessionImplIfCallbackIsSet.setCurrentControllerInfo(null);
        }
    }

    public MediaSessionCompat$Callback() {
        this.lock = new Object();
        this.callbackFwk = new MediaSessionCallback();
        this.sessionImpl = new WeakReference(null);
    }

    public void handleMediaPlayPauseIfPendingOnHandler(MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23, Handler handler) {
        if (this.mediaPlayPausePendingOnHandler) {
            this.mediaPlayPausePendingOnHandler = false;
            handler.removeMessages(1);
            PlaybackStateCompat playbackStateCompat = mediaSessionCompat$MediaSessionImplApi23.playbackState;
            long j = playbackStateCompat == null ? 0L : playbackStateCompat.actions;
            boolean z = playbackStateCompat != null && playbackStateCompat.state == 3;
            boolean z2 = (516 & j) != 0;
            boolean z3 = (j & 514) != 0;
            if (z && z3) {
                onPause();
            } else {
                if (z || !z2) {
                    return;
                }
                onPlay();
            }
        }
    }

    public boolean isScrollingEvent(PointerEvent pointerEvent) {
        return pointerEvent.type == 6;
    }

    public boolean onMediaButtonEvent(Intent intent) {
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23;
        AlertController.ButtonHandler buttonHandler;
        KeyEvent keyEvent;
        if (Build.VERSION.SDK_INT < 27) {
            synchronized (this.lock) {
                mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) ((WeakReference) this.sessionImpl).get();
                buttonHandler = (AlertController.ButtonHandler) this.callbackHandler;
            }
            if (mediaSessionCompat$MediaSessionImplApi23 != null && buttonHandler != null && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0) {
                MediaSessionManager$RemoteUserInfo currentControllerInfo = mediaSessionCompat$MediaSessionImplApi23.getCurrentControllerInfo();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79 && keyCode != 85) {
                    handleMediaPlayPauseIfPendingOnHandler(mediaSessionCompat$MediaSessionImplApi23, buttonHandler);
                    return false;
                }
                if (keyEvent.getRepeatCount() != 0) {
                    handleMediaPlayPauseIfPendingOnHandler(mediaSessionCompat$MediaSessionImplApi23, buttonHandler);
                    return true;
                }
                if (!this.mediaPlayPausePendingOnHandler) {
                    this.mediaPlayPausePendingOnHandler = true;
                    buttonHandler.sendMessageDelayed(buttonHandler.obtainMessage(1, currentControllerInfo), ViewConfiguration.getDoubleTapTimeout());
                    return true;
                }
                buttonHandler.removeMessages(1);
                this.mediaPlayPausePendingOnHandler = false;
                PlaybackStateCompat playbackStateCompat = mediaSessionCompat$MediaSessionImplApi23.playbackState;
                if (((playbackStateCompat == null ? 0L : playbackStateCompat.actions) & 32) != 0) {
                    onSkipToNext();
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m839onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        List list = pointerEvent.changes;
        List list2 = pointerEvent.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((PointerInputChange) list.get(i)).isConsumed()) {
                return;
            }
        }
        if (isScrollingEvent(pointerEvent)) {
            if (pointerEventPass == PointerEventPass.Initial && this.mediaPlayPausePendingOnHandler) {
                mo73onScrollingEventO0kMr_c(pointerEvent);
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((PointerInputChange) list2.get(i2)).consume();
                }
            }
            if (pointerEventPass == PointerEventPass.Main && !this.mediaPlayPausePendingOnHandler && mo73onScrollingEventO0kMr_c(pointerEvent)) {
                int size3 = list2.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((PointerInputChange) list2.get(i3)).consume();
                }
            }
        }
    }

    /* JADX INFO: renamed from: onScrollingEvent-O0kMr_c */
    public abstract boolean mo73onScrollingEventO0kMr_c(PointerEvent pointerEvent);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object userScroll$foundation(Function2 function2, ContinuationImpl continuationImpl) throws Throwable {
        NonTouchScrollingLogic$userScroll$1 nonTouchScrollingLogic$userScroll$1;
        if (continuationImpl instanceof NonTouchScrollingLogic$userScroll$1) {
            nonTouchScrollingLogic$userScroll$1 = (NonTouchScrollingLogic$userScroll$1) continuationImpl;
            int i = nonTouchScrollingLogic$userScroll$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nonTouchScrollingLogic$userScroll$1.label = i - Integer.MIN_VALUE;
            } else {
                nonTouchScrollingLogic$userScroll$1 = new NonTouchScrollingLogic$userScroll$1(this, continuationImpl);
            }
        } else {
            nonTouchScrollingLogic$userScroll$1 = new NonTouchScrollingLogic$userScroll$1(this, continuationImpl);
        }
        Object obj = nonTouchScrollingLogic$userScroll$1.result;
        int i2 = nonTouchScrollingLogic$userScroll$1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.mediaPlayPausePendingOnHandler = true;
            SliderState.AnonymousClass2 anonymousClass2 = new SliderState.AnonymousClass2(this, function2, continuation, (byte) 5);
            nonTouchScrollingLogic$userScroll$1.label = 1;
            SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(nonTouchScrollingLogic$userScroll$1, nonTouchScrollingLogic$userScroll$1.getContext());
            Object objStartUndispatched = Okio__OkioKt.startUndispatched(supervisorCoroutine, true, supervisorCoroutine, anonymousClass2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objStartUndispatched == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.mediaPlayPausePendingOnHandler = false;
        return Unit.INSTANCE;
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
    }

    public void onFastForward() {
    }

    public void onPause() {
    }

    public void onPlay() {
    }

    public void onPrepare() {
    }

    public void onRewind() {
    }

    public void onSkipToNext() {
    }

    public void onSkipToPrevious() {
    }

    public void onStop() {
    }

    public MediaSessionCompat$Callback(ScrollingLogic scrollingLogic, Function2 function2, Density density) {
        this.lock = scrollingLogic;
        this.callbackFwk = function2;
        this.sessionImpl = density;
        this.callbackHandler = new CallbackWrapper((byte) 2);
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void onSeekTo(long j) {
    }

    public void onSetPlaybackSpeed(float f) {
    }

    public void onSetRating(RatingCompat ratingCompat) {
    }

    public void onSetRating$1(RatingCompat ratingCompat) {
    }

    public void onSetRepeatMode(int i) {
    }

    public void onSetShuffleMode(int i) {
    }

    public void onSkipToQueueItem(long j) {
    }

    public void onCustomAction(String str, Bundle bundle) {
    }

    public void onPlayFromMediaId(String str, Bundle bundle) {
    }

    public void onPlayFromSearch(String str, Bundle bundle) {
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
    }

    public void onPrepareFromMediaId(String str, Bundle bundle) {
    }

    public void onPrepareFromSearch(String str, Bundle bundle) {
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
    }

    public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
    }
}
