package androidx.media3.extractor.mp4;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.extractor.SniffFailure;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IncorrectFragmentationSniffFailure implements SniffFailure {
    public static final IncorrectFragmentationSniffFailure FILE_FRAGMENTED = new IncorrectFragmentationSniffFailure(true);
    public static final IncorrectFragmentationSniffFailure FILE_NOT_FRAGMENTED = new IncorrectFragmentationSniffFailure(false);
    public final boolean fileIsFragmented;

    public IncorrectFragmentationSniffFailure(boolean z) {
        this.fileIsFragmented = z;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("IncorrectFragmentation{expected="), !this.fileIsFragmented, "}");
    }
}
