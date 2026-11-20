package com.metrolist.music;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.sqlite.SQLite;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.compose.AsyncImageKt;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.SongWithStats;
import com.metrolist.music.listentogether.ConnectionState;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.lyrics.LyricsUtils;
import com.metrolist.music.models.SimilarRecommendation;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.Icon;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda117;
import com.metrolist.music.ui.player.QueueKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.equalizer.wizard.DeviceModel;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardViewModel;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda66;
import com.metrolist.music.ui.screens.settings.DarkMode;
import com.metrolist.music.ui.theme.ThemeKt;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.AccountViewModel;
import com.metrolist.music.viewmodels.MoodAndGenresViewModel;
import com.metrolist.music.viewmodels.StatsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.URLBuilder;
import io.ktor.sse.ServerSentEventKt;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda1(Function0 function0, MainActivity mainActivity, AvailableUpdate availableUpdate) {
        this.$r8$classId = (byte) 7;
        this.f$1 = function0;
        this.f$0 = mainActivity;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x051a  */
    /* JADX WARN: Code duplicated, block: B:184:0x05ea  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v33 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        ?? r5;
        int i;
        long j;
        boolean z2;
        int i2;
        int i3;
        long j2;
        long j3;
        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4;
        byte b = this.$r8$classId;
        byte b2 = 8;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Object obj3 = Composer.Companion.Empty;
        byte b3 = 2;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj5;
                ComposeView composeView = (ComposeView) obj4;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i4 = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Preferences$Key preferences$Key = PreferenceKeysKt.DarkModeKey;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
                    Context context = (Context) gapComposer.consume(staticProvidableCompositionLocal);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == obj3) {
                        objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == obj3) {
                        objRememberedValue2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 2));
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    DarkMode darkMode = DarkMode.AUTO;
                    MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, darkMode, gapComposer, 48);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (objRememberedValue3 == obj3) {
                        objRememberedValue3 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2 mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2 = (MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2) objRememberedValue3;
                    boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer);
                    if (((DarkMode) mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2.getValue()) == darkMode) {
                        z = zIsSystemInDarkTheme;
                    } else {
                        z = ((DarkMode) mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2.getValue()) == DarkMode.ON;
                    }
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (objRememberedValue4 == obj3) {
                        objRememberedValue4 = Stack.mutableStateOf$default(Boolean.TRUE);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue4;
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        gapComposer.startReplaceGroup(997054545);
                        Preferences$Key preferences$Key2 = PreferenceKeysKt.UiStyleKey;
                        Context context2 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
                        Object objRememberedValue5 = gapComposer.rememberedValue();
                        if (objRememberedValue5 == obj3) {
                            objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer);
                            gapComposer.updateRememberedValue(objRememberedValue5);
                        }
                        CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue5;
                        Object objRememberedValue6 = gapComposer.rememberedValue();
                        if (objRememberedValue6 == obj3) {
                            objRememberedValue6 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context2).getData(), preferences$Key2, (byte) 3));
                            gapComposer.updateRememberedValue(objRememberedValue6);
                        }
                        MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue6, UiStyle.EDITORIAL, gapComposer, 48);
                        Object objRememberedValue7 = gapComposer.rememberedValue();
                        if (objRememberedValue7 == obj3) {
                            objRememberedValue7 = new MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle2, coroutineScope2, context2, preferences$Key2);
                            gapComposer.updateRememberedValue(objRememberedValue7);
                        }
                        ThemeKt.m1515MetrolistThemeT042LqI(z, false, 0L, (UiStyle) ((MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4) objRememberedValue7).getValue(), Expect_jvmKt.rememberComposableLambda(-1175547512, new MainActivity$$ExternalSyntheticLambda9((Object) mainActivity, (Object) composeView, (Object) mutableState, (byte) 0), gapComposer), gapComposer, 24576, 6);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(997649404);
                        gapComposer.end(false);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                AndroidComposeView androidComposeView = (AndroidComposeView) obj5;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.startReplaceGroup(1759209312);
                    CompositionLocalsKt.ProvideCommonCompositionLocals(androidComposeView, composableLambdaImpl, gapComposer2, 0);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                ((Integer) obj2).getClass();
                CompositionLocalsKt.ProvideCommonCompositionLocals((Owner) obj5, (ComposableLambdaImpl) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 3:
                ((Integer) obj2).getClass();
                AndroidDialog_androidKt.DialogLayout((Modifier) obj5, (Function2) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 4:
                ((Integer) obj2).getClass();
                SQLite.PopulateVisibleList((List) obj5, (Collection) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 5:
                ((Integer) obj2).getClass();
                DatabaseDao_Impl.AnonymousClass17.SaveableStateProvider((SaveableStateHolder) obj5, (ComposableLambdaImpl) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 6:
                URLBuilder uRLBuilder = (URLBuilder) obj;
                uRLBuilder.getParameters().append("prettyPrint", "false");
                uRLBuilder.getParameters().append("ver", "2");
                uRLBuilder.getParameters().append("c", ((YouTubeClient) obj5).clientName);
                uRLBuilder.getParameters().remove("cpn");
                uRLBuilder.getParameters().append("cpn", (String) obj4);
                return unit;
            case 7:
                Function0 function0 = (Function0) obj4;
                MainActivity mainActivity2 = (MainActivity) obj5;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                int i5 = MainActivity.$r8$clinit;
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    AvailableUpdate availableUpdate = null;
                    boolean zChanged = gapComposer3.changed(function0) | gapComposer3.changedInstance(mainActivity2) | gapComposer3.changedInstance(null);
                    Object objRememberedValue8 = gapComposer3.rememberedValue();
                    if (zChanged || objRememberedValue8 == obj3) {
                        objRememberedValue8 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(function0, mainActivity2, availableUpdate, b2);
                        gapComposer3.updateRememberedValue(objRememberedValue8);
                    }
                    CardKt.TextButton((Function0) objRememberedValue8, null, false, null, null, null, Expect_jvmKt.rememberComposableLambda(-857014533, new MainActivity$$ExternalSyntheticLambda44(availableUpdate), gapComposer3), gapComposer3, 805306368, 510);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 8:
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                Float f = (Float) obj2;
                f.floatValue();
                pointerInputChange.getClass();
                coil3.util.UtilsKt.m891addPointerInputChange0AR0LA0((VelocityTracker) obj5, pointerInputChange, 0L);
                ((BottomSheetState) obj4).$$delegate_0.onDelta.invoke(f);
                return unit;
            case 9:
                ((Integer) obj2).getClass();
                ((Icon) obj5).Download((Integer) obj4, (Composer) obj, Stack.updateChangedFlags(49));
                return unit;
            case 10:
                ((Integer) obj2).getClass();
                MenuKt.IntegrationCard((String) obj5, (List) obj4, (Composer) obj, Stack.updateChangedFlags(65));
                return unit;
            case 11:
                ((Integer) obj2).getClass();
                MenuKt.OverlayEditButton((Function0) obj5, (BiasAlignment) obj4, (Composer) obj, Stack.updateChangedFlags(3127));
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Integer) obj2).getClass();
                MenuKt.LyricsTranslationHeader((LyricsTranslationHelper.TranslationStatus) obj5, (Modifier) obj4, (Composer) obj, Stack.updateChangedFlags(57));
                return unit;
            case 13:
                ScrollState scrollState = (ScrollState) obj5;
                SongWithStats songWithStats = (SongWithStats) obj4;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    Modifier modifierScroll$default = ImageKt.scroll$default(companion, scrollState, false);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer4, 0);
                    int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, modifierScroll$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(songWithStats.title, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, null, gapComposer4, 0, 24576, 245758);
                    OffsetKt.Spacer(gapComposer4, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    List list = songWithStats.artists;
                    String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer4), ServerSentEventKt.SPACE);
                    Object objRememberedValue9 = gapComposer4.rememberedValue();
                    if (objRememberedValue9 == obj3) {
                        objRememberedValue9 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 21);
                        gapComposer4.updateRememberedValue(objRememberedValue9);
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(list, strM, null, null, (Function1) objRememberedValue9, 30);
                    if (StringsKt.isBlank(strJoinToString$default)) {
                        strJoinToString$default = songWithStats.artistName;
                    }
                    String str = strJoinToString$default;
                    if (str == null) {
                        gapComposer4.startReplaceGroup(-1820290183);
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(-1820290182);
                        TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer4, 0, 24960, 241658);
                        gapComposer4.end(false);
                    }
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 14:
                ((Integer) obj2).getClass();
                MenuKt.TimeTransfer((Function0) obj5, (StatsViewModel) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 15:
                ((Integer) obj2).getClass();
                CollectionsKt__IterablesKt.ListItemPlaceHolder((Modifier) obj5, (Shape) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 16:
                Function0 function1 = (Function0) obj5;
                Context context3 = (Context) obj4;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    LyricsEntity lyricsEntity = (LyricsEntity) function1.invoke();
                    String strJoinToString$default2 = lyricsEntity != null ? lyricsEntity.lyrics : null;
                    if (strJoinToString$default2 == null) {
                        gapComposer5.startReplaceGroup(748233863);
                        gapComposer5.end(false);
                    } else {
                        gapComposer5.startReplaceGroup(748233864);
                        if (StringsKt__StringsJVMKt.startsWith(strJoinToString$default2, "[", false)) {
                            gapComposer5.startReplaceGroup(798052555);
                            LyricsUtils lyricsUtils = LyricsUtils.INSTANCE;
                            List lyrics = LyricsUtils.parseLyrics(strJoinToString$default2);
                            Object objRememberedValue10 = gapComposer5.rememberedValue();
                            if (objRememberedValue10 == obj3) {
                                objRememberedValue10 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 29);
                                gapComposer5.updateRememberedValue(objRememberedValue10);
                            }
                            strJoinToString$default2 = CollectionsKt.joinToString$default(lyrics, "\n", null, null, (Function1) objRememberedValue10, 30);
                            r5 = 0;
                            gapComposer5.end(false);
                        } else {
                            r5 = 0;
                            gapComposer5.startReplaceGroup(798252660);
                            gapComposer5.end(false);
                        }
                        Object systemService = context3.getSystemService("clipboard");
                        systemService.getClass();
                        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Lyrics", strJoinToString$default2));
                        Toast.makeText(context3, R.string.copied_to_clipboard, (int) r5).show();
                        gapComposer5.end(r5);
                    }
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 17:
                State state = (State) obj5;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj4;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer6, 48);
                    int iHashCode2 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer6, 54);
                    int iHashCode3 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer6, companion);
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 10.0f);
                    int iOrdinal = ((ConnectionState) state.getValue()).ordinal();
                    if (iOrdinal == 0) {
                        i = 0;
                        gapComposer6.startReplaceGroup(-2014868933);
                        j = CardKt.getColorScheme(gapComposer6).outline;
                        gapComposer6.end(false);
                    } else if (iOrdinal == 1) {
                        i = 0;
                        gapComposer6.startReplaceGroup(-2014876003);
                        j = CardKt.getColorScheme(gapComposer6).secondary;
                        gapComposer6.end(false);
                    } else if (iOrdinal == 2) {
                        i = 0;
                        gapComposer6.startReplaceGroup(-2014880549);
                        j = CardKt.getColorScheme(gapComposer6).primary;
                        gapComposer6.end(false);
                    } else if (iOrdinal == 3) {
                        i = 0;
                        gapComposer6.startReplaceGroup(-2014876003);
                        j = CardKt.getColorScheme(gapComposer6).secondary;
                        gapComposer6.end(false);
                    } else {
                        if (iOrdinal != 4) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer6, -2014884108, false);
                        }
                        gapComposer6.startReplaceGroup(-2014872519);
                        j = CardKt.getColorScheme(gapComposer6).error;
                        i = 0;
                        gapComposer6.end(false);
                    }
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(modifierM151size3ABfNKs, j, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), gapComposer6, i);
                    OffsetKt.Spacer(gapComposer6, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    int iOrdinal2 = ((ConnectionState) state.getValue()).ordinal();
                    if (iOrdinal2 == 0) {
                        z2 = false;
                        i2 = -2014839703;
                        i3 = R.string.listen_together_disconnected;
                    } else if (iOrdinal2 == 1) {
                        z2 = false;
                        i2 = -2014850905;
                        i3 = R.string.listen_together_connecting;
                    } else if (iOrdinal2 == 2) {
                        z2 = false;
                        i2 = -2014854650;
                        i3 = R.string.listen_together_connected;
                    } else if (iOrdinal2 == 3) {
                        z2 = false;
                        i2 = -2014847063;
                        i3 = R.string.listen_together_reconnecting;
                    } else {
                        if (iOrdinal2 != 4) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer6, -2014856936, false);
                        }
                        i2 = -2014843390;
                        i3 = R.string.listen_together_error;
                        z2 = false;
                    }
                    String strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer6, i2, i3, gapComposer6, z2);
                    TextStyle textStyle = CardKt.getTypography(gapComposer6).titleMedium;
                    FontWeight fontWeight = FontWeight.SemiBold;
                    int iOrdinal3 = ((ConnectionState) state.getValue()).ordinal();
                    if (iOrdinal3 == 0) {
                        gapComposer6.startReplaceGroup(-2014816188);
                        j2 = CardKt.getColorScheme(gapComposer6).onSurfaceVariant;
                        gapComposer6.end(false);
                    } else if (iOrdinal3 == 1) {
                        gapComposer6.startReplaceGroup(-2014822499);
                        j2 = CardKt.getColorScheme(gapComposer6).secondary;
                        gapComposer6.end(false);
                    } else if (iOrdinal3 == 2) {
                        gapComposer6.startReplaceGroup(-2014826661);
                        j2 = CardKt.getColorScheme(gapComposer6).primary;
                        gapComposer6.end(false);
                    } else if (iOrdinal3 == 3) {
                        gapComposer6.startReplaceGroup(-2014822499);
                        j2 = CardKt.getColorScheme(gapComposer6).secondary;
                        gapComposer6.end(false);
                    } else {
                        if (iOrdinal3 != 4) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer6, -2014829887, false);
                        }
                        gapComposer6.startReplaceGroup(-2014819399);
                        j2 = CardKt.getColorScheme(gapComposer6).error;
                        gapComposer6.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strM2, null, j2, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer6, 1572864, 0, 131002);
                    gapComposer6.end(true);
                    if (((ConnectionState) state.getValue()) == ConnectionState.CONNECTING || ((ConnectionState) state.getValue()) == ConnectionState.RECONNECTING) {
                        gapComposer6.startReplaceGroup(1990107111);
                        OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion, 12.0f));
                        ProgressIndicatorKt.m310LinearProgressIndicatorrIrjwxo(CropImageView.DEFAULT_ASPECT_RATIO, 0, 6, 28, CardKt.getColorScheme(gapComposer6).primary, 0L, gapComposer6, SizeKt.fillMaxWidth(companion, 1.0f));
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(1990394450);
                        gapComposer6.end(false);
                    }
                    OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, Alignment.Companion.Top, gapComposer6, 6);
                    int iHashCode4 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierFillMaxWidth);
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    ConnectionState connectionState = (ConnectionState) state.getValue();
                    ConnectionState connectionState2 = ConnectionState.DISCONNECTED;
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if (connectionState == connectionState2 || ((ConnectionState) state.getValue()) == ConnectionState.ERROR) {
                        gapComposer6.startReplaceGroup(124900917);
                        boolean zChangedInstance = gapComposer6.changedInstance(listenTogetherManager);
                        Object objRememberedValue11 = gapComposer6.rememberedValue();
                        if (zChangedInstance || objRememberedValue11 == obj3) {
                            objRememberedValue11 = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager, (byte) 0);
                            gapComposer6.updateRememberedValue(objRememberedValue11);
                        }
                        Modifier modifierWeight = rowScopeInstance.weight(companion, 1.0f, true);
                        PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                        CardKt.Button((Function0) objRememberedValue11, modifierWeight, false, null, ButtonDefaults.m247buttonColorsro_MJ88(CardKt.getColorScheme(gapComposer6).primary, 0L, 0L, gapComposer6, 14), null, null, null, null, AlbumMenuKt.lambda$555959222, gapComposer6, 805306368, 492);
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(125522808);
                        boolean zChangedInstance2 = gapComposer6.changedInstance(listenTogetherManager);
                        Object objRememberedValue12 = gapComposer6.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue12 == obj3) {
                            objRememberedValue12 = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager, b3);
                            gapComposer6.updateRememberedValue(objRememberedValue12);
                        }
                        Modifier modifierWeight2 = rowScopeInstance.weight(companion, 1.0f, true);
                        PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
                        gapComposer6 = gapComposer6;
                        CardKt.Button((Function0) objRememberedValue12, modifierWeight2, false, null, ButtonDefaults.m247buttonColorsro_MJ88(CardKt.getColorScheme(gapComposer6).primary, 0L, 0L, gapComposer6, 14), null, null, null, null, AlbumMenuKt.f218lambda$514781953, gapComposer6, 805306368, 492);
                        boolean zChangedInstance3 = gapComposer6.changedInstance(listenTogetherManager);
                        Object objRememberedValue13 = gapComposer6.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue13 == obj3) {
                            objRememberedValue13 = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager, (byte) 3);
                            gapComposer6.updateRememberedValue(objRememberedValue13);
                        }
                        CardKt.FilledTonalButton((Function0) objRememberedValue13, rowScopeInstance.weight(companion, 1.0f, true), false, null, null, null, null, AlbumMenuKt.lambda$951378785, gapComposer6, 805306368, 508);
                        gapComposer6.end(false);
                    }
                    gapComposer6.end(true);
                    gapComposer6.end(true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 18:
                Listentogether.UserInfo userInfo = (Listentogether.UserInfo) obj5;
                MutableState mutableState2 = (MutableState) obj4;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode5 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer7, fillElement);
                    ComposeUiNode.Companion.getClass();
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    String username = userInfo.getUsername();
                    username.getClass();
                    String upperCase = StringsKt.take(1, username).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal2)).typography.titleLarge;
                    FontWeight fontWeight2 = FontWeight.Bold;
                    if (userInfo.getIsHost()) {
                        gapComposer7.startReplaceGroup(1940153911);
                        j3 = ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimary;
                        gapComposer7.end(false);
                    } else if (Intrinsics.areEqual(userInfo.getUserId(), (String) mutableState2.getValue())) {
                        gapComposer7.startReplaceGroup(1940340469);
                        j3 = ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal2)).colorScheme.onSecondary;
                        gapComposer7.end(false);
                    } else {
                        gapComposer7.startReplaceGroup(1940502320);
                        j3 = ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant;
                        gapComposer7.end(false);
                    }
                    TextKt.m352TextNvy7gAk(upperCase, null, j3, 0L, null, fontWeight2, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer7, 1572864, 0, 131002);
                    gapComposer7.end(true);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 19:
                List list2 = (List) obj5;
                Map map = (Map) obj4;
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                boolean z3 = (iIntValue8 & 3) != 2;
                int i6 = iIntValue8 & 1;
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(i6, z3)) {
                    boolean zChangedInstance4 = gapComposer8.changedInstance(map);
                    Object objRememberedValue14 = gapComposer8.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue14 == obj3) {
                        objRememberedValue14 = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 8);
                        gapComposer8.updateRememberedValue(objRememberedValue14);
                    }
                    TextKt.m352TextNvy7gAk(CollectionsKt.joinToString$default(list2, null, null, null, (Function1) objRememberedValue14, 31), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 20:
                State state2 = (State) obj5;
                State state3 = (State) obj4;
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(((Number) state2.getValue()).intValue() == 1 ? R.drawable.repeat_one : R.drawable.repeat, 0, gapComposer9), (String) null, SizeKt.m151size3ABfNKs(companion, 26.0f), ((Color) state3.getValue()).value, gapComposer9, 440, 0);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 21:
                ((Integer) obj2).getClass();
                QueueKt.SeekEffectOverlay((String) obj5, (Modifier) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 22:
                ((Integer) obj2).getClass();
                AlbumScreenKt.AccountScreen((NavHostController) obj5, (AccountViewModel) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 23:
                SimilarRecommendation similarRecommendation = (SimilarRecommendation) obj5;
                String str2 = (String) obj4;
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    if (similarRecommendation.title instanceof Artist) {
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.CircleShape;
                    } else {
                        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f);
                    }
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    AsyncImageKt.m849AsyncImage10Xjiaw(str2, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), roundedCornerShapeM185RoundedCornerShape0680j_4), null, gapComposer10, 48, 2040);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 24:
                ((Integer) obj2).getClass();
                AlbumScreenKt.MoodAndGenresScreen((NavHostController) obj5, (MoodAndGenresViewModel) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 25:
                String str3 = (String) obj5;
                State state4 = (State) obj4;
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    if (((Boolean) state4.getValue()).booleanValue()) {
                        gapComposer11.startReplaceGroup(-62622517);
                    } else {
                        gapComposer11.startReplaceGroup(275073560);
                        if (str3 == null) {
                            str3 = "";
                        }
                        TextKt.m352TextNvy7gAk(str3, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                    }
                    gapComposer11.end(false);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 26:
                ((Integer) obj2).getClass();
                WizardScreenKt.ModelItem((DeviceModel) obj5, (Function0) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 27:
                ((Integer) obj2).getClass();
                WizardScreenKt.WizardScreen((WizardViewModel) obj5, (Function0) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 28:
                MutableState mutableState3 = (MutableState) obj5;
                Playlist playlist = (Playlist) obj4;
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    String str4 = (String) mutableState3.getValue();
                    if (str4 == null) {
                        str4 = (String) playlist.getThumbnails().get(0);
                    }
                    AsyncImageKt.m849AsyncImage10Xjiaw(str4, SizeKt.FillWholeMaxSize, ContentScale.Companion.Crop, gapComposer12, 1573296, 1976);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            default:
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = (DataStoreKt$rememberPreference$1$1) obj5;
                MutableState mutableState4 = (MutableState) obj4;
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else if (StringsKt.isBlank((String) dataStoreKt$rememberPreference$1$1.$state.getValue())) {
                    gapComposer13.startReplaceGroup(-978690032);
                    gapComposer13.end(false);
                } else {
                    gapComposer13.startReplaceGroup(-979350239);
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                    RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(OffsetKt.End, Alignment.Companion.Top, gapComposer13, 6);
                    int iHashCode6 = Long.hashCode(gapComposer13.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer13.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer13, modifierM139paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer13.startReusableNode();
                    if (gapComposer13.inserting) {
                        gapComposer13.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer13.useNode();
                    }
                    Stack.m390setimpl(gapComposer13, rowMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer13, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer13, Integer.valueOf(iHashCode6), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer13);
                    Stack.m390setimpl(gapComposer13, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    boolean zChanged2 = gapComposer13.changed(dataStoreKt$rememberPreference$1$1) | gapComposer13.changed(mutableState4);
                    Object objRememberedValue15 = gapComposer13.rememberedValue();
                    if (zChanged2 || objRememberedValue15 == obj3) {
                        objRememberedValue15 = new AiSettingsKt$$ExternalSyntheticLambda66(dataStoreKt$rememberPreference$1$1, mutableState4, (byte) 0);
                        gapComposer13.updateRememberedValue(objRememberedValue15);
                    }
                    CardKt.TextButton((Function0) objRememberedValue15, null, false, null, null, null, AiSettingsKt.f499lambda$1729421458, gapComposer13, 805306368, 510);
                    gapComposer13.end(true);
                    gapComposer13.end(false);
                }
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda1(Object obj, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
