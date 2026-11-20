package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExperimentalLyricsKt$ExperimentalLyrics$14$9$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $frozenOffset;
    public final /* synthetic */ MutableState $isAutoScrollEnabled$delegate;
    public final /* synthetic */ MutableState $isInitialLayout$delegate;
    public final /* synthetic */ float $targetOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentalLyricsKt$ExperimentalLyrics$14$9$2$1$1(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, float f, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$frozenOffset = parcelableSnapshotMutableFloatState;
        this.$targetOffset = f;
        this.$isAutoScrollEnabled$delegate = mutableState;
        this.$isInitialLayout$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ExperimentalLyricsKt$ExperimentalLyrics$14$9$2$1$1(this.$frozenOffset, this.$targetOffset, this.$isAutoScrollEnabled$delegate, this.$isInitialLayout$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ExperimentalLyricsKt$ExperimentalLyrics$14$9$2$1$1 experimentalLyricsKt$ExperimentalLyrics$14$9$2$1$1 = (ExperimentalLyricsKt$ExperimentalLyrics$14$9$2$1$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        experimentalLyricsKt$ExperimentalLyrics$14$9$2$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        if (((Boolean) this.$isAutoScrollEnabled$delegate.getValue()).booleanValue() || ((Boolean) this.$isInitialLayout$delegate.getValue()).booleanValue()) {
            this.$frozenOffset.setFloatValue(this.$targetOffset);
        }
        return Unit.INSTANCE;
    }
}
