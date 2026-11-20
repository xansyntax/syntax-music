package com.metrolist.music.ui.menu;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.ui.component.MenuKt;
import com.yalantis.ucrop.R;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda37 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda37(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        int i;
        int i2;
        long j;
        byte b = this.$r8$classId;
        int i3 = R.drawable.library_add;
        int i4 = R.string.add_to_library;
        int i5 = R.drawable.favorite_border;
        int i6 = R.drawable.close;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ChipKt$$ExternalSyntheticLambda3((byte) 28);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(companion, false, (Function1) objRememberedValue);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierSemantics);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    ((Function2) mutableState.getValue()).invoke(gapComposer2, 0);
                    gapComposer2.end(true);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SaversKt$$ExternalSyntheticLambda6((byte) 24);
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    AndroidDialog_androidKt.DialogLayout(SemanticsModifierKt.semantics(companion, false, (Function1) objRememberedValue2), (Function2) mutableState.getValue(), gapComposer3, 0);
                }
                break;
            case 3:
                Float f = (Float) obj;
                f.floatValue();
                ((Float) obj2).floatValue();
                mutableState.setValue(f);
                break;
            case 4:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i6 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i6, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer4, 56, 8);
                }
                break;
            case 5:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i6 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i6, 0, gapComposer5), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer5, 56, 8);
                }
                break;
            case 6:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            case 7:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            case 8:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    boolean zChanged = gapComposer8.changed(mutableState);
                    Object objRememberedValue3 = gapComposer8.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 16);
                        gapComposer8.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function1 = (Function1) objRememberedValue3;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(553614845, new SongMenuKt$$ExternalSyntheticLambda37(mutableState, (byte) 10), gapComposer8);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    MenuKt.Switch(zBooleanValue, function1, null, composableLambdaImplRememberComposableLambda, false, ScrimKt.m324colorsV1nXRL4(((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).colorScheme.primary, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).colorScheme.primaryContainer, gapComposer8), gapComposer8, 3072, 84);
                }
                break;
            case 9:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    boolean zBooleanValue2 = ((Boolean) mutableState.getValue()).booleanValue();
                    boolean zChanged2 = gapComposer9.changed(mutableState);
                    Object objRememberedValue4 = gapComposer9.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 17);
                        gapComposer9.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function2 = (Function1) objRememberedValue4;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-2049209100, new SongMenuKt$$ExternalSyntheticLambda37(mutableState, (byte) 12), gapComposer9);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    MenuKt.Switch(zBooleanValue2, function2, null, composableLambdaImplRememberComposableLambda2, false, ScrimKt.m324colorsV1nXRL4(((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimary, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal2)).colorScheme.primary, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal2)).colorScheme.primaryContainer, gapComposer9), gapComposer9, 3072, 84);
                }
                break;
            case 10:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(1 & iIntValue10, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i6 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i6, 0, gapComposer10), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer10, 56, 8);
                }
                break;
            case 11:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(1 & iIntValue11, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i6 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i6, 0, gapComposer11), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer11, 56, 8);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(1 & iIntValue12, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i6 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i6, 0, gapComposer12), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer12, 56, 8);
                }
                break;
            case 13:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(1 & iIntValue13, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else if (!StringsKt.isBlank((String) mutableState.getValue())) {
                    gapComposer13.startReplaceGroup(1142294925);
                    boolean zChanged3 = gapComposer13.changed(mutableState);
                    Object objRememberedValue5 = gapComposer13.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 26);
                        gapComposer13.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.IconButton((Function0) objRememberedValue5, null, false, null, null, AlbumMenuKt.lambda$1318392842, gapComposer13, 1572864, 62);
                    gapComposer13.end(false);
                } else {
                    gapComposer13.startReplaceGroup(1142527487);
                    gapComposer13.end(false);
                }
                break;
            case 14:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    String str = ((String) mutableState.getValue()).length() + "/8";
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal3)).typography.labelSmall, gapComposer14, 0, 0, 131066);
                }
                break;
            case 15:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            case 16:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            case 17:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(1 & iIntValue17, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i = -338271869;
                        i2 = R.string.deleting;
                    } else {
                        i = -338185162;
                        i2 = R.string.delete_uploaded_songs;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer17, i, i2, gapComposer17, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
                }
                break;
            case 18:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(1 & iIntValue18, (iIntValue18 & 3) != 2)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i5 = R.drawable.favorite;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer18), (String) null, (Modifier) null, 0L, gapComposer18, 56, 12);
                }
                break;
            case 19:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(1 & iIntValue19, (iIntValue19 & 3) != 2)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i3 = R.drawable.library_add_check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer19), (String) null, (Modifier) null, 0L, gapComposer19, 56, 12);
                }
                break;
            case 20:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i4 = R.string.remove_from_library;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                }
                break;
            case 21:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(1 & iIntValue21, (iIntValue21 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i5 = R.drawable.favorite;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer21), (String) null, (Modifier) null, 0L, gapComposer21, 56, 12);
                }
                break;
            case 22:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(((Boolean) mutableState.getValue()).booleanValue() ? R.string.dislike_all : R.string.like_all, gapComposer22), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer22, 0, 0, 262142);
                }
                break;
            case 23:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            case 24:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(1 & iIntValue24, (iIntValue24 & 3) != 2)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState.getValue();
                    if ((albumWithSongs != null ? albumWithSongs.album.bookmarkedAt : null) != null) {
                        i5 = R.drawable.favorite;
                    }
                    Painter painterPainterResource = IntMath.painterResource(i5, 0, gapComposer24);
                    AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState.getValue();
                    if ((albumWithSongs2 != null ? albumWithSongs2.album.bookmarkedAt : null) != null) {
                        gapComposer24.startReplaceGroup(618862958);
                        j = ((MaterialTheme$Values) gapComposer24.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                    } else {
                        gapComposer24.startReplaceGroup(618863888);
                        j = ((Color) gapComposer24.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    gapComposer24.end(false);
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, (Modifier) null, j, gapComposer24, 56, 4);
                }
                break;
            case 25:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(1 & iIntValue25, (iIntValue25 & 3) != 2)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i5 = R.drawable.favorite;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer25), (String) null, (Modifier) null, 0L, gapComposer25, 56, 12);
                }
                break;
            case 26:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(((Boolean) mutableState.getValue()).booleanValue() ? R.string.dislike_all : R.string.like_all, gapComposer26), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                }
                break;
            case 27:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(1 & iIntValue27, (iIntValue27 & 3) != 2)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i3 = R.drawable.library_add_check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer27), (String) null, (Modifier) null, 0L, gapComposer27, 56, 12);
                }
                break;
            case 28:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 3) != 2)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i4 = R.string.remove_from_library;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer28), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                }
                break;
            default:
                Composer composer29 = (Composer) obj;
                int iIntValue29 = ((Integer) obj2).intValue();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 3) != 2)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
        }
        return unit;
    }
}
