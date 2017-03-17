package com.birthdaymanager.common;

/**
 * Created by umesh.soni on 3/17/2017.
 */
public interface Constants {
    interface DATA_SOURCE_PARAMETER {
        static final int MAX_ACTIVE = 5;
        static final int INITIAL_SIZE = 5;
        static final int REMOVE_ABANDONED_TIMEOUT = 60*100;
        static final Long VALIDATION_INTERVAL = 60000L;
        static final int TIME_BETWEEN_EVICTION_RUNS_MILLIS = 60000;
        static final int MAX_WAIT = 30000;
        static final int MIN_EVICTABLE_IDLE_TIME_MILLIS = 60000;
        static final int MIN_IDLE = 60000;
    }
}
