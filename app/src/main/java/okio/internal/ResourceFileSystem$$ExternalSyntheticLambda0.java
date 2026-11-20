package okio.internal;

import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import kotlin.Pair;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.descriptors.ContextDescriptor;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.internal.EnumsKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketWriter;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ResourceFileSystem$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ResourceFileSystem$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws IOException {
        int iLastIndexOf$default;
        Pair pair;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                ResourceFileSystem resourceFileSystem = (ResourceFileSystem) obj;
                ClassLoader classLoader = resourceFileSystem.classLoader;
                FileSystem fileSystem = resourceFileSystem.systemFileSystem;
                Enumeration<URL> resources = classLoader.getResources("");
                resources.getClass();
                ArrayList list = Collections.list(resources);
                list.getClass();
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                int i = 0;
                while (true) {
                    Pair pair2 = null;
                    if (i >= size) {
                        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                        resources2.getClass();
                        ArrayList list2 = Collections.list(resources2);
                        list2.getClass();
                        ArrayList arrayList2 = new ArrayList();
                        int size2 = list2.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            Object obj2 = list2.get(i2);
                            i2++;
                            URL url = (URL) obj2;
                            url.getClass();
                            String string = url.toString();
                            string.getClass();
                            if (StringsKt__StringsJVMKt.startsWith(string, "jar:file:", false) && (iLastIndexOf$default = StringsKt.lastIndexOf$default(string, "!", 6)) != -1) {
                                String str = Path.DIRECTORY_SEPARATOR;
                                pair = new Pair(_ZlibJvmKt.openZip(Path.Companion.get$default(new File(URI.create(string.substring(4, iLastIndexOf$default)))), fileSystem, new ZipFilesKt$$ExternalSyntheticLambda2((byte) 1)), ResourceFileSystem.ROOT);
                            } else {
                                pair = null;
                            }
                            if (pair != null) {
                                arrayList2.add(pair);
                            }
                        }
                        return CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayList);
                    }
                    Object obj3 = list.get(i);
                    i++;
                    URL url2 = (URL) obj3;
                    url2.getClass();
                    if (Intrinsics.areEqual(url2.getProtocol(), "file")) {
                        String str2 = Path.DIRECTORY_SEPARATOR;
                        pair2 = new Pair(fileSystem, Path.Companion.get$default(new File(url2.toURI())));
                    }
                    if (pair2 != null) {
                        arrayList.add(pair2);
                    }
                }
                break;
            case 1:
                return new UIntArray.Iterator((Object[]) obj);
            case 2:
                return ((TypeParameterReference) obj).container.findJavaDeclaration();
            case 3:
                return obj;
            case 4:
                PolymorphicSerializer polymorphicSerializer = (PolymorphicSerializer) obj;
                return new ContextDescriptor(StringsKt__IndentKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", PolymorphicKind$OPEN.INSTANCE, new SerialDescriptor[0], new PingPongKt$$ExternalSyntheticLambda0((byte) 9, (Object) polymorphicSerializer)), polymorphicSerializer.baseClass);
            case 5:
                return ((KType) ((ArrayList) obj).get(0)).getClassifier();
            case 6:
                SerialDescriptorImpl serialDescriptorImpl = (SerialDescriptorImpl) obj;
                return Integer.valueOf(EnumsKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors));
            case 7:
                Http2Connection http2Connection = (Http2Connection) obj;
                http2Connection.getClass();
                try {
                    http2Connection.writer.ping(2, false, 0);
                    break;
                } catch (IOException e) {
                    ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                    http2Connection.close$okhttp(errorCode, errorCode, e);
                }
                return unit;
            case 8:
                _UtilCommonKt.closeQuietly((WebSocketWriter) obj);
                return unit;
            default:
                ((RealWebSocket) obj).cancel();
                return unit;
        }
    }
}
