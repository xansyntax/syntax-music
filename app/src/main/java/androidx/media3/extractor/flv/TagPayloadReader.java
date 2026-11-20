package androidx.media3.extractor.flv;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapGroupSourceInformation;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.ui.layout.Measurable;
import androidx.media3.common.ParserException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TagPayloadReader {
    public final Object output;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(byte b) {
        switch (b) {
            case 2:
                MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
                this.output = new MutableIntObjectMap();
                break;
            case 3:
                this.output = new Object();
                break;
            case 4:
                this.output = new ArrayList();
                break;
            default:
                this.output = Stack.mutableStateOf$default(Boolean.FALSE);
                break;
        }
    }

    public boolean appendGroupSourceInformation(int i, GapGroupSourceInformation gapGroupSourceInformation, Object obj) {
        ArrayList groups = gapGroupSourceInformation.getGroups();
        boolean z = false;
        if (groups != null) {
            int size = groups.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj2 = groups.get(i2);
                if (!(obj2 instanceof GapAnchor)) {
                    if (!(obj2 instanceof GapGroupSourceInformation)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(obj2, "Unexpected child source info ");
                        break;
                    }
                    if (appendGroupSourceInformation(i, (GapGroupSourceInformation) obj2, obj)) {
                        appendTraceFrame(gapGroupSourceInformation.getKey(), gapGroupSourceInformation, obj2);
                        return true;
                    }
                } else if (obj2.equals(obj)) {
                    appendTraceFrame(gapGroupSourceInformation.getKey(), gapGroupSourceInformation, obj2);
                    return true;
                }
            }
        } else {
            if (!gapGroupSourceInformation.getClosed()) {
                appendTraceFrame(i, gapGroupSourceInformation, null);
                return true;
            }
            int dataStartOffset = gapGroupSourceInformation.getDataStartOffset();
            int dataEndOffset = gapGroupSourceInformation.getDataEndOffset();
            if (obj instanceof Integer) {
                Number number = (Number) obj;
                int iIntValue = number.intValue();
                if ((dataStartOffset <= iIntValue && iIntValue < dataEndOffset) || (dataStartOffset == dataEndOffset && dataStartOffset == number.intValue())) {
                    z = true;
                }
                if (z) {
                    appendTraceFrame(gapGroupSourceInformation.getKey(), gapGroupSourceInformation, null);
                }
                return z;
            }
        }
        return false;
    }

    public void appendTraceFrame(int i, GapGroupSourceInformation gapGroupSourceInformation, Object obj) {
        ((ArrayList) this.output).add(new ComposeStackTraceFrame(i, null, null));
    }

    public abstract void clearWatchSet$runtime(SendChannel sendChannel);

    public abstract void commitSubscriptionChanges$runtime();

    public abstract void dispose$runtime();

    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public abstract LazyLayoutMeasuredItem mo160getAndMeasurehBUhpc(int i, int i2, int i3, long j);

    public abstract Object getCurrentState();

    /* JADX INFO: renamed from: getPlaceables-3p2s80s, reason: not valid java name */
    public List m838getPlaceables3p2s80s(LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, int i, long j) {
        MutableIntObjectMap mutableIntObjectMap = (MutableIntObjectMap) this.output;
        List list = (List) mutableIntObjectMap.get(i);
        if (list != null) {
            return list;
        }
        List listCompose = lazyLayoutMeasureScopeImpl.compose(i);
        int size = listCompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Measurable) listCompose.get(i2)).mo598measureBRTryo0(j));
        }
        mutableIntObjectMap.set(i, arrayList);
        return arrayList;
    }

    public abstract Object getTargetState();

    public abstract int groupKeyOf(GapAnchor gapAnchor);

    public void processEdge(int i, Object obj, GapGroupSourceInformation gapGroupSourceInformation, Object obj2) {
        if (Intrinsics.areEqual(obj, Composer.Companion.Empty)) {
            appendTraceFrame(i, gapGroupSourceInformation, null);
        }
    }

    public abstract Function1 readObserverFor$runtime(SendChannel sendChannel);

    public abstract void reportSnapshotFlowCancellation$runtime(Channel channel);

    public abstract void setCurrentState$animation_core(Object obj);

    public abstract GapGroupSourceInformation sourceInformationOf(GapAnchor gapAnchor);

    public GapGroupSourceInformation sourceInformationOf(Object obj) {
        if (obj instanceof GapAnchor) {
            return sourceInformationOf((GapAnchor) obj);
        }
        if (obj instanceof GapGroupSourceInformation) {
            return (GapGroupSourceInformation) obj;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(obj, "Unexpected child source info ");
        return null;
    }

    public void transitionRemoved$animation_core() {
    }

    public void transitionConfigured$animation_core(Transition transition) {
    }

    public /* synthetic */ TagPayloadReader(Object obj) {
        this.output = obj;
    }
}
