package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SlotTable implements CompositionData, Iterable, KMappedMarker {
    public MutableIntObjectMap calledByMap;
    public int groupsSize;
    public int readers;
    public int slotsSize;
    public HashMap sourceInformationMap;
    public int version;
    public boolean writer;
    public int[] groups = new int[0];
    public Object[] slots = new Object[0];
    public final Object lock = new Object();
    public ArrayList anchors = new ArrayList();

    public final int anchorIndex(GapAnchor gapAnchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        if (!gapAnchor.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return gapAnchor.location;
    }

    public final void collectSourceInformation() {
        this.sourceInformationMap = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disposeUnusedMovableContent(RememberEventDispatcher rememberEventDispatcher) {
        SlotWriter slotWriterOpenWriter = openWriter();
        boolean z = false;
        try {
            slotWriterOpenWriter.forAllDataInRememberOrder(slotWriterOpenWriter.currentGroup, new ComposerKt$$ExternalSyntheticLambda0(0 == true ? 1 : 0, rememberEventDispatcher));
            slotWriterOpenWriter.removeGroup();
            boolean z2 = true;
        } finally {
            slotWriterOpenWriter.close(z);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (this.writer) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot read while a writer is pending");
            return null;
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (this.readers > 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(GapAnchor gapAnchor) {
        int iSearch;
        return gapAnchor.getValid() && (iSearch = SlotTableKt.search(this.anchors, gapAnchor.location, this.groupsSize)) >= 0 && Intrinsics.areEqual(this.anchors.get(iSearch), gapAnchor);
    }

    public final GapGroupSourceInformation sourceInformationOf(int i) {
        int i2;
        ArrayList arrayList;
        int iSearch;
        HashMap map = this.sourceInformationMap;
        if (map != null) {
            if (this.writer) {
                ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
            }
            GapAnchor gapAnchor = (i < 0 || i >= (i2 = this.groupsSize) || (iSearch = SlotTableKt.search((arrayList = this.anchors), i, i2)) < 0) ? null : (GapAnchor) arrayList.get(iSearch);
            if (gapAnchor != null) {
                return (GapGroupSourceInformation) map.get(gapAnchor);
            }
        }
        return null;
    }
}
