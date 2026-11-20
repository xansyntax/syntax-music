package com.metrolist.music.ui.component;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExperimentalLyricsKt$ExperimentalLyrics$14$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ float $scrollClampMax;
    public final /* synthetic */ float $scrollClampMin;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $userManualOffset$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentalLyricsKt$ExperimentalLyrics$14$1$1(float f, float f2, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, Continuation continuation) {
        super(2, continuation);
        this.$scrollClampMin = f;
        this.$scrollClampMax = f2;
        this.$userManualOffset$delegate = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ExperimentalLyricsKt$ExperimentalLyrics$14$1$1(this.$scrollClampMin, this.$scrollClampMax, this.$userManualOffset$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ExperimentalLyricsKt$ExperimentalLyrics$14$1$1 experimentalLyricsKt$ExperimentalLyrics$14$1$1 = (ExperimentalLyricsKt$ExperimentalLyrics$14$1$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        experimentalLyricsKt$ExperimentalLyrics$14$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$userManualOffset$delegate;
        float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
        float f = this.$scrollClampMin;
        float f2 = this.$scrollClampMax;
        if (floatValue < f || parcelableSnapshotMutableFloatState.getFloatValue() > f2) {
            parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn(parcelableSnapshotMutableFloatState.getFloatValue(), f, f2));
        }
        return Unit.INSTANCE;
    }
}
