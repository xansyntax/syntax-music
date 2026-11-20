package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {749}, m = "internalReadLineTo$discardCrlfOrCr", v = 1)
public final class ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelOperationsKt.internalReadLineTo$discardCrlfOrCr(null, null, false, this);
    }
}
