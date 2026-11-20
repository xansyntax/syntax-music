package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.emoji2.text.EmojiProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    public final Function1 canBeSaved;
    public final MutableScatterMap restored;
    public MutableScatterMap valueProviders;

    public SaveableStateRegistryImpl(Map map, Function1 function1) {
        MutableScatterMap mutableScatterMap;
        this.canBeSaved = function1;
        if (map == null || map.isEmpty()) {
            mutableScatterMap = null;
        } else {
            mutableScatterMap = new MutableScatterMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                mutableScatterMap.set(entry.getKey(), entry.getValue());
            }
        }
        this.restored = mutableScatterMap;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object obj) {
        return ((Boolean) this.canBeSaved.invoke(obj)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String str) {
        MutableScatterMap mutableScatterMap = this.restored;
        List list = mutableScatterMap != null ? (List) mutableScatterMap.remove(str) : null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1 && mutableScatterMap != null) {
            List listSubList = list.subList(1, list.size());
            int iFindInsertIndex = mutableScatterMap.findInsertIndex(str);
            if (iFindInsertIndex < 0) {
                iFindInsertIndex = ~iFindInsertIndex;
            }
            Object[] objArr = mutableScatterMap.values;
            Object obj = objArr[iFindInsertIndex];
            mutableScatterMap.keys[iFindInsertIndex] = str;
            objArr[iFindInsertIndex] = listSubList;
        }
        return list.get(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map performSave() {
        long[] jArr;
        long[] jArr2;
        int i;
        MutableScatterMap mutableScatterMap = this.restored;
        if (mutableScatterMap == null && this.valueProviders == null) {
            return EmptyMap.INSTANCE;
        }
        int i2 = 0;
        int i3 = mutableScatterMap != null ? mutableScatterMap._size : 0;
        MutableScatterMap mutableScatterMap2 = this.valueProviders;
        MutableScatterMap mutableScatterMap3 = new MutableScatterMap(i3 + (mutableScatterMap2 != null ? mutableScatterMap2._size : 0));
        if (mutableScatterMap != null) {
            mutableScatterMap3.putAll(mutableScatterMap);
        }
        MutableScatterMap mutableScatterMap4 = this.valueProviders;
        if (mutableScatterMap4 != null) {
            Object[] objArr = mutableScatterMap4.keys;
            Object[] objArr2 = mutableScatterMap4.values;
            long[] jArr3 = mutableScatterMap4.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j = jArr3[i4];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = i2;
                        while (i7 < i6) {
                            if ((255 & j) < 128) {
                                int i8 = (i4 << 3) + i7;
                                Object obj = objArr[i8];
                                List list = (List) objArr2[i8];
                                String str = (String) obj;
                                i = i5;
                                if (list.size() == 1) {
                                    Object objInvoke = ((Function0) list.get(i2)).invoke();
                                    if (objInvoke != null) {
                                        if (!canBeSaved(objInvoke)) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) SaverKt.generateCannotBeSavedErrorMessage(objInvoke));
                                            return null;
                                        }
                                        mutableScatterMap3.set(str, CollectionsKt__IterablesKt.listOf(objInvoke));
                                    }
                                    jArr2 = jArr3;
                                } else {
                                    int size = list.size();
                                    ArrayList arrayList = new ArrayList(size);
                                    while (i2 < size) {
                                        long[] jArr4 = jArr3;
                                        Object objInvoke2 = ((Function0) list.get(i2)).invoke();
                                        if (objInvoke2 != null && !canBeSaved(objInvoke2)) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) SaverKt.generateCannotBeSavedErrorMessage(objInvoke2));
                                            return null;
                                        }
                                        arrayList.add(objInvoke2);
                                        i2++;
                                        jArr3 = jArr4;
                                    }
                                    jArr2 = jArr3;
                                    mutableScatterMap3.set(str, arrayList);
                                }
                            } else {
                                jArr2 = jArr3;
                                i = i5;
                            }
                            j >>= i;
                            i7++;
                            i5 = i;
                            jArr3 = jArr2;
                            i2 = 0;
                        }
                        jArr = jArr3;
                        if (i6 == i5) {
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i4 != length) {
                        i4++;
                        jArr3 = jArr;
                        i2 = 0;
                    }
                }
            }
        }
        return new ScatterMapWrapper(mutableScatterMap3);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final SaveableStateRegistry.Entry registerProvider(String str, Function0 function0) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.isWhitespace(str.charAt(i))) {
                MutableScatterMap mutableScatterMap = this.valueProviders;
                if (mutableScatterMap == null) {
                    long[] jArr = ScatterMapKt.EmptyGroup;
                    mutableScatterMap = new MutableScatterMap();
                    this.valueProviders = mutableScatterMap;
                }
                Object arrayList = mutableScatterMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    mutableScatterMap.set(str, arrayList);
                }
                ((List) arrayList).add(function0);
                return new EmojiProcessor((Object) mutableScatterMap, (Object) str, (Object) function0, (byte) 7);
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Registered key is empty or blank");
        return null;
    }
}
