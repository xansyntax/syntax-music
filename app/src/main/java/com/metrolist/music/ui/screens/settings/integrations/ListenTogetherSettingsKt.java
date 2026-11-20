package com.metrolist.music.ui.screens.settings.integrations;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda2;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.ListenTogetherServer;
import com.metrolist.music.listentogether.ListenTogetherServers;
import com.metrolist.music.listentogether.LogEntry;
import com.metrolist.music.listentogether.RoomRole;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.IntegrationCardItem;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda117;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda120;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda49;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda35;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda35;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda18;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda18;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.settings.StorageSettingsKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.theme.UiStyleKt$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferedChannel$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListenTogetherSettingsKt {
    public static final void BlockedUsersDialog(Set set, Function1 function1, Function0 function0, Composer composer, int i) {
        set.getClass();
        function1.getClass();
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1581810419);
        int i2 = i | (gapComposer.changed(set) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            DialogKt.DefaultDialog(function0, null, LastFMSettingsKt.lambda$100729455, LastFMSettingsKt.f621lambda$292269490, Expect_jvmKt.rememberComposableLambda(1528590725, new PlayerMenuKt$$ExternalSyntheticLambda49(function0, (byte) 7), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-831852453, new PlayerKt$$ExternalSyntheticLambda82(set, LazyListStateKt.rememberLazyListState(gapComposer), function1, (byte) 22), gapComposer), gapComposer, ((i2 >> 6) & 14) | 1600896, 34);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlbumScreenKt$$ExternalSyntheticLambda8((byte) 18, i, set, function1, function0);
        }
    }

    public static final void ListenTogetherSettings(NavHostController navHostController, Composer composer, int i) {
        NavHostController navHostController2;
        GapComposer gapComposer;
        Function0 function0;
        NeverEqualPolicy neverEqualPolicy;
        NeverEqualPolicy neverEqualPolicy2;
        ListenTogetherManager listenTogetherManager;
        MutableState mutableState;
        GapComposer gapComposer2;
        ListenTogetherManager listenTogetherManager2;
        MutableState mutableState2;
        Object next;
        int i2;
        Function0 function1;
        Function0 function2;
        final byte b;
        final byte b2;
        char c;
        navHostController.getClass();
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(46207631);
        int i3 = (gapComposer3.changedInstance(navHostController) ? 4 : 2) | i;
        if (gapComposer3.shouldExecute(i3 & 1, (i3 & 3) != 2)) {
            ListenTogetherManager listenTogetherManager3 = (ListenTogetherManager) gapComposer3.consume(MainActivityKt.LocalListenTogetherManager);
            byte b3 = 22;
            if (listenTogetherManager3 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new ThemeScreenKt$$ExternalSyntheticLambda1(navHostController, i, b3);
                    return;
                }
                return;
            }
            Context context = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            String strStringResource = MathKt.stringResource(R.string.listen_together_cannot_edit_username_in_room, gapComposer3);
            Object objRememberedValue = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy3) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager3.connectionState, gapComposer3);
            final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager3.roomState, gapComposer3);
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager3.role, gapComposer3);
            FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager3.pendingJoinRequests, gapComposer3);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager3.logs, gapComposer3);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager3.blockedUsernames, gapComposer3);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy3) {
                objRememberedValue2 = (List) ListenTogetherServers.servers$delegate.getValue();
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            List list = (List) objRememberedValue2;
            Preferences$Key preferences$Key = PreferenceKeysKt.ListenTogetherServerUrlKey;
            SynchronizedLazyImpl synchronizedLazyImpl = ListenTogetherServers.servers$delegate;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(preferences$Key, ((ListenTogetherServer) CollectionsKt.first((List) synchronizedLazyImpl.getValue())).url, gapComposer3, 0);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.ListenTogetherUsernameKey, "", gapComposer3, 48);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.ListenTogetherAutoApprovalKey;
            Boolean bool = Boolean.FALSE;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(preferences$Key2, bool, gapComposer3, 48);
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = UtilsKt.rememberPreference(PreferenceKeysKt.ListenTogetherAutoApproveSuggestionsKey, bool, gapComposer3, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference5 = UtilsKt.rememberPreference(PreferenceKeysKt.ListenTogetherSyncVolumeKey, Boolean.TRUE, gapComposer3, 48);
            Object[] objArr = new Object[0];
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy3) {
                objRememberedValue3 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 19);
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue3, gapComposer3, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy3) {
                objRememberedValue4 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 20);
                gapComposer3.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue4, gapComposer3, 48);
            Object[] objArr3 = new Object[0];
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy3) {
                objRememberedValue5 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 21);
                gapComposer3.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState5 = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue5, gapComposer3, 48);
            Object[] objArr4 = new Object[0];
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy3) {
                objRememberedValue6 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 22);
                gapComposer3.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState6 = (MutableState) SaverKt.rememberSaveable(objArr4, (Function0) objRememberedValue6, gapComposer3, 48);
            Object[] objArr5 = new Object[0];
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy3) {
                objRememberedValue7 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 23);
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState7 = (MutableState) SaverKt.rememberSaveable(objArr5, (Function0) objRememberedValue7, gapComposer3, 48);
            Object[] objArr6 = new Object[0];
            Object objRememberedValue8 = gapComposer3.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy3) {
                objRememberedValue8 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 24);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableState8 = (MutableState) SaverKt.rememberSaveable(objArr6, (Function0) objRememberedValue8, gapComposer3, 48);
            Object[] objArr7 = new Object[0];
            Object objRememberedValue9 = gapComposer3.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy3) {
                objRememberedValue9 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 25);
                gapComposer3.updateRememberedValue(objRememberedValue9);
            }
            MutableState mutableState9 = (MutableState) SaverKt.rememberSaveable(objArr7, (Function0) objRememberedValue9, gapComposer3, 48);
            boolean zChangedInstance = gapComposer3.changedInstance(listenTogetherManager3) | gapComposer3.changedInstance(context);
            Object objRememberedValue10 = gapComposer3.rememberedValue();
            Continuation continuation = null;
            if (zChangedInstance || objRememberedValue10 == neverEqualPolicy3) {
                objRememberedValue10 = new DataStoreKt$get$1((Object) listenTogetherManager3, (Object) context, continuation, (byte) 18);
                gapComposer3.updateRememberedValue(objRememberedValue10);
            }
            Stack.LaunchedEffect(gapComposer3, Unit.INSTANCE, (Function2) objRememberedValue10);
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                gapComposer3.startReplaceGroup(-2109752038);
                String str = (String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue();
                boolean zChanged = gapComposer3.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer3.changed(mutableState3);
                Object objRememberedValue11 = gapComposer3.rememberedValue();
                if (zChanged || objRememberedValue11 == neverEqualPolicy3) {
                    objRememberedValue11 = new AiSettingsKt$$ExternalSyntheticLambda18(dataStoreKt$rememberPreference$1$1RememberPreference, mutableState3, (byte) 5);
                    gapComposer3.updateRememberedValue(objRememberedValue11);
                }
                Function1 function3 = (Function1) objRememberedValue11;
                boolean zChanged2 = gapComposer3.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer3.changed(mutableState3);
                Object objRememberedValue12 = gapComposer3.rememberedValue();
                if (zChanged2 || objRememberedValue12 == neverEqualPolicy3) {
                    objRememberedValue12 = new AiSettingsKt$$ExternalSyntheticLambda18(dataStoreKt$rememberPreference$1$1RememberPreference, mutableState3, (byte) 6);
                    gapComposer3.updateRememberedValue(objRememberedValue12);
                }
                Function1 function4 = (Function1) objRememberedValue12;
                boolean zChanged3 = gapComposer3.changed(mutableState3);
                Object objRememberedValue13 = gapComposer3.rememberedValue();
                if (zChanged3 || objRememberedValue13 == neverEqualPolicy3) {
                    objRememberedValue13 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState3, (byte) 17);
                    gapComposer3.updateRememberedValue(objRememberedValue13);
                }
                gapComposer = gapComposer3;
                function0 = null;
                neverEqualPolicy = neverEqualPolicy3;
                ServerChooserDialog(list, str, function3, function4, (Function0) objRememberedValue13, gapComposer, 0);
                gapComposer.end(false);
            } else {
                gapComposer = gapComposer3;
                function0 = null;
                neverEqualPolicy = neverEqualPolicy3;
                gapComposer.startReplaceGroup(-2109328237);
                gapComposer.end(false);
            }
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-2109245591);
                Boolean bool2 = (Boolean) mutableState4.getValue();
                bool2.getClass();
                Object[] objArr8 = {bool2};
                boolean zChanged4 = gapComposer.changed(dataStoreKt$rememberPreference$1$1RememberPreference2);
                Object objRememberedValue14 = gapComposer.rememberedValue();
                if (zChanged4 || objRememberedValue14 == neverEqualPolicy) {
                    objRememberedValue14 = new DiscordSettingsKt$$ExternalSyntheticLambda5(dataStoreKt$rememberPreference$1$1RememberPreference2, (byte) 21);
                    gapComposer.updateRememberedValue(objRememberedValue14);
                }
                MutableState mutableState10 = (MutableState) SaverKt.rememberSaveable(objArr8, (Function0) objRememberedValue14, gapComposer, 0);
                boolean zChanged5 = gapComposer.changed(mutableState4);
                Object objRememberedValue15 = gapComposer.rememberedValue();
                if (zChanged5 || objRememberedValue15 == neverEqualPolicy) {
                    c = 24;
                    objRememberedValue15 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState4, (byte) 24);
                    gapComposer.updateRememberedValue(objRememberedValue15);
                } else {
                    c = 24;
                }
                listenTogetherManager = listenTogetherManager3;
                gapComposer2 = gapComposer;
                neverEqualPolicy2 = neverEqualPolicy;
                mutableState = mutableState4;
                DialogKt.DefaultDialog((Function0) objRememberedValue15, null, LastFMSettingsKt.f622lambda$295698723, LastFMSettingsKt.f626lambda$41309316, Expect_jvmKt.rememberComposableLambda(582305139, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(dataStoreKt$rememberPreference$1$1RememberPreference2, mutableState4, mutableState10, (byte) 9), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-316486711, new DiscordSettingsKt$$ExternalSyntheticLambda78(mutableState10, (byte) 1), gapComposer), gapComposer2, 1600896, 34);
                gapComposer2.end(false);
            } else {
                neverEqualPolicy2 = neverEqualPolicy;
                listenTogetherManager = listenTogetherManager3;
                mutableState = mutableState4;
                gapComposer2 = gapComposer;
                gapComposer2.startReplaceGroup(-2107606125);
                gapComposer2.end(false);
            }
            if (((Boolean) mutableState5.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-2107505778);
                Boolean bool3 = (Boolean) mutableState5.getValue();
                bool3.booleanValue();
                Object[] objArr9 = {bool3};
                boolean zChanged6 = gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference2);
                Object objRememberedValue16 = gapComposer2.rememberedValue();
                if (zChanged6 || objRememberedValue16 == neverEqualPolicy2) {
                    objRememberedValue16 = new DiscordSettingsKt$$ExternalSyntheticLambda5(dataStoreKt$rememberPreference$1$1RememberPreference2, (byte) 27);
                    gapComposer2.updateRememberedValue(objRememberedValue16);
                }
                MutableState mutableState11 = (MutableState) SaverKt.rememberSaveable(objArr9, (Function0) objRememberedValue16, gapComposer2, 0);
                boolean zChanged7 = gapComposer2.changed(mutableState5);
                Object objRememberedValue17 = gapComposer2.rememberedValue();
                if (zChanged7 || objRememberedValue17 == neverEqualPolicy2) {
                    objRememberedValue17 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState5, (byte) 29);
                    gapComposer2.updateRememberedValue(objRememberedValue17);
                }
                DialogKt.DefaultDialog((Function0) objRememberedValue17, null, LastFMSettingsKt.f612lambda$1743705570, LastFMSettingsKt.f608lambda$1489316163, Expect_jvmKt.rememberComposableLambda(-865701708, new QueueMenuKt$$ExternalSyntheticLambda9(mutableState5, (Object) mutableState11, (MutableState) dataStoreKt$rememberPreference$1$1RememberPreference2, (Object) listenTogetherManager, (Object) context, (byte) 14), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(-1764493558, new DiscordSettingsKt$$ExternalSyntheticLambda78(mutableState11, (byte) 2), gapComposer2), gapComposer2, 1600896, 34);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-2105379085);
                gapComposer2.end(false);
            }
            if (((Boolean) mutableState6.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-2105268818);
                Boolean bool4 = (Boolean) mutableState6.getValue();
                bool4.booleanValue();
                Object[] objArr10 = {bool4};
                boolean zChanged8 = gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference2);
                Object objRememberedValue18 = gapComposer2.rememberedValue();
                if (zChanged8 || objRememberedValue18 == neverEqualPolicy2) {
                    objRememberedValue18 = new DiscordSettingsKt$$ExternalSyntheticLambda5(dataStoreKt$rememberPreference$1$1RememberPreference2, (byte) 13);
                    gapComposer2.updateRememberedValue(objRememberedValue18);
                }
                MutableState mutableState12 = (MutableState) SaverKt.rememberSaveable(objArr10, (Function0) objRememberedValue18, gapComposer2, 0);
                boolean zChanged9 = gapComposer2.changed(mutableState6);
                Object objRememberedValue19 = gapComposer2.rememberedValue();
                if (zChanged9 || objRememberedValue19 == neverEqualPolicy2) {
                    objRememberedValue19 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState6, (byte) 14);
                    gapComposer2.updateRememberedValue(objRememberedValue19);
                }
                ComposableLambdaImpl composableLambdaImpl = LastFMSettingsKt.lambda$1103254879;
                ComposableLambdaImpl composableLambdaImpl2 = LastFMSettingsKt.lambda$1357644286;
                ListenTogetherManager listenTogetherManager4 = listenTogetherManager;
                QueueMenuKt$$ExternalSyntheticLambda12 queueMenuKt$$ExternalSyntheticLambda12 = new QueueMenuKt$$ExternalSyntheticLambda12(mutableState6, (Object) mutableState12, (Object) mutableState9, (Object) dataStoreKt$rememberPreference$1$1RememberPreference2, (Object) listenTogetherManager4, (Object) context, (byte) 12);
                listenTogetherManager2 = listenTogetherManager4;
                context = context;
                dataStoreKt$rememberPreference$1$1RememberPreference2 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                DialogKt.DefaultDialog((Function0) objRememberedValue19, null, composableLambdaImpl, composableLambdaImpl2, Expect_jvmKt.rememberComposableLambda(1981258741, queueMenuKt$$ExternalSyntheticLambda12, gapComposer2), null, Expect_jvmKt.rememberComposableLambda(1082466891, new SearchScreenKt$$ExternalSyntheticLambda18(mutableState12, mutableState9, (byte) 2), gapComposer2), gapComposer2, 1600896, 34);
                gapComposer2.end(false);
            } else {
                listenTogetherManager2 = listenTogetherManager;
                gapComposer2.startReplaceGroup(-2102773101);
                gapComposer2.end(false);
            }
            if (((Boolean) mutableState7.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-2102742318);
                List list2 = (List) mutableStateCollectAsStateWithLifecycle3.getValue();
                boolean zChangedInstance2 = gapComposer2.changedInstance(listenTogetherManager2);
                Object objRememberedValue20 = gapComposer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue20 == neverEqualPolicy2) {
                    objRememberedValue20 = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager2, (byte) 8);
                    gapComposer2.updateRememberedValue(objRememberedValue20);
                }
                Function0 function5 = (Function0) objRememberedValue20;
                mutableState2 = mutableState7;
                boolean zChanged10 = gapComposer2.changed(mutableState2);
                Object objRememberedValue21 = gapComposer2.rememberedValue();
                if (zChanged10 || objRememberedValue21 == neverEqualPolicy2) {
                    objRememberedValue21 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState2, (byte) 15);
                    gapComposer2.updateRememberedValue(objRememberedValue21);
                }
                LogsDialog(list2, function5, (Function0) objRememberedValue21, gapComposer2, 0);
                gapComposer2.end(false);
            } else {
                mutableState2 = mutableState7;
                gapComposer2.startReplaceGroup(-2102587597);
                gapComposer2.end(false);
            }
            if (((Boolean) mutableState8.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-2102547452);
                Set set = (Set) mutableStateCollectAsStateWithLifecycle4.getValue();
                boolean zChangedInstance3 = gapComposer2.changedInstance(listenTogetherManager2);
                Object objRememberedValue22 = gapComposer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue22 == neverEqualPolicy2) {
                    objRememberedValue22 = new ListenTogetherScreenKt$$ExternalSyntheticLambda35(listenTogetherManager2, (byte) 4);
                    gapComposer2.updateRememberedValue(objRememberedValue22);
                }
                Function1 function6 = (Function1) objRememberedValue22;
                boolean zChanged11 = gapComposer2.changed(mutableState8);
                Object objRememberedValue23 = gapComposer2.rememberedValue();
                if (zChanged11 || objRememberedValue23 == neverEqualPolicy2) {
                    objRememberedValue23 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState8, (byte) 16);
                    gapComposer2.updateRememberedValue(objRememberedValue23);
                }
                BlockedUsersDialog(set, function6, (Function0) objRememberedValue23, gapComposer2, 0);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-2102348525);
                gapComposer2.end(false);
            }
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MainActivityKt.LocalPlayerAwareWindowInsets;
            LimitInsets limitInsets = new LimitInsets((WindowInsets) gapComposer2.consume(staticProvidableCompositionLocal), 47);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierScroll$default = ImageKt.scroll$default(OffsetKt.windowInsetsPadding(companion, limitInsets), ImageKt.rememberScrollState(gapComposer2), true);
            Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
            BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierScroll$default);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            MutableState mutableState13 = mutableState2;
            OffsetKt.Spacer(gapComposer2, OffsetKt.windowInsetsPadding(companion, new LimitInsets((WindowInsets) gapComposer2.consume(staticProvidableCompositionLocal), 16)));
            boolean zChanged12 = gapComposer2.changed((String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue());
            Object objRememberedValue24 = gapComposer2.rememberedValue();
            if (zChanged12 || objRememberedValue24 == neverEqualPolicy2) {
                String str2 = (String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue();
                str2.getClass();
                Iterator it = ((List) synchronizedLazyImpl.getValue()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = function0;
                        break;
                    }
                    next = it.next();
                    Iterator it2 = it;
                    if (Intrinsics.areEqual(((ListenTogetherServer) next).url, str2)) {
                        break;
                    } else {
                        it = it2;
                    }
                }
                objRememberedValue24 = (ListenTogetherServer) next;
                gapComposer2.updateRememberedValue(objRememberedValue24);
            }
            ListenTogetherServer listenTogetherServer = (ListenTogetherServer) objRememberedValue24;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference2;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(companion, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            String strStringResource2 = MathKt.stringResource(R.string.settings, gapComposer2);
            Painter painterPainterResource = IntMath.painterResource(R.drawable.person, 0, gapComposer2);
            ComposableLambdaImpl composableLambdaImpl3 = LastFMSettingsKt.f593lambda$104742218;
            byte b4 = 7;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(2055814327, new PlayerKt$$ExternalSyntheticLambda35(r23, b4), gapComposer2);
            if (((Set) r23.getValue()).isEmpty()) {
                i2 = 0;
                gapComposer2.startReplaceGroup(-513811173);
                gapComposer2.end(false);
                function1 = function0;
            } else {
                gapComposer2.startReplaceGroup(-513920386);
                boolean zChanged13 = gapComposer2.changed(mutableState8);
                Object objRememberedValue25 = gapComposer2.rememberedValue();
                if (zChanged13 || objRememberedValue25 == neverEqualPolicy2) {
                    objRememberedValue25 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState8, (byte) 18);
                    gapComposer2.updateRememberedValue(objRememberedValue25);
                }
                i2 = 0;
                gapComposer2.end(false);
                function1 = (Function0) objRememberedValue25;
            }
            IntegrationCardItem integrationCardItem = new IntegrationCardItem(painterPainterResource, composableLambdaImpl3, composableLambdaImplRememberComposableLambda, null, function1, 56);
            Painter painterPainterResource2 = IntMath.painterResource(R.drawable.cloud, i2, gapComposer2);
            ComposableLambdaImpl composableLambdaImpl4 = LastFMSettingsKt.f614lambda$1851760009;
            byte b5 = 6;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(308796536, new AlarmSettingsKt$$ExternalSyntheticLambda5(listenTogetherServer, dataStoreKt$rememberPreference$1$1RememberPreference, b5), gapComposer2);
            boolean zChanged14 = gapComposer2.changed(mutableState3);
            Object objRememberedValue26 = gapComposer2.rememberedValue();
            if (zChanged14 || objRememberedValue26 == neverEqualPolicy2) {
                objRememberedValue26 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState3, (byte) 19);
                gapComposer2.updateRememberedValue(objRememberedValue26);
            }
            IntegrationCardItem integrationCardItem2 = new IntegrationCardItem(painterPainterResource2, composableLambdaImpl4, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue26, 56);
            Painter painterPainterResource3 = IntMath.painterResource(R.drawable.person, 0, gapComposer2);
            ComposableLambdaImpl composableLambdaImpl5 = LastFMSettingsKt.lambda$696189496;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-1438221255, new StorageSettingsKt$$ExternalSyntheticLambda8(dataStoreKt$rememberPreference$1$1, b5), gapComposer2);
            if (((Listentogether.RoomState) r19.getValue()) == null) {
                gapComposer2.startReplaceGroup(-512467230);
                MutableState mutableState14 = mutableState;
                boolean zChanged15 = gapComposer2.changed(mutableState14);
                Object objRememberedValue27 = gapComposer2.rememberedValue();
                if (zChanged15 || objRememberedValue27 == neverEqualPolicy2) {
                    objRememberedValue27 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState14, (byte) 20);
                    gapComposer2.updateRememberedValue(objRememberedValue27);
                }
                function2 = (Function0) objRememberedValue27;
                b = 0;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-512349740);
                Context context2 = context;
                boolean zChangedInstance4 = gapComposer2.changedInstance(context2) | gapComposer2.changed(strStringResource);
                Object objRememberedValue28 = gapComposer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue28 == neverEqualPolicy2) {
                    objRememberedValue28 = new PlayerMenuKt$$ExternalSyntheticLambda120(context2, strStringResource, (byte) 6);
                    gapComposer2.updateRememberedValue(objRememberedValue28);
                }
                function2 = (Function0) objRememberedValue28;
                b = 0;
                gapComposer2.end(false);
            }
            IntegrationCardItem integrationCardItem3 = new IntegrationCardItem(painterPainterResource3, composableLambdaImpl5, composableLambdaImplRememberComposableLambda3, null, function2, 56);
            Painter painterPainterResource4 = IntMath.painterResource(R.drawable.done, b, gapComposer2);
            ComposableLambdaImpl composableLambdaImpl6 = LastFMSettingsKt.f594lambda$1050828295;
            ComposableLambdaImpl composableLambdaImpl7 = LastFMSettingsKt.lambda$1109728250;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(-1024682501, new Function2() { // from class: com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b6 = b;
                    Unit unit = Unit.INSTANCE;
                    NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                    RoomRole roomRole = RoomRole.GUEST;
                    State state = mutableStateCollectAsStateWithLifecycle2;
                    MutableState mutableState15 = mutableStateCollectAsStateWithLifecycle;
                    MutableState mutableState16 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                    switch (b6) {
                        case 0:
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer4 = (GapComposer) composer2;
                            if (!gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                gapComposer4.skipToGroupEnd();
                            } else {
                                boolean zBooleanValue = ((Boolean) mutableState16.getValue()).booleanValue();
                                boolean z2 = ((Listentogether.RoomState) mutableState15.getValue()) == null || ((RoomRole) state.getValue()) != roomRole;
                                boolean zChanged16 = gapComposer4.changed(mutableState16);
                                Object objRememberedValue29 = gapComposer4.rememberedValue();
                                if (zChanged16 || objRememberedValue29 == neverEqualPolicy4) {
                                    objRememberedValue29 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState16, (byte) 5);
                                    gapComposer4.updateRememberedValue(objRememberedValue29);
                                }
                                MenuKt.Switch(zBooleanValue, (Function1) objRememberedValue29, null, Expect_jvmKt.rememberComposableLambda(-221532865, new StorageSettingsKt$$ExternalSyntheticLambda8(mutableState16, (byte) 11), gapComposer4), z2, null, gapComposer4, 3072, 100);
                            }
                            break;
                        default:
                            Composer composer3 = (Composer) obj;
                            int iIntValue2 = ((Integer) obj2).intValue();
                            GapComposer gapComposer5 = (GapComposer) composer3;
                            if (!gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                gapComposer5.skipToGroupEnd();
                            } else {
                                boolean zBooleanValue2 = ((Boolean) mutableState16.getValue()).booleanValue();
                                boolean z3 = ((Listentogether.RoomState) mutableState15.getValue()) == null || ((RoomRole) state.getValue()) != roomRole;
                                boolean zChanged17 = gapComposer5.changed(mutableState16);
                                Object objRememberedValue30 = gapComposer5.rememberedValue();
                                if (zChanged17 || objRememberedValue30 == neverEqualPolicy4) {
                                    objRememberedValue30 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState16, (byte) 29);
                                    gapComposer5.updateRememberedValue(objRememberedValue30);
                                }
                                MenuKt.Switch(zBooleanValue2, (Function1) objRememberedValue30, null, Expect_jvmKt.rememberComposableLambda(-1968550656, new StorageSettingsKt$$ExternalSyntheticLambda8(mutableState16, (byte) 8), gapComposer5), z3, null, gapComposer5, 3072, 100);
                            }
                            break;
                    }
                    return unit;
                }
            }, gapComposer2);
            boolean zChanged16 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference3);
            Object objRememberedValue29 = gapComposer2.rememberedValue();
            if (zChanged16 || objRememberedValue29 == neverEqualPolicy2) {
                b2 = 0;
                objRememberedValue29 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b6 = b2;
                        Unit unit = Unit.INSTANCE;
                        RoomRole roomRole = RoomRole.GUEST;
                        MutableState mutableState15 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                        State state = mutableStateCollectAsStateWithLifecycle2;
                        MutableState mutableState16 = mutableStateCollectAsStateWithLifecycle;
                        switch (b6) {
                            case 0:
                                if (((Listentogether.RoomState) mutableState16.getValue()) == null || ((RoomRole) state.getValue()) != roomRole) {
                                    mutableState15.setValue(Boolean.valueOf(!((Boolean) mutableState15.getValue()).booleanValue()));
                                }
                                break;
                            default:
                                if (((Listentogether.RoomState) mutableState16.getValue()) == null || ((RoomRole) state.getValue()) != roomRole) {
                                    mutableState15.setValue(Boolean.valueOf(!((Boolean) mutableState15.getValue()).booleanValue()));
                                }
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue29);
            } else {
                b2 = 0;
            }
            IntegrationCardItem integrationCardItem4 = new IntegrationCardItem(painterPainterResource4, composableLambdaImpl6, composableLambdaImpl7, composableLambdaImplRememberComposableLambda4, (Function0) objRememberedValue29, 48);
            Painter painterPainterResource5 = IntMath.painterResource(R.drawable.done, b2, gapComposer2);
            ComposableLambdaImpl composableLambdaImpl8 = LastFMSettingsKt.lambda$1497121210;
            ComposableLambdaImpl composableLambdaImpl9 = LastFMSettingsKt.f628lambda$637289541;
            final byte b6 = 1;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(1523267004, new Function2() { // from class: com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b7 = b6;
                    Unit unit = Unit.INSTANCE;
                    NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                    RoomRole roomRole = RoomRole.GUEST;
                    State state = mutableStateCollectAsStateWithLifecycle2;
                    MutableState mutableState15 = mutableStateCollectAsStateWithLifecycle;
                    MutableState mutableState16 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                    switch (b7) {
                        case 0:
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer4 = (GapComposer) composer2;
                            if (!gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                gapComposer4.skipToGroupEnd();
                            } else {
                                boolean zBooleanValue = ((Boolean) mutableState16.getValue()).booleanValue();
                                boolean z2 = ((Listentogether.RoomState) mutableState15.getValue()) == null || ((RoomRole) state.getValue()) != roomRole;
                                boolean zChanged17 = gapComposer4.changed(mutableState16);
                                Object objRememberedValue210 = gapComposer4.rememberedValue();
                                if (zChanged17 || objRememberedValue210 == neverEqualPolicy4) {
                                    objRememberedValue210 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState16, (byte) 5);
                                    gapComposer4.updateRememberedValue(objRememberedValue210);
                                }
                                MenuKt.Switch(zBooleanValue, (Function1) objRememberedValue210, null, Expect_jvmKt.rememberComposableLambda(-221532865, new StorageSettingsKt$$ExternalSyntheticLambda8(mutableState16, (byte) 11), gapComposer4), z2, null, gapComposer4, 3072, 100);
                            }
                            break;
                        default:
                            Composer composer3 = (Composer) obj;
                            int iIntValue2 = ((Integer) obj2).intValue();
                            GapComposer gapComposer5 = (GapComposer) composer3;
                            if (!gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                gapComposer5.skipToGroupEnd();
                            } else {
                                boolean zBooleanValue2 = ((Boolean) mutableState16.getValue()).booleanValue();
                                boolean z3 = ((Listentogether.RoomState) mutableState15.getValue()) == null || ((RoomRole) state.getValue()) != roomRole;
                                boolean zChanged18 = gapComposer5.changed(mutableState16);
                                Object objRememberedValue30 = gapComposer5.rememberedValue();
                                if (zChanged18 || objRememberedValue30 == neverEqualPolicy4) {
                                    objRememberedValue30 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState16, (byte) 29);
                                    gapComposer5.updateRememberedValue(objRememberedValue30);
                                }
                                MenuKt.Switch(zBooleanValue2, (Function1) objRememberedValue30, null, Expect_jvmKt.rememberComposableLambda(-1968550656, new StorageSettingsKt$$ExternalSyntheticLambda8(mutableState16, (byte) 8), gapComposer5), z3, null, gapComposer5, 3072, 100);
                            }
                            break;
                    }
                    return unit;
                }
            }, gapComposer2);
            boolean zChanged17 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference4);
            Object objRememberedValue30 = gapComposer2.rememberedValue();
            if (zChanged17 || objRememberedValue30 == neverEqualPolicy2) {
                final byte b7 = 1;
                objRememberedValue30 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b8 = b7;
                        Unit unit = Unit.INSTANCE;
                        RoomRole roomRole = RoomRole.GUEST;
                        MutableState mutableState15 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                        State state = mutableStateCollectAsStateWithLifecycle2;
                        MutableState mutableState16 = mutableStateCollectAsStateWithLifecycle;
                        switch (b8) {
                            case 0:
                                if (((Listentogether.RoomState) mutableState16.getValue()) == null || ((RoomRole) state.getValue()) != roomRole) {
                                    mutableState15.setValue(Boolean.valueOf(!((Boolean) mutableState15.getValue()).booleanValue()));
                                }
                                break;
                            default:
                                if (((Listentogether.RoomState) mutableState16.getValue()) == null || ((RoomRole) state.getValue()) != roomRole) {
                                    mutableState15.setValue(Boolean.valueOf(!((Boolean) mutableState15.getValue()).booleanValue()));
                                }
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue30);
            }
            IntegrationCardItem integrationCardItem5 = new IntegrationCardItem(painterPainterResource5, composableLambdaImpl8, composableLambdaImpl9, composableLambdaImplRememberComposableLambda5, (Function0) objRememberedValue30, 48);
            Painter painterPainterResource6 = IntMath.painterResource(R.drawable.volume_up, 0, gapComposer2);
            ComposableLambdaImpl composableLambdaImpl10 = LastFMSettingsKt.f619lambda$249896581;
            ComposableLambdaImpl composableLambdaImpl11 = LastFMSettingsKt.lambda$1910659964;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(-223750787, new StorageSettingsKt$$ExternalSyntheticLambda8(dataStoreKt$rememberPreference$1$1RememberPreference5, b4), gapComposer2);
            boolean zChanged18 = gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference5);
            Object objRememberedValue31 = gapComposer2.rememberedValue();
            if (zChanged18 || objRememberedValue31 == neverEqualPolicy2) {
                objRememberedValue31 = new DiscordSettingsKt$$ExternalSyntheticLambda5(dataStoreKt$rememberPreference$1$1RememberPreference5, (byte) 22);
                gapComposer2.updateRememberedValue(objRememberedValue31);
            }
            IntegrationCardItem integrationCardItem6 = new IntegrationCardItem(painterPainterResource6, composableLambdaImpl10, composableLambdaImpl11, composableLambdaImplRememberComposableLambda6, (Function0) objRememberedValue31, 48);
            Painter painterPainterResource7 = IntMath.painterResource(R.drawable.bug_report, 0, gapComposer2);
            ComposableLambdaImpl composableLambdaImpl12 = LastFMSettingsKt.f616lambda$1996914372;
            ComposableLambdaImpl composableLambdaImpl13 = LastFMSettingsKt.lambda$163642173;
            boolean zChanged19 = gapComposer2.changed(mutableState13);
            Object objRememberedValue32 = gapComposer2.rememberedValue();
            if (zChanged19 || objRememberedValue32 == neverEqualPolicy2) {
                objRememberedValue32 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState13, (byte) 23);
                gapComposer2.updateRememberedValue(objRememberedValue32);
            }
            MenuKt.IntegrationCard(strStringResource2, CollectionsKt__IterablesKt.listOf((Object[]) new IntegrationCardItem[]{integrationCardItem, integrationCardItem2, integrationCardItem3, integrationCardItem4, integrationCardItem5, integrationCardItem6, new IntegrationCardItem(painterPainterResource7, composableLambdaImpl12, composableLambdaImpl13, null, (Function0) objRememberedValue32, 56)}), gapComposer2, 64);
            gapComposer2.end(true);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 16.0f));
            gapComposer2.end(true);
            navHostController2 = navHostController;
            GapComposer gapComposer4 = gapComposer2;
            MenuKt.m1493TopAppBarGHTll3U(LastFMSettingsKt.f604lambda$1365463733, null, Expect_jvmKt.rememberComposableLambda(2006336137, new ThemeScreenKt$$ExternalSyntheticLambda1(navHostController2, (byte) 23), gapComposer2), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer4, 390, 250);
            gapComposer3 = gapComposer4;
        } else {
            navHostController2 = navHostController;
            gapComposer3.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer3.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new ThemeScreenKt$$ExternalSyntheticLambda1(navHostController2, i, (byte) 24);
        }
    }

    public static final void LogEntryItem(LogEntry logEntry, Composer composer, int i) {
        boolean z;
        long j;
        logEntry.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1609414927);
        int i2 = i | (gapComposer.changed(logEntry) ? 4 : 2);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, 1);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z2 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            String str = logEntry.timestamp;
            TextStyle textStyle = CardKt.getTypography(gapComposer).labelSmall;
            long j2 = CardKt.getColorScheme(gapComposer).onSurfaceVariant;
            GenericFontFamily genericFontFamily = FontFamily.Monospace;
            TextKt.m352TextNvy7gAk(str, null, j2, 0L, null, null, genericFontFamily, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 130938);
            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            int iOrdinal = logEntry.level.ordinal();
            if (iOrdinal == 0) {
                z = false;
                gapComposer.startReplaceGroup(26560327);
                j = CardKt.getColorScheme(gapComposer).primaryContainer;
                gapComposer.end(false);
            } else if (iOrdinal == 1) {
                z = false;
                gapComposer.startReplaceGroup(26554952);
                gapComposer.end(false);
                j = -13413182865408L;
            } else if (iOrdinal == 2) {
                z = false;
                gapComposer.startReplaceGroup(26553061);
                j = CardKt.getColorScheme(gapComposer).errorContainer;
                gapComposer.end(false);
            } else {
                if (iOrdinal != 3) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, 26550615, false);
                }
                gapComposer.startReplaceGroup(26557701);
                j = CardKt.getColorScheme(gapComposer).surfaceVariant;
                z = false;
                gapComposer.end(false);
            }
            boolean z3 = z;
            SurfaceKt.m337SurfaceT9BRK9s(null, roundedCornerShapeM185RoundedCornerShape0680j_4, j, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-611795748, new ListenTogetherSettingsKt$$ExternalSyntheticLambda80(logEntry), gapComposer), gapComposer, 12582912, 121);
            gapComposer.end(true);
            TextKt.m352TextNvy7gAk(logEntry.message, null, 0L, 0L, null, null, genericFontFamily, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).bodySmall, gapComposer, 0, 0, 130942);
            gapComposer = gapComposer;
            String str2 = logEntry.details;
            if (str2 == null) {
                gapComposer.startReplaceGroup(1996686121);
                gapComposer.end(z3);
            } else {
                gapComposer.startReplaceGroup(1996686122);
                TextKt.m352TextNvy7gAk(str2, null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, null, genericFontFamily, 0L, null, 0L, 2, false, 2, 0, CardKt.getTypography(gapComposer).bodySmall, gapComposer, 0, 24960, 110458);
                gapComposer = gapComposer;
                gapComposer.end(z3);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListenTogetherSettingsKt$$ExternalSyntheticLambda80(logEntry, i);
        }
    }

    public static final void LogsDialog(List list, Function0 function0, Function0 function1, Composer composer, int i) {
        list.getClass();
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(773853407);
        byte b = 2;
        int i2 = i | (gapComposer.changed(list) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            Integer numValueOf = Integer.valueOf(list.size());
            boolean zChanged = gapComposer.changed(lazyListStateRememberLazyListState) | ((i2 & 14) == 4);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new DataStoreKt$get$1((Object) list, (Object) lazyListStateRememberLazyListState, (Continuation) null, (byte) 19);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer, numValueOf, (Function2) objRememberedValue);
            DialogKt.DefaultDialog(function1, null, LastFMSettingsKt.lambda$1465500899, LastFMSettingsKt.lambda$762905060, Expect_jvmKt.rememberComposableLambda(-414743923, new SongMenuKt$$ExternalSyntheticLambda34(list, (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext), function0, function1), gapComposer), null, Expect_jvmKt.rememberComposableLambda(1206937719, new BufferedChannel$$ExternalSyntheticLambda1(list, lazyListStateRememberLazyListState, b), gapComposer), gapComposer, ((i2 >> 6) & 14) | 1600896, 34);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlbumScreenKt$$ExternalSyntheticLambda8((byte) 19, i, list, function0, function1);
        }
    }

    public static final void ServerChooserDialog(List list, String str, Function1 function1, Function1 function2, Function0 function0, Composer composer, int i) {
        GapComposer gapComposer;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1741908201);
        int i2 = i | (gapComposer2.changed(list) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changedInstance(function1) ? 256 : 128) | (gapComposer2.changedInstance(function2) ? 2048 : 1024) | (gapComposer2.changedInstance(function0) ? 16384 : 8192);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            Object[] objArr = {str};
            boolean z = (i2 & 112) == 32;
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new NavDestinationImpl$$ExternalSyntheticLambda2(str, (byte) 7);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer2, 0);
            gapComposer = gapComposer2;
            DialogKt.DefaultDialog(function0, null, LastFMSettingsKt.f620lambda$254255123, LastFMSettingsKt.f629lambda$662278738, Expect_jvmKt.rememberComposableLambda(733543703, new PlayerMenuKt$$ExternalSyntheticLambda49(function0, (byte) 8), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(1920397953, new QueueMenuKt$$ExternalSyntheticLambda12(list, mutableState, (Object) StringsKt.trim((String) mutableState.getValue()).toString(), (Object) function2, (Object) str, (Function) function1, (byte) 13), gapComposer2), gapComposer, ((i2 >> 12) & 14) | 1600896, 34);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda92(list, str, function1, function2, function0, i, (byte) 13);
        }
    }
}
