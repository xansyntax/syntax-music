package androidx.compose.ui.window;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PopupLayout$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ PopupLayout$$ExternalSyntheticLambda5(Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        Function0 function0 = this.f$0;
        switch (b) {
            case 0:
                function0.invoke();
                break;
            case 1:
                function0.invoke();
                break;
            case 2:
                function0.invoke();
                break;
            case 3:
                function0.invoke();
                break;
            case 4:
                function0.invoke();
                break;
            default:
                function0.invoke();
                break;
        }
    }
}
