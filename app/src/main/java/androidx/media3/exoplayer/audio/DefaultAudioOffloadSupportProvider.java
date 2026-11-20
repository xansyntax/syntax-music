package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.mp4.BoxParser;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultAudioOffloadSupportProvider {
    public final Context context;
    public Boolean isOffloadVariableRateSupported;

    public DefaultAudioOffloadSupportProvider(Context context) {
        this.context = context == null ? null : context.getApplicationContext();
    }

    public final AudioOffloadSupport getAudioOffloadSupport(AudioAttributes audioAttributes, Format format) {
        Boolean boolValueOf;
        boolean zBooleanValue;
        format.getClass();
        int i = format.sampleRate;
        audioAttributes.getClass();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 || i == -1) {
            return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
        }
        Boolean bool = this.isOffloadVariableRateSupported;
        boolean z = false;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            Context context = this.context;
            if (context != null) {
                String parameters = HandlerCompat$Api28Impl.getAudioManager(context).getParameters("offloadVariableRateSupported");
                boolValueOf = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
                this.isOffloadVariableRateSupported = boolValueOf;
            } else {
                boolValueOf = Boolean.FALSE;
                this.isOffloadVariableRateSupported = boolValueOf;
            }
            zBooleanValue = boolValueOf.booleanValue();
        }
        String str = format.sampleMimeType;
        str.getClass();
        int encoding = MimeTypes.getEncoding(str, format.codecs);
        if (encoding == 0 || i2 < Util.getApiLevelThatAudioFormatIntroducedAudioEncoding(encoding)) {
            return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
        }
        int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(format.channelCount);
        if (audioTrackChannelConfig == 0) {
            return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
        }
        try {
            AudioFormat audioFormatBuild = new AudioFormat.Builder().setSampleRate(i).setChannelMask(audioTrackChannelConfig).setEncoding(encoding).build();
            if (i2 >= 33) {
                int directPlaybackSupport = AudioManager.getDirectPlaybackSupport(audioFormatBuild, audioAttributes.getPlatformAudioAttributes());
                if ((directPlaybackSupport & 1) == 0) {
                    return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
                }
                z = (directPlaybackSupport & 3) == 3;
                BoxParser.StriData striData = new BoxParser.StriData();
                striData.hasLeftEyeView = true;
                striData.hasRightEyeView = z;
                striData.eyeViewsReversed = zBooleanValue;
                return striData.build();
            }
            if (i2 < 31) {
                if (!AudioManager.isOffloadedPlaybackSupported(audioFormatBuild, audioAttributes.getPlatformAudioAttributes())) {
                    return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
                }
                BoxParser.StriData striData2 = new BoxParser.StriData();
                striData2.hasLeftEyeView = true;
                striData2.eyeViewsReversed = zBooleanValue;
                return striData2.build();
            }
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatBuild, audioAttributes.getPlatformAudioAttributes());
            if (playbackOffloadSupport == 0) {
                return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
            }
            BoxParser.StriData striData3 = new BoxParser.StriData();
            if (i2 > 32 && playbackOffloadSupport == 2) {
                z = true;
            }
            striData3.hasLeftEyeView = true;
            striData3.hasRightEyeView = z;
            striData3.eyeViewsReversed = zBooleanValue;
            return striData3.build();
        } catch (IllegalArgumentException unused) {
            return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
        }
    }
}
