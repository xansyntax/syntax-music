package com.metrolist.music.viewmodels;

import com.metrolist.music.lyrics.LyricsEntry;
import com.metrolist.music.lyrics.LyricsUtils;
import com.metrolist.music.lyrics.WordTimestamp;
import com.metrolist.music.ui.component.LyricsListItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsViewModel$processLyrics$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ List $enabledLanguages;
    public final /* synthetic */ String $lyrics;
    public final /* synthetic */ boolean $romanizeCyrillicByLine;
    public final /* synthetic */ boolean $showIntervalIndicator;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ LyricsViewModel this$0;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LyricsViewModel$processLyrics$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ List $enabledLanguages;
        public final /* synthetic */ String $lyrics;
        public final /* synthetic */ List $processedLines;
        public final /* synthetic */ boolean $romanizeCyrillicByLine;
        public String L$1;
        public List L$2;
        public Iterator L$3;
        public MutableStateFlow L$6;
        public boolean Z$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, String str, List list2, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$processedLines = list;
            this.$lyrics = str;
            this.$enabledLanguages = list2;
            this.$romanizeCyrillicByLine = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$processedLines, this.$lyrics, this.$enabledLanguages, this.$romanizeCyrillicByLine, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0036  */
        /* JADX WARN: Code duplicated, block: B:15:0x0058  */
        /* JADX WARN: Code duplicated, block: B:16:0x005a  */
        /* JADX WARN: Code duplicated, block: B:19:0x0065  */
        /* JADX WARN: Code duplicated, block: B:27:0x0085  */
        /* JADX WARN: Code duplicated, block: B:29:0x008d  */
        /* JADX WARN: Code duplicated, block: B:35:0x009f  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:43:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:51:0x00db  */
        /* JADX WARN: Code duplicated, block: B:53:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:56:0x00ef  */
        /* JADX WARN: Code duplicated, block: B:58:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:61:0x0102  */
        /* JADX WARN: Code duplicated, block: B:63:0x010a  */
        /* JADX WARN: Code duplicated, block: B:66:0x0115  */
        /* JADX WARN: Code duplicated, block: B:68:0x011d  */
        /* JADX WARN: Code duplicated, block: B:71:0x0128  */
        /* JADX WARN: Code duplicated, block: B:73:0x0130  */
        /* JADX WARN: Code duplicated, block: B:76:0x013b  */
        /* JADX WARN: Code duplicated, block: B:78:0x0143  */
        /* JADX WARN: Code duplicated, block: B:81:0x014e  */
        /* JADX WARN: Code duplicated, block: B:83:0x0156  */
        /* JADX WARN: Code duplicated, block: B:86:0x0161  */
        /* JADX WARN: Code duplicated, block: B:88:0x0164 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:93:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:95:? A[LOOP:0: B:9:0x0030->B:95:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0162 -> B:89:0x0165). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:83:0x0156
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 367
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.viewmodels.LyricsViewModel$processLyrics$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsViewModel$processLyrics$1(LyricsViewModel lyricsViewModel, boolean z, String str, List list, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = lyricsViewModel;
        this.$showIntervalIndicator = z;
        this.$lyrics = str;
        this.$enabledLanguages = list;
        this.$romanizeCyrillicByLine = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LyricsViewModel$processLyrics$1 lyricsViewModel$processLyrics$1 = new LyricsViewModel$processLyrics$1(this.this$0, this.$showIntervalIndicator, this.$lyrics, this.$enabledLanguages, this.$romanizeCyrillicByLine, continuation);
        lyricsViewModel$processLyrics$1.L$0 = obj;
        return lyricsViewModel$processLyrics$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LyricsViewModel$processLyrics$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objWithContext;
        Long lValueOf;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        boolean z = this.label;
        String str = this.$lyrics;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            LyricsUtils.AnonymousClass2 anonymousClass2 = new LyricsUtils.AnonymousClass2(str, null, (byte) 6);
            this.L$0 = coroutineScope;
            this.label = true;
            objWithContext = AwaitKt.withContext(defaultScheduler, anonymousClass2, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objWithContext = obj;
        }
        List list = (List) objWithContext;
        LyricsViewModel lyricsViewModel = this.this$0;
        lyricsViewModel._lines.setValue(list);
        StateFlowImpl stateFlowImpl = lyricsViewModel._mergedLyricsList;
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, arrayList);
                    break;
                }
                Object next = it.next();
                i = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw null;
                }
                LyricsEntry lyricsEntry = (LyricsEntry) next;
                String str2 = lyricsEntry.text;
                List list2 = lyricsEntry.words;
                if (!StringsKt.isBlank(str2)) {
                    arrayList.add(new LyricsListItem.Line(i2, lyricsEntry));
                }
                if (this.$showIntervalIndicator && i2 < list.size() - 1) {
                    long j = ((LyricsEntry) list.get(i)).time;
                    if (list2 == null || list2.isEmpty()) {
                        lValueOf = StringsKt.isBlank(lyricsEntry.text) ? Long.valueOf(lyricsEntry.time) : null;
                    } else {
                        lValueOf = Long.valueOf((long) (((WordTimestamp) CollectionsKt.last(list2)).endTime * 1000.0d));
                    }
                    if (lValueOf != null && lValueOf.longValue() < j) {
                        long jLongValue = j - lValueOf.longValue();
                        if (jLongValue > 4000) {
                            arrayList.add(new LyricsListItem.Indicator(i2, jLongValue, lValueOf.longValue(), j, ((LyricsEntry) list.get(i)).agent));
                        }
                    }
                }
            }
        } else {
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayList);
        }
        if (str != null && !str.equals("LYRICS_NOT_FOUND") && !this.$enabledLanguages.isEmpty()) {
            AwaitKt.launch$default(coroutineScope, Dispatchers.Default, null, new AnonymousClass1(list, this.$lyrics, this.$enabledLanguages, this.$romanizeCyrillicByLine, null), 2);
        }
        return Unit.INSTANCE;
    }
}
