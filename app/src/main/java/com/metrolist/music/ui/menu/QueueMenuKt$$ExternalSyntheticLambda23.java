package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import androidx.navigation.NavHostController;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.BottomSheetState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda23 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaMetadata f$0;
    public final /* synthetic */ NavHostController f$1;
    public final /* synthetic */ BottomSheetState f$2;
    public final /* synthetic */ Function0 f$3;
    public final /* synthetic */ MutableState f$4;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda23(MediaMetadata mediaMetadata, NavHostController navHostController, BottomSheetState bottomSheetState, Function0 function0, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaMetadata;
        this.f$1 = navHostController;
        this.f$2 = bottomSheetState;
        this.f$3 = function0;
        this.f$4 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$4;
        Function0 function0 = this.f$3;
        BottomSheetState bottomSheetState = this.f$2;
        NavHostController navHostController = this.f$1;
        MediaMetadata mediaMetadata = this.f$0;
        switch (b) {
            case 0:
                List list = mediaMetadata.artists;
                if (list.size() != 1) {
                    mutableState.setValue(Boolean.TRUE);
                } else {
                    NavHostController.navigate$default(navHostController, "artist/" + ((MediaMetadata.Artist) list.get(0)).id);
                    bottomSheetState.collapseSoft();
                    function0.invoke();
                }
                break;
            default:
                List list2 = mediaMetadata.artists;
                if (list2.size() != 1) {
                    mutableState.setValue(Boolean.TRUE);
                } else {
                    NavHostController.navigate$default(navHostController, "artist/" + ((MediaMetadata.Artist) list2.get(0)).id);
                    bottomSheetState.collapseSoft();
                    function0.invoke();
                }
                break;
        }
        return unit;
    }
}
