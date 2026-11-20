package androidx.compose.material3;

import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavDeepLinkRequest;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppBarKt$$ExternalSyntheticLambda5 implements FloatProducer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppBarKt$$ExternalSyntheticLambda5(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // androidx.compose.material3.internal.FloatProducer
    public final float invoke() {
        TopAppBarState topAppBarState;
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                NavDeepLinkRequest navDeepLinkRequest = (NavDeepLinkRequest) obj;
                return (navDeepLinkRequest == null || (topAppBarState = (TopAppBarState) navDeepLinkRequest.uri) == null) ? CropImageView.DEFAULT_ASPECT_RATIO : topAppBarState._heightOffset.getFloatValue();
            case 1:
                if (Dp.m795compareTo0680j_4(((Dp) ((State) obj).getValue()).value, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
                    return 1.0f;
                }
                return CropImageView.DEFAULT_ASPECT_RATIO;
            default:
                return ((Number) ((PullToRefreshStateImpl) obj).anim.getValue()).floatValue();
        }
    }
}
