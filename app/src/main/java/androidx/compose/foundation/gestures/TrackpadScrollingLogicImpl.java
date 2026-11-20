package androidx.compose.foundation.gestures;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.session.legacy.MediaSessionCompat$Callback;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.sequences.SequenceBuilderIterator;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TrackpadScrollingLogicImpl extends MediaSessionCompat$Callback {
    public final /* synthetic */ ProvidableModifierLocal $$delegate_0;
    public final ScrollingLogic$$ExternalSyntheticLambda0 canConsumeDelta;
    public final BufferedChannel channel;
    public StandaloneCoroutine receivingPanEventsJob;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TrackpadScrollDelta {
        public final boolean isEnd;
        public final long timeMillis;
        public final long value;

        public TrackpadScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.isEnd = z;
        }

        public final TrackpadScrollDelta plus(TrackpadScrollDelta trackpadScrollDelta) {
            return new TrackpadScrollDelta(Offset.m439plusMKHz9U(this.value, trackpadScrollDelta.value), Math.max(this.timeMillis, trackpadScrollDelta.timeMillis), this.isEnd || trackpadScrollDelta.isEnd);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TrackpadScrollingLogicImpl$dispatchTrackpadScroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackpadScrollingLogicImpl.this.dispatchTrackpadScroll(null, this);
        }
    }

    public TrackpadScrollingLogicImpl(ProvidableModifierLocal providableModifierLocal, ScrollingLogic scrollingLogic, ComposableLambdaImpl.AnonymousClass1 anonymousClass1, Density density, ScrollingLogic$$ExternalSyntheticLambda0 scrollingLogic$$ExternalSyntheticLambda0) {
        super(scrollingLogic, anonymousClass1, density);
        this.$$delegate_0 = providableModifierLocal;
        this.canConsumeDelta = scrollingLogic$$ExternalSyntheticLambda0;
        this.channel = EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
    }

    /* JADX INFO: renamed from: isZero-k-4lQ0M, reason: not valid java name */
    public static boolean m108isZerok4lQ0M(long j) {
        return Float.intBitsToFloat((int) (j >> 32)) == CropImageView.DEFAULT_ASPECT_RATIO && Float.intBitsToFloat((int) (j & 4294967295L)) == CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public static TrackpadScrollDelta sumOrNull(BufferedChannel bufferedChannel) {
        TrackpadScrollDelta trackpadScrollDelta = null;
        SequenceBuilderIterator it = EntryPoints.iterator(new NonTouchScrollingLogicKt$untilNull$1(new TrackpadScrollingLogicImpl$$ExternalSyntheticLambda0(bufferedChannel, (byte) 0), null));
        while (it.hasNext()) {
            TrackpadScrollDelta trackpadScrollDeltaPlus = (TrackpadScrollDelta) it.next();
            if (trackpadScrollDelta != null) {
                trackpadScrollDeltaPlus = trackpadScrollDelta.plus(trackpadScrollDeltaPlus);
            }
            trackpadScrollDelta = trackpadScrollDeltaPlus;
        }
        return trackpadScrollDelta;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d7, code lost:
    
        if (r0.invoke(r3, r4) == r9) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispatchTrackpadScroll(TrackpadScrollDelta trackpadScrollDelta, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        CallbackWrapper callbackWrapper = (CallbackWrapper) this.callbackHandler;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
        ref$ObjectRefM5m.element = trackpadScrollDelta;
        long j = trackpadScrollDelta.timeMillis;
        long j2 = trackpadScrollDelta.value;
        ((VelocityTracker1D) callbackWrapper.mCallback).addDataPoint(j, Float.intBitsToFloat((int) (j2 >> 32)));
        ((VelocityTracker1D) callbackWrapper.mExecutor).addDataPoint(j, Float.intBitsToFloat((int) (j2 & 4294967295L)));
        TrackpadScrollDelta trackpadScrollDeltaSumOrNull = sumOrNull(this.channel);
        if (trackpadScrollDeltaSumOrNull != null) {
            long j3 = trackpadScrollDeltaSumOrNull.timeMillis;
            long j4 = trackpadScrollDeltaSumOrNull.value;
            ((VelocityTracker1D) callbackWrapper.mCallback).addDataPoint(j3, Float.intBitsToFloat((int) (j4 >> 32)));
            ((VelocityTracker1D) callbackWrapper.mExecutor).addDataPoint(j3, Float.intBitsToFloat((int) (j4 & 4294967295L)));
            ref$ObjectRefM5m.element = ((TrackpadScrollDelta) ref$ObjectRefM5m.element).plus(trackpadScrollDeltaSumOrNull);
        }
        Function2 innerTube$feedback$2 = new InnerTube$feedback$2(this, ref$ObjectRefM5m, continuation, (byte) 4);
        anonymousClass1.label = 1;
        if (userScroll$foundation(innerTube$feedback$2, anonymousClass1) != obj2) {
        }
        return obj2;
        Function2 function2 = (Function2) this.callbackFwk;
        Velocity velocity = new Velocity(MathKt.Velocity(((VelocityTracker1D) callbackWrapper.mCallback).calculateVelocity(Float.MAX_VALUE), ((VelocityTracker1D) callbackWrapper.mExecutor).calculateVelocity(Float.MAX_VALUE)));
        anonymousClass1.label = 2;
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final boolean isScrollingEvent(PointerEvent pointerEvent) {
        int i = pointerEvent.type;
        return i == 10 || i == 11 || i == 12;
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    /* JADX INFO: renamed from: onScrollingEvent-O0kMr_c */
    public final boolean mo73onScrollingEventO0kMr_c(PointerEvent pointerEvent) {
        BufferedChannel bufferedChannel;
        ProvidableModifierLocal providableModifierLocal;
        long j;
        ScrollingLogic scrollingLogic = this.canConsumeDelta.f$0;
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull(pointerEvent.changes);
        if (pointerInputChange == null) {
            return this.mediaPlayPausePendingOnHandler;
        }
        long j2 = pointerInputChange.panOffset;
        if (pointerEvent.type == 10 && m108isZerok4lQ0M(j2)) {
            List historical = pointerInputChange.getHistorical();
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                if (m108isZerok4lQ0M(((HistoricalChange) historical.get(i)).panOffset)) {
                }
            }
            return this.mediaPlayPausePendingOnHandler;
        }
        List historical2 = pointerInputChange.getHistorical();
        int size2 = historical2.size();
        int i2 = 0;
        boolean z = false;
        while (true) {
            bufferedChannel = this.channel;
            providableModifierLocal = this.$$delegate_0;
            if (i2 >= size2) {
                break;
            }
            HistoricalChange historicalChange = (HistoricalChange) historical2.get(i2);
            long j3 = historicalChange.panOffset ^ (-9223372034707292160L);
            float fReverseIfNeeded = scrollingLogic.reverseIfNeeded(ProvidableModifierLocal.m627decodeToFloatsgRZ0Mg(providableModifierLocal.m637toScrollValueYk_gXsc(j3)));
            if (fReverseIfNeeded < CropImageView.DEFAULT_ASPECT_RATIO ? scrollingLogic.scrollableState.getCanScrollBackward() : fReverseIfNeeded > CropImageView.DEFAULT_ASPECT_RATIO ? scrollingLogic.scrollableState.getCanScrollForward() : false) {
                j = j2;
                z = !(bufferedChannel.mo1712trySendJP2dKIU(new TrackpadScrollDelta(j3, historicalChange.uptimeMillis, false)) instanceof ChannelResult.Failed) || z;
            } else {
                j = j2;
            }
            i2++;
            j2 = j;
        }
        long j4 = j2 ^ (-9223372034707292160L);
        boolean z2 = pointerEvent.type == 12;
        float fReverseIfNeeded2 = scrollingLogic.reverseIfNeeded(ProvidableModifierLocal.m627decodeToFloatsgRZ0Mg(providableModifierLocal.m637toScrollValueYk_gXsc(j4)));
        if ((fReverseIfNeeded2 < CropImageView.DEFAULT_ASPECT_RATIO ? scrollingLogic.scrollableState.getCanScrollBackward() : fReverseIfNeeded2 > CropImageView.DEFAULT_ASPECT_RATIO ? scrollingLogic.scrollableState.getCanScrollForward() : false) || z2) {
            z = !(bufferedChannel.mo1712trySendJP2dKIU(new TrackpadScrollDelta(j4, pointerInputChange.uptimeMillis, z2)) instanceof ChannelResult.Failed) || z;
        }
        return z || this.mediaPlayPausePendingOnHandler;
    }
}
