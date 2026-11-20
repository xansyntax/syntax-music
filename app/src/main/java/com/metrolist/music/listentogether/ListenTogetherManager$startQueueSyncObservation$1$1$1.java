package com.metrolist.music.listentogether;

import androidx.media3.common.Timeline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherManager$startQueueSyncObservation$1$1$1 extends SuspendLambda implements Function3 {
    public /* synthetic */ int I$0;
    public /* synthetic */ List L$0;
    public final /* synthetic */ ListenTogetherManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenTogetherManager$startQueueSyncObservation$1$1$1(ListenTogetherManager listenTogetherManager, Continuation continuation) {
        super(3, continuation);
        this.this$0 = listenTogetherManager;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        ListenTogetherManager$startQueueSyncObservation$1$1$1 listenTogetherManager$startQueueSyncObservation$1$1$1 = new ListenTogetherManager$startQueueSyncObservation$1$1$1(this.this$0, (Continuation) obj3);
        listenTogetherManager$startQueueSyncObservation$1$1$1.L$0 = (List) obj;
        listenTogetherManager$startQueueSyncObservation$1$1$1.I$0 = iIntValue;
        return listenTogetherManager$startQueueSyncObservation$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = this.L$0;
        int i = this.I$0;
        ResultKt.throwOnFailure(obj);
        list.getClass();
        Iterable iterableDrop = (i < 0 || i >= list.size()) ? EmptyList.INSTANCE : CollectionsKt.drop(list, i + 1);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterableDrop, 10));
        Iterator it = iterableDrop.iterator();
        while (it.hasNext()) {
            arrayList.add(this.this$0.toTrackInfo((Timeline.Window) it.next()));
        }
        return arrayList;
    }
}
