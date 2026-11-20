package com.metrolist.music.ui.player;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.ui.component.OriginalLyricsKt;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueKt$Queue$5$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ SnapshotStateList $mutableQueueWindows;
    public final /* synthetic */ MutableState $queueWindows$delegate;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueKt$Queue$5$2$1(SnapshotStateList snapshotStateList, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$mutableQueueWindows = snapshotStateList;
        this.$queueWindows$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.$queueWindows$delegate;
        SnapshotStateList snapshotStateList = this.$mutableQueueWindows;
        switch (b) {
            case 0:
                return new QueueKt$Queue$5$2$1(snapshotStateList, mutableState, continuation, (byte) 0);
            default:
                return new QueueKt$Queue$5$2$1(snapshotStateList, mutableState, continuation, (byte) 1);
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
                ((QueueKt$Queue$5$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((QueueKt$Queue$5$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SnapshotStateList snapshotStateList = this.$mutableQueueWindows;
        MutableState mutableState = this.$queueWindows$delegate;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                snapshotStateList.clear();
                snapshotStateList.addAll((List) mutableState.getValue());
                break;
            default:
                ResultKt.throwOnFailure(obj);
                int i = OriginalLyricsKt.$r8$clinit;
                mutableState.setValue(Boolean.FALSE);
                snapshotStateList.clear();
                break;
        }
        return unit;
    }
}
