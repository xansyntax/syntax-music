package com.metrolist.music.ui.screens;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import coil3.compose.AsyncImageKt;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.constants.DimensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda66 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ HomePage.Section f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda66(HomePage.Section section, String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = section;
        this.f$1 = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4;
        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        HomePage.Section section = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    BrowseEndpoint browseEndpoint = section.endpoint;
                    if (browseEndpoint == null || !browseEndpoint.isArtistEndpoint()) {
                        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f);
                    } else {
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.CircleShape;
                    }
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    AsyncImageKt.m849AsyncImage10Xjiaw(this.f$1, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), roundedCornerShapeM185RoundedCornerShape0680j_4), null, gapComposer, 48, 2040);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    BrowseEndpoint browseEndpoint2 = section.endpoint;
                    if (browseEndpoint2 == null || !browseEndpoint2.isArtistEndpoint()) {
                        SpringSpec springSpec3 = DimensionsKt.NavigationBarAnimationSpec;
                        roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f);
                    } else {
                        roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.CircleShape;
                    }
                    SpringSpec springSpec4 = DimensionsKt.NavigationBarAnimationSpec;
                    AsyncImageKt.m849AsyncImage10Xjiaw(this.f$1, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), roundedCornerShapeM185RoundedCornerShape0680j_5), null, gapComposer2, 48, 2040);
                }
                break;
        }
        return unit;
    }
}
