package com.metrolist.music.ui.component;

import androidx.compose.animation.SizeAnimationModifierNode;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationEndReason;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableNode;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntSize;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsLineKt$WordLevelLyrics$2$1 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object $currentPositionProvider;
    public boolean $isActiveLine;
    public final /* synthetic */ long $lyricsOffset;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object $smoothPosition$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsLineKt$WordLevelLyrics$2$1(boolean z, Function0 function0, long j, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, Continuation continuation) {
        super(2, continuation);
        this.$isActiveLine = z;
        this.$currentPositionProvider = function0;
        this.$lyricsOffset = j;
        this.$smoothPosition$delegate = parcelableSnapshotMutableLongState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$smoothPosition$delegate;
        switch (b) {
            case 0:
                return new LyricsLineKt$WordLevelLyrics$2$1(this.$isActiveLine, (Function0) this.$currentPositionProvider, this.$lyricsOffset, (ParcelableSnapshotMutableLongState) obj2, continuation);
            case 1:
                return new LyricsLineKt$WordLevelLyrics$2$1((SizeAnimationModifierNode.AnimData) this.$currentPositionProvider, this.$lyricsOffset, (SizeAnimationModifierNode) obj2, continuation);
            default:
                LyricsLineKt$WordLevelLyrics$2$1 lyricsLineKt$WordLevelLyrics$2$1 = new LyricsLineKt$WordLevelLyrics$2$1((DraggableNode) obj2, this.$lyricsOffset, continuation);
                lyricsLineKt$WordLevelLyrics$2$1.$currentPositionProvider = obj;
                return lyricsLineKt$WordLevelLyrics$2$1;
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
                ((LyricsLineKt$WordLevelLyrics$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 1:
                return ((LyricsLineKt$WordLevelLyrics$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((LyricsLineKt$WordLevelLyrics$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objAnimateTo$default;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        long j = this.$lyricsOffset;
        Object obj2 = this.$smoothPosition$delegate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (!this.$isActiveLine) {
                    ((ParcelableSnapshotMutableLongState) obj2).setLongValue(((Number) ((Function0) this.$currentPositionProvider).invoke()).longValue() + j);
                }
                return unit;
            case 1:
                SizeAnimationModifierNode sizeAnimationModifierNode = (SizeAnimationModifierNode) obj2;
                SizeAnimationModifierNode.AnimData animData = (SizeAnimationModifierNode.AnimData) this.$currentPositionProvider;
                boolean z = this.$isActiveLine;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = animData.anim;
                    IntSize intSize = new IntSize(j);
                    AnimationSpec animationSpec = sizeAnimationModifierNode.animationSpec;
                    this.$isActiveLine = true;
                    objAnimateTo$default = Animatable.animateTo$default(animatable, intSize, animationSpec, null, null, this, 12);
                    if (objAnimateTo$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objAnimateTo$default = obj;
                }
                AnimationEndReason animationEndReason = ((AnimationResult) objAnimateTo$default).endReason;
                return unit;
            default:
                boolean z2 = this.$isActiveLine;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.$currentPositionProvider;
                    Function3 function3 = ((DraggableNode) obj2).onDragStarted;
                    Offset offset = new Offset(j);
                    this.$isActiveLine = true;
                    if (function3.invoke(coroutineScope, offset, this) == coroutineSingletons) {
                        return coroutineSingletons;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsLineKt$WordLevelLyrics$2$1(DraggableNode draggableNode, long j, Continuation continuation) {
        super(2, continuation);
        this.$smoothPosition$delegate = draggableNode;
        this.$lyricsOffset = j;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsLineKt$WordLevelLyrics$2$1(SizeAnimationModifierNode.AnimData animData, long j, SizeAnimationModifierNode sizeAnimationModifierNode, Continuation continuation) {
        super(2, continuation);
        this.$currentPositionProvider = animData;
        this.$lyricsOffset = j;
        this.$smoothPosition$delegate = sizeAnimationModifierNode;
    }
}
