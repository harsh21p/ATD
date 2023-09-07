package com.atd.atdmobileapp.roomdatabase.configlocations;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.atd.atdmobileapp.models.locationconfig.Locationconfiguration;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ConfigLocationsDAO_Impl implements ConfigLocationsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ConfigLocationEntity> __insertionAdapterOfConfigLocationEntity;

  private final EntityDeletionOrUpdateAdapter<ConfigLocationEntity> __deletionAdapterOfConfigLocationEntity;

  private final EntityDeletionOrUpdateAdapter<ConfigLocationEntity> __updateAdapterOfConfigLocationEntity;

  public ConfigLocationsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConfigLocationEntity = new EntityInsertionAdapter<ConfigLocationEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `ConfigLocation` (`ID`,`configuration`,`value`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConfigLocationEntity value) {
        stmt.bindLong(1, value.getID());
        if (value.getConfiguration() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConfiguration());
        }
        if (value.getValue() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getValue());
        }
      }
    };
    this.__deletionAdapterOfConfigLocationEntity = new EntityDeletionOrUpdateAdapter<ConfigLocationEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ConfigLocation` WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConfigLocationEntity value) {
        stmt.bindLong(1, value.getID());
      }
    };
    this.__updateAdapterOfConfigLocationEntity = new EntityDeletionOrUpdateAdapter<ConfigLocationEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ConfigLocation` SET `ID` = ?,`configuration` = ?,`value` = ? WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConfigLocationEntity value) {
        stmt.bindLong(1, value.getID());
        if (value.getConfiguration() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConfiguration());
        }
        if (value.getValue() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getValue());
        }
        stmt.bindLong(4, value.getID());
      }
    };
  }

  @Override
  public void Insert(final ConfigLocationEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfConfigLocationEntity.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Delete(final ConfigLocationEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfConfigLocationEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final ConfigLocationEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfConfigLocationEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ConfigLocationEntity> getConfigLocationList() {
    final String _sql = "Select * from configlocation";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfConfiguration = CursorUtil.getColumnIndexOrThrow(_cursor, "configuration");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final List<ConfigLocationEntity> _result = new ArrayList<ConfigLocationEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ConfigLocationEntity _item;
        _item = new ConfigLocationEntity();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _item.setID(_tmpID);
        final String _tmpConfiguration;
        if (_cursor.isNull(_cursorIndexOfConfiguration)) {
          _tmpConfiguration = null;
        } else {
          _tmpConfiguration = _cursor.getString(_cursorIndexOfConfiguration);
        }
        _item.setConfiguration(_tmpConfiguration);
        final String _tmpValue;
        if (_cursor.isNull(_cursorIndexOfValue)) {
          _tmpValue = null;
        } else {
          _tmpValue = _cursor.getString(_cursorIndexOfValue);
        }
        _item.setValue(_tmpValue);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getPreferredBrandConfigurationList(
      final Continuation<? super List<Locationconfiguration>> continuation) {
    final String _sql = "SELECT * FROM configlocation where configuration ='PREFERRED_BRAND'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Locationconfiguration>>() {
      @Override
      public List<Locationconfiguration> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfConfiguration = CursorUtil.getColumnIndexOrThrow(_cursor, "configuration");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final List<Locationconfiguration> _result = new ArrayList<Locationconfiguration>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Locationconfiguration _item;
            final String _tmpConfiguration;
            if (_cursor.isNull(_cursorIndexOfConfiguration)) {
              _tmpConfiguration = null;
            } else {
              _tmpConfiguration = _cursor.getString(_cursorIndexOfConfiguration);
            }
            final String _tmpValue;
            if (_cursor.isNull(_cursorIndexOfValue)) {
              _tmpValue = null;
            } else {
              _tmpValue = _cursor.getString(_cursorIndexOfValue);
            }
            _item = new Locationconfiguration(_tmpConfiguration,_tmpValue);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
