package com.metrolist.shazamkit.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000fÊ\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0010"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionStatus;", "", "<init>", "()V", "Ready", "Listening", "Processing", "Success", "NoMatch", "Error", "Lcom/metrolist/shazamkit/models/RecognitionStatus$Error;", "Lcom/metrolist/shazamkit/models/RecognitionStatus$Listening;", "Lcom/metrolist/shazamkit/models/RecognitionStatus$NoMatch;", "Lcom/metrolist/shazamkit/models/RecognitionStatus$Processing;", "Lcom/metrolist/shazamkit/models/RecognitionStatus$Ready;", "Lcom/metrolist/shazamkit/models/RecognitionStatus$Success;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class RecognitionStatus {
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionStatus$Error;", "Lcom/metrolist/shazamkit/models/RecognitionStatus;", ContentType.Message.TYPE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Error extends RecognitionStatus {
        public static final int $stable = 0;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String str) {
            super(null);
            str.getClass();
            this.message = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String message) {
            message.getClass();
            return new Error(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.message, ((Error) other).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("Error(message=", this.message, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionStatus$Listening;", "Lcom/metrolist/shazamkit/models/RecognitionStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Listening extends RecognitionStatus {
        public static final int $stable = 0;
        public static final Listening INSTANCE = new Listening();

        private Listening() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Listening);
        }

        public int hashCode() {
            return -172485432;
        }

        public String toString() {
            return "Listening";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionStatus$Processing;", "Lcom/metrolist/shazamkit/models/RecognitionStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Processing extends RecognitionStatus {
        public static final int $stable = 0;
        public static final Processing INSTANCE = new Processing();

        private Processing() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Processing);
        }

        public int hashCode() {
            return -1504412506;
        }

        public String toString() {
            return "Processing";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionStatus$Ready;", "Lcom/metrolist/shazamkit/models/RecognitionStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Ready extends RecognitionStatus {
        public static final int $stable = 0;
        public static final Ready INSTANCE = new Ready();

        private Ready() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Ready);
        }

        public int hashCode() {
            return 1879055408;
        }

        public String toString() {
            return "Ready";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionStatus$Success;", "Lcom/metrolist/shazamkit/models/RecognitionStatus;", "result", "Lcom/metrolist/shazamkit/models/RecognitionResult;", "<init>", "(Lcom/metrolist/shazamkit/models/RecognitionResult;)V", "getResult", "()Lcom/metrolist/shazamkit/models/RecognitionResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Success extends RecognitionStatus {
        public static final int $stable = 8;
        private final RecognitionResult result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(RecognitionResult recognitionResult) {
            super(null);
            recognitionResult.getClass();
            this.result = recognitionResult;
        }

        public static /* synthetic */ Success copy$default(Success success, RecognitionResult recognitionResult, int i, Object obj) {
            if ((i & 1) != 0) {
                recognitionResult = success.result;
            }
            return success.copy(recognitionResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecognitionResult getResult() {
            return this.result;
        }

        public final Success copy(RecognitionResult result) {
            result.getClass();
            return new Success(result);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.result, ((Success) other).result);
        }

        public final RecognitionResult getResult() {
            return this.result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "Success(result=" + this.result + ")";
        }
    }

    public /* synthetic */ RecognitionStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RecognitionStatus() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/metrolist/shazamkit/models/RecognitionStatus$NoMatch;", "Lcom/metrolist/shazamkit/models/RecognitionStatus;", ContentType.Message.TYPE, "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class NoMatch extends RecognitionStatus {
        public static final int $stable = 0;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoMatch(String str) {
            super(null);
            str.getClass();
            this.message = str;
        }

        public static /* synthetic */ NoMatch copy$default(NoMatch noMatch, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noMatch.message;
            }
            return noMatch.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NoMatch copy(String message) {
            message.getClass();
            return new NoMatch(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoMatch) && Intrinsics.areEqual(this.message, ((NoMatch) other).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("NoMatch(message=", this.message, ")");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NoMatch() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ NoMatch(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "No matches found" : str);
        }
    }
}
