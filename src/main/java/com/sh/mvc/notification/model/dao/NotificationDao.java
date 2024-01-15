package com.sh.mvc.notification.model.dao;

import com.sh.mvc.notification.model.entity.Notification;
import org.apache.ibatis.session.SqlSession;

public class NotificationDao {
    public int insertNotification(SqlSession session, Notification noti) {
        return session.insert("noti.insertNotification", noti);
    }
}
