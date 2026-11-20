package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.emoji2.text.EmojiProcessor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LifecycleService extends Service implements LifecycleOwner {
    public final EmojiProcessor dispatcher = new EmojiProcessor(this);

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return (LifecycleRegistry) this.dispatcher.mSpanFactory;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        intent.getClass();
        EmojiProcessor emojiProcessor = this.dispatcher;
        emojiProcessor.getClass();
        emojiProcessor.postDispatchRunnable(Lifecycle.Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        EmojiProcessor emojiProcessor = this.dispatcher;
        emojiProcessor.getClass();
        emojiProcessor.postDispatchRunnable(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        EmojiProcessor emojiProcessor = this.dispatcher;
        emojiProcessor.getClass();
        emojiProcessor.postDispatchRunnable(Lifecycle.Event.ON_STOP);
        emojiProcessor.postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        EmojiProcessor emojiProcessor = this.dispatcher;
        emojiProcessor.getClass();
        emojiProcessor.postDispatchRunnable(Lifecycle.Event.ON_START);
        super.onStart(intent, i);
    }
}
