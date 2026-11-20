package com.metrolist.innertubex;

import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HttpResponseBodyKt$bodyAsTextLimited$2 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public int I$2;
    public HttpResponse L$0;
    public Function2 L$1;
    public ByteReadChannel L$2;
    public byte[] L$4;
    public byte[] L$5;
    public String L$6;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CollectionsKt__IterablesKt.bodyAsTextLimited(null, 0, null, this);
    }
}
