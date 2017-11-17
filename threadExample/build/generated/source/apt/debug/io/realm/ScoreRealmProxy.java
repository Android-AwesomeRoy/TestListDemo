package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class ScoreRealmProxy extends io.realm.examples.threads.model.Score
    implements RealmObjectProxy, ScoreRealmProxyInterface {

    static final class ScoreColumnInfo extends ColumnInfo {
        long nameIndex;
        long scoreIndex;

        ScoreColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Score");
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.scoreIndex = addColumnDetails("score", objectSchemaInfo);
        }

        ScoreColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ScoreColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ScoreColumnInfo src = (ScoreColumnInfo) rawSrc;
            final ScoreColumnInfo dst = (ScoreColumnInfo) rawDst;
            dst.nameIndex = src.nameIndex;
            dst.scoreIndex = src.scoreIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(2);
        fieldNames.add("name");
        fieldNames.add("score");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ScoreColumnInfo columnInfo;
    private ProxyState<io.realm.examples.threads.model.Score> proxyState;

    ScoreRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ScoreColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<io.realm.examples.threads.model.Score>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$score() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.scoreIndex);
    }

    @Override
    public void realmSet$score(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.scoreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.scoreIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Score", 2, 0);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("score", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ScoreColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ScoreColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Score";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static io.realm.examples.threads.model.Score createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        io.realm.examples.threads.model.Score obj = realm.createObjectInternal(io.realm.examples.threads.model.Score.class, true, excludeFields);

        final ScoreRealmProxyInterface objProxy = (ScoreRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("score")) {
            if (json.isNull("score")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'score' to null.");
            } else {
                objProxy.realmSet$score((int) json.getInt("score"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static io.realm.examples.threads.model.Score createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final io.realm.examples.threads.model.Score obj = new io.realm.examples.threads.model.Score();
        final ScoreRealmProxyInterface objProxy = (ScoreRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("score")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$score((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'score' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static io.realm.examples.threads.model.Score copyOrUpdate(Realm realm, io.realm.examples.threads.model.Score object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (io.realm.examples.threads.model.Score) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static io.realm.examples.threads.model.Score copy(Realm realm, io.realm.examples.threads.model.Score newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (io.realm.examples.threads.model.Score) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        io.realm.examples.threads.model.Score realmObject = realm.createObjectInternal(io.realm.examples.threads.model.Score.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ScoreRealmProxyInterface realmObjectSource = (ScoreRealmProxyInterface) newObject;
        ScoreRealmProxyInterface realmObjectCopy = (ScoreRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$score(realmObjectSource.realmGet$score());
        return realmObject;
    }

    public static long insert(Realm realm, io.realm.examples.threads.model.Score object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.examples.threads.model.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Score.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((ScoreRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$score(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.examples.threads.model.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Score.class);
        io.realm.examples.threads.model.Score object = null;
        while (objects.hasNext()) {
            object = (io.realm.examples.threads.model.Score) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((ScoreRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$score(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, io.realm.examples.threads.model.Score object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.examples.threads.model.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Score.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((ScoreRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$score(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.examples.threads.model.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Score.class);
        io.realm.examples.threads.model.Score object = null;
        while (objects.hasNext()) {
            object = (io.realm.examples.threads.model.Score) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((ScoreRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$score(), false);
        }
    }

    public static io.realm.examples.threads.model.Score createDetachedCopy(io.realm.examples.threads.model.Score realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        io.realm.examples.threads.model.Score unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new io.realm.examples.threads.model.Score();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (io.realm.examples.threads.model.Score) cachedObject.object;
            }
            unmanagedObject = (io.realm.examples.threads.model.Score) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ScoreRealmProxyInterface unmanagedCopy = (ScoreRealmProxyInterface) unmanagedObject;
        ScoreRealmProxyInterface realmSource = (ScoreRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$score(realmSource.realmGet$score());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Score = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{score:");
        stringBuilder.append(realmGet$score());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreRealmProxy aScore = (ScoreRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aScore.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aScore.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aScore.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
