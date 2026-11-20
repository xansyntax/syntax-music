package androidx.compose.ui.viewinterop;

import android.view.MotionEvent;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidViewsHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidViewHolder$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ViewFactoryHolder f$0;

    public /* synthetic */ AndroidViewHolder$$ExternalSyntheticLambda4(ViewFactoryHolder viewFactoryHolder, byte b) {
        this.$r8$classId = b;
        this.f$0 = viewFactoryHolder;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AndroidViewsHandler androidViewsHandler;
        boolean zDispatchTouchEvent;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ViewFactoryHolder viewFactoryHolder = this.f$0;
        switch (b) {
            case 0:
                Owner owner = (Owner) obj;
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null && (androidViewsHandler = androidComposeView._androidViewsHandler) != null) {
                    androidViewsHandler.removeViewInLayout(viewFactoryHolder);
                    TypeIntrinsics.asMutableMap(androidViewsHandler.getLayoutNodeToHolder()).remove(androidViewsHandler.getHolderToLayoutNode().remove(viewFactoryHolder));
                    viewFactoryHolder.setImportantForAccessibility(0);
                }
                viewFactoryHolder.removeAllViewsInLayout();
                return unit;
            case 1:
                MotionEvent motionEvent = (MotionEvent) obj;
                switch (motionEvent.getActionMasked()) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        zDispatchTouchEvent = viewFactoryHolder.dispatchTouchEvent(motionEvent);
                        break;
                    default:
                        zDispatchTouchEvent = viewFactoryHolder.dispatchGenericMotionEvent(motionEvent);
                        break;
                }
                return Boolean.valueOf(zDispatchTouchEvent);
            default:
                viewFactoryHolder.bringIntoViewRequester = (Function1) obj;
                return unit;
        }
    }
}
