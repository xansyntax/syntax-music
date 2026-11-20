package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Tracks;
import androidx.media3.exoplayer.RendererConfiguration;
import coil3.util.UtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TrackSelectorResult {
    public final Object info;
    public final int length;
    public final RendererConfiguration[] rendererConfigurations;
    public final ExoTrackSelection[] selections;
    public final Tracks tracks;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, Tracks tracks, Object obj) {
        UtilsKt.checkArgument(rendererConfigurationArr.length == exoTrackSelectionArr.length);
        this.rendererConfigurations = rendererConfigurationArr;
        this.selections = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.tracks = tracks;
        this.info = obj;
        this.length = rendererConfigurationArr.length;
    }

    public final boolean isEquivalent(TrackSelectorResult trackSelectorResult, int i) {
        return Objects.equals(this.rendererConfigurations[i], trackSelectorResult.rendererConfigurations[i]) && Objects.equals(this.selections[i], trackSelectorResult.selections[i]);
    }

    public final boolean isRendererEnabled(int i) {
        return this.rendererConfigurations[i] != null;
    }
}
