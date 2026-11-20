package com.metrolist.music.ui.component;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonShapes;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda6;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda78;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda24;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SettingsSleepTimerDialogKt {
    public static final IntRange WEEKDAY_INDICES = new IntRange(0, 4, 1);
    public static final IntRange WEEKEND_INDICES = new IntRange(5, 6, 1);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:137:0x0296  */
    /* JADX WARN: Code duplicated, block: B:139:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:140:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:142:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:144:0x02be  */
    /* JADX WARN: Code duplicated, block: B:146:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:147:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:149:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x02df  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        r8 = r39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SleepTimerDialog(final Function0 function0, final Function5 function5, String str, String str2, String str3, List list, Map map, Composer composer, int i) {
        Function0 function1;
        int iIntValue;
        String str4;
        final MutableState mutableState;
        Modifier modifier;
        boolean z;
        String str5;
        String str6;
        String str7;
        String str8;
        function0.getClass();
        function5.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(181979851);
        int i2 = i | (gapComposer.changedInstance(function5) ? 256 : 128) | (gapComposer.changed(str) ? 2048 : 1024) | (gapComposer.changed(str2) ? 16384 : 8192) | (gapComposer.changed(str3) ? 131072 : 65536) | (gapComposer.changed(list) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changed(map) ? 8388608 : 4194304);
        if (gapComposer.shouldExecute(i2 & 1, (4793491 & i2) != 4793490)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                String str9 = (r8 = str.hashCode()) != -621971893 ? "weekdays_weekends" : "weekdays_weekends";
                objRememberedValue = Stack.mutableStateOf$default(str9);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.valueOf(CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"weekdays", "weekdays_weekends"}).contains(str)));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.mutableStateOf$default(Boolean.valueOf(CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"weekends", "weekdays_weekends"}).contains(str)));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue3;
            Object objRememberedValue4 = gapComposer.rememberedValue();
            IntRange intRange = WEEKDAY_INDICES;
            if (objRememberedValue4 == neverEqualPolicy) {
                Pair pair = (Pair) map.get(Integer.valueOf(intRange.first));
                if (pair == null || (str8 = (String) pair.first) == null) {
                    str8 = str2;
                }
                objRememberedValue4 = Stack.mutableStateOf$default(str8);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue4;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                Pair pair2 = (Pair) map.get(Integer.valueOf(intRange.first));
                if (pair2 == null || (str7 = (String) pair2.second) == null) {
                    str7 = str3;
                }
                objRememberedValue5 = Stack.mutableStateOf$default(str7);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue5;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            IntRange intRange2 = WEEKEND_INDICES;
            if (objRememberedValue6 == neverEqualPolicy) {
                Pair pair3 = (Pair) map.get(Integer.valueOf(intRange2.first));
                if (pair3 == null || (str6 = (String) pair3.first) == null) {
                    str6 = str2;
                }
                objRememberedValue6 = Stack.mutableStateOf$default(str6);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue6;
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                Pair pair4 = (Pair) map.get(Integer.valueOf(intRange2.first));
                if (pair4 == null || (str5 = (String) pair4.second) == null) {
                    str5 = str3;
                }
                objRememberedValue7 = Stack.mutableStateOf$default(str5);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue7;
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = Stack.mutableStateOf$default(str2);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue8;
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = Stack.mutableStateOf$default(str3);
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            final MutableState mutableState10 = (MutableState) objRememberedValue9;
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = Stack.mutableStateOf$default(list);
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            final MutableState mutableState11 = (MutableState) objRememberedValue10;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = Stack.mutableStateOf$default(map);
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            final MutableState mutableState12 = (MutableState) objRememberedValue11;
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            MutableState mutableState13 = (MutableState) objRememberedValue12;
            final String str10 = (String) mutableState13.getValue();
            if (str10 == null) {
                gapComposer.startReplaceGroup(1115094620);
                gapComposer.end(false);
                mutableState = mutableState13;
                modifier = null;
                z = false;
            } else {
                gapComposer.startReplaceGroup(1115094621);
                final boolean zContains = StringsKt.contains(str10, "start", false);
                String strM = zContains ? Format$$ExternalSyntheticOutline0.m(gapComposer, 1832446694, R.string.sleep_timer_start_time, gapComposer, false) : Format$$ExternalSyntheticOutline0.m(gapComposer, 1832530952, R.string.sleep_timer_end_time, gapComposer, false);
                switch (str10) {
                    case "global_end":
                        str4 = (String) mutableState10.getValue();
                        break;
                    case "global_start":
                        str4 = (String) mutableState9.getValue();
                        break;
                    case "weekends_end":
                        str4 = (String) mutableState8.getValue();
                        break;
                    case "weekdays_end":
                        str4 = (String) mutableState6.getValue();
                        break;
                    case "weekends_start":
                        str4 = (String) mutableState7.getValue();
                        break;
                    case "weekdays_start":
                        str4 = (String) mutableState5.getValue();
                        break;
                    default:
                        Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, StringsKt.substringAfterLast(str10, "_", str10));
                        if (intOrNull != null) {
                            iIntValue = intOrNull.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        if (!zContains) {
                            Pair pair5 = (Pair) ((Map) mutableState12.getValue()).get(Integer.valueOf(iIntValue));
                            if (pair5 != null || (str4 = (String) pair5.second) == null) {
                                str4 = "06:00";
                            }
                        } else {
                            Pair pair6 = (Pair) ((Map) mutableState12.getValue()).get(Integer.valueOf(iIntValue));
                            if (pair6 != null || (str4 = (String) pair6.first) == null) {
                                str4 = "22:00";
                            }
                        }
                        break;
                }
                Object objRememberedValue13 = gapComposer.rememberedValue();
                if (objRememberedValue13 == neverEqualPolicy) {
                    objRememberedValue13 = new MainActivity$$ExternalSyntheticLambda29(mutableState13, (byte) 21);
                    gapComposer.updateRememberedValue(objRememberedValue13);
                }
                Function0 function2 = (Function0) objRememberedValue13;
                boolean zChanged = gapComposer.changed(str10) | gapComposer.changed(zContains);
                Object objRememberedValue14 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue14 == neverEqualPolicy) {
                    mutableState = mutableState13;
                    objRememberedValue14 = new Function1() { // from class: com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda2
                        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                        /* JADX WARN: Code duplicated, block: B:26:0x006b  */
                        /* JADX WARN: Code duplicated, block: B:28:0x0079  */
                        /* JADX WARN: Code duplicated, block: B:29:0x007e  */
                        /* JADX WARN: Code duplicated, block: B:32:0x0093  */
                        /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
                        /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
                        /* JADX WARN: Code duplicated, block: B:39:0x00be  */
                        /* JADX WARN: Code duplicated, block: B:40:0x00c6  */
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int iIntValue2;
                            Pair pairCopy$default;
                            Map mapSingletonMap;
                            String str11 = (String) obj;
                            str11.getClass();
                            String str12 = str10;
                            switch (str12) {
                                case "global_end":
                                    mutableState10.setValue(str11);
                                    break;
                                case "global_start":
                                    mutableState9.setValue(str11);
                                    break;
                                case "weekends_end":
                                    mutableState8.setValue(str11);
                                    break;
                                case "weekdays_end":
                                    mutableState6.setValue(str11);
                                    break;
                                case "weekends_start":
                                    mutableState7.setValue(str11);
                                    break;
                                case "weekdays_start":
                                    mutableState5.setValue(str11);
                                    break;
                                default:
                                    Integer intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull(10, StringsKt.substringAfterLast(str12, "_", str12));
                                    if (intOrNull2 != null) {
                                        iIntValue2 = intOrNull2.intValue();
                                    } else {
                                        iIntValue2 = 0;
                                    }
                                    MutableState mutableState14 = mutableState12;
                                    Pair pair7 = (Pair) ((Map) mutableState14.getValue()).get(Integer.valueOf(iIntValue2));
                                    if (pair7 == null) {
                                        pair7 = new Pair("22:00", "06:00");
                                    }
                                    Map map2 = (Map) mutableState14.getValue();
                                    Integer numValueOf = Integer.valueOf(iIntValue2);
                                    if (zContains) {
                                        pairCopy$default = Pair.copy$default(pair7, str11, null, 2);
                                    } else {
                                        pairCopy$default = Pair.copy$default(pair7, null, str11, 1);
                                    }
                                    map2.getClass();
                                    if (map2.isEmpty()) {
                                        mapSingletonMap = Collections.singletonMap(numValueOf, pairCopy$default);
                                        mapSingletonMap.getClass();
                                    } else {
                                        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
                                        linkedHashMap.put(numValueOf, pairCopy$default);
                                        mapSingletonMap = linkedHashMap;
                                    }
                                    mutableState14.setValue(new LinkedHashMap(mapSingletonMap));
                                    break;
                            }
                            mutableState.setValue(null);
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue14);
                } else {
                    mutableState = mutableState13;
                }
                Function1 function3 = (Function1) objRememberedValue14;
                String str11 = str4;
                modifier = null;
                SleepTimerTimePickerDialog(48, gapComposer, strM, str11, function2, function3);
                z = false;
                gapComposer.end(false);
            }
            final List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.sleep_timer_monday), Integer.valueOf(R.string.sleep_timer_tuesday), Integer.valueOf(R.string.sleep_timer_wednesday), Integer.valueOf(R.string.sleep_timer_thursday), Integer.valueOf(R.string.sleep_timer_friday), Integer.valueOf(R.string.sleep_timer_saturday), Integer.valueOf(R.string.sleep_timer_sunday)});
            boolean zChanged2 = gapComposer.changed(listListOf);
            if ((i2 & 896) == 256) {
                z = true;
            }
            boolean z2 = zChanged2 | z;
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue15 == neverEqualPolicy) {
                final MutableState mutableState14 = mutableState;
                Function1 function4 = new Function1() { // from class: com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                        lazyListIntervalContent.getClass();
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, DialogKt.lambda$233336693, 3);
                        final MutableState mutableState15 = mutableState2;
                        final MutableState mutableState16 = mutableState3;
                        final MutableState mutableState17 = mutableState4;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -955342548, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(mutableState15, mutableState16, mutableState17, (byte) 0)), 3);
                        final MutableState mutableState18 = mutableState9;
                        final MutableState mutableState19 = mutableState10;
                        MutableState mutableState20 = mutableState14;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -832438611, new SongMenuKt$$ExternalSyntheticLambda34(mutableState15, mutableState18, mutableState19, mutableState20, (byte) 5)), 3);
                        final MutableState mutableState21 = mutableState5;
                        final MutableState mutableState22 = mutableState6;
                        final MutableState mutableState23 = mutableState7;
                        final MutableState mutableState24 = mutableState8;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -709534674, new AlbumMenuKt$$ExternalSyntheticLambda20(mutableState15, mutableState16, mutableState21, mutableState22, mutableState20, mutableState17, mutableState23, mutableState24)), 3);
                        List list2 = listListOf;
                        final MutableState mutableState25 = mutableState11;
                        final MutableState mutableState26 = mutableState12;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -586630737, new QueueMenuKt$$ExternalSyntheticLambda9(mutableState15, (Object) list2, mutableState25, (Object) mutableState26, (Object) mutableState20, (byte) 2)), 3);
                        final Function0 function6 = function0;
                        final Function5 function7 = function5;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -463726800, new Function3() { // from class: com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                Composer composer2 = (Composer) obj3;
                                int iIntValue2 = ((Integer) obj4).intValue();
                                ((LazyItemScopeImpl) obj2).getClass();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 16.0f, 12.0f);
                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.End, Alignment.Companion.Top, gapComposer2, 6);
                                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN4);
                                    ComposeUiNode.Companion.getClass();
                                    gapComposer2.startReusableNode();
                                    if (gapComposer2.inserting) {
                                        gapComposer2.createNode(LayoutNode.Constructor);
                                    } else {
                                        gapComposer2.useNode();
                                    }
                                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                    Stack.m389reconcileimpl(gapComposer2);
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                                    ButtonShapes buttonShapesShapes = ButtonDefaults.shapes(gapComposer2);
                                    final Function0 function8 = function6;
                                    CardKt.TextButton(function8, buttonShapesShapes, null, false, null, null, gapComposer2, 805306368);
                                    ButtonShapes buttonShapesShapes2 = ButtonDefaults.shapes(gapComposer2);
                                    final Function5 function9 = function7;
                                    boolean zChanged3 = gapComposer2.changed(function9) | gapComposer2.changed(function8);
                                    Object objRememberedValue16 = gapComposer2.rememberedValue();
                                    if (zChanged3 || objRememberedValue16 == Composer.Companion.Empty) {
                                        final MutableState mutableState27 = mutableState15;
                                        final MutableState mutableState28 = mutableState16;
                                        final MutableState mutableState29 = mutableState17;
                                        final MutableState mutableState30 = mutableState21;
                                        final MutableState mutableState31 = mutableState22;
                                        final MutableState mutableState32 = mutableState23;
                                        final MutableState mutableState33 = mutableState24;
                                        final MutableState mutableState34 = mutableState26;
                                        final MutableState mutableState35 = mutableState18;
                                        final MutableState mutableState36 = mutableState19;
                                        final MutableState mutableState37 = mutableState25;
                                        Function0 function10 = new Function0() { // from class: com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda19
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Pair pair7;
                                                IntRange intRange3;
                                                int i3;
                                                int i4;
                                                IntRange intRange4;
                                                int i5;
                                                int i6;
                                                MutableState mutableState38 = mutableState27;
                                                String str12 = "weekdays_weekends";
                                                if (Intrinsics.areEqual((String) mutableState38.getValue(), "weekdays_weekends")) {
                                                    MutableState mutableState39 = mutableState28;
                                                    boolean zBooleanValue = ((Boolean) mutableState39.getValue()).booleanValue();
                                                    MutableState mutableState40 = mutableState29;
                                                    if (!zBooleanValue || !((Boolean) mutableState40.getValue()).booleanValue()) {
                                                        if (((Boolean) mutableState39.getValue()).booleanValue()) {
                                                            str12 = "weekdays";
                                                        } else {
                                                            str12 = ((Boolean) mutableState40.getValue()).booleanValue() ? "weekends" : "daily";
                                                        }
                                                    }
                                                    MapBuilder mapBuilder = new MapBuilder();
                                                    if (((Boolean) mutableState39.getValue()).booleanValue() && (i5 = (intRange4 = SettingsSleepTimerDialogKt.WEEKDAY_INDICES).first) <= (i6 = intRange4.last)) {
                                                        while (true) {
                                                            mapBuilder.put(Integer.valueOf(i5), new Pair((String) mutableState30.getValue(), (String) mutableState31.getValue()));
                                                            if (i5 == i6) {
                                                                break;
                                                            }
                                                            i5++;
                                                        }
                                                    }
                                                    if (((Boolean) mutableState40.getValue()).booleanValue() && (i3 = (intRange3 = SettingsSleepTimerDialogKt.WEEKEND_INDICES).first) <= (i4 = intRange3.last)) {
                                                        while (true) {
                                                            mapBuilder.put(Integer.valueOf(i3), new Pair((String) mutableState32.getValue(), (String) mutableState33.getValue()));
                                                            if (i3 == i4) {
                                                                break;
                                                            }
                                                            i3++;
                                                        }
                                                    }
                                                    pair7 = new Pair(str12, mapBuilder.build());
                                                } else {
                                                    pair7 = new Pair((String) mutableState38.getValue(), MapsKt__MapsKt.toMap((Map) mutableState34.getValue()));
                                                }
                                                function9.invoke((String) pair7.first, (String) mutableState35.getValue(), (String) mutableState36.getValue(), (List) mutableState37.getValue(), (Map) pair7.second);
                                                function8.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        gapComposer2.updateRememberedValue(function10);
                                        objRememberedValue16 = function10;
                                    }
                                    CardKt.Button((Function0) objRememberedValue16, buttonShapesShapes2, null, false, null, null, null, DialogKt.f23lambda$1816687740, gapComposer2, 805306368, 508);
                                    gapComposer2.end(true);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), 3);
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(function4);
                objRememberedValue15 = function4;
            }
            function1 = function0;
            DialogKt.ListDialog(function1, modifier, (Function1) objRememberedValue15, gapComposer, 6);
        } else {
            function1 = function0;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PlayerKt$$ExternalSyntheticLambda78(function1, function5, str, str2, str3, list, map, i);
        }
    }

    public static final void SleepTimerTimePickerDialog(int i, Composer composer, String str, String str2, Function0 function0, Function1 function1) {
        Function0 function2;
        LocalTime localTimeOf;
        str.getClass();
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1330545823);
        byte b = 4;
        int i2 = (gapComposer.changed(str) ? 4 : 2) | i | (gapComposer.changedInstance(function1) ? 256 : 128) | (gapComposer.changed(str2) ? 2048 : 1024);
        byte b2 = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            try {
                localTimeOf = LocalTime.parse(str2, DateTimeFormatter.ofPattern("HH:mm"));
            } catch (Exception unused) {
                localTimeOf = LocalTime.of(9, 0);
            }
            TimePickerStateImpl timePickerStateImplRememberTimePickerState = TimePickerKt.rememberTimePickerState(localTimeOf.getHour(), localTimeOf.getMinute(), gapComposer, 384);
            function2 = function0;
            DialogKt.DefaultDialog(function2, null, null, Expect_jvmKt.rememberComposableLambda(-543534086, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 15), gapComposer), Expect_jvmKt.rememberComposableLambda(1277326129, new PlayerKt$$ExternalSyntheticLambda82(function0, timePickerStateImplRememberTimePickerState, function1, b), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-1083117049, new AlarmSettingsKt$$ExternalSyntheticLambda24(timePickerStateImplRememberTimePickerState, b2), gapComposer), gapComposer, 1600518, 38);
        } else {
            function2 = function0;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda8(str, function2, function1, str2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:56:0x0102  */
    /* JADX WARN: Code duplicated, block: B:60:0x0141  */
    /* JADX WARN: Code duplicated, block: B:63:0x014a  */
    /* JADX WARN: Code duplicated, block: B:64:0x014d  */
    /* JADX WARN: Code duplicated, block: B:66:0x017a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0185  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    public static final void TimeRangeRow(final String str, final String str2, final Function0 function0, final Function0 function1, Modifier modifier, Composer composer, final int i, final int i2) {
        Function0 function2;
        Modifier modifier2;
        boolean z;
        GapComposer gapComposer;
        final Modifier modifier3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        float f;
        float f2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-217123302);
        byte b = 4;
        int i3 = (gapComposer2.changed(str) ? 4 : 2) | i | (gapComposer2.changed(str2) ? 32 : 16);
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function2 = function1;
            i3 |= gapComposer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer2.changed(modifier2) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer2.shouldExecute(i3 & 1, z)) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(modifier4, 1.0f), 16.0f, 4.0f);
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer2, 6);
                int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN4);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                if (1.0f <= 0.0d) {
                    InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                }
                Modifier modifier5 = modifier4;
                if (1.0f > Float.MAX_VALUE) {
                    f = Float.MAX_VALUE;
                } else {
                    f = 1.0f;
                }
                CardKt.Button(function0, new LayoutWeightElement(f, true), false, roundedCornerShapeM185RoundedCornerShape0680j_4, null, null, null, null, null, Expect_jvmKt.rememberComposableLambda(906674758, new MainActivity$$ExternalSyntheticLambda7(str, b), gapComposer2), gapComposer2, ((i3 >> 6) & 14) | 805306368, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                if (1.0f <= 0.0d) {
                    InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                }
                if (1.0f > Float.MAX_VALUE) {
                    f2 = Float.MAX_VALUE;
                } else {
                    f2 = 1.0f;
                }
                CardKt.Button(function2, new LayoutWeightElement(f2, true), false, roundedCornerShapeM185RoundedCornerShape0680j_5, null, null, null, null, null, Expect_jvmKt.rememberComposableLambda(-1218155729, new MainActivity$$ExternalSyntheticLambda7(str2, (byte) 5), gapComposer2), gapComposer2, ((i3 >> 9) & 14) | 805306368, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                gapComposer = gapComposer2;
                gapComposer.end(true);
                modifier3 = modifier5;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        SettingsSleepTimerDialogKt.TimeRangeRow(str, str2, function0, function1, modifier3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer2.shouldExecute(i3 & 1, z)) {
            if (i4 != 0) {
                modifier4 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(modifier4, 1.0f), 16.0f, 4.0f);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer2, 6);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN5);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            Modifier modifier6 = modifier4;
            if (1.0f > Float.MAX_VALUE) {
                f = Float.MAX_VALUE;
            } else {
                f = 1.0f;
            }
            CardKt.Button(function0, new LayoutWeightElement(f, true), false, roundedCornerShapeM185RoundedCornerShape0680j_6, null, null, null, null, null, Expect_jvmKt.rememberComposableLambda(906674758, new MainActivity$$ExternalSyntheticLambda7(str, b), gapComposer2), gapComposer2, ((i3 >> 6) & 14) | 805306368, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_7 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            if (1.0f > Float.MAX_VALUE) {
                f2 = Float.MAX_VALUE;
            } else {
                f2 = 1.0f;
            }
            CardKt.Button(function2, new LayoutWeightElement(f2, true), false, roundedCornerShapeM185RoundedCornerShape0680j_7, null, null, null, null, null, Expect_jvmKt.rememberComposableLambda(-1218155729, new MainActivity$$ExternalSyntheticLambda7(str2, (byte) 5), gapComposer2), gapComposer2, ((i3 >> 9) & 14) | 805306368, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
            gapComposer = gapComposer2;
            gapComposer.end(true);
            modifier3 = modifier6;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    SettingsSleepTimerDialogKt.TimeRangeRow(str, str2, function0, function1, modifier3, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final LinkedHashMap decodeDayTimes(String str) {
        Integer intOrNull;
        str.getClass();
        if (StringsKt.isBlank(str)) {
            return new LinkedHashMap();
        }
        List listSplit$default = StringsKt.split$default(str, new String[]{";"}, 0, 6);
        ArrayList arrayList = new ArrayList();
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((String) it.next(), new String[]{"="}, 0, 6);
            Pair pair = null;
            if (listSplit$default2.size() == 2 && (intOrNull = StringsKt__StringsJVMKt.toIntOrNull((String) listSplit$default2.get(0))) != null) {
                List listSplit$default3 = StringsKt.split$default((CharSequence) listSplit$default2.get(1), new String[]{"-"}, 0, 6);
                if (listSplit$default3.size() == 2) {
                    pair = new Pair(intOrNull, new Pair(listSplit$default3.get(0), listSplit$default3.get(1)));
                }
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return new LinkedHashMap(MapsKt__MapsKt.toMap(arrayList));
    }
}
