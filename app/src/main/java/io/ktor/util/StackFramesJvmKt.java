package io.ktor.util;

import kotlin.Metadata;
import kotlin.reflect.KClass;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n*\f\b\u0000\u0010\f\"\u00020\u000b2\u00020\u000b*\f\b\u0000\u0010\r\"\u00020\u00072\u00020\u0007¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KClass;", "kClass", "", "methodName", "fileName", "", "lineNumber", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "createStackTraceElement", "(Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "CoroutineStackFrame", "StackTraceElement", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StackFramesJvmKt {
    public static final StackTraceElement createStackTraceElement(KClass<?> kClass, String str, String str2, int i) {
        kClass.getClass();
        str.getClass();
        str2.getClass();
        return new StackTraceElement(Okio__OkioKt.getJavaClass(kClass).getName(), str, str2, i);
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }
}
