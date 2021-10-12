package com.truespring.messages.app.domain.repository;

import com.truespring.messages.app.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Slf4j
@Component
public class MessageRepository {

    private final DataSource dataSource;

    public MessageRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Message saveMessage(Message message) {
        Connection c = DataSourceUtils.getConnection(dataSource);
        try {
            String insertSql = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, ?, ?)";
            PreparedStatement ps = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            // SQL 에 필요한 매개변수를 준비한다.
            ps.setString(1, message.getText());
            ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // 새로 저장된 메시지 가져오기
                ResultSet result = ps.getGeneratedKeys();
                if (result.next()) {
                    int id = result.getInt(1);
                    return new Message(id, message.getText(), message.getCreatedDate());
                } else {
                    log.error(">> Failed to retrieve id. No row in result set");
                    return null;
                }
            } else {
                // Insert 실패
                return null;
            }
        } catch (SQLException ex) {
            log.error(">> Failed to save message ", ex);
            try {
                c.close();
            } catch (SQLException e) {
                log.error(">> Failed to close connection ", e);
            }
        } finally {
            DataSourceUtils.releaseConnection(c, dataSource);
        }
        return null;
    }
}
