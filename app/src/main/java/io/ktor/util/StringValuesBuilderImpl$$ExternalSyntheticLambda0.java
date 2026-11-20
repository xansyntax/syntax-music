package io.ktor.util;

import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StringValuesBuilderImpl$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ StringValuesBuilderImpl f$0;

    public /* synthetic */ StringValuesBuilderImpl$$ExternalSyntheticLambda0(StringValuesBuilderImpl stringValuesBuilderImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = stringValuesBuilderImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        StringValuesBuilderImpl stringValuesBuilderImpl = this.f$0;
        String str = (String) obj;
        List list = (List) obj2;
        switch (b) {
            case 0:
                return StringValuesBuilderImpl.appendMissing$lambda$0(stringValuesBuilderImpl, str, list);
            default:
                return StringValuesBuilderImpl.appendAll$lambda$0(stringValuesBuilderImpl, str, list);
        }
    }
}
