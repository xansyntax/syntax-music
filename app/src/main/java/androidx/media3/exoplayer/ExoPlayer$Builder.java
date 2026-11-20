package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import androidx.collection.internal.Lock;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda15;
import coil3.util.LifecyclesKt;
import com.google.common.base.Supplier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExoPlayer$Builder {
    public static final int DEFAULT_STUCK_PLAYING_DETECTION_TIMEOUT_MS;
    public static final boolean experimentalEnableStuckPlayingDetection;
    public AudioAttributes audioAttributes;
    public final ExoPlayer$Builder$$ExternalSyntheticLambda2 bandwidthMeterSupplier;
    public boolean buildCalled;
    public final Context context;
    public boolean deviceVolumeControlEnabled;
    public boolean handleAudioBecomingNoisy;
    public final DefaultLivePlaybackSpeedControl livePlaybackSpeedControl;
    public Supplier loadControlSupplier;
    public final Looper looper;
    public Supplier mediaSourceFactorySupplier;
    public Supplier renderersFactorySupplier;
    public final ScrubbingModeParameters scrubbingModeParameters;
    public short seekForwardIncrementMs;
    public final SeekParameters seekParameters;
    public final int stuckPlayingDetectionTimeoutMs;
    public final int stuckPlayingNotEndingTimeoutMs;
    public final ExoPlayer$Builder$$ExternalSyntheticLambda2 trackSelectorSupplier;
    public byte wakeMode;
    public boolean wakeModeSet;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        String lowerCase = LifecyclesKt.toLowerCase(Build.DEVICE);
        DEFAULT_STUCK_PLAYING_DETECTION_TIMEOUT_MS = (lowerCase.contains("emulator") || lowerCase.contains("emu64a") || lowerCase.contains("emu64x") || lowerCase.contains("generic")) ? 30000 : 10000;
        experimentalEnableStuckPlayingDetection = true;
    }

    public ExoPlayer$Builder(Context context) {
        ExoPlayer$Builder$$ExternalSyntheticLambda2 exoPlayer$Builder$$ExternalSyntheticLambda2 = new ExoPlayer$Builder$$ExternalSyntheticLambda2(context, (byte) 0);
        ExoPlayer$Builder$$ExternalSyntheticLambda2 exoPlayer$Builder$$ExternalSyntheticLambda3 = new ExoPlayer$Builder$$ExternalSyntheticLambda2(context, (byte) 2);
        ExoPlayer$Builder$$ExternalSyntheticLambda2 exoPlayer$Builder$$ExternalSyntheticLambda4 = new ExoPlayer$Builder$$ExternalSyntheticLambda2(context, (byte) 3);
        MediaSessionImpl$$ExternalSyntheticLambda15 mediaSessionImpl$$ExternalSyntheticLambda15 = new MediaSessionImpl$$ExternalSyntheticLambda15((byte) 2);
        ExoPlayer$Builder$$ExternalSyntheticLambda2 exoPlayer$Builder$$ExternalSyntheticLambda5 = new ExoPlayer$Builder$$ExternalSyntheticLambda2(context, (byte) 4);
        context.getClass();
        this.context = context;
        this.renderersFactorySupplier = exoPlayer$Builder$$ExternalSyntheticLambda2;
        this.mediaSourceFactorySupplier = exoPlayer$Builder$$ExternalSyntheticLambda3;
        this.trackSelectorSupplier = exoPlayer$Builder$$ExternalSyntheticLambda4;
        this.loadControlSupplier = mediaSessionImpl$$ExternalSyntheticLambda15;
        this.bandwidthMeterSupplier = exoPlayer$Builder$$ExternalSyntheticLambda5;
        this.looper = Util.getCurrentOrMainLooper();
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.wakeMode = (byte) 0;
        this.seekParameters = SeekParameters.DEFAULT;
        this.seekForwardIncrementMs = (short) 15000;
        this.scrubbingModeParameters = ScrubbingModeParameters.DEFAULT;
        this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl(Util.msToUs(20L), Util.msToUs(500L));
        boolean z = experimentalEnableStuckPlayingDetection;
        this.stuckPlayingDetectionTimeoutMs = z ? DEFAULT_STUCK_PLAYING_DETECTION_TIMEOUT_MS : Integer.MAX_VALUE;
        this.stuckPlayingNotEndingTimeoutMs = z ? 60000 : Integer.MAX_VALUE;
        new Lock();
    }
}
