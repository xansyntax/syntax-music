package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AndroidTextContextMenuToolbarProvider f$0;
    public final /* synthetic */ TextContextMenuDataProvider f$1;

    public /* synthetic */ AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, TextContextMenuDataProvider textContextMenuDataProvider, byte b) {
        this.$r8$classId = b;
        this.f$0 = androidTextContextMenuToolbarProvider;
        this.f$1 = textContextMenuDataProvider;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        byte b2 = 12;
        TextContextMenuDataProvider textContextMenuDataProvider = this.f$1;
        AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = this.f$0;
        switch (b) {
            case 0:
                AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 = androidTextContextMenuToolbarProvider.onDataChange;
                SliderState$$ExternalSyntheticLambda0 sliderState$$ExternalSyntheticLambda0 = new SliderState$$ExternalSyntheticLambda0((byte) 16, textContextMenuDataProvider);
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                androidTextContextMenuToolbarProvider.snapshotStateObserver.observeReads("dataBuilder", androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0, new Recomposer$$ExternalSyntheticLambda6(ref$ObjectRef, sliderState$$ExternalSyntheticLambda0, b2));
                Object obj = ref$ObjectRef.element;
                if (obj != null) {
                    return (TextContextMenuData) obj;
                }
                Intrinsics.throwUninitializedPropertyAccessException("result");
                throw null;
            case 1:
                AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1 = androidTextContextMenuToolbarProvider.onPositionChange;
                AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(androidTextContextMenuToolbarProvider, textContextMenuDataProvider, (byte) 2);
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                androidTextContextMenuToolbarProvider.snapshotStateObserver.observeReads("positioner", androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1, new Recomposer$$ExternalSyntheticLambda6(ref$ObjectRef2, androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3, b2));
                Object obj2 = ref$ObjectRef2.element;
                if (obj2 != null) {
                    return (Rect) obj2;
                }
                Intrinsics.throwUninitializedPropertyAccessException("result");
                throw null;
            default:
                Object objInvoke = androidTextContextMenuToolbarProvider.coordinatesProvider.invoke();
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) (((LayoutCoordinates) objInvoke).isAttached$1() ? objInvoke : null);
                return layoutCoordinates == null ? Rect.Zero : textContextMenuDataProvider.contentBounds(layoutCoordinates).m446translatek4lQ0M(layoutCoordinates.mo606localToRootMKHz9U(0L));
        }
    }
}
