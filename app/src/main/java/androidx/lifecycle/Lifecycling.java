package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycling {
    public static final HashMap callbackCache = new HashMap();
    public static final HashMap classToAdapters = new HashMap();

    public static void createGeneratedAdapter(Constructor constructor, LifecycleObserver lifecycleObserver) {
        try {
            constructor.newInstance(lifecycleObserver).getClass();
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:69:0x012a  */
    public static int getObserverConstructorType(Class cls) {
        Constructor<?> declaredConstructor;
        boolean zBooleanValue;
        Class<?>[] interfaces;
        HashMap map = callbackCache;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r5 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r5 != null ? r5.getName() : "";
                name.getClass();
                if (name.length() != 0) {
                    canonicalName.getClass();
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                canonicalName.getClass();
                String strConcat = StringsKt__StringsJVMKt.replace(canonicalName, ".", "_", false).concat("_LifecycleAdapter");
                if (name.length() != 0) {
                    strConcat = name + "." + strConcat;
                }
                declaredConstructor = Class.forName(strConcat).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap map2 = classToAdapters;
            if (declaredConstructor != null) {
                map2.put(cls, CollectionsKt__IterablesKt.listOf(declaredConstructor));
            } else {
                ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
                HashMap map3 = classesInfoCache.mHasLifecycleMethods;
                Boolean bool = (Boolean) map3.get(cls);
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                map3.put(cls, Boolean.FALSE);
                                zBooleanValue = false;
                                break;
                            }
                            if (((OnLifecycleEvent) declaredMethods[i2].getAnnotation(OnLifecycleEvent.class)) != null) {
                                classesInfoCache.createInfo(cls, declaredMethods);
                                zBooleanValue = true;
                                break;
                            }
                            i2++;
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!zBooleanValue) {
                    Class superclass = cls.getSuperclass();
                    if (superclass == null || !LifecycleObserver.class.isAssignableFrom(superclass)) {
                        interfaces = cls.getInterfaces();
                        interfaces.getClass();
                        for (Class<?> cls2 : interfaces) {
                            if (cls2 == null && LifecycleObserver.class.isAssignableFrom(cls2)) {
                                cls2.getClass();
                                if (getObserverConstructorType(cls2) != 1) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    Object obj = map2.get(cls2);
                                    obj.getClass();
                                    arrayList.addAll((Collection) obj);
                                }
                            }
                        }
                        if (arrayList != null) {
                            map2.put(cls, arrayList);
                        }
                    } else {
                        superclass.getClass();
                        if (getObserverConstructorType(superclass) != 1) {
                            Object obj2 = map2.get(superclass);
                            obj2.getClass();
                            arrayList = new ArrayList((Collection) obj2);
                            interfaces = cls.getInterfaces();
                            interfaces.getClass();
                            while (i < r8) {
                                if (cls2 == null) {
                                }
                            }
                            if (arrayList != null) {
                                map2.put(cls, arrayList);
                            }
                        }
                    }
                }
            }
            i = 2;
        }
        map.put(cls, Integer.valueOf(i));
        return i;
    }
}
