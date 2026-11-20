package androidx.lifecycle;

import android.app.Application;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SavedStateViewModelFactory_androidKt {
    public static final List ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt__IterablesKt.listOf((Object[]) new Class[]{Application.class, SavedStateHandle.class});
    public static final List VIEWMODEL_SIGNATURE = CollectionsKt__IterablesKt.listOf(SavedStateHandle.class);

    public static final Constructor findMatchingConstructor(Class cls, List list) {
        list.getClass();
        Constructor<?>[] constructors = cls.getConstructors();
        constructors.getClass();
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            parameterTypes.getClass();
            List list2 = ArraysKt.toList(parameterTypes);
            if (list.equals(list2)) {
                return constructor;
            }
            if (list.size() == list2.size() && list2.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final ViewModel newInstance(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Failed to access ", (Object) cls, (Throwable) e);
            return null;
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            PathKt$$ExternalSyntheticBUOutline0.m("An exception happened in constructor of " + cls, e3.getCause());
            return null;
        }
    }
}
