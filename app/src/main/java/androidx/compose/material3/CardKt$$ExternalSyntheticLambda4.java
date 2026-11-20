package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CardKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$8;

    public /* synthetic */ CardKt$$ExternalSyntheticLambda4(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = shape;
        this.f$4 = cardColors;
        this.f$5 = cardElevation;
        this.f$6 = borderStroke;
        this.f$8 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str;
        String strPluralStringResource;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$8;
        Object obj4 = this.f$6;
        Object obj5 = this.f$5;
        Object obj6 = this.f$4;
        Object obj7 = this.f$3;
        Object obj8 = this.f$1;
        Object obj9 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                CardKt.Card((Function0) obj9, (Modifier) obj8, this.f$2, (Shape) obj7, (CardColors) obj6, (CardElevation) obj5, (BorderStroke) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(100663345));
                break;
            default:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj9;
                FocusRequester focusRequester = (FocusRequester) obj8;
                MutableState mutableState = (MutableState) obj7;
                LazyListState lazyListState = (LazyListState) obj6;
                MutableState mutableState2 = (MutableState) obj5;
                MutableState mutableState3 = (MutableState) obj4;
                State state = (State) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else if (TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState2)) {
                    gapComposer.startReplaceGroup(67805737);
                    if (this.f$2) {
                        gapComposer.startReplaceGroup(67903697);
                        strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_episode, snapshotStateList.size(), new Object[]{Integer.valueOf(snapshotStateList.size())}, gapComposer);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(68045460);
                        strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_song, snapshotStateList.size(), new Object[]{Integer.valueOf(snapshotStateList.size())}, gapComposer);
                        gapComposer.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strPluralStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 0, 0, 131070);
                    gapComposer.end(false);
                } else if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(68368139);
                    TextFieldValue textFieldValue = (TextFieldValue) mutableState.getValue();
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 119);
                    TextFieldColors textFieldColorsM348colors0hiis_0 = TextFieldDefaults.m348colors0hiis_0(0L, 0L, 0L, 0L, gapComposer, 2147469263);
                    Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), focusRequester);
                    boolean zChanged = gapComposer.changed(mutableState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 11);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    ScrimKt.TextField(textFieldValue, (Function1) objRememberedValue, modifierFocusRequester, false, textStyle, TopPlaylistScreenKt.lambda$1435947527, null, keyboardOptions, null, true, 0, 0, null, textFieldColorsM348colors0hiis_0, gapComposer, 12582912, 12779520, 4030296);
                    gapComposer.end(false);
                } else if (lazyListState.getFirstVisibleItemIndex() <= 0) {
                    gapComposer.startReplaceGroup(69747546);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(69683159);
                    PlaylistItem playlistItem = (PlaylistItem) state.getValue();
                    if (playlistItem == null || (str = playlistItem.title) == null) {
                        str = "";
                    }
                    TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    gapComposer.end(false);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ CardKt$$ExternalSyntheticLambda4(boolean z, SnapshotStateList snapshotStateList, FocusRequester focusRequester, MutableState mutableState, LazyListState lazyListState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4) {
        this.f$2 = z;
        this.f$0 = snapshotStateList;
        this.f$1 = focusRequester;
        this.f$3 = mutableState;
        this.f$4 = lazyListState;
        this.f$5 = mutableState2;
        this.f$6 = mutableState3;
        this.f$8 = mutableState4;
    }
}
