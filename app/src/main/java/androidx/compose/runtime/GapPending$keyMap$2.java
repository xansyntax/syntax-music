package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectListKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GapPending$keyMap$2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ GapPending$keyMap$2(byte b, Object obj) {
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [androidx.collection.MutableObjectList] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.runtime.composer.gapbuffer.KeyInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.collection.MutableObjectList] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Object obj = this.this$0;
        switch (b) {
            case 0:
                ArrayList arrayList = ((GapPending) obj).keyInfos;
                MutableScatterMap mutableScatterMap = new MutableScatterMap(arrayList.size());
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ?? r5 = (KeyInfo) arrayList.get(i);
                    Object obj2 = r5.objectKey;
                    int i2 = r5.key;
                    Object joinedKey = obj2 != null ? new JoinedKey(Integer.valueOf(i2), r5.objectKey) : Integer.valueOf(i2);
                    int iFindInsertIndex = mutableScatterMap.findInsertIndex(joinedKey);
                    boolean z = iFindInsertIndex < 0;
                    Object obj3 = z ? null : mutableScatterMap.values[iFindInsertIndex];
                    if (obj3 != null) {
                        if (obj3 instanceof MutableObjectList) {
                            ?? r9 = (MutableObjectList) obj3;
                            r9.add(r5);
                            r5 = r9;
                        } else {
                            Object[] objArr = ObjectListKt.EmptyArray;
                            ?? mutableObjectList = new MutableObjectList(2);
                            mutableObjectList.add(obj3);
                            mutableObjectList.add(r5);
                            r5 = mutableObjectList;
                        }
                    }
                    if (z) {
                        int i3 = ~iFindInsertIndex;
                        mutableScatterMap.keys[i3] = joinedKey;
                        mutableScatterMap.values[i3] = r5;
                    } else {
                        mutableScatterMap.values[iFindInsertIndex] = r5;
                    }
                }
                return new MultiValueMap(mutableScatterMap);
            case 1:
                AndroidCompositionLocals_androidKt.noLocalProvidedFor((String) obj);
                throw null;
            default:
                CompositionLocalsKt.noLocalProvidedFor((String) obj);
                throw null;
        }
    }
}
