package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.state.ToggleableState;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.navigation.NavHostController;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.ui.component.Material3SettingsItem;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda28;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RomanizationSettingsKt {
    public static final ArrayList defaultList;

    static {
        Boolean bool = Boolean.TRUE;
        defaultList = CollectionsKt__IterablesKt.mutableListOf(new Pair("Japanese", bool), new Pair("Korean", bool), new Pair("Chinese", bool), new Pair("Hindi", bool), new Pair("Punjabi", bool), new Pair("Russian", bool), new Pair("Ukrainian", bool), new Pair("Serbian", bool), new Pair("Bulgarian", bool), new Pair("Belarusian", bool), new Pair("Kyrgyz", bool), new Pair("Macedonian", bool));
    }

    public static final void RomanizationSettings(NavHostController navHostController, Composer composer, int i) {
        NavHostController navHostController2;
        GapComposer gapComposer;
        Object obj;
        ToggleableState toggleableState;
        navHostController.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(630093574);
        int i2 = i | (gapComposer2.changedInstance(navHostController) ? 4 : 2);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.LyricsRomanizeList, "", gapComposer2, 48);
            String str = (String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            boolean zChanged = gapComposer2.changed(str);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                obj = objRememberedValue;
                int length = str.length();
                ArrayList arrayList = defaultList;
                ArrayList arrayList2 = arrayList;
                if (length != 0) {
                    List listSplit$default = StringsKt.split$default(str, new String[]{","}, 0, 6);
                    int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                    if (iMapCapacity < 16) {
                        iMapCapacity = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
                    Iterator it = listSplit$default.iterator();
                    while (it.hasNext()) {
                        List listSplit$default2 = StringsKt.split$default((String) it.next(), new String[]{ServerSentEventKt.COLON}, 0, 6);
                        linkedHashMap.put((String) listSplit$default2.get(0), Boolean.valueOf(Boolean.parseBoolean((String) listSplit$default2.get(1))));
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        Pair pair = (Pair) obj2;
                        String str2 = (String) pair.first;
                        boolean zBooleanValue = ((Boolean) pair.second).booleanValue();
                        Boolean bool = (Boolean) linkedHashMap.get(str2);
                        if (bool != null) {
                            zBooleanValue = bool.booleanValue();
                        }
                        arrayList3.add(new Pair(str2, Boolean.valueOf(zBooleanValue)));
                    }
                    arrayList2 = arrayList3;
                }
                gapComposer2.updateRememberedValue(arrayList2);
                obj = arrayList2;
            }
            List list = (List) obj;
            boolean zChanged2 = gapComposer2.changed(list);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            Object obj3 = objRememberedValue2;
            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                Pair[] pairArr = (Pair[]) list.toArray(new Pair[0]);
                Object[] objArrCopyOf = Arrays.copyOf(pairArr, pairArr.length);
                SnapshotStateList snapshotStateList = new SnapshotStateList();
                snapshotStateList.addAll(ArraysKt.toList(objArrCopyOf));
                gapComposer2.updateRememberedValue(snapshotStateList);
                obj3 = snapshotStateList;
            }
            SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj3;
            if (snapshotStateList2 != null && snapshotStateList2.isEmpty()) {
                toggleableState = ToggleableState.On;
                break;
            }
            ListIterator listIterator = snapshotStateList2.listIterator();
            while (true) {
                StateListIterator stateListIterator = (StateListIterator) listIterator;
                if (!stateListIterator.hasNext()) {
                    toggleableState = ToggleableState.On;
                    break;
                }
                if (!((Boolean) ((Pair) stateListIterator.next()).second).booleanValue()) {
                    if (!snapshotStateList2.isEmpty()) {
                        ListIterator listIterator2 = snapshotStateList2.listIterator();
                        while (true) {
                            StateListIterator stateListIterator2 = (StateListIterator) listIterator2;
                            if (!stateListIterator2.hasNext()) {
                                toggleableState = ToggleableState.Off;
                                break;
                            } else if (((Boolean) ((Pair) stateListIterator2.next()).second).booleanValue()) {
                                toggleableState = ToggleableState.Indeterminate;
                                break;
                            }
                        }
                    } else {
                        toggleableState = ToggleableState.Off;
                        break;
                    }
                }
            }
            ToggleableState toggleableState2 = toggleableState;
            Preferences$Key preferences$Key = PreferenceKeysKt.LyricsRomanizeAsMainKey;
            Boolean bool2 = Boolean.FALSE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(preferences$Key, bool2, gapComposer2, 48);
            boolean zBooleanValue2 = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference2);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(PreferenceKeysKt.LyricsRomanizeCyrillicByLineKey, bool2, gapComposer2, 48);
            boolean zBooleanValue3 = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference3.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda2 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference3);
            ArrayList arrayList4 = new ArrayList();
            WindowInsets windowInsets = (WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.scroll$default(OffsetKt.windowInsetsPadding(companion, windowInsets), ImageKt.rememberScrollState(gapComposer2), true), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            MenuKt.Material3SettingsGroup(MathKt.stringResource(R.string.options, gapComposer2), CollectionsKt__IterablesKt.listOf((Object[]) new Material3SettingsItem[]{new Material3SettingsItem(IntMath.painterResource(R.drawable.queue_music, 0, gapComposer2), AiSettingsKt.lambda$1494442422, null, Expect_jvmKt.rememberComposableLambda(-179147464, new PrivacySettingsKt$$ExternalSyntheticLambda1((byte) 4, mimesKt$$ExternalSyntheticLambda1, zBooleanValue2), gapComposer2), false, false, null, 490), new Material3SettingsItem(IntMath.painterResource(R.drawable.info, 0, gapComposer2), AiSettingsKt.f458lambda$1247437513, null, Expect_jvmKt.rememberComposableLambda(1373939897, new PrivacySettingsKt$$ExternalSyntheticLambda1((byte) 5, mimesKt$$ExternalSyntheticLambda2, zBooleanValue3), gapComposer2), false, false, null, 490)}), null, gapComposer2, 64, 12);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 8.0f));
            arrayList4.add(new Material3SettingsItem(IntMath.painterResource(R.drawable.info, 0, gapComposer2), AiSettingsKt.lambda$1645326878, null, Expect_jvmKt.rememberComposableLambda(777399516, new AlbumScreenKt$$ExternalSyntheticLambda8((Object) toggleableState2, (Object) snapshotStateList2, (Object) mimesKt$$ExternalSyntheticLambda0, (byte) 15), gapComposer2), false, false, null, 490));
            gapComposer2.startReplaceGroup(259024766);
            ListIterator listIterator3 = snapshotStateList2.listIterator();
            int i4 = 0;
            while (true) {
                StateListIterator stateListIterator3 = (StateListIterator) listIterator3;
                if (!stateListIterator3.hasNext()) {
                    gapComposer2.end(false);
                    MenuKt.Material3SettingsGroup(MathKt.stringResource(R.string.content_language, gapComposer2), arrayList4, null, gapComposer2, 0, 12);
                    gapComposer2.end(true);
                    navHostController2 = navHostController;
                    MenuKt.m1493TopAppBarGHTll3U(AiSettingsKt.f564lambda$678257462, null, Expect_jvmKt.rememberComposableLambda(-314790964, new ThemeScreenKt$$ExternalSyntheticLambda1(navHostController2, (byte) 4), gapComposer2), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer2, 390, 250);
                    gapComposer = gapComposer2;
                    break;
                }
                Object next = stateListIterator3.next();
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw null;
                }
                Pair pair2 = (Pair) next;
                String str3 = (String) pair2.first;
                arrayList4.add(new Material3SettingsItem(IntMath.painterResource(R.drawable.language, 0, gapComposer2), Expect_jvmKt.rememberComposableLambda(-2058990143, new ShowMediaInfoKt$$ExternalSyntheticLambda0(str3, (byte) 1), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(632518271, new MiniPlayerKt$$ExternalSyntheticLambda28(((Boolean) pair2.second).booleanValue(), snapshotStateList2, i4, str3, mimesKt$$ExternalSyntheticLambda0), gapComposer2), false, false, null, 490));
                i4 = i5;
            }
        } else {
            navHostController2 = navHostController;
            gapComposer2.skipToGroupEnd();
            gapComposer = gapComposer2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ThemeScreenKt$$ExternalSyntheticLambda1(navHostController2, i, (byte) 5);
        }
    }
}
