package androidx.compose.foundation.gestures;

import android.os.Build;
import android.view.ViewConfiguration;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.session.legacy.MediaSessionCompat$Callback;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.sequences.SequenceBuilderIterator;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MouseWheelScrollingLogicImpl extends MediaSessionCompat$Callback {
    public final /* synthetic */ ProvidableModifierLocal $$delegate_0;
    public final ScrollingLogic$$ExternalSyntheticLambda0 canConsumeDelta;
    public final BufferedChannel channel;
    public StandaloneCoroutine receivingMouseWheelEventsJob;
    public final DrawResult scrollConfig;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MouseWheelScrollDelta {
        public final boolean shouldApplyImmediately;
        public final long timeMillis;
        public final long value;

        public MouseWheelScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.shouldApplyImmediately = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MouseWheelScrollDelta)) {
                return false;
            }
            MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) obj;
            return Offset.m434equalsimpl0(this.value, mouseWheelScrollDelta.value) && this.timeMillis == mouseWheelScrollDelta.timeMillis && this.shouldApplyImmediately == mouseWheelScrollDelta.shouldApplyImmediately;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.shouldApplyImmediately) + IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.value) * 31, 31, this.timeMillis);
        }

        public final MouseWheelScrollDelta plus(MouseWheelScrollDelta mouseWheelScrollDelta) {
            return new MouseWheelScrollDelta(Offset.m439plusMKHz9U(this.value, mouseWheelScrollDelta.value), Math.max(this.timeMillis, mouseWheelScrollDelta.timeMillis), this.shouldApplyImmediately);
        }

        public final String toString() {
            return "MouseWheelScrollDelta(value=" + Offset.m441toStringimpl(this.value) + ", timeMillis=" + this.timeMillis + ", shouldApplyImmediately=" + this.shouldApplyImmediately + ")";
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public Ref$LongRef L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MouseWheelScrollingLogicImpl.this.dispatchMouseWheelScroll(null, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Ref$ObjectRef $animationState;
        public final /* synthetic */ float $speed;
        public final /* synthetic */ Ref$ObjectRef $targetScrollDelta;
        public final /* synthetic */ Ref$LongRef $targetValue;
        public final /* synthetic */ float $threshold;
        public int I$0;
        public /* synthetic */ Object L$0;
        public Ref$BooleanRef L$1;
        public Ref$BooleanRef L$2;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Ref$ObjectRef ref$ObjectRef, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2, float f, float f2, Continuation continuation) {
            super(2, continuation);
            this.$animationState = ref$ObjectRef;
            this.$targetValue = ref$LongRef;
            this.$targetScrollDelta = ref$ObjectRef2;
            this.$threshold = f;
            this.$speed = f2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = MouseWheelScrollingLogicImpl.this.new AnonymousClass3(this.$animationState, this.$targetValue, this.$targetScrollDelta, this.$threshold, this.$speed, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0080  */
        /* JADX WARN: Code duplicated, block: B:17:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:19:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:21:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:23:0x0105  */
        /* JADX WARN: Code duplicated, block: B:27:0x015f  */
        /* JADX WARN: Code duplicated, block: B:30:0x0166  */
        /* JADX WARN: Code duplicated, block: B:33:0x016b  */
        /* JADX WARN: Code duplicated, block: B:36:0x0186  */
        /* JADX WARN: Code duplicated, block: B:39:0x019b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0186 -> B:37:0x0187). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x019b -> B:13:0x007a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instruction units count: 485
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogicImpl.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public MouseWheelScrollingLogicImpl(ProvidableModifierLocal providableModifierLocal, ScrollingLogic scrollingLogic, DrawResult drawResult, ComposableLambdaImpl.AnonymousClass1 anonymousClass1, Density density, ScrollingLogic$$ExternalSyntheticLambda0 scrollingLogic$$ExternalSyntheticLambda0) {
        super(scrollingLogic, anonymousClass1, density);
        this.$$delegate_0 = providableModifierLocal;
        this.scrollConfig = drawResult;
        this.canConsumeDelta = scrollingLogic$$ExternalSyntheticLambda0;
        this.channel = EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static final Object dispatchMouseWheelScroll$waitNextScrollDelta(MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl, Ref$ObjectRef ref$ObjectRef, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2, long j, ContinuationImpl continuationImpl) {
        MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1 mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1;
        MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl2;
        Ref$ObjectRef ref$ObjectRef3;
        Ref$LongRef ref$LongRef2;
        Ref$ObjectRef ref$ObjectRef4;
        boolean z;
        if (continuationImpl instanceof MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1) {
            mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1 = (MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1) continuationImpl;
            int i = mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.label = i - Integer.MIN_VALUE;
            } else {
                mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1 = new MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1(continuationImpl);
            }
        } else {
            mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1 = new MouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1(continuationImpl);
        }
        Object objM1899withTimeoutOrNullKLykuaI = mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.result;
        int i2 = mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM1899withTimeoutOrNullKLykuaI);
            if (j < 0) {
                return Boolean.FALSE;
            }
            Path.Companion companion = Duration.Companion;
            long duration = InstantKt.toDuration(j, DurationUnit.MILLISECONDS);
            SyncUtils.AnonymousClass2 anonymousClass2 = new SyncUtils.AnonymousClass2(mouseWheelScrollingLogicImpl, continuation, (byte) 5);
            mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$0 = mouseWheelScrollingLogicImpl;
            mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$1 = ref$ObjectRef;
            mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$2 = ref$LongRef;
            mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$3 = ref$ObjectRef2;
            mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.label = 1;
            objM1899withTimeoutOrNullKLykuaI = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration, anonymousClass2, mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM1899withTimeoutOrNullKLykuaI == coroutineSingletons) {
                return coroutineSingletons;
            }
            mouseWheelScrollingLogicImpl2 = mouseWheelScrollingLogicImpl;
            ref$ObjectRef3 = ref$ObjectRef;
            ref$LongRef2 = ref$LongRef;
            ref$ObjectRef4 = ref$ObjectRef2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Ref$ObjectRef ref$ObjectRef5 = mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$3;
            ref$LongRef2 = mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$2;
            ref$ObjectRef3 = mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$1;
            MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl3 = mouseWheelScrollingLogicImpl$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$0;
            ResultKt.throwOnFailure(objM1899withTimeoutOrNullKLykuaI);
            ref$ObjectRef4 = ref$ObjectRef5;
            mouseWheelScrollingLogicImpl2 = mouseWheelScrollingLogicImpl3;
        }
        MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) objM1899withTimeoutOrNullKLykuaI;
        if (mouseWheelScrollDelta != null) {
            boolean z2 = ((MouseWheelScrollDelta) ref$ObjectRef3.element).shouldApplyImmediately;
            long j2 = mouseWheelScrollDelta.value;
            ref$ObjectRef3.element = new MouseWheelScrollDelta(j2, mouseWheelScrollDelta.timeMillis, z2);
            ProvidableModifierLocal providableModifierLocal = mouseWheelScrollingLogicImpl2.$$delegate_0;
            ref$LongRef2.element = providableModifierLocal.m637toScrollValueYk_gXsc(j2);
            ref$ObjectRef4.element = providableModifierLocal.newAnimationState();
            CallbackWrapper callbackWrapper = (CallbackWrapper) mouseWheelScrollingLogicImpl2.callbackHandler;
            long j3 = mouseWheelScrollDelta.timeMillis;
            long j4 = mouseWheelScrollDelta.value;
            ((VelocityTracker1D) callbackWrapper.mCallback).addDataPoint(j3, Float.intBitsToFloat((int) (j4 >> 32)));
            ((VelocityTracker1D) callbackWrapper.mExecutor).addDataPoint(j3, Float.intBitsToFloat((int) (j4 & 4294967295L)));
            z = !providableModifierLocal.m630isLowScrollingDeltasgRZ0Mg(ref$LongRef2.element);
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static MouseWheelScrollDelta sumOrNull(BufferedChannel bufferedChannel) {
        MouseWheelScrollDelta mouseWheelScrollDelta = null;
        SequenceBuilderIterator it = EntryPoints.iterator(new NonTouchScrollingLogicKt$untilNull$1(new TrackpadScrollingLogicImpl$$ExternalSyntheticLambda0(bufferedChannel, (byte) 1), null));
        while (it.hasNext()) {
            MouseWheelScrollDelta mouseWheelScrollDeltaPlus = (MouseWheelScrollDelta) it.next();
            if (mouseWheelScrollDelta != null) {
                mouseWheelScrollDeltaPlus = mouseWheelScrollDelta.plus(mouseWheelScrollDeltaPlus);
            }
            mouseWheelScrollDelta = mouseWheelScrollDeltaPlus;
        }
        return mouseWheelScrollDelta;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    public final Object dispatchMouseWheelScroll(MouseWheelScrollDelta mouseWheelScrollDelta, float f, float f2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Unit unit;
        Ref$LongRef ref$LongRef;
        float f3;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        Unit unit2 = Unit.INSTANCE;
        ProvidableModifierLocal providableModifierLocal = this.$$delegate_0;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
            ref$ObjectRefM5m.element = mouseWheelScrollDelta;
            long j = mouseWheelScrollDelta.timeMillis;
            long j2 = mouseWheelScrollDelta.value;
            unit = unit2;
            ((VelocityTracker1D) callbackWrapper.mCallback).addDataPoint(j, Float.intBitsToFloat((int) (j2 >> 32)));
            ((VelocityTracker1D) callbackWrapper.mExecutor).addDataPoint(j, Float.intBitsToFloat((int) (j2 & 4294967295L)));
            MouseWheelScrollDelta mouseWheelScrollDeltaSumOrNull = sumOrNull(this.channel);
            if (mouseWheelScrollDeltaSumOrNull != null) {
                long j3 = mouseWheelScrollDeltaSumOrNull.timeMillis;
                long j4 = mouseWheelScrollDeltaSumOrNull.value;
                ((VelocityTracker1D) callbackWrapper.mCallback).addDataPoint(j3, Float.intBitsToFloat((int) (j4 >> 32)));
                ((VelocityTracker1D) callbackWrapper.mExecutor).addDataPoint(j3, Float.intBitsToFloat((int) (j4 & 4294967295L)));
                ref$ObjectRefM5m.element = ((MouseWheelScrollDelta) ref$ObjectRefM5m.element).plus(mouseWheelScrollDeltaSumOrNull);
            }
            ref$LongRef = new Ref$LongRef();
            long jM637toScrollValueYk_gXsc = providableModifierLocal.m637toScrollValueYk_gXsc(((MouseWheelScrollDelta) ref$ObjectRefM5m.element).value);
            ref$LongRef.element = jM637toScrollValueYk_gXsc;
            if (!providableModifierLocal.m630isLowScrollingDeltasgRZ0Mg(jM637toScrollValueYk_gXsc)) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = providableModifierLocal.newAnimationState();
                Function2 anonymousClass3 = new AnonymousClass3(ref$ObjectRef, ref$LongRef, ref$ObjectRefM5m, f, f2, null);
                anonymousClass2.L$0 = ref$LongRef;
                anonymousClass2.F$0 = f2;
                anonymousClass2.label = 1;
                if (userScroll$foundation(anonymousClass3, anonymousClass2) != obj2) {
                    f3 = f2;
                }
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj);
                return unit2;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        f3 = anonymousClass2.F$0;
        ref$LongRef = anonymousClass2.L$0;
        ResultKt.throwOnFailure(obj);
        unit = unit2;
        long jVelocity = MathKt.Velocity(((VelocityTracker1D) callbackWrapper.mCallback).calculateVelocity(Float.MAX_VALUE), ((VelocityTracker1D) callbackWrapper.mExecutor).calculateVelocity(Float.MAX_VALUE));
        if (jVelocity == 0) {
            float fM627decodeToFloatsgRZ0Mg = ProvidableModifierLocal.m627decodeToFloatsgRZ0Mg(providableModifierLocal.m635timesuGREC7s(providableModifierLocal.m635timesuGREC7s(providableModifierLocal.m632normalizeuqq3eFI(ref$LongRef.element), Math.min(providableModifierLocal.m634sizesgRZ0Mg(ref$LongRef.element) / 100.0f, f3)), 1000.0f));
            if (fM627decodeToFloatsgRZ0Mg == CropImageView.DEFAULT_ASPECT_RATIO) {
                jVelocity = 0;
            } else {
                jVelocity = ((Boolean) providableModifierLocal.defaultFactory.invoke()).booleanValue() ? MathKt.Velocity(CropImageView.DEFAULT_ASPECT_RATIO, fM627decodeToFloatsgRZ0Mg) : MathKt.Velocity(fM627decodeToFloatsgRZ0Mg, CropImageView.DEFAULT_ASPECT_RATIO);
            }
        }
        Function2 function2 = (Function2) this.callbackFwk;
        Velocity velocity = new Velocity(jVelocity);
        anonymousClass2.L$0 = null;
        anonymousClass2.label = 2;
        return function2.invoke(velocity, anonymousClass2) == obj2 ? obj2 : unit;
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    /* JADX INFO: renamed from: onScrollingEvent-O0kMr_c, reason: not valid java name */
    public final boolean mo73onScrollingEventO0kMr_c(PointerEvent pointerEvent) {
        long j;
        Density density = (Density) this.sessionImpl;
        ViewConfiguration viewConfiguration = (ViewConfiguration) this.scrollConfig.block;
        int i = Build.VERSION.SDK_INT;
        float f = -(i > 26 ? viewConfiguration.getScaledVerticalScrollFactor() : density.mo81toPx0680j_4(64.0f));
        float f2 = -(i > 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : density.mo81toPx0680j_4(64.0f));
        List list = pointerEvent.changes;
        Offset offset = new Offset(0L);
        int size = list.size();
        boolean canScrollForward = false;
        int i2 = 0;
        while (true) {
            j = offset.packedValue;
            if (i2 >= size) {
                break;
            }
            offset = new Offset(Offset.m439plusMKHz9U(j, ((PointerInputChange) list.get(i2)).scrollDelta));
            i2++;
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) * f2)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) * f)) & 4294967295L);
        long jM637toScrollValueYk_gXsc = this.$$delegate_0.m637toScrollValueYk_gXsc(jFloatToRawIntBits);
        ScrollingLogic scrollingLogic = this.canConsumeDelta.f$0;
        float fReverseIfNeeded = scrollingLogic.reverseIfNeeded(ProvidableModifierLocal.m627decodeToFloatsgRZ0Mg(jM637toScrollValueYk_gXsc));
        if (fReverseIfNeeded < CropImageView.DEFAULT_ASPECT_RATIO) {
            canScrollForward = scrollingLogic.scrollableState.getCanScrollBackward();
        } else if (fReverseIfNeeded > CropImageView.DEFAULT_ASPECT_RATIO) {
            canScrollForward = scrollingLogic.scrollableState.getCanScrollForward();
        }
        if (canScrollForward) {
            return !(this.channel.mo1712trySendJP2dKIU(new MouseWheelScrollDelta(jFloatToRawIntBits, ((PointerInputChange) CollectionsKt.first(pointerEvent.changes)).uptimeMillis, false)) instanceof ChannelResult.Failed);
        }
        return this.mediaPlayPausePendingOnHandler;
    }
}
