package com.example.newsapp.architecture;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.newsapp.NewsModel;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsDao_Impl implements NewsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NewsModel> __insertionAdapterOfNewsModel;

  private final EntityDeletionOrUpdateAdapter<NewsModel> __deletionAdapterOfNewsModel;

  public NewsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNewsModel = new EntityInsertionAdapter<NewsModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `News_Table` (`headline`,`imgurl`,`description`,`url`,`source`,`time`,`content`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NewsModel value) {
        if (value.getHeadLine() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getHeadLine());
        }
        if (value.getImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImage());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUrl());
        }
        if (value.getSource() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSource());
        }
        if (value.getTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTime());
        }
        if (value.getContent() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContent());
        }
      }
    };
    this.__deletionAdapterOfNewsModel = new EntityDeletionOrUpdateAdapter<NewsModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `News_Table` WHERE `headline` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NewsModel value) {
        if (value.getHeadLine() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getHeadLine());
        }
      }
    };
  }

  @Override
  public void insertNews(final NewsModel news) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNewsModel.insert(news);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteNews(final NewsModel news) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNewsModel.handle(news);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<NewsModel>> getNewsFromDatabase() {
    final String _sql = "SELECT * FROM News_Table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"News_Table"}, false, new Callable<List<NewsModel>>() {
      @Override
      public List<NewsModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHeadLine = CursorUtil.getColumnIndexOrThrow(_cursor, "headline");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "imgurl");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final List<NewsModel> _result = new ArrayList<NewsModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final NewsModel _item;
            final String _tmpHeadLine;
            if (_cursor.isNull(_cursorIndexOfHeadLine)) {
              _tmpHeadLine = null;
            } else {
              _tmpHeadLine = _cursor.getString(_cursorIndexOfHeadLine);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            _item = new NewsModel(_tmpHeadLine,_tmpImage,_tmpDescription,_tmpUrl,_tmpSource,_tmpTime,_tmpContent);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
