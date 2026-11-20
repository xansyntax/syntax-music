package io.ktor.http;

import io.ktor.client.engine.okhttp.OkHttpEngineKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.websocket.WebSocketExtensionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SealedClassSerializer$$ExternalSyntheticLambda1;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecodingException;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.internal.WriteModeKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Url$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Url$$ExternalSyntheticLambda1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String[] strArrNames;
        long initialWindowSize;
        Http2Stream[] http2StreamArr = null;
        Object[] objArr = 0;
        switch (this.$r8$classId) {
            case 0:
                return Url.encodedPath_delegate$lambda$0((List) this.f$0, (Url) this.f$1);
            case 1:
                return OkHttpEngineKt.convertToOkHttpBody$lambda$2((CoroutineContext) this.f$0, (OutgoingContent) this.f$1);
            case 2:
                return ((WebSocketExtensionFactory) this.f$0).install((Function1) this.f$1);
            case 3:
                Regex regex = (Regex) this.f$0;
                CharSequence charSequence = (CharSequence) this.f$1;
                regex.getClass();
                Matcher matcher = regex.nativePattern.matcher(charSequence);
                matcher.getClass();
                return RegexKt.findNext(matcher, 0, charSequence);
            case 4:
                return StringsKt__IndentKt.buildSerialDescriptor((String) this.f$0, PolymorphicKind$OPEN.INSTANCE$1, new SerialDescriptor[0], new SealedClassSerializer$$ExternalSyntheticLambda1((SealedClassSerializer) this.f$1, objArr == true ? 1 : 0));
            case 5:
                EnumSerializer enumSerializer = (EnumSerializer) this.f$0;
                String str = (String) this.f$1;
                EnumDescriptor enumDescriptor = enumSerializer.overriddenDescriptor;
                if (enumDescriptor == null) {
                    Enum[] enumArr = enumSerializer.values;
                    enumDescriptor = new EnumDescriptor(str, enumArr.length);
                    for (Enum r0 : enumArr) {
                        enumDescriptor.addElement(r0.name(), false);
                    }
                }
                return enumDescriptor;
            case 6:
                SerialDescriptor serialDescriptor = (SerialDescriptor) this.f$0;
                Json json = (Json) this.f$1;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                JsonConfiguration jsonConfiguration = json.configuration;
                WriteModeKt.namingStrategy(serialDescriptor, json);
                int elementsCount = serialDescriptor.getElementsCount();
                for (int i = 0; i < elementsCount; i++) {
                    List elementAnnotations = serialDescriptor.getElementAnnotations(i);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : elementAnnotations) {
                        if (obj instanceof JsonNames) {
                            arrayList.add(obj);
                        }
                    }
                    JsonNames jsonNames = (JsonNames) CollectionsKt.singleOrNull(arrayList);
                    if (jsonNames != null && (strArrNames = jsonNames.names()) != null) {
                        for (String str2 : strArrNames) {
                            String str3 = Intrinsics.areEqual(serialDescriptor.getKind(), SerialKind$ENUM.INSTANCE) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str2)) {
                                throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "The suggested name '" + str2 + "' for " + str3 + ' ' + serialDescriptor.getElementName(i) + " is already one of the names for " + str3 + ' ' + serialDescriptor.getElementName(((Number) MapsKt__MapsKt.getValue(linkedHashMap, str2)).intValue()) + " in " + serialDescriptor, null, null, null));
                            }
                            linkedHashMap.put(str2, Integer.valueOf(i));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? EmptyMap.INSTANCE : linkedHashMap;
            case 7:
                Http2Connection http2Connection = (Http2Connection) this.f$0;
                Http2Stream http2Stream = (Http2Stream) this.f$1;
                try {
                    http2Connection.listener.onStream(http2Stream);
                    break;
                } catch (IOException e) {
                    Platform platform = Platform.platform;
                    Platform.platform.log(4, "Http2Connection.Listener failure for " + http2Connection.connectionName, e);
                    try {
                        http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return Unit.INSTANCE;
            case 8:
                Http2Connection.ReaderRunnable readerRunnable = (Http2Connection.ReaderRunnable) this.f$0;
                Settings settings = (Settings) this.f$1;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Http2Connection http2Connection2 = (Http2Connection) readerRunnable.this$0;
                synchronized (http2Connection2.writer) {
                    synchronized (http2Connection2) {
                        try {
                            Settings settings2 = http2Connection2.peerSettings;
                            Settings settings3 = new Settings();
                            settings2.getClass();
                            for (int i2 = 0; i2 < 10; i2++) {
                                if (((1 << i2) & settings2.set) != 0) {
                                    settings3.set(i2, settings2.values[i2]);
                                }
                            }
                            for (int i3 = 0; i3 < 10; i3++) {
                                if (((1 << i3) & settings.set) != 0) {
                                    settings3.set(i3, settings.values[i3]);
                                }
                            }
                            ref$ObjectRef.element = settings3;
                            initialWindowSize = ((long) settings3.getInitialWindowSize()) - ((long) settings2.getInitialWindowSize());
                            if (initialWindowSize != 0 && !http2Connection2.streams.isEmpty()) {
                                http2StreamArr = (Http2Stream[]) http2Connection2.streams.values().toArray(new Http2Stream[0]);
                            }
                            Settings settings4 = (Settings) ref$ObjectRef.element;
                            settings4.getClass();
                            http2Connection2.peerSettings = settings4;
                            TaskQueue.execute$default(http2Connection2.settingsListenerQueue, http2Connection2.connectionName + " onSettings", 0L, new Url$$ExternalSyntheticLambda1(http2Connection2, ref$ObjectRef, (byte) 9), 6);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        http2Connection2.writer.applyAndAckSettings((Settings) ref$ObjectRef.element);
                    } catch (IOException e2) {
                        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                        http2Connection2.close$okhttp(errorCode, errorCode, e2);
                    }
                    break;
                }
                if (http2StreamArr != null) {
                    for (Http2Stream http2Stream2 : http2StreamArr) {
                        synchronized (http2Stream2) {
                            http2Stream2.writeBytesMaximum += initialWindowSize;
                            if (initialWindowSize > 0) {
                                http2Stream2.notifyAll();
                            }
                            break;
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                Http2Connection http2Connection3 = (Http2Connection) this.f$0;
                http2Connection3.listener.onSettings(http2Connection3, (Settings) ((Ref$ObjectRef) this.f$1).element);
                return Unit.INSTANCE;
        }
    }
}
