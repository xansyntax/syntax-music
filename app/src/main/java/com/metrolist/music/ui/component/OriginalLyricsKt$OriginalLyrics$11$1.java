package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import com.metrolist.music.utils.potoken.PoTokenGenerator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OriginalLyricsKt$OriginalLyrics$11$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $isSeeking$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $lastPreviewTime$delegate;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OriginalLyricsKt$OriginalLyrics$11$1(MutableState mutableState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$isSeeking$delegate = mutableState;
        this.$lastPreviewTime$delegate = parcelableSnapshotMutableLongState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.$lastPreviewTime$delegate;
        MutableState mutableState = this.$isSeeking$delegate;
        switch (b) {
            case 0:
                return new OriginalLyricsKt$OriginalLyrics$11$1(mutableState, parcelableSnapshotMutableLongState, continuation, (byte) 0);
            default:
                return new OriginalLyricsKt$OriginalLyrics$11$1(mutableState, parcelableSnapshotMutableLongState, continuation, (byte) 1);
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
        return ((OriginalLyricsKt$OriginalLyrics$11$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$isSeeking$delegate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.$lastPreviewTime$delegate;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    int i = OriginalLyricsKt.$r8$clinit;
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        parcelableSnapshotMutableLongState.setLongValue(0L);
                        return unit;
                    }
                    if (parcelableSnapshotMutableLongState.getLongValue() == 0) {
                        return unit;
                    }
                    long j = OriginalLyricsKt.LyricsPreviewTime;
                    this.label = true;
                    if (AwaitKt.m1897delayVtjQ1oo(j, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                int i2 = OriginalLyricsKt.$r8$clinit;
                parcelableSnapshotMutableLongState.setLongValue(0L);
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        parcelableSnapshotMutableLongState.setLongValue(0L);
                        return unit;
                    }
                    if (parcelableSnapshotMutableLongState.getLongValue() == 0) {
                        return unit;
                    }
                    this.label = true;
                    if (AwaitKt.delay(PoTokenGenerator.POTOKEN_TIMEOUT_MS, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                parcelableSnapshotMutableLongState.setLongValue(0L);
                return unit;
        }
    }
}
