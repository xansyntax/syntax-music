package androidx.media3.common.text;

import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.util.Util;
import com.google.common.collect.ByFunctionOrdering;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CueGroup {
    public static final ByFunctionOrdering CUES_PRIORITY_COMPARATOR = new ByFunctionOrdering(new Format$$ExternalSyntheticLambda1((byte) 7), NaturalOrdering.INSTANCE);
    public static final CueGroup EMPTY_TIME_ZERO;
    public static final String FIELD_CUES;
    public static final String FIELD_PRESENTATION_TIME_US;
    public final RegularImmutableList cues;
    public final long presentationTimeUs;

    static {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        EMPTY_TIME_ZERO = new CueGroup(RegularImmutableList.EMPTY, 0L);
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_CUES = Integer.toString(0, 36);
        FIELD_PRESENTATION_TIME_US = Integer.toString(1, 36);
    }

    public CueGroup(List list, long j) {
        this.cues = ImmutableList.sortedCopyOf(CUES_PRIORITY_COMPARATOR, list);
        this.presentationTimeUs = j;
    }
}
