package com.metrolist.music.recognition;

import android.content.Context;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.core.app.NavUtils;
import com.metrolist.shazamkit.Shazam;
import com.metrolist.shazamkit.models.RecognitionResult;
import com.metrolist.shazamkit.models.RecognitionStatus;
import java.nio.ByteOrder;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicRecognitionService {
    public static final MusicRecognitionService INSTANCE = new MusicRecognitionService();
    public static final StateFlowImpl _recognitionStatus;
    public static final ReadonlyStateFlow recognitionStatus;
    public static boolean resultSavedExternally;

    /* JADX INFO: renamed from: com.metrolist.music.recognition.MusicRecognitionService$recognize$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Context $context;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00ac A[Catch: Exception -> 0x0022, CancellationException -> 0x01f4, TryCatch #3 {CancellationException -> 0x01f4, Exception -> 0x0022, blocks: (B:7:0x0019, B:39:0x010a, B:41:0x0110, B:50:0x0166, B:42:0x0134, B:45:0x013c, B:47:0x0152, B:49:0x0160, B:48:0x015a, B:13:0x002b, B:25:0x00a6, B:27:0x00ac, B:29:0x00d0, B:31:0x00dc, B:33:0x00df, B:36:0x00e7, B:53:0x016e, B:55:0x019a, B:56:0x01a1, B:57:0x01a2, B:14:0x0033, B:22:0x0064, B:19:0x005a), top: B:70:0x0011 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x01a2 A[Catch: Exception -> 0x0022, CancellationException -> 0x01f4, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x01f4, Exception -> 0x0022, blocks: (B:7:0x0019, B:39:0x010a, B:41:0x0110, B:50:0x0166, B:42:0x0134, B:45:0x013c, B:47:0x0152, B:49:0x0160, B:48:0x015a, B:13:0x002b, B:25:0x00a6, B:27:0x00ac, B:29:0x00d0, B:31:0x00dc, B:33:0x00df, B:36:0x00e7, B:53:0x016e, B:55:0x019a, B:56:0x01a1, B:57:0x01a2, B:14:0x0033, B:22:0x0064, B:19:0x005a), top: B:70:0x0011 }] */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0107, code lost:
        
            if (r14 == r10) goto L38;
         */
        /* JADX WARN: Instruction removed from duplicated block: B:57:0x01a2, please report this as an issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objM1452resample0E7RQCE;
            Throwable thM1866exceptionOrNullimpl;
            char c;
            Object objM1533recognize0E7RQCE;
            StateFlowImpl stateFlowImpl;
            byte b = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                    Context context = this.$context;
                    context.getClass();
                    if (NavUtils.checkSelfPermission(context, "android.permission.RECORD_AUDIO") != 0) {
                        Timber.Forest.tag("MusicRecognitionService");
                        ConnectionPool.w(new Object[0]);
                        return new RecognitionStatus.Error("Microphone permission not granted");
                    }
                    MusicRecognitionService._recognitionStatus.setValue(RecognitionStatus.Listening.INSTANCE);
                    Timber.Forest.tag("MusicRecognitionService");
                    ConnectionPool.d(new Object[0]);
                    this.label = (byte) 1;
                    obj = musicRecognitionService.recordAudio(this);
                    if (obj == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (b == 2) {
                    ResultKt.throwOnFailure(obj);
                    objM1452resample0E7RQCE = ((Result) obj).value;
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1452resample0E7RQCE);
                    if (thM1866exceptionOrNullimpl != null) {
                        Timber.Forest.tag("MusicRecognitionService");
                        ConnectionPool.e$1(new Object[0]);
                        StateFlowImpl stateFlowImpl2 = MusicRecognitionService._recognitionStatus;
                        RecognitionStatus.Error error = new RecognitionStatus.Error("Failed to resample audio: " + thM1866exceptionOrNullimpl.getMessage());
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, error);
                        return stateFlowImpl2.getValue();
                    }
                    DecodedAudio decodedAudio = (DecodedAudio) objM1452resample0E7RQCE;
                    ConnectionPool connectionPool = Timber.Forest;
                    connectionPool.tag("MusicRecognitionService");
                    byte[] bArr = decodedAudio.data;
                    c = decodedAudio.sampleRate;
                    ConnectionPool.d(new Integer(bArr.length), new Integer(1), new Integer(c));
                    if (c == 16000 || !Intrinsics.areEqual(ByteOrder.nativeOrder(), ByteOrder.LITTLE_ENDIAN) || bArr.length == 0 || bArr.length % 2 != 0) {
                        throw new IllegalArgumentException("Invalid audio format for fingerprint generation");
                    }
                    try {
                        String strFromI16 = VibraSignature.fromI16(bArr);
                        long length = (((long) (bArr.length / 2)) * 1000) / 16000;
                        connectionPool.tag("MusicRecognitionService");
                        ConnectionPool.d(new Long(length));
                        Shazam shazam = Shazam.INSTANCE;
                        this.label = (byte) 3;
                        objM1533recognize0E7RQCE = shazam.m1533recognize0E7RQCE(length, strFromI16, this);
                    } catch (Exception e) {
                        Timber.Forest.tag("MusicRecognitionService");
                        ConnectionPool.e$1(new Object[0]);
                        StateFlowImpl stateFlowImpl3 = MusicRecognitionService._recognitionStatus;
                        RecognitionStatus.Error error2 = new RecognitionStatus.Error("Failed to generate fingerprint: " + e.getMessage());
                        stateFlowImpl3.getClass();
                        stateFlowImpl3.updateState(null, error2);
                        return stateFlowImpl3.getValue();
                    }
                } else {
                    if (b != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1533recognize0E7RQCE = ((Result) obj).value;
                }
                Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(objM1533recognize0E7RQCE);
                if (thM1866exceptionOrNullimpl2 == null) {
                    RecognitionResult recognitionResult = (RecognitionResult) objM1533recognize0E7RQCE;
                    Timber.Forest.tag("MusicRecognitionService");
                    ConnectionPool.i(recognitionResult.getTitle(), recognitionResult.getArtist());
                    stateFlowImpl = MusicRecognitionService._recognitionStatus;
                    RecognitionStatus.Success success = new RecognitionStatus.Success(recognitionResult);
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, success);
                } else {
                    String message = thM1866exceptionOrNullimpl2.getMessage();
                    if (message == null) {
                        message = "Unknown error";
                    }
                    Timber.Forest.tag("MusicRecognitionService");
                    ConnectionPool.w$1(message);
                    stateFlowImpl = MusicRecognitionService._recognitionStatus;
                    Object noMatch = StringsKt.contains(message, "No match", true) ? new RecognitionStatus.NoMatch("No matches found. Try again with clearer audio.") : new RecognitionStatus.Error(message);
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, noMatch);
                }
                return (RecognitionStatus) stateFlowImpl.getValue();
                byte[] bArr2 = (byte[]) obj;
                ConnectionPool connectionPool2 = Timber.Forest;
                connectionPool2.tag("MusicRecognitionService");
                ConnectionPool.d(new Integer(bArr2.length));
                MusicRecognitionService._recognitionStatus.setValue(RecognitionStatus.Processing.INSTANCE);
                connectionPool2.tag("MusicRecognitionService");
                ConnectionPool.d(new Integer(44100), new Integer(VibraSignature.REQUIRED_SAMPLE_RATE));
                DecodedAudio decodedAudio2 = new DecodedAudio(bArr2, 44100);
                AudioResampler audioResampler = AudioResampler.INSTANCE;
                this.label = (byte) 2;
                objM1452resample0E7RQCE = audioResampler.m1452resample0E7RQCE(decodedAudio2, VibraSignature.REQUIRED_SAMPLE_RATE, this);
                if (objM1452resample0E7RQCE != coroutineSingletons) {
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1452resample0E7RQCE);
                    if (thM1866exceptionOrNullimpl != null) {
                        DecodedAudio decodedAudio3 = (DecodedAudio) objM1452resample0E7RQCE;
                        ConnectionPool connectionPool3 = Timber.Forest;
                        connectionPool3.tag("MusicRecognitionService");
                        byte[] bArr3 = decodedAudio3.data;
                        c = decodedAudio3.sampleRate;
                        ConnectionPool.d(new Integer(bArr3.length), new Integer(1), new Integer(c));
                        if (c == 16000) {
                        }
                        throw new IllegalArgumentException("Invalid audio format for fingerprint generation");
                    }
                    Timber.Forest.tag("MusicRecognitionService");
                    ConnectionPool.e$1(new Object[0]);
                    StateFlowImpl stateFlowImpl4 = MusicRecognitionService._recognitionStatus;
                    RecognitionStatus.Error error3 = new RecognitionStatus.Error("Failed to resample audio: " + thM1866exceptionOrNullimpl.getMessage());
                    stateFlowImpl4.getClass();
                    stateFlowImpl4.updateState(null, error3);
                    return stateFlowImpl4.getValue();
                }
                return coroutineSingletons;
            } catch (CancellationException e2) {
                throw e2;
            } catch (Exception e3) {
                Timber.Forest.tag("MusicRecognitionService");
                ConnectionPool.e$1(new Object[0]);
                StateFlowImpl stateFlowImpl5 = MusicRecognitionService._recognitionStatus;
                String message2 = e3.getMessage();
                if (message2 == null) {
                    message2 = "Recognition failed";
                }
                RecognitionStatus.Error error4 = new RecognitionStatus.Error(message2);
                stateFlowImpl5.getClass();
                stateFlowImpl5.updateState(null, error4);
                return (RecognitionStatus) stateFlowImpl5.getValue();
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.recognition.MusicRecognitionService$recordAudio$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MusicRecognitionService.this.recordAudio(this);
        }
    }

    static {
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(RecognitionStatus.Ready.INSTANCE);
        _recognitionStatus = stateFlowImplMutableStateFlow;
        recognitionStatus = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
    }

    public static Object recognize(Context context, SuspendLambda suspendLambda) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new AnonymousClass2(context, null), suspendLambda);
    }

    public static void reset() {
        Timber.Forest.tag("MusicRecognitionService");
        ConnectionPool.d(new Object[0]);
        _recognitionStatus.setValue(RecognitionStatus.Ready.INSTANCE);
        resultSavedExternally = false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object recordAudio(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objWithContext = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, continuation, (byte) 8);
            anonymousClass1.label = 1;
            objWithContext = AwaitKt.withContext(defaultIoScheduler, recomposer$join$2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        objWithContext.getClass();
        return objWithContext;
    }
}
