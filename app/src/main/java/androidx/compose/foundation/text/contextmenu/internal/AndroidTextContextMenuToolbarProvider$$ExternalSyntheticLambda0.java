package androidx.compose.foundation.text.contextmenu.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import androidx.compose.ui.window.PopupLayout$$ExternalSyntheticLambda5;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AndroidTextContextMenuToolbarProvider f$0;

    public /* synthetic */ AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, byte b) {
        this.$r8$classId = b;
        this.f$0 = androidTextContextMenuToolbarProvider;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = this.f$0;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) obj;
                View view = androidTextContextMenuToolbarProvider.view;
                Handler handler = view.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    function0.invoke();
                } else {
                    Handler handler2 = view.getHandler();
                    if (handler2 != null) {
                        handler2.post(new PopupLayout$$ExternalSyntheticLambda5(function0, (byte) 1));
                    }
                }
                return unit;
            case 1:
                ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
                if (actionMode != null) {
                    actionMode.invalidate();
                }
                return unit;
            case 2:
                ActionMode actionMode2 = androidTextContextMenuToolbarProvider.actionMode;
                if (actionMode2 != null) {
                    actionMode2.invalidateContentRect();
                }
                return unit;
            default:
                androidTextContextMenuToolbarProvider.snapshotStateObserver.start();
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1((byte) 9, androidTextContextMenuToolbarProvider);
        }
    }
}
