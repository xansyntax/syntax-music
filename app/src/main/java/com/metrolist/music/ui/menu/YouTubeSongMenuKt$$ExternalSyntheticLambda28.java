package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.Artist;
import com.metrolist.music.models.MediaMetadata;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeSongMenuKt$$ExternalSyntheticLambda28 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ NavHostController f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ MutableState f$3;

    public /* synthetic */ YouTubeSongMenuKt$$ExternalSyntheticLambda28(List list, NavHostController navHostController, Function0 function0, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = navHostController;
        this.f$2 = function0;
        this.f$3 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$3;
        Function0 function0 = this.f$2;
        NavHostController navHostController = this.f$1;
        List list = this.f$0;
        switch (b) {
            case 0:
                if (list.size() != 1) {
                    mutableState.setValue(Boolean.TRUE);
                } else {
                    NavHostController.navigate$default(navHostController, "artist/" + ((MediaMetadata.Artist) list.get(0)).id);
                    function0.invoke();
                }
                break;
            default:
                if (list.size() != 1) {
                    mutableState.setValue(Boolean.TRUE);
                } else {
                    NavHostController.navigate$default(navHostController, "artist/" + ((Artist) list.get(0)).id);
                    function0.invoke();
                }
                break;
        }
        return unit;
    }
}
