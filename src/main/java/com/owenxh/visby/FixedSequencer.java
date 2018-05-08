package com.owenxh.visby;

import com.owenxh.visby.util.Assert;

import java.io.Serializable;

/**
 * 固定序列号
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/7
 */
public class FixedSequencer implements Sequencer {

    protected final Serializable sequence;

    public FixedSequencer(Serializable sequence) {
        Assert.notNull(sequence, "[sequence] must not be null");

        this.sequence = sequence;
    }

    @Override
    public Serializable next() {
        return sequence;
    }

    /**
     * 固定字符序列号
     */
    public static Sequencer fixedCharSequencer(Character sequence) {
        return new FixedSequencer(sequence);
    }

    /**
     * 固定字符串序列号
     */
    public static Sequencer fixedStringSequencer(String sequence) {
        return new FixedSequencer(sequence);
    }
}
