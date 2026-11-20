package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import androidx.core.provider.FontRequestWorker;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26;
import androidx.media3.session.legacy.MediaSessionCompat$Token;
import androidx.navigation.NavDeepLinkRequest;
import androidx.room.concurrent.FileLock;
import coil3.ImageLoader$Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LimitedDispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityRecreator {
    public static final Class activityThreadClass;
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());
    public static final Field mainThreadField;
    public static final Method performStopActivity2ParamsMethod;
    public static final Method performStopActivity3ParamsMethod;
    public static final Method requestRelaunchActivityMethod;
    public static final Field tokenField;

    static {
        Class<?> cls;
        Field declaredField;
        Field declaredField2;
        Method declaredMethod;
        Method declaredMethod2;
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        activityThreadClass = cls;
        try {
            declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
        } catch (Throwable unused2) {
            declaredField = null;
        }
        mainThreadField = declaredField;
        try {
            declaredField2 = Activity.class.getDeclaredField("mToken");
            declaredField2.setAccessible(true);
        } catch (Throwable unused3) {
            declaredField2 = null;
        }
        tokenField = declaredField2;
        Class cls2 = activityThreadClass;
        Class cls3 = Boolean.TYPE;
        if (cls2 == null) {
            declaredMethod = null;
        } else {
            try {
                declaredMethod = cls2.getDeclaredMethod("performStopActivity", IBinder.class, cls3, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
                declaredMethod = null;
            }
        }
        performStopActivity3ParamsMethod = declaredMethod;
        Class cls4 = activityThreadClass;
        if (cls4 == null) {
            declaredMethod2 = null;
        } else {
            try {
                declaredMethod2 = cls4.getDeclaredMethod("performStopActivity", IBinder.class, cls3);
                declaredMethod2.setAccessible(true);
            } catch (Throwable unused5) {
                declaredMethod2 = null;
            }
        }
        performStopActivity2ParamsMethod = declaredMethod2;
        Class cls5 = activityThreadClass;
        int i = Build.VERSION.SDK_INT;
        if ((i == 26 || i == 27) && cls5 != null) {
            try {
                Class cls6 = Integer.TYPE;
                Class cls7 = Boolean.TYPE;
                Method declaredMethod3 = cls5.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, cls6, cls7, Configuration.class, Configuration.class, cls7, cls7);
                declaredMethod3.setAccessible(true);
                method = declaredMethod3;
            } catch (Throwable unused6) {
            }
        }
        requestRelaunchActivityMethod = method;
    }

    /* JADX INFO: renamed from: androidx.core.app.ActivityRecreator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public Object val$callbacks;
        public final Object val$token;

        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, byte b) {
            this.$r8$classId = b;
            this.val$callbacks = obj;
            this.val$token = obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Throwable thTryInternalFastPathGetFailure;
            int i = 0;
            switch (this.$r8$classId) {
                case 0:
                    ((LifecycleCheckCallbacks) this.val$callbacks).currentlyRecreatingToken = this.val$token;
                    return;
                case 1:
                    FutureCallback futureCallback = (FutureCallback) this.val$token;
                    ListenableFuture listenableFuture = (ListenableFuture) this.val$callbacks;
                    if ((listenableFuture instanceof InternalFutureFailureAccess) && (thTryInternalFastPathGetFailure = ((InternalFutureFailureAccess) listenableFuture).tryInternalFastPathGetFailure()) != null) {
                        futureCallback.onFailure(thTryInternalFastPathGetFailure);
                        return;
                    }
                    try {
                        futureCallback.onSuccess(UuidKt.getDone(listenableFuture));
                        return;
                    } catch (ExecutionException e) {
                        futureCallback.onFailure(e.getCause());
                        return;
                    } catch (Throwable th) {
                        futureCallback.onFailure(th);
                        return;
                    }
                case 2:
                    ((Application) this.val$token).unregisterActivityLifecycleCallbacks((LifecycleCheckCallbacks) this.val$callbacks);
                    return;
                case 3:
                    Object obj = this.val$callbacks;
                    Object obj2 = this.val$token;
                    try {
                        Method method = ActivityRecreator.performStopActivity3ParamsMethod;
                        if (method != null) {
                            method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                        } else {
                            ActivityRecreator.performStopActivity2ParamsMethod.invoke(obj2, obj, Boolean.FALSE);
                        }
                        return;
                    } catch (RuntimeException e2) {
                        if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                        return;
                    } catch (Throwable th2) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
                        return;
                    }
                case 4:
                    AtomicInt atomicInt = (AtomicInt) this.val$callbacks;
                    Typeface typeface = (Typeface) this.val$token;
                    TimedValueQueue timedValueQueue = (TimedValueQueue) atomicInt.delegate;
                    if (timedValueQueue != null) {
                        timedValueQueue.onFontRetrieved(typeface);
                        return;
                    }
                    return;
                case 5:
                    ((FontRequestWorker.AnonymousClass2) this.val$callbacks).accept(this.val$token);
                    return;
                case 6:
                    ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) this.val$token;
                    MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) this.val$callbacks;
                    ArrayList arrayList = (ArrayList) imageLoader$Builder.application;
                    if (!arrayList.isEmpty()) {
                        IMediaSession extraBinder = mediaSessionCompat$Token.getExtraBinder();
                        if (extraBinder != null) {
                            int size = arrayList.size();
                            while (i < size) {
                                Object obj3 = arrayList.get(i);
                                i++;
                                ((Bundle) obj3).putBinder("extra_session_binder", extraBinder.asBinder());
                            }
                        }
                        arrayList.clear();
                    }
                    MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 = (MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26) imageLoader$Builder.defaults;
                    mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.getClass();
                    mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.setSessionToken(mediaSessionCompat$Token.inner);
                    return;
                case 7:
                    IBinder binder = ((Messenger) ((MediaBrowserCompat) this.val$callbacks).impl).getBinder();
                    MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord) ((MediaLibraryServiceLegacyStub) ((MediaBrowserCompat) this.val$token).impl).connections.remove(binder);
                    if (mediaBrowserServiceCompat$ConnectionRecord != null) {
                        binder.unlinkToDeath(mediaBrowserServiceCompat$ConnectionRecord, 0);
                        return;
                    }
                    return;
                case 8:
                    ((CancellableContinuationImpl) this.val$token).resumeUndispatched((ExecutorCoroutineDispatcherImpl) this.val$callbacks);
                    return;
            }
            while (true) {
                try {
                    ((Runnable) this.val$callbacks).run();
                } catch (Throwable th3) {
                    AwaitKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th3);
                }
                try {
                    Runnable runnableObtainTaskOrDeallocateWorker = ((LimitedDispatcher) this.val$token).obtainTaskOrDeallocateWorker();
                    if (runnableObtainTaskOrDeallocateWorker == null) {
                        return;
                    }
                    this.val$callbacks = runnableObtainTaskOrDeallocateWorker;
                    i++;
                    if (i >= 16) {
                        LimitedDispatcher limitedDispatcher = (LimitedDispatcher) this.val$token;
                        if (InlineList.safeIsDispatchNeeded(limitedDispatcher.dispatcher, limitedDispatcher)) {
                            LimitedDispatcher limitedDispatcher2 = (LimitedDispatcher) this.val$token;
                            InlineList.safeDispatch(limitedDispatcher2.dispatcher, limitedDispatcher2, this);
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    LimitedDispatcher limitedDispatcher3 = (LimitedDispatcher) this.val$token;
                    synchronized (limitedDispatcher3.workerAllocationLock) {
                        LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(limitedDispatcher3);
                        throw th4;
                    }
                }
            }
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 1:
                    NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(AnonymousClass1.class.getSimpleName());
                    FutureCallback futureCallback = (FutureCallback) this.val$token;
                    FileLock fileLock = new FileLock();
                    ((FileLock) navDeepLinkRequest.mimeType).lockChannel = fileLock;
                    navDeepLinkRequest.mimeType = fileLock;
                    fileLock.lockFilename = futureCallback;
                    return navDeepLinkRequest.toString();
                default:
                    return super.toString();
            }
        }

        public /* synthetic */ AnonymousClass1(Object obj, boolean z, Object obj2, byte b) {
            this.$r8$classId = b;
            this.val$token = obj;
            this.val$callbacks = obj2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        public Object currentlyRecreatingToken;
        public Activity mActivity;
        public final int mRecreatingHashCode;
        public boolean mStarted = false;
        public boolean mDestroyed = false;
        public boolean mStopQueued = false;

        public LifecycleCheckCallbacks(Activity activity) {
            this.mActivity = activity;
            this.mRecreatingHashCode = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            if (!this.mDestroyed || this.mStopQueued || this.mStarted) {
                return;
            }
            Object obj = this.currentlyRecreatingToken;
            try {
                Object obj2 = ActivityRecreator.tokenField.get(activity);
                if (obj2 == obj && activity.hashCode() == this.mRecreatingHashCode) {
                    ActivityRecreator.mainHandler.postAtFrontOfQueue(new AnonymousClass1(ActivityRecreator.mainThreadField.get(activity), false, obj2, (byte) 3));
                    this.mStopQueued = true;
                    this.currentlyRecreatingToken = null;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while fetching field values", th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
