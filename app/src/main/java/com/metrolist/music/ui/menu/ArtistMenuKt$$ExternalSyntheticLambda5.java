package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.compose.AsyncImageKt;
import coil3.request.CachePolicy;
import coil3.request.ImageRequest;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ArtistMenuKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Artist f$0;

    public /* synthetic */ ArtistMenuKt$$ExternalSyntheticLambda5(Artist artist, byte b) {
        this.$r8$classId = b;
        this.f$0 = artist;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int i2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Artist artist = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(artist.artist.bookmarkedAt != null ? R.drawable.subscribed : R.drawable.subscribe, 0, gapComposer), (String) null, (Modifier) null, 0L, gapComposer, 56, 12);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ImageRequest.Builder builder = new ImageRequest.Builder((Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext));
                    String str = artist.artist.thumbnailUrl;
                    builder.data = str != null ? YouTubeUtilsKt.resize(str, 144, 144) : null;
                    CachePolicy cachePolicy = CachePolicy.ENABLED;
                    builder.memoryCachePolicy = cachePolicy;
                    builder.diskCachePolicy = cachePolicy;
                    builder.networkCachePolicy = cachePolicy;
                    ImageRequest imageRequestBuild = builder.build();
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    AsyncImageKt.m849AsyncImage10Xjiaw(imageRequestBuild, ClipKt.clip(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 48.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f)), null, gapComposer2, 48, 2040);
                }
                break;
            default:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    if (artist.artist.bookmarkedAt != null) {
                        i = -941500389;
                        i2 = R.string.subscribed;
                    } else {
                        i = -941499078;
                        i2 = R.string.subscribe;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer3, i, i2, gapComposer3, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
