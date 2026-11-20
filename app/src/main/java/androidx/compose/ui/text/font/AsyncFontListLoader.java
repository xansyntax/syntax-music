package androidx.compose.ui.text.font;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiProcessor;
import androidx.navigation.internal.NavContext;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncFontListLoader implements State {
    public boolean cacheable = true;
    public final List fontList;
    public final Function1 onCompletion;
    public final TypefaceRequest typefaceRequest;
    public final ParcelableSnapshotMutableState value$delegate;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncFontListLoader$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public List L$0;
        public ResourceFont L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsyncFontListLoader.this.load(this);
        }
    }

    public AsyncFontListLoader(List list, Object obj, TypefaceRequest typefaceRequest, EmojiProcessor emojiProcessor, Function1 function1, NavContext navContext) {
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.onCompletion = function1;
        this.value$delegate = Stack.mutableStateOf$default(obj);
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return this.value$delegate.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0095 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:14:0x0032, B:35:0x0095, B:21:0x0047, B:23:0x004c, B:27:0x0072, B:33:0x008b), top: B:40:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0095 -> B:36:0x009e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object load(kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
