package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda97 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ ListenTogetherManager f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda97(MutableState mutableState, MutableState mutableState2, ListenTogetherManager listenTogetherManager, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$2 = mutableState2;
        this.f$1 = listenTogetherManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String str;
        String str2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        ListenTogetherManager listenTogetherManager = this.f$1;
        MutableState mutableState2 = this.f$0;
        switch (b) {
            case 0:
                String str3 = (String) mutableState2.getValue();
                if (str3 != null) {
                    listenTogetherManager.kickUser(str3, "Removed by host");
                }
                mutableState2.setValue(null);
                mutableState.setValue(null);
                break;
            case 1:
                String str4 = (String) mutableState2.getValue();
                if (str4 != null) {
                    listenTogetherManager.transferHost(str4);
                }
                mutableState2.setValue(null);
                mutableState.setValue(null);
                break;
            case 2:
                String str5 = (String) mutableState2.getValue();
                if (str5 != null && (str = (String) mutableState.getValue()) != null) {
                    listenTogetherManager.blockUser(str);
                    listenTogetherManager.kickUser(str5, String.valueOf(R.string.user_blocked_by_host));
                }
                mutableState2.setValue(null);
                mutableState.setValue(null);
                break;
            case 3:
                String str6 = (String) mutableState2.getValue();
                if (str6 != null) {
                    listenTogetherManager.kickUser(str6, "Removed by host");
                }
                mutableState2.setValue(null);
                mutableState.setValue(null);
                break;
            case 4:
                String str7 = (String) mutableState2.getValue();
                if (str7 != null && (str2 = (String) mutableState.getValue()) != null) {
                    listenTogetherManager.blockUser(str2);
                    listenTogetherManager.kickUser(str7, String.valueOf(R.string.user_blocked_by_host));
                }
                mutableState2.setValue(null);
                mutableState.setValue(null);
                break;
            default:
                String str8 = (String) mutableState2.getValue();
                if (str8 != null) {
                    listenTogetherManager.transferHost(str8);
                }
                mutableState2.setValue(null);
                mutableState.setValue(null);
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda97(MutableState mutableState, ListenTogetherManager listenTogetherManager, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = listenTogetherManager;
        this.f$2 = mutableState2;
    }
}
