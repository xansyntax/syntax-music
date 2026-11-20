package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import com.google.common.math.IntMath;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Album f$0;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda4(Album album, byte b) {
        this.$r8$classId = b;
        this.f$0 = album;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        long j;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Album album = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    List list = album.artists;
                    String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer), ServerSentEventKt.SPACE);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    String strJoinToArtistString = UtilsKt.joinToArtistString(list, strM, (Function1) objRememberedValue);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strJoinToArtistString, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 0, 24960, 110586);
                }
                break;
            case 1:
                AlbumEntity albumEntity = album.album;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Painter painterPainterResource = IntMath.painterResource(albumEntity.bookmarkedAt != null ? R.drawable.favorite : R.drawable.favorite_border, 0, gapComposer2);
                    if (albumEntity.bookmarkedAt != null) {
                        gapComposer2.startReplaceGroup(-763450815);
                        j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                    } else {
                        gapComposer2.startReplaceGroup(-763449885);
                        j = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    gapComposer2.end(false);
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, (Modifier) null, j, gapComposer2, 56, 4);
                }
                break;
            default:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    List list2 = album.artists;
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 25);
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    TextKt.m352TextNvy7gAk(CollectionsKt.joinToString$default(list2, null, null, null, (Function1) objRememberedValue2, 31), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
