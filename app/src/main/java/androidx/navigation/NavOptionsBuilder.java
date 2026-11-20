package androidx.navigation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavOptionsBuilder {
    public final NavOptions.Builder builder;
    public boolean inclusive;
    public boolean launchSingleTop;
    public int popUpToId;
    public String popUpToRoute;
    public boolean restoreState;
    public boolean saveState;

    public NavOptionsBuilder() {
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.enterAnim = -1;
        builder.exitAnim = -1;
        this.builder = builder;
        this.popUpToId = -1;
    }
}
