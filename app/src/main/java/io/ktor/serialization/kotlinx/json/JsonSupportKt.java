package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0002\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\u0006\"\u0017\u0010\b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/serialization/Configuration;", "Lkotlinx/serialization/json/Json;", "json", "Lio/ktor/http/ContentType;", "contentType", "", "(Lio/ktor/serialization/Configuration;Lkotlinx/serialization/json/Json;Lio/ktor/http/ContentType;)V", "jsonIo", "DefaultJson", "Lkotlinx/serialization/json/Json;", "getDefaultJson", "()Lkotlinx/serialization/json/Json;", "ktor-serialization-kotlinx-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonSupportKt {
    private static final Json DefaultJson = UuidKt.Json$default(new InstantKt$$ExternalSyntheticLambda0((byte) 6));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultJson$lambda$0(JsonBuilder jsonBuilder) {
        jsonBuilder.getClass();
        jsonBuilder.encodeDefaults = true;
        jsonBuilder.isLenient = true;
        jsonBuilder.allowSpecialFloatingPointValues = true;
        jsonBuilder.allowStructuredMapKeys = true;
        jsonBuilder.prettyPrint = false;
        return Unit.INSTANCE;
    }

    public static final Json getDefaultJson() {
        return DefaultJson;
    }

    public static final void json(Configuration configuration, Json json, ContentType contentType) {
        configuration.getClass();
        json.getClass();
        contentType.getClass();
        KotlinxSerializationConverterKt.serialization(configuration, contentType, json);
    }

    public static /* synthetic */ void json$default(Configuration configuration, Json json, ContentType contentType, int i, Object obj) {
        if ((i & 1) != 0) {
            json = DefaultJson;
        }
        if ((i & 2) != 0) {
            contentType = ContentType.Application.INSTANCE.getJson();
        }
        json(configuration, json, contentType);
    }

    public static final void jsonIo(Configuration configuration, Json json, ContentType contentType) {
        configuration.getClass();
        json.getClass();
        contentType.getClass();
        Configuration.register$default(configuration, contentType, new ExperimentalJsonConverter(json), null, 4, null);
    }

    public static /* synthetic */ void jsonIo$default(Configuration configuration, Json json, ContentType contentType, int i, Object obj) {
        if ((i & 1) != 0) {
            json = DefaultJson;
        }
        if ((i & 2) != 0) {
            contentType = ContentType.Application.INSTANCE.getJson();
        }
        jsonIo(configuration, json, contentType);
    }
}
