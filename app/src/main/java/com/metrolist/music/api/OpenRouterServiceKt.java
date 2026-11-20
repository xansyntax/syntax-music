package com.metrolist.music.api;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import io.ktor.http.ContentType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.LinesSequence;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OpenRouterServiceKt {
    public static final JsonImpl translationJson = UuidKt.Json$default(new KuGouKt$$ExternalSyntheticLambda0((byte) 26));

    public static final String apiErrorMessage(int i, String str, String str2) {
        Object failure;
        JsonElement jsonElement;
        str2.getClass();
        Object obj = null;
        try {
            JsonImpl jsonImpl = translationJson;
            if (str == null) {
                str = "";
            }
            JsonElement jsonElement2 = (JsonElement) JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(str)).get("error");
            failure = (jsonElement2 == null || (jsonElement = (JsonElement) JsonElementKt.getJsonObject(jsonElement2).get(ContentType.Message.TYPE)) == null) ? null : JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement));
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        String str3 = (String) failure;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            obj = failure;
        }
        String str4 = (String) obj;
        if (str4 != null) {
            return str4;
        }
        return "HTTP " + i + ": " + str2;
    }

    public static final JsonObject buildTranslationRequest(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        String strM;
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        int size = StringsKt.lines(str).size();
        if (StringsKt.isBlank(str5)) {
            str5 = null;
        }
        String strReplace = str5 != null ? StringsKt__StringsJVMKt.replace(str5, "{lineCount}", String.valueOf(size), false) : IntIntPair$$ExternalSyntheticOutline0.m(size, "You are a precise lyrics translation assistant. Your output must ALWAYS be a valid JSON object of the form {\"lines\": [\"line1\", \"line2\", \"line3\"].\n\nCRITICAL RULES:\n1. Output ONLY the JSON object: {\"lines\": [\"line1\", \"line2\", \"line3\"]}\n2. NO explanations, NO questions, NO additional text\n3. Each input line maps to exactly one entry in the \"lines\" array\n4. Preserve empty lines as empty strings \"\"\n5. The \"lines\" array must contain EXACTLY ", " items\n6. If uncertain, provide best approximation but maintain line count");
        if (str4.equals("Romanized")) {
            StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(size, "Romanize/transliterate the following ", " lines into simple Latin script using ONLY basic English letters (a-z, A-Z).\n\nCRITICAL REQUIREMENTS:\n- Use ONLY simple ASCII characters (a-z, A-Z, 0-9, basic punctuation)\n- NO special characters like ā, ī, ū, ñ, ç, etc.\n- NO diacritics or accent marks\n- If text is already in Latin script, return it UNCHANGED\n- For non-Latin scripts (Hindi, Chinese, Japanese, Korean, Cyrillic, etc.), provide simple romanization\n- DO NOT translate meaning, only convert script to simple English letters\n- Keep all punctuation and formatting\n- Preserve line-by-line structure exactly\n\nExamples of correct simple romanization:\n- Sanskrit/Hindi \"आ\" → \"aa\" (not \"ā\")\n- Japanese \"東京\" → \"toukyou\" or \"tokyo\" (not \"tōkyō\")\n- Korean \"서울\" → \"seoul\" (not \"sŏul\")\n\nInput (", size, " lines):\n");
            sbM3m.append(str);
            sbM3m.append("\n\nOutput MUST be a JSON object {\"lines\": [...]} with EXACTLY ");
            sbM3m.append(size);
            sbM3m.append(" strings using ONLY simple ASCII characters.");
            strM = sbM3m.toString();
        } else if (str4.equals("Transcribed")) {
            StringBuilder sb = new StringBuilder("Transcribe/transliterate the following ");
            sb.append(size);
            sb.append(" lines phonetically into ");
            sb.append(str2);
            sb.append(" script.\n\nCRITICAL REQUIREMENTS:\n- Convert the SOUND/PRONUNCIATION of the original text into ");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sb, str2, " script\n- DO NOT translate the meaning - only represent how the original words SOUND\n- Use the native script of ", str2, " (e.g., Devanagari for Hindi, Hangul for Korean, etc.)\n- Preserve the original pronunciation as closely as possible in the target script\n- Keep punctuation and formatting\n- Preserve line-by-line structure exactly\n- If text is already in ");
            sb.append(str2);
            sb.append(" script, return it UNCHANGED\n\nExamples:\n- Japanese \"こんにちは\" to Hindi → \"कोन्निचिवा\" (phonetic, not translation)\n- English \"Hello\" to Hindi → \"हेलो\" (phonetic)\n- Korean \"안녕하세요\" to Hindi → \"अन्न्योंग हासेयो\" (phonetic)\n\nInput (");
            sb.append(size);
            sb.append(" lines):\n");
            sb.append(str);
            sb.append("\n\nOutput MUST be a JSON object {\"lines\": [...]} with EXACTLY ");
            sb.append(size);
            sb.append(" strings in ");
            strM = IntIntPair$$ExternalSyntheticOutline0.m(sb, str2, " script.");
        } else {
            StringBuilder sb2 = new StringBuilder("Translate the following ");
            sb2.append(size);
            sb2.append(" lines to ");
            sb2.append(str2);
            sb2.append(".\n\nIMPORTANT:\n- Provide natural, accurate translation\n- Maintain poetic flow and meaning\n- Keep punctuation appropriate for target language\n- Preserve line-by-line structure exactly\n- For song lyrics, prioritize singability\n\nInput (");
            sb2.append(size);
            sb2.append(" lines):\n");
            sb2.append(str);
            sb2.append("\n\nOutput MUST be a JSON object {\"lines\": [...]} with EXACTLY ");
            strM = Fragment$5$$ExternalSyntheticOutline0.m(sb2, size, " strings.");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        arrayList.add(new JsonObject(linkedHashMap2));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        arrayList.add(new JsonObject(linkedHashMap3));
        if (!StringsKt.isBlank(str3)) {
        }
        if (!StringsKt.contains(str6, "api.openai.com", false)) {
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        Boolean bool = Boolean.TRUE;
        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        LinkedHashMap linkedHashMap7 = new LinkedHashMap();
        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
        LinkedHashMap linkedHashMap9 = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        JsonPrimitive JsonPrimitive = JsonElementKt.JsonPrimitive("lines");
        JsonPrimitive.getClass();
        arrayList2.add(JsonPrimitive);
        if (StringsKt.contains(str6, "openrouter.ai", false)) {
            LinkedHashMap linkedHashMap10 = new LinkedHashMap();
        }
        if (z) {
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ArrayList extractLines(JsonElement jsonElement) {
        ArrayList arrayList = null;
        if (jsonElement != 0) {
            if (jsonElement instanceof JsonObject) {
                Object obj = ((JsonObject) jsonElement).get("lines");
                JsonArray jsonArray = obj instanceof JsonArray ? (JsonArray) obj : null;
                if (jsonArray != null) {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(jsonArray, 10));
                    Iterator it = jsonArray.content.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(JsonElementKt.getJsonPrimitive((JsonElement) it.next()).getContent());
                    }
                    return arrayList2;
                }
            } else if (jsonElement instanceof JsonArray) {
                Iterable iterable = (Iterable) jsonElement;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    arrayList.add(JsonElementKt.getJsonPrimitive((JsonElement) it2.next()).getContent());
                }
            }
        }
        return arrayList;
    }

    public static final Serializable parseTranslationContent(int i, String str) {
        try {
            String string = StringsKt.trim(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(str, "```json", "", false), "```", "", false)).toString();
            String strSubstringAfter = StringsKt.substringAfter('[', string, "");
            int iLastIndexOf$default = StringsKt.lastIndexOf$default(strSubstringAfter, ']', 0, 6);
            String strSubstring = iLastIndexOf$default == -1 ? "" : strSubstringAfter.substring(0, iLastIndexOf$default);
            if (strSubstring.length() <= 0) {
                strSubstring = null;
            }
            List list = (List) SequencesKt.firstOrNull(SequencesKt.mapNotNull(new FilteringSequence(new LinesSequence((byte) 1, new String[]{StringsKt.trim(str).toString(), string, strSubstring != null ? "[" + strSubstring + "]" : null}), false, new InstantKt$$ExternalSyntheticLambda0((byte) 19)), new KuGouKt$$ExternalSyntheticLambda0((byte) 27)));
            if (list == null) {
                List listLines = StringsKt.lines(string);
                ArrayList arrayList = new ArrayList();
                for (Object obj : listLines) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    String string2 = StringsKt.trim((String) obj2).toString();
                    string2.getClass();
                    arrayList2.add(StringsKt.removeSurrounding(StringsKt.removeSurrounding(string2, "\"", "\""), "'", "'"));
                }
                ArrayList arrayList3 = arrayList2.isEmpty() ? null : arrayList2;
                if (arrayList3 == null) {
                    throw new IllegalStateException("Failed to parse translation");
                }
                list = arrayList3;
            }
            List listTake = CollectionsKt.take(list, i);
            int size2 = i - list.size();
            if (size2 < 0) {
                size2 = 0;
            }
            ArrayList arrayList4 = new ArrayList(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add("");
            }
            return CollectionsKt.plus((Iterable) arrayList4, (Collection) listTake);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }
}
