package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiEditableFactory extends Editable.Factory {
    public static final Object INSTANCE_LOCK = new Object();
    public static volatile EmojiEditableFactory sInstance;
    public static Class sWatcherClass;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = sWatcherClass;
        return cls != null ? new SpannableBuilder(cls, charSequence) : super.newEditable(charSequence);
    }
}
