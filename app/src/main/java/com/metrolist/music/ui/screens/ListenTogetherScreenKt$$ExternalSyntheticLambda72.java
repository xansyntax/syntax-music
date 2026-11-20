package com.metrolist.music.ui.screens;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import coil3.util.FileSystemsKt;
import com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda16;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenTogetherScreenKt$$ExternalSyntheticLambda72 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ ListenTogetherScreenKt$$ExternalSyntheticLambda72(byte b, Function0 function0, boolean z) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.$r8$classId) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f);
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    CardKt.Button(this.f$0, modifierFillMaxWidth, this.f$1, roundedCornerShapeM185RoundedCornerShape0680j_4, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, 0L, 0L, gapComposer, 14), null, null, null, null, AlbumScreenKt.f302lambda$1257962803, gapComposer, 805306416, 480);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            default:
                Modifier modifier = (Modifier) obj;
                ((Integer) obj3).getClass();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                gapComposer2.startReplaceGroup(-196777734);
                final long j = ((TextSelectionColors) gapComposer2.consume(TextSelectionColorsKt.LocalTextSelectionColors)).handleColor;
                boolean zChanged = gapComposer2.changed(j);
                final Function0 function0 = this.f$0;
                boolean zChanged2 = zChanged | gapComposer2.changed(function0);
                final boolean z = this.f$1;
                boolean zChanged3 = zChanged2 | gapComposer2.changed(z);
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            CacheDrawScope cacheDrawScope = (CacheDrawScope) obj4;
                            return cacheDrawScope.onDrawWithContent(new DialogKt$$ExternalSyntheticLambda16(function0, z, FileSystemsKt.createHandleImage(cacheDrawScope, Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo398getSizeNHjbRc() >> 32)) / 2.0f), new BlendModeColorFilter(j, 5)));
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierDrawWithCache = ClipKt.drawWithCache(modifier, (Function1) objRememberedValue);
                gapComposer2.end(false);
                return modifierDrawWithCache;
        }
    }
}
