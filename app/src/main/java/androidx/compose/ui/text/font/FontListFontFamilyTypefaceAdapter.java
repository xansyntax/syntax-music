package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.DispatcherKt;
import androidx.emoji2.text.EmojiProcessor;
import coil3.RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapter {
    public static final RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1 DropExceptionHandler = new RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE, (byte) 1);
    public final ContextScope asyncLoadScope = AwaitKt.CoroutineScope(DropExceptionHandler.plus(DispatcherKt.FontCacheManagementDispatcher).plus(EmptyCoroutineContext.INSTANCE).plus(new SupervisorJobImpl(null)));
    public final EmojiProcessor asyncTypefaceCache;

    public FontListFontFamilyTypefaceAdapter(EmojiProcessor emojiProcessor) {
        this.asyncTypefaceCache = emojiProcessor;
    }
}
