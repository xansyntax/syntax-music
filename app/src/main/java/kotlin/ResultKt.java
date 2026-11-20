package kotlin;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.internal.PlatformImplementations$ReflectThrowable;
import kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion;
import kotlin.jvm.functions.Function0;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResultKt {
    public static final CoroutineSingletons UNDEFINED_RESULT = CoroutineSingletons.COROUTINE_SUSPENDED;

    public static void addSuppressed(Throwable th, Throwable th2) {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = JDK7PlatformImplementations$ReflectSdkVersion.sdkVersion;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = PlatformImplementations$ReflectThrowable.addSuppressed;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static final Result.Failure createFailure(Throwable th) {
        th.getClass();
        return new Result.Failure(th);
    }

    public static Lazy lazy(LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function0) {
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.INSTANCE;
        int iOrdinal = lazyThreadSafetyMode.ordinal();
        if (iOrdinal == 0) {
            return new SynchronizedLazyImpl(function0);
        }
        if (iOrdinal == 1) {
            SafePublicationLazyImpl safePublicationLazyImpl = new SafePublicationLazyImpl();
            safePublicationLazyImpl.initializer = function0;
            safePublicationLazyImpl._value = uninitialized_value;
            return safePublicationLazyImpl;
        }
        if (iOrdinal != 2) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        UnsafeLazyImpl unsafeLazyImpl = new UnsafeLazyImpl();
        unsafeLazyImpl.initializer = function0;
        unsafeLazyImpl._value = uninitialized_value;
        return unsafeLazyImpl;
    }

    public static String stackTraceToString(Throwable th) {
        th.getClass();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        string.getClass();
        return string;
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    public static final Pair to(Object obj, Object obj2) {
        return new Pair(obj, obj2);
    }

    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048.0d) + (j & 2047);
    }

    public static final String ulongToString(int i, long j) {
        if (j >= 0) {
            CharsKt.checkRadix(i);
            String string = Long.toString(j, i);
            string.getClass();
            return string;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        CharsKt.checkRadix(i);
        String string2 = Long.toString(j3, i);
        string2.getClass();
        CharsKt.checkRadix(i);
        String string3 = Long.toString(j4, i);
        string3.getClass();
        return string2.concat(string3);
    }

    public static SynchronizedLazyImpl lazy(Function0 function0) {
        return new SynchronizedLazyImpl(function0);
    }
}
