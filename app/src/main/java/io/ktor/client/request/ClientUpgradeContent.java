package io.ktor.client.request;

import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/request/ClientUpgradeContent;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "pipeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Headers;", "headers", "verify", "(Lio/ktor/http/Headers;)V", "Lio/ktor/utils/io/ByteChannel;", "content$delegate", "Lkotlin/Lazy;", "getContent", "()Lio/ktor/utils/io/ByteChannel;", "content", "getOutput", "()Lio/ktor/utils/io/ByteWriteChannel;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ClientUpgradeContent extends OutgoingContent.NoContent {

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    private final Lazy content = new SynchronizedLazyImpl(new Shazam$$ExternalSyntheticLambda0(29));

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteChannel content_delegate$lambda$0() {
        return new ByteChannel(false, 1, null);
    }

    private final ByteChannel getContent() {
        return (ByteChannel) this.content.getValue();
    }

    public final ByteWriteChannel getOutput() {
        return getContent();
    }

    public final Object pipeTo(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        Object objCopyAndClose = ByteReadChannelOperationsKt.copyAndClose(getContent(), byteWriteChannel, continuation);
        return objCopyAndClose == CoroutineSingletons.COROUTINE_SUSPENDED ? objCopyAndClose : Unit.INSTANCE;
    }

    public abstract void verify(Headers headers);
}
