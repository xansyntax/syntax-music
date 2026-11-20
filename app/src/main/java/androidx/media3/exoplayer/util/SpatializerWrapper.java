package androidx.media3.exoplayer.util;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.session.DefaultMediaNotificationProvider$$ExternalSyntheticLambda1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpatializerWrapper {
    public final Handler handler;
    public final AnonymousClass1 listener;
    public final boolean spatializationSupported;
    public final Spatializer spatializer;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.media.Spatializer$OnSpatializerStateChangedListener, androidx.media3.exoplayer.util.SpatializerWrapper$1] */
    public SpatializerWrapper(Context context, final Runnable runnable, Boolean bool) {
        AudioManager audioManager = context == null ? null : HandlerCompat$Api28Impl.getAudioManager(context);
        if (audioManager == null || (bool != null && bool.booleanValue())) {
            this.spatializer = null;
            this.spatializationSupported = false;
            this.handler = null;
            this.listener = null;
            return;
        }
        Spatializer spatializer = audioManager.getSpatializer();
        this.spatializer = spatializer;
        this.spatializationSupported = spatializer.getImmersiveAudioLevel() != 0;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        Handler handler = new Handler(looperMyLooper);
        this.handler = handler;
        ?? r1 = new Spatializer$OnSpatializerStateChangedListener() { // from class: androidx.media3.exoplayer.util.SpatializerWrapper.1
            public final void onSpatializerAvailableChanged(Spatializer spatializer2, boolean z) {
                runnable.run();
            }

            public final void onSpatializerEnabledChanged(Spatializer spatializer2, boolean z) {
                runnable.run();
            }
        };
        this.listener = r1;
        spatializer.addOnSpatializerStateChangedListener(new DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(handler, (byte) 1), r1);
    }

    public final boolean canBeSpatialized(AudioAttributes audioAttributes, Format format) {
        if (this.spatializer == null || !this.spatializationSupported || !isAvailable() || !isEnabled()) {
            return false;
        }
        String str = format.sampleMimeType;
        int i = format.channelCount;
        if (Objects.equals(str, "audio/eac3-joc")) {
            if (i == 16) {
                i = 12;
            }
        } else if (Objects.equals(str, "audio/iamf")) {
            if (i == -1) {
                i = 6;
            }
        } else if (Objects.equals(str, "audio/ac4") && (i == 18 || i == 21)) {
            i = 24;
        }
        int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i);
        if (audioTrackChannelConfig == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(audioTrackChannelConfig);
        int i2 = format.sampleRate;
        if (i2 != -1) {
            channelMask.setSampleRate(i2);
        }
        Spatializer spatializer = this.spatializer;
        spatializer.getClass();
        return spatializer.canBeSpatialized(audioAttributes.getPlatformAudioAttributes(), channelMask.build());
    }

    public final List getSpatializedChannelMasks() {
        if (this.spatializer == null || !this.spatializationSupported || !isAvailable() || !isEnabled()) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }
        if (Build.VERSION.SDK_INT < 36) {
            return ImmutableList.of((Object) 252);
        }
        Spatializer spatializer = this.spatializer;
        spatializer.getClass();
        return spatializer.getSpatializedChannelMasks();
    }

    public final boolean isAvailable() {
        Spatializer spatializer = this.spatializer;
        return spatializer != null && spatializer.isAvailable();
    }

    public final boolean isEnabled() {
        Spatializer spatializer = this.spatializer;
        return spatializer != null && spatializer.isEnabled();
    }

    public final void release() {
        AnonymousClass1 anonymousClass1;
        Handler handler;
        Spatializer spatializer = this.spatializer;
        if (spatializer == null || (anonymousClass1 = this.listener) == null || (handler = this.handler) == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(anonymousClass1);
        handler.removeCallbacksAndMessages(null);
    }
}
