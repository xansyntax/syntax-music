package androidx.activity;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda0(ComponentActivity componentActivity, byte b) {
        this.$r8$classId = b;
        this.f$0 = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        ComponentActivity componentActivity = this.f$0;
        switch (b) {
            case 0:
                componentActivity.invalidateMenu();
                break;
            default:
                ComponentActivity.onBackPressedDispatcher_delegate$lambda$0$0(componentActivity);
                break;
        }
    }
}
