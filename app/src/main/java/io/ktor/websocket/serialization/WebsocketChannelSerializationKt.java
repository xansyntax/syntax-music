package io.ktor.websocket.serialization;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\n\u001a\u00020\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087H¢\u0006\u0004\b\n\u0010\u000b\u001a:\u0010\n\u001a\u00020\t*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087@¢\u0006\u0004\b\n\u0010\u000e\u001a2\u0010\u000f\u001a\u0004\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087H¢\u0006\u0004\b\u000f\u0010\u0010\u001a2\u0010\u000f\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087@¢\u0006\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"T", "Lio/ktor/websocket/WebSocketSession;", "", "data", "Lio/ktor/serialization/WebsocketContentConverter;", "converter", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "sendSerializedBase", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveDeserializedBase", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WebsocketChannelSerializationKt {

    /* JADX INFO: renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", l = {103, 112}, m = "receiveDeserializedBase", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.receiveDeserializedBase(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", l = {54, 59}, m = "sendSerializedBase", v = 1)
    public static final class C03812 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C03812(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.sendSerializedBase(null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x00bc, please report this as an issue */
    public static final Object receiveDeserializedBase(WebSocketSession webSocketSession, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation continuation) throws WebsocketDeserializeException {
        AnonymousClass2 anonymousClass2;
        TypeInfo typeInfo2;
        Charset charset2;
        WebsocketContentConverter websocketContentConverter2;
        TypeInfo typeInfo3;
        Frame frame;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object objReceive = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objReceive);
            ReceiveChannel incoming = webSocketSession.getIncoming();
            anonymousClass2.L$0 = null;
            typeInfo2 = typeInfo;
            anonymousClass2.L$1 = typeInfo2;
            anonymousClass2.L$2 = websocketContentConverter;
            charset2 = charset;
            anonymousClass2.L$3 = charset2;
            anonymousClass2.label = 1;
            objReceive = incoming.receive(anonymousClass2);
            if (objReceive != coroutineSingletons) {
                websocketContentConverter2 = websocketContentConverter;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            Charset charset3 = (Charset) anonymousClass2.L$3;
            websocketContentConverter2 = (WebsocketContentConverter) anonymousClass2.L$2;
            TypeInfo typeInfo4 = (TypeInfo) anonymousClass2.L$1;
            ResultKt.throwOnFailure(objReceive);
            charset2 = charset3;
            typeInfo2 = typeInfo4;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Frame frame2 = (Frame) anonymousClass2.L$4;
            typeInfo3 = (TypeInfo) anonymousClass2.L$1;
            ResultKt.throwOnFailure(objReceive);
            frame = frame2;
        }
        if (typeInfo3.getType().isInstance(objReceive)) {
            return objReceive;
        }
        if (objReceive != null && typeInfo3.getIsNullable()) {
            return null;
        }
        if (objReceive == null) {
            throw new WebsocketDeserializeException("Frame has null content", null, frame, 2, null);
        }
        throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo3.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(objReceive.getClass()).getSimpleName(), null, frame, 2, null);
        Frame frame3 = (Frame) objReceive;
        if (!websocketContentConverter2.isApplicable(frame3)) {
            throw new WebsocketDeserializeException("Converter doesn't support frame type " + frame3.getFrameType().name(), null, frame3, 2, null);
        }
        anonymousClass2.L$0 = null;
        anonymousClass2.L$1 = typeInfo2;
        anonymousClass2.L$2 = null;
        anonymousClass2.L$3 = null;
        anonymousClass2.L$4 = frame3;
        anonymousClass2.label = 2;
        objReceive = websocketContentConverter2.deserialize(charset2, typeInfo2, frame3, anonymousClass2);
        if (objReceive != coroutineSingletons) {
            typeInfo3 = typeInfo2;
            frame = frame3;
            if (typeInfo3.getType().isInstance(objReceive)) {
                return objReceive;
            }
            if (objReceive != null) {
            }
            if (objReceive == null) {
                throw new WebsocketDeserializeException("Frame has null content", null, frame, 2, null);
            }
            throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo3.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(objReceive.getClass()).getSimpleName(), null, frame, 2, null);
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0087, code lost:
    
        if (r6.send((io.ktor.websocket.Frame) r11, r0) == r5) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation continuation) {
        C03812 c03812;
        if (continuation instanceof C03812) {
            c03812 = (C03812) continuation;
            int i = c03812.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03812.label = i - Integer.MIN_VALUE;
            } else {
                c03812 = new C03812(continuation);
            }
        } else {
            c03812 = new C03812(continuation);
        }
        Object objSerialize = c03812.result;
        int i2 = c03812.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSerialize);
            c03812.L$0 = webSocketSession;
            c03812.L$1 = null;
            c03812.L$2 = null;
            c03812.L$3 = null;
            c03812.L$4 = null;
            c03812.label = 1;
            objSerialize = websocketContentConverter.serialize(charset, typeInfo, obj, c03812);
            if (objSerialize != obj2) {
            }
            return obj2;
        }
        if (i2 == 1) {
            webSocketSession = (WebSocketSession) c03812.L$0;
            ResultKt.throwOnFailure(objSerialize);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objSerialize);
        }
        return Unit.INSTANCE;
        SendChannel outgoing = webSocketSession.getOutgoing();
        c03812.L$0 = null;
        c03812.L$1 = null;
        c03812.L$2 = null;
        c03812.L$3 = null;
        c03812.L$4 = null;
        c03812.L$5 = null;
        c03812.label = 2;
    }

    public static final <T> Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation continuation) {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public static final <T> Object receiveDeserializedBase(WebSocketSession webSocketSession, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation continuation) {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }
}
