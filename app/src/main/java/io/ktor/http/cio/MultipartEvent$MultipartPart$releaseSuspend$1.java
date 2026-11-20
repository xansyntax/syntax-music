package io.ktor.http.cio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.cio.MultipartEvent$MultipartPart", f = "Multipart.kt", l = {91, 93, 93}, m = "releaseSuspend", v = 1)
public final class MultipartEvent$MultipartPart$releaseSuspend$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultipartEvent.MultipartPart this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultipartEvent$MultipartPart$releaseSuspend$1(MultipartEvent.MultipartPart multipartPart, Continuation continuation) {
        super(continuation);
        this.this$0 = multipartPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.releaseSuspend(this);
    }
}
