package com.metrolist.music.lyrics;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import coil3.ImageLoader$Builder;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.extensions.ContextExtKt$isSyncEnabled$1;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import dagger.hilt.EntryPoints;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsHelper$getAllLyrics$3 extends SuspendLambda implements Function2 {
    public Serializable $album;
    public final /* synthetic */ Object $allResult;
    public Object $cacheKey;
    public final /* synthetic */ Object $callback;
    public int $duration;
    public Object $mediaId;
    public final /* synthetic */ byte $r8$classId = 1;
    public Object $songArtists;
    public String $songTitle;
    public /* synthetic */ Object L$0;
    public String L$1;
    public Object L$5;
    public Object L$6;
    public Object L$9;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsHelper$getAllLyrics$3$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $album;
        public final /* synthetic */ ArrayList $allResult;
        public final /* synthetic */ MimesKt$$ExternalSyntheticLambda0 $callback;
        public final /* synthetic */ Object $callbackMutex;
        public final /* synthetic */ String $cleanedTitle;
        public final /* synthetic */ int $duration;
        public final /* synthetic */ LyricsProvider $lyricsPlusProvider;
        public final /* synthetic */ String $mediaId;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ String $songArtists;
        public boolean label;
        public final /* synthetic */ ImageLoader$Builder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(LyricsProvider lyricsProvider, ImageLoader$Builder imageLoader$Builder, String str, String str2, String str3, int i, String str4, Object obj, ArrayList arrayList, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$lyricsPlusProvider = lyricsProvider;
            this.this$0 = imageLoader$Builder;
            this.$mediaId = str;
            this.$cleanedTitle = str2;
            this.$songArtists = str3;
            this.$duration = i;
            this.$album = str4;
            this.$callbackMutex = obj;
            this.$allResult = arrayList;
            this.$callback = mimesKt$$ExternalSyntheticLambda0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass2(this.$lyricsPlusProvider, this.this$0, this.$mediaId, this.$cleanedTitle, this.$songArtists, this.$duration, this.$album, this.$callbackMutex, this.$allResult, this.$callback, continuation, (byte) 0);
                default:
                    return new AnonymousClass2(this.$lyricsPlusProvider, this.this$0, this.$mediaId, this.$cleanedTitle, this.$songArtists, this.$duration, this.$album, this.$callbackMutex, this.$allResult, this.$callback, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = Unit.INSTANCE;
            ImageLoader$Builder imageLoader$Builder = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    try {
                        if (!z) {
                            ResultKt.throwOnFailure(obj);
                            final LyricsProvider lyricsProvider = this.$lyricsPlusProvider;
                            Context context = (Context) imageLoader$Builder.application;
                            String str = this.$mediaId;
                            String str2 = this.$cleanedTitle;
                            String str3 = this.$songArtists;
                            int i = this.$duration;
                            String str4 = this.$album;
                            final Object obj3 = this.$callbackMutex;
                            final ArrayList arrayList = this.$allResult;
                            final MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = this.$callback;
                            final byte b2 = 0;
                            Function1 function1 = new Function1() { // from class: com.metrolist.music.lyrics.LyricsHelper$getAllLyrics$3$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj4) {
                                    switch (b2) {
                                        case 0:
                                            LyricsProvider lyricsProvider2 = lyricsProvider;
                                            Object obj5 = obj3;
                                            ArrayList arrayList2 = arrayList;
                                            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
                                            LyricsUtils lyricsUtils = LyricsUtils.INSTANCE;
                                            LyricsResult lyricsResult = new LyricsResult(lyricsProvider2.getName(), LyricsUtils.filterLyricsCreditLines((String) obj4));
                                            synchronized (obj5) {
                                                arrayList2.add(lyricsResult);
                                                mimesKt$$ExternalSyntheticLambda1.invoke(lyricsResult);
                                            }
                                            return Unit.INSTANCE;
                                        default:
                                            LyricsProvider lyricsProvider3 = lyricsProvider;
                                            Object obj6 = obj3;
                                            ArrayList arrayList3 = arrayList;
                                            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda2 = mimesKt$$ExternalSyntheticLambda0;
                                            LyricsUtils lyricsUtils2 = LyricsUtils.INSTANCE;
                                            LyricsResult lyricsResult2 = new LyricsResult(lyricsProvider3.getName(), LyricsUtils.filterLyricsCreditLines((String) obj4));
                                            synchronized (obj6) {
                                                arrayList3.add(lyricsResult2);
                                                mimesKt$$ExternalSyntheticLambda2.invoke(lyricsResult2);
                                            }
                                            return Unit.INSTANCE;
                                    }
                                }
                            };
                            this.label = true;
                            if (lyricsProvider.getAllLyrics(context, str, str2, str3, i, str4, function1, this) == coroutineSingletons) {
                                obj2 = coroutineSingletons;
                            }
                        } else {
                            if (!z) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj2;
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return obj2;
                    }
                default:
                    boolean z2 = this.label;
                    try {
                        if (!z2) {
                            ResultKt.throwOnFailure(obj);
                            final LyricsProvider lyricsProvider2 = this.$lyricsPlusProvider;
                            Context context2 = (Context) imageLoader$Builder.application;
                            String str5 = this.$mediaId;
                            String str6 = this.$cleanedTitle;
                            String str7 = this.$songArtists;
                            int i2 = this.$duration;
                            String str8 = this.$album;
                            final Object obj4 = this.$callbackMutex;
                            final ArrayList arrayList2 = this.$allResult;
                            final MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = this.$callback;
                            final byte b3 = 1;
                            Function1 function2 = new Function1() { // from class: com.metrolist.music.lyrics.LyricsHelper$getAllLyrics$3$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj5) {
                                    switch (b3) {
                                        case 0:
                                            LyricsProvider lyricsProvider3 = lyricsProvider2;
                                            Object obj6 = obj4;
                                            ArrayList arrayList3 = arrayList2;
                                            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda2 = mimesKt$$ExternalSyntheticLambda1;
                                            LyricsUtils lyricsUtils = LyricsUtils.INSTANCE;
                                            LyricsResult lyricsResult = new LyricsResult(lyricsProvider3.getName(), LyricsUtils.filterLyricsCreditLines((String) obj5));
                                            synchronized (obj6) {
                                                arrayList3.add(lyricsResult);
                                                mimesKt$$ExternalSyntheticLambda2.invoke(lyricsResult);
                                            }
                                            return Unit.INSTANCE;
                                        default:
                                            LyricsProvider lyricsProvider4 = lyricsProvider2;
                                            Object obj7 = obj4;
                                            ArrayList arrayList4 = arrayList2;
                                            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda3 = mimesKt$$ExternalSyntheticLambda1;
                                            LyricsUtils lyricsUtils2 = LyricsUtils.INSTANCE;
                                            LyricsResult lyricsResult2 = new LyricsResult(lyricsProvider4.getName(), LyricsUtils.filterLyricsCreditLines((String) obj5));
                                            synchronized (obj7) {
                                                arrayList4.add(lyricsResult2);
                                                mimesKt$$ExternalSyntheticLambda3.invoke(lyricsResult2);
                                            }
                                            return Unit.INSTANCE;
                                    }
                                }
                            };
                            this.label = true;
                            if (lyricsProvider2.getAllLyrics(context2, str5, str6, str7, i2, str8, function2, this) == coroutineSingletons) {
                                obj2 = coroutineSingletons;
                            }
                        } else {
                            if (!z2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return obj2;
                    } catch (CancellationException e3) {
                        throw e3;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return obj2;
                    }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsHelper$getAllLyrics$3(String str, ImageLoader$Builder imageLoader$Builder, ArrayList arrayList, String str2, String str3, String str4, int i, String str5, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, Continuation continuation) {
        super(2, continuation);
        this.$songTitle = str;
        this.this$0 = imageLoader$Builder;
        this.$allResult = arrayList;
        this.$cacheKey = str2;
        this.$mediaId = str3;
        this.$songArtists = str4;
        this.$duration = i;
        this.$album = str5;
        this.$callback = mimesKt$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0187  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v6, types: [java.lang.Object, java.lang.String, java.lang.Throwable, kotlin.coroutines.CoroutineContext, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01a2 -> B:43:0x01a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private final java.lang.Object invokeSuspend$com$metrolist$music$lyrics$LyricsHelper$getAllLyrics$3(java.lang.Object r32) {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.lyrics.LyricsHelper$getAllLyrics$3.invokeSuspend$com$metrolist$music$lyrics$LyricsHelper$getAllLyrics$3(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$callback;
        Object obj3 = this.$allResult;
        Object obj4 = this.this$0;
        switch (b) {
            case 0:
                LyricsHelper$getAllLyrics$3 lyricsHelper$getAllLyrics$3 = new LyricsHelper$getAllLyrics$3(this.$songTitle, (ImageLoader$Builder) obj4, (ArrayList) obj3, (String) this.$cacheKey, (String) this.$mediaId, (String) this.$songArtists, this.$duration, (String) this.$album, (MimesKt$$ExternalSyntheticLambda0) obj2, continuation);
                lyricsHelper$getAllLyrics$3.L$0 = obj;
                return lyricsHelper$getAllLyrics$3;
            default:
                LyricsHelper$getAllLyrics$3 lyricsHelper$getAllLyrics$4 = new LyricsHelper$getAllLyrics$3((Context) obj4, (Uri) obj3, (BackupRestoreViewModel) obj2, continuation);
                lyricsHelper$getAllLyrics$4.L$0 = obj;
                return lyricsHelper$getAllLyrics$4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((LyricsHelper$getAllLyrics$3) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x037f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0382  */
    /* JADX WARN: Code duplicated, block: B:143:0x03ae A[Catch: all -> 0x03e1, TryCatch #1 {all -> 0x03e1, blocks: (B:124:0x0371, B:125:0x0374, B:143:0x03ae, B:148:0x03e3, B:150:0x03f9, B:156:0x043d, B:158:0x0453, B:160:0x0464, B:130:0x0384, B:132:0x038c, B:138:0x0395, B:139:0x0398, B:141:0x039a), top: B:256:0x0371 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x03df  */
    /* JADX WARN: Code duplicated, block: B:148:0x03e3 A[Catch: all -> 0x03e1, TryCatch #1 {all -> 0x03e1, blocks: (B:124:0x0371, B:125:0x0374, B:143:0x03ae, B:148:0x03e3, B:150:0x03f9, B:156:0x043d, B:158:0x0453, B:160:0x0464, B:130:0x0384, B:132:0x038c, B:138:0x0395, B:139:0x0398, B:141:0x039a), top: B:256:0x0371 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x03f9 A[Catch: all -> 0x03e1, TRY_LEAVE, TryCatch #1 {all -> 0x03e1, blocks: (B:124:0x0371, B:125:0x0374, B:143:0x03ae, B:148:0x03e3, B:150:0x03f9, B:156:0x043d, B:158:0x0453, B:160:0x0464, B:130:0x0384, B:132:0x038c, B:138:0x0395, B:139:0x0398, B:141:0x039a), top: B:256:0x0371 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x042f  */
    /* JADX WARN: Code duplicated, block: B:163:0x046c  */
    /* JADX WARN: Code duplicated, block: B:174:0x04e4 A[Catch: all -> 0x052b, Exception -> 0x052e, TryCatch #3 {Exception -> 0x052e, blocks: (B:172:0x049f, B:174:0x04e4, B:176:0x04ea), top: B:259:0x049f }] */
    /* JADX WARN: Code duplicated, block: B:176:0x04ea A[Catch: all -> 0x052b, Exception -> 0x052e, TRY_LEAVE, TryCatch #3 {Exception -> 0x052e, blocks: (B:172:0x049f, B:174:0x04e4, B:176:0x04ea), top: B:259:0x049f }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0533 A[Catch: all -> 0x0520, Exception -> 0x054e, TryCatch #0 {all -> 0x0520, blocks: (B:180:0x0512, B:197:0x0564, B:199:0x0568, B:200:0x0576, B:202:0x05ae, B:203:0x05b0, B:205:0x05c1, B:207:0x05c9, B:208:0x05d5, B:193:0x054e, B:189:0x0533, B:190:0x0541, B:191:0x0542, B:192:0x054d), top: B:255:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0542 A[Catch: all -> 0x0520, Exception -> 0x054e, TryCatch #0 {all -> 0x0520, blocks: (B:180:0x0512, B:197:0x0564, B:199:0x0568, B:200:0x0576, B:202:0x05ae, B:203:0x05b0, B:205:0x05c1, B:207:0x05c9, B:208:0x05d5, B:193:0x054e, B:189:0x0533, B:190:0x0541, B:191:0x0542, B:192:0x054d), top: B:255:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:194:0x055c  */
    /* JADX WARN: Code duplicated, block: B:197:0x0564 A[Catch: all -> 0x0520, TryCatch #0 {all -> 0x0520, blocks: (B:180:0x0512, B:197:0x0564, B:199:0x0568, B:200:0x0576, B:202:0x05ae, B:203:0x05b0, B:205:0x05c1, B:207:0x05c9, B:208:0x05d5, B:193:0x054e, B:189:0x0533, B:190:0x0541, B:191:0x0542, B:192:0x054d), top: B:255:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:199:0x0568 A[Catch: all -> 0x0520, TryCatch #0 {all -> 0x0520, blocks: (B:180:0x0512, B:197:0x0564, B:199:0x0568, B:200:0x0576, B:202:0x05ae, B:203:0x05b0, B:205:0x05c1, B:207:0x05c9, B:208:0x05d5, B:193:0x054e, B:189:0x0533, B:190:0x0541, B:191:0x0542, B:192:0x054d), top: B:255:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:202:0x05ae A[Catch: all -> 0x0520, TryCatch #0 {all -> 0x0520, blocks: (B:180:0x0512, B:197:0x0564, B:199:0x0568, B:200:0x0576, B:202:0x05ae, B:203:0x05b0, B:205:0x05c1, B:207:0x05c9, B:208:0x05d5, B:193:0x054e, B:189:0x0533, B:190:0x0541, B:191:0x0542, B:192:0x054d), top: B:255:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:205:0x05c1 A[Catch: all -> 0x0520, TryCatch #0 {all -> 0x0520, blocks: (B:180:0x0512, B:197:0x0564, B:199:0x0568, B:200:0x0576, B:202:0x05ae, B:203:0x05b0, B:205:0x05c1, B:207:0x05c9, B:208:0x05d5, B:193:0x054e, B:189:0x0533, B:190:0x0541, B:191:0x0542, B:192:0x054d), top: B:255:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:206:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:208:0x05d5 A[Catch: all -> 0x0520, TRY_LEAVE, TryCatch #0 {all -> 0x0520, blocks: (B:180:0x0512, B:197:0x0564, B:199:0x0568, B:200:0x0576, B:202:0x05ae, B:203:0x05b0, B:205:0x05c1, B:207:0x05c9, B:208:0x05d5, B:193:0x054e, B:189:0x0533, B:190:0x0541, B:191:0x0542, B:192:0x054d), top: B:255:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:243:0x065d  */
    /* JADX WARN: Code duplicated, block: B:246:0x0696  */
    /* JADX WARN: Code duplicated, block: B:256:0x0371 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x049f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x023c A[FALL_THROUGH] */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x035e, code lost:
    
        if (kotlinx.coroutines.AwaitKt.withContext(r0, r2, r26) == r4) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0429, code lost:
    
        if (kotlinx.coroutines.AwaitKt.withContext(r0, r2, r26) == r4) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x05fe, code lost:
    
        if (kotlinx.coroutines.AwaitKt.withContext(r6, r8, r26) == r4) goto L245;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v37, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v40, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v41 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v49 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v50 */
    /* JADX WARN: Type inference failed for: r13v51 */
    /* JADX WARN: Type inference failed for: r13v52 */
    /* JADX WARN: Type inference failed for: r13v53 */
    /* JADX WARN: Type inference failed for: r13v54 */
    /* JADX WARN: Type inference failed for: r13v55 */
    /* JADX WARN: Type inference failed for: r13v56 */
    /* JADX WARN: Type inference failed for: r13v57 */
    /* JADX WARN: Type inference failed for: r13v58 */
    /* JADX WARN: Type inference failed for: r13v59 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v62 */
    /* JADX WARN: Type inference failed for: r13v63 */
    /* JADX WARN: Type inference failed for: r13v64 */
    /* JADX WARN: Type inference failed for: r13v65, types: [kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r13v66 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r14v18, types: [java.io.Serializable, java.lang.Object, kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v34, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v46 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v53 */
    /* JADX WARN: Type inference failed for: r14v54 */
    /* JADX WARN: Type inference failed for: r14v55 */
    /* JADX WARN: Type inference failed for: r14v58 */
    /* JADX WARN: Type inference failed for: r14v59 */
    /* JADX WARN: Type inference failed for: r14v60 */
    /* JADX WARN: Type inference failed for: r14v61 */
    /* JADX WARN: Type inference failed for: r14v62 */
    /* JADX WARN: Type inference failed for: r14v66 */
    /* JADX WARN: Type inference failed for: r14v67 */
    /* JADX WARN: Type inference failed for: r14v68 */
    /* JADX WARN: Type inference failed for: r14v69 */
    /* JADX WARN: Type inference failed for: r14v70 */
    /* JADX WARN: Type inference failed for: r14v71 */
    /* JADX WARN: Type inference failed for: r14v72 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARN: Type inference failed for: r24v11 */
    /* JADX WARN: Type inference failed for: r24v12 */
    /* JADX WARN: Type inference failed for: r24v13 */
    /* JADX WARN: Type inference failed for: r24v14 */
    /* JADX WARN: Type inference failed for: r24v15 */
    /* JADX WARN: Type inference failed for: r24v16 */
    /* JADX WARN: Type inference failed for: r24v17 */
    /* JADX WARN: Type inference failed for: r24v18 */
    /* JADX WARN: Type inference failed for: r24v19 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v20 */
    /* JADX WARN: Type inference failed for: r24v21 */
    /* JADX WARN: Type inference failed for: r24v22 */
    /* JADX WARN: Type inference failed for: r24v23 */
    /* JADX WARN: Type inference failed for: r24v24 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v63 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r4v66 */
    /* JADX WARN: Type inference failed for: r4v67 */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r4v72 */
    /* JADX WARN: Type inference failed for: r4v73 */
    /* JADX WARN: Type inference failed for: r4v74 */
    /* JADX WARN: Type inference failed for: r4v75 */
    /* JADX WARN: Type inference failed for: r4v76 */
    /* JADX WARN: Type inference failed for: r4v77 */
    /* JADX WARN: Type inference failed for: r4v78 */
    /* JADX WARN: Type inference failed for: r4v79 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v80 */
    /* JADX WARN: Type inference failed for: r4v81 */
    /* JADX WARN: Type inference failed for: r4v82 */
    /* JADX WARN: Type inference failed for: r4v83 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v28, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.lang.StringBuilder] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws IOException {
        ?? r5;
        Unit unit;
        Object obj2;
        ?? r4;
        ?? r13;
        ?? r14;
        ?? r6;
        Object obj3;
        Object objCreateFailure;
        ?? r7;
        ?? r15;
        ?? r16;
        ?? r8;
        ?? r9;
        Object obj4;
        Throwable thM1866exceptionOrNullimpl;
        HandlerContext handlerContext;
        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$1;
        Object obj5;
        ?? r1;
        ?? r17;
        ?? r18;
        ?? r10;
        ?? r2;
        ?? r19;
        ?? r110;
        String str;
        ?? r111;
        ?? r112;
        ?? r11;
        Ref$BooleanRef ref$BooleanRef;
        String str2;
        Ref$ObjectRef ref$ObjectRef;
        ?? r12;
        String str3;
        Throwable th;
        Throwable th2;
        String str4;
        ?? r24;
        ZipEntry nextEntry;
        String str5;
        ?? r20;
        File file;
        ?? r21;
        int i;
        int i2;
        BackupRestoreViewModel backupRestoreViewModel;
        HandlerContext handlerContext2;
        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$2;
        SQLiteDatabase sQLiteDatabaseOpenDatabase;
        int i3;
        String str6;
        File file2;
        ?? r113;
        Context context;
        String str7;
        DiscordRpcManager.C01441 c01441;
        ?? r114;
        ?? r115;
        BackupRestoreViewModel backupRestoreViewModel2;
        File file3;
        Context context2;
        ?? r25;
        BackupRestoreViewModel backupRestoreViewModel3;
        ?? r26;
        ?? r27;
        String str8;
        ?? r116;
        String str9;
        ?? r22;
        File file4;
        String str10;
        String str11;
        ?? r23;
        ?? r117;
        ?? r118;
        String str12;
        ?? RenameTo;
        boolean z;
        File file5;
        File file6;
        File file7;
        String str13;
        ?? r119;
        Map map;
        Intent launchIntentForPackage;
        String str14;
        ?? r120;
        String str15;
        String str16;
        ?? r28;
        String str17;
        ?? r121;
        String str18;
        ?? r29;
        File file8;
        switch (this.$r8$classId) {
            case 0:
                return invokeSuspend$com$metrolist$music$lyrics$LyricsHelper$getAllLyrics$3(obj);
            default:
                String str19 = "datastore/settings.preferences_pb";
                Context context3 = (Context) this.this$0;
                ?? r30 = (CoroutineScope) this.L$0;
                byte b = this.label;
                String str20 = "-shm";
                String str21 = "-wal";
                Unit unit2 = Unit.INSTANCE;
                ?? r122 = CoroutineSingletons.COROUTINE_SUSPENDED;
                try {
                    switch (b) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            String absolutePath = context3.getDatabasePath("restored_song.db").getAbsolutePath();
                            File file9 = new File(context3.getFilesDir(), "datastore/settings.preferences_pb.restore");
                            Uri uri = (Uri) this.$allResult;
                            BackupRestoreViewModel backupRestoreViewModel4 = (BackupRestoreViewModel) this.$callback;
                            try {
                                ConnectionPool connectionPool = Timber.Forest;
                                connectionPool.tag("RESTORE");
                                uri.toString();
                                unit = unit2;
                                try {
                                    ConnectionPool.i(new Object[0]);
                                    try {
                                        String path = backupRestoreViewModel4.database.delegate.getOpenHelper().getWritableDatabase().getPath();
                                        if (path == null) {
                                            try {
                                                connectionPool.tag("RESTORE");
                                                ConnectionPool.e(new Object[0]);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                obj2 = file9;
                                                r5 = absolutePath;
                                                r4 = r122;
                                                r13 = "-wal";
                                                obj3 = obj2;
                                                r6 = r5;
                                                r14 = str20;
                                                objCreateFailure = ResultKt.createFailure(th);
                                                obj4 = obj3;
                                                r9 = r4;
                                                r8 = r6;
                                                r16 = r13;
                                                r15 = r14;
                                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                r2 = obj4;
                                                r10 = r8;
                                                r18 = r16;
                                                r17 = r15;
                                                if (thM1866exceptionOrNullimpl != null) {
                                                    UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                    Timber.Forest.tag("RESTORE");
                                                    ConnectionPool.e$1(new Object[0]);
                                                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                                                    handlerContext = MainDispatcherLoader.dispatcher;
                                                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                    this.L$0 = null;
                                                    this.L$1 = r8;
                                                    this.$cacheKey = obj4;
                                                    this.L$6 = objCreateFailure;
                                                    this.$mediaId = null;
                                                    this.$songArtists = null;
                                                    this.$songTitle = null;
                                                    this.$album = null;
                                                    this.L$5 = null;
                                                    this.L$9 = null;
                                                    this.label = (byte) 7;
                                                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                        r7 = r9;
                                                        obj5 = obj4;
                                                        r1 = r8;
                                                        r110 = r16;
                                                        r19 = r15;
                                                        r2 = obj5;
                                                        r10 = r1;
                                                        r18 = r110;
                                                        r17 = r19;
                                                    }
                                                    r7 = r21;
                                                    file8 = file4;
                                                    r29 = r22;
                                                    str18 = str9;
                                                    r121 = r119;
                                                    str17 = str13;
                                                    r7 = r22;
                                                    r7 = r9;
                                                    return r7;
                                                }
                                                new File((String) r10).delete();
                                                ?? sb = new StringBuilder();
                                                sb.append(r10);
                                                sb.append(r18);
                                                new File(sb.toString()).delete();
                                                ?? sb2 = new StringBuilder();
                                                sb2.append(r10);
                                                sb2.append(r17);
                                                new File(sb2.toString()).delete();
                                                r2.delete();
                                            }
                                            break;
                                        } else {
                                            new File(absolutePath).delete();
                                            new File(absolutePath + "-wal").delete();
                                            new File(absolutePath + "-shm").delete();
                                            file9.delete();
                                            ?? ref$BooleanRef2 = new Ref$BooleanRef();
                                            ref$BooleanRef = new Ref$BooleanRef();
                                            str2 = "datastore/settings.preferences_pb";
                                            ref$ObjectRef = new Ref$ObjectRef();
                                            String str22 = "-shm";
                                            try {
                                                InputStream inputStreamOpenInputStream = context3.getApplicationContext().getContentResolver().openInputStream(uri);
                                                try {
                                                    if (inputStreamOpenInputStream != null) {
                                                        try {
                                                            ZipInputStream zipInputStream = new ZipInputStream(inputStreamOpenInputStream);
                                                            try {
                                                                nextEntry = zipInputStream.getNextEntry();
                                                                break;
                                                            } catch (Exception unused) {
                                                                nextEntry = null;
                                                            } catch (Throwable th4) {
                                                                th2 = th4;
                                                                str4 = "-wal";
                                                                r24 = r122;
                                                                try {
                                                                    throw th2;
                                                                } catch (Throwable th5) {
                                                                    try {
                                                                        CharsKt.closeFinally(zipInputStream, th2);
                                                                        throw th5;
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                        ref$BooleanRef2 = str22;
                                                                        r122 = str4;
                                                                        r30 = r24;
                                                                        try {
                                                                            throw th;
                                                                        } catch (Throwable th7) {
                                                                            CharsKt.closeFinally(inputStreamOpenInputStream, th);
                                                                            throw th7;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            while (nextEntry != null) {
                                                                str4 = str21;
                                                                try {
                                                                    ConnectionPool connectionPool2 = Timber.Forest;
                                                                    connectionPool2.tag("RESTORE");
                                                                    nextEntry.getName();
                                                                    ?? r210 = r30;
                                                                    String str23 = path;
                                                                    ConnectionPool.i(new Object[0]);
                                                                    String name = nextEntry.getName();
                                                                    if (name != null) {
                                                                        switch (name.hashCode()) {
                                                                            case -2129424926:
                                                                                backupRestoreViewModel3 = backupRestoreViewModel4;
                                                                                ?? r211 = r122;
                                                                                r27 = r211;
                                                                                r26 = r211;
                                                                                if (!name.equals("song.db-shm")) {
                                                                                    connectionPool2.tag("RESTORE");
                                                                                    nextEntry.getName();
                                                                                    ConnectionPool.i(new Object[0]);
                                                                                    r27 = r26;
                                                                                }
                                                                                break;
                                                                            case -2129421300:
                                                                                backupRestoreViewModel3 = backupRestoreViewModel4;
                                                                                ?? r212 = r122;
                                                                                r27 = r212;
                                                                                if (!name.equals("song.db-wal")) {
                                                                                    r26 = r212;
                                                                                    connectionPool2.tag("RESTORE");
                                                                                    nextEntry.getName();
                                                                                    ConnectionPool.i(new Object[0]);
                                                                                    r27 = r26;
                                                                                }
                                                                                break;
                                                                            case -2028720137:
                                                                                backupRestoreViewModel3 = backupRestoreViewModel4;
                                                                                r25 = r122;
                                                                                if (!name.equals("song.db")) {
                                                                                    r26 = r25;
                                                                                    connectionPool2.tag("RESTORE");
                                                                                    nextEntry.getName();
                                                                                    ConnectionPool.i(new Object[0]);
                                                                                    r27 = r26;
                                                                                    break;
                                                                                } else {
                                                                                    ref$BooleanRef2.element = true;
                                                                                    FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                                                                                    try {
                                                                                        Boxing.boxLong(EntryPoints.copyTo(zipInputStream, fileOutputStream));
                                                                                        CharsKt.closeFinally(fileOutputStream, null);
                                                                                        r27 = r25;
                                                                                        break;
                                                                                    } catch (Throwable th8) {
                                                                                        try {
                                                                                            throw th8;
                                                                                        } catch (Throwable th9) {
                                                                                            CharsKt.closeFinally(fileOutputStream, th8);
                                                                                            throw th9;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 34521540:
                                                                                backupRestoreViewModel3 = backupRestoreViewModel4;
                                                                                r25 = r122;
                                                                                if (!name.equals("settings.preferences_pb")) {
                                                                                    r26 = r25;
                                                                                    connectionPool2.tag("RESTORE");
                                                                                    nextEntry.getName();
                                                                                    ConnectionPool.i(new Object[0]);
                                                                                    r27 = r26;
                                                                                    break;
                                                                                } else {
                                                                                    ref$BooleanRef.element = true;
                                                                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file9);
                                                                                    try {
                                                                                        fileOutputStream2.write(EntryPoints.readBytes(zipInputStream));
                                                                                        CharsKt.closeFinally(fileOutputStream2, null);
                                                                                        r27 = r25;
                                                                                        break;
                                                                                    } catch (Throwable th10) {
                                                                                        try {
                                                                                            throw th10;
                                                                                        } catch (Throwable th11) {
                                                                                            CharsKt.closeFinally(fileOutputStream2, th10);
                                                                                            throw th11;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 1151882260:
                                                                                if (name.equals("artist_name_aliases.json")) {
                                                                                    ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                                                                                    String strDecodeToString = StringsKt__StringsJVMKt.decodeToString(EntryPoints.readBytes(zipInputStream));
                                                                                    Json.Default r31 = Json.Default;
                                                                                    r31.getClass();
                                                                                    backupRestoreViewModel3 = backupRestoreViewModel4;
                                                                                    StringSerializer stringSerializer = StringSerializer.INSTANCE;
                                                                                    r25 = r122;
                                                                                    try {
                                                                                        ref$ObjectRef.element = (Map) r31.decodeFromString(new HashMapSerializer(stringSerializer, stringSerializer, (byte) 1), strDecodeToString);
                                                                                        r27 = r25;
                                                                                    } catch (Throwable th12) {
                                                                                        th = th12;
                                                                                        th2 = th;
                                                                                        r24 = r25;
                                                                                        throw th2;
                                                                                    }
                                                                                    break;
                                                                                } else {
                                                                                    break;
                                                                                }
                                                                            default:
                                                                                backupRestoreViewModel3 = backupRestoreViewModel4;
                                                                                r26 = r122;
                                                                                connectionPool2.tag("RESTORE");
                                                                                nextEntry.getName();
                                                                                ConnectionPool.i(new Object[0]);
                                                                                r27 = r26;
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        backupRestoreViewModel3 = backupRestoreViewModel4;
                                                                        r26 = r122;
                                                                        connectionPool2.tag("RESTORE");
                                                                        nextEntry.getName();
                                                                        ConnectionPool.i(new Object[0]);
                                                                        r27 = r26;
                                                                    }
                                                                    try {
                                                                        nextEntry = zipInputStream.getNextEntry();
                                                                    } catch (Exception unused2) {
                                                                        nextEntry = null;
                                                                    }
                                                                    path = str23;
                                                                    str21 = str4;
                                                                    r30 = r210;
                                                                    backupRestoreViewModel4 = backupRestoreViewModel3;
                                                                    r122 = r27;
                                                                } catch (Throwable th13) {
                                                                    th = th13;
                                                                    r25 = r122;
                                                                }
                                                            }
                                                            ?? r213 = r30;
                                                            str5 = str21;
                                                            BackupRestoreViewModel backupRestoreViewModel5 = backupRestoreViewModel4;
                                                            ?? r214 = r122;
                                                            String str24 = path;
                                                            try {
                                                                CharsKt.closeFinally(zipInputStream, null);
                                                                try {
                                                                    CharsKt.closeFinally(inputStreamOpenInputStream, null);
                                                                    boolean z2 = ref$BooleanRef2.element;
                                                                    if (z2) {
                                                                        r21 = r214;
                                                                        i = -1;
                                                                        if (z2) {
                                                                            absolutePath.getClass();
                                                                            if (!new File(absolutePath).exists()) {
                                                                                sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(absolutePath, null, 1);
                                                                                int version = sQLiteDatabaseOpenDatabase.getVersion();
                                                                                CharsKt.closeFinally(sQLiteDatabaseOpenDatabase, null);
                                                                                i = version;
                                                                            }
                                                                            i2 = 0;
                                                                            if (i <= 0) {
                                                                                backupRestoreViewModel = backupRestoreViewModel5;
                                                                                if (i > backupRestoreViewModel.database.delegate.getOpenHelper().getWritableDatabase().delegate.getVersion()) {
                                                                                    Timber.Forest.tag("RESTORE");
                                                                                    ConnectionPool.w(new Object[0]);
                                                                                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                                                                    HandlerContext handlerContext3 = MainDispatcherLoader.dispatcher;
                                                                                    ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$3 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 11);
                                                                                    this.L$0 = null;
                                                                                    this.L$1 = absolutePath;
                                                                                    this.$cacheKey = file9;
                                                                                    this.L$6 = null;
                                                                                    this.$mediaId = null;
                                                                                    this.$songArtists = null;
                                                                                    this.$songTitle = null;
                                                                                    this.$album = null;
                                                                                    this.$duration = i;
                                                                                    this.label = (byte) 3;
                                                                                    break;
                                                                                }
                                                                                r7 = r21;
                                                                                file8 = file4;
                                                                                r29 = r22;
                                                                                str18 = str9;
                                                                                r121 = r119;
                                                                                str17 = str13;
                                                                                r7 = r22;
                                                                                r7 = r9;
                                                                                return r7;
                                                                            }
                                                                            Timber.Forest.tag("RESTORE");
                                                                            ConnectionPool.e(new Object[i2]);
                                                                            DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                                                                            handlerContext2 = MainDispatcherLoader.dispatcher;
                                                                            contextExtKt$isSyncEnabled$2 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 10);
                                                                            this.L$0 = null;
                                                                            this.L$1 = absolutePath;
                                                                            this.$cacheKey = file9;
                                                                            this.L$6 = null;
                                                                            this.$mediaId = null;
                                                                            this.$songArtists = null;
                                                                            this.$songTitle = null;
                                                                            this.$album = null;
                                                                            this.$duration = i;
                                                                            this.label = (byte) 2;
                                                                            if (AwaitKt.withContext(handlerContext2, contextExtKt$isSyncEnabled$2, this) == r21) {
                                                                                r7 = r21;
                                                                                r7 = r21;
                                                                                file8 = file4;
                                                                                r29 = r22;
                                                                                str18 = str9;
                                                                                r121 = r119;
                                                                                str17 = str13;
                                                                                r7 = r22;
                                                                                r7 = r9;
                                                                                return r7;
                                                                            }
                                                                        } else {
                                                                            backupRestoreViewModel = backupRestoreViewModel5;
                                                                        }
                                                                        i3 = i;
                                                                        context3.stopService(new Intent(context3, (Class<?>) MusicService.class));
                                                                        c01441 = new DiscordRpcManager.C01441();
                                                                        this.L$0 = null;
                                                                        this.L$1 = absolutePath;
                                                                        this.$cacheKey = file9;
                                                                        this.L$6 = backupRestoreViewModel;
                                                                        this.$mediaId = context3;
                                                                        this.$songArtists = r213;
                                                                        str6 = str24;
                                                                        this.$songTitle = str6;
                                                                        this.$album = ref$BooleanRef2;
                                                                        this.L$5 = ref$BooleanRef;
                                                                        this.L$9 = ref$ObjectRef;
                                                                        this.$duration = i3;
                                                                        this.label = (byte) 4;
                                                                        r114 = 5000;
                                                                        r7 = r21;
                                                                        if (AwaitKt.withTimeout(5000L, c01441, this) != r21) {
                                                                            r115 = ref$BooleanRef2;
                                                                            str7 = str6;
                                                                            backupRestoreViewModel2 = backupRestoreViewModel;
                                                                            file3 = file9;
                                                                            context2 = context3;
                                                                            r28 = r21;
                                                                            str16 = absolutePath;
                                                                            str15 = str22;
                                                                            Context context4 = context2;
                                                                            ref$ObjectRef = ref$ObjectRef;
                                                                            file4 = file3;
                                                                            backupRestoreViewModel = backupRestoreViewModel2;
                                                                            context = context4;
                                                                            r22 = r28;
                                                                            str9 = str16;
                                                                            r118 = r114;
                                                                            r117 = r115;
                                                                            str8 = str15;
                                                                            backupRestoreViewModel.database.close();
                                                                            if (r117.element) {
                                                                                file5 = new File(str7);
                                                                                file6 = new File(str7 + ".restore_staged");
                                                                                StringBuilder sb3 = new StringBuilder();
                                                                                sb3.append(str7);
                                                                                str12 = ".restore_backup";
                                                                                sb3.append(".restore_backup");
                                                                                file7 = new File(sb3.toString());
                                                                                file6.delete();
                                                                                file7.delete();
                                                                                FilesKt.copyTo$default(new File(str9), file6);
                                                                                RenameTo = file5.renameTo(file7);
                                                                                if (RenameTo != 0) {
                                                                                    throw new IllegalStateException("Failed to preserve current DB before restore");
                                                                                }
                                                                                if (file6.renameTo(file5)) {
                                                                                    file7.renameTo(file5);
                                                                                    throw new IllegalStateException("Failed to promote restored DB");
                                                                                }
                                                                                file7.delete();
                                                                                ?? sb4 = new StringBuilder();
                                                                                sb4.append(str7);
                                                                                RenameTo = str5;
                                                                                sb4.append(RenameTo);
                                                                                new File(sb4.toString()).delete();
                                                                                StringBuilder sb5 = new StringBuilder();
                                                                                sb5.append(str7);
                                                                                String str25 = str8;
                                                                                sb5.append(str25);
                                                                                new File(sb5.toString()).delete();
                                                                                r120 = RenameTo;
                                                                                str14 = str25;
                                                                                Timber.Forest.getClass();
                                                                                ConnectionPool.e$1(new Object[0]);
                                                                                z = false;
                                                                                r119 = RenameTo;
                                                                                str13 = str12;
                                                                                if (z) {
                                                                                    DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                                                                                    HandlerContext handlerContext4 = MainDispatcherLoader.dispatcher;
                                                                                    ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$4 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                                                                    this.L$0 = null;
                                                                                    this.L$1 = str9;
                                                                                    this.$cacheKey = file4;
                                                                                    this.L$6 = null;
                                                                                    this.$mediaId = null;
                                                                                    this.$songArtists = null;
                                                                                    this.$songTitle = null;
                                                                                    this.$album = null;
                                                                                    this.L$5 = null;
                                                                                    this.L$9 = null;
                                                                                    this.$duration = i3;
                                                                                    this.label = (byte) 6;
                                                                                } else {
                                                                                    if (ref$BooleanRef.element) {
                                                                                        FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                                                                    }
                                                                                    File filesDir = context.getFilesDir();
                                                                                    filesDir.getClass();
                                                                                    FilesKt.resolve(filesDir, "persistent_queue.data").delete();
                                                                                    File filesDir2 = context.getFilesDir();
                                                                                    filesDir2.getClass();
                                                                                    FilesKt.resolve(filesDir2, "persistent_automix.data").delete();
                                                                                    File filesDir3 = context.getFilesDir();
                                                                                    filesDir3.getClass();
                                                                                    FilesKt.resolve(filesDir3, "persistent_player_state.data").delete();
                                                                                    ArtistNameAliases artistNameAliases2 = ArtistNameAliases.INSTANCE;
                                                                                    map = (Map) ref$ObjectRef.element;
                                                                                    if (map == null) {
                                                                                        map = EmptyMap.INSTANCE;
                                                                                    }
                                                                                    artistNameAliases2.restore(context, map);
                                                                                    launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                                                                    if (launchIntentForPackage != null) {
                                                                                        launchIntentForPackage.addFlags(268468224);
                                                                                    } else {
                                                                                        launchIntentForPackage = null;
                                                                                    }
                                                                                    context.startActivity(launchIntentForPackage);
                                                                                    Runtime.getRuntime().exit(0);
                                                                                    file8 = file4;
                                                                                    r29 = r22;
                                                                                    str18 = str9;
                                                                                    r121 = r119;
                                                                                    str17 = str13;
                                                                                }
                                                                                file8 = file4;
                                                                                r29 = r22;
                                                                                str18 = str9;
                                                                                r121 = r119;
                                                                                str17 = str13;
                                                                                r7 = r22;
                                                                                objCreateFailure = unit;
                                                                                obj4 = file8;
                                                                                r9 = r29;
                                                                                r8 = str18;
                                                                                r16 = r121;
                                                                                r15 = str17;
                                                                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                r2 = obj4;
                                                                                r10 = r8;
                                                                                r18 = r16;
                                                                                r17 = r15;
                                                                                if (thM1866exceptionOrNullimpl != null) {
                                                                                    UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                    Timber.Forest.tag("RESTORE");
                                                                                    ConnectionPool.e$1(new Object[0]);
                                                                                    DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                                                                                    handlerContext = MainDispatcherLoader.dispatcher;
                                                                                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                    this.L$0 = null;
                                                                                    this.L$1 = r8;
                                                                                    this.$cacheKey = obj4;
                                                                                    this.L$6 = objCreateFailure;
                                                                                    this.$mediaId = null;
                                                                                    this.$songArtists = null;
                                                                                    this.$songTitle = null;
                                                                                    this.$album = null;
                                                                                    this.L$5 = null;
                                                                                    this.L$9 = null;
                                                                                    this.label = (byte) 7;
                                                                                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                        r7 = r9;
                                                                                        obj5 = obj4;
                                                                                        r1 = r8;
                                                                                        r110 = r16;
                                                                                        r19 = r15;
                                                                                        r2 = obj5;
                                                                                        r10 = r1;
                                                                                        r18 = r110;
                                                                                        r17 = r19;
                                                                                    }
                                                                                }
                                                                                new File((String) r10).delete();
                                                                                ?? sb6 = new StringBuilder();
                                                                                sb6.append(r10);
                                                                                sb6.append(r18);
                                                                                new File(sb6.toString()).delete();
                                                                                ?? sb7 = new StringBuilder();
                                                                                sb7.append(r10);
                                                                                sb7.append(r17);
                                                                                new File(sb7.toString()).delete();
                                                                                r2.delete();
                                                                            } else {
                                                                                str14 = str8;
                                                                                r120 = str5;
                                                                            }
                                                                            z = true;
                                                                            r119 = r120;
                                                                            str13 = str14;
                                                                            if (z) {
                                                                                DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                                                                                HandlerContext handlerContext5 = MainDispatcherLoader.dispatcher;
                                                                                ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$5 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                                                                this.L$0 = null;
                                                                                this.L$1 = str9;
                                                                                this.$cacheKey = file4;
                                                                                this.L$6 = null;
                                                                                this.$mediaId = null;
                                                                                this.$songArtists = null;
                                                                                this.$songTitle = null;
                                                                                this.$album = null;
                                                                                this.L$5 = null;
                                                                                this.L$9 = null;
                                                                                this.$duration = i3;
                                                                                this.label = (byte) 6;
                                                                            } else {
                                                                                if (ref$BooleanRef.element) {
                                                                                    FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                                                                }
                                                                                File filesDir4 = context.getFilesDir();
                                                                                filesDir4.getClass();
                                                                                FilesKt.resolve(filesDir4, "persistent_queue.data").delete();
                                                                                File filesDir5 = context.getFilesDir();
                                                                                filesDir5.getClass();
                                                                                FilesKt.resolve(filesDir5, "persistent_automix.data").delete();
                                                                                File filesDir6 = context.getFilesDir();
                                                                                filesDir6.getClass();
                                                                                FilesKt.resolve(filesDir6, "persistent_player_state.data").delete();
                                                                                ArtistNameAliases artistNameAliases3 = ArtistNameAliases.INSTANCE;
                                                                                map = (Map) ref$ObjectRef.element;
                                                                                if (map == null) {
                                                                                    map = EmptyMap.INSTANCE;
                                                                                }
                                                                                artistNameAliases3.restore(context, map);
                                                                                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                                                                if (launchIntentForPackage != null) {
                                                                                    launchIntentForPackage.addFlags(268468224);
                                                                                } else {
                                                                                    launchIntentForPackage = null;
                                                                                }
                                                                                context.startActivity(launchIntentForPackage);
                                                                                Runtime.getRuntime().exit(0);
                                                                                file8 = file4;
                                                                                r29 = r22;
                                                                                str18 = str9;
                                                                                r121 = r119;
                                                                                str17 = str13;
                                                                            }
                                                                            file8 = file4;
                                                                            r29 = r22;
                                                                            str18 = str9;
                                                                            r121 = r119;
                                                                            str17 = str13;
                                                                            r7 = r22;
                                                                            objCreateFailure = unit;
                                                                            obj4 = file8;
                                                                            r9 = r29;
                                                                            r8 = str18;
                                                                            r16 = r121;
                                                                            r15 = str17;
                                                                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                            r2 = obj4;
                                                                            r10 = r8;
                                                                            r18 = r16;
                                                                            r17 = r15;
                                                                            if (thM1866exceptionOrNullimpl != null) {
                                                                                UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                Timber.Forest.tag("RESTORE");
                                                                                ConnectionPool.e$1(new Object[0]);
                                                                                DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                                                                                handlerContext = MainDispatcherLoader.dispatcher;
                                                                                contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                this.L$0 = null;
                                                                                this.L$1 = r8;
                                                                                this.$cacheKey = obj4;
                                                                                this.L$6 = objCreateFailure;
                                                                                this.$mediaId = null;
                                                                                this.$songArtists = null;
                                                                                this.$songTitle = null;
                                                                                this.$album = null;
                                                                                this.L$5 = null;
                                                                                this.L$9 = null;
                                                                                this.label = (byte) 7;
                                                                                if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                    r7 = r9;
                                                                                    obj5 = obj4;
                                                                                    r1 = r8;
                                                                                    r110 = r16;
                                                                                    r19 = r15;
                                                                                    r2 = obj5;
                                                                                    r10 = r1;
                                                                                    r18 = r110;
                                                                                    r17 = r19;
                                                                                }
                                                                            }
                                                                            new File((String) r10).delete();
                                                                            ?? sb8 = new StringBuilder();
                                                                            sb8.append(r10);
                                                                            sb8.append(r18);
                                                                            new File(sb8.toString()).delete();
                                                                            ?? sb9 = new StringBuilder();
                                                                            sb9.append(r10);
                                                                            sb9.append(r17);
                                                                            new File(sb9.toString()).delete();
                                                                            r2.delete();
                                                                            break;
                                                                        }
                                                                        r7 = r21;
                                                                        file8 = file4;
                                                                        r29 = r22;
                                                                        str18 = str9;
                                                                        r121 = r119;
                                                                        str17 = str13;
                                                                        r7 = r22;
                                                                        r7 = r9;
                                                                        return r7;
                                                                    }
                                                                    try {
                                                                        if (!ref$BooleanRef.element) {
                                                                            Timber.Forest.tag("RESTORE");
                                                                            ConnectionPool.w(new Object[0]);
                                                                            DefaultScheduler defaultScheduler8 = Dispatchers.Default;
                                                                            HandlerContext handlerContext6 = MainDispatcherLoader.dispatcher;
                                                                            ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$6 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 9);
                                                                            this.L$0 = null;
                                                                            this.L$1 = absolutePath;
                                                                            this.$cacheKey = file9;
                                                                            this.L$6 = null;
                                                                            this.$mediaId = null;
                                                                            this.$songArtists = null;
                                                                            this.$songTitle = null;
                                                                            this.$album = null;
                                                                            this.label = (byte) 1;
                                                                            ?? r32 = r214;
                                                                            r7 = r32;
                                                                        }
                                                                        r21 = r214;
                                                                        i = -1;
                                                                        try {
                                                                            try {
                                                                                try {
                                                                                    try {
                                                                                        if (z2) {
                                                                                            try {
                                                                                                absolutePath.getClass();
                                                                                                try {
                                                                                                    if (!new File(absolutePath).exists()) {
                                                                                                        try {
                                                                                                            sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(absolutePath, null, 1);
                                                                                                            try {
                                                                                                                int version2 = sQLiteDatabaseOpenDatabase.getVersion();
                                                                                                                CharsKt.closeFinally(sQLiteDatabaseOpenDatabase, null);
                                                                                                                i = version2;
                                                                                                            } catch (Throwable th14) {
                                                                                                                try {
                                                                                                                    throw th14;
                                                                                                                } catch (Throwable th15) {
                                                                                                                    CharsKt.closeFinally(sQLiteDatabaseOpenDatabase, th14);
                                                                                                                    throw th15;
                                                                                                                }
                                                                                                            }
                                                                                                        } catch (Exception unused3) {
                                                                                                            Timber.Forest.tag("MusicDatabase");
                                                                                                            "Failed to read database version from ".concat(absolutePath);
                                                                                                            i2 = 0;
                                                                                                            ConnectionPool.e$1(new Object[0]);
                                                                                                        }
                                                                                                    }
                                                                                                    i2 = 0;
                                                                                                } catch (Exception unused4) {
                                                                                                }
                                                                                                if (i <= 0) {
                                                                                                    backupRestoreViewModel = backupRestoreViewModel5;
                                                                                                    if (i > backupRestoreViewModel.database.delegate.getOpenHelper().getWritableDatabase().delegate.getVersion()) {
                                                                                                        Timber.Forest.tag("RESTORE");
                                                                                                        ConnectionPool.w(new Object[0]);
                                                                                                        DefaultScheduler defaultScheduler9 = Dispatchers.Default;
                                                                                                        HandlerContext handlerContext7 = MainDispatcherLoader.dispatcher;
                                                                                                        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$7 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 11);
                                                                                                        this.L$0 = null;
                                                                                                        this.L$1 = absolutePath;
                                                                                                        this.$cacheKey = file9;
                                                                                                        this.L$6 = null;
                                                                                                        this.$mediaId = null;
                                                                                                        this.$songArtists = null;
                                                                                                        this.$songTitle = null;
                                                                                                        this.$album = null;
                                                                                                        this.$duration = i;
                                                                                                        this.label = (byte) 3;
                                                                                                        break;
                                                                                                    }
                                                                                                    r7 = r21;
                                                                                                    file8 = file4;
                                                                                                    r29 = r22;
                                                                                                    str18 = str9;
                                                                                                    r121 = r119;
                                                                                                    str17 = str13;
                                                                                                    r7 = r22;
                                                                                                    r7 = r9;
                                                                                                    return r7;
                                                                                                }
                                                                                                Timber.Forest.tag("RESTORE");
                                                                                                ConnectionPool.e(new Object[i2]);
                                                                                                DefaultScheduler defaultScheduler10 = Dispatchers.Default;
                                                                                                handlerContext2 = MainDispatcherLoader.dispatcher;
                                                                                                contextExtKt$isSyncEnabled$2 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 10);
                                                                                                this.L$0 = null;
                                                                                                this.L$1 = absolutePath;
                                                                                                this.$cacheKey = file9;
                                                                                                this.L$6 = null;
                                                                                                this.$mediaId = null;
                                                                                                this.$songArtists = null;
                                                                                                this.$songTitle = null;
                                                                                                this.$album = null;
                                                                                                this.$duration = i;
                                                                                                this.label = (byte) 2;
                                                                                                if (AwaitKt.withContext(handlerContext2, contextExtKt$isSyncEnabled$2, this) == r21) {
                                                                                                    r7 = r21;
                                                                                                    r7 = r21;
                                                                                                    file8 = file4;
                                                                                                    r29 = r22;
                                                                                                    str18 = str9;
                                                                                                    r121 = r119;
                                                                                                    str17 = str13;
                                                                                                    r7 = r22;
                                                                                                    r7 = r9;
                                                                                                    return r7;
                                                                                                }
                                                                                            } catch (Throwable th16) {
                                                                                                th = th16;
                                                                                                r20 = r21;
                                                                                                file = file9;
                                                                                                r23 = r20;
                                                                                                str11 = absolutePath;
                                                                                                str10 = str22;
                                                                                                r14 = str10;
                                                                                                r13 = str5;
                                                                                                obj3 = file;
                                                                                                r4 = r23;
                                                                                                r6 = str11;
                                                                                                objCreateFailure = ResultKt.createFailure(th);
                                                                                                obj4 = obj3;
                                                                                                r9 = r4;
                                                                                                r8 = r6;
                                                                                                r16 = r13;
                                                                                                r15 = r14;
                                                                                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                                r2 = obj4;
                                                                                                r10 = r8;
                                                                                                r18 = r16;
                                                                                                r17 = r15;
                                                                                                if (thM1866exceptionOrNullimpl != null) {
                                                                                                    UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                                    Timber.Forest.tag("RESTORE");
                                                                                                    ConnectionPool.e$1(new Object[0]);
                                                                                                    DefaultScheduler defaultScheduler11 = Dispatchers.Default;
                                                                                                    handlerContext = MainDispatcherLoader.dispatcher;
                                                                                                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                                    this.L$0 = null;
                                                                                                    this.L$1 = r8;
                                                                                                    this.$cacheKey = obj4;
                                                                                                    this.L$6 = objCreateFailure;
                                                                                                    this.$mediaId = null;
                                                                                                    this.$songArtists = null;
                                                                                                    this.$songTitle = null;
                                                                                                    this.$album = null;
                                                                                                    this.L$5 = null;
                                                                                                    this.L$9 = null;
                                                                                                    this.label = (byte) 7;
                                                                                                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                                        r7 = r9;
                                                                                                        obj5 = obj4;
                                                                                                        r1 = r8;
                                                                                                        r110 = r16;
                                                                                                        r19 = r15;
                                                                                                        r2 = obj5;
                                                                                                        r10 = r1;
                                                                                                        r18 = r110;
                                                                                                        r17 = r19;
                                                                                                    }
                                                                                                    r7 = r21;
                                                                                                    file8 = file4;
                                                                                                    r29 = r22;
                                                                                                    str18 = str9;
                                                                                                    r121 = r119;
                                                                                                    str17 = str13;
                                                                                                    r7 = r22;
                                                                                                    r7 = r9;
                                                                                                    return r7;
                                                                                                }
                                                                                                new File((String) r10).delete();
                                                                                                ?? sb10 = new StringBuilder();
                                                                                                sb10.append(r10);
                                                                                                sb10.append(r18);
                                                                                                new File(sb10.toString()).delete();
                                                                                                ?? sb11 = new StringBuilder();
                                                                                                sb11.append(r10);
                                                                                                sb11.append(r17);
                                                                                                new File(sb11.toString()).delete();
                                                                                                r2.delete();
                                                                                                r7 = r21;
                                                                                                return unit;
                                                                                            }
                                                                                        } else {
                                                                                            backupRestoreViewModel = backupRestoreViewModel5;
                                                                                        }
                                                                                        r7 = r21;
                                                                                        if (AwaitKt.withTimeout(5000L, c01441, this) != r21) {
                                                                                            r115 = ref$BooleanRef2;
                                                                                            str7 = str6;
                                                                                            backupRestoreViewModel2 = backupRestoreViewModel;
                                                                                            file3 = file9;
                                                                                            context2 = context3;
                                                                                            r28 = r21;
                                                                                            str16 = absolutePath;
                                                                                            str15 = str22;
                                                                                            Context context5 = context2;
                                                                                            ref$ObjectRef = ref$ObjectRef;
                                                                                            file4 = file3;
                                                                                            backupRestoreViewModel = backupRestoreViewModel2;
                                                                                            context = context5;
                                                                                            r22 = r28;
                                                                                            str9 = str16;
                                                                                            r118 = r114;
                                                                                            r117 = r115;
                                                                                            str8 = str15;
                                                                                            backupRestoreViewModel.database.close();
                                                                                            try {
                                                                                                if (r117.element) {
                                                                                                    try {
                                                                                                        file5 = new File(str7);
                                                                                                        file6 = new File(str7 + ".restore_staged");
                                                                                                        StringBuilder sb12 = new StringBuilder();
                                                                                                        sb12.append(str7);
                                                                                                        str12 = ".restore_backup";
                                                                                                        sb12.append(".restore_backup");
                                                                                                        file7 = new File(sb12.toString());
                                                                                                        file6.delete();
                                                                                                        file7.delete();
                                                                                                        FilesKt.copyTo$default(new File(str9), file6);
                                                                                                        RenameTo = file5.renameTo(file7);
                                                                                                        try {
                                                                                                            if (RenameTo != 0) {
                                                                                                                throw new IllegalStateException("Failed to preserve current DB before restore");
                                                                                                            }
                                                                                                            if (file6.renameTo(file5)) {
                                                                                                                file7.renameTo(file5);
                                                                                                                throw new IllegalStateException("Failed to promote restored DB");
                                                                                                            }
                                                                                                            file7.delete();
                                                                                                            ?? sb13 = new StringBuilder();
                                                                                                            sb13.append(str7);
                                                                                                            RenameTo = str5;
                                                                                                            try {
                                                                                                                sb13.append(RenameTo);
                                                                                                                new File(sb13.toString()).delete();
                                                                                                                StringBuilder sb14 = new StringBuilder();
                                                                                                                sb14.append(str7);
                                                                                                                String str26 = str8;
                                                                                                                sb14.append(str26);
                                                                                                                new File(sb14.toString()).delete();
                                                                                                                r120 = RenameTo;
                                                                                                                str14 = str26;
                                                                                                            } catch (Exception unused5) {
                                                                                                                str12 = str8;
                                                                                                                Timber.Forest.getClass();
                                                                                                                ConnectionPool.e$1(new Object[0]);
                                                                                                                z = false;
                                                                                                                r119 = RenameTo;
                                                                                                                str13 = str12;
                                                                                                            } catch (Throwable th17) {
                                                                                                                th = th17;
                                                                                                                r14 = str8;
                                                                                                                obj3 = file4;
                                                                                                                r4 = r22;
                                                                                                                r6 = str9;
                                                                                                                r13 = RenameTo;
                                                                                                                objCreateFailure = ResultKt.createFailure(th);
                                                                                                                obj4 = obj3;
                                                                                                                r9 = r4;
                                                                                                                r8 = r6;
                                                                                                                r16 = r13;
                                                                                                                r15 = r14;
                                                                                                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                                                r2 = obj4;
                                                                                                                r10 = r8;
                                                                                                                r18 = r16;
                                                                                                                r17 = r15;
                                                                                                                if (thM1866exceptionOrNullimpl != null) {
                                                                                                                    UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                                                    Timber.Forest.tag("RESTORE");
                                                                                                                    ConnectionPool.e$1(new Object[0]);
                                                                                                                    DefaultScheduler defaultScheduler12 = Dispatchers.Default;
                                                                                                                    handlerContext = MainDispatcherLoader.dispatcher;
                                                                                                                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                                                    this.L$0 = null;
                                                                                                                    this.L$1 = r8;
                                                                                                                    this.$cacheKey = obj4;
                                                                                                                    this.L$6 = objCreateFailure;
                                                                                                                    this.$mediaId = null;
                                                                                                                    this.$songArtists = null;
                                                                                                                    this.$songTitle = null;
                                                                                                                    this.$album = null;
                                                                                                                    this.L$5 = null;
                                                                                                                    this.L$9 = null;
                                                                                                                    this.label = (byte) 7;
                                                                                                                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                                                        r7 = r9;
                                                                                                                        obj5 = obj4;
                                                                                                                        r1 = r8;
                                                                                                                        r110 = r16;
                                                                                                                        r19 = r15;
                                                                                                                        r2 = obj5;
                                                                                                                        r10 = r1;
                                                                                                                        r18 = r110;
                                                                                                                        r17 = r19;
                                                                                                                    }
                                                                                                                    r7 = r21;
                                                                                                                    file8 = file4;
                                                                                                                    r29 = r22;
                                                                                                                    str18 = str9;
                                                                                                                    r121 = r119;
                                                                                                                    str17 = str13;
                                                                                                                    r7 = r22;
                                                                                                                    r7 = r9;
                                                                                                                    return r7;
                                                                                                                }
                                                                                                                new File((String) r10).delete();
                                                                                                                ?? sb15 = new StringBuilder();
                                                                                                                sb15.append(r10);
                                                                                                                sb15.append(r18);
                                                                                                                new File(sb15.toString()).delete();
                                                                                                                ?? sb16 = new StringBuilder();
                                                                                                                sb16.append(r10);
                                                                                                                sb16.append(r17);
                                                                                                                new File(sb16.toString()).delete();
                                                                                                                r2.delete();
                                                                                                                r7 = r21;
                                                                                                                return unit;
                                                                                                            }
                                                                                                        } catch (Exception unused6) {
                                                                                                        }
                                                                                                    } catch (Exception unused7) {
                                                                                                        str12 = str8;
                                                                                                        RenameTo = str5;
                                                                                                    }
                                                                                                    Timber.Forest.getClass();
                                                                                                    ConnectionPool.e$1(new Object[0]);
                                                                                                    z = false;
                                                                                                    r119 = RenameTo;
                                                                                                    str13 = str12;
                                                                                                    if (z) {
                                                                                                        DefaultScheduler defaultScheduler13 = Dispatchers.Default;
                                                                                                        HandlerContext handlerContext8 = MainDispatcherLoader.dispatcher;
                                                                                                        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$8 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                                                                                        this.L$0 = null;
                                                                                                        this.L$1 = str9;
                                                                                                        this.$cacheKey = file4;
                                                                                                        this.L$6 = null;
                                                                                                        this.$mediaId = null;
                                                                                                        this.$songArtists = null;
                                                                                                        this.$songTitle = null;
                                                                                                        this.$album = null;
                                                                                                        this.L$5 = null;
                                                                                                        this.L$9 = null;
                                                                                                        this.$duration = i3;
                                                                                                        this.label = (byte) 6;
                                                                                                    } else {
                                                                                                        if (ref$BooleanRef.element) {
                                                                                                            FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                                                                                        }
                                                                                                        File filesDir7 = context.getFilesDir();
                                                                                                        filesDir7.getClass();
                                                                                                        FilesKt.resolve(filesDir7, "persistent_queue.data").delete();
                                                                                                        File filesDir8 = context.getFilesDir();
                                                                                                        filesDir8.getClass();
                                                                                                        FilesKt.resolve(filesDir8, "persistent_automix.data").delete();
                                                                                                        File filesDir9 = context.getFilesDir();
                                                                                                        filesDir9.getClass();
                                                                                                        FilesKt.resolve(filesDir9, "persistent_player_state.data").delete();
                                                                                                        ArtistNameAliases artistNameAliases4 = ArtistNameAliases.INSTANCE;
                                                                                                        map = (Map) ref$ObjectRef.element;
                                                                                                        if (map == null) {
                                                                                                            map = EmptyMap.INSTANCE;
                                                                                                        }
                                                                                                        artistNameAliases4.restore(context, map);
                                                                                                        launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                                                                                        if (launchIntentForPackage != null) {
                                                                                                            launchIntentForPackage.addFlags(268468224);
                                                                                                        } else {
                                                                                                            launchIntentForPackage = null;
                                                                                                        }
                                                                                                        context.startActivity(launchIntentForPackage);
                                                                                                        Runtime.getRuntime().exit(0);
                                                                                                        file8 = file4;
                                                                                                        r29 = r22;
                                                                                                        str18 = str9;
                                                                                                        r121 = r119;
                                                                                                        str17 = str13;
                                                                                                    }
                                                                                                    file8 = file4;
                                                                                                    r29 = r22;
                                                                                                    str18 = str9;
                                                                                                    r121 = r119;
                                                                                                    str17 = str13;
                                                                                                    r7 = r22;
                                                                                                    objCreateFailure = unit;
                                                                                                    obj4 = file8;
                                                                                                    r9 = r29;
                                                                                                    r8 = str18;
                                                                                                    r16 = r121;
                                                                                                    r15 = str17;
                                                                                                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                                    r2 = obj4;
                                                                                                    r10 = r8;
                                                                                                    r18 = r16;
                                                                                                    r17 = r15;
                                                                                                    if (thM1866exceptionOrNullimpl != null) {
                                                                                                        UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                                        Timber.Forest.tag("RESTORE");
                                                                                                        ConnectionPool.e$1(new Object[0]);
                                                                                                        DefaultScheduler defaultScheduler14 = Dispatchers.Default;
                                                                                                        handlerContext = MainDispatcherLoader.dispatcher;
                                                                                                        contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                                        this.L$0 = null;
                                                                                                        this.L$1 = r8;
                                                                                                        this.$cacheKey = obj4;
                                                                                                        this.L$6 = objCreateFailure;
                                                                                                        this.$mediaId = null;
                                                                                                        this.$songArtists = null;
                                                                                                        this.$songTitle = null;
                                                                                                        this.$album = null;
                                                                                                        this.L$5 = null;
                                                                                                        this.L$9 = null;
                                                                                                        this.label = (byte) 7;
                                                                                                        if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                                            r7 = r9;
                                                                                                            obj5 = obj4;
                                                                                                            r1 = r8;
                                                                                                            r110 = r16;
                                                                                                            r19 = r15;
                                                                                                            r2 = obj5;
                                                                                                            r10 = r1;
                                                                                                            r18 = r110;
                                                                                                            r17 = r19;
                                                                                                        }
                                                                                                    }
                                                                                                    new File((String) r10).delete();
                                                                                                    ?? sb17 = new StringBuilder();
                                                                                                    sb17.append(r10);
                                                                                                    sb17.append(r18);
                                                                                                    new File(sb17.toString()).delete();
                                                                                                    ?? sb18 = new StringBuilder();
                                                                                                    sb18.append(r10);
                                                                                                    sb18.append(r17);
                                                                                                    new File(sb18.toString()).delete();
                                                                                                    r2.delete();
                                                                                                } else {
                                                                                                    str14 = str8;
                                                                                                    r120 = str5;
                                                                                                }
                                                                                                z = true;
                                                                                                r119 = r120;
                                                                                                str13 = str14;
                                                                                                if (z) {
                                                                                                    DefaultScheduler defaultScheduler15 = Dispatchers.Default;
                                                                                                    HandlerContext handlerContext9 = MainDispatcherLoader.dispatcher;
                                                                                                    ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$9 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                                                                                    this.L$0 = null;
                                                                                                    this.L$1 = str9;
                                                                                                    this.$cacheKey = file4;
                                                                                                    this.L$6 = null;
                                                                                                    this.$mediaId = null;
                                                                                                    this.$songArtists = null;
                                                                                                    this.$songTitle = null;
                                                                                                    this.$album = null;
                                                                                                    this.L$5 = null;
                                                                                                    this.L$9 = null;
                                                                                                    this.$duration = i3;
                                                                                                    this.label = (byte) 6;
                                                                                                } else {
                                                                                                    if (ref$BooleanRef.element) {
                                                                                                        FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                                                                                    }
                                                                                                    File filesDir10 = context.getFilesDir();
                                                                                                    filesDir10.getClass();
                                                                                                    FilesKt.resolve(filesDir10, "persistent_queue.data").delete();
                                                                                                    File filesDir11 = context.getFilesDir();
                                                                                                    filesDir11.getClass();
                                                                                                    FilesKt.resolve(filesDir11, "persistent_automix.data").delete();
                                                                                                    File filesDir12 = context.getFilesDir();
                                                                                                    filesDir12.getClass();
                                                                                                    FilesKt.resolve(filesDir12, "persistent_player_state.data").delete();
                                                                                                    ArtistNameAliases artistNameAliases5 = ArtistNameAliases.INSTANCE;
                                                                                                    map = (Map) ref$ObjectRef.element;
                                                                                                    if (map == null) {
                                                                                                        map = EmptyMap.INSTANCE;
                                                                                                    }
                                                                                                    artistNameAliases5.restore(context, map);
                                                                                                    launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                                                                                    if (launchIntentForPackage != null) {
                                                                                                        launchIntentForPackage.addFlags(268468224);
                                                                                                    } else {
                                                                                                        launchIntentForPackage = null;
                                                                                                    }
                                                                                                    context.startActivity(launchIntentForPackage);
                                                                                                    Runtime.getRuntime().exit(0);
                                                                                                    file8 = file4;
                                                                                                    r29 = r22;
                                                                                                    str18 = str9;
                                                                                                    r121 = r119;
                                                                                                    str17 = str13;
                                                                                                }
                                                                                                file8 = file4;
                                                                                                r29 = r22;
                                                                                                str18 = str9;
                                                                                                r121 = r119;
                                                                                                str17 = str13;
                                                                                                r7 = r22;
                                                                                                objCreateFailure = unit;
                                                                                                obj4 = file8;
                                                                                                r9 = r29;
                                                                                                r8 = str18;
                                                                                                r16 = r121;
                                                                                                r15 = str17;
                                                                                            } catch (Throwable th18) {
                                                                                                th = th18;
                                                                                                obj3 = file4;
                                                                                                r4 = r22;
                                                                                                r6 = str9;
                                                                                                r13 = r118;
                                                                                                r14 = r117;
                                                                                            }
                                                                                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                            r2 = obj4;
                                                                                            r10 = r8;
                                                                                            r18 = r16;
                                                                                            r17 = r15;
                                                                                            if (thM1866exceptionOrNullimpl != null) {
                                                                                                UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                                Timber.Forest.tag("RESTORE");
                                                                                                ConnectionPool.e$1(new Object[0]);
                                                                                                DefaultScheduler defaultScheduler16 = Dispatchers.Default;
                                                                                                handlerContext = MainDispatcherLoader.dispatcher;
                                                                                                contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                                this.L$0 = null;
                                                                                                this.L$1 = r8;
                                                                                                this.$cacheKey = obj4;
                                                                                                this.L$6 = objCreateFailure;
                                                                                                this.$mediaId = null;
                                                                                                this.$songArtists = null;
                                                                                                this.$songTitle = null;
                                                                                                this.$album = null;
                                                                                                this.L$5 = null;
                                                                                                this.L$9 = null;
                                                                                                this.label = (byte) 7;
                                                                                                if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                                    r7 = r9;
                                                                                                    obj5 = obj4;
                                                                                                    r1 = r8;
                                                                                                    r110 = r16;
                                                                                                    r19 = r15;
                                                                                                    r2 = obj5;
                                                                                                    r10 = r1;
                                                                                                    r18 = r110;
                                                                                                    r17 = r19;
                                                                                                }
                                                                                            }
                                                                                            new File((String) r10).delete();
                                                                                            ?? sb19 = new StringBuilder();
                                                                                            sb19.append(r10);
                                                                                            sb19.append(r18);
                                                                                            new File(sb19.toString()).delete();
                                                                                            ?? sb110 = new StringBuilder();
                                                                                            sb110.append(r10);
                                                                                            sb110.append(r17);
                                                                                            new File(sb110.toString()).delete();
                                                                                            r2.delete();
                                                                                        }
                                                                                        break;
                                                                                    } catch (Exception unused8) {
                                                                                        file2 = file9;
                                                                                        r113 = ref$BooleanRef2;
                                                                                        context = context3;
                                                                                        str7 = str6;
                                                                                        file4 = file2;
                                                                                        r22 = r21;
                                                                                        str9 = absolutePath;
                                                                                        r116 = r113;
                                                                                        str8 = str22;
                                                                                        try {
                                                                                            Object[] objArr = new Object[0];
                                                                                            Timber.Forest.getClass();
                                                                                            ConnectionPool.e$1(objArr);
                                                                                            file4 = file4;
                                                                                            r22 = r22;
                                                                                            str9 = str9;
                                                                                            r118 = objArr;
                                                                                            r117 = r116;
                                                                                            str8 = str8;
                                                                                        } catch (Throwable th19) {
                                                                                            th = th19;
                                                                                            file = file4;
                                                                                            r23 = r22;
                                                                                            str11 = str9;
                                                                                            str10 = str8;
                                                                                            r14 = str10;
                                                                                            r13 = str5;
                                                                                            obj3 = file;
                                                                                            r4 = r23;
                                                                                            r6 = str11;
                                                                                            objCreateFailure = ResultKt.createFailure(th);
                                                                                            obj4 = obj3;
                                                                                            r9 = r4;
                                                                                            r8 = r6;
                                                                                            r16 = r13;
                                                                                            r15 = r14;
                                                                                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                            r2 = obj4;
                                                                                            r10 = r8;
                                                                                            r18 = r16;
                                                                                            r17 = r15;
                                                                                            if (thM1866exceptionOrNullimpl != null) {
                                                                                                UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                                Timber.Forest.tag("RESTORE");
                                                                                                ConnectionPool.e$1(new Object[0]);
                                                                                                DefaultScheduler defaultScheduler17 = Dispatchers.Default;
                                                                                                handlerContext = MainDispatcherLoader.dispatcher;
                                                                                                contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                                this.L$0 = null;
                                                                                                this.L$1 = r8;
                                                                                                this.$cacheKey = obj4;
                                                                                                this.L$6 = objCreateFailure;
                                                                                                this.$mediaId = null;
                                                                                                this.$songArtists = null;
                                                                                                this.$songTitle = null;
                                                                                                this.$album = null;
                                                                                                this.L$5 = null;
                                                                                                this.L$9 = null;
                                                                                                this.label = (byte) 7;
                                                                                                if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                                    r7 = r9;
                                                                                                    obj5 = obj4;
                                                                                                    r1 = r8;
                                                                                                    r110 = r16;
                                                                                                    r19 = r15;
                                                                                                    r2 = obj5;
                                                                                                    r10 = r1;
                                                                                                    r18 = r110;
                                                                                                    r17 = r19;
                                                                                                }
                                                                                                r7 = r21;
                                                                                                file8 = file4;
                                                                                                r29 = r22;
                                                                                                str18 = str9;
                                                                                                r121 = r119;
                                                                                                str17 = str13;
                                                                                                r7 = r22;
                                                                                                r7 = r9;
                                                                                                return r7;
                                                                                            }
                                                                                            new File((String) r10).delete();
                                                                                            ?? sb111 = new StringBuilder();
                                                                                            sb111.append(r10);
                                                                                            sb111.append(r18);
                                                                                            new File(sb111.toString()).delete();
                                                                                            ?? sb112 = new StringBuilder();
                                                                                            sb112.append(r10);
                                                                                            sb112.append(r17);
                                                                                            new File(sb112.toString()).delete();
                                                                                            r2.delete();
                                                                                            r7 = r21;
                                                                                            return unit;
                                                                                        }
                                                                                    }
                                                                                    this.$songTitle = str6;
                                                                                    this.$album = ref$BooleanRef2;
                                                                                    this.L$5 = ref$BooleanRef;
                                                                                    this.L$9 = ref$ObjectRef;
                                                                                    this.$duration = i3;
                                                                                    this.label = (byte) 4;
                                                                                    r114 = 5000;
                                                                                } catch (Exception unused9) {
                                                                                    file2 = file9;
                                                                                    r113 = ref$BooleanRef2;
                                                                                    context = context3;
                                                                                    str7 = str6;
                                                                                    file4 = file2;
                                                                                    r22 = r21;
                                                                                    str9 = absolutePath;
                                                                                    r116 = r113;
                                                                                    str8 = str22;
                                                                                    Object[] objArr2 = new Object[0];
                                                                                    Timber.Forest.getClass();
                                                                                    ConnectionPool.e$1(objArr2);
                                                                                    file4 = file4;
                                                                                    r22 = r22;
                                                                                    str9 = str9;
                                                                                    r118 = objArr2;
                                                                                    r117 = r116;
                                                                                    str8 = str8;
                                                                                    backupRestoreViewModel.database.close();
                                                                                    if (r117.element) {
                                                                                        file5 = new File(str7);
                                                                                        file6 = new File(str7 + ".restore_staged");
                                                                                        StringBuilder sb113 = new StringBuilder();
                                                                                        sb113.append(str7);
                                                                                        str12 = ".restore_backup";
                                                                                        sb113.append(".restore_backup");
                                                                                        file7 = new File(sb113.toString());
                                                                                        file6.delete();
                                                                                        file7.delete();
                                                                                        FilesKt.copyTo$default(new File(str9), file6);
                                                                                        RenameTo = file5.renameTo(file7);
                                                                                        if (RenameTo != 0) {
                                                                                            throw new IllegalStateException("Failed to preserve current DB before restore");
                                                                                        }
                                                                                        if (file6.renameTo(file5)) {
                                                                                            file7.renameTo(file5);
                                                                                            throw new IllegalStateException("Failed to promote restored DB");
                                                                                        }
                                                                                        file7.delete();
                                                                                        ?? sb114 = new StringBuilder();
                                                                                        sb114.append(str7);
                                                                                        RenameTo = str5;
                                                                                        sb114.append(RenameTo);
                                                                                        new File(sb114.toString()).delete();
                                                                                        StringBuilder sb115 = new StringBuilder();
                                                                                        sb115.append(str7);
                                                                                        String str27 = str8;
                                                                                        sb115.append(str27);
                                                                                        new File(sb115.toString()).delete();
                                                                                        r120 = RenameTo;
                                                                                        str14 = str27;
                                                                                        Timber.Forest.getClass();
                                                                                        ConnectionPool.e$1(new Object[0]);
                                                                                        z = false;
                                                                                        r119 = RenameTo;
                                                                                        str13 = str12;
                                                                                        if (z) {
                                                                                            DefaultScheduler defaultScheduler18 = Dispatchers.Default;
                                                                                            HandlerContext handlerContext10 = MainDispatcherLoader.dispatcher;
                                                                                            ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$10 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                                                                            this.L$0 = null;
                                                                                            this.L$1 = str9;
                                                                                            this.$cacheKey = file4;
                                                                                            this.L$6 = null;
                                                                                            this.$mediaId = null;
                                                                                            this.$songArtists = null;
                                                                                            this.$songTitle = null;
                                                                                            this.$album = null;
                                                                                            this.L$5 = null;
                                                                                            this.L$9 = null;
                                                                                            this.$duration = i3;
                                                                                            this.label = (byte) 6;
                                                                                            break;
                                                                                        } else {
                                                                                            if (ref$BooleanRef.element) {
                                                                                                FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                                                                            }
                                                                                            File filesDir13 = context.getFilesDir();
                                                                                            filesDir13.getClass();
                                                                                            FilesKt.resolve(filesDir13, "persistent_queue.data").delete();
                                                                                            File filesDir14 = context.getFilesDir();
                                                                                            filesDir14.getClass();
                                                                                            FilesKt.resolve(filesDir14, "persistent_automix.data").delete();
                                                                                            File filesDir15 = context.getFilesDir();
                                                                                            filesDir15.getClass();
                                                                                            FilesKt.resolve(filesDir15, "persistent_player_state.data").delete();
                                                                                            ArtistNameAliases artistNameAliases6 = ArtistNameAliases.INSTANCE;
                                                                                            map = (Map) ref$ObjectRef.element;
                                                                                            if (map == null) {
                                                                                                map = EmptyMap.INSTANCE;
                                                                                            }
                                                                                            artistNameAliases6.restore(context, map);
                                                                                            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                                                                            if (launchIntentForPackage != null) {
                                                                                                launchIntentForPackage.addFlags(268468224);
                                                                                            } else {
                                                                                                launchIntentForPackage = null;
                                                                                            }
                                                                                            context.startActivity(launchIntentForPackage);
                                                                                            Runtime.getRuntime().exit(0);
                                                                                            file8 = file4;
                                                                                            r29 = r22;
                                                                                            str18 = str9;
                                                                                            r121 = r119;
                                                                                            str17 = str13;
                                                                                        }
                                                                                        file8 = file4;
                                                                                        r29 = r22;
                                                                                        str18 = str9;
                                                                                        r121 = r119;
                                                                                        str17 = str13;
                                                                                        r7 = r22;
                                                                                        objCreateFailure = unit;
                                                                                        obj4 = file8;
                                                                                        r9 = r29;
                                                                                        r8 = str18;
                                                                                        r16 = r121;
                                                                                        r15 = str17;
                                                                                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                        r2 = obj4;
                                                                                        r10 = r8;
                                                                                        r18 = r16;
                                                                                        r17 = r15;
                                                                                        if (thM1866exceptionOrNullimpl != null) {
                                                                                            UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                            Timber.Forest.tag("RESTORE");
                                                                                            ConnectionPool.e$1(new Object[0]);
                                                                                            DefaultScheduler defaultScheduler19 = Dispatchers.Default;
                                                                                            handlerContext = MainDispatcherLoader.dispatcher;
                                                                                            contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                            this.L$0 = null;
                                                                                            this.L$1 = r8;
                                                                                            this.$cacheKey = obj4;
                                                                                            this.L$6 = objCreateFailure;
                                                                                            this.$mediaId = null;
                                                                                            this.$songArtists = null;
                                                                                            this.$songTitle = null;
                                                                                            this.$album = null;
                                                                                            this.L$5 = null;
                                                                                            this.L$9 = null;
                                                                                            this.label = (byte) 7;
                                                                                            if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                                r7 = r9;
                                                                                                obj5 = obj4;
                                                                                                r1 = r8;
                                                                                                r110 = r16;
                                                                                                r19 = r15;
                                                                                                r2 = obj5;
                                                                                                r10 = r1;
                                                                                                r18 = r110;
                                                                                                r17 = r19;
                                                                                            }
                                                                                            r7 = r21;
                                                                                            file8 = file4;
                                                                                            r29 = r22;
                                                                                            str18 = str9;
                                                                                            r121 = r119;
                                                                                            str17 = str13;
                                                                                            r7 = r22;
                                                                                            r7 = r9;
                                                                                            return r7;
                                                                                        }
                                                                                        new File((String) r10).delete();
                                                                                        ?? sb116 = new StringBuilder();
                                                                                        sb116.append(r10);
                                                                                        sb116.append(r18);
                                                                                        new File(sb116.toString()).delete();
                                                                                        ?? sb117 = new StringBuilder();
                                                                                        sb117.append(r10);
                                                                                        sb117.append(r17);
                                                                                        new File(sb117.toString()).delete();
                                                                                        r2.delete();
                                                                                        r7 = r21;
                                                                                        return unit;
                                                                                    }
                                                                                    str14 = str8;
                                                                                    r120 = str5;
                                                                                    z = true;
                                                                                    r119 = r120;
                                                                                    str13 = str14;
                                                                                    if (z) {
                                                                                        DefaultScheduler defaultScheduler110 = Dispatchers.Default;
                                                                                        HandlerContext handlerContext11 = MainDispatcherLoader.dispatcher;
                                                                                        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$11 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                                                                        this.L$0 = null;
                                                                                        this.L$1 = str9;
                                                                                        this.$cacheKey = file4;
                                                                                        this.L$6 = null;
                                                                                        this.$mediaId = null;
                                                                                        this.$songArtists = null;
                                                                                        this.$songTitle = null;
                                                                                        this.$album = null;
                                                                                        this.L$5 = null;
                                                                                        this.L$9 = null;
                                                                                        this.$duration = i3;
                                                                                        this.label = (byte) 6;
                                                                                        break;
                                                                                    } else {
                                                                                        if (ref$BooleanRef.element) {
                                                                                            FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                                                                        }
                                                                                        File filesDir16 = context.getFilesDir();
                                                                                        filesDir16.getClass();
                                                                                        FilesKt.resolve(filesDir16, "persistent_queue.data").delete();
                                                                                        File filesDir17 = context.getFilesDir();
                                                                                        filesDir17.getClass();
                                                                                        FilesKt.resolve(filesDir17, "persistent_automix.data").delete();
                                                                                        File filesDir18 = context.getFilesDir();
                                                                                        filesDir18.getClass();
                                                                                        FilesKt.resolve(filesDir18, "persistent_player_state.data").delete();
                                                                                        ArtistNameAliases artistNameAliases7 = ArtistNameAliases.INSTANCE;
                                                                                        map = (Map) ref$ObjectRef.element;
                                                                                        if (map == null) {
                                                                                            map = EmptyMap.INSTANCE;
                                                                                        }
                                                                                        artistNameAliases7.restore(context, map);
                                                                                        launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                                                                        if (launchIntentForPackage != null) {
                                                                                            launchIntentForPackage.addFlags(268468224);
                                                                                        } else {
                                                                                            launchIntentForPackage = null;
                                                                                        }
                                                                                        context.startActivity(launchIntentForPackage);
                                                                                        Runtime.getRuntime().exit(0);
                                                                                        file8 = file4;
                                                                                        r29 = r22;
                                                                                        str18 = str9;
                                                                                        r121 = r119;
                                                                                        str17 = str13;
                                                                                    }
                                                                                    file8 = file4;
                                                                                    r29 = r22;
                                                                                    str18 = str9;
                                                                                    r121 = r119;
                                                                                    str17 = str13;
                                                                                    r7 = r22;
                                                                                    objCreateFailure = unit;
                                                                                    obj4 = file8;
                                                                                    r9 = r29;
                                                                                    r8 = str18;
                                                                                    r16 = r121;
                                                                                    r15 = str17;
                                                                                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                                    r2 = obj4;
                                                                                    r10 = r8;
                                                                                    r18 = r16;
                                                                                    r17 = r15;
                                                                                    if (thM1866exceptionOrNullimpl != null) {
                                                                                        UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                        Timber.Forest.tag("RESTORE");
                                                                                        ConnectionPool.e$1(new Object[0]);
                                                                                        DefaultScheduler defaultScheduler111 = Dispatchers.Default;
                                                                                        handlerContext = MainDispatcherLoader.dispatcher;
                                                                                        contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                        this.L$0 = null;
                                                                                        this.L$1 = r8;
                                                                                        this.$cacheKey = obj4;
                                                                                        this.L$6 = objCreateFailure;
                                                                                        this.$mediaId = null;
                                                                                        this.$songArtists = null;
                                                                                        this.$songTitle = null;
                                                                                        this.$album = null;
                                                                                        this.L$5 = null;
                                                                                        this.L$9 = null;
                                                                                        this.label = (byte) 7;
                                                                                        if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                            r7 = r9;
                                                                                            obj5 = obj4;
                                                                                            r1 = r8;
                                                                                            r110 = r16;
                                                                                            r19 = r15;
                                                                                            r2 = obj5;
                                                                                            r10 = r1;
                                                                                            r18 = r110;
                                                                                            r17 = r19;
                                                                                        }
                                                                                        r7 = r21;
                                                                                        file8 = file4;
                                                                                        r29 = r22;
                                                                                        str18 = str9;
                                                                                        r121 = r119;
                                                                                        str17 = str13;
                                                                                        r7 = r22;
                                                                                        r7 = r9;
                                                                                        return r7;
                                                                                    }
                                                                                    new File((String) r10).delete();
                                                                                    ?? sb118 = new StringBuilder();
                                                                                    sb118.append(r10);
                                                                                    sb118.append(r18);
                                                                                    new File(sb118.toString()).delete();
                                                                                    ?? sb119 = new StringBuilder();
                                                                                    sb119.append(r10);
                                                                                    sb119.append(r17);
                                                                                    new File(sb119.toString()).delete();
                                                                                    r2.delete();
                                                                                    r7 = r21;
                                                                                    return unit;
                                                                                }
                                                                                c01441 = new DiscordRpcManager.C01441();
                                                                                this.L$0 = null;
                                                                                this.L$1 = absolutePath;
                                                                                this.$cacheKey = file9;
                                                                                this.L$6 = backupRestoreViewModel;
                                                                                this.$mediaId = context3;
                                                                                this.$songArtists = r213;
                                                                                str6 = str24;
                                                                            } catch (Exception unused10) {
                                                                                str6 = str24;
                                                                            }
                                                                            context3.stopService(new Intent(context3, (Class<?>) MusicService.class));
                                                                        } catch (Throwable th20) {
                                                                            th = th20;
                                                                            r112 = str22;
                                                                            r111 = str5;
                                                                            r11 = r21;
                                                                            obj3 = file9;
                                                                            r4 = r11;
                                                                            r6 = absolutePath;
                                                                            r13 = r111;
                                                                            r14 = r112;
                                                                            objCreateFailure = ResultKt.createFailure(th);
                                                                            obj4 = obj3;
                                                                            r9 = r4;
                                                                            r8 = r6;
                                                                            r16 = r13;
                                                                            r15 = r14;
                                                                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                            r2 = obj4;
                                                                            r10 = r8;
                                                                            r18 = r16;
                                                                            r17 = r15;
                                                                            if (thM1866exceptionOrNullimpl != null) {
                                                                                UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                                Timber.Forest.tag("RESTORE");
                                                                                ConnectionPool.e$1(new Object[0]);
                                                                                DefaultScheduler defaultScheduler112 = Dispatchers.Default;
                                                                                handlerContext = MainDispatcherLoader.dispatcher;
                                                                                contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                                this.L$0 = null;
                                                                                this.L$1 = r8;
                                                                                this.$cacheKey = obj4;
                                                                                this.L$6 = objCreateFailure;
                                                                                this.$mediaId = null;
                                                                                this.$songArtists = null;
                                                                                this.$songTitle = null;
                                                                                this.$album = null;
                                                                                this.L$5 = null;
                                                                                this.L$9 = null;
                                                                                this.label = (byte) 7;
                                                                                if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                    r7 = r9;
                                                                                    obj5 = obj4;
                                                                                    r1 = r8;
                                                                                    r110 = r16;
                                                                                    r19 = r15;
                                                                                    r2 = obj5;
                                                                                    r10 = r1;
                                                                                    r18 = r110;
                                                                                    r17 = r19;
                                                                                }
                                                                                r7 = r21;
                                                                                file8 = file4;
                                                                                r29 = r22;
                                                                                str18 = str9;
                                                                                r121 = r119;
                                                                                str17 = str13;
                                                                                r7 = r22;
                                                                                r7 = r9;
                                                                                return r7;
                                                                            }
                                                                            new File((String) r10).delete();
                                                                            ?? sb1110 = new StringBuilder();
                                                                            sb1110.append(r10);
                                                                            sb1110.append(r18);
                                                                            new File(sb1110.toString()).delete();
                                                                            ?? sb1111 = new StringBuilder();
                                                                            sb1111.append(r10);
                                                                            sb1111.append(r17);
                                                                            new File(sb1111.toString()).delete();
                                                                            r2.delete();
                                                                            r7 = r21;
                                                                            return unit;
                                                                        }
                                                                        i3 = i;
                                                                        break;
                                                                    } catch (Throwable th21) {
                                                                        th = th21;
                                                                        r20 = r214;
                                                                        file = file9;
                                                                        r23 = r20;
                                                                        str11 = absolutePath;
                                                                        str10 = str22;
                                                                        r14 = str10;
                                                                        r13 = str5;
                                                                        obj3 = file;
                                                                        r4 = r23;
                                                                        r6 = str11;
                                                                        objCreateFailure = ResultKt.createFailure(th);
                                                                        obj4 = obj3;
                                                                        r9 = r4;
                                                                        r8 = r6;
                                                                        r16 = r13;
                                                                        r15 = r14;
                                                                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                                        r2 = obj4;
                                                                        r10 = r8;
                                                                        r18 = r16;
                                                                        r17 = r15;
                                                                        if (thM1866exceptionOrNullimpl != null) {
                                                                            UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                                            Timber.Forest.tag("RESTORE");
                                                                            ConnectionPool.e$1(new Object[0]);
                                                                            DefaultScheduler defaultScheduler113 = Dispatchers.Default;
                                                                            handlerContext = MainDispatcherLoader.dispatcher;
                                                                            contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                                            this.L$0 = null;
                                                                            this.L$1 = r8;
                                                                            this.$cacheKey = obj4;
                                                                            this.L$6 = objCreateFailure;
                                                                            this.$mediaId = null;
                                                                            this.$songArtists = null;
                                                                            this.$songTitle = null;
                                                                            this.$album = null;
                                                                            this.L$5 = null;
                                                                            this.L$9 = null;
                                                                            this.label = (byte) 7;
                                                                            if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                                                r7 = r9;
                                                                                obj5 = obj4;
                                                                                r1 = r8;
                                                                                r110 = r16;
                                                                                r19 = r15;
                                                                                r2 = obj5;
                                                                                r10 = r1;
                                                                                r18 = r110;
                                                                                r17 = r19;
                                                                            }
                                                                            r7 = r21;
                                                                            file8 = file4;
                                                                            r29 = r22;
                                                                            str18 = str9;
                                                                            r121 = r119;
                                                                            str17 = str13;
                                                                            r7 = r22;
                                                                            r7 = r9;
                                                                            return r7;
                                                                        }
                                                                        new File((String) r10).delete();
                                                                        ?? sb1112 = new StringBuilder();
                                                                        sb1112.append(r10);
                                                                        sb1112.append(r18);
                                                                        new File(sb1112.toString()).delete();
                                                                        ?? sb1113 = new StringBuilder();
                                                                        sb1113.append(r10);
                                                                        sb1113.append(r17);
                                                                        new File(sb1113.toString()).delete();
                                                                        r2.delete();
                                                                        r7 = r21;
                                                                        return unit;
                                                                    }
                                                                    r7 = r21;
                                                                    file8 = file4;
                                                                    r29 = r22;
                                                                    str18 = str9;
                                                                    r121 = r119;
                                                                    str17 = str13;
                                                                    r7 = r22;
                                                                    r7 = r9;
                                                                    return r7;
                                                                } catch (Throwable th22) {
                                                                    th = th22;
                                                                    r112 = str22;
                                                                    r111 = str5;
                                                                    r11 = r214;
                                                                }
                                                            } catch (Throwable th23) {
                                                                th = th23;
                                                                str3 = str5;
                                                                r12 = r214;
                                                                th = th;
                                                                r30 = r12;
                                                                r122 = str3;
                                                                ref$BooleanRef2 = str22;
                                                                throw th;
                                                            }
                                                        } catch (Throwable th24) {
                                                            th = th24;
                                                            r12 = r122;
                                                            str3 = "-wal";
                                                        }
                                                    } else {
                                                        connectionPool.tag("RESTORE");
                                                        uri.toString();
                                                        ConnectionPool.e(new Object[0]);
                                                    }
                                                } catch (Throwable th25) {
                                                    th = th25;
                                                    r11 = r30;
                                                    r111 = r122;
                                                    r112 = ref$BooleanRef2;
                                                    obj3 = file9;
                                                    r4 = r11;
                                                    r6 = absolutePath;
                                                    r13 = r111;
                                                    r14 = r112;
                                                    objCreateFailure = ResultKt.createFailure(th);
                                                    obj4 = obj3;
                                                    r9 = r4;
                                                    r8 = r6;
                                                    r16 = r13;
                                                    r15 = r14;
                                                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                    r2 = obj4;
                                                    r10 = r8;
                                                    r18 = r16;
                                                    r17 = r15;
                                                    if (thM1866exceptionOrNullimpl != null) {
                                                        UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                        Timber.Forest.tag("RESTORE");
                                                        ConnectionPool.e$1(new Object[0]);
                                                        DefaultScheduler defaultScheduler114 = Dispatchers.Default;
                                                        handlerContext = MainDispatcherLoader.dispatcher;
                                                        contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                        this.L$0 = null;
                                                        this.L$1 = r8;
                                                        this.$cacheKey = obj4;
                                                        this.L$6 = objCreateFailure;
                                                        this.$mediaId = null;
                                                        this.$songArtists = null;
                                                        this.$songTitle = null;
                                                        this.$album = null;
                                                        this.L$5 = null;
                                                        this.L$9 = null;
                                                        this.label = (byte) 7;
                                                        if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                            r7 = r9;
                                                            obj5 = obj4;
                                                            r1 = r8;
                                                            r110 = r16;
                                                            r19 = r15;
                                                            r2 = obj5;
                                                            r10 = r1;
                                                            r18 = r110;
                                                            r17 = r19;
                                                        }
                                                        r7 = r21;
                                                        file8 = file4;
                                                        r29 = r22;
                                                        str18 = str9;
                                                        r121 = r119;
                                                        str17 = str13;
                                                        r7 = r22;
                                                        r7 = r9;
                                                        return r7;
                                                    }
                                                    new File((String) r10).delete();
                                                    ?? sb1114 = new StringBuilder();
                                                    sb1114.append(r10);
                                                    sb1114.append(r18);
                                                    new File(sb1114.toString()).delete();
                                                    ?? sb1115 = new StringBuilder();
                                                    sb1115.append(r10);
                                                    sb1115.append(r17);
                                                    new File(sb1115.toString()).delete();
                                                    r2.delete();
                                                    r7 = r21;
                                                    return unit;
                                                }
                                            } catch (Throwable th26) {
                                                th = th26;
                                                str = str22;
                                                r111 = "-wal";
                                                r11 = r122;
                                                r112 = str;
                                                obj3 = file9;
                                                r4 = r11;
                                                r6 = absolutePath;
                                                r13 = r111;
                                                r14 = r112;
                                                objCreateFailure = ResultKt.createFailure(th);
                                                obj4 = obj3;
                                                r9 = r4;
                                                r8 = r6;
                                                r16 = r13;
                                                r15 = r14;
                                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                                r2 = obj4;
                                                r10 = r8;
                                                r18 = r16;
                                                r17 = r15;
                                                if (thM1866exceptionOrNullimpl != null) {
                                                    UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                                    Timber.Forest.tag("RESTORE");
                                                    ConnectionPool.e$1(new Object[0]);
                                                    DefaultScheduler defaultScheduler115 = Dispatchers.Default;
                                                    handlerContext = MainDispatcherLoader.dispatcher;
                                                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                                    this.L$0 = null;
                                                    this.L$1 = r8;
                                                    this.$cacheKey = obj4;
                                                    this.L$6 = objCreateFailure;
                                                    this.$mediaId = null;
                                                    this.$songArtists = null;
                                                    this.$songTitle = null;
                                                    this.$album = null;
                                                    this.L$5 = null;
                                                    this.L$9 = null;
                                                    this.label = (byte) 7;
                                                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                                        r7 = r9;
                                                        obj5 = obj4;
                                                        r1 = r8;
                                                        r110 = r16;
                                                        r19 = r15;
                                                        r2 = obj5;
                                                        r10 = r1;
                                                        r18 = r110;
                                                        r17 = r19;
                                                    }
                                                    r7 = r21;
                                                    file8 = file4;
                                                    r29 = r22;
                                                    str18 = str9;
                                                    r121 = r119;
                                                    str17 = str13;
                                                    r7 = r22;
                                                    r7 = r9;
                                                    return r7;
                                                }
                                                new File((String) r10).delete();
                                                ?? sb1116 = new StringBuilder();
                                                sb1116.append(r10);
                                                sb1116.append(r18);
                                                new File(sb1116.toString()).delete();
                                                ?? sb1117 = new StringBuilder();
                                                sb1117.append(r10);
                                                sb1117.append(r17);
                                                new File(sb1117.toString()).delete();
                                                r2.delete();
                                                r7 = r21;
                                                return unit;
                                            }
                                        }
                                    } catch (Throwable th27) {
                                        th = th27;
                                        str = "-shm";
                                    }
                                } catch (Throwable th28) {
                                    th = th28;
                                    str = str20;
                                    r111 = "-wal";
                                    r11 = r122;
                                    r112 = str;
                                    obj3 = file9;
                                    r4 = r11;
                                    r6 = absolutePath;
                                    r13 = r111;
                                    r14 = r112;
                                    objCreateFailure = ResultKt.createFailure(th);
                                    obj4 = obj3;
                                    r9 = r4;
                                    r8 = r6;
                                    r16 = r13;
                                    r15 = r14;
                                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                    r2 = obj4;
                                    r10 = r8;
                                    r18 = r16;
                                    r17 = r15;
                                    if (thM1866exceptionOrNullimpl != null) {
                                        UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                        Timber.Forest.tag("RESTORE");
                                        ConnectionPool.e$1(new Object[0]);
                                        DefaultScheduler defaultScheduler116 = Dispatchers.Default;
                                        handlerContext = MainDispatcherLoader.dispatcher;
                                        contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                        this.L$0 = null;
                                        this.L$1 = r8;
                                        this.$cacheKey = obj4;
                                        this.L$6 = objCreateFailure;
                                        this.$mediaId = null;
                                        this.$songArtists = null;
                                        this.$songTitle = null;
                                        this.$album = null;
                                        this.L$5 = null;
                                        this.L$9 = null;
                                        this.label = (byte) 7;
                                        if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                            r7 = r9;
                                            obj5 = obj4;
                                            r1 = r8;
                                            r110 = r16;
                                            r19 = r15;
                                            r2 = obj5;
                                            r10 = r1;
                                            r18 = r110;
                                            r17 = r19;
                                        }
                                        r7 = r21;
                                        file8 = file4;
                                        r29 = r22;
                                        str18 = str9;
                                        r121 = r119;
                                        str17 = str13;
                                        r7 = r22;
                                        r7 = r9;
                                        return r7;
                                    }
                                    new File((String) r10).delete();
                                    ?? sb1118 = new StringBuilder();
                                    sb1118.append(r10);
                                    sb1118.append(r18);
                                    new File(sb1118.toString()).delete();
                                    ?? sb1119 = new StringBuilder();
                                    sb1119.append(r10);
                                    sb1119.append(r17);
                                    new File(sb1119.toString()).delete();
                                    r2.delete();
                                    r7 = r21;
                                    return unit;
                                }
                            } catch (Throwable th29) {
                                th = th29;
                                unit = unit2;
                            }
                            r7 = r21;
                            return unit;
                        case 1:
                            String str28 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            return unit2;
                        case 2:
                            String str29 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            return unit2;
                        case 3:
                            String str30 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            return unit2;
                        case 4:
                            i3 = this.$duration;
                            Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) this.L$9;
                            Ref$BooleanRef ref$BooleanRef3 = (Ref$BooleanRef) this.L$5;
                            Ref$BooleanRef ref$BooleanRef4 = (Ref$BooleanRef) this.$album;
                            str7 = this.$songTitle;
                            context2 = (Context) this.$mediaId;
                            backupRestoreViewModel2 = (BackupRestoreViewModel) this.L$6;
                            file3 = (File) this.$cacheKey;
                            String str31 = this.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                str2 = "datastore/settings.preferences_pb";
                                str15 = "-shm";
                                str5 = "-wal";
                                ref$ObjectRef = ref$ObjectRef2;
                                unit = unit2;
                                ref$BooleanRef = ref$BooleanRef3;
                                str16 = str31;
                                r28 = r122;
                                r114 = r122;
                                r115 = ref$BooleanRef4;
                                Context context6 = context2;
                                ref$ObjectRef = ref$ObjectRef;
                                file4 = file3;
                                backupRestoreViewModel = backupRestoreViewModel2;
                                context = context6;
                                r22 = r28;
                                str9 = str16;
                                r118 = r114;
                                r117 = r115;
                                str8 = str15;
                            } catch (Exception unused11) {
                                str2 = "datastore/settings.preferences_pb";
                                str8 = "-shm";
                                str5 = "-wal";
                                file4 = file3;
                                backupRestoreViewModel = backupRestoreViewModel2;
                                context = context2;
                                ref$ObjectRef = ref$ObjectRef2;
                                unit = unit2;
                                ref$BooleanRef = ref$BooleanRef3;
                                str9 = str31;
                                r22 = r122;
                                r116 = ref$BooleanRef4;
                                Object[] objArr3 = new Object[0];
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(objArr3);
                                file4 = file4;
                                r22 = r22;
                                str9 = str9;
                                r118 = objArr3;
                                r117 = r116;
                                str8 = str8;
                            } catch (Throwable th30) {
                                th = th30;
                                r5 = str31;
                                unit = unit2;
                                obj2 = file3;
                                r4 = r122;
                                r13 = "-wal";
                                obj3 = obj2;
                                r6 = r5;
                                r14 = str20;
                                objCreateFailure = ResultKt.createFailure(th);
                                obj4 = obj3;
                                r9 = r4;
                                r8 = r6;
                                r16 = r13;
                                r15 = r14;
                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                r2 = obj4;
                                r10 = r8;
                                r18 = r16;
                                r17 = r15;
                                if (thM1866exceptionOrNullimpl != null) {
                                    UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                    Timber.Forest.tag("RESTORE");
                                    ConnectionPool.e$1(new Object[0]);
                                    DefaultScheduler defaultScheduler117 = Dispatchers.Default;
                                    handlerContext = MainDispatcherLoader.dispatcher;
                                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                    this.L$0 = null;
                                    this.L$1 = r8;
                                    this.$cacheKey = obj4;
                                    this.L$6 = objCreateFailure;
                                    this.$mediaId = null;
                                    this.$songArtists = null;
                                    this.$songTitle = null;
                                    this.$album = null;
                                    this.L$5 = null;
                                    this.L$9 = null;
                                    this.label = (byte) 7;
                                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                        r7 = r9;
                                        obj5 = obj4;
                                        r1 = r8;
                                        r110 = r16;
                                        r19 = r15;
                                        r2 = obj5;
                                        r10 = r1;
                                        r18 = r110;
                                        r17 = r19;
                                    }
                                    r7 = r21;
                                    file8 = file4;
                                    r29 = r22;
                                    str18 = str9;
                                    r121 = r119;
                                    str17 = str13;
                                    r7 = r22;
                                    r7 = r9;
                                    return r7;
                                }
                                new File((String) r10).delete();
                                ?? sb11110 = new StringBuilder();
                                sb11110.append(r10);
                                sb11110.append(r18);
                                new File(sb11110.toString()).delete();
                                ?? sb11111 = new StringBuilder();
                                sb11111.append(r10);
                                sb11111.append(r17);
                                new File(sb11111.toString()).delete();
                                r2.delete();
                                r7 = r21;
                                return unit;
                            }
                            backupRestoreViewModel.database.close();
                            if (r117.element) {
                                file5 = new File(str7);
                                file6 = new File(str7 + ".restore_staged");
                                StringBuilder sb1120 = new StringBuilder();
                                sb1120.append(str7);
                                str12 = ".restore_backup";
                                sb1120.append(".restore_backup");
                                file7 = new File(sb1120.toString());
                                file6.delete();
                                file7.delete();
                                FilesKt.copyTo$default(new File(str9), file6);
                                RenameTo = file5.renameTo(file7);
                                if (RenameTo != 0) {
                                    throw new IllegalStateException("Failed to preserve current DB before restore");
                                }
                                if (file6.renameTo(file5)) {
                                    file7.renameTo(file5);
                                    throw new IllegalStateException("Failed to promote restored DB");
                                }
                                file7.delete();
                                ?? sb1121 = new StringBuilder();
                                sb1121.append(str7);
                                RenameTo = str5;
                                sb1121.append(RenameTo);
                                new File(sb1121.toString()).delete();
                                StringBuilder sb1122 = new StringBuilder();
                                sb1122.append(str7);
                                String str210 = str8;
                                sb1122.append(str210);
                                new File(sb1122.toString()).delete();
                                r120 = RenameTo;
                                str14 = str210;
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                                z = false;
                                r119 = RenameTo;
                                str13 = str12;
                                if (z) {
                                    DefaultScheduler defaultScheduler118 = Dispatchers.Default;
                                    HandlerContext handlerContext12 = MainDispatcherLoader.dispatcher;
                                    ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$12 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                    this.L$0 = null;
                                    this.L$1 = str9;
                                    this.$cacheKey = file4;
                                    this.L$6 = null;
                                    this.$mediaId = null;
                                    this.$songArtists = null;
                                    this.$songTitle = null;
                                    this.$album = null;
                                    this.L$5 = null;
                                    this.L$9 = null;
                                    this.$duration = i3;
                                    this.label = (byte) 6;
                                    break;
                                } else {
                                    if (ref$BooleanRef.element) {
                                        FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                    }
                                    File filesDir19 = context.getFilesDir();
                                    filesDir19.getClass();
                                    FilesKt.resolve(filesDir19, "persistent_queue.data").delete();
                                    File filesDir110 = context.getFilesDir();
                                    filesDir110.getClass();
                                    FilesKt.resolve(filesDir110, "persistent_automix.data").delete();
                                    File filesDir111 = context.getFilesDir();
                                    filesDir111.getClass();
                                    FilesKt.resolve(filesDir111, "persistent_player_state.data").delete();
                                    ArtistNameAliases artistNameAliases8 = ArtistNameAliases.INSTANCE;
                                    map = (Map) ref$ObjectRef.element;
                                    if (map == null) {
                                        map = EmptyMap.INSTANCE;
                                    }
                                    artistNameAliases8.restore(context, map);
                                    launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                    if (launchIntentForPackage != null) {
                                        launchIntentForPackage.addFlags(268468224);
                                    } else {
                                        launchIntentForPackage = null;
                                    }
                                    context.startActivity(launchIntentForPackage);
                                    Runtime.getRuntime().exit(0);
                                    file8 = file4;
                                    r29 = r22;
                                    str18 = str9;
                                    r121 = r119;
                                    str17 = str13;
                                }
                                file8 = file4;
                                r29 = r22;
                                str18 = str9;
                                r121 = r119;
                                str17 = str13;
                                r7 = r22;
                                objCreateFailure = unit;
                                obj4 = file8;
                                r9 = r29;
                                r8 = str18;
                                r16 = r121;
                                r15 = str17;
                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                                r2 = obj4;
                                r10 = r8;
                                r18 = r16;
                                r17 = r15;
                                if (thM1866exceptionOrNullimpl != null) {
                                    UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                    Timber.Forest.tag("RESTORE");
                                    ConnectionPool.e$1(new Object[0]);
                                    DefaultScheduler defaultScheduler119 = Dispatchers.Default;
                                    handlerContext = MainDispatcherLoader.dispatcher;
                                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                    this.L$0 = null;
                                    this.L$1 = r8;
                                    this.$cacheKey = obj4;
                                    this.L$6 = objCreateFailure;
                                    this.$mediaId = null;
                                    this.$songArtists = null;
                                    this.$songTitle = null;
                                    this.$album = null;
                                    this.L$5 = null;
                                    this.L$9 = null;
                                    this.label = (byte) 7;
                                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                        r7 = r9;
                                        obj5 = obj4;
                                        r1 = r8;
                                        r110 = r16;
                                        r19 = r15;
                                        r2 = obj5;
                                        r10 = r1;
                                        r18 = r110;
                                        r17 = r19;
                                    }
                                    r7 = r21;
                                    file8 = file4;
                                    r29 = r22;
                                    str18 = str9;
                                    r121 = r119;
                                    str17 = str13;
                                    r7 = r22;
                                    r7 = r9;
                                    return r7;
                                }
                                new File((String) r10).delete();
                                ?? sb11112 = new StringBuilder();
                                sb11112.append(r10);
                                sb11112.append(r18);
                                new File(sb11112.toString()).delete();
                                ?? sb11113 = new StringBuilder();
                                sb11113.append(r10);
                                sb11113.append(r17);
                                new File(sb11113.toString()).delete();
                                r2.delete();
                                r7 = r21;
                                return unit;
                            }
                            str14 = str8;
                            r120 = str5;
                            z = true;
                            r119 = r120;
                            str13 = str14;
                            if (z) {
                                DefaultScheduler defaultScheduler1110 = Dispatchers.Default;
                                HandlerContext handlerContext13 = MainDispatcherLoader.dispatcher;
                                ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$13 = new ContextExtKt$isSyncEnabled$1(context, null, (byte) 12);
                                this.L$0 = null;
                                this.L$1 = str9;
                                this.$cacheKey = file4;
                                this.L$6 = null;
                                this.$mediaId = null;
                                this.$songArtists = null;
                                this.$songTitle = null;
                                this.$album = null;
                                this.L$5 = null;
                                this.L$9 = null;
                                this.$duration = i3;
                                this.label = (byte) 6;
                                break;
                            } else {
                                if (ref$BooleanRef.element) {
                                    FilesKt.copyTo$default(file4, new File(context.getFilesDir(), str2));
                                }
                                File filesDir112 = context.getFilesDir();
                                filesDir112.getClass();
                                FilesKt.resolve(filesDir112, "persistent_queue.data").delete();
                                File filesDir113 = context.getFilesDir();
                                filesDir113.getClass();
                                FilesKt.resolve(filesDir113, "persistent_automix.data").delete();
                                File filesDir114 = context.getFilesDir();
                                filesDir114.getClass();
                                FilesKt.resolve(filesDir114, "persistent_player_state.data").delete();
                                ArtistNameAliases artistNameAliases9 = ArtistNameAliases.INSTANCE;
                                map = (Map) ref$ObjectRef.element;
                                if (map == null) {
                                    map = EmptyMap.INSTANCE;
                                }
                                artistNameAliases9.restore(context, map);
                                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                if (launchIntentForPackage != null) {
                                    launchIntentForPackage.addFlags(268468224);
                                } else {
                                    launchIntentForPackage = null;
                                }
                                context.startActivity(launchIntentForPackage);
                                Runtime.getRuntime().exit(0);
                                file8 = file4;
                                r29 = r22;
                                str18 = str9;
                                r121 = r119;
                                str17 = str13;
                            }
                            file8 = file4;
                            r29 = r22;
                            str18 = str9;
                            r121 = r119;
                            str17 = str13;
                            r7 = r22;
                            objCreateFailure = unit;
                            obj4 = file8;
                            r9 = r29;
                            r8 = str18;
                            r16 = r121;
                            r15 = str17;
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                            r2 = obj4;
                            r10 = r8;
                            r18 = r16;
                            r17 = r15;
                            if (thM1866exceptionOrNullimpl != null) {
                                UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                Timber.Forest.tag("RESTORE");
                                ConnectionPool.e$1(new Object[0]);
                                DefaultScheduler defaultScheduler1111 = Dispatchers.Default;
                                handlerContext = MainDispatcherLoader.dispatcher;
                                contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                this.L$0 = null;
                                this.L$1 = r8;
                                this.$cacheKey = obj4;
                                this.L$6 = objCreateFailure;
                                this.$mediaId = null;
                                this.$songArtists = null;
                                this.$songTitle = null;
                                this.$album = null;
                                this.L$5 = null;
                                this.L$9 = null;
                                this.label = (byte) 7;
                                if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                    r7 = r9;
                                    obj5 = obj4;
                                    r1 = r8;
                                    r110 = r16;
                                    r19 = r15;
                                    r2 = obj5;
                                    r10 = r1;
                                    r18 = r110;
                                    r17 = r19;
                                }
                                r7 = r21;
                                file8 = file4;
                                r29 = r22;
                                str18 = str9;
                                r121 = r119;
                                str17 = str13;
                                r7 = r22;
                                r7 = r9;
                                return r7;
                            }
                            new File((String) r10).delete();
                            ?? sb11114 = new StringBuilder();
                            sb11114.append(r10);
                            sb11114.append(r18);
                            new File(sb11114.toString()).delete();
                            ?? sb11115 = new StringBuilder();
                            sb11115.append(r10);
                            sb11115.append(r17);
                            new File(sb11115.toString()).delete();
                            r2.delete();
                            r7 = r21;
                            return unit;
                        case 5:
                            String str32 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            return unit2;
                        case 6:
                            File file10 = (File) this.$cacheKey;
                            String str33 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            str18 = str33;
                            str17 = "-shm";
                            unit = unit2;
                            r29 = r122;
                            r121 = "-wal";
                            file8 = file10;
                            file8 = file4;
                            r29 = r22;
                            str18 = str9;
                            r121 = r119;
                            str17 = str13;
                            r7 = r22;
                            objCreateFailure = unit;
                            obj4 = file8;
                            r9 = r29;
                            r8 = str18;
                            r16 = r121;
                            r15 = str17;
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCreateFailure);
                            r2 = obj4;
                            r10 = r8;
                            r18 = r16;
                            r17 = r15;
                            if (thM1866exceptionOrNullimpl != null) {
                                UtilsKt.reportException(thM1866exceptionOrNullimpl);
                                Timber.Forest.tag("RESTORE");
                                ConnectionPool.e$1(new Object[0]);
                                DefaultScheduler defaultScheduler1112 = Dispatchers.Default;
                                handlerContext = MainDispatcherLoader.dispatcher;
                                contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context3, null, (byte) 13);
                                this.L$0 = null;
                                this.L$1 = r8;
                                this.$cacheKey = obj4;
                                this.L$6 = objCreateFailure;
                                this.$mediaId = null;
                                this.$songArtists = null;
                                this.$songTitle = null;
                                this.$album = null;
                                this.L$5 = null;
                                this.L$9 = null;
                                this.label = (byte) 7;
                                if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != r9) {
                                    r7 = r9;
                                    obj5 = obj4;
                                    r1 = r8;
                                    r110 = r16;
                                    r19 = r15;
                                    r2 = obj5;
                                    r10 = r1;
                                    r18 = r110;
                                    r17 = r19;
                                }
                                r7 = r21;
                                file8 = file4;
                                r29 = r22;
                                str18 = str9;
                                r121 = r119;
                                str17 = str13;
                                r7 = r22;
                                r7 = r9;
                                return r7;
                            }
                            new File((String) r10).delete();
                            ?? sb11116 = new StringBuilder();
                            sb11116.append(r10);
                            sb11116.append(r18);
                            new File(sb11116.toString()).delete();
                            ?? sb11117 = new StringBuilder();
                            sb11117.append(r10);
                            sb11117.append(r17);
                            new File(sb11117.toString()).delete();
                            r2.delete();
                            r7 = r21;
                            return unit;
                        case 7:
                            File file11 = (File) this.$cacheKey;
                            String str34 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            r19 = "-shm";
                            r110 = "-wal";
                            unit = unit2;
                            obj5 = file11;
                            r1 = str34;
                            r2 = obj5;
                            r10 = r1;
                            r18 = r110;
                            r17 = r19;
                            new File((String) r10).delete();
                            ?? sb11118 = new StringBuilder();
                            sb11118.append(r10);
                            sb11118.append(r18);
                            new File(sb11118.toString()).delete();
                            ?? sb11119 = new StringBuilder();
                            sb11119.append(r10);
                            sb11119.append(r17);
                            new File(sb11119.toString()).delete();
                            r2.delete();
                            r7 = r21;
                            return unit;
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } catch (Throwable th31) {
                    th = th31;
                    r5 = r30;
                    unit = unit2;
                    obj2 = str19;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsHelper$getAllLyrics$3(Context context, Uri uri, BackupRestoreViewModel backupRestoreViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = context;
        this.$allResult = uri;
        this.$callback = backupRestoreViewModel;
    }
}
