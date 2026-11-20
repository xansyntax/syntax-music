package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenTogetherScreenKt$$ExternalSyntheticLambda53 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ ListenTogetherScreenKt$$ExternalSyntheticLambda53(List list, Function1 function1, Function1 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = function1;
        this.f$2 = function2;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0256  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        NeverEqualPolicy neverEqualPolicy;
        final Function1 function1;
        boolean zChanged;
        Object objRememberedValue;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
        final Function1 function2 = this.f$2;
        final Function1 function3 = this.f$1;
        List list = this.f$0;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
        boolean z = true;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    String strStringResource = MathKt.stringResource(R.string.listen_together_join_requests, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer, 1572864, 0, 131002);
                    OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    gapComposer.startReplaceGroup(1321087271);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        final Listentogether.JoinRequestPayload joinRequestPayload = (Listentogether.JoinRequestPayload) it.next();
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        Iterator it2 = it;
                        Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
                        int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
                        ComposeUiNode.Companion.getClass();
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                        Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda2);
                        Stack.m389reconcileimpl(gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                        Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 40.0f);
                        RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        SurfaceKt.m337SurfaceT9BRK9s(modifierM151size3ABfNKs, roundedCornerShape, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.secondary, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1999313432, new MainActivity$$ExternalSyntheticLambda0((byte) 15, joinRequestPayload), gapComposer), gapComposer, 12582918, 120);
                        OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 12.0f));
                        String username = joinRequestPayload.getUsername();
                        username.getClass();
                        TextKt.m352TextNvy7gAk(username, new LayoutWeightElement(1.0f, true), 0L, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.bodyLarge, gapComposer, 1572864, 0, 131004);
                        boolean zChanged2 = gapComposer.changed(function3) | gapComposer.changed(joinRequestPayload);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        Object obj4 = objRememberedValue2;
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy2) {
                            final byte b2 = 0;
                            Function0 function0 = new Function0() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda62
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b3 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    Listentogether.JoinRequestPayload joinRequestPayload2 = joinRequestPayload;
                                    Function1 function4 = function3;
                                    switch (b3) {
                                        case 0:
                                            String userId = joinRequestPayload2.getUserId();
                                            userId.getClass();
                                            function4.invoke(userId);
                                            break;
                                        default:
                                            String userId2 = joinRequestPayload2.getUserId();
                                            userId2.getClass();
                                            function4.invoke(userId2);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(function0);
                            obj4 = function0;
                        }
                        CardKt.IconButton((Function0) obj4, null, false, null, null, AlbumScreenKt.f332lambda$737370581, gapComposer, 1572864, 62);
                        boolean zChanged3 = gapComposer.changed(function2) | gapComposer.changed(joinRequestPayload);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy2) {
                            final byte b3 = 1;
                            objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda62
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    Listentogether.JoinRequestPayload joinRequestPayload2 = joinRequestPayload;
                                    Function1 function4 = function2;
                                    switch (b4) {
                                        case 0:
                                            String userId = joinRequestPayload2.getUserId();
                                            userId.getClass();
                                            function4.invoke(userId);
                                            break;
                                        default:
                                            String userId2 = joinRequestPayload2.getUserId();
                                            userId2.getClass();
                                            function4.invoke(userId2);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, AlbumScreenKt.lambda$1219566498, gapComposer, 1572864, 62);
                        gapComposer.end(true);
                        it = it2;
                    }
                    gapComposer.end(false);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                    return unit;
                }
                Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
                NeverEqualPolicy neverEqualPolicy3 = neverEqualPolicy2;
                Function1 function4 = function2;
                int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs2);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                String strStringResource2 = MathKt.stringResource(R.string.pending_suggestions, gapComposer2);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                TextKt.m352TextNvy7gAk(strStringResource2, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).typography.titleMedium, gapComposer2, 1572864, 0, 131002);
                OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 12.0f));
                gapComposer2.startReplaceGroup(764433451);
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    final Listentogether.SuggestionReceivedPayload suggestionReceivedPayload = (Listentogether.SuggestionReceivedPayload) it3.next();
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    Iterator it4 = it3;
                    Unit unit2 = unit;
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, z ? 1 : 0);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical2, gapComposer2, 48);
                    int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.queue_music, 0, gapComposer2);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal4)).colorScheme.primary, gapComposer2, 440, 0);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
                    int iHashCode5 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda3);
                    String title = suggestionReceivedPayload.getTrackInfo().getTitle();
                    title.getClass();
                    TextKt.m352TextNvy7gAk(title, null, 0L, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal4)).typography.bodyMedium, gapComposer2, 1572864, 24960, 110526);
                    String fromUsername = suggestionReceivedPayload.getFromUsername();
                    fromUsername.getClass();
                    TextKt.m352TextNvy7gAk(fromUsername, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal4)).typography.bodySmall, gapComposer2, 0, 24960, 110586);
                    gapComposer2.end(true);
                    boolean zChanged4 = gapComposer2.changed(function3) | gapComposer2.changed(suggestionReceivedPayload);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged4) {
                        neverEqualPolicy = neverEqualPolicy3;
                    } else {
                        neverEqualPolicy = neverEqualPolicy3;
                        if (objRememberedValue4 == neverEqualPolicy) {
                        }
                        obj = objRememberedValue4;
                        CardKt.IconButton((Function0) obj, null, false, null, null, AlbumScreenKt.f329lambda$60269594, gapComposer2, 1572864, 62);
                        function1 = function4;
                        zChanged = gapComposer2.changed(function1) | gapComposer2.changed(suggestionReceivedPayload);
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            final byte b4 = 1;
                            objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda74
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b5 = b4;
                                    Unit unit3 = Unit.INSTANCE;
                                    Listentogether.SuggestionReceivedPayload suggestionReceivedPayload2 = suggestionReceivedPayload;
                                    Function1 function5 = function1;
                                    switch (b5) {
                                        case 0:
                                            String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                            suggestionId.getClass();
                                            function5.invoke(suggestionId);
                                            break;
                                        default:
                                            String suggestionId2 = suggestionReceivedPayload2.getSuggestionId();
                                            suggestionId2.getClass();
                                            function5.invoke(suggestionId2);
                                            break;
                                    }
                                    return unit3;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, AlbumScreenKt.lambda$1744872477, gapComposer2, 1572864, 62);
                        gapComposer2.end(true);
                        neverEqualPolicy3 = neverEqualPolicy;
                        function4 = function1;
                        z = true;
                        unit = unit2;
                        it3 = it4;
                    }
                    obj = objRememberedValue4;
                    final byte b5 = 0;
                    Function0 function5 = new Function0() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda74
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b6 = b5;
                            Unit unit3 = Unit.INSTANCE;
                            Listentogether.SuggestionReceivedPayload suggestionReceivedPayload2 = suggestionReceivedPayload;
                            Function1 function6 = function3;
                            switch (b6) {
                                case 0:
                                    String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                    suggestionId.getClass();
                                    function6.invoke(suggestionId);
                                    break;
                                default:
                                    String suggestionId2 = suggestionReceivedPayload2.getSuggestionId();
                                    suggestionId2.getClass();
                                    function6.invoke(suggestionId2);
                                    break;
                            }
                            return unit3;
                        }
                    };
                    gapComposer2.updateRememberedValue(function5);
                    Object obj5 = function5;
                    obj5 = objRememberedValue4;
                    CardKt.IconButton((Function0) obj5, null, false, null, null, AlbumScreenKt.f329lambda$60269594, gapComposer2, 1572864, 62);
                    function1 = function4;
                    zChanged = gapComposer2.changed(function1) | gapComposer2.changed(suggestionReceivedPayload);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged) {
                        final byte b6 = 1;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda74
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b7 = b6;
                                Unit unit3 = Unit.INSTANCE;
                                Listentogether.SuggestionReceivedPayload suggestionReceivedPayload2 = suggestionReceivedPayload;
                                Function1 function6 = function1;
                                switch (b7) {
                                    case 0:
                                        String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                        suggestionId.getClass();
                                        function6.invoke(suggestionId);
                                        break;
                                    default:
                                        String suggestionId2 = suggestionReceivedPayload2.getSuggestionId();
                                        suggestionId2.getClass();
                                        function6.invoke(suggestionId2);
                                        break;
                                }
                                return unit3;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        final byte b7 = 1;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda74
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b8 = b7;
                                Unit unit3 = Unit.INSTANCE;
                                Listentogether.SuggestionReceivedPayload suggestionReceivedPayload2 = suggestionReceivedPayload;
                                Function1 function6 = function1;
                                switch (b8) {
                                    case 0:
                                        String suggestionId = suggestionReceivedPayload2.getSuggestionId();
                                        suggestionId.getClass();
                                        function6.invoke(suggestionId);
                                        break;
                                    default:
                                        String suggestionId2 = suggestionReceivedPayload2.getSuggestionId();
                                        suggestionId2.getClass();
                                        function6.invoke(suggestionId2);
                                        break;
                                }
                                return unit3;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, AlbumScreenKt.lambda$1744872477, gapComposer2, 1572864, 62);
                    gapComposer2.end(true);
                    neverEqualPolicy3 = neverEqualPolicy;
                    function4 = function1;
                    z = true;
                    unit = unit2;
                    it3 = it4;
                }
                Unit unit3 = unit;
                gapComposer2.end(false);
                gapComposer2.end(z);
                return unit3;
        }
    }
}
