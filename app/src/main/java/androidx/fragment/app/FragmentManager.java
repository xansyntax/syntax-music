package androidx.fragment.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback$OnBackPressedEventHandler;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.SimpleArrayMap;
import androidx.collection.internal.Lock;
import androidx.compose.ui.window.DialogWrapper$$ExternalSyntheticLambda0;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.NavUtils;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import coil3.Extras;
import coil3.network.HttpException;
import com.yalantis.ucrop.R;
import io.ktor.sse.ServerSentEventKt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    public ArrayList mBackStack;
    public FragmentContainer mContainer;
    public ArrayList mCreatedMenus;
    public int mCurState;
    public final Lock mDefaultSpecialEffectsControllerFactory;
    public boolean mDestroyed;
    public final Fragment.AnonymousClass1 mExecCommit;
    public boolean mExecutingActions;
    public boolean mHavePendingDeferredStart;
    public FragmentHostCallback mHost;
    public final AnonymousClass3 mHostFragmentFactory;
    public ArrayDeque mLaunchedFragments;
    public final FragmentAnim$AnimationOrAnimator mLifecycleCallbacksDispatcher;
    public final AnonymousClass2 mMenuProvider;
    public boolean mNeedMenuInvalidate;
    public FragmentManagerViewModel mNonConfig;
    public final CopyOnWriteArrayList mOnAttachListeners;
    public final AnonymousClass1 mOnBackPressedCallback;
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnConfigurationChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnMultiWindowModeChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnPictureInPictureModeChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda1 mOnTrimMemoryListener;
    public Fragment mParent;
    public Fragment mPrimaryNav;
    public ActivityResultRegistry.AnonymousClass2 mRequestPermissions;
    public ActivityResultRegistry.AnonymousClass2 mStartActivityForResult;
    public ActivityResultRegistry.AnonymousClass2 mStartIntentSenderForResult;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList mTmpAddedFragments;
    public ArrayList mTmpIsPop;
    public ArrayList mTmpRecords;
    public final ArrayList mPendingActions = new ArrayList();
    public final FragmentStore mFragmentStore = new FragmentStore();
    public final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    public final AtomicInteger mBackStackIndex = new AtomicInteger();
    public final Map mBackStackStates = Collections.synchronizedMap(new HashMap());
    public final Map mResults = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements MenuProvider {
        public AnonymousClass2() {
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 {
        public static final SimpleArrayMap sClassCacheMap = new SimpleArrayMap(0);

        public AnonymousClass3() {
        }

        public static Class loadClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
            SimpleArrayMap simpleArrayMap = sClassCacheMap;
            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(classLoader);
            if (simpleArrayMap2 == null) {
                simpleArrayMap2 = new SimpleArrayMap(0);
                simpleArrayMap.put(classLoader, simpleArrayMap2);
            }
            Class cls = (Class) simpleArrayMap2.get(str);
            if (cls != null) {
                return cls;
            }
            Class<?> cls2 = Class.forName(str, false, classLoader);
            simpleArrayMap2.put(str, cls2);
            return cls2;
        }

        public static Class loadFragmentClass(ClassLoader classLoader, String str) {
            try {
                return loadClass(classLoader, str);
            } catch (ClassCastException e) {
                throw new HttpException(IntIntPair$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
            } catch (ClassNotFoundException e2) {
                throw new HttpException(IntIntPair$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FragmentIntentSenderContract extends ActivityResultContract {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ FragmentIntentSenderContract(byte b) {
            this.$r8$classId = b;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent createIntent(Context context, Object obj) {
            Bundle bundleExtra;
            switch (this.$r8$classId) {
                case 0:
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
                    Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                    Intent intent2 = intentSenderRequest.fillInIntent;
                    if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                        intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                        intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                        if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                            intentSenderRequest = new IntentSenderRequest(intentSenderRequest.intentSender, null, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues);
                        }
                    }
                    intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        intent.toString();
                    }
                    return intent;
                case 1:
                    String str = (String) obj;
                    str.getClass();
                    Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType("application/octet-stream").putExtra("android.intent.extra.TITLE", str);
                    intentPutExtra.getClass();
                    return intentPutExtra;
                case 2:
                    String str2 = (String) obj;
                    str2.getClass();
                    Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str2);
                    type.getClass();
                    return type;
                case 3:
                    String[] strArr = (String[]) obj;
                    strArr.getClass();
                    Intent type2 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
                    type2.getClass();
                    return type2;
                case 4:
                    String[] strArr2 = (String[]) obj;
                    strArr2.getClass();
                    Intent type3 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
                    type3.getClass();
                    return type3;
                case 5:
                    PickVisualMediaRequest pickVisualMediaRequest = (PickVisualMediaRequest) obj;
                    pickVisualMediaRequest.getClass();
                    if (BuildCompat.Api30Impl.isSystemPickerAvailable$activity()) {
                        Intent intent3 = new Intent("android.provider.action.PICK_IMAGES");
                        intent3.setType(BuildCompat.Api30Impl.getVisualMimeType$activity(pickVisualMediaRequest.mediaType));
                        intent3.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", 1);
                        return intent3;
                    }
                    if (context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112) == null) {
                        Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent4.setType(BuildCompat.Api30Impl.getVisualMimeType$activity(pickVisualMediaRequest.mediaType));
                        if (intent4.getType() != null) {
                            return intent4;
                        }
                        intent4.setType("*/*");
                        intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                        return intent4;
                    }
                    ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
                    if (resolveInfoResolveActivity == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
                        return null;
                    }
                    ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                    Intent intent5 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                    intent5.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent5.setType(BuildCompat.Api30Impl.getVisualMimeType$activity(pickVisualMediaRequest.mediaType));
                    intent5.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", 1);
                    return intent5;
                case 6:
                    String[] strArr3 = (String[]) obj;
                    strArr3.getClass();
                    Intent intentPutExtra2 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr3);
                    intentPutExtra2.getClass();
                    return intentPutExtra2;
                case 7:
                    String str3 = (String) obj;
                    str3.getClass();
                    Intent intentPutExtra3 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{str3});
                    intentPutExtra3.getClass();
                    return intentPutExtra3;
                default:
                    Intent intent6 = (Intent) obj;
                    intent6.getClass();
                    return intent6;
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Extras.Key getSynchronousResult(Context context, Object obj) {
            switch (this.$r8$classId) {
                case 1:
                    ((String) obj).getClass();
                    return null;
                case 2:
                    ((String) obj).getClass();
                    return null;
                case 3:
                    ((String[]) obj).getClass();
                    return null;
                case 4:
                    ((String[]) obj).getClass();
                    return null;
                case 5:
                    ((PickVisualMediaRequest) obj).getClass();
                    return null;
                case 6:
                    String[] strArr = (String[]) obj;
                    strArr.getClass();
                    if (strArr.length == 0) {
                        return new Extras.Key(EmptyMap.INSTANCE);
                    }
                    for (String str : strArr) {
                        if (NavUtils.checkSelfPermission(context, str) != 0) {
                            return null;
                        }
                    }
                    int iMapCapacity = MapsKt__MapsKt.mapCapacity(strArr.length);
                    if (iMapCapacity < 16) {
                        iMapCapacity = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
                    for (String str2 : strArr) {
                        linkedHashMap.put(str2, Boolean.TRUE);
                    }
                    return new Extras.Key(linkedHashMap);
                case 7:
                    String str3 = (String) obj;
                    str3.getClass();
                    if (NavUtils.checkSelfPermission(context, str3) == 0) {
                        return new Extras.Key(Boolean.TRUE);
                    }
                    return null;
                default:
                    return super.getSynchronousResult(context, obj);
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object parseResult(Intent intent, int i) {
            byte b = this.$r8$classId;
            List arrayList = EmptyList.INSTANCE;
            z = false;
            boolean z = false;
            switch (b) {
                case 0:
                    return new ActivityResult(intent, i);
                case 1:
                    if (i != -1) {
                        intent = null;
                    }
                    if (intent != null) {
                        return intent.getData();
                    }
                    return null;
                case 2:
                    if (i != -1) {
                        intent = null;
                    }
                    if (intent != null) {
                        return intent.getData();
                    }
                    return null;
                case 3:
                    if (i != -1) {
                        intent = null;
                    }
                    if (intent != null) {
                        return intent.getData();
                    }
                    return null;
                case 4:
                    if (i != -1) {
                        intent = null;
                    }
                    if (intent == null) {
                        return arrayList;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Uri data = intent.getData();
                    if (data != null) {
                        linkedHashSet.add(data);
                    }
                    ClipData clipData = intent.getClipData();
                    if (clipData == null && linkedHashSet.isEmpty()) {
                        return arrayList;
                    }
                    if (clipData != null) {
                        int itemCount = clipData.getItemCount();
                        for (int i2 = 0; i2 < itemCount; i2++) {
                            Uri uri = clipData.getItemAt(i2).getUri();
                            if (uri != null) {
                                linkedHashSet.add(uri);
                            }
                        }
                    }
                    return new ArrayList(linkedHashSet);
                case 5:
                    if (i != -1) {
                        intent = null;
                    }
                    if (intent == null) {
                        return null;
                    }
                    Uri data2 = intent.getData();
                    if (data2 != null) {
                        return data2;
                    }
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    Uri data3 = intent.getData();
                    if (data3 != null) {
                        linkedHashSet2.add(data3);
                    }
                    ClipData clipData2 = intent.getClipData();
                    if (clipData2 != null || !linkedHashSet2.isEmpty()) {
                        if (clipData2 != null) {
                            int itemCount2 = clipData2.getItemCount();
                            for (int i3 = 0; i3 < itemCount2; i3++) {
                                Uri uri2 = clipData2.getItemAt(i3).getUri();
                                if (uri2 != null) {
                                    linkedHashSet2.add(uri2);
                                }
                            }
                        }
                        arrayList = new ArrayList(linkedHashSet2);
                    }
                    return (Uri) CollectionsKt.firstOrNull(arrayList);
                case 6:
                    if (i == -1 && intent != null) {
                        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                        if (intArrayExtra != null && stringArrayExtra != null) {
                            ArrayList arrayList2 = new ArrayList(intArrayExtra.length);
                            for (int i4 : intArrayExtra) {
                                arrayList2.add(Boolean.valueOf(i4 == 0));
                            }
                            return MapsKt__MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(stringArrayExtra), arrayList2));
                        }
                    }
                    return EmptyMap.INSTANCE;
                case 7:
                    if (intent == null || i != -1) {
                        return Boolean.FALSE;
                    }
                    int[] intArrayExtra2 = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra2 != null) {
                        for (int i5 : intArrayExtra2) {
                            if (i5 == 0) {
                                z = true;
                            }
                        }
                    }
                    return Boolean.valueOf(z);
                default:
                    return new ActivityResult(intent, i);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new FragmentState.AnonymousClass1((byte) 12);
        public int mRequestCode;
        public String mWho;

        public LaunchedFragmentInfo(String str, int i) {
            this.mWho = str;
            this.mRequestCode = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1] */
    public FragmentManager() {
        final byte b = 0;
        this.mOnBackPressedCallback = new AnonymousClass1(b, this);
        Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new FragmentAnim$AnimationOrAnimator(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mOnConfigurationChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                byte b2 = b;
                FragmentManager fragmentManager = this.f$0;
                switch (b2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (fragmentManager.isParentAdded() && num.intValue() == 80) {
                            fragmentManager.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        final byte b2 = 1;
        this.mOnTrimMemoryListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                byte b3 = b2;
                FragmentManager fragmentManager = this.f$0;
                switch (b3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (fragmentManager.isParentAdded() && num.intValue() == 80) {
                            fragmentManager.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        final byte b3 = 2;
        this.mOnMultiWindowModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                byte b4 = b3;
                FragmentManager fragmentManager = this.f$0;
                switch (b4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (fragmentManager.isParentAdded() && num.intValue() == 80) {
                            fragmentManager.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        final byte b4 = 3;
        this.mOnPictureInPictureModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
            public final /* synthetic */ FragmentManager f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                byte b5 = b4;
                FragmentManager fragmentManager = this.f$0;
                switch (b5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchConfigurationChanged(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (fragmentManager.isParentAdded() && num.intValue() == 80) {
                            fragmentManager.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        if (fragmentManager.isParentAdded()) {
                            fragmentManager.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        }
                        break;
                }
            }
        };
        this.mMenuProvider = new AnonymousClass2();
        this.mCurState = -1;
        this.mHostFragmentFactory = new AnonymousClass3();
        this.mDefaultSpecialEffectsControllerFactory = new Lock((byte) 20);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new Fragment.AnonymousClass1((byte) 5, this);
    }

    public static boolean isLoggingEnabled(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean isMenuAvailable(Fragment fragment) {
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        ArrayList activeFragments = fragment.mChildFragmentManager.mFragmentStore.getActiveFragments();
        int size = activeFragments.size();
        boolean zIsMenuAvailable = false;
        int i = 0;
        while (i < size) {
            Object obj = activeFragments.get(i);
            i++;
            Fragment fragment2 = (Fragment) obj;
            if (fragment2 != null) {
                zIsMenuAvailable = isMenuAvailable(fragment2);
            }
            if (zIsMenuAvailable) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.mPrimaryNav) && isPrimaryNavigation(fragmentManager.mParent);
    }

    public final FragmentStateManager addFragment(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str);
        }
        if (isLoggingEnabled(2)) {
            fragment.toString();
        }
        FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.makeActive(fragmentStateManagerCreateOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            fragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return fragmentStateManagerCreateOrGetFragmentStateManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, final Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel;
        LifecycleOwner lifecycleOwner;
        if (this.mHost != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already attached");
            return;
        }
        this.mHost = fragmentHostCallback;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.mOnAttachListeners;
        if (fragment != null) {
            copyOnWriteArrayList.add(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.7
                @Override // androidx.fragment.app.FragmentOnAttachListener
                public final void onAttachFragment$1(Fragment fragment2) {
                    fragment.onAttachFragment(fragment2);
                }
            });
        } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
            copyOnWriteArrayList.add((FragmentOnAttachListener) fragmentHostCallback);
        }
        if (this.mParent != null) {
            updateOnBackPressedCallbackEnabled();
        }
        if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
            OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            this.mOnBackPressedDispatcher = onBackPressedDispatcher;
            if (fragment != null) {
                lifecycleOwner = onBackPressedDispatcherOwner;
                lifecycleOwner = fragment;
            }
            lifecycleOwner = onBackPressedDispatcherOwner;
            onBackPressedDispatcher.addCallback(this.mOnBackPressedCallback, lifecycleOwner);
        }
        final byte b = 0;
        if (fragment != null) {
            FragmentManagerViewModel fragmentManagerViewModel2 = fragment.mFragmentManager.mNonConfig;
            HashMap map = fragmentManagerViewModel2.mChildNonConfigs;
            fragmentManagerViewModel = (FragmentManagerViewModel) map.get(fragment.mWho);
            if (fragmentManagerViewModel == null) {
                fragmentManagerViewModel = new FragmentManagerViewModel(fragmentManagerViewModel2.mStateAutomaticallySaved);
                map.put(fragment.mWho, fragmentManagerViewModel);
            }
            this.mNonConfig = fragmentManagerViewModel;
        } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore();
            viewModelStore.getClass();
            CreationExtras.Empty empty = CreationExtras.Empty.INSTANCE;
            empty.getClass();
            Dispatcher dispatcher = new Dispatcher(viewModelStore, FragmentManagerViewModel.FACTORY, empty);
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FragmentManagerViewModel.class);
            String qualifiedName = orCreateKotlinClass.getQualifiedName();
            if (qualifiedName == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
                return;
            } else {
                fragmentManagerViewModel = (FragmentManagerViewModel) dispatcher.getViewModel$lifecycle_viewmodel(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName));
                this.mNonConfig = fragmentManagerViewModel;
            }
        } else {
            fragmentManagerViewModel = new FragmentManagerViewModel(false);
            this.mNonConfig = fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel3 = fragmentManagerViewModel;
        final byte b2 = 1;
        fragmentManagerViewModel.mIsStateSaved = this.mStateSaved || this.mStopped;
        this.mFragmentStore.mNonConfig = fragmentManagerViewModel3;
        Object obj = this.mHost;
        if ((obj instanceof SavedStateRegistryOwner) && fragment == null) {
            SavedStateRegistry savedStateRegistry = ((SavedStateRegistryOwner) obj).getSavedStateRegistry();
            savedStateRegistry.registerSavedStateProvider("android:support:fragments", new FragmentManager$$ExternalSyntheticLambda5(b, this));
            Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey("android:support:fragments");
            if (bundleConsumeRestoredStateForKey != null) {
                restoreSaveStateInternal(bundleConsumeRestoredStateForKey);
            }
        }
        Object obj2 = this.mHost;
        if (obj2 instanceof ActivityResultRegistryOwner) {
            ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) obj2).getActivityResultRegistry();
            String strConcat = "FragmentManager:".concat(fragment != null ? IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), fragment.mWho, ServerSentEventKt.COLON) : "");
            this.mStartActivityForResult = activityResultRegistry.register(strConcat.concat("StartActivityForResult"), new FragmentIntentSenderContract((byte) 8), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager.8
                public final /* synthetic */ FragmentManager this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj3) {
                    byte b3 = b;
                    FragmentManager fragmentManager = this.this$0;
                    switch (b3) {
                        case 0:
                            ActivityResult activityResult = (ActivityResult) obj3;
                            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo == null) {
                                Log.w("FragmentManager", "No Activities were started for result for " + this);
                            } else {
                                String str = launchedFragmentInfo.mWho;
                                int i = launchedFragmentInfo.mRequestCode;
                                Fragment fragmentFindFragmentByWho = fragmentManager.mFragmentStore.findFragmentByWho(str);
                                if (fragmentFindFragmentByWho == null) {
                                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                                } else {
                                    fragmentFindFragmentByWho.onActivityResult(i, activityResult.resultCode, activityResult.data);
                                }
                            }
                            break;
                        case 1:
                            Map map2 = (Map) obj3;
                            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
                            ArrayList arrayList = new ArrayList(map2.values());
                            int[] iArr = new int[arrayList.size()];
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                            }
                            LaunchedFragmentInfo launchedFragmentInfo2 = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo2 == null) {
                                Log.w("FragmentManager", "No permissions were requested for " + this);
                            } else {
                                String str2 = launchedFragmentInfo2.mWho;
                                int i3 = launchedFragmentInfo2.mRequestCode;
                                Fragment fragmentFindFragmentByWho2 = fragmentManager.mFragmentStore.findFragmentByWho(str2);
                                if (fragmentFindFragmentByWho2 == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                                } else {
                                    fragmentFindFragmentByWho2.onRequestPermissionsResult(i3, strArr, iArr);
                                }
                            }
                            break;
                        default:
                            ActivityResult activityResult2 = (ActivityResult) obj3;
                            LaunchedFragmentInfo launchedFragmentInfo3 = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo3 == null) {
                                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                            } else {
                                String str3 = launchedFragmentInfo3.mWho;
                                int i4 = launchedFragmentInfo3.mRequestCode;
                                Fragment fragmentFindFragmentByWho3 = fragmentManager.mFragmentStore.findFragmentByWho(str3);
                                if (fragmentFindFragmentByWho3 == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                                } else {
                                    fragmentFindFragmentByWho3.onActivityResult(i4, activityResult2.resultCode, activityResult2.data);
                                }
                            }
                            break;
                    }
                }
            });
            final byte b3 = 2;
            this.mStartIntentSenderForResult = activityResultRegistry.register(strConcat.concat("StartIntentSenderForResult"), new FragmentIntentSenderContract(b), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager.8
                public final /* synthetic */ FragmentManager this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj3) {
                    byte b4 = b3;
                    FragmentManager fragmentManager = this.this$0;
                    switch (b4) {
                        case 0:
                            ActivityResult activityResult = (ActivityResult) obj3;
                            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo == null) {
                                Log.w("FragmentManager", "No Activities were started for result for " + this);
                            } else {
                                String str = launchedFragmentInfo.mWho;
                                int i = launchedFragmentInfo.mRequestCode;
                                Fragment fragmentFindFragmentByWho = fragmentManager.mFragmentStore.findFragmentByWho(str);
                                if (fragmentFindFragmentByWho == null) {
                                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                                } else {
                                    fragmentFindFragmentByWho.onActivityResult(i, activityResult.resultCode, activityResult.data);
                                }
                            }
                            break;
                        case 1:
                            Map map2 = (Map) obj3;
                            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
                            ArrayList arrayList = new ArrayList(map2.values());
                            int[] iArr = new int[arrayList.size()];
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                            }
                            LaunchedFragmentInfo launchedFragmentInfo2 = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo2 == null) {
                                Log.w("FragmentManager", "No permissions were requested for " + this);
                            } else {
                                String str2 = launchedFragmentInfo2.mWho;
                                int i3 = launchedFragmentInfo2.mRequestCode;
                                Fragment fragmentFindFragmentByWho2 = fragmentManager.mFragmentStore.findFragmentByWho(str2);
                                if (fragmentFindFragmentByWho2 == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                                } else {
                                    fragmentFindFragmentByWho2.onRequestPermissionsResult(i3, strArr, iArr);
                                }
                            }
                            break;
                        default:
                            ActivityResult activityResult2 = (ActivityResult) obj3;
                            LaunchedFragmentInfo launchedFragmentInfo3 = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo3 == null) {
                                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                            } else {
                                String str3 = launchedFragmentInfo3.mWho;
                                int i4 = launchedFragmentInfo3.mRequestCode;
                                Fragment fragmentFindFragmentByWho3 = fragmentManager.mFragmentStore.findFragmentByWho(str3);
                                if (fragmentFindFragmentByWho3 == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                                } else {
                                    fragmentFindFragmentByWho3.onActivityResult(i4, activityResult2.resultCode, activityResult2.data);
                                }
                            }
                            break;
                    }
                }
            });
            this.mRequestPermissions = activityResultRegistry.register(strConcat.concat("RequestPermissions"), new FragmentIntentSenderContract((byte) 6), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager.8
                public final /* synthetic */ FragmentManager this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj3) {
                    byte b4 = b2;
                    FragmentManager fragmentManager = this.this$0;
                    switch (b4) {
                        case 0:
                            ActivityResult activityResult = (ActivityResult) obj3;
                            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo == null) {
                                Log.w("FragmentManager", "No Activities were started for result for " + this);
                            } else {
                                String str = launchedFragmentInfo.mWho;
                                int i = launchedFragmentInfo.mRequestCode;
                                Fragment fragmentFindFragmentByWho = fragmentManager.mFragmentStore.findFragmentByWho(str);
                                if (fragmentFindFragmentByWho == null) {
                                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                                } else {
                                    fragmentFindFragmentByWho.onActivityResult(i, activityResult.resultCode, activityResult.data);
                                }
                            }
                            break;
                        case 1:
                            Map map2 = (Map) obj3;
                            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
                            ArrayList arrayList = new ArrayList(map2.values());
                            int[] iArr = new int[arrayList.size()];
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                            }
                            LaunchedFragmentInfo launchedFragmentInfo2 = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo2 == null) {
                                Log.w("FragmentManager", "No permissions were requested for " + this);
                            } else {
                                String str2 = launchedFragmentInfo2.mWho;
                                int i3 = launchedFragmentInfo2.mRequestCode;
                                Fragment fragmentFindFragmentByWho2 = fragmentManager.mFragmentStore.findFragmentByWho(str2);
                                if (fragmentFindFragmentByWho2 == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                                } else {
                                    fragmentFindFragmentByWho2.onRequestPermissionsResult(i3, strArr, iArr);
                                }
                            }
                            break;
                        default:
                            ActivityResult activityResult2 = (ActivityResult) obj3;
                            LaunchedFragmentInfo launchedFragmentInfo3 = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollFirst();
                            if (launchedFragmentInfo3 == null) {
                                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                            } else {
                                String str3 = launchedFragmentInfo3.mWho;
                                int i4 = launchedFragmentInfo3.mRequestCode;
                                Fragment fragmentFindFragmentByWho3 = fragmentManager.mFragmentStore.findFragmentByWho(str3);
                                if (fragmentFindFragmentByWho3 == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                                } else {
                                    fragmentFindFragmentByWho3.onActivityResult(i4, activityResult2.resultCode, activityResult2.data);
                                }
                            }
                            break;
                    }
                }
            });
        }
        Object obj3 = this.mHost;
        if (obj3 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj3).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        Object obj4 = this.mHost;
        if (obj4 instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj4).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        Object obj5 = this.mHost;
        if (obj5 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) obj5).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        Object obj6 = this.mHost;
        if (obj6 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) obj6).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        Object obj7 = this.mHost;
        if ((obj7 instanceof MenuHost) && fragment == null) {
            ((MenuHost) obj7).addMenuProvider(this.mMenuProvider);
        }
    }

    public final void attachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Objects.toString(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.mFragmentStore.addFragment(fragment);
            if (isLoggingEnabled(2)) {
                fragment.toString();
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    public final void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final HashSet collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        ArrayList activeFragmentStateManagers = this.mFragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            ViewGroup viewGroup = ((FragmentStateManager) obj).mFragment.mContainer;
            if (viewGroup != null) {
                hashSet.add(DefaultSpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    public final FragmentStateManager createOrGetFragmentStateManager(Fragment fragment) {
        String str = fragment.mWho;
        FragmentStore fragmentStore = this.mFragmentStore;
        FragmentStateManager fragmentStateManager = (FragmentStateManager) ((HashMap) fragmentStore.mActive).get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragmentStore, fragment);
        fragmentStateManager2.restoreState(this.mHost.mContext.getClassLoader());
        fragmentStateManager2.mFragmentManagerState = this.mCurState;
        return fragmentStateManager2;
    }

    public final void detachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Objects.toString(fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (isLoggingEnabled(2)) {
                fragment.toString();
            }
            FragmentStore fragmentStore = this.mFragmentStore;
            synchronized (((ArrayList) fragmentStore.mAdded)) {
                ((ArrayList) fragmentStore.mAdded).remove(fragment);
            }
            fragment.mAdded = false;
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            setVisibleRemovingFragment(fragment);
        }
    }

    public final void dispatchConfigurationChanged(boolean z, Configuration configuration) {
        if (z && (this.mHost instanceof OnConfigurationChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.dispatchConfigurationChanged(true, configuration);
                }
            }
        }
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final void dispatchDestroy() {
        boolean zIsChangingConfigurations = true;
        this.mDestroyed = true;
        execPendingActions(true);
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
        }
        FragmentHostCallback fragmentHostCallback = this.mHost;
        boolean z = fragmentHostCallback instanceof ViewModelStoreOwner;
        FragmentStore fragmentStore = this.mFragmentStore;
        if (z) {
            zIsChangingConfigurations = ((FragmentManagerViewModel) fragmentStore.mNonConfig).mHasBeenCleared;
        } else {
            Context context = fragmentHostCallback.mContext;
            if (context instanceof Activity) {
                zIsChangingConfigurations = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it2 = this.mBackStackStates.values().iterator();
            while (it2.hasNext()) {
                ArrayList arrayList = ((BackStackState) it2.next()).mFragments;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((FragmentManagerViewModel) fragmentStore.mNonConfig).clearNonConfigStateInternal((String) obj);
                }
            }
        }
        dispatchStateChange(-1);
        Object obj2 = this.mHost;
        if (obj2 instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj2).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        Object obj3 = this.mHost;
        if (obj3 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj3).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        Object obj4 = this.mHost;
        if (obj4 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) obj4).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        Object obj5 = this.mHost;
        if (obj5 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) obj5).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        Object obj6 = this.mHost;
        if (obj6 instanceof MenuHost) {
            ((MenuHost) obj6).removeMenuProvider(this.mMenuProvider);
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultRegistry.AnonymousClass2 anonymousClass2 = this.mStartActivityForResult;
        if (anonymousClass2 != null) {
            anonymousClass2.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    public final void dispatchLowMemory(boolean z) {
        if (z && (this.mHost instanceof OnTrimMemoryProvider)) {
            throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.dispatchLowMemory(true);
                }
            }
        }
    }

    public final void dispatchMultiWindowModeChanged(boolean z, boolean z2) {
        if (z2 && (this.mHost instanceof OnMultiWindowModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(z, true);
                }
            }
        }
    }

    public final void dispatchOnHiddenChanged() {
        ArrayList activeFragments = this.mFragmentStore.getActiveFragments();
        int size = activeFragments.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragments.get(i);
            i++;
            Fragment fragment = (Fragment) obj;
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.dispatchOnHiddenChanged();
            }
        }
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState < 1) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z, boolean z2) {
        if (z2 && (this.mHost instanceof OnPictureInPictureModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(z, true);
                }
            }
        }
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            for (FragmentStateManager fragmentStateManager : ((HashMap) this.mFragmentStore.mActive).values()) {
                if (fragmentStateManager != null) {
                    fragmentStateManager.mFragmentManagerState = i;
                }
            }
            moveToState(i, false);
            Iterator it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        FragmentStore fragmentStore = this.mFragmentStore;
        ArrayList arrayList = (ArrayList) fragmentStore.mAdded;
        String str3 = str + "    ";
        HashMap map = (HashMap) fragmentStore.mActive;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : map.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.mFragment;
                    printWriter.println(fragment);
                    fragment.dump(str3, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.mCreatedMenus;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment3 = (Fragment) this.mCreatedMenus.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.mBackStack;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            try {
                int size4 = this.mPendingActions.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (BackStackRecord) this.mPendingActions.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public final void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("FragmentManager is already executing transactions");
            return;
        }
        if (this.mHost == null) {
            if (this.mDestroyed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("FragmentManager has been destroyed");
                return;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("FragmentManager has not been attached to a host.");
                return;
            }
        }
        if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Must be called from main thread of fragment host");
            return;
        }
        if (!z && (this.mStateSaved || this.mStopped)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Can not perform this action after onSaveInstanceState");
        } else if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList();
            this.mTmpIsPop = new ArrayList();
        }
    }

    public final boolean execPendingActions(boolean z) {
        boolean z2;
        ArrayList arrayList;
        ensureExecReady(z);
        boolean z3 = false;
        while (true) {
            ArrayList arrayList2 = this.mTmpRecords;
            ArrayList arrayList3 = this.mTmpIsPop;
            synchronized (this.mPendingActions) {
                if (this.mPendingActions.isEmpty()) {
                    z2 = false;
                } else {
                    try {
                        int size = this.mPendingActions.size();
                        int i = 0;
                        z2 = false;
                        while (true) {
                            arrayList = this.mPendingActions;
                            if (i >= size) {
                                break;
                            }
                            ((BackStackRecord) arrayList.get(i)).generateOps(arrayList2, arrayList3);
                            i++;
                            z2 = true;
                            throw th;
                        }
                        arrayList.clear();
                        this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                    } catch (Throwable th) {
                        this.mPendingActions.clear();
                        this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                        throw th;
                    }
                }
            }
            if (!z2) {
                break;
            }
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z3 = true;
            } catch (Throwable th2) {
                cleanupExec();
                throw th2;
            }
        }
        updateOnBackPressedCallbackEnabled();
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            ArrayList activeFragmentStateManagers = this.mFragmentStore.getActiveFragmentStateManagers();
            int size2 = activeFragmentStateManagers.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj = activeFragmentStateManagers.get(i2);
                i2++;
                FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
                Fragment fragment = fragmentStateManager.mFragment;
                if (fragment.mDeferStart) {
                    if (this.mExecutingActions) {
                        this.mHavePendingDeferredStart = true;
                    } else {
                        fragment.mDeferStart = false;
                        fragmentStateManager.moveToExpectedState();
                    }
                }
            }
        }
        ((HashMap) this.mFragmentStore.mActive).values().removeAll(Collections.singleton(null));
        return z3;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x022d A[PHI: r14
      0x022d: PHI (r14v14 int) = (r14v13 int), (r14v15 int) binds: [B:99:0x021d, B:104:0x0229] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x0180  */
    /* JADX WARN: Code duplicated, block: B:65:0x0186  */
    public final void executeOpsTogether(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        ViewGroup viewGroup;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        int i6;
        boolean z4 = ((BackStackRecord) arrayList.get(i)).mReorderingAllowed;
        ArrayList arrayList3 = this.mTmpAddedFragments;
        if (arrayList3 == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            arrayList3.clear();
        }
        ArrayList arrayList4 = this.mTmpAddedFragments;
        FragmentStore fragmentStore = this.mFragmentStore;
        arrayList4.addAll(fragmentStore.getFragments());
        Fragment fragment = this.mPrimaryNav;
        int i7 = i;
        boolean z5 = false;
        while (true) {
            int i8 = 1;
            if (i7 >= i2) {
                boolean z6 = z4;
                this.mTmpAddedFragments.clear();
                if (!z6 && this.mCurState >= 1) {
                    for (int i9 = i; i9 < i2; i9++) {
                        ArrayList arrayList5 = ((BackStackRecord) arrayList.get(i9)).mOps;
                        int size = arrayList5.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj = arrayList5.get(i10);
                            i10++;
                            Fragment fragment2 = ((FragmentTransaction$Op) obj).mFragment;
                            if (fragment2 != null && fragment2.mFragmentManager != null) {
                                fragmentStore.makeActive(createOrGetFragmentStateManager(fragment2));
                            }
                        }
                    }
                }
                for (int i11 = i; i11 < i2; i11++) {
                    BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i11);
                    if (((Boolean) arrayList2.get(i11)).booleanValue()) {
                        backStackRecord.bumpBackStackNesting(-1);
                        FragmentManager fragmentManager = backStackRecord.mManager;
                        ArrayList arrayList6 = backStackRecord.mOps;
                        boolean z7 = true;
                        for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
                            FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op) arrayList6.get(size2);
                            Fragment fragment3 = fragmentTransaction$Op.mFragment;
                            if (fragment3 != null) {
                                fragment3.mBeingSaved = false;
                                fragment3.setPopDirection(z7);
                                int i12 = backStackRecord.mTransition;
                                int i13 = 8194;
                                int i14 = 4097;
                                if (i12 != 4097) {
                                    if (i12 != 8194) {
                                        i13 = 4100;
                                        i14 = 8197;
                                        if (i12 != 8197) {
                                            if (i12 == 4099) {
                                                i13 = 4099;
                                            } else if (i12 != 4100) {
                                                i13 = 0;
                                            } else {
                                                i13 = i14;
                                            }
                                        }
                                    } else {
                                        i13 = i14;
                                    }
                                }
                                fragment3.setNextTransition(i13);
                                fragment3.setSharedElementNames(backStackRecord.mSharedElementTargetNames, backStackRecord.mSharedElementSourceNames);
                            }
                            switch (fragmentTransaction$Op.mCmd) {
                                case 1:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    z7 = true;
                                    fragmentManager.setExitAnimationOrder(fragment3, true);
                                    fragmentManager.removeFragment(fragment3);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + fragmentTransaction$Op.mCmd);
                                case 3:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.addFragment(fragment3);
                                    z7 = true;
                                    break;
                                case 4:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    if (isLoggingEnabled(2)) {
                                        Objects.toString(fragment3);
                                    }
                                    if (fragment3.mHidden) {
                                        fragment3.mHidden = false;
                                        fragment3.mHiddenChanged = !fragment3.mHiddenChanged;
                                    }
                                    z7 = true;
                                    break;
                                case 5:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.setExitAnimationOrder(fragment3, true);
                                    if (isLoggingEnabled(2)) {
                                        Objects.toString(fragment3);
                                    }
                                    if (!fragment3.mHidden) {
                                        fragment3.mHidden = true;
                                        fragment3.mHiddenChanged = !fragment3.mHiddenChanged;
                                        fragmentManager.setVisibleRemovingFragment(fragment3);
                                    }
                                    z7 = true;
                                    break;
                                case 6:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.attachFragment(fragment3);
                                    z7 = true;
                                    break;
                                case 7:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManager.setExitAnimationOrder(fragment3, true);
                                    fragmentManager.detachFragment(fragment3);
                                    z7 = true;
                                    break;
                                case 8:
                                    fragmentManager.setPrimaryNavigationFragment(null);
                                    z7 = true;
                                    break;
                                case 9:
                                    fragmentManager.setPrimaryNavigationFragment(fragment3);
                                    z7 = true;
                                    break;
                                case 10:
                                    fragmentManager.setMaxLifecycle(fragment3, fragmentTransaction$Op.mOldMaxState);
                                    z7 = true;
                                    break;
                            }
                        }
                    } else {
                        backStackRecord.bumpBackStackNesting(1);
                        FragmentManager fragmentManager2 = backStackRecord.mManager;
                        ArrayList arrayList7 = backStackRecord.mOps;
                        int size3 = arrayList7.size();
                        for (int i15 = 0; i15 < size3; i15++) {
                            FragmentTransaction$Op fragmentTransaction$Op2 = (FragmentTransaction$Op) arrayList7.get(i15);
                            Fragment fragment4 = fragmentTransaction$Op2.mFragment;
                            if (fragment4 != null) {
                                fragment4.mBeingSaved = false;
                                fragment4.setPopDirection(false);
                                fragment4.setNextTransition(backStackRecord.mTransition);
                                fragment4.setSharedElementNames(backStackRecord.mSharedElementSourceNames, backStackRecord.mSharedElementTargetNames);
                            }
                            switch (fragmentTransaction$Op2.mCmd) {
                                case 1:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment4, false);
                                    fragmentManager2.addFragment(fragment4);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + fragmentTransaction$Op2.mCmd);
                                case 3:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.removeFragment(fragment4);
                                    break;
                                case 4:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    if (isLoggingEnabled(2)) {
                                        Objects.toString(fragment4);
                                    }
                                    if (!fragment4.mHidden) {
                                        fragment4.mHidden = true;
                                        fragment4.mHiddenChanged = !fragment4.mHiddenChanged;
                                        fragmentManager2.setVisibleRemovingFragment(fragment4);
                                    }
                                    break;
                                case 5:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment4, false);
                                    if (isLoggingEnabled(2)) {
                                        Objects.toString(fragment4);
                                    }
                                    if (fragment4.mHidden) {
                                        fragment4.mHidden = false;
                                        fragment4.mHiddenChanged = !fragment4.mHiddenChanged;
                                    }
                                    break;
                                case 6:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.detachFragment(fragment4);
                                    break;
                                case 7:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment4, false);
                                    fragmentManager2.attachFragment(fragment4);
                                    break;
                                case 8:
                                    fragmentManager2.setPrimaryNavigationFragment(fragment4);
                                    break;
                                case 9:
                                    fragmentManager2.setPrimaryNavigationFragment(null);
                                    break;
                                case 10:
                                    fragmentManager2.setMaxLifecycle(fragment4, fragmentTransaction$Op2.mCurrentMaxState);
                                    break;
                            }
                        }
                    }
                }
                boolean zBooleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
                for (int i16 = i; i16 < i2; i16++) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) arrayList.get(i16);
                    if (zBooleanValue) {
                        for (int size4 = backStackRecord2.mOps.size() - 1; size4 >= 0; size4--) {
                            Fragment fragment5 = ((FragmentTransaction$Op) backStackRecord2.mOps.get(size4)).mFragment;
                            if (fragment5 != null) {
                                createOrGetFragmentStateManager(fragment5).moveToExpectedState();
                            }
                        }
                    } else {
                        ArrayList arrayList8 = backStackRecord2.mOps;
                        int size5 = arrayList8.size();
                        int i17 = 0;
                        while (i17 < size5) {
                            Object obj2 = arrayList8.get(i17);
                            i17++;
                            Fragment fragment6 = ((FragmentTransaction$Op) obj2).mFragment;
                            if (fragment6 != null) {
                                createOrGetFragmentStateManager(fragment6).moveToExpectedState();
                            }
                        }
                    }
                }
                moveToState(this.mCurState, true);
                HashSet<DefaultSpecialEffectsController> hashSet = new HashSet();
                for (int i18 = i; i18 < i2; i18++) {
                    ArrayList arrayList9 = ((BackStackRecord) arrayList.get(i18)).mOps;
                    int size6 = arrayList9.size();
                    int i19 = 0;
                    while (i19 < size6) {
                        Object obj3 = arrayList9.get(i19);
                        i19++;
                        Fragment fragment7 = ((FragmentTransaction$Op) obj3).mFragment;
                        if (fragment7 != null && (viewGroup = fragment7.mContainer) != null) {
                            hashSet.add(DefaultSpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
                        }
                    }
                }
                for (DefaultSpecialEffectsController defaultSpecialEffectsController : hashSet) {
                    defaultSpecialEffectsController.mOperationDirectionIsPop = zBooleanValue;
                    defaultSpecialEffectsController.markPostponedState();
                    defaultSpecialEffectsController.executePendingOperations();
                }
                for (int i20 = i; i20 < i2; i20++) {
                    BackStackRecord backStackRecord3 = (BackStackRecord) arrayList.get(i20);
                    if (((Boolean) arrayList2.get(i20)).booleanValue() && backStackRecord3.mIndex >= 0) {
                        backStackRecord3.mIndex = -1;
                    }
                    backStackRecord3.getClass();
                }
                return;
            }
            BackStackRecord backStackRecord4 = (BackStackRecord) arrayList.get(i7);
            boolean zBooleanValue2 = ((Boolean) arrayList2.get(i7)).booleanValue();
            ArrayList arrayList10 = this.mTmpAddedFragments;
            if (zBooleanValue2) {
                z = z4;
                i3 = i7;
                z2 = z5;
                int i21 = 1;
                ArrayList arrayList11 = backStackRecord4.mOps;
                int size7 = arrayList11.size() - 1;
                while (size7 >= 0) {
                    FragmentTransaction$Op fragmentTransaction$Op3 = (FragmentTransaction$Op) arrayList11.get(size7);
                    int i22 = fragmentTransaction$Op3.mCmd;
                    if (i22 == i21) {
                        arrayList10.remove(fragmentTransaction$Op3.mFragment);
                    } else if (i22 != 3) {
                        switch (i22) {
                            case 6:
                                arrayList10.add(fragmentTransaction$Op3.mFragment);
                                break;
                            case 7:
                                arrayList10.remove(fragmentTransaction$Op3.mFragment);
                                break;
                            case 8:
                                fragment = null;
                                break;
                            case 9:
                                fragment = fragmentTransaction$Op3.mFragment;
                                break;
                            case 10:
                                fragmentTransaction$Op3.mCurrentMaxState = fragmentTransaction$Op3.mOldMaxState;
                                break;
                        }
                    } else {
                        arrayList10.add(fragmentTransaction$Op3.mFragment);
                    }
                    size7--;
                    i21 = 1;
                }
            } else {
                ArrayList arrayList12 = backStackRecord4.mOps;
                int i23 = 0;
                while (i23 < arrayList12.size()) {
                    FragmentTransaction$Op fragmentTransaction$Op4 = (FragmentTransaction$Op) arrayList12.get(i23);
                    int i24 = fragmentTransaction$Op4.mCmd;
                    if (i24 != i8) {
                        if (i24 != 2) {
                            if (i24 == 3 || i24 == 6) {
                                z4 = z4;
                                arrayList10.remove(fragmentTransaction$Op4.mFragment);
                                Fragment fragment8 = fragmentTransaction$Op4.mFragment;
                                if (fragment8 == fragment) {
                                    arrayList12.add(i23, new FragmentTransaction$Op(fragment8, 9));
                                    i23++;
                                    i5 = i7;
                                    z3 = z5;
                                    i4 = 1;
                                    fragment = null;
                                }
                            } else if (i24 == 7) {
                                i4 = 1;
                            } else if (i24 != 8) {
                                z4 = z4;
                            } else {
                                z4 = z4;
                                arrayList12.add(i23, new FragmentTransaction$Op(9, fragment, 0));
                                fragmentTransaction$Op4.mFromExpandedOp = true;
                                i23++;
                                fragment = fragmentTransaction$Op4.mFragment;
                            }
                            i5 = i7;
                            z3 = z5;
                            i4 = 1;
                        } else {
                            z4 = z4;
                            Fragment fragment9 = fragmentTransaction$Op4.mFragment;
                            int i25 = fragment9.mContainerId;
                            int size8 = arrayList10.size() - 1;
                            boolean z8 = false;
                            while (size8 >= 0) {
                                int i26 = i7;
                                Fragment fragment10 = (Fragment) arrayList10.get(size8);
                                boolean z9 = z5;
                                if (fragment10.mContainerId != i25) {
                                    i25 = i25;
                                } else if (fragment10 == fragment9) {
                                    i25 = i25;
                                    z8 = true;
                                } else {
                                    if (fragment10 == fragment) {
                                        i6 = 0;
                                        arrayList12.add(i23, new FragmentTransaction$Op(9, fragment10, 0));
                                        i23++;
                                        fragment = null;
                                    } else {
                                        i6 = 0;
                                    }
                                    FragmentTransaction$Op fragmentTransaction$Op5 = new FragmentTransaction$Op(3, fragment10, i6);
                                    fragmentTransaction$Op5.mEnterAnim = fragmentTransaction$Op4.mEnterAnim;
                                    fragmentTransaction$Op5.mPopEnterAnim = fragmentTransaction$Op4.mPopEnterAnim;
                                    fragmentTransaction$Op5.mExitAnim = fragmentTransaction$Op4.mExitAnim;
                                    fragmentTransaction$Op5.mPopExitAnim = fragmentTransaction$Op4.mPopExitAnim;
                                    arrayList12.add(i23, fragmentTransaction$Op5);
                                    arrayList10.remove(fragment10);
                                    i23++;
                                    fragment = fragment;
                                }
                                size8--;
                                i25 = i25;
                                z5 = z9;
                                i7 = i26;
                            }
                            i5 = i7;
                            z3 = z5;
                            i4 = 1;
                            if (z8) {
                                arrayList12.remove(i23);
                                i23--;
                            } else {
                                fragmentTransaction$Op4.mCmd = 1;
                                fragmentTransaction$Op4.mFromExpandedOp = true;
                                arrayList10.add(fragment9);
                            }
                        }
                        i23 += i4;
                        i8 = i4;
                        z4 = z4;
                        z5 = z3;
                        i7 = i5;
                    } else {
                        i4 = i8;
                    }
                    i5 = i7;
                    z3 = z5;
                    arrayList10.add(fragmentTransaction$Op4.mFragment);
                    i23 += i4;
                    i8 = i4;
                    z4 = z4;
                    z5 = z3;
                    i7 = i5;
                }
                z = z4;
                i3 = i7;
                z2 = z5;
            }
            z5 = z2 || backStackRecord4.mAddToBackStack;
            i7 = i3 + 1;
            z4 = z;
        }
    }

    public final Fragment findFragmentById(int i) {
        FragmentStore fragmentStore = this.mFragmentStore;
        ArrayList arrayList = (ArrayList) fragmentStore.mAdded;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : ((HashMap) fragmentStore.mActive).values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final ViewGroup getFragmentContainer(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.mContainer.onHasView()) {
            return null;
        }
        View viewOnFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
        if (viewOnFindViewById instanceof ViewGroup) {
            return (ViewGroup) viewOnFindViewById;
        }
        return null;
    }

    public final AnonymousClass3 getFragmentFactory() {
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getFragmentFactory() : this.mHostFragmentFactory;
    }

    public final Lock getSpecialEffectsControllerFactory() {
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getSpecialEffectsControllerFactory() : this.mDefaultSpecialEffectsControllerFactory;
    }

    public final boolean isParentAdded() {
        Fragment fragment = this.mParent;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.mParent.getParentFragmentManager().isParentAdded();
    }

    public final void moveToState(int i, boolean z) {
        FragmentHostCallback fragmentHostCallback;
        if (this.mHost == null && i != -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No activity");
            return;
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            FragmentStore fragmentStore = this.mFragmentStore;
            HashMap map = (HashMap) fragmentStore.mActive;
            ArrayList arrayList = (ArrayList) fragmentStore.mAdded;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                FragmentStateManager fragmentStateManager = (FragmentStateManager) map.get(((Fragment) obj).mWho);
                if (fragmentStateManager != null) {
                    fragmentStateManager.moveToExpectedState();
                }
            }
            for (FragmentStateManager fragmentStateManager2 : map.values()) {
                if (fragmentStateManager2 != null) {
                    fragmentStateManager2.moveToExpectedState();
                    Fragment fragment = fragmentStateManager2.mFragment;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        if (fragment.mBeingSaved && !((HashMap) fragmentStore.mSavedState).containsKey(fragment.mWho)) {
                            fragmentStateManager2.saveState();
                        }
                        fragmentStore.makeInactive(fragmentStateManager2);
                    }
                }
            }
            ArrayList activeFragmentStateManagers = fragmentStore.getActiveFragmentStateManagers();
            int size2 = activeFragmentStateManagers.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = activeFragmentStateManagers.get(i3);
                i3++;
                FragmentStateManager fragmentStateManager3 = (FragmentStateManager) obj2;
                Fragment fragment2 = fragmentStateManager3.mFragment;
                if (fragment2.mDeferStart) {
                    if (this.mExecutingActions) {
                        this.mHavePendingDeferredStart = true;
                    } else {
                        fragment2.mDeferStart = false;
                        fragmentStateManager3.moveToExpectedState();
                    }
                }
            }
            if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 7) {
                FragmentActivity.this.invalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    public final void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.mIsStateSaved = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final boolean popBackStackImmediate() {
        boolean z;
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        ArrayList arrayList = this.mTmpRecords;
        ArrayList arrayList2 = this.mTmpIsPop;
        ArrayList arrayList3 = this.mBackStack;
        int size = (arrayList3 == null || arrayList3.isEmpty()) ? -1 : this.mBackStack.size() - 1;
        if (size < 0) {
            z = false;
        } else {
            for (int size2 = this.mBackStack.size() - 1; size2 >= size; size2--) {
                arrayList.add((BackStackRecord) this.mBackStack.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
            z = true;
        }
        if (z) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        updateOnBackPressedCallbackEnabled();
        boolean z2 = this.mHavePendingDeferredStart;
        FragmentStore fragmentStore = this.mFragmentStore;
        if (z2) {
            this.mHavePendingDeferredStart = false;
            ArrayList activeFragmentStateManagers = fragmentStore.getActiveFragmentStateManagers();
            int size3 = activeFragmentStateManagers.size();
            int i = 0;
            while (i < size3) {
                Object obj = activeFragmentStateManagers.get(i);
                i++;
                FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment2.mDeferStart) {
                    if (this.mExecutingActions) {
                        this.mHavePendingDeferredStart = true;
                    } else {
                        fragment2.mDeferStart = false;
                        fragmentStateManager.moveToExpectedState();
                    }
                }
            }
        }
        ((HashMap) fragmentStore.mActive).values().removeAll(Collections.singleton(null));
        return z;
    }

    public final void removeFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Objects.toString(fragment);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        FragmentStore fragmentStore = this.mFragmentStore;
        synchronized (((ArrayList) fragmentStore.mAdded)) {
            ((ArrayList) fragmentStore.mAdded).remove(fragment);
        }
        fragment.mAdded = false;
        if (isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mRemoving = true;
        setVisibleRemovingFragment(fragment);
    }

    public final void removeRedundantOperationsAndExecute(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Internal error with the back stack records");
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((BackStackRecord) arrayList.get(i)).mReorderingAllowed) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mReorderingAllowed) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    public final void restoreSaveStateInternal(Parcelable parcelable) {
        FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator;
        int i;
        boolean z;
        int i2;
        ArrayList arrayList;
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.mHost.mContext.getClassLoader());
                this.mResults.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.mHost.mContext.getClassLoader());
                arrayList2.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        FragmentStore fragmentStore = this.mFragmentStore;
        HashMap map = (HashMap) fragmentStore.mSavedState;
        HashMap map2 = (HashMap) fragmentStore.mActive;
        map.clear();
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            FragmentState fragmentState = (FragmentState) obj;
            map.put(fragmentState.mWho, fragmentState);
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        map2.clear();
        ArrayList arrayList3 = fragmentManagerState.mActive;
        int size2 = arrayList3.size();
        int i4 = 0;
        while (true) {
            fragmentAnim$AnimationOrAnimator = this.mLifecycleCallbacksDispatcher;
            i = 2;
            if (i4 >= size2) {
                break;
            }
            Object obj2 = arrayList3.get(i4);
            i4++;
            FragmentState fragmentState2 = (FragmentState) ((HashMap) fragmentStore.mSavedState).remove((String) obj2);
            if (fragmentState2 != null) {
                Fragment fragment = (Fragment) this.mNonConfig.mRetainedFragments.get(fragmentState2.mWho);
                if (fragment != null) {
                    if (isLoggingEnabled(2)) {
                        fragment.toString();
                    }
                    fragmentStateManager = new FragmentStateManager(fragmentAnim$AnimationOrAnimator, fragmentStore, fragment, fragmentState2);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.mContext.getClassLoader(), getFragmentFactory(), fragmentState2);
                }
                Fragment fragment2 = fragmentStateManager.mFragment;
                fragment2.mFragmentManager = this;
                if (isLoggingEnabled(2)) {
                    fragment2.toString();
                }
                fragmentStateManager.restoreState(this.mHost.mContext.getClassLoader());
                fragmentStore.makeActive(fragmentStateManager);
                fragmentStateManager.mFragmentManagerState = this.mCurState;
            }
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
        fragmentManagerViewModel.getClass();
        ArrayList arrayList4 = new ArrayList(fragmentManagerViewModel.mRetainedFragments.values());
        int size3 = arrayList4.size();
        int i5 = 0;
        while (true) {
            z = true;
            if (i5 >= size3) {
                break;
            }
            Object obj3 = arrayList4.get(i5);
            i5++;
            Fragment fragment3 = (Fragment) obj3;
            if (map2.get(fragment3.mWho) == null) {
                if (isLoggingEnabled(2)) {
                    fragment3.toString();
                    Objects.toString(fragmentManagerState.mActive);
                }
                this.mNonConfig.removeRetainedFragment(fragment3);
                fragment3.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(fragmentAnim$AnimationOrAnimator, fragmentStore, fragment3);
                fragmentStateManager2.mFragmentManagerState = 1;
                fragmentStateManager2.moveToExpectedState();
                fragment3.mRemoving = true;
                fragmentStateManager2.moveToExpectedState();
            }
        }
        ArrayList arrayList5 = fragmentManagerState.mAdded;
        ((ArrayList) fragmentStore.mAdded).clear();
        if (arrayList5 != null) {
            int size4 = arrayList5.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj4 = arrayList5.get(i6);
                i6++;
                String str3 = (String) obj4;
                Fragment fragmentFindActiveFragment = fragmentStore.findActiveFragment(str3);
                if (fragmentFindActiveFragment == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m("No instantiated fragment for (", str3, ")"));
                    return;
                } else {
                    if (isLoggingEnabled(2)) {
                        fragmentFindActiveFragment.toString();
                    }
                    fragmentStore.addFragment(fragmentFindActiveFragment);
                }
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
            int i7 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                if (i7 >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecordState backStackRecordState = backStackRecordStateArr[i7];
                ArrayList arrayList6 = backStackRecordState.mFragmentWhos;
                BackStackRecord backStackRecord = new BackStackRecord(this);
                int[] iArr = backStackRecordState.mOps;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    int length = iArr.length;
                    arrayList = backStackRecord.mOps;
                    if (i8 >= length) {
                        break;
                    }
                    FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op();
                    int i10 = i8 + 1;
                    int i11 = i;
                    fragmentTransaction$Op.mCmd = iArr[i8];
                    if (isLoggingEnabled(i11)) {
                        Objects.toString(backStackRecord);
                        int i12 = iArr[i10];
                    }
                    fragmentTransaction$Op.mOldMaxState = Lifecycle.State.values()[backStackRecordState.mOldMaxLifecycleStates[i9]];
                    fragmentTransaction$Op.mCurrentMaxState = Lifecycle.State.values()[backStackRecordState.mCurrentMaxLifecycleStates[i9]];
                    int i13 = i8 + 2;
                    fragmentTransaction$Op.mFromExpandedOp = iArr[i10] != 0 ? z : false;
                    int i14 = iArr[i13];
                    fragmentTransaction$Op.mEnterAnim = i14;
                    int i15 = iArr[i8 + 3];
                    fragmentTransaction$Op.mExitAnim = i15;
                    int i16 = i8 + 5;
                    int i17 = iArr[i8 + 4];
                    fragmentTransaction$Op.mPopEnterAnim = i17;
                    i8 += 6;
                    int i18 = iArr[i16];
                    fragmentTransaction$Op.mPopExitAnim = i18;
                    backStackRecord.mEnterAnim = i14;
                    backStackRecord.mExitAnim = i15;
                    backStackRecord.mPopEnterAnim = i17;
                    backStackRecord.mPopExitAnim = i18;
                    arrayList.add(fragmentTransaction$Op);
                    fragmentTransaction$Op.mEnterAnim = backStackRecord.mEnterAnim;
                    fragmentTransaction$Op.mExitAnim = backStackRecord.mExitAnim;
                    fragmentTransaction$Op.mPopEnterAnim = backStackRecord.mPopEnterAnim;
                    fragmentTransaction$Op.mPopExitAnim = backStackRecord.mPopExitAnim;
                    i9++;
                    i = i11;
                    z = true;
                }
                int i19 = i;
                backStackRecord.mTransition = backStackRecordState.mTransition;
                backStackRecord.mName = backStackRecordState.mName;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = backStackRecordState.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = backStackRecordState.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = backStackRecordState.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = backStackRecordState.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = backStackRecordState.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = backStackRecordState.mSharedElementTargetNames;
                backStackRecord.mReorderingAllowed = backStackRecordState.mReorderingAllowed;
                backStackRecord.mIndex = backStackRecordState.mIndex;
                for (int i20 = 0; i20 < arrayList6.size(); i20++) {
                    String str4 = (String) arrayList6.get(i20);
                    if (str4 != null) {
                        ((FragmentTransaction$Op) arrayList.get(i20)).mFragment = fragmentStore.findActiveFragment(str4);
                    }
                }
                backStackRecord.bumpBackStackNesting(1);
                if (isLoggingEnabled(i19)) {
                    backStackRecord.toString();
                    PrintWriter printWriter = new PrintWriter(new LogWriter());
                    backStackRecord.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(backStackRecord);
                i7++;
                i = i19;
                z = true;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
        String str5 = fragmentManagerState.mPrimaryNavActiveWho;
        if (str5 != null) {
            Fragment fragmentFindActiveFragment2 = fragmentStore.findActiveFragment(str5);
            this.mPrimaryNav = fragmentFindActiveFragment2;
            dispatchParentPrimaryNavigationFragmentChanged(fragmentFindActiveFragment2);
        }
        ArrayList arrayList7 = fragmentManagerState.mBackStackStateKeys;
        if (arrayList7 != null) {
            while (i2 < arrayList7.size()) {
                this.mBackStackStates.put((String) arrayList7.get(i2), (BackStackState) fragmentManagerState.mBackStackStates.get(i2));
                i2++;
            }
        }
        this.mLaunchedFragments = new ArrayDeque(fragmentManagerState.mLaunchedFragments);
    }

    public final Bundle saveAllStateInternal() {
        int i;
        ArrayList arrayList;
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            DefaultSpecialEffectsController defaultSpecialEffectsController = (DefaultSpecialEffectsController) it.next();
            if (defaultSpecialEffectsController.mIsContainerPostponed) {
                defaultSpecialEffectsController.mIsContainerPostponed = false;
                defaultSpecialEffectsController.executePendingOperations();
            }
        }
        Iterator it2 = collectAllSpecialEffectsController().iterator();
        while (it2.hasNext()) {
            ((DefaultSpecialEffectsController) it2.next()).forceCompleteAllOperations();
        }
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.mIsStateSaved = true;
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.getClass();
        HashMap map = (HashMap) fragmentStore.mActive;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (FragmentStateManager fragmentStateManager : map.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment = fragmentStateManager.mFragment;
                fragmentStateManager.saveState();
                arrayList2.add(fragment.mWho);
                if (isLoggingEnabled(2)) {
                    fragment.toString();
                    Objects.toString(fragment.mSavedFragmentState);
                }
            }
        }
        FragmentStore fragmentStore2 = this.mFragmentStore;
        fragmentStore2.getClass();
        ArrayList arrayList3 = new ArrayList(((HashMap) fragmentStore2.mSavedState).values());
        if (!arrayList3.isEmpty()) {
            FragmentStore fragmentStore3 = this.mFragmentStore;
            synchronized (((ArrayList) fragmentStore3.mAdded)) {
                try {
                    if (((ArrayList) fragmentStore3.mAdded).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) fragmentStore3.mAdded).size());
                        ArrayList arrayList4 = (ArrayList) fragmentStore3.mAdded;
                        int size2 = arrayList4.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            Object obj = arrayList4.get(i2);
                            i2++;
                            Fragment fragment2 = (Fragment) obj;
                            arrayList.add(fragment2.mWho);
                            if (isLoggingEnabled(2)) {
                                fragment2.toString();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList5 = this.mBackStack;
            if (arrayList5 == null || (size = arrayList5.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i3 = 0; i3 < size; i3++) {
                    backStackRecordStateArr[i3] = new BackStackRecordState((BackStackRecord) this.mBackStack.get(i3));
                    if (isLoggingEnabled(2)) {
                        Objects.toString(this.mBackStack.get(i3));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mPrimaryNavActiveWho = null;
            ArrayList arrayList6 = new ArrayList();
            fragmentManagerState.mBackStackStateKeys = arrayList6;
            ArrayList arrayList7 = new ArrayList();
            fragmentManagerState.mBackStackStates = arrayList7;
            fragmentManagerState.mActive = arrayList2;
            fragmentManagerState.mAdded = arrayList;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
            Fragment fragment3 = this.mPrimaryNav;
            if (fragment3 != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment3.mWho;
            }
            arrayList6.addAll(this.mBackStackStates.keySet());
            arrayList7.addAll(this.mBackStackStates.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.mResults.keySet()) {
                bundle.putBundle(Fragment$5$$ExternalSyntheticOutline0.m("result_", str), (Bundle) this.mResults.get(str));
            }
            int size3 = arrayList3.size();
            while (i < size3) {
                Object obj2 = arrayList3.get(i);
                i++;
                FragmentState fragmentState = (FragmentState) obj2;
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle("fragment_" + fragmentState.mWho, bundle2);
            }
        }
        return bundle;
    }

    public final void setExitAnimationOrder(Fragment fragment, boolean z) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || !(fragmentContainer instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
    }

    public final void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
        } else {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Fragment ", fragment, " is not an active fragment of FragmentManager ", this);
        }
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Fragment ", fragment, " is not an active fragment of FragmentManager ", this);
                return;
            }
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public final void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    fragmentContainer.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void throwException(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter());
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            try {
                dump("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            FragmentActivity.this.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb.append("}");
        } else {
            FragmentHostCallback fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void updateOnBackPressedCallbackEnabled() {
        synchronized (this.mPendingActions) {
            try {
                if (!this.mPendingActions.isEmpty()) {
                    this.mOnBackPressedCallback.setEnabled(true);
                    return;
                }
                AnonymousClass1 anonymousClass1 = this.mOnBackPressedCallback;
                ArrayList arrayList = this.mBackStack;
                anonymousClass1.setEnabled((arrayList != null ? arrayList.size() : 0) > 0 && isPrimaryNavigation(this.mParent));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 {
        public final /* synthetic */ byte $r8$classId;
        public final CopyOnWriteArrayList closeables;
        public final ArrayList eventHandlers;
        public boolean isEnabled;
        public final /* synthetic */ Object this$0;

        public AnonymousClass1(boolean z) {
            this.eventHandlers = new ArrayList();
            this.isEnabled = z;
            this.closeables = new CopyOnWriteArrayList();
        }

        public final void remove() throws Exception {
            boolean zIsTerminated;
            CopyOnWriteArrayList copyOnWriteArrayList = this.closeables;
            Iterator it = copyOnWriteArrayList.iterator();
            it.getClass();
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    copyOnWriteArrayList.clear();
                    ArrayList arrayList = this.eventHandlers;
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((OnBackPressedCallback$OnBackPressedEventHandler) obj).remove();
                    }
                    arrayList.clear();
                    return;
                }
                AutoCloseable autoCloseable = (AutoCloseable) it.next();
                if (autoCloseable instanceof AutoCloseable) {
                    autoCloseable.close();
                } else if (autoCloseable instanceof ExecutorService) {
                    ExecutorService executorService = (ExecutorService) autoCloseable;
                    if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated = executorService.isTerminated())) {
                        executorService.shutdown();
                        while (!zIsTerminated) {
                            try {
                                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                            } catch (InterruptedException unused) {
                                if (i == 0) {
                                    executorService.shutdownNow();
                                    i = 1;
                                }
                            }
                        }
                        if (i != 0) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } else if (autoCloseable instanceof TypedArray) {
                    ((TypedArray) autoCloseable).recycle();
                } else if (autoCloseable instanceof MediaMetadataRetriever) {
                    ((MediaMetadataRetriever) autoCloseable).release();
                } else {
                    if (!(autoCloseable instanceof MediaDrm)) {
                        Path$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                    ((MediaDrm) autoCloseable).release();
                }
            }
        }

        public final void setEnabled(boolean z) {
            this.isEnabled = z;
            ArrayList arrayList = this.eventHandlers;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                OnBackPressedCallback$OnBackPressedEventHandler onBackPressedCallback$OnBackPressedEventHandler = (OnBackPressedCallback$OnBackPressedEventHandler) obj;
                onBackPressedCallback$OnBackPressedEventHandler.setBackEnabled(onBackPressedCallback$OnBackPressedEventHandler.isLifecycleActive && z);
            }
        }

        public final void handleOnBackCancelled$androidx$activity$OnBackPressedCallback() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(byte b, Object obj) {
            this(false);
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DialogWrapper$$ExternalSyntheticLambda0 dialogWrapper$$ExternalSyntheticLambda0) {
            this(true);
            this.$r8$classId = (byte) 1;
            this.this$0 = dialogWrapper$$ExternalSyntheticLambda0;
        }

        public final void handleOnBackProgressed$androidx$activity$OnBackPressedCallback(BackEventCompat backEventCompat) {
        }

        public final void handleOnBackStarted$androidx$activity$OnBackPressedCallback(BackEventCompat backEventCompat) {
        }
    }
}
