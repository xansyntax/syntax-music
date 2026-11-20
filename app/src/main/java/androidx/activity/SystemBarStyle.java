package androidx.activity;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle {
    public final int darkScrim;
    public final Function1 detectDarkMode;
    public final int lightScrim;
    public final byte nightMode;

    /* JADX WARN: Multi-variable type inference failed */
    public SystemBarStyle(int i, int i2, int i3, Function1 function1) {
        this.lightScrim = i;
        this.darkScrim = i2;
        this.nightMode = i3;
        this.detectDarkMode = function1;
    }

    public final int getScrimWithEnforcedContrast$activity(boolean z) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z ? this.darkScrim : this.lightScrim;
    }
}
