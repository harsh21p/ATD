package com.atd.atdmobileapp.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO;
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO_Impl;
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO;
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO_Impl;
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO;
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ATDRoomDatabase_Impl extends ATDRoomDatabase {
  private volatile PreviousKeywordSearchDAO _previousKeywordSearchDAO;

  private volatile ConfigLocationsDAO _configLocationsDAO;

  private volatile PermissionsDAO _permissionsDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `KeywordSearch` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `keyword` TEXT NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_KeywordSearch_keyword` ON `KeywordSearch` (`keyword`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ConfigLocation` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `configuration` TEXT NOT NULL, `value` TEXT NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ConfigLocation_configuration_value` ON `ConfigLocation` (`configuration`, `value`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Permissions` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `permissionValue` TEXT, `website` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9367830d1d0c3952e1a1c7bd87d87d93')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `KeywordSearch`");
        _db.execSQL("DROP TABLE IF EXISTS `ConfigLocation`");
        _db.execSQL("DROP TABLE IF EXISTS `Permissions`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsKeywordSearch = new HashMap<String, TableInfo.Column>(2);
        _columnsKeywordSearch.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKeywordSearch.put("keyword", new TableInfo.Column("keyword", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKeywordSearch = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKeywordSearch = new HashSet<TableInfo.Index>(1);
        _indicesKeywordSearch.add(new TableInfo.Index("index_KeywordSearch_keyword", true, Arrays.asList("keyword"), Arrays.asList("ASC")));
        final TableInfo _infoKeywordSearch = new TableInfo("KeywordSearch", _columnsKeywordSearch, _foreignKeysKeywordSearch, _indicesKeywordSearch);
        final TableInfo _existingKeywordSearch = TableInfo.read(_db, "KeywordSearch");
        if (! _infoKeywordSearch.equals(_existingKeywordSearch)) {
          return new RoomOpenHelper.ValidationResult(false, "KeywordSearch(com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity).\n"
                  + " Expected:\n" + _infoKeywordSearch + "\n"
                  + " Found:\n" + _existingKeywordSearch);
        }
        final HashMap<String, TableInfo.Column> _columnsConfigLocation = new HashMap<String, TableInfo.Column>(3);
        _columnsConfigLocation.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfigLocation.put("configuration", new TableInfo.Column("configuration", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfigLocation.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConfigLocation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConfigLocation = new HashSet<TableInfo.Index>(1);
        _indicesConfigLocation.add(new TableInfo.Index("index_ConfigLocation_configuration_value", true, Arrays.asList("configuration","value"), Arrays.asList("ASC","ASC")));
        final TableInfo _infoConfigLocation = new TableInfo("ConfigLocation", _columnsConfigLocation, _foreignKeysConfigLocation, _indicesConfigLocation);
        final TableInfo _existingConfigLocation = TableInfo.read(_db, "ConfigLocation");
        if (! _infoConfigLocation.equals(_existingConfigLocation)) {
          return new RoomOpenHelper.ValidationResult(false, "ConfigLocation(com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity).\n"
                  + " Expected:\n" + _infoConfigLocation + "\n"
                  + " Found:\n" + _existingConfigLocation);
        }
        final HashMap<String, TableInfo.Column> _columnsPermissions = new HashMap<String, TableInfo.Column>(3);
        _columnsPermissions.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPermissions.put("permissionValue", new TableInfo.Column("permissionValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPermissions.put("website", new TableInfo.Column("website", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPermissions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPermissions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPermissions = new TableInfo("Permissions", _columnsPermissions, _foreignKeysPermissions, _indicesPermissions);
        final TableInfo _existingPermissions = TableInfo.read(_db, "Permissions");
        if (! _infoPermissions.equals(_existingPermissions)) {
          return new RoomOpenHelper.ValidationResult(false, "Permissions(com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity).\n"
                  + " Expected:\n" + _infoPermissions + "\n"
                  + " Found:\n" + _existingPermissions);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9367830d1d0c3952e1a1c7bd87d87d93", "164f85a78c228ec5f249ba2b7993ed0d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "KeywordSearch","ConfigLocation","Permissions");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `KeywordSearch`");
      _db.execSQL("DELETE FROM `ConfigLocation`");
      _db.execSQL("DELETE FROM `Permissions`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PreviousKeywordSearchDAO.class, PreviousKeywordSearchDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ConfigLocationsDAO.class, ConfigLocationsDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(PermissionsDAO.class, PermissionsDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public PreviousKeywordSearchDAO previousKeywordSearchDAO() {
    if (_previousKeywordSearchDAO != null) {
      return _previousKeywordSearchDAO;
    } else {
      synchronized(this) {
        if(_previousKeywordSearchDAO == null) {
          _previousKeywordSearchDAO = new PreviousKeywordSearchDAO_Impl(this);
        }
        return _previousKeywordSearchDAO;
      }
    }
  }

  @Override
  public ConfigLocationsDAO configLocationDAO() {
    if (_configLocationsDAO != null) {
      return _configLocationsDAO;
    } else {
      synchronized(this) {
        if(_configLocationsDAO == null) {
          _configLocationsDAO = new ConfigLocationsDAO_Impl(this);
        }
        return _configLocationsDAO;
      }
    }
  }

  @Override
  public PermissionsDAO permissionsDAO() {
    if (_permissionsDAO != null) {
      return _permissionsDAO;
    } else {
      synchronized(this) {
        if(_permissionsDAO == null) {
          _permissionsDAO = new PermissionsDAO_Impl(this);
        }
        return _permissionsDAO;
      }
    }
  }
}
