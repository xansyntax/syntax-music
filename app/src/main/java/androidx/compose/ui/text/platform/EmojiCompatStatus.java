package androidx.compose.ui.text.platform;

import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiCompatStatus {
    public static final AtomicInt delegate;

    static {
        AtomicInt atomicInt = new AtomicInt();
        atomicInt.delegate = EmojiCompat.isConfigured() ? atomicInt.getFontLoadState() : null;
        delegate = atomicInt;
    }
}
