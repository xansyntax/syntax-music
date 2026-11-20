package com.metrolist.music.extensions;

import kotlin.Function;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoroutineExtKt$sam$kotlinx_coroutines_flow_FlowCollector$0 implements FlowCollector, FunctionAdapter {
    public final /* synthetic */ Function2 function;

    public CoroutineExtKt$sam$kotlinx_coroutines_flow_FlowCollector$0(Function2 function2) {
        this.function = function2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return this.function.invoke(obj, continuation);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FlowCollector) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return this.function.equals(((FunctionAdapter) obj).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return this.function.hashCode();
    }
}
