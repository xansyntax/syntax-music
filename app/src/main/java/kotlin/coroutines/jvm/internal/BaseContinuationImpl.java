package kotlin.coroutines.jvm.internal;

import androidx.navigation.NavDeepLinkRequest;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseContinuationImpl implements Continuation, CoroutineStackFrame, Serializable {
    private final Continuation completion;

    public BaseContinuationImpl(Continuation continuation) {
        this.completion = continuation;
    }

    public Continuation create(Continuation continuation) {
        continuation.getClass();
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final Continuation getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        DebugMetadata debugMetadata = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        String str = null;
        if (debugMetadata == null || debugMetadata.v() < 1) {
            return null;
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? debugMetadata.l()[iIntValue] : -1;
        NavDeepLinkRequest navDeepLinkRequest = Boxing.cache;
        NavDeepLinkRequest navDeepLinkRequest2 = Boxing.notOnJava9;
        if (navDeepLinkRequest == null) {
            try {
                NavDeepLinkRequest navDeepLinkRequest3 = new NavDeepLinkRequest((Object) Class.class.getDeclaredMethod("getModule", null), (Object) getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), (Object) getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ContentDisposition.Parameters.Name, null), (byte) 8);
                Boxing.cache = navDeepLinkRequest3;
                navDeepLinkRequest = navDeepLinkRequest3;
            } catch (Exception unused2) {
                Boxing.cache = navDeepLinkRequest2;
                navDeepLinkRequest = navDeepLinkRequest2;
            }
        }
        if (navDeepLinkRequest != navDeepLinkRequest2 && (method = (Method) navDeepLinkRequest.uri) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) navDeepLinkRequest.action) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) navDeepLinkRequest.mimeType;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = debugMetadata.c();
        } else {
            strC = str + '/' + debugMetadata.c();
        }
        return new StackTraceElement(strC, debugMetadata.m(), debugMetadata.f(), i);
    }

    public Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ?? r2 = this;
        while (true) {
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) r2;
            Continuation continuation = baseContinuationImpl.completion;
            continuation.getClass();
            try {
                obj = baseContinuationImpl.invokeSuspend(obj);
                if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return;
                }
            } catch (Throwable th) {
                obj = new Result.Failure(th);
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(continuation instanceof BaseContinuationImpl)) {
                continuation.resumeWith(obj);
                return;
            }
            r2 = continuation;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public Continuation create(Object obj, Continuation continuation) {
        continuation.getClass();
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
