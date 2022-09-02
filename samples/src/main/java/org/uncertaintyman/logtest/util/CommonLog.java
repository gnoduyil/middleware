package org.uncertaintyman.logtest.util;

public class CommonLog {

    private String traceId;

    private String sessionId;

    private String userId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    @Override
    public String toString() {
        return String.format("traceId:%s sessionId:$s userId$s", this.traceId, this.sessionId, this.userId);
    }

    public static final class CommonLogBuilder {
        private String traceId;
        private String sessionId;
        private String userId;

        private CommonLogBuilder() {
        }

        public static CommonLogBuilder aCommonLog() {
            return new CommonLogBuilder();
        }

        public CommonLogBuilder withTraceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public CommonLogBuilder withSessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public CommonLogBuilder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public CommonLog build() {
            CommonLog commonLog = new CommonLog();
            commonLog.setTraceId(traceId);
            commonLog.setSessionId(sessionId);
            commonLog.setUserId(userId);
            return commonLog;
        }
    }
}
