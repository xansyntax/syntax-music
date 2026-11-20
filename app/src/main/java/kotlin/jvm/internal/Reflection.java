package kotlin.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Reflection {
    public static final KClass[] EMPTY_K_CLASS_ARRAY;
    public static final ReflectionFactory factory;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        factory = reflectionFactory;
        EMPTY_K_CLASS_ARRAY = new KClass[0];
    }

    public static ClassReference getOrCreateKotlinClass(Class cls) {
        factory.getClass();
        return new ClassReference(cls);
    }

    public static TypeReference nullableTypeOf(Class cls) {
        ClassReference orCreateKotlinClass = getOrCreateKotlinClass(cls);
        List list = Collections.EMPTY_LIST;
        factory.getClass();
        list.getClass();
        return new TypeReference(orCreateKotlinClass, list, 1);
    }

    public static TypeReference typeOf(Class cls, KTypeProjection kTypeProjection) {
        ClassReference orCreateKotlinClass = getOrCreateKotlinClass(cls);
        List listSingletonList = Collections.singletonList(kTypeProjection);
        factory.getClass();
        listSingletonList.getClass();
        return new TypeReference(orCreateKotlinClass, listSingletonList, 0);
    }

    public static TypeReference typeOf(Class cls) {
        ClassReference orCreateKotlinClass = getOrCreateKotlinClass(cls);
        List list = Collections.EMPTY_LIST;
        factory.getClass();
        list.getClass();
        return new TypeReference(orCreateKotlinClass, list, 0);
    }

    public static TypeReference typeOf(Class cls, KTypeProjection... kTypeProjectionArr) {
        ClassReference orCreateKotlinClass = getOrCreateKotlinClass(cls);
        List list = ArraysKt.toList(kTypeProjectionArr);
        factory.getClass();
        return new TypeReference(orCreateKotlinClass, list, 0);
    }
}
