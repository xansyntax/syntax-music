package androidx.media3.exoplayer.metadata;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import androidx.media3.extractor.metadata.icy.IcyDecoder;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.scte35.SpliceInfoDecoder;
import androidx.sqlite.SQLite;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataDecoderFactory$1 {
    public static final MetadataDecoderFactory$1 DEFAULT = new MetadataDecoderFactory$1();

    public final SQLite createDecoder(Format format) {
        String str = format.sampleMimeType;
        if (str != null) {
            switch (str) {
                case "application/vnd.dvb.ait":
                    return new EventMessageDecoder((byte) 1);
                case "application/x-icy":
                    return new IcyDecoder();
                case "application/id3":
                    return new Id3Decoder(null);
                case "application/x-emsg":
                    return new EventMessageDecoder((byte) 0);
                case "application/x-scte35":
                    return new SpliceInfoDecoder();
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Attempted to create decoder for unsupported MIME type: ", str));
        return null;
    }

    public final boolean supportsFormat(Format format) {
        String str = format.sampleMimeType;
        return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
    }
}
