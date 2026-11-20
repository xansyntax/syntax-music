package com.metrolist.music.ui.player;

import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.ui.component.DraggableLyricsProviderItem;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueKt$Queue$5$reorderableState$1$1 extends SuspendLambda implements Function4 {
    public final /* synthetic */ MutableState $dragInfo$delegate;
    public final /* synthetic */ List $mutableQueueWindows;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ LazyListMeasuredItem L$0;
    public /* synthetic */ LazyListMeasuredItem L$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueKt$Queue$5$reorderableState$1$1(List list, MutableState mutableState, Continuation continuation, byte b) {
        super(4, continuation);
        this.$r8$classId = b;
        this.$mutableQueueWindows = list;
        this.$dragInfo$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$dragInfo$delegate;
        List list = this.$mutableQueueWindows;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) obj2;
        LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) obj3;
        Continuation continuation = (Continuation) obj4;
        switch (b) {
            case 0:
                QueueKt$Queue$5$reorderableState$1$1 queueKt$Queue$5$reorderableState$1$1 = new QueueKt$Queue$5$reorderableState$1$1((SnapshotStateList) list, mutableState, continuation, (byte) 0);
                queueKt$Queue$5$reorderableState$1$1.L$0 = lazyListMeasuredItem;
                queueKt$Queue$5$reorderableState$1$1.L$1 = lazyListMeasuredItem2;
                queueKt$Queue$5$reorderableState$1$1.invokeSuspend(unit);
                break;
            case 1:
                QueueKt$Queue$5$reorderableState$1$1 queueKt$Queue$5$reorderableState$1$2 = new QueueKt$Queue$5$reorderableState$1$1((SnapshotStateList) list, mutableState, continuation, (byte) 1);
                queueKt$Queue$5$reorderableState$1$2.L$0 = lazyListMeasuredItem;
                queueKt$Queue$5$reorderableState$1$2.L$1 = lazyListMeasuredItem2;
                queueKt$Queue$5$reorderableState$1$2.invokeSuspend(unit);
                break;
            default:
                QueueKt$Queue$5$reorderableState$1$1 queueKt$Queue$5$reorderableState$1$3 = new QueueKt$Queue$5$reorderableState$1$1(list, mutableState, continuation, (byte) 2);
                queueKt$Queue$5$reorderableState$1$3.L$0 = lazyListMeasuredItem;
                queueKt$Queue$5$reorderableState$1$3.L$1 = lazyListMeasuredItem2;
                queueKt$Queue$5$reorderableState$1$3.invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$dragInfo$delegate;
        List list = this.$mutableQueueWindows;
        switch (b) {
            case 0:
                SnapshotStateList snapshotStateList = (SnapshotStateList) list;
                LazyListMeasuredItem lazyListMeasuredItem = this.L$0;
                LazyListMeasuredItem lazyListMeasuredItem2 = this.L$1;
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) mutableState.getValue();
                mutableState.setValue(pair == null ? new Pair(new Integer(lazyListMeasuredItem.index), new Integer(lazyListMeasuredItem2.index)) : new Pair(pair.first, new Integer(lazyListMeasuredItem2.index)));
                snapshotStateList.add(UuidKt.coerceIn(lazyListMeasuredItem2.index - 1, 0, snapshotStateList.size() - 1), snapshotStateList.remove(UuidKt.coerceIn(lazyListMeasuredItem.index - 1, 0, CollectionsKt__IterablesKt.getLastIndex(snapshotStateList))));
                break;
            case 1:
                LazyListMeasuredItem lazyListMeasuredItem3 = this.L$0;
                LazyListMeasuredItem lazyListMeasuredItem4 = this.L$1;
                ResultKt.throwOnFailure(obj);
                int i2 = lazyListMeasuredItem4.index;
                if (i2 >= 2 && (i = lazyListMeasuredItem3.index) >= 2) {
                    Pair pair2 = (Pair) mutableState.getValue();
                    mutableState.setValue(pair2 == null ? new Pair(new Integer(i - 2), new Integer(i2 - 2)) : new Pair(pair2.first, new Integer(i2 - 2)));
                    SnapshotStateList snapshotStateList2 = (SnapshotStateList) list;
                    snapshotStateList2.getClass();
                    snapshotStateList2.add(i2 - 2, snapshotStateList2.remove(i - 2));
                }
                break;
            default:
                LazyListMeasuredItem lazyListMeasuredItem5 = this.L$0;
                LazyListMeasuredItem lazyListMeasuredItem6 = this.L$1;
                ResultKt.throwOnFailure(obj);
                list.add(lazyListMeasuredItem6.index, (DraggableLyricsProviderItem) list.remove(lazyListMeasuredItem5.index));
                mutableState.setValue(Boolean.TRUE);
                break;
        }
        return unit;
    }
}
