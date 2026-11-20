package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.HitTestResultKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleNodeFactory$create$colorProducer$1 implements ColorProducer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ RippleNodeFactory$create$colorProducer$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    @Override // androidx.compose.ui.graphics.ColorProducer
    /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
    public final long mo314invoke0d7_KjU() {
        byte b = this.$r8$classId;
        Object obj = this.this$0;
        switch (b) {
            case 0:
                return ((RippleNodeFactory) obj).color;
            case 1:
                DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode = (DelegatingThemeAwareRippleNode) obj;
                long j = ((RippleNodeFactory) delegatingThemeAwareRippleNode.color.this$0).color;
                if (j != 16) {
                    return j;
                }
                RippleConfiguration rippleConfiguration = (RippleConfiguration) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.LocalRippleConfiguration);
                if (rippleConfiguration != null) {
                    long j2 = rippleConfiguration.color;
                    if (j2 != 16) {
                        return j2;
                    }
                }
                return ((Color) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, ContentColorKt.LocalContentColor)).value;
            case 2:
                DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode2 = (DelegatingThemeAwareRippleNode) obj;
                return ((MaterialTheme$Values) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode2, MaterialThemeKt._localMaterialTheme)).colorScheme.onSecondary;
            default:
                DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode3 = (DelegatingThemeAwareRippleNode) obj;
                return ((MaterialTheme$Values) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode3, MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
        }
    }
}
