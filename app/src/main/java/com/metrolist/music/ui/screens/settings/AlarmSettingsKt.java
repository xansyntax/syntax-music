package com.metrolist.music.ui.screens.settings;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TimePickerStateImpl;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.palette.graphics.ColorCutQuantizer;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.App$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda17;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda6;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.playback.alarm.MusicAlarmStore$loadBlocking$1;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.Material3SettingsItem;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda22;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.yalantis.ucrop.R;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AlarmSettingsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void AlarmEditorDialog(MusicAlarmEntry musicAlarmEntry, List list, List list2, Function0 function0, Function1 function1, Composer composer, int i) {
        GapComposer gapComposer;
        boolean z;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        byte b;
        MutableState mutableState;
        MutableState mutableState2;
        Locale locale;
        GapComposer gapComposer2;
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(-15933910);
        int i2 = i | (gapComposer3.changed(musicAlarmEntry) ? 4 : 2) | (gapComposer3.changed(list) ? 32 : 16) | (gapComposer3.changed(list2) ? 256 : 128) | (gapComposer3.changedInstance(function1) ? 16384 : 8192);
        if (gapComposer3.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            Context context = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Locale locale2 = ((androidx.compose.ui.text.intl.Locale) gapComposer3.consume(CompositionLocalsKt.LocalLocale)).platformLocale;
            String strStringResource = MathKt.stringResource(R.string.alarm_no_playlists, gapComposer3);
            String strStringResource2 = MathKt.stringResource(R.string.alarm_select_playlist, gapComposer3);
            Object objRememberedValue = gapComposer3.rememberedValue();
            Object obj = Composer.Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (objRememberedValue3 == obj) {
                objRememberedValue3 = Stack.mutableStateOf$default(Boolean.valueOf(musicAlarmEntry != null ? musicAlarmEntry.enabled : true));
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (objRememberedValue4 == obj) {
                objRememberedValue4 = Fragment$5$$ExternalSyntheticOutline0.m(musicAlarmEntry != null ? musicAlarmEntry.hour : 7, gapComposer3);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) objRememberedValue4;
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (objRememberedValue5 == obj) {
                objRememberedValue5 = Fragment$5$$ExternalSyntheticOutline0.m(musicAlarmEntry != null ? musicAlarmEntry.minute : 0, gapComposer3);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3 = (ParcelableSnapshotMutableIntState) objRememberedValue5;
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            Object obj2 = null;
            if (objRememberedValue6 == obj) {
                String str = musicAlarmEntry != null ? musicAlarmEntry.playlistId : null;
                if (str == null) {
                    str = "";
                }
                objRememberedValue6 = Stack.mutableStateOf$default(str);
                gapComposer3.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState6 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (objRememberedValue7 == obj) {
                objRememberedValue7 = Stack.mutableStateOf$default(Boolean.valueOf(musicAlarmEntry != null ? musicAlarmEntry.randomSong : false));
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState7 = (MutableState) objRememberedValue7;
            boolean zChanged = ((i2 & 112) == 32) | ((i2 & 14) == 4) | gapComposer3.changed(parcelableSnapshotMutableIntState2.getIntValue()) | gapComposer3.changed(parcelableSnapshotMutableIntState3.getIntValue());
            Object objRememberedValue8 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue8 == obj) {
                if (list != null && list.isEmpty()) {
                    z = false;
                    break;
                }
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    MusicAlarmEntry musicAlarmEntry2 = (MusicAlarmEntry) it.next();
                    if (!musicAlarmEntry2.id.equals(musicAlarmEntry != null ? musicAlarmEntry.id : null) && musicAlarmEntry2.hour == parcelableSnapshotMutableIntState2.getIntValue() && musicAlarmEntry2.minute == parcelableSnapshotMutableIntState3.getIntValue()) {
                        z = true;
                        break;
                    }
                }
                objRememberedValue8 = Boolean.valueOf(z);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            }
            boolean zBooleanValue = ((Boolean) objRememberedValue8).booleanValue();
            for (Object obj3 : list2) {
                if (Intrinsics.areEqual(((Playlist) obj3).playlist.id, (String) mutableState6.getValue())) {
                    obj2 = obj3;
                    break;
                }
            }
            Playlist playlist = (Playlist) obj2;
            boolean z2 = playlist != null;
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                gapComposer3.startReplaceGroup(2055526064);
                String strStringResource3 = MathKt.stringResource(R.string.alarm_time, gapComposer3);
                int intValue = parcelableSnapshotMutableIntState2.getIntValue();
                int intValue2 = parcelableSnapshotMutableIntState3.getIntValue();
                Object objRememberedValue9 = gapComposer3.rememberedValue();
                if (objRememberedValue9 == obj) {
                    objRememberedValue9 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState4, (byte) 29);
                    gapComposer3.updateRememberedValue(objRememberedValue9);
                }
                Function0 function2 = (Function0) objRememberedValue9;
                Object objRememberedValue10 = gapComposer3.rememberedValue();
                if (objRememberedValue10 == obj) {
                    objRememberedValue10 = new AlbumScreenKt$$ExternalSyntheticLambda8((Object) parcelableSnapshotMutableIntState2, (Object) parcelableSnapshotMutableIntState3, mutableState4, (byte) 13);
                    gapComposer3.updateRememberedValue(objRememberedValue10);
                }
                parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState3;
                AlarmTimePickerDialog(strStringResource3, intValue, intValue2, function2, (Function2) objRememberedValue10, gapComposer3, 27648);
                b = 0;
                gapComposer3.end(false);
            } else {
                zBooleanValue = zBooleanValue;
                parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState3;
                b = 0;
                gapComposer3.startReplaceGroup(2055933528);
                gapComposer3.end(false);
            }
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                gapComposer3.startReplaceGroup(2056074950);
                Object objRememberedValue11 = gapComposer3.rememberedValue();
                if (objRememberedValue11 == obj) {
                    objRememberedValue11 = new AlarmSettingsKt$$ExternalSyntheticLambda14(mutableState3, b);
                    gapComposer3.updateRememberedValue(objRememberedValue11);
                }
                mutableState2 = mutableState3;
                mutableState = mutableState6;
                boolean z3 = b;
                locale = locale2;
                DialogKt.DefaultDialog((Function0) objRememberedValue11, null, null, AiSettingsKt.lambda$1984942429, Expect_jvmKt.rememberComposableLambda(-1896293946, new QueueKt$$ExternalSyntheticLambda21(mutableState3, (byte) 25), gapComposer3), null, Expect_jvmKt.rememberComposableLambda(2093996336, new SongMenuKt$$ExternalSyntheticLambda34(list2, strStringResource, mutableState, mutableState2, (byte) 19), gapComposer3), gapComposer3, 1600518, 38);
                GapComposer gapComposer4 = gapComposer3;
                gapComposer4.end(z3);
                gapComposer2 = gapComposer4;
            } else {
                boolean z4 = b;
                GapComposer gapComposer5 = gapComposer3;
                mutableState = mutableState6;
                mutableState2 = mutableState3;
                locale = locale2;
                gapComposer5.startReplaceGroup(2059536472);
                gapComposer5.end(z4);
                gapComposer2 = gapComposer5;
            }
            GapComposer gapComposer6 = gapComposer2;
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState4 = parcelableSnapshotMutableIntState;
            boolean z5 = zBooleanValue;
            GapComposer gapComposer7 = gapComposer6;
            DialogKt.DefaultDialog(function0, null, null, Expect_jvmKt.rememberComposableLambda(-492030097, new MainActivity$$ExternalSyntheticLambda0((byte) 21, musicAlarmEntry), gapComposer2), Expect_jvmKt.rememberComposableLambda(-1818765992, new MainActivity$$ExternalSyntheticLambda17(function0, z5, z2, context, strStringResource2, function1, musicAlarmEntry, mutableState5, parcelableSnapshotMutableIntState2, parcelableSnapshotMutableIntState4, mutableState, mutableState7), gapComposer6), null, Expect_jvmKt.rememberComposableLambda(598942658, new SelectionSongsMenuKt$$ExternalSyntheticLambda22(list2, context, strStringResource, z5, mutableState5, mutableState4, locale, parcelableSnapshotMutableIntState2, parcelableSnapshotMutableIntState4, mutableState2, playlist, strStringResource2, mutableState7), gapComposer7), gapComposer7, 1600518, 38);
            gapComposer = gapComposer7;
        } else {
            gapComposer3.skipToGroupEnd();
            gapComposer = gapComposer3;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda92(musicAlarmEntry, list, list2, function0, function1, i, (byte) 10);
        }
    }

    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v50 */
    public static final void AlarmSettingsSection(boolean z, Composer composer, int i) throws XmlPullParserException, IOException {
        boolean z2;
        boolean z3;
        MutableState mutableState;
        Mutex mutex;
        CoroutineScope coroutineScope;
        MutableState mutableState2;
        MutableState mutableState3;
        ?? r1;
        boolean z4;
        Iterator it;
        Object next;
        String str;
        byte b;
        Object songMenuKt$$ExternalSyntheticLambda20;
        MutableState mutableState4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1057099718);
        int i2 = i | 6;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Locale locale = ((androidx.compose.ui.text.intl.Locale) gapComposer.consume(CompositionLocalsKt.LocalLocale)).platformLocale;
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            Flow flowPlaylistsByNameAsc = musicDatabase.$$delegate_0.playlistsByNameAsc();
            EmptyList emptyList = EmptyList.INSTANCE;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(flowPlaylistsByNameAsc, emptyList, gapComposer, 48);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new MutexImpl();
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Mutex mutex2 = (Mutex) objRememberedValue2;
            String strStringResource = MathKt.stringResource(R.string.alarm_select_playlist, gapComposer);
            String strStringResource2 = MathKt.stringResource(R.string.alarm_random_enabled, gapComposer);
            String strStringResource3 = MathKt.stringResource(R.string.alarm_random_disabled, gapComposer);
            String strStringResource4 = MathKt.stringResource(R.string.alarm_not_scheduled, gapComposer);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.mutableStateOf$default(emptyList);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState6 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState7 = (MutableState) objRememberedValue5;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            int i3 = Build.VERSION.SDK_INT;
            boolean z5 = i3 < 31 || (alarmManager != null && alarmManager.canScheduleExactAlarms());
            PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
            boolean z6 = powerManager != null && powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
            gapComposer.startReplaceGroup(2034465517);
            ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
            if (i3 < 31 || z5) {
                z3 = false;
                gapComposer.startReplaceGroup(708632423);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(707898219);
                Painter painterPainterResource = IntMath.painterResource(R.drawable.warning, 0, gapComposer);
                ComposableLambdaImpl composableLambdaImpl = AiSettingsKt.f491lambda$1645123226;
                ComposableLambdaImpl composableLambdaImpl2 = AiSettingsKt.f483lambda$1522219289;
                boolean zChangedInstance = gapComposer.changedInstance(context);
                Object objRememberedValue6 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new App$$ExternalSyntheticLambda0(context, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                listBuilderCreateListBuilder.add(new Material3SettingsItem(painterPainterResource, composableLambdaImpl, composableLambdaImpl2, null, false, false, (Function0) objRememberedValue6, 242));
                z3 = false;
                gapComposer.end(false);
            }
            if (z6) {
                gapComposer.startReplaceGroup(709318887);
                gapComposer.end(z3);
            } else {
                gapComposer.startReplaceGroup(708695198);
                Painter painterPainterResource2 = IntMath.painterResource(R.drawable.warning, z3 ? 1 : 0, gapComposer);
                ComposableLambdaImpl composableLambdaImpl3 = AiSettingsKt.f566lambda$699039153;
                ComposableLambdaImpl composableLambdaImpl4 = AiSettingsKt.lambda$1447527312;
                boolean zChangedInstance2 = gapComposer.changedInstance(context);
                Object objRememberedValue7 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new App$$ExternalSyntheticLambda0(context, (byte) 4);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                listBuilderCreateListBuilder.add(new Material3SettingsItem(painterPainterResource2, composableLambdaImpl3, composableLambdaImpl4, null, false, false, (Function0) objRememberedValue7, 242));
                z3 = false;
                gapComposer.end(false);
            }
            Collection collectionBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
            gapComposer.end(z3);
            boolean zChangedInstance3 = gapComposer.changedInstance(context);
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = new DataStoreKt$get$2((byte) 17, (Object) context, (Object) mutableState5, (Continuation) null, false);
                mutableState = mutableState5;
                context = context;
                gapComposer.updateRememberedValue(objRememberedValue8);
            } else {
                mutableState = mutableState5;
            }
            Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue8);
            if (((Boolean) mutableState6.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-1353825021);
                MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) mutableState7.getValue();
                List list = (List) mutableState.getValue();
                List list2 = (List) mutableStateCollectAsStateWithLifecycle.getValue();
                Object objRememberedValue9 = gapComposer.rememberedValue();
                if (objRememberedValue9 == neverEqualPolicy) {
                    objRememberedValue9 = new TooltipKt$$ExternalSyntheticLambda2(mutableState6, mutableState7, (byte) 15);
                    gapComposer.updateRememberedValue(objRememberedValue9);
                }
                Function0 function0 = (Function0) objRememberedValue9;
                boolean zChangedInstance4 = gapComposer.changedInstance(coroutineScope2) | gapComposer.changedInstance(mutex2) | gapComposer.changedInstance(context);
                Object objRememberedValue10 = gapComposer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue10 == neverEqualPolicy) {
                    mutex = mutex2;
                    coroutineScope = coroutineScope2;
                    mutableState2 = mutableState6;
                    mutableState4 = mutableState7;
                    songMenuKt$$ExternalSyntheticLambda20 = new SongMenuKt$$ExternalSyntheticLambda20(coroutineScope, mutex, context, mutableState, mutableState2, mutableState4);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda20);
                } else {
                    mutex = mutex2;
                    mutableState2 = mutableState6;
                    mutableState4 = mutableState7;
                    songMenuKt$$ExternalSyntheticLambda20 = objRememberedValue10;
                    coroutineScope = coroutineScope2;
                }
                mutableState3 = mutableState4;
                AlarmEditorDialog(musicAlarmEntry, list, list2, function0, (Function1) songMenuKt$$ExternalSyntheticLambda20, gapComposer, 3072);
                gapComposer = gapComposer;
                r1 = 0;
                gapComposer.end(false);
            } else {
                mutex = mutex2;
                coroutineScope = coroutineScope2;
                mutableState2 = mutableState6;
                mutableState3 = mutableState7;
                r1 = 0;
                gapComposer.startReplaceGroup(-1353328184);
                gapComposer.end(false);
            }
            String strM = Format$$ExternalSyntheticOutline0.m(gapComposer, 2034556216, R.string.alarm, gapComposer, (boolean) r1);
            gapComposer.startReplaceGroup(2034562461);
            ListBuilder listBuilderCreateListBuilder2 = CollectionsKt__IterablesKt.createListBuilder();
            Painter painterPainterResource3 = IntMath.painterResource(R.drawable.add_circle, r1, gapComposer);
            ComposableLambdaImpl composableLambdaImpl5 = AiSettingsKt.lambda$1683334502;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = new TooltipKt$$ExternalSyntheticLambda2(mutableState3, mutableState2, (byte) 16);
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            listBuilderCreateListBuilder2.add(new Material3SettingsItem(painterPainterResource3, composableLambdaImpl5, null, null, false, false, (Function0) objRememberedValue11, 250));
            if (((List) mutableState.getValue()).isEmpty()) {
                gapComposer.startReplaceGroup(883269272);
                listBuilderCreateListBuilder2.add(new Material3SettingsItem(IntMath.painterResource(R.drawable.bedtime, 0, gapComposer), AiSettingsKt.lambda$1726690987, null, null, false, false, null, 506));
                gapComposer.end(false);
                z4 = false;
            } else {
                gapComposer.startReplaceGroup(883645178);
                List list3 = (List) mutableState.getValue();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    MusicAlarmEntry musicAlarmEntry2 = (MusicAlarmEntry) it2.next();
                    Iterator it3 = ((List) mutableStateCollectAsStateWithLifecycle.getValue()).iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            it = it2;
                            next = null;
                            break;
                        } else {
                            next = it3.next();
                            it = it2;
                            if (Intrinsics.areEqual(((Playlist) next).playlist.id, musicAlarmEntry2.playlistId)) {
                                break;
                            } else {
                                it2 = it;
                            }
                        }
                    }
                    Playlist playlist = (Playlist) next;
                    if (playlist == null || (str = playlist.playlist.name) == null) {
                        str = strStringResource;
                    }
                    CoroutineScope coroutineScope3 = coroutineScope;
                    Mutex mutex3 = mutex;
                    String str2 = musicAlarmEntry2.nextTriggerAt > 0 ? DateTimeFormatter.ofPattern("EEE, HH:mm", locale).format(Instant.ofEpochMilli(musicAlarmEntry2.nextTriggerAt).atZone(ZoneId.systemDefault())) : strStringResource4;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" • ");
                    sb.append(musicAlarmEntry2.randomSong ? strStringResource2 : strStringResource3);
                    sb.append("\n");
                    str2.getClass();
                    sb.append(MathKt.stringResource(R.string.alarm_next_prefix, new Object[]{str2}, gapComposer));
                    String string = sb.toString();
                    Painter painterPainterResource4 = IntMath.painterResource(R.drawable.bedtime, 0, gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1489247374, new AlarmSettingsKt$$ExternalSyntheticLambda5(locale, musicAlarmEntry2, (byte) 0), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-854948365, new MainActivity$$ExternalSyntheticLambda6(string, (byte) 24), gapComposer);
                    Locale locale2 = locale;
                    MutableState mutableState8 = mutableState2;
                    MutableState mutableState9 = mutableState;
                    Context context2 = context;
                    PlayerKt$$ExternalSyntheticLambda92 playerKt$$ExternalSyntheticLambda92 = new PlayerKt$$ExternalSyntheticLambda92((Object) musicAlarmEntry2, (Object) coroutineScope3, (Object) mutex3, (Object) context2, mutableState9, (byte) 11);
                    coroutineScope = coroutineScope3;
                    mutex = mutex3;
                    context = context2;
                    mutableState = mutableState9;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-220649356, playerKt$$ExternalSyntheticLambda92, gapComposer);
                    boolean zChangedInstance5 = gapComposer.changedInstance(musicAlarmEntry2);
                    Object objRememberedValue12 = gapComposer.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue12 == neverEqualPolicy) {
                        b = 10;
                        objRememberedValue12 = new QueueKt$$ExternalSyntheticLambda24(musicAlarmEntry2, mutableState3, mutableState8, b);
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    } else {
                        b = 10;
                    }
                    arrayList.add(new Material3SettingsItem(painterPainterResource4, composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, composableLambdaImplRememberComposableLambda3, false, false, (Function0) objRememberedValue12, 226));
                    mutableState2 = mutableState8;
                    locale = locale2;
                    it2 = it;
                }
                listBuilderCreateListBuilder2.addAll(arrayList);
                z4 = false;
                gapComposer.end(false);
            }
            listBuilderCreateListBuilder2.addAll(collectionBuild);
            ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder2);
            gapComposer.end(z4);
            MenuKt.Material3SettingsGroup(strM, listBuilderBuild, null, gapComposer, 0, 12);
            z2 = true;
        } else {
            gapComposer.skipToGroupEnd();
            z2 = z;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SongMenuKt$$ExternalSyntheticLambda26(z2, i, (byte) 23);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object AlarmSettingsSection$loadAlarms(Context context, ContinuationImpl continuationImpl) {
        AlarmSettingsKt$AlarmSettingsSection$loadAlarms$1 alarmSettingsKt$AlarmSettingsSection$loadAlarms$1;
        if (continuationImpl instanceof AlarmSettingsKt$AlarmSettingsSection$loadAlarms$1) {
            alarmSettingsKt$AlarmSettingsSection$loadAlarms$1 = (AlarmSettingsKt$AlarmSettingsSection$loadAlarms$1) continuationImpl;
            int i = alarmSettingsKt$AlarmSettingsSection$loadAlarms$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                alarmSettingsKt$AlarmSettingsSection$loadAlarms$1.label = i - Integer.MIN_VALUE;
            } else {
                alarmSettingsKt$AlarmSettingsSection$loadAlarms$1 = new AlarmSettingsKt$AlarmSettingsSection$loadAlarms$1(continuationImpl);
            }
        } else {
            alarmSettingsKt$AlarmSettingsSection$loadAlarms$1 = new AlarmSettingsKt$AlarmSettingsSection$loadAlarms$1(continuationImpl);
        }
        Object objWithContext = alarmSettingsKt$AlarmSettingsSection$loadAlarms$1.result;
        int i2 = alarmSettingsKt$AlarmSettingsSection$loadAlarms$1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            MusicAlarmStore$loadBlocking$1 musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, continuation, (byte) 4);
            alarmSettingsKt$AlarmSettingsSection$loadAlarms$1.label = 1;
            objWithContext = AwaitKt.withContext(defaultIoScheduler, musicAlarmStore$loadBlocking$1, alarmSettingsKt$AlarmSettingsSection$loadAlarms$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return CollectionsKt.sortedWith((Iterable) objWithContext, new ColorCutQuantizer.AnonymousClass1((byte) 14));
    }

    public static final void AlarmSwitch(boolean z, Function1 function1, final boolean z2, Composer composer, final int i) {
        final boolean z3;
        final Function1 function2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(133643225);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i2 | 384;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            z3 = z;
            function2 = function1;
            MenuKt.Switch(z3, function2, null, Expect_jvmKt.rememberComposableLambda(1113300757, new SongMenuKt$$ExternalSyntheticLambda26((byte) 22, z), gapComposer), true, null, gapComposer, (i3 & 14) | 3072 | (i3 & 112) | 24576, 100);
            z2 = true;
        } else {
            z3 = z;
            function2 = function1;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    AlarmSettingsKt.AlarmSwitch(z3, function2, z2, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void AlarmTimePickerDialog(String str, int i, int i2, Function0 function0, Function2 function2, Composer composer, int i3) {
        Function2 function3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(28069478);
        int i4 = i3 | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(i) ? 32 : 16) | (gapComposer.changed(i2) ? 256 : 128);
        byte b = 0;
        if (gapComposer.shouldExecute(i4 & 1, (i4 & 9363) != 9362)) {
            int i5 = i4 >> 3;
            TimePickerStateImpl timePickerStateImplRememberTimePickerState = TimePickerKt.rememberTimePickerState(i, i2, gapComposer, (i5 & 112) | (i5 & 14) | 384);
            function3 = function2;
            DialogKt.DefaultDialog(function0, null, null, Expect_jvmKt.rememberComposableLambda(-526473023, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 23), gapComposer), Expect_jvmKt.rememberComposableLambda(-703009032, new PlayerKt$$ExternalSyntheticLambda82(function0, function3, timePickerStateImplRememberTimePickerState, (byte) 18), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-1759075378, new AlarmSettingsKt$$ExternalSyntheticLambda24(timePickerStateImplRememberTimePickerState, b), gapComposer), gapComposer, 1600518, 38);
        } else {
            function3 = function2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda2(str, i, i2, function0, function3, i3);
        }
    }
}
