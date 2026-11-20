package com.metrolist.music.ui.component;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda63;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda5 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda5(Object obj, boolean z, boolean z2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = z;
        this.f$2 = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        boolean z;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                Album album = (Album) obj4;
                BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                boxWithConstraintsScopeImpl.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                }
                int i = iIntValue;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 19) != 18)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
                    PlayerConnection playerConnection = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
                    if (playerConnection != null) {
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                        String str = album.album.thumbnailUrl;
                        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer));
                        boolean z2 = this.f$1;
                        MenuKt.ItemThumbnail(str, z2, this.f$2, roundedCornerShapeM185RoundedCornerShape0680j_4, null, null, false, CropImageView.DEFAULT_ASPECT_RATIO, 0, gapComposer, 0, 496);
                        boolean z3 = !z2;
                        boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(musicDatabase) | gapComposer.changed(album) | gapComposer.changedInstance(playerConnection);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope, musicDatabase, (Object) album, (Object) playerConnection, (byte) 5);
                            gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                            objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda63;
                        }
                        MenuKt.AlbumPlayButton(boxWithConstraintsScopeImpl, z3, (Function0) objRememberedValue2, gapComposer, i & 14);
                    }
                }
                break;
            case 1:
                YTItem yTItem = (YTItem) obj4;
                BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl2 = (BoxWithConstraintsScopeImpl) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                boxWithConstraintsScopeImpl2.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(boxWithConstraintsScopeImpl2) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
                    PlayerConnection playerConnection2 = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
                    if (playerConnection2 != null) {
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer2);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue3;
                        String thumbnail = yTItem.getThumbnail();
                        SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer2));
                        boolean z4 = this.f$1;
                        MenuKt.ItemThumbnail(thumbnail, z4, this.f$2, roundedCornerShapeM185RoundedCornerShape0680j_5, null, null, false, CropImageView.DEFAULT_ASPECT_RATIO, 0, gapComposer2, 0, 496);
                        if (!(yTItem instanceof SongItem) || z4) {
                            gapComposer2.startReplaceGroup(-213387600);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-213471207);
                            MenuKt.OverlayPlayButton(boxWithConstraintsScopeImpl2, gapComposer2, (iIntValue2 & 14) | 48);
                            gapComposer2.end(false);
                        }
                        z = (yTItem instanceof AlbumItem) && !z4;
                        boolean zChangedInstance2 = gapComposer2.changedInstance(coroutineScope2) | gapComposer2.changedInstance(musicDatabase2) | gapComposer2.changedInstance(yTItem) | gapComposer2.changedInstance(playerConnection2);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                            SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda64 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope2, musicDatabase2, (Object) yTItem, (Object) playerConnection2, (byte) 4);
                            gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda64);
                            objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda64;
                        }
                        MenuKt.AlbumPlayButton(boxWithConstraintsScopeImpl2, z, (Function0) objRememberedValue4, gapComposer2, iIntValue2 & 14);
                    }
                }
                break;
            case 2:
                Song song = (Song) obj4;
                BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl3 = (BoxWithConstraintsScopeImpl) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                boxWithConstraintsScopeImpl3.getClass();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(boxWithConstraintsScopeImpl3) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    float fCurrentGridThumbnailHeight = MenuKt.currentGridThumbnailHeight(gapComposer3);
                    String str2 = song.song.thumbnailUrl;
                    SpringSpec springSpec3 = DimensionsKt.NavigationBarAnimationSpec;
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer3));
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, fCurrentGridThumbnailHeight);
                    boolean z5 = this.f$1;
                    MenuKt.ItemThumbnail(str2, z5, this.f$2, roundedCornerShapeM185RoundedCornerShape0680j_6, modifierM151size3ABfNKs, null, false, CropImageView.DEFAULT_ASPECT_RATIO, 0, gapComposer3, 0, 480);
                    if (!z5) {
                        gapComposer3.startReplaceGroup(-851419456);
                        MenuKt.OverlayPlayButton(boxWithConstraintsScopeImpl3, gapComposer3, (iIntValue3 & 14) | 48);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(-851335849);
                        gapComposer3.end(false);
                    }
                }
                break;
            default:
                Function0 function0 = (Function0) obj4;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    z = this.f$1 && this.f$2;
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_7 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f);
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    CardKt.Button(function0, modifierFillMaxWidth, z, roundedCornerShapeM185RoundedCornerShape0680j_7, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.tertiary, 0L, 0L, gapComposer4, 14), null, null, null, null, AlbumScreenKt.lambda$407910892, gapComposer4, 805306416, 480);
                }
                break;
        }
        return unit;
    }
}
