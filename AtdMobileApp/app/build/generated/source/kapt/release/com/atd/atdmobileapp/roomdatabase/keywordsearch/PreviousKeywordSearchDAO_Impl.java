package com.atd.atdmobileapp.roomdatabase.keywordsearch;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PreviousKeywordSearchDAO_Impl implements PreviousKeywordSearchDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PreviousKeywordSearchEntity> __insertionAdapterOfPreviousKeywordSearchEntity;

  private final EntityDeletionOrUpdateAdapter<PreviousKeywordSearchEntity> __deletionAdapterOfPreviousKeywordSearchEntity;

  private final EntityDeletionOrUpdateAdapter<PreviousKeywordSearchEntity> __updateAdapterOfPreviousKeywordSearchEntity;

  public PreviousKeywordSearchDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPreviousKeywordSearchEntity = new EntityInsertionAdapter<PreviousKeywordSearchEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `KeywordSearch` (`ID`,`keyword`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PreviousKeywordSearchEntity value) {
        stmt.bindLong(1, value.getID());
        if (value.getKeyword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyword());
        }
      }
    };
    this.__deletionAdapterOfPreviousKeywordSearchEntity = new EntityDeletionOrUpdateAdapter<PreviousKeywordSearchEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `KeywordSearch` WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PreviousKeywordSearchEntity value) {
        stmt.bindLong(1, value.getID());
      }
    };
    this.__updateAdapterOfPreviousKeywordSearchEntity = new EntityDeletionOrUpdateAdapter<PreviousKeywordSearchEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `KeywordSearch` SET `ID` = ?,`keyword` = ? WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PreviousKeywordSearchEntity value) {
        stmt.bindLong(1, value.getID());
        if (value.getKeyword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyword());
        }
        stmt.bindLong(3, value.getID());
      }
    };
  }

  @Override
  public void Insert(final PreviousKeywordSearchEntity previousKeywordSearchEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPreviousKeywordSearchEntity.insert(previousKeywordSearchEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Delete(final PreviousKeywordSearchEntity previousKeywordSearchEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPreviousKeywordSearchEntity.handle(previousKeywordSearchEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final PreviousKeywordSearchEntity previousKeywordSearchEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPreviousKeywordSearchEntity.handle(previousKeywordSearchEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PreviousKeywordSearchEntity> getKeyWordList() {
    final String _sql = "Select * from KeywordSearch order By ID DESC LIMIT 10 OFFSET 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfKeyword = CursorUtil.getColumnIndexOrThrow(_cursor, "keyword");
      final List<PreviousKeywordSearchEntity> _result = new ArrayList<PreviousKeywordSearchEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PreviousKeywordSearchEntity _item;
        _item = new PreviousKeywordSearchEntity();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _item.setID(_tmpID);
        final String _tmpKeyword;
        if (_cursor.isNull(_cursorIndexOfKeyword)) {
          _tmpKeyword = null;
        } else {
          _tmpKeyword = _cursor.getString(_cursorIndexOfKeyword);
        }
        _item.setKeyword(_tmpKeyword);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
