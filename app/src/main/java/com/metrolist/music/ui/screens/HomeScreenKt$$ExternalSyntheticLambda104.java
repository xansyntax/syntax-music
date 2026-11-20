package com.metrolist.music.ui.screens;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda104 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ HomeSection.HomePageSection f$0;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda104(HomeSection.HomePageSection homePageSection, byte b) {
        this.$r8$classId = b;
        this.f$0 = homePageSection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        HomeSection.HomePageSection homePageSection = this.f$0;
        switch (b) {
            case 0:
                YTItem yTItem = (YTItem) obj;
                yTItem.getClass();
                return "home_section_" + homePageSection.index + "_item_" + yTItem.getId();
            default:
                SongItem songItem = (SongItem) obj;
                songItem.getClass();
                return "home_section_" + homePageSection.index + "_song_" + songItem.id;
        }
    }
}
