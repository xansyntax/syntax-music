package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.ui.unit.Dp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatingActionButtonElevationAnimatable {
    public final Animatable animatable;
    public float defaultElevation;
    public float focusedElevation;
    public float hoveredElevation;
    public Interaction lastTargetInteraction;
    public float pressedElevation;
    public Interaction targetInteraction;

    /* JADX INFO: renamed from: androidx.compose.material3.FloatingActionButtonElevationAnimatable$animateElevation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Interaction L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FloatingActionButtonElevationAnimatable.this.animateElevation(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.FloatingActionButtonElevationAnimatable$snapElevation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00301 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00301(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FloatingActionButtonElevationAnimatable.this.snapElevation(this);
        }
    }

    public FloatingActionButtonElevationAnimatable(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.hoveredElevation = f3;
        this.focusedElevation = f4;
        this.animatable = new Animatable(new Dp(f), ArcSplineKt.DpToVector, (Object) null, 12);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, kotlin.Unit] */
    public final Object animateElevation(Interaction interaction, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        float f;
        Animatable animatable = this.animatable;
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
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (interaction instanceof PressInteraction.Press) {
                    f = this.pressedElevation;
                } else if (interaction instanceof HoverInteraction$Enter) {
                    f = this.hoveredElevation;
                } else {
                    f = interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
                }
                this.targetInteraction = interaction;
                if (!Dp.m796equalsimpl0(((Dp) animatable.targetValue$delegate.getValue()).value, f)) {
                    Interaction interaction2 = this.lastTargetInteraction;
                    anonymousClass1.L$0 = interaction;
                    anonymousClass1.label = 1;
                    Object objM367animateElevationrAjV9yQ = ElevationKt.m367animateElevationrAjV9yQ(animatable, f, interaction2, interaction, anonymousClass1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objM367animateElevationrAjV9yQ == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                interaction = anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.lastTargetInteraction = interaction;
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th) {
            this.lastTargetInteraction = interaction;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object snapElevation(ContinuationImpl continuationImpl) {
        C00301 c00301;
        float f;
        if (continuationImpl instanceof C00301) {
            c00301 = (C00301) continuationImpl;
            int i = c00301.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00301.label = i - Integer.MIN_VALUE;
            } else {
                c00301 = new C00301(continuationImpl);
            }
        } else {
            c00301 = new C00301(continuationImpl);
        }
        Object obj = c00301.result;
        int i2 = c00301.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Interaction interaction = this.targetInteraction;
                if (interaction instanceof PressInteraction.Press) {
                    f = this.pressedElevation;
                } else if (interaction instanceof HoverInteraction$Enter) {
                    f = this.hoveredElevation;
                } else {
                    f = interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
                }
                Animatable animatable = this.animatable;
                if (!Dp.m796equalsimpl0(((Dp) animatable.targetValue$delegate.getValue()).value, f)) {
                    Dp dp = new Dp(f);
                    c00301.label = 1;
                    Object objSnapTo = animatable.snapTo(dp, c00301);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objSnapTo == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.lastTargetInteraction = this.targetInteraction;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.lastTargetInteraction = this.targetInteraction;
            throw th;
        }
    }
}
