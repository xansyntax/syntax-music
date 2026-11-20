package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.music.db.entities.ArtistEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongMenuKt$SongMenu$12$1$3$1$1 implements Function0 {
    public final /* synthetic */ ArtistEntity $artist;
    public final /* synthetic */ NavHostController $navController;
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $showSelectArtistDialog$delegate;

    public SongMenuKt$SongMenu$12$1$3$1$1(Function0 function0, NavHostController navHostController, ArtistEntity artistEntity, MutableState mutableState) {
        this.$r8$classId = (byte) 3;
        this.$onDismiss = function0;
        this.$navController = navHostController;
        this.$artist = artistEntity;
        this.$showSelectArtistDialog$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ArtistEntity artistEntity = this.$artist;
        NavHostController navHostController = this.$navController;
        Function0 function0 = this.$onDismiss;
        MutableState mutableState = this.$showSelectArtistDialog$delegate;
        switch (b) {
            case 0:
                Format$$ExternalSyntheticOutline0.m("artist/", artistEntity.id, navHostController);
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            case 1:
                Format$$ExternalSyntheticOutline0.m("artist/", artistEntity.id, navHostController);
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            case 2:
                Format$$ExternalSyntheticOutline0.m("artist/", artistEntity.id, navHostController);
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            default:
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                Format$$ExternalSyntheticOutline0.m("artist/", artistEntity.id, navHostController);
                break;
        }
        return unit;
    }

    public /* synthetic */ SongMenuKt$SongMenu$12$1$3$1$1(NavHostController navHostController, ArtistEntity artistEntity, Function0 function0, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$navController = navHostController;
        this.$artist = artistEntity;
        this.$onDismiss = function0;
        this.$showSelectArtistDialog$delegate = mutableState;
    }
}
