package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.CueDecoder;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ExtractorsFactory {
    Extractor[] createExtractors();

    default Extractor[] createExtractors(Uri uri, Map map) {
        return createExtractors();
    }

    default void experimentalSetCodecsToParseWithinGopSampleDependencies() {
    }

    default void experimentalSetTextTrackTranscodingEnabled() {
    }

    default void setSubtitleParserFactory(CueDecoder cueDecoder) {
    }
}
