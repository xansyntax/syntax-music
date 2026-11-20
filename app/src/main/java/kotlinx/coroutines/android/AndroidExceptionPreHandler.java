package kotlinx.coroutines.android;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.Key.$$INSTANCE);
        this._preHandler = this;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT < 28) {
            Object obj = this._preHandler;
            if (obj != this) {
                declaredMethod = (Method) obj;
            } else {
                try {
                    declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
                    if (!Modifier.isPublic(declaredMethod.getModifiers()) || !Modifier.isStatic(declaredMethod.getModifiers())) {
                        declaredMethod = null;
                    }
                } catch (Throwable unused) {
                }
                this._preHandler = declaredMethod;
            }
            Object objInvoke = declaredMethod != null ? declaredMethod.invoke(null, null) : null;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
