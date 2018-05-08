package com.owenxh.visby;

import com.owenxh.visby.util.Assert;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期序列号生成器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class DateSequencer implements Sequencer {

    private String pattern = DEFAULT_PATTERN;

    public static final String DEFAULT_PATTERN = "yyyyMMdd";

    public DateSequencer() {}

    public DateSequencer(String pattern) {
        Assert.hasLength(pattern, "[pattern] must not be empty");

        this.pattern = pattern;
    }

    @Override
    public Serializable next() {
        return new SimpleDateFormat(pattern).format(new Date());
    }
}
