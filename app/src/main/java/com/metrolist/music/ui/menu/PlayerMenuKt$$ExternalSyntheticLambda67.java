package com.metrolist.music.ui.menu;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.ui.Modifier;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda67 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ ListenTogetherManager f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda67(MutableState mutableState, MutableState mutableState2, ListenTogetherManager listenTogetherManager) {
        this.$r8$classId = (byte) 1;
        this.f$0 = mutableState;
        this.f$2 = mutableState2;
        this.f$1 = listenTogetherManager;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MutableState mutableState = this.f$2;
        ListenTogetherManager listenTogetherManager = this.f$1;
        MutableState mutableState2 = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    boolean zChanged = gapComposer.changed(mutableState2) | gapComposer.changedInstance(listenTogetherManager) | gapComposer.changed(mutableState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new PlayerMenuKt$$ExternalSyntheticLambda97(mutableState2, listenTogetherManager, mutableState, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    SurfaceKt.m337SurfaceT9BRK9s(ImageKt.m46clickableoSLSa3U$default(modifierM137paddingVpY3zN4$default, false, null, (Function0) objRememberedValue, 15), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.errorContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AlbumMenuKt.lambda$1947036230, gapComposer, 12582912, 120);
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
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    boolean zChanged2 = gapComposer2.changed(mutableState2) | gapComposer2.changed(mutableState) | gapComposer2.changedInstance(listenTogetherManager);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new PlayerMenuKt$$ExternalSyntheticLambda97(mutableState2, mutableState, listenTogetherManager, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    SurfaceKt.m337SurfaceT9BRK9s(ImageKt.m46clickableoSLSa3U$default(modifierM137paddingVpY3zN4$default2, false, null, (Function0) objRememberedValue2, 15), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AlbumMenuKt.f264lambda$824168444, gapComposer2, 12582912, 120);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    boolean zChanged3 = gapComposer3.changed(mutableState2) | gapComposer3.changedInstance(listenTogetherManager) | gapComposer3.changed(mutableState);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new PlayerMenuKt$$ExternalSyntheticLambda97(mutableState2, listenTogetherManager, mutableState, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    SurfaceKt.m337SurfaceT9BRK9s(ImageKt.m46clickableoSLSa3U$default(modifierM137paddingVpY3zN4$default3, false, null, (Function0) objRememberedValue3, 15), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primaryContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AlbumMenuKt.lambda$699594178, gapComposer3, 12582912, 120);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda67(MutableState mutableState, ListenTogetherManager listenTogetherManager, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = listenTogetherManager;
        this.f$2 = mutableState2;
    }
}
