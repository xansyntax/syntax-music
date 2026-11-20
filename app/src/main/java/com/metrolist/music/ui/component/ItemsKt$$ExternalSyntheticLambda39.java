package com.metrolist.music.ui.component;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.yalantis.ucrop.R;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda39 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Playlist f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda39(boolean z, Playlist playlist) {
        this.$r8$classId = (byte) 1;
        this.f$1 = z;
        this.f$0 = playlist;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        String strPluralStringResource;
        Integer num;
        int i;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$1;
        Playlist playlist = this.f$0;
        byte b2 = 2;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    List thumbnails = playlist.getThumbnails();
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    MenuKt.m1490PlaylistThumbnailEUb7tLY(thumbnails, 48.0f, Expect_jvmKt.rememberComposableLambda(-858906445, new ItemsKt$$ExternalSyntheticLambda39(playlist, z, b2), gapComposer), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f), gapComposer, 384);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    if (z) {
                        gapComposer2.startReplaceGroup(1298350090);
                        gapComposer2.end(false);
                        strPluralStringResource = "";
                    } else {
                        gapComposer2.startReplaceGroup(1298396838);
                        int i2 = playlist.songCount;
                        PlaylistEntity playlistEntity = playlist.playlist;
                        if (i2 != 0 || (num = playlistEntity.remoteSongCount) == null) {
                            gapComposer2.startReplaceGroup(1298696360);
                            int i3 = playlist.songCount;
                            strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_song, i3, new Object[]{Integer.valueOf(i3)}, gapComposer2);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(1298475082);
                            strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_song, num.intValue(), new Object[]{num}, gapComposer2);
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(false);
                    }
                    String str = strPluralStringResource;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 24960, 110586);
                }
                break;
            default:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    String str2 = playlist.playlist.name;
                    gapComposer3.startReplaceGroup(-775371265);
                    if (Intrinsics.areEqual(str2, MathKt.stringResource(R.string.liked, gapComposer3))) {
                        i = R.drawable.favorite_border;
                    } else if (Intrinsics.areEqual(str2, MathKt.stringResource(R.string.offline, gapComposer3))) {
                        i = R.drawable.offline;
                    } else if (Intrinsics.areEqual(str2, MathKt.stringResource(R.string.cached_playlist, gapComposer3))) {
                        i = R.drawable.cached;
                    } else if (Intrinsics.areEqual(str2, MathKt.stringResource(R.string.uploaded_playlist, gapComposer3))) {
                        i = R.drawable.backup;
                    } else {
                        i = z ? R.drawable.trending_up : R.drawable.queue_music;
                    }
                    gapComposer3.end(false);
                    Painter painterPainterResource = IntMath.painterResource(i, 0, gapComposer3);
                    long j = ((Color) gapComposer3.consume(ContentColorKt.LocalContentColor)).value;
                    long jColor = ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.8f, Color.m483getColorSpaceimpl(j));
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 24.0f), jColor, gapComposer3, 56, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda39(Playlist playlist, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = playlist;
        this.f$1 = z;
    }
}
