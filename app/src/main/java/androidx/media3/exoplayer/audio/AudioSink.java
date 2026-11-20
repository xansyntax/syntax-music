package androidx.media3.exoplayer.audio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface AudioSink {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes2.dex */
    public final class AudioTrackConfig {
        public static final AudioTrackConfig DEFAULT = new AudioTrackConfig();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InitializationException extends Exception {
        public final boolean isRecoverable;

        /* JADX WARN: Illegal instructions before constructor call */
        public InitializationException(int i, int i2, int i3, int i4, Format format, boolean z, AudioOutputProvider.InitializationException initializationException) {
            StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "AudioTrack init failed 0 Config(", ", ", i2, ", ");
            sbM3m.append(i3);
            sbM3m.append(", ");
            sbM3m.append(i4);
            sbM3m.append(") ");
            sbM3m.append(format);
            sbM3m.append(z ? " (recoverable)" : "");
            super(sbM3m.toString(), initializationException);
            this.isRecoverable = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class WriteException extends Exception {
        public final int errorCode;
        public final Format format;
        public final boolean isRecoverable;

        public WriteException(int i, Format format, boolean z) {
            super(IntIntPair$$ExternalSyntheticOutline0.m(i, "AudioTrack write failed: "));
            this.isRecoverable = z;
            this.errorCode = i;
            this.format = format;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ConfigurationException extends Exception {
        public final Format format;

        public ConfigurationException(Exception exc, Format format) {
            super(exc);
            this.format = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.format = format;
        }
    }
}
