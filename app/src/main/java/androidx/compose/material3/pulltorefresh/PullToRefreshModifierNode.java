package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.Animatable;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.unit.Velocity;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PullToRefreshModifierNode extends DelegatingNode implements NestedScrollConnection {
    public final ParcelableSnapshotMutableFloatState distancePulled$delegate;
    public boolean enabled;
    public boolean isRefreshing;
    public final NestedScrollNode nestedScrollNode;
    public Function0 onRefresh;
    public PullToRefreshStateImpl state;
    public float threshold;
    public final ParcelableSnapshotMutableFloatState verticalOffset$delegate;

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1, reason: invalid class name */
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
            return PullToRefreshModifierNode.this.animateToHidden(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00341 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00341(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.animateToThreshold(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00351 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ PullToRefreshModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C00351(PullToRefreshModifierNode pullToRefreshModifierNode, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = pullToRefreshModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            PullToRefreshModifierNode pullToRefreshModifierNode = this.this$0;
            switch (b) {
                case 0:
                    return new C00351(pullToRefreshModifierNode, continuation, (byte) 0);
                default:
                    return new C00351(pullToRefreshModifierNode, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((C00351) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            PullToRefreshModifierNode pullToRefreshModifierNode = this.this$0;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        PullToRefreshStateImpl pullToRefreshStateImpl = pullToRefreshModifierNode.state;
                        float f = pullToRefreshModifierNode.isRefreshing ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO;
                        this.label = true;
                        Object objSnapTo = pullToRefreshStateImpl.anim.snapTo(new Float(f), this);
                        if (objSnapTo != coroutineSingletons) {
                            objSnapTo = unit;
                        }
                        if (objSnapTo == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                default:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        if (!pullToRefreshModifierNode.state.anim.isRunning()) {
                            PullToRefreshStateImpl pullToRefreshStateImpl2 = pullToRefreshModifierNode.state;
                            float floatValue = pullToRefreshModifierNode.verticalOffset$delegate.getFloatValue() / pullToRefreshModifierNode.getThresholdPx();
                            this.label = true;
                            Object objSnapTo2 = pullToRefreshStateImpl2.anim.snapTo(new Float(floatValue), this);
                            if (objSnapTo2 != coroutineSingletons) {
                                objSnapTo2 = unit;
                            }
                            if (objSnapTo2 == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00361 extends ContinuationImpl {
        public float F$0;
        public int label;
        public /* synthetic */ Object result;

        public C00361(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.onRelease(CropImageView.DEFAULT_ASPECT_RATIO, this);
        }
    }

    public PullToRefreshModifierNode(boolean z, Function0 function0, boolean z2, PullToRefreshStateImpl pullToRefreshStateImpl, float f) {
        this.isRefreshing = z;
        this.onRefresh = function0;
        this.enabled = z2;
        this.state = pullToRefreshStateImpl;
        this.threshold = f;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = NestedScrollNodeKt.CancelledNestedScope;
        this.nestedScrollNode = new NestedScrollNode(this, null);
        this.verticalOffset$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
        this.distancePulled$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object animateToHidden(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
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
        Unit unit = Unit.INSTANCE;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                PullToRefreshStateImpl pullToRefreshStateImpl = this.state;
                anonymousClass2.label = 1;
                Object objAnimateTo$default = Animatable.animateTo$default(pullToRefreshStateImpl.anim, new Float(CropImageView.DEFAULT_ASPECT_RATIO), null, null, null, anonymousClass2, 14);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAnimateTo$default != coroutineSingletons) {
                    objAnimateTo$default = unit;
                }
                if (objAnimateTo$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            setDistancePulled(CropImageView.DEFAULT_ASPECT_RATIO);
            setVerticalOffset(CropImageView.DEFAULT_ASPECT_RATIO);
            return unit;
        } catch (Throwable th) {
            setDistancePulled(CropImageView.DEFAULT_ASPECT_RATIO);
            setVerticalOffset(CropImageView.DEFAULT_ASPECT_RATIO);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object animateToThreshold(ContinuationImpl continuationImpl) {
        C00341 c00341;
        if (continuationImpl instanceof C00341) {
            c00341 = (C00341) continuationImpl;
            int i = c00341.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00341.label = i - Integer.MIN_VALUE;
            } else {
                c00341 = new C00341(continuationImpl);
            }
        } else {
            c00341 = new C00341(continuationImpl);
        }
        C00341 c00342 = c00341;
        Object obj = c00342.result;
        int i2 = c00342.label;
        Unit unit = Unit.INSTANCE;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                PullToRefreshStateImpl pullToRefreshStateImpl = this.state;
                c00342.label = 1;
                Object objAnimateTo$default = Animatable.animateTo$default(pullToRefreshStateImpl.anim, new Float(1.0f), null, null, null, c00342, 14);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAnimateTo$default != coroutineSingletons) {
                    objAnimateTo$default = unit;
                }
                if (objAnimateTo$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            if (this.isAttached) {
                setDistancePulled(getThresholdPx());
                setVerticalOffset(getThresholdPx());
            }
            return unit;
        } catch (Throwable th) {
            if (!this.isAttached) {
                throw th;
            }
            setDistancePulled(getThresholdPx());
            setVerticalOffset(getThresholdPx());
            throw th;
        }
    }

    /* JADX INFO: renamed from: consumeAvailableOffset-MK-Hz9U, reason: not valid java name */
    public final long m380consumeAvailableOffsetMKHz9U(long j) {
        float floatValue;
        float thresholdPx;
        if (this.isRefreshing) {
            floatValue = 0.0f;
        } else {
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.distancePulled$delegate;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L)) + parcelableSnapshotMutableFloatState.getFloatValue();
            if (fIntBitsToFloat < CropImageView.DEFAULT_ASPECT_RATIO) {
                fIntBitsToFloat = 0.0f;
            }
            floatValue = fIntBitsToFloat - parcelableSnapshotMutableFloatState.getFloatValue();
            setDistancePulled(fIntBitsToFloat);
            if (parcelableSnapshotMutableFloatState.getFloatValue() * 0.5f <= getThresholdPx()) {
                thresholdPx = parcelableSnapshotMutableFloatState.getFloatValue() * 0.5f;
            } else {
                float fCoerceIn = UuidKt.coerceIn(Math.abs((parcelableSnapshotMutableFloatState.getFloatValue() * 0.5f) / getThresholdPx()) - 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f);
                thresholdPx = getThresholdPx() + (getThresholdPx() * (fCoerceIn - (((float) Math.pow(fCoerceIn, 2.0d)) / 4.0f)));
            }
            setVerticalOffset(thresholdPx);
        }
        return (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(floatValue)) & 4294967295L);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final int getThresholdPx() {
        return HitTestResultKt.requireLayoutNode(this).density.mo75roundToPx0680j_4(this.threshold);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        delegate(this.nestedScrollNode);
        AwaitKt.launch$default(getCoroutineScope(), null, null, new C00351(this, null, (byte) 0), 3);
        setVerticalOffset(this.isRefreshing ? getThresholdPx() : CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
        if (this.state.anim.isRunning() || !this.enabled) {
            return 0L;
        }
        byte b = 1;
        if (i != 1) {
            return 0L;
        }
        long jM380consumeAvailableOffsetMKHz9U = m380consumeAvailableOffsetMKHz9U(j2);
        AwaitKt.launch$default(getCoroutineScope(), null, null, new C00351(this, null, b), 3);
        return jM380consumeAvailableOffsetMKHz9U;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public final Object mo326onPreFlingQWom1Mo(long j, Continuation continuation) {
        PullToRefreshModifierNode$onPreFling$1 pullToRefreshModifierNode$onPreFling$1;
        if (continuation instanceof PullToRefreshModifierNode$onPreFling$1) {
            pullToRefreshModifierNode$onPreFling$1 = (PullToRefreshModifierNode$onPreFling$1) continuation;
            int i = pullToRefreshModifierNode$onPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                pullToRefreshModifierNode$onPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                pullToRefreshModifierNode$onPreFling$1 = new PullToRefreshModifierNode$onPreFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            pullToRefreshModifierNode$onPreFling$1 = new PullToRefreshModifierNode$onPreFling$1(this, (ContinuationImpl) continuation);
        }
        Object objOnRelease = pullToRefreshModifierNode$onPreFling$1.result;
        int i2 = pullToRefreshModifierNode$onPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objOnRelease);
            float fM820getYimpl = Velocity.m820getYimpl(j);
            pullToRefreshModifierNode$onPreFling$1.label = 1;
            objOnRelease = onRelease(fM820getYimpl, pullToRefreshModifierNode$onPreFling$1);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objOnRelease == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objOnRelease);
        }
        return new Velocity(MathKt.Velocity(CropImageView.DEFAULT_ASPECT_RATIO, ((Number) objOnRelease).floatValue()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public final long mo178onPreScrollOzD1aCk(int i, long j) {
        if (!this.state.anim.isRunning() && this.enabled && i == 1 && Float.intBitsToFloat((int) (4294967295L & j)) < CropImageView.DEFAULT_ASPECT_RATIO) {
            return m380consumeAvailableOffsetMKHz9U(j);
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object onRelease(float f, ContinuationImpl continuationImpl) {
        C00361 c00361;
        if (continuationImpl instanceof C00361) {
            c00361 = (C00361) continuationImpl;
            int i = c00361.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00361.label = i - Integer.MIN_VALUE;
            } else {
                c00361 = new C00361(continuationImpl);
            }
        } else {
            c00361 = new C00361(continuationImpl);
        }
        Object obj = c00361.result;
        int i2 = c00361.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isRefreshing) {
                return new Float(CropImageView.DEFAULT_ASPECT_RATIO);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.distancePulled$delegate;
            if (parcelableSnapshotMutableFloatState.getFloatValue() * 0.5f > getThresholdPx()) {
                this.onRefresh.invoke();
            }
            if (parcelableSnapshotMutableFloatState.getFloatValue() == CropImageView.DEFAULT_ASPECT_RATIO || f < CropImageView.DEFAULT_ASPECT_RATIO) {
                f = 0.0f;
            }
            c00361.F$0 = f;
            c00361.label = 1;
            Object objAnimateToHidden = animateToHidden(c00361);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnimateToHidden == obj2) {
                return obj2;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            f = c00361.F$0;
            ResultKt.throwOnFailure(obj);
        }
        setDistancePulled(CropImageView.DEFAULT_ASPECT_RATIO);
        return new Float(f);
    }

    public final void setDistancePulled(float f) {
        this.distancePulled$delegate.setFloatValue(f);
    }

    public final void setVerticalOffset(float f) {
        this.verticalOffset$delegate.setFloatValue(f);
    }
}
