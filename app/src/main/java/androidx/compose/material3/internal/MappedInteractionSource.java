package androidx.compose.material3.internal;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MappedInteractionSource implements InteractionSource {
    public final Function0 calculateDelta;
    public final DownloadUtil$getDownload$$inlined$map$1 interactions;
    public final LinkedHashMap mappedPresses = new LinkedHashMap();

    public MappedInteractionSource(MutableInteractionSourceImpl mutableInteractionSourceImpl, Function0 function0) {
        this.calculateDelta = function0;
        this.interactions = new DownloadUtil$getDownload$$inlined$map$1(mutableInteractionSourceImpl.interactions, this, (byte) 1);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public final Flow getInteractions() {
        return this.interactions;
    }
}
