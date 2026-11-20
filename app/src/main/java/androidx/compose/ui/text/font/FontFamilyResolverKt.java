package androidx.compose.ui.text.font;

import androidx.compose.ui.platform.WeakCache;
import androidx.emoji2.text.EmojiProcessor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FontFamilyResolverKt {
    public static final WeakCache GlobalTypefaceRequestCache = new WeakCache((byte) 12);
    public static final EmojiProcessor GlobalAsyncTypefaceCache = new EmojiProcessor((byte) 13);
}
