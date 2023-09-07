package com.atd.atdmobileapp.roomdatabase.permissions;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
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
public final class PermissionsDAO_Impl implements PermissionsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PermissionEntity> __insertionAdapterOfPermissionEntity;

  private final EntityDeletionOrUpdateAdapter<PermissionEntity> __updateAdapterOfPermissionEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public PermissionsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPermissionEntity = new EntityInsertionAdapter<PermissionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Permissions` (`ID`,`permissionValue`,`website`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PermissionEntity value) {
        stmt.bindLong(1, value.getID());
        if (value.getPermissionValue() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPermissionValue());
        }
        if (value.getWebsite() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getWebsite());
        }
      }
    };
    this.__updateAdapterOfPermissionEntity = new EntityDeletionOrUpdateAdapter<PermissionEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Permissions` SET `ID` = ?,`permissionValue` = ?,`website` = ? WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PermissionEntity value) {
        stmt.bindLong(1, value.getID());
        if (value.getPermissionValue() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPermissionValue());
        }
        if (value.getWebsite() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getWebsite());
        }
        stmt.bindLong(4, value.getID());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from Permissions";
        return _query;
      }
    };
  }

  @Override
  public void Insert(final PermissionEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPermissionEntity.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final PermissionEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPermissionEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<PermissionEntity> getPermissions() {
    final String _sql = "Select * from Permissions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfPermissionValue = CursorUtil.getColumnIndexOrThrow(_cursor, "permissionValue");
      final int _cursorIndexOfWebsite = CursorUtil.getColumnIndexOrThrow(_cursor, "website");
      final List<PermissionEntity> _result = new ArrayList<PermissionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PermissionEntity _item;
        _item = new PermissionEntity();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _item.setID(_tmpID);
        final String _tmpPermissionValue;
        if (_cursor.isNull(_cursorIndexOfPermissionValue)) {
          _tmpPermissionValue = null;
        } else {
          _tmpPermissionValue = _cursor.getString(_cursorIndexOfPermissionValue);
        }
        _item.setPermissionValue(_tmpPermissionValue);
        final String _tmpWebsite;
        if (_cursor.isNull(_cursorIndexOfWebsite)) {
          _tmpWebsite = null;
        } else {
          _tmpWebsite = _cursor.getString(_cursorIndexOfWebsite);
        }
        _item.setWebsite(_tmpWebsite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getApprovePermission(final String filter, final String profileSelected,
      final Continuation<? super String> continuation) {
    final String _sql = "SELECT permissionValue FROM Permissions where permissionValue=? And website=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (filter == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, filter);
    }
    _argIndex = 2;
    if (profileSelected == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, profileSelected);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getString(0);
            }
          } else {
            _result = null;
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
