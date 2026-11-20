package androidx.compose.foundation.gestures;

import android.view.textclassifier.TextClassifier;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.discord.DiscordGateway;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.HttpHeaders;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableKt$semanticsScrollBy$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $offset;
    public final /* synthetic */ Object $previousValue;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object $this_semanticsScrollBy;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$semanticsScrollBy$2(Response response, Throwable th, DiscordGateway discordGateway, long j, Continuation continuation) {
        super(2, continuation);
        this.L$0 = response;
        this.$this_semanticsScrollBy = th;
        this.$previousValue = discordGateway;
        this.$offset = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$previousValue;
        Object obj3 = this.$this_semanticsScrollBy;
        switch (b) {
            case 0:
                ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2((ScrollingLogic) obj3, this.$offset, (Ref$FloatRef) obj2, continuation);
                scrollableKt$semanticsScrollBy$2.L$0 = obj;
                return scrollableKt$semanticsScrollBy$2;
            case 1:
                ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$3 = new ScrollableKt$semanticsScrollBy$2(this.$offset, (PlatformSelectionBehaviorsImpl) obj3, (CharSequence) obj2, continuation);
                scrollableKt$semanticsScrollBy$3.L$0 = obj;
                return scrollableKt$semanticsScrollBy$3;
            default:
                return new ScrollableKt$semanticsScrollBy$2((Response) this.L$0, (Throwable) obj3, (DiscordGateway) obj2, this.$offset, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((ScrollableKt$semanticsScrollBy$2) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((ScrollableKt$semanticsScrollBy$2) create((TextClassifier) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((ScrollableKt$semanticsScrollBy$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String message;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$previousValue;
        Object obj3 = this.$this_semanticsScrollBy;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
        switch (b) {
            case 0:
                ScrollingLogic scrollingLogic = (ScrollingLogic) obj3;
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) this.L$0;
                float fM105toFloatk4lQ0M = scrollingLogic.m105toFloatk4lQ0M(this.$offset);
                MainActivity$$ExternalSyntheticLambda9 mainActivity$$ExternalSyntheticLambda9 = new MainActivity$$ExternalSyntheticLambda9((Ref$FloatRef) obj2, scrollingLogic, scrollingLogic$nestedScrollScope$1, b2);
                this.label = true;
                return ArcSplineKt.animate$default(CropImageView.DEFAULT_ASPECT_RATIO, fM105toFloatk4lQ0M, null, mainActivity$$ExternalSyntheticLambda9, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    TextClassifier textClassifier = (TextClassifier) this.L$0;
                    this.label = true;
                    return ((PlatformSelectionBehaviorsImpl) obj3).m227classifyTextM8tDOmk((CharSequence) obj2, this.$offset, textClassifier, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) this.L$0;
                int i = response != null ? response.code : 4000;
                String strHeader$default = response != null ? Response.header$default(HttpHeaders.RetryAfter, response) : null;
                Throwable th = (Throwable) obj3;
                String strM = "failure";
                if (strHeader$default == null) {
                    message = th.getMessage();
                    if (message == null) {
                    }
                    this.label = true;
                    if (((DiscordGateway) obj2).handleClose(i, message, false, this.$offset, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return unit;
                }
                String message2 = th.getMessage();
                strM = IntIntPair$$ExternalSyntheticOutline0.m(message2 != null ? message2 : "failure", ";retry_after=", strHeader$default);
                message = strM;
                this.label = true;
                if (((DiscordGateway) obj2).handleClose(i, message, false, this.$offset, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$semanticsScrollBy$2(ScrollingLogic scrollingLogic, long j, Ref$FloatRef ref$FloatRef, Continuation continuation) {
        super(2, continuation);
        this.$this_semanticsScrollBy = scrollingLogic;
        this.$offset = j;
        this.$previousValue = ref$FloatRef;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$semanticsScrollBy$2(long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, CharSequence charSequence, Continuation continuation) {
        super(2, continuation);
        this.$this_semanticsScrollBy = platformSelectionBehaviorsImpl;
        this.$previousValue = charSequence;
        this.$offset = j;
    }
}
