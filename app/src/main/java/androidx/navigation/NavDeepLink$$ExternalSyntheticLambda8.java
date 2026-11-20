package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavDeepLink$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Bundle f$0;

    public /* synthetic */ NavDeepLink$$ExternalSyntheticLambda8(Bundle bundle, byte b) {
        this.$r8$classId = b;
        this.f$0 = bundle;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zContainsKey;
        byte b = this.$r8$classId;
        Bundle bundle = this.f$0;
        String str = (String) obj;
        switch (b) {
            case 0:
                str.getClass();
                zContainsKey = bundle.containsKey(str);
                break;
            default:
                str.getClass();
                zContainsKey = bundle.containsKey(str);
                break;
        }
        return Boolean.valueOf(!zContainsKey);
    }
}
