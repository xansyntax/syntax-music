package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a/\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onClose", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;)Lio/ktor/utils/io/ByteWriteChannel;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CloseHookByteWriteChannelKt {
    public static final ByteWriteChannel onClose(ByteWriteChannel byteWriteChannel, Function1 function1) {
        byteWriteChannel.getClass();
        function1.getClass();
        return new CloseHookByteWriteChannel(byteWriteChannel, function1);
    }
}
