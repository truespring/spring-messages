package com.truespring.messages.app.domain.repository;

import com.truespring.messages.app.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageRepository {

    private final SessionFactory sessionFactory;

    public MessageRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Message saveMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
        return message;
    }

//    private final DataSource dataSource;
//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//    }
//
//    public MessageRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    // 스프링 JDBC를 사용한 메소드
//    public Message saveMessage(Message message) {
//        GeneratedKeyHolder holder = new GeneratedKeyHolder();
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("text", message.getText());
//        params.addValue("createdDate", message.getCreatedDate());
//        String insertSQL = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, :text, :createdDate)";
//        try {
//            this.jdbcTemplate.update(insertSQL, params, holder);
//        } catch (DataAccessException e) {
//            log.error("Failed to save message", e);
//            return null;
//        }
//        return new Message(Objects.requireNonNull(holder.getKey()).intValue(), message.getText(), message.getCreatedDate());
//    }

    // JDBC API를 직접 사용해 상호작용한 메소드
//    public Message saveMessage(Message message) {
//        Connection c = DataSourceUtils.getConnection(dataSource);
//        try {
//            String insertSql = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, ?, ?)";
//            PreparedStatement ps = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
//            // SQL 에 필요한 매개변수를 준비한다.
//            ps.setString(1, message.getText());
//            ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));
//            int rowsAffected = ps.executeUpdate();
//            if (rowsAffected > 0) {
//                // 새로 저장된 메시지 가져오기
//                ResultSet result = ps.getGeneratedKeys();
//                if (result.next()) {
//                    int id = result.getInt(1);
//                    return new Message(id, message.getText(), message.getCreatedDate());
//                } else {
//                    log.error(">> Failed to retrieve id. No row in result set");
//                    return null;
//                }
//            } else {
//                // Insert 실패
//                return null;
//            }
//        } catch (SQLException ex) {
//            log.error(">> Failed to save message ", ex);
//            try {
//                c.close();
//            } catch (SQLException e) {
//                log.error(">> Failed to close connection ", e);
//            }
//        } finally {
//            DataSourceUtils.releaseConnection(c, dataSource);
//        }
//        return null;
//    }
}
