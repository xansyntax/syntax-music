package io.ktor.http;

import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CookieKt$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ CookieKt$$ExternalSyntheticLambda3(byte b, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf(CookieKt.clientCookies$lambda$1(z, (Pair) obj));
            case 1:
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                if (!z) {
                    KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                    semanticsPropertyReceiver.set(SemanticsProperties.Disabled, unit);
                }
                return unit;
            default:
                SemanticsPropertiesKt.setSelected((SemanticsPropertyReceiver) obj, z);
                return unit;
        }
    }
}
