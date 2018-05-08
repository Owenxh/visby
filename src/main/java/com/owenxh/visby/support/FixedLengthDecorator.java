package com.owenxh.visby.support;

import com.owenxh.visby.util.Assert;

import java.io.Serializable;

/**
 * 固定长度的序列号装饰器
 *
 * @author <a href="mailto:sowen1023@gmail.com">Owen.Yuan</a>
 * @since 2018/5/8
 */
public class FixedLengthDecorator implements SequenceDecorateStrategy {

    public static final Character DEFAULT_PADDING = '0';

    /**
     * 填充的字符
     */
    protected Character padding = DEFAULT_PADDING;

    /**
     * 序列号长度
     */
    protected int limitedLength;

    public FixedLengthDecorator(int seqLength) {
        this(null, seqLength);
    }

    public FixedLengthDecorator(Character padding, int limitedLength) {
        Assert.isPositive(limitedLength, "[limitedLength] must be positive");

        this.padding = forPadding(padding);
        this.limitedLength = limitedLength;
    }

    public int getLimitedLength() {
        return limitedLength;
    }

    public Character getPadding() {
        return padding;
    }

    private Character forPadding(Character padding) {
        return padding == null ? DEFAULT_PADDING : padding;
    }

    @Override
    public Serializable decorate(Serializable sequence) {
        int realLength = lengthFrom(sequence);

        if (realLength > limitedLength) {
            throw new IllegalArgumentException("[sequence] decorate failed, the length of sequence  "
                    + realLength + " is large than limited " + limitedLength);
        }

        if (realLength < limitedLength) {
            return fillPadding(sequence, limitedLength - realLength);
        }

        return sequence;
    }

    protected String fillPadding(Serializable sequence, int paddingCount) {
        StringBuilder seqBuilder = new StringBuilder();

        while (paddingCount > 0) {
            seqBuilder.append(padding);
            paddingCount--;
        }

        seqBuilder.append(sequence);

        return seqBuilder.toString();
    }

    private int lengthFrom(Serializable sequence) {
        Assert.notNull(sequence, "[sequence] must not be null");

        return String.valueOf(sequence).length();
    }
}
