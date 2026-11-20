package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.res.Configuration;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.window.DialogProperties;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentManager;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda39;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.listentogether.ConnectionState;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.RoomRole;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda43;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda84;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.Constants;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlayerMenuKt {
    public static final void ListenTogetherDialog(int i, Composer composer, MediaMetadata mediaMetadata, final Function0 function0, boolean z) {
        int i2;
        GapComposer gapComposer;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        PlayerKt$$ExternalSyntheticLambda43 playerKt$$ExternalSyntheticLambda43;
        Object playerMenuKt$ListenTogetherDialog$8$1;
        final MutableState mutableState;
        String str;
        MutableState mutableState2;
        MutableState mutableState3;
        MutableState mutableState4;
        Function0 function1 = function0;
        function1.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-621252266);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 256 : 128;
        }
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 131) != 130)) {
            if (z) {
                final Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
                final ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
                final String strStringResource = MathKt.stringResource(R.string.joining_room, gapComposer2);
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (listenTogetherManager == null) {
                    gapComposer2.startReplaceGroup(-711698091);
                    boolean z2 = (i2 & 896) == 256;
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (z2 || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AppBarKt$$ExternalSyntheticLambda8(function1, (byte) 9);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    DialogKt.ListDialog(function1, null, (Function1) objRememberedValue, gapComposer2, (i2 >> 6) & 14);
                    gapComposer2.end(false);
                    recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup == null) {
                        return;
                    } else {
                        playerKt$$ExternalSyntheticLambda43 = new PlayerKt$$ExternalSyntheticLambda43(z, mediaMetadata, function1, i, (byte) 4);
                    }
                } else {
                    gapComposer2.startReplaceGroup(-709861620);
                    gapComposer2.end(false);
                    final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.connectionState, gapComposer2);
                    final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.roomState, gapComposer2);
                    MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.userId, gapComposer2);
                    final MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.pendingJoinRequests, gapComposer2);
                    final MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(listenTogetherManager.pendingSuggestions, gapComposer2);
                    final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.ListenTogetherUsernameKey, "", gapComposer2, 48);
                    Object[] objArr = new Object[0];
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 18);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    final MutableState mutableState5 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue2, gapComposer2, 48);
                    Object[] objArr2 = new Object[0];
                    boolean zChanged = gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new QueueMenuKt$$ExternalSyntheticLambda2(dataStoreKt$rememberPreference$1$1RememberPreference, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    final MutableState mutableState6 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue3, gapComposer2, 0);
                    Object[] objArr3 = new Object[0];
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 19);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MutableState mutableState7 = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue4, gapComposer2, 48);
                    Object[] objArr4 = new Object[0];
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 20);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    MutableState mutableState8 = (MutableState) SaverKt.rememberSaveable(objArr4, (Function0) objRememberedValue5, gapComposer2, 48);
                    Object[] objArr5 = new Object[0];
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 21);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    MutableState mutableState9 = (MutableState) SaverKt.rememberSaveable(objArr5, (Function0) objRememberedValue6, gapComposer2, 48);
                    Object[] objArr6 = new Object[0];
                    Object objRememberedValue7 = gapComposer2.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 22);
                        gapComposer2.updateRememberedValue(objRememberedValue7);
                    }
                    final MutableState mutableState10 = (MutableState) SaverKt.rememberSaveable(objArr6, (Function0) objRememberedValue7, gapComposer2, 48);
                    Object[] objArr7 = new Object[0];
                    Object objRememberedValue8 = gapComposer2.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 23);
                        gapComposer2.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState11 = (MutableState) SaverKt.rememberSaveable(objArr7, (Function0) objRememberedValue8, gapComposer2, 48);
                    String strStringResource2 = MathKt.stringResource(R.string.waiting_for_approval, gapComposer2);
                    String strStringResource3 = MathKt.stringResource(R.string.invalid_room_code, gapComposer2);
                    String strStringResource4 = MathKt.stringResource(R.string.join_request_denied, gapComposer2);
                    if (((String) mutableState10.getValue()) == null || ((String) mutableState11.getValue()) == null) {
                        int i3 = i2;
                        gapComposer2.startReplaceGroup(-699894996);
                        gapComposer2.end(false);
                        String str2 = (String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue();
                        boolean zChanged2 = gapComposer2.changed(mutableState6) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference);
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue9 == neverEqualPolicy) {
                            objRememberedValue9 = new PlayerMenuKt$ListenTogetherDialog$7$1(mutableState6, dataStoreKt$rememberPreference$1$1RememberPreference, null, (byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        Stack.LaunchedEffect(gapComposer2, str2, (Function2) objRememberedValue9);
                        boolean zChangedInstance = gapComposer2.changedInstance(listenTogetherManager) | gapComposer2.changed(mutableState9) | gapComposer2.changed(strStringResource4) | gapComposer2.changed(strStringResource3) | gapComposer2.changed(mutableState8) | gapComposer2.changed(mutableState7) | gapComposer2.changedInstance(context);
                        Object objRememberedValue10 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue10 == neverEqualPolicy) {
                            mutableState = mutableStateCollectAsStateWithLifecycle3;
                            str = strStringResource2;
                            playerMenuKt$ListenTogetherDialog$8$1 = new PlayerMenuKt$ListenTogetherDialog$8$1(listenTogetherManager, strStringResource4, strStringResource3, context, mutableState9, mutableState8, mutableState7, null, (byte) 0);
                            mutableState2 = mutableState9;
                            mutableState3 = mutableState8;
                            mutableState4 = mutableState7;
                            gapComposer2.updateRememberedValue(playerMenuKt$ListenTogetherDialog$8$1);
                        } else {
                            mutableState4 = mutableState7;
                            mutableState3 = mutableState8;
                            mutableState2 = mutableState9;
                            str = strStringResource2;
                            mutableState = mutableStateCollectAsStateWithLifecycle3;
                            playerMenuKt$ListenTogetherDialog$8$1 = objRememberedValue10;
                        }
                        Stack.LaunchedEffect(gapComposer2, listenTogetherManager, (Function2) playerMenuKt$ListenTogetherDialog$8$1);
                        final boolean zIsInRoom = listenTogetherManager.client.isInRoom();
                        Listentogether.RoomState roomState = (Listentogether.RoomState) mutableStateCollectAsStateWithLifecycle2.getValue();
                        final boolean zAreEqual = Intrinsics.areEqual(roomState != null ? roomState.getHostId() : null, (String) mutableState.getValue());
                        boolean zChanged3 = gapComposer2.changed(zIsInRoom) | gapComposer2.changed(zAreEqual) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(listenTogetherManager) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changedInstance(context) | gapComposer2.changed(mutableState) | gapComposer2.changed(mutableState10) | gapComposer2.changed(mutableState11) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle5) | ((i3 & 896) == 256) | gapComposer2.changed(mutableState6) | gapComposer2.changed(mutableState5) | gapComposer2.changed(mutableState3) | gapComposer2.changed(str) | gapComposer2.changed(mutableState2) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer2.changed(mutableState4) | gapComposer2.changed(strStringResource);
                        Object objRememberedValue11 = gapComposer2.rememberedValue();
                        if (zChanged3 || objRememberedValue11 == neverEqualPolicy) {
                            final String str3 = str;
                            final MutableState mutableState12 = mutableState4;
                            final MutableState mutableState13 = mutableState3;
                            final MutableState mutableState14 = mutableState2;
                            objRememberedValue11 = new Function1() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda31
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                    lazyListIntervalContent.getClass();
                                    final boolean z3 = zIsInRoom;
                                    final boolean z4 = zAreEqual;
                                    final byte b = 1;
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 444915052, new Function3() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda70
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj2, Object obj3, Object obj4) throws XmlPullParserException, IOException {
                                            String strM;
                                            int i4;
                                            int i5;
                                            Composer composer2 = (Composer) obj3;
                                            int iIntValue = ((Integer) obj4).intValue();
                                            ((LazyItemScopeImpl) obj2).getClass();
                                            GapComposer gapComposer3 = (GapComposer) composer2;
                                            if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f, 16.0f);
                                                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer3, 54);
                                                int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM136paddingVpY3zN4);
                                                ComposeUiNode.Companion.getClass();
                                                gapComposer3.startReusableNode();
                                                if (gapComposer3.inserting) {
                                                    gapComposer3.createNode(LayoutNode.Constructor);
                                                } else {
                                                    gapComposer3.useNode();
                                                }
                                                Stack.m390setimpl(gapComposer3, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                                Stack.m389reconcileimpl(gapComposer3);
                                                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                                Painter painterPainterResource = IntMath.painterResource(R.drawable.group, 0, gapComposer3);
                                                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 40.0f), ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer3, 440, 0);
                                                OffsetKt.Spacer(gapComposer3, SizeKt.m155width3ABfNKs(companion, 16.0f));
                                                if (z3) {
                                                    gapComposer3.startReplaceGroup(1535938859);
                                                    if (z4) {
                                                        i4 = 326642317;
                                                        i5 = R.string.hosting_room;
                                                    } else {
                                                        i4 = 326643688;
                                                        i5 = R.string.in_room;
                                                    }
                                                    strM = Format$$ExternalSyntheticOutline0.m(gapComposer3, i4, i5, gapComposer3, false);
                                                    gapComposer3.end(false);
                                                } else {
                                                    strM = Format$$ExternalSyntheticOutline0.m(gapComposer3, 1536085210, R.string.listen_together, gapComposer3, false);
                                                }
                                                String str4 = strM;
                                                TextKt.m352TextNvy7gAk(str4, null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.headlineSmall, gapComposer3, 1572864, 0, 131002);
                                                gapComposer3.end(true);
                                            } else {
                                                gapComposer3.skipToGroupEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), 3);
                                    State state = mutableStateCollectAsStateWithLifecycle;
                                    final ListenTogetherManager listenTogetherManager2 = listenTogetherManager;
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 223114709, new PlayerMenuKt$$ExternalSyntheticLambda71(state, listenTogetherManager2)), 3);
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.f207lambda$461115596, 3);
                                    if (((ConnectionState) state.getValue()) == ConnectionState.CONNECTED && !z3) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$841620785, 3);
                                    }
                                    final Context context2 = context;
                                    final Function0 function2 = function0;
                                    if (z3) {
                                        Listentogether.RoomState roomState2 = (Listentogether.RoomState) mutableStateCollectAsStateWithLifecycle2.getValue();
                                        if (roomState2 != null) {
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 112494953, new PlayerMenuKt$$ExternalSyntheticLambda72(z4, roomState2, context2)), 3);
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.f187lambda$308019886, 3);
                                            List<Listentogether.UserInfo> usersList = roomState2.getUsersList();
                                            usersList.getClass();
                                            ArrayList arrayList = new ArrayList();
                                            for (Object obj2 : usersList) {
                                                if (((Listentogether.UserInfo) obj2).getIsConnected()) {
                                                    arrayList.add(obj2);
                                                }
                                            }
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 863188785, new SongMenuKt$$ExternalSyntheticLambda32(arrayList, z4, mutableState10, mutableState11, mutableState, (byte) 2)), 3);
                                            if (z4) {
                                                State state2 = mutableStateCollectAsStateWithLifecycle4;
                                                if (!((List) state2.getValue()).isEmpty()) {
                                                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.f217lambda$504514898, 3);
                                                    final List list = (List) state2.getValue();
                                                    final byte b2 = 0;
                                                    lazyListIntervalContent.items(list.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 8), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$lambda$36$0$2$$inlined$items$default$4
                                                        @Override // kotlin.jvm.functions.Function4
                                                        public final Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                                                            byte b3 = b2;
                                                            Unit unit = Unit.INSTANCE;
                                                            final ListenTogetherManager listenTogetherManager3 = listenTogetherManager2;
                                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                            List list2 = list;
                                                            switch (b3) {
                                                                case 0:
                                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj3;
                                                                    int iIntValue = ((Number) obj4).intValue();
                                                                    Composer composer2 = (Composer) obj5;
                                                                    int iIntValue2 = ((Number) obj6).intValue();
                                                                    int i4 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                                    if ((iIntValue2 & 48) == 0) {
                                                                        i4 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                                    }
                                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                                        gapComposer3.skipToGroupEnd();
                                                                    } else {
                                                                        final Listentogether.JoinRequestPayload joinRequestPayload = (Listentogether.JoinRequestPayload) list2.get(iIntValue);
                                                                        gapComposer3.startReplaceGroup(-111941755);
                                                                        Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f);
                                                                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                                                                        long j = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
                                                                        SurfaceKt.m337SurfaceT9BRK9s(modifierM136paddingVpY3zN4, roundedCornerShapeM185RoundedCornerShape0680j_4, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.15f, Color.m483getColorSpaceimpl(j)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1817480882, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1
                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Object invoke(Object obj7, Object obj8) {
                                                                                Composer composer3 = (Composer) obj7;
                                                                                int iIntValue3 = ((Number) obj8).intValue();
                                                                                GapComposer gapComposer4 = (GapComposer) composer3;
                                                                                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                                                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                                                                    FlowRowOverflow flowRowOverflow = OffsetKt.SpaceBetween;
                                                                                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                                                                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion2, 12.0f);
                                                                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer4, 54);
                                                                                    int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs);
                                                                                    ComposeUiNode.Companion.getClass();
                                                                                    gapComposer4.startReusableNode();
                                                                                    boolean z5 = gapComposer4.inserting;
                                                                                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                                                                                    if (z5) {
                                                                                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                                                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                                                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                                                    Stack.m390setimpl(gapComposer4, numValueOf, updater$$ExternalSyntheticLambda2);
                                                                                    Stack.m389reconcileimpl(gapComposer4);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                                                                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                                                                                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                                                                                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer4, 54);
                                                                                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, layoutWeightElement);
                                                                                    gapComposer4.startReusableNode();
                                                                                    if (gapComposer4.inserting) {
                                                                                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                                                                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 36.0f);
                                                                                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                                                                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                                                    long j2 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.secondary;
                                                                                    final Listentogether.JoinRequestPayload joinRequestPayload2 = joinRequestPayload;
                                                                                    SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs, roundedCornerShapeM185RoundedCornerShape0680j_5, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1861292683, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1$1$1$1
                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                        public final Object invoke(Object obj9, Object obj10) {
                                                                                            Composer composer4 = (Composer) obj9;
                                                                                            int iIntValue4 = ((Number) obj10).intValue();
                                                                                            GapComposer gapComposer5 = (GapComposer) composer4;
                                                                                            if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                                                                BiasAlignment biasAlignment = Alignment.Companion.Center;
                                                                                                FillElement fillElement = SizeKt.FillWholeMaxSize;
                                                                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                                                                                int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                                                                                                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, fillElement);
                                                                                                ComposeUiNode.Companion.getClass();
                                                                                                gapComposer5.startReusableNode();
                                                                                                if (gapComposer5.inserting) {
                                                                                                    gapComposer5.createNode(LayoutNode.Constructor);
                                                                                                } else {
                                                                                                    gapComposer5.useNode();
                                                                                                }
                                                                                                Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                                                                                Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                                                                Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                                                                                                Stack.m389reconcileimpl(gapComposer5);
                                                                                                Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                                                                                                String username = joinRequestPayload2.getUsername();
                                                                                                username.getClass();
                                                                                                String upperCase = StringsKt.take(1, username).toUpperCase(Locale.ROOT);
                                                                                                upperCase.getClass();
                                                                                                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                                                                                                TextKt.m352TextNvy7gAk(upperCase, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.onSecondary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.titleMedium, gapComposer5, 1572864, 0, 131002);
                                                                                                gapComposer5.end(true);
                                                                                            } else {
                                                                                                gapComposer5.skipToGroupEnd();
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }, gapComposer4), gapComposer4, 12582918, 120);
                                                                                    String username = joinRequestPayload2.getUsername();
                                                                                    username.getClass();
                                                                                    TextKt.m352TextNvy7gAk(username, null, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer4, 1572864, 0, 131002);
                                                                                    gapComposer4.end(true);
                                                                                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer4, 6);
                                                                                    int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, companion2);
                                                                                    gapComposer4.startReusableNode();
                                                                                    if (gapComposer4.inserting) {
                                                                                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                                                                                    final ListenTogetherManager listenTogetherManager4 = listenTogetherManager3;
                                                                                    boolean zChangedInstance2 = gapComposer4.changedInstance(listenTogetherManager4) | gapComposer4.changed(joinRequestPayload2);
                                                                                    Object objRememberedValue12 = gapComposer4.rememberedValue();
                                                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                                                    if (zChangedInstance2 || objRememberedValue12 == neverEqualPolicy2) {
                                                                                        objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1$1$2$1$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String userId = joinRequestPayload2.getUserId();
                                                                                                userId.getClass();
                                                                                                listenTogetherManager4.client.approveJoin(userId);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer4.updateRememberedValue(objRememberedValue12);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue12, null, false, null, null, AlbumMenuKt.lambda$1906328273, gapComposer4, 1572864, 62);
                                                                                    boolean zChangedInstance3 = gapComposer4.changedInstance(listenTogetherManager4) | gapComposer4.changed(joinRequestPayload2);
                                                                                    Object objRememberedValue13 = gapComposer4.rememberedValue();
                                                                                    if (zChangedInstance3 || objRememberedValue13 == neverEqualPolicy2) {
                                                                                        objRememberedValue13 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1$1$2$2$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String userId = joinRequestPayload2.getUserId();
                                                                                                userId.getClass();
                                                                                                listenTogetherManager4.client.rejectJoin(userId, "Rejected by host");
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer4.updateRememberedValue(objRememberedValue13);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue13, null, false, null, null, AlbumMenuKt.lambda$47671034, gapComposer4, 1572864, 62);
                                                                                    gapComposer4.end(true);
                                                                                    gapComposer4.end(true);
                                                                                } else {
                                                                                    gapComposer4.skipToGroupEnd();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, gapComposer3), gapComposer3, 12582918, 120);
                                                                        gapComposer3.end(false);
                                                                    }
                                                                    break;
                                                                default:
                                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj3;
                                                                    int iIntValue3 = ((Number) obj4).intValue();
                                                                    Composer composer3 = (Composer) obj5;
                                                                    int iIntValue4 = ((Number) obj6).intValue();
                                                                    int i5 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                                                                    if ((iIntValue4 & 48) == 0) {
                                                                        i5 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                                    }
                                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                                    if (!gapComposer4.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                                                                        gapComposer4.skipToGroupEnd();
                                                                    } else {
                                                                        final Listentogether.SuggestionReceivedPayload suggestionReceivedPayload = (Listentogether.SuggestionReceivedPayload) list2.get(iIntValue3);
                                                                        gapComposer4.startReplaceGroup(280397609);
                                                                        Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f);
                                                                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                                                                        long j2 = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
                                                                        SurfaceKt.m337SurfaceT9BRK9s(modifierM136paddingVpY3zN5, roundedCornerShapeM185RoundedCornerShape0680j_5, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.15f, Color.m483getColorSpaceimpl(j2)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1968128679, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$4$1
                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Object invoke(Object obj7, Object obj8) throws XmlPullParserException, IOException {
                                                                                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
                                                                                Composer composer4 = (Composer) obj7;
                                                                                int iIntValue5 = ((Number) obj8).intValue();
                                                                                GapComposer gapComposer5 = (GapComposer) composer4;
                                                                                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                                                                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                                                                    FlowRowOverflow flowRowOverflow = OffsetKt.SpaceBetween;
                                                                                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                                                                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion2, 12.0f);
                                                                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer5, 54);
                                                                                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM135padding3ABfNKs);
                                                                                    ComposeUiNode.Companion.getClass();
                                                                                    gapComposer5.startReusableNode();
                                                                                    boolean z5 = gapComposer5.inserting;
                                                                                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
                                                                                    if (z5) {
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda4);
                                                                                    } else {
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                                                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                                                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                                                    Stack.m390setimpl(gapComposer5, numValueOf, updater$$ExternalSyntheticLambda2);
                                                                                    Stack.m389reconcileimpl(gapComposer5);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                                                                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                                                                                    if (1.0f <= 0.0d) {
                                                                                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                                                                    }
                                                                                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true);
                                                                                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer5, 54);
                                                                                    int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, layoutWeightElement);
                                                                                    gapComposer5.startReusableNode();
                                                                                    if (gapComposer5.inserting) {
                                                                                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer5, updater$$ExternalSyntheticLambda2, gapComposer5);
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                                                                    Painter painterPainterResource = IntMath.painterResource(R.drawable.queue_music, 0, gapComposer5);
                                                                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                                                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda5 = textKt$$ExternalSyntheticLambda3;
                                                                                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion2, 24.0f), ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer5, 440, 0);
                                                                                    if (1.0f <= 0.0d) {
                                                                                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                                                                    }
                                                                                    LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true);
                                                                                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer5, 0);
                                                                                    int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, layoutWeightElement2);
                                                                                    gapComposer5.startReusableNode();
                                                                                    if (gapComposer5.inserting) {
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda5);
                                                                                    } else {
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer5, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer5, updater$$ExternalSyntheticLambda2, gapComposer5);
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                                                                                    final Listentogether.SuggestionReceivedPayload suggestionReceivedPayload2 = suggestionReceivedPayload;
                                                                                    String title = suggestionReceivedPayload2.getTrackInfo().getTitle();
                                                                                    title.getClass();
                                                                                    TextKt.m352TextNvy7gAk(title, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer5, 1572864, 24960, 110522);
                                                                                    String fromUsername = suggestionReceivedPayload2.getFromUsername();
                                                                                    fromUsername.getClass();
                                                                                    TextKt.m352TextNvy7gAk(fromUsername, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer5, 0, 24960, 110586);
                                                                                    gapComposer5.end(true);
                                                                                    gapComposer5.end(true);
                                                                                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer5, 6);
                                                                                    int iHashCode4 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer5, companion2);
                                                                                    gapComposer5.startReusableNode();
                                                                                    if (gapComposer5.inserting) {
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda5);
                                                                                    } else {
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer5, updater$$ExternalSyntheticLambda2, gapComposer5);
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                                                                                    final ListenTogetherManager listenTogetherManager4 = listenTogetherManager3;
                                                                                    boolean zChangedInstance2 = gapComposer5.changedInstance(listenTogetherManager4) | gapComposer5.changed(suggestionReceivedPayload2);
                                                                                    Object objRememberedValue12 = gapComposer5.rememberedValue();
                                                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                                                    if (zChangedInstance2 || objRememberedValue12 == neverEqualPolicy2) {
                                                                                        objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$4$1$1$2$1$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                                                                                suggestionId.getClass();
                                                                                                ListenTogetherManager listenTogetherManager5 = listenTogetherManager4;
                                                                                                if (listenTogetherManager5.isHost()) {
                                                                                                    listenTogetherManager5.client.approveSuggestion(suggestionId);
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer5.updateRememberedValue(objRememberedValue12);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue12, null, false, null, null, AlbumMenuKt.lambda$371978038, gapComposer5, 1572864, 62);
                                                                                    boolean zChangedInstance3 = gapComposer5.changedInstance(listenTogetherManager4) | gapComposer5.changed(suggestionReceivedPayload2);
                                                                                    Object objRememberedValue13 = gapComposer5.rememberedValue();
                                                                                    if (zChangedInstance3 || objRememberedValue13 == neverEqualPolicy2) {
                                                                                        objRememberedValue13 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$4$1$1$2$2$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                                                                                suggestionId.getClass();
                                                                                                listenTogetherManager4.client.rejectSuggestion(suggestionId, "Rejected by host");
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer5.updateRememberedValue(objRememberedValue13);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue13, null, false, null, null, AlbumMenuKt.lambda$1719691565, gapComposer5, 1572864, 62);
                                                                                    gapComposer5.end(true);
                                                                                    gapComposer5.end(true);
                                                                                } else {
                                                                                    gapComposer5.skipToGroupEnd();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, gapComposer4), gapComposer4, 12582918, 120);
                                                                        gapComposer4.end(false);
                                                                    }
                                                                    break;
                                                            }
                                                            return unit;
                                                        }
                                                    }));
                                                }
                                            }
                                            if (z4) {
                                                State state3 = mutableStateCollectAsStateWithLifecycle5;
                                                if (!((List) state3.getValue()).isEmpty()) {
                                                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.f228lambda$548999849, 3);
                                                    final List list2 = (List) state3.getValue();
                                                    lazyListIntervalContent.items(list2.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 9), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$lambda$36$0$2$$inlined$items$default$4
                                                        @Override // kotlin.jvm.functions.Function4
                                                        public final Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                                                            byte b3 = b;
                                                            Unit unit = Unit.INSTANCE;
                                                            final ListenTogetherManager listenTogetherManager3 = listenTogetherManager2;
                                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                            List list3 = list2;
                                                            switch (b3) {
                                                                case 0:
                                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj3;
                                                                    int iIntValue = ((Number) obj4).intValue();
                                                                    Composer composer2 = (Composer) obj5;
                                                                    int iIntValue2 = ((Number) obj6).intValue();
                                                                    int i4 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                                    if ((iIntValue2 & 48) == 0) {
                                                                        i4 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                                    }
                                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                                        gapComposer3.skipToGroupEnd();
                                                                    } else {
                                                                        final Listentogether.JoinRequestPayload joinRequestPayload = (Listentogether.JoinRequestPayload) list3.get(iIntValue);
                                                                        gapComposer3.startReplaceGroup(-111941755);
                                                                        Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f);
                                                                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                                                                        long j = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
                                                                        SurfaceKt.m337SurfaceT9BRK9s(modifierM136paddingVpY3zN4, roundedCornerShapeM185RoundedCornerShape0680j_4, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.15f, Color.m483getColorSpaceimpl(j)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1817480882, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1
                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Object invoke(Object obj7, Object obj8) {
                                                                                Composer composer3 = (Composer) obj7;
                                                                                int iIntValue3 = ((Number) obj8).intValue();
                                                                                GapComposer gapComposer4 = (GapComposer) composer3;
                                                                                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                                                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                                                                    FlowRowOverflow flowRowOverflow = OffsetKt.SpaceBetween;
                                                                                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                                                                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion2, 12.0f);
                                                                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer4, 54);
                                                                                    int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs);
                                                                                    ComposeUiNode.Companion.getClass();
                                                                                    gapComposer4.startReusableNode();
                                                                                    boolean z5 = gapComposer4.inserting;
                                                                                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                                                                                    if (z5) {
                                                                                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                                                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                                                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                                                    Stack.m390setimpl(gapComposer4, numValueOf, updater$$ExternalSyntheticLambda2);
                                                                                    Stack.m389reconcileimpl(gapComposer4);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                                                                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                                                                                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                                                                                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer4, 54);
                                                                                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, layoutWeightElement);
                                                                                    gapComposer4.startReusableNode();
                                                                                    if (gapComposer4.inserting) {
                                                                                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                                                                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 36.0f);
                                                                                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                                                                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                                                    long j2 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.secondary;
                                                                                    final Listentogether.JoinRequestPayload joinRequestPayload2 = joinRequestPayload;
                                                                                    SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs, roundedCornerShapeM185RoundedCornerShape0680j_5, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1861292683, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1$1$1$1
                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                        public final Object invoke(Object obj9, Object obj10) {
                                                                                            Composer composer4 = (Composer) obj9;
                                                                                            int iIntValue4 = ((Number) obj10).intValue();
                                                                                            GapComposer gapComposer5 = (GapComposer) composer4;
                                                                                            if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                                                                BiasAlignment biasAlignment = Alignment.Companion.Center;
                                                                                                FillElement fillElement = SizeKt.FillWholeMaxSize;
                                                                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                                                                                int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                                                                                                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, fillElement);
                                                                                                ComposeUiNode.Companion.getClass();
                                                                                                gapComposer5.startReusableNode();
                                                                                                if (gapComposer5.inserting) {
                                                                                                    gapComposer5.createNode(LayoutNode.Constructor);
                                                                                                } else {
                                                                                                    gapComposer5.useNode();
                                                                                                }
                                                                                                Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                                                                                Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                                                                Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                                                                                                Stack.m389reconcileimpl(gapComposer5);
                                                                                                Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                                                                                                String username = joinRequestPayload2.getUsername();
                                                                                                username.getClass();
                                                                                                String upperCase = StringsKt.take(1, username).toUpperCase(Locale.ROOT);
                                                                                                upperCase.getClass();
                                                                                                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                                                                                                TextKt.m352TextNvy7gAk(upperCase, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.onSecondary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.titleMedium, gapComposer5, 1572864, 0, 131002);
                                                                                                gapComposer5.end(true);
                                                                                            } else {
                                                                                                gapComposer5.skipToGroupEnd();
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }, gapComposer4), gapComposer4, 12582918, 120);
                                                                                    String username = joinRequestPayload2.getUsername();
                                                                                    username.getClass();
                                                                                    TextKt.m352TextNvy7gAk(username, null, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer4, 1572864, 0, 131002);
                                                                                    gapComposer4.end(true);
                                                                                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer4, 6);
                                                                                    int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, companion2);
                                                                                    gapComposer4.startReusableNode();
                                                                                    if (gapComposer4.inserting) {
                                                                                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                                                                                    final ListenTogetherManager listenTogetherManager4 = listenTogetherManager3;
                                                                                    boolean zChangedInstance2 = gapComposer4.changedInstance(listenTogetherManager4) | gapComposer4.changed(joinRequestPayload2);
                                                                                    Object objRememberedValue12 = gapComposer4.rememberedValue();
                                                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                                                    if (zChangedInstance2 || objRememberedValue12 == neverEqualPolicy2) {
                                                                                        objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1$1$2$1$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String userId = joinRequestPayload2.getUserId();
                                                                                                userId.getClass();
                                                                                                listenTogetherManager4.client.approveJoin(userId);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer4.updateRememberedValue(objRememberedValue12);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue12, null, false, null, null, AlbumMenuKt.lambda$1906328273, gapComposer4, 1572864, 62);
                                                                                    boolean zChangedInstance3 = gapComposer4.changedInstance(listenTogetherManager4) | gapComposer4.changed(joinRequestPayload2);
                                                                                    Object objRememberedValue13 = gapComposer4.rememberedValue();
                                                                                    if (zChangedInstance3 || objRememberedValue13 == neverEqualPolicy2) {
                                                                                        objRememberedValue13 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$3$1$1$2$2$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String userId = joinRequestPayload2.getUserId();
                                                                                                userId.getClass();
                                                                                                listenTogetherManager4.client.rejectJoin(userId, "Rejected by host");
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer4.updateRememberedValue(objRememberedValue13);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue13, null, false, null, null, AlbumMenuKt.lambda$47671034, gapComposer4, 1572864, 62);
                                                                                    gapComposer4.end(true);
                                                                                    gapComposer4.end(true);
                                                                                } else {
                                                                                    gapComposer4.skipToGroupEnd();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, gapComposer3), gapComposer3, 12582918, 120);
                                                                        gapComposer3.end(false);
                                                                    }
                                                                    break;
                                                                default:
                                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj3;
                                                                    int iIntValue3 = ((Number) obj4).intValue();
                                                                    Composer composer3 = (Composer) obj5;
                                                                    int iIntValue4 = ((Number) obj6).intValue();
                                                                    int i5 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                                                                    if ((iIntValue4 & 48) == 0) {
                                                                        i5 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                                    }
                                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                                    if (!gapComposer4.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                                                                        gapComposer4.skipToGroupEnd();
                                                                    } else {
                                                                        final Listentogether.SuggestionReceivedPayload suggestionReceivedPayload = (Listentogether.SuggestionReceivedPayload) list3.get(iIntValue3);
                                                                        gapComposer4.startReplaceGroup(280397609);
                                                                        Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f);
                                                                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                                                                        long j2 = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
                                                                        SurfaceKt.m337SurfaceT9BRK9s(modifierM136paddingVpY3zN5, roundedCornerShapeM185RoundedCornerShape0680j_5, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.15f, Color.m483getColorSpaceimpl(j2)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1968128679, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$4$1
                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Object invoke(Object obj7, Object obj8) throws XmlPullParserException, IOException {
                                                                                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
                                                                                Composer composer4 = (Composer) obj7;
                                                                                int iIntValue5 = ((Number) obj8).intValue();
                                                                                GapComposer gapComposer5 = (GapComposer) composer4;
                                                                                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                                                                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                                                                    FlowRowOverflow flowRowOverflow = OffsetKt.SpaceBetween;
                                                                                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                                                                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion2, 12.0f);
                                                                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer5, 54);
                                                                                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM135padding3ABfNKs);
                                                                                    ComposeUiNode.Companion.getClass();
                                                                                    gapComposer5.startReusableNode();
                                                                                    boolean z5 = gapComposer5.inserting;
                                                                                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
                                                                                    if (z5) {
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda4);
                                                                                    } else {
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                                                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                                                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                                                    Stack.m390setimpl(gapComposer5, numValueOf, updater$$ExternalSyntheticLambda2);
                                                                                    Stack.m389reconcileimpl(gapComposer5);
                                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                                                                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                                                                                    if (1.0f <= 0.0d) {
                                                                                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                                                                    }
                                                                                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true);
                                                                                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer5, 54);
                                                                                    int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, layoutWeightElement);
                                                                                    gapComposer5.startReusableNode();
                                                                                    if (gapComposer5.inserting) {
                                                                                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                                                                                    } else {
                                                                                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer5, updater$$ExternalSyntheticLambda2, gapComposer5);
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                                                                    Painter painterPainterResource = IntMath.painterResource(R.drawable.queue_music, 0, gapComposer5);
                                                                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                                                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda5 = textKt$$ExternalSyntheticLambda3;
                                                                                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion2, 24.0f), ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer5, 440, 0);
                                                                                    if (1.0f <= 0.0d) {
                                                                                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                                                                    }
                                                                                    LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true);
                                                                                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer5, 0);
                                                                                    int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, layoutWeightElement2);
                                                                                    gapComposer5.startReusableNode();
                                                                                    if (gapComposer5.inserting) {
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda5);
                                                                                    } else {
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer5, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer5, updater$$ExternalSyntheticLambda2, gapComposer5);
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                                                                                    final Listentogether.SuggestionReceivedPayload suggestionReceivedPayload2 = suggestionReceivedPayload;
                                                                                    String title = suggestionReceivedPayload2.getTrackInfo().getTitle();
                                                                                    title.getClass();
                                                                                    TextKt.m352TextNvy7gAk(title, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer5, 1572864, 24960, 110522);
                                                                                    String fromUsername = suggestionReceivedPayload2.getFromUsername();
                                                                                    fromUsername.getClass();
                                                                                    TextKt.m352TextNvy7gAk(fromUsername, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer5, 0, 24960, 110586);
                                                                                    gapComposer5.end(true);
                                                                                    gapComposer5.end(true);
                                                                                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer5, 6);
                                                                                    int iHashCode4 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer5.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer5, companion2);
                                                                                    gapComposer5.startReusableNode();
                                                                                    if (gapComposer5.inserting) {
                                                                                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda5);
                                                                                    } else {
                                                                                        gapComposer5.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                                                                                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                                                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer5, updater$$ExternalSyntheticLambda2, gapComposer5);
                                                                                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                                                                                    final ListenTogetherManager listenTogetherManager4 = listenTogetherManager3;
                                                                                    boolean zChangedInstance2 = gapComposer5.changedInstance(listenTogetherManager4) | gapComposer5.changed(suggestionReceivedPayload2);
                                                                                    Object objRememberedValue12 = gapComposer5.rememberedValue();
                                                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                                                    if (zChangedInstance2 || objRememberedValue12 == neverEqualPolicy2) {
                                                                                        objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$4$1$1$2$1$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                                                                                suggestionId.getClass();
                                                                                                ListenTogetherManager listenTogetherManager5 = listenTogetherManager4;
                                                                                                if (listenTogetherManager5.isHost()) {
                                                                                                    listenTogetherManager5.client.approveSuggestion(suggestionId);
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer5.updateRememberedValue(objRememberedValue12);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue12, null, false, null, null, AlbumMenuKt.lambda$371978038, gapComposer5, 1572864, 62);
                                                                                    boolean zChangedInstance3 = gapComposer5.changedInstance(listenTogetherManager4) | gapComposer5.changed(suggestionReceivedPayload2);
                                                                                    Object objRememberedValue13 = gapComposer5.rememberedValue();
                                                                                    if (zChangedInstance3 || objRememberedValue13 == neverEqualPolicy2) {
                                                                                        objRememberedValue13 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$9$1$3$4$1$1$2$2$1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                                                                                suggestionId.getClass();
                                                                                                listenTogetherManager4.client.rejectSuggestion(suggestionId, "Rejected by host");
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer5.updateRememberedValue(objRememberedValue13);
                                                                                    }
                                                                                    CardKt.IconButton((Function0) objRememberedValue13, null, false, null, null, AlbumMenuKt.lambda$1719691565, gapComposer5, 1572864, 62);
                                                                                    gapComposer5.end(true);
                                                                                    gapComposer5.end(true);
                                                                                } else {
                                                                                    gapComposer5.skipToGroupEnd();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, gapComposer4), gapComposer4, 12582918, 120);
                                                                        gapComposer4.end(false);
                                                                    }
                                                                    break;
                                                            }
                                                            return unit;
                                                        }
                                                    }));
                                                }
                                            }
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 2034397456, new AlbumMenuKt$$ExternalSyntheticLambda11(function2, listenTogetherManager2, (byte) 13)), 3);
                                        }
                                    } else {
                                        final MutableState mutableState15 = mutableState6;
                                        final MutableState mutableState16 = mutableState5;
                                        final MutableState mutableState17 = mutableState13;
                                        String str4 = str3;
                                        final MutableState mutableState18 = mutableState14;
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -1244943951, new QueueMenuKt$$ExternalSyntheticLambda9(mutableState15, (Object) mutableState16, mutableState17, (Object) str4, (Object) mutableState18, (byte) 4)), 3);
                                        final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference;
                                        final MutableState mutableState19 = mutableState12;
                                        final String str5 = strStringResource;
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -138243366, new Function3() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda76
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                                Modifier.Companion companion;
                                                float f;
                                                float f2;
                                                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2 = dataStoreKt$rememberPreference$1$1;
                                                State state4 = dataStoreKt$rememberPreference$1$2.$state;
                                                Composer composer2 = (Composer) obj4;
                                                int iIntValue = ((Integer) obj5).intValue();
                                                ((LazyItemScopeImpl) obj3).getClass();
                                                GapComposer gapComposer3 = (GapComposer) composer2;
                                                if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                                    OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion2, 20.0f));
                                                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion2, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                                                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer3, 6);
                                                    int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default);
                                                    ComposeUiNode.Companion.getClass();
                                                    gapComposer3.startReusableNode();
                                                    boolean z5 = gapComposer3.inserting;
                                                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                                                    if (z5) {
                                                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                                                    } else {
                                                        gapComposer3.useNode();
                                                    }
                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                                    Integer numValueOf = Integer.valueOf(iHashCode);
                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                    Stack.m390setimpl(gapComposer3, numValueOf, updater$$ExternalSyntheticLambda2);
                                                    Stack.m389reconcileimpl(gapComposer3);
                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion2, 1.0f);
                                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer3, 6);
                                                    int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth);
                                                    gapComposer3.startReusableNode();
                                                    if (gapComposer3.inserting) {
                                                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                                                    } else {
                                                        gapComposer3.useNode();
                                                    }
                                                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                                                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                                    MutableState mutableState20 = mutableState15;
                                                    boolean zChanged4 = gapComposer3.changed(mutableState20) | gapComposer3.changed(dataStoreKt$rememberPreference$1$2);
                                                    Context context3 = context2;
                                                    boolean zChangedInstance2 = zChanged4 | gapComposer3.changedInstance(context3);
                                                    MutableState mutableState21 = mutableState19;
                                                    boolean zChanged5 = zChangedInstance2 | gapComposer3.changed(mutableState21);
                                                    MutableState mutableState22 = mutableState17;
                                                    boolean zChanged6 = zChanged5 | gapComposer3.changed(mutableState22);
                                                    MutableState mutableState23 = mutableState18;
                                                    boolean zChanged7 = zChanged6 | gapComposer3.changed(mutableState23);
                                                    ListenTogetherManager listenTogetherManager3 = listenTogetherManager2;
                                                    boolean zChangedInstance3 = zChanged7 | gapComposer3.changedInstance(listenTogetherManager3);
                                                    Object objRememberedValue12 = gapComposer3.rememberedValue();
                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                    if (zChangedInstance3 || objRememberedValue12 == neverEqualPolicy2) {
                                                        PlayerMenuKt$$ExternalSyntheticLambda105 playerMenuKt$$ExternalSyntheticLambda105 = new PlayerMenuKt$$ExternalSyntheticLambda105(context3, listenTogetherManager3, mutableState20, dataStoreKt$rememberPreference$1$2, mutableState21, mutableState22, mutableState23, (byte) 0);
                                                        gapComposer3.updateRememberedValue(playerMenuKt$$ExternalSyntheticLambda105);
                                                        objRememberedValue12 = playerMenuKt$$ExternalSyntheticLambda105;
                                                    }
                                                    Function0 function3 = (Function0) objRememberedValue12;
                                                    if (1.0f <= 0.0d) {
                                                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                                    }
                                                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true);
                                                    boolean z6 = (StringsKt.isBlank(StringsKt.trim((String) mutableState20.getValue()).toString()) && StringsKt.isBlank((String) state4.getValue())) ? false : true;
                                                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                    CardKt.Button(function3, layoutWeightElement, z6, null, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, 0L, gapComposer3, 14), null, null, null, null, AlbumMenuKt.f46lambda$1060238256, gapComposer3, 805306368, 488);
                                                    GapComposer gapComposer4 = gapComposer3;
                                                    MutableState mutableState24 = mutableState16;
                                                    if (((String) mutableState24.getValue()).length() == 8) {
                                                        gapComposer4.startReplaceGroup(-1667149980);
                                                        boolean zChanged8 = gapComposer4.changed(mutableState20) | gapComposer4.changed(dataStoreKt$rememberPreference$1$2) | gapComposer4.changedInstance(context3);
                                                        String str6 = str5;
                                                        boolean zChanged9 = zChanged8 | gapComposer4.changed(str6) | gapComposer4.changed(mutableState24) | gapComposer4.changed(mutableState22) | gapComposer4.changed(mutableState21) | gapComposer4.changed(mutableState23) | gapComposer4.changedInstance(listenTogetherManager3);
                                                        Object objRememberedValue13 = gapComposer4.rememberedValue();
                                                        if (zChanged9 || objRememberedValue13 == neverEqualPolicy2) {
                                                            companion = companion2;
                                                            f2 = 16.0f;
                                                            objRememberedValue13 = new PlayerMenuKt$$ExternalSyntheticLambda106(context3, str6, listenTogetherManager3, mutableState20, dataStoreKt$rememberPreference$1$2, mutableState24, mutableState22, mutableState21, mutableState23, (byte) 0);
                                                            mutableState20 = mutableState20;
                                                            gapComposer4.updateRememberedValue(objRememberedValue13);
                                                        } else {
                                                            f2 = 16.0f;
                                                            companion = companion2;
                                                        }
                                                        Function0 function4 = (Function0) objRememberedValue13;
                                                        f = 1.0f;
                                                        if (1.0f <= 0.0d) {
                                                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                                        }
                                                        CardKt.Button(function4, new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true), (StringsKt.isBlank(StringsKt.trim((String) mutableState20.getValue()).toString()) && StringsKt.isBlank((String) state4.getValue())) ? false : true, null, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.secondary, 0L, 0L, gapComposer4, 14), null, null, null, null, AlbumMenuKt.f80lambda$130946667, gapComposer4, 805306368, 488);
                                                        gapComposer4 = gapComposer4;
                                                        gapComposer4.end(false);
                                                    } else {
                                                        companion = companion2;
                                                        f = 1.0f;
                                                        f2 = 16.0f;
                                                        gapComposer4.startReplaceGroup(-1664907006);
                                                        gapComposer4.end(false);
                                                    }
                                                    gapComposer4.end(true);
                                                    GapComposer gapComposer5 = gapComposer4;
                                                    CardKt.TextButton(function2, SizeKt.fillMaxWidth(companion, f), false, null, null, null, AlbumMenuKt.lambda$1258865543, gapComposer5, 805306416, 508);
                                                    gapComposer5.end(true);
                                                    OffsetKt.Spacer(gapComposer5, SizeKt.m145height3ABfNKs(companion, f2));
                                                } else {
                                                    gapComposer3.skipToGroupEnd();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), 3);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            function1 = function0;
                            gapComposer = gapComposer2;
                            gapComposer.updateRememberedValue(objRememberedValue11);
                        } else {
                            gapComposer = gapComposer2;
                            function1 = function0;
                        }
                        DialogKt.ListDialog(function1, null, (Function1) objRememberedValue11, gapComposer, (i3 >> 6) & 14);
                    } else {
                        gapComposer2.startReplaceGroup(-708061574);
                        boolean zChanged4 = gapComposer2.changed(mutableState10) | gapComposer2.changed(mutableState11);
                        Object objRememberedValue12 = gapComposer2.rememberedValue();
                        if (zChanged4 || objRememberedValue12 == neverEqualPolicy) {
                            objRememberedValue12 = new TooltipKt$$ExternalSyntheticLambda2(mutableState10, mutableState11, (byte) 2);
                            gapComposer2.updateRememberedValue(objRememberedValue12);
                        }
                        Function0 function2 = (Function0) objRememberedValue12;
                        boolean zChanged5 = gapComposer2.changed(mutableState11) | gapComposer2.changed(mutableState10) | gapComposer2.changedInstance(listenTogetherManager);
                        Object objRememberedValue13 = gapComposer2.rememberedValue();
                        if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
                            objRememberedValue13 = new MainActivity$$ExternalSyntheticLambda21((Object) mutableState11, (Object) mutableState10, (Object) listenTogetherManager, (byte) 15);
                            gapComposer2.updateRememberedValue(objRememberedValue13);
                        }
                        DialogKt.ListDialog(function2, null, (Function1) objRememberedValue13, gapComposer2, 0);
                        gapComposer2.end(false);
                        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup == null) {
                            return;
                        } else {
                            playerKt$$ExternalSyntheticLambda43 = new PlayerKt$$ExternalSyntheticLambda43(z, mediaMetadata, function0, i, (byte) 2);
                        }
                    }
                }
            } else {
                recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                } else {
                    playerKt$$ExternalSyntheticLambda43 = new PlayerKt$$ExternalSyntheticLambda43(z, mediaMetadata, function1, i, (byte) 1);
                }
            }
            recomposeScopeImplEndRestartGroup.block = playerKt$$ExternalSyntheticLambda43;
        }
        gapComposer = gapComposer2;
        gapComposer.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            playerKt$$ExternalSyntheticLambda43 = new PlayerKt$$ExternalSyntheticLambda43(z, mediaMetadata, function1, i, (byte) 3);
            recomposeScopeImplEndRestartGroup.block = playerKt$$ExternalSyntheticLambda43;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r29v1, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r29v2, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r7v10, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r7v19, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final void PlayerMenu(final MediaMetadata mediaMetadata, final BottomSheetState bottomSheetState, Boolean bool, final Function0 function0, final Function0 function1, Composer composer, int i) {
        Boolean bool2;
        ?? r7;
        MutableState mutableStateCollectAsStateWithLifecycle;
        MutableState mutableStateCollectAsStateWithLifecycle2;
        MutableState mutableStateCollectAsStateWithLifecycle3;
        MutableState mutableStateCollectAsStateWithLifecycle4;
        MutableState mutableStateCollectAsStateWithLifecycle5;
        boolean z;
        MutableState mutableState;
        NavHostController navHostController;
        List list;
        int i2;
        MutableState mutableState2;
        Context context;
        Modifier.Companion companion;
        MutableState mutableState3;
        List list2;
        NavHostController navHostController2;
        MutableState mutableState4;
        int i3;
        int i4;
        boolean z2;
        PlayerConnection playerConnection;
        NeverEqualPolicy neverEqualPolicy;
        ?? r10;
        ?? r8;
        ?? r9;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3;
        boolean z3;
        ?? r11;
        Object queueMenuKt$$ExternalSyntheticLambda5;
        ?? r2;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        function0.getClass();
        function1.getClass();
        ?? r12 = (GapComposer) composer;
        r12.startRestartGroup(-149388496);
        int i5 = i | (r12.changed(mediaMetadata) ? 4 : 2) | (r12.changed(bottomSheetState) ? 32 : 16) | 384 | (r12.changedInstance(function0) ? 2048 : 1024) | (r12.changedInstance(function1) ? 16384 : 8192);
        if (r12.shouldExecute(i5 & 1, (i5 & 9363) != 9362)) {
            Boolean bool3 = Boolean.FALSE;
            List list3 = mediaMetadata.artists;
            String str = mediaMetadata.id;
            NavHostController navHostController3 = (NavHostController) r12.consume(MainActivityKt.LocalNavController);
            Context context2 = (Context) r12.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final MusicDatabase musicDatabase = (MusicDatabase) r12.consume(MainActivityKt.LocalDatabase);
            PlayerConnection playerConnection2 = (PlayerConnection) r12.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = r12.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new QueueMenuKt$$ExternalSyntheticLambda0(mediaMetadata, bottomSheetState, function0, function1, i, (byte) 1);
                    return;
                }
                return;
            }
            MusicService musicService = playerConnection2.service;
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(musicService.getPlayerVolume(), r12);
            boolean zChanged = r12.changed(playerConnection2);
            Object objRememberedValue = r12.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy2) {
                try {
                    objRememberedValue = musicService.castConnectionHandler;
                } catch (Exception unused) {
                    objRememberedValue = null;
                }
                r12.updateRememberedValue(objRememberedValue);
            }
            CastConnectionHandler castConnectionHandler = (CastConnectionHandler) objRememberedValue;
            StateFlowImpl stateFlowImpl = castConnectionHandler != null ? castConnectionHandler.isCasting : null;
            if (stateFlowImpl == null) {
                r12.startReplaceGroup(-845689836);
                r12.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                r12.startReplaceGroup(-1828395635);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl, r12);
                r12.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle == null) {
                r12.startReplaceGroup(-845656944);
                Object objRememberedValue2 = r12.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy2) {
                    objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    r12.updateRememberedValue(objRememberedValue2);
                }
                mutableStateCollectAsStateWithLifecycle = (MutableState) objRememberedValue2;
            } else {
                r12.startReplaceGroup(-1828396341);
            }
            r12.end(false);
            StateFlowImpl stateFlowImpl2 = castConnectionHandler != null ? castConnectionHandler.castVolume : null;
            if (stateFlowImpl2 == null) {
                r12.startReplaceGroup(-845575756);
                r12.end(false);
                mutableStateCollectAsStateWithLifecycle2 = null;
            } else {
                r12.startReplaceGroup(-1828391955);
                mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl2, r12);
                r12.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle2 == null) {
                r12.startReplaceGroup(-845542802);
                Object objRememberedValue3 = r12.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy2) {
                    objRememberedValue3 = Format$$ExternalSyntheticOutline0.m(1.0f, (GapComposer) r12);
                }
                mutableStateCollectAsStateWithLifecycle2 = (ParcelableSnapshotMutableFloatState) objRememberedValue3;
            } else {
                r12.startReplaceGroup(-1828392690);
            }
            r12.end(false);
            MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle2;
            StateFlowImpl stateFlowImpl3 = castConnectionHandler != null ? castConnectionHandler.castDeviceName : null;
            if (stateFlowImpl3 == null) {
                r12.startReplaceGroup(-845451756);
                r12.end(false);
                mutableStateCollectAsStateWithLifecycle3 = null;
            } else {
                r12.startReplaceGroup(-1828387955);
                mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(stateFlowImpl3, r12);
                r12.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle3 == null) {
                r12.startReplaceGroup(-845418616);
                Object objRememberedValue4 = r12.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy2) {
                    objRememberedValue4 = Stack.mutableStateOf$default(null);
                    r12.updateRememberedValue(objRememberedValue4);
                }
                mutableStateCollectAsStateWithLifecycle3 = (MutableState) objRememberedValue4;
            } else {
                r12.startReplaceGroup(-1828388808);
            }
            r12.end(false);
            MutableState mutableState6 = mutableStateCollectAsStateWithLifecycle3;
            Preferences$Key preferences$Key = PreferenceKeysKt.VarispeedKey;
            Boolean bool4 = Boolean.FALSE;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(preferences$Key, bool4, r12, 48);
            final MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.$$delegate_0.song(str), null, r12, 48);
            Object objRememberedValue5 = r12.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(r12);
                r12.updateRememberedValue(objRememberedValue5);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
            DownloadUtil downloadUtil = (DownloadUtil) r12.consume(MainActivityKt.LocalDownloadUtil);
            MutableState mutableState7 = mutableStateCollectAsStateWithLifecycle;
            final MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil.getDownload(str), null, r12, 48);
            MutableState mutableStateCollectAsStateWithLifecycle9 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.delegate.getSpeedDialDao().isPinned(str), bool4, r12, 48);
            boolean zChanged2 = r12.changed(list3);
            Object objRememberedValue6 = r12.rememberedValue();
            Object obj = objRememberedValue6;
            if (zChanged2 || objRememberedValue6 == neverEqualPolicy2) {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list3) {
                    if (((MediaMetadata.Artist) obj2).id != null) {
                        arrayList.add(obj2);
                    }
                }
                r12.updateRememberedValue(arrayList);
                obj = arrayList;
            }
            List list4 = (List) obj;
            Object[] objArr = new Object[0];
            Object objRememberedValue7 = r12.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy2) {
                objRememberedValue7 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 24);
                r12.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState8 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue7, r12, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue8 = r12.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy2) {
                objRememberedValue8 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 25);
                r12.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableState9 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue8, r12, 48);
            final ListenTogetherManager listenTogetherManager = (ListenTogetherManager) r12.consume(MainActivityKt.LocalListenTogetherManager);
            ReadonlyStateFlow readonlyStateFlow = listenTogetherManager != null ? listenTogetherManager.role : null;
            if (readonlyStateFlow == null) {
                r12.startReplaceGroup(-844401259);
                r12.end(false);
                mutableStateCollectAsStateWithLifecycle4 = null;
            } else {
                r12.startReplaceGroup(-1828354068);
                mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(readonlyStateFlow, RoomRole.NONE, r12, 48);
                r12.end(false);
            }
            boolean z4 = (mutableStateCollectAsStateWithLifecycle4 != null ? (RoomRole) mutableStateCollectAsStateWithLifecycle4.getValue() : null) == RoomRole.GUEST;
            ReadonlyStateFlow readonlyStateFlow2 = listenTogetherManager != null ? listenTogetherManager.pendingSuggestions : null;
            EmptyList emptyList = EmptyList.INSTANCE;
            if (readonlyStateFlow2 == null) {
                r12.startReplaceGroup(-844122662);
                r12.end(false);
                mutableStateCollectAsStateWithLifecycle5 = null;
            } else {
                r12.startReplaceGroup(-1828345081);
                mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(readonlyStateFlow2, emptyList, r12, 48);
                r12.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle5 == null) {
                r12.startReplaceGroup(-844056662);
                Object objRememberedValue9 = r12.rememberedValue();
                if (objRememberedValue9 == neverEqualPolicy2) {
                    objRememberedValue9 = Stack.mutableStateOf$default(emptyList);
                    r12.updateRememberedValue(objRememberedValue9);
                }
                mutableStateCollectAsStateWithLifecycle5 = (MutableState) objRememberedValue9;
                z = false;
            } else {
                z = false;
                r12.startReplaceGroup(-1828346362);
            }
            r12.end(z);
            FragmentManager.FragmentIntentSenderContract fragmentIntentSenderContract = new FragmentManager.FragmentIntentSenderContract((byte) 8);
            Object objRememberedValue10 = r12.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy2) {
                objRememberedValue10 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 2);
                r12.updateRememberedValue(objRememberedValue10);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = LifecyclesKt.rememberLauncherForActivityResult(fragmentIntentSenderContract, (Function1) objRememberedValue10, r12, 48);
            boolean zBooleanValue = ((Boolean) mutableState8.getValue()).booleanValue();
            DownloadUtil downloadUtil2 = downloadUtil;
            int i6 = i5 & 14;
            boolean zChangedInstance = (i6 == 4) | r12.changedInstance(musicDatabase);
            Object objRememberedValue11 = r12.rememberedValue();
            if (zChangedInstance || objRememberedValue11 == neverEqualPolicy2) {
                objRememberedValue11 = new QueueMenuKt$QueueMenu$2$1(musicDatabase, mediaMetadata, null, (byte) 1);
                r12.updateRememberedValue(objRememberedValue11);
            }
            Function1 function2 = (Function1) objRememberedValue11;
            boolean z5 = i6 == 4;
            Object objRememberedValue12 = r12.rememberedValue();
            if (z5 || objRememberedValue12 == neverEqualPolicy2) {
                objRememberedValue12 = new QueueMenuKt$QueueMenu$3$1(mediaMetadata, null, (byte) 1);
                r12.updateRememberedValue(objRememberedValue12);
            }
            Function1 function3 = (Function1) objRememberedValue12;
            boolean zChanged3 = r12.changed(mutableState8);
            Object objRememberedValue13 = r12.rememberedValue();
            if (zChanged3 || objRememberedValue13 == neverEqualPolicy2) {
                objRememberedValue13 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState8, (byte) 25);
                r12.updateRememberedValue(objRememberedValue13);
            }
            Boolean bool5 = bool3;
            final MutableState mutableState10 = mutableStateCollectAsStateWithLifecycle5;
            final boolean z6 = z4;
            BiasAlignment.Vertical vertical2 = vertical;
            AlbumMenuKt.AddToPlaylistDialog(zBooleanValue, false, function2, function3, (Function0) objRememberedValue13, null, r12, 0);
            boolean zBooleanValue2 = ((Boolean) mutableState9.getValue()).booleanValue();
            MutableState mutableState11 = mutableState9;
            boolean zChanged4 = r12.changed(mutableState11);
            Object objRememberedValue14 = r12.rememberedValue();
            if (zChanged4 || objRememberedValue14 == neverEqualPolicy2) {
                objRememberedValue14 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState11, (byte) 27);
                r12.updateRememberedValue(objRememberedValue14);
            }
            ListenTogetherDialog((i5 << 3) & 112, r12, mediaMetadata, (Function0) objRememberedValue14, zBooleanValue2);
            Object[] objArr3 = new Object[0];
            Object objRememberedValue15 = r12.rememberedValue();
            if (objRememberedValue15 == neverEqualPolicy2) {
                objRememberedValue15 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 16);
                r12.updateRememberedValue(objRememberedValue15);
            }
            MutableState mutableState12 = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue15, r12, 48);
            if (((Boolean) mutableState12.getValue()).booleanValue()) {
                r12.startReplaceGroup(-843192878);
                boolean zChanged5 = r12.changed(mutableState12);
                Object objRememberedValue16 = r12.rememberedValue();
                if (zChanged5 || objRememberedValue16 == neverEqualPolicy2) {
                    objRememberedValue16 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState12, (byte) 28);
                    r12.updateRememberedValue(objRememberedValue16);
                }
                Function0 function4 = (Function0) objRememberedValue16;
                boolean zChangedInstance2 = r12.changedInstance(list4) | r12.changedInstance(navHostController3) | r12.changed(mutableState12) | ((i5 & 112) == 32) | ((i5 & 57344) == 16384);
                Object objRememberedValue17 = r12.rememberedValue();
                if (zChangedInstance2 || objRememberedValue17 == neverEqualPolicy2) {
                    mutableState = mutableState12;
                    navHostController = navHostController3;
                    list = list4;
                    r2 = 0;
                    queueMenuKt$$ExternalSyntheticLambda5 = new QueueMenuKt$$ExternalSyntheticLambda5(list, navHostController, mutableState, bottomSheetState, function1, (byte) 1);
                    r12.updateRememberedValue(queueMenuKt$$ExternalSyntheticLambda5);
                } else {
                    mutableState = mutableState12;
                    navHostController = navHostController3;
                    list = list4;
                    r2 = 0;
                    queueMenuKt$$ExternalSyntheticLambda5 = objRememberedValue17;
                }
                DialogKt.ListDialog(function4, null, (Function1) queueMenuKt$$ExternalSyntheticLambda5, r12, r2);
                r12.end(r2);
                i2 = r2;
            } else {
                mutableState = mutableState12;
                mutableStateCollectAsStateWithLifecycle9 = mutableStateCollectAsStateWithLifecycle9;
                navHostController = navHostController3;
                list = list4;
                mutableState11 = mutableState11;
                i2 = 0;
                context2 = context2;
                r12.startReplaceGroup(-842147310);
                r12.end(false);
            }
            Object[] objArr4 = new Object[i2];
            Object objRememberedValue18 = r12.rememberedValue();
            if (objRememberedValue18 == neverEqualPolicy2) {
                objRememberedValue18 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 15);
                r12.updateRememberedValue(objRememberedValue18);
            }
            MutableState mutableState13 = (MutableState) SaverKt.rememberSaveable(objArr4, (Function0) objRememberedValue18, r12, 48);
            if (((Boolean) mutableState13.getValue()).booleanValue()) {
                r12.startReplaceGroup(-842025139);
                boolean zChanged6 = r12.changed(mutableState13);
                Object objRememberedValue19 = r12.rememberedValue();
                if (zChanged6 || objRememberedValue19 == neverEqualPolicy2) {
                    objRememberedValue19 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState13, (byte) 29);
                    r12.updateRememberedValue(objRememberedValue19);
                }
                TempoPitchDialog((Function0) objRememberedValue19, r12, i2);
                r12.end(i2);
            } else {
                r12.startReplaceGroup(-841928078);
                r12.end(i2);
            }
            Object[] objArr5 = new Object[i2];
            Object objRememberedValue20 = r12.rememberedValue();
            if (objRememberedValue20 == neverEqualPolicy2) {
                objRememberedValue20 = new AlbumMenuKt$$ExternalSyntheticLambda3((byte) 17);
                r12.updateRememberedValue(objRememberedValue20);
            }
            MutableState mutableState14 = (MutableState) SaverKt.rememberSaveable(objArr5, (Function0) objRememberedValue20, r12, 48);
            if (((Boolean) mutableState14.getValue()).booleanValue()) {
                r12.startReplaceGroup(-841816137);
                boolean zChanged7 = r12.changed(mutableState14);
                Object objRememberedValue21 = r12.rememberedValue();
                if (zChanged7 || objRememberedValue21 == neverEqualPolicy2) {
                    objRememberedValue21 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState14, (byte) 2);
                    r12.updateRememberedValue(objRememberedValue21);
                }
                SpeedDialog((Function0) objRememberedValue21, r12, i2);
                r12.end(i2);
            } else {
                r12.startReplaceGroup(-841728686);
                r12.end(i2);
            }
            boolean zAreEqual = Intrinsics.areEqual(bool5, Boolean.TRUE);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            if (zAreEqual) {
                mutableState13 = mutableState13;
                mutableState2 = mutableStateCollectAsStateWithLifecycle9;
                context = context2;
                companion = companion2;
                bool5 = bool5;
                mutableState3 = mutableState14;
                list2 = list;
                navHostController2 = navHostController;
                mutableState4 = mutableState;
                i3 = i6;
                i4 = i5;
                mutableState11 = mutableState11;
                downloadUtil2 = downloadUtil2;
                z2 = true;
                playerConnection = playerConnection2;
                neverEqualPolicy = neverEqualPolicy2;
                ?? r13 = i2;
                r12.startReplaceGroup(-839657390);
                r12.end(r13);
                r8 = r12;
                r10 = r13;
            } else {
                r12.startReplaceGroup(-841631284);
                Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion2, 1.0f), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, 5);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, r12, i2);
                Context context3 = context2;
                int iHashCode = Long.hashCode(r12.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = r12.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(r12, modifierM139paddingqDBjuR0$default);
                ComposeUiNode.Companion.getClass();
                r12.startReusableNode();
                boolean z7 = r12.inserting;
                context = context3;
                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
                if (z7) {
                    r12.createNode(textKt$$ExternalSyntheticLambda4);
                } else {
                    r12.useNode();
                }
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetMeasurePolicy;
                Stack.m390setimpl(r12, columnMeasurePolicy, updater$$ExternalSyntheticLambda4);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Stack.m390setimpl(r12, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda5);
                Integer numValueOf = Integer.valueOf(iHashCode);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetCompositeKeyHash;
                Stack.m390setimpl(r12, numValueOf, updater$$ExternalSyntheticLambda6);
                Stack.m389reconcileimpl(r12);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetModifier;
                Stack.m390setimpl(r12, modifierMaterializeModifier, updater$$ExternalSyntheticLambda7);
                if (!((Boolean) mutableState7.getValue()).booleanValue() || ((String) mutableState6.getValue()) == null) {
                    mutableState2 = mutableStateCollectAsStateWithLifecycle9;
                    updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda7;
                    updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda6;
                    companion = companion2;
                    updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda5;
                    textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                    mutableState3 = mutableState14;
                    list2 = list;
                    navHostController2 = navHostController;
                    mutableState4 = mutableState;
                    updater$$ExternalSyntheticLambda3 = updater$$ExternalSyntheticLambda4;
                    i3 = i6;
                    i4 = i5;
                    z2 = true;
                    z3 = false;
                    r12.startReplaceGroup(-1736645432);
                    r12.end(false);
                    r11 = r12;
                } else {
                    r12.startReplaceGroup(-1737582841);
                    FlowRowOverflow flowRowOverflow = OffsetKt.Center;
                    Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion2, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7);
                    MutableState mutableState15 = mutableStateCollectAsStateWithLifecycle9;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical2, r12, 54);
                    int iHashCode2 = Long.hashCode(r12.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = r12.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(r12, modifierM139paddingqDBjuR0$default2);
                    r12.startReusableNode();
                    if (r12.inserting) {
                        r12.createNode(textKt$$ExternalSyntheticLambda4);
                    } else {
                        r12.useNode();
                    }
                    Stack.m390setimpl(r12, rowMeasurePolicy, updater$$ExternalSyntheticLambda4);
                    Stack.m390setimpl(r12, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda5);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, (GapComposer) r12, updater$$ExternalSyntheticLambda6, (GapComposer) r12);
                    Stack.m390setimpl(r12, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda7);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.cast, 0, r12);
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 24.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda6;
                    updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda5;
                    updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda7;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, modifierM151size3ABfNKs, ((MaterialTheme$Values) r12.consume(staticProvidableCompositionLocal)).colorScheme.primary, (Composer) r12, 440, 0);
                    OffsetKt.Spacer(r12, SizeKt.m155width3ABfNKs(companion2, 10.0f));
                    String str2 = (String) mutableState6.getValue();
                    if (str2 == null) {
                        str2 = "";
                    }
                    companion = companion2;
                    mutableState3 = mutableState14;
                    mutableState2 = mutableState15;
                    vertical2 = vertical2;
                    list2 = list;
                    navHostController2 = navHostController;
                    mutableState4 = mutableState;
                    updater$$ExternalSyntheticLambda3 = updater$$ExternalSyntheticLambda4;
                    i3 = i6;
                    textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                    i4 = i5;
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.casting_to, new Object[]{str2}, r12), null, ((MaterialTheme$Values) r12.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) r12.consume(staticProvidableCompositionLocal)).typography.bodyMedium, r12, 0, 0, 131066);
                    ?? r14 = r12;
                    z2 = true;
                    r14.end(true);
                    z3 = false;
                    r14.end(false);
                    r11 = r14;
                }
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical2, r11, 48);
                int iHashCode3 = Long.hashCode(r11.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = r11.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(r11, modifierFillMaxWidth);
                r11.startReusableNode();
                if (r11.inserting) {
                    r11.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    r11.useNode();
                }
                Stack.m390setimpl(r11, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(r11, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, (GapComposer) r11, updater$$ExternalSyntheticLambda1, (GapComposer) r11);
                Stack.m390setimpl(r11, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                float fFloatValue = ((Boolean) mutableState7.getValue()).booleanValue() ? ((Number) mutableState5.getValue()).floatValue() : ((Number) mutableStateCollectAsStateWithLifecycle6.getValue()).floatValue();
                playerConnection = playerConnection2;
                boolean zChanged8 = r11.changed(mutableState7) | r11.changedInstance(castConnectionHandler) | r11.changedInstance(playerConnection);
                Object objRememberedValue22 = r11.rememberedValue();
                neverEqualPolicy = neverEqualPolicy2;
                if (zChanged8 || objRememberedValue22 == neverEqualPolicy) {
                    objRememberedValue22 = new SongMenuKt$$ExternalSyntheticLambda4(castConnectionHandler, playerConnection, mutableState7);
                    r11.updateRememberedValue(objRememberedValue22);
                }
                MenuKt.m1495VolumeSliderV9fs2A(fFloatValue, (Function1) objRememberedValue22, new LayoutWeightElement(1.0f, z2), false, ((MaterialTheme$Values) r11.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, r11, 0);
                Fragment$5$$ExternalSyntheticOutline0.m((GapComposer) r11, z2, z2, z3);
                r8 = r11;
                r10 = z3;
            }
            OffsetKt.Spacer(r8, SizeKt.m145height3ABfNKs(companion, 20.0f));
            ?? r29 = r8;
            CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, r29, 0, 7);
            OffsetKt.Spacer(r29, SizeKt.m145height3ABfNKs(companion, 12.0f));
            int i7 = ((Configuration) r29.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).orientation;
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.asPaddingValues(OffsetKt.current(r29).systemBars, r29).mo122calculateBottomPaddingD9Ej5fM() + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO);
            final Context context4 = context;
            int i8 = i4;
            final List list5 = list2;
            final NavHostController navHostController4 = navHostController2;
            final MutableState mutableState16 = mutableState4;
            final MutableState mutableState17 = mutableState2;
            final DownloadUtil downloadUtil3 = downloadUtil2;
            boolean z8 = ((((((((((((((((((r29.changed(z6) ? 1 : 0) | (r29.changedInstance(context4) ? 1 : 0)) | (r29.changedInstance(playerConnection) ? 1 : 0) ? 1 : 0) | ((i8 & 57344) == 16384 ? z2 : r10)) | (r29.changed(mutableState8) ? 1 : 0)) == true ? 1 : 0) | (i3 == 4 ? z2 : r10)) | (r29.changedInstance(list5) ? 1 : 0)) == true ? 1 : 0) | (r29.changedInstance(navHostController4) ? 1 : 0)) | ((i8 & 112) == 32 ? z2 : r10)) == true ? 1 : 0) | (r29.changed(mutableState16) ? 1 : 0)) | (r29.changed(mutableStateCollectAsStateWithLifecycle7) ? 1 : 0) ? 1 : 0) | (r29.changed(mutableState17) ? 1 : 0)) | (r29.changedInstance(coroutineScope) ? 1 : 0) ? 1 : 0) | (r29.changedInstance(musicDatabase) ? 1 : 0)) | (r29.changed(mutableStateCollectAsStateWithLifecycle8) ? 1 : 0) ? 1 : 0) | (r29.changedInstance(downloadUtil3) ? 1 : 0) | (r29.changed(mutableState10) ? 1 : 0);
            final MutableState mutableState18 = mutableState11;
            final MutableState mutableState19 = mutableState3;
            boolean z9 = ((((((((z8 ? 1 : 0) | (r29.changed(mutableState18) ? 1 : 0)) | (r29.changedInstance(listenTogetherManager) ? 1 : 0) ? 1 : 0) | ((i8 & 7168) == 2048 ? (char) 1 : (char) 0)) | (r29.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) ? 1 : 0)) == true ? 1 : 0) | (r29.changed(dataStoreKt$rememberPreference$1$1RememberPreference) ? 1 : 0)) | (r29.changed(mutableState13) ? 1 : 0) ? 1 : 0) | (r29.changed(mutableState19) ? 1 : 0);
            Object objRememberedValue23 = r29.rememberedValue();
            if (z9 != 0 || objRememberedValue23 == neverEqualPolicy) {
                final PlayerConnection playerConnection3 = playerConnection;
                final MutableState mutableState20 = mutableState13;
                objRememberedValue23 = new Function1() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj3;
                        lazyListIntervalContent.getClass();
                        boolean z10 = z6;
                        Context context5 = context4;
                        PlayerConnection playerConnection4 = playerConnection3;
                        Function0 function5 = function1;
                        MutableState mutableState21 = mutableState8;
                        MediaMetadata mediaMetadata2 = mediaMetadata;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1962424709, new AlbumMenuKt$$ExternalSyntheticLambda16(z10, context5, playerConnection4, function5, mutableState21, mediaMetadata2)), 3);
                        List list6 = list5;
                        NavHostController navHostController5 = navHostController4;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -953589700, new PlayerMenuKt$$ExternalSyntheticLambda17(mediaMetadata2, list6, navHostController5, bottomSheetState, function5, mutableState16, playerConnection4, coroutineScope, mutableState17, musicDatabase, mutableStateCollectAsStateWithLifecycle7)), 3);
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1255534781, 3);
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -830308034, new QueueMenuKt$$ExternalSyntheticLambda11(context5, mediaMetadata2, downloadUtil3, mutableStateCollectAsStateWithLifecycle8, (byte) 1)), 3);
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1378816447, 3);
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -707026368, new SongMenuKt$$ExternalSyntheticLambda32(mutableState18, z10, listenTogetherManager, function5, mutableState10)), 3);
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1502098113, 3);
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -583744702, new LyricsMenuKt$$ExternalSyntheticLambda0(function0, function5, navHostController5, playerConnection4, context5, managedActivityResultLauncherRememberLauncherForActivityResult, dataStoreKt$rememberPreference$1$1RememberPreference, mutableState20, mutableState19)), 3);
                        return Unit.INSTANCE;
                    }
                };
                ?? r15 = r29;
                r15.updateRememberedValue(objRememberedValue23);
                r9 = r15;
            } else {
                r9 = r29;
            }
            ?? r210 = r9;
            IntMath.LazyColumn(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue23, r210, 0, 507);
            r7 = r210;
            bool2 = bool5;
        } else {
            r12.skipToGroupEnd();
            bool2 = bool;
            r7 = r12;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = r7.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new PlayerKt$$ExternalSyntheticLambda92(mediaMetadata, bottomSheetState, bool2, function0, function1, i, (byte) 5);
        }
    }

    public static final void SpeedDialog(Function0 function0, Composer composer, int i) {
        GapComposer gapComposer;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-799805027);
        int i2 = (gapComposer2.changedInstance(function0) ? 4 : 2) | i;
        final byte b = 0;
        final byte b2 = 1;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, (byte) 5);
                    return;
                }
                return;
            }
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Format$$ExternalSyntheticOutline0.m(playerConnection.getPlayerSafe().getPlaybackParameters().speed, gapComposer2);
            }
            final ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue;
            boolean zChangedInstance = gapComposer2.changedInstance(playerConnection);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(playerConnection, parcelableSnapshotMutableFloatState, (byte) 17);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            final Function0 function1 = (Function0) objRememberedValue2;
            gapComposer = gapComposer2;
            CardKt.m251AlertDialogOix01E0(function0, Expect_jvmKt.rememberComposableLambda(-45212075, new MainActivity$$ExternalSyntheticLambda39(function0, (byte) 6), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(1852284691, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = b;
                    Unit unit = Unit.INSTANCE;
                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                    ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = parcelableSnapshotMutableFloatState;
                    Function0 function2 = function1;
                    switch (b3) {
                        case 0:
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer3 = (GapComposer) composer2;
                            if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                gapComposer3.skipToGroupEnd();
                            } else {
                                boolean zChanged = gapComposer3.changed(function2);
                                Object objRememberedValue3 = gapComposer3.rememberedValue();
                                if (zChanged || objRememberedValue3 == neverEqualPolicy2) {
                                    objRememberedValue3 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(function2, parcelableSnapshotMutableFloatState2, (byte) 18);
                                    gapComposer3.updateRememberedValue(objRememberedValue3);
                                }
                                CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AlbumMenuKt.lambda$166730358, gapComposer3, 805306368, 510);
                            }
                            break;
                        default:
                            Composer composer3 = (Composer) obj;
                            int iIntValue2 = ((Integer) obj2).intValue();
                            GapComposer gapComposer4 = (GapComposer) composer3;
                            if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                gapComposer4.skipToGroupEnd();
                            } else {
                                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer4, 0);
                                int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                                ComposeUiNode.Companion.getClass();
                                gapComposer4.startReusableNode();
                                if (gapComposer4.inserting) {
                                    gapComposer4.createNode(LayoutNode.Constructor);
                                } else {
                                    gapComposer4.useNode();
                                }
                                Stack.m390setimpl(gapComposer4, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                Stack.m389reconcileimpl(gapComposer4);
                                Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                Float fValueOf = Float.valueOf(parcelableSnapshotMutableFloatState2.getFloatValue());
                                IntRange intRange = new IntRange(0, 35, 1);
                                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
                                Iterator it = intRange.iterator();
                                while (((IntProgressionIterator) it).hasNext) {
                                    arrayList.add(Float.valueOf(((float) Math.rint(((((IntIterator) it).nextInt() * 0.05f) + 0.25f) * 100.0f)) / 100.0f));
                                }
                                boolean zChanged2 = gapComposer4.changed(function2);
                                Object objRememberedValue4 = gapComposer4.rememberedValue();
                                if (zChanged2 || objRememberedValue4 == neverEqualPolicy2) {
                                    objRememberedValue4 = new PlayerMenuKt$$ExternalSyntheticLambda78(function2, parcelableSnapshotMutableFloatState2, (byte) 0);
                                    gapComposer4.updateRememberedValue(objRememberedValue4);
                                }
                                Function1 function3 = (Function1) objRememberedValue4;
                                Object objRememberedValue5 = gapComposer4.rememberedValue();
                                if (objRememberedValue5 == neverEqualPolicy2) {
                                    objRememberedValue5 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 4);
                                    gapComposer4.updateRememberedValue(objRememberedValue5);
                                }
                                PlayerMenuKt.ValueAdjuster(R.drawable.speed, fValueOf, arrayList, function3, (Function1) objRememberedValue5, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 7), gapComposer4, 221184, 0);
                                gapComposer4.end(true);
                            }
                            break;
                    }
                    return unit;
                }
            }, gapComposer2), null, AlbumMenuKt.f227lambda$545185839, Expect_jvmKt.rememberComposableLambda(-1743921104, new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = b2;
                    Unit unit = Unit.INSTANCE;
                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                    ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = parcelableSnapshotMutableFloatState;
                    Function0 function2 = function1;
                    switch (b3) {
                        case 0:
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer3 = (GapComposer) composer2;
                            if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                gapComposer3.skipToGroupEnd();
                            } else {
                                boolean zChanged = gapComposer3.changed(function2);
                                Object objRememberedValue3 = gapComposer3.rememberedValue();
                                if (zChanged || objRememberedValue3 == neverEqualPolicy2) {
                                    objRememberedValue3 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(function2, parcelableSnapshotMutableFloatState2, (byte) 18);
                                    gapComposer3.updateRememberedValue(objRememberedValue3);
                                }
                                CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AlbumMenuKt.lambda$166730358, gapComposer3, 805306368, 510);
                            }
                            break;
                        default:
                            Composer composer3 = (Composer) obj;
                            int iIntValue2 = ((Integer) obj2).intValue();
                            GapComposer gapComposer4 = (GapComposer) composer3;
                            if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                gapComposer4.skipToGroupEnd();
                            } else {
                                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer4, 0);
                                int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                                ComposeUiNode.Companion.getClass();
                                gapComposer4.startReusableNode();
                                if (gapComposer4.inserting) {
                                    gapComposer4.createNode(LayoutNode.Constructor);
                                } else {
                                    gapComposer4.useNode();
                                }
                                Stack.m390setimpl(gapComposer4, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                Stack.m389reconcileimpl(gapComposer4);
                                Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                Float fValueOf = Float.valueOf(parcelableSnapshotMutableFloatState2.getFloatValue());
                                IntRange intRange = new IntRange(0, 35, 1);
                                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
                                Iterator it = intRange.iterator();
                                while (((IntProgressionIterator) it).hasNext) {
                                    arrayList.add(Float.valueOf(((float) Math.rint(((((IntIterator) it).nextInt() * 0.05f) + 0.25f) * 100.0f)) / 100.0f));
                                }
                                boolean zChanged2 = gapComposer4.changed(function2);
                                Object objRememberedValue4 = gapComposer4.rememberedValue();
                                if (zChanged2 || objRememberedValue4 == neverEqualPolicy2) {
                                    objRememberedValue4 = new PlayerMenuKt$$ExternalSyntheticLambda78(function2, parcelableSnapshotMutableFloatState2, (byte) 0);
                                    gapComposer4.updateRememberedValue(objRememberedValue4);
                                }
                                Function1 function3 = (Function1) objRememberedValue4;
                                Object objRememberedValue5 = gapComposer4.rememberedValue();
                                if (objRememberedValue5 == neverEqualPolicy2) {
                                    objRememberedValue5 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 4);
                                    gapComposer4.updateRememberedValue(objRememberedValue5);
                                }
                                PlayerMenuKt.ValueAdjuster(R.drawable.speed, fValueOf, arrayList, function3, (Function1) objRememberedValue5, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 7), gapComposer4, 221184, 0);
                                gapComposer4.end(true);
                            }
                            break;
                    }
                    return unit;
                }
            }, gapComposer2), null, 0L, 0L, 0L, 0L, new DialogProperties(3), gapComposer, (i2 & 14) | 1772592, 3072, 8084);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, (byte) 7);
        }
    }

    public static final void TempoPitchDialog(Function0 function0, Composer composer, int i) {
        GapComposer gapComposer;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(509733719);
        byte b = 2;
        int i2 = (gapComposer2.changedInstance(function0) ? 4 : 2) | i;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, b);
                    return;
                }
                return;
            }
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Format$$ExternalSyntheticOutline0.m(playerConnection.getPlayerSafe().getPlaybackParameters().speed, gapComposer2);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Fragment$5$$ExternalSyntheticOutline0.m((int) Math.rint(((float) (Math.log(playerConnection.getPlayerSafe().getPlaybackParameters().pitch) / Constants.LN2)) * 12.0f), gapComposer2);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue2;
            boolean zChangedInstance = gapComposer2.changedInstance(playerConnection);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new GapComposer$$ExternalSyntheticLambda0(playerConnection, parcelableSnapshotMutableFloatState, parcelableSnapshotMutableIntState, (byte) 17);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            Function0 function1 = (Function0) objRememberedValue3;
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
            gapComposer = gapComposer2;
            CardKt.m251AlertDialogOix01E0(function0, Expect_jvmKt.rememberComposableLambda(1289679263, new MainActivity$$ExternalSyntheticLambda39(function0, (byte) 3), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(1408120737, new MainActivity$$ExternalSyntheticLambda9(function1, parcelableSnapshotMutableFloatState, parcelableSnapshotMutableIntState, (byte) 24), gapComposer2), null, AlbumMenuKt.lambda$1526562211, Expect_jvmKt.rememberComposableLambda(1585782948, new PlayerKt$$ExternalSyntheticLambda84((byte) 5, (Object) function1, (Object) parcelableSnapshotMutableFloatState, (Object) parcelableSnapshotMutableIntState, listenTogetherManager != null ? listenTogetherManager.client.isInRoom() : false), gapComposer2), null, 0L, 0L, 0L, 0L, new DialogProperties(3), gapComposer, (i2 & 14) | 1772592, 3072, 8084);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, (byte) 4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:35:0x007a  */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0080  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:45:0x0108  */
    /* JADX WARN: Code duplicated, block: B:46:0x010a  */
    /* JADX WARN: Code duplicated, block: B:49:0x010f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0111  */
    /* JADX WARN: Code duplicated, block: B:53:0x0119  */
    /* JADX WARN: Code duplicated, block: B:54:0x011b  */
    /* JADX WARN: Code duplicated, block: B:60:0x012a  */
    /* JADX WARN: Code duplicated, block: B:63:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:67:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:68:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x0201  */
    /* JADX WARN: Code duplicated, block: B:82:0x020a  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    public static final void ValueAdjuster(final int i, final Number number, final List list, final Function1 function1, final Function1 function2, Modifier modifier, Composer composer, final int i2, final int i3) {
        final Modifier modifier2;
        boolean z;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier3;
        final byte b;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        Object objRememberedValue;
        final byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        int i7;
        Object objRememberedValue2;
        function1.getClass();
        function2.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1866995609);
        int i8 = i2 | (gapComposer.changed(i) ? 4 : 2) | (gapComposer.changed(number) ? 32 : 16) | (gapComposer.changed(list) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024);
        int i9 = i3 & 32;
        if (i9 == 0) {
            if ((i2 & 196608) == 0) {
                modifier2 = modifier;
                i8 |= gapComposer.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i8) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i8 & 1, z)) {
                companion = Modifier.Companion.$$INSTANCE;
                if (i9 != 0) {
                    modifier3 = companion;
                } else {
                    modifier3 = modifier2;
                }
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(24.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer, 54);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier3);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                Modifier modifier4 = modifier3;
                b = 1;
                IconKt.m290Iconww6aTOc(IntMath.painterResource(i, i8 & 14, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 28.0f), 0L, gapComposer, 440, 8);
                boolean z6 = !number.equals(CollectionsKt.first(list));
                i4 = i8 & 7168;
                if (i4 == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i5 = i8 & 896;
                if (i5 != 256) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                boolean z7 = z3 | z2;
                i6 = i8 & 112;
                if (i6 != 32) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                z5 = z7 | z4;
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (!z5 || objRememberedValue == neverEqualPolicy) {
                    b2 = 0;
                    objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda94
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b7 = b2;
                            Unit unit = Unit.INSTANCE;
                            Number number2 = number;
                            List list2 = list;
                            Function1 function3 = function1;
                            switch (b7) {
                                case 0:
                                    function3.invoke(list2.get(list2.indexOf(number2) - 1));
                                    break;
                                default:
                                    function3.invoke(list2.get(list2.indexOf(number2) + 1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    b2 = 0;
                }
                b3 = b2;
                CardKt.IconButton((Function0) objRememberedValue, null, z6, null, null, AlbumMenuKt.lambda$612623771, gapComposer, 1572864, 58);
                TextKt.m352TextNvy7gAk((String) function2.invoke(number), SizeKt.m155width3ABfNKs(companion, 80.0f), 0L, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 48, 0, 130044);
                gapComposer = gapComposer;
                boolean z8 = !number.equals(CollectionsKt.last(list));
                if (i4 == 2048) {
                    b4 = 1;
                } else {
                    b4 = b3;
                }
                if (i5 != 256) {
                    b5 = b3;
                } else {
                    b5 = 1;
                }
                int i10 = b5 | b4;
                if (i6 != 32) {
                    b6 = b3;
                } else {
                    b6 = 1;
                }
                i7 = i10 | b6;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (i7 == 0 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda94
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b7 = b;
                            Unit unit = Unit.INSTANCE;
                            Number number2 = number;
                            List list2 = list;
                            Function1 function3 = function1;
                            switch (b7) {
                                case 0:
                                    function3.invoke(list2.get(list2.indexOf(number2) - 1));
                                    break;
                                default:
                                    function3.invoke(list2.get(list2.indexOf(number2) + 1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                CardKt.IconButton((Function0) objRememberedValue2, null, z8, null, null, AlbumMenuKt.lambda$1551083922, gapComposer, 1572864, 58);
                gapComposer.end(true);
                modifier2 = modifier4;
            } else {
                gapComposer.skipToGroupEnd();
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda96
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        PlayerMenuKt.ValueAdjuster(i, number, list, function1, function2, modifier2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i8 |= 196608;
        modifier2 = modifier;
        if ((74899 & i8) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i8 & 1, z)) {
            companion = Modifier.Companion.$$INSTANCE;
            if (i9 != 0) {
                modifier3 = companion;
            } else {
                modifier3 = modifier2;
            }
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(24.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer, 54);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifier3);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            Modifier modifier5 = modifier3;
            b = 1;
            IconKt.m290Iconww6aTOc(IntMath.painterResource(i, i8 & 14, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 28.0f), 0L, gapComposer, 440, 8);
            boolean z9 = !number.equals(CollectionsKt.first(list));
            i4 = i8 & 7168;
            if (i4 == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            i5 = i8 & 896;
            if (i5 != 256) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean z10 = z3 | z2;
            i6 = i8 & 112;
            if (i6 != 32) {
                z4 = false;
            } else {
                z4 = true;
            }
            z5 = z10 | z4;
            objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (z5) {
                b2 = 0;
                objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda94
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b7 = b2;
                        Unit unit = Unit.INSTANCE;
                        Number number2 = number;
                        List list2 = list;
                        Function1 function3 = function1;
                        switch (b7) {
                            case 0:
                                function3.invoke(list2.get(list2.indexOf(number2) - 1));
                                break;
                            default:
                                function3.invoke(list2.get(list2.indexOf(number2) + 1));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                b2 = 0;
                objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda94
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b7 = b2;
                        Unit unit = Unit.INSTANCE;
                        Number number2 = number;
                        List list2 = list;
                        Function1 function3 = function1;
                        switch (b7) {
                            case 0:
                                function3.invoke(list2.get(list2.indexOf(number2) - 1));
                                break;
                            default:
                                function3.invoke(list2.get(list2.indexOf(number2) + 1));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            b3 = b2;
            CardKt.IconButton((Function0) objRememberedValue, null, z9, null, null, AlbumMenuKt.lambda$612623771, gapComposer, 1572864, 58);
            TextKt.m352TextNvy7gAk((String) function2.invoke(number), SizeKt.m155width3ABfNKs(companion, 80.0f), 0L, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 48, 0, 130044);
            gapComposer = gapComposer;
            boolean z11 = !number.equals(CollectionsKt.last(list));
            if (i4 == 2048) {
                b4 = 1;
            } else {
                b4 = b3;
            }
            if (i5 != 256) {
                b5 = b3;
            } else {
                b5 = 1;
            }
            int i11 = b5 | b4;
            if (i6 != 32) {
                b6 = b3;
            } else {
                b6 = 1;
            }
            i7 = i11 | b6;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (i7 == 0) {
                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda94
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b7 = b;
                        Unit unit = Unit.INSTANCE;
                        Number number2 = number;
                        List list2 = list;
                        Function1 function3 = function1;
                        switch (b7) {
                            case 0:
                                function3.invoke(list2.get(list2.indexOf(number2) - 1));
                                break;
                            default:
                                function3.invoke(list2.get(list2.indexOf(number2) + 1));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda94
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b7 = b;
                        Unit unit = Unit.INSTANCE;
                        Number number2 = number;
                        List list2 = list;
                        Function1 function3 = function1;
                        switch (b7) {
                            case 0:
                                function3.invoke(list2.get(list2.indexOf(number2) - 1));
                                break;
                            default:
                                function3.invoke(list2.get(list2.indexOf(number2) + 1));
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CardKt.IconButton((Function0) objRememberedValue2, null, z11, null, null, AlbumMenuKt.lambda$1551083922, gapComposer, 1572864, 58);
            gapComposer.end(true);
            modifier2 = modifier5;
        } else {
            gapComposer.skipToGroupEnd();
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda96
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    PlayerMenuKt.ValueAdjuster(i, number, list, function1, function2, modifier2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
