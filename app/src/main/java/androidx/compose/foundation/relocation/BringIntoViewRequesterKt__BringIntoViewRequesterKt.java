package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class BringIntoViewRequesterKt__BringIntoViewRequesterKt {
    public static final Modifier bringIntoViewRequester(Modifier modifier, BringIntoViewRequesterImpl bringIntoViewRequesterImpl) {
        return modifier.then(new BringIntoViewRequesterElement(bringIntoViewRequesterImpl));
    }
}
