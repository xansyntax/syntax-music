package io.ktor.http;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Url$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;

    public /* synthetic */ Url$$ExternalSyntheticLambda0(List list, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        List list = this.f$0;
        switch (b) {
            case 0:
                return Url.segments_delegate$lambda$0(list);
            case 1:
                Object obj = list.get(2);
                obj.getClass();
                return (Integer) obj;
            case 2:
                Object obj2 = list.get(2);
                obj2.getClass();
                return (Integer) obj2;
            case 3:
                Object obj3 = list.get(2);
                obj3.getClass();
                return (Integer) obj3;
            case 4:
                return Integer.valueOf(list.size());
            case 5:
                return ((KType) list.get(0)).getClassifier();
            case 6:
                return ((KType) list.get(0)).getClassifier();
            default:
                return list;
        }
    }
}
