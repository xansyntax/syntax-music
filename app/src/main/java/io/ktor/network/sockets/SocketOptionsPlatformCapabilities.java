package io.ktor.network.sockets;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.SocketOption;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\nJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/ktor/network/sockets/SocketOptionsPlatformCapabilities;", "", "<init>", "()V", "Ljava/nio/channels/SocketChannel;", "channel", "", "setReusePort", "(Ljava/nio/channels/SocketChannel;)V", "Ljava/nio/channels/ServerSocketChannel;", "(Ljava/nio/channels/ServerSocketChannel;)V", "Ljava/nio/channels/DatagramChannel;", "(Ljava/nio/channels/DatagramChannel;)V", "", ContentDisposition.Parameters.Name, "socketOption", "(Ljava/lang/String;)Ljava/lang/Object;", "", "Ljava/lang/reflect/Field;", "standardSocketOptions", "Ljava/util/Map;", "Ljava/lang/reflect/Method;", "channelSetOption", "Ljava/lang/reflect/Method;", "serverChannelSetOption", "datagramSetOption", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SocketOptionsPlatformCapabilities {
    public static final SocketOptionsPlatformCapabilities INSTANCE;
    private static final Method channelSetOption;
    private static final Method datagramSetOption;
    private static final Method serverChannelSetOption;
    private static final Map<String, Field> standardSocketOptions;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Method[] methods;
        int length;
        int i;
        Map map = EmptyMap.INSTANCE;
        INSTANCE = new SocketOptionsPlatformCapabilities();
        try {
            try {
                Field[] fields = Class.forName("java.net.StandardSocketOptions").getFields();
                if (fields != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Field field : fields) {
                        int modifiers = field.getModifiers();
                        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers)) {
                            arrayList.add(field);
                        }
                    }
                    int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    if (iMapCapacity < 16) {
                        iMapCapacity = 16;
                    }
                    Map linkedHashMap = new LinkedHashMap(iMapCapacity);
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        String name = ((Field) obj).getName();
                        name.getClass();
                        linkedHashMap.put(name, obj);
                    }
                    map = linkedHashMap;
                }
                while (true) {
                    if (i >= length) {
                        method = null;
                        break;
                    }
                    method = methods[i];
                    int modifiers2 = method.getModifiers();
                    if (Modifier.isPublic(modifiers2) && !Modifier.isStatic(modifiers2) && Intrinsics.areEqual(method.getName(), "setOption") && method.getParameterTypes().length == 2 && Intrinsics.areEqual(method.getReturnType(), cls) && Intrinsics.areEqual(method.getParameterTypes()[0], SocketOption.class) && Intrinsics.areEqual(method.getParameterTypes()[1], Object.class)) {
                        break;
                    } else {
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
            cls = Class.forName("java.nio.channels.SocketChannel");
            methods = cls.getMethods();
            methods.getClass();
            length = methods.length;
            i = 0;
        } catch (Throwable unused2) {
        }
        standardSocketOptions = map;
        Method method3 = null;
        channelSetOption = method;
        try {
            Class<?> cls2 = Class.forName("java.nio.channels.ServerSocketChannel");
            Method[] methods2 = cls2.getMethods();
            methods2.getClass();
            int length2 = methods2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    method2 = null;
                    break;
                }
                method2 = methods2[i3];
                int modifiers3 = method2.getModifiers();
                if (Modifier.isPublic(modifiers3) && !Modifier.isStatic(modifiers3) && Intrinsics.areEqual(method2.getName(), "setOption") && method2.getParameterTypes().length == 2 && Intrinsics.areEqual(method2.getReturnType(), cls2) && Intrinsics.areEqual(method2.getParameterTypes()[0], SocketOption.class) && Intrinsics.areEqual(method2.getParameterTypes()[1], Object.class)) {
                    break;
                } else {
                    i3++;
                }
            }
        } catch (Throwable unused3) {
        }
        serverChannelSetOption = method2;
        try {
            Class<?> cls3 = Class.forName("java.nio.channels.DatagramChannel");
            Method[] methods3 = cls3.getMethods();
            methods3.getClass();
            for (Method method4 : methods3) {
                int modifiers4 = method4.getModifiers();
                if (Modifier.isPublic(modifiers4) && !Modifier.isStatic(modifiers4) && Intrinsics.areEqual(method4.getName(), "setOption") && method4.getParameterTypes().length == 2 && Intrinsics.areEqual(method4.getReturnType(), cls3) && Intrinsics.areEqual(method4.getParameterTypes()[0], SocketOption.class) && Intrinsics.areEqual(method4.getParameterTypes()[1], Object.class)) {
                    method3 = method4;
                    break;
                }
            }
        } catch (Throwable unused4) {
        }
        datagramSetOption = method3;
    }

    private SocketOptionsPlatformCapabilities() {
    }

    private final Object socketOption(String name) throws IOException {
        Object obj;
        Field field = standardSocketOptions.get(name);
        if (field != null && (obj = field.get(null)) != null) {
            return obj;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m("Socket option ", name, " is not supported"));
        return null;
    }

    public final void setReusePort(SocketChannel channel) throws IllegalAccessException, IOException, InvocationTargetException {
        channel.getClass();
        Object objSocketOption = socketOption("SO_REUSEPORT");
        Method method = channelSetOption;
        method.getClass();
        method.invoke(channel, objSocketOption, Boolean.TRUE);
    }

    public final void setReusePort(ServerSocketChannel channel) throws IllegalAccessException, IOException, InvocationTargetException {
        channel.getClass();
        Object objSocketOption = socketOption("SO_REUSEPORT");
        Method method = serverChannelSetOption;
        method.getClass();
        method.invoke(channel, objSocketOption, Boolean.TRUE);
    }

    public final void setReusePort(DatagramChannel channel) throws IllegalAccessException, IOException, InvocationTargetException {
        channel.getClass();
        Object objSocketOption = socketOption("SO_REUSEPORT");
        Method method = datagramSetOption;
        method.getClass();
        method.invoke(channel, objSocketOption, Boolean.TRUE);
    }
}
