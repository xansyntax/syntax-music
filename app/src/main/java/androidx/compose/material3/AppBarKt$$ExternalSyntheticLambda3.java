package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppBarKt$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State f$0;

    public /* synthetic */ AppBarKt$$ExternalSyntheticLambda3(State state, byte b) {
        this.$r8$classId = b;
        this.f$0 = state;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SongEntity songEntity;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        State state = this.f$0;
        switch (b) {
            case 0:
                DrawScope drawScope = (DrawScope) obj;
                long j = ((Color) state.getValue()).value;
                if (!ULong.m1869equalsimpl0(j, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified))) {
                    DrawScope.m550drawRectnJ9OG0$default(drawScope, j, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 126);
                }
                return unit;
            case 1:
                ((ReusableGraphicsLayerScope) obj).setAlpha(((Number) state.getValue()).floatValue());
                return unit;
            case 2:
                ((ReusableGraphicsLayerScope) obj).setAlpha(((Number) state.getValue()).floatValue());
                return unit;
            case 3:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                reusableGraphicsLayerScope.setScaleX(((Number) state.getValue()).floatValue());
                reusableGraphicsLayerScope.setScaleY(((Number) state.getValue()).floatValue());
                return unit;
            case 4:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope2.getClass();
                reusableGraphicsLayerScope2.setScaleX(((Number) state.getValue()).floatValue());
                reusableGraphicsLayerScope2.setScaleY(((Number) state.getValue()).floatValue());
                return unit;
            case 5:
                Density density = (Density) obj;
                density.getClass();
                return new IntOffset((((long) density.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * (-24.0f)) + CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) density.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * (-24.0f)) + CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L));
            case 6:
                Density density2 = (Density) obj;
                density2.getClass();
                return new IntOffset((((long) density2.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * 24.0f) + CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) density2.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * (-24.0f)) + CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L));
            case 7:
                Density density3 = (Density) obj;
                density3.getClass();
                return new IntOffset((((long) density3.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * (-24.0f)) + CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) density3.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * 24.0f) + CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L));
            case 8:
                Density density4 = (Density) obj;
                density4.getClass();
                return new IntOffset((((long) density4.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * 24.0f) + CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) density4.mo75roundToPx0680j_4((((Number) state.getValue()).floatValue() * 24.0f) + CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L));
            case 9:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                Playlist playlist = (Playlist) state.getValue();
                if (playlist != null) {
                    musicDatabase.$$delegate_0.update(playlist.playlist.toggleLike());
                }
                return unit;
            default:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                Song song = (Song) state.getValue();
                if (song != null && (songEntity = song.song) != null) {
                    musicDatabase2.$$delegate_0.update(SongEntity.copy$default(songEntity, null, 0, null, null, null, false, null, null, null, null, null, 0, false, false, false, null, 134209535));
                }
                return unit;
        }
    }
}
