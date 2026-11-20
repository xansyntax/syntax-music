package io.ktor.client.request.forms;

import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt__StringsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.io.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a \u0010\b\u001a\u00020\u0007*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "generateBoundary", "()Ljava/lang/String;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "copyTo", "(Lkotlinx/io/Source;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "RN_BYTES", "[B", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FormDataContentKt {
    private static final byte[] RN_BYTES = StringsKt__StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object copyTo(Source source, ByteWriteChannel byteWriteChannel, Continuation continuation) {
        Object objWritePacket = ByteWriteChannelOperationsKt.writePacket(byteWriteChannel, source, continuation);
        return objWritePacket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWritePacket : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int iNextInt = Random.defaultRandom.nextInt();
            CharsKt.checkRadix(16);
            String string = Integer.toString(iNextInt, 16);
            string.getClass();
            sb.append(string);
        }
        return StringsKt.take(70, sb.toString());
    }
}
