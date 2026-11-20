package coil3.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.webkit.MimeTypeMap;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1;
import androidx.compose.foundation.AbstractClickableNode$onKeyEvent$1;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.TextFieldKeyInput;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode.ClickTextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.room.InvalidationTracker;
import androidx.room.ObserverWrapper;
import androidx.room.concurrent.FileLock;
import coil3.Extras;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.decode.FileImageSource;
import coil3.decode.SourceImageSource;
import coil3.disk.DiskLruCache;
import coil3.disk.RealDiskCache;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.EngineInterceptor;
import coil3.network.internal.DefaultCacheStrategy;
import coil3.network.internal.UNINITIALIZED;
import coil3.network.okhttp.internal.CallFactoryNetworkClient;
import coil3.request.CachePolicy;
import coil3.request.Options;
import coil3.util.LifecyclesKt;
import coil3.util.MimeTypesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.dynamiccolor.ColorSpec2021;
import com.materialkolor.scheme.DynamicScheme;
import com.metrolist.innertubex.cipher.RemotePlayerConfigStore;
import com.metrolist.music.App;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import io.ktor.client.utils.CacheControl;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.InitializedLazyImpl;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Okio__OkioKt;
import okio.Path;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkFetcher implements Fetcher {
    public final SynchronizedLazyImpl cacheStrategy;
    public final SynchronizedLazyImpl concurrentRequestStrategy;
    public final InitializedLazyImpl connectivityChecker;
    public final SynchronizedLazyImpl diskCache;
    public final SynchronizedLazyImpl networkClient;
    public final Options options;
    public final String url;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements Fetcher.Factory {
        public final SynchronizedLazyImpl cacheStrategyLazy;
        public final SynchronizedLazyImpl concurrentRequestStrategyLazy;
        public final FileLock connectivityCheckerLazy;
        public final SynchronizedLazyImpl networkClientLazy;

        /* JADX INFO: renamed from: coil3.network.NetworkFetcher$Factory$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2(1, DatabaseDao_Impl.AnonymousClass17.class, "ConnectivityChecker", "ConnectivityChecker(Landroid/content/Context;)Lcoil3/network/ConnectivityChecker;", 1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Context applicationContext = ((Context) obj).getApplicationContext();
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(ConnectivityManager.class);
                if (connectivityManager != null && NavUtils.checkSelfPermission(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                    try {
                        return new ConnectivityCheckerApi23(connectivityManager);
                    } catch (Exception unused) {
                    }
                }
                return ConnectivityChecker.ONLINE;
            }
        }

        public Factory(UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
            UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda1 = new UtilsKt$$ExternalSyntheticLambda0((byte) 20);
            AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
            UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda2 = new UtilsKt$$ExternalSyntheticLambda0((byte) 21);
            this.networkClientLazy = new SynchronizedLazyImpl(utilsKt$$ExternalSyntheticLambda0);
            this.cacheStrategyLazy = new SynchronizedLazyImpl(utilsKt$$ExternalSyntheticLambda1);
            FileLock fileLock = new FileLock();
            fileLock.lockFilename = anonymousClass2;
            fileLock.lockChannel = UNINITIALIZED.INSTANCE;
            this.connectivityCheckerLazy = fileLock;
            this.concurrentRequestStrategyLazy = new SynchronizedLazyImpl(utilsKt$$ExternalSyntheticLambda2);
        }

        @Override // coil3.fetch.Fetcher.Factory
        public final Fetcher create(Object obj, Options options, RealImageLoader realImageLoader) {
            Uri uri = (Uri) obj;
            if (!Intrinsics.areEqual(uri.scheme, "http") && !Intrinsics.areEqual(uri.scheme, "https")) {
                return null;
            }
            String str = uri.data;
            SynchronizedLazyImpl synchronizedLazyImpl = this.networkClientLazy;
            SynchronizedLazyImpl synchronizedLazyImpl2 = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 2, realImageLoader));
            SynchronizedLazyImpl synchronizedLazyImpl3 = this.cacheStrategyLazy;
            FileLock fileLock = this.connectivityCheckerLazy;
            Context context = options.context;
            Object obj2 = fileLock.lockChannel;
            UNINITIALIZED uninitialized = UNINITIALIZED.INSTANCE;
            if (obj2 == uninitialized) {
                synchronized (fileLock) {
                    obj2 = fileLock.lockChannel;
                    if (obj2 == uninitialized) {
                        Function1 function1 = (Function1) fileLock.lockFilename;
                        function1.getClass();
                        Object objInvoke = function1.invoke(context);
                        fileLock.lockChannel = objInvoke;
                        fileLock.lockFilename = null;
                        obj2 = objInvoke;
                    }
                }
            }
            return new NetworkFetcher(str, options, synchronizedLazyImpl, synchronizedLazyImpl2, synchronizedLazyImpl3, new InitializedLazyImpl(obj2), this.concurrentRequestStrategyLazy);
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$doFetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Ref$ObjectRef L$0;
        public Ref$ObjectRef L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.doFetch(this);
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$fetch$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
        public final /* synthetic */ byte $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(int i, Object obj, Class cls, String str, String str2, int i2, byte b) {
            super(i, obj, cls, str, str2, i2);
            this.$r8$classId = b;
        }

        /* JADX WARN: Code duplicated, block: B:87:0x027d  */
        /* JADX WARN: Code duplicated, block: B:91:0x028d  */
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Object[] objArr;
            CommitTextCommand commitTextCommand;
            KeyCommand keyCommandM196mapZmokQxo;
            boolean z;
            Integer numValueOf;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((NetworkFetcher) this.receiver).doFetch((Continuation) obj);
                case 1:
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    AbstractClickableNode abstractClickableNode = (AbstractClickableNode) this.receiver;
                    MutableLongObjectMap mutableLongObjectMap = abstractClickableNode.currentKeyPressInteractions;
                    if (zBooleanValue) {
                        abstractClickableNode.initializeIndicationAndInteractionSourceIfNeeded();
                    } else {
                        if (abstractClickableNode.interactionSource != null) {
                            Object[] objArr2 = mutableLongObjectMap.values;
                            long[] jArr = mutableLongObjectMap.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i = 0;
                                while (true) {
                                    long j = jArr[i];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i2 = 8;
                                        int i3 = 8 - ((~(i - length)) >>> 31);
                                        int i4 = 0;
                                        while (i4 < i3) {
                                            if ((j & 255) < 128) {
                                                AwaitKt.launch$default(abstractClickableNode.getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, (PressInteraction.Press) objArr2[(i << 3) + i4], null, (byte) 1), 3);
                                            }
                                            j >>= i2;
                                            i4++;
                                            i2 = i2;
                                            objArr2 = objArr2;
                                        }
                                        objArr = objArr2;
                                        if (i3 == i2) {
                                        }
                                    } else {
                                        objArr = objArr2;
                                    }
                                    if (i != length) {
                                        i++;
                                        objArr2 = objArr;
                                    }
                                }
                            }
                            PressInteraction.Press press = abstractClickableNode.indirectPointerPressInteraction;
                            if (press != null) {
                                AwaitKt.launch$default(abstractClickableNode.getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, press, null, (byte) 2), 3);
                            }
                        }
                        mutableLongObjectMap.clear();
                        abstractClickableNode.indirectPointerPressInteraction = null;
                        abstractClickableNode.onCancelKeyInput();
                    }
                    return unit;
                case 2:
                    KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                    TextFieldKeyInput textFieldKeyInput = (TextFieldKeyInput) this.receiver;
                    TextPreparedSelectionState textPreparedSelectionState = textFieldKeyInput.preparedSelectionState;
                    boolean z2 = textFieldKeyInput.editable;
                    if (keyEvent.getAction() != 0 || Character.isISOControl(keyEvent.getUnicodeChar())) {
                        commitTextCommand = null;
                    } else {
                        DeadKeyCombiner deadKeyCombiner = textFieldKeyInput.keyCombiner;
                        deadKeyCombiner.getClass();
                        int unicodeChar = keyEvent.getUnicodeChar();
                        if ((Integer.MIN_VALUE & unicodeChar) != 0) {
                            deadKeyCombiner.deadKeyCode = Integer.valueOf(unicodeChar & Integer.MAX_VALUE);
                            numValueOf = null;
                        } else {
                            Integer num = deadKeyCombiner.deadKeyCode;
                            if (num != null) {
                                deadKeyCombiner.deadKeyCode = null;
                                int deadChar = KeyCharacterMap.getDeadChar(num.intValue(), unicodeChar);
                                Integer numValueOf2 = Integer.valueOf(deadChar);
                                if (deadChar == 0) {
                                    numValueOf2 = null;
                                }
                                if (numValueOf2 != null) {
                                    unicodeChar = numValueOf2.intValue();
                                }
                                numValueOf = Integer.valueOf(unicodeChar);
                            } else {
                                numValueOf = Integer.valueOf(unicodeChar);
                            }
                        }
                        if (numValueOf != null) {
                            commitTextCommand = new CommitTextCommand(new StringBuilder().appendCodePoint(numValueOf.intValue()).toString(), 1);
                        } else {
                            commitTextCommand = null;
                        }
                    }
                    if (commitTextCommand != null) {
                        if (z2) {
                            textFieldKeyInput.apply(CollectionsKt__IterablesKt.listOf(commitTextCommand));
                            textPreparedSelectionState.cachedX = null;
                            z = true;
                        } else {
                            z = false;
                        }
                    } else if (Key.m581getTypeZmokQxo(keyEvent) != 2 || (keyCommandM196mapZmokQxo = BasicTextKt.platformDefaultKeyMapping.m196mapZmokQxo(keyEvent)) == null || (keyCommandM196mapZmokQxo.editsText && !z2)) {
                        z = false;
                    } else {
                        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                        ref$BooleanRef.element = true;
                        coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0((Object) keyCommandM196mapZmokQxo, (Object) textFieldKeyInput, (Object) ref$BooleanRef, (byte) 10);
                        TextFieldValue textFieldValue = textFieldKeyInput.value;
                        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(textFieldValue, textFieldKeyInput.offsetMapping, textFieldKeyInput.state.getLayoutResult(), textPreparedSelectionState);
                        utilsKt$$ExternalSyntheticLambda0.invoke(textFieldPreparedSelection);
                        boolean zM740equalsimpl0 = TextRange.m740equalsimpl0(textFieldPreparedSelection.selection, textFieldValue.selection);
                        AnnotatedString annotatedString = textFieldPreparedSelection.annotatedString;
                        if (!zM740equalsimpl0 || !Intrinsics.areEqual(annotatedString, textFieldValue.annotatedString)) {
                            textFieldKeyInput.onValueChange.invoke(TextFieldValue.m762copy3r_uNRQ$default(textFieldValue, annotatedString, textFieldPreparedSelection.selection, 4));
                        }
                        textFieldKeyInput.undoManager.forceNextSnapshot = true;
                        z = ref$BooleanRef.element;
                    }
                    return Boolean.valueOf(z);
                case 3:
                    long j2 = ((Offset) obj).packedValue;
                    TextContextMenuGestureNode textContextMenuGestureNode = (TextContextMenuGestureNode) this.receiver;
                    textContextMenuGestureNode.getClass();
                    TextContextMenuProvider textContextMenuProvider = (TextContextMenuProvider) HitTestResultKt.currentValueOf(textContextMenuGestureNode, TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider);
                    if (textContextMenuProvider != null) {
                        AwaitKt.launch$default(textContextMenuGestureNode.getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1(textContextMenuGestureNode, j2, textContextMenuProvider, textContextMenuGestureNode.new ClickTextContextMenuDataProvider(j2), (Continuation) null), 3);
                    }
                    return unit;
                case 4:
                    ((TextContextMenuBuilderScope) this.receiver).filters.add((Function1) obj);
                    return unit;
                case 5:
                    ((AndroidParagraph) this.receiver).paint((Canvas) obj);
                    return unit;
                case 6:
                    ((AndroidParagraph) this.receiver).paint((Canvas) obj);
                    return unit;
                case 7:
                    ((Set) obj).getClass();
                    InvalidationTracker invalidationTracker = (InvalidationTracker) this.receiver;
                    ReentrantLock reentrantLock = invalidationTracker.observerMapLock;
                    reentrantLock.lock();
                    try {
                        List list = CollectionsKt.toList(invalidationTracker.observerMap.values());
                        reentrantLock.unlock();
                        Iterator it = list.iterator();
                        if (!it.hasNext()) {
                            return unit;
                        }
                        ((ObserverWrapper) it.next()).getClass();
                        throw null;
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                case 8:
                    DynamicScheme dynamicScheme = (DynamicScheme) obj;
                    dynamicScheme.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme);
                case 9:
                    DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                    dynamicScheme2.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme2);
                case 10:
                    DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                    dynamicScheme3.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme3);
                case 11:
                    DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                    dynamicScheme4.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme4);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                    dynamicScheme5.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme5);
                case 13:
                    DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                    dynamicScheme6.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme6);
                case 14:
                    DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                    dynamicScheme7.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme7);
                case 15:
                    DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                    dynamicScheme8.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme8);
                case 16:
                    DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                    dynamicScheme9.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme9);
                case 17:
                    DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                    dynamicScheme10.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme10);
                case 18:
                    DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                    dynamicScheme11.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme11);
                case 19:
                    DynamicScheme dynamicScheme12 = (DynamicScheme) obj;
                    dynamicScheme12.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme12);
                case 20:
                    DynamicScheme dynamicScheme13 = (DynamicScheme) obj;
                    dynamicScheme13.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme13);
                case 21:
                    DynamicScheme dynamicScheme14 = (DynamicScheme) obj;
                    dynamicScheme14.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme14);
                case 22:
                    DynamicScheme dynamicScheme15 = (DynamicScheme) obj;
                    dynamicScheme15.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme15);
                case 23:
                    DynamicScheme dynamicScheme16 = (DynamicScheme) obj;
                    dynamicScheme16.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme16);
                case 24:
                    DynamicScheme dynamicScheme17 = (DynamicScheme) obj;
                    dynamicScheme17.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme17);
                case 25:
                    DynamicScheme dynamicScheme18 = (DynamicScheme) obj;
                    dynamicScheme18.getClass();
                    return ((ColorSpec2021) this.receiver).highestSurface(dynamicScheme18);
                case 26:
                    String str = (String) obj;
                    str.getClass();
                    ((RemotePlayerConfigStore) this.receiver).getClass();
                    return RemotePlayerConfigStore.validatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex(str);
                case 27:
                    String str2 = (String) obj;
                    str2.getClass();
                    return Boolean.valueOf(((Set) this.receiver).contains(str2));
                case 28:
                    String str3 = (String) obj;
                    str3.getClass();
                    StateFlowImpl stateFlowImpl = ((LibraryAlbumsViewModel) this.receiver)._searchQuery;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, str3);
                    return unit;
                default:
                    String str4 = (String) obj;
                    str4.getClass();
                    StateFlowImpl stateFlowImpl2 = ((LibraryArtistsViewModel) this.receiver)._searchQuery;
                    stateFlowImpl2.getClass();
                    stateFlowImpl2.updateState(null, str4);
                    return unit;
            }
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$toImageSource$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00551 extends ContinuationImpl {
        public Buffer L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00551(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.toImageSource(null, this);
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$writeToDiskCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00561 extends ContinuationImpl {
        public RealDiskCache.RealSnapshot L$0;
        public NetworkResponse L$3;
        public NetworkResponse L$5;
        public ConnectionPool L$6;
        public int label;
        public /* synthetic */ Object result;

        public C00561(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.writeToDiskCache(null, null, null, this);
        }
    }

    public NetworkFetcher(String str, Options options, SynchronizedLazyImpl synchronizedLazyImpl, SynchronizedLazyImpl synchronizedLazyImpl2, SynchronizedLazyImpl synchronizedLazyImpl3, InitializedLazyImpl initializedLazyImpl, SynchronizedLazyImpl synchronizedLazyImpl4) {
        this.url = str;
        this.options = options;
        this.networkClient = synchronizedLazyImpl;
        this.diskCache = synchronizedLazyImpl2;
        this.cacheStrategy = synchronizedLazyImpl3;
        this.connectivityChecker = initializedLazyImpl;
        this.concurrentRequestStrategy = synchronizedLazyImpl4;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0013  */
    public static String getMimeType(String str, String str2) {
        String mimeTypeFromExtension;
        if (str2 == null || StringsKt__StringsJVMKt.startsWith(str2, "text/plain", false)) {
            if (StringsKt.isBlank(str)) {
                mimeTypeFromExtension = null;
            } else {
                String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(str, '#'), '?');
                String strSubstringAfterLast = StringsKt.substringAfterLast('.', StringsKt.substringAfterLast('/', strSubstringBeforeLast$default, strSubstringBeforeLast$default), "");
                if (StringsKt.isBlank(strSubstringAfterLast)) {
                    mimeTypeFromExtension = null;
                } else {
                    String lowerCase = strSubstringAfterLast.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    mimeTypeFromExtension = (String) MimeTypesKt.mimeTypeData.get(lowerCase);
                    if (mimeTypeFromExtension == null) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                    }
                }
            }
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        if (str2 != null) {
            return StringsKt.substringBefore$default(str2, ';');
        }
        return null;
    }

    public static void throwIfFailureResponseCode(NetworkResponse networkResponse) {
        int i = networkResponse.code;
        if ((200 > i || i >= 300) && i != 304) {
            throw new HttpException(IntIntPair$$ExternalSyntheticOutline0.m(i, "HTTP "));
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:75:0x0187  */
    /* JADX WARN: Code duplicated, block: B:76:0x0188 A[Catch: Exception -> 0x0043, PHI: r0 r1
      0x0188: PHI (r0v30 java.lang.Object) = (r0v20 java.lang.Object), (r0v1 java.lang.Object) binds: [B:74:0x0185, B:22:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r1v10 kotlin.jvm.internal.Ref$ObjectRef) = (r1v8 kotlin.jvm.internal.Ref$ObjectRef), (r1v16 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:74:0x0185, B:22:0x0052] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {Exception -> 0x0043, blocks: (B:15:0x003e, B:81:0x01ac, B:22:0x0052, B:76:0x0188, B:78:0x018c, B:58:0x011e, B:60:0x0124, B:66:0x014d, B:68:0x0153, B:71:0x0162, B:72:0x0167, B:73:0x0168, B:41:0x00a3, B:43:0x00aa, B:45:0x00b8, B:52:0x00ea, B:54:0x00f6, B:48:0x00ce, B:50:0x00d8, B:63:0x0143, B:64:0x014b), top: B:93:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x018c A[Catch: Exception -> 0x0043, TryCatch #3 {Exception -> 0x0043, blocks: (B:15:0x003e, B:81:0x01ac, B:22:0x0052, B:76:0x0188, B:78:0x018c, B:58:0x011e, B:60:0x0124, B:66:0x014d, B:68:0x0153, B:71:0x0162, B:72:0x0167, B:73:0x0168, B:41:0x00a3, B:43:0x00aa, B:45:0x00b8, B:52:0x00ea, B:54:0x00f6, B:48:0x00ce, B:50:0x00d8, B:63:0x0143, B:64:0x014b), top: B:93:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a9, code lost:
    
        if (r0 == r12) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doFetch(Continuation continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRefM5m;
        RealDiskCache.RealSnapshot realSnapshot;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        RealDiskCache realDiskCache;
        SourceFetchResult sourceFetchResult;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objM858executeRequestimpl = anonymousClass2.result;
        Ref$ObjectRef ref$ObjectRef3 = anonymousClass2.label;
        DataSource dataSource = DataSource.DISK;
        SynchronizedLazyImpl synchronizedLazyImpl = this.networkClient;
        String str = this.url;
        Options options = this.options;
        Continuation continuation2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (ref$ObjectRef3 != 0) {
                if (ref$ObjectRef3 == 1) {
                    Ref$ObjectRef ref$ObjectRef4 = anonymousClass2.L$1;
                    Ref$ObjectRef ref$ObjectRef5 = anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(objM858executeRequestimpl);
                        ref$ObjectRef2 = ref$ObjectRef4;
                        ref$ObjectRefM5m = ref$ObjectRef5;
                    } catch (Exception e) {
                        e = e;
                        ref$ObjectRef3 = ref$ObjectRef5;
                        RealDiskCache.RealSnapshot realSnapshot2 = (RealDiskCache.RealSnapshot) ref$ObjectRef3.element;
                        if (realSnapshot2 != null) {
                            try {
                                Fragment$5$$ExternalSyntheticOutline0.m((AutoCloseable) realSnapshot2);
                            } catch (RuntimeException e2) {
                                throw e2;
                            } catch (Exception unused) {
                            }
                        }
                        throw e;
                    }
                } else if (ref$ObjectRef3 == 2) {
                    ref$ObjectRefM5m = anonymousClass2.L$0;
                    ResultKt.throwOnFailure(objM858executeRequestimpl);
                    sourceFetchResult = (SourceFetchResult) objM858executeRequestimpl;
                    if (sourceFetchResult != null) {
                        return sourceFetchResult;
                    }
                    CallFactoryNetworkClient callFactoryNetworkClient = (CallFactoryNetworkClient) synchronizedLazyImpl.getValue();
                    NetworkRequest networkRequestNewRequest = newRequest();
                    App.C01391 c01391 = new App.C01391((Object) this, continuation2, (byte) 10);
                    anonymousClass2.L$0 = ref$ObjectRefM5m;
                    anonymousClass2.L$1 = null;
                    anonymousClass2.label = 3;
                    objM858executeRequestimpl = CallFactoryNetworkClient.m858executeRequestimpl(callFactoryNetworkClient.callFactory, networkRequestNewRequest, c01391, anonymousClass2);
                } else {
                    if (ref$ObjectRef3 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Ref$ObjectRef ref$ObjectRef6 = anonymousClass2.L$0;
                    ResultKt.throwOnFailure(objM858executeRequestimpl);
                }
                return (SourceFetchResult) objM858executeRequestimpl;
            }
            ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(objM858executeRequestimpl);
            if (!options.diskCachePolicy.readEnabled || (realDiskCache = (RealDiskCache) this.diskCache.getValue()) == null) {
                realSnapshot = null;
            } else {
                String str2 = options.diskCacheKey;
                if (str2 == null) {
                    str2 = str;
                }
                DiskLruCache diskLruCache = realDiskCache.cache;
                ByteString byteString = ByteString.EMPTY;
                DiskLruCache.Snapshot snapshot = diskLruCache.get(Path.Companion.encodeUtf8(str2).digest$okio("SHA-256").hex());
                if (snapshot != null) {
                    realSnapshot = new RealDiskCache.RealSnapshot(snapshot);
                } else {
                    realSnapshot = null;
                }
            }
            ref$ObjectRefM5m.element = realSnapshot;
            Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
            if (realSnapshot != null) {
                FileSystem fileSystem = getFileSystem();
                DiskLruCache.Snapshot snapshot2 = ((RealDiskCache.RealSnapshot) ref$ObjectRefM5m.element).snapshot;
                if (snapshot2.closed) {
                    throw new IllegalStateException("snapshot is closed");
                }
                Long l = (Long) fileSystem.metadata((Path) snapshot2.entry.cleanFiles.get(0)).size;
                if (l != null && l.longValue() == 0) {
                    return new SourceFetchResult(toImageSource((RealDiskCache.RealSnapshot) ref$ObjectRefM5m.element), getMimeType(str, null), dataSource);
                }
                NetworkResponse networkResponseOrNull = toNetworkResponseOrNull((RealDiskCache.RealSnapshot) ref$ObjectRefM5m.element);
                ref$ObjectRef7.element = networkResponseOrNull;
                if (networkResponseOrNull != null) {
                    CacheStrategy cacheStrategy = (CacheStrategy) this.cacheStrategy.getValue();
                    NetworkResponse networkResponse = (NetworkResponse) ref$ObjectRef7.element;
                    newRequest();
                    anonymousClass2.L$0 = ref$ObjectRefM5m;
                    anonymousClass2.L$1 = ref$ObjectRef7;
                    anonymousClass2.label = 1;
                    ((DefaultCacheStrategy) cacheStrategy).getClass();
                    CacheStrategy.ReadResult readResult = new CacheStrategy.ReadResult(networkResponse);
                    if (readResult != coroutineSingletons) {
                        ref$ObjectRef2 = ref$ObjectRef7;
                        objM858executeRequestimpl = readResult;
                    }
                }
                return coroutineSingletons;
            }
            ref$ObjectRef = ref$ObjectRef7;
            if (options.networkCachePolicy.readEnabled && Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                throw new NetworkOnMainThreadException();
            }
            NetworkRequest networkRequestNewRequest2 = newRequest();
            CallFactoryNetworkClient callFactoryNetworkClient2 = (CallFactoryNetworkClient) synchronizedLazyImpl.getValue();
            NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$1 = new NetworkFetcher$doFetch$fetchResult$1(ref$ObjectRefM5m, this, ref$ObjectRef, networkRequestNewRequest2, null);
            anonymousClass2.L$0 = ref$ObjectRefM5m;
            anonymousClass2.L$1 = null;
            anonymousClass2.label = 2;
            objM858executeRequestimpl = CallFactoryNetworkClient.m858executeRequestimpl(callFactoryNetworkClient2.callFactory, networkRequestNewRequest2, networkFetcher$doFetch$fetchResult$1, anonymousClass2);
            if (objM858executeRequestimpl == coroutineSingletons) {
                sourceFetchResult = (SourceFetchResult) objM858executeRequestimpl;
                if (sourceFetchResult != null) {
                    return sourceFetchResult;
                }
                CallFactoryNetworkClient callFactoryNetworkClient3 = (CallFactoryNetworkClient) synchronizedLazyImpl.getValue();
                NetworkRequest networkRequestNewRequest3 = newRequest();
                App.C01391 c01392 = new App.C01391((Object) this, continuation2, (byte) 10);
                anonymousClass2.L$0 = ref$ObjectRefM5m;
                anonymousClass2.L$1 = null;
                anonymousClass2.label = 3;
                objM858executeRequestimpl = CallFactoryNetworkClient.m858executeRequestimpl(callFactoryNetworkClient3.callFactory, networkRequestNewRequest3, c01392, anonymousClass2);
            }
            return coroutineSingletons;
            CacheStrategy.ReadResult readResult2 = (CacheStrategy.ReadResult) objM858executeRequestimpl;
            NetworkResponse networkResponse2 = readResult2.response;
            if (networkResponse2 != null) {
                throwIfFailureResponseCode(networkResponse2);
                return new SourceFetchResult(toImageSource((RealDiskCache.RealSnapshot) ref$ObjectRefM5m.element), getMimeType(str, readResult2.response.headers.get()), dataSource);
            }
            ref$ObjectRef = ref$ObjectRef2;
            if (options.networkCachePolicy.readEnabled) {
                throw new NetworkOnMainThreadException();
            }
            NetworkRequest networkRequestNewRequest4 = newRequest();
            CallFactoryNetworkClient callFactoryNetworkClient4 = (CallFactoryNetworkClient) synchronizedLazyImpl.getValue();
            NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$2 = new NetworkFetcher$doFetch$fetchResult$1(ref$ObjectRefM5m, this, ref$ObjectRef, networkRequestNewRequest4, null);
            anonymousClass2.L$0 = ref$ObjectRefM5m;
            anonymousClass2.L$1 = null;
            anonymousClass2.label = 2;
            objM858executeRequestimpl = CallFactoryNetworkClient.m858executeRequestimpl(callFactoryNetworkClient4.callFactory, networkRequestNewRequest4, networkFetcher$doFetch$fetchResult$2, anonymousClass2);
            if (objM858executeRequestimpl == coroutineSingletons) {
                sourceFetchResult = (SourceFetchResult) objM858executeRequestimpl;
                if (sourceFetchResult != null) {
                    return sourceFetchResult;
                }
                CallFactoryNetworkClient callFactoryNetworkClient5 = (CallFactoryNetworkClient) synchronizedLazyImpl.getValue();
                NetworkRequest networkRequestNewRequest5 = newRequest();
                App.C01391 c01393 = new App.C01391((Object) this, continuation2, (byte) 10);
                anonymousClass2.L$0 = ref$ObjectRefM5m;
                anonymousClass2.L$1 = null;
                anonymousClass2.label = 3;
                objM858executeRequestimpl = CallFactoryNetworkClient.m858executeRequestimpl(callFactoryNetworkClient5.callFactory, networkRequestNewRequest5, c01393, anonymousClass2);
            }
            return coroutineSingletons;
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // coil3.fetch.Fetcher
    public final Object fetch(EngineInterceptor.C00531 c00531) {
        UncoordinatedConcurrentRequestStrategy uncoordinatedConcurrentRequestStrategy = (UncoordinatedConcurrentRequestStrategy) this.concurrentRequestStrategy.getValue();
        String str = this.options.diskCacheKey;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(1, this, NetworkFetcher.class, "doFetch", "doFetch(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0, (byte) 0);
        uncoordinatedConcurrentRequestStrategy.getClass();
        return anonymousClass2.invoke(c00531);
    }

    public final FileSystem getFileSystem() {
        FileSystem fileSystem;
        RealDiskCache realDiskCache = (RealDiskCache) this.diskCache.getValue();
        return (realDiskCache == null || (fileSystem = realDiskCache.fileSystem) == null) ? this.options.fileSystem : fileSystem;
    }

    public final NetworkRequest newRequest() {
        Extras.Key key = ImageRequestsKt.httpHeadersKey;
        Options options = this.options;
        NetworkHeaders networkHeaders = (NetworkHeaders) UriKt.getExtra(options, key);
        networkHeaders.getClass();
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder(networkHeaders);
        CachePolicy cachePolicy = options.diskCachePolicy;
        boolean z = cachePolicy.readEnabled;
        boolean z2 = options.networkCachePolicy.readEnabled && ((ConnectivityChecker) this.connectivityChecker.value).isOnline();
        if (!z2 && z) {
            builder.set("only-if-cached, max-stale=2147483647");
        } else if (!z2 || z) {
            if (!z2 && !z) {
                builder.set("no-cache, only-if-cached");
            }
        } else if (cachePolicy.writeEnabled) {
            builder.set(CacheControl.NO_CACHE);
        } else {
            builder.set("no-cache, no-store");
        }
        String str = (String) UriKt.getExtra(options, ImageRequestsKt.httpMethodKey);
        NetworkHeaders networkHeaders2 = new NetworkHeaders(MapsKt__MapsKt.toMap(builder.data));
        if (UriKt.getExtra(options, ImageRequestsKt.httpBodyKey) == null) {
            return new NetworkRequest(this.url, str, networkHeaders2, options.extras);
        }
        PathKt$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object toImageSource(SourceResponseBody sourceResponseBody, ContinuationImpl continuationImpl) {
        C00551 c00551;
        Buffer buffer;
        if (continuationImpl instanceof C00551) {
            c00551 = (C00551) continuationImpl;
            int i = c00551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00551.label = i - Integer.MIN_VALUE;
            } else {
                c00551 = new C00551(continuationImpl);
            }
        } else {
            c00551 = new C00551(continuationImpl);
        }
        Object obj = c00551.result;
        int i2 = c00551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Buffer buffer2 = new Buffer();
            c00551.L$1 = buffer2;
            c00551.label = 1;
            sourceResponseBody.source.readAll(buffer2);
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (unit == coroutineSingletons) {
                return coroutineSingletons;
            }
            buffer = buffer2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            buffer = c00551.L$1;
            ResultKt.throwOnFailure(obj);
        }
        return new SourceImageSource(buffer, getFileSystem(), null);
    }

    public final NetworkResponse toNetworkResponseOrNull(RealDiskCache.RealSnapshot realSnapshot) throws Throwable {
        Throwable th;
        NetworkResponse from;
        try {
            FileSystem fileSystem = getFileSystem();
            DiskLruCache.Snapshot snapshot = realSnapshot.snapshot;
            if (snapshot.closed) {
                throw new IllegalStateException("snapshot is closed");
            }
            Source source = fileSystem.source((Path) snapshot.entry.cleanFiles.get(0));
            source.getClass();
            RealBufferedSource realBufferedSource = new RealBufferedSource(source);
            try {
                from = LifecyclesKt.readFrom(realBufferedSource);
                try {
                    realBufferedSource.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    realBufferedSource.close();
                } catch (Throwable th4) {
                    ResultKt.addSuppressed(th3, th4);
                }
                th = th3;
                from = null;
            }
            if (th == null) {
                return from;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0230 A[Catch: Exception -> 0x003d, TryCatch #7 {Exception -> 0x003d, blocks: (B:13:0x0038, B:109:0x020a, B:116:0x0215, B:117:0x021f, B:119:0x022d, B:121:0x0230, B:124:0x0237, B:125:0x0238, B:118:0x0220), top: B:148:0x0038, inners: #11 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0255  */
    /* JADX WARN: Code duplicated, block: B:155:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0245 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x024f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0191  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [okhttp3.ConnectionPool] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [okhttp3.ConnectionPool] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [okhttp3.ConnectionPool] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32, types: [okhttp3.ConnectionPool] */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    public final Object writeToDiskCache(RealDiskCache.RealSnapshot realSnapshot, NetworkResponse networkResponse, NetworkResponse networkResponse2, ContinuationImpl continuationImpl) throws Exception {
        C00561 c00561;
        NetworkResponse networkResponse3;
        ConnectionPool connectionPool;
        ?? r4;
        ?? r1;
        ?? th;
        ?? th2;
        ?? r2;
        Latch latchEdit;
        ConnectionPool connectionPool2;
        SourceResponseBody sourceResponseBody;
        SourceResponseBody sourceResponseBody2;
        Latch latch;
        DiskLruCache diskLruCache;
        DiskLruCache.Snapshot snapshot;
        RealDiskCache.RealSnapshot realSnapshot2 = realSnapshot;
        NetworkResponse networkResponse4 = networkResponse2;
        if (continuationImpl instanceof C00561) {
            c00561 = (C00561) continuationImpl;
            int i = c00561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00561.label = i - Integer.MIN_VALUE;
            } else {
                c00561 = new C00561(continuationImpl);
            }
        } else {
            c00561 = new C00561(continuationImpl);
        }
        Object writeResult = c00561.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c00561.label;
        RealDiskCache.RealSnapshot realSnapshot3 = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(writeResult);
            if (!this.options.diskCachePolicy.writeEnabled) {
                if (realSnapshot2 != null) {
                    try {
                        Fragment$5$$ExternalSyntheticOutline0.m((AutoCloseable) realSnapshot2);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            CacheStrategy cacheStrategy = (CacheStrategy) this.cacheStrategy.getValue();
            c00561.L$0 = realSnapshot2;
            c00561.L$3 = networkResponse4;
            c00561.label = 1;
            ((DefaultCacheStrategy) cacheStrategy).getClass();
            int i3 = networkResponse4.code;
            if (i3 != 304 || networkResponse == null) {
                writeResult = ((200 > i3 || i3 >= 300) && !DefaultCacheStrategy.CACHEABLE_STATUS_CODES.contains(new Integer(i3))) ? CacheStrategy.WriteResult.DISABLED : new CacheStrategy.WriteResult(networkResponse4);
            } else {
                NetworkHeaders networkHeaders = networkResponse.headers;
                NetworkHeaders networkHeaders2 = networkResponse4.headers;
                networkHeaders.getClass();
                Map map = networkHeaders.data;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    linkedHashMap.put(entry.getKey(), CollectionsKt.toMutableList((Collection) entry.getValue()));
                }
                for (Map.Entry entry2 : networkHeaders2.data.entrySet()) {
                    String str = (String) entry2.getKey();
                    List list = (List) entry2.getValue();
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    linkedHashMap.put(lowerCase, CollectionsKt.toMutableList((Collection) list));
                }
                writeResult = new CacheStrategy.WriteResult(new NetworkResponse(networkResponse4.code, networkResponse4.requestMillis, networkResponse4.responseMillis, new NetworkHeaders(MapsKt__MapsKt.toMap(linkedHashMap)), null, networkResponse4.delegate));
            }
            if (writeResult != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            r1 = c00561.L$6;
            networkResponse3 = c00561.L$5;
            networkResponse4 = c00561.L$3;
            try {
                ResultKt.throwOnFailure(writeResult);
                r2 = r1;
                r1 = r2;
                latch = (Latch) r1.delegate;
                diskLruCache = (DiskLruCache) latch.spareList;
                synchronized (diskLruCache.lock) {
                    latch.complete(true);
                    snapshot = diskLruCache.get(((DiskLruCache.Entry) latch.lock).key);
                }
                if (snapshot != null) {
                    return new RealDiskCache.RealSnapshot(snapshot);
                }
                return realSnapshot3;
            } catch (Exception e2) {
                e = e2;
                try {
                    ((Latch) r1.delegate).complete(false);
                } catch (Exception unused2) {
                }
                sourceResponseBody = networkResponse4.body;
                if (sourceResponseBody != null) {
                    try {
                        Fragment$5$$ExternalSyntheticOutline0.m((AutoCloseable) sourceResponseBody);
                    } catch (RuntimeException e3) {
                        throw e3;
                    } catch (Exception unused3) {
                    }
                }
                sourceResponseBody2 = networkResponse3.body;
                if (sourceResponseBody2 != null) {
                    throw e;
                }
                try {
                    Fragment$5$$ExternalSyntheticOutline0.m((AutoCloseable) sourceResponseBody2);
                    throw e;
                } catch (RuntimeException e4) {
                    throw e4;
                } catch (Exception unused4) {
                    throw e;
                }
            }
        }
        NetworkResponse networkResponse5 = c00561.L$3;
        RealDiskCache.RealSnapshot realSnapshot4 = c00561.L$0;
        ResultKt.throwOnFailure(writeResult);
        networkResponse4 = networkResponse5;
        realSnapshot2 = realSnapshot4;
        realSnapshot3 = null;
        networkResponse3 = ((CacheStrategy.WriteResult) writeResult).response;
        if (networkResponse3 == null) {
            return realSnapshot3;
        }
        if (realSnapshot2 != null) {
            DiskLruCache.Snapshot snapshot2 = realSnapshot2.snapshot;
            DiskLruCache diskLruCache2 = DiskLruCache.this;
            synchronized (diskLruCache2.lock) {
                snapshot2.close();
                latchEdit = diskLruCache2.edit(snapshot2.entry.key);
            }
            if (latchEdit != null) {
                connectionPool2 = new ConnectionPool(latchEdit);
            } else {
                r4 = realSnapshot3;
            }
        } else {
            RealDiskCache realDiskCache = (RealDiskCache) this.diskCache.getValue();
            if (realDiskCache == null) {
                r4 = realSnapshot3;
            } else {
                String str2 = this.options.diskCacheKey;
                if (str2 == null) {
                    str2 = this.url;
                }
                DiskLruCache diskLruCache3 = realDiskCache.cache;
                ByteString byteString = ByteString.EMPTY;
                Latch latchEdit2 = diskLruCache3.edit(Path.Companion.encodeUtf8(str2).digest$okio("SHA-256").hex());
                if (latchEdit2 != null) {
                    connectionPool = new ConnectionPool(latchEdit2);
                } else {
                    r4 = realSnapshot3;
                }
            }
        }
        if (r4 == 0) {
            r4 = connectionPool;
            r4 = connectionPool2;
            return realSnapshot3;
        }
        try {
            r4 = connectionPool;
            r4 = connectionPool2;
            RealBufferedSink realBufferedSinkBuffer = Okio__OkioKt.buffer(getFileSystem().sink(((Latch) r4.delegate).file(0), false));
            try {
                LifecyclesKt.writeTo(networkResponse3, realBufferedSinkBuffer);
                try {
                    realBufferedSinkBuffer.close();
                    th = realSnapshot3;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                try {
                    realBufferedSinkBuffer.close();
                } catch (Throwable th5) {
                    ResultKt.addSuppressed(th4, th5);
                }
                th = th4;
            }
            if (th != 0) {
                throw th;
            }
            SourceResponseBody sourceResponseBody3 = networkResponse3.body;
            if (sourceResponseBody3 != null) {
                FileSystem fileSystem = getFileSystem();
                Path pathFile = ((Latch) r4.delegate).file(1);
                realSnapshot3 = realSnapshot3;
                c00561.L$0 = realSnapshot3;
                c00561.L$3 = networkResponse4;
                c00561.L$5 = networkResponse3;
                c00561.L$6 = r4;
                c00561.label = 2;
                BufferedSource bufferedSource = sourceResponseBody3.source;
                RealBufferedSink realBufferedSinkBuffer2 = Okio__OkioKt.buffer(fileSystem.sink(pathFile, false));
                try {
                    Boxing.boxLong(bufferedSource.readAll(realBufferedSinkBuffer2));
                    try {
                        realBufferedSinkBuffer2.close();
                        th2 = realSnapshot3;
                    } catch (Throwable th6) {
                        th2 = th6;
                    }
                } catch (Throwable th7) {
                    try {
                        realBufferedSinkBuffer2.close();
                    } catch (Throwable th8) {
                        ResultKt.addSuppressed(th7, th8);
                    }
                    th2 = th7;
                }
                if (th2 != 0) {
                    throw th2;
                }
                Unit unit = Unit.INSTANCE;
                if (unit != coroutineSingletons) {
                    r2 = r4;
                    writeResult = unit;
                    r1 = r2;
                }
                return coroutineSingletons;
            }
            realSnapshot3 = realSnapshot3;
            r1 = r4;
            latch = (Latch) r1.delegate;
            diskLruCache = (DiskLruCache) latch.spareList;
            synchronized (diskLruCache.lock) {
                latch.complete(true);
                snapshot = diskLruCache.get(((DiskLruCache.Entry) latch.lock).key);
                if (snapshot != null) {
                    return new RealDiskCache.RealSnapshot(snapshot);
                }
                return realSnapshot3;
            }
        } catch (Exception e5) {
            e = e5;
            r1 = r4;
            ((Latch) r1.delegate).complete(false);
            sourceResponseBody = networkResponse4.body;
            if (sourceResponseBody != null) {
                Fragment$5$$ExternalSyntheticOutline0.m((AutoCloseable) sourceResponseBody);
            }
            sourceResponseBody2 = networkResponse3.body;
            if (sourceResponseBody2 != null) {
                throw e;
            }
            Fragment$5$$ExternalSyntheticOutline0.m((AutoCloseable) sourceResponseBody2);
            throw e;
        }
    }

    public final FileImageSource toImageSource(RealDiskCache.RealSnapshot realSnapshot) {
        DiskLruCache.Snapshot snapshot = realSnapshot.snapshot;
        if (!snapshot.closed) {
            Path path = (Path) snapshot.entry.cleanFiles.get(1);
            FileSystem fileSystem = getFileSystem();
            String str = this.options.diskCacheKey;
            if (str == null) {
                str = this.url;
            }
            return MathKt.ImageSource$default(path, fileSystem, str, realSnapshot, 16);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("snapshot is closed");
        return null;
    }
}
