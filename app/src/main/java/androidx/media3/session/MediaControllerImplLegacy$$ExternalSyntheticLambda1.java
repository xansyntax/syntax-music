package androidx.media3.session;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.util.Log;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import coil3.util.UtilsKt;
import com.materialkolor.quantize.QuantizerWu;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplLegacy$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaControllerImplLegacy f$0;

    public /* synthetic */ MediaControllerImplLegacy$$ExternalSyntheticLambda1(MediaControllerImplLegacy mediaControllerImplLegacy, QuantizerWu quantizerWu) {
        this.$r8$classId = (byte) 2;
        this.f$0 = mediaControllerImplLegacy;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MediaControllerImplLegacy mediaControllerImplLegacy = this.f$0;
        switch (b) {
            case 0:
                if (!mediaControllerImplLegacy.released && ((MediaControllerCompat$MediaControllerImplApi23) mediaControllerImplLegacy.controllerCompat.mCallback).sessionToken.getExtraBinder() == null) {
                    mediaControllerImplLegacy.onConnected();
                    break;
                }
                break;
            case 1:
                Context context = mediaControllerImplLegacy.context;
                ComponentName componentName = mediaControllerImplLegacy.token.impl.getComponentName();
                EmojiProcessor emojiProcessor = new EmojiProcessor(mediaControllerImplLegacy);
                Bundle connectionHints = mediaControllerImplLegacy.instance.impl.getConnectionHints();
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat();
                mediaBrowserCompat.impl = new MediaBrowserCompat.MediaBrowserImplApi26(context, componentName, emojiProcessor, connectionHints);
                mediaControllerImplLegacy.browserCompat = mediaBrowserCompat;
                Log.d("Connecting to a MediaBrowserService.");
                ((MediaBrowserCompat.MediaBrowserImplApi26) mediaBrowserCompat.impl).browserFwk.connect();
                break;
            default:
                MediaController mediaController = mediaControllerImplLegacy.instance;
                mediaController.getClass();
                UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                MediaController.Listener listener = mediaController.listener;
                listener.getClass();
                MediaController.Listener.onSetCustomLayout();
                listener.onMediaButtonPreferencesChanged();
                break;
        }
    }

    public /* synthetic */ MediaControllerImplLegacy$$ExternalSyntheticLambda1(MediaControllerImplLegacy mediaControllerImplLegacy, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaControllerImplLegacy;
    }
}
