package com.metrolist.music.widget;

import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PlaylistWidgetManager$observeQuickPickChanges$6 extends SuspendLambda implements Function6 {
    public /* synthetic */ List L$0;
    public /* synthetic */ List L$1;
    public /* synthetic */ List L$2;
    public /* synthetic */ List L$3;
    public /* synthetic */ List L$4;

    public PlaylistWidgetManager$observeQuickPickChanges$6(Continuation continuation) {
        super(6, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = this.L$0;
        List list2 = this.L$1;
        List list3 = this.L$2;
        List list4 = this.L$3;
        List list5 = this.L$4;
        ResultKt.throwOnFailure(obj);
        return new PlaylistWidgetManager.QuickPickSnapshot(list, list2, list3, list4, list5);
    }
}
