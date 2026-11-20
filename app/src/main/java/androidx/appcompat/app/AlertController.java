package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.MediaCodec;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.appcompat.view.menu.MenuDialogHelper;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.app.ActivityRecreator;
import androidx.core.widget.NestedScrollView;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.CopyOnWriteMultiset;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.MediaDrmCallback$Response;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaSession$ControllerCb;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$ServiceBinderImpl$6;
import androidx.media3.session.legacy.MediaSessionCompat$Callback;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import com.google.common.collect.ImmutableList;
import com.yalantis.ucrop.R;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlertController {
    public ListAdapter mAdapter;
    public final int mAlertDialogLayout;
    public Button mButtonNegative;
    public Button mButtonNeutral;
    public Button mButtonPositive;
    public final Context mContext;
    public View mCustomTitleView;
    public final AlertDialog mDialog;
    public final ButtonHandler mHandler;
    public Drawable mIcon;
    public ImageView mIconView;
    public final int mListItemLayout;
    public final int mListLayout;
    public RecycleListView mListView;
    public TextView mMessageView;
    public NestedScrollView mScrollView;
    public final boolean mShowTitle;
    public final int mSingleChoiceItemLayout;
    public CharSequence mTitle;
    public TextView mTitleView;
    public final Window mWindow;
    public int mCheckedItem = -1;
    public final Toolbar.AnonymousClass4 mButtonHandler = new Toolbar.AnonymousClass4(1, this);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes2.dex */
    public final class AlertParams {
        public ListAdapter mAdapter;
        public int mCheckedItem = -1;
        public final ContextThemeWrapper mContext;
        public View mCustomTitleView;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public boolean mIsSingleChoice;
        public DialogInterface.OnClickListener mOnClickListener;
        public MenuDialogHelper mOnKeyListener;
        public CharSequence mTitle;

        public AlertParams(ContextThemeWrapper contextThemeWrapper) {
            this.mContext = contextThemeWrapper;
            this.mInflater = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CheckedItemAdapter extends ArrayAdapter {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, AlertDialog alertDialog, Window window) {
        this.mContext = context;
        this.mDialog = alertDialog;
        this.mWindow = window;
        ButtonHandler buttonHandler = new ButtonHandler();
        buttonHandler.mDialog = new WeakReference(alertDialog);
        this.mHandler = buttonHandler;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.mListLayout = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.mSingleChoiceItemLayout = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.mListItemLayout = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.mShowTitle = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        alertDialog.getDelegate().requestWindowFeature(1);
    }

    public static ViewGroup resolvePanel(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ButtonHandler extends Handler {
        public final /* synthetic */ byte $r8$classId;
        public Object mDialog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ButtonHandler(Looper looper, Dispatcher dispatcher) {
            super(looper);
            this.$r8$classId = (byte) 4;
            this.mDialog = dispatcher;
        }

        private final void handleMessage$androidx$media3$exoplayer$mediacodec$AsynchronousMediaCodecBufferEnqueuer$1(Message message) {
            AsynchronousMediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer = (AsynchronousMediaCodecBufferEnqueuer) this.mDialog;
            int i = message.what;
            AsynchronousMediaCodecBufferEnqueuer.MessageParams messageParams = null;
            if (i == 1) {
                AsynchronousMediaCodecBufferEnqueuer.MessageParams messageParams2 = (AsynchronousMediaCodecBufferEnqueuer.MessageParams) message.obj;
                try {
                    asynchronousMediaCodecBufferEnqueuer.codec.queueInputBuffer(messageParams2.index, 0, messageParams2.size, messageParams2.presentationTimeUs, messageParams2.flags);
                } catch (RuntimeException e) {
                    AtomicReference atomicReference = asynchronousMediaCodecBufferEnqueuer.pendingRuntimeException;
                    while (!atomicReference.compareAndSet(null, e) && atomicReference.get() == null) {
                    }
                }
                messageParams = messageParams2;
            } else if (i == 2) {
                AsynchronousMediaCodecBufferEnqueuer.MessageParams messageParams3 = (AsynchronousMediaCodecBufferEnqueuer.MessageParams) message.obj;
                int i2 = messageParams3.index;
                MediaCodec.CryptoInfo cryptoInfo = messageParams3.cryptoInfo;
                long j = messageParams3.presentationTimeUs;
                int i3 = messageParams3.flags;
                try {
                    if (Build.VERSION.SDK_INT >= 31) {
                        asynchronousMediaCodecBufferEnqueuer.codec.queueSecureInputBuffer(i2, 0, cryptoInfo, j, i3);
                    } else {
                        synchronized (AsynchronousMediaCodecBufferEnqueuer.QUEUE_SECURE_LOCK) {
                            asynchronousMediaCodecBufferEnqueuer.codec.queueSecureInputBuffer(i2, 0, cryptoInfo, j, i3);
                        }
                    }
                } catch (RuntimeException e2) {
                    AtomicReference atomicReference2 = asynchronousMediaCodecBufferEnqueuer.pendingRuntimeException;
                    while (!atomicReference2.compareAndSet(null, e2) && atomicReference2.get() == null) {
                    }
                }
                messageParams = messageParams3;
            } else if (i == 3) {
                asynchronousMediaCodecBufferEnqueuer.conditionVariable.open();
            } else if (i != 4) {
                AtomicReference atomicReference3 = asynchronousMediaCodecBufferEnqueuer.pendingRuntimeException;
                IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(i));
                while (!atomicReference3.compareAndSet(null, illegalStateException) && atomicReference3.get() == null) {
                }
            } else {
                try {
                    asynchronousMediaCodecBufferEnqueuer.codec.setParameters((Bundle) message.obj);
                } catch (RuntimeException e3) {
                    AtomicReference atomicReference4 = asynchronousMediaCodecBufferEnqueuer.pendingRuntimeException;
                    while (!atomicReference4.compareAndSet(null, e3) && atomicReference4.get() == null) {
                    }
                }
            }
            if (messageParams != null) {
                ArrayDeque arrayDeque = AsynchronousMediaCodecBufferEnqueuer.MESSAGE_PARAMS_INSTANCE_POOL;
                synchronized (arrayDeque) {
                    arrayDeque.add(messageParams);
                }
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            CueDecoder cueDecoder;
            Set set;
            MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23;
            MediaSessionCompat$Callback mediaSessionCompat$Callback;
            ButtonHandler buttonHandler;
            MediaSessionCompat$Callback mediaSessionCompat$Callback2;
            boolean z = false;
            byte b = 1;
            switch (this.$r8$classId) {
                case 0:
                    int i = message.what;
                    if (i == -3 || i == -2 || i == -1) {
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.mDialog).get(), message.what);
                        return;
                    } else {
                        if (i != 1) {
                            return;
                        }
                        ((DialogInterface) message.obj).dismiss();
                        return;
                    }
                case 1:
                    Pair pair = (Pair) message.obj;
                    Object obj = pair.first;
                    Object obj2 = pair.second;
                    int i2 = message.what;
                    if (i2 == 1) {
                        DefaultDrmSession defaultDrmSession = (DefaultDrmSession) this.mDialog;
                        WeakCache weakCache = defaultDrmSession.provisioningManager;
                        if (obj == defaultDrmSession.currentProvisionRequest) {
                            if (defaultDrmSession.state == 2 || defaultDrmSession.isOpen()) {
                                defaultDrmSession.currentProvisionRequest = null;
                                if (obj2 instanceof Exception) {
                                    weakCache.onProvisionError((Exception) obj2, false);
                                    return;
                                }
                                try {
                                    defaultDrmSession.mediaDrm.provideProvisionResponse(((MediaDrmCallback$Response) obj2).data);
                                    weakCache.referenceQueue = null;
                                    HashSet hashSet = (HashSet) weakCache.values;
                                    ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) hashSet);
                                    hashSet.clear();
                                    ImmutableList.Itr itrListIterator = immutableListCopyOf.listIterator(0);
                                    while (itrListIterator.hasNext()) {
                                        DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) itrListIterator.next();
                                        if (defaultDrmSession2.openInternal()) {
                                            defaultDrmSession2.doLicense(true);
                                        }
                                    }
                                    return;
                                } catch (Exception e) {
                                    weakCache.onProvisionError(e, true);
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if (i2 != 2) {
                        return;
                    }
                    DefaultDrmSession defaultDrmSession3 = (DefaultDrmSession) this.mDialog;
                    if (obj == defaultDrmSession3.currentKeyRequest && defaultDrmSession3.isOpen()) {
                        defaultDrmSession3.currentKeyRequest = null;
                        synchronized (defaultDrmSession3.keyRequestInfoLock) {
                            AtomicInt atomicInt = defaultDrmSession3.currentKeyRequestInfo;
                            atomicInt.getClass();
                            cueDecoder = new CueDecoder(b);
                            ((ImmutableList.Builder) atomicInt.delegate).build();
                            defaultDrmSession3.currentKeyRequestInfo = null;
                            break;
                        }
                        if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                            defaultDrmSession3.onKeysError((Throwable) obj2, false);
                            return;
                        }
                        try {
                            byte[] bArrProvideKeyResponse = defaultDrmSession3.mediaDrm.provideKeyResponse(defaultDrmSession3.sessionId, ((MediaDrmCallback$Response) obj2).data);
                            if (defaultDrmSession3.offlineLicenseKeySetId != null && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                                defaultDrmSession3.offlineLicenseKeySetId = bArrProvideKeyResponse;
                            }
                            defaultDrmSession3.state = (byte) 4;
                            CopyOnWriteMultiset copyOnWriteMultiset = defaultDrmSession3.eventDispatchers;
                            synchronized (copyOnWriteMultiset.lock) {
                                set = copyOnWriteMultiset.elementSet;
                                break;
                            }
                            Iterator it = set.iterator();
                            while (it.hasNext()) {
                                ((DrmSessionEventListener.EventDispatcher) it.next()).drmKeysLoaded(cueDecoder);
                            }
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            defaultDrmSession3.onKeysError(e, true);
                            return;
                        } catch (NoSuchMethodError e3) {
                            e = e3;
                            defaultDrmSession3.onKeysError(e, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    byte[] bArr = (byte[]) message.obj;
                    if (bArr == null) {
                        return;
                    }
                    ArrayList arrayList = ((DefaultDrmSessionManager) this.mDialog).sessions;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj3 = arrayList.get(i3);
                        i3++;
                        DefaultDrmSession defaultDrmSession4 = (DefaultDrmSession) obj3;
                        defaultDrmSession4.verifyPlaybackThread();
                        if (Arrays.equals(defaultDrmSession4.sessionId, bArr)) {
                            if (message.what == 2 && defaultDrmSession4.state == 4) {
                                String str = Util.DEVICE_DEBUG_INFO;
                                defaultDrmSession4.doLicense(false);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 3:
                    handleMessage$androidx$media3$exoplayer$mediacodec$AsynchronousMediaCodecBufferEnqueuer$1(message);
                    return;
                case 4:
                    MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) message.obj;
                    Dispatcher dispatcher = (Dispatcher) this.mDialog;
                    if (dispatcher.isConnected(mediaSession$ControllerInfo)) {
                        MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
                        mediaSession$ControllerCb.getClass();
                        mediaSession$ControllerCb.onDisconnected();
                        dispatcher.removeController(mediaSession$ControllerInfo);
                        return;
                    }
                    return;
                case 5:
                    MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) this.mDialog;
                    if (mediaLibraryServiceLegacyStub == null) {
                        removeCallbacksAndMessages(null);
                        return;
                    }
                    final MediaBrowserCompat mediaBrowserCompat = mediaLibraryServiceLegacyStub.serviceBinderImpl;
                    Bundle data = message.getData();
                    switch (message.what) {
                        case 3:
                            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(data.getBundle("data_options"));
                            ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).handler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$6(mediaBrowserCompat, new MediaBrowserCompat(message.replyTo), data.getString("data_media_item_id"), data.getBinder("data_callback_token"), bundleConvertToNullIfInvalid));
                            return;
                        case 4:
                            ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).handler.postOrRun(new CascadingMenuPopup$3$1(mediaBrowserCompat, new MediaBrowserCompat(message.replyTo), data.getString("data_media_item_id"), data.getBinder("data_callback_token"), (byte) 2));
                            return;
                        case 5:
                            String string = data.getString("data_media_item_id");
                            ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                            MediaBrowserCompat mediaBrowserCompat2 = new MediaBrowserCompat(message.replyTo);
                            mediaBrowserCompat.getClass();
                            if (TextUtils.isEmpty(string) || resultReceiver == null) {
                                return;
                            }
                            ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).handler.postOrRun(new CascadingMenuPopup$3$1(mediaBrowserCompat, mediaBrowserCompat2, string, resultReceiver, (byte) 3));
                            return;
                        case 6:
                            final Bundle bundleConvertToNullIfInvalid2 = Util.convertToNullIfInvalid(data.getBundle("data_root_hints"));
                            final MediaBrowserCompat mediaBrowserCompat3 = new MediaBrowserCompat(message.replyTo);
                            final String string2 = data.getString("data_package_name");
                            final int i4 = data.getInt("data_calling_pid");
                            final int i5 = data.getInt("data_calling_uid");
                            ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).handler.postOrRun(new Runnable(mediaBrowserCompat3, i5, string2, i4, bundleConvertToNullIfInvalid2) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat$ServiceBinderImpl$4
                                public final /* synthetic */ MediaBrowserCompat val$callbacks;
                                public final /* synthetic */ int val$pid;
                                public final /* synthetic */ String val$pkg;
                                public final /* synthetic */ int val$uid;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
                                    MediaBrowserCompat mediaBrowserCompat4 = this.val$callbacks;
                                    IBinder binder = ((Messenger) mediaBrowserCompat4.impl).getBinder();
                                    MediaBrowserCompat mediaBrowserCompat5 = this.this$1;
                                    ((MediaLibraryServiceLegacyStub) mediaBrowserCompat5.impl).connections.remove(binder);
                                    MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) mediaBrowserCompat5.impl;
                                    Iterator it2 = mediaLibraryServiceLegacyStub2.pendingConnections.iterator();
                                    while (true) {
                                        mediaBrowserServiceCompat$ConnectionRecord = null;
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord2 = (MediaBrowserServiceCompat$ConnectionRecord) it2.next();
                                        if (mediaBrowserServiceCompat$ConnectionRecord2.uid == this.val$uid) {
                                            mediaBrowserServiceCompat$ConnectionRecord = (TextUtils.isEmpty(this.val$pkg) || this.val$pid <= 0) ? new MediaBrowserServiceCompat$ConnectionRecord(mediaLibraryServiceLegacyStub2, mediaBrowserServiceCompat$ConnectionRecord2.pkg, mediaBrowserServiceCompat$ConnectionRecord2.pid, mediaBrowserServiceCompat$ConnectionRecord2.uid, mediaBrowserCompat4) : null;
                                            it2.remove();
                                            break;
                                        }
                                    }
                                    if (mediaBrowserServiceCompat$ConnectionRecord == null) {
                                        mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(mediaLibraryServiceLegacyStub2, this.val$pkg, this.val$pid, this.val$uid, mediaBrowserCompat4);
                                    }
                                    mediaLibraryServiceLegacyStub2.connections.put(binder, mediaBrowserServiceCompat$ConnectionRecord);
                                    try {
                                        binder.linkToDeath(mediaBrowserServiceCompat$ConnectionRecord, 0);
                                    } catch (RemoteException unused) {
                                        Log.w("MBServiceCompat", "IBinder is already dead.");
                                    }
                                }
                            });
                            return;
                        case 7:
                            ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).handler.postOrRun(new ActivityRecreator.AnonymousClass1(mediaBrowserCompat, z, new MediaBrowserCompat(message.replyTo), (byte) 7));
                            return;
                        case 8:
                            Bundle bundleConvertToNullIfInvalid3 = Util.convertToNullIfInvalid(data.getBundle("data_search_extras"));
                            String string3 = data.getString("data_search_query");
                            ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                            MediaBrowserCompat mediaBrowserCompat4 = new MediaBrowserCompat(message.replyTo);
                            mediaBrowserCompat.getClass();
                            if (TextUtils.isEmpty(string3) || resultReceiver2 == null) {
                                return;
                            }
                            ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).handler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$6(mediaBrowserCompat, mediaBrowserCompat4, string3, bundleConvertToNullIfInvalid3, resultReceiver2, (byte) 0));
                            return;
                        case 9:
                            Bundle bundleConvertToNullIfInvalid4 = Util.convertToNullIfInvalid(data.getBundle("data_custom_action_extras"));
                            String string4 = data.getString("data_custom_action");
                            ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                            MediaBrowserCompat mediaBrowserCompat5 = new MediaBrowserCompat(message.replyTo);
                            mediaBrowserCompat.getClass();
                            if (TextUtils.isEmpty(string4) || resultReceiver3 == null) {
                                return;
                            }
                            ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).handler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$6(mediaBrowserCompat, mediaBrowserCompat5, string4, bundleConvertToNullIfInvalid4, resultReceiver3, (byte) 1));
                            return;
                        default:
                            Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                            return;
                    }
                default:
                    if (message.what == 1) {
                        synchronized (((MediaSessionCompat$Callback) this.mDialog).lock) {
                            mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) ((WeakReference) ((MediaSessionCompat$Callback) this.mDialog).sessionImpl).get();
                            mediaSessionCompat$Callback = (MediaSessionCompat$Callback) this.mDialog;
                            buttonHandler = (ButtonHandler) mediaSessionCompat$Callback.callbackHandler;
                            break;
                        }
                        if (mediaSessionCompat$MediaSessionImplApi23 != null) {
                            synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
                                mediaSessionCompat$Callback2 = mediaSessionCompat$MediaSessionImplApi23.callback;
                                break;
                            }
                            if (mediaSessionCompat$Callback != mediaSessionCompat$Callback2 || buttonHandler == null) {
                                return;
                            }
                            mediaSessionCompat$MediaSessionImplApi23.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo) message.obj);
                            ((MediaSessionCompat$Callback) this.mDialog).handleMediaPlayPauseIfPendingOnHandler(mediaSessionCompat$MediaSessionImplApi23, buttonHandler);
                            mediaSessionCompat$MediaSessionImplApi23.setCurrentControllerInfo(null);
                            return;
                        }
                        return;
                    }
                    return;
            }
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            switch (this.$r8$classId) {
                case 5:
                    Bundle data = message.getData();
                    ClassLoader classLoader = MediaBrowserCompat.class.getClassLoader();
                    classLoader.getClass();
                    data.setClassLoader(classLoader);
                    data.putInt("data_calling_uid", Binder.getCallingUid());
                    int callingPid = Binder.getCallingPid();
                    if (callingPid > 0) {
                        data.putInt("data_calling_pid", callingPid);
                    } else if (!data.containsKey("data_calling_pid")) {
                        data.putInt("data_calling_pid", -1);
                    }
                    break;
            }
            return super.sendMessageAtTime(message, j);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ButtonHandler(Looper looper) {
            super(looper);
            this.$r8$classId = (byte) 5;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ButtonHandler(Object obj, Looper looper, byte b) {
            super(looper);
            this.$r8$classId = b;
            this.mDialog = obj;
        }

        public /* synthetic */ ButtonHandler() {
            this.$r8$classId = (byte) 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class RecycleListView extends ListView {
        public final int mPaddingBottomNoButtons;
        public final int mPaddingTopNoTitle;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.mPaddingBottomNoButtons = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.mPaddingTopNoTitle = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }

        public RecycleListView(Context context) {
            this(context, null);
        }
    }
}
