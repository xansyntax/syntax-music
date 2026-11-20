package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface AudioOutputProvider {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ConfigurationException extends Exception {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FormatSupport {
        public boolean isFormatSupportedForOffload;
        public boolean isGaplessSupportedForOffload;
        public boolean isSpeedChangeSupportedForOffload;
        public int supportLevel;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InitializationException extends Exception {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OutputConfig {
        public final AudioAttributes audioAttributes;
        public final int audioSessionId;
        public final int bufferSize;
        public final int channelMask;
        public final int encoding;
        public final boolean isOffload;
        public final boolean isTunneling;
        public final int sampleRate;
        public final boolean useOffloadGapless;
        public final boolean usePlaybackParameters;
        public final int virtualDeviceId;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Builder {
            public AudioAttributes audioAttributes;
            public int audioSessionId;
            public int bufferSize;
            public int channelMask;
            public int encoding;
            public boolean isOffload;
            public boolean isTunneling;
            public int sampleRate;
            public boolean useOffloadGapless;
            public boolean usePlaybackParameters;
            public int virtualDeviceId;
        }

        public OutputConfig(Builder builder) {
            this.encoding = builder.encoding;
            this.sampleRate = builder.sampleRate;
            this.channelMask = builder.channelMask;
            this.isTunneling = builder.isTunneling;
            this.isOffload = builder.isOffload;
            this.bufferSize = builder.bufferSize;
            this.audioAttributes = builder.audioAttributes;
            this.audioSessionId = builder.audioSessionId;
            this.virtualDeviceId = builder.virtualDeviceId;
            this.usePlaybackParameters = builder.usePlaybackParameters;
            this.useOffloadGapless = builder.useOffloadGapless;
        }

        public final Builder buildUpon() {
            Builder builder = new Builder();
            builder.encoding = this.encoding;
            builder.sampleRate = this.sampleRate;
            builder.channelMask = this.channelMask;
            builder.isTunneling = this.isTunneling;
            builder.isOffload = this.isOffload;
            builder.bufferSize = this.bufferSize;
            builder.audioAttributes = this.audioAttributes;
            builder.audioSessionId = this.audioSessionId;
            builder.virtualDeviceId = this.virtualDeviceId;
            builder.usePlaybackParameters = this.usePlaybackParameters;
            builder.useOffloadGapless = this.useOffloadGapless;
            return builder;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || OutputConfig.class != obj.getClass()) {
                return false;
            }
            OutputConfig outputConfig = (OutputConfig) obj;
            return this.encoding == outputConfig.encoding && this.sampleRate == outputConfig.sampleRate && this.channelMask == outputConfig.channelMask && this.isTunneling == outputConfig.isTunneling && this.isOffload == outputConfig.isOffload && this.bufferSize == outputConfig.bufferSize && this.audioSessionId == outputConfig.audioSessionId && this.virtualDeviceId == outputConfig.virtualDeviceId && this.usePlaybackParameters == outputConfig.usePlaybackParameters && this.useOffloadGapless == outputConfig.useOffloadGapless && this.audioAttributes.equals(outputConfig.audioAttributes);
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.encoding), Integer.valueOf(this.sampleRate), Integer.valueOf(this.channelMask), Boolean.valueOf(this.isTunneling), Boolean.valueOf(this.isOffload), Integer.valueOf(this.bufferSize), this.audioAttributes, Integer.valueOf(this.audioSessionId), Integer.valueOf(this.virtualDeviceId), Boolean.valueOf(this.useOffloadGapless), Boolean.valueOf(this.usePlaybackParameters));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FormatConfig {
        public AudioAttributes audioAttributes;
        public int audioSessionId;
        public boolean enableOffload;
        public boolean enablePlaybackParameters;
        public boolean enableTunneling;
        public final Format format;
        public AudioDeviceInfo preferredDevice;
        public int virtualDeviceId;

        public FormatConfig(FormatConfig formatConfig) {
            this.format = formatConfig.format;
            this.audioAttributes = formatConfig.audioAttributes;
            this.preferredDevice = formatConfig.preferredDevice;
            this.enablePlaybackParameters = formatConfig.enablePlaybackParameters;
            this.enableOffload = formatConfig.enableOffload;
            this.audioSessionId = formatConfig.audioSessionId;
            this.virtualDeviceId = formatConfig.virtualDeviceId;
            this.enableTunneling = formatConfig.enableTunneling;
        }

        public FormatConfig(Format format) {
            this.format = format;
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.audioSessionId = 0;
            this.virtualDeviceId = -1;
        }
    }
}
