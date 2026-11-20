package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerElement;
import androidx.compose.ui.graphics.LayerOutsets;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListItemKt$$ExternalSyntheticLambda11 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State f$2;

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda11(State state, byte b) {
        this.$r8$classId = b;
        this.f$2 = state;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        long j;
        int i;
        int i2;
        long j2;
        SongEntity songEntity;
        int i3;
        int i4;
        SongEntity songEntity2;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        LocalDateTime localDateTime = null;
        int i5 = R.drawable.add;
        Unit unit = Unit.INSTANCE;
        State state = this.f$2;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ListItemKt.m302OverlineDecoratorrcwGITA(((Color) state.getValue()).value, gapComposer, 0);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.expand_more, 0, gapComposer2), (String) null, Modifier.Companion.$$INSTANCE.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : ((Number) state.getValue()).floatValue(), ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero)), 0L, gapComposer2, 56, 8);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, 0, gapComposer3), (String) null, Modifier.Companion.$$INSTANCE.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : ((Number) state.getValue()).floatValue(), ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero)), 0L, gapComposer3, 56, 8);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer4), (String) null, (Modifier) null, 0L, gapComposer4, 56, 12);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((Boolean) state.getValue()).booleanValue() ? Format$$ExternalSyntheticOutline0.m(gapComposer5, -1181581210, R.string.unpin_from_speed_dial, gapComposer5, false) : Format$$ExternalSyntheticOutline0.m(gapComposer5, -1181579550, R.string.pin_to_speed_dial, gapComposer5, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer6), (String) null, SizeKt.m151size3ABfNKs(companion, 28.0f), ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, gapComposer6, 440, 0);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(((Boolean) state.getValue()).booleanValue() ? R.drawable.check : R.drawable.close, 0, gapComposer7), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer7, 56, 8);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    String strValueOf = String.valueOf(((List) state.getValue()).size());
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strValueOf, OffsetKt.m136paddingVpY3zN4(companion, 6.0f, 2.0f), ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer8, 48, 0, 131064);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((Boolean) state.getValue()).booleanValue() ? Format$$ExternalSyntheticOutline0.m(gapComposer9, -841553247, R.string.unpin_from_speed_dial, gapComposer9, false) : Format$$ExternalSyntheticOutline0.m(gapComposer9, -841551587, R.string.pin_to_speed_dial, gapComposer9, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 262142);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer10), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer10, 440, 8);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer11, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.group, 0, gapComposer11), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer11, 440, 8);
                    if (((List) state.getValue()).isEmpty()) {
                        gapComposer11.startReplaceGroup(3494991);
                        gapComposer11.end(false);
                    } else {
                        gapComposer11.startReplaceGroup(2420252);
                        SurfaceKt.m337SurfaceT9BRK9s(BoxScopeInstance.INSTANCE.align(OffsetKt.m133offsetVpY3zN4(companion, 8.0f, -6.0f), Alignment.Companion.TopEnd), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(723112873, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 7), gapComposer11), gapComposer11, 12582912, 120);
                        gapComposer11.end(false);
                    }
                    gapComposer11.end(true);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    Playlist playlist = (Playlist) state.getValue();
                    Painter painterPainterResource = IntMath.painterResource((playlist != null ? playlist.playlist.bookmarkedAt : null) != null ? R.drawable.favorite : R.drawable.favorite_border, 0, gapComposer12);
                    Playlist playlist2 = (Playlist) state.getValue();
                    if ((playlist2 != null ? playlist2.playlist.bookmarkedAt : null) != null) {
                        gapComposer12.startReplaceGroup(983273804);
                        j = ((MaterialTheme$Values) gapComposer12.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                        gapComposer12.end(false);
                    } else {
                        gapComposer12.startReplaceGroup(983373810);
                        j = ((Color) gapComposer12.consume(ContentColorKt.LocalContentColor)).value;
                        gapComposer12.end(false);
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, (Modifier) null, j, gapComposer12, 56, 4);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer13), (String) null, (Modifier) null, 0L, gapComposer13, 56, 12);
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((Boolean) state.getValue()).booleanValue() ? Format$$ExternalSyntheticOutline0.m(gapComposer14, -1694083266, R.string.unpin_from_speed_dial, gapComposer14, false) : Format$$ExternalSyntheticOutline0.m(gapComposer14, -1694081606, R.string.pin_to_speed_dial, gapComposer14, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, 0, gapComposer15), (String) null, Modifier.Companion.$$INSTANCE.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : ((Number) state.getValue()).floatValue(), ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero)), 0L, gapComposer15, 56, 8);
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer16), (String) null, (Modifier) null, 0L, gapComposer16, 56, 12);
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((Boolean) state.getValue()).booleanValue() ? Format$$ExternalSyntheticOutline0.m(gapComposer17, -89677091, R.string.unpin_from_speed_dial, gapComposer17, false) : Format$$ExternalSyntheticOutline0.m(gapComposer17, -89675431, R.string.pin_to_speed_dial, gapComposer17, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, 0, gapComposer18), (String) null, Modifier.Companion.$$INSTANCE.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : ((Number) state.getValue()).floatValue(), ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero)), 0L, gapComposer18, 56, 8);
                }
                break;
            case 18:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer19), (String) null, (Modifier) null, 0L, gapComposer19, 56, 12);
                }
                break;
            case 19:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((Boolean) state.getValue()).booleanValue() ? Format$$ExternalSyntheticOutline0.m(gapComposer20, -468211483, R.string.unpin_from_speed_dial, gapComposer20, false) : Format$$ExternalSyntheticOutline0.m(gapComposer20, -468209823, R.string.pin_to_speed_dial, gapComposer20, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    Artist artist = (Artist) state.getValue();
                    if ((artist != null ? artist.artist.bookmarkedAt : null) != null) {
                        i = 216586320;
                        i2 = R.string.subscribed;
                    } else {
                        i = 216587631;
                        i2 = R.string.subscribe;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer21, i, i2, gapComposer21, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                }
                break;
            case 21:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer22), (String) null, SizeKt.m151size3ABfNKs(companion, 28.0f), ((MaterialTheme$Values) gapComposer22.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, gapComposer22, 440, 0);
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    Artist artist2 = (Artist) state.getValue();
                    IconKt.m290Iconww6aTOc(IntMath.painterResource((artist2 != null ? artist2.artist.bookmarkedAt : null) != null ? R.drawable.subscribed : R.drawable.subscribe, 0, gapComposer23), (String) null, (Modifier) null, 0L, gapComposer23, 56, 12);
                }
                break;
            case 23:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    Playlist playlist3 = (Playlist) state.getValue();
                    Painter painterPainterResource2 = IntMath.painterResource((playlist3 != null ? playlist3.playlist.bookmarkedAt : null) != null ? R.drawable.favorite : R.drawable.favorite_border, 0, gapComposer24);
                    Playlist playlist4 = (Playlist) state.getValue();
                    if ((playlist4 != null ? playlist4.playlist.bookmarkedAt : null) != null) {
                        gapComposer24.startReplaceGroup(-2116289284);
                        j2 = ((MaterialTheme$Values) gapComposer24.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                        gapComposer24.end(false);
                    } else {
                        gapComposer24.startReplaceGroup(-2116189278);
                        j2 = ((Color) gapComposer24.consume(ContentColorKt.LocalContentColor)).value;
                        gapComposer24.end(false);
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, (Modifier) null, j2, gapComposer24, 56, 4);
                }
                break;
            case 24:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 3) != 2)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer25), (String) null, (Modifier) null, 0L, gapComposer25, 56, 12);
                }
                break;
            case 25:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((Boolean) state.getValue()).booleanValue() ? Format$$ExternalSyntheticOutline0.m(gapComposer26, -644640564, R.string.unpin_from_speed_dial, gapComposer26, false) : Format$$ExternalSyntheticOutline0.m(gapComposer26, -644638904, R.string.pin_to_speed_dial, gapComposer26, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                }
                break;
            case 26:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 3) != 2)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i5 = R.drawable.remove;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer27), (String) null, (Modifier) null, 0L, gapComposer27, 56, 12);
                }
                break;
            case 27:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 3) != 2)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(((Boolean) state.getValue()).booleanValue() ? Format$$ExternalSyntheticOutline0.m(gapComposer28, 643056982, R.string.unpin_from_speed_dial, gapComposer28, false) : Format$$ExternalSyntheticOutline0.m(gapComposer28, 643058642, R.string.pin_to_speed_dial, gapComposer28, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                }
                break;
            case 28:
                Composer composer29 = (Composer) obj;
                int iIntValue29 = ((Integer) obj2).intValue();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 3) != 2)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    Song song = (Song) state.getValue();
                    if (song != null && (songEntity = song.song) != null) {
                        localDateTime = songEntity.inLibrary;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(localDateTime != null ? R.drawable.library_add_check : R.drawable.library_add, 0, gapComposer29), (String) null, (Modifier) null, 0L, gapComposer29, 56, 12);
                }
                break;
            default:
                Composer composer30 = (Composer) obj;
                int iIntValue30 = ((Integer) obj2).intValue();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (!gapComposer30.shouldExecute(iIntValue30 & 1, (iIntValue30 & 3) != 2)) {
                    gapComposer30.skipToGroupEnd();
                } else {
                    Song song2 = (Song) state.getValue();
                    if (song2 != null && (songEntity2 = song2.song) != null) {
                        localDateTime = songEntity2.inLibrary;
                    }
                    if (localDateTime != null) {
                        i3 = -2079763523;
                        i4 = R.string.remove_from_library;
                    } else {
                        i3 = -2079761928;
                        i4 = R.string.add_to_library;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer30, i3, i4, gapComposer30, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer30, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
