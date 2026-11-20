package androidx.media3.session;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.service.media.MediaBrowserService;
import android.text.TextUtils;
import androidx.activity.EdgeToEdge$$ExternalSyntheticLambda0;
import androidx.appcompat.app.AlertController;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityRecreator;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.session.CommandButton;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.LibraryResult;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaLibraryServiceLegacyStub.BrowserLegacyCb;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ConnectionResult;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda3;
import androidx.media3.session.MediaUtils;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$2;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$Result;
import androidx.media3.session.legacy.MediaSessionCompat$Token;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.ImageLoader$Builder;
import coil3.util.UtilsKt;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaLibraryServiceLegacyStub extends Service {
    public final Dispatcher connectedControllersManager;
    public MediaBrowserServiceCompat$ConnectionRecord curConnection;
    public final AlertController.ButtonHandler handler;
    public ImageLoader$Builder impl;
    public final MediaLibrarySessionImpl librarySessionImpl;
    public final MediaBrowserCompat manager;
    public MediaSessionCompat$Token session;
    public final MediaLibrarySessionImpl sessionImpl;
    public final MediaBrowserCompat serviceBinderImpl = new MediaBrowserCompat(this);
    public final MediaBrowserServiceCompat$ConnectionRecord connectionFromFwk = new MediaBrowserServiceCompat$ConnectionRecord(this, "android.media.session.MediaController", -1, -1, null);
    public final ArrayList pendingConnections = new ArrayList();
    public final ArrayMap connections = new ArrayMap(0);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class BrowserLegacyCb implements MediaSession$ControllerCb {
        public final MediaSessionManager$RemoteUserInfo remoteUserInfo;
        public final Object lock = new Object();
        public final ArrayList searchRequests = new ArrayList();

        public BrowserLegacyCb(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
            this.remoteUserInfo = mediaSessionManager$RemoteUserInfo;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BrowserLegacyCb) {
                return this.remoteUserInfo.equals(((BrowserLegacyCb) obj).remoteUserInfo);
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.remoteUserInfo);
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onSearchResultChanged(int i, String str, MediaLibraryService.LibraryParams libraryParams) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.lock) {
                try {
                    for (int size = this.searchRequests.size() - 1; size >= 0; size--) {
                        SearchRequest searchRequest = (SearchRequest) this.searchRequests.get(size);
                        if (this.remoteUserInfo.equals(searchRequest.remoteUserInfo) && searchRequest.query.equals(str)) {
                            arrayList.add(searchRequest);
                            this.searchRequests.remove(size);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    Util.postOrRun(MediaLibraryServiceLegacyStub.this.librarySessionImpl.applicationHandler, new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, (Object) arrayList, (byte) 8));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SearchRequest {
        public final MediaSession$ControllerInfo controller;
        public final Bundle extras;
        public final String query;
        public final MediaSessionManager$RemoteUserInfo remoteUserInfo;
        public final MediaBrowserServiceCompat$2 result;

        public SearchRequest(MediaSession$ControllerInfo mediaSession$ControllerInfo, MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String str, Bundle bundle, MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2) {
            this.controller = mediaSession$ControllerInfo;
            this.remoteUserInfo = mediaSessionManager$RemoteUserInfo;
            this.query = str;
            this.extras = bundle;
            this.result = mediaBrowserServiceCompat$2;
        }
    }

    public MediaLibraryServiceLegacyStub(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        AlertController.ButtonHandler buttonHandler = new AlertController.ButtonHandler(looperMyLooper);
        buttonHandler.mDialog = this;
        this.handler = buttonHandler;
        this.manager = MediaBrowserCompat.getSessionManager(mediaLibrarySessionImpl.context);
        this.sessionImpl = mediaLibrarySessionImpl;
        this.connectedControllersManager = new Dispatcher(mediaLibrarySessionImpl);
        this.librarySessionImpl = mediaLibrarySessionImpl;
    }

    public final MediaSession$ControllerInfo getCurrentController() {
        ImageLoader$Builder imageLoader$Builder = this.impl;
        imageLoader$Builder.getClass();
        return this.connectedControllersManager.getController(imageLoader$Builder.getCurrentBrowserInfo());
    }

    public final void initialize(MediaSessionCompat$Token mediaSessionCompat$Token) {
        attachBaseContext(this.sessionImpl.context);
        onCreate();
        if (mediaSessionCompat$Token == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Session token may not be null");
            return;
        }
        if (this.session != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("The session token has already been set");
            return;
        }
        this.session = mediaSessionCompat$Token;
        ImageLoader$Builder imageLoader$Builder = this.impl;
        imageLoader$Builder.getClass();
        ((MediaLibraryServiceLegacyStub) imageLoader$Builder.diskCacheLazy).handler.postOrRun(new ActivityRecreator.AnonymousClass1(imageLoader$Builder, false, mediaSessionCompat$Token, (byte) 6));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        ImageLoader$Builder imageLoader$Builder = this.impl;
        imageLoader$Builder.getClass();
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 = (MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26) imageLoader$Builder.defaults;
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.getClass();
        return mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.onBind(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        final ImageLoader$Builder imageLoader$Builder;
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            imageLoader$Builder = new ImageLoader$Builder() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplApi28
                {
                    super(this.this$0);
                }

                @Override // coil3.ImageLoader$Builder
                public final MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
                    MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = this.this$0;
                    MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = mediaLibraryServiceLegacyStub.curConnection;
                    if (mediaBrowserServiceCompat$ConnectionRecord == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
                        return null;
                    }
                    if (mediaBrowserServiceCompat$ConnectionRecord != mediaLibraryServiceLegacyStub.connectionFromFwk) {
                        return mediaBrowserServiceCompat$ConnectionRecord.browserInfo;
                    }
                    MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 = (MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26) this.defaults;
                    mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.getClass();
                    return new MediaSessionManager$RemoteUserInfo(mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.getCurrentBrowserInfo());
                }
            };
            this.impl = imageLoader$Builder;
        } else {
            imageLoader$Builder = new ImageLoader$Builder(this);
            this.impl = imageLoader$Builder;
        }
        final MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) imageLoader$Builder.extras;
        MediaBrowserService mediaBrowserService = new MediaBrowserService(mediaLibraryServiceLegacyStub) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26
            public final /* synthetic */ ImageLoader$Builder this$1$1;

            {
                this.this$1$1 = this.this$1;
                attachBaseContext(mediaLibraryServiceLegacyStub);
            }

            /* JADX WARN: Code duplicated, block: B:37:0x00fc  */
            /* JADX WARN: Code duplicated, block: B:86:0x0202  */
            @Override // android.service.media.MediaBrowserService
            public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
                Bundle bundle2;
                Splitter splitter;
                Splitter splitter2;
                Splitter splitter3;
                MediaSession$ControllerInfo currentController;
                LibraryResult libraryResult;
                Bundle bundle3;
                Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
                ImageLoader$Builder imageLoader$Builder2 = this.this$1$1;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) imageLoader$Builder2.diskCacheLazy;
                Bundle bundle4 = bundleConvertToNullIfInvalid == null ? null : new Bundle(bundleConvertToNullIfInvalid);
                int i2 = -1;
                if (bundle4 == null || bundle4.getInt("extra_client_version", 0) == 0) {
                    bundle2 = null;
                } else {
                    bundle4.remove("extra_client_version");
                    imageLoader$Builder2.memoryCacheLazy = new Messenger(mediaLibraryServiceLegacyStub2.handler);
                    Bundle bundle5 = new Bundle();
                    bundle5.putInt("extra_service_version", 2);
                    bundle5.putBinder("extra_messenger", ((Messenger) imageLoader$Builder2.memoryCacheLazy).getBinder());
                    MediaSessionCompat$Token mediaSessionCompat$Token = mediaLibraryServiceLegacyStub2.session;
                    if (mediaSessionCompat$Token != null) {
                        IMediaSession extraBinder = mediaSessionCompat$Token.getExtraBinder();
                        bundle5.putBinder("extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                    } else {
                        ((ArrayList) imageLoader$Builder2.application).add(bundle5);
                    }
                    i2 = bundle4.getInt("extra_calling_pid", -1);
                    bundle4.remove("extra_calling_pid");
                    bundle2 = bundle5;
                }
                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(mediaLibraryServiceLegacyStub2, str, i2, i, null);
                mediaLibraryServiceLegacyStub2.curConnection = mediaBrowserServiceCompat$ConnectionRecord;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibraryServiceLegacyStub2.librarySessionImpl;
                Dispatcher dispatcher = mediaLibraryServiceLegacyStub2.connectedControllersManager;
                ImageLoader$Builder imageLoader$Builder3 = mediaLibraryServiceLegacyStub2.impl;
                imageLoader$Builder3.getClass();
                MediaSessionManager$RemoteUserInfo currentBrowserInfo = imageLoader$Builder3.getCurrentBrowserInfo();
                Bundle bundle6 = bundle4 != null ? bundle4 : Bundle.EMPTY;
                boolean zIsTrustedForMediaControl = mediaLibraryServiceLegacyStub2.manager.isTrustedForMediaControl(currentBrowserInfo);
                MediaLibraryServiceLegacyStub.BrowserLegacyCb browserLegacyCb = mediaLibraryServiceLegacyStub2.new BrowserLegacyCb(currentBrowserInfo);
                ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
                bundle6.getInt("androidx.media.utils.MediaBrowserCompat.extras.CUSTOM_BROWSER_ACTION_LIMIT", 0);
                MediaSession$ControllerInfo mediaSession$ControllerInfo = new MediaSession$ControllerInfo(currentBrowserInfo, 0, 0, zIsTrustedForMediaControl, browserLegacyCb, bundle6);
                AtomicReference atomicReference = new AtomicReference();
                ConditionVariable conditionVariable = new ConditionVariable(0);
                Util.postOrRun(mediaLibraryServiceLegacyStub2.sessionImpl.applicationHandler, new MediaSessionStub$$ExternalSyntheticLambda3(mediaLibraryServiceLegacyStub2, atomicReference, mediaSession$ControllerInfo, conditionVariable));
                try {
                    conditionVariable.block();
                    MediaSession$ConnectionResult mediaSession$ConnectionResult = (MediaSession$ConnectionResult) atomicReference.get();
                    mediaSession$ConnectionResult.getClass();
                    dispatcher.addController(currentBrowserInfo, mediaSession$ControllerInfo, mediaSession$ConnectionResult.availableSessionCommands, mediaSession$ConnectionResult.availablePlayerCommands);
                    splitter = MediaUtils.defaultBrowserRoot;
                } catch (InterruptedException e) {
                    Log.e("MSSLegacyStub", "Couldn't get a result from onConnect", e);
                    splitter = null;
                }
                if (splitter == null || (currentController = mediaLibraryServiceLegacyStub2.getCurrentController()) == null || !dispatcher.isSessionCommandAvailable(currentController, 50000)) {
                    splitter2 = null;
                } else {
                    MediaLibraryService.LibraryParams libraryParamsConvertToLibraryParams = LegacyConversions.convertToLibraryParams(mediaLibrarySessionImpl.context, bundle4);
                    AtomicReference atomicReference2 = new AtomicReference();
                    ConditionVariable conditionVariable2 = new ConditionVariable(0);
                    Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new EdgeToEdge$$ExternalSyntheticLambda0(mediaLibraryServiceLegacyStub2, atomicReference2, currentController, libraryParamsConvertToLibraryParams, conditionVariable2, (byte) 2));
                    try {
                        conditionVariable2.block();
                        libraryResult = (LibraryResult) ((ListenableFuture) atomicReference2.get()).get();
                        UtilsKt.checkNotNull(libraryResult, "LibraryResult must not be null");
                    } catch (InterruptedException | CancellationException | ExecutionException e2) {
                        Log.e("MLSLegacyStub", "Couldn't get a result from onGetLibraryRoot", e2);
                        libraryResult = null;
                    }
                    if (libraryResult != null) {
                        Object obj = libraryResult.value;
                        if (libraryResult.resultCode == 0 && obj != null) {
                            MediaLibraryService.LibraryParams libraryParams = libraryResult.params;
                            if (libraryParams != null) {
                                Bundle bundle7 = libraryParams.extras;
                                bundle3 = new Bundle(bundle7);
                                if (bundle7.containsKey("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY")) {
                                    boolean z = bundle7.getBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", false);
                                    bundle3.remove("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY");
                                    bundle3.putInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", z ? 1 : 3);
                                }
                                bundle3.putBoolean("android.service.media.extra.RECENT", libraryParams.isRecent);
                                bundle3.putBoolean("android.service.media.extra.OFFLINE", libraryParams.isOffline);
                                bundle3.putBoolean("android.service.media.extra.SUGGESTED", libraryParams.isSuggested);
                            } else {
                                bundle3 = new Bundle();
                            }
                            bundle3.putBoolean("android.media.browse.SEARCH_SUPPORTED", dispatcher.isSessionCommandAvailable(currentController, 50005));
                            ImmutableList immutableList = mediaLibrarySessionImpl.commandButtonsForMediaItems;
                            if (!immutableList.isEmpty()) {
                                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                                for (int i3 = 0; i3 < immutableList.size(); i3++) {
                                    CommandButton commandButton = (CommandButton) immutableList.get(i3);
                                    SessionCommand sessionCommand = commandButton.sessionCommand;
                                    if (sessionCommand != null && sessionCommand.commandCode == 0) {
                                        Bundle bundle8 = new Bundle();
                                        SessionCommand sessionCommand2 = commandButton.sessionCommand;
                                        Bundle bundle9 = commandButton.extras;
                                        if (sessionCommand2 != null) {
                                            bundle8.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_ID", sessionCommand2.customAction);
                                        }
                                        bundle8.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_LABEL", commandButton.displayName.toString());
                                        Uri uri = commandButton.iconUri;
                                        if (uri != null) {
                                            bundle8.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_ICON_URI", uri.toString());
                                        }
                                        if (!bundle9.isEmpty()) {
                                            bundle8.putBundle("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_EXTRAS", bundle9);
                                        }
                                        arrayList.add(bundle8);
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    bundle3.putParcelableArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ROOT_LIST", arrayList);
                                }
                            }
                            splitter2 = new Splitter(((MediaItem) obj).mediaId, bundle3);
                        } else if (libraryResult != null || libraryResult.resultCode == 0) {
                            splitter2 = MediaUtils.defaultBrowserRoot;
                        } else {
                            splitter2 = null;
                        }
                    } else {
                        if (libraryResult != null) {
                        }
                        splitter2 = MediaUtils.defaultBrowserRoot;
                    }
                }
                mediaLibraryServiceLegacyStub2.curConnection = null;
                if (splitter2 == null) {
                    splitter3 = null;
                } else {
                    if (((Messenger) imageLoader$Builder2.memoryCacheLazy) != null) {
                        mediaLibraryServiceLegacyStub2.pendingConnections.add(mediaBrowserServiceCompat$ConnectionRecord);
                    }
                    Bundle bundle10 = (Bundle) splitter2.strategy;
                    if (bundle2 == null) {
                        bundle2 = bundle10;
                    } else if (bundle10 != null) {
                        bundle2.putAll(bundle10);
                    }
                    splitter3 = new Splitter((String) splitter2.trimmer, bundle2);
                }
                if (splitter3 == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot((String) splitter3.trimmer, (Bundle) splitter3.strategy);
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
                Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle);
                ImageLoader$Builder imageLoader$Builder2 = this.this$1;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) imageLoader$Builder2.extras;
                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = mediaLibraryServiceLegacyStub2.connectionFromFwk;
                MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2(imageLoader$Builder2, str, new MediaBrowserCompat(result), bundleConvertToNullIfInvalid);
                mediaLibraryServiceLegacyStub2.curConnection = mediaBrowserServiceCompat$ConnectionRecord;
                mediaLibraryServiceLegacyStub2.onLoadChildren(str, mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2, bundleConvertToNullIfInvalid);
                mediaLibraryServiceLegacyStub2.curConnection = null;
                mediaLibraryServiceLegacyStub2.curConnection = null;
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadItem(String str, MediaBrowserService.Result result) {
                MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2(str, new MediaBrowserCompat(result), (byte) 1);
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) this.this$1$1.diskCacheLazy;
                mediaLibraryServiceLegacyStub2.curConnection = mediaLibraryServiceLegacyStub2.connectionFromFwk;
                mediaLibraryServiceLegacyStub2.onLoadItem(str, mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2);
                mediaLibraryServiceLegacyStub2.curConnection = null;
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result result) {
                MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2(str, new MediaBrowserCompat(result), (byte) 0);
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) this.this$1$1.diskCacheLazy;
                mediaLibraryServiceLegacyStub2.curConnection = mediaLibraryServiceLegacyStub2.connectionFromFwk;
                mediaLibraryServiceLegacyStub2.onLoadChildren(str, mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2, null);
                mediaLibraryServiceLegacyStub2.curConnection = null;
            }
        };
        imageLoader$Builder.defaults = mediaBrowserService;
        mediaBrowserService.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.handler.mDialog = null;
    }

    public final void onLoadChildren(String str, MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result, Bundle bundle) {
        MediaSession$ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            mediaBrowserServiceCompat$Result.sendResult(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            mediaBrowserServiceCompat$Result.detach();
            Util.postOrRun(this.librarySessionImpl.applicationHandler, new EdgeToEdge$$ExternalSyntheticLambda0(this, currentController, mediaBrowserServiceCompat$Result, bundle, str, (byte) 4));
        } else {
            Log.w("MLSLegacyStub", "onLoadChildren(): Ignoring empty parentId from " + currentController);
            mediaBrowserServiceCompat$Result.sendResult(null);
        }
    }

    public final void onLoadItem(String str, MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result) {
        MediaSession$ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            mediaBrowserServiceCompat$Result.sendResult(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            mediaBrowserServiceCompat$Result.detach();
            Util.postOrRun(this.librarySessionImpl.applicationHandler, new MediaSessionStub$$ExternalSyntheticLambda3((Object) this, (Object) currentController, (Object) mediaBrowserServiceCompat$Result, (Object) str, (byte) 4));
        } else {
            Log.w("MLSLegacyStub", "Ignoring empty itemId from " + currentController);
            mediaBrowserServiceCompat$Result.sendResult(null);
        }
    }

    public final void onUnsubscribe(String str) {
        MediaSession$ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Util.postOrRun(this.librarySessionImpl.applicationHandler, new Util$$ExternalSyntheticLambda1((Object) this, (Object) currentController, (Object) str, (byte) 13));
            return;
        }
        Log.w("MLSLegacyStub", "onUnsubscribe(): Ignoring empty id from " + currentController);
    }

    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
