package androidx.compose.ui.window;

import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PopupLayout$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PopupLayout f$0;

    public /* synthetic */ PopupLayout$$ExternalSyntheticLambda3(PopupLayout popupLayout, byte b) {
        this.$r8$classId = b;
        this.f$0 = popupLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PopupLayout popupLayout = this.f$0;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) obj;
                Handler handler = popupLayout.getHandler();
                if ((handler != null ? handler.getLooper() : null) != Looper.myLooper()) {
                    Handler handler2 = popupLayout.getHandler();
                    if (handler2 != null) {
                        handler2.post(new PopupLayout$$ExternalSyntheticLambda5(function0, (byte) 0));
                    }
                } else {
                    function0.invoke();
                }
                break;
            case 1:
                LayoutCoordinates parentLayoutCoordinates = ((LayoutCoordinates) obj).getParentLayoutCoordinates();
                parentLayoutCoordinates.getClass();
                popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                break;
            default:
                popupLayout.m826setPopupContentSizefhxjrPA((IntSize) obj);
                popupLayout.updatePosition();
                break;
        }
        return unit;
    }
}
