package androidx.media3.extractor.flv;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioTagPayloadReader extends TagPayloadReader {
    public static final int[] AUDIO_SAMPLING_RATE_TABLE = {5512, 11025, 22050, 44100};
    public int audioFormat;
    public boolean hasOutputFormat;
    public boolean hasParsedAudioDataHeader;
}
