package com.metrolist.music.ui.player;

import android.content.Context;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.search.OnlineSearchResultKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt;
import com.metrolist.music.ui.screens.settings.DarkMode;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function4;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposableSingletons$MiniPlayerKt$$ExternalSyntheticLambda0 implements Function4 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ComposableSingletons$MiniPlayerKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Integer) obj4).intValue();
                ((AnimatedContentScopeImpl) obj).getClass();
                if ((iIntValue2 & 48) == 0) {
                    iIntValue2 |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue2 & 1, (iIntValue2 & 145) != 144)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(iIntValue, (iIntValue2 >> 3) & 14, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onPrimary, gapComposer, 440, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                return new PlatformSelectionBehaviorsImpl((CoroutineContext) obj, (Context) obj2, (SelectedTextType) obj3, (LocaleList) obj4);
            case 2:
                ((Integer) obj2).getClass();
                Composer composer2 = (Composer) obj3;
                int iIntValue3 = ((Integer) obj4).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 129) != 128)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AlbumScreenKt.lambda$2129518804, gapComposer2, 24576, 15);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                ((Integer) obj2).getClass();
                Composer composer3 = (Composer) obj3;
                int iIntValue4 = ((Integer) obj4).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 129) != 128)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AlbumScreenKt.lambda$903724149, gapComposer3, 24576, 15);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                ((Integer) obj2).getClass();
                Composer composer4 = (Composer) obj3;
                int iIntValue5 = ((Integer) obj4).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 129) != 128)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AlbumScreenKt.lambda$1858816030, gapComposer4, 24576, 15);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                ((Integer) obj2).getClass();
                Composer composer5 = (Composer) obj3;
                int iIntValue6 = ((Integer) obj4).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue6 & 1, (iIntValue6 & 129) != 128)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AlbumScreenKt.lambda$1184749245, gapComposer5, 24576, 15);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                ((Integer) obj2).getClass();
                Composer composer6 = (Composer) obj3;
                int iIntValue7 = ((Integer) obj4).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue7 & 1, (iIntValue7 & 129) != 128)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AlbumScreenKt.f320lambda$280058768, gapComposer6, 24576, 15);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                ((Integer) obj2).getClass();
                Composer composer7 = (Composer) obj3;
                int iIntValue8 = ((Integer) obj4).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue8 & 1, (iIntValue8 & 129) != 128)) {
                    UuidKt.m1896TextPlaceholderuFdPcIQ(SizeKt.m155width3ABfNKs(companion, 72.0f), 30.0f, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f), gapComposer7, 54, 0);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                ((Integer) obj2).intValue();
                Composer composer8 = (Composer) obj3;
                int iIntValue9 = ((Integer) obj4).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue9 & 1, (iIntValue9 & 129) != 128)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, false, gapComposer8, 0, 7);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj2;
                Composer composer9 = (Composer) obj3;
                Format$$ExternalSyntheticOutline0.m((Integer) obj4, (AnimatedContentScopeImpl) obj, navBackStackEntry);
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.PureBlackKey, Boolean.FALSE, composer9, 48);
                Preferences$Key preferences$Key = PreferenceKeysKt.DarkModeKey;
                GapComposer gapComposer9 = (GapComposer) composer9;
                Context context = (Context) gapComposer9.consume(AndroidCompositionLocals_androidKt.LocalContext);
                Object objRememberedValue = gapComposer9.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer9);
                    gapComposer9.updateRememberedValue(objRememberedValue);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                Object objRememberedValue2 = gapComposer9.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 22));
                    gapComposer9.updateRememberedValue(objRememberedValue2);
                }
                DarkMode darkMode = DarkMode.AUTO;
                MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, darkMode, gapComposer9, 48);
                Object objRememberedValue3 = gapComposer9.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key);
                    gapComposer9.updateRememberedValue(objRememberedValue3);
                }
                ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2 composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2 = (ComposableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2) objRememberedValue3;
                boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer9);
                boolean zChanged = gapComposer9.changed(((DarkMode) composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2.getValue()).ordinal()) | gapComposer9.changed(zIsSystemInDarkTheme);
                Object objRememberedValue4 = gapComposer9.rememberedValue();
                if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                    if (((DarkMode) composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2.getValue()) != darkMode) {
                        zIsSystemInDarkTheme = ((DarkMode) composableSingletons$NavigationBuilderKt$lambda__1906800632$lambda$0$$inlined$rememberEnumPreference$2.getValue()) == DarkMode.ON;
                    }
                    objRememberedValue4 = Boolean.valueOf(zIsSystemInDarkTheme);
                    gapComposer9.updateRememberedValue(objRememberedValue4);
                }
                boolean zBooleanValue = ((Boolean) objRememberedValue4).booleanValue();
                boolean zChanged2 = gapComposer9.changed(((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue()) | gapComposer9.changed(zBooleanValue);
                Object objRememberedValue5 = gapComposer9.rememberedValue();
                if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Boolean.valueOf(((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue() && zBooleanValue);
                    gapComposer9.updateRememberedValue(objRememberedValue5);
                }
                SearchScreenKt.SearchScreen(((Boolean) objRememberedValue5).booleanValue(), navBackStackEntry.getSavedStateHandle(), gapComposer9, 0);
                return unit;
            case 10:
                ((Integer) obj4).intValue();
                ((AnimatedContentScopeImpl) obj).getClass();
                ((NavBackStackEntry) obj2).getClass();
                LibraryScreenKt.LibraryScreen(0, (Composer) obj3);
                return unit;
            case 11:
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
                ((Integer) obj4).getClass();
                ((AnimatedContentScopeImpl) obj).getClass();
                navBackStackEntry2.getClass();
                OnlineSearchResultKt.OnlineSearchResult(null, navBackStackEntry2.getSavedStateHandle(), (Composer) obj3, 0);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Format$$ExternalSyntheticOutline0.m((Integer) obj4, (AnimatedContentScopeImpl) obj, (NavBackStackEntry) obj2);
                EqScreenKt.EqScreen(null, (Composer) obj3, 0);
                return unit;
            case 13:
                ((Integer) obj2).getClass();
                Composer composer10 = (Composer) obj3;
                int iIntValue10 = ((Integer) obj4).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 129) != 128)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AlbumScreenKt.lambda$1159604797, gapComposer10, 24576, 15);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            default:
                ((Integer) obj2).getClass();
                Composer composer11 = (Composer) obj3;
                int iIntValue11 = ((Integer) obj4).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 129) != 128)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AlbumScreenKt.lambda$844127933, gapComposer11, 24576, 15);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
        }
    }
}
