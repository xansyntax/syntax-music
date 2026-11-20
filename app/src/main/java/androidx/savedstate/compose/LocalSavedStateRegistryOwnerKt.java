package androidx.savedstate.compose;

import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.savedstate.SavedStateRegistryOwner;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Result;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalSavedStateRegistryOwnerKt {
    public static final ProvidableCompositionLocal LocalSavedStateRegistryOwner;

    static {
        Object failure;
        try {
            ClassLoader classLoader = SavedStateRegistryOwner.class.getClassLoader();
            classLoader.getClass();
            Method method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalSavedStateRegistryOwner", null);
            Annotation[] annotations = method.getAnnotations();
            annotations.getClass();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    Object objInvoke = method.invoke(null, null);
                    if (objInvoke instanceof ProvidableCompositionLocal) {
                        failure = (ProvidableCompositionLocal) objInvoke;
                        break;
                    }
                } else if (!(annotations[i] instanceof Deprecated)) {
                    i++;
                }
                failure = null;
                break;
            }
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        ProvidableCompositionLocal staticProvidableCompositionLocal = (ProvidableCompositionLocal) (failure instanceof Result.Failure ? null : failure);
        if (staticProvidableCompositionLocal == null) {
            staticProvidableCompositionLocal = new StaticProvidableCompositionLocal(new UtilsKt$$ExternalSyntheticLambda0((byte) 15), (byte) 0);
        }
        LocalSavedStateRegistryOwner = staticProvidableCompositionLocal;
    }
}
