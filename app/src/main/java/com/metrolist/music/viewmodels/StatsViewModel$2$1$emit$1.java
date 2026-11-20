package com.metrolist.music.viewmodels;

import com.metrolist.music.db.entities.Album;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$2$1$emit$1 extends ContinuationImpl {
    public StatsViewModel L$2;
    public Iterator L$3;
    public Album L$5;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StatsViewModel.AnonymousClass1.C00121 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsViewModel$2$1$emit$1(StatsViewModel.AnonymousClass1.C00121 c00121, Continuation continuation) {
        super(continuation);
        this.this$0 = c00121;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((List) null, (Continuation) this);
    }
}
