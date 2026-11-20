package androidx.media3.extractor;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Extractor {
    default List getSniffFailureDetails() {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        return RegularImmutableList.EMPTY;
    }

    void init(ExtractorOutput extractorOutput);

    int read(ExtractorInput extractorInput, PositionHolder positionHolder);

    void release();

    void seek(long j, long j2);

    boolean sniff(ExtractorInput extractorInput);
}
