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
public class DotRealmProxy extends io.realm.examples.threads.model.Dot
    implements RealmObjectProxy, DotRealmProxyInterface {

    static final class DotColumnInfo extends ColumnInfo {
        long xIndex;
        long yIndex;
        long colorIndex;
        long timestampIndex;

        DotColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Dot");
            this.xIndex = addColumnDetails("x", objectSchemaInfo);
            this.yIndex = addColumnDetails("y", objectSchemaInfo);
            this.colorIndex = addColumnDetails("color", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", objectSchemaInfo);
        }

        DotColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DotColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DotColumnInfo src = (DotColumnInfo) rawSrc;
            final DotColumnInfo dst = (DotColumnInfo) rawDst;
            dst.xIndex = src.xIndex;
            dst.yIndex = src.yIndex;
            dst.colorIndex = src.colorIndex;
            dst.timestampIndex = src.timestampIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(4);
        fieldNames.add("x");
        fieldNames.add("y");
        fieldNames.add("color");
        fieldNames.add("timestamp");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private DotColumnInfo columnInfo;
    private ProxyState<io.realm.examples.threads.model.Dot> proxyState;

    DotRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DotColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<io.realm.examples.threads.model.Dot>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$x() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.xIndex);
    }

    @Override
    public void realmSet$x(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.xIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.xIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$y() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.yIndex);
    }

    @Override
    public void realmSet$y(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.yIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.yIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$color() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.colorIndex);
    }

    @Override
    public void realmSet$color(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.colorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.colorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$timestamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timestampIndex);
    }

    @Override
    public void realmSet$timestamp(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timestampIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Dot", 4, 0);
        builder.addPersistedProperty("x", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("y", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("color", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DotColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DotColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Dot";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static io.realm.examples.threads.model.Dot createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        io.realm.examples.threads.model.Dot obj = realm.createObjectInternal(io.realm.examples.threads.model.Dot.class, true, excludeFields);

        final DotRealmProxyInterface objProxy = (DotRealmProxyInterface) obj;
        if (json.has("x")) {
            if (json.isNull("x")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'x' to null.");
            } else {
                objProxy.realmSet$x((int) json.getInt("x"));
            }
        }
        if (json.has("y")) {
            if (json.isNull("y")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'y' to null.");
            } else {
                objProxy.realmSet$y((int) json.getInt("y"));
            }
        }
        if (json.has("color")) {
            if (json.isNull("color")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'color' to null.");
            } else {
                objProxy.realmSet$color((int) json.getInt("color"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
            } else {
                objProxy.realmSet$timestamp((long) json.getLong("timestamp"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static io.realm.examples.threads.model.Dot createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final io.realm.examples.threads.model.Dot obj = new io.realm.examples.threads.model.Dot();
        final DotRealmProxyInterface objProxy = (DotRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("x")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$x((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'x' to null.");
                }
            } else if (name.equals("y")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$y((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'y' to null.");
                }
            } else if (name.equals("color")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$color((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'color' to null.");
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timestamp((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static io.realm.examples.threads.model.Dot copyOrUpdate(Realm realm, io.realm.examples.threads.model.Dot object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (io.realm.examples.threads.model.Dot) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static io.realm.examples.threads.model.Dot copy(Realm realm, io.realm.examples.threads.model.Dot newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (io.realm.examples.threads.model.Dot) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        io.realm.examples.threads.model.Dot realmObject = realm.createObjectInternal(io.realm.examples.threads.model.Dot.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        DotRealmProxyInterface realmObjectSource = (DotRealmProxyInterface) newObject;
        DotRealmProxyInterface realmObjectCopy = (DotRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$x(realmObjectSource.realmGet$x());
        realmObjectCopy.realmSet$y(realmObjectSource.realmGet$y());
        realmObjectCopy.realmSet$color(realmObjectSource.realmGet$color());
        realmObjectCopy.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        return realmObject;
    }

    public static long insert(Realm realm, io.realm.examples.threads.model.Dot object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.examples.threads.model.Dot.class);
        long tableNativePtr = table.getNativePtr();
        DotColumnInfo columnInfo = (DotColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Dot.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.xIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$x(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.yIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$y(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.colorIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$color(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$timestamp(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.examples.threads.model.Dot.class);
        long tableNativePtr = table.getNativePtr();
        DotColumnInfo columnInfo = (DotColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Dot.class);
        io.realm.examples.threads.model.Dot object = null;
        while (objects.hasNext()) {
            object = (io.realm.examples.threads.model.Dot) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.xIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$x(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.yIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$y(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.colorIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$color(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$timestamp(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, io.realm.examples.threads.model.Dot object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.examples.threads.model.Dot.class);
        long tableNativePtr = table.getNativePtr();
        DotColumnInfo columnInfo = (DotColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Dot.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.xIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$x(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.yIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$y(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.colorIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$color(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$timestamp(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.examples.threads.model.Dot.class);
        long tableNativePtr = table.getNativePtr();
        DotColumnInfo columnInfo = (DotColumnInfo) realm.getSchema().getColumnInfo(io.realm.examples.threads.model.Dot.class);
        io.realm.examples.threads.model.Dot object = null;
        while (objects.hasNext()) {
            object = (io.realm.examples.threads.model.Dot) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.xIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$x(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.yIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$y(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.colorIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$color(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((DotRealmProxyInterface) object).realmGet$timestamp(), false);
        }
    }

    public static io.realm.examples.threads.model.Dot createDetachedCopy(io.realm.examples.threads.model.Dot realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        io.realm.examples.threads.model.Dot unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new io.realm.examples.threads.model.Dot();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (io.realm.examples.threads.model.Dot) cachedObject.object;
            }
            unmanagedObject = (io.realm.examples.threads.model.Dot) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        DotRealmProxyInterface unmanagedCopy = (DotRealmProxyInterface) unmanagedObject;
        DotRealmProxyInterface realmSource = (DotRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$x(realmSource.realmGet$x());
        unmanagedCopy.realmSet$y(realmSource.realmGet$y());
        unmanagedCopy.realmSet$color(realmSource.realmGet$color());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Dot = proxy[");
        stringBuilder.append("{x:");
        stringBuilder.append(realmGet$x());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{y:");
        stringBuilder.append(realmGet$y());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{color:");
        stringBuilder.append(realmGet$color());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp());
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
        DotRealmProxy aDot = (DotRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDot.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDot.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDot.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
