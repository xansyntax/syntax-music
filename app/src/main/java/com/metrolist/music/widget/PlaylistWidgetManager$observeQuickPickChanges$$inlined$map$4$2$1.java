package com.metrolist.music.widget;

import com.metrolist.music.viewmodels.StatsViewModel$special$$inlined$map$3$2;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StatsViewModel$special$$inlined$map$3$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1(StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$2, Continuation continuation) {
        super(continuation);
        this.this$0 = statsViewModel$special$$inlined$map$3$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
