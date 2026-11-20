package io.ktor.websocket;

import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda0;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.internals.DeflaterUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/.B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R.\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010%¨\u00060"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "config", "<init>", "(Lio/ktor/websocket/WebSocketDeflateExtension$Config;)V", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "negotiatedProtocols", "", "clientNegotiation", "(Ljava/util/List;)Z", "requestedProtocols", "serverNegotiation", "(Ljava/util/List;)Ljava/util/List;", "Lio/ktor/websocket/Frame;", "frame", "processOutgoingFrame", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processIncomingFrame", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "factory", "Lio/ktor/websocket/WebSocketExtensionFactory;", "getFactory", "()Lio/ktor/websocket/WebSocketExtensionFactory;", "protocols", "Ljava/util/List;", "getProtocols", "()Ljava/util/List;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "outgoingNoContextTakeover", "Z", "getOutgoingNoContextTakeover$ktor_websockets", "()Z", "setOutgoingNoContextTakeover$ktor_websockets", "(Z)V", "incomingNoContextTakeover", "getIncomingNoContextTakeover$ktor_websockets", "setIncomingNoContextTakeover$ktor_websockets", "decompressIncoming", "Companion", "Config", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSocketDeflateExtension implements WebSocketExtension<Config> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<WebSocketDeflateExtension> key;
    private static final boolean rsv1;
    private static final boolean rsv2 = false;
    private static final boolean rsv3 = false;
    private final Config config;
    private boolean decompressIncoming;
    private final Deflater deflater;
    private final WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> factory;
    private boolean incomingNoContextTakeover;
    private final Inflater inflater;
    private boolean outgoingNoContextTakeover;
    private final List<WebSocketExtensionHeader> protocols;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u0011R\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010\u0011R4\u0010'\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\nR.\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*\"\u0004\b.\u0010\n¨\u0006/"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "", "<init>", "()V", "Lkotlin/Function1;", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "", "block", "configureProtocols", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/websocket/Frame;", "", "compressIf", "", "bytes", "compressIfBiggerThan", "(I)V", "", "build$ktor_websockets", "()Ljava/util/List;", "build", "clientNoContextTakeOver", "Z", "getClientNoContextTakeOver", "()Z", "setClientNoContextTakeOver", "(Z)V", "serverNoContextTakeOver", "getServerNoContextTakeOver", "setServerNoContextTakeOver", "compressionLevel", "I", "getCompressionLevel", "()I", "setCompressionLevel", "maxInflatedFrameSize", "getMaxInflatedFrameSize", "setMaxInflatedFrameSize", "manualConfig", "Lkotlin/jvm/functions/Function1;", "getManualConfig$ktor_websockets", "()Lkotlin/jvm/functions/Function1;", "setManualConfig$ktor_websockets", "compressCondition", "getCompressCondition$ktor_websockets", "setCompressCondition$ktor_websockets", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Config {
        private boolean clientNoContextTakeOver;
        private boolean serverNoContextTakeOver;
        private int compressionLevel = -1;
        private int maxInflatedFrameSize = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        private Function1 manualConfig = new InstantKt$$ExternalSyntheticLambda0((byte) 12);
        private Function1 compressCondition = new InstantKt$$ExternalSyntheticLambda0((byte) 13);

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressCondition$lambda$0(Frame frame) {
            frame.getClass();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressIf$lambda$0(Function1 function1, Function1 function2, Frame frame) {
            frame.getClass();
            return ((Boolean) function1.invoke(frame)).booleanValue() && ((Boolean) function2.invoke(frame)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressIfBiggerThan$lambda$0(int i, Frame frame) {
            frame.getClass();
            return frame.getData().length > i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit configureProtocols$lambda$0(Function1 function1, Function1 function2, List list) {
            list.getClass();
            function1.invoke(list);
            function2.invoke(list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit manualConfig$lambda$0(List list) {
            list.getClass();
            return Unit.INSTANCE;
        }

        public final List<WebSocketExtensionHeader> build$ktor_websockets() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.clientNoContextTakeOver) {
                arrayList2.add("client_no_context_takeover");
            }
            if (this.serverNoContextTakeOver) {
                arrayList2.add("server_no_context_takeover");
            }
            arrayList.add(new WebSocketExtensionHeader("permessage-deflate", arrayList2));
            this.manualConfig.invoke(arrayList);
            return arrayList;
        }

        public final void compressIf(Function1 block) {
            block.getClass();
            this.compressCondition = new HttpClientConfig$$ExternalSyntheticLambda0(block, this.compressCondition, (byte) 5);
        }

        public final void compressIfBiggerThan(int bytes) {
            compressIf(new TimePickerKt$$ExternalSyntheticLambda36((byte) 8, bytes));
        }

        public final void configureProtocols(Function1 block) {
            block.getClass();
            this.manualConfig = new HttpClientConfig$$ExternalSyntheticLambda0(this.manualConfig, block, (byte) 6);
        }

        public final boolean getClientNoContextTakeOver() {
            return this.clientNoContextTakeOver;
        }

        /* JADX INFO: renamed from: getCompressCondition$ktor_websockets, reason: from getter */
        public final Function1 getCompressCondition() {
            return this.compressCondition;
        }

        public final int getCompressionLevel() {
            return this.compressionLevel;
        }

        /* JADX INFO: renamed from: getManualConfig$ktor_websockets, reason: from getter */
        public final Function1 getManualConfig() {
            return this.manualConfig;
        }

        public final int getMaxInflatedFrameSize() {
            return this.maxInflatedFrameSize;
        }

        public final boolean getServerNoContextTakeOver() {
            return this.serverNoContextTakeOver;
        }

        public final void setClientNoContextTakeOver(boolean z) {
            this.clientNoContextTakeOver = z;
        }

        public final void setCompressCondition$ktor_websockets(Function1 function1) {
            function1.getClass();
            this.compressCondition = function1;
        }

        public final void setCompressionLevel(int i) {
            this.compressionLevel = i;
        }

        public final void setManualConfig$ktor_websockets(Function1 function1) {
            function1.getClass();
            this.manualConfig = function1;
        }

        public final void setMaxInflatedFrameSize(int i) {
            this.maxInflatedFrameSize = i;
        }

        public final void setServerNoContextTakeOver(boolean z) {
            this.serverNoContextTakeOver = z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TypeReference typeReferenceTypeOf = null;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WebSocketDeflateExtension.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(WebSocketDeflateExtension.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("WebsocketDeflateExtension", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        rsv1 = true;
    }

    public WebSocketDeflateExtension(Config config) {
        config.getClass();
        this.config = config;
        this.factory = INSTANCE;
        this.protocols = config.build$ktor_websockets();
        this.inflater = new Inflater(true);
        this.deflater = new Deflater(config.getCompressionLevel(), true);
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public boolean clientNegotiation(List<WebSocketExtensionHeader> negotiatedProtocols) {
        Object next;
        negotiatedProtocols.getClass();
        Iterator<T> it = negotiatedProtocols.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((WebSocketExtensionHeader) next).getName(), "permessage-deflate"));
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) next;
        if (webSocketExtensionHeader == null) {
            return false;
        }
        this.incomingNoContextTakeover = this.config.getServerNoContextTakeOver();
        this.outgoingNoContextTakeover = this.config.getClientNoContextTakeOver();
        for (Pair pair : webSocketExtensionHeader.parseParameters()) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            switch (str.hashCode()) {
                case -708713803:
                    if (str.equals("client_no_context_takeover")) {
                        if (!StringsKt.isBlank(str2)) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) "WebSocket permessage-deflate extension parameter client_no_context_takeover shouldn't have a value. Current: ".concat(str2));
                            return false;
                        }
                        this.outgoingNoContextTakeover = true;
                    } else {
                        continue;
                    }
                    break;
                case 646404390:
                    if (str.equals("client_max_window_bits") && !StringsKt.isBlank(str2) && Integer.parseInt(str2) != 15) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Only 15 window size is supported.");
                        return false;
                    }
                    break;
                    break;
                case 1266201133:
                    if (str.equals("server_no_context_takeover")) {
                        if (!StringsKt.isBlank(str2)) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) "WebSocket permessage-deflate extension parameter server_no_context_takeover shouldn't have a value. Current: ".concat(str2));
                            return false;
                        }
                        this.incomingNoContextTakeover = true;
                    } else {
                        continue;
                    }
                    break;
                case 2034279582:
                    str.equals("server_max_window_bits");
                    break;
            }
        }
        return true;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> getFactory() {
        return this.factory;
    }

    /* JADX INFO: renamed from: getIncomingNoContextTakeover$ktor_websockets, reason: from getter */
    public final boolean getIncomingNoContextTakeover() {
        return this.incomingNoContextTakeover;
    }

    /* JADX INFO: renamed from: getOutgoingNoContextTakeover$ktor_websockets, reason: from getter */
    public final boolean getOutgoingNoContextTakeover() {
        return this.outgoingNoContextTakeover;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public List<WebSocketExtensionHeader> getProtocols() {
        return this.protocols;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public Frame processIncomingFrame(Frame frame) {
        frame.getClass();
        if (!WebSocketDeflateExtensionKt.isCompressed(frame) && !this.decompressIncoming) {
            return frame;
        }
        this.decompressIncoming = true;
        byte[] bArrInflateFully = DeflaterUtilsKt.inflateFully(this.inflater, frame.getData(), this.config.getMaxInflatedFrameSize());
        if (this.incomingNoContextTakeover) {
            this.inflater.reset();
        }
        if (frame.getFin()) {
            this.decompressIncoming = false;
        }
        return Frame.INSTANCE.byType(frame.getFin(), frame.getFrameType(), bArrInflateFully, !rsv1, frame.getRsv2(), frame.getRsv3());
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public Frame processOutgoingFrame(Frame frame) {
        frame.getClass();
        if ((!(frame instanceof Frame.Text) && !(frame instanceof Frame.Binary)) || !((Boolean) this.config.getCompressCondition().invoke(frame)).booleanValue()) {
            return frame;
        }
        byte[] bArrDeflateFully = DeflaterUtilsKt.deflateFully(this.deflater, frame.getData());
        if (this.outgoingNoContextTakeover) {
            this.deflater.reset();
        }
        return Frame.INSTANCE.byType(frame.getFin(), frame.getFrameType(), bArrDeflateFully, rsv1, frame.getRsv2(), frame.getRsv3());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.ktor.websocket.WebSocketExtension
    public List<WebSocketExtensionHeader> serverNegotiation(List<WebSocketExtensionHeader> requestedProtocols) {
        Object next;
        requestedProtocols.getClass();
        Iterator<T> it = requestedProtocols.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((WebSocketExtensionHeader) next).getName(), "permessage-deflate"));
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) next;
        if (webSocketExtensionHeader == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (Pair pair : webSocketExtensionHeader.parseParameters()) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            Locale locale = Locale.getDefault();
            locale.getClass();
            String lowerCase = str.toLowerCase(locale);
            lowerCase.getClass();
            switch (lowerCase.hashCode()) {
                case -708713803:
                    if (!lowerCase.equals("client_no_context_takeover")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + str + ", " + str2 + ')').toString());
                    }
                    if (!StringsKt.isBlank(str2)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                        return null;
                    }
                    this.incomingNoContextTakeover = true;
                    arrayList.add("client_no_context_takeover");
                    break;
                    break;
                case 646404390:
                    if (!lowerCase.equals("client_max_window_bits")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + str + ", " + str2 + ')').toString());
                    }
                    break;
                    break;
                case 1266201133:
                    if (!lowerCase.equals("server_no_context_takeover")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + str + ", " + str2 + ')').toString());
                    }
                    if (!StringsKt.isBlank(str2)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                        return null;
                    }
                    this.outgoingNoContextTakeover = true;
                    arrayList.add("server_no_context_takeover");
                    break;
                    break;
                case 2034279582:
                    if (!lowerCase.equals("server_max_window_bits")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + str + ", " + str2 + ')').toString());
                    }
                    if (Integer.parseInt(str2) != 15) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Only 15 window size is supported");
                        return null;
                    }
                    break;
                    break;
                default:
                    throw new IllegalStateException(("Unsupported extension parameter: (" + str + ", " + str2 + ')').toString());
            }
        }
        return CollectionsKt__IterablesKt.listOf(new WebSocketExtensionHeader("permessage-deflate", arrayList));
    }

    public final void setIncomingNoContextTakeover$ktor_websockets(boolean z) {
        this.incomingNoContextTakeover = z;
    }

    public final void setOutgoingNoContextTakeover$ktor_websockets(boolean z) {
        this.outgoingNoContextTakeover = z;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Companion;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketDeflateExtension;", "<init>", "()V", "Lkotlin/Function1;", "", "config", "install", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "", "rsv1", "Z", "getRsv1", "()Z", "rsv2", "getRsv2", "rsv3", "getRsv3", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements WebSocketExtensionFactory<Config, WebSocketDeflateExtension> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public AttributeKey<WebSocketDeflateExtension> getKey() {
            return WebSocketDeflateExtension.key;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv1() {
            return WebSocketDeflateExtension.rsv1;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv2() {
            return WebSocketDeflateExtension.rsv2;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv3() {
            return WebSocketDeflateExtension.rsv3;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public WebSocketDeflateExtension install(Function1 config) {
            config.getClass();
            Config config2 = new Config();
            config.invoke(config2);
            return new WebSocketDeflateExtension(config2);
        }

        private Companion() {
        }
    }
}
