package io.ktor.websocket;

import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", l = {79, 83}, m = "invokeSuspend", v = 1)
public final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ SendChannel $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PingPongKt$pinger$1$rc$1(SendChannel sendChannel, String str, Channel channel, Continuation continuation) {
        super(2, continuation);
        this.$outgoing = sendChannel;
        this.$pingMessage = str;
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PingPongKt$pinger$1$rc$1(this.$outgoing, this.$pingMessage, this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PingPongKt$pinger$1$rc$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r7 == r3) goto L15;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0047 -> B:16:0x004a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DefaultWebSocketSessionKt.getLOGGER().trace("WebSocket Pinger: sending ping frame");
            SendChannel sendChannel = this.$outgoing;
            Frame.Ping ping = new Frame.Ping(StringsKt.toByteArray(this.$pingMessage, Charsets.ISO_8859_1));
            this.label = 1;
            if (sendChannel.send(ping, this) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        Frame.Pong pong = (Frame.Pong) obj;
        if (StringsKt__StringsJVMKt.decodeToString$default(0, pong.getData().length, 4, pong.getData()).equals(this.$pingMessage)) {
            Logger logger = DefaultWebSocketSessionKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("WebSocket Pinger: received valid pong frame " + pong);
            }
            return Unit.INSTANCE;
        }
        Logger logger2 = DefaultWebSocketSessionKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger2)) {
            logger2.trace("WebSocket Pinger: received invalid pong frame " + pong + ", continue waiting");
        }
        Channel channel = this.$channel;
        this.label = 2;
        obj = channel.receive(this);
    }
}
