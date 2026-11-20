package androidx.core.app;

import android.app.PictureInPictureUiState;
import android.os.Build;
import androidx.collection.internal.Lock;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PictureInPictureUiStateCompat$Companion {
    public static Lock fromPictureInPictureUiState(PictureInPictureUiState pictureInPictureUiState) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            pictureInPictureUiState.isStashed();
            pictureInPictureUiState.isTransitioningToPip();
            return new Lock((byte) 10);
        }
        if (i < 31) {
            return new Lock((byte) 10);
        }
        pictureInPictureUiState.isStashed();
        return new Lock((byte) 10);
    }
}
