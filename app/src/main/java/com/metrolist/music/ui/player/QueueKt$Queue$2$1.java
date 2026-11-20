package com.metrolist.music.ui.player;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueKt$Queue$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $sleepTimerDefault$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $sleepTimerValue$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueKt$Queue$2$1(DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$sleepTimerDefault$delegate = dataStoreKt$rememberPreference$1$1;
        this.$sleepTimerValue$delegate = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$sleepTimerValue$delegate;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.$sleepTimerDefault$delegate;
        switch (b) {
            case 0:
                return new QueueKt$Queue$2$1(dataStoreKt$rememberPreference$1$1, parcelableSnapshotMutableFloatState, continuation, (byte) 0);
            default:
                return new QueueKt$Queue$2$1(dataStoreKt$rememberPreference$1$1, parcelableSnapshotMutableFloatState, continuation, (byte) 1);
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
                ((QueueKt$Queue$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((QueueKt$Queue$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.$sleepTimerDefault$delegate;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$sleepTimerValue$delegate;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                parcelableSnapshotMutableFloatState.setFloatValue(((Number) dataStoreKt$rememberPreference$1$1.getValue()).floatValue());
                break;
            default:
                ResultKt.throwOnFailure(obj);
                parcelableSnapshotMutableFloatState.setFloatValue(((Number) dataStoreKt$rememberPreference$1$1.getValue()).floatValue());
                break;
        }
        return unit;
    }
}
