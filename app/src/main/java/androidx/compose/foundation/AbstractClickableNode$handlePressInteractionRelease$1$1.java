package androidx.compose.foundation;

import android.app.PendingIntent;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimationKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$paste$1;
import androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntOffset;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AbstractClickableNode$handlePressInteractionRelease$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $interactionSource;
    public final /* synthetic */ Object $job;
    public final /* synthetic */ long $offset;
    public final /* synthetic */ byte $r8$classId;
    public Object L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteractionRelease$1$1(TextContextMenuGestureNode textContextMenuGestureNode, long j, TextContextMenuProvider textContextMenuProvider, TextContextMenuGestureNode.ClickTextContextMenuDataProvider clickTextContextMenuDataProvider, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 3;
        this.L$0 = textContextMenuGestureNode;
        this.$offset = j;
        this.$job = textContextMenuProvider;
        this.$interactionSource = clickTextContextMenuDataProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$interactionSource;
        Object obj3 = this.$job;
        switch (b) {
            case 0:
                return new AbstractClickableNode$handlePressInteractionRelease$1$1(obj3, this.$offset, (MutableInteractionSourceImpl) obj2, continuation, (byte) 0);
            case 1:
                return new AbstractClickableNode$handlePressInteractionRelease$1$1((LazyLayoutItemAnimation) obj3, (FiniteAnimationSpec) obj2, this.$offset, continuation);
            case 2:
                return new AbstractClickableNode$handlePressInteractionRelease$1$1(obj3, this.$offset, (MutableInteractionSourceImpl) obj2, continuation, (byte) 2);
            default:
                return new AbstractClickableNode$handlePressInteractionRelease$1$1((TextContextMenuGestureNode) this.L$0, this.$offset, (TextContextMenuProvider) obj3, (TextContextMenuGestureNode.ClickTextContextMenuDataProvider) obj2, continuation);
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((AbstractClickableNode$handlePressInteractionRelease$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x009c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0120  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PendingIntent.CanceledException {
        PressInteraction.Release release;
        FiniteAnimationSpec finiteAnimationSpec;
        IntOffset intOffset;
        ScrimKt$$ExternalSyntheticLambda1 scrimKt$$ExternalSyntheticLambda1;
        MutableState mutableState;
        PressInteraction.Press press;
        byte b = this.$r8$classId;
        long j = this.$offset;
        Object obj2 = this.$interactionSource;
        Object obj3 = this.$job;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        byte b2 = 2;
        switch (b) {
            case 0:
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj2;
                byte b3 = this.label;
                if (b3 != 0) {
                    if (b3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else if (b3 == 2) {
                        release = (PressInteraction.Release) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = null;
                        this.label = (byte) 3;
                        if (mutableInteractionSourceImpl.emit(release, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (b3 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                this.label = (byte) 1;
                if (((Job) obj3).join(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                PressInteraction.Press press2 = new PressInteraction.Press(j);
                PressInteraction.Release release2 = new PressInteraction.Release(press2);
                this.L$0 = release2;
                this.label = (byte) 2;
                if (mutableInteractionSourceImpl.emit(press2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                release = release2;
                this.L$0 = null;
                this.label = (byte) 3;
                if (mutableInteractionSourceImpl.emit(release, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            case 1:
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) obj3;
                Animatable animatable = lazyLayoutItemAnimation.placementDeltaAnimation;
                byte b4 = this.label;
                try {
                    if (b4 != 0) {
                        if (b4 == 1) {
                            finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b4 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        lazyLayoutItemAnimation.isPlacementAnimationInProgress$delegate.setValue(Boolean.FALSE);
                        lazyLayoutItemAnimation.isRunningMovingAwayAnimation = false;
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    finiteAnimationSpec = (FiniteAnimationSpec) obj2;
                    if (animatable.isRunning()) {
                        finiteAnimationSpec = finiteAnimationSpec instanceof SpringSpec ? (SpringSpec) finiteAnimationSpec : LazyLayoutItemAnimationKt.InterruptionSpec;
                    }
                    if (!animatable.isRunning()) {
                        IntOffset intOffset2 = new IntOffset(j);
                        this.L$0 = finiteAnimationSpec;
                        this.label = (byte) 1;
                        if (animatable.snapTo(intOffset2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    long jM805minusqkQi6aY = IntOffset.m805minusqkQi6aY(((IntOffset) animatable.getValue()).packedValue, j);
                    intOffset = new IntOffset(jM805minusqkQi6aY);
                    scrimKt$$ExternalSyntheticLambda1 = new ScrimKt$$ExternalSyntheticLambda1(lazyLayoutItemAnimation, jM805minusqkQi6aY, b2);
                    this.L$0 = null;
                    this.label = (byte) 2;
                    if (Animatable.animateTo$default(animatable, intOffset, finiteAnimationSpec, null, scrimKt$$ExternalSyntheticLambda1, this, 4) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    lazyLayoutItemAnimation.isPlacementAnimationInProgress$delegate.setValue(Boolean.FALSE);
                    lazyLayoutItemAnimation.isRunningMovingAwayAnimation = false;
                    return unit;
                    lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
                    long jM805minusqkQi6aY2 = IntOffset.m805minusqkQi6aY(((IntOffset) animatable.getValue()).packedValue, j);
                    intOffset = new IntOffset(jM805minusqkQi6aY2);
                    scrimKt$$ExternalSyntheticLambda1 = new ScrimKt$$ExternalSyntheticLambda1(lazyLayoutItemAnimation, jM805minusqkQi6aY2, b2);
                    this.L$0 = null;
                    this.label = (byte) 2;
                    if (Animatable.animateTo$default(animatable, intOffset, finiteAnimationSpec, null, scrimKt$$ExternalSyntheticLambda1, this, 4) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    lazyLayoutItemAnimation.isPlacementAnimationInProgress$delegate.setValue(Boolean.FALSE);
                    lazyLayoutItemAnimation.isRunningMovingAwayAnimation = false;
                    break;
                } catch (CancellationException unused) {
                }
                return unit;
            case 2:
                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) obj2;
                MutableState mutableState2 = (MutableState) obj3;
                byte b5 = this.label;
                if (b5 != 0) {
                    if (b5 == 1) {
                        mutableState = (MutableState) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b5 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        press = (PressInteraction.Press) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    mutableState2.setValue(press);
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                PressInteraction.Press press3 = (PressInteraction.Press) mutableState2.getValue();
                if (press3 != null) {
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press3);
                    if (mutableInteractionSourceImpl2 != null) {
                        this.L$0 = mutableState2;
                        this.label = (byte) 1;
                        if (mutableInteractionSourceImpl2.emit(cancel, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    mutableState = mutableState2;
                } else {
                    press = new PressInteraction.Press(j);
                    if (mutableInteractionSourceImpl2 != null) {
                        this.L$0 = press;
                        this.label = (byte) 2;
                        if (mutableInteractionSourceImpl2.emit(press, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                mutableState2.setValue(press);
                return unit;
                mutableState.setValue(null);
                press = new PressInteraction.Press(j);
                if (mutableInteractionSourceImpl2 != null) {
                    this.L$0 = press;
                    this.label = (byte) 2;
                    if (mutableInteractionSourceImpl2.emit(press, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                mutableState2.setValue(press);
                return unit;
            default:
                byte b6 = this.label;
                if (b6 != 0) {
                    if (b6 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b6 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                TextFieldSelectionManager$paste$1 textFieldSelectionManager$paste$1 = ((TextContextMenuGestureNode) this.L$0).onPreShowContextMenu;
                if (textFieldSelectionManager$paste$1 != null) {
                    this.label = (byte) 1;
                    if (new TextFieldSelectionManager$paste$1(textFieldSelectionManager$paste$1.this$0, this, (byte) 1).invokeSuspend(unit) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                this.label = (byte) 2;
                if (((TextContextMenuProvider) obj3).showTextContextMenu((TextContextMenuGestureNode.ClickTextContextMenuDataProvider) obj2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteractionRelease$1$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec finiteAnimationSpec, long j, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.$job = lazyLayoutItemAnimation;
        this.$interactionSource = finiteAnimationSpec;
        this.$offset = j;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractClickableNode$handlePressInteractionRelease$1$1(Object obj, long j, MutableInteractionSourceImpl mutableInteractionSourceImpl, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$job = obj;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSourceImpl;
    }
}
