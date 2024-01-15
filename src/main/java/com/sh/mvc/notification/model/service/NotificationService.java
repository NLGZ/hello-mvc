package com.sh.mvc.notification.model.service;

import com.sh.mvc.notification.model.dao.NotificationDao;
import com.sh.mvc.notification.model.entity.Notification;
import org.apache.ibatis.session.SqlSession;

import static com.sh.mvc.common.SqlSessionTemplate.getSqlSession;

public class NotificationService {
    private NotificationDao notificationDao = new NotificationDao();

    public int insertNotification(Notification noti) {
        SqlSession session = getSqlSession();
        int result = 0;
        try {
            result = notificationDao.insertNotification(session, noti);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
}
