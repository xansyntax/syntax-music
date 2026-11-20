package androidx.compose.ui.window;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogWrapper$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DialogWrapper f$0;

    public /* synthetic */ DialogWrapper$$ExternalSyntheticLambda0(DialogWrapper dialogWrapper, byte b) {
        this.$r8$classId = b;
        this.f$0 = dialogWrapper;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        DialogWrapper dialogWrapper = this.f$0;
        switch (b) {
            case 0:
                if (dialogWrapper.properties.dismissOnBackPress) {
                    dialogWrapper.onDismissRequest.invoke();
                }
                return Unit.INSTANCE;
            default:
                dialogWrapper.show();
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1((byte) 14, dialogWrapper);
        }
    }
}
