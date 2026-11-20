package androidx.media3.common.util;

import android.os.Handler;
import android.os.Message;
import coil3.util.UtilsKt;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemHandlerWrapper {
    public static final ArrayList messagePool = new ArrayList(50);
    public final Handler handler;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SystemMessage {
        public Message message;

        public final void recycle() {
            this.message = null;
            ArrayList arrayList = SystemHandlerWrapper.messagePool;
            synchronized (arrayList) {
                try {
                    if (arrayList.size() < 50) {
                        arrayList.add(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void sendToTarget() {
            Message message = this.message;
            message.getClass();
            message.sendToTarget();
            recycle();
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.handler = handler;
    }

    public static SystemMessage obtainSystemMessage() {
        SystemMessage systemMessage;
        ArrayList arrayList = messagePool;
        synchronized (arrayList) {
            try {
                systemMessage = arrayList.isEmpty() ? new SystemMessage() : (SystemMessage) arrayList.remove(arrayList.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemMessage;
    }

    public final SystemMessage obtainMessage(int i) {
        SystemMessage systemMessageObtainSystemMessage = obtainSystemMessage();
        systemMessageObtainSystemMessage.message = this.handler.obtainMessage(i);
        return systemMessageObtainSystemMessage;
    }

    public final void post(Runnable runnable) {
        this.handler.post(runnable);
    }

    public final void removeMessages(int i) {
        UtilsKt.checkArgument(i != 0);
        this.handler.removeMessages(i);
    }

    public final void sendEmptyMessage(int i) {
        this.handler.sendEmptyMessage(i);
    }

    public final SystemMessage obtainMessage(int i, Object obj) {
        SystemMessage systemMessageObtainSystemMessage = obtainSystemMessage();
        systemMessageObtainSystemMessage.message = this.handler.obtainMessage(i, obj);
        return systemMessageObtainSystemMessage;
    }
}
