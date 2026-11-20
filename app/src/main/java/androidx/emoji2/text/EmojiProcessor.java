package androidx.emoji2.text;

import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.appcompat.app.TwilightManager$TwilightState;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.collection.ArraySet;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.internal.Lock;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.CachedItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.pager.MeasuredPage;
import androidx.compose.foundation.pager.PagerMeasureResult;
import androidx.compose.foundation.pager.PagerState$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Latch;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.Thread_androidKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.Invalidation;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.compose.ui.node.SortedSet;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.AppOpsManagerCompat$Api29Impl;
import androidx.core.app.NavUtils;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompatBuilder$Api28Impl;
import androidx.core.app.NotificationCompatBuilder$Api31Impl;
import androidx.core.app.NotificationCompatBuilder$Api36Impl;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleService;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.offline.ProgressiveDownloader;
import androidx.media3.exoplayer.offline.SegmentDownloaderFactory;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.exoplayer.source.UnrecognizedInputFormatException;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.webvtt.WebvttCueInfo;
import androidx.media3.extractor.ts.SectionPayloadReader;
import androidx.media3.extractor.ts.TsPayloadReader;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerImplLegacy;
import androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda1;
import androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.ImageLoader$Builder;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.base.Joiner;
import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenableFuture;
import com.metrolist.music.playback.DownloadUtil$$ExternalSyntheticLambda2;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.EOFException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiProcessor implements CacheWindowScope, SaveableStateRegistry.Entry, Subtitle, SectionPayloadReader {
    public static EmojiProcessor sInstance;
    public final /* synthetic */ byte $r8$classId;
    public Object mGlyphChecker;
    public Object mMetadataRepo;
    public Object mSpanFactory;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface EmojiProcessCallback {
        Object getResult();

        boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ProcessorSm {
        public int mCurrentDepth;
        public MetadataRepo$Node mCurrentNode;
        public MetadataRepo$Node mFlushNode;
        public int mLastCodepoint;
        public final MetadataRepo$Node mRootNode;
        public byte mState = 1;

        public ProcessorSm(MetadataRepo$Node metadataRepo$Node) {
            this.mRootNode = metadataRepo$Node;
            this.mCurrentNode = metadataRepo$Node;
        }

        public final void reset() {
            this.mState = (byte) 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
        }

        public final boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            MetadataItem metadataItem = this.mCurrentNode.mData.getMetadataItem();
            int i__offset = metadataItem.__offset(6);
            return !(i__offset == 0 || ((ByteBuffer) metadataItem.bb).get(i__offset + metadataItem.bb_pos) == 0) || this.mLastCodepoint == 65039;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.content.Context, android.content.res.Resources] */
    public EmojiProcessor(NotificationCompat$Builder notificationCompat$Builder) {
        byte b;
        int i;
        int i2;
        this.$r8$classId = (byte) 17;
        this.mGlyphChecker = new Bundle();
        this.mMetadataRepo = notificationCompat$Builder;
        Context context = notificationCompat$Builder.mContext;
        ArrayList arrayList = notificationCompat$Builder.mPeople;
        ArrayList arrayList2 = notificationCompat$Builder.mPersonList;
        ArrayList arrayList3 = notificationCompat$Builder.mInvisibleActions;
        String str = notificationCompat$Builder.mChannelId;
        Notification.Builder builder = new Notification.Builder(context, str);
        this.mSpanFactory = builder;
        Notification notification = notificationCompat$Builder.mNotification;
        ?? r11 = 0;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(notificationCompat$Builder.mContentTitle).setContentText(notificationCompat$Builder.mContentText).setContentInfo(null).setContentIntent(notificationCompat$Builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        IconCompat iconCompat = notificationCompat$Builder.mLargeIcon;
        builder.setLargeIcon(iconCompat == null ? null : FileSystemsKt.toIcon(iconCompat, context));
        builder.setSubText(null).setUsesChronometer(notificationCompat$Builder.mUseChronometer).setPriority(notificationCompat$Builder.mPriority);
        ArrayList arrayList4 = notificationCompat$Builder.mActions;
        int size = arrayList4.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList4.get(i3);
            i3++;
            NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action) obj;
            IconCompat iconCompatCreateWithResource = notificationCompat$Action.mIcon;
            if (iconCompatCreateWithResource == null && (i2 = notificationCompat$Action.icon) != 0) {
                iconCompatCreateWithResource = IconCompat.createWithResource(r11, "", i2);
                notificationCompat$Action.mIcon = iconCompatCreateWithResource;
            }
            boolean z = notificationCompat$Action.mAllowGeneratedReplies;
            Bundle bundle = notificationCompat$Action.mExtras;
            ArrayList arrayList5 = arrayList4;
            ArrayList arrayList6 = arrayList2;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompatCreateWithResource != null ? FileSystemsKt.toIcon(iconCompatCreateWithResource, r11) : r11, notificationCompat$Action.title, notificationCompat$Action.actionIntent);
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putBoolean("android.support.allowGeneratedReplies", z);
            builder2.setAllowGeneratedReplies(z);
            bundle2.putInt("android.support.action.semanticAction", 0);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28) {
                NotificationCompatBuilder$Api28Impl.setSemanticAction(builder2);
            }
            if (i4 >= 29) {
                AppOpsManagerCompat$Api29Impl.setContextual(builder2);
            }
            if (i4 >= 31) {
                NotificationCompatBuilder$Api31Impl.setAuthenticationRequired(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", notificationCompat$Action.mShowsUserInterface);
            builder2.addExtras(bundle2);
            ((Notification.Builder) this.mSpanFactory).addAction(builder2.build());
            arrayList4 = arrayList5;
            arrayList2 = arrayList6;
            r11 = 0;
        }
        ArrayList arrayList7 = arrayList2;
        Bundle bundle3 = notificationCompat$Builder.mExtras;
        if (bundle3 != null) {
            ((Bundle) this.mGlyphChecker).putAll(bundle3);
        }
        ((Notification.Builder) this.mSpanFactory).setShowWhen(notificationCompat$Builder.mShowWhen);
        ((Notification.Builder) this.mSpanFactory).setLocalOnly(false);
        ((Notification.Builder) this.mSpanFactory).setGroup(notificationCompat$Builder.mGroupKey);
        ((Notification.Builder) this.mSpanFactory).setSortKey(null);
        ((Notification.Builder) this.mSpanFactory).setGroupSummary(false);
        ((Notification.Builder) this.mSpanFactory).setCategory(null);
        ((Notification.Builder) this.mSpanFactory).setColor(0);
        ((Notification.Builder) this.mSpanFactory).setVisibility(notificationCompat$Builder.mVisibility);
        ((Notification.Builder) this.mSpanFactory).setPublicVersion(null);
        ((Notification.Builder) this.mSpanFactory).setSound(notification.sound, notification.audioAttributes);
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList8 = new ArrayList(arrayList7.size());
            Iterator it = arrayList7.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                PathKt$$ExternalSyntheticBUOutline0.m();
                throw null;
            }
            ArraySet arraySet = new ArraySet(arrayList.size() + arrayList8.size());
            arraySet.addAll(arrayList8);
            arraySet.addAll(arrayList);
            arrayList = new ArrayList(arraySet);
        }
        if (!arrayList.isEmpty()) {
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = arrayList.get(i5);
                i5++;
                ((Notification.Builder) this.mSpanFactory).addPerson((String) obj2);
            }
        }
        if (arrayList3.size() > 0) {
            Bundle bundle4 = notificationCompat$Builder.mExtras;
            if (bundle4 == null) {
                bundle4 = new Bundle();
                notificationCompat$Builder.mExtras = bundle4;
            }
            Bundle bundle5 = bundle4.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            int i6 = 0;
            while (i6 < arrayList3.size()) {
                String string = Integer.toString(i6);
                NotificationCompat$Action notificationCompat$Action2 = (NotificationCompat$Action) arrayList3.get(i6);
                Bundle bundle8 = new Bundle();
                IconCompat iconCompatCreateWithResource2 = notificationCompat$Action2.mIcon;
                if (iconCompatCreateWithResource2 == null && (i = notificationCompat$Action2.icon) != 0) {
                    iconCompatCreateWithResource2 = IconCompat.createWithResource(null, "", i);
                    notificationCompat$Action2.mIcon = iconCompatCreateWithResource2;
                }
                Bundle bundle9 = notificationCompat$Action2.mExtras;
                bundle8.putInt("icon", iconCompatCreateWithResource2 != null ? iconCompatCreateWithResource2.getResId() : 0);
                bundle8.putCharSequence(LinkHeader.Parameters.Title, notificationCompat$Action2.title);
                bundle8.putParcelable("actionIntent", notificationCompat$Action2.actionIntent);
                Bundle bundle10 = bundle9 != null ? new Bundle(bundle9) : new Bundle();
                bundle10.putBoolean("android.support.allowGeneratedReplies", notificationCompat$Action2.mAllowGeneratedReplies);
                bundle8.putBundle("extras", bundle10);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", notificationCompat$Action2.mShowsUserInterface);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(string, bundle8);
                i6++;
                arrayList3 = arrayList3;
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            Bundle bundle11 = notificationCompat$Builder.mExtras;
            if (bundle11 == null) {
                bundle11 = new Bundle();
                notificationCompat$Builder.mExtras = bundle11;
            }
            bundle11.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) this.mGlyphChecker).putBundle("android.car.EXTENSIONS", bundle6);
        }
        ((Notification.Builder) this.mSpanFactory).setExtras(notificationCompat$Builder.mExtras);
        ((Notification.Builder) this.mSpanFactory).setRemoteInputHistory(null);
        ((Notification.Builder) this.mSpanFactory).setBadgeIconType(0);
        ((Notification.Builder) this.mSpanFactory).setSettingsText(null);
        ((Notification.Builder) this.mSpanFactory).setShortcutId(null);
        ((Notification.Builder) this.mSpanFactory).setTimeoutAfter(0L);
        ((Notification.Builder) this.mSpanFactory).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(str)) {
            ((Notification.Builder) this.mSpanFactory).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            Iterator it2 = arrayList7.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                PathKt$$ExternalSyntheticBUOutline0.m();
                throw null;
            }
        }
        if (i7 >= 29) {
            AppOpsManagerCompat$Api29Impl.setAllowSystemGeneratedContextualActions((Notification.Builder) this.mSpanFactory);
            AppOpsManagerCompat$Api29Impl.setBubbleMetadata((Notification.Builder) this.mSpanFactory);
        }
        if (i7 >= 31 && (b = notificationCompat$Builder.mFgsDeferBehavior) != 0) {
            NotificationCompatBuilder$Api31Impl.setForegroundServiceBehavior((Notification.Builder) this.mSpanFactory, b);
        }
        if (i7 >= 36) {
            NotificationCompatBuilder$Api36Impl.setShortCriticalText((Notification.Builder) this.mSpanFactory);
        }
    }

    public static DefaultDrmSessionManager createManager(MediaItem.DrmConfiguration drmConfiguration) {
        AtomicInt atomicInt = new AtomicInt((byte) 17);
        Uri uri = drmConfiguration.licenseUri;
        Latch latch = new Latch(uri == null ? null : uri.toString(), drmConfiguration.forceDefaultLicenseUri, atomicInt);
        UnmodifiableIterator it = drmConfiguration.licenseRequestHeaders.entrySet().iterator();
        while (true) {
            AbstractIndexedListIterator abstractIndexedListIterator = (AbstractIndexedListIterator) it;
            if (!abstractIndexedListIterator.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) abstractIndexedListIterator.next();
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            str.getClass();
            str2.getClass();
            synchronized (((HashMap) latch.spareList)) {
                ((HashMap) latch.spareList).put(str, str2);
            }
        }
        HashMap map = new HashMap();
        int i = C.SUGGESTED_MAX_IPC_SIZE;
        CueDecoder cueDecoder = new CueDecoder((byte) 6);
        UUID uuid = drmConfiguration.scheme;
        uuid.getClass();
        boolean z = drmConfiguration.multiSession;
        boolean z2 = drmConfiguration.playClearContentWithoutKey;
        int[] array = StringsKt__IndentKt.toArray(drmConfiguration.forcedSessionTrackTypes);
        for (int i2 : array) {
            boolean z3 = true;
            if (i2 != 2 && i2 != 1) {
                z3 = false;
            }
            UtilsKt.checkArgument(z3);
        }
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid, latch, map, z, (int[]) array.clone(), z2, cueDecoder);
        byte[] bArr = drmConfiguration.keySetId;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        UtilsKt.checkState(defaultDrmSessionManager.sessions.isEmpty());
        defaultDrmSessionManager.offlineLicenseKeySetId = bArrCopyOf;
        return defaultDrmSessionManager;
    }

    public static void createSegmentDownloaderFactory(Class cls, CacheDataSource.Factory factory) {
        try {
            if (cls.getConstructor(CacheDataSource.Factory.class).newInstance(factory) == null) {
            } else {
                throw new ClassCastException();
            }
        } catch (Exception e) {
            throw new IllegalStateException("Downloader factory missing", e);
        }
    }

    public static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, TypefaceEmojiSpan.class)) != null && typefaceEmojiSpanArr.length > 0) {
                for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                    int spanStart = editable.getSpanStart(typefaceEmojiSpan);
                    int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean handleDeleteSurroundingText(EmojiInputConnection emojiInputConnection, Editable editable, int i, int i2, boolean z) {
        int iMin;
        if (editable != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
                if (z) {
                    int iMax = Math.max(i, 0);
                    int length = editable.length();
                    if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                        loop0: while (true) {
                            boolean z2 = false;
                            while (true) {
                                if (iMax == 0) {
                                    break loop0;
                                }
                                selectionStart--;
                                if (selectionStart < 0) {
                                    if (!z2) {
                                        selectionStart = 0;
                                        break loop0;
                                    }
                                    break loop0;
                                }
                                char cCharAt = editable.charAt(selectionStart);
                                if (z2) {
                                    if (Character.isHighSurrogate(cCharAt)) {
                                        iMax--;
                                    }
                                } else if (!Character.isSurrogate(cCharAt)) {
                                    iMax--;
                                } else if (!Character.isHighSurrogate(cCharAt)) {
                                    z2 = true;
                                }
                                selectionStart = -1;
                                break loop0;
                            }
                        }
                    }
                    selectionStart = -1;
                    break loop0;
                    int iMax2 = Math.max(i2, 0);
                    iMin = editable.length();
                    if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                        loop2: while (true) {
                            boolean z3 = false;
                            while (true) {
                                if (iMax2 != 0) {
                                    if (selectionEnd >= iMin) {
                                        if (!z3) {
                                            break loop2;
                                        }
                                        break loop2;
                                    }
                                    char cCharAt2 = editable.charAt(selectionEnd);
                                    if (z3) {
                                        if (Character.isLowSurrogate(cCharAt2)) {
                                            iMax2--;
                                            selectionEnd++;
                                        }
                                    } else if (!Character.isSurrogate(cCharAt2)) {
                                        iMax2--;
                                        selectionEnd++;
                                    } else if (!Character.isLowSurrogate(cCharAt2)) {
                                        selectionEnd++;
                                        z3 = true;
                                    }
                                    iMin = -1;
                                    break loop2;
                                }
                                iMin = selectionEnd;
                                break loop2;
                            }
                        }
                    }
                    iMin = -1;
                    break loop2;
                    if (selectionStart != -1 && iMin != -1) {
                    }
                } else {
                    selectionStart = Math.max(selectionStart - i, 0);
                    iMin = Math.min(selectionEnd + i2, editable.length());
                }
                TypefaceEmojiSpan[] typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, iMin, TypefaceEmojiSpan.class);
                if (typefaceEmojiSpanArr != null && typefaceEmojiSpanArr.length > 0) {
                    for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                        int spanStart = editable.getSpanStart(typefaceEmojiSpan);
                        int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
                        selectionStart = Math.min(spanStart, selectionStart);
                        iMin = Math.max(spanEnd, iMin);
                    }
                    int iMax3 = Math.max(selectionStart, 0);
                    int iMin2 = Math.min(iMin, editable.length());
                    emojiInputConnection.beginBatchEdit();
                    editable.delete(iMax3, iMin2);
                    emojiInputConnection.endBatchEdit();
                    return true;
                }
            }
        }
        return false;
    }

    public static EmojiProcessor obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new EmojiProcessor(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public void add(LayoutNode layoutNode, Invalidation invalidation) {
        DrawResult drawResult = (DrawResult) this.mSpanFactory;
        DrawResult drawResult2 = (DrawResult) this.mMetadataRepo;
        DrawResult drawResult3 = (DrawResult) this.mGlyphChecker;
        int iOrdinal = invalidation.ordinal();
        if (iOrdinal == 0) {
            drawResult.add(layoutNode);
            drawResult3.add(layoutNode);
            return;
        }
        if (iOrdinal == 1) {
            drawResult2.add(layoutNode);
            drawResult3.add(layoutNode);
            return;
        }
        if (iOrdinal == 2) {
            if (layoutNode.lookaheadRoot != null) {
                drawResult3.add(layoutNode);
                return;
            } else {
                drawResult.add(layoutNode);
                return;
            }
        }
        if (iOrdinal != 3) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        } else if (layoutNode.lookaheadRoot != null) {
            drawResult3.add(layoutNode);
        } else {
            drawResult2.add(layoutNode);
        }
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void consume(ParsableByteArray parsableByteArray) {
        long firstSampleTimestampUs;
        long j;
        ((TimestampAdjuster) this.mMetadataRepo).getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        TimestampAdjuster timestampAdjuster = (TimestampAdjuster) this.mMetadataRepo;
        synchronized (timestampAdjuster) {
            try {
                long j2 = timestampAdjuster.lastUnadjustedTimestampUs;
                firstSampleTimestampUs = j2 != -9223372036854775807L ? j2 + timestampAdjuster.timestampOffsetUs : timestampAdjuster.getFirstSampleTimestampUs();
            } catch (Throwable th) {
                throw th;
            }
        }
        TimestampAdjuster timestampAdjuster2 = (TimestampAdjuster) this.mMetadataRepo;
        synchronized (timestampAdjuster2) {
            j = timestampAdjuster2.timestampOffsetUs;
        }
        if (firstSampleTimestampUs == -9223372036854775807L || j == -9223372036854775807L) {
            return;
        }
        Format format = (Format) this.mSpanFactory;
        if (j != format.subsampleOffsetUs) {
            Format.Builder builderBuildUpon = format.buildUpon();
            builderBuildUpon.subsampleOffsetUs = j;
            Format format2 = new Format(builderBuildUpon);
            this.mSpanFactory = format2;
            ((TrackOutput) this.mGlyphChecker).format(format2);
        }
        int iBytesLeft = parsableByteArray.bytesLeft();
        ((TrackOutput) this.mGlyphChecker).sampleData(iBytesLeft, parsableByteArray);
        ((TrackOutput) this.mGlyphChecker).sampleMetadata(firstSampleTimestampUs, 1, iBytesLeft, 0, null);
    }

    public boolean contains(LayoutNode layoutNode) {
        return !(layoutNode.lookaheadRoot == null) && (((SortedSet) ((DrawResult) this.mSpanFactory).block).contains(layoutNode) || ((SortedSet) ((DrawResult) this.mMetadataRepo).block).contains(layoutNode));
    }

    public ProgressiveDownloader createDownloader(DownloadRequest downloadRequest) {
        CacheDataSource.Factory factory = (CacheDataSource.Factory) this.mSpanFactory;
        Uri uri = downloadRequest.uri;
        String str = downloadRequest.customCacheKey;
        int iInferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(uri, downloadRequest.mimeType);
        if (iInferContentTypeForUriAndMimeType != 0 && iInferContentTypeForUriAndMimeType != 1 && iInferContentTypeForUriAndMimeType != 2) {
            if (iInferContentTypeForUriAndMimeType != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(iInferContentTypeForUriAndMimeType, "Unsupported type: "));
                return null;
            }
            DownloadRequest.ByteRange byteRange = downloadRequest.byteRange;
            MediaItem.Builder builder = new MediaItem.Builder();
            builder.uri = uri;
            builder.customCacheKey = str;
            return new ProgressiveDownloader(builder.build(), factory, (DownloadUtil$$ExternalSyntheticLambda2) this.mMetadataRepo, byteRange != null ? byteRange.offset : 0L, byteRange != null ? byteRange.length : -1L);
        }
        SparseArray sparseArray = (SparseArray) this.mGlyphChecker;
        if (sparseArray.indexOfKey(iInferContentTypeForUriAndMimeType) < 0) {
            try {
                loadSegmentDownloaderFactory(iInferContentTypeForUriAndMimeType, factory);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(IntIntPair$$ExternalSyntheticOutline0.m(iInferContentTypeForUriAndMimeType, "Module missing for content type "), e);
            }
        } else if (sparseArray.get(iInferContentTypeForUriAndMimeType) != null) {
            PathKt$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        MediaItem.Builder builder2 = new MediaItem.Builder();
        DownloadRequest.TimeRange timeRange = downloadRequest.timeRange;
        builder2.uri = uri;
        List list = downloadRequest.streamKeys;
        builder2.streamKeys = (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
        builder2.customCacheKey = str;
        builder2.build();
        timeRange.getClass();
        throw null;
    }

    public Object get() {
        long jCurrentThreadId = Expect_jvmKt.currentThreadId();
        if (jCurrentThreadId == Thread_androidKt.MainThreadId) {
            return this.mGlyphChecker;
        }
        ThreadMap threadMap = (ThreadMap) ((AtomicReference) this.mSpanFactory).get();
        int iFind = threadMap.find(jCurrentThreadId);
        if (iFind >= 0) {
            return threadMap.values[iFind];
        }
        return null;
    }

    public Canvas getCanvas() {
        return ((CanvasDrawScope) this.mGlyphChecker).drawParams.canvas;
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = (TypedArray) this.mMetadataRepo;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = NavUtils.getColorStateList((Context) this.mSpanFactory, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List getCues(long j) {
        List list = (List) this.mSpanFactory;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            long[] jArr = (long[]) this.mMetadataRepo;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                WebvttCueInfo webvttCueInfo = (WebvttCueInfo) list.get(i);
                Cue cue = webvttCueInfo.cue;
                if (cue.line == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, new LayoutNode$$ExternalSyntheticLambda1((byte) 22));
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            Cue cue2 = ((WebvttCueInfo) arrayList2.get(i3)).cue;
            arrayList.add(new Cue(cue2.text, cue2.textAlignment, cue2.multiRowAlignment, cue2.bitmap, (-1) - i3, 1, cue2.lineAnchor, cue2.position, cue2.positionAnchor, cue2.textSizeType, cue2.textSize, cue2.size, cue2.bitmapHeight, cue2.windowColorSet, cue2.windowColor, cue2.verticalType, cue2.shearDegrees, cue2.zIndex));
        }
        return arrayList;
    }

    public LocaleList getCurrent() {
        android.os.LocaleList localeList = android.os.LocaleList.getDefault();
        synchronized (((Lock) this.mGlyphChecker)) {
            try {
                LocaleList localeList2 = (LocaleList) this.mMetadataRepo;
                if (localeList2 != null && localeList == ((android.os.LocaleList) this.mSpanFactory)) {
                    return localeList2;
                }
                int size = localeList.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(new Locale(localeList.get(i)));
                }
                LocaleList localeList3 = new LocaleList(arrayList);
                this.mSpanFactory = localeList;
                this.mMetadataRepo = localeList3;
                return localeList3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long getCurrentInputPosition() {
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) this.mGlyphChecker;
        if (defaultExtractorInput != null) {
            return defaultExtractorInput.position;
        }
        return -1L;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public Density getDensity() {
        switch (this.$r8$classId) {
            case 4:
                return getLayoutInfo().density;
            default:
                return ((CanvasDrawScope) this.mGlyphChecker).drawParams.density;
        }
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.mMetadataRepo;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : SizeKt.getDrawable((Context) this.mSpanFactory, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        Drawable drawable;
        if (!((TypedArray) this.mMetadataRepo).hasValue(i) || (resourceId = ((TypedArray) this.mMetadataRepo).getResourceId(i, 0)) == 0) {
            return null;
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = (Context) this.mSpanFactory;
        synchronized (appCompatDrawableManager) {
            drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
        }
        return drawable;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long getEventTime(int i) {
        long[] jArr = (long[]) this.mGlyphChecker;
        UtilsKt.checkArgument(i >= 0);
        UtilsKt.checkArgument(i < jArr.length);
        return jArr[i];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return ((long[]) this.mGlyphChecker).length;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getFirstVisibleItemIndex() {
        if (getLayoutInfo().visiblePagesInfo.isEmpty()) {
            return -1;
        }
        long j = ((long) ((MeasuredPage) CollectionsKt.first(getLayoutInfo().visiblePagesInfo)).index) - ((long) getLayoutInfo().beyondViewportPageCount);
        if (j < 0) {
            j = 0;
        }
        return (int) j;
    }

    public Typeface getFont(int i, int i2, TimedValueQueue timedValueQueue) {
        int resourceId = ((TypedArray) this.mMetadataRepo).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        TypedValue typedValue = (TypedValue) this.mGlyphChecker;
        if (typedValue == null) {
            typedValue = new TypedValue();
            this.mGlyphChecker = typedValue;
        }
        TypedValue typedValue2 = typedValue;
        Context context = (Context) this.mSpanFactory;
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, resourceId, typedValue2, i2, timedValueQueue, true);
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public boolean getHasVisibleItems() {
        return !getLayoutInfo().visiblePagesInfo.isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastItemIndex() {
        if (getLayoutInfo().visiblePagesInfo.isEmpty()) {
            return -1;
        }
        return getTotalItemsCount() - 1;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastVisibleItemIndex() {
        if (getLayoutInfo().visiblePagesInfo.isEmpty()) {
            return -1;
        }
        long j = ((long) ((MeasuredPage) CollectionsKt.last(getLayoutInfo().visiblePagesInfo)).index) + ((long) getLayoutInfo().beyondViewportPageCount);
        long totalItemsCount = ((long) getTotalItemsCount()) - 1;
        if (j > totalItemsCount) {
            j = totalItemsCount;
        }
        return (int) j;
    }

    public LayoutDirection getLayoutDirection() {
        return ((CanvasDrawScope) this.mGlyphChecker).drawParams.layoutDirection;
    }

    public PagerMeasureResult getLayoutInfo() {
        PagerMeasureResult pagerMeasureResult = (PagerMeasureResult) this.mMetadataRepo;
        if (pagerMeasureResult != null) {
            return pagerMeasureResult;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        throw null;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisViewportSize() {
        return FileSystemsKt.getMainAxisViewportSize(getLayoutInfo());
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        long[] jArr = (long[]) this.mGlyphChecker;
        int iBinarySearchCeil = Util.binarySearchCeil(jArr, j, false);
        if (iBinarySearchCeil < jArr.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long m831getSizeNHjbRc() {
        return ((CanvasDrawScope) this.mGlyphChecker).drawParams.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getTotalItemsCount() {
        return ((Number) ((PagerState$$ExternalSyntheticLambda2) this.mSpanFactory).invoke()).intValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemIndex(int i) {
        int size = getLayoutInfo().extraPagesBefore.size();
        int size2 = getLayoutInfo().visiblePagesInfo.size();
        if (i < size) {
            return ((MeasuredPage) getLayoutInfo().extraPagesBefore.get(i)).index;
        }
        if (i >= size && i < size + size2) {
            return ((MeasuredPage) getLayoutInfo().visiblePagesInfo.get(i - size)).index;
        }
        if (i >= size + size2) {
            return ((MeasuredPage) getLayoutInfo().extraPagesAfter.get((i - size) - size2)).index;
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public Object getVisibleItemKey(int i) {
        int size = getLayoutInfo().extraPagesBefore.size();
        int size2 = getLayoutInfo().visiblePagesInfo.size();
        if (i < size) {
            return ((MeasuredPage) getLayoutInfo().extraPagesBefore.get(i)).key;
        }
        if (i < size || i >= size + size2) {
            return i >= size + size2 ? ((MeasuredPage) getLayoutInfo().extraPagesAfter.get((i - size) - size2)).key : CachedItem.NoKey;
        }
        return ((MeasuredPage) getLayoutInfo().visiblePagesInfo.get(i - size)).key;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemSize(int i) {
        return getLayoutInfo().pageSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemsCount() {
        return getLayoutInfo().extraPagesAfter.size() + getLayoutInfo().visiblePagesInfo.size() + getLayoutInfo().extraPagesBefore.size();
    }

    public boolean hasGlyph(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 3) == 0) {
            DefaultGlyphChecker defaultGlyphChecker = (DefaultGlyphChecker) this.mGlyphChecker;
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset = metadataItem.__offset(8);
            if (i__offset != 0) {
                ((ByteBuffer) metadataItem.bb).getShort(i__offset + metadataItem.bb_pos);
            }
            defaultGlyphChecker.getClass();
            ThreadLocal threadLocal = DefaultGlyphChecker.sStringBuilder;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            boolean zHasGlyph = defaultGlyphChecker.mTextPaint.hasGlyph(sb.toString());
            int i3 = typefaceEmojiRasterizer.mCache & 4;
            typefaceEmojiRasterizer.mCache = zHasGlyph ? i3 | 2 : i3 | 1;
        }
        return (typefaceEmojiRasterizer.mCache & 3) == 2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public void init(DataSource dataSource, Uri uri, Map map, long j, long j2, ProgressiveMediaPeriod progressiveMediaPeriod) throws UnrecognizedInputFormatException {
        Extractor extractor;
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, j, j2);
        this.mGlyphChecker = defaultExtractorInput;
        if (((Extractor) this.mMetadataRepo) != null) {
            return;
        }
        Extractor[] extractorArrCreateExtractors = ((ExtractorsFactory) this.mSpanFactory).createExtractors(uri, map);
        int length = extractorArrCreateExtractors.length;
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        Maps.checkNonnegative(length, "expectedSize");
        ImmutableList.Builder builder = new ImmutableList.Builder(length);
        boolean z = true;
        if (extractorArrCreateExtractors.length == 1) {
            extractor = extractorArrCreateExtractors[0];
            this.mMetadataRepo = extractor;
        } else {
            for (Extractor extractor2 : extractorArrCreateExtractors) {
                try {
                    if (extractor2.sniff(defaultExtractorInput)) {
                        this.mMetadataRepo = extractor2;
                        defaultExtractorInput.peekBufferPosition = 0;
                        break;
                    }
                    builder.addAll(extractor2.getSniffFailureDetails());
                    boolean z2 = ((Extractor) this.mMetadataRepo) != null || defaultExtractorInput.position == j;
                    UtilsKt.checkState(z2);
                    defaultExtractorInput.peekBufferPosition = 0;
                } catch (EOFException unused) {
                    if (((Extractor) this.mMetadataRepo) != null || defaultExtractorInput.position == j) {
                    }
                } catch (Throwable th) {
                    if (((Extractor) this.mMetadataRepo) == null && defaultExtractorInput.position != j) {
                        z = false;
                    }
                    UtilsKt.checkState(z);
                    defaultExtractorInput.peekBufferPosition = 0;
                    throw th;
                }
                UtilsKt.checkState(z2);
                defaultExtractorInput.peekBufferPosition = 0;
            }
            Extractor extractor3 = (Extractor) this.mMetadataRepo;
            if (extractor3 == null) {
                StringBuilder sb = new StringBuilder("None of the available extractors (");
                Joiner joiner = new Joiner(", ");
                Iterator it = Maps.transform(new Format$$ExternalSyntheticLambda1((byte) 10), ImmutableList.copyOf(extractorArrCreateExtractors)).iterator();
                StringBuilder sb2 = new StringBuilder();
                joiner.appendTo(sb2, it);
                sb.append(sb2.toString());
                sb.append(") could read the stream.");
                String string = sb.toString();
                uri.getClass();
                throw new UnrecognizedInputFormatException(string, builder.build());
            }
            extractor = extractor3;
        }
        extractor.init(progressiveMediaPeriod);
    }

    public boolean isNotEmpty() {
        return !(((SortedSet) ((DrawResult) this.mSpanFactory).block).isEmpty() && ((SortedSet) ((DrawResult) this.mGlyphChecker).block).isEmpty() && ((SortedSet) ((DrawResult) this.mMetadataRepo).block).isEmpty());
    }

    public boolean isStaleResolvedFont() {
        if (((State) this.mSpanFactory).getValue() != this.mGlyphChecker) {
            return true;
        }
        EmojiProcessor emojiProcessor = (EmojiProcessor) this.mMetadataRepo;
        return emojiProcessor != null && emojiProcessor.isStaleResolvedFont();
    }

    public void loadSegmentDownloaderFactory(int i, CacheDataSource.Factory factory) {
        if (i == 0) {
            createSegmentDownloaderFactory(Class.forName("androidx.media3.exoplayer.dash.offline.DashDownloader$Factory").asSubclass(SegmentDownloaderFactory.class), factory);
        } else if (i == 1) {
            createSegmentDownloaderFactory(Class.forName("androidx.media3.exoplayer.smoothstreaming.offline.SsDownloader$Factory").asSubclass(SegmentDownloaderFactory.class), factory);
        } else {
            if (i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unsupported type: "));
                return;
            }
            createSegmentDownloaderFactory(Class.forName("androidx.media3.exoplayer.hls.offline.HlsDownloader$Factory").asSubclass(SegmentDownloaderFactory.class), factory);
        }
        ((SparseArray) this.mGlyphChecker).put(i, null);
    }

    public void postDispatchRunnable(Lifecycle.Event event) {
        DefaultSpecialEffectsController.AnonymousClass6 anonymousClass6 = (DefaultSpecialEffectsController.AnonymousClass6) this.mGlyphChecker;
        if (anonymousClass6 != null) {
            anonymousClass6.run();
        }
        DefaultSpecialEffectsController.AnonymousClass6 anonymousClass7 = new DefaultSpecialEffectsController.AnonymousClass6((LifecycleRegistry) this.mSpanFactory, event);
        this.mGlyphChecker = anonymousClass7;
        ((Handler) this.mMetadataRepo).postAtFrontOfQueue(anonymousClass7);
    }

    public Object process(CharSequence charSequence, int i, int i2, int i3, boolean z, EmojiProcessCallback emojiProcessCallback) {
        int i4;
        char c;
        ProcessorSm processorSm = new ProcessorSm((MetadataRepo$Node) ((Dispatcher) this.mMetadataRepo).runningAsyncCalls);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean zHandleEmoji = true;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (true) {
                if (iCharCount < i2 && i5 < i3 && zHandleEmoji) {
                    MetadataRepo$Node metadataRepo$Node = (MetadataRepo$Node) processorSm.mCurrentNode.mChildren.get(iCodePointAt);
                    if (processorSm.mState == 2) {
                        if (metadataRepo$Node != null) {
                            processorSm.mCurrentNode = metadataRepo$Node;
                            processorSm.mCurrentDepth++;
                        } else {
                            if (iCodePointAt == 65038) {
                                processorSm.reset();
                            } else if (iCodePointAt != 65039) {
                                MetadataRepo$Node metadataRepo$Node2 = processorSm.mCurrentNode;
                                if (metadataRepo$Node2.mData != null) {
                                    if (processorSm.mCurrentDepth != 1) {
                                        processorSm.mFlushNode = metadataRepo$Node2;
                                        processorSm.reset();
                                    } else if (processorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                        processorSm.mFlushNode = processorSm.mCurrentNode;
                                        processorSm.reset();
                                    } else {
                                        processorSm.reset();
                                    }
                                    c = 3;
                                } else {
                                    processorSm.reset();
                                }
                            }
                            c = 1;
                        }
                        c = 2;
                    } else if (metadataRepo$Node == null) {
                        processorSm.reset();
                        c = 1;
                    } else {
                        processorSm.mState = (byte) 2;
                        processorSm.mCurrentNode = metadataRepo$Node;
                        processorSm.mCurrentDepth = 1;
                        c = 2;
                    }
                    processorSm.mLastCodepoint = iCodePointAt;
                    if (c == 1) {
                        iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                        if (iCharCount >= i2) {
                            break;
                        }
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        break;
                    }
                    if (c == 2) {
                        int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                        if (iCharCount2 < i2) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                        }
                        iCharCount = iCharCount2;
                    } else if (c == 3) {
                        if (!z && hasGlyph(charSequence, i4, iCharCount, processorSm.mFlushNode.mData)) {
                            break;
                        }
                        zHandleEmoji = emojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, processorSm.mFlushNode.mData);
                        i5++;
                        break;
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (processorSm.mState == 2 && processorSm.mCurrentNode.mData != null && ((processorSm.mCurrentDepth > 1 || processorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) && i5 < i3 && zHandleEmoji && (z || !hasGlyph(charSequence, i4, iCharCount, processorSm.mCurrentNode.mData)))) {
            emojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, processorSm.mCurrentNode.mData);
        }
        return emojiProcessCallback.getResult();
    }

    public void recycle() {
        ((TypedArray) this.mMetadataRepo).recycle();
    }

    public void releaseInternal(Allocation allocation) {
        PlayerId playerId = (PlayerId) ((HashMap) this.mSpanFactory).remove(allocation);
        playerId.getClass();
        DefaultLoadControl.PlayerLoadingState playerLoadingState = (DefaultLoadControl.PlayerLoadingState) ((DefaultLoadControl) this.mGlyphChecker).loadingStates.get(playerId);
        if (playerLoadingState != null) {
            synchronized (playerLoadingState) {
                playerLoadingState.allocatedCounts--;
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public List schedulePrefetch(int i, Function1 function1) {
        long j = getLayoutInfo().childConstraints;
        LazyLayoutPrefetchState lazyLayoutPrefetchState = (LazyLayoutPrefetchState) this.mGlyphChecker;
        if (lazyLayoutPrefetchState != null) {
            return CollectionsKt__IterablesKt.listOf(lazyLayoutPrefetchState.m177schedulePrecompositionAndPremeasure_EkL_Y$foundation(i, j, true, new BackHandlerKt$$ExternalSyntheticLambda2(function1, this, (byte) 28)));
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        throw null;
    }

    public void set(Object obj) {
        long jCurrentThreadId = Expect_jvmKt.currentThreadId();
        if (jCurrentThreadId == Thread_androidKt.MainThreadId) {
            this.mGlyphChecker = obj;
            return;
        }
        synchronized (this.mMetadataRepo) {
            ThreadMap threadMap = (ThreadMap) ((AtomicReference) this.mSpanFactory).get();
            int iFind = threadMap.find(jCurrentThreadId);
            if (iFind < 0) {
                ((AtomicReference) this.mSpanFactory).set(threadMap.newWith(jCurrentThreadId, obj));
            } else {
                threadMap.values[iFind] = obj;
            }
        }
    }

    public void setCanvas(Canvas canvas) {
        ((CanvasDrawScope) this.mGlyphChecker).drawParams.canvas = canvas;
    }

    public void setDensity(Density density) {
        ((CanvasDrawScope) this.mGlyphChecker).drawParams.density = density;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection) {
        ((CanvasDrawScope) this.mGlyphChecker).drawParams.layoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
    public void m832setSizeuvyYCjk(long j) {
        ((CanvasDrawScope) this.mGlyphChecker).drawParams.size = j;
    }

    public void unregister() {
        MutableScatterMap mutableScatterMap = (MutableScatterMap) this.mSpanFactory;
        String str = (String) this.mMetadataRepo;
        List list = (List) mutableScatterMap.remove(str);
        if (list != null) {
            list.remove((Function0) this.mGlyphChecker);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        mutableScatterMap.set(str, list);
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneFirstVisibleItemIndex(int[] iArr) {
        iArr[0] = getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneLastVisibleItemIndexes(int[] iArr) {
        iArr[0] = getLastVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneMainAxisExtraEndSpace(int[] iArr) {
        if (getLayoutInfo().visiblePagesInfo.isEmpty()) {
            iArr[0] = 0;
        } else {
            iArr[0] = Math.abs(((((MeasuredPage) CollectionsKt.last(getLayoutInfo().visiblePagesInfo)).offset + getLayoutInfo().pageSize) + getLayoutInfo().pageSpacing) - getLayoutInfo().viewportEndOffset);
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneMainAxisExtraStartSpace(int[] iArr) {
        if (getLayoutInfo().visiblePagesInfo.isEmpty()) {
            iArr[0] = 0;
            return;
        }
        int i = ((MeasuredPage) CollectionsKt.first(getLayoutInfo().visiblePagesInfo)).offset + (-getLayoutInfo().viewportStartOffset);
        if (i > 0) {
            i = 0;
        }
        iArr[0] = Math.abs(i);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EmojiProcessLookupCallback implements EmojiProcessCallback {
        public final int mOffset;
        public int start = -1;
        public int end = -1;

        public EmojiProcessLookupCallback(int i) {
            this.mOffset = i;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            int i3 = this.mOffset;
            if (i > i3 || i3 >= i2) {
                return i2 <= i3;
            }
            this.start = i;
            this.end = i2;
            return false;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final Object getResult() {
            return this;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int lastItemIndexInLine(int i) {
        return i;
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.mMetadataRepo = timestampAdjuster;
        trackIdGenerator.generateNewId();
        trackIdGenerator.maybeThrowUninitializedError();
        TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.trackId, 5);
        this.mGlyphChecker = trackOutputTrack;
        trackOutputTrack.format((Format) this.mSpanFactory);
    }

    public /* synthetic */ EmojiProcessor(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.mSpanFactory = obj;
        this.mMetadataRepo = obj2;
        this.mGlyphChecker = obj3;
    }

    public EmojiProcessor(Recomposer$$ExternalSyntheticLambda1 recomposer$$ExternalSyntheticLambda1) {
        this.$r8$classId = (byte) 5;
        this.mSpanFactory = new androidx.compose.runtime.internal.AtomicInt(0);
        this.mMetadataRepo = new ImageLoader$Builder();
        this.mGlyphChecker = new Recomposer$$ExternalSyntheticLambda6((Object) this, (Object) recomposer$$ExternalSyntheticLambda1, (byte) 23);
    }

    public EmojiProcessor(LifecycleService lifecycleService) {
        this.$r8$classId = (byte) 19;
        this.mSpanFactory = new LifecycleRegistry(lifecycleService, true);
        this.mMetadataRepo = new Handler(Looper.getMainLooper());
    }

    public EmojiProcessor(ArrayList arrayList) {
        this.$r8$classId = (byte) 26;
        this.mSpanFactory = Collections.unmodifiableList(new ArrayList(arrayList));
        this.mMetadataRepo = new long[arrayList.size() * 2];
        for (int i = 0; i < arrayList.size(); i++) {
            WebvttCueInfo webvttCueInfo = (WebvttCueInfo) arrayList.get(i);
            int i2 = i * 2;
            long[] jArr = (long[]) this.mMetadataRepo;
            jArr[i2] = webvttCueInfo.startTimeUs;
            jArr[i2 + 1] = webvttCueInfo.endTimeUs;
        }
        long[] jArr2 = (long[]) this.mMetadataRepo;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.mGlyphChecker = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public EmojiProcessor(String str) {
        this.$r8$classId = (byte) 27;
        Format.Builder builder = new Format.Builder();
        builder.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
        builder.sampleMimeType = MimeTypes.normalizeMimeType(str);
        this.mSpanFactory = new Format(builder);
    }

    public EmojiProcessor(View view) {
        this.$r8$classId = (byte) 14;
        this.mSpanFactory = view;
        this.mMetadataRepo = ResultKt.lazy(LazyThreadSafetyMode.NONE, new RoomDatabase$$ExternalSyntheticLambda0((byte) 18, this));
        this.mGlyphChecker = new AtomicInt(view);
    }

    public /* synthetic */ EmojiProcessor(byte b, Object obj) {
        this.$r8$classId = b;
        this.mSpanFactory = obj;
    }

    public EmojiProcessor(Context context, TypedArray typedArray) {
        this.$r8$classId = (byte) 2;
        this.mSpanFactory = context;
        this.mMetadataRepo = typedArray;
    }

    public EmojiProcessor(CacheDataSource.Factory factory, DownloadUtil$$ExternalSyntheticLambda2 downloadUtil$$ExternalSyntheticLambda2) {
        this.$r8$classId = (byte) 24;
        this.mSpanFactory = factory;
        this.mMetadataRepo = downloadUtil$$ExternalSyntheticLambda2;
        this.mGlyphChecker = new SparseArray();
    }

    public EmojiProcessor(CanvasDrawScope canvasDrawScope) {
        this.$r8$classId = (byte) 8;
        this.mGlyphChecker = canvasDrawScope;
        this.mSpanFactory = new DrawResult((byte) 23, (Object) this);
    }

    public EmojiProcessor(Context context, LocationManager locationManager) {
        this.$r8$classId = (byte) 1;
        this.mGlyphChecker = new TwilightManager$TwilightState();
        this.mSpanFactory = context;
        this.mMetadataRepo = locationManager;
    }

    public EmojiProcessor(byte[] bArr, ListenableFuture listenableFuture) {
        this.$r8$classId = (byte) 28;
        this.mSpanFactory = bArr;
        this.mMetadataRepo = null;
        this.mGlyphChecker = listenableFuture;
    }

    public EmojiProcessor(Uri uri, ListenableFuture listenableFuture) {
        this.$r8$classId = (byte) 28;
        this.mSpanFactory = null;
        this.mMetadataRepo = uri;
        this.mGlyphChecker = listenableFuture;
    }

    public EmojiProcessor(MediaMetadata mediaMetadata, ListenableFuture listenableFuture) {
        this.$r8$classId = (byte) 28;
        this.mSpanFactory = mediaMetadata.artworkData;
        this.mMetadataRepo = mediaMetadata.artworkUri;
        this.mGlyphChecker = listenableFuture;
    }

    public EmojiProcessor(Dispatcher dispatcher, Lock lock, DefaultGlyphChecker defaultGlyphChecker, Set set) {
        this.$r8$classId = (byte) 0;
        this.mSpanFactory = lock;
        this.mMetadataRepo = dispatcher;
        this.mGlyphChecker = defaultGlyphChecker;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            process(str, 0, str.length(), 1, true, new Joiner(str, (byte) 1));
        }
    }

    public EmojiProcessor(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
        this.$r8$classId = (byte) 22;
        AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
        this.mSpanFactory = audioProcessorArr2;
        System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
        this.mMetadataRepo = silenceSkippingAudioProcessor;
        this.mGlyphChecker = sonicAudioProcessor;
        audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
        audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
    }

    public EmojiProcessor(TypefaceResult typefaceResult, EmojiProcessor emojiProcessor) {
        this.$r8$classId = (byte) 12;
        this.mSpanFactory = typefaceResult;
        this.mMetadataRepo = emojiProcessor;
        this.mGlyphChecker = typefaceResult.getValue();
    }

    public EmojiProcessor(byte b) {
        this.$r8$classId = b;
        byte b2 = 9;
        switch (b) {
            case 6:
                this.mSpanFactory = new AtomicReference(Expect_jvmKt.emptyThreadMap);
                this.mMetadataRepo = new Object();
                break;
            case 10:
                this.mSpanFactory = new DrawResult((byte) 25);
                this.mMetadataRepo = new DrawResult((byte) 25);
                this.mGlyphChecker = new DrawResult((byte) 25);
                break;
            case 11:
                this.mSpanFactory = new LruCache(8);
                break;
            case 13:
                this.mSpanFactory = new LruCache(16);
                long[] jArr = ScatterMapKt.EmptyGroup;
                this.mMetadataRepo = new MutableScatterMap();
                this.mGlyphChecker = new Lock(b2);
                break;
            case 15:
                this.mGlyphChecker = new Lock(b2);
                break;
            case 16:
                this.mSpanFactory = new WeakHashMap();
                this.mMetadataRepo = new WeakHashMap();
                this.mGlyphChecker = new WeakHashMap();
                break;
            case 18:
                this.mSpanFactory = new MutableScatterMap();
                break;
            case 20:
                break;
            case 23:
                this.mSpanFactory = new Object();
                break;
            default:
                long[] jArr2 = ScatterMapKt.EmptyGroup;
                this.mSpanFactory = new MutableScatterMap();
                break;
        }
    }

    public EmojiProcessor(MediaControllerImplLegacy mediaControllerImplLegacy) {
        this.$r8$classId = (byte) 29;
        this.mGlyphChecker = mediaControllerImplLegacy;
        this.mSpanFactory = new MediaBrowser.ConnectionCallback() { // from class: androidx.media3.session.legacy.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackImpl
            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public final void onConnected() {
                IMediaSession iMediaSession;
                IMediaSession iMediaSession2;
                EmojiProcessor emojiProcessor = this.this$0;
                MediaBrowserCompat.MediaBrowserImplApi26 mediaBrowserImplApi26 = (MediaBrowserCompat.MediaBrowserImplApi26) emojiProcessor.mMetadataRepo;
                byte b = 0;
                if (mediaBrowserImplApi26 != null) {
                    MediaSessionImpl$MediaPlayPauseKeyHandler mediaSessionImpl$MediaPlayPauseKeyHandler = mediaBrowserImplApi26.handler;
                    MediaBrowser mediaBrowser = mediaBrowserImplApi26.browserFwk;
                    try {
                        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(mediaBrowser.getExtras());
                        if (bundleConvertToNullIfInvalid != null) {
                            bundleConvertToNullIfInvalid.getInt("extra_service_version", 0);
                            IBinder binder = bundleConvertToNullIfInvalid.getBinder("extra_messenger");
                            if (binder != null) {
                                CallbackWrapper callbackWrapper = new CallbackWrapper(binder, mediaBrowserImplApi26.rootHints);
                                mediaBrowserImplApi26.serviceBinderWrapper = callbackWrapper;
                                Messenger messenger = new Messenger(mediaSessionImpl$MediaPlayPauseKeyHandler);
                                mediaBrowserImplApi26.callbacksMessenger = messenger;
                                mediaSessionImpl$MediaPlayPauseKeyHandler.getClass();
                                mediaSessionImpl$MediaPlayPauseKeyHandler.this$0 = new WeakReference(messenger);
                                try {
                                    Context context = mediaBrowserImplApi26.context;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("data_package_name", context.getPackageName());
                                    bundle.putInt("data_calling_pid", Process.myPid());
                                    bundle.putBundle("data_root_hints", (Bundle) callbackWrapper.mExecutor);
                                    callbackWrapper.sendRequest(6, bundle, messenger);
                                } catch (RemoteException unused) {
                                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                                }
                            }
                            IBinder binder2 = bundleConvertToNullIfInvalid.getBinder("extra_session_binder");
                            int i = MediaSessionCompat$MediaSessionImplApi23.ExtraSession.$r8$clinit;
                            if (binder2 == null) {
                                iMediaSession2 = null;
                            } else {
                                IInterface iInterfaceQueryLocalInterface = binder2.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) {
                                    IMediaSession$Stub$Proxy iMediaSession$Stub$Proxy = new IMediaSession$Stub$Proxy();
                                    iMediaSession$Stub$Proxy.remote = binder2;
                                    iMediaSession2 = iMediaSession$Stub$Proxy;
                                } else {
                                    iMediaSession = (IMediaSession) iInterfaceQueryLocalInterface;
                                }
                            }
                            if (iMediaSession2 != null) {
                                iMediaSession2 = iMediaSession;
                                mediaBrowserImplApi26.mediaSessionToken = new MediaSessionCompat$Token(mediaBrowser.getSessionToken(), iMediaSession2);
                            }
                        }
                    } catch (IllegalStateException e) {
                        Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
                    }
                }
                iMediaSession2 = iMediaSession;
                MediaControllerImplLegacy mediaControllerImplLegacy2 = (MediaControllerImplLegacy) emojiProcessor.mGlyphChecker;
                MediaBrowserCompat mediaBrowserCompat = mediaControllerImplLegacy2.browserCompat;
                if (mediaBrowserCompat != null) {
                    MediaBrowserCompat.MediaBrowserImplApi26 mediaBrowserImplApi27 = (MediaBrowserCompat.MediaBrowserImplApi26) mediaBrowserCompat.impl;
                    MediaSessionCompat$Token mediaSessionCompat$Token = mediaBrowserImplApi27.mediaSessionToken;
                    if (mediaSessionCompat$Token == null) {
                        MediaSessionCompat$Token mediaSessionCompat$Token2 = new MediaSessionCompat$Token(mediaBrowserImplApi27.browserFwk.getSessionToken(), null);
                        mediaBrowserImplApi27.mediaSessionToken = mediaSessionCompat$Token2;
                        mediaSessionCompat$Token = mediaSessionCompat$Token2;
                    }
                    MediaController mediaController = mediaControllerImplLegacy2.instance;
                    mediaController.runOnApplicationLooper(new TransactionExecutor$$ExternalSyntheticLambda0((Object) mediaControllerImplLegacy2, (Object) mediaSessionCompat$Token, (byte) 4));
                    mediaController.applicationHandler.postDelayed(new MediaControllerImplLegacy$$ExternalSyntheticLambda1(mediaControllerImplLegacy2, b), 500L);
                }
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public final void onConnectionFailed() {
                ((MediaControllerImplLegacy) this.this$0.mGlyphChecker).instance.release();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public final void onConnectionSuspended() {
                EmojiProcessor emojiProcessor = this.this$0;
                MediaBrowserCompat.MediaBrowserImplApi26 mediaBrowserImplApi26 = (MediaBrowserCompat.MediaBrowserImplApi26) emojiProcessor.mMetadataRepo;
                if (mediaBrowserImplApi26 != null) {
                    mediaBrowserImplApi26.serviceBinderWrapper = null;
                    mediaBrowserImplApi26.callbacksMessenger = null;
                    mediaBrowserImplApi26.mediaSessionToken = null;
                    MediaSessionImpl$MediaPlayPauseKeyHandler mediaSessionImpl$MediaPlayPauseKeyHandler = mediaBrowserImplApi26.handler;
                    mediaSessionImpl$MediaPlayPauseKeyHandler.getClass();
                    mediaSessionImpl$MediaPlayPauseKeyHandler.this$0 = new WeakReference(null);
                }
                ((MediaControllerImplLegacy) emojiProcessor.mGlyphChecker).instance.release();
            }
        };
    }

    public EmojiProcessor(DefaultLoadControl defaultLoadControl, PlayerId playerId) {
        this.$r8$classId = (byte) 21;
        this.mGlyphChecker = defaultLoadControl;
        this.mSpanFactory = new HashMap();
        this.mMetadataRepo = playerId;
    }
}
