package com.metrolist.music.ui.screens.library;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.lifecycle.ViewModel;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MutableState $currentFileName$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $currentUploadIndex$delegate;
    public final /* synthetic */ MutableState $isUploading$delegate;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $showUploadDialog$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $totalUploads$delegate;
    public final /* synthetic */ String $uploadCompleteStr;
    public final /* synthetic */ String $uploadFailedStr;
    public final /* synthetic */ String $uploadFileTooLargeStr;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $uploadProgress$delegate;
    public final /* synthetic */ String $uploadUnsupportedFormatStr;
    public final /* synthetic */ List $uris;
    public final /* synthetic */ ViewModel $viewModel;
    public int I$0;
    public int I$1;
    public Ref$IntRef L$0;
    public Uri L$11;
    public Context L$2;
    public String L$3;
    public String L$4;
    public String L$5;
    public ParcelableSnapshotMutableIntState L$6;
    public ParcelableSnapshotMutableFloatState L$7;
    public MutableState L$8;
    public Iterator L$9;
    public byte label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ String $uploadCompleteStr;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Context context, String str, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$context = context;
            this.$uploadCompleteStr = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass2(this.$context, this.$uploadCompleteStr, continuation, (byte) 0);
                default:
                    return new AnonymousClass2(this.$context, this.$uploadCompleteStr, continuation, (byte) 1);
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
                    ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            String str = this.$uploadCompleteStr;
            Context context = this.$context;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Toast.makeText(context, str, 0).show();
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    Toast.makeText(context, str, 0).show();
                    break;
            }
            return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2(List list, String str, ViewModel viewModel, MutableState mutableState, MutableState mutableState2, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, Context context, String str2, String str3, String str4, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState3, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$uris = list;
        this.$uploadCompleteStr = str;
        this.$viewModel = viewModel;
        this.$isUploading$delegate = mutableState;
        this.$showUploadDialog$delegate = mutableState2;
        this.$totalUploads$delegate = parcelableSnapshotMutableIntState;
        this.$context = context;
        this.$uploadUnsupportedFormatStr = str2;
        this.$uploadFileTooLargeStr = str3;
        this.$uploadFailedStr = str4;
        this.$currentUploadIndex$delegate = parcelableSnapshotMutableIntState2;
        this.$uploadProgress$delegate = parcelableSnapshotMutableFloatState;
        this.$currentFileName$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ViewModel viewModel = this.$viewModel;
        switch (b) {
            case 0:
                return new LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2(this.$uris, this.$uploadCompleteStr, (LibrarySongsViewModel) viewModel, this.$isUploading$delegate, this.$showUploadDialog$delegate, this.$totalUploads$delegate, this.$context, this.$uploadUnsupportedFormatStr, this.$uploadFileTooLargeStr, this.$uploadFailedStr, this.$currentUploadIndex$delegate, this.$uploadProgress$delegate, this.$currentFileName$delegate, continuation, (byte) 0);
            default:
                return new LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2(this.$uris, this.$uploadCompleteStr, (AutoPlaylistViewModel) viewModel, this.$isUploading$delegate, this.$showUploadDialog$delegate, this.$totalUploads$delegate, this.$context, this.$uploadUnsupportedFormatStr, this.$uploadFileTooLargeStr, this.$uploadFailedStr, this.$currentUploadIndex$delegate, this.$uploadProgress$delegate, this.$currentFileName$delegate, continuation, (byte) 1);
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
        return ((LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0464  */
    /* JADX WARN: Code duplicated, block: B:139:0x046e  */
    /* JADX WARN: Code duplicated, block: B:152:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:163:0x0509  */
    /* JADX WARN: Code duplicated, block: B:166:0x0519  */
    /* JADX WARN: Code duplicated, block: B:168:0x051f A[Catch: Exception -> 0x04fa, CancellationException -> 0x05f0, TRY_LEAVE, TryCatch #6 {CancellationException -> 0x05f0, blocks: (B:125:0x03a0, B:180:0x0580, B:182:0x058b, B:184:0x0591, B:140:0x047d, B:142:0x0483, B:144:0x048b, B:146:0x04a7, B:148:0x04ab, B:153:0x04bf, B:157:0x04de, B:160:0x04f2, B:165:0x0510, B:168:0x051f, B:171:0x0536, B:173:0x055a, B:175:0x056c, B:130:0x03f3), top: B:246:0x0362 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0536 A[Catch: Exception -> 0x05b7, CancellationException -> 0x05f0, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x05b7, blocks: (B:157:0x04de, B:171:0x0536), top: B:238:0x04de }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0574  */
    /* JADX WARN: Code duplicated, block: B:179:0x0577  */
    /* JADX WARN: Code duplicated, block: B:182:0x058b A[Catch: Exception -> 0x0599, CancellationException -> 0x05f0, TRY_LEAVE, TryCatch #6 {CancellationException -> 0x05f0, blocks: (B:125:0x03a0, B:180:0x0580, B:182:0x058b, B:184:0x0591, B:140:0x047d, B:142:0x0483, B:144:0x048b, B:146:0x04a7, B:148:0x04ab, B:153:0x04bf, B:157:0x04de, B:160:0x04f2, B:165:0x0510, B:168:0x051f, B:171:0x0536, B:173:0x055a, B:175:0x056c, B:130:0x03f3), top: B:246:0x0362 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x059d  */
    /* JADX WARN: Code duplicated, block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v21, types: [kotlin.coroutines.Continuation, kotlin.jvm.internal.Ref$IntRef] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v49, types: [kotlin.coroutines.Continuation, kotlin.jvm.internal.Ref$IntRef] */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x0527 -> B:170:0x0530). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x0577 -> B:250:0x0580). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:216:0x05f6 -> B:217:0x0617). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01ed -> B:59:0x01f7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x023b -> B:264:0x0243). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x0297 -> B:95:0x02ba). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r32) {
        /*
            Method dump skipped, instruction units count: 1716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
