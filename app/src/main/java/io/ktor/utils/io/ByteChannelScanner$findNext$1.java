package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelScanner", f = "ByteChannelScanner.kt", l = {53, 55, 58, 70}, m = "findNext$ktor_io", v = 1)
public final class ByteChannelScanner$findNext$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelScanner$findNext$1(ByteChannelScanner byteChannelScanner, Continuation continuation) {
        super(continuation);
        this.this$0 = byteChannelScanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.findNext$ktor_io(false, this);
    }
}
