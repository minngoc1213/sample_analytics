package com.example.sample_analytics.common.constant;

public class APIConstant {
    private APIConstant() {
        throw new IllegalStateException("Constant class");
    }

    public static final class ResponseStructure {
        private ResponseStructure() {
            throw new IllegalStateException("Constant class");
        }

        public static final String KEY_CODE = "code";

        public static final String KEY_MESSAGE = "message";

        public static final String KEY_DATA = "data";

        public static final String KEY_METADATA = "metadata";
    }
}
