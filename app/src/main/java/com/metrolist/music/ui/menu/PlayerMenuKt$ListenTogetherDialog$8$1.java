package com.metrolist.music.ui.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.api.OpenRouterStreamingService;
import com.metrolist.music.listentogether.ListenTogetherEvent;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.lyrics.LyricsEntry;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerMenuKt$ListenTogetherDialog$8$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $invalidRoomCodeText;
    public final /* synthetic */ MutableState $isCreatingRoom$delegate;
    public final /* synthetic */ MutableState $isJoiningRoom$delegate;
    public final /* synthetic */ MutableState $joinErrorMessage$delegate;
    public final /* synthetic */ String $joinRequestDeniedText;
    public final /* synthetic */ ListenTogetherManager $listenTogetherManager;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.menu.PlayerMenuKt$ListenTogetherDialog$8$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements FlowCollector {
        public final /* synthetic */ Object $context;
        public final /* synthetic */ Serializable $invalidRoomCodeText;
        public final /* synthetic */ Object $isCreatingRoom$delegate;
        public final /* synthetic */ Object $isJoiningRoom$delegate;
        public final /* synthetic */ Object $joinErrorMessage$delegate;
        public final /* synthetic */ Object $joinRequestDeniedText;
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(Object obj, Serializable serializable, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
            this.$r8$classId = b;
            this.$joinRequestDeniedText = obj;
            this.$invalidRoomCodeText = serializable;
            this.$context = obj2;
            this.$joinErrorMessage$delegate = obj3;
            this.$isJoiningRoom$delegate = obj4;
            this.$isCreatingRoom$delegate = obj5;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Object obj2 = this.$isJoiningRoom$delegate;
            Object obj3 = this.$joinErrorMessage$delegate;
            Object obj4 = this.$context;
            Object obj5 = this.$isCreatingRoom$delegate;
            Object obj6 = this.$joinRequestDeniedText;
            Serializable serializable = this.$invalidRoomCodeText;
            switch (b) {
                case 0:
                    ListenTogetherEvent listenTogetherEvent = (ListenTogetherEvent) obj;
                    String strM = (String) obj6;
                    MutableState mutableState = (MutableState) obj5;
                    MutableState mutableState2 = (MutableState) obj2;
                    MutableState mutableState3 = (MutableState) obj3;
                    if (listenTogetherEvent != null) {
                        if (listenTogetherEvent instanceof ListenTogetherEvent.JoinRejected) {
                            String str = ((ListenTogetherEvent.JoinRejected) listenTogetherEvent).reason;
                            if (!StringsKt.isBlank(str)) {
                                strM = StringsKt.contains(str, "invalid", true) ? (String) serializable : Fragment$5$$ExternalSyntheticOutline0.m(strM, ": ", str);
                            }
                            mutableState3.setValue(strM);
                            Boolean bool = Boolean.FALSE;
                            mutableState2.setValue(bool);
                            mutableState.setValue(bool);
                        } else if (listenTogetherEvent instanceof ListenTogetherEvent.JoinApproved) {
                            mutableState2.setValue(Boolean.FALSE);
                            mutableState3.setValue(null);
                        } else if (listenTogetherEvent instanceof ListenTogetherEvent.RoomCreated) {
                            mutableState.setValue(Boolean.FALSE);
                            Object systemService = ((Context) obj4).getSystemService("clipboard");
                            systemService.getClass();
                            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("ListenTogetherRoom", ((ListenTogetherEvent.RoomCreated) listenTogetherEvent).roomCode));
                        }
                    }
                    return unit;
                case 1:
                    ListenTogetherEvent listenTogetherEvent2 = (ListenTogetherEvent) obj;
                    String strM2 = (String) obj6;
                    MutableState mutableState4 = (MutableState) obj5;
                    MutableState mutableState5 = (MutableState) obj2;
                    MutableState mutableState6 = (MutableState) obj3;
                    if (listenTogetherEvent2 != null) {
                        if (listenTogetherEvent2 instanceof ListenTogetherEvent.JoinRejected) {
                            String str2 = ((ListenTogetherEvent.JoinRejected) listenTogetherEvent2).reason;
                            if (!StringsKt.isBlank(str2)) {
                                strM2 = StringsKt.contains(str2, "invalid", true) ? (String) serializable : Fragment$5$$ExternalSyntheticOutline0.m(strM2, ": ", str2);
                            }
                            mutableState6.setValue(strM2);
                            Boolean bool2 = Boolean.FALSE;
                            mutableState5.setValue(bool2);
                            mutableState4.setValue(bool2);
                        } else if (listenTogetherEvent2 instanceof ListenTogetherEvent.JoinApproved) {
                            mutableState5.setValue(Boolean.FALSE);
                            mutableState6.setValue(null);
                        } else if (listenTogetherEvent2 instanceof ListenTogetherEvent.RoomCreated) {
                            mutableState4.setValue(Boolean.FALSE);
                            Object systemService2 = ((Context) obj4).getSystemService("clipboard");
                            systemService2.getClass();
                            ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("ListenTogetherRoom", ((ListenTogetherEvent.RoomCreated) listenTogetherEvent2).roomCode));
                        }
                    }
                    return unit;
                default:
                    OpenRouterStreamingService.StreamChunk streamChunk = (OpenRouterStreamingService.StreamChunk) obj;
                    ArrayList arrayList = (ArrayList) serializable;
                    StringBuilder sb = (StringBuilder) obj6;
                    ConnectionPool connectionPool = Timber.Forest;
                    Objects.toString(streamChunk);
                    int i = 0;
                    connectionPool.getClass();
                    ConnectionPool.v(new Object[0]);
                    if (streamChunk != null) {
                        if (streamChunk instanceof OpenRouterStreamingService.StreamChunk.Content) {
                            sb.append(((OpenRouterStreamingService.StreamChunk.Content) streamChunk).text);
                            String string = sb.toString();
                            StateFlowImpl stateFlowImpl = LyricsTranslationHelper._status;
                            arrayList.size();
                            List listLines = StringsKt.lines(string);
                            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listLines, 10));
                            Iterator it = listLines.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(StringsKt.trim((String) it.next()).toString());
                            }
                            ArrayList arrayList3 = new ArrayList();
                            int size = arrayList2.size();
                            int i2 = 0;
                            while (i2 < size) {
                                Object obj7 = arrayList2.get(i2);
                                i2++;
                                if (!StringsKt.isBlank((String) obj7)) {
                                    arrayList3.add(obj7);
                                }
                            }
                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                            int size2 = arrayList3.size();
                            int i3 = 0;
                            while (i3 < size2) {
                                Object obj8 = arrayList3.get(i3);
                                i3++;
                                String str3 = (String) obj8;
                                Pattern patternCompile = Pattern.compile("^\\d+\\.\\s*");
                                patternCompile.getClass();
                                str3.getClass();
                                String strReplaceAll = patternCompile.matcher(str3).replaceAll("");
                                strReplaceAll.getClass();
                                Pattern patternCompile2 = Pattern.compile("^Line\\s+\\d+:\\s*", 66);
                                patternCompile2.getClass();
                                String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("");
                                strReplaceAll2.getClass();
                                Pattern patternCompile3 = Pattern.compile("^-\\s*");
                                patternCompile3.getClass();
                                String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("");
                                strReplaceAll3.getClass();
                                arrayList4.add(strReplaceAll3);
                            }
                            if (arrayList4.isEmpty()) {
                                return unit;
                            }
                            List list = (List) obj5;
                            int size3 = arrayList4.size();
                            int i4 = 0;
                            while (i4 < size3) {
                                Object obj9 = arrayList4.get(i4);
                                i4++;
                                int i5 = i + 1;
                                if (i < 0) {
                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                    throw null;
                                }
                                String str4 = (String) obj9;
                                if (i < arrayList.size() && !StringsKt.isBlank(str4)) {
                                    ((StateFlowImpl) ((LyricsEntry) list.get(((Number) ((Pair) arrayList.get(i)).first).intValue())).translatedTextFlow).updateState(null, str4);
                                }
                                i = i5;
                            }
                            StateFlowImpl stateFlowImpl2 = LyricsTranslationHelper._status;
                            stateFlowImpl2.getClass();
                            stateFlowImpl2.updateState(null, LyricsTranslationHelper.TranslationStatus.Translating.INSTANCE);
                            return unit;
                        }
                        if (streamChunk instanceof OpenRouterStreamingService.StreamChunk.Complete) {
                            List list2 = ((OpenRouterStreamingService.StreamChunk.Complete) streamChunk).translatedLines;
                            list2.size();
                            ConnectionPool.d(new Object[0]);
                            ((Ref$ObjectRef) obj4).element = list2;
                            return unit;
                        }
                        if (streamChunk instanceof OpenRouterStreamingService.StreamChunk.Error) {
                            String str5 = ((OpenRouterStreamingService.StreamChunk.Error) streamChunk).message;
                            ConnectionPool.e(new Object[0]);
                            ((Ref$BooleanRef) obj3).element = true;
                            ((Ref$ObjectRef) obj2).element = str5;
                            return unit;
                        }
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayerMenuKt$ListenTogetherDialog$8$1(ListenTogetherManager listenTogetherManager, String str, String str2, Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$listenTogetherManager = listenTogetherManager;
        this.$joinRequestDeniedText = str;
        this.$invalidRoomCodeText = str2;
        this.$context = context;
        this.$joinErrorMessage$delegate = mutableState;
        this.$isJoiningRoom$delegate = mutableState2;
        this.$isCreatingRoom$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new PlayerMenuKt$ListenTogetherDialog$8$1(this.$listenTogetherManager, this.$joinRequestDeniedText, this.$invalidRoomCodeText, this.$context, this.$joinErrorMessage$delegate, this.$isJoiningRoom$delegate, this.$isCreatingRoom$delegate, continuation, (byte) 0);
            default:
                return new PlayerMenuKt$ListenTogetherDialog$8$1(this.$listenTogetherManager, this.$joinRequestDeniedText, this.$invalidRoomCodeText, this.$context, this.$joinErrorMessage$delegate, this.$isJoiningRoom$delegate, this.$isCreatingRoom$delegate, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((PlayerMenuKt$ListenTogetherDialog$8$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((PlayerMenuKt$ListenTogetherDialog$8$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return coroutineSingletons;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        ListenTogetherManager listenTogetherManager = this.$listenTogetherManager;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlySharedFlow readonlySharedFlow = listenTogetherManager.events;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$joinRequestDeniedText, this.$invalidRoomCodeText, this.$context, this.$joinErrorMessage$delegate, this.$isJoiningRoom$delegate, this.$isCreatingRoom$delegate, (byte) 0);
                this.label = true;
                if (readonlySharedFlow.$$delegate_0.collect(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlySharedFlow readonlySharedFlow2 = listenTogetherManager.events;
                AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$joinRequestDeniedText, this.$invalidRoomCodeText, this.$context, this.$joinErrorMessage$delegate, this.$isJoiningRoom$delegate, this.$isCreatingRoom$delegate, (byte) 1);
                this.label = true;
                if (readonlySharedFlow2.$$delegate_0.collect(anonymousClass2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
        }
    }
}
