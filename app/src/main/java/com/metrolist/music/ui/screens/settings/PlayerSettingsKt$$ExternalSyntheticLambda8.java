package com.metrolist.music.ui.screens.settings;

import com.metrolist.music.discord.DiscordRpcManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerSettingsKt$$ExternalSyntheticLambda8 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ PlayerSettingsKt$$ExternalSyntheticLambda8(boolean z, Function1 function1, boolean z2, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function1;
        this.f$2 = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$2;
        Function1 function1 = this.f$1;
        boolean z2 = this.f$0;
        switch (b) {
            case 0:
                if (z2) {
                    function1.invoke(Boolean.valueOf(!z));
                }
                break;
            case 1:
                if (!z2) {
                    function1.invoke(Boolean.valueOf(!z));
                }
                break;
            case 2:
                if (z2) {
                    function1.invoke(Boolean.valueOf(!z));
                }
                break;
            default:
                if (z2) {
                    function1.invoke(Boolean.valueOf(!z));
                    DiscordRpcManager.INSTANCE.notifySettingsChanged();
                }
                break;
        }
        return unit;
    }
}
