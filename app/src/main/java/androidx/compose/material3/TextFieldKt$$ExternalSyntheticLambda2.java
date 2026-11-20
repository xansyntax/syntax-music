package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.OriginalLyricsKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldKt$$ExternalSyntheticLambda2 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$13;
    public final /* synthetic */ Object f$14;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$7;

    public /* synthetic */ TextFieldKt$$ExternalSyntheticLambda2(TextFieldValue textFieldValue, boolean z, boolean z2, VisualTransformation visualTransformation, MutableInteractionSourceImpl mutableInteractionSourceImpl, Function2 function2, Shape shape, TextFieldColors textFieldColors) {
        this.f$0 = textFieldValue;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = visualTransformation;
        this.f$4 = mutableInteractionSourceImpl;
        this.f$7 = function2;
        this.f$13 = shape;
        this.f$14 = textFieldColors;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$14;
        Object obj5 = this.f$13;
        Object obj6 = this.f$7;
        Object obj7 = this.f$4;
        Object obj8 = this.f$3;
        Object obj9 = this.f$0;
        switch (b) {
            case 0:
                TextFieldValue textFieldValue = (TextFieldValue) obj9;
                VisualTransformation visualTransformation = (VisualTransformation) obj8;
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj7;
                Function2 function2 = (Function2) obj6;
                Shape shape = (Shape) obj5;
                TextFieldColors textFieldColors = (TextFieldColors) obj4;
                Function2 function3 = (Function2) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changedInstance(function3) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextFieldDefaults.INSTANCE.DecorationBox(textFieldValue.annotatedString.text, function3, this.f$1, this.f$2, visualTransformation, mutableInteractionSourceImpl, null, function2, shape, textFieldColors, null, null, gapComposer, (iIntValue << 3) & 112);
                }
                break;
            default:
                MutableState mutableState = (MutableState) obj9;
                MutableState mutableState2 = (MutableState) obj8;
                PlayerConnection playerConnection = (PlayerConnection) obj7;
                String str = (String) obj6;
                ArtistPage artistPage = (ArtistPage) obj5;
                CoroutineScope coroutineScope = (CoroutineScope) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean z = this.f$1;
                    boolean zChanged = gapComposer2.changed(z) | gapComposer2.changed(mutableState) | gapComposer2.changed(mutableState2) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(str) | gapComposer2.changedInstance(artistPage) | gapComposer2.changedInstance(coroutineScope);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        OriginalLyricsKt$$ExternalSyntheticLambda4 originalLyricsKt$$ExternalSyntheticLambda4 = new OriginalLyricsKt$$ExternalSyntheticLambda4(z, playerConnection, str, artistPage, coroutineScope, mutableState, mutableState2);
                        gapComposer2.updateRememberedValue(originalLyricsKt$$ExternalSyntheticLambda4);
                        objRememberedValue = originalLyricsKt$$ExternalSyntheticLambda4;
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    if (!this.f$2) {
                        gapComposer2.startReplaceGroup(-701658467);
                        CardKt.m259FloatingActionButtonXz6DiA(function0, OffsetKt.m135padding3ABfNKs(companion, 16.0f), null, 0L, 0L, null, ArtistItemsScreenKt.lambda$796694260, gapComposer2, 12582960, 124);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-702166960);
                        CardKt.m265SmallFloatingActionButtonXz6DiA(function0, OffsetKt.m133offsetVpY3zN4(OffsetKt.m135padding3ABfNKs(companion, 16.0f), -4.0f, CropImageView.DEFAULT_ASPECT_RATIO), null, 0L, 0L, null, ArtistItemsScreenKt.f351lambda$948408580, gapComposer2, 12582960, 124);
                        gapComposer2.end(false);
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ TextFieldKt$$ExternalSyntheticLambda2(boolean z, MutableState mutableState, MutableState mutableState2, PlayerConnection playerConnection, String str, ArtistPage artistPage, CoroutineScope coroutineScope, boolean z2) {
        this.f$1 = z;
        this.f$0 = mutableState;
        this.f$3 = mutableState2;
        this.f$4 = playerConnection;
        this.f$7 = str;
        this.f$13 = artistPage;
        this.f$14 = coroutineScope;
        this.f$2 = z2;
    }
}
