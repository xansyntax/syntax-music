package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HistoryScreenKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ FocusRequester f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ MutableState f$4;

    public /* synthetic */ HistoryScreenKt$$ExternalSyntheticLambda2(List list, FocusRequester focusRequester, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = focusRequester;
        this.f$2 = mutableState;
        this.f$3 = mutableState2;
        this.f$4 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$4;
        MutableState mutableState2 = this.f$3;
        MutableState mutableState3 = this.f$2;
        FocusRequester focusRequester = this.f$1;
        List list = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else if (AlbumScreenKt.HistoryScreen$lambda$4(mutableState2)) {
                    gapComposer.startReplaceGroup(967547109);
                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_selected, list.size(), new Object[]{Integer.valueOf(list.size())}, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    gapComposer.end(false);
                } else if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(969011983);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.history, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(967735868);
                    TextFieldValue textFieldValue = (TextFieldValue) mutableState3.getValue();
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 119);
                    TextFieldColors textFieldColorsM348colors0hiis_0 = TextFieldDefaults.m348colors0hiis_0(0L, 0L, 0L, 0L, gapComposer, 2147469263);
                    Modifier modifierGlass = Modifier.Companion.$$INSTANCE;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifierGlass, 1.0f);
                    if (UiStyleKt.isGlassStyle(gapComposer)) {
                        gapComposer.startReplaceGroup(31253834);
                        modifierGlass = GlassComponentsKt.glass(modifierGlass, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer, 6, 2);
                    } else {
                        gapComposer.startReplaceGroup(31254933);
                    }
                    gapComposer.end(false);
                    Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(modifierFillMaxWidth.then(modifierGlass), focusRequester);
                    boolean zChanged = gapComposer.changed(mutableState3);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new TooltipKt$$ExternalSyntheticLambda5(mutableState3, (byte) 23);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    ScrimKt.TextField(textFieldValue, (Function1) objRememberedValue, modifierFocusRequester, false, textStyle, AlbumScreenKt.lambda$1548272012, null, keyboardOptions, null, true, 0, 0, null, textFieldColorsM348colors0hiis_0, gapComposer, 12582912, 12779520, 4030296);
                    gapComposer.end(false);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else if (TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState3)) {
                    gapComposer2.startReplaceGroup(1011006645);
                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_song, list.size(), new Object[]{Integer.valueOf(list.size())}, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer2, 0, 0, 131070);
                    gapComposer2.end(false);
                } else if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    gapComposer2.startReplaceGroup(1012656186);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cached_playlist, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer2, 0, 0, 131070);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(1011356170);
                    TextFieldValue textFieldValue2 = (TextFieldValue) mutableState.getValue();
                    TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge;
                    KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, 3, 119);
                    TextFieldColors textFieldColorsM348colors0hiis_1 = TextFieldDefaults.m348colors0hiis_0(0L, 0L, 0L, 0L, gapComposer2, 2147469263);
                    Modifier modifierFocusRequester2 = FocusTraversalKt.focusRequester(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), focusRequester);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 7);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    ScrimKt.TextField(textFieldValue2, (Function1) objRememberedValue2, modifierFocusRequester2, false, textStyle2, TopPlaylistScreenKt.f406lambda$901879057, null, keyboardOptions2, null, true, 0, 0, null, textFieldColorsM348colors0hiis_1, gapComposer2, 12582960, 12779520, 4030296);
                    gapComposer2.end(false);
                }
                break;
        }
        return unit;
    }
}
