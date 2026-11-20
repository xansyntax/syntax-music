package com.metrolist.music;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.PlayerMenuKt;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda49;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt;
import com.metrolist.music.ui.screens.settings.ChangelogScreenKt;
import com.metrolist.music.ui.utils.AppBarKt;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda39 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda39(Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Function0 function0 = this.f$0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    CardKt.TextButton(this.f$0, null, false, null, null, null, ComposableSingletons$MainActivityKt.f10lambda$1051466499, gapComposer, 805306368, 510);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((MediaMetadata) function0.invoke()).title, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                }
                break;
            case 2:
                ((Integer) obj2).getClass();
                PlayerMenuKt.TempoPitchDialog(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 3:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    CardKt.TextButton(this.f$0, null, false, null, null, null, AlbumMenuKt.lambda$861608988, gapComposer3, 805306368, 510);
                }
                break;
            case 4:
                ((Integer) obj2).getClass();
                PlayerMenuKt.TempoPitchDialog(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 5:
                ((Integer) obj2).getClass();
                PlayerMenuKt.SpeedDialog(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 6:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    CardKt.TextButton(this.f$0, null, false, null, null, null, AlbumMenuKt.f126lambda$1730766408, gapComposer4, 805306368, 510);
                }
                break;
            case 7:
                ((Integer) obj2).getClass();
                PlayerMenuKt.SpeedDialog(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 8:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    ComposableLambdaImpl composableLambdaImpl = AlbumScreenKt.lambda$2085214764;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1901479145, new PlayerMenuKt$$ExternalSyntheticLambda49(function0, (byte) 3), gapComposer5);
                    PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                    MenuKt.m1493TopAppBarGHTll3U(composableLambdaImpl, null, null, composableLambdaImplRememberComposableLambda, CropImageView.DEFAULT_ASPECT_RATIO, null, TopAppBarDefaults.m363topAppBarColors5tl4gsc(((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface, 0L, 0L, 0L, 0L, gapComposer5, 62), null, gapComposer5, 3078, 182);
                }
                break;
            case 9:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    CardKt.m258ExtendedFloatingActionButtonElI57k(AlbumScreenKt.f304lambda$1313378575, AlbumScreenKt.f317lambda$1987445360, this.f$0, null, false, null, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).colorScheme.primaryContainer, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).colorScheme.onPrimaryContainer, null, gapComposer6, 54);
                }
                break;
            case 10:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.SettingsLinkCard(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 11:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    CardKt.IconButton(this.f$0, null, false, null, null, EqScreenKt.f354lambda$1687735534, gapComposer7, 1572864, 62);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Integer) obj2).getClass();
                RecognitionScreenKt.ListeningState(function0, (Composer) obj, Stack.updateChangedFlags(7));
                break;
            case 13:
                ((Integer) obj2).getClass();
                RecognitionScreenKt.ReadyState(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 14:
                ((Integer) obj2).getClass();
                ChangelogScreenKt.ChangelogScreen(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                AppBarKt.ShowOffsetDialog(function0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda39(Function0 function0, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
    }
}
