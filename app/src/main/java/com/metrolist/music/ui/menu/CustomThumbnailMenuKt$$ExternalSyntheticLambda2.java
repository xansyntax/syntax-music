package com.metrolist.music.ui.menu;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemColors;
import androidx.compose.material3.ListItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CustomThumbnailMenuKt$$ExternalSyntheticLambda2 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ CustomThumbnailMenuKt$$ExternalSyntheticLambda2(Function0 function0, Function0 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Function0 function0 = this.f$1;
        Function0 function1 = this.f$0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ListItemColors listItemColorsGlassListItemColors = GlassComponentsKt.glassListItemColors(gapComposer);
                    boolean zChanged = gapComposer.changed(function1) | gapComposer.changed(function0);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new QueueMenuKt$$ExternalSyntheticLambda21(function1, function0, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    ListItemKt.ListItem(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue, 15), false, AlbumMenuKt.f61lambda$117916001, null, null, null, null, listItemColorsGlassListItemColors, null, null, AlbumMenuKt.f208lambda$461985143, gapComposer, 384, 1786);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ListItemColors listItemColorsGlassListItemColors2 = GlassComponentsKt.glassListItemColors(gapComposer2);
                    boolean zChanged2 = gapComposer2.changed(function1) | gapComposer2.changed(function0);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new QueueMenuKt$$ExternalSyntheticLambda21(function1, function0, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    ListItemKt.ListItem(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue2, 15), false, AlbumMenuKt.lambda$499276872, null, null, null, null, listItemColorsGlassListItemColors2, null, null, AlbumMenuKt.lambda$561313202, gapComposer2, 384, 1786);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    CardKt.DropdownMenuItem(EqScreenKt.f359lambda$551780734, this.f$0, null, EqScreenKt.f356lambda$2059267745, null, false, null, null, gapComposer3, 3078, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                    CardKt.DropdownMenuItem(EqScreenKt.f355lambda$1903345877, this.f$1, null, EqScreenKt.lambda$1100582600, null, false, null, null, gapComposer3, 3078, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                }
                break;
        }
        return unit;
    }
}
