package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Function;
import kotlin.Result;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassValueCache implements SerializerCache, ParametrizedSerializerCache {
    public final ClassValueReferences classValue = new ClassValueReferences();
    public final Function compute;

    public ClassValueCache(Function1 function1) {
        this.compute = function1;
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer get(KClass kClass) {
        Object obj = this.classValue.get(Okio__OkioKt.getJavaClass(kClass));
        obj.getClass();
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        Object cacheEntry = mutableSoftReference.reference.get();
        if (cacheEntry == null) {
            synchronized (mutableSoftReference) {
                cacheEntry = mutableSoftReference.reference.get();
                if (cacheEntry == null) {
                    cacheEntry = new CacheEntry((KSerializer) ((Function1) this.compute).invoke(kClass));
                    mutableSoftReference.reference = new SoftReference(cacheEntry);
                }
            }
        }
        return ((CacheEntry) cacheEntry).serializer;
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* JADX INFO: renamed from: get-gIAlu-s */
    public Object mo843getgIAlus(KClass kClass, ArrayList arrayList) {
        Object failure;
        Object obj = this.classValue.get(Okio__OkioKt.getJavaClass(kClass));
        obj.getClass();
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        Object parametrizedCacheEntry = mutableSoftReference.reference.get();
        if (parametrizedCacheEntry == null) {
            synchronized (mutableSoftReference) {
                parametrizedCacheEntry = mutableSoftReference.reference.get();
                if (parametrizedCacheEntry == null) {
                    parametrizedCacheEntry = new ParametrizedCacheEntry();
                    mutableSoftReference.reference = new SoftReference(parametrizedCacheEntry);
                }
            }
        }
        ParametrizedCacheEntry parametrizedCacheEntry2 = (ParametrizedCacheEntry) parametrizedCacheEntry;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(new KTypeWrapper((KType) obj2));
        }
        ConcurrentHashMap concurrentHashMap = parametrizedCacheEntry2.serializers;
        Object obj3 = concurrentHashMap.get(arrayList2);
        if (obj3 == null) {
            try {
                failure = (KSerializer) ((Function2) this.compute).invoke(kClass, arrayList);
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            Result result = new Result(failure);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList2, result);
            obj3 = objPutIfAbsent == null ? result : objPutIfAbsent;
        }
        return ((Result) obj3).value;
    }

    public ClassValueCache(Function2 function2) {
        this.compute = function2;
    }
}
