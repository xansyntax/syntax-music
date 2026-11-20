package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.emoji2.text.EmojiProcessor;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    public static final EmojiProcessor calculationBlockNestedLevel = new EmojiProcessor((byte) 6);
    public static final EmojiProcessor derivedStateObservers = new EmojiProcessor((byte) 6);

    public static final MutableVector derivedStateObservers() {
        EmojiProcessor emojiProcessor = derivedStateObservers;
        MutableVector mutableVector = (MutableVector) emojiProcessor.get();
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector mutableVector2 = new MutableVector(new GapComposer$derivedStateObserver$1[0]);
        emojiProcessor.set(mutableVector2);
        return mutableVector2;
    }

    public static final DerivedSnapshotState derivedStateOf(Function0 function0) {
        return new DerivedSnapshotState(function0, null);
    }
}
